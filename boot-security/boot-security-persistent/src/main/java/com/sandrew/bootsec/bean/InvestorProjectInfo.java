package com.sandrew.bootsec.bean;

import com.sandrew.bury.bean.PO;
import lombok.Data;

/** 投资者预约信息bean*/
@Data
public class InvestorProjectInfo extends PO {

  private String mobile; // 手机号

  private String name; // 姓名

  private Integer cardType; // 证件类型(1:身份证)

  private String cardNo; // 证件号码

  private String investorNo; // 投资者编号

  private Integer productId;// 产品id

  private String productCode;// 产品编号

  private String productName;// 产品名称

  private String operatorNo;// 经办人编码


}
