package ubis.service;

import java.util.ArrayList;

import ubis.model.dto.Animal;
import ubis.model.dto.MedicalRecord;


public class PetChargerService {

	// singleton design pattern
	private static PetChargerService instance = new PetChargerService();
	
	private MedicalRecordService() {}
	
	public static MedicalRecordService getInstance() {
			return instance;
	}
	
	/** 조회한 진료기록을 저장 */
	private ArrayList<MedicalRecord> medicalRecordList = new ArrayList<MedicalRecord>();


	/** 조회한 동물 정보를 저장 */
	private ArrayList<Animal> animalList = new ArrayList<Animal>();

	private PetChargerService() {}

	public static PetChargerService getInstance() {
		return instance;
	}

	public void animalInsert(Animal animal) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Animal> getAnimalList(String petName) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<MedicalRecord> getMedicalRecordList(int animalPK) {
		// TODO Auto-generated method stub
		return null;
	}

	public void animalAndMedicalRecordDelete(int animalPK) {
		// TODO Auto-generated method stub
		
	}

	public void medicalRecordInsert(MedicalRecord medicalRecord) {
		// TODO Auto-generated method stub
		
	}


}
