package entity.video;

public class WXVideo {
	private String MediaId;
	private String Title;
	private String Description;

	public WXVideo() {
	}

	public WXVideo(String mediaId) {
		MediaId = mediaId;
	}

	public WXVideo(String mediaId, String title, String description) {
		MediaId = mediaId;
		Title = title;
		Description = description;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
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

}
