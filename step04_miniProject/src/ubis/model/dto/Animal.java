package ubis.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter  
@Setter

public class Animal {
	// 동물 pk
	private String petId;
	
	// 반려동물 이름
	private String petName;
	
	// 보호자 성함
	private String guardianName;
	
	// 동물 종류
	private String animalType;
	
	// 충전 금액
	private int chargeAmount;
	
	// 반려동물 성별
	private char gender;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("동물 id : ");
		builder.append(petId);
		builder.append("반려동물 이름 : ");
		builder.append(petName);
		builder.append("보호자 성함 : ");
		builder.append(guardianName);
		builder.append("동물 종류 : ");
		builder.append(animalType);
		builder.append("충전 금액 : ");
		builder.append(chargeAmount);
		builder.append("반려동물 성별 : ");
		builder.append(gender);
		return builder.toString();
	}
}
