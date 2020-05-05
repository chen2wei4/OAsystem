/**  
 * @author 张钰平
 * @createDate 2020年4月27日
 */

package com.woniuxy.oasystem.entity;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**  
 * @Description  TODO
 * @author  张钰平
 * @changeLog 	1. 创建 (2020年4月27日 [张钰平])
 *              
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MeetingApply {
private Integer maId;//主键
private Emp emp;//员工id
@DateTimeFormat(pattern = "yyyy-MM-dd")
@JsonFormat(pattern = "yyyy-MM-dd")
private Date applyTime;//申请时间
@DateTimeFormat(pattern = "yyyy-MM-dd")
@JsonFormat(pattern = "yyyy-MM-dd")
private Date startTime;//开始时间
@DateTimeFormat(pattern = "yyyy-MM-dd")
@JsonFormat(pattern = "yyyy-MM-dd")
private Date endTime;//结束时间
private String purpose;//用途
private String review;//审核
private Boardroom boardroom;//会议室id
}
