package com.woniuxy.oasystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Interview {
	private int interviewId; // 面试id
	private int intervieweeId; // 面试人id
	private int positionId; // 面试职位id
	private int interviewInterviewer; // 面试官id
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
	public Interview(int intervieweeId, int positionId, int interviewInterviewer, String intervieweeName,
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
	
	
}
