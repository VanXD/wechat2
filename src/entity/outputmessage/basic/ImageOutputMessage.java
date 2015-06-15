package entity.outputmessage.basic;

import java.util.Map;

import entity.InputMessageAbstract;
import entity.image.WXImage;
import entity.outputmessage.OutputMessageAbstract;

public class ImageOutputMessage extends OutputMessageAbstract {

	private String MsgType = "image";
	private WXImage Image;

	@Override
	public void inject(InputMessageAbstract ima) {
		setToUserName(ima.getFromUserName());
		setFromUserName(ima.getToUserName());
		setCreateTime(System.currentTimeMillis());
		// setMediaId("sX-A3AylJ4DwYEfQLhFRSjq_FDddtW-OcbTAZpVsVJY");
		setImage(new WXImage("sX-A3AylJ4DwYEfQLhFRSjq_FDddtW-OcbTAZpVsVJY"));
	}
	
	@Override
	public void inject(InputMessageAbstract ima, String ImageStr) {
		setToUserName(ima.getFromUserName());
		setFromUserName(ima.getToUserName());
		setCreateTime(System.currentTimeMillis());
		// setMediaId("sX-A3AylJ4DwYEfQLhFRSjq_FDddtW-OcbTAZpVsVJY");
		setImage(new WXImage(ImageStr));
	}

	public WXImage getImage() {
		return Image;
	}

	public void setImage(WXImage image) {
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

}
