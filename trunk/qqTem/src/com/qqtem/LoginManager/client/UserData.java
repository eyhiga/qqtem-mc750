package com.qqtem.LoginManager.client;

public class UserData {
	final static int NORMAL = 0;
	final static int ADMIN = 1;
	final static int BANNED = 2; 
	
	
	public UserData(int id,String name, String login,boolean male, int state) {
		super();
		this.name = name;
		this.login = login;
		this.state = state;
		this.setMale(male);
	}
	
	private int id;
	private String name;
	private String login;
	private int state;
	private boolean male;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isMale() {
		return male;
	}
	public void setMale(boolean male) {
		this.male = male;
	}
	
	
}
