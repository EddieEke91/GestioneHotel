package it.solving.model;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.stereotype.Service;

import it.solving.dao.Dao;

@Service
public class StanzaImpl implements StanzaServiceImpl {

    public static boolean contains(String test) {
	for (Tipologia c : Tipologia.values()) {
	    if (c.name().equalsIgnoreCase(test)) {
		return true;
	    }
	}

	return false;
    }

    public void insertStanza(int nStanza) {
	Dao dao = new Dao();

	EntityManagerFactory entityManagerFactory = dao.getEntityManagerFactory();

	EntityManager entityManager = entityManagerFactory.createEntityManager();

	entityManager.getTransaction().begin();

	Stanza nuovaStanza = new Stanza(nStanza);

	entityManager.persist(nuovaStanza);

	entityManager.getTransaction().commit();
	entityManager.close();

    }

    public Stanza selectStanza(int id) {
	Stanza result = null;

	Dao dao = new Dao();

	EntityManagerFactory entityManagerFactory = dao.getEntityManagerFactory();

	EntityManager entityManager = entityManagerFactory.createEntityManager();

	entityManager.getTransaction().begin();
	try {
	    ArrayList<Stanza> resultLista = (ArrayList<Stanza>) entityManager.createNamedQuery("stanza.findById")
		    .setParameter("paramId", id).getResultList();

	    if (resultLista.get(0) != null) {
		Stanza result2 = resultLista.get(0);
		result = result2;
	    }

	}

	catch (final Exception ignore) {

	    return null;
	}
	entityManager.getTransaction().commit();
	entityManager.close();

	return result;
    }

    public boolean updateStanza(int id, int nStanza) {

	boolean trovato = false;

	Dao dao = new Dao();

	EntityManagerFactory entityManagerFactory = dao.getEntityManagerFactory();

	EntityManager entityManager = entityManagerFactory.createEntityManager();

	entityManager.getTransaction().begin();

	try {

	    entityManager.createNativeQuery("UPDATE stanza a SET a.nStanza = :paramNStanza WHERE a.id = :paramId ")
		    .setParameter("paramNStanza", nStanza).setParameter("paramId", id).executeUpdate();

	    trovato = true;
	} catch (final Exception ignore) {

	}

	entityManager.getTransaction().commit();
	entityManager.close();

	return trovato;
    }

    @Override
    public boolean deleteStanza(int id) {

	boolean trovato = false;

	Dao dao = new Dao();

	EntityManagerFactory entityManagerFactory = dao.getEntityManagerFactory();

	EntityManager entityManager = entityManagerFactory.createEntityManager();

	entityManager.getTransaction().begin();

//	try {
	ArrayList<Stanza> resultLista = (ArrayList<Stanza>) entityManager.createNamedQuery("stanza.findById")
		.setParameter("paramId", id).getResultList();

//	    if (resultLista.get(0) != null) {
	trovato = true;

	entityManager.remove(resultLista.get(0));
//	    }
	entityManager.getTransaction().commit();
	entityManager.close();

//	} catch (final Exception ignore) {
//	}
	return trovato;

    }

}
