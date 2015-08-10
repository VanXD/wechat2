package com.aliapp.wxxd.group.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliapp.wxxd.group.entity.db.Groups;
import com.aliapp.wxxd.group.entity.db.GroupsExample;
import com.aliapp.wxxd.group.mapper.GroupsMapper;

@Service
public class GroupsMapperProxy implements GroupsMapper{
	@Autowired
	GroupsMapper groupsMapper;
	
	@Override
	public int countByExample(GroupsExample example) {
		return groupsMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(GroupsExample example) {
		return groupsMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return groupsMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Groups record) {
		return groupsMapper.insert(record);
	}

	@Override
	public int insertSelective(Groups record) {
		return groupsMapper.insertSelective(record);
	}

	@Override
	public List<Groups> selectByExample(GroupsExample example) {
		return groupsMapper.selectByExample(example);
	}

	@Override
	public Groups selectByPrimaryKey(Integer id) {
		return groupsMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(Groups record, GroupsExample example) {
		return groupsMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Groups record, GroupsExample example) {
		return groupsMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Groups record) {
		return groupsMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Groups record) {
		return groupsMapper.updateByPrimaryKey(record);
	}

}
