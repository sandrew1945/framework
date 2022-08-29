package com.sandrew.bootsec.service;


import com.sandrew.bootsec.bean.RoleTreeNode;
import com.sandrew.bootsec.core.bean.AclUserBean;
import com.sandrew.bootsec.core.common.JsonResult;
import com.sandrew.bootsec.core.exception.ServiceException;
import com.sandrew.bootsec.service.util.MenuNode;

import java.util.List;


/**
 * Function    : 
 * @author     : zhao.feng
 * CreateDate  : 2010-11-5
 * @version    :
 */
public interface LoginService
{

	/**
	 *  登录
	 * @param user
	 * @return
	 * @throws ServiceException
	 */
//	AclUserBean login(TmUserPO user) throws ServiceException;

	/**
	 *  获取用户信息，控制台前端获取用户信息
	 * @return
	 * @throws ServiceException
	 */
	AclUserBean userInfo(AclUserBean loginUser) throws ServiceException;

	/**
	 *  获取用户/经办人信息，经办端APP登录后获取用户信息
	 * @param userId
	 * @return
	 * @throws ServiceException
	 */
	JsonResult getOperatorInfo(Integer userId) throws ServiceException;

	/**
	 *
	 * @param roleId
	 * @return
	 * @throws ServiceException
	 */
	List<MenuNode> getMenuByRole(Integer roleId) throws ServiceException;

	/**
	 *
	 * Function    : 处理用户的角色及Session信息
	 * LastUpdate  : 2017年5月24日
	 * @param userCode
	 * @return
	 * @throws ServiceException
	 */
//	LoginResult postRoleHandler(String userCode) throws ServiceException;

	/**
	 *
	 * Function    : 根据用户ID获取角色选择树
	 * LastUpdate  : 2016年4月16日
	 * @param userId
	 * @return
	 * @throws ServiceException
	 */
	List<RoleTreeNode> choiceRoleTree(Integer userId) throws ServiceException;

	/**
	 *
	 * Function    : 用户选择完角色进入主界面
	 * LastUpdate  : 2016年4月16日
	 * @param roleId
	 * @return
	 * @throws ServiceException
	 */
//	String showIndex(Integer roleId) throws ServiceException;

	/**
	 *  登出
	 * @throws ServiceException
	 */
//	void logout() throws ServiceException;
	
}
