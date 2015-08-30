package com.aliapp.wxxd.website.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliapp.wxxd.website.user.entity.db.SysPermissions;
import com.aliapp.wxxd.website.user.entity.db.SysPermissionsExample;
import com.aliapp.wxxd.website.user.entity.db.SysUsersRolesExample;
import com.aliapp.wxxd.website.user.entity.db.SysUsersRolesKey;
import com.aliapp.wxxd.website.user.mapper.SysPermissionsMapper;
import com.aliapp.wxxd.website.user.mapper.SysUsersRolesMapper;
@Service
public class SysUsersRolesMapperProxy implements SysUsersRolesMapper {
	@Autowired
	SysUsersRolesMapper sysUsersRolesMapper;

	@Override
	public int countByExample(SysUsersRolesExample example) {

		return sysUsersRolesMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(SysUsersRolesExample example) {

		return sysUsersRolesMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(SysUsersRolesKey key) {

		return sysUsersRolesMapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(SysUsersRolesKey record) {

		return sysUsersRolesMapper.insert(record);
	}

	@Override
	public int insertSelective(SysUsersRolesKey record) {

		return sysUsersRolesMapper.insertSelective(record);
	}

	@Override
	public List<SysUsersRolesKey> selectByExample(SysUsersRolesExample example) {

		return sysUsersRolesMapper.selectByExample(example);
	}

	@Override
	public int updateByExampleSelective(SysUsersRolesKey record,
			SysUsersRolesExample example) {

		return sysUsersRolesMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(SysUsersRolesKey record,
			SysUsersRolesExample example) {

		return sysUsersRolesMapper.updateByExample(record, example);
	}

}
