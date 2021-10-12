package br.com.projetoxp.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Styles {
	
	private String description;
	private List<Selections> selections;
	private Long style;
	
	public Styles() {
		super();
	}

	public Styles(String description, List<Selections> selections, Long style) {
		super();
		this.description = description;
		this.selections = selections;
		this.style = style;
	}
	
	public String getDescription() {
		return description;
	}
	public List<Selections> getSelections() {
		return selections;
	}
	public Long getStyle() {
		return style;
	}
	
}
