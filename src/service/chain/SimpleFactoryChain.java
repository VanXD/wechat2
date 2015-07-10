package service.chain;

public class SimpleFactoryChain extends AbstractFactoryChain{
	
	public SimpleFactoryChain() {
		vanxdHandlerFactory.setNextHandler(commonFactory);
		setEntry(vanxdHandlerFactory);
		
		commonFactory.setNextHandler(eventFactory);
		
	}
}
