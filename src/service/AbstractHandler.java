package service;

import entity.InputMessage;
import entity.InputMessageAbstract;
import entity.outputmessage.OutputMessageAbstract;

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
