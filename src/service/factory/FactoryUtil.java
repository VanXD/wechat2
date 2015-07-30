package service.factory;

import com.aliapp.wxxd.material.entity.InputMessageAbstract;

import service.AbstractHandler;

public class FactoryUtil {
	public static  AbstractHandler isNextFactory(InputMessageAbstract im, AbstractFactory nextFactory) {
		if (nextFactory != null)
			return nextFactory.getInstance(im);
		else
			return null;
	}
}
