package com.example.hell.modal;

import javax.persistence.GeneratedValue;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="hell")
public class Modal {
	public Modal(){}
	private String firstName;
	private long id;
	@Column(name="firstname", nullable=false)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Id
	@GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String toString() {
		return id+": "+firstName;
	}
}
