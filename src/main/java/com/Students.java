package com;

import java.sql.Date;

public class Students {
	
	private int studentId;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String address;
	private String phonenumber;
	
	private String grade;
	private String base64Image;
	private byte[] image;
	
	public String getBase64Image() {
		return base64Image;
	}
	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}
	
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Students()
	{
		
	}
	public Students(int studentId,String firstName,String lastName)
	{
		this.studentId=studentId;
		this.firstName=firstName;
		this.lastName=lastName;
	}
	public Students(int studentId)
	{
		this.studentId=studentId;
	}
	public Students(int studentId,String firstName,String lastName,String address,String phoneNumber,String dateOfBirth)
	{
		this.studentId=studentId;
		this.firstName=firstName;
		this.lastName=lastName;
		this.address=address;
		this.phonenumber=phoneNumber;
		this.dateOfBirth=dateOfBirth;
	}
	
	public Students(int studentId,String firstName,String lastName,String address,String phoneNumber,String dob,String grade,String gender)
	{
		this.studentId=studentId;
		this.firstName=firstName;
		this.lastName=lastName;
		this.address=address;
		this.dateOfBirth=dob;
		this.phonenumber=phoneNumber;
		this.grade=grade;
		
		this.gender=gender;
	
	}
	
	public Students(int studentId,String firstName,String lastName,String address,String phoneNumber,String dob,String grade,String gender,String base64Image)
	{
		this.studentId=studentId;
		this.firstName=firstName;
		this.lastName=lastName;
		this.address=address;
		this.dateOfBirth=dob;
		this.phonenumber=phoneNumber;
		this.grade=grade;
		
		this.gender=gender;
		this.base64Image=base64Image;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private String gender;
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	


}
