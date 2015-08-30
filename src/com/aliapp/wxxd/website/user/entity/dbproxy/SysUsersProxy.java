package com.aliapp.wxxd.website.user.entity.dbproxy;

import interfaces.EntityWrapperInterface;

import com.aliapp.wxxd.website.user.entity.db.SysPermissions;
import com.aliapp.wxxd.website.user.entity.db.SysUsers;

public class SysUsersProxy extends SysUsers implements EntityWrapperInterface {
	private String CredentialsSalt;

	public String getCredentialsSalt() {
		return CredentialsSalt;
	}

	public void setCredentialsSalt(String credentialsSalt) {
		CredentialsSalt = credentialsSalt;
	}

	@Override
	public void wrap(Object o) {
		if (o instanceof SysUsers) {
			SysUsers sysUsers = (SysUsers) o;
			setId(sysUsers.getId());
			setLocked(sysUsers.getLocked());
			setPassword(sysUsers.getPassword());
			setSalt(sysUsers.getSalt());
			setUsername(sysUsers.getUsername());
			setCredentialsSalt(sysUsers.getUsername() + sysUsers.getSalt());
		}
	}

}
