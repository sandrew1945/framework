package com.sandrew.bootsec.bean;

import com.sandrew.bury.bean.PO;
import lombok.Data;

@Data
public class OperatorInfo extends PO
{
    private int operatorId;      // 经办人id

    private String operatorName; // 经办人姓名

    private String operatorCode; // 经办人编号

    private String operatorNo;   // 经办人编号

    private String mobile;      // 手机号

    private String email;      // 电子邮箱

    private String branchCode; // 所在营业部编号

    private String branchName; // 所在营业部名称

    private String cardType;   // 证件类型

    private String cardNo;      // 证件编号

    private String appId;       //客户端ID 用于消息推送使用

}
