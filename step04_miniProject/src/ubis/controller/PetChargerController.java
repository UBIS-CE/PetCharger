package ubis.controller;

//import java.util.ArrayList;

import ubis.model.dto.Animal;
import ubis.model.dto.Disease;
import ubis.model.dto.MedicalRecord;
import ubis.service.PetChargerService;
import ubis.view.EndView;
import ubis.view.FailView;

public class PetChargerController {

    private static PetChargerController instance;
    private static PetChargerService service = PetChargerService.getInstance();

    private PetChargerController() {}
    
    // 수정 부분 - 웅빈 if문으로 객체가 이미 있다면 생성x
    public static PetChargerController getInstance() {
    	if(instance == null) {
    		instance = new PetChargerController();
    	}
        return instance;
    }

    /**
     * 1. 환자 정보 생성
     * INSERT
     */
    public void animalInsert(Animal animal) {
        String petName = animal.getPetName();
        if (petName != null && petName.length() != 0) {
            try {
                service.animalInsert(animal);
                EndView.successMessage("동물 등록이 완료되었습니다.");
            } catch (Exception e) {
                FailView.failViewMessage("동물 등록 실패: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            FailView.failViewMessage("동물 회원가입 시 필수 정보가 미입력 되었습니다. 다시 한 번 확인해주세요.");
        }
    }

    /**
     * 2. 질병 정보 생성
     * INSERT
     */
    public void diseaseInsert(Disease disease) {
        try {
            service.diseaseInsert(disease);
        } catch (Exception e) {
            FailView.failViewMessage("질병 등록 실패: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 3. 환자 정보 검색
     * 이름 검색 후 리스트 반환-> 선택하여 확인
     * SELECT
     */
    // 수정 부분 - 웅빈
    public void getAnimalList(String petName) throws Exception {
        //EndView.animalViewList(service.getAnimalList(petName));
        //return service.getAnimalList(petName);
    	EndView.animalViewList2(service.getAnimalList(petName));
    }

    /**
     * 4. 환자 진료기록 생성
     * INSERT
     */
    public void medicalRecordInsert(MedicalRecord medicalRecord) {
        int animalPK = medicalRecord.getAnimalPK();
        String doctorName = medicalRecord.getDoctorName();

        if (animalPK != 0 && doctorName != null && doctorName.length() != 0) {
            try {
                service.medicalRecordInsert(medicalRecord);
                EndView.successMessage("진료 기록 등록이 완료되었습니다.");
            } catch (Exception e) {
                FailView.failViewMessage("진료 기록 등록 실패: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            FailView.failViewMessage("진료 기록 필수 정보가 미입력 되었습니다. 다시 한 번 확인해주세요.");
        }
    }

    /**
     * 5. 환자 진료기록 검색
     * SELECT
     */
    public void getMedicalRecordList(int animalPK) {
        try {
        	// 수정 부분 - 웅빈 함수 1 -> 2 로 변경
            EndView.medicalRecordViewList2(service.getMedicalRecordList(animalPK));
        } catch (Exception e) {
            FailView.failViewMessage("진료 기록 조회 실패: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 6. 환자 진료기록 삭제
     * DELETE
     */
    public void animalAndMedicalRecordDelete(int animalPK) {
        service.animalAndMedicalRecordDelete(animalPK);
        EndView.successMessage("동물 정보 및 진료 기록 삭제가 완료되었습니다.");
    }

    /**
     * 7. 환자의 질병 처리 및 비용 계산
     */
    public Animal getDisease(Animal animal, String diseaseName) {
        Disease disease = service.getDisease(diseaseName);
        Animal updatedAnimal = service.calculateTotalFee(animal, disease.getFee());
        return updatedAnimal;
    }
//    // 수정부분 - 웅빈 & 요금 조회 및 정산
//    public void getDisease2(Animal animal, String diseaseName) {
//    	EndView.getDiseaseInfo(service.getDisease(diseaseName));
//    	Animal updatedAnimal = service.calculateTotalFee(animal, disease.getFee());
//    }
//    
    
 
    /**
     * 8. 동물 정보 조회
     */
    // 수정 부분 - 웅빈
    public void getAnimalInfo(int petID) {
        EndView.animalInfo(service.getAnimalInfo(petID));
    }
    // 추가 부분 - 웅빈 , 진료기록 추가
    public void medicalRecordInsert2(int mRPK, String diseaseName, int petPK,String updateDate , String doctorName ) throws Exception {
    	EndView.medicalRecordInsert(service.medicalRecordInsert2(mRPK, diseaseName, petPK,updateDate, doctorName));
    	
    	// 총 진료비에서 이번 진료비를 빼자!
    }
    // service에서 질병에 따른 가격을 불러오고 그 후 service에서 medicalrecord insert
}
