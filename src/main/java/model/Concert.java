package model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author  Andrew Steele aeste - aesteele
 * CIS175 - Fall 2021
 * Feb 26, 2023
 */
@Entity
@Table(name = "concert")
public class Concert {
	
	@Id
	@GeneratedValue
	private int id;
	private Venue locationName;
	private String bandName;
	private String bandDescription;
	private LocalDate concertDate;

	public Concert() {
		super();
	}

	public Concert(Venue locationName, String bandName, String bandDescription, LocalDate concertDate) {
		super();
		this.locationName = locationName;
		this.bandName = bandName;
		this.bandDescription = bandDescription;
		this.concertDate = concertDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Venue getLocationName() {
		return locationName;
	}

	public void setLocationName(Venue locationName) {
		this.locationName = locationName;
	}

	public String getBandName() {
		return bandName;
	}

	public void setBandName(String bandName) {
		this.bandName = bandName;
	}

	public String getBandDescription() {
		return bandDescription;
	}

	public void setBandDescription(String bandDescription) {
		this.bandDescription = bandDescription;
	}

	public LocalDate getConcertDate() {
		return concertDate;
	}

	public void setConcertDate(LocalDate concertDate) {
		this.concertDate = concertDate;
	}

	@Override
	public String toString() {
		return "Concert [id=" + id + ", locationName=" + locationName + ", bandName=" + bandName + ", bandDescription="
				+ bandDescription + ", concertDate=" + concertDate + "]";
	}
	
	
}
