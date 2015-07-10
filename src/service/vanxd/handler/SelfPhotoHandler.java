package service.vanxd.handler;

import java.util.ArrayList;
import java.util.List;

import entity.InputMessageAbstract;
import entity.article.WXItem;
import entity.outputmessage.OutputMessageAbstract;
import entity.outputmessage.basic.ArticleOutputMessage;
import service.AbstractHandler;
import util.ienum.VanXDEventKeyEnum;

public class SelfPhotoHandler extends AbstractHandler {

	@Override
	public OutputMessageAbstract handle(InputMessageAbstract im) {
		if (im.getEventKey().equals(VanXDEventKeyEnum.SELF_PHOTO.toString())) {
			System.out.println("SelfPhotoHandler handler~~");
			List<WXItem> wxItem = new ArrayList<WXItem>();

			WXItem wxItem1 = new WXItem(
					"微信SDK初步结构",
					"恩..这是微信工程的结构,嘻嘻~",
					"http://a2.qpic.cn/psb?/V12xrU4p2SDIl1/4YsFKU1cxKEP8AiTgoHYyj1Uhoqyvv2tDNPG09AZ7*8!/b/dDa0rW2cDgAA&bo=ZwWAAgAAAAADB8I!&rf=viewer_4",
					"http://a2.qpic.cn/psb?/V12xrU4p2SDIl1/4YsFKU1cxKEP8AiTgoHYyj1Uhoqyvv2tDNPG09AZ7*8!/b/dDa0rW2cDgAA&bo=ZwWAAgAAAAADB8I!&rf=viewer_4");
			wxItem.add(wxItem1);
			oma = new ArticleOutputMessage(1, wxItem);
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
