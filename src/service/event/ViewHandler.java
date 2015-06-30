package service.event;

import entity.InputMessage;
import service.AbstractHandler;

public class ViewHandler extends AbstractHandler {

	@Override
	public void handle(InputMessage im) {
		if(im.getEvent().equals("VIEW")){
			System.out.println("VIEW handler~~");
		}
		if(nextHandler != null)
			nextHandler.handle(im);
	}

}
