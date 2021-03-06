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
		employee.setFirstName("Gienek");
		employee.setLastName("Ziomecki");
		employee.setSalary(5500);

		entityManager.getTransaction().begin();
		entityManager.persist(employee);

		entityManager.getTransaction().commit();

		System.out.println(employee.getFirstName());
		System.out.println(employee.getLastName());
		System.out.println(employee.getSalary());
		System.out.println(employee.getTax());

		entityManager.refresh(employee);
		System.out.println(employee.getFirstName());
		System.out.println(employee.getLastName());
		System.out.println(employee.getSalary());
		System.out.println(employee.getTax());

		entityManager.close();
		entityManagerFactory.close();

	}

}
