package com.aliapp.wxxd.material.entity.outputmessage.mass.type;

import com.aliapp.wxxd.material.entity.outputmessage.mass.MsgTypeOutputMessage;
import com.aliapp.wxxd.material.entity.outputmessage.mass.OpenIDOutputMessage;

public class VoiceMassOutputMessage extends OpenIDOutputMessage {

	private String msgtype = "voice";
	private MsgTypeOutputMessage voice;

	public VoiceMassOutputMessage() {
	}
	
	public VoiceMassOutputMessage(MsgTypeOutputMessage voice) {
		this.voice = voice;
	}

	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	public MsgTypeOutputMessage getVoice() {
		return voice;
	}

	public void setVoice(MsgTypeOutputMessage voice) {
		this.voice = voice;
	}

}
