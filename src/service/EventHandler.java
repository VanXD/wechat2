package service;

import service.chain.AbstractEventHandlerChain;
import service.chain.SimpleEventHandlerChain;
import entity.InputMessage;
import entity.InputMessageAbstract;
import entity.outputmessage.OutputMessageAbstract;
import entity.outputmessage.basic.TextOutputMessage;

public class EventHandler extends AbstractHandler{

	@Override
	public OutputMessageAbstract handle(InputMessageAbstract im) {
		if (im.getMsgType().equals("event")) {
			System.out.println("EventHandler handler~~");
			AbstractEventHandlerChain sehc = new SimpleEventHandlerChain();
			return sehc.process(im);
		}
		if (nextHandler != null)
			return nextHandler.handle(im);
		else {
			return null;
		}
	}

}
