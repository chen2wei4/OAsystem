package com.woniuxy.oasystem.service;

import java.util.List;

import com.woniuxy.oasystem.entity.Memor;

public interface MemorService {
	void addMemor(Memor memor);
	void deleteMemor(Memor memor);
	void changeMemor(Memor memor);
	List<Memor> getMemor(Memor memor);
}
