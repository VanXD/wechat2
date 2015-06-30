package test;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;

import org.junit.Test;

import net.sf.json.JSONObject;
import service.AbstractHandler;
import service.EventService;
import service.chain.AbstractNormalHandlerChain;
import service.chain.SimpleHandlerChain;
import util.HttpTools;
import util.MessageFactory;
import util.MessageUtil;
import entity.InputMessage;
import entity.article.WXArticles;
import entity.article.WXItem;
import entity.outputmessage.OutputMessageAbstract;
import entity.outputmessage.mass.ArticleSummary;
import entity.outputmessage.mass.ArticlesMassOutputMessage;
import entity.outputmessage.mass.MsgTypeOutputMessage;
import entity.outputmessage.mass.OpenIDOutputMessage;
import entity.outputmessage.mass.type.ImageMassOutputMessage;
import entity.outputmessage.mass.type.NewsMassOutputMessage;
public class TestMain {
	InputMessage im = new InputMessage();
	//新增永久图文素材
	@Test
	public void addPernate(){
		
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
	//群发图文消息
	@Test
	public void massMessage(){
		
//		https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=ACCESS_TOKEN
		String[] touser = new String[2];
		touser[0] = "oJWm_vrtWITI4VCtv_slja8mvzhU";
		touser[1] = "oJWm_vl3UHq6-AidG0qQV3RgsJrA";
		
		NewsMassOutputMessage openIDOutputMessage = new NewsMassOutputMessage(); 
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
	public void textSimpleChianHandler(){
		AbstractNormalHandlerChain simpleHandlerChain = new SimpleHandlerChain();
		im.setMsgType("event");
		im.setEvent("subscribe");
		simpleHandlerChain.process(im);
	}
}
