package it.solving.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "stanza")
//nn  uso @NamedQuery(name = "updateDevice", query = "UPDATE a  myentity set quantita=?, marca=? Where id=?")
@NamedQuery(name = "stanza.findById", query = "SELECT a FROM Stanza a WHERE a.id = :paramId ")

public class Stanza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nStanza")
    private int nStanza;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private Tipologia tipo;

    @OneToMany(mappedBy = "stanza", cascade = CascadeType.ALL)
    private List<Prenotazione> prenotazioni;

    @ManyToOne
    @JoinColumn(name = "idHotel")
    private Hotel hotel;

    public Stanza() {
    }

    public Stanza(int nStanza) {
	this.nStanza = nStanza;

    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public int getnStanza() {
	return nStanza;
    }

    public void setnStanza(int nStanza) {
	this.nStanza = nStanza;
    }

    public Tipologia getTipo() {
	return tipo;
    }

    public void setTipo(Tipologia tipo) {
	this.tipo = tipo;
    }

    public List<Prenotazione> getPrenotazioni() {
	return prenotazioni;
    }

    public void setPrenotazioni(List<Prenotazione> prenotazioni) {
	this.prenotazioni = prenotazioni;
    }

    public Hotel getHotel() {
	return hotel;
    }

    public void setHotel(Hotel hotel) {
	this.hotel = hotel;
    }

}
