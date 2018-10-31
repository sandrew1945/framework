package com.sandrew.boot.controller.functionmanager;


import com.sandrew.boot.bean.FunctionBean;
import com.sandrew.boot.core.bean.BaseCondition;
import com.sandrew.boot.core.common.AjaxResult;
import com.sandrew.boot.core.common.Constants;
import com.sandrew.boot.core.controller.BaseController;
import com.sandrew.boot.core.exception.ActionException;
import com.sandrew.boot.core.exception.JsonException;
import com.sandrew.boot.core.exception.ServiceException;
import com.sandrew.boot.core.page.PageResult;
import com.sandrew.boot.model.TmFunctionPO;
import com.sandrew.boot.service.functionmanager.FunctionManagerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.annotation.Resource;


@Log4j2
@Controller
@RequestMapping("/functionmanager")
@SessionAttributes(value = {Constants.CONDITION}, types = {BaseCondition.class})
public class FunctionManagerController extends BaseController
{
    @Resource
    private FunctionManagerService functionManagerService;

    /**
     * 进入功能管理查询页面,清空session中的条件回显
     *
     * @return String
     */
    @RequestMapping(value = "/initFunctionmanagerPre")
    public String initFunctionmanagerPre(SessionStatus status) throws ActionException
    {
        status.setComplete();
        return "functionManager/functionmanager";
    }

    /**
     * 进入功能管理查询页面
     *
     * @return String
     */
    @RequestMapping(value = "/functionManagerPre")
    public String functionManagerPre() throws ActionException
    {

        return "functionManager/functionmanager";
    }

    /**
     * 用户信息查询所有
     *
     * @param condition
     * @param curPage
     * @return
     */
    @RequestMapping(value = "/functionManagerPageQuery")
    public
    @ResponseBody
    PageResult<FunctionBean> functionManagerPageQuery(TmFunctionPO condition, int curPage) throws JsonException
    {
        try
        {
            return functionManagerService.functionManagerPageQuery(condition, curPage);
        }
        catch (Exception e)
        {
            log.error(e.getMessage(), e);
            throw new JsonException(e.getMessage(), e);
        }

    }

    /**
     * Function    : 进入创建应用
     * LastUpdate  : 2016年4月16日
     *
     * @return
     */
    @RequestMapping(value = "/createFuncInfoPre")
    public String createFuncInfoPre() throws ActionException
    {
        return "functionManager/createfunctioninfo";
    }

    /**
     * Function    : 编辑用户信息
     * LastUpdate  : 2016年4月16日
     *
     * @return
     */
    @RequestMapping(value = "/updateFuncInfoPre")
    public String updateFuncInfoPre(Integer functionId, Model model) throws ActionException
    {
        try
        {
            TmFunctionPO function = functionManagerService.findFunctionById(functionId);
            model.addAttribute("func", function);
            return "functionManager/updatefunction";
        }
        catch (ServiceException e)
        {
            e.printStackTrace();
            log.error(e.getMessage(), e);
            throw new ActionException("编辑应用系统信息失败", e);
        }
    }

    /**
     *  创建应用系统信息
     * @param function
     * @return
     * @throws JsonException
     */
    @RequestMapping(value = "/createFunction")
    public
    @ResponseBody
    AjaxResult createFunction(TmFunctionPO function) throws JsonException
    {
        try
        {
            return functionManagerService.createFunction(function, getLoginUser());
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new JsonException(e.getMessage(), e);
        }
    }


    /**
     *  系统功能信息编辑
     * @param function
     * @return
     * @throws JsonException
     */
    @RequestMapping(value = "/updateFunctionInfo")
    public
    @ResponseBody
    AjaxResult updateFunctionInfo(TmFunctionPO function) throws JsonException
    {
        try
        {
            return functionManagerService.updateFunctionInfo(function, getLoginUser());
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new JsonException(e.getMessage(), e);
        }
    }

    /**
     *  删除应用系统信息
     * @param functionId
     * @return
     * @throws JsonException
     */
    @RequestMapping(value = "/deleteFunctionInfo")
    public
    @ResponseBody
    AjaxResult deleteFunctionInfo(Integer functionId) throws JsonException
    {
        try
        {
            return functionManagerService.deleteFunctionInfo(functionId, getLoginUser());
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new JsonException(e.getMessage(), e);
        }
    }
}
