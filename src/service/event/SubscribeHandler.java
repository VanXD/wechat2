package service.event;

import entity.InputMessage;
import service.AbstractHandler;

public class SubscribeHandler extends AbstractHandler {

	@Override
	public void handle(InputMessage im) {
		if(im.getEvent().equals("subscribe")){
			System.out.println("subscribe handler~~");
		}
		if(nextHandler != null)
			nextHandler.handle(im);
	}

}
