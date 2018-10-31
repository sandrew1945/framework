package com.sandrew.boot.service.rolemanager;


import com.sandrew.boot.bean.RoleBean;
import com.sandrew.boot.core.bean.AclUserBean;
import com.sandrew.boot.core.common.AjaxResult;
import com.sandrew.boot.core.exception.ServiceException;
import com.sandrew.boot.core.page.PageResult;
import com.sandrew.boot.model.TmFunctionPO;
import com.sandrew.boot.model.TmRolePO;

import java.util.List;


/**
 * Function    : 角色管理处理service
 * @author     : liutt
 * CreateDate  : 2016-5-30
 * @version    :
 */
public interface RoleManagerService
{
	/**
	 * 
	 * Function    : 获取全部角色信息
	 * LastUpdate  : 2016年5月27日
	 * @return
	 */
	public List<TmRolePO> getRoleList() throws ServiceException;
	
	/**
	 * Function    : 分页查询角色列表
	 * LastUpdate  : 2016年5月26日
	 * @author     ：liutt
	 * @param condition 查询条件
	 * @param curPage 分页信息
	 */
	public PageResult<RoleBean> roleManagerPageQuery(TmRolePO condition, int curPage) throws ServiceException;
	

	/**
	 * Function    : 创建角色
	 * LastUpdate  : 2016年5月30日
	 * @author     ：liutt
	 * @param role 角色
	 * @param aclUser 登录用户
	 */
	public AjaxResult createRole(TmRolePO role, AclUserBean aclUser) throws ServiceException;
	
	/**
	 * Function    :根据角色id查询角色信息
	 * LastUpdate  : 2016年5月31日
	 * @author     ：liutt
	 * @param roleId 角色id
	 * @return
	 * @throws ServiceException
	 */
	public TmRolePO findByroleId(Integer roleId) throws ServiceException;
	
	/**
	 * Function    :修改编辑角色信息
	 * LastUpdate  : 2016年5月31日
	 * @author     ：liutt
	 * @param role
	 * @param aclUser
	 * @return
	 * @throws ServiceException
	 */
	public AjaxResult updateRole(TmRolePO role, AclUserBean aclUser) throws ServiceException;
	

	/**
	 * Function    : 删除角色
	 * LastUpdate  : 2016年5月31日
	 * @author     ：liutt
	 * @param roleId 角色id
	 * @return
	 * @throws ServiceException
	 */
	public AjaxResult deleteRole(Integer roleId, AclUserBean aclUser) throws ServiceException;

	/**
	 * 
	 * Function    : 查询该角色所有的功能
	 * LastUpdate  : 2016年9月22日
	 * @param roleId
	 * @return
	 * @throws ServiceException
	 */
	public List<TmFunctionPO> queryRelationFunc(Integer roleId) throws ServiceException;
	
	/**
	 * 
	 * Function    : 删除该角色下功能
	 * LastUpdate  : 2016年9月22日
	 * @param roleId
	 * @param functionId
	 * @return
	 * @throws ServiceException
	 */
	public AjaxResult deleteRelationFunc(Integer roleId, Integer functionId) throws ServiceException;
	
	/**
	 * 
	 * Function    : 根据角色id查询该角色未分配的功能
	 * LastUpdate  : 2016年9月22日
	 * @param roleId
	 * @param functionName
	 * @return
	 * @throws ServiceException
	 */
	public List<TmFunctionPO> queryUnRelationFunc(Integer roleId, String functionName) throws ServiceException;
	
	/**
	 * 
	 * Function    : 添加功能
	 * LastUpdate  : 2016年9月22日
	 * @param roleId
	 * @param funcsStr
	 * @param loginUser
	 * @return
	 * @throws ServiceException
	 */
	public AjaxResult createRelation(Integer roleId, String funcsStr, AclUserBean loginUser) throws ServiceException;
}
