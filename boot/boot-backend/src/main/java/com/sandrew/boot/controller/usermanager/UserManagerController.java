package com.sandrew.boot.controller.usermanager;


import com.sandrew.boot.core.bean.AclUserBean;
import com.sandrew.boot.core.bean.BaseCondition;
import com.sandrew.boot.core.common.AjaxResult;
import com.sandrew.boot.core.common.Constants;
import com.sandrew.boot.core.common.JsonResult;
import com.sandrew.boot.core.controller.BaseController;
import com.sandrew.boot.core.exception.JsonException;
import com.sandrew.boot.core.page.PageResult;
import com.sandrew.boot.model.TmUserPO;
import com.sandrew.boot.service.usermanager.UserManagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@Controller
@Api(tags = "用户管理相关接口", description = "提供用户管理相关的 API")
@RequestMapping("/usermanager")
@SessionAttributes(value = {Constants.CONDITION}, types = {BaseCondition.class})
public class UserManagerController extends BaseController
{
    @Resource
    private UserManagerService userManagerService;

    @ApiOperation("用户查询（分页）")
    @PostMapping(value = "/userManagerPageQuery")
    public
    @ResponseBody
    PageResult<TmUserPO> userManagerPageQuery(@RequestParam(required = false) String userCode, @RequestParam(required = false) String userName, @RequestParam(required = false) Integer userStatus, int limit, int curPage) throws JsonException
    {
        try
        {
            TmUserPO condition = new TmUserPO();
            condition.setUserCode(userCode);
            condition.setUserName(userName);
            condition.setUserStatus(userStatus);
            return userManagerService.userManagerPageQuery(condition, curPage);
        }
        catch (Exception e)
        {
            throw new JsonException(e.getMessage(), e);
        }

    }


    @ApiOperation("根据ID获取用户信息")
    @GetMapping("getUserInfoById")
    public @ResponseBody JsonResult getUserInfoById(Integer userId) throws JsonException
    {
        try
        {
            JsonResult result = new JsonResult();
            TmUserPO user = userManagerService.findByUserId(userId);
            return result.requestSuccess(user);
        }
        catch (Exception e)
        {
            log.error(e.getMessage(), e);
            throw new JsonException("获取用户信息失败", e);
        }
    }


    @ApiOperation("创建用户信息")
    @PostMapping(value = "/createUserInfo")
    public
    @ResponseBody
    JsonResult createUserInfo(TmUserPO user) throws JsonException
    {
        try
        {
            return userManagerService.createUserInfo(user, null, getLoginUser());
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new JsonException(e.getMessage(), e);
        }
    }


    @ApiOperation("用户信息编辑")
    @PostMapping(value = "/updateUserInfo")
    public
    @ResponseBody
    AjaxResult updateUserInfo(TmUserPO user) throws JsonException
    {
        try
        {
            return userManagerService.updateUserInfo(user, null, getLoginUser());
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new JsonException(e.getMessage(), e);
        }
    }

    @ApiOperation("删除用户")
    @PostMapping(value = "/deleteUserInfo")
    public
    @ResponseBody
    JsonResult deleteUserInfo(Integer userId) throws JsonException
    {
        try
        {
            return userManagerService.deleteUserInfo(userId, getLoginUser());
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new JsonException(e.getMessage(), e);
        }
    }

    @ApiOperation("根据用户ID查询用户的角色")
    @GetMapping(value = "/queryRelationRoles")
    public
    @ResponseBody
    JsonResult queryRelationRoles(Integer userId) throws JsonException
    {
        JsonResult result = new JsonResult();
        try
        {
            return result.requestSuccess(userManagerService.getRelationRolesByUserId(userId));
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new JsonException(e.getMessage(), e);
        }
    }


    @ApiOperation("删除该用户的指定角色")
    @PostMapping(value = "/deleteRoleRelation")
    public
    @ResponseBody
    JsonResult deleteRoleRelation(Integer userId, Integer roleId) throws JsonException
    {
        try
        {
            return userManagerService.deleteRoleRelation(userId, roleId);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new JsonException(e.getMessage(), e);
        }
    }

    @ApiOperation("查询该用户全部未关联角色")
    @GetMapping(value = "/queryUnRelationRoles")
    public
    @ResponseBody
    JsonResult queryUnRelationRoles(Integer userId, @ApiParam(name = "roleName", value = "过滤条件") String roleName) throws JsonException
    {
        JsonResult result = new JsonResult();
        try
        {
            AclUserBean aclUser = new AclUserBean();
            aclUser.setUserId(userId);
            aclUser.setRoleName(roleName);
            return result.requestSuccess(userManagerService.getUnRelationRoles(aclUser));
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new JsonException(e.getMessage(), e);
        }
    }


    @ApiOperation("为用户增加指定角色")
    @PostMapping(value = "/createRelation")
    public
    @ResponseBody
    AjaxResult createRelation(Integer userId, @ApiParam(name="rolesStr", value = "角色ID串，用','分割，如：1,2,5") String rolesStr) throws JsonException
    {
        try
        {
            return userManagerService.createRelation(userId, rolesStr, getLoginUser());
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new JsonException(e.getMessage(), e);
        }
    }
}
