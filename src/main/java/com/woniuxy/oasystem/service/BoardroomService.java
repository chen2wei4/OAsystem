package com.woniuxy.oasystem.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oasystem.entity.Boardroom;
import com.woniuxy.oasystem.entity.Car;
import com.woniuxy.oasystem.entity.CarApply;
import com.woniuxy.oasystem.entity.OfficeSupplies;
import com.woniuxy.oasystem.entity.PageBean;

/**
 * 
 * @Description 会议室业务
 * @author 张钰平
 * @changeLog 1. 创建 (2020年4月26日 [张钰平])
 *
 */
public interface BoardroomService {
	//展示所有会议室
	PageBean< Boardroom> findAllByPage(Boardroom  boardroom,int pageIndex,int pageSize);
	// 根据 BoardroomId删除
	void deleteByBoardroomId(int boardroomId);

	// 根据 BoardroomId修改
	void updateByBoardroomId(Boardroom boardroom);

	// 添加会议室
	void insert(Boardroom boardroom);

}
