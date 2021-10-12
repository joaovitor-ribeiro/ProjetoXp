package br.com.projetoxp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Match {
	
	private MetaData metadata;
	private Information info;
	
	public Match() {
		super();
	}

	public Match(MetaData metadata, Information info) {
		super();
		this.metadata = metadata;
		this.info = info;
	}
	
	public MetaData getmetadata() {
		return metadata;
	}
	
	public Information getinfo() {
		return info;
	}
	
}
