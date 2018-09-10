package pojo;

public class Shop {
	private Integer shopid;
	private String shopname;
	private String shopaddress;
	private String sellid;
	public static final int PAGE_SIZE=2;
	public Integer getShopid() {
		return shopid;
	}
	public void setShopid(Integer shopid) {
		this.shopid = shopid;
	}
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	public String getShopaddress() {
		return shopaddress;
	}
	public void setShopaddress(String shopaddress) {
		this.shopaddress = shopaddress;
	}
	public String getSellid() {
		return sellid;
	}
	public void setSellid(String sellid) {
		this.sellid = sellid;
	}
	@Override
	public String toString() {
		return "Shop [shopid=" + shopid + ", shopname=" + shopname + ", shopaddress=" + shopaddress + ", sellid="
				+ sellid + "]";
	}
	
}
