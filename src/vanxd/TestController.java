package vanxd;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/test")
public class TestController {
	@RequestMapping("/test1")
	public void test1(@RequestParam("content") String content){
		System.out.println(content.indexOf("\n"));
		content = content.replaceAll("\n", "/\n");
		System.out.println(content);
	}
}
