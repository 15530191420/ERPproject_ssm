package com.tledu.wyb.model;

public class User {
	// private int deptId;
	/**
	 * 所属部门
	 */
	private Dept dept;
	private int id;
	/**
	 * 姓名/用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 昵称
	 */
	private String nickname;

	/**
	 * 1 表示男 0 表示女
	 */
	private int sex;
	private int age;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public User(int id, String username, String password, String nickname,
			int sex, int age) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.sex = sex;
		this.age = age;
	}

	public User(String username, String password, String nickname, int sex,
			int age) {
		super();
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.sex = sex;
		this.age = age;
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public User() {
		super();
	}

	public User( int id, String username, String password,
			String nickname, int sex, int age,Dept dept) {
		super();
		this.dept = dept;
		this.id = id;
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.sex = sex;
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [dept=" + dept + ", id=" + id + ", username=" + username
				+ ", password=" + password + ", nickname=" + nickname
				+ ", sex=" + sex + ", age=" + age + "]";
	}


}
