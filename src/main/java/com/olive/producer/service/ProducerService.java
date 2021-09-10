package com.olive.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.olive.model.Product;
import com.olive.utils.JacksonUtils;

@Component
public class ProducerService {
	@Autowired
	private JacksonUtils utils;
	
	@Autowired
	JmsTemplate jt;
	
    @Value("${my.jms.desti-name}")   
	public String destination;
    
    public boolean sendData(Product prod) {
    	     String json = utils.toJson(prod);
    	return send(json); 
    }
    
	
	public boolean send(String message) {
		 boolean send=false;
		try {
			jt.send(destination, 
		   (session)->session.createTextMessage(message));
			send=true;
		} catch (Exception e) {
			send=false;
			e.printStackTrace();
		}
		return send;
	}
}
