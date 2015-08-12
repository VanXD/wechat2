package com.aliapp.wxxd.material.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aliapp.wxxd.material.entity.db.Material;
import com.aliapp.wxxd.material.entity.db.MaterialCount;
import com.aliapp.wxxd.material.entity.db.MaterialCountExample;
import com.aliapp.wxxd.material.entity.dbproxy.MaterialCountProxy;
import com.aliapp.wxxd.material.mapper.MaterialCountMapper;

import util.FileUtil;
import util.ienum.MessageTypeEnum;

/**
 * 素材总数管理的代理类
 * 
 * @author VanXD
 *
 */
@Service
public class MaterialCountMapperProxy implements MaterialCountMapper {
	@Autowired
	MaterialCountMapper materialCountMapper;
	@Autowired 
	MaterialCountProxy materialCountProxy;
	public int countByExample(MaterialCountExample example) {
		return materialCountMapper.countByExample(example);
	}

	public int deleteByExample(MaterialCountExample example) {
		return materialCountMapper.deleteByExample(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return materialCountMapper.deleteByPrimaryKey(id);
	}

	public int insert(MaterialCount record) {
		return materialCountMapper.insert(record);
	}

	public int insertSelective(MaterialCount record) {
		return materialCountMapper.insertSelective(record);
	}

	public List<MaterialCount> selectByExample(MaterialCountExample example) {
		return materialCountMapper.selectByExample(example);
	}

	public MaterialCount selectByPrimaryKey(Integer id) {
		return materialCountMapper.selectByPrimaryKey(id);
	}

	public int updateByExampleSelective(MaterialCount record,
			MaterialCountExample example) {
		return materialCountMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(MaterialCount record,
			MaterialCountExample example) {
		return materialCountMapper.updateByExample(record, example);
	}

	public int updateByPrimaryKeySelective(MaterialCount record) {
		return materialCountMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(MaterialCount record) {
		return materialCountMapper.updateByPrimaryKey(record);
	}

	/**
	 * 自定义方法 累加加值不为null的列
	 */
	public int increaseByPrimaryKeySelective(MultipartFile file, int var) {
		String fileSuffix = FileUtil.getFileSuffix(file.getOriginalFilename());
		String fileType = FileUtil.getFileType(fileSuffix);
		MaterialCount materialCount = injectVar(fileType, var);
		return increaseByPrimaryKeySelective(materialCount);
	}

	/**
	 * 以mediaId，找出type,进行累加
	 * 
	 * @param mediaId
	 * @param var
	 * @return
	 */
	public int increaseByPrimaryKeySelective(Material material, int var) {
		MaterialCount materialCount = injectVar(material.getType(), var);
		return increaseByPrimaryKeySelective(materialCount);

	}

	private MaterialCount injectVar(String type, int var) {
		MaterialCount materialCount = new MaterialCount();
		materialCount.setId(1);
		if (type.equals(MessageTypeEnum.IMAGE.toString())) {
			materialCount.setImage_count(var);
		} else if (type.equals(MessageTypeEnum.VOICE.toString())) {
			materialCount.setVoice_count(var);
		} else if (type.equals(MessageTypeEnum.VIDEO.toString())) {
			materialCount.setVideo_count(var);
		}else if (type.equals(MessageTypeEnum.NEWS.toString())) {
			materialCount.setNews_count(var);
		}
		return materialCount;
	}

	public int increaseByPrimaryKeySelective(MaterialCount record) {
		//要先判断数据库是否有数据
		if(materialCountMapper.selectByPrimaryKey(materialCountProxy.getId()) == null){
			materialCountMapper.insert(materialCountProxy);
		}
		return materialCountMapper.increaseByPrimaryKeySelective(record);
	}

}
