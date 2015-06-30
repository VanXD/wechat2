package service;

import entity.InputMessage;

public class VoiceHandler extends AbstractHandler {

	@Override
	public void handle(InputMessage im) {
		if(im.getMsgType().equals("voice")){
			System.out.println("voice handler~~");
		}
		if(nextHandler != null)
			nextHandler.handle(im);
	}

}
