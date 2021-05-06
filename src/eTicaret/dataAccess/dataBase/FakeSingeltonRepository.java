package eTicaret.dataAccess.dataBase;

import java.util.ArrayList;
import java.util.List;

import eTicaret.entities.concretes.User;

public class FakeSingeltonRepository {
	private static FakeSingeltonRepository instance = null;

	private  ArrayList<User> users=null;

	private  FakeSingeltonRepository() {
		users = new ArrayList<User>();
		System.out.println("newlendi");
	}

	public static FakeSingeltonRepository getInstance() {
		if (instance == null) {
			instance = new FakeSingeltonRepository();
		}
		
		return instance;
	}

	public ArrayList<User> getArray() {
		return this.users;
	}

	// Add element to array
	public void addToArray(User value) {
		users.add(value);
	}
	
	public User get(int id) {
		for(User user : users) {
			if(user.getId()==id) {
				return user;
			}
		}
		
		return null;
	}

}
