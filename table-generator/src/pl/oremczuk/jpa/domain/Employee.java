package pl.oremczuk.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class Employee {

	@Id
	@TableGenerator (
			name = "mojGenerator",
			table = "tabela_sekwencji_identyfikatorów",
			pkColumnName = "nazwa_sekwencji",
			valueColumnName = "wartosc_identyfikatora",
			pkColumnValue = "id_pracownika",
			initialValue = 2,
			allocationSize = 15
			)
	@GeneratedValue (strategy = GenerationType.TABLE, generator = "mojGenerator")
	private long ID;
	private String firstName;
	private String lastName;
	private double salary;

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
