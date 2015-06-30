package service;

import entity.InputMessage;

public class EventHandler extends AbstractHandler{

	@Override
	public void handle(InputMessage im) {
		if(im.getMsgType().equals("event")){
			System.out.println("event handler~~");
		}
		if(nextHandler != null)
			nextHandler.handle(im);
	}

}
