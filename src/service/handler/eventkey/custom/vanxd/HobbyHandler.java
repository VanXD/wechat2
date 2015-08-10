package service.handler.eventkey.custom.vanxd;

import com.aliapp.wxxd.material.entity.InputMessageAbstract;
import com.aliapp.wxxd.material.entity.outputmessage.OutputMessageAbstract;
import com.aliapp.wxxd.material.entity.outputmessage.basic.TextOutputMessage;

import interfaces.TextAnswerInterface;
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
		answer.append("1.热爱看计算机相关论文及书籍...~\n");
		answer.append("2.偶尔打游戏,LOL,DOTA2.\n");
		answer.append("3.喜欢尝试新鲜事务,做一些没做过的事.\n");
		return answer.toString();
	}

}
