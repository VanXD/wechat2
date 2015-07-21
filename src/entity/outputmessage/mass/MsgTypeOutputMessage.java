package entity.outputmessage.mass;

public class MsgTypeOutputMessage {
	// text
	private String content;
	// image video voice news
	private String media_id;
	private String url;
	private String type;
	private String created_at;
	// video
	private String title;
	private String description;

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	@Override
	public String toString() {
		return "MsgTypeOutputMessage [content=" + content + ", media_id="
				+ media_id + ", url=" + url + ", type=" + type
				+ ", created_at=" + created_at + ", title=" + title
				+ ", description=" + description + "]";
	}

}
