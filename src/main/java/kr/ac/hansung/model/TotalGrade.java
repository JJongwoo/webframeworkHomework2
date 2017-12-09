package kr.ac.hansung.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class TotalGrade {
	private int year;
	private int semester;
	private float credit;
	
	public TotalGrade(int year, int semester, float credit) {
		this.year=year;
		this.semester=semester;
		this.credit=credit;
	}
}
