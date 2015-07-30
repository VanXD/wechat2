package service;

import com.aliapp.wxxd.material.entity.InputMessage;
import com.aliapp.wxxd.material.entity.InputMessageAbstract;
import com.aliapp.wxxd.material.entity.outputmessage.OutputMessageAbstract;

public abstract class AbstractHandler {
	protected AbstractHandler nextHandler;
	
	protected OutputMessageAbstract oma;
	
	public abstract OutputMessageAbstract handle(InputMessageAbstract im);

	public void setNextHandler(AbstractHandler nextHandler) {
		this.nextHandler = nextHandler;
	}

	public OutputMessageAbstract getOma() {
		return oma;
	}
}
