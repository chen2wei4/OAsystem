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
		permissions.add("customer:insert");
		permissions.add("customer:select");
//		permissions.add("customer:delete");
		permissions.add("customer:update");
//		authorizationInfo.addStringPermissions(permissions);
		//行政部门权限
		Collection<String> administrativePermissions=new ArrayList<String>();
		if(emp.getRole().getRoleName().equals("员工")) {
			administrativePermissions.add("worker:select");
			administrativePermissions.add("worker:insert");
			administrativePermissions.add("worker:update");
			administrativePermissions.add("worker:delete");
			administrativePermissions.add("worker:upload");
		}else if(emp.getRole().getRoleName().equals("行政部门")) {
			administrativePermissions.add("AdministrativeManager:select");
			administrativePermissions.add("AdministrativeManager:insert");
			administrativePermissions.add("AdministrativeManager:update");
			administrativePermissions.add("AdministrativeManager:delete");
			administrativePermissions.add("AdministrativeManager:upload");
		}
		
		//事务模块权限叠加
		 administrativePermissions=affair(administrativePermissions);
		 //公告模块权限
		 administrativePermissions=affairann(administrativePermissions);

		authorizationInfo.addStringPermissions(administrativePermissions);
		
		authorizationInfo.addStringPermission("customer:delete");
		authorizationInfo.addStringPermission("customer:select");
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

	//根据用户的角色id，将权限进行分配
	public Collection<String> getPermissions(Integer roleId){
		Collection<String> permissions=new ArrayList<String>();
		if(roleId==2) {
			permissions.add("customer:select");
			permissions.add("contract:select");
			permissions.add("order:select");
			
		}else if(roleId==3) {
			permissions.add("customer:select");
			permissions.add("customer:select1");
			permissions.add("contract:select1");
			permissions.add("order:select1");
			permissions.add("contract:select");
			permissions.add("order:select");
			permissions.add("customer:insert");
			permissions.add("contract:insert");
			permissions.add("order:insert");
			permissions.add("customer:update");
			permissions.add("contract:update");
			permissions.add("order:update");
		}else if(roleId==4) {
			permissions.add("customer:select");
			permissions.add("contract:select");
			permissions.add("customer:select1");
			permissions.add("contract:select1");
			permissions.add("order:select1");
			permissions.add("order:select");
			permissions.add("customer:insert");
			permissions.add("contract:insert");
			permissions.add("order:insert");
			permissions.add("customer:update");
			permissions.add("contract:update");
			permissions.add("order:update");
			permissions.add("customer:delete");
			permissions.add("contract:delete");
			permissions.add("order:delete");
		}
		return permissions;
		
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

	//公告权限
		public Collection<String> affairann(Collection<String> permissions){
			//获得当前员工权限
			Integer roleId=emp.getRole().getRoleId();
			if(roleId==1) {
				//管理员
			permissions.add("announcement:manage");
			permissions.add("announcement:select");
			}else {
			permissions.add("announcement:select");		
			}
			return  permissions;
		}
} 
