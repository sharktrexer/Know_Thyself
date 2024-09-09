package com.knowtheyselfweb.Know_Thyself_WEB.models;

import java.util.List;

public class Scenario {
	private String 		id;	     // Unique name for scenario for options to reference
	private String 		desc;    // What the scenario is about
	private List<Option> options; // What options the user can take from this scene
	
	public String getId() {
		return id;
	}

	public String getDesc() {
		return desc;
	}

	public List<Option> getOptions() {
		return options;
	}

	// Empty Scenario
	public Scenario() {
		this.id           = "";          
		this.desc         = "";        
		this.options      = null;  
	}
	
	// Standard Scenario
	public Scenario(String id, String desc, List<Option> options) {
		this.id           = id;          
		this.desc         = desc;        
		this.options      = options;     
	}  
}
