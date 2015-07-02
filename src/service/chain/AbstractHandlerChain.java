package service.chain;

import service.AbstractHandler;
import entity.InputMessage;
import entity.InputMessageAbstract;
import entity.outputmessage.OutputMessageAbstract;

public abstract class AbstractHandlerChain {
	// 链首handler
	protected AbstractHandler entryHandler;
	
	protected OutputMessageAbstract oma;
	/**
	 * 调用链首handler
	 */
	public OutputMessageAbstract process(InputMessageAbstract im) {
		oma = entryHandler.handle(im);
		return oma;
	}

	public AbstractHandler getEntryHandler() {
		return entryHandler;
	}

	/**
	 * @param entryHandler
	 *            只有在自己的HandlerChain里才能设置链首
	 */
	protected void setEntryHandler(AbstractHandler entryHandler) {
		this.entryHandler = entryHandler;
	}

	public OutputMessageAbstract getOma() {
		return oma;
	}
}
