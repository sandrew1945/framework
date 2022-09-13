/**
 * Copyright (C), 2015-2022, 东北证券股份有限公司
 * FileName: DBUserDetailsService
 * Author:   summer
 * Date:     2022/8/30 15:18
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 **/

package com.sandrew.bootsec.service.security;

import com.sandrew.bootsec.core.exception.ServiceException;
import com.sandrew.bootsec.core.security.MyUser;
import com.sandrew.bootsec.model.TmRolePO;
import com.sandrew.bootsec.model.TmUserPO;
import com.sandrew.bootsec.service.UserManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName DBUserDetailsService
 * @Description
 * @Author summer
 * @Date 2022/8/30 15:18
 **/
@Service("userDetailsService")
@Slf4j
public class DBUserDetailsService implements UserDetailsService
{

    @Resource
    private UserManagerService userManagerService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        try
        {
            TmUserPO userFromDb = userManagerService.getUserByCode(username);
            if (null == userFromDb)
            {
                throw new UsernameNotFoundException("User [" + username + "] is not exist");
            }
            List<TmRolePO> roleList = userManagerService.getRelationRolesByUserId(userFromDb.getUserId());
            String roles = roleList.stream().map(tmRolePO -> tmRolePO.getRoleCode()).collect(Collectors.joining(","));
            List<GrantedAuthority> grantedAuthorityList = AuthorityUtils.commaSeparatedStringToAuthorityList(roles);

            MyUser user = new MyUser(userFromDb.getUserCode(), userFromDb.getPassword(), grantedAuthorityList);
            user.setUserId(userFromDb.getUserId());
            user.setFullName(userFromDb.getUserName());
            user.setSex(userFromDb.getSex());
            user.setUserType(userFromDb.getUserType());
            user.setPhone(userFromDb.getPhone());
            user.setMobile(userFromDb.getMobile());
            user.setEmail(userFromDb.getEmail());
            user.setAvatarPath(userFromDb.getAvatar());
            return user;
        }
        catch (ServiceException e)
        {
            log.error(e.getMessage(), e);
            throw new UsernameNotFoundException("获取用户信息失败", e);
        }
    }

}
