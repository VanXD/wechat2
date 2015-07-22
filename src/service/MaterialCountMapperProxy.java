package service;

import java.util.List;

import mapper.MaterialCountMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import util.FileUtil;
import util.ienum.MessageTypeEnum;
import entity.db.Material;
import entity.db.MaterialCount;
import entity.db.MaterialCountExample;

/**
 * 素材总数管理的代理类
 * @author VanXD
 *
 */
@Service
public class MaterialCountMapperProxy implements MaterialCountMapper {
	@Autowired
	MaterialCountMapper materialCountMapper;
	@Autowired
	MaterialMapperProxy materialMapperProxy;

	@Override
	public int countByExample(MaterialCountExample example) {
		return materialCountMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(MaterialCountExample example) {
		return materialCountMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return materialCountMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(MaterialCount record) {
		return materialCountMapper.insert(record);
	}

	@Override
	public int insertSelective(MaterialCount record) {
		return materialCountMapper.insertSelective(record);
	}

	@Override
	public List<MaterialCount> selectByExample(MaterialCountExample example) {
		return materialCountMapper.selectByExample(example);
	}

	@Override
	public MaterialCount selectByPrimaryKey(Integer id) {
		return materialCountMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(MaterialCount record,
			MaterialCountExample example) {
		return materialCountMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(MaterialCount record,
			MaterialCountExample example) {
		return materialCountMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(MaterialCount record) {
		return materialCountMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(MaterialCount record) {
		return materialCountMapper.updateByPrimaryKey(record);
	}

	/**
	 * 自定义方法 累加加值不为null的列
	 */
	public int increaseByPrimaryKeySelective(MultipartFile file,
			int var) {
		String fileSuffix = FileUtil.getFileSuffix(file.getOriginalFilename());
		String fileType = FileUtil.getFileType(fileSuffix);
		MaterialCount materialCount = injectVar(fileType, var);
		return increaseByPrimaryKeySelective(materialCount);
	}
	
	/**
	 * 以mediaId，找出type,进行累加
	 * @param mediaId
	 * @param var
	 * @return
	 */
	public int increaseByPrimaryKeySelective(String mediaId, int var){
		Material material = materialMapperProxy.selectByPrimaryKey(mediaId);
		if(material == null)
			return 0;
		MaterialCount materialCount = injectVar(material.getType(), var);
		return increaseByPrimaryKeySelective(materialCount);
		
	}

	private MaterialCount injectVar(String type, int var) {
		MaterialCount materialCount = new MaterialCount();
		materialCount.setId(1);
		if (type.equals(MessageTypeEnum.IMAGE.toString())) {
			materialCount.setImage_count(var);
		}
		else if (type.equals(MessageTypeEnum.VOICE.toString())) {
			materialCount.setVoice_count(var);
		}
		else if (type.equals(MessageTypeEnum.VIDEO.toString())) {
			materialCount.setVideo_count(var);
		}
		return materialCount;
	}
	
	@Override
	public int increaseByPrimaryKeySelective(MaterialCount record) {
		return materialCountMapper.increaseByPrimaryKeySelective(record);
	}

}
