package pl.oremczuk.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pl.oremczuk.jpa.domain.Employee;
import pl.oremczuk.jpa.domain.Project;


public class Main {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;

	public static void main(String args[]) {

		entityManagerFactory = Persistence.createEntityManagerFactory("mojabaza");
		entityManager = entityManagerFactory.createEntityManager();

		Project project1 = new Project();
		project1.setName("Projekt 1");
		
		Project project2 = new Project();
		project2.setName("Projekt 2");
		
		Project project3 = new Project();
		project3.setName("Projekt 3");
		
		Employee employee1 = new Employee("Jan", "Krn¹brny", 4500.00);
		Employee employee2 = new Employee("W³adek", "Pasikonik", 3500.00);
		Employee employee3 = new Employee("Muniek", "Staszczyk", 6500.00);
		Employee employee4 = new Employee("Ferdynand", "Bia³ow¹s", 1500.00);
		Employee employee5 = new Employee("Oliwier", "£opian", 8000.00);
		Employee employee6 = new Employee("Ivan", "Gro¿ny", 7500.00);
		Employee employee7 = new Employee("Bertold", "Kitel", 2000.00);
		Employee employee8 = new Employee("Mietek", "Zalewa", 2500.00);
		Employee employee9 = new Employee("Artur", "Owczarek", 3000.00);
		
		List<Employee> employeesA = new ArrayList<>();
		employeesA.add(employee1);
		employeesA.add(employee2);
		employeesA.add(employee3);
		employeesA.add(employee9);
		
		List<Employee> employeesB = new ArrayList<>();
		employeesB.add(employee4);
		employeesB.add(employee2);
		employeesB.add(employee5);
		employeesB.add(employee8);
		
		List<Employee> employeesC = new ArrayList<>();
		employeesC.add(employee6);
		employeesC.add(employee1);
		employeesC.add(employee7);
		employeesC.add(employee8);

		project1.setEmployee(employeesA);
		project2.setEmployee(employeesB);
		project3.setEmployee(employeesC);
		
		entityManager.getTransaction().begin();
		entityManager.persist(project1);
		entityManager.persist(project2);
		entityManager.persist(project3);
		entityManager.persist(employee1);
		entityManager.persist(employee2);
		entityManager.persist(employee3);
		entityManager.persist(employee4);
		entityManager.persist(employee5);
		entityManager.persist(employee6);
		entityManager.persist(employee7);
		entityManager.persist(employee8);
		entityManager.persist(employee9);
		entityManager.getTransaction().commit();
		
		
		entityManager.close();
		entityManagerFactory.close();

	}

}
