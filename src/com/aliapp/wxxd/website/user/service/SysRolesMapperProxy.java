package com.aliapp.wxxd.website.user.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliapp.wxxd.website.user.entity.db.SysPermissions;
import com.aliapp.wxxd.website.user.entity.db.SysPermissionsExample;
import com.aliapp.wxxd.website.user.entity.db.SysRoles;
import com.aliapp.wxxd.website.user.entity.db.SysRolesExample;
import com.aliapp.wxxd.website.user.entity.db.SysUsers;
import com.aliapp.wxxd.website.user.mapper.SysRolesMapper;

@Service
public class SysRolesMapperProxy implements SysRolesMapper {
	@Autowired
	SysRolesMapper sysRolesMapper;

	@Override
	public int countByExample(SysRolesExample example) {

		return sysRolesMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(SysRolesExample example) {

		return sysRolesMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long id) {

		return sysRolesMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SysRoles record) {

		return sysRolesMapper.insert(record);
	}

	@Override
	public int insertSelective(SysRoles record) {

		return sysRolesMapper.insertSelective(record);
	}

	@Override
	public List<SysRoles> selectByExample(SysRolesExample example) {

		return sysRolesMapper.selectByExample(example);
	}

	@Override
	public SysRoles selectByPrimaryKey(Long id) {

		return sysRolesMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(SysRoles record, SysRolesExample example) {

		return sysRolesMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(SysRoles record, SysRolesExample example) {

		return sysRolesMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(SysRoles record) {

		return sysRolesMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SysRoles record) {

		return sysRolesMapper.updateByPrimaryKey(record);
	}

	@Override
	public Set<String> selectRolesByUsername(String username) {
		return sysRolesMapper.selectRolesByUsername(username);
	}
}
