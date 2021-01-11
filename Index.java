package project;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Index {
	
	public List<Lesson> lessonlist = new ArrayList<Lesson>();
	public String CourseCode;
	public String IndexNumber;
	private int AU;
	public int slotsVacancy; //total size - taken slots
	public int slotsTotalsize; //total size
	Queue<String> waitList = new PriorityQueue<String>();
	
	
	//constructors
	public Index() {}
	
	public Index(String courseCode, int AU,String indexNumber) {
		this.CourseCode = courseCode;
		this.AU = AU;
		this.IndexNumber= indexNumber;
	}
	public Index(String indexNumber, int numberOfSlotsIndex, List<Lesson> lessonList) {
		this.IndexNumber = indexNumber;
		this.slotsTotalsize = numberOfSlotsIndex;
		this.lessonlist =lessonList;
	}
	
	public Index(String CourseCode, String indexNumber, int AU, int numberOfSlotsIndex, List<Lesson> lessonList) {
		this.CourseCode = CourseCode;
		this.IndexNumber = indexNumber;
		this.AU = AU;
		this.slotsTotalsize = numberOfSlotsIndex;
		this.slotsVacancy = numberOfSlotsIndex;
		this.lessonlist =lessonList;
	
	}
	
	
	//getset method
	public int getAU() {
		//System.out.println(AU); 

		return this.AU; 
	}
	public void setAU(int AU) {
		this.AU = AU;
	}

	public Queue<String> getWaitList(){
		return waitList;
	}
	public String getIndexNumber() {
		return IndexNumber;
	}

	public String getCourseCode() {
		return CourseCode;
	}
	public List<Lesson> getLessonList() {
		return lessonlist;
	}
	
	
	public void setCourseCode(String courseCode) {
		// TODO Auto-generated method stub
		this.CourseCode = courseCode;
	}
	
	public void setIndexNumber(String indexNumber) {
		this.IndexNumber = indexNumber;
	}
	
	public void setSlotsVacancy(int slotsVacancy) {
		this.slotsVacancy = slotsVacancy;
	}
	
	public void setSlotsTotalSize(int slotsTotalSize) {
		this.slotsTotalsize = slotsTotalSize;
	}
	
	public void setLessonList( List<Lesson> lessonList) {
		this.lessonlist = lessonList;
	}
		
	public int getSlotsTotalsize() {
		return slotsTotalsize;
	}

	public int getVacancy() {
		return slotsVacancy;
	}
	
	
	
	//waitlist methods
	
	public void printWaitlistedStudents() {
	//print name of students that's in that particular index	
		for(String i: waitList) {
			System.out.println(i);			
		}
	}
	
	public void printWaitlistedIndex(String studentName) {
		//print name of students that's in that particular index	
			for(String i: waitList) {
				if(i.equals(studentName)) {
					System.out.println(IndexNumber);			
				}
			}
		}
	
	public void addStudentToWaitlist(String studentName) {
		waitList.add(studentName);
		}
	
	public void dropStudentFromWaitlist(String studentName) {
		waitList.remove(studentName);
		System.out.println("Index dropped");			

		}
	
	public String allocateVacancySlot(String courseDrop,String indexDrop) {
		String currentStudent = null;
		if(slotsVacancy>0) {
			if(waitList.size() != 0) {
			 currentStudent = waitList.element();
					}
		}
		return currentStudent;

	}
	
	
}
//}

