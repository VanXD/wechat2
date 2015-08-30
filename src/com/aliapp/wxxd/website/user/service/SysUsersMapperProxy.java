package com.aliapp.wxxd.website.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliapp.wxxd.website.user.entity.db.SysPermissions;
import com.aliapp.wxxd.website.user.entity.db.SysPermissionsExample;
import com.aliapp.wxxd.website.user.entity.db.SysUsers;
import com.aliapp.wxxd.website.user.entity.db.SysUsersExample;
import com.aliapp.wxxd.website.user.mapper.SysPermissionsMapper;
import com.aliapp.wxxd.website.user.mapper.SysUsersMapper;

@Service
public class SysUsersMapperProxy implements SysUsersMapper {
	@Autowired
	SysUsersMapper sysUsersMapper;

	@Override
	public int countByExample(SysUsersExample example) {

		return sysUsersMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(SysUsersExample example) {

		return sysUsersMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long id) {

		return sysUsersMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SysUsers record) {

		return sysUsersMapper.insert(record);
	}

	@Override
	public int insertSelective(SysUsers record) {

		return sysUsersMapper.insertSelective(record);
	}

	@Override
	public List<SysUsers> selectByExample(SysUsersExample example) {
		return sysUsersMapper.selectByExample(example);
	}

	@Override
	public SysUsers selectByPrimaryKey(Long id) {

		return sysUsersMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(SysUsers record, SysUsersExample example) {

		return sysUsersMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(SysUsers record, SysUsersExample example) {

		return sysUsersMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(SysUsers record) {

		return sysUsersMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SysUsers record) {

		return sysUsersMapper.updateByPrimaryKey(record);
	}

}
