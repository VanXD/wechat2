package util;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import net.sf.json.JSONObject;

public class HttpTools {
	public static HttpURLConnection initHttp(String action, String method) {
		URL url;
		HttpURLConnection http = null;
		try {

			url = new URL(action);
			http = (HttpURLConnection) url.openConnection();
			http.setRequestMethod(method);
			http.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			http.setDoOutput(true);
			http.setDoInput(true);
			System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒
			System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return http;
	}

	public static String getResult(HttpURLConnection http) {
		OutputStream os;
		String message = null;
		try {
			os = http.getOutputStream();
			os.flush();
			os.close();
			InputStream is = http.getInputStream();
			int size = is.available();
			byte[] jsonBytes = new byte[size];
			is.read(jsonBytes);
			message = new String(jsonBytes, "UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return message;
	}

	public static void jsonData(HttpURLConnection http, JSONObject jsonObject) {
		System.out.println(jsonObject);
		try {
			DataOutputStream out = new DataOutputStream(http.getOutputStream());
			out.writeBytes(jsonObject.toString());
			http.connect();
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
