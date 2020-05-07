/**  
 * @author 张钰平
 * @createDate 2020年4月26日
 */

package com.woniuxy.oasystem.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**  
 * @Description  会议参与人实体
 * @author  张钰平
 * @changeLog 	1. 创建 (2020年4月26日 [张钰平])
 *              
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Participant {
private Integer participantId;//主键
private Integer empId;//员工id
private Integer meetingId;//会议id
private String flag;//软删除
}
