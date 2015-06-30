package service;

import entity.InputMessage;

public class LocationHandler extends AbstractHandler {

	@Override
	public void handle(InputMessage im) {
		if(im.getMsgType().equals("location")){
			System.out.println("location handler~~");
		}
		if(nextHandler != null)
			nextHandler.handle(im);
	}

}
