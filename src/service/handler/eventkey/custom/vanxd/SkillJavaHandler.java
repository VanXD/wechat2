package service.handler.eventkey.custom.vanxd;

import com.aliapp.wxxd.material.entity.InputMessageAbstract;
import com.aliapp.wxxd.material.entity.outputmessage.OutputMessageAbstract;
import com.aliapp.wxxd.material.entity.outputmessage.basic.TextOutputMessage;

import interfaces.TextAnswerInterface;
import service.AbstractHandler;
import util.ienum.VanXDEventKeyEnum;

public class SkillJavaHandler extends AbstractHandler implements TextAnswerInterface {

	@Override
	public OutputMessageAbstract handle(InputMessageAbstract im) {
		if (im.getEventKey().equals(VanXDEventKeyEnum.SKILL_JAVA.toString())) {
			System.out.println("SkillJavaHandler handler~~");
			oma = new TextOutputMessage(answer());
			oma.inject(im);
			return oma;
		}
		return null;
	}

	@Override
	public String answer() {
		StringBuilder answer = new StringBuilder();
		answer.append("1.SPRING(MVC)4 : 主要使用MVC的视图转发，Spring与其他框架的集成，环境搭建，AOP及IOC的使用。学习了Spring IoC容器的初始化，Bean的注入过程。\n");
		answer.append("2.MyBatis3/Hibernate4 : 大多时候使用它们的逆向工具，将数据库的表逆向到Java代码，并自动生成MAPPER/DAO"
				+ "，并与Spring整合。\n");
		answer.append("3.Shiro : 恩..看完了一本书，练习了一些基本例子~~\n");
		answer.append("4.时时加强练习，熟悉->精通以上知识...\n");
		return answer.toString();
	}

}
