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

@TableName("tr_product_sign")
public class TrProductSignPO extends PO
{

    public TrProductSignPO()
    {
    }


                                        
    public TrProductSignPO(Integer id)
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

    @ColumnName(value = "operator_id", isPK = false, autoIncrement = false)
    private Pack<Integer> operatorId;

    @ColumnName(value = "is_signed", isPK = false, autoIncrement = false)
    private Pack<Integer> isSigned;

    @ColumnName(value = "sign_time", isPK = false, autoIncrement = false)
    private Pack<Date> signTime;

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

    public void setOperatorId(Integer operatorId)
    {
        if (null == this.operatorId)
        {
            this.operatorId = new EqualPack<Integer>();
        }
        this.operatorId.setValue(operatorId);
    }

    public void setOperatorId(Pack<Integer> operatorId)
    {
        this.operatorId = operatorId;
    }
        
    public Integer getOperatorId()
    {
        return this.operatorId == null ? null : this.operatorId.getValue();
    }

    public void setIsSigned(Integer isSigned)
    {
        if (null == this.isSigned)
        {
            this.isSigned = new EqualPack<Integer>();
        }
        this.isSigned.setValue(isSigned);
    }

    public void setIsSigned(Pack<Integer> isSigned)
    {
        this.isSigned = isSigned;
    }
        
    public Integer getIsSigned()
    {
        return this.isSigned == null ? null : this.isSigned.getValue();
    }

    public void setSignTime(Date signTime)
    {
        if (null == this.signTime)
        {
            this.signTime = new EqualPack<Date>();
        }
        this.signTime.setValue(signTime);
    }

    public void setSignTime(Pack<Date> signTime)
    {
        this.signTime = signTime;
    }
        
    public Date getSignTime()
    {
        return this.signTime == null ? null : this.signTime.getValue();
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