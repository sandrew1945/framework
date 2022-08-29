package com.sandrew.bootsec.bean.esign;

import lombok.Data;

/** 项目关系 */
@Data
public class Relations {

  /** 签约平台项目编号 */
  String fundCode;

  /** 项目经办人（项目经办人注册返回的签约接口平台账号itoAccount） */
  String itoAccount;
}
