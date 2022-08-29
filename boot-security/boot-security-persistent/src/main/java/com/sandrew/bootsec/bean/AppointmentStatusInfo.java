package com.sandrew.bootsec.bean;

import com.sandrew.bury.bean.PO;
import lombok.Data;

@Data
public class AppointmentStatusInfo extends PO {
  private int appointmentId; // 预约id

  private int status; // 状态:未确认、已确认、已取消'

  private int orderId; // 任务id

  private String ProductCode;
}
