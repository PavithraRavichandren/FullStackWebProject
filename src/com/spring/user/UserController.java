package com.spring.user;

import com.spring.user.UserDAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes({ "user" })
public class UserController {
	// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	private UserDAO userDAO;

	private HttpSession session;

	@RequestMapping("/submitPatient")
	public ModelAndView submitPatient(@RequestParam("fullname") String fullname, @RequestParam("dob") String dob,
			@RequestParam("height") Integer height, @RequestParam("weight") Integer weight,
			@RequestParam("bloodGroup") String bloodGroup, @RequestParam("cholesterol") Integer cholesterol,
			@RequestParam("pressure") Integer pressure, @RequestParam("sugar") Integer sugar,
			@RequestParam("conditions") String conditions, @RequestParam("symptoms") String symptoms,
			@RequestParam("Gender") String gender, @RequestParam("tobacco") String tobacco,
			@RequestParam("drugs") String drugs, @RequestParam("alcohol") String alcohol,
			@RequestParam("purpose1") String purpose1, @RequestParam("medication1") String medication1,
			@RequestParam("hospital1") String hospital1, @RequestParam("purpose2") String purpose2,
			@RequestParam("medication2") String medication2, @RequestParam("hospital2") String hospital2,
			@RequestParam("purpose3") String purpose3, @RequestParam("medication3") String medication3,
			@RequestParam("hospital3") String hospital3, @RequestParam("purpose4") String purpose4,
			@RequestParam("medication4") String medication4, @RequestParam("hospital4") String hospital4,
			@RequestParam("date1") String date1, @RequestParam("date2") String date2,
			@RequestParam("date3") String date3, @RequestParam("date4") String date4,
			@RequestParam("comments") String comments, @ModelAttribute User user) throws ParseException {
		java.sql.Date td1 = null;
		java.sql.Date td2 = null;
		java.sql.Date td3 = null;
		java.sql.Date td4 = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dateOfBirth = sdf.parse(dob);
		java.sql.Date date = new java.sql.Date(dateOfBirth.getTime());
		if (date1 != "") {
			java.util.Date d1 = sdf.parse(date1);
			td1 = new java.sql.Date(d1.getTime());
		}

		if (date2 != "") {
			java.util.Date d2 = sdf.parse(date2);
			td2 = new java.sql.Date(d2.getTime());
		}
		if (date3 != "") {
			java.util.Date d3 = sdf.parse(date3);
			td3 = new java.sql.Date(d3.getTime());
		}
		if (date4 != "") {
			java.util.Date d4 = sdf.parse(date4);
			td4 = new java.sql.Date(d4.getTime());
		}
		MedicalHistory medicalHistory = new MedicalHistory(fullname, date, height, weight, bloodGroup, cholesterol,
				pressure, sugar, conditions, symptoms, gender, tobacco, drugs, alcohol, comments, user);

		ArrayList<Medication> list = new ArrayList<Medication>();
		if ((purpose1 != "") && (medication1 != "") && (hospital1 != "") && (date1 != ""))
			list.add(new Medication(purpose1, medication1, hospital1, td1, medicalHistory, user));
		if ((purpose2 != "") && (medication2 != "") && (hospital2 != "") && (date2 != ""))
			list.add(new Medication(purpose2, medication2, hospital2, td2, medicalHistory, user));
		if ((purpose3 != "") && (medication3 != "") && (hospital3 != "") && (date3 != ""))
			list.add(new Medication(purpose3, medication3, hospital3, td3, medicalHistory, user));
		if ((purpose4 != "") && (medication4 != "") && (hospital4 != "") && (date4 != ""))
			list.add(new Medication(purpose4, medication4, hospital4, td4, medicalHistory, user));

		System.out.println(conditions);
		userDAO.insertMedicalHistory(medicalHistory, list);
		return new ModelAndView("home");
	}

	@RequestMapping("/emergency")
	public ModelAndView emergency(@ModelAttribute User user,ModelMap modelMap) {
		List<Hospital> list = (List<Hospital>) userDAO.getAllHospitals();
		modelMap.addAttribute("list", list);
		return new ModelAndView("emergency");
	}

	@RequestMapping("/index")
	public String index() {
		// System.out.println("ControllerUser");
		return "index";
	}

	@RequestMapping("/home")
	public String home() {
		// System.out.println("ControllerUser");
		return "home";
	}

	@RequestMapping("/signup")
	public String signup() {
		// System.out.println("ControllerUser");
		return "signup";
	}

	@RequestMapping("/hospitalHome")
	public ModelAndView hospitalLogin(@ModelAttribute User user) {
		Hospital hospital = userDAO.getHospital(user);
		return new ModelAndView("hospitalHome", "Hospital", hospital);
	}

	@RequestMapping("/hospitalLogin")
	public ModelAndView hospitalLogin(@RequestParam("hospital_name") String hospital_name,
			@RequestParam("hospital_address") String hospital_address,
			@RequestParam("hospital_email") String hospital_email,
			@RequestParam("hospital_number") String hospital_number, @ModelAttribute User user) {
		String[] arr = hospital_address.split(",");
		Address address1 = new Address(arr[0], arr[1], arr[2], arr[3], Long.parseLong(arr[4]));
		// User user = (User) request.getAttribute("user");
		// User user = userDAO.getLastUser();
		Hospital hospital = new Hospital(hospital_name, hospital_email, hospital_number, address1, user);
		userDAO.insertHospital(hospital);
		return new ModelAndView("hospitalHome", "Hospital", hospital);
	}

	@RequestMapping("/insertUser")
	public ModelAndView signup(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("role") String role, @RequestParam("password") String password,
			@RequestParam("mobile") String mobile, @RequestParam("address") String address, ModelMap modelMap,HttpServletRequest request) {
		String[] arr = address.split(",");
		Address address1 = new Address(arr[0], arr[1], arr[2], arr[3], Long.parseLong(arr[4]));
		User user = new User(name, email, role, password, mobile, address1);
		User u = userDAO.checkUser(name, password);
		if (u == null) {
			userDAO.insertUser(user);
			session = request.getSession();
			session.setAttribute("loginStatus", "true");
			session.setAttribute("user", user);
			return new ModelAndView("redirect:enterRole.do","user",user);
		}else {
			return new ModelAndView("login", "error","You Already Have an account...Please try again with other email!");
		}
	}
	
	@RequestMapping("/checkLogin")
	public ModelAndView checkLogin(@RequestParam("name") String name, @RequestParam("password") String password,
		ModelMap modelMap, HttpServletRequest request) {
		User user = userDAO.checkUser(name, password);
		if (user == null) {
			return new ModelAndView("login", "error", "UserName or Password may be wrong!!");
		} 
		else {
			session = request.getSession();
			session.setAttribute("loginStatus", "true");
			session.setAttribute("user", user);
			return new ModelAndView("redirect:checkRole.do","user",user);
			
		}
	}

	@RequestMapping("/getAllPatients")
	public ModelAndView getAllPatients(@ModelAttribute User user) {

		Hospital h = userDAO.getHospital(user);
		@SuppressWarnings("unchecked")
		List<Medication> list = (List<Medication>) userDAO.getAllPatients(h);
		return new ModelAndView("getAllPatients", "list", list);
	}
	@RequestMapping("/getEmergencyRequest")
	public ModelAndView getEmergencyRequest()
	{
		User user = (User) session.getAttribute("user");
		Hospital hospital = userDAO.getHospital(user);
		@SuppressWarnings("unchecked")
		List<Emergency> list1 = userDAO.getEmergencyRequest(hospital);
		@SuppressWarnings("unchecked")
		List<MedicalHistory> list = (List<MedicalHistory>) userDAO.getEmergencyMedication(list1);
		Set<MedicalHistory> set = new HashSet<MedicalHistory>(list);
		List list2 = new ArrayList(set);
		return new ModelAndView("emergencyDisplay", "list", list2);
	}
	
	@RequestMapping(value = "/requestEmergency", method=RequestMethod.POST)
	public ModelAndView requestEmergency(@RequestParam("id")String id)
	{
		Integer i = Integer.parseInt(id);
		User user = (User) session.getAttribute("user");
		MedicalHistory m = userDAO.getMedicalByUser(user);
		Emergency e  = userDAO.getEmergencyByUser(user);
		if(e!=null){
			String name = e.getHospital().getHospitalName();
			String error = "An emergency request has been sent already to "+name;
			return new ModelAndView("home","error",error);
		}
		if(m!=null)
		{
		Hospital hospital = userDAO.getHospitalById(i);
		userDAO.insertEmergencyRequest(hospital,user);
		String error = "An emergency request has been to "+hospital.getHospitalName();
		return new ModelAndView("home","error",error);
		}
		else
			return new ModelAndView("home","error","First upload your medical history");
	}
	@RequestMapping("/getPatientByDate")
	public ModelAndView getPatientByDate(@ModelAttribute User user, @RequestParam("date") String date)
			throws ParseException {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date td1 = null;
		Hospital h = userDAO.getHospital(user);
		// java.sql.Date d = (Date) sdf.parse(date);
		java.util.Date d1 = sdf1.parse(date);
		td1 = new java.sql.Date(d1.getTime());
		@SuppressWarnings("unchecked")
		List<Medication> list = (List<Medication>) userDAO.getPatientByDate(h, td1);
		return new ModelAndView("getAllPatients", "list", list);
	}

	
	
	@RequestMapping("/login")
	public String login() {
		// System.out.println("ControllerUser");
		return "login";
	}

	@RequestMapping("/getPatientByName")
	public ModelAndView getPatientByName(@RequestParam("name") String name, @ModelAttribute User user) {
		Hospital hospital = userDAO.getHospital(user);
		List<Medication> list = (List<Medication>) userDAO.getPatientByName(hospital, name);
		return new ModelAndView("getAllPatients", "list", list);
	}

	@RequestMapping("/getPatientById")
	public ModelAndView getPatientById(@RequestParam("id") String id, @ModelAttribute User user)
			throws NumberFormatException {
		Hospital hospital = userDAO.getHospital(user);
		Integer p_id = Integer.parseInt(id);
		@SuppressWarnings("unchecked")
		List<Medication> list = (List<Medication>) userDAO.getPatientById(hospital, p_id);
		return new ModelAndView("getAllPatients", "list", list);
	}
	@RequestMapping("/enterRole")
	public ModelAndView enterRole(HttpServletRequest request,@ModelAttribute User user)
	{
		if (user.getRole().equals("patient")) {
			return new ModelAndView("home");
		} else if (user.getRole().equals("medical_staff")) {
			return new ModelAndView("hospital","user",user);
		}
		else
			return new ModelAndView("index");
	}

	@RequestMapping("/checkRole")
	public ModelAndView checkRole(@ModelAttribute User user,HttpServletRequest request,ModelMap modelMap)
	{
		
		modelMap.addAttribute(user);
		if (user.getRole().equals("patient")) {
			return new ModelAndView("home");
		} else if (user.getRole().equals("medical_staff")) {
			// Hospital hospital = userDAO.getHospital(u.getId());
			Hospital hospital = userDAO.getHospital(user);
			if (hospital != null) {
				return new ModelAndView("hospitalHome", "Hospital", hospital);
			} else {
				return new ModelAndView("index");
			}
		} else {
			return new ModelAndView("login", "error", "UserName or Password may be wrong!!");
		}
		
	}

	@RequestMapping("/patientform")
	public String patientform() {
		return "patientform";
	}

	@RequestMapping("/UploadMedicalHistory")
	public String UploadMedicalHistory(@ModelAttribute User user) {

		Boolean b = userDAO.checkPatientRecord(user);
		if (b == true)
			return "patientform";
		else
			return "errorupload";
	}
	@RequestMapping("/deleteEmergency")
	public ModelAndView deleteEmergency(@RequestParam("id")String id,ModelMap modelMap)
	{
		Integer i = Integer.parseInt(id);
		userDAO.deleteEmergency(i);
		return new ModelAndView("redirect:getEmergencyRequest.do");
	}
	
	@RequestMapping("/deleteEmergencyByUser")
	public ModelAndView deleteEmergencyByUser(ModelMap modelMap)
	{
		//Integer i = Integer.parseInt(id);
		User user = (User) session.getAttribute("user");  
		Boolean b = userDAO.checkRequest(user);
		if(b) {
			userDAO.deleteEmergency(user.getId());
			modelMap.addAttribute("error", "Request Cancelled Successfully!");
			return new ModelAndView("home","error","Request Cancelled Successfully!");
		}else {
			
			modelMap.addAttribute("error", "Request Cancelled Successfully!");
			return new ModelAndView("home","error","No request has been made to this hospital");
		}
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView invalidate(@ModelAttribute User user) {
		session.invalidate();
		System.out.println(session == null);
		return new ModelAndView("index");
	}
}