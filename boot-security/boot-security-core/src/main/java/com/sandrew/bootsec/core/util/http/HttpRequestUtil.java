package com.sandrew.bootsec.core.util.http;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpRequestUtil
{
    public static ESResponse get(String url, boolean ssl)
    {
        return get(url, null, null, ssl);
    }


    public static ESResponse get(String url, Map<String, String> params, boolean ssl)
    {
        return get(url, params, null, ssl);
    }

    public static ESResponse get(String url, Map<String, String> params, Map<String, String> headers, boolean ssl)
    {
        ESResponse httpResponse = null;
        try
        {
            CloseableHttpClient httpclient = null;
            if (ssl)
            {
                httpclient = SSLClient.getSSLClient();
            }
            else
            {
                httpclient = HttpClients.createDefault();
            }
            URIBuilder uriBuilder = new URIBuilder(url);
            // 处理参数
            if (null != params && !params.isEmpty())
            {
                params.entrySet().stream().forEach(param -> {
                    uriBuilder.addParameter(param.getKey(), param.getValue());
                });
            }
            // 创建httpget
            HttpGet httpget = new HttpGet(uriBuilder.build());
            // 处理header
            if (null != headers && !headers.isEmpty())
            {
                headers.entrySet().stream().forEach(header -> {
                    httpget.setHeader(header.getKey(), header.getValue());
                });
            }
            System.out.println("executing request " + httpget.getURI());
            // 执行get请求.
            CloseableHttpResponse response = httpclient.execute(httpget);
            httpResponse = new ESResponse();
            httpResponse.setStatusCode(response.getStatusLine().getStatusCode());
            httpResponse.setEntity(response.getEntity());
            httpResponse.setContentType(response.getEntity().getContentType().getElements()[0].getName());
            httpResponse.setBody(getResponse(response.getEntity()));
        }
        catch (IOException | URISyntaxException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return httpResponse;
    }

    /**
     *  表单数据post
     * @param url
     * @param formData
     * @param charset
     * @param headers
     * @param ssl
     * @return
     */
    public static ESResponse formPost(String url, Map<String, String> formData, String charset, Map<String, String> headers, boolean ssl)
    {
        ESResponse httpResponse = null;
        try
        {
            List<NameValuePair> formParams = new ArrayList<NameValuePair>();
            formData.entrySet().stream().forEach(data -> {
                formParams.add(new BasicNameValuePair(data.getKey(), data.getValue()));
            });
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(formParams, null == charset ? "UTF-8" : charset);
            httpResponse = post(url, uefEntity, headers, ssl);
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        return httpResponse;
    }

    public static ESResponse bodyPost(String url, String jsonData, String charset, Map<String, String> headers, boolean ssl)
    {

        StringEntity stringEntity = new StringEntity(jsonData, ContentType.APPLICATION_JSON);
        stringEntity.setContentEncoding(StringUtils.isEmpty(charset) ? "UTF-8" : charset);
        return post(url, stringEntity, headers, ssl);
    }

    /**
     *  各种请求公共方法
     * @param url       请求url
     * @param entity
     * @param headers   请求头
     * @param ssl       是否ssl请求
     * @return
     */
    private static ESResponse post(String url, HttpEntity entity, Map<String, String> headers, boolean ssl)
    {
        ESResponse httpResponse = null;
        try
        {
            CloseableHttpClient httpclient = null;
            if (ssl)
            {
                httpclient = SSLClient.getSSLClient();
            }
            else
            {
                httpclient = HttpClients.createDefault();
            }
            URIBuilder uriBuilder = new URIBuilder(url);

            // 创建httpget
            HttpPost httpPost = new HttpPost(uriBuilder.build());
            // 处理header
            if (null != headers && !headers.isEmpty())
            {
                headers.entrySet().stream().forEach(header -> {
                    System.out.println("header:" + header.getKey() + ":" + header.getValue());
                    httpPost.setHeader(header.getKey(), header.getValue());
                });
            }
            httpPost.setEntity(entity);

            System.out.println("executing request " + httpPost.getURI());

            // 执行post请求.
            CloseableHttpResponse response = httpclient.execute(httpPost);
            httpResponse = new ESResponse();
            httpResponse.setStatusCode(response.getStatusLine().getStatusCode());
            httpResponse.setEntity(response.getEntity());
            httpResponse.setContentType(null == response.getEntity().getContentType() ? "" : response.getEntity().getContentType().getElements()[0].getName());
            httpResponse.setBody(getResponse(response.getEntity()));
        }
        catch (IOException | URISyntaxException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return httpResponse;
    }

    //    pubic static void

    /**
     * 获取响应内容
     *
     * @param entity
     * @return
     */
    public static String getResponse(HttpEntity entity)
    {
        String responseStr = null;
        try
        {
            responseStr = EntityUtils.toString(entity);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return responseStr;
    }
}
