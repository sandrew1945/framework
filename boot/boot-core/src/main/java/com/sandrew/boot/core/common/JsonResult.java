package com.sandrew.boot.core.common;

/**
 * Created by summer on 2019/12/18.
 */
public class JsonResult extends AjaxResult
{
    private Object data;

    public Object getData()
    {
        return data;
    }

    public void setData(Object data)
    {
        this.data = data;
    }

    public JsonResult requestSuccess(Object data)
    {
        this.result = true;
        this.data = data;
        return this;
    }
}
