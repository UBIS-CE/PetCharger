package ubis.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import ubis.controller.PetChargerController;
import ubis.model.dto.Animal;
import ubis.model.dto.Disease;
import ubis.model.dto.MedicalRecord;

public class StartView {

    public static void main(String[] args) {
        String filepath = "C:\\teamProject\\PetCharger\\step04_miniProject\\docs\\";

        // 초기 Animal들의 정보가 저장돼있는 ArrayList
        ArrayList<Animal> animalList = readAnimalDataFromFile(filepath + "animal.txt");
        ArrayList<Disease> diseaseList = makeDiseaseList();
        ArrayList<MedicalRecord> medicalRecordList = readMedicalRecordFromFile(filepath + "medicalRecord.txt", diseaseList);

        PetChargerController controller = PetChargerController.getInstance();
        for (Animal animal : animalList) {
            controller.animalInsert(animal);
            System.out.println("an:" + animal);
        }
        for (Disease disease : diseaseList) {
            controller.diseaseInsert(disease);
        }
        for (MedicalRecord medicalRecord : medicalRecordList) {
            controller.medicalRecordInsert(medicalRecord);
        }
        System.out.println("===============================================");
        System.out.println("     UBIS 동물병원에 오신 것을 환영합니다!     ");
        System.out.println("===============================================");
        System.out.println("처음 방문하셨나요?");
        System.out.println("1. 처음 방문");
        System.out.println("2. 이전에 방문한 적이 있음");

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        // 처음 방문 
        if (num == 1) {
          
            Animal an = new Animal(100, "웅이", "박웅빈", "HEDGEHOG", 200000,"M");
            controller.animalInsert(an);
            System.out.println(an); // 출력
        }
        // 이전에 방문한 적이 있음
        else if (num == 2) {
            System.out.println("반갑습니다! 보호자 이름을 입력해주세요:");
            String ownerName = sc.next();
            controller.getAnimalList(ownerName);
        } else {
            System.out.println("잘못된 입력입니다. 프로그램을 재실행 해주세요.");
            return;
        }

        System.out.println("===============================================");
        System.out.println("                진료 중입니다...                ");
        System.out.println("===============================================");
        System.out.println("질병명을 입력해주세요:");
        String diseaseName = sc.next();

        System.out.println("===============================================");
        System.out.println("        환자 진료기록을 생성하고 있습니다...        ");
        System.out.println("===============================================");
        


        System.out.println("===============================================");
        System.out.println("    환자 진료기록을 검색합니다: 애완동물 이름을 입력해주세요.");
        System.out.println("===============================================");
        String name = sc.next();
        controller.getAnimalList(name);

        System.out.println("===============================================");
        System.out.println("          해피의 진료기록 조회 결과입니다.          ");
        System.out.println("===============================================");
        controller.getMedicalRecordList(22);

        System.out.println("===============================================");
        System.out.println("        병명 및 가격 정보를 생성하고 있습니다...        ");
        System.out.println("===============================================");
        
        System.out.println("병명을 입력해주세요:");
        String disease = sc.next();

        Animal animal = controller.getAnimalInfo(22);
        controller.getDisease(animal, disease);

        System.out.println("===============================================");
        System.out.println("     환자 진료기록 및 동물 정보를 삭제하고 있습니다...     ");
        System.out.println("===============================================");
        controller.animalAndMedicalRecordDelete(animal.getPetId());

        System.out.println("===============================================");
        System.out.println("            작업이 완료되었습니다. 감사합니다!             ");
        System.out.println("===============================================");
    }
    
	/** Disease 정보 생성*/
	public static ArrayList<Disease> makeDiseaseList(){
		Disease d1 = new Disease(1,"leg", 20000);
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
	                String sex = data[5];
	                
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

