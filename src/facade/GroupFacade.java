package facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliapp.wxxd.group.entity.GroupSummary;
import com.aliapp.wxxd.group.entity.UserSummary;
import com.aliapp.wxxd.group.entity.db.Groups;
import com.aliapp.wxxd.group.entity.db.User;
import com.aliapp.wxxd.group.entity.dbproxy.GroupsProxy;
import com.aliapp.wxxd.group.entity.dbproxy.UserProxy;
import com.aliapp.wxxd.group.service.GroupWeChatService;
import com.aliapp.wxxd.group.service.GroupsMapperProxy;
import com.aliapp.wxxd.group.service.UserMapperProxy;
import com.aliapp.wxxd.group.service.UserWeChatService;
import com.aliapp.wxxd.material.entity.Result;

/**
 * <p>
 * 用户(组)管理模块的Facade
 * 
 * @author VanXD
 *
 */
@Service
public class GroupFacade {

	@Autowired
	GroupWeChatService groupWeChatService;
	@Autowired
	UserWeChatService userWeChatService;
	@Autowired
	UserMapperProxy userMapperProxy;
	@Autowired
	GroupsMapperProxy groupsMapperProxy;

	/**
	 * <p>
	 * 设置用户备注名
	 * <p>
	 * 选择性更新数据库表
	 * 
	 * @param userProxy
	 * @return
	 */
	public Result updateRemark(UserProxy userProxy) {
		Result result = userWeChatService.updateRemark(userProxy);
		if (((Result) result).getErrcode().equals("0")) {
			userMapperProxy.updateByPrimaryKeySelective(userProxy);
		}
		return result;

	}

	/**
	 * <p>
	 * 获取用户基本信息（包括UnionID机制）
	 * <p>
	 * HTTP Method: GET
	 * 
	 * @param userProxy
	 * @return
	 */
	public Object info(UserProxy userProxy) {
		Object result = userWeChatService.info(userProxy);
		if (result instanceof Result) {
			return result;
		} else {
			// 保存进数据库
			User user = userMapperProxy.selectByPrimaryKey(((UserProxy) result)
					.getOpenid());
			if (user != null) {
				userMapperProxy
						.updateByPrimaryKeySelective(((UserProxy) result));
			} else {
				userMapperProxy.insertSelective(((UserProxy) result));
			}
			return (UserProxy) result;
		}

	}

	/**
	 * <p>
	 * 批量获取用户基本信息
	 * <p>
	 * 将获取到的用户数组保存进数据库
	 * 
	 * @param userSummary
	 * @return
	 */
	public Object batchGet(UserSummary userSummary) {
		Object result = userWeChatService.batchGet(userSummary);
		if (result instanceof Result) {
			return result;
		} else {
			// 循环保存进数据库
			UserProxy[] user_info_list = ((UserSummary) result)
					.getUser_info_list();
			for (UserProxy tmpUser : user_info_list) {
				User user = userMapperProxy.selectByPrimaryKey(tmpUser
						.getOpenid());
				if (user != null) {
					userMapperProxy.updateByPrimaryKeySelective(tmpUser);
				} else {
					userMapperProxy.insertSelective(tmpUser);
				}
			}
			return (UserSummary) result;
		}

	}

	/**
	 * <p>
	 * 获取用户列表
	 * <p>
	 * HTTP Method: GET
	 * <p>
	 * 当公众号关注者数量超过10000时，可通过填写next_openid的值，从而多次拉取列表的方式来满足需求。
	 * 
	 * @param userSummary
	 * @return UserSummary | Result
	 */
	public Object getList(UserSummary userSummary) {
		return userWeChatService.getList(userSummary);
	}

	/**
	 * <p>
	 * Authorize ,授权预留接口
	 */
	public void authorize() {

	}

	/**
	 * <p>
	 * 创建分组
	 * <p>
	 * 返回值可能保存不正确
	 * 
	 * @param name
	 *            : 名字
	 * @return GroupSummary | Result
	 */
	public Object create(GroupsProxy groupProxy) {
		Object result = groupWeChatService.create(groupProxy);
		if (result instanceof Result) {
			return result;
		} else {
			// 保存进数据库
			groupsMapperProxy.insertSelective(((GroupSummary) result)
					.getGroup());
			return (GroupSummary) result;
		}
	}

	/**
	 * <p>
	 * 查询所有分组
	 * 
	 * @return GroupSummary | Result
	 */
	public Object get() {
		Object result = groupWeChatService.get();
		if (result instanceof Result) {
			return result;
		} else {
			// 循环更新数据库
			Groups[] groups = ((GroupSummary) result).getGroups();
			for (Groups groupTmp : groups) {
				if (groupsMapperProxy.selectByPrimaryKey(groupTmp.getId()) != null) {
					groupsMapperProxy.updateByPrimaryKeySelective(groupTmp);
				} else {
					groupsMapperProxy.insertSelective(groupTmp);
				}
			}
			return (GroupSummary) result;
		}
	}

	/**
	 * <p>
	 * 查询用户所在分组
	 * <p>
	 * 如果从微信官方获取失败，则从数据库中获取
	 * 
	 * @return GroupsProxy | Result
	 */
	public Object getUserGroupId(UserProxy userProxy) {
		Object result = groupWeChatService.getUserGroupId(userProxy);
		if (result instanceof Result) {
			if (!((Result) result).getErrcode().equals("0")) {
				return userMapperProxy
						.selectByPrimaryKey(userProxy.getOpenid());
			}
			return result;
		} else {
			return (GroupsProxy) result;
		}
	}

	/**
	 * <p>
	 * 修改分组名
	 * <p>
	 * HTTP Method: POST
	 * 
	 * @param groupsProxy
	 * @return Result
	 */
	public Result update(GroupsProxy groupsProxy) {
		Result result = groupWeChatService.update(groupsProxy);
		if (result.getErrcode().equals("0")) {
			groupsMapperProxy.updateByPrimaryKeySelective(groupsProxy);
		}
		return result;

	}

	/**
	 * <p>
	 * 移动用户分组
	 * 
	 * @param userProxy
	 * @return Result
	 */
	public Result membersUpdate(UserProxy userProxy) {
		Result result = groupWeChatService.membersUpdate(userProxy);
		if (result.getErrcode().equals("0")) {
			userMapperProxy.updateByPrimaryKeySelective(userProxy);
		}
		return result;
	}

	/**
	 * <p>
	 * 批量移动用户分组
	 * <p>
	 * HTTP Method: POST
	 * 
	 * @param userProxy
	 * @return Result
	 */
	public Result membersBatchUpdate(UserProxy userProxy) {
		Result result = groupWeChatService.membersBatchUpdate(userProxy);
		if (result.getErrcode().equals("0")) {
			// 循环更新每个用户的用户组
			String[] openIdList = userProxy.getOpenid_list();
			for (String openId : openIdList) {
				User user = new User();
				user.setOpenid(openId);
				user.setGroupid(userProxy.getTo_groupid());
				userMapperProxy.updateByPrimaryKeySelective(user);
			}
		}
		return result;

	}

	/**
	 * <p>
	 * 删除用户分组
	 * <p>
	 * HTTP Method: POST
	 * <p>
	 * 当返回空的时候，也算正确删除
	 * 
	 * @param groupsProxy
	 * @return Result
	 */
	public Result delete(GroupsProxy groupsProxy) {
		Result result = groupWeChatService.delete(groupsProxy);
		if (result.getErrcode() == null || result.getErrcode().equals("0")) {
			groupsMapperProxy.deleteByPrimaryKey(groupsProxy.getId());
		}
		return result;
	}
}
