package entity.outputmessage.basic;

import java.util.Map;

import entity.InputMessageAbstract;
import entity.WXMedia;
import entity.outputmessage.OutputMessageAbstract;

public class ImageOutputMessage extends OutputMessageAbstract {

	private String MsgType = "image";
	private WXMedia Image;

	@Override
	public void inject(InputMessageAbstract ima) {
		setToUserName(ima.getFromUserName());
		setFromUserName(ima.getToUserName());
		setCreateTime(System.currentTimeMillis());
		// setMediaId("sX-A3AylJ4DwYEfQLhFRSjq_FDddtW-OcbTAZpVsVJY");
		setImage(Image);
	}
	
	@Override
	public void inject(InputMessageAbstract ima, String ImageStr) {
		setToUserName(ima.getFromUserName());
		setFromUserName(ima.getToUserName());
		setCreateTime(System.currentTimeMillis());
		// setMediaId("sX-A3AylJ4DwYEfQLhFRSjq_FDddtW-OcbTAZpVsVJY");
		setImage(new WXMedia(ImageStr));
	}

	public WXMedia getImage() {
		return Image;
	}

	public void setImage(WXMedia image) {
		Image = image;
	}

	public ImageOutputMessage() {
	}

	@Override
	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	/**
	 * @param image
	 */
	public ImageOutputMessage(WXMedia image) {
		super();
		Image = image;
	}
	

}
