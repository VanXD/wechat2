package com.aliapp.wxxd.group.entity;

import com.aliapp.wxxd.group.entity.db.Groups;

public class GroupSummary {
	private Groups group;
	private Groups[] groups;

	/**
	 * 
	 */
	public GroupSummary() {
		super();
	}

	/**
	 * @param group
	 */
	public GroupSummary(Groups group) {
		super();
		this.group = group;
	}

	public Groups getGroup() {
		return group;
	}

	public void setGroup(Groups group) {
		this.group = group;
	}

	public Groups[] getGroups() {
		return groups;
	}

	public void setGroups(Groups[] groups) {
		this.groups = groups;
	}

}
