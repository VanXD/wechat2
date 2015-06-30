package vanxd;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import util.MessageUtil;

@Controller
public class AccessTokenController {

	@RequestMapping("/accesstoken")
	public void accessToken(HttpServletResponse response) {
		String accessToken = MessageUtil.getAccess_token();
		try {
			response.getWriter().write(accessToken);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
