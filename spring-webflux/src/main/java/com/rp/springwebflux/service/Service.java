package com.rp.springwebflux.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rp.springwebflux.dao.DaoClass;
import com.rp.springwebflux.dto.Customer;

import reactor.core.publisher.Flux;

@org.springframework.stereotype.Service
public class Service {
@Autowired
private DaoClass dao;

public List<Customer> LoadAllCustomer(){
	
	long start= System.currentTimeMillis();
	List<Customer> customer= dao.getCustomer();
	long end = System.currentTimeMillis();
	System.out.println("TotaL Execution Time :" +(end -start));
	return customer;
}


  public Flux<Customer> LoadAllCustomerSprinReactive(){
  
  long start= System.currentTimeMillis();
  Flux<Customer> customer= dao.getCustomerreactive(); 
  long end = System.currentTimeMillis();
  System.out.println("TotaL Execution Time :" +(end -start)); return customer;
  }
 
}
