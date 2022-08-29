package com.sandrew.bootcas.shiro;

import org.apache.shiro.cas.CasRealm;

/**
 *
 */
public class MyCasRealm extends CasRealm
{

    /*
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals)
    {
//        String username = (String) principals.getPrimaryPrincipal();

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        authorizationInfo.setRoles(userService.findRoles(username));
//        authorizationInfo.setStringPermissions(userService.findPermissions(username));

        return authorizationInfo;
    }

    */
}
