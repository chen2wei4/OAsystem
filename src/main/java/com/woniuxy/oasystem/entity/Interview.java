package com.woniuxy.oasystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @Description  面试记录实体类
 * @author  王培霖
 * @changeLog 	1. 创建 (2020年4月27日 下午10:50:32 [王培霖])
 *                      	2.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Interview {
	private Integer interviewId; // 面试id
	private Integer intervieweeId; // 面试人id
	private Integer positionId; // 面试职位id
	private Integer interviewInterviewer; // 面试官id
	private String empIdNumber; // 面试官工号
	private String intervieweeName; // 面试人姓名
	private String empName; // 面试官姓名
	private String positionName; // 面试职位
	private String interviewLocation; // 面试地点
	private String interviewTime; // 面试时间
	/**
	 * 构造方法
	 * @param intervieweeId
	 * @param positionId
	 * @param interviewInterviewer
	 * @param intervieweeName
	 * @param empName
	 * @param positionName
	 * @param interviewLocation
	 * @param interviewTime
	 */
	public Interview(Integer intervieweeId, Integer positionId, Integer interviewInterviewer, String intervieweeName,
			String empName, String positionName, String interviewLocation, String interviewTime) {
		super();
		this.intervieweeId = intervieweeId;
		this.positionId = positionId;
		this.interviewInterviewer = interviewInterviewer;
		this.intervieweeName = intervieweeName;
		this.empName = empName;
		this.positionName = positionName;
		this.interviewLocation = interviewLocation;
		this.interviewTime = interviewTime;
	}
	
	/**
	 * 构造方法
	 * @param intervieweeId
	 * @param positionId
	 * @param interviewInterviewer
	 * @param interviewLocation
	 * @param interviewTime
	 */
	public Interview(int intervieweeId, int positionId, int interviewInterviewer, String interviewLocation,
			String interviewTime) {
		super();
		this.intervieweeId = intervieweeId;
		this.positionId = positionId;
		this.interviewInterviewer = interviewInterviewer;
		this.interviewLocation = interviewLocation;
		this.interviewTime = interviewTime;
	}

	public Interview(Integer interviewId, Integer positionId, Integer interviewInterviewer, String interviewLocation,
			String interviewTime) {
		super();
		this.interviewId = interviewId;
		this.positionId = positionId;
		this.interviewInterviewer = interviewInterviewer;
		this.interviewLocation = interviewLocation;
		this.interviewTime = interviewTime;
	}

	
	
	
}
