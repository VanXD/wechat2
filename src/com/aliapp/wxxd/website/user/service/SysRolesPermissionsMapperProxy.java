package com.aliapp.wxxd.website.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliapp.wxxd.website.user.entity.db.SysPermissions;
import com.aliapp.wxxd.website.user.entity.db.SysPermissionsExample;
import com.aliapp.wxxd.website.user.entity.db.SysRolesPermissionsExample;
import com.aliapp.wxxd.website.user.entity.db.SysRolesPermissionsKey;
import com.aliapp.wxxd.website.user.mapper.SysPermissionsMapper;
import com.aliapp.wxxd.website.user.mapper.SysRolesPermissionsMapper;
@Service
public class SysRolesPermissionsMapperProxy implements
		SysRolesPermissionsMapper {
	@Autowired
	SysRolesPermissionsMapper sysRolesPermissionsMapper;

	@Override
	public int countByExample(SysRolesPermissionsExample example) {

		return sysRolesPermissionsMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(SysRolesPermissionsExample example) {

		return sysRolesPermissionsMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(SysRolesPermissionsKey key) {

		return sysRolesPermissionsMapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(SysRolesPermissionsKey record) {

		return sysRolesPermissionsMapper.insert(record);
	}

	@Override
	public int insertSelective(SysRolesPermissionsKey record) {

		return sysRolesPermissionsMapper.insertSelective(record);
	}

	@Override
	public List<SysRolesPermissionsKey> selectByExample(
			SysRolesPermissionsExample example) {

		return sysRolesPermissionsMapper.selectByExample(example);
	}

	@Override
	public int updateByExampleSelective(SysRolesPermissionsKey record,
			SysRolesPermissionsExample example) {

		return sysRolesPermissionsMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(SysRolesPermissionsKey record,
			SysRolesPermissionsExample example) {

		return sysRolesPermissionsMapper.updateByExample(record, example);
	}

}
