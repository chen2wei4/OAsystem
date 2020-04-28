package com.woniuxy.oasystem.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oasystem.entity.Car;
import com.woniuxy.oasystem.entity.CarApply;
import com.woniuxy.oasystem.entity.Meeting;
import com.woniuxy.oasystem.entity.MeetingApply;
import com.woniuxy.oasystem.entity.OfficeSupplies;
import com.woniuxy.oasystem.entity.PageBean;

/**
 * 
 * @Description 会议申请业务
 * @author 张钰平
 * @changeLog 1. 创建 (2020年4月26日 [张钰平])
 *
 */
public interface MeetingApplyService {
	//展示所有会议申请
	PageBean<MeetingApply> findAllByPage(MeetingApply meetingApply,int pageIndex,int pageSize);
	// 根据MaId删除
	void deleteByMaId(int maId);

	// 根据MaId修改
	void updateByMaId(MeetingApply meetingApply);

	// 添加
	void insert(MeetingApply meetingApply);

}
