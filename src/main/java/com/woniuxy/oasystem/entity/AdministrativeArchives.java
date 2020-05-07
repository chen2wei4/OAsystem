/**  
 * @author 张钰平
 * @createDate 2020年4月27日
 */

package com.woniuxy.oasystem.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**  
 * @Description  行政档案实体
 * @author  张钰平
 * @changeLog 	1. 创建 (2020年4月27日 [张钰平])
 *              
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdministrativeArchives {
private Integer aaId;//主键
private String name;//档案名
private String file;//文件地址
@DateTimeFormat(pattern = "yyyy-MM-dd")
@JsonFormat(pattern = "yyyy-MM-dd")
private Date time;//入档时间
private String sort;//档案类别
}
