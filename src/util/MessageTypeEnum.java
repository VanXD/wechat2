package util;

public enum MessageTypeEnum {

	TEXT("text"),
	IMAGE("image"),
	VOICE("voice"),
	VIDEO("video"),
	SHORTVIDEO("shortvideo"),
	LOCATION("location"),
	LINK("link"),
	EVENT("event"),
	SUBSCRIBE("subscribe"),
	UNSUBSCRIBE("unsubscribe"),
	SCAN("SCAN"),
	LOCATIONS("LOCATION"),
	CLICK("CLICK"),
	VIEW("VIEW");
	
	private String msgType="";

	private MessageTypeEnum(String msgType) {
		this.msgType = msgType;
	}
	
	@Override
	public String toString() {
		return msgType.toString();
	}
}
