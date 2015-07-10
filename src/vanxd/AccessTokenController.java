package vanxd;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import util.MessageUtil;
import util.PropertyUtil;

@Controller
public class AccessTokenController {

	@RequestMapping("/accesstoken")
	public void accessToken(HttpServletResponse response) {
		String accessToken = MessageUtil.getAccess_token();
		try {
			response.getWriter().write(accessToken);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
