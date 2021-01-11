package project;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class Admin {
	
	//attribute
	//public Student [] studentList;
	//private Course[] courseList= new Course[100];
	private String Username;
	private String password;
	public List<Student> studentList = new ArrayList<Student>();
	public List<Course> courseList = new ArrayList<Course>();
	private java.util.Date RegistrationStartDate;
	private java.util.Date RegistrationEndDate;
	
	//constructor
	public Admin (String name, String password, List <Student> studentList, List <Course> courseList) {
		this.Username = name;
		this.password = password;
		this.studentList = studentList;
		this.courseList = courseList;
	}
	
	

	public Admin() {
		// TODO Auto-generated constructor stub
	}


	//methods
	public void AddStudent() {
		System.out.println("enter student name"); 
    	Scanner scanner = new Scanner(System.in);
    	String name = scanner.nextLine();
    	
    	System.out.println("enter student Username"); 
    	String userName = scanner.nextLine();
    	
    	System.out.println("enter matric number"); 
    	String matricNo = scanner.nextLine();
    	
    	System.out.println("enter gender"); 
    	String gender = scanner.nextLine();
    	
    	System.out.println("enter Nationality"); 
    	String Nationality = scanner.nextLine();
    	
		//should have this contructor in student class
    	List <Index> studentCourseList = null;
    	List <Course> courseList = null;

		Student studentone = new Student(name, userName,matricNo, gender, Nationality, studentCourseList,courseList);
		studentList.add(studentone);
		for(Student i : studentList) {
	    	//System.out.println(i.getUsername()); 
	    	//System.out.println(i.getMatricNo()); 

	    	//System.out.println(i.getNationality()); 
		}
	}
	
	public void AddCourse() {
		
    	List <Index> indexList = new ArrayList <Index> ();

		//enter coursecode, school, number of indexes, and number of lectures
		//course class#==========================================#
		System.out.println("enter course code to be added"); 
    	Scanner scanner = new Scanner(System.in);
    	String CourseCode = scanner.nextLine();
    	
    	System.out.println("enter the course's school"); 
    	Scanner scannerschool = new Scanner(System.in);
    	String School = scannerschool.nextLine();

    	System.out.println("enter the course's number of AU"); 
    	Scanner scannerAU = new Scanner(System.in);
    	int  AU = scannerAU.nextInt();

    	System.out.println("enter the numberOfINdexes to be added"); 
    	Scanner scannerindex = new Scanner(System.in);
    	int numberOfIndexes = scannerindex.nextInt();
		
		//#course class=========================================#
		
		//#index class=========================================#

    	
    	for(int i=0;i<numberOfIndexes;i++) {
    		
    	 	//attributes of index class
    	 	//===========#
    		System.out.println("enter number of slots per index"); 
    	 	Scanner scanner4 = new Scanner(System.in);
        	int numberOfSlotsIndex = scanner4.nextInt();
        	
        	List <Lesson> lessonList = new ArrayList <Lesson> ();
        	//===========#
        	
    		System.out.println("enter index number"); 
    	 	Scanner scannerindexnumber = new Scanner(System.in);
        	String indexNumber = scannerindexnumber.nextLine();

        	//===========#    	//appending lesson objects to lessonlist
        	
        	System.out.println("enter the numberOfLectures to be added"); 
        	Scanner scannerlectures = new Scanner(System.in);
        	int numberOfLectures = scannerlectures.nextInt();
        	
        	for(int iteration=0;iteration<numberOfLectures;iteration++) {
              	System.out.println("enter lecture venue"); 
        	 	Scanner scanner8 = new Scanner(System.in);
            	String venue = scanner8.nextLine();
            	
            	System.out.println("enter lecture day"); 
        	 	Scanner scanner9 = new Scanner(System.in);
            	String day = scanner9.nextLine();
            	
            	System.out.println("enter lecture starttime"); 
        	 	Scanner scanner10 = new Scanner(System.in);
            	String starttime1 = scanner10.nextLine();
    			LocalTime starttime = LocalTime.parse(starttime1);

            	System.out.println("enter lecture endtime"); 
        	 	Scanner scanner11 = new Scanner(System.in);
            	String endtime1 = scanner11.nextLine();
    			LocalTime endtime = LocalTime.parse(endtime1);

            	//add type of lesson
            	String typeOfLesson = "Lecture";
            	Lesson currentLecture = new Lecture(venue, typeOfLesson, day, starttime, endtime);
            	lessonList.add(currentLecture);
    			//append lesson to i.lesson list	
        	}
        	
       		System.out.println("enter number of tutorials"); 
    	 	Scanner scanner5 = new Scanner(System.in);
        	int noOfTutorials = scanner5.nextInt();
        	
        	System.out.println("enter number of seminars"); 
    	 	Scanner scanner6 = new Scanner(System.in);
        	int noOfSeminars = scanner6.nextInt();
        	
        	System.out.println("enter number of labs"); 
    	 	Scanner scanner7 = new Scanner(System.in);
        	int noOfLabs = scanner7.nextInt();
        	
        	//creating tutorial objects and append to lessonlist
        	for(int iteration=0;iteration<noOfTutorials;iteration++) {
              	System.out.println("enter tutorial venue"); 
        	 	Scanner scanner8 = new Scanner(System.in);
            	String venue = scanner8.nextLine();
            	
            	System.out.println("enter tutorial day"); 
        	 	Scanner scanner9 = new Scanner(System.in);
            	String day = scanner9.nextLine();
            	
            	System.out.println("enter tutorial starttime"); 
        	 	Scanner scanner10 = new Scanner(System.in);
            	String starttime1 = scanner10.nextLine();
    			LocalTime starttime = LocalTime.parse(starttime1);

            	System.out.println("enter tutorial endtime"); 
        	 	Scanner scanner11 = new Scanner(System.in);
            	String endtime1 = scanner11.nextLine();
    			LocalTime endtime = LocalTime.parse(endtime1);

            	//add type of lesson
            	String typeOfLesson = "Tutorial";
            	Lesson currentTutorial = new Tutorial(venue, typeOfLesson, day, starttime, endtime);
            	lessonList.add(currentTutorial);
				//append lesson to i.lesson list	
        	}
        	
        	//creating seminar objects and append to lessonlist
        	for(int iteration=0;iteration<noOfSeminars;iteration++) {
              	System.out.println("enter seminar venue"); 
        	 	Scanner scanner8 = new Scanner(System.in);
            	String venue = scanner8.nextLine();
            	
            	System.out.println("enter seminar day"); 
        	 	Scanner scanner9 = new Scanner(System.in);
            	String day = scanner9.nextLine();
            	
            	System.out.println("enter seminar starttime"); 
        	 	Scanner scanner10 = new Scanner(System.in);
            	String starttime1 = scanner10.nextLine();
    			LocalTime starttime = LocalTime.parse(starttime1);

            	System.out.println("enter seminar endtime"); 
        	 	Scanner scanner11 = new Scanner(System.in);
            	String endtime1 = scanner11.nextLine();
    			LocalTime endtime = LocalTime.parse(endtime1);

            	//add type of lesson
            	String typeOfLesson = "Seminar";
            	Lesson currentSeminar = new Seminar(venue, typeOfLesson, day, starttime, endtime);
            	lessonList.add(currentSeminar);
        	}
        	
           	//creating Lab objects and append to lessonlist
        	for(int iteration=0;iteration<noOfLabs;iteration++) {
              	System.out.println("enter Lab venue"); 
        	 	Scanner scanner8 = new Scanner(System.in);
            	String venue = scanner8.nextLine();
            	
            	System.out.println("enter Lab day"); 
        	 	Scanner scanner9 = new Scanner(System.in);
            	String day = scanner9.nextLine();
            	
            	System.out.println("enter Lab starttime"); 
        	 	Scanner scanner10 = new Scanner(System.in);
            	String starttime1 = scanner10.nextLine();
    			LocalTime starttime = LocalTime.parse(starttime1);

            	System.out.println("enter Lab endtime"); 
        	 	Scanner scanner11 = new Scanner(System.in);
            	String endtime1 = scanner11.nextLine();
    			LocalTime endtime = LocalTime.parse(endtime1);

            	//add type of lesson
            	String typeOfLesson = "Lab";
            	
            	System.out.println("Odd or even"); 
        	 	Scanner scanner12 = new Scanner(System.in);
            	String oddeven = scanner12.nextLine();
            	//add type of lesson
            	Lesson currentLab = new Lab(venue, day, typeOfLesson,starttime, endtime, oddeven);
            	lessonList.add(currentLab);
        	}
        	Index indexone = new Index(CourseCode,indexNumber, AU, numberOfSlotsIndex, lessonList);
        	indexList.add(indexone);
			//System.out.println(indexone.getAU());//null

			System.out.println(indexone.getIndexNumber());//null
			System.out.println(indexone.getSlotsTotalsize());//null
			System.out.println(indexone.getVacancy());//null

    		//#index class=========================================#
    	}
    	
    	Course newcourse = new Course(CourseCode, School, indexList);
    	//newcourse.updateChanges();
		courseList.add(newcourse);
		//System.out.println(newcourse.getCourseCode());

		
		for(Course x: courseList) {
        	for(Index i: x.getIndexList()) { 
        	}
		}
	}
	
	public void updateCourseCode() {
    	System.out.println("enter course code to be updated"); 
	 	Scanner scannercoursecode = new Scanner(System.in);
    	String currentcoursecode = scannercoursecode.nextLine();
    	
    	System.out.println("enter course code to be updated to"); 
	 	Scanner newcoursecode = new Scanner(System.in);
    	String updatedcoursecode = newcoursecode.nextLine();
    	
    	
    	for(Course i : courseList) {
    		if(i.getCourseCode() == currentcoursecode){
    			i.setCourseCode(updatedcoursecode); 
    		}		
    	}
	}
	

	public void checkAvailableSlot()
	{
		System.out.println("Enter CourseCode");

	 	Scanner scanner13 = new Scanner(System.in);
    	String courseCode = scanner13.nextLine();
		System.out.println("Enter indexNo");
    	String indexNo = scanner13.nextLine();
		for (Course i : courseList) {
			//System.out.println(i.getCourseCode()); 

			if (i.getCourseCode().equals(courseCode))
			{
				for(Index x: i.getIndexList()) { 
					String indexNumber = x.getIndexNumber();
					if(indexNumber.equals(indexNo)) {
						System.out.println(x.getSlotsTotalsize()); 
					}
					}
			}
		}
	}
	
	public void printStudentListByCourse() {
		System.out.println("Enter CourseCode");

	 	Scanner scanner13 = new Scanner(System.in);
    	String courseCode = scanner13.nextLine();
    	
		for (Student i : studentList) {
			for (Index x: i.getStudentCourse()) {
				
				if(x.getCourseCode().equals(courseCode)) {
					System.out.println(i.getUsername()); 

				}
				}
		}
	}
	public void printStudentListByIndex(){
		System.out.println("Enter Index");
	 	Scanner scanner13 = new Scanner(System.in);
    	String Index = scanner13.nextLine();
		for (Student i : studentList) {
			for(Index x: i.getStudentCourse()) { 
					
					if((x.getIndexNumber().equals(Index))){
						System.out.println(i.getUsername()); 

					}
				}}};
			
	public void printWaitlistedStudents() {
	 printWaitlistedStudents();
			}
	
	public void setRegistrationDate(java.util.Date startDate, java.util.Date endDate) {
		RegistrationStartDate = startDate;
		RegistrationEndDate = endDate;
	}

	public void getRegistrationDate() {
		System.out.println(this.RegistrationStartDate); 
		System.out.println(this.RegistrationEndDate); 

	}
	
	public java.util.Date getRegistrationStartDate() {
		return RegistrationStartDate;
	}
	
	public java.util.Date getRegistrationEndDate() {
		return RegistrationEndDate;
	}
	
	public void addTimePeriod() {
		System.out.println("enter start date: yyyy-mm-dd hh:mm:ss");
    	Scanner scanner = new Scanner(System.in);
    	String date = scanner.nextLine();
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    	java.util.Date date2=null;
    	try {
			date2 = dateFormat.parse(date);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		System.out.println("enter end date: ");

    	Scanner scanner2 = new Scanner(System.in);

    	String date3 = scanner.nextLine();
		System.out.println(date3);

    	SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    	java.util.Date date4=null;
    	try {
			date4 = dateFormat.parse(date3);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	setRegistrationDate(date2,date4);

	}
	
	public void setDefaultTimePeriod() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    	java.util.Date date2=null;
    	try {
			date2 = dateFormat.parse("2020-08-10 10:00:00");
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	java.util.Date date4=null;
    	try {
			date4 = dateFormat.parse("2020-09-10 10:00:00");
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	setRegistrationDate(date2,date4);

	}
	
	

	public void updateChanges() {
		  //update student csv
		  String CSV_SEPARATOR = ",";
		  
		  
	        try
	        {
	        	 BufferedWriter bw3 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\nikit\\Desktop\\Java Coding\\ProjectDraft1\\src\\project\\updatedcsv\\updatedIndex.csv"), "UTF-8"));
	            for (Course  currentcourse : courseList)
	            {
	            	for(Index i: currentcourse.getIndexList()) {
	                StringBuffer oneLine3 = new StringBuffer();

	                oneLine3.append(currentcourse.getCourseCode().trim().length() == 0? "" : i.getCourseCode());
	                oneLine3.append(CSV_SEPARATOR);
	                oneLine3.append(i.getIndexNumber().trim().length() == 0? "" : i.getIndexNumber());
	                oneLine3.append(CSV_SEPARATOR);
	                oneLine3.append(i.getAU() < 0? "" : i.getAU());
	                oneLine3.append(CSV_SEPARATOR);
	                oneLine3.append(i.getVacancy() < 0? "" :i.getVacancy());

	                oneLine3.append(CSV_SEPARATOR);
	                
	                oneLine3.append(i.getSlotsTotalsize() < 0? "" : i.getSlotsTotalsize());
	    			
	                oneLine3.append(CSV_SEPARATOR);

	                bw3.write(oneLine3.toString());
	                bw3.newLine();
	            }
	            }
	            bw3.flush();
	            bw3.close();
	        }
	        catch (UnsupportedEncodingException e) {}
	        catch (FileNotFoundException e){}
	        catch (IOException e){}
	        
		   
		        try
		        {
		            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/Users/admin/eclipse-workspace/helloworld/src/project/updatedcsv/studentupdated.csv"), "UTF-8"));
		            for (Student stu : studentList)
		            {
		                StringBuffer oneLine = new StringBuffer();

		                oneLine.append(stu.getUsername().trim().length() == 0? "" : stu.getUsername());
		                oneLine.append(CSV_SEPARATOR);
		                oneLine.append(stu.getName().trim().length() == 0? "" : stu.getName());
		                oneLine.append(CSV_SEPARATOR);
		                oneLine.append(stu.getMatricNo().trim().length() == 0? "" : stu.getMatricNo());
		                oneLine.append(CSV_SEPARATOR);
		                oneLine.append(stu.getGender().trim().length() == 0? "" : stu.getGender());
		                oneLine.append(CSV_SEPARATOR);
		                oneLine.append(stu.getNationality().trim().length() == 0? "" : stu.getNationality());
		                oneLine.append(CSV_SEPARATOR);
		                bw.write(oneLine.toString());
		                bw.newLine();
		            }
		            bw.flush();
		            bw.close();
		        }
		        catch (UnsupportedEncodingException e) {}
		        catch (FileNotFoundException e){}
		        catch (IOException e){}
		        
		       
		 //update course csv      
	     try
	     {
	         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/Users/admin/eclipse-workspace/helloworld/src/project/updatedcsv/courseupdated.csv"), "UTF-8"));
        	 BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/Users/admin/eclipse-workspace/helloworld/src/project/updatedcsv/updatedLessons.csv"), "UTF-8"));
        
        	 
        	 for (Course currentcourse : courseList)
             {
	            	 //System.out.println(currentcourse.getCourseCode()); 
	            	 // for(Index i: currentcourse.getIndexList()) {
	        		 //get from course class
		             StringBuffer oneLine = new StringBuffer();
		             oneLine.append(currentcourse.getSchool().trim().length() == 0? "" : currentcourse.getSchool());
		             oneLine.append(CSV_SEPARATOR);
		             oneLine.append(currentcourse.getCourseCode().trim().length() == 0? "" : currentcourse.getCourseCode());
		             oneLine.append(CSV_SEPARATOR);
		             //oneLine.append(currentcourse.getAU() <=0 ? "" : currentcourse.getAU());
		             oneLine.append(CSV_SEPARATOR);
		             //get from index class
		          //   oneLine.append(i.getIndexNumber().length() == 0? "" : i.getIndexNumber());
		            // oneLine.append(CSV_SEPARATOR);
		             
		             bw.write(oneLine.toString());
		             bw.newLine();
		        // }
					//System.out.println(currentcourse.getCourseCode()); 

	        	 for(Index i: currentcourse.getIndexList()) {
	        		
	        		 //System.out.println(i.getCourseCode()); 
		        	 for(Lesson y: i.getLessonList()) {
		        		 
		        		 	//if(y.getTypeOfLesson().equals("Tutorial")) {
		        		 		
		        			//System.out.println(y.getEndTime()); 
							//get from course class
							 StringBuffer oneLine2 = new StringBuffer();
				             oneLine2.append(i.getCourseCode().trim().length() == 0? "" :i.getCourseCode());
				             oneLine2.append(CSV_SEPARATOR);
		        			 //System.out.println(i.getCourseCode()); 

				             oneLine2.append(i.getIndexNumber().trim().length() == 0? "" :i.getIndexNumber());
				             oneLine2.append(CSV_SEPARATOR);
			        		 //System.out.println(i.getIndexNumber()); 

				             oneLine2.append(y.getTypeOfLesson());
				             oneLine2.append(CSV_SEPARATOR);
				             
				             oneLine2.append(y.getVenue().trim().length() == 0? "" : y.getVenue());
				             oneLine2.append(CSV_SEPARATOR);
				             oneLine2.append(y.getDay().trim().length() == 0? "" : y.getDay());
				             oneLine2.append(CSV_SEPARATOR);
				             String [] starttime = y.getStartTime().toString().split(":");
				             

				             oneLine2.append(starttime[0].trim().length() == 0? "" : starttime[0]);
				             oneLine2.append(CSV_SEPARATOR);
				             oneLine2.append(starttime[1].trim().length() == 0? "" : starttime[1]);
				             oneLine2.append(CSV_SEPARATOR);
				             String [] endttime = y.getEndTime().toString().split(":");

				             oneLine2.append(endttime[0].trim().length() == 0? "" : endttime[0]);
				             oneLine2.append(CSV_SEPARATOR);
				             oneLine2.append(endttime[1].trim().length() == 0? "" : endttime[1]);
				             oneLine2.append(CSV_SEPARATOR);
				             bw2.write(oneLine2.toString());
				             bw2.newLine();

		        	 }
	        	 }
	        	 }
	        	 
        	 
	         bw.flush();
	         bw.close();

             bw2.flush();
             bw2.close();
             
	     }
             
	     catch (UnsupportedEncodingException e) {}
	     catch (FileNotFoundException e){}
	     catch (IOException e){}
     

	     
}



		// TODO Auto-generated method stub
		
	
	   

}