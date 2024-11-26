package com.flowserve.vaccumepump.webservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flowserve.vaccumepump.webservice.dto.IVacuumPumpDetails;
import com.flowserve.vaccumepump.webservice.dto.IVacuumSelectionInputs;

public class OperatingConditions {

	
	
	

	
	
	@RequestMapping(value = "/vaccumepumps/rest/operatingfluid/change", method = RequestMethod.POST)
	public ResponseEntity<IVacuumPumpDetails> operatingfluidChange(@RequestBody IVacuumSelectionInputs input) {

		IVacuumPumpDetails respose = new IVacuumPumpDetails();
         
	   
		
		return ResponseEntity.ok().body(respose);

	}
	
}
