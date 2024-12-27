package codingtechniques.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Student {
	
	private @Id @GeneratedValue Long id;
	private String firstName;
	private String lastName;
	private String department;
	
	public Student() {
		super();
	}

	public Student(String firstName, String lastName, String department) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	
	
	

}
