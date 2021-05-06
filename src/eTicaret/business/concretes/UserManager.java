package eTicaret.business.concretes;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eTicaret.business.abstracts.UserService;
import eTicaret.dataAccess.abstracts.UserDao;
import eTicaret.entities.concretes.User;

public class UserManager implements UserService{

	private UserDao userDao;
	
	public UserManager(UserDao userDao) {
		this.userDao=userDao;
	}
	
	@Override
	public boolean add(User user) {
		Scanner scan=new Scanner(System.in);
		if(checkUser(user)) {
			System.out.println("Bu kullanıcı zaten kayitli!!");
			return false;
		}
		if(!checkRegisterRequeriment(user)) {
			return false;
		}
		System.out.println("E ticaret sistemimize sizin mail adresinizden kayıt olundu . Eğer kayit islemini onaylamak istiyorsaniz \n 1  basarak linke tıklayın onaylamıyorsanız herhangi bir tusa basiniz !! \n");
		int request = scan.nextInt();
		scan.nextLine();
		if(request==1) {
			userDao.add(user);
			return true;
		}else {
			System.out.println("KAyit islemi basarisiz linke tiklamadiniz");
			return false;
		}
		
	}

	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User get(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean login(String email, String password) {
		
		User user = userDao.get(email);
		if(user == null) {
			System.out.println("Böyle bir kullanıcı mevcut degi!!");
			return false;
		}
		
		if(user.getEmail().equals(email)&&user.getPassword().equals(password)) {
			System.out.println("Sisteme giriş yapıldı hos geldiniz "+user.getFirstName()+" "+user.getLatName());
			return true;
		}
		else {
			System.out.println("Kullanici adi yada sifre hatali!!");
		}
		
		return false;
	}
	
	
	private boolean checkUser(User user) {
		
		ArrayList<User> users= userDao.getAll();
		
		for(User item :users) {
			if(item.getEmail().equals(user.getEmail())) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean checkRegisterRequeriment(User user) {
		
		Pattern p=Pattern.compile("^(.+)@(.+)$");
		Matcher m = p.matcher(user.getEmail());
		if(!m.matches()) {
			System.out.println("Gecerli formatta bir email giriniz!!! \n ex: asjsadn@sdasda.com\n");
			return false;
		}
		
		if(user.getPassword().length()<6) {
			System.out.println("Parolaniz en az 6 karakter olmali");
			return false;
		}
		
		
		return true;
	}

	

	
}
