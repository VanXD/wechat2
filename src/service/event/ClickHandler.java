package service.event;

import entity.InputMessage;
import entity.InputMessageAbstract;
import entity.outputmessage.OutputMessageAbstract;
import entity.outputmessage.basic.TextOutputMessage;
import service.AbstractHandler;
import service.chain.AbstractEventHandlerChain;
import service.chain.AbstractVanXDHandlerChain;
import service.chain.SimpleEventHandlerChain;
import service.chain.VanXDEventKeyHandlerChain;

public class ClickHandler extends AbstractHandler {

	@Override
	public OutputMessageAbstract handle(InputMessageAbstract im) {
		if (im.getEvent().equals("CLICK")) {
			System.out.println("CLICK handler~~");
			AbstractVanXDHandlerChain redirect = new VanXDEventKeyHandlerChain();
			return redirect.process(im);
		}
		if (nextHandler != null)
			return nextHandler.handle(im);
		else {
			return null;
		}
	}

}
