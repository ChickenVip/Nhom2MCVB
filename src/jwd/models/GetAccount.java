package jwd.models;

public class GetAccount {

	String user, pass, perid;
	int role;

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getPerid() {
		return perid;
	}

	public void setPerid(String perid) {
		this.perid = perid;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public GetAccount (String perid,String user, String pass, int role) {
		this.perid = perid;
		this.user = user;
		this.pass = pass;
		this.role = role;
	}
}
