package ubis.controller;
import ubis.model.dto.Animal;
import ubis.model.dto.Disease;
import ubis.model.dto.MedicalRecord;
import ubis.service.PetChargerService;
import ubis.view.EndView;
import ubis.view.FailView;
public class PetChargerController {
	
	private static PetChargerController instance = new PetChargerController();
	private static PetChargerService service = PetChargerService.getInstance();
	private PetChargerController() {}
	public static PetChargerController getInstance() {
		return instance;
	}
	/**
	 * 1. 환자 정보 생성
	 * INSERT
	 *
	 *
	 */
	public void animalInsert(Animal animal) {
		String petName = animal.getPetName();
		if(petName != null && petName.length() !=0){
			try {
				service.animalInsert(animal);
				EndView.successMessage("동물 등록이 완료되었습니다.");
			}catch (Exception e) {
				FailView.failViewMessage(e.getMessage()); //실패인 경우 예외로 end user 서비스
				e.printStackTrace();
			}
		}
		else {
			FailView.failViewMessage("동물 회원가입 시 필수 정보가 미입력 되었습니다. 다시 한 번 확인해주세요");
		}
	}
	
	
	public void diseaseInsert(Disease disease) {
		service.diseaseInsert(disease);
	}
	/**
	 * 2. 환자 정보 검색
	 * 이름 검색 후 리스트 반환-> 선택하여 확인
	 * SELECT
	 * @return 환자 객체
	 */
	public void getAnimalList(String petName) {
		try {
			EndView.animalViewList(service.getAnimalList(petName));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 3. 환자 진료기록 생성
	 * INSERT
	 * @return 진료기록 객체
	 */
	public void medicalRecordInsert(MedicalRecord medicalRecord) {
		int animalPK = medicalRecord.getAnimalPK();
		String doctorName = medicalRecord.getDoctorName();
		
		if(animalPK !=0 && doctorName !=null && doctorName.length()!=0){
			try {
				service.medicalRecordInsert(medicalRecord);
				EndView.successMessage("진료 기록 등록이 완료되었습니다.");
			}catch (Exception e) {
				FailView.failViewMessage(e.getMessage()); //실패인 경우 예외로 end user 서비스
				e.printStackTrace();
			}
		}
		else {
			FailView.failViewMessage("진료 기록 필수 정보가 미입력 되었습니다. 다시 한 번 확인해주세요");
		}
	}
	
	/**medicalRecord
	 * 4. 환자 진료기록 검색
	 * SELECT
	 * @param 동물 pk
	 * @return 진료기록 객체
	 */
	public void getMedicalRecordList(int animalPK) {
		try {
			EndView.medicalRecordViewList(service.getMedicalRecordList(animalPK));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 5. 환자 진료기록 삭제
	 * DELETE
	 *
	 * 동물 정보, 진료기록 정보 모두 삭제
	 * @param 동물 pk
	 * @return 진료기록 객체
	 */
	public void animalAndMedicalRecordDelete(int animalPK) {
		service.animalAndMedicalRecordDelete(animalPK);
	}
	
	public void getDisease(Animal animal, String diseaseName) {
		Disease disease = service.getDisease(diseaseName);
		service.calculateTotalFee(animal, diseaseName);
	}
	
	public Animal getAnimalInfo(int petID) {
		return service.getAnimalInfo(petID);
	}
}