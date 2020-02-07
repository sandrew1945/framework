package com.sandrew.boot.service.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * VUE菜单节点
 * Created by summer on 2020/1/8.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuNode implements Comparable
{
    @ApiModelProperty("Url")
    private String path;
    @ApiModelProperty("名称")
    private String name;
    @ApiModelProperty("页面所在路径")
    private String component;
    @ApiModelProperty("重定向")
    private String redirect;
    @ApiModelProperty("元数据，如：title: 'Dashboard', icon: 'dashboard'")
    private Map<String, String> meta;
    @ApiModelProperty("子节点集合")
    private List<MenuNode> children = new ArrayList<>();

    public MenuNode()
    {
    }

    public void addChildren(MenuNode child)
    {
        if (null != children)
        {
            children.add(child);
        }
    }

    @Override
    public int compareTo(Object other)
    {
        MenuNode otherNode = (MenuNode) other;
        if (this.path.equals(otherNode.path) && this.name.equals(otherNode.name))
        {
            return 0;
        }
        return -1;
    }
}
