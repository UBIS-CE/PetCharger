package ubis.service;

import java.util.ArrayList;
import java.util.Scanner;

import ubis.model.dto.Animal;
import ubis.model.dto.Disease;
import ubis.model.dto.MedicalRecord;

public class PetChargerService {

    // Singleton design pattern
    private static PetChargerService instance = new PetChargerService();

    /** 동물 정보를 저장하는 리스트 */
    private ArrayList<Animal> animalList = new ArrayList<>();

    /** 진료기록을 저장하는 리스트 */
    private ArrayList<MedicalRecord> medicalRecordList = new ArrayList<>();

    /** 질병정보를 저장하는 리스트 */
    private ArrayList<Disease> diseaseList = new ArrayList<>();

    private PetChargerService() {}

    public static PetChargerService getInstance() {
        return instance;
    }

    /**
     * 동물 정보를 삽입
     * @param animal 동물 객체
     * @throws Exception 이미 존재하는 animal ID일 경우 예외 발생
     */
    public void animalInsert(Animal animal) throws Exception {
        Animal a = getAnimal(animal.getPetId());
        if (a != null) {
            throw new Exception("해당 animal ID는 이미 존재합니다. 재 확인하세요.");
        }
        animalList.add(animal);
        System.out.println("동물 등록이 완료되었습니다.");
    }

    /**
     * 진료기록을 삽입
     * @param medicalRecord 진료기록 객체
     * @throws Exception 이미 존재하는 진료기록 ID일 경우 예외 발생
     */
    public void medicalRecordInsert(MedicalRecord medicalRecord) throws Exception {
        MedicalRecord m = getMedicalRecord(medicalRecord.getPk());
        if (m != null) {
            throw new Exception("해당 진료기록 ID는 이미 존재합니다. 재 확인하세요.");
        }
        medicalRecordList.add(medicalRecord);
        System.out.println("진료기록 등록이 완료되었습니다.");
    }

    /**
     * 질병 정보를 삽입
     * @param disease 질병 객체
     * @throws Exception 예외 발생 시 메시지 출력
     */
    public void diseaseInsert(Disease disease) throws Exception {
        diseaseList.add(disease);
        System.out.println("질병 등록이 완료되었습니다.");
    }

    /**
     * 동물 리스트를 반환
     * @param petName 동물 이름
     * @return 검색된 동물 리스트
     * @throws Exception 검색된 동물이 없거나, 이름을 입력하지 않은 경우 예외 발생
     */
    public ArrayList<Animal> getAnimalList(String petName) throws Exception {
        ArrayList<Animal> searchAnimals = new ArrayList<>();

        if (petName != null && petName.length() != 0) {
            for (Animal animal : animalList) {
                if (animal.getPetName().equals(petName)) {
                    searchAnimals.add(animal);
                }
            }

            if (searchAnimals.size() > 1) {
                System.out.println("다음은 검색된 동물 목록입니다: " + searchAnimals);
                Scanner sc = new Scanner(System.in);
                System.out.print("당신의 애완동물 PK를 입력해주세요: ");
                Integer animalPK = sc.nextInt();
                searchAnimals.removeIf(animal -> animal.getPetId() != animalPK);
                sc.close();
            }

            if (searchAnimals.isEmpty()) {
                throw new Exception("해당 이름의 애완동물이 존재하지 않습니다.");
            }

        } else {
            throw new Exception("애완동물 이름을 입력해주세요.");
        }

        return searchAnimals;
    }

    /**
     * 진료기록 리스트를 반환
     * @param animalPK 동물 PK
     * @return 검색된 진료기록 리스트
     * @throws Exception 입력값 검증 실패 시 예외 발생
     */
    public ArrayList<MedicalRecord> getMedicalRecordList(int animalPK) throws Exception {
        if (animalPK == 0) throw new Exception("애완동물 PK를 입력해주세요.");

        ArrayList<MedicalRecord> searchMedicalRecords = new ArrayList<>();
        
        for (MedicalRecord medicalRecord : medicalRecordList) {
            if (medicalRecord.getAnimalPK() == animalPK) {
                searchMedicalRecords.add(medicalRecord);
            }
        }

        if (searchMedicalRecords.isEmpty()) {
            throw new Exception("해당 애완동물의 진료기록이 존재하지 않습니다.");
        }
        return searchMedicalRecords;
    }

    /**
     * 동물 정보를 반환
     * @param petId 동물 ID
     * @return 동물 객체
     */
    public Animal getAnimalInfo(Integer petId) {
        for (Animal info : animalList) {
            if (info != null && info.getPetId().equals(petId)) {
                return info;
            }
        }
        return null;
    }

    /**
     * 동물 정보 및 진료기록 삭제
     * @param animalPK 동물 PK
     */
    public void animalAndMedicalRecordDelete(int animalPK) {
        Animal animal = getAnimal(animalPK);
        if (animal != null) {
            animalList.remove(animal);
            medicalRecordList.removeIf(record -> record.getAnimalPK() == animalPK);
            System.out.println("동물 정보 및 진료 기록이 삭제되었습니다.");
        } else {
            System.out.println("해당 동물 정보가 존재하지 않습니다.");
        }
    }

    /**
     * 진료 비용 계산 및 업데이트
     * @param animal 동물 객체
     * @param fee 진료 비용
     * @return 업데이트된 동물 객체
     */
    public Animal calculateTotalFee(Animal animal, int fee) {
        int total = animal.getChargeAmount() - fee;
        animal.setChargeAmount(total);
        return animal;
    }

    /**
     * 질병 정보를 반환
     * @param diseaseName 질병 이름
     * @return 질병 객체
     */
    public Disease getDisease(String diseaseName) {
        for (Disease d : diseaseList) {
            if (d != null && d.getDiseaseName().equals(diseaseName)) {
                return d;
            }
        }
        return null;
    }
    
    private Animal getAnimal(Integer petId) {
        for (Animal animal : animalList) {
            if (animal != null && animal.getPetId().equals(petId)) {
                return animal;
            }
        }
        return null;
    }

    private MedicalRecord getMedicalRecord(int pk) {
        for (MedicalRecord medical : medicalRecordList) {
            if (medical != null && medical.getPk() == pk) {
                return medical;
            }
        }
        return null;
    }
}
