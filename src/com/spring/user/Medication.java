package com.spring.user;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ForeignKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Medication")
public class Medication {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	@Column(name="purpose")
	private String purpose;
	@Column(name="medications")
	private String medications;
	@Column(name="hospitalName")
	private String hospitalName;
	
	@Column(name="treatmentDate")
	private Date treatmentDate;	
	
	@Autowired
	@ManyToOne
	@ForeignKey(name="medicalHistory")
	MedicalHistory medicalHistory;
	
	@Autowired
	@ManyToOne
	@ForeignKey(name="user")
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getMedications() {
		return medications;
	}
	@Override
	public String toString() {
		return "Medication [purpose=" + purpose + ", medications=" + medications + ", hospitalName=" + hospitalName
				+ ", treatmentDate=" + treatmentDate + ", medicalHistory=" + medicalHistory + "]";
	}
	public void setMedications(String medications) {
		this.medications = medications;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public Date getTreatmentDate() {
		return treatmentDate;
	}
	public void setTreatmentDate(Date treatmentDate) {
		this.treatmentDate = treatmentDate;
	}
	public MedicalHistory getMedicalHistory() {
		return medicalHistory;
	}
	public void setMedicalHistory(MedicalHistory medicalHistory) {
		this.medicalHistory = medicalHistory;
	}
	public Medication(Integer id, String purpose, String medications, String hospitalName, Date treatmentDate,
			MedicalHistory medicalHistory,User user) {
		super();
		this.id = id;
		this.purpose = purpose;
		this.medications = medications;
		this.hospitalName = hospitalName;
		this.treatmentDate = treatmentDate;
		this.medicalHistory = medicalHistory;
		this.user = user;
	}
	public Medication() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Medication(String purpose, String medications, String hospitalName, Date treatmentDate,
			MedicalHistory medicalHistory,User user) {
		super();
		this.purpose = purpose;
		this.medications = medications;
		this.hospitalName = hospitalName;
		this.treatmentDate = treatmentDate;
		this.medicalHistory = medicalHistory;
		this.user = user;
	}
	

}
