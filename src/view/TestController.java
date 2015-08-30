package view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aliapp.wxxd.website.user.service.SysPermissionsMapperProxy;
import com.aliapp.wxxd.website.user.service.SysRolesMapperProxy;

@Controller
@RequestMapping("/text")
public class TestController {
	@Autowired
	SysRolesMapperProxy sysRolesMapperProxy;
	@Autowired
	private SysPermissionsMapperProxy sysPermissionsMapperProxy;

	@RequestMapping("/testexample")
	public void testExample() {
		System.out.println(sysPermissionsMapperProxy.selectPermissionsByUsername("zhang"));
	}
}
