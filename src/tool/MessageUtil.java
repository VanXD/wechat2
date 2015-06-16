package tool;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;
import net.sf.json.groovy.JsonGroovyBuilder;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;

import entity.button.Button;
import entity.button.ButtonSummary;
import entity.button.Button;

public class MessageUtil {
	public static final String appID = "wxc1ca2ea6a518621b";
	public static final String appsecret = "bf3efce70d4a2e196dcc9b6ef0f478b6";
	public static final String accessTokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
			+ appID + "&secret=" + appsecret;
	
	private static String lastAccessToken;
	//毫秒 2个小时：7200000
	private static long lastATTime = 0;
	private static long ATIntervalRequestTime = 7200000;
	public static <T> String objToXml(T t) {
		XStream xml = new XStream();
		xml.alias("xml", t.getClass());
		return xml.toXML(t);
	}

	public static String getAccess_token() {
		
		//如果超过间隔AT使用时间
		if(System.currentTimeMillis() - lastATTime < ATIntervalRequestTime)
			return lastAccessToken;
		
		String url = accessTokenUrl;
		String accessToken = null;
		
		try {
			HttpURLConnection http = HttpTools.initHttp(accessTokenUrl, "GET");
			http.connect();

			String message = HttpTools.getResult(http);

			JSONObject demoJson = JSONObject.fromObject(message);
			accessToken = demoJson.getString("access_token");

			System.out.println(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		lastAccessToken = accessToken;
		lastATTime = System.currentTimeMillis();
		return accessToken;
	}

	/**
	 * 创建Menu
	 * 
	 * @Title: createMenu
	 * @Description: 创建Menu
	 * @param @return
	 * @param @throws IOException 设定文件
	 * @return int 返回类型
	 * @throws
	 */
	public static String createMenu(String menu) {
		System.out.println(menu);
		String access_token = getAccess_token();

		String action = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token="
				+ access_token;
		try {
			HttpURLConnection http = HttpTools.initHttp(action, "POST");
			http.connect();
			String message = HttpTools.getResult(http);
			return "返回信息" + message;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "createMenu 失败";
	}

	public static void main(String[] args) {
		System.out.println(createMenu(createMenuiii()));
		// System.out.println(deleteMenu());
		// System.out.println(getAccess_token());

	}

	public static String createMenuiii() {
		ButtonSummary bs = new ButtonSummary();
		Button[] button = new Button[3];

		button[0] = new Button();
		button[0].setName("扫码");
		Button[] subButton = new Button[2];
		subButton[0] = new Button();
		subButton[0].setType(ButtonTypeEnum.SCANCODE_WAITMSG.toString());
		subButton[0].setName("扫码带提示");
		subButton[0].setKey("rselfmenu_0_0");
		subButton[1] = new Button();
		subButton[1].setType(ButtonTypeEnum.SCANCODE_PUSH.toString());
		subButton[1].setName("扫码推事件");
		subButton[1].setKey("rselfmenu_0_1");
		button[0].setSub_button(subButton);

		button[1] = new Button();
		button[1].setName("发图吧");
		subButton = new Button[3];
		subButton[0] = new Button();
		subButton[0].setType(ButtonTypeEnum.PIC_SYSPHOTO.toString());
		subButton[0].setName("系统拍照发图");
		subButton[0].setKey("rselfmenu_1_0");
		subButton[1] = new Button();
		subButton[1].setType(ButtonTypeEnum.PIC_PHOTO_OR_ALBUM.toString());
		subButton[1].setName("拍照或者相册发图");
		subButton[1].setKey("rselfmenu_1_1");
		subButton[2] = new Button();
		subButton[2].setType(ButtonTypeEnum.PIC_WEIXIN.toString());
		subButton[2].setName("微信相册发图");
		subButton[2].setKey("rselfmenu_1_2");
		button[1].setSub_button(subButton);

		button[2] = new Button();
		button[2].setName("发送位置");
		button[2].setType(ButtonTypeEnum.LOCATION_SELECT.toString());
		button[2].setKey("rselfmenu_2_0");

		bs.setButton(button);

		JSONObject jsonObject = JSONObject.fromObject(bs);
		return jsonObject.toString();
	}

	public static String deleteMenu() {
		String access_token = getAccess_token();
		String action = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token="
				+ access_token;
		try {
			HttpURLConnection http = HttpTools.initHttp(action, "GET");
			http.connect();
			String message = HttpTools.getResult(http);
			return "deleteMenu返回信息:" + message;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "deleteMenu 失败";
	}

}