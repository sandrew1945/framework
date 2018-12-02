/**********************************************************************
* <pre>
* FILE : LoginService.java
* CLASS : LoginService
*
* AUTHOR : SuMMeR
*
* FUNCTION : TODO
*
*
*======================================================================
* CHANGE HISTORY LOG
*----------------------------------------------------------------------
* MOD. NO.| DATE | NAME | REASON | CHANGE REQ.
*----------------------------------------------------------------------
* 		  |2014年5月3日| SuMMeR| Created |
* DESCRIPTION:
* </pre>
***********************************************************************/
/**
* $Id: LoginService.java,v 0.1 2014年5月3日 上午10:58:34 SuMMeR Exp $
*/

package com.sandrew.mvc.service.usermanager.impl;


import com.sandrew.mvc.bean.AclUserBean;
import com.sandrew.mvc.core.common.AjaxResult;
import com.sandrew.mvc.core.common.Fixcode;
import com.sandrew.mvc.core.exception.ServiceException;
import com.sandrew.mvc.core.exception.TooManyResultsException;
import com.sandrew.mvc.core.page.PageQueryBuilder;
import com.sandrew.mvc.core.page.PageResult;
import com.sandrew.mvc.mapper.TmUserPOMapper;
import com.sandrew.mvc.mapper.TrUserRolePOMapper;
import com.sandrew.mvc.mapper.usermanager.UserManagerMapper;
import com.sandrew.mvc.model.*;
import com.sandrew.mvc.service.usermanager.UserManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Function    : 
 * @author     : SuMMeR
 * CreateDate  : 2014年5月3日
 * @version    :
 */
@Service
@Slf4j
public class UserManagerServiceImpl implements UserManagerService
{

	@Resource
	private UserManagerMapper userManagerMapper;

	@Resource
	private TmUserPOMapper tmUserPOMapper;

	@Resource
	private TrUserRolePOMapper trUserRolePOMapper;

	@Override
	public PageResult<TmUserPO> userManagerPageQuery(TmUserPO condition, int curPage) throws ServiceException
	{
		try
		{
			return PageQueryBuilder.pageQuery(userManagerMapper, "userManagerPageQuery", condition, curPage);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			log.error(e.getMessage(), e);
			throw new ServiceException("用户列表查询失败", e);
		}
	}

	@Override
	public AjaxResult createUserInfo(TmUserPO user, MultipartFile avatar, AclUserBean aclUser) throws ServiceException
	{
		AjaxResult result = new AjaxResult();
		try
		{
			boolean isExits = false;

			// 验证用户代码是否存在
			TmUserPOExample cond = new TmUserPOExample();
			TmUserPOExample.Criteria criteria = cond.createCriteria();
			criteria.andUserCodeEqualTo(user.getUserCode());
			criteria.andIsDeleteEqualTo(Fixcode.IF_TYPE_NO.getFixcode());
			List<TmUserPO> list = tmUserPOMapper.selectByExample(cond);
			isExits = (null != list && list.size() > 0) ? true : false;
			if (!isExits)
			{
				user.setIsDelete(Fixcode.IF_TYPE_NO.getFixcode());
				user.setCreateBy(aclUser.getUserId());
				user.setCreateDate(new Date());
				//user.setPassword(MD5Encrypt.MD5Encode(user.getPassword()));
				// 使用明文密码
				user.setPassword(user.getPassword());
				tmUserPOMapper.insertSelective(user);
				result.requestSuccess();
			}
			else
			{
				result.requestFailure("用户已经存在");
			}
			return result;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new ServiceException("创建用户失败", e);
		}
	}

	@Override
	public AjaxResult deleteUserInfo(Integer userId, AclUserBean aclUser) throws ServiceException
	{
		try
		{
			AjaxResult result = new AjaxResult();
			// 将该用户IS_DELETE标记为是
			TmUserPOExample cond = new TmUserPOExample();
			TmUserPOExample.Criteria criteria = cond.createCriteria();
			criteria.andUserIdEqualTo(userId);

			TmUserPO value = new TmUserPO();
			value.setIsDelete(Fixcode.IF_TYPE_YES.getFixcode());
			value.setUpdateBy(aclUser.getUserId());
			value.setUpdateDate(new Date());

			int count = tmUserPOMapper.updateByExampleSelective(value, cond);
			if (count > 0)
			{
				result.requestSuccess();
			}
			else
			{
				result.requestFailure("删用户失败");
			}
			return result;
		}
		catch (Exception e)
		{
			log.error(e.getMessage(), e);
			throw new ServiceException("删除用户失败", e);
		}
	}

	@Override
	public TmUserPO findByUserId(Integer userId) throws ServiceException
	{

		try
		{
			TmUserPO tmUserPO = tmUserPOMapper.selectByPrimaryKey(userId);
			return tmUserPO;
		}
		catch (Exception e)
		{
			log.error(e.getMessage(), e);
			throw new ServiceException("查询失败", e);
		}
	}

	@Override
	public TmUserPO getUserByCode(String userCode) throws ServiceException
	{
		try
		{

			if (null == userCode || "".equals(userCode))
			{
				return null;
			}
			TmUserPOExample cond = new TmUserPOExample();
			TmUserPOExample.Criteria criteria = cond.createCriteria();
			criteria.andUserCodeEqualTo(userCode);
			criteria.andUserStatusEqualTo(Fixcode.STATUS_ENABLE.getFixcode());
			criteria.andIsDeleteEqualTo(Fixcode.IF_TYPE_NO.getFixcode());
			List<TmUserPO> users = tmUserPOMapper.selectByExample(cond);
			if (null != users && users.size() == 1)
			{
				return users.get(0);
			}
			else
			{
				throw new TooManyResultsException("");
			}
		}
		catch (Exception e)
		{
			log.error(e.getMessage(), e);
			throw new ServiceException(e.getMessage(), e);
		}
	}

	/**
	 * @liutt
	 * 修改编辑用户信息
	 * @param user
	 * @param avatar
	 * @param aclUser
	 * @return
	 * @throws ServiceException
	 */
	@Override
	public AjaxResult updateUserInfo(TmUserPO user, MultipartFile avatar, AclUserBean aclUser) throws ServiceException
	{
		AjaxResult result = new AjaxResult();
		try
		{
			TmUserPOExample cond = new TmUserPOExample();
			TmUserPOExample.Criteria criteria = cond.createCriteria();
			criteria.andUserIdEqualTo(user.getUserId());

			user.setUpdateDate(new Date());
			user.setUpdateBy(aclUser.getUserId());
			//如果用户没有填写密码选项，则密码不改变
			if("".equals(user.getPassword())){
				user.setPassword(null);
			}
			tmUserPOMapper.updateByExampleSelective(user, cond);
			result.requestSuccess();
			return result;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			log.error(e.getMessage(), e);
			throw new ServiceException("编辑用户失败", e);
		}
	}

	@Override
	public List<TmRolePO> getRelationRolesByUserId(Integer userId) throws ServiceException
	{
		try
		{
			return userManagerMapper.queryRelationRole(userId);
		}
		catch (Exception e)
		{
			log.error(e.getMessage(), e);
			throw new ServiceException("获取已有角色失败", e);
		}

	}

	@Override
	public AjaxResult deleteRoleRelation(Integer userId, Integer roleId) throws ServiceException
	{
		try
		{
			AjaxResult result = new AjaxResult();

			TrUserRolePOExample cond = new TrUserRolePOExample();
			TrUserRolePOExample.Criteria criteria = cond.createCriteria();
			criteria.andUserIdEqualTo(userId);
			criteria.andRoleIdEqualTo(roleId);
			int count = trUserRolePOMapper.deleteByExample(cond);
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
	public List<TmRolePO> getUnRelationRoles(AclUserBean aclUser) throws ServiceException
	{
		try
		{
			List<TmRolePO> roles = userManagerMapper.getRoleExistOwn(aclUser);
			return roles;
		}
		catch (Exception e)
		{
			log.error(e.getMessage(), e);
			throw new ServiceException("获取未关联角色失败", e);
		}

	}

	@Override
	public AjaxResult createRelation(Integer userId, String rolesStr, AclUserBean aclUser) throws ServiceException
	{
		try
		{
			String[] roles = rolesStr.split(",");
			for (String roleId : roles)
			{
				TrUserRolePO userRole = new TrUserRolePO();
				userRole.setUserId(userId);
				userRole.setRoleId(new Integer(roleId));
				userRole.setCreateBy(aclUser.getUserId());
				userRole.setCreateDate(new Date());
				trUserRolePOMapper.insertSelective(userRole);
			}
			AjaxResult ajaxResult = new AjaxResult();
			return ajaxResult.requestSuccess();
		}
		catch (Exception e)
		{
			log.error(e.getMessage(), e);
			throw new ServiceException("添加角色失败", e);
		}

	}

	@Override
	public AjaxResult updateClearAvatar(Integer userId, AclUserBean loginUser) throws ServiceException {
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("userId", userId);
			paramMap.put("updateBy", loginUser.getUserId());
			paramMap.put("updateDate", new Date());
			int count = userManagerMapper.updateClearAvatar(paramMap);
			AjaxResult ajaxResult = new AjaxResult();
			if (count > 0) {
				return ajaxResult.requestSuccess();
			} else {
				return ajaxResult.requestFailure("用户保存失败");
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ServiceException("用户保存失败", e);
		}
	}

}
