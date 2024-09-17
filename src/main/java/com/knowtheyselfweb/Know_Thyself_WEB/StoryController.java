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
import com.knowthyselfweb.Know_Thyself_WEB.services.StoryTrackerService;

@Controller

public class StoryController {
	
	//TODO turn into dependency injections
	StoryService story = new StoryService();
	StoryTrackerService storyCon = new StoryTrackerService(story.getStory());
	
	@GetMapping("/playStart")
	public String startStory(Model model) {
		
		Scenario beginning = storyCon.GetCurrentScene();
		
		model.addAttribute("scene_desc", beginning.getDesc());
		model.addAttribute("options", beginning.getOptions());
		
		return "play.html";
	}
	
	@GetMapping("/play1")
	public String displayNextScene(@RequestParam(required = true) String radioOp, Model model) {
		
		// Get option index from radio form input
		int option = Integer.parseInt(radioOp.substring(6, radioOp.length()));
		System.out.println(option);
		
		/*
		 * If radioOp empty: get 1st scenario
		 * otherwise use radioOp to choose an option and get the scenario it points to
		 * display scenario data
		 * consequences of option needs to be displayed somehow, with chosen option being saved and used to display next scenario
		*/
		//System.out.println(radioOp);
		
		return "play.html";
	}
	
}
