package com.sandrew.bootsec.bean.esign;

import lombok.Data;

import java.util.List;

@Data
public class SelectProductOutput
{
    private String requestId;

    private List<FundInfo> fundInfos;
}
