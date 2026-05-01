package com.restapi.SmartContactManager.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.restapi.SmartContactManager.dao.UserRepository;
import com.restapi.SmartContactManager.entities.User;
import com.restapi.SmartContactManager.helper.Message;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("title", "Home-Smart Contact Manger");
		return "home";
	}

    @GetMapping("/signin")
         public String login(Model model) {
         model.addAttribute("title", "Login Page");
         return "login";
}
	@GetMapping("/about")
	public String about(Model model) {
		model.addAttribute("title", "About - Smart Contact Manger");
		return "about";
	}

	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("title", "Register - Smart Contact Manger");
		model.addAttribute("user", new User());
		return "signup";
	}

	// this handler for register user
	@PostMapping("/do_register")
public String registerUser(@Valid @ModelAttribute("user") User user,
                           BindingResult result1,
                           @RequestParam(value = "agreement", defaultValue = "false") boolean agreement,
                           Model model,
                           HttpSession session) {

    try {

        if (!agreement) {
            throw new Exception("Please accept terms and conditions");
        }

        if (result1.hasErrors()) {
            model.addAttribute("user", user);
            return "signup";
        }

        user.setRole("ROLE_USER");
        user.setEnable(true);
        user.setImageUrl("default.png");

        // 🔥 STEP 1: raw password save karo
        String rawPassword = user.getPassword();

        // 🔐 STEP 2: encode password
        user.setPassword(passwordEncoder.encode(rawPassword));

        // 💾 STEP 3: save user
        this.userRepository.save(user);

        // 🖥️ STEP 4: terminal me print karo
        System.out.println("========= LOGIN DETAILS =========");
        System.out.println("Username (Email): " + user.getEmail());
        System.out.println("Password: " + rawPassword);
        System.out.println("=================================");

        session.setAttribute("message",
                new Message("Successfully Registered !!", "alert-success"));
        session.removeAttribute("message");
        return "redirect:/signin";

    } catch (Exception e) {

        e.printStackTrace();

        model.addAttribute("user", user);

        session.setAttribute("message",
                new Message("Error: " + e.getMessage(), "alert-danger"));

        return "signup";
    }
}
}
