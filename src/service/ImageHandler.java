package service;

import entity.InputMessage;

public class ImageHandler extends AbstractHandler{

	@Override
	public void handle(InputMessage im) {
		if(im.getMsgType().equals("image")){
			System.out.println("image handler~~");
		}
		if(nextHandler != null)
			nextHandler.handle(im);
	}

}
