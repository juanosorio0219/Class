package model;

public class Course {
	
	private String name;
	private int numStudents;
	
	private Student firstStudent;
	private Student lastStudent;
	
	public Course(String name, int numStudents) {
		this.name = name;
		this.numStudents = numStudents;
	
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getNumStudents() {
		return numStudents;
	}
	
	public void setNumStudents(int numStudents) {
		this.numStudents = numStudents;
	}
	
	public Student getFirstStudent() {
		return firstStudent;
	}
	
	public void setFirstStudent(Student firstStudent) {
		this.firstStudent = firstStudent;
	}
	

	public void addStudent (Student newStudent) {
		if(firstStudent==null) {
			firstStudent=newStudent;
			lastStudent=firstStudent;
			firstStudent.setNext(lastStudent);
			firstStudent.setPrev(lastStudent);
			lastStudent.setPrev(firstStudent);
			lastStudent.setNext(firstStudent);
		}else {
			newStudent.setNext(firstStudent);
			firstStudent.setPrev(newStudent);
			newStudent.setPrev(lastStudent);
			lastStudent.setNext(newStudent);
			firstStudent=newStudent;
		}
		numStudents++;
		
	}
	
	public String printStudents() {
		String message = "";
		Student temp = firstStudent;
		for(int i = 0; i<numStudents; i++) {
			message += temp.toString() + "\n";
			temp = temp.getNext();			
		}
					
		return message;
	}
	
	public int deleteStudents(String name) {
	Student temp = null;
	int n = 0;
	for(int i = 0; i<numStudents; i++) {
		if(name.equalsIgnoreCase(firstStudent.getName())) {
			temp = firstStudent;
			firstStudent.getNext().setPrev(null);
			firstStudent = firstStudent.getNext();
			temp.setNext(null);
			n++;
		}
		else if(name.equalsIgnoreCase(lastStudent.getName())) {
			temp = lastStudent;
			lastStudent.getPrev().setNext(null);
			lastStudent = lastStudent.getPrev();
			temp.setNext(null);
			n++;
		}
		else {
			Student p = firstStudent;
			Student c = firstStudent.getNext();
			boolean st = false;
			while(c!=null && !st) {
				if(c.getName().equalsIgnoreCase(name)) {
					temp = c;
					c.getNext().setPrev(p);
					p.setNext(c.getNext());
					temp.setNext(null);
					temp.setPrev(null);
					st = true;
					n++;
				}
				else {
					p = c;
					c = p.getNext();
				}
			}
		}
	}
	numStudents-=n;
	return n;
	}
	
}
