package com.sandrew.bootsec.bean;

import com.sandrew.bury.bean.PO;
import lombok.Data;

import java.util.Date;

/**
 *  签署任务VO
 */
@Data
public class SignTaskVO extends PO
{
    private String productCode;

    private String productName;

    private String fundCode;

    private String fundName;

    private Integer isSigned;       // 是否签署

    private String signStatus;      // 签署状态：已签署/未签署

    private Date signTime;
}
