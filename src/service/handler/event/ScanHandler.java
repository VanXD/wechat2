package service.handler.event;

import com.aliapp.wxxd.material.entity.InputMessage;
import com.aliapp.wxxd.material.entity.InputMessageAbstract;
import com.aliapp.wxxd.material.entity.outputmessage.OutputMessageAbstract;
import com.aliapp.wxxd.material.entity.outputmessage.basic.TextOutputMessage;

import service.AbstractHandler;

public class ScanHandler extends AbstractHandler {

	@Override
	public OutputMessageAbstract handle(InputMessageAbstract im) {
		if (im.getEvent().equals("SCAN")) {
			System.out.println("ScanHandler handler~~");
			oma = new TextOutputMessage("ScanHandler handler~~~");
			oma.inject(im);
			return oma;
		}
		return null;
	}

}
