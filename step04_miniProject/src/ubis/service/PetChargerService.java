package ubis.service;

import java.util.ArrayList;

import ubis.model.dto.Animal;
import ubis.model.dto.MedicalRecord;


public class PetChargerService {

	// singleton design pattern
	private static PetChargerService instance = new PetChargerService();

	/** 조회한 진료기록을 저장 */
	private ArrayList<MedicalRecord> medicalRecordList = new ArrayList<MedicalRecord>();

	/** 조회한 동물 정보를 저장 */
	private ArrayList<Animal> animalList = new ArrayList<Animal>();

	private PetChargerService() {}

	public static PetChargerService getInstance() {
		return instance;
	}

	public void animalInsert(Animal animal) {
		
	}

	public ArrayList<Animal> getAnimalList(String petName) {
		return null;
	}

	public ArrayList<MedicalRecord> getMedicalRecordList(int animalPK) {
		return null;
	}

	public void animalAndMedicalRecordDelete(int animalPK) {
		
	}

	public void medicalRecordInsert(MedicalRecord medicalRecord) {
		
	}


}
