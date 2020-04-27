package com.woniuxy.oasystem.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oasystem.entity.Car;
import com.woniuxy.oasystem.entity.CarApply;
import com.woniuxy.oasystem.entity.Meeting;
import com.woniuxy.oasystem.entity.OfficeSupplies;
import com.woniuxy.oasystem.entity.PageBean;

/**
 * 
 * @Description 会议业务
 * @author 张钰平
 * @changeLog 1. 创建 (2020年4月26日 [张钰平])
 *
 */
public interface MeetingService {
	//展示所有会议
	PageBean<Meeting> findAllByPage(Meeting meeting,int pageIndex,int pageSize);
	// 根据mid删除
	void deleteByMid(int meetingId);

	// 根据mid修改
	void updateByMid(Meeting meeting);

	// 添加
	void insert(Meeting meeting);

}
