package com.workorders.workorders;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WoRepo extends JpaRepository<WorkOrders, Long> {

	List<WorkOrders> findByTitle(String title);
	List<WorkOrders> findAllByOrderByDeadlineAsc();

}
