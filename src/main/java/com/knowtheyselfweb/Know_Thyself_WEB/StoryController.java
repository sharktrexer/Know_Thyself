package com.knowtheyselfweb.Know_Thyself_WEB;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.knowtheyselfweb.Know_Thyself_WEB.models.Scenario;
import com.knowthyselfweb.Know_Thyself_WEB.services.StoryService;

@Controller

public class StoryController {
	
	//TODO turn into dependency injection
	StoryService service = new StoryService();
	
	//will become dependency injection i guess
	ArrayList<Scenario> scenes = service.getStory();
	
	@GetMapping("/play1")
	public String displayNextScene(@RequestParam(defaultValue = "") String option, Model model) {
		
		
		
		return "play.html";
	}
	
}
