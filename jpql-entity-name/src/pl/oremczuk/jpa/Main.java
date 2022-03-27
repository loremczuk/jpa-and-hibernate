package pl.oremczuk.jpa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import pl.oremczuk.jpa.domain.Employee;

public class Main {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;

	public static void main(String args[]) {

		entityManagerFactory = Persistence.createEntityManagerFactory("mojabaza");
		entityManager = entityManagerFactory.createEntityManager();

		addEmployees();

		TypedQuery<Employee> query = entityManager
				.createQuery("select e from pracownik e where e.lastName in :lastNames", Employee.class);
		List<String> names = new ArrayList<>();
		names.add("Ziomecki");
		names.add("Krzak");
		names.add("Brzmichrz¹szcz");
		query.setParameter("lastNames", names);

		query.getResultList().forEach(
				e -> System.out.println(e.getFirstName() + "\n" + e.getLastName() + "\n" + e.getSalary() + "\n"));

		entityManager.close();
		entityManagerFactory.close();

	}

	public static void addEmployees() {
		addEmployee("W³adys³aw", "Ziomecki", 2000.00);
		addEmployee("Henryk", "Gnuœny", 3000.00);
		addEmployee("Iryna", "Dawydow", 4000.00);
		addEmployee("Teodor", "Brzmichrz¹szcz", 1000.00);
		addEmployee("Wac³aw", "Ziomecki", 5000.00);
		addEmployee("Zygmunt", "Fujara", 2500.00);
		addEmployee("Hiacynta", "Kwiat", 3500.00);
		addEmployee("Wirgiliusz", "Onomatopeja", 3200.00);
		addEmployee("Tadeusz", "Rydzyk", 10000.00);
		addEmployee("Wanda", "Krzak", 4750.00);

	}

	public static void addEmployee(String firstName, String lastName, double salary) {
		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setSalary(salary);

		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
	}

}
