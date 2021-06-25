package com.example.demo;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;


public class KafkaServiceProxy {
	
	private RestTemplate restTemplate;
	
	private final String KAFKA="KAFKA";
	
	
	public void setEvent(@PathVariable String owner,@PathVariable double price,
			@PathVariable String category,@PathVariable String type, @PathVariable String name, 
			@PathVariable String user,@PathVariable long objectid,@PathVariable String event){
		
		restTemplate.exchange(Config.getProperty(this.KAFKA)+"/RecordEvent/{owner}/{price}/{category}/{type}/{name}/{user}/{objectid}/{event}",
		          HttpMethod.GET, null, new ParameterizedTypeReference<Void>() {}, owner,price,
		          category,type,name,user,objectid,event).getBody();
		
	}

	public boolean setEvent(@PathVariable String owner,@PathVariable double price,
			@PathVariable String category,@PathVariable String type, @PathVariable String name, 
			@PathVariable String user,@PathVariable long objectid,@PathVariable String event,
			@PathVariable boolean viewclick, @PathVariable boolean contactclick ) {
		
        boolean result = false;
		
		try {
			result = restTemplate.exchange(Config.getProperty(this.KAFKA)+"/RecordEvent/{owner}/{price}/{category}/{type}/{name}/{user}/{objectid}/{event}/{viewclick}/{contactclick}",
			          HttpMethod.GET, null, new ParameterizedTypeReference<Boolean>() {}, owner,price,
			          category,type,name,user,objectid,event,viewclick,contactclick).getBody();
		}catch(Exception e) {
			System.err.println(e.getMessage());
			result = false;
		}
		
		return result;
		
	}
	
	public KafkaServiceProxy setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate=restTemplate;
		return this;
	}

}
