package service.handler.common;

import com.aliapp.wxxd.material.entity.InputMessageAbstract;
import com.aliapp.wxxd.material.entity.outputmessage.OutputMessageAbstract;
import com.aliapp.wxxd.material.entity.outputmessage.basic.TextOutputMessage;

import service.AbstractHandler;

public class EventHandler extends AbstractHandler{

	@Override
	public OutputMessageAbstract handle(InputMessageAbstract im) {
		if (im.getMsgType().equals("event")) {
			System.out.println("EventHandler handler~~");
			oma = new TextOutputMessage("ImageHandler handler~~~");
			oma.inject(im);
			return oma;
		}
		return null;
	}

}
