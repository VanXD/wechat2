package entity.outputmessage.mass.type;

import entity.outputmessage.mass.MsgTypeOutputMessage;
import entity.outputmessage.mass.OpenIDOutputMessage;

public class ImageMassOutputMessage extends OpenIDOutputMessage {

	private String msgtype = "image";
	private MsgTypeOutputMessage image;

	public ImageMassOutputMessage() {
	}
	
	public ImageMassOutputMessage(MsgTypeOutputMessage image) {
		this.image = image;
	}

	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	public MsgTypeOutputMessage getImage() {
		return image;
	}

	public void setImage(MsgTypeOutputMessage image) {
		this.image = image;
	}

}
