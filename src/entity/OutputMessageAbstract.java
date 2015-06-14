package entity;

import interfaces.MsgTypeInterface;

public abstract class OutputMessageAbstract implements MsgTypeInterface {
	/**
	 * 接收方帐号（收到的OpenID）
	 */
	private String ToUserName;
	/**
	 * 开发者微信号
	 */
	private String FromUserName;
	/**
	 * 消息创建时间 （整型）
	 */
	private Long CreateTime;

	/**
	 * 获取 接收方帐号（收到的OpenID）
	 * 
	 * @return 接收方帐号（收到的OpenID）
	 */
	public String getToUserName() {
		return ToUserName;
	}

	/**
	 * 设置 接收方帐号（收到的OpenID）
	 * 
	 * @return 接收方帐号（收到的OpenID）
	 */
	public String getFromUserName() {
		return FromUserName;
	}

	/**
	 * 获取 消息创建时间 （整型）
	 * 
	 * @return 消息创建时间 （整型）
	 */
	public Long getCreateTime() {
		return CreateTime;
	}

	/**
	 * 获取 消息类型
	 * 
	 * @return 消息类型
	 */
	public abstract String getMsgType();

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public void setCreateTime(Long createTime) {
		CreateTime = createTime;
	}

}
