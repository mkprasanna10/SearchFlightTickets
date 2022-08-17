package com.brownfield.pss.search.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Inventory 
{
	@Id
	@SequenceGenerator(name="INVENTORY_ID_GENERATOR",sequenceName="INVENTORY_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="INVENTORY_ID_GENERATOR")
	@Column(name="inv_id")
	long id;
    int count;
    
    @Override
	public String toString() {
		return "Inventory [id=" + id + ", count=" + count + "]";
	}

	public Inventory() { 	
    }
    
	public Inventory(long id, int count) {
		super();
		this.id = id;
		this.count = count;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}	
    
    
}
