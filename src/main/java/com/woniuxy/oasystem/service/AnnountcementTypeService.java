package com.woniuxy.oasystem.service;

import java.util.List;


import com.woniuxy.oasystem.entity.AnnouncementType;
import com.woniuxy.oasystem.entity.PageBean;

public interface AnnountcementTypeService {
	//插入新的公告分类
	public void addAnType(AnnouncementType anType);
	//展示所有公告分类
	public PageBean<AnnouncementType> ShowAllAnnountcementType(AnnouncementType antype, Integer pageIndex, Integer pageSize);
	//软删除公告类别
	public void DeleteAntypeById(Integer id);
	//修改公告类别
	public void UpdateAntypeById(AnnouncementType anType);
	/**
	 * TODO
	 * @return
	 * @changeLog 	1. 创建 (2020年4月30日 上午9:01:02 [liuwenpeng])
	 *              2.查询所有的公告类别
	 */
	public List<AnnouncementType> ShowAllAnnountcementTypes();
	/**
	 * TODO
	 * @param atId
	 * @return
	 * @changeLog 	1. 创建 (2020年5月4日 下午4:48:32 [liuwenpeng])
	 *              2.修改前的查询
	 */
	public AnnouncementType showantype(Integer atId);
	/**
	 * TODO
	 * @param atId
	 * @changeLog 	1. 创建 (2020年5月4日 下午5:07:38 [liuwenpeng])
	 *              2.开启公告类别
	 */
	public void StartAntypeById(Integer atId);
}
