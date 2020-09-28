package it.solving.model;

public enum Tipologia {

    SINGOLA("SINGOLA"), DOPPIA("DOPPIA"), TRIPLA("TRIPLA");

    private String nome;

    Tipologia(String nome) {
	this.nome = nome;
    }

    Tipologia() {
	// TODO Auto-generated constructor stub
    }

    public String getNome() {
	return nome;
    }

}
