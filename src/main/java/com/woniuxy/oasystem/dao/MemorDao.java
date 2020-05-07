package com.woniuxy.oasystem.dao;

import java.util.List;

import com.woniuxy.oasystem.entity.Memor;
import org.apache.ibatis.annotations.Param;

public interface MemorDao {
	void addMemor(@Param("memor")Memor memor);
	void deleteMemor(@Param("memor")Memor memor);
	void changeMemor(@Param("memor")Memor memor);
	List<Memor> queryMemor(@Param("memor")Memor memor,@Param("page")Integer page);
}
