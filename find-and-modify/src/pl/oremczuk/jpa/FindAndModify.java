package pl.oremczuk.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pl.oremczuk.jpa.domain.Employee;

public class FindAndModify {

	public static void main(String args[]) {

		Persistence.createEntityManagerFactory("mojabaza");
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mojabaza");
		entityManagerFactory.createEntityManager();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		entityManager.find(Employee.class, 1L);
		Employee employee = entityManager.find(Employee.class, 1L);
		System.out.println("First name: " + employee.getFirstName());
		System.out.println("Last name: " + employee.getLastName());
		System.out.println("Salary: " + employee.getSalary());
		
		employee.setSalary(5000.00);
		
		entityManager.getTransaction().commit();
		
		
		entityManager.close();
		entityManagerFactory.close();

	}

}
