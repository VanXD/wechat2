package entity.outputmessage.mass.type;

import entity.outputmessage.mass.MsgTypeOutputMessage;
import entity.outputmessage.mass.OpenIDOutputMessage;

public class NewsMassOutputMessage extends OpenIDOutputMessage {

	private String msgtype = "mpnews";
	private MsgTypeOutputMessage mpnews;

	public NewsMassOutputMessage() {
	}


	public NewsMassOutputMessage(MsgTypeOutputMessage mpnews) {
		this.mpnews = mpnews;
	}


	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}


	public MsgTypeOutputMessage getMpnews() {
		return mpnews;
	}


	public void setMpnews(MsgTypeOutputMessage mpnews) {
		this.mpnews = mpnews;
	}

}
