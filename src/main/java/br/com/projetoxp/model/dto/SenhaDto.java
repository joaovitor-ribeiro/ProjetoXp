package br.com.projetoxp.model.dto;

public class SenhaDto {
	private String senhaAntiga;
	private String senhaNova;
	
	public SenhaDto(String senhaAntiga, String senhaNova) {
		super();
		this.senhaAntiga = senhaAntiga;
		this.senhaNova = senhaNova;
	}
	
	public SenhaDto() {
	}

	public String getSenhaAntiga() {
		return senhaAntiga;
	}

	public void setSenhaAntiga(String senhaAntiga) {
		this.senhaAntiga = senhaAntiga;
	}

	public String getSenhaNova() {
		return senhaNova;
	}

	public void setSenhaNova(String senhaNova) {
		this.senhaNova = senhaNova;
	}
		
}
