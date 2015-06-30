package service;

import entity.InputMessage;

public abstract class AbstractHandler {
	protected AbstractHandler nextHandler;

	public abstract void handle(InputMessage im);

	public void setNextHandler(AbstractHandler nextHandler) {
		this.nextHandler = nextHandler;
	}

}
