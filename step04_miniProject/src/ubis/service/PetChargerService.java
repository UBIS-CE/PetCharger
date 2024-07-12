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
	private Animal getAnimal(Integer petId) {
		for (Animal animal : animalList) {
			if (animal != null && animal.getPetId().equals(petId)) {
				return animal; //메소드 자체의 종료
			}
		}
		return null;
	}
		
	public ArrayList<Animal> getAnimalList(String petName) {
		return null;
	}
	public ArrayList<MedicalRecord> getMedicalRecordList(int animalPK) {
		return null;
	}
	public void animalAndMedicalRecordDelete(int animalPK) {
		
	}
	public void medicalRecordInsert(MedicalRecord medicalRecord) throws Exception {
		MedicalRecord m = getMedicalRecord(medicalRecord.getPk());
		if (m != null) {
			throw new Exception("해당 진료기록 Id는 이미 존재합니다. 재 확인하세요");
		}
		medicalRecordList.add(m);
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
