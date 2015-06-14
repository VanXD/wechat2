package interfaces;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import entity.InputMessageAbstract;

public interface MsgTypeInterface {
	
	public void inject(InputMessageAbstract ima);
}
