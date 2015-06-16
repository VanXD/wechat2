package test;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;

import org.junit.Test;

import net.sf.json.JSONObject;
import service.EventService;
import tool.HttpTools;
import tool.MessageFactory;
import tool.MessageUtil;
import entity.InputMessage;
import entity.article.WXArticles;
import entity.article.WXItem;
import entity.outputmessage.OutputMessageAbstract;
import entity.outputmessage.mass.ArticleSummary;
import entity.outputmessage.mass.ArticlesMassOutputMessage;
import entity.outputmessage.mass.MsgTypeOutputMessage;
import entity.outputmessage.mass.OpenIDOutputMessage;
import entity.outputmessage.mass.type.ImageMassOutputMessage;
public class TestMain {
	
	@Test
	public void addPernate(){
		//新增永久图文素材
		ArticlesMassOutputMessage[] amom = new ArticlesMassOutputMessage[1];
		amom[0] = new ArticlesMassOutputMessage();
		amom[0].setAuthor("author");
		amom[0].setContent("content");
		amom[0].setDigest("digist");
		amom[0].setTitle("title");
		amom[0].setShow_cover_pic(1);
		amom[0].setThumb_media_id("waTpuoyFAIjJIFpidEbPbjaY5HZTLYBUml7wEvkt4kw");
		ArticleSummary as = new ArticleSummary();
		as.setArticles(amom);
		JSONObject jsonObject = JSONObject.fromObject(as);
		System.out.println(jsonObject);

		String url = "https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=";

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
	public static void massMessage(){
		//群发图文消息
//		https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=ACCESS_TOKEN
		String[] touser = new String[2];
		touser[0] = "oJWm_vrtWITI4VCtv_slja8mvzhU";
		touser[1] = "oJWm_vl3UHq6-AidG0qQV3RgsJrA";
		
		ImageMassOutputMessage openIDOutputMessage = new ImageMassOutputMessage();
		MsgTypeOutputMessage mtom = new MsgTypeOutputMessage();
		mtom.setMedia_id("waTpuoyFAIjJIFpidEbPbjaY5HZTLYBUml7wEvkt4kw");
		openIDOutputMessage.setImage(mtom);
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
	
	public static void main(String[] args) {
		InputMessage im = new InputMessage();
		im.setCreateTime(12321L);
		im.setMsgType("event");
		im.setEvent("subscribe");
		im.setFromUserName("fromusername");
		im.setToUserName("tousername");

		// EventService es = MessageFactory.generateOutPutMessage(im
		// .getMsgType());
		// 调用相应的service factory

		// OutputMessageAbstract oma = es.normal(im);
		// 输出
		// System.out.println(MessageUtil.objToXml(oma));
	}
}
