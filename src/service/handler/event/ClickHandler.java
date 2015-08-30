package service.handler.event;

import com.aliapp.wxxd.material.entity.InputMessageAbstract;
import com.aliapp.wxxd.material.entity.outputmessage.OutputMessageAbstract;
import com.aliapp.wxxd.material.entity.outputmessage.basic.TextOutputMessage;

import service.AbstractHandler;

public class ClickHandler extends AbstractHandler {

	@Override
	public OutputMessageAbstract handle(InputMessageAbstract im) {
		if (im.getEvent().equals("CLICK")) {
			System.out.println("CLICK handler~~");
			oma = new TextOutputMessage("ClickHandler handler~~~");
			oma.inject(im);
			return oma;
		}
		return null;
	}

}
