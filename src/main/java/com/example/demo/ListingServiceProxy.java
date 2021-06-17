package com.example.demo;

import java.util.HashMap;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="ListingsDAO",url="http://localhost:8001/")
public interface ListingServiceProxy {
	
	@GetMapping("/ListingsDAO/{user}/{ecommunities}/{types}")
	//@GetMapping(method = RequestMethod.GET, value = "/listings")
	public List<ListingBean> getListings(@PathVariable String user,@PathVariable List<String> ecommunities,@PathVariable List<String> types);
	
	/*@GetMapping("/ListingsDAOType/{user}/{category}/{listings}/{rentals}/{donations}/{exchange}")
	public List<ListingBean> getListings(@PathVariable String user,@PathVariable String category,@PathVariable boolean listings,
			@PathVariable boolean rentals,@PathVariable boolean donations,@PathVariable boolean exchange);*/
	
	@GetMapping("/CategoriesDAO/{user}/{ecommunities}/{types}")
	public List<CategoryBean> getCategories(@PathVariable String user,@PathVariable List<String> ecommunities,@PathVariable List<String> types);
	
	@GetMapping("/UserCategoriesDAO/{user}/{ecommunities}/{types}")
	public List<CategoryBean> getUserCategories(@PathVariable String user,@PathVariable List<String> ecommunities,@PathVariable List<String> types);
	
	@GetMapping("/ListingDetailDAO/{user}/{objectid}")
	public ListingDetailBean getListingDetail(@PathVariable String user,@PathVariable String objectid);
	
	@GetMapping("/ListingUserCategoriesFeedDAO/{user}/{ecommunities}/{types}")
	public ListingUserFeedCategoryBean getListingUserCategoryFeedDao(@PathVariable String user,@PathVariable List<String> ecommunities,@PathVariable List<String> types);
	
	@GetMapping("/ListingsCategoryDAO/{user}/{category}/{ecommunities}/{types}")
	public List<ListingBean> getListingsCategory(@PathVariable String user,@PathVariable String category,@PathVariable List<String> ecommunities,@PathVariable List<String> types);
	
	@GetMapping("/ListingsUserCategoryDAO/{user}/{category}/{ecommunities}/{types}")
	public List<ListingBean> getListingsUserCategory(@PathVariable String user,@PathVariable String category,@PathVariable List<String> ecommunities,@PathVariable List<String> types);
	
	@GetMapping("/ListingsPriceDAO/{user}/{price}")
	public List<ListingBean> getListingsPrice(@PathVariable String user,@PathVariable double price);
	
	@GetMapping("/ListingContactDAO/{owner}/{requester}/{namerequester}/{email}/{message}/{mobile}/{product}/{price}/{objectid}/{nameowner}")
	public void setContact(@PathVariable String owner, @PathVariable String requester,
			@PathVariable String namerequester,@PathVariable String email,@PathVariable String message,
			@PathVariable String mobile,@PathVariable String product,@PathVariable double price,
			@PathVariable String objectid,@PathVariable String nameowner);
	
	
	@GetMapping("/ListingDaoObjectID/{objectid}")
	public ListingBean getListingObjectid(@PathVariable String objectid);
	
	@GetMapping("/ListingSharePostDao/{username}/{objectid}")
	public boolean sharePost(@PathVariable String username, @PathVariable String objectid);
	


}
