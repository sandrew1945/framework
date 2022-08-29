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

@TableName("tr_product_investor")
public class TrProductInvestorPO extends PO
{

    public TrProductInvestorPO()
    {
    }


                                
    public TrProductInvestorPO(Integer id)
    {
        if (null == this.id)
        {
            this.id = new EqualPack<Integer>();
        }
        this.id.setValue(id);
    }

    @ColumnName(value = "id", isPK = true, autoIncrement = true)
    private Pack<Integer> id;

    @ColumnName(value = "product_id", isPK = false, autoIncrement = false)
    private Pack<Integer> productId;

    @ColumnName(value = "investor_id", isPK = false, autoIncrement = false)
    private Pack<Integer> investorId;

    @ColumnName(value = "is_send", isPK = false, autoIncrement = false)
    private Pack<Integer> isSend;

    @ColumnName(value = "send_time", isPK = false, autoIncrement = false)
    private Pack<Date> sendTime;

    @ColumnName(value = "create_date", isPK = false, autoIncrement = false)
    private Pack<Date> createDate;

    @ColumnName(value = "create_by", isPK = false, autoIncrement = false)
    private Pack<Integer> createBy;


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

    public void setProductId(Integer productId)
    {
        if (null == this.productId)
        {
            this.productId = new EqualPack<Integer>();
        }
        this.productId.setValue(productId);
    }

    public void setProductId(Pack<Integer> productId)
    {
        this.productId = productId;
    }
        
    public Integer getProductId()
    {
        return this.productId == null ? null : this.productId.getValue();
    }

    public void setInvestorId(Integer investorId)
    {
        if (null == this.investorId)
        {
            this.investorId = new EqualPack<Integer>();
        }
        this.investorId.setValue(investorId);
    }

    public void setInvestorId(Pack<Integer> investorId)
    {
        this.investorId = investorId;
    }
        
    public Integer getInvestorId()
    {
        return this.investorId == null ? null : this.investorId.getValue();
    }

    public void setIsSend(Integer isSend)
    {
        if (null == this.isSend)
        {
            this.isSend = new EqualPack<Integer>();
        }
        this.isSend.setValue(isSend);
    }

    public void setIsSend(Pack<Integer> isSend)
    {
        this.isSend = isSend;
    }
        
    public Integer getIsSend()
    {
        return this.isSend == null ? null : this.isSend.getValue();
    }

    public void setSendTime(Date sendTime)
    {
        if (null == this.sendTime)
        {
            this.sendTime = new EqualPack<Date>();
        }
        this.sendTime.setValue(sendTime);
    }

    public void setSendTime(Pack<Date> sendTime)
    {
        this.sendTime = sendTime;
    }
        
    public Date getSendTime()
    {
        return this.sendTime == null ? null : this.sendTime.getValue();
    }

    public void setCreateDate(Date createDate)
    {
        if (null == this.createDate)
        {
            this.createDate = new EqualPack<Date>();
        }
        this.createDate.setValue(createDate);
    }

    public void setCreateDate(Pack<Date> createDate)
    {
        this.createDate = createDate;
    }
        
    public Date getCreateDate()
    {
        return this.createDate == null ? null : this.createDate.getValue();
    }

    public void setCreateBy(Integer createBy)
    {
        if (null == this.createBy)
        {
            this.createBy = new EqualPack<Integer>();
        }
        this.createBy.setValue(createBy);
    }

    public void setCreateBy(Pack<Integer> createBy)
    {
        this.createBy = createBy;
    }
        
    public Integer getCreateBy()
    {
        return this.createBy == null ? null : this.createBy.getValue();
    }

}