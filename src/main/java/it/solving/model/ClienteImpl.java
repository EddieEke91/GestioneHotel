package it.solving.model;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.stereotype.Service;

import it.solving.dao.Dao;

@Service
public class ClienteImpl implements ClienteServiceImpl {

    public void insertCliente(String nome, String cognome) {

	Dao dao = new Dao();

	EntityManagerFactory entityManagerFactory = dao.getEntityManagerFactory();

	EntityManager entityManager = entityManagerFactory.createEntityManager();

	entityManager.getTransaction().begin();

	Cliente nuovoCliente = new Cliente(nome, cognome);

	entityManager.persist(nuovoCliente);

	entityManager.getTransaction().commit();
	entityManager.close();

    }

    public Cliente selectCliente(int id) {
	Cliente result = null;

	Dao dao = new Dao();

	EntityManagerFactory entityManagerFactory = dao.getEntityManagerFactory();

	EntityManager entityManager = entityManagerFactory.createEntityManager();

	entityManager.getTransaction().begin();
	try {
	    ArrayList<Cliente> resultLista = (ArrayList<Cliente>) entityManager.createNamedQuery("cliente.findById")
		    .setParameter("paramId", id).getResultList();

	    if (resultLista.get(0) != null) {
		Cliente result2 = resultLista.get(0);
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

    public boolean updateCliente(int id, String nome, String cognome) {

	boolean trovato = false;

	Dao dao = new Dao();

	EntityManagerFactory entityManagerFactory = dao.getEntityManagerFactory();

	EntityManager entityManager = entityManagerFactory.createEntityManager();

	entityManager.getTransaction().begin();

	try {

	    entityManager.createNativeQuery("UPDATE cliente a SET a.nome = :paramNome WHERE a.idDevice = :paramId ")
		    .setParameter("paramQuantita", nome).setParameter("paramId", id).executeUpdate();

	    trovato = true;
	} catch (final Exception ignore) {

	}

	entityManager.getTransaction().commit();
	entityManager.close();

	return trovato;
    }

    @Override
    public boolean deleteCliente(int id) {

	boolean trovato = false;

	Dao dao = new Dao();

	EntityManagerFactory entityManagerFactory = dao.getEntityManagerFactory();

	EntityManager entityManager = entityManagerFactory.createEntityManager();

	entityManager.getTransaction().begin();

//	try {
	ArrayList<Cliente> resultLista = (ArrayList<Cliente>) entityManager.createNamedQuery("cliente.findById")
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
