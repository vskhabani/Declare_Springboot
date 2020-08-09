package declare.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import declare.Services.AuthService;

@Controller
public class SignupController {
	@Autowired
	private AuthService authService;

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String showLoginPage() {
		return "signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String handleUserLogin(ModelMap model, @RequestParam String email, @RequestParam String password,
			@RequestParam String confirmPassword, @RequestParam String firstName, @RequestParam String lastName) {
		return null;
//
//		if (!authService.validateEmail(email)) {
//			model.put("errorMessage", "Please Enter Valid Email");
//			return "signup";
//		} else if (!authService.validatePassword(password, confirmPassword)) {
//			model.put("errorMessage", "Passwords Do not match !!!!  ");
//			return "signup";
//		} else {
//			model.put("mail", mail);
//			model.put("first_name", fname);
//			model.put("last_name", lname);
//
//			return "welcome";
	}
}
