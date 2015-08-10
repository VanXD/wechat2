package com.aliapp.wxxd.material.service;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;

import javax.servlet.http.HttpUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.NewBeanInstanceStrategy;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aliapp.wxxd.WeChatServiceAbstract;
import com.aliapp.wxxd.material.entity.Result;
import com.aliapp.wxxd.material.entity.batch.BatchArticleSummary;
import com.aliapp.wxxd.material.entity.batch.BatchRequire;
import com.aliapp.wxxd.material.entity.batch.BatchSummary;
import com.aliapp.wxxd.material.entity.db.Material;
import com.aliapp.wxxd.material.entity.db.MaterialCount;
import com.aliapp.wxxd.material.entity.dbproxy.MaterialCountProxy;
import com.aliapp.wxxd.material.entity.dbproxy.MaterialProxy;
import com.aliapp.wxxd.material.entity.outputmessage.mass.ArticleSummary;
import com.aliapp.wxxd.material.entity.outputmessage.mass.ArticleUpdateSummary;
import com.aliapp.wxxd.material.entity.outputmessage.mass.ArticlesMassOutputMessage;
import com.aliapp.wxxd.material.entity.outputmessage.mass.MsgTypeOutputMessage;
import com.aliapp.wxxd.material.entity.video.Description;
import com.google.gson.JsonArray;

import util.FileUtil;
import util.HttpTools;
import util.MessageUtil;
import util.ienum.MessageTypeEnum;
import util.wechat.request.url.WechatMaterialRequestURL;

/**
 * 与微信官方进行交互
 * 
 * @author VanXD
 *
 */
@Service
public class MaterialWeChatService extends WeChatServiceAbstract {

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
				WechatMaterialRequestURL.ADD_MATERIAL + accessToken + "&type="
						+ fileTyep, "POST");
		// 放入json参数,并发送
		if (fileTyep.equals(MessageTypeEnum.VIDEO.toString())) {
			Description desc = new Description(materialProxy.getTitle(),
					materialProxy.getIntroduction());
			HttpTools.jsonData(http, JSONObject.fromObject(desc));
		}

		DataOutputStream out = null;
		try {
			out = HttpTools.sendMediaRequest(materialProxy.getFile(), http);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		getResult(out, http, new Material());
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
		String url = WechatMaterialRequestURL.ADD_NEWS
				+ MessageUtil.getAccess_token();
		HttpURLConnection http = HttpTools.initHttp(url, "POST");
		DataOutputStream out = HttpTools.jsonData(http, jsonObject);

		getResult(out, http, new MaterialProxy());

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
				WechatMaterialRequestURL.DEL_MATERIAL
						+ MessageUtil.getAccess_token(), "POST");
		// 放入json参数
		DataOutputStream out = HttpTools.jsonData(http,
				JSONObject.fromObject(msgTypeOutputMessage));
		getResult(out, http);
		return (Result) resultObject;
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
				WechatMaterialRequestURL.GET_MATERIAL
						+ MessageUtil.getAccess_token(), "POST");
		// 放入json参数
		DataOutputStream out = HttpTools.jsonData(http,
				JSONObject.fromObject(msgTypeOutputMessage));
		getResult(out, http, new MsgTypeOutputMessage());
		return resultObject;
	}

	public Result updateArticle(MaterialProxy materialProxy) {
		ArticleUpdateSummary articleUpdateSummary = new ArticleUpdateSummary();
		// 将newsProxy 封装到articleUpdateSummary 以用正确的数据结构
		articleUpdateSummary.wrap(materialProxy);

		HttpURLConnection http = HttpTools.initHttp(
				WechatMaterialRequestURL.UPDATE_ARTICLE
						+ MessageUtil.getAccess_token(), "POST");

		DataOutputStream out = HttpTools.jsonData(http, JSONObject
				.fromObject(JSONObject.fromObject(articleUpdateSummary)));

		getResult(out, http);
		return (Result) resultObject;
	}

	public Object batchGetMaterial(BatchRequire batchRequire) {
		HttpURLConnection http = HttpTools.initHttp(
				WechatMaterialRequestURL.BATCH_GET_MATERIAL
						+ MessageUtil.getAccess_token(), "POST");
		// 放入json参数
		DataOutputStream out = HttpTools.jsonData(http,
				JSONObject.fromObject(batchRequire));
		getResult(out, http, new BatchSummary());
		return resultObject;

	}

	public Object getMaterialCount() {
		HttpURLConnection http = HttpTools.initHttp(
				WechatMaterialRequestURL.GET_MATERIAL_COUNT
						+ MessageUtil.getAccess_token(), "GET");
		getResult(null, http, new MaterialCountProxy());
		return resultObject;

	}
}
