package com.spring.user;

import java.util.Date;
import java.util.ArrayList;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ForeignKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="MedicalHistory")
public class MedicalHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="fullName")
	private String fullName;
	@Column(name="dateOfBirth")
	private Date dateOfBirth;
	//@Column(name = "dateOfBirth", columnDefinition="DATETIME")
	//@Temporal(TemporalType.TIMESTAMP)
	//private String dateOfBirth;
	//@DateTimeFormat(pattern = "dd-MM-yyyy")
	//private Date dateOfBirth;
	@Override
	public String toString() {
		return "MedicalHistory [fullName=" + fullName + ", dateOfBirth=" + dateOfBirth + ", height=" + height
				+ ", weight=" + weight + ", bloodGroup=" + bloodGroup + ", cholestrol=" + cholestrol + ", pressure="
				+ pressure + ", sugar=" + sugar + ", conditions=" + conditions + ", symptoms=" + symptoms + ", gender="
				+ gender + ", tobacco=" + tobacco + ", drug=" + drug + ", alcohol=" + alcohol + ", comments=" + comments
				+ "]";
	}
	@Column(name="height")
	private Integer height;
	@Column(name="weight")
	private Integer weight;
	@Column(name="bloodGroup")
	private String bloodGroup;
	@Column(name="cholestrol")
	private Integer cholestrol;
	@Column(name="pressure")
	private Integer pressure;
	@Column(name="sugar")
	private Integer sugar;
	@Column(name="conditions")
	private String conditions;
	@Column(name="symptoms")
	private String symptoms;
	@Column(name="gender")
	private String gender;
	@Column(name="tobacco")
	private String tobacco;
	@Column(name="drug")
	private String drug;
	@Column(name="alcohol")
	private String alcohol;
	@Column(name="comments")
	private String comments;
	@ManyToOne
	@ForeignKey(name="user")
	@Autowired
	User user;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public Integer getCholestrol() {
		return cholestrol;
	}
	public void setCholestrol(Integer cholestrol) {
		this.cholestrol = cholestrol;
	}
	public Integer getPressure() {
		return pressure;
	}
	public void setPressure(Integer pressure) {
		this.pressure = pressure;
	}
	public Integer getSugar() {
		return sugar;
	}
	public void setSugar(Integer sugar) {
		this.sugar = sugar;
	}
	public String getConditions() {
		return conditions;
	}
	public void setConditions(String conditions) {
		this.conditions = conditions;
	}
	public String getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTobacco() {
		return tobacco;
	}
	public void setTobacco(String tobacco) {
		this.tobacco = tobacco;
	}
	public String getDrug() {
		return drug;
	}
	public void setDrug(String drug) {
		this.drug = drug;
	}
	public String getAlcohol() {
		return alcohol;
	}
	public void setAlcohol(String alcohol) {
		this.alcohol = alcohol;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public MedicalHistory(Integer id, String fullName, Date dateOfBirth, Integer height, Integer weight,
			String bloodGroup, Integer cholestrol, Integer pressure, Integer sugar, String conditions, String symptoms,
			String gender, String tobacco, String drug, String alcohol, String comments, User user) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.height = height;
		this.weight = weight;
		this.bloodGroup = bloodGroup;
		this.cholestrol = cholestrol;
		this.pressure = pressure;
		this.sugar = sugar;
		this.conditions = conditions;
		this.symptoms = symptoms;
		this.gender = gender;
		this.tobacco = tobacco;
		this.drug = drug;
		this.alcohol = alcohol;
		this.comments = comments;
		this.user = user;
	}
	public MedicalHistory(String fullName, Date dateOfBirth, Integer height, Integer weight, String bloodGroup,
			Integer cholestrol, Integer pressure, Integer sugar, String conditions, String symptoms, String gender,
			String tobacco, String drug, String alcohol, String comments, User user) {
		super();
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.height = height;
		this.weight = weight;
		this.bloodGroup = bloodGroup;
		this.cholestrol = cholestrol;
		this.pressure = pressure;
		this.sugar = sugar;
		this.conditions = conditions;
		this.symptoms = symptoms;
		this.gender = gender;
		this.tobacco = tobacco;
		this.drug = drug;
		this.alcohol = alcohol;
		this.comments = comments;
		this.user = user;
	}
	public MedicalHistory() {
	//	super();
		// TODO Auto-generated constructor stub
	}

	

}
