package util;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import net.sf.json.JSONObject;

import com.thoughtworks.xstream.XStream;

import entity.article.WXItem;
import entity.button.Button;
import entity.button.ButtonSummary;

public class MessageUtil {
	public static final String appID = "wxc1ca2ea6a518621b";
	public static final String appsecret = "bf3efce70d4a2e196dcc9b6ef0f478b6";
	public static final String accessTokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
			+ appID + "&secret=" + appsecret;

	private static String lastAccessToken;
	// 毫秒 2个小时：7200000
	private static long lastATTime = 0;
	private static long ATIntervalRequestTime = 7200000;

	public static <T> String objToXml(T t) {
		XStream xml = new XStream();
		xml.alias("xml", t.getClass());
		xml.alias("item", WXItem.class);
		return xml.toXML(t);
	}

	public static String getAccess_token() {
		// 如果超过间隔AT使用时间
		if (System.currentTimeMillis() - lastATTime < ATIntervalRequestTime)
			return lastAccessToken;

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

	public static void main(String[] args) {
		// System.out.println(createMenu());
		// System.out.println(deleteMenu());

	}

	public static String deleteMenu() {
		String access_token = getAccess_token();
		String action = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token="
				+ access_token;
		try {
			HttpURLConnection http = HttpTools.initHttp(action, "GET");
			http.connect();
			String message = HttpTools.getResult(http);
			return message;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "deleteMenu 失败";
	}

}