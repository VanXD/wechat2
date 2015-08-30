package service.handler.eventkey.custom.vanxd;

import com.aliapp.wxxd.material.entity.InputMessageAbstract;
import com.aliapp.wxxd.material.entity.outputmessage.OutputMessageAbstract;
import com.aliapp.wxxd.material.entity.outputmessage.basic.TextOutputMessage;

import interfaces.TextAnswerInterface;
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
		return null;
	}

	@Override
	public String answer() {
		StringBuilder answer = new StringBuilder();
		answer.append("1.看完了大话设计模式。\n");
		answer.append("2.在这个微信小程序中的捣腾~\n");
		answer.append("  2.1:先是用了简单工厂模式，觉得if条件太多太麻烦，写了一半就丢弃了..\n");
		answer.append("  2.2:后又选择了指责连模式，感觉添加自己的业务逻辑时，要写一个抽象链，具体链，把自己的handler都穿起来，还要在有例如event的地方又放上一条链..等等，觉得还是麻烦..\n");
		answer.append("  2.3:现在使用抽象工厂模式+反射+职责链模式，工厂+反射+properties文件生成出对应的handler,并且利用properties来判断要实现消息的业务。而针对MsgType,Event,EventKey等等会有分支的问题，选择了职责链模式，只用把工厂链起来就行，效率大大增加，代码大量减少!\n");
		answer.append("  2.4:由于增加了与数据库的连接，会导致Controller与多个对象耦合，所以在Controller与Service之间加了一层Facade，将Service封装起来。\n");
		answer.append("3.喜欢设计架构，达到尽可能的聚合，解耦，在校企合作中对多模块不同语言结合提出了外观者模式，并得到认可。\n");
		answer.append("4.感觉做架构设计比写实现代码有意思多了.~ \n");
		return answer.toString();
	}

}
