package service;

import entity.InputMessage;

public class TextHandler extends AbstractHandler {

	@Override
	public void handle(InputMessage im) {
		if(im.getMsgType().equals("text")){
			System.out.println("text handler~~");
		}
		if(nextHandler != null)
			nextHandler.handle(im);
	}

}
