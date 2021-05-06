package eTicaret.business.abstracts;

import java.util.ArrayList;

import eTicaret.entities.concretes.User;

public interface UserService {
	
	boolean add(User user);
	boolean update(User user);
	boolean delete(User user);
	boolean login(String email,String password);
	User get(String email);
	ArrayList<User> getAll();

}
