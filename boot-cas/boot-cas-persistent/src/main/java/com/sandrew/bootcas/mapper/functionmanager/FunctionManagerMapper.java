package com.sandrew.bootcas.mapper.functionmanager;


import com.sandrew.bootcas.model.TmFunctionPO;
import com.sandrew.bootcas.core.page.Pager;

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