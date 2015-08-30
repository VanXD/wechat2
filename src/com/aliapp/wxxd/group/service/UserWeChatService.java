package com.aliapp.wxxd.group.service;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;

import org.springframework.stereotype.Service;

import net.sf.json.JSONObject;
import util.HttpTools;
import util.MessageUtil;
import util.wechat.request.url.WechatGroupRequestURL;
import util.wechat.request.url.WechatUserRequestURL;

import com.aliapp.wxxd.WeChatServiceAbstract;
import com.aliapp.wxxd.group.entity.GroupSummary;
import com.aliapp.wxxd.group.entity.UserSummary;
import com.aliapp.wxxd.group.entity.dbproxy.GroupsProxy;
import com.aliapp.wxxd.group.entity.dbproxy.UserProxy;
import com.aliapp.wxxd.material.entity.Result;

/**
 * 与微信官方用户管理接口交互
 * 
 * @author VanXD
 *
 */
@Service
public class UserWeChatService extends WeChatServiceAbstract {

	/**
	 * <p>
	 * 设置用户备注名
	 * <p>
	 * HTTP Method: POST
	 * 
	 * @param userProxy
	 * @return
	 */
	public Result updateRemark(UserProxy userProxy) {
		HttpURLConnection http = HttpTools.initHttp(
				WechatUserRequestURL.UPDATE_REMARK
						+ MessageUtil.getAccess_token(), "POST");
		// 放入json参数
		DataOutputStream out = HttpTools.jsonData(http,
				JSONObject.fromObject(userProxy));

		getResult(out, http, new Result());
		return (Result) resultObject;
	}

	/**
	 * <p>
	 * 获取用户基本信息（包括UnionID机制）
	 * <p>
	 * HTTP Method: GET
	 * 
	 * @param userProxy
	 * @return
	 */
	public Object info(UserProxy userProxy) {
		HttpURLConnection http = HttpTools.initHttp(
				WechatUserRequestURL.INFO + MessageUtil.getAccess_token()
						+ "&openid=" + userProxy.getOpenid() + "&lang="
						+ userProxy.getLanguage(), "POST");

		getResult(null, http, new UserProxy());
		return resultObject;
	}

	/**
	 * <p>
	 * 批量获取用户基本信息
	 * <p>
	 * HTTP Method: POST
	 * 
	 * @param userSummary
	 * @return UserSummary | Result
	 */
	public Object batchGet(UserSummary userSummary) {
		HttpURLConnection http = HttpTools.initHttp(
				WechatUserRequestURL.BATCH_GET + MessageUtil.getAccess_token(),
				"POST");
		// 放入json参数
		DataOutputStream out = HttpTools.jsonData(http,
				JSONObject.fromObject(userSummary));

		getResult(out, http, new UserSummary());
		return resultObject;
	}

	/**
	 * <p>
	 * 获取大量用户openid
	 * <p>
	 * HTTP Method: GET
	 * <p>
	 * 当公众号关注者数量超过10000时，可通过填写next_openid的值，从而多次拉取列表的方式来满足需求。
	 * 
	 * @param userSummary
	 * @return UserSummary | Result
	 */
	public Object getList(UserSummary userSummary) {
		String next_openid = "";
		if (userSummary.getNext_openid() != null) {
			next_openid = "&next_openid=" + userSummary.getNext_openid();
		}
		HttpURLConnection http = HttpTools.initHttp(
				WechatUserRequestURL.GET_LIST + MessageUtil.getAccess_token()
						+ next_openid, "GET");

		getResult(null, http, new UserSummary());
		return resultObject;

	}

	/**
	 * <p>
	 * Authorize ,授权预留接口
	 */
	public void authorize() {

	}
}
