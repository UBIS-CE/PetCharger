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

    public static void main(String[] args) throws Exception {
        String filepath = "C:\\fisa_miniproject\\PetCharger\\step04_miniProject\\docs\\";
        
        // 추가 부분 - 웅빈
        // 동물PK
        int animalPK = 31;
        // 진료기록 PK
        int medicalRecordPK = 101;
        
        // 초기 Animal들의 정보가 저장돼있는 ArrayList
        ArrayList<Animal> animalList = readAnimalDataFromFile(filepath + "animal.txt");
        ArrayList<Disease> diseaseList = makeDiseaseList();
        ArrayList<MedicalRecord> medicalRecordList = readMedicalRecordFromFile(filepath + "medicalRecord.txt", diseaseList);

        PetChargerController controller = PetChargerController.getInstance();

        for (Animal animal : animalList) {
            controller.animalInsert(animal);
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

//        
//        System.out.println("===============================================");
//        System.out.println("1. 리셉션");
//        System.out.println("2. 수의사");
//        
//        System.out.println("===============================================");
//
//        int num = sc.nextInt();
        Scanner sc = new Scanner(System.in);
        boolean auto = true;
        while(auto) {
            System.out.println("===============================================");
            System.out.println("1. 리셉션");
            System.out.println("2. 수의사");
            
            System.out.println("===============================================");
           
            int num = sc.nextInt();
        	switch(num) {
        	
            case 1:
            	System.out.println("----------------------------------");
            	System.out.println("1. 조회 - 초진 X");
                System.out.println("2. 초진");
                System.out.println("----------------------------------");
                int num1 = sc.nextInt();
             // 처음 방문
                if(num1 == 1) {
                	System.out.println("조회하려는 동물의 이름을 입력해주세요.");
                	String petName = sc.next();
                	controller.getAnimalList(petName);
                	
                	System.out.println("동물ID를 입력해주세요.");
                	int petId = sc.nextInt();
                	controller.getAnimalInfo(petId);
                	
                	System.out.println("진료기록을 보시겠습니까?");
                	System.out.println("1. 예  2. 아니오");
                	int choice = sc.nextInt();
                	if(choice == 1) {
                		controller.getMedicalRecordList(petId);
                	}
                	else if (choice == 2) {
                		break;
                	}
                	break;
                		
                }
                else if (num1 == 2) {
                	System.out.println("---------------------------------------");
                	System.out.println("              손님 정보 입력                ");
                	System.out.println("---------------------------------------");
                	System.out.println("반려동물 이름.");
                	String petName = sc.next();
                	
                	System.out.println("보호자 성함.");
                	String ownerName = sc.next();
                	
                	System.out.println("동물 종");
                	String animalType = sc.next();
                	
                	System.out.println("충전 금액");
                	int charge = sc.nextInt();
                	
                	System.out.println("반려동물 성별 (F/M)");
                	String gender = sc.next();
                	
                	animalPK++;
                	
                    Animal an = new Animal(animalPK, petName,ownerName,animalType, charge, gender);
                    controller.animalInsert(an);
                    System.out.println("새로운 동물이 등록되었습니다: " + an);
                    break;
                }
                // 이전에 방문한 적이 있음
                
                else {
                    System.out.println("잘못된 입력입니다. 프로그램을 재실행 해주세요.");
                    return;
                }
                
            
            // 수의사 부분
            case 2:
            	System.out.println("1. 진료          2. 환자정보 삭제");
            	int num2 = sc.nextInt();
            	if(num2==1) {
            		System.out.println("===========================================");
                	System.out.println("진료하시는 동물의 이름을 입력해주세요");
                    String petName = sc.next();
                    controller.getAnimalList(petName);
                    
                    System.out.println("해당하는 동물 PK를 입력해주세요");
                    int petId = sc.nextInt();
                    
                    System.out.println("===============================================");
                    System.out.println("          진료기록 조회 결과입니다.          ");
                    System.out.println("===============================================");
                    controller.getMedicalRecordList(petId);
                    
                    
                    System.out.println("===============================================");
                    System.out.println("                진료 중입니다...                ");
                    System.out.println("===============================================");
                    System.out.println("질병명을 입력해주세요:");
                    String diseaseName = sc.next();

                    
                    
                    System.out.println("===============================================");
                    System.out.println("        환자 진료기록을 생성하고 있습니다...        ");
                    System.out.println("===============================================");
                    
                    //TODO 동물 진료기록 Update  --> 새로운 medicalRecord Insert
                    medicalRecordPK++;
                    // updateDate, DoctorName 임시 설정
                    String updateDate = "20240713";
                    String doctorName = "김사부";
                    
                    
                    controller.medicalRecordInsert2(medicalRecordPK, diseaseName, petId, updateDate, doctorName);
                    break;
            	}
            	else if (num2==2) {
            		System.out.println("===========================================");
                	System.out.println("삭제하시려는 환자정보의 동물 이름을 입력해주세요");
                    String petName = sc.next();
                    controller.getAnimalList(petName);
                    
                    System.out.println("해당하는 동물 PK를 입력해주세요");
                    int petId = sc.nextInt();
                    
                    
                    System.out.println("===============================================");
                    System.out.println("     환자 진료기록 및 동물 정보를 삭제하고 있습니다...     ");
                    System.out.println("===============================================");
                    controller.animalAndMedicalRecordDelete(petId);
                    break;
            	}
            default:
    	        System.out.println("===============================================");
    	        System.out.println("            작업이 완료되었습니다. 감사합니다!             ");
    	        System.out.println("===============================================");
    	        auto = false;
            }
        }sc.close();
        

//        System.out.println("===============================================");
//        System.out.println("                진료 중입니다...                ");
//        System.out.println("===============================================");
//        System.out.println("질병명을 입력해주세요:");
//        String diseaseName = sc.next();
//
//        System.out.println("===============================================");
//        System.out.println("        환자 진료기록을 생성하고 있습니다...        ");
//        System.out.println("===============================================");
//        System.out.println("애완동물 이름을 입력해주세요:");
//        String name = sc.next();
//        // 수정 부분 - 웅빈
//        // ArrayList<Animal> AnimalArrayList = controller.getAnimalList(name);
//        controller.getAnimalList(name);
//        
//        System.out.println("해당하는 동물 PK를 입력해주세요");
//        int petId = sc.nextInt();
//        
//
//        
//        System.out.println("===============================================");
//        System.out.println("          진료기록 조회 결과입니다.          ");
//        System.out.println("===============================================");
//        // 수정 부분 - 웅빈
//        // controller.getMedicalRecordList(AnimalArrayList.get(0).getPetId());
//        controller.getMedicalRecordList(petId);
//
//        System.out.println("===============================================");
//        System.out.println("        병명 및 가격 정보를 생성하고 있습니다...        ");
//        System.out.println("===============================================");
//        System.out.println("병명을 입력해주세요:");
//        String disease = sc.next();
//        // 수정 부분 - 웅빈
//        // controller.getAnimalInfo(petId);
////        Animal animal = controller.getAnimalInfo(AnimalArrayList.get(0).getPetId());
//       
//        // 금액 조회 기능과 금액 수정 기능이 필요함 - 웅빈
//        System.out.println("수정 전 충전금액: " + controller.getDisease2(null, diseaseName)
//        Animal updatedAnimal = controller.getDisease(animal, disease);
//        System.out.println("수정 후 충전금액: " + updatedAnimal.getChargeAmount());
        
//        System.out.println("===============================================");
//        System.out.println("     환자 진료기록 및 동물 정보를 삭제하고 있습니다...     ");
//        System.out.println("===============================================");
//        controller.animalAndMedicalRecordDelete(animal.getPetId());

        
    }

    /** Disease 정보 생성 */
    public static ArrayList<Disease> makeDiseaseList() {
        Disease d1 = new Disease(1, "leg", 20000);
        Disease d2 = new Disease(2, "Eye", 65000);
        Disease d3 = new Disease(3, "Heart", 70000);
        Disease d4 = new Disease(4, "Head", 60000);
        Disease d5 = new Disease(5, "Skin", 20000);
        Disease d6 = new Disease(6, "Ear", 25000);

        ArrayList<Disease> diseaseList = new ArrayList<>();
        diseaseList.add(d1);
        diseaseList.add(d2);
        diseaseList.add(d3);
        diseaseList.add(d4);
        diseaseList.add(d5);
        diseaseList.add(d6);

        return diseaseList;
    }

    /** animalData.txt 파일에서 데이터들을 읽어들여 데이터 생성 */
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

                /** 동물 정보 - pk, 동물이름, 보호자명, 동물종류, 충전금액, 성별 */
                Animal animal = new Animal(pk, name, guardianName, animalType, charge, sex);
                animalList.add(animal);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return animalList;
    }

    /** medicalRecord.txt 파일에서 데이터를 읽어들여 데이터 생성 */
    public static ArrayList<MedicalRecord> readMedicalRecordFromFile(String filePath, ArrayList<Disease> diseaseList) {
        ArrayList<MedicalRecord> medicalRecordList = new ArrayList<>();
        Random random = new Random();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(" ");

                int pk = Integer.parseInt(data[0]);
                Disease disease = diseaseList.get(random.nextInt(diseaseList.size()));
                int animalPK = Integer.parseInt(data[1]);
                String updateDate = data[2];
                int totalFee = Integer.parseInt(data[3]);
                String doctorName = data[4];

                /** 진료기록 정보 - pk, 질병, 동물PK, 갱신일, 총비용, 의사명 */
                MedicalRecord medicalRecord = new MedicalRecord(pk, disease, animalPK, updateDate, totalFee, doctorName);
                medicalRecordList.add(medicalRecord);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return medicalRecordList;
    }
}
