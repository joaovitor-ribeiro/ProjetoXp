package br.com.projetoxp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Selections {
	
	private int perk;
	private int var1;
	private int var2;
	private int var3;
	
	public Selections() {
		super();
	}
	public Selections(int perk, int var1, int var2, int var3) {
		super();
		this.perk = perk;
		this.var1 = var1;
		this.var2 = var2;
		this.var3 = var3;
	}
	
	public int getPerk() {
		return perk;
	}
	public int getVar1() {
		return var1;
	}
	public int getVar2() {
		return var2;
	}
	public int getVar3() {
		return var3;
	}

}
