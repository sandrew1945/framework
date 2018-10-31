/**
 * <pre>
 * FILE : DistributedFormAuthenticationFilter.java
 * CLASS : DistributedFormAuthenticationFilter
 *
 * AUTHOR : Administrator
 *
 * FUNCTION : TODO
 *
 *
 * ======================================================================
 * CHANGE HISTORY LOG
 * ----------------------------------------------------------------------
 * MOD. NO.| DATE | NAME | REASON | CHANGE REQ.
 * ----------------------------------------------------------------------
 * 		  |2017年5月8日| Administrator| Created |
 * DESCRIPTION:
 * </pre>
 * <p/>
 * $Id: DistributedFormAuthenticationFilter.java,v 0.1 2017年5月8日 上午9:41:32 Administrator Exp $
 */

package com.sandrew.boot.shiro;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Function    : 
 * @author     : Administrator
 * CreateDate  : 2017年5月8日
 * @version    :
 */
@Log4j2
public class DistributedFormAuthenticationFilter extends FormAuthenticationFilter
{
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception
    {
        // 如果验证码验证失败,跳过验证
        if (request.getAttribute(getFailureKeyAttribute()) != null)
        {
			return true;
        }
        return super.onAccessDenied(request, response);
    }

    @Override
    protected void issueSuccessRedirect(ServletRequest request, ServletResponse response) throws Exception
    {
        // 判断session中是否存在authc.fallbackUrl，如果存在，说明是从其他系统重定向过来的请求，否则是server系统自身登录
        Session session = getSubject(request, response).getSession();
        String fallbackUrl = (String) session.getAttribute("authc.fallbackUrl");
        log.debug("fallbackUrl =============" + fallbackUrl);
        if (StringUtils.isEmpty(fallbackUrl))
        {
            fallbackUrl = getSuccessUrl();
        }
        WebUtils.redirectToSavedRequest(request, response, fallbackUrl);
    }

}