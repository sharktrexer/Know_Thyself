package com.knowtheyselfweb.Know_Thyself_WEB;

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
	
	@GetMapping("/play")
	public String play( Model model) {
		model.addAttribute("scene_desc", "this is where scenario desc is displayed");
		model.addAttribute("options", "this is where each option is displayed");
		model.addAttribute("result", "this is where the result of an option is displayed if applicable");
		return "play.html";
	}
	
	@GetMapping("/play1")
	public ModelAndView displayStory() {
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("scene_desc", "this is where scenario desc is displayed");
		mv.addObject("options", "this is where each option is displayed");
		mv.addObject("result", "this is where the result of an option is displayed if applicable");
		mv.setViewName("play");
		return mv;
	}

	
}
