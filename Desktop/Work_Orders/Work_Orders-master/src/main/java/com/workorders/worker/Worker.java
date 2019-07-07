package com.workorders.worker;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.workorders.workorders.WorkOrders;
@Data 

@Entity
@Table(name="workers")
@EntityListeners(AuditingEntityListener.class)
public class Worker {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "companyName")
	private String companyName;
	
	@Column(name = "email")
	private String email;
	
	@ManyToOne
	@JoinColumn
	private WorkOrders workOrders;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Worker(Long id, String name, String companyName, String email) {
		super();
		this.id = id;
		this.name = name;
		this.companyName = companyName;
		this.email = email;
	}
	
	public Worker() {
		
	}
	
	public Worker(Object Worker) {
		
	}
	public Object setWorkOrders(WorkOrders workOrders) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
