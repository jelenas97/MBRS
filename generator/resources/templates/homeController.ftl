package mbrs.tim2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class HomeController {

	@GetMapping(value = { "/", "/home" })
	public String homePage() {
		return "home";
	}
}