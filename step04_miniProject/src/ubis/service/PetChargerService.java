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
	
	/**
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

	public void medicalRecordInsert(MedicalRecord medicalRecord) {
		// TODO Auto-generated method stub
		
	}


}
