package service.factory;

import java.util.Properties;

import entity.InputMessage;
import entity.InputMessageAbstract;
import service.AbstractHandler;
import service.handler.eventkey.custom.vanxd.SelfPhotoHandler;
import util.PropertyUtil;

/**
 * 自己的业务逻辑的工厂
 * 
 * @author Vanxd
 *
 */
public class VanxdHandlerFactory extends AbstractFactory {

	/**
	 * 用im.getEventKey的值来反射要返回哪一个handler
	 */
	@Override
	public AbstractHandler getInstance(InputMessageAbstract im) {
		if (im.getEventKey() == null) {
			System.out.println("no EventKey, ");
			return FactoryUtil.isNextFactory(im, nextFactory);
		}
		String className = getProperties().getProperty(im.getEventKey());
		if (className == null) {
			System.out.println("ignore this EventKey, go to next factory");
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
