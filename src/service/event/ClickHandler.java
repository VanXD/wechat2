package service.event;

import entity.InputMessage;
import service.AbstractHandler;

public class ClickHandler extends AbstractHandler {

	@Override
	public void handle(InputMessage im) {
		if(im.getEvent().equals("CLICK")){
			System.out.println("CLICK handler~~");
		}
		if(nextHandler != null)
			nextHandler.handle(im);
	}

}
