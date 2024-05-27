package org.example.Fremont;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HtmlController {

	@GetMapping("/p0")
	public String displayP0() {
		return "p0";  // This should match the name of your HTML file (without the .html extension)
	}

	@Autowired
	private AuthenticationService authenticationService;

//	@GetMapping("p2")
//	public String showLoginPage(Model model) {
//		model.addAttribute("error", false);
//		return "p2";
//	}
//
//	@PostMapping("/p2")
//	public String login(@RequestParam String username, @RequestParam String password, Model model) {
//
//		if (authenticationService.authenticate(username, password)) {
//			return "redirect:/p7";  // Redirect to a home page after successful login
//	} else {
//			model.addAttribute("error", true);
//			return "p7";
//		}
//	}

	@GetMapping("/p2")
	public String displayP2() {
		return "p2";  // This should match the name of your HTML file (without the .html extension)
	}

	@GetMapping("/p1")
	public String displayP1() {
		return "p1";  // This should match the name of your HTML file (without the .html extension)
	}

//	@GetMapping("/p2")
//	public String displayP2() {
//		return "p2";  // This should match the name of your HTML file (without the .html extension)
//	}

	@GetMapping("/p4")
	public String displayP4() {
		return "p4";  // This should match the name of your HTML file (without the .html extension)
	}

	@GetMapping("/p5")
	public String displayP5() {
		return "p5";  // This should match the name of your HTML file (without the .html extension)
	}
	@GetMapping("/p6")
	public String displayP6() {
		return "p6";  // This should match the name of your HTML file (without the .html extension)
	}
	@GetMapping("/p7")
	public String displayP7() {
		return "p7";  // This should match the name of your HTML file (without the .html extension)
	}
}
