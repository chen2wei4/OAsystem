/**  
 * @author 张钰平
 * @createDate 2020年4月27日
 */

package com.woniuxy.oasystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**  
 * @Description  会议室实体
 * @author  张钰平
 * @changeLog 	1. 创建 (2020年4月27日 [张钰平])
 *              
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Boardroom {
private Integer boardroomId;//主键
private String name;//会议室名
private String address;//会议室地址
private String useState;//使用状态
}
