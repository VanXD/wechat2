package com.aliapp.wxxd.group.entity.dbproxy;

import com.aliapp.wxxd.group.entity.db.User;

public class UserProxy extends User {
	/**
	 * 移动到的分组id,setter方法将其赋值到父类的groupId
	 */
	private Integer to_groupid;
	private String[] openid_list;
	/**
	 * 第一个拉取的OPENID，不填默认从头开始拉取
	 */
	private String next_openid;

	public String getNext_openid() {
		return next_openid;
	}

	public void setNext_openid(String next_openid) {
		this.next_openid = next_openid;
	}

	public Integer getTo_groupid() {
		return to_groupid;
	}

	public void setTo_groupid(Integer to_groupid) {
		this.to_groupid = to_groupid;
		setGroupid(to_groupid);
	}

	public String[] getOpenid_list() {
		return openid_list;
	}

	public void setOpenid_list(String[] openid_list) {
		this.openid_list = openid_list;
	}

}
