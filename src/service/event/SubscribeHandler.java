package service.event;

import interfaces.TextAnswerInterface;
import entity.InputMessage;
import entity.InputMessageAbstract;
import entity.outputmessage.OutputMessageAbstract;
import entity.outputmessage.basic.TextOutputMessage;
import service.AbstractHandler;

public class SubscribeHandler extends AbstractHandler implements TextAnswerInterface{

	@Override
	public OutputMessageAbstract handle(InputMessageAbstract im) {
		if (im.getEvent().equals("subscribe")) {
			System.out.println("SubscribeHandler handler~~");
			oma = new TextOutputMessage(answer());
			oma.inject(im);
			return oma;
		}
		if (nextHandler != null)
			return nextHandler.handle(im);
		else {
			return null;
		}
	}

	@Override
	public String answer() {
		StringBuilder sb = new StringBuilder();
		sb.append("谢谢关注，我是WeChat 吴耀东~\n");
		sb.append("您可以点击下方按钮，了解我的个人资料~\n");
		sb.append("We are what we repeatedly do. Excellence, then, is not an act, but a habit!\n");
		return sb.toString();
	}

}
