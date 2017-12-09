package kr.ac.hansung.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class TypeGrade {
	private String type;
	private float credit;

	public TypeGrade(String type, float credit) {
		this.type = type;
		this.credit = credit;
	}
}
