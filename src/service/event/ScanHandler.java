package service.event;

import entity.InputMessage;
import service.AbstractHandler;

public class ScanHandler extends AbstractHandler {

	@Override
	public void handle(InputMessage im) {
		if(im.getEvent().equals("SCAN")){
			System.out.println("SCAN handler~~");
		}
		if(nextHandler != null)
			nextHandler.handle(im);
	
	}

}
