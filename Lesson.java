package project;

import java.time.LocalTime;

public class Lesson {
	private String venue;
	private String day;
	private LocalTime starttime;
	private LocalTime endtime;
	private String typeOfLesson;
	
	
	//constructor
	Lesson(){}
	Lesson(String venue, String typeOfLesson, String day, LocalTime starttime2, LocalTime endtime2){
		
		this.venue = venue;
		this.day = day;
		this.starttime = starttime2;
		this.endtime = endtime2;
		this.typeOfLesson = typeOfLesson;
		
	}
	
	//methods
	public String getTypeOfLesson() {
		return typeOfLesson;
	}
	
	public void setTypeOfLesson(String typeOfLesson) {
		this.typeOfLesson= typeOfLesson;
	}
	public String getVenue() {
		return venue;
	}
	
	public String getDay() {
		return day;
	}
	
	public LocalTime getStartTime(){
		return starttime;
	}
	
	public LocalTime getEndTime() {
		return endtime;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	
	public void setDay(String day) {
		this.day = day;
	}
	
	public void setStartTime(LocalTime starttime){
		this.starttime = starttime;
	}
	
	public void setEndTime(LocalTime endtime) {
		this.endtime= endtime;
	}
	
	
	

}
