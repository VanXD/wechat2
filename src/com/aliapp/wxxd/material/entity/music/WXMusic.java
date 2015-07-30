package com.aliapp.wxxd.material.entity.music;

public class WXMusic {
	private String Title;
	private String Description;
	private String MusicUrl;
	private String HQMusicUrl;
	private String ThumbMediaId;

	public WXMusic(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}

	public WXMusic(String musicUrl, String thumbMediaId) {
		MusicUrl = musicUrl;
		ThumbMediaId = thumbMediaId;
	}

	public WXMusic(String title, String musicUrl, String thumbMediaId) {
		Title = title;
		MusicUrl = musicUrl;
		ThumbMediaId = thumbMediaId;
	}

	public WXMusic(String title, String description, String musicUrl,
			String thumbMediaId) {
		Title = title;
		Description = description;
		MusicUrl = musicUrl;
		ThumbMediaId = thumbMediaId;
	}

	public WXMusic() {
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

	public String getMusicUrl() {
		return MusicUrl;
	}

	public void setMusicUrl(String musicUrl) {
		MusicUrl = musicUrl;
	}

	public String getHQMusicUrl() {
		return HQMusicUrl;
	}

	public void setHQMusicUrl(String hQMusicUrl) {
		HQMusicUrl = hQMusicUrl;
	}

	public String getThumbMediaId() {
		return ThumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}

}
