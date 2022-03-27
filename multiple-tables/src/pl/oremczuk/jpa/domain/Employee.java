package pl.oremczuk.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name = "Pracownicy")
@SecondaryTable(name = "Adresy", pkJoinColumns = @PrimaryKeyJoinColumn(name = "idPracownika"))
public class Employee {

	@Id
	@GeneratedValue
	private long ID;

	@Column(name = "Imie")
	private String firstName;
	@Column(name = "Nazwisko")
	private String lastName;
	@Column(name = "Pensja")
	private int salary;

	@Column(table = "Adresy", name = "Miejscowoœæ")
	private String locality;
	@Column(table = "Adresy", name = "KodPocztowy")
	private String zipCode;
	@Column(table = "Adresy", name = "Ulica")
	private String street;
	@Column(table = "Adresy", name = "NumerUlicy")
	private int streetNumber;

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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	public long getID() {
		return ID;
	}

}
