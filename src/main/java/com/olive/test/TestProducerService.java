package com.olive.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.olive.model.Product;
import com.olive.producer.service.ProducerService;

@Component
public class TestProducerService {
	@Autowired
	private ProducerService service;
	
	@Scheduled(cron = "*/10 * * * * *")
	public void testData() {
		Product p=new Product();
		    p.setProdId(101);
		    p.setProdCode("PEN");
		    p.setProdCost(200.0);
             boolean send = service.sendData(p);
             if(send)
            	 System.out.println("Producer Message Send : ");
             else
            	 System.out.println("Producer Message Not Send !");
             
	}
}
