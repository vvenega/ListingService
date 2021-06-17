package com.example.demo;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class ListingBean {
	
	String owner;
	String name;
	String shortdescription;
	String longDescription;
	String thumbnailimage;
	double saleprice;
	String manufacturer;
	List<String> image;
	String salespricerange;
	List<String> category;
	String type;
	long objectid;
	String overview;
	int views;
	int quantity;
	boolean sold;
	String dateSold;
	String nameowner;
	List<String>sharedby;
	int numshares;

	
	
	
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShortdescription() {
		return shortdescription;
	}
	public void setShortdescription(String shortdescription) {
		this.shortdescription = shortdescription;
	}
	public String getThumbnailimage() {
		return thumbnailimage;
	}
	public void setThumbnailimage(String thumbnailimage) {
		this.thumbnailimage = thumbnailimage;
	}
	public double getSaleprice() {
		return saleprice;
	}
	public void setSaleprice(double saleprice) {
		this.saleprice = saleprice;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public String getSalespricerange() {
		return salespricerange;
	}
	public void setSalespricerange(String salespricerange) {
		this.salespricerange = salespricerange;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getObjectid() {
		return objectid;
	}
	public void setObjectid(long objectid) {
		this.objectid = objectid;
	}
	public String getNameowner() {
		return nameowner;
	}
	public void setNameowner(String nameowner) {
		this.nameowner = nameowner;
	}
	public String getLongDescription() {
		return longDescription;
	}
	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}
	public List<String> getImage() {
		return image;
	}
	public void setImage(List<String> image) {
		this.image = image;
	}
	public List<String> getCategory() {
		return category;
	}
	public void setCategory(List<String> category) {
		this.category = category;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public boolean isSold() {
		return sold;
	}
	public void setSold(boolean sold) {
		this.sold = sold;
	}
	public String getDateSold() {
		return dateSold;
	}
	public void setDateSold(String dateSold) {
		this.dateSold = dateSold;
	}
	public List<String> getSharedby() {
		return sharedby;
	}
	public void setSharedby(List<String> sharedby) {
		this.sharedby = sharedby;
	}
	public int getNumshares() {
		return numshares;
	}
	public void setNumshares(int numshares) {
		this.numshares = numshares;
	}
	


}
