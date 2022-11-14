package com.rp.springwebflux.dao;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.format.datetime.joda.MillisecondInstantPrinter;
import org.springframework.stereotype.Component;


import com.rp.springwebflux.dto.Customer;

import reactor.core.publisher.Flux;

@Component
public class DaoClass {
	
	private static void sleepexecution(int i) {
		try{Thread.sleep(1000);}
		catch(Exception e) {
		e.printStackTrace();	
		}
	}
public List<Customer> getCustomer(){
	 return IntStream.rangeClosed(1, 50).peek(DaoClass::sleepexecution)
			 .peek(i->System.out.println("processing count "  +i))
	.mapToObj(i-> new Customer(i, "connect"+i))
	.collect(Collectors.toList());
	 }
		
		  public Flux<Customer> getCustomerreactive(){
			  return Flux.range(1, 50).delayElements(Duration.ofSeconds(1))
					  .doOnNext(i->System.out.println("processing count "  +i))
					  .map(i-> new Customer(i, "connect"+i));
			  
		  
		  }
		 
}
