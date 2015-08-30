package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aliapp.wxxd.material.entity.InputMessage;
import com.aliapp.wxxd.material.entity.InputMessageAbstract;
import com.aliapp.wxxd.material.entity.outputmessage.OutputMessageAbstract;
import com.aliapp.wxxd.material.entity.outputmessage.basic.TextOutputMessage;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import service.AbstractHandler;
import service.chain.AbstractFactoryChain;
import service.chain.SimpleFactoryChain;
import service.factory.AbstractFactory;
import service.factory.VanxdHandlerFactory;
import service.invoker.DefaultHandlerInvoker;
import service.invoker.HandlerInvokerAbstract;
import util.MessageUtil;
import util.SignUtil;

@Controller
public class Entry {

	@RequestMapping(value = "/entry", method = RequestMethod.GET)
	public void entry(@RequestParam(value = "signature") String signature,
			@RequestParam(value = "timestamp") String timestamp,
			@RequestParam(value = "nonce") String nonce,
			@RequestParam(value = "echostr") String echostr,
			HttpServletResponse response) {

		if (SignUtil.checkSignature(signature, timestamp, nonce)) {
			try {
				response.getWriter().write(echostr);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@RequestMapping(value = "/entry", method = RequestMethod.POST)
	public void entry(HttpServletResponse response, HttpServletRequest request)
			throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		InputMessage im = initInputMessage(request);

		// 默认使用简单工厂链
		AbstractFactoryChain sf = new SimpleFactoryChain();
		// 获取handler(具体命令)
		AbstractHandler handler = sf.process(im);
		// 执行具体命令，封装一些业务逻辑操作
		HandlerInvokerAbstract defaultHandlerInvoker = new DefaultHandlerInvoker(
				handler);
		// 输出
		writer.print(MessageUtil.objToXml(defaultHandlerInvoker.handle(im)));
	}

	private InputMessage initInputMessage(HttpServletRequest request)
			throws IOException, UnsupportedEncodingException {
		ServletInputStream in = request.getInputStream();
		// 将POST流转换为XStream对象
		XStream xs = new XStream(new DomDriver());
		// 将指定节点下的xml节点数据映射为对象
		xs.alias("xml", InputMessage.class);
		// 将流转换为字符串
		StringBuilder xmlMsg = new StringBuilder();
		byte[] b = new byte[4096];
		for (int n; (n = in.read(b)) != -1;) {
			xmlMsg.append(new String(b, 0, n, "UTF-8"));
		}
		// 将xml内容转换为InputMessage对象

		return (InputMessage) xs.fromXML(xmlMsg.toString());
	}

}
