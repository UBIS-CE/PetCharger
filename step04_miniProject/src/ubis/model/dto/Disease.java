package ubis.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Disease {
	
	/** PK **/
	private int diseasePK;
	
	/** 질환명 **/
	private String diseaseName; 
	
	/** 요금 **/
	private int fee;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PK : ");
		builder.append(diseasePK);
		builder.append(", 질환명 : ");
		builder.append(diseaseName);
		builder.append(", 요금 : ");
		builder.append(fee);
		return builder.toString();
	}
}

