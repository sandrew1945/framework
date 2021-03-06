/**********************************************************************
* <pre>
* FILE : RoleManagerServiceImpl.java
* CLASS : RoleManagerServiceImpl
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
* $Id: RoleManagerServiceImpl.java,v 0.1 2016年5月30日 上午10:58:34 liutt Exp $
*/

package com.sandrew.boot.service.rolemanager.impl;


import com.sandrew.boot.bean.RoleBean;
import com.sandrew.boot.bean.RoleFunctionBean;
import com.sandrew.boot.core.bean.AclUserBean;
import com.sandrew.boot.core.common.AjaxResult;
import com.sandrew.boot.core.common.Constants;
import com.sandrew.boot.core.exception.ServiceException;
import com.sandrew.boot.core.page.PageQueryBuilder;
import com.sandrew.boot.core.page.PageResult;
import com.sandrew.boot.mapper.TmRolePOMapper;
import com.sandrew.boot.mapper.TrRoleFuncPOMapper;
import com.sandrew.boot.mapper.rolemanager.RoleManagerMapper;
import com.sandrew.boot.model.*;
import com.sandrew.boot.service.rolemanager.RoleManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


/**
 * Function    : 
 * @author     : liutt
 * CreateDate  : 2016年5月30日
 * @version    :
 */
@Service
@Slf4j
public class RoleManagerServiceImpl implements RoleManagerService
{

	@Resource
	private RoleManagerMapper roleManagerMapper;

	@Resource
	private TmRolePOMapper tmRoleMapper;

	@Resource
	private TrRoleFuncPOMapper trRoleFuncPOMapper;

	@Override
	public List<TmRolePO> getRoleList() throws ServiceException
	{
		try
		{
			TmRolePOExample example = new TmRolePOExample();
			TmRolePOExample.Criteria criteria = example.createCriteria();
			List<TmRolePO> roleList = tmRoleMapper.selectByExample(example);
			log.debug("roleList : " + roleList);
			return roleList;
		}
		catch (Exception e)
		{
			log.error(e.getMessage(), e);
			throw new ServiceException("获取角色列表失败", e);
		}

	}

	/**
	 * Function    : 分页查询角色列表
	 * LastUpdate  : 2016年5月26日
	 * @author     ：liutt
	 * @param condition 查询条件
	 * @param curPage 分页信息
	 */
	@Override
	public PageResult<RoleBean> roleManagerPageQuery(TmRolePO condition, int curPage) throws ServiceException
	{
		try
		{
			return PageQueryBuilder.pageQuery(roleManagerMapper, "roleManagerPageQuery", condition, curPage);
		}
		catch (Exception e)
		{
			log.error(e.getMessage(), e);
			throw new ServiceException("角色列表查询失败", e);
		}
	}

	/**
	 * Function    : 创建角色
	 * LastUpdate  : 2016年5月30日
	 * @author     ：liutt
	 * @param role 角色
	 * @param aclUser 登录用户
	 */
	@Override
	public AjaxResult createRole(TmRolePO role, AclUserBean aclUser) throws ServiceException
	{
		AjaxResult result = new AjaxResult();
		try
		{
			boolean isExits = false;
			// 验证用户代码是否存在
			TmRolePOExample example = new TmRolePOExample();
			TmRolePOExample.Criteria criteria = example.createCriteria();
			criteria.andRoleCodeEqualTo(role.getRoleCode()).andIsDeleteEqualTo(Constants.IF_TYPE_NO);
			List<TmRolePO> list = tmRoleMapper.selectByExample(example);
			isExits = (null != list && list.size() > 0) ? true : false;
			if (!isExits)
			{
				role.setIsDelete(Constants.IF_TYPE_NO);
				role.setCreateBy(aclUser.getUserId());
				role.setCreateDate(new Date());
				tmRoleMapper.insertSelective(role);
				result.requestSuccess();
			}
			else
			{
				result.requestFailure("角色已经存在");
			}
			return result;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			log.error(e.getMessage(), e);
			throw new ServiceException("创建角色失败", e);
		}
	}

	/**
	 * Function    :根据角色id查询角色信息
	 * LastUpdate  : 2016年5月31日
	 * @author     ：liutt
	 * @param roleId 角色id
	 * @return
	 * @throws ServiceException
	 */
	@Override
	public TmRolePO findByroleId(Integer roleId) throws ServiceException
	{

		TmRolePO tmRolePO = tmRoleMapper.selectByPrimaryKey(roleId);
		return tmRolePO;
	}

	/**
	 * Function    :修改编辑角色信息
	 * LastUpdate  : 2016年5月31日
	 * @author     ：liutt
	 * @param role
	 * @param aclUser
	 * @return
	 * @throws ServiceException
	 */
	@Override
	public AjaxResult updateRole(TmRolePO role, AclUserBean aclUser) throws ServiceException
	{
		AjaxResult result = new AjaxResult();
		try
		{
			role.setUpdateDate(new Date());
			role.setUpdateBy(aclUser.getUserId());
			tmRoleMapper.updateByPrimaryKeySelective(role);
			result.requestSuccess();
			return result;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			log.error(e.getMessage(), e);
			throw new ServiceException("编辑角色失败", e);
		}

	}

	/**
	 * Function    : 删除角色
	 * LastUpdate  : 2016年5月31日
	 * @author     ：
	 * @param roleId 角色id
	 * @return
	 * @throws ServiceException
	 */
	@Override
	public AjaxResult deleteRole(Integer roleId, AclUserBean aclUser) throws ServiceException
	{
		try
		{
			AjaxResult result = new AjaxResult();
			List<TrUserRolePO> trUserRolePOs = roleManagerMapper.userRoleByRoleId(roleId);
			List<TmFunctionPO> tmFunctionPOs = roleManagerMapper.roleFuncByRoleId(roleId);

			if (trUserRolePOs.size() > 0 || tmFunctionPOs.size() > 0)
			{
				result.requestFailure("删除角色失败,请先解除关联关系");
				return result;
			}
			//int count = tmRoleMapper.deleteByPrimaryKey(roleId);
			TmRolePO value = new TmRolePO();
			value.setRoleId(roleId);
			value.setIsDelete(Constants.IF_TYPE_YES);
			value.setUpdateBy(aclUser.getUserId());
			value.setUpdateDate(new Date());
			int count = tmRoleMapper.updateByPrimaryKeySelective(value);

			if (count > 0)
			{
				result.requestSuccess();
			}
			else
			{
				result.requestFailure("删除角色失败");
			}
			return result;
		}
		catch (Exception e)
		{
			log.error(e.getMessage(), e);
			throw new ServiceException("删除角色失败", e);
		}
	}

	@Override
	public List<TmFunctionPO> queryRelationFunc(Integer roleId) throws ServiceException
	{
		try
		{
			return roleManagerMapper.roleFuncByRoleId(roleId);
		}
		catch (Exception e)
		{
			throw new ServiceException("查询功能失败", e);
		}
		
	}

	@Override
	public AjaxResult deleteRelationFunc(Integer roleId, Integer functionId) throws ServiceException
	{
		try
		{
			AjaxResult ajaxResult = new AjaxResult();
			TrRoleFuncPOExample example = new TrRoleFuncPOExample();
			TrRoleFuncPOExample.Criteria criteria = example.createCriteria();
			criteria.andRoleIdEqualTo(roleId);
			criteria.andFunctionIdEqualTo(functionId);
			int count = trRoleFuncPOMapper.deleteByExample(example);
			if(count > 0)
			{
				return ajaxResult.requestSuccess();
			}
			return ajaxResult.requestFailure("删除功能失败");
		}
		catch (Exception e)
		{
			log.error(e.getMessage(), e);
			throw new ServiceException("查询功能失败", e);
		}
		
	}

	@Override
	public List<TmFunctionPO> queryUnRelationFunc(Integer roleId, String functionName) throws ServiceException
	{
		try
		{
			RoleFunctionBean roleFunction = new RoleFunctionBean();
			roleFunction.setRoleId(roleId);
			roleFunction.setFunctionName(functionName);
			return roleManagerMapper.getFuncExistOwn(roleFunction);
		}
		catch (Exception e)
		{
			throw new ServiceException("查询功能失败", e);
		}
		
	}

	@Override
	public AjaxResult createRelation(Integer roleId, String funcsStr, AclUserBean loginUser) throws ServiceException
	{
		try
		{
			String[] funcs = funcsStr.split(",");
			for (String functionId : funcs)
			{
				TrRoleFuncPO roleFunc = new TrRoleFuncPO();
				roleFunc.setFunctionId(new Integer(functionId));
				roleFunc.setRoleId(roleId);
				roleFunc.setCreateBy(loginUser.getUserId());
				roleFunc.setCreateDate(new Date());
				trRoleFuncPOMapper.insertSelective(roleFunc);
			}
			AjaxResult ajaxResult = new AjaxResult();
			return ajaxResult.requestSuccess();
		}
		catch (Exception e)
		{
			log.error(e.getMessage(), e);
			throw new ServiceException("添加功能失败", e);
		}
	}
	
	

}
