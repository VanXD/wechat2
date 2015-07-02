package service.common;

import service.AbstractHandler;
import entity.InputMessage;
import entity.InputMessageAbstract;
import entity.outputmessage.OutputMessageAbstract;
import entity.outputmessage.basic.TextOutputMessage;

public class VideoHandler extends AbstractHandler {

	@Override
	public OutputMessageAbstract handle(InputMessageAbstract im) {
		if (im.getMsgType().equals("video")) {
			System.out.println("VideoHandler handler~~");
			oma = new TextOutputMessage("VideoHandler handler~~~");
			oma.inject(im);
			return oma;
		}
		if (nextHandler != null)
			return nextHandler.handle(im);
		else {
			return null;
		}
	}

}
