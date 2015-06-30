package service.event;

import entity.InputMessage;
import service.AbstractHandler;

public class LocationEventHandler extends AbstractHandler {

	@Override
	public void handle(InputMessage im) {
		if(im.getEvent().equals("LOCATION")){
			System.out.println("LOCATION handler~~");
		}
		if(nextHandler != null)
			nextHandler.handle(im);
	}

}
