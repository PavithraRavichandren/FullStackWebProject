package com.spring.user;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="User")
public class User implements Serializable{
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id")
    private Integer id;
	@Column(name = "userName")
    private String userName;
	@Column(name = "email")
    private String email;
	@Column(name="role")
	private String role;
	@Column(name="password")
	private String password;
	@Column(name="mobile")
	private String mobile;
	@ManyToOne
	@ForeignKey(name="address")
	@Autowired
    private Address address;
	
    public User() {
	}
	public User(Integer id, String userName, String email,String role,String password,String mobile, Address address) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.role = role;
		this.password = password;
		this.mobile = mobile;
		this.address = address;
	}
	public User(String userName, String email, String role,String password,String mobile, Address address) {
		super();
		this.userName = userName;
		this.email = email;
		this.role = role;
		this.mobile = mobile;
		this.password = password;
		this.address = address;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getUserId() {
		return id;
	}
	public void setUserId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
   
}