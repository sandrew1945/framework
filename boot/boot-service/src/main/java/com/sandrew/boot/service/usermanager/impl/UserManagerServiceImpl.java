/**
 * <pre>
 * FILE : LoginService.java
 * CLASS : LoginService
 *
 * AUTHOR : SuMMeR
 *
 * FUNCTION : TODO
 *
 *
 * ======================================================================
 * CHANGE HISTORY LOG
 * ----------------------------------------------------------------------
 * MOD. NO.| DATE | NAME | REASON | CHANGE REQ.
 * ----------------------------------------------------------------------
 * 		  |2014年5月3日| SuMMeR| Created |
 * DESCRIPTION:
 * </pre>
 * <p>
 * $Id: LoginService.java,v 0.1 2014年5月3日 上午10:58:34 SuMMeR Exp $
 */
/**
 * $Id: LoginService.java,v 0.1 2014年5月3日 上午10:58:34 SuMMeR Exp $
 */

package com.sandrew.boot.service.usermanager.impl;


import com.sandrew.boot.core.bean.AclUserBean;
import com.sandrew.boot.core.common.AjaxResult;
import com.sandrew.boot.core.common.Constants;
import com.sandrew.boot.core.common.JsonResult;
import com.sandrew.boot.core.common.MD5Encrypt;
import com.sandrew.boot.core.exception.ServiceException;
import com.sandrew.boot.core.exception.TooManyResultsException;
import com.sandrew.boot.core.page.PageQueryBuilder;
import com.sandrew.boot.core.page.PageResult;
import com.sandrew.boot.mapper.TmUserPOMapper;
import com.sandrew.boot.mapper.TrUserRolePOMapper;
import com.sandrew.boot.mapper.usermanager.UserManagerMapper;
import com.sandrew.boot.model.*;
import com.sandrew.boot.service.usermanager.UserManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
@CacheConfig(cacheNames = "user")
@Slf4j
public class UserManagerServiceImpl implements UserManagerService
{

    @Resource
    private UserManagerMapper userManagerMapper;

    @Resource
    private TmUserPOMapper tmUserMapper;

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
            throw new ServiceException("用户列表查询失败", e);
        }
    }

    @Override
    public JsonResult createUserInfo(TmUserPO user, MultipartFile avatar, AclUserBean aclUser) throws ServiceException
    {
        JsonResult result = new JsonResult();
        try
        {
            boolean isExits = false;
            TmUserPOExample example = new TmUserPOExample();
            TmUserPOExample.Criteria criteria = example.createCriteria();
            criteria.andUserCodeEqualTo(user.getUserCode());
            criteria.andIsDeleteEqualTo(Constants.IF_TYPE_NO);
            List<TmUserPO> list = tmUserMapper.selectByExample(example);
            isExits = (null != list && list.size() > 0) ? true : false;
            if (!isExits)
            {
                user.setIsDelete(Constants.IF_TYPE_NO);
                user.setCreateBy(aclUser.getUserId());
                user.setCreateDate(new Date());
                user.setPassword(MD5Encrypt.MD5Encode(user.getPassword()));
                result.requestSuccess(tmUserMapper.insertSelective(user));
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
            log.error(e.getMessage(), e);
            throw new ServiceException("创建用户失败", e);
        }
    }

    @Override
    @CacheEvict(key = "#userId")
    public JsonResult deleteUserInfo(Integer userId, AclUserBean aclUser) throws ServiceException
    {
        try
        {
            JsonResult result = new JsonResult();
            //int count = tmUserMapper.deleteByPrimaryKey(userId);
            // 将该用户IS_DELETE标记为是
            //			TmUserPO cond = new TmUserPO();
            //			cond.setUserId(userId);
            TmUserPO value = new TmUserPO();
            value.setIsDelete(Constants.IF_TYPE_YES);
            value.setUpdateBy(aclUser.getUserId());
            value.setUpdateDate(new Date());
            //			int count = commonMapper.update(cond, value);
            TmUserPOExample example = new TmUserPOExample();
            TmUserPOExample.Criteria criteria = example.createCriteria();
            criteria.andUserIdEqualTo(userId);
            int count = tmUserMapper.updateByExampleSelective(value, example);

            if (count > 0)
            {
                result.requestSuccess(true);
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
    @Cacheable(key = "#userId")
    public TmUserPO findByUserId(Integer userId) throws ServiceException
    {

        try
        {
            log.debug("缓存中不存在用户信息,读取数据库...");
            TmUserPO tmUserPO = tmUserMapper.selectByPrimaryKey(userId);
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
            TmUserPOExample example = new TmUserPOExample();
            TmUserPOExample.Criteria criteria = example.createCriteria();
            criteria.andUserCodeEqualTo(userCode);
            criteria.andUserStatusEqualTo(Constants.STATUS_ENABLE);
            criteria.andIsDeleteEqualTo(Constants.IF_TYPE_NO);
            List<TmUserPO> users = tmUserMapper.selectByExample(example);
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
    @CacheEvict(key = "#user.userId")
    public AjaxResult updateUserInfo(TmUserPO user, MultipartFile avatar, AclUserBean aclUser) throws ServiceException
    {
        AjaxResult result = new AjaxResult();
        try
        {
            //			TmUserPO tmUserPO = new TmUserPO();
            //			tmUserPO.setUserId(user.getUserId());
            user.setUpdateDate(new Date());
            user.setUpdateBy(aclUser.getUserId());
            //如果用户没有填写密码选项，则密码不改变
            if ("".equals(user.getPassword()))
            {
                user.setPassword(null);
            }
            else
            {
                user.setPassword(MD5Encrypt.MD5Encode(user.getPassword()));
            }
            //			commonMapper.update(tmUserPO, user);
            TmUserPOExample example = new TmUserPOExample();
            TmUserPOExample.Criteria criteria = example.createCriteria();
            criteria.andUserIdEqualTo(user.getUserId());
            tmUserMapper.updateByExampleSelective(user, example);
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
            throw new ServiceException("获取已有角色失败", e);
        }

    }

    @Override
    public AjaxResult deleteRoleRelation(Integer userId, Integer roleId) throws ServiceException
    {
        try
        {
            AjaxResult result = new AjaxResult();

            TrUserRolePO userRole = new TrUserRolePO();
            userRole.setUserId(userId);
            userRole.setRoleId(roleId);
            //			int count = commonMapper.delete(userRole);
            TrUserRolePOExample example = new TrUserRolePOExample();
            TrUserRolePOExample.Criteria criteria = example.createCriteria();
            criteria.andUserIdEqualTo(userId);
            criteria.andRoleIdEqualTo(roleId);
            int count = trUserRolePOMapper.deleteByExample(example);
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
                //				commonMapper.insert(userRole);
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
    public AjaxResult updateClearAvatar(Integer userId, AclUserBean loginUser) throws ServiceException
    {
        try
        {
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("userId", userId);
            paramMap.put("updateBy", loginUser.getUserId());
            paramMap.put("updateDate", new Date());
            int count = userManagerMapper.updateClearAvatar(paramMap);
            AjaxResult ajaxResult = new AjaxResult();
            if (count > 0)
            {
                return ajaxResult.requestSuccess();
            }
            else
            {
                return ajaxResult.requestFailure("用户保存失败");
            }
        }
        catch (Exception e)
        {
            log.error(e.getMessage(), e);
            throw new ServiceException("用户保存失败", e);
        }
    }
}
