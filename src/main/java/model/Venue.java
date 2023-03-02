package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author  Andrew Steele aeste - aesteele
 * CIS175 - Fall 2021
 * Feb 26, 2023
 */

@Entity
@Table(name="venue")
public class Venue {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	@Column(name = "venue_name")
	private String venueName;
	@Column(name = "venueAddress")
	private String venueAddress;

	public Venue() {
		super();
	}

	public Venue(String venueName, String venueAddress) {
		super();
		this.venueName = venueName;
		this.venueAddress = venueAddress;
	}

	public Venue(String venueName) {
		super();
		this.venueName = venueName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVenueName() {
		return venueName;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	public String getVenueAddress() {
		return venueAddress;
	}

	public void setVenueAddress(String venueAddress) {
		this.venueAddress = venueAddress;
	}

	@Override
	public String toString() {
		return "Venue [id=" + id + ", venueName=" + venueName + ", venueAddress=" + venueAddress + "]";
	}
	
	

}
