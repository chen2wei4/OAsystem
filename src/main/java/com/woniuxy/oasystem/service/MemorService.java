package com.woniuxy.oasystem.service;

import java.util.List;

import com.woniuxy.oasystem.entity.Memor;
import com.woniuxy.oasystem.entity.PageBean;

public interface MemorService {
	void addMemor(Memor memor);
	void deleteMemor(Memor memor);
	void changeMemor(Memor memor);
	PageBean<Memor> getMemor(Memor memor, Integer page);
}
