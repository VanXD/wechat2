package util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.web.multipart.MultipartFile;

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
			if (method == "POST")
				http.setUseCaches(false);
			// 设置请求头信息
			http.setRequestProperty("Connection", "Keep-Alive");
			http.setRequestProperty("Charset", "UTF-8");
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

	public static DataOutputStream sendMediaRequest(MultipartFile file,
			HttpURLConnection http) throws UnsupportedEncodingException,
			IOException {
		String boundary = "----------" + System.currentTimeMillis();
		http.setRequestProperty("Content-Type",
				"multipart/form-data; boundary=" + boundary);
		// 请求正文信息
		// 第一部分：
		StringBuilder sb = new StringBuilder();
		sb.append("--"); // 必须多两道线
		sb.append(boundary);
		sb.append("\r\n");
		sb.append("Content-Disposition: form-data;name=\"media\";filename=\""
				+ file.getOriginalFilename() + "\" \r\n");
		sb.append("Content-Type:application/octet-stream\r\n\r\n");
		byte[] head = sb.toString().getBytes("utf-8");
		// 获得输出流
		DataOutputStream out = new DataOutputStream(http.getOutputStream());
		// 输出表头
		out.write(head);
		// 文件正文部分
		// 把文件已流文件的方式 推入到url中
		DataInputStream in = new DataInputStream(file.getInputStream());
		int bytes = 0;
		byte[] bufferOut = new byte[1024];
		while ((bytes = in.read(bufferOut)) != -1) {
			out.write(bufferOut, 0, bytes);
		}
		in.close();
		// 结尾部分
		byte[] foot = ("\r\n--" + boundary + "--\r\n").getBytes("utf-8");// 定义最后数据分隔线
		out.write(foot);
		return out;
	}

	/**
	 * <p>
	 * 得到结果转UTF-8的字符串
	 * 
	 * @param http
	 * @return String
	 */
	public static String getResult(HttpURLConnection http) {
		String message = null;
		try {
			InputStream is = getInputStreamResult(http);
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

	/**
	 * <p>
	 * 得到结果的InputStream对象
	 * 
	 * @param http
	 * @return
	 */
	public static InputStream getInputStreamResult(HttpURLConnection http) {
		OutputStream os;
		try {
			os = http.getOutputStream();
			os.flush();
			os.close();
			return http.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 将JSONObject 数据压入http
	 * 
	 * @param http
	 * @param jsonObject
	 */
	public static DataOutputStream jsonData(HttpURLConnection http,
			JSONObject jsonObject) {
		System.out.println("压入jsonObject:");
		System.out.println(jsonObject);
		DataOutputStream out = null;
		try {
			out = new DataOutputStream(http.getOutputStream());
			out.writeBytes(jsonObject.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return out;
	}

	public static void sendRequest(DataOutputStream out, HttpURLConnection http)
			throws IOException {
		http.connect();
		if(out != null){
			out.flush();
			out.close();
		}
	}

	public static DataOutputStream jsonData(HttpURLConnection http,
			String jsonString) {
		System.out.println("压入jsonString:");
		System.out.println(jsonString);
		DataOutputStream out = null;
		try {
			out = new DataOutputStream(http.getOutputStream());
			out.writeBytes(jsonString);
			http.connect();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return out;
	}

}
