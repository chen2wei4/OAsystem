/**
 * @author 陈一玮
 * @createDate 2020年4月24日
 */
package com.woniuxy.oasystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 职工角色实体类
 * @author 陈一玮
 * @changeLog 1.创建 (2020年4月24日 上午9:25:05 [陈一玮]
 *            2.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
	private Integer roleId;
	private String roleName;
	private Integer flag;
}
