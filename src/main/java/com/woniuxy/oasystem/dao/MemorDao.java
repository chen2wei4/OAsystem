package com.woniuxy.oasystem.dao;

import java.util.List;

import com.woniuxy.oasystem.entity.Memor;

public interface MemorDao {
	void addMemor(Memor memor);
	void deleteMemor(Memor memor);
	void changeMemor(Memor memor);
	List<Memor> queryMemor(Memor memor);
}
