package hello;
import java.util.LinkedList;
import java.util.List;

public class Usuario {
	
	private String userName;
	private String password;
	
	public Usuario(String userName, String password, String name, int ra,
			String institution, String course, int year, int period) {

		this.userName = userName;
		this.password = password;
		
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
	
	
}
