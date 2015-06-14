package test;

import tool.MessageFactory;
import tool.MessageUtil;
import entity.InputMessage;
import entity.OutputMessageAbstract;

public class Test {
	public static void main(String[] args) {
		InputMessage im = new InputMessage();
		im.setContent("content");
		im.setCreateTime(12321L);
		im.setMsgType("text");
		im.setFromUserName("fromusername");
		im.setToUserName("tousername");

		// 生成outputmessage
		OutputMessageAbstract oma = MessageFactory.generateOutPutMessage(im
				.getMsgType());
		// 注入值
		oma.inject(im);
		// 输出
		System.out.println(MessageUtil.objToXml(oma));
	}
}
