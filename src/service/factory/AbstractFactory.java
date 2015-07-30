package service.factory;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;

import com.aliapp.wxxd.material.entity.InputMessage;
import com.aliapp.wxxd.material.entity.InputMessageAbstract;
import com.aliapp.wxxd.material.entity.outputmessage.OutputMessageAbstract;

import service.AbstractHandler;
import util.PropertyUtil;

/**
 * 抽象工厂
 * 
 * @author Vanxd
 *
 */
public abstract class AbstractFactory {
	AbstractFactory nextFactory;

	// 加载properties文件
	protected static PropertyUtil propertyUtil = new PropertyUtil();
	private static Properties properties;
	/**
	 * 通过InputMessage生成相应的handler
	 * 
	 * @param im
	 * @return
	 */
	public abstract AbstractHandler getInstance(InputMessageAbstract im);

	public void setNextHandler(AbstractFactory nextFactory) {
		this.nextFactory = nextFactory;
	}
	
	protected static Properties getProperties() {
		if(properties == null)
			return propertyUtil.loadProperties();
		return properties;
	}
}
