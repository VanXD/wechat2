package service;

import entity.InputMessage;

public class LinkHandler extends AbstractHandler {

	@Override
	public void handle(InputMessage im) {
		if(im.getMsgType().equals("link")){
			System.out.println("link handler~~");
		}
		if(nextHandler != null)
			nextHandler.handle(im);
	}

}
