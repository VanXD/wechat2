package tool;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import entity.ImageOutputMessage;
import entity.InputMessage;
import entity.InputMessageAbstract;
import entity.OutputMessageAbstract;
import entity.TextOutputMessage;

public class MessageFactory {
	// 增加类型
	public static OutputMessageAbstract generateOutPutMessage(String msgType) {
		MessageTypeEnum mte = MessageTypeEnum.valueOf(msgType.toUpperCase());
		switch (mte) {
		case TEXT:
//			return new TextOutputMessage();
			return new ImageOutputMessage();
		default:
			return null;
		}
	}

}
