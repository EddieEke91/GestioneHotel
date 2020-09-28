package it.solving.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Dao {

    private EntityManagerFactory entityManagerFactory;

    public Dao() {

	entityManagerFactory = Persistence.createEntityManagerFactory("gestionehotel");
    }

    public EntityManagerFactory getEntityManagerFactory() {
	if (entityManagerFactory == null) {
	    new Dao();
	}
	return entityManagerFactory;
    }

}
