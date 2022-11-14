package com.rp.springwebflux.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rp.springwebflux.dto.Customer;
import com.rp.springwebflux.service.Service;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/customers")
public class Controller {
	@Autowired
	private Service service;
	
	@GetMapping("/")
public List<Customer> getAllCustomrs() {
	
	
	return service.LoadAllCustomer();
	
}

  @GetMapping(value = "/steam",produces =MediaType.TEXT_EVENT_STREAM_VALUE) 
  public Flux<Customer> getAllCustomrStreamDetails() {
  
  
  return service.LoadAllCustomerSprinReactive();
  
  }
 
}
