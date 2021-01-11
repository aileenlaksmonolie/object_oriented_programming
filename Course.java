package project;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class Course {
	
	private String CourseCode;
	private String School;
	public List<Index> Indexlist = new ArrayList<Index>();
	
	public Course(String CourseCode, String School, List<Index> indexList) {
		this.CourseCode = CourseCode; 
		this.Indexlist = indexList;
		this.School = School;
	}
	
	
	public Course() {
	}
	
	
	public String getSchool() {
		return this.School; 
	}
	
	public void setSchool(String school) {
		this.School = school;
	}
	
	public String getCourseCode() {
		return this.CourseCode; 
	}
	public void setCourseCode(String courseCode) {
		this.CourseCode = courseCode;
	}

	public List<Index> getIndexList() {
		return Indexlist;
	}
	
	public void setIndexList(List<Index> Indexlist) {
		this.Indexlist = Indexlist;
	}
	
	public void getIndexNo() {//not needed???
		for(Index i: Indexlist) {
	    	System.out.println("i.getIndexNumber()"); 
		}
	}
	
	



}