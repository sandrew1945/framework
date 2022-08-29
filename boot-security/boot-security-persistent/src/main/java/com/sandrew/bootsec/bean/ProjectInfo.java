package com.sandrew.bootsec.bean;

import com.sandrew.bury.bean.PO;
import lombok.Data;

@Data
public class ProjectInfo extends PO
{
    private Integer productId;

    private String productCode;

    private String productName;

}
