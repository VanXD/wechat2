package com.aliapp.wxxd.website.user.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliapp.wxxd.website.user.entity.db.SysPermissions;
import com.aliapp.wxxd.website.user.entity.db.SysPermissionsExample;
import com.aliapp.wxxd.website.user.mapper.SysPermissionsMapper;
@Service
public class SysPermissionsMapperProxy implements SysPermissionsMapper {
	@Autowired
	SysPermissionsMapper sysPermissionsMapper;

	@Override
	public int countByExample(SysPermissionsExample example) {

		return sysPermissionsMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(SysPermissionsExample example) {

		return sysPermissionsMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long id) {

		return sysPermissionsMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SysPermissions record) {

		return sysPermissionsMapper.insert(record);
	}

	@Override
	public int insertSelective(SysPermissions record) {

		return sysPermissionsMapper.insertSelective(record);
	}

	@Override
	public List<SysPermissions> selectByExample(SysPermissionsExample example) {

		return sysPermissionsMapper.selectByExample(example);
	}

	@Override
	public SysPermissions selectByPrimaryKey(Long id) {

		return sysPermissionsMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(SysPermissions record,
			SysPermissionsExample example) {

		return sysPermissionsMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(SysPermissions record,
			SysPermissionsExample example) {

		return sysPermissionsMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(SysPermissions record) {

		return sysPermissionsMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SysPermissions record) {

		return sysPermissionsMapper.updateByPrimaryKey(record);
	}

	@Override
	public Set<String> selectPermissionsByUsername(String username) {
		return sysPermissionsMapper.selectPermissionsByUsername(username);
	}
}
