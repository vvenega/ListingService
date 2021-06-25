package com.example.demo;

import java.util.Iterator;
import java.util.List;

public class Utilities {
	
	public static String toStringJSON(List<String> lst) {
		
		String response = "";
		
		try {
			
			Iterator<String> itr = lst.iterator();
			
			while(itr.hasNext()) {
				String element = itr.next();
				if(response.equals(""))
					response = element;
				else
					response = response +","+element;
			}
			
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
		System.err.println("returning:"+response);
		
		return response;
	}

}
