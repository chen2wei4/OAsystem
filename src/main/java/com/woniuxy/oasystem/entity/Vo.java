/**  
 * @author 张钰平
 * @createDate 2020年4月28日
 */

package com.woniuxy.oasystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**  
 * @Description  vo实体，用于封装ajax多参传递
 * @author  张钰平
 * @changeLog 	1. 创建 (2020年4月28日 [张钰平])
 *              
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vo<T> {
	public T t;
	public Integer pageIndex;
}
