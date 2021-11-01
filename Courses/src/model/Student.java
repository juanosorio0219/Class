package model;

public class Student {
	
	private String code;
	private String name;
	
	private Student next;
	private Student prev;


public Student(String code, String name) {
	this.code = code;
	this.name = name;
}


public String getCode() {
	return code;
}

public void setCode(String code) {
	this.code = code;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Student getNext() {
	return next;
}

public void setNext(Student next) {
	this.next = next;
}

public Student getPrev() {
	return prev;
}

public void setPrev(Student prev) {
	this.prev = prev;
}

public String toString() {
	String message = "Code: "+code+" Name: "+name;
	return message;
}


}
