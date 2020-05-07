/**
 * @author 陈一玮
 * @createDate 2020年5月5日
 */
package com.woniuxy.oasystem.realm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.woniuxy.oasystem.entity.Emp;
import com.woniuxy.oasystem.service.EmpService;
import com.woniuxy.oasystem.util.RegexUtil;

/**
 * @Description TODO
 * @author 陈一玮
 * @changeLog 1.创建 (2020年5月5日 下午3:27:05 [陈一玮]
 *            2.
 */
public class UserRealm extends AuthorizingRealm{
	@Autowired
	EmpService empService;
	@Autowired
	Emp emp;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("doGetAuthorizationInfo");
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		Collection<String> permissions=new ArrayList<String>();
//		permissions.add("customer:insert");
//		permissions.add("customer:select");
//		permissions.add("customer:delete");
//		permissions.add("customer:update");

//		authorizationInfo.addStringPermission("customer:delete");
//		authorizationInfo.addStringPermission("customer:select");
		//事务模块权限叠加
		 permissions=affair(permissions);
		authorizationInfo.addStringPermissions(permissions);
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("doGetAuthenticationInfo");
		//提交的用户名
		String principal = (String) token.getPrincipal();
		emp=null;
		//判断用户名是数字，手机号，还是邮箱，然后通过相对应的方法进行查询
		if(principal.matches(RegexUtil.isMath)&&!principal.matches(RegexUtil.isCellNumber)) {
			emp=empService.getEmpId(Integer.valueOf(principal));
		}else if(principal.matches(RegexUtil.isCellNumber)) {
			emp=empService.getEmpCellNumber(principal);
		}else if(principal.matches(RegexUtil.isEmail)) {
			emp=empService.getEmpEmail(principal);
		}
//		//如果上述账号查询不到账户信息，则用户名不存在
		if(emp==null){
			return null;
		}
		String credentials=emp.getEmpPassword();
		
		AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(principal, credentials, this.getName());
		return authenticationInfo;
	}
	
	//事务权限
	public Collection<String> affair(Collection<String> permissions){
		//获得当前员工权限
		Integer roleId=emp.getRole().getRoleId();
		if(roleId==1) {
			//管理员
		permissions.add("apply:add");
		permissions.add("patchcard:query");
		permissions.add("reception:add");
		}else if(roleId==2) {
			
			
		}else {
			
			
		}
		return  permissions;
	}
}
