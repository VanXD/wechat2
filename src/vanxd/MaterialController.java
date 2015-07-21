package vanxd;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import mapper.MaterialMapper;
import mapper.NewsMapper;

import org.springframework.beans.factory.annotation.Autowired;
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
import entity.db.Material;
import entity.db.MaterialProxy;
import entity.db.News;
import entity.db.NewsProxy;
import entity.outputmessage.mass.ArticlesMassOutputMessage;
import entity.outputmessage.mass.ArticlesMassOutputMessageArray;
import entity.outputmessage.mass.type.ArticleMassOutputMessage;
import service.MaterialService;

@Controller
@RequestMapping("/material")
public class MaterialController {
	@Autowired
	MaterialService materialService;
	@Autowired
	MaterialMapper materialMapper;
	@Autowired
	NewsMapper newsMapper;

	/**
	 * <p>
	 * 添加素材，自动判断类型
	 * <p>
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
		Object result = materialService.addMaterial(materialProxy);
		if (result instanceof Result) {
			return result;
		}

		else {
			materialProxy.wrap(result);
			;
			materialMapper.insert(materialProxy);
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
	public @ResponseBody Object addNews(@RequestBody NewsProxy newsProxy) {
		Object result = materialService.addNews(newsProxy);
		if (result instanceof Result) {
			return result;
		} else {
			newsProxy.wrap(result);
			;
			newsMapper.insert(newsProxy);
			return (News) newsProxy;
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
		Result result = materialService.delMaterial(media_id);
		if (result.getErrcode().equals("0")) {
			materialMapper.deleteByPrimaryKey(media_id);
		}
		System.out.println(result);
	}

	@RequestMapping(value = "/updateArticle", method = RequestMethod.POST)
	public @ResponseBody Result updateArticle(@RequestBody NewsProxy newsProxy) {
		System.out.println(newsProxy);
//		Result result = materialService.updateArticle(newsProxy);
//		if(result.getErrcode().equals("0")){
//			newsMapper.updateByPrimaryKeySelective(newsProxy);
//		}
		return null;
	}

	@RequestMapping(value = "/addTempMaterial", method = RequestMethod.POST)
	public void addTempMaterial(@RequestParam("file") MultipartFile file) {
		Result result = materialService.addTempMaterial(file);
		System.out.println(result);
	}

	@RequestMapping(value = "/batchGetMaterial", method = RequestMethod.POST)
	public void batchGetMaterial(
			@RequestParam(value = "jsonRequest") String jsonRequest) {
		Object result = materialService.batchGetMaterial(jsonRequest);
		System.out.println(result);
	}

	@RequestMapping(value = "/getMaterialCount")
	public void getMaterialCount() {
		Object result = materialService.getMaterialCount();
		System.out.println(result);
	}

}
