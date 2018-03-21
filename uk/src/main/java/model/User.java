package model;

import java.util.Date;

public class User {
	private String id;
	private String name;
	private String psw;
	private String nickname;
	private int rank;
	private int remark;
	private String phone;//注册号码
	private String email;
	private String signtime;
	private String lastLogin;
	private int isForbit;
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", psw=" + psw
				+ ", nickname=" + nickname + ", rank=" + rank + ", remark="
				+ remark + ", phone=" + phone + ", email=" + email
				+ ", signtime=" + signtime + ", lastLogin=" + lastLogin
				+ ", isForbit=" + isForbit + "]";
	}

	public int getIsForbit() {
		return isForbit;
	}

	public void setIsForbit(int isForbit) {
		this.isForbit = isForbit;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getRemark() {
		return remark;
	}

	public void setRemark(int remark) {
		this.remark = remark;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSigntime() {
		return signtime;
	}

	public void setSigntime(String signtime) {
		this.signtime = signtime;
	}

	/**
	 * @param id
	 * @param name
	 * @param psw
	 * @param nickname
	 * @param rank
	 * @param remark
	 * @param phone
	 * @param email
	 * @param signtime
	 * @param lastLogin
	 * @param isForbit
	 */
	public User(String id, String name, String psw, String nickname, int rank,
			int remark, String phone, String email, String signtime,
			String lastLogin, int isForbit) {
		super();
		this.id = id;
		this.name = name;
		this.psw = psw;
		this.nickname = nickname;
		this.rank = rank;
		this.remark = remark;
		this.phone = phone;
		this.email = email;
		this.signtime = signtime;
		this.lastLogin = lastLogin;
		this.isForbit = isForbit;
	}

	/**
	 * 
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}