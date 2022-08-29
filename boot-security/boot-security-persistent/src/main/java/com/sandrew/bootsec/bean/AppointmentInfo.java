package com.sandrew.bootsec.bean;

import com.sandrew.bury.bean.PO;
import lombok.Data;

import java.util.Date;

@Data
public class AppointmentInfo extends PO {
  private int appointmentId; // 预约id

  private int productId; // 产品id

  private int operatorId; // 经办人id

  private String operatorName; // 经办人姓名

  private String operatorCode; // 经办人编号

  private String productCode; // 代销机构产品编号

  private String fundCode; // 签约平台项目编号

  private String productName; // 代销机构产品名称

  private String investorId; // 投资者id

  private String investorName; // 投资者姓名

  private Date appointmentTime; // 预约时间

  private int status; // 状态:未确认、已确认、已取消'

  private int orderId; // 任务id

  private String investorAccount; // 通用接口服务平台账号
}
