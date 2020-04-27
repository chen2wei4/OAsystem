package com.woniuxy.oasystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oasystem.entity.Car;
import com.woniuxy.oasystem.entity.CarApply;
import com.woniuxy.oasystem.entity.Meeting;
import com.woniuxy.oasystem.entity.MeetingApply;
import com.woniuxy.oasystem.entity.OfficeSupplies;
/**
 * 
 * @Description  会议申请管理dao
 * @author  张钰平
 * @changeLog 	1. 创建 (2020年4月26日 [张钰平])
 *
 */
public interface MeetingApplyDao {
	//展示所有会议申请
	List<MeetingApply> findAllByPage(@Param("ma")MeetingApply meetingApply,@Param("pageIndex")int pageIndex,
			@Param("pageSize")int pageSize);
	int findAllByPageCount(@Param("ma")MeetingApply meetingApply);
	//根据maId删除
	void deleteByMaId(int maId);
	//根据maId修改
	void updateByMaId(@Param("ma")MeetingApply meetingApply);
	//添加
	void insert(@Param("ma")MeetingApply meetingApply);
}
