package vanxd;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import util.MessageUtil;

@Controller
public class ButtonController {
	
//	@RequestMapping("/deleteButton")
	public void deleteButton(HttpServletResponse response){
		try {
			response.getWriter().write(MessageUtil.deleteMenu());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
