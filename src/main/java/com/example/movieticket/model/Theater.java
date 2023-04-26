package com.example.movieticket.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Theater")
public class Theater {
	private static Theater obj;

	private Theater() {
	}

	// Only one thread can execute this at a time
	public static synchronized Theater getInstance() {
		if (obj == null)
			obj = new Theater();
		return obj;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String TheaterName;
	private String OwnerName;
	private String ContactInfo;
	private String Address;
	private int TotalSeats;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTheaterName() {
		return TheaterName;
	}

	public void setTheaterName(String TheaterName) {
		this.TheaterName = TheaterName;
	}

	public String getOwnerName() {
		return OwnerName;
	}

	public void setOwnerName(String OwnerName) {
		this.OwnerName = OwnerName;
	}

	public String getContactInfo() {
		return ContactInfo;
	}

	public void setContactInfo(String ContactInfo) {
		this.ContactInfo = ContactInfo;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String Address) {
		this.Address = Address;
	}

	public int getTotalSeats() {
		return TotalSeats;
	}

	public void setTotalSeats(int TotalSeats) {
		this.TotalSeats = TotalSeats;
	}
}