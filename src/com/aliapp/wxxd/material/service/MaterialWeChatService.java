package com.aliapp.wxxd.material.service;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;

import javax.servlet.http.HttpUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aliapp.wxxd.material.entity.Result;
import com.aliapp.wxxd.material.entity.batch.BatchArticleSummary;
import com.aliapp.wxxd.material.entity.batch.BatchRequire;
import com.aliapp.wxxd.material.entity.batch.BatchSummary;
import com.aliapp.wxxd.material.entity.db.Material;
import com.aliapp.wxxd.material.entity.db.MaterialCount;
import com.aliapp.wxxd.material.entity.db.MaterialProxy;
import com.aliapp.wxxd.material.entity.outputmessage.mass.ArticleSummary;
import com.aliapp.wxxd.material.entity.outputmessage.mass.ArticleUpdateSummary;
import com.aliapp.wxxd.material.entity.outputmessage.mass.ArticlesMassOutputMessage;
import com.aliapp.wxxd.material.entity.outputmessage.mass.MsgTypeOutputMessage;
import com.aliapp.wxxd.material.entity.video.Description;
import com.google.gson.JsonArray;

import util.FileUtil;
import util.HttpTools;
import util.MessageUtil;
import util.WechatRequestURL;
import util.ienum.MessageTypeEnum;

/**
 * 与微信官方进行交互
 * @author VanXD
 *
 */
@Service
public class MaterialWeChatService {

	/**
	 * <p>
	 * 增加永久素材
	 * </P>
	 * <p>
	 * 自动判断类型
	 * </p>
	 * 
	 * @param title
	 * @param introduction
	 * @param file
	 * @return Result
	 */
	public Object addMaterial(MaterialProxy materialProxy) {
		String accessToken = MessageUtil.getAccess_token();
		String fileSuffix = FileUtil.getFileSuffix(materialProxy.getFile()
				.getOriginalFilename());
		String fileTyep = FileUtil.getFileType(fileSuffix);
		materialProxy.setType(fileTyep);
		
		HttpURLConnection http = HttpTools.initHttp(
				WechatRequestURL.ADD_MATERIAL + accessToken + "&type="
						+ fileTyep, "POST");
		// 放入json参数,并发送
		if (fileTyep.equals(MessageTypeEnum.VIDEO.toString())) {
			Description desc = new Description(materialProxy.getTitle(),
					materialProxy.getIntroduction());
			HttpTools.jsonData(http, JSONObject.fromObject(desc));
		}
		String resultString = null;
		Object resultObject = null;
		try {
			// 写入文件
			DataOutputStream out = HttpTools.sendMediaRequest(
					materialProxy.getFile(), http);
			// 发送数据
			HttpTools.sendRequest(out, http);
			resultString = HttpTools.getResult(http);
			resultObject = getTargetClass(resultString, new Result());
			isResultNULL(resultObject);
		} catch (net.sf.json.JSONException e) {
			resultObject = getTargetClass(resultString, new Material());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultObject;
	}

	/**
	 * <p>
	 * 增加永久图文素材
	 * 
	 * @param newsProxy
	 *            : 前端整理好的json数据
	 * @return Result
	 */
	public Object addNews(MaterialProxy materialProxy) {
		ArticleSummary as = new ArticleSummary();
		as.setArticles(materialProxy.getArticles());
		JSONObject jsonObject = JSONObject.fromObject(as);
		materialProxy.setType("news");
		String url = WechatRequestURL.ADD_NEWS + MessageUtil.getAccess_token();
		HttpURLConnection http = HttpTools.initHttp(url, "POST");
		DataOutputStream out = HttpTools.jsonData(http, jsonObject);
		String resultString = null;
		Object resultObject = null;

		try {
			HttpTools.sendRequest(out, http);
			resultString = HttpTools.getResult(http);
			resultObject = getTargetClass(resultString, new Result());
			isResultNULL(resultObject);
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (net.sf.json.JSONException e) {
			resultObject = getTargetClass(resultString, new MaterialProxy());
		}
		return resultObject;
	}

	/**
	 * 删除指定mediaId的永久素材，服务器一定会范围Result的正确格式
	 * 
	 * @param mediaId
	 * @return Result
	 */
	public Result delMaterial(String mediaId) {
		MsgTypeOutputMessage msgTypeOutputMessage = new MsgTypeOutputMessage();
		msgTypeOutputMessage.setMedia_id(mediaId);
		HttpURLConnection http = HttpTools.initHttp(
				WechatRequestURL.DEL_MATERIAL + MessageUtil.getAccess_token(),
				"POST");
		// 放入json参数
		DataOutputStream out = HttpTools.jsonData(http,
				JSONObject.fromObject(msgTypeOutputMessage));
		try {
			HttpTools.sendRequest(out, http);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String resultString = HttpTools.getResult(http);
		return getTargetClass(resultString, new Result());
	}

	/**
	 * <p>
	 * 微信返回值是文件内容
	 * 
	 * @param mediaId
	 * @return Result
	 */
	public Object getArticleMaterial(String mediaId) {

		MsgTypeOutputMessage msgTypeOutputMessage = new MsgTypeOutputMessage();
		msgTypeOutputMessage.setMedia_id(mediaId);
		HttpURLConnection http = HttpTools.initHttp(
				WechatRequestURL.GET_MATERIAL + MessageUtil.getAccess_token(),
				"POST");
		// 放入json参数
		DataOutputStream out = HttpTools.jsonData(http,
				JSONObject.fromObject(msgTypeOutputMessage));

		String resultString = null;
		Object resultObject = null;

		try {
			HttpTools.sendRequest(out, http);
			resultString = HttpTools.getResult(http);
			resultObject = getTargetClass(resultString, new Result());
			isResultNULL(resultObject);
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (net.sf.json.JSONException e) {
			resultObject = getTargetClass(resultString,
					new MsgTypeOutputMessage());
		}
		return resultObject;
	}

	public Result updateArticle(MaterialProxy materialProxy) {
		ArticleUpdateSummary articleUpdateSummary = new ArticleUpdateSummary();
		// 将newsProxy 封装到articleUpdateSummary 以用正确的数据结构
		articleUpdateSummary.wrap(materialProxy);

		HttpURLConnection http = HttpTools
				.initHttp(
						WechatRequestURL.UPDATE_ARTICLE
								+ MessageUtil.getAccess_token(), "POST");

		DataOutputStream out = HttpTools.jsonData(http, JSONObject
				.fromObject(JSONObject.fromObject(articleUpdateSummary)));

		try {
			HttpTools.sendRequest(out, http);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String resultString = HttpTools.getResult(http);
		return getTargetClass(resultString, new Result());
	}

	/**
	 * <p>
	 * 没有图文素材
	 * 
	 * @return Result
	 */
	public Result addTempMaterial(MultipartFile file) {

		String accessToken = MessageUtil.getAccess_token();
		String fileSuffix = FileUtil.getFileSuffix(file.getOriginalFilename());
		String fileTyep = FileUtil.getFileType(fileSuffix);
		HttpURLConnection http = HttpTools.initHttp(
				WechatRequestURL.ADD_MATERIAL + accessToken + "&type="
						+ fileTyep, "POST");
		String resultString = null;
		Object resultObject = null;
		try {
			// 发送数据
			DataOutputStream out = HttpTools.sendMediaRequest(file, http);
			HttpTools.sendRequest(out, http);
			resultString = HttpTools.getResult(http);
			resultObject = getTargetClass(resultString, new Result());
			isResultNULL(resultObject);
		} catch (net.sf.json.JSONException e) {
			resultObject = getTargetClass(resultString,
					new MsgTypeOutputMessage());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Object batchGetMaterial(BatchRequire batchRequire) {
		HttpURLConnection http = HttpTools.initHttp(
				WechatRequestURL.BATCH_GET_MATERIAL
						+ MessageUtil.getAccess_token(), "POST");
		// 放入json参数
		DataOutputStream out = HttpTools.jsonData(http,
				JSONObject.fromObject(batchRequire));
		String resultString = null;
		Object resultObject = null;
		try {
			HttpTools.sendRequest(out, http);
			resultString = HttpTools.getResult(http);
			resultObject = getTargetClass(resultString, new Result());
			isResultNULL(resultObject);
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (net.sf.json.JSONException e) {
			resultObject = getTargetClass(resultString, new BatchSummary());
		}
		return resultObject;

	}

	public Object getMaterialCount() {
		HttpURLConnection http = HttpTools.initHttp(
				WechatRequestURL.GET_MATERIAL_COUNT
						+ MessageUtil.getAccess_token(), "GET");

		String resultString = HttpTools.getResult(http);
		Object resultObject = null;

		try {
			resultObject = getTargetClass(resultString, new Result());
			isResultNULL(resultObject);
		} catch (net.sf.json.JSONException e) {
			resultObject = getTargetClass(resultString, new MaterialCount());
		}
		return resultObject;

	}

	private <T> T getTargetClass(String resultString, T t) {
		System.out.println("转换至目标对象：" + t.getClass());
		System.out.println(resultString);
		JSONObject result = JSONObject.fromObject(resultString);
		return (T) JSONObject.toBean(result, t.getClass());
	}
	
	/**
	 * <p>如果返回结果的errcode 为null则抛出异常，在异常里进行转换
	 * @param resultObject
	 */
	private void isResultNULL(Object resultObject) {
		if (resultObject instanceof Result) {
			if (((Result) resultObject).getErrcode() == null) {
				throw new net.sf.json.JSONException();
			}
		}
	}
}
