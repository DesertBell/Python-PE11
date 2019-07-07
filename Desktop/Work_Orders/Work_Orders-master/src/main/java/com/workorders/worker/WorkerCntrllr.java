package com.workorders.worker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/worker")
public class WorkerCntrllr {
	
	@Autowired
	private WorkerRepo workerRepo;
	
	//Create worker
	@RequestMapping(value="/newWorker", method= {RequestMethod.POST, RequestMethod.GET})
	public @ResponseBody String saveWorker(@RequestParam String name, String companyName, String email) {
		Worker w = new Worker();
		
		w.setName(name);
		w.setCompanyName(companyName);
		w.setEmail(email);
		workerRepo.save(w);
		return "Saved";
	}
	
	//Delete worker
	@RequestMapping(value="/deleteWorker", method= {RequestMethod.GET,RequestMethod.DELETE})
	@Query("delete from Worker w where w.name-:name")
	public void deleteWorker(@Param("name") String name){
		Long workerName = workerRepo.findByName("name");
		workerRepo.deleteByName(workerName);
		System.out.println("Deleted");
	}

	
}
