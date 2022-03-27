package pl.oremczuk.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pl.oremczuk.jpa.domain.Employee;
import pl.oremczuk.jpa.domain.Phone;

public class Fetch {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;

	public static void main(String args[]) {

		entityManagerFactory = Persistence.createEntityManagerFactory("mojabaza");
		entityManager = entityManagerFactory.createEntityManager();

		Employee employee = entityManager.find(Employee.class, 1L);
		List<Phone> phones = employee.getPhones();
		System.out.println(phones);
		
		entityManager.close();
		entityManagerFactory.close();

	}

}
