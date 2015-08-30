package facade;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aliapp.wxxd.material.entity.Result;
import com.aliapp.wxxd.material.entity.batch.BatchRequire;
import com.aliapp.wxxd.material.entity.batch.BatchSummary;
import com.aliapp.wxxd.material.entity.db.Material;
import com.aliapp.wxxd.material.entity.db.MaterialCount;
import com.aliapp.wxxd.material.entity.dbproxy.MaterialCountProxy;
import com.aliapp.wxxd.material.entity.dbproxy.MaterialProxy;
import com.aliapp.wxxd.material.service.MaterialCountMapperProxy;
import com.aliapp.wxxd.material.service.MaterialMapperProxy;
import com.aliapp.wxxd.material.service.MaterialWeChatService;

import util.ienum.WeChatGlobalResponse;

/**
 * <p>
 * 处于Controller与Material Service层之间的Facade
 * <p>
 * 将后台与微信交互和数据库交互封装在一个系统中，由Facade进行与Controller的交互。
 * <p>素材管理模块的Facade
 * 
 * @author VanXD
 *
 */
@Service
public class MaterialFacade {

	@Autowired
	MaterialWeChatService materialWeChatService;
	@Autowired
	MaterialMapperProxy materialMapperProxy;
	@Autowired
	MaterialCountMapperProxy materialCountMapperProxy;
	/**
	 * 为了能够自动注入id=1,将此entity的bean定义在了spring配置文件中,而非使用@Entity
	 */
	@Autowired
	MaterialCountProxy materialCountProxy;

	/**
	 * <p>
	 * 添加素材，自动判断类型
	 * <P>
	 * 如果微信接口出错，则返回Result -> json
	 * <p>
	 * 添加成功返回Material -> json
	 * 
	 * @param materialProxy
	 * @return Object -> json
	 */
	public Object addMaterial(MaterialProxy materialProxy) {
		Object result = materialWeChatService.addMaterial(materialProxy);
		if (result instanceof Result) {
			return result;
		} else {
			materialProxy.wrap(result);
			materialMapperProxy.insert(materialProxy);
			materialCountMapperProxy.increaseByPrimaryKeySelective(
					materialProxy.getFile(), 1);
			return (Material) materialProxy;
		}
	}

	/**
	 * 
	 * @param newsProxy
	 *            : 前端传递json数据自动转换
	 * @return Object
	 */
	public Object addNews(MaterialProxy materialProxy) {
		Object result = materialWeChatService.addNews(materialProxy);
		if (result instanceof Result) {
			return result;
		} else {
			materialProxy.wrap(result);
			materialMapperProxy.insert(materialProxy);
			materialCountMapperProxy
					.increaseByPrimaryKeySelective(materialCountProxy);
			return (MaterialProxy) materialProxy;
		}
	}

	/**
	 * 删除指定素材
	 * 
	 * @param mediaId
	 */
	public Result delMaterial(String media_id) {
		Result result = materialWeChatService.delMaterial(media_id);
		if (result.getErrcode().equals("0")) {
			Material material = materialMapperProxy
					.selectByPrimaryKey(media_id);
			materialCountMapperProxy
					.increaseByPrimaryKeySelective(material, -1);
			materialMapperProxy.deleteByPrimaryKey(media_id);
		}
		return result;
	}

	/**
	 * 更新指定图文素材的指定文章
	 * 
	 * @param newsProxy
	 *            : 包含了素材media_id, 和指定文章index
	 * @return
	 */
	public Result updateArticle(MaterialProxy materialProxy) {
		Result result = materialWeChatService.updateArticle(materialProxy);
		if (result.getErrcode().equals("0")) {
			materialMapperProxy.updateByPrimaryKeySelective(materialProxy);
		}
		return result;
	}

	/**
	 * 获取永久素材列表
	 * 
	 * @param jsonRequest
	 */
	public Object batchGetMaterial(BatchRequire batchRequire) {
		Object result = materialWeChatService.batchGetMaterial(batchRequire);
		if (result instanceof Result) {
			return result;
		} else {
			return (BatchSummary) result;
		}
	}

	/**
	 * 获取素材总数
	 * 
	 * @return
	 */
	public Object getMaterialCount() {
		Object result = materialWeChatService.getMaterialCount();
		if (result instanceof Result) {
			if (((Result) result).getErrcode().equals(
					WeChatGlobalResponse.MAX_API_DAILY_QUOTA.toString()))
				return materialCountMapperProxy.selectByPrimaryKey(1);
			return result;
		} else {
			((MaterialCount) result).setId(1);
			materialCountMapperProxy
					.updateByPrimaryKey(((MaterialCount) result));
			return (MaterialCount) result;
		}
	}

}
