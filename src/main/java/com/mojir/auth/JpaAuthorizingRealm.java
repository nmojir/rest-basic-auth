package com.mojir.auth;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAccount;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.cbi.hit.ts_core.utils.db.JpaUtil;

import com.mojir.auth.entities.Permission;
import com.mojir.auth.entities.Role;
import com.mojir.auth.entities.User;
import com.mojir.dao.UserDao;

public class JpaAuthorizingRealm extends AuthorizingRealm {

	final private String REALM_NAME = "MY_REALM";
	
	private EntityManager em = JpaUtil.getInstance().createEntityManager();;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		UserDao dao = new UserDao(em);
		User user = dao.findByUsername(principals.getPrimaryPrincipal().toString());
		if(user == null)
			return null;
				
		Set<String> roles = new HashSet<>();
		Set<String> permissions = new HashSet<>();
		for(Role role : user.getRoles())
		{
			roles.add(role.getName());
			for(Permission perm : role.getPermissions())
			{
				permissions.add(perm.getPerm());
			}
		}
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo(roles);
		authorizationInfo.setStringPermissions(permissions);
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		if(!(token instanceof UsernamePasswordToken))
			throw new IllegalStateException("Token must be an instance of UsernamePasswordToken");
		
		final UsernamePasswordToken userPassToken = (UsernamePasswordToken)token;
		
		UserDao dao = new UserDao(em);
		User user = dao.findByUsername(userPassToken.getUsername());
		if(user == null)
			return null;
		
		SimpleAccount simpleAccount = new SimpleAccount(
			user.getUsername(),
			user.getPassword(),
			ByteSource.Util.bytes("salt"),
			REALM_NAME
		);
				
		return simpleAccount;
	}

}
