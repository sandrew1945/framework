package com.sandrew.boot.service.functionmanager.impl;

import com.sandrew.boot.bean.FunctionBean;
import com.sandrew.boot.core.bean.AclUserBean;
import com.sandrew.boot.core.common.AjaxResult;
import com.sandrew.boot.core.common.Constants;
import com.sandrew.boot.core.exception.ServiceException;
import com.sandrew.boot.core.page.PageQueryBuilder;
import com.sandrew.boot.core.page.PageResult;
import com.sandrew.boot.mapper.TmFunctionPOMapper;
import com.sandrew.boot.mapper.functionmanager.FunctionManagerMapper;
import com.sandrew.boot.model.TmFunctionPO;
import com.sandrew.boot.model.TmFunctionPOExample;
import com.sandrew.boot.service.functionmanager.FunctionManagerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by summer on 2018/2/19.
 */
@Service
@Log4j2
public class FunctionManagerServiceImpl implements FunctionManagerService
{
    @Resource
    FunctionManagerMapper functionManagerMapper;

    @Resource
    TmFunctionPOMapper tmFunctionPOMapper;

    @Override
    public PageResult<FunctionBean> functionManagerPageQuery(TmFunctionPO condition, int curPage) throws ServiceException
    {

        try
        {
            return PageQueryBuilder.pageQuery(functionManagerMapper, "functionManagerPageQuery", condition, curPage);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            log.error(e.getMessage(), e);
            throw new ServiceException("分页查询功能列表失败", e);
        }
    }

    @Override
    public AjaxResult createFunction(TmFunctionPO function, AclUserBean loginUser) throws ServiceException
    {
        AjaxResult result = new AjaxResult();
        try
        {
            // 判断应用系统信息是否存在
            boolean isExits = false;
            TmFunctionPOExample example = new TmFunctionPOExample();
            TmFunctionPOExample.Criteria criteria = example.createCriteria();
            criteria.andFunctionCodeEqualTo(function.getFunctionCode()).andIsDeleteEqualTo(Constants.IF_TYPE_NO);
            List<TmFunctionPO> list = tmFunctionPOMapper.selectByExample(example);
            isExits = (null != list && list.size() > 0) ? true : false;
            if (!isExits)
            {
                function.setFunctionType(Constants.FUNC_TYPE_MENU);
                function.setIsDelete(Constants.IF_TYPE_NO);
                function.setCreateBy(loginUser.getUserId());
                function.setCreateDate(new Date());
                tmFunctionPOMapper.insertSelective(function);
                result.requestSuccess();
            }
            else
            {
                result.requestFailure("应用系统已经存在");
            }
            return result;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            log.error(e.getMessage(), e);
            throw new ServiceException("创建系统功能失败", e);
        }
    }

    /**
     * 根绝ID获取功能信息
     *
     * @param functionId
     * @return
     * @throws ServiceException
     */
    @Override
    public TmFunctionPO findFunctionById(Integer functionId) throws ServiceException
    {
        try
        {
            return tmFunctionPOMapper.selectByPrimaryKey(functionId);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            log.error(e.getMessage(), e);
            throw new ServiceException("查询功能信息失败", e);
        }
    }

    /**
     * @param function
     * @param loginUser
     * @return
     * @throws ServiceException
     */
    @Override
    public AjaxResult updateFunctionInfo(TmFunctionPO function, AclUserBean loginUser) throws ServiceException
    {
        AjaxResult result = new AjaxResult();
        try
        {
            TmFunctionPOExample cond = new TmFunctionPOExample();
            TmFunctionPOExample.Criteria criteria = cond.createCriteria();
            criteria.andFunctionIdEqualTo(function.getFunctionId());

            function.setUpdateBy(loginUser.getUserId());
            function.setUpdateDate(new Date());
            int count = tmFunctionPOMapper.updateByExampleSelective(function, cond);
            if (count > 0)
            {
                result.requestSuccess();
            }
            else
            {
                result.requestFailure("更新功能信息失败");
            }
            return result;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            log.error(e.getMessage(), e);
            throw new ServiceException("更新功能信息失败", e);
        }
    }

    /**
     *  删除系统功能
     * @param functionId
     * @param loginUser
     * @return
     * @throws ServiceException
     */
    @Override
    public AjaxResult deleteFunctionInfo(Integer functionId, AclUserBean loginUser) throws ServiceException
    {
        AjaxResult result = new AjaxResult();
        try
        {
            TmFunctionPOExample cond = new TmFunctionPOExample();
            TmFunctionPOExample.Criteria criteria = cond.createCriteria();
            criteria.andFunctionIdEqualTo(functionId);

            TmFunctionPO value = new TmFunctionPO();
            value.setIsDelete(Constants.IF_TYPE_YES);
            value.setUpdateBy(loginUser.getUserId());
            value.setUpdateDate(new Date());

            int count = tmFunctionPOMapper.updateByExampleSelective(value, cond);
            if(count > 0)
            {
                result.requestSuccess();
            }
            else
            {
                result.requestFailure("删除功能失败");
            }
            return result;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            log.error(e.getMessage(), e);
            throw new ServiceException("删除系统功能失败", e);
        }
    }

    /**
     *  获取全部有效的系统功能
     * @return
     * @throws ServiceException
     */
    @Override
    public List<TmFunctionPO> getAllFucntion() throws ServiceException
    {
        try
        {
            TmFunctionPOExample cond = new TmFunctionPOExample();
            TmFunctionPOExample.Criteria criteria = cond.createCriteria();
            criteria.andIsDeleteEqualTo(Constants.IF_TYPE_NO).andFunctionStatusEqualTo(Constants.STATUS_ENABLE);
            List<TmFunctionPO> functionList = tmFunctionPOMapper.selectByExample(cond);
            return functionList;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            log.error(e.getMessage(), e);
            throw new ServiceException("获取系统功能列表失败", e);
        }
    }
}
