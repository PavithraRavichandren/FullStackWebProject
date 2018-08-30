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
@Table(name="Hospital")
public class Hospital implements Serializable{
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Integer id;
	@Column(name = "hospitalName")
    private String hospitalName;
	@Column(name = "hospitalEmail")
    private String hospitalEmail;
	@Column(name="mobile")
	private String mobile;
	@ManyToOne
	@ForeignKey(name="address")
	@Autowired
    private Address address;
	
	@ManyToOne
	@ForeignKey(name="user")
	@Autowired
	private User user;
    
	public Hospital() {}
	 
	public Hospital(Integer id, String hospitalName, String hospitalEmail, String mobile, Address address, User user) {
		super();
		this.id = id;
		this.hospitalName = hospitalName;
		this.hospitalEmail = hospitalEmail;
		this.mobile = mobile;
		this.address = address;
		this.user = user;
	}

	public Hospital(String hospitalName, String hospitalEmail, String mobile, Address address, User user) {
		super();
		this.hospitalName = hospitalName;
		this.hospitalEmail = hospitalEmail;
		this.mobile = mobile;
		this.address = address;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getHospitalEmail() {
		return hospitalEmail;
	}

	public void setHospitalEmail(String hospitalEmail) {
		this.hospitalEmail = hospitalEmail;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}