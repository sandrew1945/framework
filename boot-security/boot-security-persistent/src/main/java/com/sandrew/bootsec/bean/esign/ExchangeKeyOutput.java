package com.sandrew.bootsec.bean.esign;

public class ExchangeKeyOutput
{
    private String requestId;

    private String publicKey;

    private String encode;

    public String getRequestId()
    {
        return requestId;
    }

    public void setRequestId(String requestId)
    {
        this.requestId = requestId;
    }

    public String getPublicKey()
    {
        return publicKey;
    }

    public void setPublicKey(String publicKey)
    {
        this.publicKey = publicKey;
    }

    public String getEncode()
    {
        return encode;
    }

    public void setEncode(String encode)
    {
        this.encode = encode;
    }
}
