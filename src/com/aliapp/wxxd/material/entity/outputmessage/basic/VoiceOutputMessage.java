package com.aliapp.wxxd.material.entity.outputmessage.basic;

import java.util.Map;

import com.aliapp.wxxd.material.entity.InputMessageAbstract;
import com.aliapp.wxxd.material.entity.WXMedia;
import com.aliapp.wxxd.material.entity.outputmessage.OutputMessageAbstract;

public class VoiceOutputMessage extends OutputMessageAbstract {

	private String MsgType = "voice";
	private WXMedia Voice;

	public VoiceOutputMessage() {
	}

	@Override
	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	@Override
	public void inject(InputMessageAbstract ima) {
		setToUserName(ima.getFromUserName());
		setFromUserName(ima.getToUserName());
		setCreateTime(System.currentTimeMillis());
	}

	@Override
	public void inject(InputMessageAbstract ima, String MediaIdStr) {
		setToUserName(ima.getFromUserName());
		setFromUserName(ima.getToUserName());
		setCreateTime(System.currentTimeMillis());
		Voice = new WXMedia(MediaIdStr);
	}

	public WXMedia getVoice() {
		return Voice;
	}

	public void setVoice(WXMedia voice) {
		Voice = voice;
	}

}
