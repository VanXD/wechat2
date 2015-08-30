package com.aliapp.wxxd.group.entity;

import com.aliapp.wxxd.group.entity.dbproxy.UserProxy;

/**
 * 用户基本信息列表,用户列表返回值
 * 
 * @author VanXD
 *
 */
public class UserSummary {
	/**
	 * BatchGet请求数组
	 */
	private UserProxy[] user_list;
	/**
	 * BatchGet结果返回数组
	 */
	private UserProxy[] user_info_list;
	// 用户列表返回值
	private Integer total;
	private Integer count;
	/**
	 * 用户openid, getList返回值
	 */
	private OpenIDData data;
	private String next_openid;

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public OpenIDData getData() {
		return data;
	}

	public void setData(OpenIDData data) {
		this.data = data;
	}

	public String getNext_openid() {
		return next_openid;
	}

	public void setNext_openid(String next_openid) {
		this.next_openid = next_openid;
	}

	public UserProxy[] getUser_list() {
		return user_list;
	}

	public void setUser_list(UserProxy[] user_list) {
		this.user_list = user_list;
	}

	public UserProxy[] getUser_info_list() {
		return user_info_list;
	}

	public void setUser_info_list(UserProxy[] user_info_list) {
		this.user_info_list = user_info_list;
	}

}
