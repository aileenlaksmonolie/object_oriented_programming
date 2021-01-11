package project;

import java.time.LocalTime;

public class Tutorial extends Lesson {

	Tutorial(String venue, String typeOfLesson, String day, LocalTime starttime, LocalTime endtime) {
		super(venue, typeOfLesson,day, starttime, endtime);
	}
	
	Tutorial(){}

}
