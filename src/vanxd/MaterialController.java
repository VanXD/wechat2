package vanxd;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.aliapp.wxxd.material.entity.Result;
import com.aliapp.wxxd.material.entity.batch.BatchRequire;
import com.aliapp.wxxd.material.entity.dbproxy.MaterialProxy;

import facade.MaterialFacade;

/**
 * <p>
 * 利用PersistenceFacade进行交互，避免Controller耦合太多对象
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/material")
public class MaterialController {
	@Autowired
	MaterialFacade persistenceFacade;

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
		return persistenceFacade.addMaterial(materialProxy);
	}

	/**
	 * 
	 * @param newsProxy
	 *            : 前端传递json数据自动转换
	 * @return Object
	 */
	@RequestMapping(value = "/addNews", method = RequestMethod.POST)
	public @ResponseBody Object addNews(@RequestBody MaterialProxy materialProxy) {
		return persistenceFacade.addNews(materialProxy);
	}

	/**
	 * 删除指定素材
	 * 
	 * @param mediaId
	 */
	@RequestMapping(value = "/delMatrial", method = RequestMethod.POST)
	public @ResponseBody Result delMaterial(
			@RequestParam(value = "media_id", required = true) String media_id) {
		return persistenceFacade.delMaterial(media_id);
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
		return persistenceFacade.updateArticle(materialProxy);
	}

	/**
	 * 获取永久素材列表
	 * 
	 * @param jsonRequest
	 */
	@RequestMapping(value = "/batchGetMaterial", method = RequestMethod.POST)
	public @ResponseBody Object batchGetMaterial(
			@RequestBody BatchRequire batchRequire) {
		return persistenceFacade.batchGetMaterial(batchRequire);
	}

	/**
	 * 获取素材总数
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getMaterialCount")
	public @ResponseBody Object getMaterialCount() {
		return persistenceFacade.getMaterialCount();
	}

}
