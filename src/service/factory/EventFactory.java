package service.factory;

import java.util.Properties;

import com.aliapp.wxxd.material.entity.InputMessage;
import com.aliapp.wxxd.material.entity.InputMessageAbstract;

import service.AbstractHandler;
import service.factory.AbstractFactory;
import util.PropertyUtil;

/**
 * 自己的业务逻辑的工厂
 * 
 * @author Vanxd
 *
 */
public class EventFactory extends AbstractFactory {

	/**
	 * 用im.getEvent的值来反射要返回哪一个handler
	 */
	@Override
	public AbstractHandler getInstance(InputMessageAbstract im) {
		if (im.getEvent() == null) {
			System.out.println("no Event, ");
			return FactoryUtil.isNextFactory(im, nextFactory);
		}
		String className = getProperties().getProperty(im.getEvent());
		if (className == null) {
			System.out.println("ignore this Event, go to next factory");
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
