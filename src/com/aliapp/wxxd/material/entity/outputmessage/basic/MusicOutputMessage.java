package com.aliapp.wxxd.material.entity.outputmessage.basic;

import java.util.Map;

import com.aliapp.wxxd.material.entity.InputMessageAbstract;
import com.aliapp.wxxd.material.entity.WXMedia;
import com.aliapp.wxxd.material.entity.music.WXMusic;
import com.aliapp.wxxd.material.entity.outputmessage.OutputMessageAbstract;

public class MusicOutputMessage extends OutputMessageAbstract {

	private String MsgType = "music";
	private WXMusic Music;

	@Override
	public void inject(InputMessageAbstract ima) {
		setToUserName(ima.getFromUserName());
		setFromUserName(ima.getToUserName());
		setCreateTime(System.currentTimeMillis());
		// setMediaId("sX-A3AylJ4DwYEfQLhFRSjq_FDddtW-OcbTAZpVsVJY");
	}

	@Override
	public void inject(InputMessageAbstract ima, String ThumbMediaIdStr,
			String Title, String MusicUrl) {
		setToUserName(ima.getFromUserName());
		setFromUserName(ima.getToUserName());
		setCreateTime(System.currentTimeMillis());
		setMusic(new WXMusic(Title, MusicUrl, ThumbMediaIdStr));
	}

	public WXMusic getMusic() {
		return Music;
	}

	public void setMusic(WXMusic music) {
		Music = music;
	}

	public MusicOutputMessage() {
	}

	@Override
	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

}
