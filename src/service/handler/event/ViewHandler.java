package service.handler.event;

import com.aliapp.wxxd.material.entity.InputMessage;
import com.aliapp.wxxd.material.entity.InputMessageAbstract;
import com.aliapp.wxxd.material.entity.outputmessage.OutputMessageAbstract;
import com.aliapp.wxxd.material.entity.outputmessage.basic.TextOutputMessage;

import service.AbstractHandler;

public class ViewHandler extends AbstractHandler {

	@Override
	public OutputMessageAbstract handle(InputMessageAbstract im) {
		if (im.getEvent().equals("VIEW")) {
			System.out.println("ViewHandler handler~~");
			oma = new TextOutputMessage("ViewHandler handler~~~");
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
