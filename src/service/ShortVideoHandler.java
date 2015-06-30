package service;

import entity.InputMessage;

public class ShortVideoHandler extends AbstractHandler {

	@Override
	public void handle(InputMessage im) {
		if(im.getMsgType().equals("shortvideo")){
			System.out.println("shortvideo handler~~");
		}
		if(nextHandler != null)
			nextHandler.handle(im);
	}

}
