package sg.edu.iss.caps.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.caps.model.RoleType;
import sg.edu.iss.caps.model.User;
import sg.edu.iss.caps.service.interfaces.IUser;

@Controller
@RequestMapping()
public class AccountController {

//	@Autowired private IStudent studentService;
//	@Autowired private ILecturer lecturerService;
//	@Autowired private IAdmin adminService;
	@Autowired private IUser userService;
	
	@Autowired
	public void setAccount(IUser uService) {
		this.userService = uService;
	}
	
	@GetMapping("/login")
	public String login() {
		
		return "LoginPage";
	}

	@PostMapping("/authenticate")
	public String authenticate(@Valid String email, String password, String identity, HttpSession session, Model model) {

		User user = userService.findUser(email, password, identity);

		if(user != null) {
			session.setAttribute("user", user);
			//session.getAttribute("user");
			//model.addAttribute(user);
			return "Profile";
//			if(user.getRole() == RoleType.STUDENT)
//				return "student/student-profile";
//			else if(user.getRole() == RoleType.LECTURER)
//				return "lecturer/lecturer-profile";
//			else
//				return "admin/admin-profile";
		}
		return "LoginPage";
	}
	
	@GetMapping("/logout")
	public String logout() {
		
		
		return "LoginPage";
	}
	
}
