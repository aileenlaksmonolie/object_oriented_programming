package project;

import java.time.LocalTime;

public class Lab extends Lesson{
	
	private String evenWeekforLab;

	Lab(String venue, String typeOfLesson,String day, LocalTime starttime, LocalTime endtime, String oddevenweek) {
		super(venue, typeOfLesson, day, starttime, endtime);
		this.evenWeekforLab = oddevenweek;
		}
	Lab(){}
	String getEvenWeekforLab() {
		return evenWeekforLab;
	}
	
	void setEvenWeekforLab(String evenWeekforLab) {
		this.evenWeekforLab = evenWeekforLab;
	}
	
}
