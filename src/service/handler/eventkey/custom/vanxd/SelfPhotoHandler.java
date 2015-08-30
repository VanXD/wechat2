package service.handler.eventkey.custom.vanxd;

import java.util.ArrayList;
import java.util.List;

import com.aliapp.wxxd.material.entity.InputMessageAbstract;
import com.aliapp.wxxd.material.entity.article.WXItem;
import com.aliapp.wxxd.material.entity.outputmessage.OutputMessageAbstract;
import com.aliapp.wxxd.material.entity.outputmessage.basic.ArticleOutputMessage;

import service.AbstractHandler;
import util.ienum.VanXDEventKeyEnum;

public class SelfPhotoHandler extends AbstractHandler {

	@Override
	public OutputMessageAbstract handle(InputMessageAbstract im) {
		if (im.getEventKey().equals(VanXDEventKeyEnum.SELF_PHOTO.toString())) {
			System.out.println("SelfPhotoHandler handler~~");
			List<WXItem> wxItem = new ArrayList<WXItem>();
			
			wxItem.add(new WXItem(
					"微信SDK结构",
					"恩..这是微信工程的结构,UPDATE TIME:2015年7月22日 13:18:34",
					"https://mmbiz.qlogo.cn/mmbiz/PduSZ63J80u9p6RCYQWvpRu5FDtCNqQ64CZLhkBFyAuw0vkuCmqukL6iaGMqcQjZCTMH2dQsJEcAuEId9u3dlKg/0?wx_fmt=png",
					"http://naotu.baidu.com/viewshare.html?shareId=awwbw1ypp2ps"));
			wxItem.add(new WXItem(
					"微信SDK结构",
					"恩..这是微信工程的结构,UPDATE TIME:2015年7月10日 11:10:24",
					"http://a2.qpic.cn/psb?/V12xrU4p2SDIl1/QlsnmBCC7.ebSFwjW4WCTyu0vsWbmkkPISk6HT80Qko!/b/dDTws20fDwAA&bo=kAWAAgAAAAADBzU!&rf=viewer_4",
					"http://naotu.baidu.com/viewshare.html?shareId=awwbw1ypp2ps"));
			wxItem.add(new WXItem(
					"微信SDK结构",
					"恩..这是微信工程的结构,嘻嘻~",
					"http://a2.qpic.cn/psb?/V12xrU4p2SDIl1/4YsFKU1cxKEP8AiTgoHYyj1Uhoqyvv2tDNPG09AZ7*8!/b/dDa0rW2cDgAA&bo=ZwWAAgAAAAADB8I!&rf=viewer_4",
					"http://naotu.baidu.com/viewshare.html?shareId=awwbw1ypp2ps"));
			oma = new ArticleOutputMessage(wxItem.size(), wxItem);
			oma.inject(im);
			return oma;
		}
		return null;
	}

}
