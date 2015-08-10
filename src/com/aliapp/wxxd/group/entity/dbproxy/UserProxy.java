package com.aliapp.wxxd.group.entity.dbproxy;

import com.aliapp.wxxd.group.entity.db.User;

public class UserProxy extends User {
	/**
	 * 移动到的分组id
	 */
	private String to_groupid;
	private String[] openid_list;

	public String getTo_groupid() {
		return to_groupid;
	}

	public void setTo_groupid(String to_groupid) {
		this.to_groupid = to_groupid;
	}

	public String[] getOpenid_list() {
		return openid_list;
	}

	public void setOpenid_list(String[] openid_list) {
		this.openid_list = openid_list;
	}

}
