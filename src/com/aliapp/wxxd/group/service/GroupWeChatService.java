package com.aliapp.wxxd.group.service;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import util.HttpTools;
import util.MessageUtil;
import util.wechat.request.url.WechatGroupRequestURL;
import util.wechat.request.url.WechatMaterialRequestURL;

import com.aliapp.wxxd.WeChatServiceAbstract;
import com.aliapp.wxxd.group.entity.GroupSummary;
import com.aliapp.wxxd.group.entity.db.Groups;
import com.aliapp.wxxd.group.entity.dbproxy.GroupsProxy;
import com.aliapp.wxxd.group.entity.dbproxy.UserProxy;
import com.aliapp.wxxd.material.entity.Result;
import com.aliapp.wxxd.material.entity.db.MaterialCount;
import com.aliapp.wxxd.material.entity.dbproxy.MaterialCountProxy;
import com.aliapp.wxxd.material.entity.outputmessage.mass.MsgTypeOutputMessage;

/**
 * 与微信官方分组管理接口交互
 * 
 * @author VanXD
 *
 */
@Service
public class GroupWeChatService extends WeChatServiceAbstract {
	/**
	 * <p>
	 * 创建分组
	 * <p>
	 * 未测试
	 * 
	 * @param name
	 *            : 名字
	 * @return GroupSummary | Result
	 */
	public Object create(GroupsProxy groupProxy) {
		HttpURLConnection http = HttpTools.initHttp(
				WechatGroupRequestURL.CREATE + MessageUtil.getAccess_token(),
				"POST");
		GroupSummary data = new GroupSummary(groupProxy);
		// 放入json参数
		DataOutputStream out = HttpTools.jsonData(http,
				JSONObject.fromObject(data));

		getResult(out, http, new GroupSummary());
		return resultObject;
	}

	/**
	 * <p>
	 * 删除用户分组
	 * <p>
	 * HTTP Method: POST
	 * 
	 * @param groupsProxy
	 * @return Result
	 */
	public Result delete(GroupsProxy groupProxy) {
		HttpURLConnection http = HttpTools.initHttp(
				WechatGroupRequestURL.DELETE + MessageUtil.getAccess_token(),
				"POST");
		GroupSummary data = new GroupSummary(groupProxy);
		// 放入json参数
		DataOutputStream out = HttpTools.jsonData(http,
				JSONObject.fromObject(data));
		getResult(out, http);
		return (Result) resultObject;
	}

	/**
	 * <p>
	 * 查询所有分组
	 * <p>
	 * 
	 * 
	 * @return GroupSummary | Result
	 */
	public Object get() {
		HttpURLConnection http = HttpTools.initHttp(WechatGroupRequestURL.GET
				+ MessageUtil.getAccess_token(), "GET");
		getResult(null, http, new GroupSummary());
		return resultObject;
	}

	/**
	 * <p>
	 * 查询用户所在分组
	 * <p>
	 * HTTP Method: POST
	 * 
	 * @return GroupsProxy | Result
	 */
	public Object getUserGroupId(UserProxy userProxy) {
		HttpURLConnection http = HttpTools.initHttp(
				WechatGroupRequestURL.GET_USER_GROUP_ID
						+ MessageUtil.getAccess_token(), "POST");
		// 放入json参数
		DataOutputStream out = HttpTools.jsonData(http,
				JSONObject.fromObject(userProxy));
		getResult(out, http, new GroupsProxy());
		return resultObject;
	}

	/**
	 * <p>
	 * 修改分组名
	 * <p>
	 * HTTP Method: POST
	 * 
	 * @param groupsProxy
	 * @return Result
	 */
	public Result update(GroupsProxy groupsProxy) {
		HttpURLConnection http = HttpTools.initHttp(
				WechatGroupRequestURL.UPDATE + MessageUtil.getAccess_token(),
				"POST");
		// 放入json参数
		DataOutputStream out = HttpTools.jsonData(http,
				JSONObject.fromObject(groupsProxy));
		getResult(out, http);
		return (Result) resultObject;
	}

	/**
	 * <p>
	 * 移动用户分组
	 * <p>
	 * HTTP Method: POST
	 * 
	 * @param userProxy
	 * @return Result
	 */
	public Result membersUpdate(UserProxy userProxy) {
		HttpURLConnection http = HttpTools.initHttp(
				WechatGroupRequestURL.MEMBERS_UPDATE
						+ MessageUtil.getAccess_token(), "POST");
		// 放入json参数
		DataOutputStream out = HttpTools.jsonData(http,
				JSONObject.fromObject(userProxy));
		getResult(out, http);
		return (Result) resultObject;
	}

	/**
	 * <p>
	 * 批量移动用户分组
	 * <p>
	 * HTTP Method: POST
	 * 
	 * @param userProxy
	 * @return Result
	 */
	public Result membersBatchUpdate(UserProxy userProxy) {
		HttpURLConnection http = HttpTools.initHttp(
				WechatGroupRequestURL.MEMBERS_UPDATE
						+ MessageUtil.getAccess_token(), "POST");
		// 放入json参数
		DataOutputStream out = HttpTools.jsonData(http,
				JSONObject.fromObject(userProxy));
		getResult(out, http);
		return (Result) resultObject;
	}
}
