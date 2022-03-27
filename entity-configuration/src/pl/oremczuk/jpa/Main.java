package pl.oremczuk.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pl.oremczuk.jpa.domain.Employee;

public class Main {

	public static void main(String args[]) {

		Persistence.createEntityManagerFactory("mojabaza");
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mojabaza");
		entityManagerFactory.createEntityManager();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Employee employee = new Employee();
		// employee.setID(1L);
		employee.setFirstName("W³adek");
		employee.setLastName("Kolano");
		employee.setSalary(3534.50);
		
		Employee employee2 = new Employee();
		// employee2.setID(2L);
		employee2.setFirstName("Gienio");
		employee2.setLastName("Burak");
		employee2.setSalary(2546.85);
		
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.persist(employee2);
		entityManager.getTransaction().commit();
		
		
		entityManager.close();
		entityManagerFactory.close();

	}

}
