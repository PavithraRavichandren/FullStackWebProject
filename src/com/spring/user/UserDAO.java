package com.spring.user;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service

public class UserDAO {
	
	Criteria criteria = null;
	@Autowired
	public SessionFactory sessionFactory;
	@Transactional 
	public void insertUser(User user)
	{
		Address address = user.getAddress();
		criteria = sessionFactory.getCurrentSession().createCriteria(Address.class);
		criteria.add(Restrictions.eq("streetNumber", address.getStreetNumber()));
		criteria.add(Restrictions.eq("area", address.getArea()));
		criteria.add(Restrictions.eq("city", address.getCity()));
		criteria.add(Restrictions.eq("location", address.getLocation()));
		criteria.add(Restrictions.eq("pincode",address.getPincode()));
		Address a = (Address) criteria.uniqueResult();
		if(a!=null)
		{
			user.setAddress(a);
			sessionFactory.getCurrentSession().save(user);
		}
		else
		{
			sessionFactory.getCurrentSession().save(address);
			sessionFactory.getCurrentSession().save(user);
		}
		
		
	}
	@Transactional
	public void insertEmergencyRequest(Hospital h,User u)
	{
		Emergency e = new Emergency(u,h);
		sessionFactory.getCurrentSession().save(e);
	}
	@Autowired
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public User checkUser(String name,String password)
	{
		 criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("userName", name));
		criteria.add(Restrictions.eq("password",password));
		return (User)criteria.uniqueResult();
	}
	
	@Transactional
	public void insertMedicalHistory(MedicalHistory medicalHistory,List<Medication> list)
	{
		for(Medication m:list)
		sessionFactory.getCurrentSession().saveOrUpdate(m);
		sessionFactory.getCurrentSession().saveOrUpdate(medicalHistory);
	}
	
	@Transactional
	public void insertMedication(Medication medication)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(medication);
	}
	@Transactional
	public void insertHospital(Hospital hospital)
	{
		Address address = hospital.getAddress();
		User user = hospital.getUser();
		sessionFactory.getCurrentSession().saveOrUpdate(address);
		sessionFactory.getCurrentSession().saveOrUpdate(hospital);
	}
	@Transactional
	public Hospital getHospital(User user)
	{
		criteria = sessionFactory.getCurrentSession().createCriteria(Hospital.class);
		criteria.add(Restrictions.eq("user", user));
		return (Hospital) criteria.uniqueResult();
	}
	@Transactional
	public Boolean checkPatientRecord(User user)
	{
		criteria = sessionFactory.getCurrentSession().createCriteria(MedicalHistory.class);
		criteria.add(Restrictions.eq("user", user));
	    List patientRecordList = criteria.list();
	//	MedicalHistory medicalHistory = (MedicalHistory) criteria.uniqueResult();
		if(patientRecordList.isEmpty())
			return true;
		else
			return false;
	}
   @Transactional
	public List getPatientByDate(Hospital hospital,java.sql.Date d)
	{
		criteria = sessionFactory.getCurrentSession().createCriteria(Medication.class);
		criteria.add(Restrictions.eq("hospitalName", hospital.getHospitalName()));
		criteria.add(Restrictions.eq("treatmentDate", d));
		System.out.println(d);
		return criteria.list();
	}
   @Transactional
   public List getPatientByName(Hospital hospital,String name)
   {
	   criteria = sessionFactory.getCurrentSession().createCriteria(Medication.class).createAlias("medicalHistory","medicalHistory")
			   .add(Restrictions.eq("medicalHistory.fullName", name));
	   criteria.add(Restrictions.eq("hospitalName", hospital.getHospitalName()));
	   return criteria.list();
   }
   @Transactional
   public List getPatientById(Hospital hospital,Integer id)
   {
	   
	   criteria = sessionFactory.getCurrentSession().createCriteria(Medication.class).createAlias("user","user");
			   criteria.add(Restrictions.eq("hospitalName", hospital.getHospitalName()));
			   criteria.add(Restrictions.eq("user.id", id));
	 
	   return criteria.list();

   }
	@SuppressWarnings("unchecked")
	@Transactional 
	public List getAllPatients(Hospital hospital)
	{
		/*criteria = sessionFactory.getCurrentSession().createCriteria(Hospital.class);
		criteria.add(Restrictions.eq("user", user));*/
		criteria = sessionFactory.getCurrentSession().createCriteria(Medication.class);
		criteria.add(Restrictions.eq("hospitalName", hospital.getHospitalName()));
		return  criteria.list();
	}
	@Transactional
	public List getAllHospitals()
	{
		criteria = sessionFactory.getCurrentSession().createCriteria(Hospital.class);
		return criteria.list();
	}
	@Transactional
	public Hospital getHospitalById(Integer id)
	{
		criteria = sessionFactory.getCurrentSession().createCriteria(Hospital.class);
		criteria.add(Restrictions.eq("id", id));
		return (Hospital) criteria.uniqueResult();
	}
	@Transactional
	public List getEmergencyRequest(Hospital h)
	{
		criteria = sessionFactory.getCurrentSession().createCriteria(Emergency.class);
		criteria.add(Restrictions.eq("hospital",h));
		return criteria.list();
	}
	@Transactional
	public List getEmergencyMedication(List<Emergency> list)
	{
		List<MedicalHistory> list1 = new ArrayList<MedicalHistory>();
		for(Emergency e: list)
		{
			criteria = sessionFactory.getCurrentSession().createCriteria(MedicalHistory.class);
			criteria.add(Restrictions.eq("user", e.getPatient()));
			list1.addAll((List<MedicalHistory>) criteria.list());
		}
		return list1;
	}
	
	@Transactional
	public MedicalHistory getMedicalByUser(User user)
	{
		criteria = sessionFactory.getCurrentSession().createCriteria(MedicalHistory.class);
		criteria.add(Restrictions.eq("user", user));
		return (MedicalHistory) criteria.uniqueResult();
	}
	@Transactional
	public Emergency getEmergencyByUser(User user)
	{
		criteria = sessionFactory.getCurrentSession().createCriteria(Emergency.class);
		criteria.add(Restrictions.eq("patient", user));
		return (Emergency) criteria.uniqueResult();
	}
	@Transactional
	public void deleteEmergency(Integer id)
	{
		criteria = sessionFactory.getCurrentSession().createCriteria(Emergency.class).createAlias("patient", "patient");
		Emergency e = (Emergency) criteria.add(Restrictions.eq("patient.id", id)).uniqueResult();
		sessionFactory.getCurrentSession().delete(e);
	}
	@SuppressWarnings("unused")
	@Transactional
	public Boolean checkRequest(User user)
	{
		criteria = sessionFactory.getCurrentSession().createCriteria(Emergency.class);
		criteria.add(Restrictions.eq("patient", user));
		Emergency e = (Emergency) criteria.uniqueResult();
		if(e!=null)
			return true;
		else if(e==null)
			return false;
		return false;
	}
}
