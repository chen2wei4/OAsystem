/**  
 * @author 张钰平
 * @createDate 2020年4月24日
 */

package com.woniuxy.oasystem.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**  
 * @Description  办公用品归还实体类
 * @author  张钰平
 * @changeLog 	1. 创建 (2020年4月24日 [张钰平])
 *              
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfficeSuppliesReturn {
private Integer osrId;//主键
private Integer empId;//职工id
private Integer osNumber;//物品编号
private Date returnTime;//归还时间
private String maintenance;//维护状态
private Integer flag;//软删除
}
