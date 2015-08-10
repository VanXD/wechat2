package com.aliapp.wxxd.group.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliapp.wxxd.group.entity.db.User;
import com.aliapp.wxxd.group.entity.db.UserExample;
import com.aliapp.wxxd.group.mapper.UserMapper;
@Service
public class UserMapperProxy implements UserMapper {
	@Autowired
	UserMapper userMapper;

	@Override
	public int countByExample(UserExample example) {
		return userMapper.countByExample(example);

	}

	@Override
	public int deleteByExample(UserExample example) {
		return userMapper.deleteByExample(example);

	}

	@Override
	public int deleteByPrimaryKey(String openid) {
		return userMapper.deleteByPrimaryKey(openid);

	}

	@Override
	public int insert(User record) {
		return userMapper.insert(record);

	}

	@Override
	public int insertSelective(User record) {
		return userMapper.insertSelective(record);

	}

	@Override
	public List<User> selectByExample(UserExample example) {
		return userMapper.selectByExample(example);
	}

	@Override
	public User selectByPrimaryKey(String openid) {
		return userMapper.selectByPrimaryKey(openid);
	}

	@Override
	public int updateByExampleSelective(User record, UserExample example) {
		return userMapper.updateByExampleSelective(record, example);

	}

	@Override
	public int updateByExample(User record, UserExample example) {
		return userMapper.updateByExample(record, example);

	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		return userMapper.updateByPrimaryKeySelective(record);

	}

	@Override
	public int updateByPrimaryKey(User record) {
		return userMapper.updateByPrimaryKey(record);

	}

}
