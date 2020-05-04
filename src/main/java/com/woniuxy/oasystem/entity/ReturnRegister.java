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
 * @Description  车辆归还登记
 * @author  张钰平
 * @changeLog 	1. 创建 (2020年4月26日 [张钰平])
 *              
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReturnRegister {
	private Integer rrId;//主键
	private Integer empId;//员工id
	private String license;//车牌
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date returnTime;//归还时间
	private String maintenance;//维护
	private String place;//地点
	private Double mileage;//里程
	private Double oil;//耗油
	private String parkingPlace;//停车位
	private Integer flag;//软删除
}
