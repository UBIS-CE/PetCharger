package ubis.service;

import java.util.ArrayList;

import ubis.model.dto.Animal;
import ubis.model.dto.MedicalRecord;


public class PetChargerService {

	// singleton design pattern
	private static PetChargerService instance = new PetChargerService();
	
	/** 동물 정보를 저장 */
	private ArrayList<Animal> animalList = new ArrayList<Animal>();
	
	/** 진료기록을 저장 */
	private ArrayList<MedicalRecord> medicalRecordList = new ArrayList<MedicalRecord>();
	
	private PetChargerService() {}
	
	public static PetChargerService getInstance() {
		return instance;
	}
	
	public void animalInsert(Animal animal) throws Exception {
		Animal a = getAnimal(animal.getPetId());
		if (a != null) {
			throw new Exception("해당 animal Id는이미 존재합니다. 재 확인하세요");
		}
		animalList.add(a);
	}
		
	public ArrayList<Animal> getAnimalList(String petName) {
		return null;
	}
	public ArrayList<MedicalRecord> getMedicalRecordList(int animalPK) {
		return null;
	}
	
	/**
<<<<<<< HEAD
	 * animal pk로 animal 객체를 조회
	 */
	public Animal getAnimalInfo(Integer petId) {
		
		for(Animal info : animalList ) {
			if(info != null && info.getAnimalpetId().equals(petId)) {
				return info;
			}
		}
		
		return null;
	}
	
	/**
=======
>>>>>>> e581fb76bb2bf24d5a163eb62035d41deaadb032
	 * animalPK를 animal list와 mediclist에서 삭제
	 * @param animalPK
	 */
	public void animalAndMedicalRecordDelete(int animalPK) {
		Animal animal = animalList.get(animalPK);
		if(animal != null) {
			animalList.remove(animalPK);
			medicalRecordList.remove(animalPK);
		}
	}
	
	public void medicalRecordInsert(MedicalRecord medicalRecord) throws Exception {
		MedicalRecord m = getMedicalRecord(medicalRecord.getPk());
		if (m != null) {
			throw new Exception("해당 진료기록 Id는 이미 존재합니다. 재 확인하세요");
		}
		medicalRecordList.add(m);
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


}
