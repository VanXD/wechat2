package com.aliapp.wxxd.material.entity.outputmessage.mass.type;

import com.aliapp.wxxd.material.entity.outputmessage.mass.MsgTypeOutputMessage;
import com.aliapp.wxxd.material.entity.outputmessage.mass.OpenIDOutputMessage;

public class ImageMassOutputMessage extends OpenIDOutputMessage {

	private String msgtype = "image";
	private MsgTypeOutputMessage image;

	public ImageMassOutputMessage() {
	}
	
	public ImageMassOutputMessage(MsgTypeOutputMessage image) {
		this.image = image;
	}

	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	public MsgTypeOutputMessage getImage() {
		return image;
	}

	public void setImage(MsgTypeOutputMessage image) {
		this.image = image;
	}

}
