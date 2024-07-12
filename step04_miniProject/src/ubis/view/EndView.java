
package ubis.view;


import java.util.ArrayList;

import ubis.model.dto.Animal;
import ubis.model.dto.MedicalRecord;

public class EndView {
	
	//선택한 동물 정보 출력
	public static void animalView(Animal animal){
		if(animal != null) {
			System.out.println(animal);	//project.toString()	
		}else {
			System.out.println("해당 프로젝트는 존재하지 않습니다.");
		}
	}
	
	//선택한 진료기록 출력
	public static void medicalRecordView(MedicalRecord medicalRecord){
		if(medicalRecord != null) {
			System.out.println(medicalRecord);	//project.toString()	
		}else {
			System.out.println("해당 프로젝트는 존재하지 않습니다.");
		}
	}
	
	//입력받은 보호자 이름으로 조회된 모든 동물 리스트 출력
	public static void animalViewList(ArrayList<Animal> animals){
		
		int index = 1;
		for(Animal animal : animals) {
			
			if(animal != null){
				System.out.println("[검색한 animal : " + (index++) + "] " + animal);
			}
			
		}
	}

	
	//입력받은 동물 pk로 조회한 모든 진료기록 출력
	public static void medicalRecordViewList(ArrayList<MedicalRecord> records){
		
		int index = 1;
		for(MedicalRecord medicalRecord : records) {
			
			if(medicalRecord != null){
				System.out.println("[검색한 진료기록 : " + (index++) + "] " + medicalRecord);
			}
			
		}
	}
	public static void successMessage(String message) {
		System.out.println(message);
	}
	
}






