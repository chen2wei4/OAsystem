
package com.woniuxy.oasystem.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**  
 * @Description  办公用品请购实体类
 * @author  张钰平
 * @changeLog 	1. 创建 (2020年4月24日 [张钰平])
 *              
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfficeSuppliesBuy {
private Integer osbId;//主键
private Emp emp;//职工id
private String content;//内容
@DateTimeFormat(pattern = "yyyy-MM-dd")
@JsonFormat(pattern = "yyyy-MM-dd")
private Date buyTime;//请购时间
private String state;//处理状态
private Integer flag;//软删除
}
