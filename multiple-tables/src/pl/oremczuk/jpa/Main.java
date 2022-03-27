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
		employee.setFirstName("Mietek");
		employee.setLastName("Zbuczyn");
		employee.setSalary(5000);
		employee.setLocality("Lublin");
		employee.setZipCode("20-554");
		employee.setStreet("U³anów");
		employee.setStreetNumber(16);

		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();

	}

}
