package com.sandrew.bootsec.bean;

import lombok.Data;

@Data
public class AppVersionLogVo {

    private Integer logId;

    private String appVersion;

    private String aokUrl;

    private String updateDesc;

    private Integer isForceUpdate;

    private Integer isUpdate;

    private Integer apkSize;

    private String apkMd5;

}