package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



import org.springframework.web.bind.annotation.CrossOrigin;



@RestController
public class ListingServiceController {
	
	//private static final String VALID_CUSTOMER = "http://192.168.166:4200";
	private static final String VALID_CUSTOMER = "*";
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ListingServiceProxy proxy;
	HashMap<Integer, Integer> htPuerto=new HashMap<>();	
	
	@Autowired
	private KafkaServiceProxy kafkaproxy;
	
	
	
	@CrossOrigin(origins = VALID_CUSTOMER)
	@GetMapping("/ListingsObjectid/{objectid}/{user}/{price}")
	
	public ListingBean getListingObjectid(@PathVariable String objectid,@PathVariable String user,@PathVariable double price) {
		
		System.err.println("object id:"+objectid);
	    ListingBean response = proxy.getListingObjectid(objectid);
		System.err.println(response.getShortdescription());
	    //pass Category
		kafkaproxy.setEvent(objectid, price, "LISTING", 
				"-", "-", user, 
				0, "VIEW_OBJECTID");
		
		return response;
	}
	
	
	@CrossOrigin(origins = VALID_CUSTOMER)
	@GetMapping("/Listings/{user}/{ecommunities}/{types}")
	//public List<ListingBean> getListings(@PathVariable String dummy) {
	public List<ListingBean> getListings(@PathVariable String user,@PathVariable List<String> ecommunities,
			@PathVariable List<String> types) {
		
		List<ListingBean> response = proxy.getListings(user,ecommunities,types);
		
		return response;
	}
	
	@CrossOrigin(origins = VALID_CUSTOMER)
	@GetMapping("/Categories/{user}/{ecommunities}/{types}")
	public List<CategoryBean> getCategories(@PathVariable String user,@PathVariable List<String> ecommunities,
			@PathVariable List<String> types) {
		
		List<CategoryBean> response = proxy.getCategories(user,ecommunities,types);
		
		return response;
	}
	
	@CrossOrigin(origins = VALID_CUSTOMER)
	@GetMapping("/UserCategories/{user}/{ecommunities}/{types}")
	public List<CategoryBean> getUserCategories(@PathVariable String user,@PathVariable List<String> ecommunities,
			@PathVariable List<String> types) {
		
		List<CategoryBean> response = proxy.getUserCategories(user,ecommunities,types);
		
		return response;
	}
	
	@CrossOrigin(origins = VALID_CUSTOMER)
	@GetMapping("/ListingsCategory/{user}/{category}/{ecommunities}/{types}")
	//public List<ListingBean> getListings(@PathVariable String dummy) {
	public List<ListingBean> getListingsCategory(@PathVariable String user,@PathVariable String category,@PathVariable List<String> ecommunities,
			@PathVariable List<String> types) {
		
		List<ListingBean> response = proxy.getListingsCategory(user,category,ecommunities,types);
		
		kafkaproxy.setEvent("ALL", 0.0, category, 
				"-", "-", user, 
				0, "CATEGORY_VIEW");
		
		System.err.println("Size:"+response.size());
		return response;
	}
	
	@CrossOrigin(origins = VALID_CUSTOMER)
	@GetMapping("/ListingsUserCategory/{user}/{category}/{ecommunities}/{types}")
	//public List<ListingBean> getListings(@PathVariable String dummy) {
	public List<ListingBean> getListingsUserCategory(@PathVariable String user,@PathVariable String category,@PathVariable List<String> ecommunities,
			@PathVariable List<String> types) {
		
		List<ListingBean> response = proxy.getListingsUserCategory(user,category,ecommunities,types);
		
		kafkaproxy.setEvent("ALL", 0.0, category, 
				"-", "-", user, 
				0, "CATEGORY_VIEW_OWN");
		
		System.err.println("Size:"+response.size());
		return response;
	}
	
	@CrossOrigin(origins = VALID_CUSTOMER)
	@GetMapping("/ListingsPrice/{user}/{price}")
	//public List<ListingBean> getListings(@PathVariable String dummy) {
	public List<ListingBean> getListingsPrice(@PathVariable String user,@PathVariable double price) {
		
		List<ListingBean> response = proxy.getListingsPrice(user,price);
		
		kafkaproxy.setEvent("ALL", price, "-", 
				"-", "-", user, 
				0, "PRICE_VIEW");
		
		return response;
	}
	
	@CrossOrigin(origins = VALID_CUSTOMER)
	@GetMapping("/ListingDetail/{user}/{owner}/{objectid}")
	public ListingDetailBean getListingDetail(@PathVariable String user, @PathVariable String owner,@PathVariable String objectid) {
		
		System.out.println("*****************************************");
		System.out.println("user:"+user);
		System.out.println("objectid:"+objectid);
		
		ListingDetailBean response = proxy.getListingDetail(user, objectid);
		response.setUser(user);
		Iterator<String> itrCategory = response.getCategory().iterator();
		while(itrCategory.hasNext()) {
			String category =itrCategory.next();
			category=category.replace("/", "-");
			String type = response.getType().replace("/", "-");
			String name = response.getName().replace("/", "-");
			name = name.replace("\\", "-");
			
			kafkaproxy.setEvent(response.getOwner(), response.getSaleprice(), category, 
					type, name, response.getUser(), 
					response.getObjectid(), "VIEW");

		}
		
		return response;
	}
	
	
	@CrossOrigin(origins = VALID_CUSTOMER)
	@GetMapping("/ListingUserCategoriesFeed/{user}/{ecommunities}/{types}")
	public ListingUserFeedCategoryBean getListingFeedUser(@PathVariable String user,@PathVariable List<String> ecommunities,
			@PathVariable List<String> types) {
		
		System.out.println("*****************************************");
		System.out.println("user:"+user);
		
		ListingUserFeedCategoryBean response = proxy.getListingUserCategoryFeedDao(user,ecommunities,types);
		response.setUser(user);

		return response;
	}
	
	@CrossOrigin(origins = VALID_CUSTOMER)
	@GetMapping("/ListingContact/{owner}/{requester}/{namerequester}/{email}/{message}/{mobile}/{product}/{price}/{objectid}/{type}/{category}/{view}/{contact}/{nameowner}")
	public void contactPublisher(@PathVariable String owner, @PathVariable String requester,
			@PathVariable String namerequester,@PathVariable String email,@PathVariable String message,
			@PathVariable String mobile,@PathVariable String product,@PathVariable double price,
			@PathVariable String objectid,@PathVariable String type,@PathVariable List<String> category,@PathVariable boolean view,
			@PathVariable boolean contact,@PathVariable String nameowner) {
		
		proxy.setContact(owner, requester, namerequester, email, message, mobile, product, price, objectid,nameowner);
		
		Iterator<String> itrCat = category.iterator();
		while(itrCat.hasNext()) {
			String catValue = itrCat.next();
		kafkaproxy.setEvent(owner, price, catValue, 
				type, product, requester, 
				Long.parseLong(objectid), "SEND",view,contact);
		}
	}
	
	
	
	@CrossOrigin(origins = VALID_CUSTOMER)
	@GetMapping("/ListingSharePost/{username}/{objectid}/{saleprice}/{category}/{type}/{name}/{owner}")
	public boolean sharePost(@PathVariable String username, @PathVariable String objectid,
			@PathVariable double saleprice,@PathVariable String category,@PathVariable String type,
			@PathVariable String name, @PathVariable String owner) {
		
		System.err.println("Shared post...");
		
		boolean response = proxy.sharePost(username, objectid);
		
	    category = category.replace("/", "-");
		type = type.replace("/", "-");
		name = name.replace("/", "-");
		name = name.replace("\\", "-");
		
		kafkaproxy.setEvent(owner, saleprice, category, 
				type, name, username, 
				Long.parseLong(objectid), "SHARED");
		return response;
	}
	
	
	
	
}
