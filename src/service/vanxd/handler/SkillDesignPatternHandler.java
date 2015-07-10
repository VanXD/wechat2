package service.vanxd.handler;

import interfaces.TextAnswerInterface;
import entity.InputMessageAbstract;
import entity.outputmessage.OutputMessageAbstract;
import entity.outputmessage.basic.TextOutputMessage;
import service.AbstractHandler;
import util.ienum.VanXDEventKeyEnum;

public class SkillDesignPatternHandler extends AbstractHandler implements TextAnswerInterface{

	@Override
	public OutputMessageAbstract handle(InputMessageAbstract im) {
		if (im.getEventKey().equals(VanXDEventKeyEnum.SKILL_DESIGN_PATTERN.toString())) {
			System.out.println("SkillDesignPatternHandler handler~~");
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
		answer.append("1.看完了大话设计模式。\n");
		answer.append("2.在这个微信小程序中先是使用了工厂模式，觉得IF条件太多比较烦，又换到了职责链模式，发现当想增加自己的业务时，需要写一个chain,和相应多个handler与工厂模式车比较，其实也差不多~\n");
		answer.append("3.喜欢设计架构，达到尽可能的聚合，解耦，在校企合作中对多模块不同语言结合提出了中介者模式，并得到认可。\n");
		answer.append("4.感觉做架构设计比写实现代码有意思多了.~ \n");
		return answer.toString();
	}

}
