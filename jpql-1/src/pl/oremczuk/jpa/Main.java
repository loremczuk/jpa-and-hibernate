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

		entityManager.createQuery(
				"SELECT e FROM Employee e WHERE e.lastName = 'Ziomecki' ",
				Employee.class);
		TypedQuery<Employee> query = entityManager.createQuery(
				"SELECT e FROM Employee e WHERE e.lastName = 'Ziomecki' ",
				Employee.class);
//		query.getSingleResult();
//		Employee employee = query.getSingleResult();
//		System.out.println(employee.getFirstName());
//		System.out.println(employee.getLastName());
//		System.out.println(employee.getSalary());
		
		query.getResultList();
		List<Employee> employeeList = query.getResultList();
		for (Employee employee : employeeList) {
			System.out.println(employee.getFirstName());
			System.out.println(employee.getLastName());
			System.out.println(employee.getSalary());
		}
		
		
//		entityManager.createQuery("select concat(e.firstName, ' ', e.lastName), e.salary from Employee e where e.salary > 4000 order by e.salary");
//		Query query = entityManager.createQuery("select concat(e.firstName, ' ', e.lastName), e.salary from Employee e where e.salary > 4000 order by e.salary");
//		
//		query.getResultList().iterator();
//		Iterator<?> iterator = query.getResultList().iterator();
//		
//		while (iterator.hasNext()) {
//			Object[] item = (Object []) iterator.next();
//			String name = (String) item[0];
//			double salary = (double) item[1];
//			System.out.println(name + " zarabia: " + salary);
//		}
			
		

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
