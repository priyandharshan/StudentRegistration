package com;

public class Results {
	
	private  int resultId;
	private int StudentId;
	
	private int subjectId;
	private String examId;
	private int studentMark;
	public Results()
	{
		
	}
	
	public Results(int subjectId,String examId,int studentMark)
	{
		
		this.subjectId=subjectId;
		this.examId=examId;
		this.studentMark=studentMark;
	}
	public Results(int resultId,int studentId,int subjectId,String examId,int studentMark)
	{
		this.resultId=resultId;
		this.StudentId=studentId;
		this.subjectId=subjectId;
		this.examId=examId;
		this.studentMark=studentMark;
	}
	public Results(int studentId,int subjectId,String examId,int studentMark)
	{
		this.StudentId=studentId;
		this.subjectId=subjectId;
		this.examId=examId;
		this.studentMark=studentMark;
	}
	
	public int getStudentId() {
		return StudentId;
	}
	public void setStudentId(int studentId) {
		StudentId = studentId;
	}
	
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public String getExamId() {
		return examId;
	}
	public void setExamId(String examId) {
		this.examId = examId;
	}

	public int getResultId() {
		return resultId;
	}
	public void setResultId(int resultId) {
		this.resultId = resultId;
	}
	public int getStudentMark() {
		return studentMark;
	}
	public void setStudentMark(int studentMark) {
		this.studentMark = studentMark;
	}
	

}
