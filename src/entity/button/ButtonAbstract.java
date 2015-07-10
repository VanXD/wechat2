package entity.button;

public abstract class ButtonAbstract {
	protected String name;
	protected ButtonAbstract[] sub_button;
	protected String type;
	protected String key;
	protected String url;
	protected String media_id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ButtonAbstract[] getSub_button() {
		return sub_button;
	}

	public void setSub_button(ButtonAbstract[] sub_button) {
		this.sub_button = sub_button;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}

}
