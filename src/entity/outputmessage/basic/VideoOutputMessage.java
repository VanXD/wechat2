package entity.outputmessage.basic;

import java.util.Map;

import entity.InputMessageAbstract;
import entity.image.WXImage;
import entity.outputmessage.OutputMessageAbstract;
import entity.video.WXVideo;

public class VideoOutputMessage extends OutputMessageAbstract {

	private String MsgType = "video";
	private WXVideo Video;

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
		setVideo(new WXVideo(ImageStr, Title, Description));
	}

	@Override
	public void inject(InputMessageAbstract ima, String ImageStr) {
		setToUserName(ima.getFromUserName());
		setFromUserName(ima.getToUserName());
		setCreateTime(System.currentTimeMillis());
		setVideo(new WXVideo(ImageStr));
	}

	public WXVideo getVideo() {
		return Video;
	}

	public void setVideo(WXVideo video) {
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
