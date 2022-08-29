package com.sandrew.bootsec.bean;

import com.sandrew.bury.bean.PO;
import lombok.Data;

import java.util.Date;

/** */
@Data
public class InvestorAppointmentInfo extends PO {

  private Date appointmentTime; // 预约时间

  private String investorAccount; // 投资者账号

  private String inverstorToken; //投资者token

  private String operatorAccount; // 经办人账号

  private int status; // 预约状态

  private String fundCode; // 项目编号

  private String operatorNo; // 经办人编码



}
