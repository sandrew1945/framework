package com.sandrew.boot.service.functionmanager;


import com.sandrew.boot.bean.FunctionBean;
import com.sandrew.boot.core.bean.AclUserBean;
import com.sandrew.boot.core.common.AjaxResult;
import com.sandrew.boot.core.exception.ServiceException;
import com.sandrew.boot.core.page.PageResult;
import com.sandrew.boot.model.TmFunctionPO;

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
