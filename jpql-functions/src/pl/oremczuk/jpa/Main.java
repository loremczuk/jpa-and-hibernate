package pl.oremczuk.jpa;

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

		Query query = entityManager.createQuery(
				"select avg(e.salary), sum(e.salary), min(e.salary), max(e.salary), count(e) from Employee e");
		Object[] objectTable = (Object[]) query.getSingleResult();
		System.out.println("Œrednia pensja: " + objectTable[0]);
		System.out.println("Suma wszystkich zarobków: " + objectTable[1]);
		System.out.println("Najni¿sza pensja: " + objectTable[2]);
		System.out.println("Najwy¿sza pensja: " + objectTable[3]);
		System.out.println("Liczba pracowników: " + objectTable[4]);

		Query query2 = entityManager.createQuery(
				"select substring(e.lastName, 1,5), trim(e.lastName), lower(e.lastName), upper(e.lastName), length(e.lastName) from Employee e where e.lastName = 'Brzmichrz¹szcz'");
		Object[] resultTable = (Object[]) query2.getSingleResult();
		System.out.println("Pierwsze 5 liter: " + resultTable[0]);
		System.out.println("Bez spacji: |" + resultTable[1] + "|");
		System.out.println("Ma³ymi literami: " + resultTable[2]);
		System.out.println("Du¿ymi literami: " + resultTable[3]);
		System.out.println("Liczba znaków: " + resultTable[4]);

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
