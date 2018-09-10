package pojo;

public class Message {
	private String username;
	private int shopid;
	private String content;
	private int contentid;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getShopid() {
		return shopid;
	}
	public void setShopid(int shopid) {
		this.shopid = shopid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getContentid() {
		return contentid;
	}
	public void setContentid(int contentid) {
		this.contentid = contentid;
	}
	@Override
	public String toString() {
		return "Message [username=" + username + ", shopid=" + shopid + ", content=" + content + ", contentid="
				+ contentid + "]";
	}
}
