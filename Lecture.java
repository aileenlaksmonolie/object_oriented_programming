package project;

import java.time.LocalTime;

public class Lecture extends Lesson {
	Lecture(String venue, String typeOfLesson, String day, LocalTime starttime, LocalTime endtime) {
		super(venue, typeOfLesson,day, starttime, endtime);
	}
	
	Lecture(){}
}