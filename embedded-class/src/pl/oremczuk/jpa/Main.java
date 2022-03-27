package pl.oremczuk.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pl.oremczuk.jpa.domain.Address;
import pl.oremczuk.jpa.domain.Employee;

public class Main {

	public static void main(String args[]) {

		Persistence.createEntityManagerFactory("my_database");
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my_database");
		entityManagerFactory.createEntityManager();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Employee employee = new Employee();
		Address address = new Address();

		employee.setFirstName("Wie�czys�aw");
		employee.setLastName("Brzmichrz�szcz");
		employee.setSalary(10000);
		employee.setAddress(address);

		address.setLocality("Krzczon�w");
		address.setZipCode("10-001");
		address.setStreet("Konstantynopolita�czykowianecz�teczka");
		address.setStreetNumber(13);

		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();

	}

}
