/**
 * Copyright (C), 2015-2022, 东北证券股份有限公司
 * FileName: OAuth2AuthorizationGrantRequestEntityUtils
 * Author:   summer
 * Date:     2022/9/15 10:09
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 **/

package com.sandrew.bootsec.config.security.oauth;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;

import java.util.Collections;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @ClassName OAuth2AuthorizationGrantRequestEntityUtils
 * @Description
 * @Author summer
 * @Date 2022/9/15 10:09
 **/
public class OAuth2AuthorizationGrantRequestEntityUtils
{
    private static HttpHeaders DEFAULT_TOKEN_REQUEST_HEADERS = getDefaultTokenRequestHeaders();

    static HttpHeaders getTokenRequestHeaders(ClientRegistration clientRegistration) {
        HttpHeaders headers = new HttpHeaders();
        headers.addAll(DEFAULT_TOKEN_REQUEST_HEADERS);
        if (ClientAuthenticationMethod.BASIC.equals(clientRegistration.getClientAuthenticationMethod())) {
            headers.setBasicAuth(clientRegistration.getClientId(), clientRegistration.getClientSecret());
        }
        return headers;
    }

    private static HttpHeaders getDefaultTokenRequestHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON_UTF8));
        final MediaType contentType = MediaType.valueOf(APPLICATION_JSON_VALUE + ";charset=UTF-8");
        headers.setContentType(contentType);
        return headers;
    }
}
