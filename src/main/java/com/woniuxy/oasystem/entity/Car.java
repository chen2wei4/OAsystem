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
 * @Description  TODO
 * @author  张钰平
 * @changeLog 	1. 创建 (2020年4月26日 [张钰平])
 *              
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
private Integer carId;//主键
private String license;//车牌
private String maintenance;//维护
private String useState;//使用状态
private String parkingSpace;//停车位
private Integer flag;//软删除
}
