package test;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.AbstractHandler;
import service.chain.AbstractFactoryChain;
import service.chain.SimpleFactoryChain;
import service.factory.AbstractFactory;
import service.factory.VanxdHandlerFactory;
import util.HttpTools;
import util.MessageUtil;
import util.ienum.ButtonTypeEnum;
import util.ienum.MessageTypeEnum;
import util.ienum.VanXDEventKeyEnum;
import entity.InputMessage;
import entity.article.WXItem;
import entity.button.Button;
import entity.button.ButtonSummary;
import entity.outputmessage.OutputMessageAbstract;
import entity.outputmessage.basic.ArticleOutputMessage;
import entity.outputmessage.basic.ImageOutputMessage;
import entity.outputmessage.basic.TextOutputMessage;
import entity.outputmessage.mass.ArticleSummary;
import entity.outputmessage.mass.ArticlesMassOutputMessage;
import entity.outputmessage.mass.MsgTypeOutputMessage;
import entity.outputmessage.mass.OpenIDOutputMessage;
import entity.outputmessage.mass.type.ImageMassOutputMessage;
import entity.outputmessage.mass.type.ArticleMassOutputMessage;

public class TestMain {
	InputMessage im = new InputMessage();

	// 新增永久图文素材
	@Test
	public void addPernate() {

		ArticlesMassOutputMessage[] amom = new ArticlesMassOutputMessage[1];
		amom[0] = new ArticlesMassOutputMessage();
		amom[0].setAuthor("VanXD");
		amom[0].setContent("恩..这是微信工程的结构,嘻嘻~");
		amom[0].setDigest("digist");
		amom[0].setTitle("微信SDK初步结构");
		amom[0].setShow_cover_pic(1);
		amom[0].setThumb_media_id("JilFq5lLY6Y-Z4nCTA3naLx1xuYKVDW6oW4hLHTURTM");
		ArticleSummary as = new ArticleSummary();
		as.setArticles(amom);
		JSONObject jsonObject = JSONObject.fromObject(as);

		String url = "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=";

		String accessToken = url + MessageUtil.getAccess_token();
		try {
			HttpURLConnection http = HttpTools.initHttp(accessToken, "POST");
			HttpTools.jsonData(http, jsonObject);
			String message = HttpTools.getResult(http);
			System.out.println(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 群发图文消息
	@Test
	public void massMessage() {

		// https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=ACCESS_TOKEN
		String[] touser = new String[2];
		touser[0] = "oJWm_vrtWITI4VCtv_slja8mvzhU";
		touser[1] = "oJWm_vl3UHq6-AidG0qQV3RgsJrA";

		ArticleMassOutputMessage openIDOutputMessage = new ArticleMassOutputMessage();
		MsgTypeOutputMessage mtom = new MsgTypeOutputMessage();
		mtom.setMedia_id("5yCPEid4tiYYD0Gq_gso_RcHsJbto0OgCExb7c5WFEY");
		openIDOutputMessage.setMpnews(mtom);
		openIDOutputMessage.setTouser(touser);
		JSONObject jsonObject = JSONObject.fromObject(openIDOutputMessage);

		System.out.println(jsonObject);
		String url = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=";

		String accessToken = url + MessageUtil.getAccess_token();
		try {
			HttpURLConnection http = HttpTools.initHttp(accessToken, "POST");
			HttpTools.jsonData(http, jsonObject);
			String message = HttpTools.getResult(http);
			System.out.println(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testEventKeyEnum() {
		System.out.println(VanXDEventKeyEnum.HOBBY.toString());
	}

	@Test
	public void createMenu() {
		String access_token = MessageUtil.getAccess_token();

		String action = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token="
				+ access_token;

		ButtonSummary bs = new ButtonSummary();
		Button[] button = new Button[3];

		button[0] = new Button();
		button[0].setName("技能");
		Button[] subButton = new Button[3];
		subButton[0] = new Button();
		subButton[0].setType(ButtonTypeEnum.CLICK.toString());
		subButton[0].setName("JAVA 方向");
		subButton[0].setKey(VanXDEventKeyEnum.SKILL_JAVA.toString());
		subButton[1] = new Button();
		subButton[1].setType(ButtonTypeEnum.CLICK.toString());
		subButton[1].setName("前端");
		subButton[1].setKey(VanXDEventKeyEnum.SKILL_FRONT_END.toString());
		subButton[2] = new Button();
		subButton[2].setType(ButtonTypeEnum.CLICK.toString());
		subButton[2].setName("设计模式");
		subButton[2].setKey(VanXDEventKeyEnum.SKILL_DESIGN_PATTERN.toString());
		button[0].setSub_button(subButton);

		button[1] = new Button();
		button[1].setName("兴趣爱好");
		button[1].setType(ButtonTypeEnum.CLICK.toString());
		button[1].setKey(VanXDEventKeyEnum.HOBBY.toString());

		button[2] = new Button();
		button[2].setName("神秘照片");
		button[2].setType(ButtonTypeEnum.CLICK.toString());
		button[2].setKey(VanXDEventKeyEnum.SELF_PHOTO.toString());

		bs.setButton(button);

		JSONObject jsonObject = JSONObject.fromObject(bs);

		HttpURLConnection http = HttpTools.initHttp(action, "POST");
		HttpTools.jsonData(http, jsonObject);
		String message = HttpTools.getResult(http);
		System.out.println(message);
	}

	@Test
	public void testFactory() {
		AbstractFactory af = new VanxdHandlerFactory();
		im.setMsgType("event");
		im.setEvent("CLICK");
		// im.setEventKey(VanXDEventKeyEnum.SELF_PHOTO.toString());
		AbstractHandler handler = af.getInstance(im);
		if (handler == null) {
			System.out.println("no handler ");
			return;
		}
		OutputMessageAbstract oma = handler.handle(im);
		System.out.println(handler.getClass());
		System.out.println(oma);
		System.out.println(MessageUtil.objToXml(oma));
	}

	@Test
	public void testSimpleFactory() {
		AbstractFactoryChain sf = new SimpleFactoryChain();
		OutputMessageAbstract oma;
		im.setMsgType("event");
		im.setEvent("CLICK");
		im.setEventKey(VanXDEventKeyEnum.SELF_PHOTO.toString());
		AbstractHandler handler = sf.process(im);
		if (handler == null) {
			System.out.println("no handler ");
			oma = new TextOutputMessage("暂不支持此服务,谢谢.");
			oma.inject(im);
		} else {
			oma = handler.handle(im);
		}
		System.out.println(MessageUtil.objToXml(oma));
	}

}
