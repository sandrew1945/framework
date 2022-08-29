package com.sandrew.bootsec.bean;

import com.sandrew.bury.bean.PO;
import lombok.Data;

import java.util.Date;

@Data
public class AppointmentInfos extends PO {
  private Date appointmentTime; // 预约时间

  private String investorAccount; // 投资者账号

  private String operatorAccount; // 经办人账号

  private String productCode; // 代销机构产品编号

  private String productName; // 代销机构产品名称

  private String fundCode; // 签约平台项目编号

  private String fundName; // 签约平台项目名称

  private String investorNo; // 投资者编码

  private String operatorNo; // 经办人编码

  private String operatorName; // 经办人姓名

  private int status; // 预约状态
}
