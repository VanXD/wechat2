package com.aliapp.wxxd.material.entity.outputmessage.mass.type;

import com.aliapp.wxxd.material.entity.outputmessage.mass.MsgTypeOutputMessage;
import com.aliapp.wxxd.material.entity.outputmessage.mass.OpenIDOutputMessage;

public class TextMassOutputMessage extends OpenIDOutputMessage {

	private String msgtype = "text";
	private MsgTypeOutputMessage text;

	public TextMassOutputMessage() {
	}

	public TextMassOutputMessage(MsgTypeOutputMessage text) {
		this.text = text;
	}

	public MsgTypeOutputMessage getText() {
		return text;
	}

	public void setText(MsgTypeOutputMessage text) {
		this.text = text;
	}

	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

}
