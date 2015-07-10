package service.factory;

import service.AbstractHandler;
import entity.InputMessageAbstract;

public class FactoryUtil {
	public static  AbstractHandler isNextFactory(InputMessageAbstract im, AbstractFactory nextFactory) {
		if (nextFactory != null)
			return nextFactory.getInstance(im);
		else
			return null;
	}
}
