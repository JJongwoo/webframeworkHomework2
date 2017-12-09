package kr.ac.hansung.model;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class DividedGrade {
	private int year;
	private int semester;
	private float credit;
	private String classname;
	
	public DividedGrade(int year, int semester, float credit, String classname) {
		this.year=year;
		this.semester=semester;
		this.credit = credit;
		this.classname=classname;
	}
}
