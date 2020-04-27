/**  
 * @author 张钰平
 * @createDate 2020年4月26日
 */

package com.woniuxy.oasystem.entity;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**  
 * @Description  会议实体
 * @author  张钰平
 * @changeLog 	1. 创建 (2020年4月26日 [张钰平])
 *              
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Meeting {
private Integer meetingId;//主键
private Integer empId;//员工id
private String principal;//负责人
private String recorder;//记录员
private String topic;//主题
private Integer boardroomId;//会议室id
private Date startTime;//开始时间
private Date endTime;//结束时间
private String file;//文件地址
private List<Participant> participant;//参与人中间表
}
