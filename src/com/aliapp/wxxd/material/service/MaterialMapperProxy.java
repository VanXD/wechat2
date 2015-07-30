package com.aliapp.wxxd.material.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.aliapp.wxxd.material.entity.db.Material;
import com.aliapp.wxxd.material.entity.db.MaterialExample;
import com.aliapp.wxxd.material.mapper.MaterialCountMapper;
import com.aliapp.wxxd.material.mapper.MaterialMapper;

/**
 * Mapper都是由Generator进行自动生成，为了方便以后改表结构，进行扩展不影响自己扩展功能的使用，进行代理
 * 
 * @author VanXD
 *
 */
@Service
public class MaterialMapperProxy implements MaterialMapper{

	@Autowired
	MaterialMapper materialMapper;

	public int countByExample(MaterialExample example) {
		return materialMapper.countByExample(example);
	}

	public int deleteByExample(MaterialExample example) {
		return materialMapper.deleteByExample(example);
	}

	public int deleteByPrimaryKey(String mediaId) {
		return materialMapper.deleteByPrimaryKey(mediaId);
	}

	public int insert(Material record) {
		return materialMapper.insert(record);
	}

	public int insertSelective(Material record) {
		return materialMapper.insertSelective(record);
	}

	public List<Material> selectByExample(MaterialExample example) {
		return materialMapper.selectByExample(example);
	}

	public Material selectByPrimaryKey(String mediaId) {
		return materialMapper.selectByPrimaryKey(mediaId);
	}

	public int updateByExampleSelective(Material record, MaterialExample example) {
		return materialMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(Material record, MaterialExample example) {
		return materialMapper.updateByExample(record, example);
	}

	public int updateByPrimaryKeySelective(Material record) {
		return materialMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Material record) {
		return materialMapper.updateByPrimaryKey(record);
	}

}
