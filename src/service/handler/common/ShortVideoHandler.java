package service.handler.common;

import com.aliapp.wxxd.material.entity.InputMessage;
import com.aliapp.wxxd.material.entity.InputMessageAbstract;
import com.aliapp.wxxd.material.entity.outputmessage.OutputMessageAbstract;
import com.aliapp.wxxd.material.entity.outputmessage.basic.TextOutputMessage;

import service.AbstractHandler;

public class ShortVideoHandler extends AbstractHandler {

	@Override
	public OutputMessageAbstract handle(InputMessageAbstract im) {
		if (im.getMsgType().equals("shortvideo")) {
			System.out.println("ShortVideoHandler handler~~");
			oma = new TextOutputMessage("ShortVideoHandler handler~~~");
			oma.inject(im);
			return oma;
		}
		return null;
	}

}
