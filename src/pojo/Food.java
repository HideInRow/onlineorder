package pojo;

import java.math.BigDecimal;

public class Food {
	private Integer foodid;
	private String name;
	private String descrip;
	private BigDecimal price;
	private String keyword;
	private Integer count;
	private String picture;
	public Integer getFoodid() {
		return foodid;
	}
	public void setFoodid(Integer foodid) {
		this.foodid = foodid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	@Override
	public String toString() {
		return "Food [foodid=" + foodid + ", name=" + name + ", descrip=" + descrip + ", price=" + price + ", keyword="
				+ keyword + ", count=" + count + ", picture=" + picture + "]";
	}
	
	
}
