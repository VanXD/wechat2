package vanxd;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import mapper.MaterialMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import entity.Result;
import entity.WXMedia;
import entity.batch.BatchRequire;
import entity.batch.BatchSummary;
import entity.db.Material;
import entity.db.MaterialCount;
import entity.db.MaterialCountProxy;
import entity.db.MaterialProxy;
import entity.outputmessage.mass.ArticlesMassOutputMessage;
import entity.outputmessage.mass.ArticlesMassOutputMessageArray;
import entity.outputmessage.mass.type.ArticleMassOutputMessage;
import service.MaterialCountMapperProxy;
import service.MaterialMapperProxy;
import service.MaterialWeChatService;
import util.FileUtil;
import util.ienum.WeChatGlobalResponse;

@Controller
@RequestMapping("/material")
public class MaterialController {
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
	@RequestMapping(value = "/addMaterial", method = RequestMethod.POST)
	public @ResponseBody Object addMaterial(MaterialProxy materialProxy) {
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
	@RequestMapping(value = "/addNews", method = RequestMethod.POST)
	public @ResponseBody Object addNews(@RequestBody MaterialProxy materialProxy) {
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
	@RequestMapping(value = "/delMatrial", method = RequestMethod.POST)
	public void delMaterial(
			@RequestParam(value = "media_id", required = true) String media_id) {
		Result result = materialWeChatService.delMaterial(media_id);
		if (result.getErrcode().equals("0")) {
			materialCountMapperProxy
					.increaseByPrimaryKeySelective(media_id, -1);
			materialMapperProxy.deleteByPrimaryKey(media_id);
		}
		System.out.println(result);
	}

	/**
	 * 更新指定图文素材的指定文章
	 * 
	 * @param newsProxy
	 *            : 包含了素材media_id, 和指定文章index
	 * @return
	 */
	@RequestMapping(value = "/updateArticle", method = RequestMethod.POST)
	public @ResponseBody Result updateArticle(
			@RequestBody MaterialProxy materialProxy) {
		Result result = materialWeChatService.updateArticle(materialProxy);
		if (result.getErrcode().equals("0")) {
			materialMapperProxy.updateByPrimaryKeySelective(materialProxy);
		}
		return result;
	}

	/**
	 * 添加临时素材，暂时没有保存到数据库中
	 * 
	 * @param file
	 */
	@RequestMapping(value = "/addTempMaterial", method = RequestMethod.POST)
	public void addTempMaterial(@RequestParam("file") MultipartFile file) {
		Result result = materialWeChatService.addTempMaterial(file);
		System.out.println(result);
	}

	/**
	 * 获取永久素材列表
	 * 
	 * @param jsonRequest
	 */
	@RequestMapping(value = "/batchGetMaterial", method = RequestMethod.POST)
	public @ResponseBody Object batchGetMaterial(BatchRequire batchRequire) {
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
	@RequestMapping(value = "/getMaterialCount")
	public @ResponseBody Object getMaterialCount() {
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
