/**  
 * @author 张钰平
 * @createDate 2020年4月26日
 */

package com.woniuxy.oasystem.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**  
 * @Description  车辆申请
 * @author  张钰平
 * @changeLog 	1. 创建 (2020年4月26日 [张钰平])
 *              
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarApply {
private Integer caId;//主键
private Integer empId;//员工id
private String license;//车牌
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
private Integer flag;//软删除
}
