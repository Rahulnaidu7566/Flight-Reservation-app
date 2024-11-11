package com.flight_reservation_app_6.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flight_reservation_app_6.entity.USER;
import com.flight_reservation_app_6.repository.userrepository;

@Controller
public class UserController {
    
	@RequestMapping("/showLoginPage")
	public String showLoginPage() {
		return "login/login";
	}

	
	@Autowired
	private userrepository userRepo;
	@RequestMapping("/showReg")
	public String showReg() {
		return "login/showReg";
	}
	@RequestMapping("/saveReg")
	public String saveReg(@ModelAttribute("user") USER user)  { 
		
      	userRepo.save(user);
		return "login/login";
	}
	@RequestMapping("/verifyLogin")
	public String verifyLogin(@RequestParam("email")String email, @RequestParam("password")String password,ModelMap modelMap ) {
		USER user = userRepo.findByEmail(email);
		if(user!=null) {
		if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
        	return "findFlights";
        }else {
        	modelMap.addAttribute("error","invalid username/password");
        	return "login/login";
        }
		}else {
			modelMap.addAttribute("error","invalid username/password");
        	return "login/login";
	}
}
}
