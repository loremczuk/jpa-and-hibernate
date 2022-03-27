package pl.oremczuk.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class DateTime {
	
	
	@Id
	private long ID;


	private java.sql.Date date;
	private java.sql.Time time;
	private java.sql.Timestamp timestamp;

	@Temporal(TemporalType.TIME)
	private java.util.Date utilDate;
	@Temporal(TemporalType.DATE)
	private java.util.Calendar calendar;
	
	public void setID(long iD) {
		ID = iD;
	}

	public java.util.Date getUtilDate2() {
		return utilDate2;
	}

	public void setUtilDate2(java.util.Date utilDate2) {
		this.utilDate2 = utilDate2;
	}

	public java.util.Calendar getCalendar2() {
		return calendar2;
	}

	public void setCalendar2(java.util.Calendar calendar2) {
		this.calendar2 = calendar2;
	}

	public long getID() {
		return ID;
	}

	private java.util.Date utilDate2;
	private java.util.Calendar calendar2;

	public java.sql.Date getDate() {
		return date;
	}

	public void setDate(java.sql.Date date) {
		this.date = date;
	}

	public java.sql.Time getTime() {
		return time;
	}

	public void setTime(java.sql.Time time) {
		this.time = time;
	}

	public java.sql.Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(java.sql.Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public java.util.Date getUtilDate() {
		return utilDate;
	}

	public void setUtilDate(java.util.Date utilDate) {
		this.utilDate = utilDate;
	}

	public java.util.Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(java.util.Calendar calendar) {
		this.calendar = calendar;
	}

}
