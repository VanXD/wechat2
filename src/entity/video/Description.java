package entity.video;

public class Description {
	private String title;
	private String introduction;
	private String down_url;

	/**
	 * 
	 */
	public Description() {
		super();
	}

	/**
	 * @param title
	 * @param introduction
	 */
	public Description(String title, String introduction) {
		super();
		this.title = title;
		this.introduction = introduction;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getDown_url() {
		return down_url;
	}

	public void setDown_url(String down_url) {
		this.down_url = down_url;
	}

}
