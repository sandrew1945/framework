/**********************************************************************
* <pre>
* FILE : RegisterServiceImpl.java
* CLASS : RegisterServiceImpl
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
* 		  |2016年9月20日| SuMMeR| Created |
* DESCRIPTION:
* </pre>
***********************************************************************/
/**
* $Id: RegisterServiceImpl.java,v 0.1 2016年9月20日 上午11:25:56 SuMMeR Exp $
*/

package com.sandrew.mvc.service.register.impl;

import com.sandrew.mvc.core.common.Constants;
import com.sandrew.mvc.core.exception.ServiceException;
import com.sandrew.mvc.mapper.TmUserPOMapper;
import com.sandrew.mvc.model.TmUserPO;
import com.sandrew.mvc.model.TmUserPOExample;
import com.sandrew.mvc.service.register.RegisterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;



/**
 * Function    : 
 * @author     : SuMMeR
 * CreateDate  : 2016年9月20日
 * @version    :
 */
@Service
public class RegisterServiceImpl implements RegisterService
{
	@Resource
	private TmUserPOMapper tmUserPOMapper;

	
	
	/* (non-Javadoc)
	 * @see com.hexnology.stes.service.register.RegisterService#register()
	 */
	@Override
	public void createCompanyUser(String userCode, String password, String companyName, Integer region) throws ServiceException
	{
		// 注册用户全部为企业用户，默认用户类型为企业用户，并自动关联类型为企业角色的角色
		// 注册后自动生成一条企业信息，只保存ID和企业名称
		try
		{
			// 插入用户数据
			TmUserPO user = new TmUserPO();
			user.setUserCode(userCode);
			user.setUserName(userCode);
			user.setPassword(password);
			user.setUserStatus(Constants.STATUS_ENABLE);
			user.setIsDelete(Constants.IF_TYPE_NO);
			user.setCreateDate(new Date());
			tmUserPOMapper.insertSelective(user);
		}
		catch (Exception e)
		{
			throw new ServiceException("注册用户失败", e);
		}
	}

	@Override
	public String validateUser(String userCode) throws ServiceException
	{
		try
		{
			TmUserPOExample cond = new TmUserPOExample();
			TmUserPOExample.Criteria criteria = cond.createCriteria();
			criteria.andUserCodeEqualTo(userCode);
			criteria.andIsDeleteEqualTo(Constants.IF_TYPE_NO);
			List<TmUserPO> users = tmUserPOMapper.selectByExample(cond);
			if(null != users && users.size() > 0)
			{
				return "false";
			}
			return "true";
		}
		catch (Exception e)
		{
			throw new ServiceException("验证用户失败", e);
		}

	}
	
	

}