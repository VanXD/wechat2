package service;

import java.util.List;

import mapper.MaterialMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.db.Material;
import entity.db.MaterialExample;

/**
 * Mapper都是由Generator进行自动生成，为了方便以后改表结构，进行扩展不影响自己扩展功能的使用，进行代理
 * 
 * @author VanXD
 *
 */
@Service
public class MaterialMapperProxy implements MaterialMapper {

	@Autowired
	MaterialMapper materialMapper;

	@Override
	public int countByExample(MaterialExample example) {
		return materialMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(MaterialExample example) {
		return materialMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(String mediaId) {
		return materialMapper.deleteByPrimaryKey(mediaId);
	}

	@Override
	public int insert(Material record) {
		return materialMapper.insert(record);
	}

	@Override
	public int insertSelective(Material record) {
		return materialMapper.insertSelective(record);
	}

	@Override
	public List<Material> selectByExample(MaterialExample example) {
		return materialMapper.selectByExample(example);
	}

	@Override
	public Material selectByPrimaryKey(String mediaId) {
		return materialMapper.selectByPrimaryKey(mediaId);
	}

	@Override
	public int updateByExampleSelective(Material record, MaterialExample example) {
		return materialMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Material record, MaterialExample example) {
		return materialMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Material record) {
		return materialMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Material record) {
		return materialMapper.updateByPrimaryKey(record);
	}

}
