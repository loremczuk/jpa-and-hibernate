package pl.oremczuk.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pl.oremczuk.jpa.domain.Employee;
import pl.oremczuk.jpa.domain.Phone;

public class Main {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;

	public static void main(String args[]) {

		entityManagerFactory = Persistence.createEntityManagerFactory("mojabaza");
		entityManager = entityManagerFactory.createEntityManager();

		Employee employee = new Employee();
		Phone phone = new Phone();
		Phone phone2 = new Phone();

		employee.setFirstName("Kazio");
		employee.setLastName("Mamrot");
		employee.setSalary(3500.00);

		phone.setType("mobile");
		phone.setPhoneNumber("546 456 987");
		phone2.setType("home");
		phone2.setPhoneNumber("543 123 321");

		List<Phone> phoneList = new ArrayList<>();
		phoneList.add(phone);
		phoneList.add(phone2);

		employee.setPhones(phoneList);

		entityManager.getTransaction().begin();
		entityManager.persist(employee);
//		entityManager.persist(phone);
//		entityManager.persist(phone2);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();

	}

}
