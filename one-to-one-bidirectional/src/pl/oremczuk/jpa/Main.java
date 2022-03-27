package pl.oremczuk.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pl.oremczuk.jpa.domain.Cat;
import pl.oremczuk.jpa.domain.Owner;

public class Main {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;

	public static void main(String args[]) {

		entityManagerFactory = Persistence.createEntityManagerFactory("mojabaza");
		entityManager = entityManagerFactory.createEntityManager();

		Owner owner = new Owner();
		Cat cat = new Cat();

		owner.setFirstName("Mietek");
		owner.setLastName("Warzywo");
		owner.setCat(cat);

		cat.setName("Filemon");
		
		

		entityManager.getTransaction().begin();
		entityManager.persist(owner);
		entityManager.persist(cat);
		entityManager.getTransaction().commit();

		entityManager.refresh(cat);

		entityManager.close();
		entityManagerFactory.close();

	}

}
