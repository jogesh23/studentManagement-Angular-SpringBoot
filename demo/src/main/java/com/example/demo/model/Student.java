package com.example.demo.model;
import javax.persistence.Entity;  
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Table(name="students")
public class Student {
	private long id;
	private String firstName;
	private String lastName;
	private String password;
	
	@Id

	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "first_name", nullable = false)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", nullable = false)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Student() {

	}

	public Student(String firstName, String lastName,String password) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.password = password;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password + "]";
	}
	
}
