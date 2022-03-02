package studentManagementApp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.student.manage.StudentClass;
import com.student.manage.StudentDao;

public class Start {
                                         //ignores the exceptions
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
	  System.out.println("welcome to student management app");
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  while(true)
	  {
		  System.out.println("PRESS 1 to ADD student");
		  System.out.println("PRESS 2 TO DELETE student");
		  System.out.println("PRESS 3 TO DISPLAY student");
		  System.out.println("PRESS 4 TO EXIT app");
		  int choice = Integer.parseInt(br.readLine());
		 if (choice ==1) {
			//add student
			 System.out.println("enter student name");
			 String name = br.readLine();
			 System.out.println("enter student phone");
			 String phone = br.readLine();
			 System.out.println("enter student city");
			 String city = br.readLine();
			 
			 //create student object to store
			 StudentClass st = new StudentClass(name,phone,city);
			 boolean answer=StudentDao.insertStudentToDB(st);
			 if (answer) {
				System.out.println("Success in data adding in db");
			}else {System.out.println("something went wrong try again");}
			 
			 System.out.println(st);
			 
		}
		 else if(choice==2) {
			 //delete student
			 System.out.println("Enter student id to delete");
			 int usrID = Integer.parseInt(br.readLine());
			 boolean flagD = StudentDao.deleteStudent(usrID);
			 if (flagD) {
					System.out.println("Success in data adding in db");
				}else {System.out.println("something went wrong try again");}
				 
				
		  	 
		 }
		 else if(choice==3) {
			 //display student
		  	 StudentDao.showAllStudents();
		 }
		 else if(choice==4) {
			 //exit app
			 break;
		  	 
		 }
		 }
          System.out.println("out of loop"); 
	}

}
