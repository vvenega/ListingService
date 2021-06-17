package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="RecordEvent",url="http://localhost:8002/")
public interface KafkaServiceProxy {
	
	@GetMapping("/RecordEvent/{owner}/{price}/{category}/{type}/{name}/{user}/{objectid}/{event}")
	public void setEvent(@PathVariable String owner,@PathVariable double price,
			@PathVariable String category,@PathVariable String type, @PathVariable String name, 
			@PathVariable String user,@PathVariable long objectid,@PathVariable String event);
	
	
	@GetMapping("/RecordEvent/{owner}/{price}/{category}/{type}/{name}/{user}/{objectid}/{event}/{viewclick}/{contactclick}")
	public boolean setEvent(@PathVariable String owner,@PathVariable double price,
			@PathVariable String category,@PathVariable String type, @PathVariable String name, 
			@PathVariable String user,@PathVariable long objectid,@PathVariable String event,
			@PathVariable boolean viewclick, @PathVariable boolean contactclick );

}
