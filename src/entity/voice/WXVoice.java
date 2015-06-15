package entity.voice;

public class WXVoice {
	private String MediaId;

	public WXVoice() {
	}

	public WXVoice(String mediaId) {
		MediaId = mediaId;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

}
