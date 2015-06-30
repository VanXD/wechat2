package service;

import entity.InputMessage;

public class VideoHandler extends AbstractHandler {

	@Override
	public void handle(InputMessage im) {
		if(im.getMsgType().equals("video")){
			System.out.println("video handler~~");
		}
		
		if(nextHandler != null)
			nextHandler.handle(im);
	}

}
