package com.sandrew.boot.controller.usermanager;


import com.sandrew.boot.core.bean.AclUserBean;
import com.sandrew.boot.core.bean.BaseCondition;
import com.sandrew.boot.core.common.AjaxResult;
import com.sandrew.boot.core.common.Constants;
import com.sandrew.boot.core.common.JsonResult;
import com.sandrew.boot.core.controller.BaseController;
import com.sandrew.boot.core.exception.ActionException;
import com.sandrew.boot.core.exception.JsonException;
import com.sandrew.boot.core.page.PageResult;
import com.sandrew.boot.model.TmRolePO;
import com.sandrew.boot.model.TmUserPO;
import com.sandrew.boot.service.usermanager.UserManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/usermanager")
@SessionAttributes(value = {Constants.CONDITION}, types = {BaseCondition.class})
public class UserManagerController extends BaseController
{
    @Resource
    private UserManagerService userManagerService;

    /**
     * 用户信息查询所有
     *
     * @param condition
     * @param curPage
     * @return
     */
    @RequestMapping(value = "/userManagerPageQuery")
    public
    @ResponseBody
    PageResult<TmUserPO> userManagerPageQuery(TmUserPO condition, int curPage) throws JsonException
    {
        try
        {
            return userManagerService.userManagerPageQuery(condition, curPage);
        }
        catch (Exception e)
        {
            throw new JsonException(e.getMessage(), e);
        }

    }

    /**
     *  根据ID获取用户信息
     * @param userId
     * @return
     * @throws JsonException
     */
    @RequestMapping("getUserInfoById")
    public @ResponseBody JsonResult getUserInfoById(Integer userId) throws JsonException
    {
        try
        {
            JsonResult result = new JsonResult();
            TmUserPO user = userManagerService.findByUserId(userId);
            return result.requestSuccess(user);
        }
        catch (Exception e)
        {
            log.error(e.getMessage(), e);
            throw new JsonException("获取用户信息失败", e);
        }
    }

    /**
     * 用户信息保存
     *
     * @param user
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/createUserInfo")
    public
    @ResponseBody
    JsonResult createUserInfo(TmUserPO user) throws JsonException
    {
        try
        {
            return userManagerService.createUserInfo(user, null, getLoginUser());
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new JsonException(e.getMessage(), e);
        }
    }

    /**
     * 用户信息编辑
     *
     * @param user
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/updateUserInfo")
    public
    @ResponseBody
    AjaxResult updateUserInfo(TmUserPO user) throws JsonException
    {
        try
        {
            return userManagerService.updateUserInfo(user, null, getLoginUser());
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new JsonException(e.getMessage(), e);
        }
    }

    /**
     * Function    : 删除用户
     * LastUpdate  : 2016年4月16日
     *
     * @param userId
     * @return
     * @throws ActionException
     */
    @RequestMapping(value = "/deleteUserInfo")
    public
    @ResponseBody
    JsonResult deleteUserInfo(Integer userId) throws JsonException
    {
        try
        {
            return userManagerService.deleteUserInfo(userId, getLoginUser());
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new JsonException(e.getMessage(), e);
        }
    }

    /**
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/updateProfile")
    public
    @ResponseBody
    AjaxResult updateProfile(TmUserPO user, @RequestParam(value = "file", required = false) MultipartFile file) throws JsonException
    {
        try
        {
            if (file == null && user.getAvatar() == null && "".equals(user.getAvatar()))
            {
                //如果页面没有照片信息，清空照片
                userManagerService.updateClearAvatar(user.getUserId(), getLoginUser());
            }
            else
            {
                if (file != null)
                {
                    // 上传文件到文件服务器
                    // AbstractManager manager = new FTPManager();
                    // FileServer fileserver = new FileServer(manager);
                    // String filePath = fileserver.upload(file.getOriginalFilename(), ((FileInputStream) file.getInputStream()));
                    // user.setAvatar(filePath);
                }
            }
            return userManagerService.updateUserInfo(user, file, getLoginUser());
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new JsonException(e.getMessage(), e);
        }
    }

    /**
     * @param userId
     * @return
     * @throws JsonException
     */
    @RequestMapping(value = "/queryRelationRoles")
    public
    @ResponseBody
    List<TmRolePO> queryRelationRoles(Integer userId) throws JsonException
    {
        try
        {
            return userManagerService.getRelationRolesByUserId(userId);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new JsonException(e.getMessage(), e);
        }
    }


    @RequestMapping(value = "/deleteRoleRelation")
    public
    @ResponseBody
    AjaxResult deleteRoleRelation(Integer userId, Integer roleId) throws JsonException
    {
        try
        {
            return userManagerService.deleteRoleRelation(userId, roleId);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new JsonException(e.getMessage(), e);
        }
    }

    /**
     * Function    : 查询该userId全部未关联角色
     * LastUpdate  : 2016年9月22日
     *
     * @param userId
     * @param roleName
     * @return
     * @throws JsonException
     */
    @RequestMapping(value = "/queryUnRelationRoles")
    public
    @ResponseBody
    List<TmRolePO> queryUnRelationRoles(Integer userId, String roleName) throws JsonException
    {
        try
        {
            AclUserBean aclUser = new AclUserBean();
            aclUser.setUserId(userId);
            aclUser.setRoleName(roleName);
            return userManagerService.getUnRelationRoles(aclUser);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new JsonException(e.getMessage(), e);
        }
    }

    /**
     * Function    : 创建用户与角色关系
     * LastUpdate  : 2016年9月22日
     *
     * @param userId
     * @param rolesStr
     * @return
     * @throws JsonException
     */
    @RequestMapping(value = "/createRelation")
    public
    @ResponseBody
    AjaxResult createRelation(Integer userId, String rolesStr) throws JsonException
    {
        try
        {
            return userManagerService.createRelation(userId, rolesStr, getLoginUser());
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new JsonException(e.getMessage(), e);
        }
    }


    /**
     * 查看头像
     *
     * @param avatarPath
     * @param response
     * @throws ActionException
     */
    @RequestMapping(value = "/showAvatar", method = RequestMethod.GET)
    public void showAvatar(String avatarPath, HttpServletResponse response) throws ActionException
    {
        OutputStream outputStream = null;
        try
        {
            // 文件服务器下载附件
            //			AbstractManager manager = new FTPManager();
            //			FileServer fileserver = new FileServer(manager);
            //			byte[] bytes = fileserver.download(avatarPath);
            //			outputStream = response.getOutputStream();
            //			response.setContentType("application/octet-stream;charset=UTF-8");
            //			FileCopyUtils.copy(bytes, outputStream);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new ActionException("查看头像失败", e);
        }
    }
}
