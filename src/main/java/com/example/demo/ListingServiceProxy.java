package com.example.demo;


import java.util.List;


import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

public class ListingServiceProxy {
	
	private RestTemplate restTemplate;
	
	private final String DAO="DAO";

	public List<ListingBean> getListings(@PathVariable String user,@PathVariable List<String> ecommunities,@PathVariable List<String> types){
		
		String strEcommunities = Utilities.toStringJSON(ecommunities);
		String strTypes=Utilities.toStringJSON(types);
		List<ListingBean> lst = restTemplate.exchange(Config.getProperty(this.DAO)+"/ListingsDAO/{user}/{ecommunities}/{types}",
		          HttpMethod.GET, null, new ParameterizedTypeReference<List<ListingBean>>() {}, user,strEcommunities,strTypes).getBody();
		
		return lst;
		
	}
	
	/*@GetMapping("/ListingsDAOType/{user}/{category}/{listings}/{rentals}/{donations}/{exchange}")
	public List<ListingBean> getListings(@PathVariable String user,@PathVariable String category,@PathVariable boolean listings,
			@PathVariable boolean rentals,@PathVariable boolean donations,@PathVariable boolean exchange);*/

	public List<CategoryBean> getCategories(@PathVariable String user,@PathVariable List<String> ecommunities,@PathVariable List<String> types){
		
		
		String strCommunities = Utilities.toStringJSON(ecommunities);
		String strTypes = Utilities.toStringJSON(types);
		
		List<CategoryBean> lst = restTemplate.exchange(Config.getProperty(this.DAO)+"/CategoriesDAO/{user}/{ecommunities}/{types}",
		          HttpMethod.GET, null, new ParameterizedTypeReference<List<CategoryBean>>() {}, user,strCommunities,strTypes).getBody();
		
		return lst;
		
	}
	
	public List<CategoryBean> getUserCategories(@PathVariable String user,@PathVariable List<String> ecommunities,@PathVariable List<String> types){
		
		String strCommunities = Utilities.toStringJSON(ecommunities);
		String strTypes = Utilities.toStringJSON(types);
		
		List<CategoryBean> lst = restTemplate.exchange(Config.getProperty(this.DAO)+"/UserCategoriesDAO/{user}/{ecommunities}/{types}",
		          HttpMethod.GET, null, new ParameterizedTypeReference<List<CategoryBean>>() {}, user,strCommunities,strTypes).getBody();
		
		return lst;
		
	}
	

	public ListingDetailBean getListingDetail(@PathVariable String user,@PathVariable String objectid) {
		
		ListingDetailBean bean = restTemplate.exchange(Config.getProperty(this.DAO)+"/ListingDetailDAO/{user}/{objectid}",
		          HttpMethod.GET, null, new ParameterizedTypeReference<ListingDetailBean>() {}, user,objectid).getBody();
		
		return bean;
		
	}
	

	public ListingUserFeedCategoryBean getListingUserCategoryFeedDao(@PathVariable String user,@PathVariable List<String> ecommunities,@PathVariable List<String> types) {
		
		String strCommunities = Utilities.toStringJSON(ecommunities);
		String strTypes = Utilities.toStringJSON(types);
		
		ListingUserFeedCategoryBean bean = restTemplate.exchange(Config.getProperty(this.DAO)+"/ListingUserCategoriesFeedDAO/{user}/{ecommunities}/{types}",
		          HttpMethod.GET, null, new ParameterizedTypeReference<ListingUserFeedCategoryBean>() {}, user,strCommunities,strTypes).getBody();
		
		return bean;
		
	}
	

	public List<ListingBean> getListingsCategory(@PathVariable String user,@PathVariable String category,@PathVariable List<String> ecommunities,@PathVariable List<String> types){
		
		String strCommunities = Utilities.toStringJSON(ecommunities);
		String strTypes = Utilities.toStringJSON(types);
		
		List<ListingBean> lst = restTemplate.exchange(Config.getProperty(this.DAO)+"/ListingsCategoryDAO/{user}/{category}/{ecommunities}/{types}",
		          HttpMethod.GET, null, new ParameterizedTypeReference<List<ListingBean>>() {}, user,category,strCommunities,strTypes).getBody();
		
		return lst;
		
	}
	

	public List<ListingBean> getListingsUserCategory(@PathVariable String user,@PathVariable String category,@PathVariable List<String> ecommunities,@PathVariable List<String> types){
		
		String strCommunities = Utilities.toStringJSON(ecommunities);
		String strTypes = Utilities.toStringJSON(types);
		
		List<ListingBean> lst = restTemplate.exchange(Config.getProperty(this.DAO)+"/ListingsUserCategoryDAO/{user}/{category}/{ecommunities}/{types}",
		          HttpMethod.GET, null, new ParameterizedTypeReference<List<ListingBean>>() {}, user,category,strCommunities,strTypes).getBody();
		
		return lst;
		
	}
	

	public List<ListingBean> getListingsPrice(@PathVariable String user,@PathVariable double price){
		
		List<ListingBean> lst = restTemplate.exchange(Config.getProperty(this.DAO)+"/ListingsPriceDAO/{user}/{price}",
		          HttpMethod.GET, null, new ParameterizedTypeReference<List<ListingBean>>() {}, user,price).getBody();
		
		return lst;
		
	}
	

	public void setContact(@PathVariable String owner, @PathVariable String requester,
			@PathVariable String namerequester,@PathVariable String email,@PathVariable String message,
			@PathVariable String mobile,@PathVariable String product,@PathVariable double price,
			@PathVariable String objectid,@PathVariable String nameowner) {
		
		
		
	}
	
	

	public ListingBean getListingObjectid(@PathVariable String objectid) {
		
		ListingBean bean = restTemplate.exchange(Config.getProperty(this.DAO)+"/ListingDaoObjectID/{objectid}",
		          HttpMethod.GET, null, new ParameterizedTypeReference<ListingBean>() {}, objectid).getBody();
		
		return bean;
		
	}
	

	public boolean sharePost(@PathVariable String username, @PathVariable String objectid) {
		
		boolean response = restTemplate.exchange(Config.getProperty(this.DAO)+"/ListingSharePostDao/{username}/{objectid}",
		          HttpMethod.GET, null, new ParameterizedTypeReference<Boolean>() {}, username,objectid).getBody();
		
		return response;
		
	}
	
	public ListingServiceProxy setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate=restTemplate;
		return this;
	}
	


}
