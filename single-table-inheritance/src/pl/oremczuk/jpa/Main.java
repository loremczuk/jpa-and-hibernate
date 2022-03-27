package pl.oremczuk.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pl.oremczuk.jpa.domain.Professor;
import pl.oremczuk.jpa.domain.Student;

public class Main {

	public static void main(String args[]) {

		Persistence.createEntityManagerFactory("mojabaza");
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mojabaza");
		entityManagerFactory.createEntityManager();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Professor profesor = new Professor();
		profesor.setFirstName("Joachim");
		profesor.setLastName("Go³¹bek");
		profesor.setSalary(5500.00);

		Student student = new Student();
		student.setFirstName("Borys");
		student.setLastName("Gorza³a");
		student.setAverageGrade(3.55);

		entityManager.getTransaction().begin();
		entityManager.persist(profesor);
		entityManager.persist(student);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();

	}

}
