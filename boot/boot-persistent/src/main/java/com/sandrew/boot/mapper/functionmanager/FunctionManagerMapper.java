package com.sandrew.boot.mapper.functionmanager;


import com.sandrew.boot.core.page.Pager;
import com.sandrew.boot.model.TmFunctionPO;

import java.util.List;


public interface FunctionManagerMapper
{
	/**
	 *  分页查询系统功能信息
	 * @param pager
	 * @return
     */
	public List<TmFunctionPO> functionManagerPageQuery(Pager pager);

}