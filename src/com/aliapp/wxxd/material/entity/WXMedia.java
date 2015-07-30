package com.aliapp.wxxd.material.entity;

public class WXMedia {
	private String MediaId;
	private String Title;
	private String Description;

	public WXMedia(String mediaId) {
		MediaId = mediaId;
	}

	/**
	 * 
	 */
	public WXMedia() {
		super();
	}

	/**
	 * video 用的
	 * 
	 * @param mediaId
	 * @param title
	 * @param description
	 */
	public WXMedia(String mediaId, String title, String description) {
		super();
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

	@Override
	public String toString() {
		return "WXMedia [MediaId=" + MediaId + ", Title=" + Title
				+ ", Description=" + Description + "]";
	}

}
