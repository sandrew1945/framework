package com.sandrew.bootsec.core.util.http;

import org.apache.http.HttpEntity;

/**
 *  调用esign返回结果
 */
public class ESResponse
{
    private int statusCode;

    private String contentType;

    private HttpEntity entity;

    private String body;

    public int getStatusCode()
    {
        return statusCode;
    }

    public void setStatusCode(int statusCode)
    {
        this.statusCode = statusCode;
    }

    public String getContentType()
    {
        return contentType;
    }

    public void setContentType(String contentType)
    {
        this.contentType = contentType;
    }

    public HttpEntity getEntity()
    {
        return entity;
    }

    public void setEntity(HttpEntity entity)
    {
        this.entity = entity;
    }

    public String getBody()
    {
        return body;
    }

    public void setBody(String body)
    {
        this.body = body;
    }
}
