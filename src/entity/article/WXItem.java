package entity.article;

public class WXItem {
	private String Title;
	private String Description;
	private String PicUrl;
	private String Url;

	public WXItem() {
	}

	public WXItem(String title, String url) {
		Title = title;
		Url = url;
	}

	public WXItem(String title, String picUrl, String url) {
		Title = title;
		PicUrl = picUrl;
		Url = url;
	}

	public WXItem(String title, String description, String picUrl, String url) {
		Title = title;
		Description = description;
		PicUrl = picUrl;
		Url = url;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

}
