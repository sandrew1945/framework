package com.sandrew.bootcas.mapper.rolemanager;


import com.sandrew.bootcas.bean.RoleBean;
import com.sandrew.bootcas.bean.RoleFunctionBean;
import com.sandrew.bootcas.model.TmFunctionPO;
import com.sandrew.bootcas.model.TrUserRolePO;
import com.sandrew.bootcas.core.page.Pager;

import java.util.List;


/**
 * 角色管理mapper
 * @author liutingting
 *
 */
public interface RoleManagerMapper
{
	public List<RoleBean> roleManagerPageQuery(Pager pager);
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
	 * @param roleFunction
	 * @return
	 */
	public List<TmFunctionPO> getFuncExistOwn(RoleFunctionBean roleFunction);
}