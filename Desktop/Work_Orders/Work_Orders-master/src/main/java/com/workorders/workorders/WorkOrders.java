package com.workorders.workorders;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.workorders.worker.Worker;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(exclude = "workers")

@Entity
@Table(name = "workOrders")
@EntityListeners(AuditingEntityListener.class)
public class WorkOrders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "deadline")
	private Date deadline;
	
	@OneToMany(mappedBy = "workOrders", cascade = CascadeType.ALL)
	private Set<Worker> workers;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public WorkOrders(Long id, String title, String description, Date deadline, Worker...workers) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.deadline = deadline;
		this.workers = Stream.of(workers).collect(Collectors.toSet());
		this.workers.forEach(x -> x.setWorkOrders(this));
	}
	
	public WorkOrders() {
	
	}
	
	public WorkOrders(Object workOrders) {
	}
	
}
	
