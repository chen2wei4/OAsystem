/**
 * @author liuwenpeng
 * @createDate 2020年4月29日
 */
package com.woniuxy.oasystem.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Description  TODO
 * @author liuwenpeng
 * @changeLog 	1. 创建 (2020年4月29日 下午3:22:21 [liuwenpeng])
 * 				2.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AnnouncementWatched {
	private Integer awId;
	private Integer awEmpId;
	private Integer awAnId;
	private Date awTime;
	private Emp emp;
}
