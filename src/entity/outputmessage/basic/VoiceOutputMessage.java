package entity.outputmessage.basic;

import java.util.Map;

import entity.InputMessageAbstract;
import entity.image.WXImage;
import entity.outputmessage.OutputMessageAbstract;
import entity.voice.WXVoice;

public class VoiceOutputMessage extends OutputMessageAbstract {

	private String MsgType = "voice";
	private WXVoice Voice;

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
		Voice = new WXVoice(MediaIdStr);
	}

	public WXVoice getVoice() {
		return Voice;
	}

	public void setVoice(WXVoice voice) {
		Voice = voice;
	}


	
}
