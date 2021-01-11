package project;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class login {	
	public static void main(String[] args) throws IOException {
			csvreader_logindetails logincheck = new csvreader_logindetails();
			String choice;
			Admin currentAdmin = null;
			Student currentStudent= null;
			List <Student> studentList ;
			java.util.Date todayDate;
			Boolean outerCondition = true;
			boolean checkk;
			currentAdmin = new Admin();
			currentAdmin.setDefaultTimePeriod();
			
			
			createLists newList = new createLists();
			studentList = newList.createStudentList();
			Queue <String> waitList =null;
			//newList create waitlist!!!
			List <Course> courseList =newList.createCourseList();
			final String secretKey = "iloveeeejava";
			waitListAllocationCheck allocation = new waitListAllocationCheck( studentList,courseList);
			allocation.importCsv();
			while(outerCondition) {
				
				do {
					while (true) {
						Calendar calendar = Calendar.getInstance(); // Returns instance with current date and time set
						//SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
						todayDate = calendar.getTime();
						//System.out.println(todayDate);

						System.out.println("Please enter student for student login or admin for admin login:");
						Scanner sc = new Scanner(System.in);
						choice = sc.nextLine();
						if (choice.equals("student")) {
							String stuUsername,stuPassword;
							System.out.println("Please enter student username:");
							stuUsername = sc.nextLine();
							System.out.println("Please enter student password:");
							stuPassword = sc.nextLine();
							String encryptedString = password.encrypt(stuPassword, secretKey);
							checkk=logincheck.checkStudentLogin(stuUsername, encryptedString);
							//createLists newList = new createLists();
							//List <Course> courseList =newList.createCourseList();
							//studentList = newList.createStudentList();
							
							for(Student i : studentList) {
								if(stuUsername.equals(i.getUsername())) {
									currentStudent = i;
								}
							}
							if (checkk==true) {
								break;
							}
							else {
								continue;
							}
						}
						else if (choice.equals("admin")) {
							String adminUsername,adminPassword;
							System.out.println("Please enter admin username:");
							adminUsername = sc.nextLine();
							System.out.println("Please enter admin password:");
						    adminPassword = sc.nextLine();
						    String encryptedString = password2.encrypt(adminPassword, secretKey);
							System.out.println(encryptedString);
							checkk=logincheck.checkAdminLogin(adminUsername, encryptedString);							//create student list in admin class
							//createLists newList = new createLists();
							//studentList = newList.createStudentList();
							//List <Course> courseList =newList.createCourseList();
						
							currentAdmin = new Admin(adminUsername, adminPassword, studentList, courseList);
							if (checkk==true) {
								break;
							}
							else {
								continue;
							}
							}
						else {
							System.out.println("Invalid input, please try again!");}}
				break;
				}
			while (choice != "student" && choice != "admin");	
	
		
		boolean x = true;
		while(x) {
		if (choice.equals("admin")) {
			
			
			System.out.println("What do you want to do today?");
			System.out.println("1. Add registration period");
			System.out.println("2. Add course");
			System.out.println("3. Add student");
			System.out.println("4. Check Available Slot");
			System.out.println("5. printStudentListByCourse");
			System.out.println("6. printStudentListByIndex");
			System.out.println("7. printWaitlistedStudents");
			System.out.println("8. Save changes and log off from Admin");
			System.out.println("9. log out");

        	
    	 	Scanner scanner12 = new Scanner(System.in);
        	int AdminChoice = scanner12.nextInt();
        	if(AdminChoice ==1) {
        		currentAdmin.addTimePeriod();
        	}
        	else if(AdminChoice == 2) {
        		currentAdmin.AddCourse();
        	} 
        	else if(AdminChoice ==3) {
        		currentAdmin.AddStudent();
        	}	
        	else if(AdminChoice ==4) {
 
            	currentAdmin.checkAvailableSlot();
        	}
        	else if(AdminChoice ==5) { 
        		currentAdmin.printStudentListByCourse();
        	}
        	else if(AdminChoice ==6) { 
        		currentAdmin.printStudentListByIndex();
        	}
        	else if(AdminChoice ==7) { 
        		currentAdmin.printWaitlistedStudents();
        	}
        	else if(AdminChoice ==8) { 
        		currentAdmin.updateChanges();
        		x= false;
        	}
        	else if(AdminChoice ==9) {
        		currentAdmin.updateChanges();

        		x= false;
        		outerCondition=false;

        	}
        	
        	else {
        		x= false;
        		outerCondition=false;
        	}
		}
		
		else if(choice.equals("student")){
			boolean y = true;
			while(y) {

				System.out.println("What do you want to do today?");
				System.out.println("1. Add course");
				System.out.println("2. drop course");
				System.out.println("3. check current registered course");
				System.out.println("4. getVacanciesAvailable");
				System.out.println("5. checkStudentCourse");
				System.out.println("6. swap index with another friend");
				System.out.println("7. PrintWaitlistedIndex");
				System.out.println("8. Drop from waitlist");
				System.out.println("9. update and log off from student");
				System.out.println("10. log out");

	    	 	Scanner scanner12 = new Scanner(System.in);
	        	int studentChoice = scanner12.nextInt();
	        	
	        	if(studentChoice ==1) {
	        		//if(currentAdmin.getRegistrationEndDate().before(todayDate) || todayDate.before(currentAdmin.getRegistrationStartDate())) {
	    			//	System.out.println("invalid registration date");

	        		//}
	        		//else {
	        		//currentAdmin.getRegistrationEndDate();
	        		currentStudent.StuAddCourse();
	        		//}

	        		//currentStudent.addTimePeriod();
	        	}
	        	else if(studentChoice == 2) {
	        		//if(currentAdmin.getRegistrationEndDate().before(todayDate) || todayDate.before(currentAdmin.getRegistrationStartDate())) {
	    			//	System.out.println("invalid registration date");

	        		//}
	        		//else {
	        		//currentAdmin.getRegistrationEndDate();
					currentStudent.StuDropCourse(allocation);	
	        		//}

	        		//currentAdmin.AddCourse();
	        	} 
	        	else if(studentChoice ==3) {
	        		currentStudent.printStudentCourse();
	        		}	
	        	else if(studentChoice ==4) {
	        		currentStudent.getVacanciesAvailable();
	            	//currentAdmin.checkAvailableSlot();
	        	}
	        	else if(studentChoice ==5) { 
		    	 	Scanner scanner13 = new Scanner(System.in);

	    			System.out.println("Please enter course");	
	    			String courseCode = scanner13.nextLine();

	    			System.out.println("Please enter index");	
	    			String indexNumber = scanner13.nextLine();

	    			System.out.println("Please enter friend's username:");	
	    			String friendsUsername = scanner13.nextLine();
	    			
	    			for(Student i : studentList) {
	    				if(i.getUsername().equals(friendsUsername)) {
	    	        		if(currentStudent.checkStudentCourse(courseCode)==true) {
	    		    			System.out.println("registered");	

	    	        		}
	    	        		else {
	    		    			System.out.println("not registered");	

	    	        		}

	    				}}
	        		//currentAdmin.printStudentListByCourse();
	        	}
	        	else if(studentChoice ==6) { 

	    			System.out.println("Please enter friend's username:");	
		    	 	Scanner scanner13 = new Scanner(System.in);
	    			String friendsUsername = scanner13.nextLine();
	    			
	    			for(Student i : studentList) {
	    				if(i.getUsername().equals(friendsUsername)) {
	    	        		currentStudent.swapIndexwithAnotherFriend(i);

	    				}
	    				
	    				
	    		}
	        		//currentStudent.swapIndexwithAnotherFriend();
	        		//currentAdmin.printStudentListByIndex();
	        	}
	        	else if(studentChoice ==7) {
	        		currentStudent.printStudentWaitlistedIndex(currentStudent.getName());
	            	//currentAdmin.checkAvailableSlot();
	        	}
	        	else if(studentChoice ==8) {
	        		System.out.println("Which index do you want to drop?");	
		    	 	Scanner scanner13 = new Scanner(System.in);
	    			String indexToBeDropped = scanner13.nextLine();	
	        		currentStudent.dropFromWaitlist(indexToBeDropped, currentStudent);
	            	//currentAdmin.checkAvailableSlot();
	        	}
	        	else if(studentChoice ==9 || studentChoice == 10) { 
	        			  //up date student csv
	        		
	        			currentStudent.updateChanges();

	        			  String CSV_SEPARATOR = ",";
	        			   
	        			        try
	        			        {
	        			            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/Users/admin/eclipse-workspace/helloworld/src/project/updatedcsv/updatedstudentCourses.csv"), "UTF-8"));
	        			            for (Student stu : studentList)
	        			            {
	        			                
	        			                for(Index i: stu.getStudentCourse()) {
		        			                StringBuffer oneLine = new StringBuffer();

	        			                	oneLine.append(stu.getUsername().trim().length() == 0? "" : stu.getUsername());
		        			                oneLine.append(CSV_SEPARATOR);
	        			                	oneLine.append(i.getCourseCode().trim().length() == 0? "" : i.getCourseCode());
		        			                oneLine.append(CSV_SEPARATOR);
		        			                oneLine.append(i.getIndexNumber().trim().length() == 0? "" :i.getIndexNumber());
		        			                oneLine.append(CSV_SEPARATOR);
		        			                oneLine.append(i.getAU() <= 0? "" : i.getAU());
		        			                oneLine.append(CSV_SEPARATOR);
		        			                bw.write(oneLine.toString());
		        			                bw.newLine();
	        			                	
	        			                }

	        			            }
	        			            bw.flush();
	        			            bw.close();
	        			        }
	        			        catch (UnsupportedEncodingException e) {}
	        			        catch (FileNotFoundException e){}
	        			        catch (IOException e){}
	        	
        	        		outerCondition = false;
	        			    x = false;
	        				break;
	        				
	        			} 	
	        	else {
	        		x= false;
	        		outerCondition = false;
	        	}
			}
			break;
		}
		}

		}
			System.out.println("Program ends. Thank you & have a nice day!");

}
}