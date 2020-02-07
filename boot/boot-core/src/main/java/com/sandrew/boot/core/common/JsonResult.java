package com.sandrew.boot.core.common;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by summer on 2019/12/18.
 */
public class JsonResult extends AjaxResult
{
    @ApiModelProperty("返回数据")
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
