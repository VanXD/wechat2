package test;

import service.EventService;
import tool.ILOVEYOU;
import tool.MessageFactory;
import tool.MessageUtil;
import entity.InputMessage;
import entity.outputmessage.OutputMessageAbstract;

public class Test {
	public static void main(String[] args) {
		InputMessage im = new InputMessage();
		im.setCreateTime(12321L);
		im.setMsgType("event");
		im.setEvent("subscribe");
		im.setFromUserName("fromusername");
		im.setToUserName("tousername");
		
		EventService es = MessageFactory.generateOutPutMessage(im
				.getMsgType());
		// 调用相应的service factory
		
		OutputMessageAbstract oma = es.normal(im);
		// 输出
		System.out.println(MessageUtil.objToXml(oma));
		
	}
}
