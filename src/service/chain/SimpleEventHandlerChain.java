package service.chain;

import entity.InputMessage;

public class SimpleEventHandlerChain extends AbstractEventHandlerChain {

	public SimpleEventHandlerChain() {
		clickHandler.setNextHandler(locationEventHandler);
		setEntryHandler(clickHandler);

		locationEventHandler.setNextHandler(scanHandler);
		scanHandler.setNextHandler(subscribeHandler);
		subscribeHandler.setNextHandler(unSubscribeHandler);
		unSubscribeHandler.setNextHandler(viewHandler);
	}
}
