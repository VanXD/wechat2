package service.chain;

import entity.InputMessageAbstract;
import entity.outputmessage.OutputMessageAbstract;
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
	
	public AbstractHandler process(InputMessageAbstract im) {
		return entry.getInstance(im);
	}
	
	protected void setEntry(AbstractFactory entry) {
		this.entry = entry;
	}
}
