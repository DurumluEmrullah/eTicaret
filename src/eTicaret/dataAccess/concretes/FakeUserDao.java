package eTicaret.dataAccess.concretes;

import java.util.ArrayList;

import eTicaret.dataAccess.abstracts.UserDao;
import eTicaret.dataAccess.dataBase.FakeSingeltonRepository;
import eTicaret.entities.concretes.User;

public class FakeUserDao implements UserDao {

	private FakeSingeltonRepository db = FakeSingeltonRepository.getInstance();
	@Override
	public void add(User user) {
		db.addToArray(user);
	}

	@Override
	public void delete(User user) {
		
	}

	@Override
	public void update(User user) {
	
		
	}

	@Override
	public User get(String email) {
		// TODO Auto-generated method stub
		
		for(User user :db.getArray()) {
			if(user.getEmail().equals(email)) {
				return user;
			}
		}
		
		return null;
		
	}

	@Override
	public ArrayList<User> getAll() {
		// TODO Auto-generated method stub
		return db.getArray();
	}

}
