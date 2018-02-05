package br.edu.ifal.proint.model;

public enum Funcao {

	ADMINISTRADOR("Administrador"),
	USUARIO("Usu�rio"),
	PALESTRANTE("Palestrante"),
	VISITANTE("Visitante");
	
	private String descricao;
	
	Funcao(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}
