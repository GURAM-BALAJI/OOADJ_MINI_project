package com.example.movieticket.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Tickets")
public class Ticket {
	private static Ticket obj;
	private Ticket() {
	}
	// Only one thread can execute this at a time
	public static synchronized Ticket getInstance() {
		if (obj == null)
			obj = new Ticket();
		return obj;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String TicketAmount;
	private String TicketBy;
	private String TicketTime;
	private String TicketDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTicketAmount() {
		return TicketAmount;
	}

	public void setTicketAmount(String TicketAmount) {
		this.TicketAmount = TicketAmount;
	}

	public String getTicketBy() {
		return TicketBy;
	}

	public void setTicketBy(String TicketBy) {
		this.TicketBy = TicketBy;
	}

	public String getTicketTime() {
		return TicketTime;
	}

	public void setTicketTime(String TicketTime) {
		this.TicketTime = TicketTime;
	}

	public String getTicketDate() {
		return TicketDate;
	}

	public void setTicketDate(String TicketDate) {
		this.TicketDate = TicketDate;
	}
}