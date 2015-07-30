package com.aliapp.wxxd.material.entity.outputmessage.mass.type;

import com.aliapp.wxxd.material.entity.outputmessage.mass.MsgTypeOutputMessage;
import com.aliapp.wxxd.material.entity.outputmessage.mass.OpenIDOutputMessage;

public class ArticleMassOutputMessage extends OpenIDOutputMessage {

	private String msgtype = "mpnews";
	private MsgTypeOutputMessage mpnews;

	public ArticleMassOutputMessage() {
	}


	public ArticleMassOutputMessage(MsgTypeOutputMessage mpnews) {
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
