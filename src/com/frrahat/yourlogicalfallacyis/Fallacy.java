package com.frrahat.yourlogicalfallacyis;

/**
 * @author Rahat
 * @since Dec 26, 2016
 */
public class Fallacy {
	private String name;
	private String iconFileString;
	
	private String definition;
	private String source;
	private String example;
	private String note;
	
	

	public Fallacy(String name, String definition,
			String source, String example) {
		this.name = name;
		this.iconFileString = "icon_"+name.replaceAll(" ", "_")
				.replaceAll("-", "_")
				.replaceAll("/", "_")
				.replaceAll("'", "");
		this.definition = definition;
		this.source = source;
		this.example = example;
	}

	public String getName() {
		return name;
	}

	public String getIconFileString() {
		return iconFileString;
	}

	public String getDefinition() {
		return definition;
	}

	public String getSource() {
		return source;
	}

	public String getExample() {
		return example;
	}

	public String getNote() {
		return note;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setIconFileString(String iconFileString) {
		this.iconFileString = iconFileString;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public void setExample(String example) {
		this.example = example;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	
}
