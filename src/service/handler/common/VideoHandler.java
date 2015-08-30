package service.handler.common;

import com.aliapp.wxxd.material.entity.InputMessage;
import com.aliapp.wxxd.material.entity.InputMessageAbstract;
import com.aliapp.wxxd.material.entity.outputmessage.OutputMessageAbstract;
import com.aliapp.wxxd.material.entity.outputmessage.basic.TextOutputMessage;
import com.aliapp.wxxd.material.entity.outputmessage.basic.VideoOutputMessage;

import service.AbstractHandler;

public class VideoHandler extends AbstractHandler {

	@Override
	public OutputMessageAbstract handle(InputMessageAbstract im) {
		if (im.getMsgType().equals("video")) {
			System.out.println("VideoHandler handler~~");
			oma = new VideoOutputMessage();
			oma.inject(im, "1", "2", "3");
			return oma;
		}
		return null;
	}

}
