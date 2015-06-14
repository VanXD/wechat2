package tool;

public enum ButtonTypeEnum {
	SCANCODE_WAITMSG("scancode_waitmsg"),
	CLICK("click"),
	VIEW("view"),
	SCANCODE_PUSH("scancode_push"),
	PIC_SYSPHOTO("pic_sysphoto"),
	PIC_PHOTO_OR_ALBUM("pic_photo_or_album"),
	PIC_WEIXIN("pic_weixin"),
	LOCATION_SELECT("location_select"),
	MEDIA_ID("media_id"),
	VIEW_LIMITED("view_limited");
	
	private String btnType="";

	private ButtonTypeEnum(String btnType) {
		this.btnType = btnType;
	}
	
	@Override
	public String toString() {
		return btnType.toString();
	}
}
