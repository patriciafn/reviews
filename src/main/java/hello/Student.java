package hello;



import java.util.LinkedList;
import java.util.List;

public class Student {
	
	private String userName;
	private String password;
	private int question;
	
	
	
	public Student(String userName, String password, int question) {
		this.userName = userName;
		this.password = password;
		this.question = question;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getQuestion() {
		return question;
	}
	public void setQuestion(int question) {
		this.question = question;
	}
	
	
	
	
	
	
}
