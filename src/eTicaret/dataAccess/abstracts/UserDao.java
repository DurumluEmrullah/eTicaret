package eTicaret.dataAccess.abstracts;

import java.util.ArrayList;

import eTicaret.entities.concretes.User;

public interface UserDao {
	
	void add(User user);
	void delete(User user);
	void update(User user);
	User get(String email);
	ArrayList<User> getAll();
}
