package com.woniuxy.oasystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IntervieweeInfo {
	private int intervieweeId;
	private int positionId;
	private String positionName;
	private String intervieweeName;
	private int intervieweeAge;
	private String intervieweeGender;
	private String intervieweeEducationBackground;
	private String intervieweeGraduateInstitution;
	private String intervieweeMajor;
	private String intervieweePhone;
	private int flag;
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
	public IntervieweeInfo(int positionId, String intervieweeName, int intervieweeAge, String intervieweeGender,
			String intervieweeEducationBackground, String intervieweeGraduateInstitution, String intervieweeMajor,
			String intervieweePhone, int flag) {
		super();
		this.positionId = positionId;
		this.intervieweeName = intervieweeName;
		this.intervieweeAge = intervieweeAge;
		this.intervieweeGender = intervieweeGender;
		this.intervieweeEducationBackground = intervieweeEducationBackground;
		this.intervieweeGraduateInstitution = intervieweeGraduateInstitution;
		this.intervieweeMajor = intervieweeMajor;
		this.intervieweePhone = intervieweePhone;
		this.flag = flag;
	}
	
}
