package com.aliapp.wxxd;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;

import util.HttpTools;
import net.sf.json.JSONObject;

import com.aliapp.wxxd.material.entity.Result;

public class WeChatServiceAbstract {
	protected String resultString = null;
	protected Object resultObject = null;
	
	/**
	 * 将数据转换至目标对象类型
	 * @param resultString
	 * @param t
	 * @return
	 */
	protected <T> T getTargetClass(String resultString, T t) {
		System.out.println("转换至目标对象：" + t.getClass());
		System.out.println(resultString);
		JSONObject result = JSONObject.fromObject(resultString);
		return (T) JSONObject.toBean(result, t.getClass());
	}

	/**
	 * <p>
	 * 如果返回结果的errcode 为null则抛出异常，在异常里进行转换
	 * 
	 * @param resultObject
	 */
	protected void isResultNULL(Object resultObject) {
		if (resultObject instanceof Result) {
			if (((Result) resultObject).getErrcode() == null) {
				throw new net.sf.json.JSONException();
			}
		}
	}

	/**
	 * 封装所有发送数据的操作,得到返回结果:resultObject
	 * 
	 * @param out
	 *            : 数据流
	 * @param http
	 *            : HttpURLConnection 连接
	 * @param data
	 *            : 确定类型
	 */
	public <T> void getResult(DataOutputStream out, HttpURLConnection http,
			T data) {
		try {
			HttpTools.sendRequest(out, http);
			resultString = HttpTools.getResult(http);
			resultObject = getTargetClass(resultString, new Result());
			isResultNULL(resultObject);
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (net.sf.json.JSONException e) {
			resultObject = getTargetClass(resultString, data);
		}
	}

	/**
	 * <p>
	 * 封装所有发送数据的操作,得到返回结果:resultObject
	 * <p>
	 * 这个方法一定返回Result
	 * 
	 * @param out
	 *            : 数据流
	 * @param http
	 *            : HttpURLConnection 连接
	 * @param data
	 *            : 确定类型
	 */
	public <T> void getResult(DataOutputStream out, HttpURLConnection http) {
		try {
			HttpTools.sendRequest(out, http);
			resultString = HttpTools.getResult(http);
			resultObject = getTargetClass(resultString, new Result());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
