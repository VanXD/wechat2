package service.chain;

import service.AbstractHandler;
import service.event.*;

public abstract class AbstractEventHandlerChain extends AbstractHandlerChain {
	protected AbstractHandler clickHandler = new ClickHandler();
	protected AbstractHandler locationEventHandler = new LocationEventHandler();
	protected AbstractHandler scanHandler = new ScanHandler();
	protected AbstractHandler subscribeHandler = new SubscribeHandler();
	protected AbstractHandler unSubscribeHandler = new UnSubscribeHandler();
	protected AbstractHandler viewHandler = new ViewHandler();
}
