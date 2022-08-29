package com.sandrew.bootsec.bean;

import com.sandrew.bury.bean.PO;
import lombok.Data;

@Data
public class SmsInfo extends PO {

  // private String LX;//处理类型（功能号）  =0

  // private String YYBDM;//营业部代码，可以为空

  // private String FHLS;//返回流水0：不需要，1：需要

   private String DXNR;//短信内容

   private String SJHM;//接收手机号码,多个手机以；分隔

}
