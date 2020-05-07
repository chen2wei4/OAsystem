/**  
 * @author 王培霖
 * @createDate 2020年4月24日
 */

package com.woniuxy.oasystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**  
 * @Description  假期实体类
 * @author  王培霖
 * @changeLog 	1. 创建 (2020年4月24日 下午5:16:42 [王培霖])
 *                      	2.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vacation {
	private Integer vacationId;
	private String vacationName;
}
