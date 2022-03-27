package pl.oremczuk.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String args[]) {

		Persistence.createEntityManagerFactory("mojabaza");
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mojabaza");
		entityManagerFactory.createEntityManager();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.close();
		entityManagerFactory.close();

	}

}

