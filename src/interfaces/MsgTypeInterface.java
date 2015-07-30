package interfaces;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.aliapp.wxxd.material.entity.InputMessageAbstract;

public interface MsgTypeInterface {
	
	public void inject(InputMessageAbstract ima);
	public void inject(InputMessageAbstract ima, String content);
	public void inject(InputMessageAbstract ima, String VideoStr, String Title, String Description);
}
