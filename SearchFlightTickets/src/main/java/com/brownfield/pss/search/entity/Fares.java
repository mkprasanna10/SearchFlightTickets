package com.brownfield.pss.search.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="FARE")
public class Fares 
{
	@Id
	@SequenceGenerator(name="FARE_ID_GENERATOR",allocationSize=1,sequenceName="FARE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="FARE_ID_GENERATOR")
	@Column(name="fare_id")
	long id;
    String fare;
	String currency;
    
	@Override
	public String toString() {
		return "Fares [id=" + id + ", fare=" + fare + ", currency=" + currency + "]";
	}
	
    public Fares() { super(); }
   
	public Fares(long id, String fare, String currency) {
		super();
		this.id = id;
		this.fare = fare;
		this.currency = currency;
	}

	public String getFare() {
		return fare;
	}

	public void setFare(String fare) {
		this.fare = fare;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
    
	
    
}
