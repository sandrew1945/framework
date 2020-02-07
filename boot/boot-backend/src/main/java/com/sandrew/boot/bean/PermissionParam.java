package com.sandrew.boot.bean;

import com.sandrew.boot.service.util.MenuNode;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by summer on 2020/2/1.
 */
@Data
public class PermissionParam
{
    @ApiModelProperty("角色ID")
    public Integer roleId;

    @ApiModelProperty("菜单节点集合")
    public List<MenuNode> node;
}
