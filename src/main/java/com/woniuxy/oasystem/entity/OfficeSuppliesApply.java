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
 * @Description  办公用品申请实体类
 * @author  张钰平
 * @changeLog 	1. 创建 (2020年4月24日 [张钰平])
 *              
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfficeSuppliesApply {
private Integer osaId;//主键
private Integer osNumber;//用品编号
private Integer empId;//职工id
private Integer number;//数量
private Date applyTime;//申请时间
private String review;//审核状态
private Integer flag;//软删除
}