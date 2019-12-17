import java.util.Scanner;
import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
public class User extends Buy_Offer {
	private String name;
	private String pass;
	private String email;
	private String username;
	private String Type;
	private String phoneno;
	public String Username_verify ;
	public String Password_verify ;
	public String type_verify ;
	Controller User_verify = new Controller();

public String getName() {
		return name;
}
	
public void setName(String name) {
		this.name = name;
}

public void setPass(String pass) {
	this.pass = pass;
}

public String getPass() {
		return pass;
}
	
public String getEmail() {
		return email;
}
	
public void setEmail(String email) {
		this.email = email;
}
	
public void setUsername(String username) {
	this.username = username;
}

public String getUsername() {
		return username;
}
	
public String getPhoneno() {
		return phoneno;
}
	
public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
}
public String getType() {
	return Type;
}

public void setType(String type) {
	Type = type;
}

public User login() throws IOException {
	    User u=new User();
		Scanner input1 = new Scanner(System.in);
		System.out.println("Enter Username : ");
		Username_verify = input1.next();
		Scanner input2 = new Scanner(System.in);
	    System.out.println("Enter Password : ");	    
	    Password_verify = input2.next();
	    Scanner input3 = new Scanner(System.in);
		System.out.println("Enter Your type Admin? / Customer? / StoreOwner? ");
		type_verify = input3.next();
		u=User_verify.verify(type_verify,Username_verify,Password_verify);
		if(u!=null) {
			return u;
		}
		return null;
}
	 
public void createaccount() throws IOException{		
		File f = new File("Users.txt");
		System.out.println("Enter username");
		Scanner username = new Scanner(System.in);
		this.setUsername(username.next());
		System.out.println("Enter password");
		Scanner password = new Scanner(System.in);
		this.setPass(password.next());
		System.out.println("Enter Your type Admin? / Customer? / StoreOwner? ");
		Scanner type = new Scanner(System.in);
		this.setType(type.next());
		System.out.println("Enter email");
		Scanner email = new Scanner(System.in);
		this.setEmail(email.next());
		System.out.println("Enter phoneno");
		Scanner phoneno = new Scanner(System.in);
		this.setPhoneno(phoneno.next());
		if(User_verify.verify_Account(getUsername(),getPass())==true) {
		String a[]= {this.getType(), this.getUsername(), this.getPass()};
		Database1.Write(f, a);
		System.out.println("Account Created Successfuly");
		System.out.println("Now You Can Login To Our Stores");
		}
		else
			System.out.println("Account Can't Be Created");
}
	
}