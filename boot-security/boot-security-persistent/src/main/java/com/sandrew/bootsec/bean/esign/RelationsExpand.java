package com.sandrew.bootsec.bean.esign;

import lombok.Data;

import javax.validation.constraints.NotEmpty;


/** 项目关系-投资者实体 */
@Data
public class RelationsExpand {

  /** 指定双录经办人（项目经办人注册返回的签约接口平台账号itoAccount） */
  String doubleRecordAccount;

  /** 项目经办人（项目经办人注册返回的签约接口平台账号itoAccount） */
  @NotEmpty(message = "投资者账号为必输字段")
  String investorAccount;

  /** 项目投资者（项目投资者注册返回的签约接口平台账号itoAccount） */
  @NotEmpty(message = "经办人账号为必输字段")
  String operatorAccount;

  /** 投资者类型 */
  @NotEmpty(message = "投资者类型为必输字段")
  String type;
  /** 投资者风险等级 */
  @NotEmpty(message = "投资者风险等级为必输字段")
  String riskLevel;

  /** 匹配结果 */
  @NotEmpty(message = "匹配结果为必输字段")
  String riskMatch;

  /** 双录文件hash */
  String recordHash;

  /** 签约平台项目编号 */
  @NotEmpty(message = "签约平台项目编号为必输字段")
  String fundCode;
}
