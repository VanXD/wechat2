package service.handler.event;

import com.aliapp.wxxd.material.entity.InputMessage;
import com.aliapp.wxxd.material.entity.InputMessageAbstract;
import com.aliapp.wxxd.material.entity.outputmessage.OutputMessageAbstract;
import com.aliapp.wxxd.material.entity.outputmessage.basic.TextOutputMessage;

import service.AbstractHandler;

public class LocationEventHandler extends AbstractHandler {

	@Override
	public OutputMessageAbstract handle(InputMessageAbstract im) {
		if (im.getEvent().equals("LOCATION")) {
			System.out.println("LocationEventHandler handler~~");
			oma = new TextOutputMessage("LocationEventHandler handler~~~");
			oma.inject(im);
			return oma;
		}
		return null;
	}

}
