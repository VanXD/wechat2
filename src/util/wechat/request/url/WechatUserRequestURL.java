package util.wechat.request.url;

public class WechatUserRequestURL {
	/**
	 * 设置备注名
	 */
	public static final String UPDATE_REMARK = "https://api.weixin.qq.com/cgi-bin/user/info/updateremark?access_token=";
	
	/**
	 * 获取用户基本信息
	 */
	public static final String INFO ="https://api.weixin.qq.com/cgi-bin/user/info?access_token=";
	
	/**
	 * 批量获取用户基本信息
	 */
	public static final String BATCH_GET = "https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=";
	
	/**
	 * 获取用户列表
	 */
	public static final String GET_LIST = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=";

}
