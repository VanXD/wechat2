package util.wechat.request.url;

/**
 * 向微信服务器交互的请求地址 
 * @author VanXD
 *
 */
public class WechatGroupRequestURL {
	/**
	 * 创建分组
	 */
	public static final String CREATE = "https://api.weixin.qq.com/cgi-bin/groups/create?access_token=";
	
	/**
	 * 查询所有分组
	 */
	public static final String GET = "https://api.weixin.qq.com/cgi-bin/groups/get?access_token=";
	
	/**
	 * 查询用户所在分组
	 */
	public static final String GET_USER_GROUP_ID = "https://api.weixin.qq.com/cgi-bin/groups/getid?access_token=";
	
	/**
	 * 修改分组名
	 */
	public static final String UPDATE = "https://api.weixin.qq.com/cgi-bin/groups/update?access_token=";
	/**
	 * 移动用户分组
	 */
	public static final String MEMBERS_UPDATE = "https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token=";
	/**
	 * 批量移动用户分组
	 */
	public static final String MEMBERS_BATCH_UPDATE = "https://api.weixin.qq.com/cgi-bin/groups/members/batchupdate?access_token=";
	/**
	 * 删除用户分组
	 */
	public static final String DELETE = "https://api.weixin.qq.com/cgi-bin/groups/delete?access_token=";
}
