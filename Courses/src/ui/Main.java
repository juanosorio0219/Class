package ui;

import java.util.Scanner;

import model.Course;
import model.Student;



public class Main {
	public static Scanner lector = new Scanner(System.in);
	private Course course;
	
	
	public static void main(String[] args) {
		Main controller = new Main();
		int start = 0;
		do{
				System.out.println("Welcome to the menu:\n1. Add Student \n2. Show Students \n3. Delete Student \n0.Exit");
				int option=lector.nextInt();
				lector.nextLine();
				switch(option){
					case 1:
						controller.addStudent();					 
					break;				
					case 2:
						controller.printStudents();					
					break;
					case 3:
						controller.deleteStudents();
					break;
				
					default:
					System.out.println("\nThe option entered is not valid");
					break;
				}
						
			System.out.println("\nMENU: 0 \nClose the the program: 1");
			start = lector.nextInt();
			lector.nextLine();
		}
		while (start == 0);
	}
	private void deleteStudents() {
		System.out.println("Enter the name of the student you want to delete");
		String name = lector.nextLine();
		System.out.println("Number of students deleted: "+course.deleteStudents(name));
		
		
		
	}
	private void printStudents() {
		System.out.println(course.printStudents());
		
	}
	private void addStudent() {
		
		System.out.println("Enter the code of the student");
		String code = lector.nextLine();
		System.out.println("Enter the name of the student");
		String name = lector.nextLine();
		course.addStudent(new Student(code, name));
		System.out.println("The student has been added successfully");
		
		
	}
	public Main() {
		course = new Course("Apo2", 0);
		
	}
	

}
