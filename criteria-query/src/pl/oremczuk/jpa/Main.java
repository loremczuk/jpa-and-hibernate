package pl.oremczuk.jpa;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import pl.oremczuk.jpa.domain.Employee;

public class Main {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;

	public static void main(String args[]) {

		entityManagerFactory = Persistence.createEntityManagerFactory("mojabaza");
		entityManager = entityManagerFactory.createEntityManager();

		addEmployees();

		// select e from Employee e where e.salary>3000 and e.salary<5000
		// zarówno pêtla for each jak i stream zwracaj¹ wyniki tyle razy ile jest rekordów w tabeli (10), nie wiem dlaczego
		
		entityManager.getCriteriaBuilder();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		
		builder.createQuery(Employee.class);
		CriteriaQuery<Employee> criteriaQuery = builder.createQuery(Employee.class);
		
		criteriaQuery.from(Employee.class);
		Root<Employee> employee = criteriaQuery.from(Employee.class);
		
		employee.get("salary");
		Path<Double> salary = employee.get("salary");
		
//		criteriaQuery.select(employee).where(builder.greaterThan(salary, 3000.00));
//		criteriaQuery.select(employee).where(builder.and(builder.greaterThan(salary,3000.00), builder.lessThan(salary, 5000.00)));
		criteriaQuery.select(employee).where(builder.between(salary,3000.00,5000.00));
		
		entityManager.createQuery(criteriaQuery);
		TypedQuery<Employee> query = entityManager.createQuery(criteriaQuery);
		
		query.getResultList();
		List<Employee> employees = query.getResultList();
		
//		for (Employee emp : employees) {
//			System.out.println(emp.getFirstName());
//			System.out.println(emp.getLastName());
//			System.out.println(emp.getSalary());
//			System.out.println();
//		}
		
		employees.forEach(e -> System.out.println(e.getFirstName() + "\n" + e.getLastName() + "\n" + e.getSalary() + "\n"));

		// zarówno pêtla for each jak i stream zwracaj¹ wyniki tyle razy ile jest rekordów w tabeli (10), nie wiem dlaczego
		

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
