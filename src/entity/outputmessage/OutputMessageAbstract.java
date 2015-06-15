package entity.outputmessage;

import entity.InputMessageAbstract;
import interfaces.MsgTypeInterface;

public abstract class OutputMessageAbstract implements MsgTypeInterface {
	private String ToUserName;
	private String FromUserName;
	private Long CreateTime;

	public String getToUserName() {
		return ToUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public Long getCreateTime() {
		return CreateTime;
	}

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

	@Override
	public void inject(InputMessageAbstract ima) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inject(InputMessageAbstract ima, String content) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inject(InputMessageAbstract ima, String VideoStr, String Title,
			String Description) {
		// TODO Auto-generated method stub
		
	}
	

}
