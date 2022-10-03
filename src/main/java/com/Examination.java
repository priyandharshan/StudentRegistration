package com;

public class Examination {
	private String examId;
	private String examName;
	
	public Examination(String examId,String examName)
	{
		this.examId=examId;
		this.examName=examName;
	}
	public String getExamId() {
		return examId;
	}
	public void setExamId(String examId) {
		this.examId = examId;
	}
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}

}
