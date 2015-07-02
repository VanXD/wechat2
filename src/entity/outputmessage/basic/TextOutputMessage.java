package entity.outputmessage.basic;

import java.util.Map;

import entity.InputMessageAbstract;
import entity.outputmessage.OutputMessageAbstract;

public class TextOutputMessage extends OutputMessageAbstract {

	private String MsgType = "text";
	private String Content;

	@Override
	public void inject(InputMessageAbstract ima) {
		setToUserName(ima.getFromUserName());
		setFromUserName(ima.getToUserName());
		setCreateTime(System.currentTimeMillis());
		setContent(Content);
	}

	public TextOutputMessage() {
	}

	public TextOutputMessage(String content) {
		Content = content;
	}

	@Override
	public String getMsgType() {
		return MsgType;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	@Override
	public void inject(InputMessageAbstract ima, String content) {
		setToUserName(ima.getFromUserName());
		setFromUserName(ima.getToUserName());
		setCreateTime(System.currentTimeMillis());
		setContent(content);
	}

}
