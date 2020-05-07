/**  
 * @author 王培霖
 * @createDate 2020年5月3日
 */

package com.woniuxy.oasystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**  
 * @Description  打卡记录
 * @author  王培霖
 * @changeLog 	1. 创建 (2020年5月3日 下午5:15:11 [王培霖])
 *                      	2.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckIn {
	private Emp emp; // 员工
	private String signTime; // 签到时间
	private String patchcardTime; // 补签时间
	private Integer signResult; // 签到结果
	private Integer flag; // 软删除
	@Override
	public String toString() {
		return "CheckIn [emp=" + emp + ", signTime=" + signTime + ", patchcardTime="
				+ patchcardTime + ", signResult=" + signResult + ", flag=" + flag + "]";
	}
	
}
