package com.woniuxy.oasystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @Description  面试人信息实体类
 * @author  王培霖
 * @changeLog 	1. 创建 (2020年4月27日 下午10:48:55 [王培霖])
 *                      	2.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IntervieweeInfo {
	private Integer intervieweeId;
	private Integer positionId;
	private String positionName;
	private String intervieweeName;
	private Integer intervieweeAge;
	private String intervieweeGender;
	private String intervieweeEducationBackground;
	private String intervieweeGraduateInstitution;
	private String intervieweeMajor;
	private String intervieweePhone;
	private Integer flag;
	/**
	 * 构造方法
	 * @param positionId
	 * @param intervieweeName
	 * @param intervieweeAge
	 * @param intervieweeGender
	 * @param intervieweeEducationBackground
	 * @param intervieweeGraduateInstitution
	 * @param intervieweeMajor
	 * @param intervieweePhone
	 * @param flag
	 */
	public IntervieweeInfo(Integer positionId, String intervieweeName, Integer intervieweeAge, String intervieweeGender,
			String intervieweeEducationBackground, String intervieweeGraduateInstitution, String intervieweeMajor,
			String intervieweePhone) {
		super();
		this.positionId = positionId;
		this.intervieweeName = intervieweeName;
		this.intervieweeAge = intervieweeAge;
		this.intervieweeGender = intervieweeGender;
		this.intervieweeEducationBackground = intervieweeEducationBackground;
		this.intervieweeGraduateInstitution = intervieweeGraduateInstitution;
		this.intervieweeMajor = intervieweeMajor;
		this.intervieweePhone = intervieweePhone;
	}
	public IntervieweeInfo(Integer intervieweeId, Integer positionId, String intervieweeName, Integer intervieweeAge,
			String intervieweeGender, String intervieweeEducationBackground, String intervieweeGraduateInstitution,
			String intervieweeMajor, String intervieweePhone) {
		super();
		this.intervieweeId = intervieweeId;
		this.positionId = positionId;
		this.intervieweeName = intervieweeName;
		this.intervieweeAge = intervieweeAge;
		this.intervieweeGender = intervieweeGender;
		this.intervieweeEducationBackground = intervieweeEducationBackground;
		this.intervieweeGraduateInstitution = intervieweeGraduateInstitution;
		this.intervieweeMajor = intervieweeMajor;
		this.intervieweePhone = intervieweePhone;
	}
	
}
