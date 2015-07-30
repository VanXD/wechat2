package service.handler.common;

import com.aliapp.wxxd.material.entity.InputMessage;
import com.aliapp.wxxd.material.entity.InputMessageAbstract;
import com.aliapp.wxxd.material.entity.outputmessage.OutputMessageAbstract;
import com.aliapp.wxxd.material.entity.outputmessage.basic.TextOutputMessage;

import service.AbstractHandler;

public class LinkHandler extends AbstractHandler {

	@Override
	public OutputMessageAbstract handle(InputMessageAbstract im) {
		if (im.getMsgType().equals("link")) {
			System.out.println("LinkHandler handler~~");
			oma = new TextOutputMessage("LinkHandler handler~~~");
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
