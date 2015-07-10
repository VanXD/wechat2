package entity.outputmessage.basic;

import java.util.Map;

import entity.InputMessageAbstract;
import entity.WXMedia;
import entity.outputmessage.OutputMessageAbstract;

public class VideoOutputMessage extends OutputMessageAbstract {

	private String MsgType = "video";
	private WXMedia Video;

	@Override
	public void inject(InputMessageAbstract ima) {
		setToUserName(ima.getFromUserName());
		setFromUserName(ima.getToUserName());
		setCreateTime(System.currentTimeMillis());
	}

	@Override
	public void inject(InputMessageAbstract ima, String ImageStr, String Title,
			String Description) {
		setToUserName(ima.getFromUserName());
		setFromUserName(ima.getToUserName());
		setCreateTime(System.currentTimeMillis());
		setVideo(new WXMedia(ImageStr, Title, Description));
	}

	@Override
	public void inject(InputMessageAbstract ima, String ImageStr) {
		setToUserName(ima.getFromUserName());
		setFromUserName(ima.getToUserName());
		setCreateTime(System.currentTimeMillis());
		setVideo(new WXMedia(ImageStr));
	}

	public WXMedia getVideo() {
		return Video;
	}

	public void setVideo(WXMedia video) {
		Video = video;
	}

	public VideoOutputMessage() {
	}

	@Override
	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

}
