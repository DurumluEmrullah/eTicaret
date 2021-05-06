package eTicaret;

import java.util.ArrayList;
import java.util.Scanner;

import eTicaret.business.abstracts.UserService;
import eTicaret.business.concretes.UserManager;
import eTicaret.dataAccess.abstracts.UserDao;
import eTicaret.dataAccess.concretes.FakeUserDao;
import eTicaret.entities.concretes.User;

public class Main {
	public static int id =1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String operations="1-Kayit Ol\n2-Giris yap\n3-Cikis\n";
		Scanner scan=new Scanner(System.in);
		UserService userService = new UserManager(new FakeUserDao());
		System.out.println("Hoşgeldiniz\n");
		System.out.println("***************************************************\n");
		while(true) {
			System.out.println(operations);
			int op =scan.nextInt();
			scan.nextLine();
			switch(op) {
				case 1:
					regType(scan,userService);
					break;
				case 2:
					login(scan,userService);
					break;
				case 3:
					System.out.println("Sistem kapatiliyor....");
					return;
				default:
					System.out.println("Hatali secim yaptiniz!");
					break;
				
			}
			
		}
	}
	
	public static void login(Scanner scanner,UserService userService) {
		System.out.println("Email adresinizi giriniz : ");
		String email=scanner.nextLine();
		System.out.println("Sifrenizi griniz : ");
		String password=scanner.nextLine();
		scanner.nextLine();
		
		userService.login(email, password);
		
		
	}
	
	public static void regType(Scanner scanner,UserService userService) {
		System.out.println("1-Düz kayıt olmak için \n2- Google kayit icin.");
		int regType= scanner.nextInt();
		scanner.nextLine();
		
		if(regType==1) {
			register(scanner,userService);
		}
		else if(regType ==2) {
			registerWithGoogle(scanner,userService);	
		}
		else {
			System.out.println("hatali giris yaptiniz");
		}
	}
	
	public static void registerWithGoogle(Scanner scanner,UserService userService) {
		System.out.println("Google Email adresinizi giriniz : ");
		String email=scanner.nextLine();
		System.out.println("Sifrenizi griniz : ");
		String password=scanner.nextLine();
		scanner.nextLine();
		String name ="Google kullanicisi adi";
		String surname="Google Kullanicisi soyadi";
		User user= new User(id,name,surname,email,password);
		if(userService.add(user)) {
			id++;
			System.out.println("Kayıt işlemi basarili..");
		}
	}
	public static void register(Scanner scanner,UserService userService) {
		
		
		
		System.out.println("Adinizi giriniz:");
		String name = scanner.nextLine();
		System.out.println("Soyadinizi giriniz:");
		String surname=scanner.nextLine();
		System.out.println("Email adresinizi giriniz : ");
		String email=scanner.nextLine();
		System.out.println("Sifrenizi griniz : ");
		String password=scanner.nextLine();
		scanner.nextLine();
		
		User user= new User(id,name,surname,email,password);
		if(userService.add(user)) {
			id++;
			System.out.println("Kayıt işlemi basarili..");
		}
		
	}

}
