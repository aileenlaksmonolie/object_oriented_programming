package project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class createLists {
	public List<Index> createStudentCourseList(String studentUserName) throws IOException {
		String path = "/Users/admin/eclipse-workspace/helloworld/src/project/updatedcsv/updatedstudentCourses.csv";
		String line = "";
		BufferedReader brcs = new BufferedReader(new FileReader(path));  
		List<Index> studentCourseList = new ArrayList<>();
		while ((line = brcs.readLine()) != null) {  
		       String splitBy = ",";
		       // split on comma(',')  
		       String[] studentclcsv = line.split(splitBy );  
		       // create car object to store values  
		       Index tcoursesObj = new Index();
		       if(studentclcsv[0].equals(studentUserName)) {
			       tcoursesObj.setCourseCode(studentclcsv[1]);
			       tcoursesObj.setIndexNumber(studentclcsv[2]);
			       tcoursesObj.setAU(Integer.parseInt(studentclcsv[3]));
			       studentCourseList.add(tcoursesObj);
		       	} 	
		}
		for(Index i : studentCourseList) {
	       // System.out.println(i.getAU());
		}
		
		return studentCourseList;
	}
	public List<Student> createStudentList() throws IOException {
		String path = "/Users/admin/eclipse-workspace/helloworld/src/project/updatedcsv/studentupdated.csv";
		String line = "";
		BufferedReader br = new BufferedReader(new FileReader(path));  
		

		List<Student> studentList = new ArrayList<>();
		while ((line = br.readLine()) != null) {  
		       String splitBy = ",";
			// split on comma(',')  
		       String[] studentCsv = line.split(splitBy ); 

		       List<Index> takenCoursesList = createStudentCourseList(studentCsv[0]);

			
				Student studentobj = new Student(studentCsv[0],takenCoursesList,createCourseList());
		
				

		      // Student studentobj = new Student(studentCsv[0],takenCoursesList, );

		       // create car object to store values  
		      // studentobj.setUsername(studentCsv[0]);
		       studentobj.setName(studentCsv[1]);
		       studentobj.setMatricNo(studentCsv[2]);
		       studentobj.setGender(studentCsv[3]);
		       studentobj.setNationality(studentCsv[4]);
		       //studentobj.setStudentCourse(createStudentCourseList(studentCsv[0]));
		       
		       studentList.add(studentobj);
			   //studentobj.setStudentCourse(takenCoursesList);
			   //for(Index i:studentobj.getStudentCourse()) {
			     //   System.out.println( i.getCourseCode());
			   //}
				
				
		} 
		
		for(Student i : studentList) {
	        //System.out.println(i.getUsername());

			for(Index x:i.getStudentCourse()) {
		       // System.out.println(x.getCourseCode());
		   }
	        //System.out.println(i.getName());
	        //System.out.println(i.getMatricNo());
		}
		
		return studentList;
	}
	
	public List<Course> createCourseList() throws NumberFormatException, IOException{
		//create courses
			String path = "/Users/admin/eclipse-workspace/helloworld/src/project/updatedcsv/courseupdated.csv";
			String line = "";
			BufferedReader br = new BufferedReader(new FileReader(path));  
			List<Course> courseList = new ArrayList<>();
			while ((line = br.readLine()) != null) {  
			       String splitBy = ",";
			       String[] courseCsv = line.split(splitBy );  

			       // create car object to store values  
			     
			       Course courseobj = new Course();
			       courseobj.setSchool(courseCsv[0]);
			       courseobj.setCourseCode(courseCsv[1]);
			       //courseobj.setAU(Integer.parseInt(courseCsv[2]));
		           //System.out.println(courseobj.getSchool());

			       String path2 = "/Users/admin/eclipse-workspace/helloworld/src/project/updatedcsv/updatedLessons.csv";
				   String line2 = "";
				   
				   
				   BufferedReader br2 = new BufferedReader(new FileReader(path2));  
			       List<Lecture> LectureList = new ArrayList<>();
			       while ((line2 = br2.readLine()) != null) {  
				       String splitBy2 = ",";
				       String[] lecturecsv = line2.split(splitBy2 );  
				       Lecture lectureobj = new Lecture();
				       
				       if(courseCsv[1].equals(lecturecsv[0]) && (lecturecsv[2].equals("Lecture"))) { //join by coursecode & Lecture 
	
					       lectureobj.setVenue(lecturecsv[3]);
					       lectureobj.setDay(lecturecsv[4]);
					       lectureobj.setStartTime(LocalTime.parse(lecturecsv[5]));
					       lectureobj.setEndTime(LocalTime.parse(lecturecsv[6]));
					       LectureList.add(lectureobj);
				           // System.out.println(lectureobj.getDay());

				       // create car object to store values  
			       }

			       }
			     
			
			   String path3 = "/Users/admin/eclipse-workspace/helloworld/src/project/updatedcsv/updatedIndex.csv";
			   String line3 = "";
			   BufferedReader br3 = new BufferedReader(new FileReader(path3));  
		       List<Index> indexList = new ArrayList<>();
		       while ((line3 = br3.readLine()) != null) {  
			       String splitBy3 = ",";
			       String[] indexcsv = line3.split(splitBy3 );  
			       Index indexobj = new Index();
			       
			       if(courseCsv[1].equals(indexcsv[0])) { //join by coursecode
			       indexobj.setCourseCode(indexcsv[0]);
			       indexobj.setIndexNumber(indexcsv[1]);
			       indexobj.setAU(Integer.parseInt(indexcsv[2]));
			       indexobj.setSlotsVacancy(Integer.parseInt(indexcsv[3]));
			       indexobj.setSlotsTotalSize(Integer.parseInt(indexcsv[4]));
			       indexList.add(indexobj);

			       // create car object to store values  
		       }
		       
		       String path4 = "/Users/admin/eclipse-workspace/helloworld/src/project/updatedcsv/updatedLessons.csv";
			   String line4 = "";
			   BufferedReader br4 = new BufferedReader(new FileReader(path4));  
		       List<Lesson> lessonList = new ArrayList<>();
		       while ((line4 = br4.readLine()) != null) {  
			       String splitBy4 = ",";
			       String[] lessonCsv = line4.split(splitBy4);  
			       Lesson tutorialobj = new Tutorial();
			       Lesson seminarObj = new Seminar();
			       Lesson labObj = new Lab();

			       if( lessonCsv[1].equals(indexcsv[1]) && lessonCsv[2].equals("Tutorial")) {
			    	   
			    	   tutorialobj.setVenue(lessonCsv[3]);
			    	   tutorialobj.setDay(lessonCsv[4]);
			    	   tutorialobj.setTypeOfLesson("Tutorial");

			    	   tutorialobj.setStartTime(LocalTime.of(Integer.parseInt(lessonCsv[5]),Integer.parseInt(lessonCsv[6])));
			    	   tutorialobj.setEndTime(LocalTime.of(Integer.parseInt(lessonCsv[7]),Integer.parseInt(lessonCsv[8])));
			           //System.out.println(tutorialobj.getDay());
			    	   lessonList.add(tutorialobj);

			       }
			       
		    	   else if(lessonCsv[1].equals(indexcsv[1]) && lessonCsv[2].equals("Seminar")) {
		    		   
		    		   seminarObj.setVenue(lessonCsv[3]);
		    		   seminarObj.setDay(lessonCsv[4]);
		    		   seminarObj.setTypeOfLesson("Seminar");
		    		   seminarObj.setStartTime(LocalTime.of(Integer.parseInt(lessonCsv[5]),Integer.parseInt(lessonCsv[6])));
		    		   seminarObj.setEndTime(LocalTime.of(Integer.parseInt(lessonCsv[7]),Integer.parseInt(lessonCsv[8])));
			           //System.out.println(seminarObj.getTypeOfLesson());
			    	   lessonList.add(seminarObj);

			    	   }
			       //LocalTime.of(Integer.parseInt(lecturecsv[4]),Integer.parseInt(lecturecsv[5])
		    	   else if( lessonCsv[1].equals(indexcsv[1]) && lessonCsv[2].equals("Lab")) {
		    		   

			    	   //((Lab) labObj).setEvenWeekforLab(lessonCsv[9]);
		    		   labObj.setVenue(lessonCsv[3]);
		    		   labObj.setDay(lessonCsv[4]);
		    		   labObj.setTypeOfLesson("Lab");
		    		   labObj.setStartTime(LocalTime.of(Integer.parseInt(lessonCsv[5]),Integer.parseInt(lessonCsv[6])));
		    		   labObj.setEndTime(LocalTime.of(Integer.parseInt(lessonCsv[7]),Integer.parseInt(lessonCsv[8])));
			    	   
			    	   lessonList.add(labObj);
		    	   }
			       }
		       indexobj.setLessonList(lessonList);
			       }
		       
		       courseobj.setIndexList(indexList);
		       courseList.add(courseobj);
		} 
			
			for(Course i : courseList) {
				//if(i.getCourseCode().equals("CZ2001")) {
	            //System.out.println(i.getSchool());
	            //System.out.println(i.getAU());
		           // System.out.println(x.getStartTime());
		           // System.out.println(x.getDay());


	           // }
	            for(Index y : i.getIndexList()) {
		            //System.out.println(y.getIndexNumber());

					//if(y.getIndexNumber().equals("10495")) {
						for(Lesson a: y.getLessonList()) {
							//System.out.println(a.getEndTime());

						//System.out.println(a.getVenue());
//
					//	}
						}
							//System.out.println(y.getLessonList());
		           // System.out.println(y.getSlotsTotalsize());
///
	            }
	            }
			return courseList;
			
	}
	

}




