package pl.oremczuk.jpa.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Project {

	@Id
	@GeneratedValue
	private long id;

	private String name;

	@ManyToMany
	@JoinTable(
			name = "Pracownicy_w_projektach", 
			joinColumns = {@JoinColumn(name = "id_projektu")}, 
			inverseJoinColumns = {@JoinColumn(name = "id_pracownika")}
			)
	private List<Employee> employees;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployee() {
		return employees;
	}

	public void setEmployee(List<Employee> employee) {
		this.employees = employee;
	}

	public long getId() {
		return id;
	}

}
