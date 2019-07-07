package com.workorders.worker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepo extends JpaRepository<Worker, Long>{

	Long findByName(String name);

	void deleteByName(Long workerName);

}
