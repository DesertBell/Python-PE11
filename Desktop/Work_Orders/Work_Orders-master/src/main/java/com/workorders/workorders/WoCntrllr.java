package com.workorders.workorders;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:3000", allowedHeaders="*")
@RequestMapping("/api/woServ")
public class WoCntrllr {
	
	@Autowired
	WoRepo woRepo;
	
	//Get work order by worker
	@GetMapping ("/getName")
	public List<WorkOrders> getName(@PathVariable("name")String title){
		List<WorkOrders> workOrders = woRepo.findByTitle(title);
		System.out.println(workOrders);
		return workOrders;
	}
	
	//Get all work orders sorted by deadline
	@GetMapping("/getAll")
	public List<WorkOrders> findAll(){
		return woRepo.findAllByOrderByDeadlineAsc();
	}
	
	
	//Create work order
	@RequestMapping(value="/newWo", method= {RequestMethod.POST, RequestMethod.GET})
	public @ResponseBody String newWo(@RequestParam String title, String description, Date deadline) {
		WorkOrders wo = new WorkOrders();
		
		wo.setTitle(title);
		wo.setDescription(description);
		wo.setDeadline(deadline);
		woRepo.save(wo);
		return "Saved";
	}
}

