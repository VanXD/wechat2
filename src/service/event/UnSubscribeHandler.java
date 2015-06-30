package service.event;

import entity.InputMessage;
import service.AbstractHandler;

public class UnSubscribeHandler extends AbstractHandler {

	@Override
	public void handle(InputMessage im) {
		if(im.getEvent().equals("unsubscribe")){
			System.out.println("unsubscribe handler~~");
		}
		if(nextHandler != null)
			nextHandler.handle(im);
	}

}
