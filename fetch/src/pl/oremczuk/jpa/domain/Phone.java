package pl.oremczuk.jpa.domain;

import javax.persistence.*;

@Entity
public class Phone {

	@Id
	@GeneratedValue
	private long ID;
	
	private String type;
	private String phoneNumber;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public long getID() {
		return ID;
	}
	
	
	
}
