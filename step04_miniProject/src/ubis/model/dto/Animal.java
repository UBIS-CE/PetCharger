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
	private String pet_id;
	
	// 반려동물 이름
	private String pet_name;
	
	// 보호자 성함
	private String guardian_name;
	
	// 동물 종류
	private String animal_type;
	
	// 충전 금액
	private int charge_amount;
	
	// 반려동물 성별
	private char gender;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("동물 id : ");
		builder.append(pet_id);
		builder.append("반려동물 이름 : ");
		builder.append(pet_name);
		builder.append("보호자 성함 : ");
		builder.append(guardian_name);
		builder.append("동물 종류 : ");
		builder.append(animal_type);
		builder.append("충전 금액 : ");
		builder.append(charge_amount);
		builder.append("반려동물 성별 : ");
		builder.append(gender);
		return builder.toString();
	}
}
