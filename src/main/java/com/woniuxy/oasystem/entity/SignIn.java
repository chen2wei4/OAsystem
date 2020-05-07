/**  
 * @author 王培霖
 * @createDate 2020年5月2日
 */

package com.woniuxy.oasystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**  
 * @Description  签到实体
 * @author  王培霖
 * @changeLog 	1. 创建 (2020年5月2日 下午9:28:05 [王培霖])
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignIn {
	private Integer signinId;
	private Integer empId;
	private String signTime;
	private Integer signResult;
	private Integer flag;
}
