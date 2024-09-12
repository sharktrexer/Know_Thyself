package com.knowtheyselfweb.Know_Thyself_WEB.models;

import java.util.List;

public class Option {
	private String 		desc;		  // What the option is
	private String 		pointsToID;   // What scenario, by id, the option will take the player to
	private List<String> tags;		  // What tags the user receives upon choosing this option, if applicable
	private Alignment 	alignment;    // What alignment this option increases, if applicable
	private List<String> tagsRequired; // What tags this options requires the user to have
	private String 		resultDesc;   // What directly results from the option after picking it
	private boolean		isShown;      // If option is not meant to purely point to next scene.
	
	public String getDesc() {
		return desc;
	}

	public String getPointsToID() {
		return pointsToID;
	}

	public List<String> getTags() {
		return tags;
	}

	public Alignment getAlignment() {
		return alignment;
	}

	public List<String> getTagsRequired() {
		return tagsRequired;
	}

	public String getResultDesc() {
		return resultDesc;
	}

	public boolean isShown() {
		return isShown;
	}

	// Empty option
	public Option() {
		this.desc 		  = "";
		this.tags 		  =	null;
		this.alignment 	  =	null;
		this.tagsRequired = null;
		this.resultDesc   = "";
		this.isShown	  = false;
	}
	
	// For a parent option that only leads into child options. Has no tags, alignment, condition, or resulting text
	public Option(String desc, String pointsToID) {
		this.desc 		  =	desc;
		this.pointsToID   = pointsToID;
		this.tags 		  = null;
		this.alignment    = null;
		this.tagsRequired = null;
		this.resultDesc   = "";
		this.isShown	  = true;
	}
	
	// For a conditional child option. Only appears if user has appropriate tags
	public Option(String desc, String pointsToID, List<String> tags, Alignment alignment, List<String> tagsRequired, String resultDesc) {
		this.desc 		  = desc;
		this.pointsToID   = pointsToID;
		this.tags 		  = tags;
		this.alignment 	  = alignment;
		this.tagsRequired = tagsRequired;
		this.resultDesc   = resultDesc;
		this.isShown	  = true;
	}
	
	
	// For an unconditional child option. Will always be visible.
	public Option(String desc, String pointsToID, List<String> tags, Alignment alignment, String resultDesc) {
		this.desc 		  = desc;
		this.pointsToID   = pointsToID;
		this.tags 		  = tags;
		this.alignment 	  = alignment;
		this.tagsRequired = null;
		this.resultDesc   = resultDesc;
		this.isShown	  = true;
	}
	
	// For a transitional option. It won't be displayed to the user, and is thus differentiated from parent option constructor using boolean
	// otherwise ambiguity error occurs if tagsRequired is null
	public Option(List<String> tagsRequired, String pointsToID, boolean isShown) {
		this.desc 		  = "";
		this.pointsToID   = pointsToID;
		this.tags 		  = null;
		this.alignment    = null;
		this.tagsRequired = tagsRequired;
		this.resultDesc   = "";
		this.isShown	  = false;
	}

	@Override
	public String toString() {
		return desc ;
	}
	
	
}
