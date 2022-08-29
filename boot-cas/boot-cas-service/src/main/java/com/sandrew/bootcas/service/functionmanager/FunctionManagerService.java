package com.sandrew.bootcas.service.functionmanager;


import com.sandrew.bootcas.bean.FunctionBean;
import com.sandrew.bootcas.core.bean.AclUserBean;
import com.sandrew.bootcas.core.common.AjaxResult;
import com.sandrew.bootcas.core.exception.ServiceException;
import com.sandrew.bootcas.core.page.PageResult;
import com.sandrew.bootcas.model.TmFunctionPO;

import java.util.List;

/**
 * Created by summer on 2018/2/15.
 */
public interface FunctionManagerService
{

    PageResult<FunctionBean> functionManagerPageQuery(TmFunctionPO condition, int curPage) throws ServiceException;

    AjaxResult createFunction(TmFunctionPO function, AclUserBean loginUser) throws ServiceException;

    TmFunctionPO findFunctionById(Integer functionId) throws ServiceException;

    AjaxResult updateFunctionInfo(TmFunctionPO function, AclUserBean loginUser) throws ServiceException;

    AjaxResult deleteFunctionInfo(Integer functionId, AclUserBean loginUser) throws ServiceException;

    List<TmFunctionPO> getAllFucntion() throws ServiceException;

}
