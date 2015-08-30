package service.invoker;

import service.AbstractHandler;

import com.aliapp.wxxd.material.entity.InputMessage;
import com.aliapp.wxxd.material.entity.outputmessage.OutputMessageAbstract;
import com.aliapp.wxxd.material.entity.outputmessage.basic.TextOutputMessage;

public class DefaultHandlerInvoker extends HandlerInvokerAbstract {

	/**
	 * 
	 */
	public DefaultHandlerInvoker() {
		super();
	}

	/**
	 * @param handler
	 */
	public DefaultHandlerInvoker(AbstractHandler handler) {
		super(handler);
	}

	@Override
	public OutputMessageAbstract handle(InputMessage im) {
		if (handler != null) {
			return handler.handle(im);
		} else {
			OutputMessageAbstract oma;
			oma = new TextOutputMessage("暂不支持此服务,谢谢.");
			oma.inject(im);
			return oma;
		}
	}

}
