package project;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Student {
	//attribute
private String Username;
private String Name;
private String MatricNo;
private String Gender; 
private String Nationality;
private List <Index> studentCourseList;
public List<Course> CourseList = new ArrayList<Course>();



//constructor
public Student(String stuName, String userName, String matricNo, String stuGender, String Nationality,List <Index> studentCourseList, List <Course> courseList ) {
	this.Name = stuName;
	this.Username = userName;
	this.MatricNo = matricNo;
	this.Gender = stuGender;
	this.Nationality = Nationality;
	this.studentCourseList = studentCourseList;
	this.CourseList = courseList;
}


public Student( String userName,List <Index> studentCourseList, List <Course> courseList ) {
	this.Username = userName;
	this.studentCourseList = studentCourseList;
	this.CourseList = courseList;

}


public Student() {
}

//method get and set

public void setUsername(String userName) {
	this.Username = userName;
}

public void setName(String name) {
	this.Name = name;
}
public void setMatricNo(String matricNo) {
	this.MatricNo = matricNo;
}

public void setGender(String gender) {
	this.Gender = gender;
}

public void setNationality(String nationality) {
	this.Nationality = nationality;
}

//Methods
public String getUsername() {
	return Username;
}

public String getMatricNo() {
	return MatricNo;
}

public String getName() {
	return Name;
}

public String getGender() {
	return Gender;
}

public String getNationality() {
	return Nationality;
}
public void setStudentCourse(List<Index>studentCourseList) { 
	this.studentCourseList =studentCourseList ;
	}
//public void setCourseList(List<Index>courseList) { 
//	this.CourseList =courseList ;
//	}

public void setCourseList(List<Index>studentcourseList) {
	this.studentCourseList = studentcourseList;
}

//changes to void
public void printStudentCourse() { 
	for(Index x: studentCourseList) {
		System.out.println(x.getCourseCode());	
		System.out.println(x.getIndexNumber());	
	}
	}

public List<Index> getStudentCourse() { 
	return studentCourseList;
	}


public boolean checkStudentCourse( String courseCode) {
	// checks if student have registered for this course or not;
	for (Index i : studentCourseList) {
		if(i.getCourseCode().equals(courseCode)) {
				System.out.println("Student is registered for this course");	
				return true;
		}
}
	return false;} 


public boolean checkFriendStudentCourse(Student studentobject, String indexNumber, String courseCode) {
	// checks if student have registered for this course or not;
	for (Index i : studentobject.studentCourseList) {
		if(i.getIndexNumber().equals(indexNumber) && i.getCourseCode().equals(courseCode)) {
				System.out.println("Student is registered for this course");	
				return true;
		}
}
	return false;} 

public void StuDropCourse (waitListAllocationCheck allocation) {
	String Username = getUsername();
	String courseEntered;
	boolean checkcourse = false;
	Scanner sc = new Scanner(System.in);
	while(true) { //loop until student input a valid course code
		System.out.println("Please enter course code to be dropped: ");
		courseEntered = sc.nextLine();
		this.getStudentCourse(); //prints out the courses that are already registered by student; DONE
		
		for(Index currentIndex : studentCourseList) {
			if(currentIndex.getCourseCode().equals(courseEntered)) {
				
				checkcourse = checkStudentCourse(courseEntered); //checks if the course code entered is already registered by student; DONE
			}}
		
		if (checkcourse == true) {
			//DROPCOURSE;
			// remove the course from csv and ADD 1 to noofslots
			List<Index> found = new ArrayList<Index>();
			
			Index currentIndex1 = null;
			for(Index currentIndex : studentCourseList) {
				if(currentIndex.getCourseCode().equals(courseEntered)) {
					currentIndex1 = currentIndex;
					found.add(currentIndex);
						}
					}
			for(Course currentCourse: CourseList) {
				for(Index i : currentCourse.getIndexList()) {
					if(i.getIndexNumber().equals(currentIndex1.getIndexNumber())) {
						i.setSlotsVacancy(i.getVacancy()+1);
						String studentToAddToIndex = i.allocateVacancySlot(i.getCourseCode(),i.getIndexNumber());
						allocation.allocateSlot(studentToAddToIndex,i);
						}
				
			}
			}
			studentCourseList.removeAll(found);
			found.removeAll(found);
			
			
			
			//WAITLIST THINGY; have another method for wait list
			System.out.println("Course successfully dropped!");	
			break;
			}
		else {
			System.out.println("Course is not registered. Please input a registered course.");	
			break;
		}
	}
}

public void getVacanciesAvailable() {
	
	System.out.println("Please enter coursecode");
	Scanner sc = new Scanner(System.in);
	String coursecode = sc.nextLine();
	// prints out ALL indexes vacancy/totalsize;
	for (Course i : CourseList) {
		if (i.getCourseCode().equals(coursecode)) {
			System.out.println("These are the indexes for course "+i.getCourseCode()+" (vacancy/totalsize)");
			for (Index x : i.getIndexList()) {
				System.out.println("Index:"+x.getIndexNumber()+", "+x.getVacancy()+"/"+x.getSlotsTotalsize());
			}
		}
	}}

public void getVacanciesAvailable(String coursecode) {
	
	// prints out ALL indexes vacancy/totalsize;
	for (Course i : CourseList) {
		if (i.getCourseCode().equals(coursecode)) {
			System.out.println("These are the indexes for course "+i.getCourseCode()+" (vacancy/totalsize)");
			for (Index x : i.getIndexList()) {
				System.out.println("Index:"+x.getIndexNumber()+", "+x.getVacancy()+"/"+x.getSlotsTotalsize());
			}
		}
	}}


public boolean checkVacanciesAvailable() {
	
	System.out.println("Please enter coursecode");
	Scanner sc = new Scanner(System.in);
	String coursecode = sc.nextLine();
	System.out.println("Please enter index");
	String index = sc.nextLine();
	
	// checks if index is available, look at slotsVacancy, checking from list;
	for (Course i : CourseList) {
		if (i.getCourseCode().equals(coursecode)) {
			for (Index x : i.getIndexList()) {
				if (x.getIndexNumber().equals(index)) {
					if (x.getVacancy()>0)
						return true;
				}
			}
		}
	}
	return false;
}


public boolean checkVacanciesAvailable(String coursecode, String index) {
	// checks if index is available, look at slotsVacancy, checking from list;
	for (Course i : CourseList) {
		if (i.getCourseCode().equals(coursecode)) {
			for (Index x : i.getIndexList()) {
				if (x.getIndexNumber().equals(index)) {
					if (x.getVacancy()>0)
						return true;
				}
			}
		}
	}
	return false;
}




public void StuAddCourse () {
	String Username = getUsername();
	String courseEntered,indexEntered;
	boolean checkcourse = false, checkindex,checkclash = false, checkindex2;
	int choiceIndex, AUCount = 0;
	
	
	
	Scanner sc = new Scanner(System.in);
	
	
	while(true) { //loop until student input a valid course code
		System.out.println("Please enter course code to be added: ");
		courseEntered = sc.nextLine();
		printStudentCourse(); //since can only login as 1 student at a time, just need to get studentcourse registered by the student that logs in.
		//prints out the courses that are already registered by student; DONE
		for(Index i: getStudentCourse()) {
			checkcourse = checkStudentCourse(courseEntered); //already check both index & course.
			
		}

		//checkcourse = checkStudentCourse(Username,courseEntered); //checks if the course code entered is already registered by student; DONE
		if (checkcourse == true) {
			System.out.println("Course is already registered. Please enter another course code.");	
			continue;
			}
		else
			break;
	
	}
		
	System.out.println("Course is not registered yet. ");	
	
	
	//checks the indexes available for courseEntered; DONE
	getVacanciesAvailable(courseEntered);
	
	//student to enter the index they want from the available indexes; DONE
	
	
	while(true) { //loop until student input a valid index
		System.out.println("Please enter available course index to be added: ");
		indexEntered = sc.nextLine(); 
		
		Index indexobjecttobeadded = null;
		for(Course i: CourseList) {
			for(Index currentIndex: i.getIndexList()) {
				if(currentIndex.getIndexNumber().equals(indexEntered)) {
					indexobjecttobeadded = currentIndex;
				}
			}
		}

		// check if the index is part of course; DONE
		checkindex=checkIndexInCourse(courseEntered, indexEntered);
		// check if index has vacancy; DONE
		if (checkindex==true) {
			checkindex2=checkVacanciesAvailable(courseEntered,indexEntered);
			if (checkindex2 == false) {
				System.out.println("Index is already full. Enter 1 to enter waitlist, enter 2 to reenter index.");	
				choiceIndex = sc.nextInt(); 
				if (choiceIndex == 1) {
					//System.out.println(indexobjecttobeadded.getAU());

					System.out.println(Name+" added to waitlist for course "+courseEntered+", "+indexEntered);
					indexobjecttobeadded.addStudentToWaitlist(Name);
					//ADD TO WAITLIST;
					
					break;
				}
				else if (choiceIndex == 2) {
					continue;
				}}
			else {
				
				//checks AU Count
				for (Course currentCourseAU : CourseList) {
					for(Index i: currentCourseAU.getIndexList()) {
					if (currentCourseAU.getCourseCode().equals(courseEntered)  && i.getIndexNumber().equals(indexEntered)) {
						AUCount = i.getAU();
					}
				}
				}
				
				AUCount = AUCount + getAUofStudent(Username);
				
				if (AUCount > 21) {
					System.out.println("Maximum AU reached. Please enter another course code.");	
					//continue;
					}
				for(Index c: studentCourseList) {
					//currentIndexNo is indexnumber taken by the student
					String currentIndexNo = c.getIndexNumber();
					for(Course currentcourse: CourseList) {
						for(Index currentIndex : currentcourse.getIndexList()) {
							if(currentIndex.getIndexNumber().equals(currentIndexNo) && currentcourse.getCourseCode().equals(courseEntered)) { 
							checkclash = checkforScheduleClash(indexobjecttobeadded, currentIndex);
							System.out.println(checkclash);	

							}
						}
						}
					}
				
				for(Index i: studentCourseList) {
					checkclash = checkforScheduleClash(indexobjecttobeadded, i);
				}

				if (checkclash==true) {
					System.out.println("There is a clash in indexes " + indexobjecttobeadded );
				}
				else {
					int AU = 0;
					//ADD COURSE;
					//reduce vacancy by1.
					for (Course i : CourseList) {
						if (i.getCourseCode().equals(courseEntered)) {
							System.out.println("These are the indexes for course "+i.getCourseCode()+" (vacancy/totalsize)");
							for (Index x : i.getIndexList()) {
								if(x.getIndexNumber().equals(indexEntered)) {
									x.setSlotsVacancy(x.getVacancy()-1);
									AU = x.getAU();
									System.out.println(x.getVacancy());


								}
								}
						}
					}
					Index newtakenCourse = new Index( courseEntered,  AU, indexEntered) ;
					studentCourseList.add(newtakenCourse);
					System.out.println("Index successfully added!");	
					break;
				}
			}
		}
		else 
			continue;
		}		
	}


private boolean checkIndexInCourse(String courseEntered, String indexEntered) {
	// checks if index entered is in course
		for (Course i : CourseList) {
			if (i.getCourseCode().equals(courseEntered)) {
				for (Index x : i.getIndexList()) {
					if (x.getIndexNumber().equals(indexEntered)) {
							return true;
					}
				}
			}
		}
	return false;
}


public int getAUofStudent(String Username) {
	//count and return number of AUs student currently has
	int count = 0;
	String[] tempIndex;
	for (Index i : studentCourseList) {
		count = count + i.getAU();
	}
	return count;
}




public boolean checkStudentIndex(String Index) {
	// checks if student have registered for this index or not; mainly for swap with friend
	for (Index i : studentCourseList) {
		
		if(i.getIndexNumber().equals(Index)) { 
				return true;}
			}
		
	return false;
}
public void swapIndexwithAnotherFriend(Student friend){
	
	
	String Username = getUsername();
	String storemyIndex, storefriendIndex, friendsUsername, course2swap;
	boolean checkYourCourse, checkFCourse, checkYourIndexinC, checkFIndexinC, checkYourIndex, checkFIndex;
	boolean checkYourClash = false,checkFClash = false;
	Scanner sc = new Scanner(System.in);
	String index2swap, friendIndex2swap;
	
	
	while(true) {
		
		
		while (true) {//check course
			
			//check whether you & friend both have the indexes registered
			System.out.println("Please enter course code to be swapped");	
			course2swap = sc.nextLine();
			

			System.out.println("Please enter YOUR index to be swapped");	
			 index2swap = sc.nextLine();
			
			System.out.println("Please enter YOUR FRIEND'S index to be swapped");	
			 friendIndex2swap = sc.nextLine();

			
			//checks if you have registered for course2swap
			checkYourCourse=checkStudentCourse(course2swap);//already check for both index and course
			{
			if (checkYourCourse==false) {
				System.out.println("You are not registered under course "+course2swap+", please re-enter course code to be swapped.");	
				continue;
			}
			
			
			//checks if friend have registered for course2swap
			checkFCourse=this.checkFriendStudentCourse(friend,friendIndex2swap,course2swap);//already check for both index and course
			if (checkFCourse==false) {
				System.out.println("Friend not registered under course "+course2swap+", please re-enter friend's username or course code to be swapped.");	
				continue;
			}	
			
			//System.out.println("Please enter your current index:");	
			//storemyIndex = sc.nextLine();
			checkYourIndexinC=checkIndexInCourse(course2swap,index2swap);//check whether index is in course
			//checkYourIndex=checkStudentIndex(index2swap);//check whether you're registered in this index
			
			
			if (checkYourIndexinC == false) {
				System.out.println("Index "+index2swap+" entered is not under course "+course2swap+", please re-enter Index.");	
				continue;
			}
			//if (checkYourIndex == false) {
			//	System.out.println("You are not registered under Index "+storemyIndex+", please re-enter Index.");	
			//	continue;
			//}
			//System.out.println("Please enter friend's current index:");	
			//storefriendIndex = sc.nextLine();
			//checkFIndexinC=checkIndexInCourse(course2swap,storefriendIndex);
			checkFIndexinC=checkIndexInCourse(course2swap,friendIndex2swap);
			//checkFIndex=friend.checkStudentIndex(storefriendIndex);
			if (checkFIndexinC == false) {
				System.out.println("Index "+friendIndex2swap+" entered is not under course "+course2swap+", please re-enter Index.");	
				continue;
			}
			//if (checkYourIndex == false) {
			//	System.out.println("Friend not registered under Index "+friendIndex2swap+", please re-enter Index.");	
			//	continue;
			//}
			break;
		}
		}
		
		
		

	//check for clashes =======================================//
		
		//private boolean checkforScheduleClash(Index indexobjecttobeadded, Index currentIndex) {
	Index friendIndexToSwap = null;
	for(Index i: friend.getStudentCourse()) {
		if(i.getIndexNumber().equals(friendIndex2swap)) {
			friendIndexToSwap=i;
		}
	
	}
	
	for(Index i : this.getStudentCourse()) {
		
	checkYourClash = checkforScheduleClash(friendIndexToSwap,i);
	}
	
	if (checkYourClash==true) {
		System.out.println("Friend's Index "+friendIndex2swap+"clashes with your index, please re-renter.");	
		continue;}
	
	
	// check for schedule clash for FRIEND
	
	Index myIndexToSwap = null;
	for(Index i: this.getStudentCourse()) {
		if(i.getIndexNumber().equals(index2swap)) {
			myIndexToSwap=i;
		}
	}
	
	for(Index i : friend.getStudentCourse()) {
		
	checkFClash = friend.checkforScheduleClash(myIndexToSwap,i);
	}
	if (checkFClash==true) {
		System.out.println("Your Index "+index2swap+"clashes with Friend's index, please re-renter.");	
		continue;}
	
	
	//check for clashes =======================================//
	
	
	
	//swapping==================================================//
	
	//add drop from my account
	
	List<Index> found = new ArrayList<Index>();
	
	for(Index currentIndex : studentCourseList) {
		if(currentIndex.getCourseCode().equals(myIndexToSwap.getCourseCode())) {
			found.add(currentIndex);
				}
			}
	
	studentCourseList.removeAll(found);
	found.removeAll(found);
	
	
	Index newtakenCourse = new Index( friendIndexToSwap.getCourseCode(),  friendIndexToSwap.getAU(), friendIndexToSwap.getIndexNumber()) ;
	studentCourseList.add(newtakenCourse);
	
	//myaccount
	
	//friend's account
	
	//drop
	
	List<Index> found2 = new ArrayList<Index>();
		
		for(Index currentIndex4 : friend.getStudentCourse()) {
			if(currentIndex4.getCourseCode().equals(friendIndexToSwap.getCourseCode()) && currentIndex4.getIndexNumber().equals(friendIndexToSwap.getIndexNumber())) {
				found2.add(currentIndex4);
					}
				}
		
		List<Index> friendCourseList = friend.getStudentCourse();
		
		friendCourseList.removeAll(found2);
		found2.removeAll(found2);
		
	
	//add
	Index myfriendnewindex = new Index( myIndexToSwap.getCourseCode(),  myIndexToSwap.getAU(), myIndexToSwap.getIndexNumber()) ;
	//add myfriendnewindex to his/her list
	friendCourseList.add(myfriendnewindex);
	
	
	friend.setCourseList(friendCourseList);

	
	
	
	break;
	}
	System.out.println("Indexes swapped Successfully!");	
	}

//drop from waitlist


public void printStudentWaitlistedIndex(String studentName) {
	
	for(Course i: CourseList) {
		for(Index currentIndex : i.getIndexList()) {
			currentIndex.printWaitlistedIndex(studentName);
		}
	}
}

public void dropFromWaitlist(String indexToBeDropped, Student currentStudent) {
	for(Course i: CourseList) {
		for(Index currentIndex : i.getIndexList()) {
			if((currentIndex.getIndexNumber().equals(indexToBeDropped))) {
			currentIndex.dropStudentFromWaitlist(this.getName());
		}
			}
	}
}

public void updateChanges() {
	  //update student csv
	  String CSV_SEPARATOR = ",";
	  
	  try
      {
      	 BufferedWriter bw3 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/Users/admin/eclipse-workspace/helloworld/src/project/updatedcsv/updateWaitList.csv"), "UTF-8"));
          for (Course  currentcourse : CourseList)
	          {
        	  
	          	for(Index i: currentcourse.getIndexList()) {
	          		for(String string1: i.getWaitList()) {
	          			
	  	              StringBuffer oneLine3 = new StringBuffer();
	  	              oneLine3.append(currentcourse.getCourseCode().trim().length() == 0? "" : currentcourse.getCourseCode());
	  	              oneLine3.append(CSV_SEPARATOR);
	  	              oneLine3.append(i.getIndexNumber().trim().length() == 0? "" : i.getIndexNumber());
	  	              oneLine3.append(CSV_SEPARATOR);

	  	              oneLine3.append(string1.trim().length() == 0? "" : string1);
	  	              oneLine3.append(CSV_SEPARATOR);
	  	              bw3.write(oneLine3.toString());
	  	              bw3.newLine();
	          			
	          		}
	          		
	              
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
      	 BufferedWriter bw3 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/Users/admin/eclipse-workspace/helloworld/src/project/updatedcsv/updatedIndex.csv"), "UTF-8"));
          for (Course  currentcourse : CourseList)
          {
          	for(Index i: currentcourse.getIndexList()) {
          	
          		
              StringBuffer oneLine3 = new StringBuffer();
              oneLine3.append(currentcourse.getCourseCode().trim().length() == 0? "" : currentcourse.getCourseCode());
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
      
	       
	 //update course csv      
   try
   {
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/Users/admin/eclipse-workspace/helloworld/src/project/updatedcsv/courseupdated.csv"), "UTF-8"));
  	 BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/Users/admin/eclipse-workspace/helloworld/src/project/updatedcsv/updatedLessons.csv"), "UTF-8"));
  
  	 
  	 for (Course currentcourse : CourseList)
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
private boolean checkforScheduleClash(Index indexobjecttobeadded, Index currentIndex) {
	for (Course i: CourseList) {
		for (Index x: i.getIndexList()) {
			for (Lesson lesson: currentIndex.getLessonList()) {
				for (Lesson lessonToBeAdded: indexobjecttobeadded.getLessonList()) {
					if (lessonToBeAdded.getDay() == lesson.getDay()) {
		    			System.out.println(lessonToBeAdded.getDay());	
		    			System.out.println(lesson.getEndTime());	

						if (lessonToBeAdded.getStartTime().isBefore(lesson.getEndTime())  &&
							lesson.getStartTime().isBefore(lessonToBeAdded.getEndTime())) {
							return true;
							}
						}
					}
				}
			}
		}

    return false;
}

}


