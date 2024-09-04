package com.knowtheyselfweb.Know_Thyself_WEB;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {
	
	@GetMapping("/")
	public String home( Model model) {

		return "index.html";
	}
	
	@GetMapping("/about")
	public String about(Model model) {
		
		return "about.html";
	}
	
	@GetMapping("/error")
	public String error( Model model) {
		
		return "error";
	}
	
	@GetMapping("/test")
	public String test( Model model) {
		
		return "bootstraptest.html";
	}
	
	@GetMapping("/play")
	public ModelAndView displayStory() {
		
		ModelAndView mv = new ModelAndView();
		
		ArrayList<String> test = new ArrayList<>();
		test.add("test 1");
		test.add("test 2");
		test.add("test 3");
		test.add("test 4 test 4 test 4 test 4 test 4 test 4 test 4");
		
		mv.addObject("scene_desc", "this is where scenario desc is displayed");
		mv.addObject("options", test);
		mv.addObject("result", "this is where the result of an option is displayed if applicable");
		mv.setViewName("play");
		return mv;
	}

	
}
