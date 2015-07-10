package service.common;

import service.AbstractHandler;
import entity.InputMessage;
import entity.InputMessageAbstract;
import entity.outputmessage.OutputMessageAbstract;
import entity.outputmessage.basic.TextOutputMessage;
import entity.outputmessage.basic.VideoOutputMessage;

public class VideoHandler extends AbstractHandler {

	@Override
	public OutputMessageAbstract handle(InputMessageAbstract im) {
		if (im.getMsgType().equals("video")) {
			System.out.println("VideoHandler handler~~");
			oma = new VideoOutputMessage();
			oma.inject(im, "1", "2", "3");
			return oma;
		}
		if (nextHandler != null)
			return nextHandler.handle(im);
		else {
			return null;
		}
	}

}
