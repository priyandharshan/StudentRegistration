package com;

public class Subjects {
	private int subjectId;
	private String subjectName;
	private String grade;
	
	public Subjects(int subjectId,String subjectName,String grade)
	{
		this.subjectId=subjectId;
		this.subjectName=subjectName;
		this.grade=grade;
	}
	public Subjects(String subjectName,String grade)
	{
		this.subjectName=subjectName;
		this.grade=grade;
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	

}
