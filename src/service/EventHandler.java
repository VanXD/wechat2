package service;

import service.chain.AbstractEventHandlerChain;
import service.chain.SimpleEventHandlerChain;
import entity.InputMessage;

public class EventHandler extends AbstractHandler{

	@Override
	public void handle(InputMessage im) {
		if(im.getMsgType().equals("event")){
			System.out.println("event handler~~");
			AbstractEventHandlerChain abstractEventHandlerChainnew = new SimpleEventHandlerChain();
			abstractEventHandlerChainnew.process(im);
		}
		if(nextHandler != null)
			nextHandler.handle(im);
	}

}
