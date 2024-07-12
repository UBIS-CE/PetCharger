package ubis.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import ubis.controller.PetChargerController;
import ubis.model.dto.Animal;
import ubis.model.dto.Disease;
import ubis.model.dto.MedicalRecord;

public class StartView {

	public static void main(String[] args) {
		String filepath = "C:/fisa_miniproject/PetCharger/step04_miniProject/docs/";
		/**초기 Animal들의 정보가 저장돼있는 ArrayList*/
		ArrayList<Animal> animalList = readAnimalDataFromFile(filepath+"animal.txt");
		ArrayList<Disease> diseaseList = makeDiseaseList();
		ArrayList<MedicalRecord> medicalRecordList = readMedicalRecordFromFile(filepath+"medicalRecord.txt", diseaseList);
		
		PetChargerController controller = PetChargerController.getInstance();
		
		System.out.println("01. 환자정보 생성");
		for(Animal animal : animalList) {
			controller.animalInsert(animal);
		}
		
		System.out.println("02. 환자정보 검색");
		controller.getAnimalList(petname);
		
		System.out.println("03. 환자 진료기록 생성");
		for(MedicalRecord medicalRecord : medicalRecordList) {
			controller.medicalRecordInsert(medicalRecord);
		}
		
		System.out.println("04. 환자 진료기록 검색 ");
		controller.getMedicalRecordList(0);
		
		System.out.println("05. 병명 및 가격 생성");
		for(Disease disease : diseaseList) {
			controller.diseaseInsert(disease);
		}
		
		
		System.out.println("0x. 환자 진료기록 및 동물 정보 삭제");
		controller.animalAndMedicalRecordDelete(0);
		
		

	}
	/** Disease 정보 생성*/
	public static ArrayList<Disease> makeDiseaseList(){
		Disease d1 = new Disease(1,"Leg", 20000);
		Disease d2 = new Disease(2,"Eye", 65000);
		Disease d3 = new Disease(3,"Heart", 70000);
		Disease d4 = new Disease(4,"Head", 60000);
		Disease d5 = new Disease(5,"Skin", 20000);
		Disease d6 = new Disease(6,"Ear", 25000);
		
		ArrayList<Disease> diseaseList = new ArrayList<>();
		diseaseList.add(d1);
		diseaseList.add(d2);
		diseaseList.add(d3);
		diseaseList.add(d4);
		diseaseList.add(d5);
		diseaseList.add(d6);
		
		return diseaseList;
	}
	
	
	/**animalData.txt 파일에서 데이터들을 읽어들여 데이터 생성.*/

	 public static ArrayList<Animal> readAnimalDataFromFile(String filePath) {
	        ArrayList<Animal> animalList = new ArrayList<>();

	        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                String[] data = line.split(" ");
	                
	                Integer pk = Integer.parseInt(data[0]);
	                String name = data[1];
	                String guardianName = data[2];
	                String animalType = data[3];
	                int charge = Integer.parseInt(data[4]);
	                char sex = data[5].charAt(0);
	                
	                /** 동물 정보 - pk, 동물이름, 보호자명, 동물종류, 충전금액, 성별*/
	                Animal animal = new Animal(pk, name, guardianName, animalType, charge, sex);
	                animalList.add(animal);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return animalList;
	    }
	 
	 
	 /**medicalRecod.txt 파일에서 데이터를 읽어들여 데이터 생성.*/
	 public static ArrayList<MedicalRecord> readMedicalRecordFromFile(String filePath, ArrayList<Disease> diseaseList) {
	        ArrayList<MedicalRecord> medicalRecordList = new ArrayList<>();
	        Random random = new Random();
	        
	        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                String[] data = line.split(" ");
	                
	                int pk = Integer.parseInt(data[0]);
	                Disease disease = diseaseList.get(random.nextInt(6));
	                int animalPK = Integer.parseInt(data[1]);
	                String updateDate = data[2];
	                int totalFee = Integer.parseInt(data[3]);
	                String doctorName = data[4];
	                
	                /** 동물 정보 - pk, 동물이름, 보호자명, 동물종류, 충전금액, 성별*/
	                MedicalRecord medicalRecord = new MedicalRecord(pk, disease, animalPK, updateDate, totalFee,doctorName);
	                medicalRecordList.add(medicalRecord);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return medicalRecordList;
	    }
	 
	
}

