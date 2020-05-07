package com.woniuxy.oasystem.entity;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Announcement {

	private Integer anId;
	private Integer anEmpId;
	private Integer anType;
	private String anName;
	private String anContent;
	private Date anTime;
	private Boolean anFlag;
	private AnnouncementType atype;
	private Emp emp;
	private Boolean iswatched;
	//公告观看人数
	private Integer countwatch;
	//公告观看人员信息列表
	private List<AnnouncementWatched> watchedlist;
}
