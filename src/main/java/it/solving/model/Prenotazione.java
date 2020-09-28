package it.solving.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "prenotazione")
@NamedQuery(name = "prenotazione.findById", query = "SELECT a FROM Prenotazione a WHERE a.id = :paramId ")

public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idStanza")
    private Stanza stanza;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    @Column(name = "dataArrivo")
    private Date dataArrivo;

    @Column(name = "dataPartenza")
    private Date dataPartenza;

    public Prenotazione() {

    }

    public Prenotazione(Cliente cliente, Stanza stanza) {
	this.cliente = cliente;
	this.stanza = stanza;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public Stanza getStanza() {
	return stanza;
    }

    public void setStanza(Stanza stanza) {
	this.stanza = stanza;
    }

    public Cliente getCliente() {
	return cliente;
    }

    public void setCliente(Cliente cliente) {
	this.cliente = cliente;
    }

    public Date getDataArrivo() {
	return dataArrivo;
    }

    public void setDataArrivo(Date dataArrivo) {
	this.dataArrivo = dataArrivo;
    }

    public Date getDataPartenza() {
	return dataPartenza;
    }

    public void setDataPartenza(Date dataPartenza) {
	this.dataPartenza = dataPartenza;
    }

}
