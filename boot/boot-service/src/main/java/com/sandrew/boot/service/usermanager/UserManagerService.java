package com.sandrew.boot.service.usermanager;


import com.sandrew.boot.core.bean.AclUserBean;
import com.sandrew.boot.core.common.AjaxResult;
import com.sandrew.boot.core.exception.ServiceException;
import com.sandrew.boot.core.page.PageResult;
import com.sandrew.boot.model.TmRolePO;
import com.sandrew.boot.model.TmUserPO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


/**
 * Function    : 
 * @author     : zhao.feng
 * CreateDate  : 2010-11-5
 * @version    :
 */
public interface UserManagerService
{
	/**
	 * 
	 * Function    : 用户管理分页查询
	 * LastUpdate  : 2016年9月22日
	 * @param condition
	 * @param curPage
	 * @return
	 * @throws ServiceException
	 */
	public PageResult<TmUserPO> userManagerPageQuery(TmUserPO condition, int curPage) throws ServiceException;

	/**
	 * 
	 * Function    : 创建用户
	 * LastUpdate  : 2016年9月22日
	 * @param user
	 * @param avatar
	 * @param aclUser
	 * @return
	 * @throws ServiceException
	 */
	public AjaxResult createUserInfo(TmUserPO user, MultipartFile avatar, AclUserBean aclUser) throws ServiceException;
	
	/**
	 * 
	 * Function    : 删除用户信息
	 * LastUpdate  : 2016年9月22日
	 * @param userId
	 * @return
	 * @throws ServiceException
	 */
	public AjaxResult deleteUserInfo(Integer userId, AclUserBean aclUser) throws ServiceException;
	
	/**
	 * 根据用户id查询用户信息
	 * @param userId
	 * @return
	 * @throws ServiceException
	 */
	public TmUserPO findByUserId(Integer userId) throws ServiceException;
	
	/**
	 * 
	 * Function    : 根据用户名获取用户信息
	 * LastUpdate  : 2016年10月25日
	 * @param userCode
	 * @return
	 * @throws ServiceException
	 */
	public TmUserPO getUserByCode(String userCode) throws ServiceException;
	
	/**
	 * 修改编辑用户信息
	 * @param user
	 * @param avatar
	 * @param aclUser
	 * @return
	 * @throws ServiceException
	 */
	public AjaxResult updateUserInfo(TmUserPO user, MultipartFile avatar, AclUserBean aclUser) throws ServiceException;
	
	
	/**
	 * 
	 * Function    : 获取当前用户已经关联的角色
	 * LastUpdate  : 2016年9月22日
	 * @param userId
	 * @return
	 * @throws ServiceException
	 */
	public List<TmRolePO> getRelationRolesByUserId(Integer userId) throws ServiceException;
	
	/**
	 * 
	 * Function    : 删除用户与角色的关联
	 * LastUpdate  : 2016年9月22日
	 * @param userId
	 * @param roleId
	 * @return
	 * @throws ServiceException
	 */
	public AjaxResult deleteRoleRelation(Integer userId, Integer roleId) throws ServiceException;
	
	/**
	 * 
	 * Function    : 获取该用户下全部未关联角色
	 * LastUpdate  : 2016年9月22日
	 * @param aclUser
	 * @return
	 * @throws ServiceException
	 */
	public List<TmRolePO> getUnRelationRoles(AclUserBean aclUser) throws ServiceException;
	
	/**
	 * 
	 * Function    : 批量添加用户与角色关系
	 * LastUpdate  : 2016年9月22日
	 * @param userId
	 * @param rolesStr
	 * @return
	 * @throws ServiceException
	 */
	public AjaxResult createRelation(Integer userId, String rolesStr, AclUserBean aclUser) throws ServiceException;

	/**
	 * 清空用户照片
	 * @param userId
	 * @param loginUser
	 * @return
	 * @throws ServiceException
	 */
	public AjaxResult updateClearAvatar(Integer userId, AclUserBean loginUser) throws ServiceException;
	
}
