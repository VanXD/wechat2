package service.chain;

import com.aliapp.wxxd.material.entity.InputMessageAbstract;
import com.aliapp.wxxd.material.entity.outputmessage.OutputMessageAbstract;

import service.AbstractHandler;
import service.factory.AbstractFactory;
import service.factory.CommonFactory;
import service.factory.EventFactory;
import service.factory.VanxdHandlerFactory;

public abstract class AbstractFactoryChain {
	// 链首
	protected AbstractFactory entry;
	
	protected AbstractHandler handler;
	
	protected AbstractFactory commonFactory = new CommonFactory();
	protected AbstractFactory eventFactory  = new EventFactory();
	protected AbstractFactory vanxdHandlerFactory = new VanxdHandlerFactory();
	
	/**
	 * 父亲工厂类的方法，子类不进行覆盖，将执行工厂链的入口类的处理方法
	 * @param im
	 * @return
	 */
	public AbstractHandler process(InputMessageAbstract im) {
		return entry.getInstance(im);
	}
	
	protected void setEntry(AbstractFactory entry) {
		this.entry = entry;
	}
}
