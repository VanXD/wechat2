package view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aliapp.wxxd.group.entity.UserSummary;
import com.aliapp.wxxd.group.entity.dbproxy.GroupsProxy;
import com.aliapp.wxxd.group.entity.dbproxy.UserProxy;
import com.aliapp.wxxd.material.entity.Result;

import facade.GroupFacade;

@Controller
@RequestMapping("/group")
public class GroupController {
	@Autowired
	GroupFacade groupFacade;

	@RequestMapping("/updateRemark")
	public @ResponseBody Result updateRemark(UserProxy userProxy) {
		return groupFacade.updateRemark(userProxy);
	}

	@RequestMapping("/info")
	public @ResponseBody Object info(UserProxy userProxy) {
		return groupFacade.info(userProxy);
	}

	@RequestMapping("/batchGet")
	public @ResponseBody Object batchGet(UserSummary userSummary) {
		return groupFacade.batchGet(userSummary);
	}
	
	/**
	 * 
	 * @param next_openid:第一个拉取的OPENID，不填默认从头开始拉取 
	 * @return
	 */
	@RequestMapping("/getList")
	public @ResponseBody Object getList(UserSummary userSummary) {
		return groupFacade.getList(userSummary);
	}

	public void authorize() {

	}

	/**
	 * <p>
	 * 创建分组
	 * <p>
	 * HTTP Method: POST
	 * 
	 * @param name
	 *            :分组名字（30个字符以内）
	 * @return
	 */
	@RequestMapping("/create")
	public @ResponseBody Object create(GroupsProxy groupProxy) {
		return groupFacade.create(groupProxy);
	}

	/**
	 * <p>
	 * 删除分组
	 * <p>
	 * HTTP Method: POST
	 * 
	 * @param id
	 *            :分组id
	 * @return
	 */
	@RequestMapping("/delete")
	public @ResponseBody Result delete(GroupsProxy groupsProxy) {
		return groupFacade.delete(groupsProxy);
	}

	/**
	 * <p>
	 * 查询所有分组
	 * <p>
	 * HTTP Method: GET
	 * 
	 * @return
	 */
	@RequestMapping("/get")
	public @ResponseBody Object get() {
		return groupFacade.get();
	}
	
	/**
	 * 查询用户所在分组
	 * @param openid 
	 * @return
	 */
	@RequestMapping("/getUserGroupId")
	public @ResponseBody Object getUserGroupId(UserProxy userProxy) {
		return groupFacade.getUserGroupId(userProxy);
	}

	@RequestMapping("/update")
	public @ResponseBody Result update(GroupsProxy groupsProxy) {
		return groupFacade.update(groupsProxy);
	}

	@RequestMapping("/membersUpdate")
	public @ResponseBody Result membersUpdate(UserProxy userProxy) {
		return groupFacade.membersUpdate(userProxy);
	}

	@RequestMapping("/membersBatchUpdate")
	public @ResponseBody Result membersBatchUpdate(UserProxy userProxy) {
		return groupFacade.membersBatchUpdate(userProxy);
	}

}
