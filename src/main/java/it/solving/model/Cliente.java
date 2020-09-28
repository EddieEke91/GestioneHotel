package it.solving.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
//nn  uso @NamedQuery(name = "updateDevice", query = "UPDATE a  myentity set quantita=?, marca=? Where id=?")
@NamedQuery(name = "cliente.findById", query = "SELECT a FROM Cliente a WHERE a.id = :paramId ")

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Prenotazione> prenotazioni;

    public Cliente() {
    }

    public Cliente(String nome, String cognome) {
	this.nome = nome;
	this.cognome = cognome;

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

    public String getCognome() {
	return cognome;
    }

    public void setCognome(String cognome) {
	this.cognome = cognome;
    }

    public List<Prenotazione> getPrenotazione() {
	return prenotazioni;
    }

    public void setPrenotazione(List<Prenotazione> prenotazioni) {
	this.prenotazioni = prenotazioni;
    }

}
