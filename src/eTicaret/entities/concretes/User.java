package eTicaret.entities.concretes;

import eTicaret.entities.abstracts.Entity;

public class User implements Entity {
	
	private int id;
	private String firstName;
	private String latName;
	private String email;
	private String password;
	public User(int id, String firstName, String latName, String email, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.latName = latName;
		this.email = email;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLatName() {
		return latName;
	}
	public void setLatName(String latName) {
		this.latName = latName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
