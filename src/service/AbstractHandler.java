package service;

import com.aliapp.wxxd.material.entity.InputMessage;
import com.aliapp.wxxd.material.entity.InputMessageAbstract;
import com.aliapp.wxxd.material.entity.outputmessage.OutputMessageAbstract;

public abstract class AbstractHandler {
	protected OutputMessageAbstract oma;
	
	public abstract OutputMessageAbstract handle(InputMessageAbstract im);

	public OutputMessageAbstract getOma() {
		return oma;
	}
}
