package it.solving.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    private String nome;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Stanza> stanze;

    public Hotel() {
    }

    public Hotel(String nome) {

    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public List<Stanza> getStanze() {
	return stanze;
    }

    public void setStanze(List<Stanza> stanze) {
	this.stanze = stanze;
    }

}
