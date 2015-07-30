package com.aliapp.wxxd.material.entity.outputmessage.mass.type;

import com.aliapp.wxxd.material.entity.outputmessage.mass.MsgTypeOutputMessage;
import com.aliapp.wxxd.material.entity.outputmessage.mass.OpenIDOutputMessage;

public class VideoMassOutputMessage extends OpenIDOutputMessage {

	private String msgtype = "video";
	private MsgTypeOutputMessage video;

	public VideoMassOutputMessage() {
	}
	
	public VideoMassOutputMessage(MsgTypeOutputMessage video) {
		this.video = video;
	}

	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	public MsgTypeOutputMessage getVideo() {
		return video;
	}

	public void setVideo(MsgTypeOutputMessage video) {
		this.video = video;
	}
	
}
