package com.rp.springwebflux;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class TestMonoFlux {


	public void testMono() {
	Mono<String> mymono = Mono.just("MyJava").log();
	mymono.subscribe(System.out::println);
	
}
	
	public void testFlux() {
	Flux<String>	myflux=Flux.just("event1","event2","event3","event4").log();
	myflux.subscribe(System.out::println);
		
	}
	
	
}
