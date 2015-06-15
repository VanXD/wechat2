package tool;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import service.EventService;
import entity.InputMessage;
import entity.InputMessageAbstract;
import entity.outputmessage.OutputMessageAbstract;
import entity.outputmessage.basic.ImageOutputMessage;
import entity.outputmessage.basic.TextOutputMessage;

public class MessageFactory {
	// 增加类型
	public static EventService generateOutPutMessage(String msgType) {
		MessageTypeEnum mte = MessageTypeEnum.valueOf(msgType.toUpperCase());
		switch (mte) {
		case EVENT:
			return new EventService();
		default:
			return null;
		}
	}

}
