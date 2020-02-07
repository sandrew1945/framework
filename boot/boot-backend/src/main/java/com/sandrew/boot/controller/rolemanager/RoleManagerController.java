/**********************************************************************
* <pre>
* FILE : RoleManagerController.java
* CLASS : RoleManagerController
*
* AUTHOR : Liutt
*
* FUNCTION : TODO
*
*
*======================================================================
* CHANGE HISTORY LOG
*----------------------------------------------------------------------
* MOD. NO.| DATE | NAME | REASON | CHANGE REQ.
*----------------------------------------------------------------------
* 		  |2016年5月30日| Liutt| Created |
* DESCRIPTION:
* </pre>
***********************************************************************/
/**
* $Id: RoleManagerController.java,v 0.1 2016年5月30日 上午10:58:34 liutt Exp $
*/
package com.sandrew.boot.controller.rolemanager;


import com.sandrew.boot.bean.PermissionParam;
import com.sandrew.boot.bean.RoleBean;
import com.sandrew.boot.core.bean.BaseCondition;
import com.sandrew.boot.core.common.AjaxResult;
import com.sandrew.boot.core.common.Constants;
import com.sandrew.boot.core.common.JsonResult;
import com.sandrew.boot.core.controller.BaseController;
import com.sandrew.boot.core.exception.JsonException;
import com.sandrew.boot.core.exception.ServiceException;
import com.sandrew.boot.core.page.PageResult;
import com.sandrew.boot.model.TmRolePO;
import com.sandrew.boot.service.rolemanager.RoleManagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * Function    : 
 * @author     : liutt
 * CreateDate  : 2016年5月30日
 * @version    :
 */
@Slf4j
@Api(tags = "角色管理相关接口", description = "提供角色管理相关的 API")
@Controller
@RequestMapping("/rolemanager")
@SessionAttributes(value = { Constants.CONDITION }, types = { BaseCondition.class })
public class RoleManagerController extends BaseController
{
	@Resource
	private RoleManagerService roleManagerService;//角色处理的service


	@ApiOperation("角色查询（分页）")
	@PostMapping(value = "/roleManagerPageQuery")
	public @ResponseBody
	PageResult<RoleBean> userManagerPageQuery(@RequestParam(required = false) String roleCode, @RequestParam(required = false) String roleName, @RequestParam(required = false) Integer roleStatus, int curPage) throws JsonException
	{
		try
		{
			TmRolePO condition = new TmRolePO();
			condition.setRoleCode(roleCode);
			condition.setRoleName(roleName);
			condition.setRoleStatus(roleStatus);
			return roleManagerService.roleManagerPageQuery(condition, curPage);
		}
		catch (Exception e)
		{
			throw new JsonException(e.getMessage(), e);
		}

	}

	@ApiOperation("根据ID查询角色信息")
	@GetMapping("getRoleInfoById")
	public @ResponseBody JsonResult getRoleInfoById(Integer roleId) throws JsonException
	{
		JsonResult result = new JsonResult();
		try
		{
			TmRolePO role = roleManagerService.findByroleId(roleId);
			return result.requestSuccess(role);
		}
		catch (ServiceException e)
		{
			log.error(e.getMessage(), e);
			throw new JsonException("查询角色失败", e);
		}
	}

	@ApiOperation("创建角色信息")
	@PostMapping(value = "/createRole")
	public @ResponseBody
	AjaxResult createRole(TmRolePO user) throws JsonException
	{
		try
		{
			return roleManagerService.createRole(user, getLoginUser());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new JsonException(e.getMessage(), e);
		}
	}

	@ApiOperation("编辑角色信息")
	@PostMapping(value = "/updateRole")
	public @ResponseBody
	AjaxResult updateRole(TmRolePO role) throws JsonException
	{
		try
		{
			return roleManagerService.updateRole(role, getLoginUser());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new JsonException(e.getMessage(), e);
		}
	}

	@ApiOperation("删除角色")
	@PostMapping(value = "/deleteRole")
	public @ResponseBody
	JsonResult deleteRole(Integer roleId) throws JsonException
	{
		JsonResult result = new JsonResult();
		try
		{
			//删除角色的时候 需要判断 该角色是否分配给其他人 如果未分配咋可以删除 如果已分配 则不可以删除
			return roleManagerService.deleteRole(roleId, getLoginUser());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new JsonException(e.getMessage(), e);
		}
	}

	@ApiOperation("保存该角色的菜单权限")
	@PostMapping("savePermission")
	public @ResponseBody JsonResult savePermission(@ApiParam("请求数据,包括角色ID和选中的菜单节点") @RequestBody PermissionParam parameter) throws JsonException
	{
		try
		{
			return roleManagerService.savePermission(parameter.getRoleId(), parameter.getNode(), getLoginUser());
		}
		catch (Exception e)
		{
			log.error(e.getMessage(), e);
			throw new JsonException("保存权限失败", e);
		}
	}

	@ApiOperation("获取已选菜单")
	@GetMapping("getCheckedPremission")
	public @ResponseBody JsonResult getCheckedPremission(Integer roleId) throws JsonException
	{
		try
		{
			return roleManagerService.getCheckPermission(roleId);
		}
		catch (Exception e)
		{
			log.error(e.getMessage(), e);
			throw new JsonException("保存权限失败", e);
		}
	}
}
