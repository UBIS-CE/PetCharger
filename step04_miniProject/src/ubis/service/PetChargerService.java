package ubis.service;

import java.util.ArrayList;
import java.util.Scanner;

import ubis.model.dto.Animal;
import ubis.model.dto.Disease;
import ubis.model.dto.MedicalRecord;


public class PetChargerService {

	// singleton design pattern
	private static PetChargerService instance = new PetChargerService();
	
	/** 동물 정보를 저장 */
	private ArrayList<Animal> animalList = new ArrayList<Animal>();
	
	/** 진료기록을 저장 */
	private ArrayList<MedicalRecord> medicalRecordList = new ArrayList<MedicalRecord>();
	
	/** 질병정보를 저장 */
	private ArrayList<Disease> diseaseList = new ArrayList<Disease>();

	private PetChargerService() {}
	
	public static PetChargerService getInstance() {
		return instance;
	}
	
	public void animalInsert(Animal animal) throws Exception {
		Animal a = getAnimal(animal.getPetId());
		if (a != null) {
			throw new Exception("해당 animal Id는이미 존재합니다. 재 확인하세요");
		}
		animalList.add(animal);
	}
		
	public void medicalRecordInsert(MedicalRecord medicalRecord) throws Exception {
		MedicalRecord m = getMedicalRecord(medicalRecord.getPk());
		if (m != null) {
			throw new Exception("해당 진료기록 Id는 이미 존재합니다. 재 확인하세요");
		}
		medicalRecordList.add(medicalRecord);
	}
	
	public void diseaseInsert(Disease disease) throws Exception {
		diseaseList.add(disease);
	}
	
	
	public ArrayList<Animal> getAnimalList(String petName) throws Exception {
		// 검색된 데이터 넣을 리스트 생성
		ArrayList<Animal> searchAnimals = new ArrayList<Animal>();
		// petName 입력값 검증
		if (petName != null && petName.length() != 0) {
			// 펫이름으로 해당되는 리스트 검색
			for (Animal animal : animalList) {
				if (animal.getPetName().equals(petName)) {
					searchAnimals.add(animal);
				}
			}
			
			// 펫이름으로 조회되 리스트가 2이상이면 사용자에게 id를 받고 해당 데이터 보여주기
			if (searchAnimals.size() > 1) {
				searchAnimals.toString();
				Scanner sc = new Scanner(System.in);
				System.out.println("당신의 애완동물 pk를 입력해주세요.");
				Integer animalPK = sc.nextInt();
				
				searchAnimals.removeIf(animal -> animal.getPetId() != animalPK);
			} 
			
		} else {
			throw new Exception("애완동물 이름을 입력해주세요.");
		}

		return searchAnimals;
	}

	public ArrayList<MedicalRecord> getMedicalRecordList(int animalPK) throws Exception {		
		// animalPK 입력값 검증
		if(animalPK == 0) throw new Exception("애완동물 PK을 입력해주세요.");
		
		// 검색된 데이터 넣을 리스트 생성
		ArrayList<MedicalRecord> searchMedicaRecord = new ArrayList<MedicalRecord>();
		
		for (MedicalRecord medicalRecord : medicalRecordList) {
			if (medicalRecord.getAnimalPK() == animalPK) {
				searchMedicaRecord.add(medicalRecord);
			}
		}
		
		return searchMedicaRecord;
	}

	public Animal getAnimalInfo(Integer petId) {
		
		for(Animal info : animalList ) {
			if(info != null && info.getPetId().equals(petId)) {
				return info;
			}
		}
		
		return null;
	}
	

	public void animalAndMedicalRecordDelete(int animalPK) {
		Animal animal = animalList.get(animalPK);
		if(animal != null) {
			animalList.remove(animalPK);
			medicalRecordList.remove(animalPK);
		}
	}

	public Animal calculateTotalFee(Animal animal, int fee) {
		int total = animal.getChargeAmount() -fee;
		animal.setChargeAmount(total);
		return animal;
	}
	
	private Animal getAnimal(Integer petId) {
		for (Animal animal : animalList) {
			if (animal != null && animal.getPetId().equals(petId)) {
				return animal; //메소드 자체의 종료
			}
		}
		return null;
	}
	
	private MedicalRecord getMedicalRecord(int pk) {
		for (MedicalRecord medical : medicalRecordList) {
			if (medical != null && medical.getPk()==pk) {
				return medical; //메소드 자체의 종료
			}
		}
		return null;
	}
	
	public Disease getDisease(String diseaseName) {
		for (Disease d : diseaseList) {
			if (d != null && d.getDiseaseName().equals(diseaseName)) {
				return d; //메소드 자체의 종료
			}
		}
		return null;
	}


}
