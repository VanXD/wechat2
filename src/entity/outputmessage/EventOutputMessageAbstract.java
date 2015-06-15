package entity.outputmessage;

public abstract class EventOutputMessageAbstract extends OutputMessageAbstract {
	private String MsgType = "event";
	private String Event;
	
	public String getEvent() {
		return Event;
	}

	public void setEvent(String event) {
		Event = event;
	}

	@Override
	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

}
