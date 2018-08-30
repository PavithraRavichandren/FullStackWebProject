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
@Table(name="Emergency")
public class Emergency implements Serializable{
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id")
    private Integer id;
	public Emergency(Integer id, User patient, Hospital hospital) {
		super();
		this.id = id;
		this.patient = patient;
		this.hospital = hospital;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@ManyToOne
	@ForeignKey(name="patient")
	@Autowired
    private User patient;
	@ManyToOne
	@ForeignKey(name="hospital")
	private Hospital hospital;
	public Emergency() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Emergency(User patient, Hospital hospital) {
		super();
		this.patient = patient;
		this.hospital = hospital;
	}
	public User getPatient() {
		return patient;
	}
	public void setPatient(User patient) {
		this.patient = patient;
	}
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
}
