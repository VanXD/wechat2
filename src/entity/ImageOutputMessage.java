package entity;

import java.util.Map;

import entity.button.WXImage;

public class ImageOutputMessage extends OutputMessageAbstract {

	/**
	 * 消息类型:文本消息
	 */
	private String MsgType = "image";
	/**
	 * 文本消息
	 */
	private WXImage Image;

	@Override
	public void inject(InputMessageAbstract ima) {
		setToUserName(ima.getFromUserName());
		setFromUserName(ima.getToUserName());
		setCreateTime(System.currentTimeMillis());
		// setMediaId("sX-A3AylJ4DwYEfQLhFRSjq_FDddtW-OcbTAZpVsVJY");
		setImage(new WXImage("sX-A3AylJ4DwYEfQLhFRSjq_FDddtW-OcbTAZpVsVJY"));
	}

	public WXImage getImage() {
		return Image;
	}

	public void setImage(WXImage image) {
		Image = image;
	}

	/**
	 * 创建一个新的 Output Message.并且MsgType的值为text.
	 */
	public ImageOutputMessage() {
	}

	/**
	 * 获取 消息类型
	 * 
	 * @return 消息类型
	 */
	@Override
	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

}
