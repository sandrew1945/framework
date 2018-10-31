package com.sandrew.mvc.mapper.rolemanager;

import java.util.List;

import com.sandrew.mvc.bean.RoleFunctionBean;
import com.sandrew.mvc.core.page.Pager;
import com.sandrew.mvc.model.TmFunctionPO;
import com.sandrew.mvc.model.TmRolePO;
import com.sandrew.mvc.model.TrUserRolePO;

/**
 * 角色管理mapper
 * @author liutingting
 *
 */
public interface RoleManagerMapper
{
	public List<TmRolePO> roleManagerPageQuery(Pager pager);
	/**
	 * 
	 * Function    : 根据居然色id查询用户角色关系表
	 * LastUpdate  : 2016年5月31日
	 * @param roleId
	 * @return
	 */
	public List<TrUserRolePO> userRoleByRoleId(Integer roleId);
	/**
	 * 
	 * Function    : 根据角色id查询角色功能关系表
	 * LastUpdate  : 2016年5月31日
	 * @param roleId
	 * @return
	 */
	public List<TmFunctionPO> roleFuncByRoleId(Integer roleId);
	
	/**
	 * 
	 * Function    : 根据角色id查询该角色未分配的功能
	 * LastUpdate  : 2016年9月22日
	 * @param roleId
	 * @param functionName
	 * @return
	 */
	public List<TmFunctionPO> getFuncExistOwn(RoleFunctionBean roleFunction);
}