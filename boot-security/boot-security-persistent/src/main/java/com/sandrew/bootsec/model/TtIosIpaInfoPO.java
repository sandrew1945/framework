/**
 *   自动生成的PO,不要手动修改
 *
 */
package com.sandrew.bootsec.model;

import com.sandrew.bury.annotations.ColumnName;
import com.sandrew.bury.annotations.TableName;
import com.sandrew.bury.bean.EqualPack;
import com.sandrew.bury.bean.PO;
import com.sandrew.bury.bean.Pack;

import java.util.Date;

@TableName("tt_ios_ipa_info")
public class TtIosIpaInfoPO extends PO
{

    public TtIosIpaInfoPO()
    {
    }


                                    
    public TtIosIpaInfoPO(Integer id)
    {
        if (null == this.id)
        {
            this.id = new EqualPack<Integer>();
        }
        this.id.setValue(id);
    }

    @ColumnName(value = "id", isPK = true, autoIncrement = true)
    private Pack<Integer> id;

    @ColumnName(value = "code", isPK = false, autoIncrement = false)
    private Pack<String> code;

    @ColumnName(value = "insert_time", isPK = false, autoIncrement = false)
    private Pack<Date> insertTime;

    @ColumnName(value = "url", isPK = false, autoIncrement = false)
    private Pack<String> url;

    @ColumnName(value = "use_flag", isPK = false, autoIncrement = false)
    private Pack<Integer> useFlag;

    @ColumnName(value = "use_time", isPK = false, autoIncrement = false)
    private Pack<Date> useTime;

    @ColumnName(value = "use_ip", isPK = false, autoIncrement = false)
    private Pack<String> useIp;

    @ColumnName(value = "user_agent", isPK = false, autoIncrement = false)
    private Pack<String> userAgent;


    public void setId(Integer id)
    {
        if (null == this.id)
        {
            this.id = new EqualPack<Integer>();
        }
        this.id.setValue(id);
    }

    public void setId(Pack<Integer> id)
    {
        this.id = id;
    }
        
    public Integer getId()
    {
        return this.id == null ? null : this.id.getValue();
    }

    public void setCode(String code)
    {
        if (null == this.code)
        {
            this.code = new EqualPack<String>();
        }
        this.code.setValue(code);
    }

    public void setCode(Pack<String> code)
    {
        this.code = code;
    }
        
    public String getCode()
    {
        return this.code == null ? null : this.code.getValue();
    }

    public void setInsertTime(Date insertTime)
    {
        if (null == this.insertTime)
        {
            this.insertTime = new EqualPack<Date>();
        }
        this.insertTime.setValue(insertTime);
    }

    public void setInsertTime(Pack<Date> insertTime)
    {
        this.insertTime = insertTime;
    }
        
    public Date getInsertTime()
    {
        return this.insertTime == null ? null : this.insertTime.getValue();
    }

    public void setUrl(String url)
    {
        if (null == this.url)
        {
            this.url = new EqualPack<String>();
        }
        this.url.setValue(url);
    }

    public void setUrl(Pack<String> url)
    {
        this.url = url;
    }
        
    public String getUrl()
    {
        return this.url == null ? null : this.url.getValue();
    }

    public void setUseFlag(Integer useFlag)
    {
        if (null == this.useFlag)
        {
            this.useFlag = new EqualPack<Integer>();
        }
        this.useFlag.setValue(useFlag);
    }

    public void setUseFlag(Pack<Integer> useFlag)
    {
        this.useFlag = useFlag;
    }
        
    public Integer getUseFlag()
    {
        return this.useFlag == null ? null : this.useFlag.getValue();
    }

    public void setUseTime(Date useTime)
    {
        if (null == this.useTime)
        {
            this.useTime = new EqualPack<Date>();
        }
        this.useTime.setValue(useTime);
    }

    public void setUseTime(Pack<Date> useTime)
    {
        this.useTime = useTime;
    }
        
    public Date getUseTime()
    {
        return this.useTime == null ? null : this.useTime.getValue();
    }

    public void setUseIp(String useIp)
    {
        if (null == this.useIp)
        {
            this.useIp = new EqualPack<String>();
        }
        this.useIp.setValue(useIp);
    }

    public void setUseIp(Pack<String> useIp)
    {
        this.useIp = useIp;
    }
        
    public String getUseIp()
    {
        return this.useIp == null ? null : this.useIp.getValue();
    }

    public void setUserAgent(String userAgent)
    {
        if (null == this.userAgent)
        {
            this.userAgent = new EqualPack<String>();
        }
        this.userAgent.setValue(userAgent);
    }

    public void setUserAgent(Pack<String> userAgent)
    {
        this.userAgent = userAgent;
    }
        
    public String getUserAgent()
    {
        return this.userAgent == null ? null : this.userAgent.getValue();
    }

}