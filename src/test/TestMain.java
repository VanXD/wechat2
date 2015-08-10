package test;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.junit.Test;

import com.aliapp.wxxd.material.entity.InputMessage;
import com.aliapp.wxxd.material.entity.Result;
import com.aliapp.wxxd.material.entity.WXMedia;
import com.aliapp.wxxd.material.entity.article.WXItem;
import com.aliapp.wxxd.material.entity.batch.BatchArticleSummary;
import com.aliapp.wxxd.material.entity.batch.BatchSummary;
import com.aliapp.wxxd.material.entity.button.Button;
import com.aliapp.wxxd.material.entity.button.ButtonSummary;
import com.aliapp.wxxd.material.entity.db.Material;
import com.aliapp.wxxd.material.entity.outputmessage.OutputMessageAbstract;
import com.aliapp.wxxd.material.entity.outputmessage.basic.ArticleOutputMessage;
import com.aliapp.wxxd.material.entity.outputmessage.basic.ImageOutputMessage;
import com.aliapp.wxxd.material.entity.outputmessage.basic.TextOutputMessage;
import com.aliapp.wxxd.material.entity.outputmessage.mass.ArticleSummary;
import com.aliapp.wxxd.material.entity.outputmessage.mass.ArticlesMassOutputMessage;
import com.aliapp.wxxd.material.entity.outputmessage.mass.MsgTypeOutputMessage;
import com.aliapp.wxxd.material.entity.outputmessage.mass.OpenIDOutputMessage;
import com.aliapp.wxxd.material.entity.outputmessage.mass.type.ArticleMassOutputMessage;
import com.aliapp.wxxd.material.entity.outputmessage.mass.type.ImageMassOutputMessage;
import com.aliapp.wxxd.material.service.MaterialWeChatService;

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
import util.wechat.request.url.WechatMaterialRequestURL;

public class TestMain {
	InputMessage im = new InputMessage();

	@Test
	public void practice() {
		Object a = new WXMedia("123");
		System.out.println(a.getClass());

	}

	private <T> T getTClass(int i) {
		if (i == 0)
			return (T) new Object();
		else
			return (T) new Material();
	}

	// 测试获取指定永久素材
	// FpStB0Ex0Kse-xROWhfBoTlNkwX9lmQZjIVdfYli6qw
	@Test
	public void testGetArticleMaterial() {
		MaterialWeChatService service = new MaterialWeChatService();

		MsgTypeOutputMessage msgTypeOutputMessage = new MsgTypeOutputMessage();
		msgTypeOutputMessage
				.setMedia_id("YJMI9Tj7ILTv9DK1H8NFi2Jd95EWd0hNXWLt6CJmz0s");
		HttpURLConnection http = HttpTools.initHttp(
				WechatMaterialRequestURL.GET_MATERIAL + MessageUtil.getAccess_token(),
				"POST");

		// 放入json参数
		DataOutputStream out = HttpTools.jsonData(http,
				JSONObject.fromObject(msgTypeOutputMessage));


		try {
			HttpTools.sendRequest(out, http);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InputStream in = HttpTools.getInputStreamResult(http);
		createNewFile(in);
	}

	public void createNewFile(InputStream in) {
		// 使用本地文件系统接受网络数据并存为新文件
		File file = new File("newFile.jpg");
		RandomAccessFile raf;
		try {
			file.createNewFile();
			raf = new RandomAccessFile(file, "rw");
			byte[] buf = new byte[2048];

			int num = in.read(buf);

			while (num != (-1)) {// 是否读完所有数据
				raf.write(buf, 0, num);// 将数据写往文件
				raf.skipBytes(num);// 顺序写文件字节
				num = in.read(buf);// 继续从网络中读取文件
			}
			in.close();
			raf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

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

	@Test
	public void tesAddImage() {

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

	@Test
	public void testAddNews() {
		MaterialWeChatService s = new MaterialWeChatService();
	}

	@Test
	public void testGetMaterial() {
		MaterialWeChatService s = new MaterialWeChatService();
		System.out
				.println(s
						.getArticleMaterial("36BbxqEys5zmqImZ5WrHPIKyODVZwWGD6bOKyqi_srk"));
	}

	@Test
	public void testUpdateNews() {
		MaterialWeChatService s = new MaterialWeChatService();
	}

	@Test()
	public void testBatchGetMaterial() {
		MaterialWeChatService s = new MaterialWeChatService();
	}

	@Test
	public void testBatchSummary() {
		String s = "{'item':[{'media_id':'36BbxqEys5zmqImZ5WrHPJ44vFJw254Vy6vw2bCGB_Y','content':{'news_item':[{'title':'fdasfs','author':'vanxd','digest':'digest','content':'dasdsa','content_source_url':'','thumb_media_id':'JilFq5lLY6Y-Z4nCTA3naLx1xuYKVDW6oW4hLHTURTM','show_cover_pic':1,'url':'http://mp.weixin.qq.com/s?__biz=MzIwMDIxNTMzMw==&mid=207412948&idx=1&sn=970a4bd4483cf457891fbf968319b161#rd'}]},'update_time':1436921472},{'media_id':'36BbxqEys5zmqImZ5WrHPBxxsjGjaRtDFIWmb3AZ2fc','content':{'news_item':[{'title':'fda','author':'fdas','digest':'digest','content':'fdas','content_source_url':'','thumb_media_id':'JilFq5lLY6Y-Z4nCTA3naLx1xuYKVDW6oW4hLHTURTM','show_cover_pic':1,'url':'http://mp.weixin.qq.com/s?__biz=MzIwMDIxNTMzMw==&mid=207412930&idx=1&sn=93e289f6eab0f599f9d8f10f092fa7ec#rd'}]},'update_time':1436920967},{'media_id':'CHfpVtZOGaqBYdnBUhwMm71NHjwe8ir_yC3hgsJAn8E','content':{'news_item':[{'title':'aaaaaaa','author':'VanXD','digest':'digist','content':'i..?/????ӄ,;;~','content_source_url':'http://dsa','thumb_media_id':'JilFq5lLY6Y-Z4nCTA3naLx1xuYKVDW6oW4hLHTURTM','show_cover_pic':1,'url':'http://mp.weixin.qq.com/s?__biz=MzIwMDIxNTMzMw==&mid=207402124&idx=1&sn=d2d29c25462272bf5c7089f9e09caa8c#rd'}]},'update_time':1436865165}],'total_count':22,'item_count':3}";
		// String s = "{'errcode':-1,'errmsg':'system error'}";
		JSONObject jsonO = JSONObject.fromObject(s);
		Object resultObject = null;
		try {
			resultObject = getResult(s);
			System.out.println("1232");
		} catch (net.sf.json.JSONException e) {
			System.out.println("Batch success.");
			resultObject = getBatchObj(s);
		}
		// BatchSummary bs = (BatchSummary) JSONObject.toBean(jsonO,
		// BatchSummary.class);
		System.out.println(resultObject);
	}

	private BatchSummary getBatchObj(String resultString) {
		System.out.println(resultString);
		JSONObject result = JSONObject.fromObject(resultString);
		return (BatchSummary) JSONObject.toBean(result, BatchSummary.class);
	}

	private Result getResult(String resultString)
			throws net.sf.json.JSONException {
		System.out.println(resultString);
		JSONObject resultJson = JSONObject.fromObject(resultString);
		Result result = (Result) JSONObject.toBean(resultJson, Result.class);
		if (result.getErrcode() == null)
			throw new net.sf.json.JSONException();
		else
			return result;
	}

	@Test
	public void testGetMaterialCount() {
		MaterialWeChatService s = new MaterialWeChatService();
		Object result = s.getMaterialCount();
		System.out.println(result);
	}

	@Test
	public void testDelete() {
		// 36BbxqEys5zmqImZ5WrHPIKyODVZwWGD6bOKyqi_srk
		MaterialWeChatService s = new MaterialWeChatService();
		System.out.println(s
				.delMaterial("36BbxqEys5zmqImZ5WrDDIKyODVZwWGD6bOKyqi_srk"));

	}

	@Test
	public void testGetTargetClass() {
		// String s =
		// "{'voice_count':0,'video_count':0,'image_count':17,'news_count':22}";
		// String s = "{'errcode':-1,'errmsg':'system error'}";
		String s = "{'item':[{'media_id':'36BbxqEys5zmqImZ5WrHPJ44vFJw254Vy6vw2bCGB_Y','content':{'news_item':[{'title':'fdasfs','author':'vanxd','digest':'digest','content':'dasdsa','content_source_url':'','thumb_media_id':'JilFq5lLY6Y-Z4nCTA3naLx1xuYKVDW6oW4hLHTURTM','show_cover_pic':1,'url':'http://mp.weixin.qq.com/s?__biz=MzIwMDIxNTMzMw==&mid=207412948&idx=1&sn=970a4bd4483cf457891fbf968319b161#rd'}]},'update_time':1436921472},{'media_id':'36BbxqEys5zmqImZ5WrHPBxxsjGjaRtDFIWmb3AZ2fc','content':{'news_item':[{'title':'fda','author':'fdas','digest':'digest','content':'fdas','content_source_url':'','thumb_media_id':'JilFq5lLY6Y-Z4nCTA3naLx1xuYKVDW6oW4hLHTURTM','show_cover_pic':1,'url':'http://mp.weixin.qq.com/s?__biz=MzIwMDIxNTMzMw==&mid=207412930&idx=1&sn=93e289f6eab0f599f9d8f10f092fa7ec#rd'}]},'update_time':1436920967},{'media_id':'CHfpVtZOGaqBYdnBUhwMm71NHjwe8ir_yC3hgsJAn8E','content':{'news_item':[{'title':'aaaaaaa','author':'VanXD','digest':'digist','content':'i..?/????ӄ,;;~','content_source_url':'http://dsa','thumb_media_id':'JilFq5lLY6Y-Z4nCTA3naLx1xuYKVDW6oW4hLHTURTM','show_cover_pic':1,'url':'http://mp.weixin.qq.com/s?__biz=MzIwMDIxNTMzMw==&mid=207402124&idx=1&sn=d2d29c25462272bf5c7089f9e09caa8c#rd'}]},'update_time':1436865165}],'total_count':22,'item_count':3}";
		Object resultObject = null;
		try {
			resultObject = getTargetClass(s, new Result());
			if (resultObject instanceof Result) {
				if (((Result) resultObject).getErrcode() == null) {
					throw new net.sf.json.JSONException();
				}
			}
		} catch (net.sf.json.JSONException e) {
			resultObject = getTargetClass(s, new BatchSummary());
		}

		System.out.println(resultObject);
	}

	private <T> T getTargetClass(String resultString, T t) {
		System.out.println(resultString);
		JSONObject result = JSONObject.fromObject(resultString);
		return (T) JSONObject.toBean(result, t.getClass());
	}
	
}
