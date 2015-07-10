package service.factory;

import java.util.Properties;

import entity.InputMessage;
import entity.InputMessageAbstract;
import service.AbstractHandler;
import service.factory.AbstractFactory;
import util.PropertyUtil;

/**
 * 自己的业务逻辑的工厂
 * 
 * @author Vanxd
 *
 */
public class CommonFactory extends AbstractFactory {

	/**
	 * 用im.getMsgType的值来反射要返回哪一个handler
	 */
	@Override
	public AbstractHandler getInstance(InputMessageAbstract im) {
		if (im.getMsgType() == null) {
			System.out.println("no MsgType ");
			return FactoryUtil.isNextFactory(im, nextFactory);
		}
		String className = getProperties().getProperty(im.getMsgType());
		if (className == null) {
			System.out.println("ignore this type, go to next factory");
			return FactoryUtil.isNextFactory(im, nextFactory);
		}

		try {
			Class<?> abstractHandler = Class.forName(className);
			AbstractHandler handler = (AbstractHandler) abstractHandler
					.newInstance();
			return handler;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

}
