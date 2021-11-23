package com.github.LtAden.qiagenproject.controler;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.github.LtAden.qiagenproject.DAO.TaxDAO;

@RestController
public class TaxControler {
    
	@GetMapping("calculate/{income:.+}")
	public ResponseEntity<?> calculateEAT(@PathVariable double income){
		return ResponseEntity.ok(TaxDAO.addResult(income));
	}
	
	@GetMapping("/recent")
	public ResponseEntity<?> getRecentCalculations(){
		return ResponseEntity.ok(TaxDAO.getResults());
	}

    }