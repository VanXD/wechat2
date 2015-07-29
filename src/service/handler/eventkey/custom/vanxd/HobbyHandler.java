package service.handler.eventkey.custom.vanxd;

import interfaces.TextAnswerInterface;
import entity.InputMessageAbstract;
import entity.outputmessage.OutputMessageAbstract;
import entity.outputmessage.basic.TextOutputMessage;
import service.AbstractHandler;
import util.ienum.VanXDEventKeyEnum;

public class HobbyHandler extends AbstractHandler implements
		TextAnswerInterface {

	@Override
	public OutputMessageAbstract handle(InputMessageAbstract im) {
		if (im.getEventKey().equals(VanXDEventKeyEnum.HOBBY.toString())) {
			System.out.println("HobbyHandler handler~~");
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
		StringBuilder answer = new StringBuilder();
		answer.append("1.热爱看架构类与原理类书籍.~\n");
		answer.append("2.偶尔打游戏,LOL,DOTA2.\n");
		answer.append("3.其实还喜欢运动，就是身体太差~\n");
		return answer.toString();
	}

}
