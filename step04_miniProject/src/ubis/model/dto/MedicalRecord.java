package ubis.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class MedicalRecord {
	/** 진료기록PK */
	private int pk;
	
	/** 병 */
	private Disease disease;
	
	/** 동물pk */
	private int animalPK;
	
	/** 업데이트 날짜 */
	private String updateDate;
	
	/** 총 진료비 */
	private int totalFee;
	
	/** 담당의사 */
	private String doctorName;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("진료기록PK : ");
		builder.append(pk);
		builder.append(", 병 : ");
		builder.append(disease);
		builder.append("동물PK : ");
		builder.append(animalPK);
		builder.append(", 업데이트 날짜 : ");
		builder.append(updateDate);
		builder.append(", 총 진료비 : ");
		builder.append(totalFee);
		builder.append(", 담당의사 : ");
		builder.append(doctorName);
		return builder.toString();
	}
}


