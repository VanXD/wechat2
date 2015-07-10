package service.handler.eventkey.custom.vanxd;

import interfaces.TextAnswerInterface;
import entity.InputMessageAbstract;
import entity.outputmessage.OutputMessageAbstract;
import entity.outputmessage.basic.TextOutputMessage;
import service.AbstractHandler;
import util.ienum.VanXDEventKeyEnum;

public class SkillFrontEndHandler extends AbstractHandler implements TextAnswerInterface {

	@Override
	public OutputMessageAbstract handle(InputMessageAbstract im) {
		if (im.getEventKey().equals(VanXDEventKeyEnum.SKILL_FRONT_END.toString())) {
			System.out.println("SkillFrontEndHandler handler~~");
			String reply = answer();
			oma = new TextOutputMessage(reply);
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
		answer.append("1.HTML5 : 能写！\n");
		answer.append("2.JavaScript : 熟悉一些常用API，能完成一些特效(手风琴...)\n");
		answer.append("3.CSS : animation, transition这些高级点的需要查着文档用.~~\n");
		answer.append("4.叫我写写JavaScript还行，写HTML5 + CSS 真的就这个表情,┑(￣▽ ￣)┍  \n");
		return answer.toString();
	}
}
