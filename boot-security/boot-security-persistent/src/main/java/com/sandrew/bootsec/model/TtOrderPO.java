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

import java.math.BigDecimal;
import java.util.Date;

@TableName("tt_order")
public class TtOrderPO extends PO
{

    public TtOrderPO()
    {
    }


                                                
    public TtOrderPO(Integer orderId)
    {
        if (null == this.orderId)
        {
            this.orderId = new EqualPack<Integer>();
        }
        this.orderId.setValue(orderId);
    }

    @ColumnName(value = "order_id", isPK = true, autoIncrement = true)
    private Pack<Integer> orderId;

    @ColumnName(value = "appointment_id", isPK = false, autoIncrement = false)
    private Pack<Integer> appointmentId;

    @ColumnName(value = "count", isPK = false, autoIncrement = false)
    private Pack<Integer> count;

    @ColumnName(value = "amount", isPK = false, autoIncrement = false)
    private Pack<BigDecimal> amount;

    @ColumnName(value = "order_time", isPK = false, autoIncrement = false)
    private Pack<Date> orderTime;

    @ColumnName(value = "status", isPK = false, autoIncrement = false)
    private Pack<Integer> status;

    @ColumnName(value = "is_delete", isPK = false, autoIncrement = false)
    private Pack<Integer> isDelete;

    @ColumnName(value = "create_date", isPK = false, autoIncrement = false)
    private Pack<Date> createDate;

    @ColumnName(value = "create_by", isPK = false, autoIncrement = false)
    private Pack<Integer> createBy;

    @ColumnName(value = "update_date", isPK = false, autoIncrement = false)
    private Pack<Date> updateDate;

    @ColumnName(value = "update_by", isPK = false, autoIncrement = false)
    private Pack<Integer> updateBy;


    public void setOrderId(Integer orderId)
    {
        if (null == this.orderId)
        {
            this.orderId = new EqualPack<Integer>();
        }
        this.orderId.setValue(orderId);
    }

    public void setOrderId(Pack<Integer> orderId)
    {
        this.orderId = orderId;
    }
        
    public Integer getOrderId()
    {
        return this.orderId == null ? null : this.orderId.getValue();
    }

    public void setAppointmentId(Integer appointmentId)
    {
        if (null == this.appointmentId)
        {
            this.appointmentId = new EqualPack<Integer>();
        }
        this.appointmentId.setValue(appointmentId);
    }

    public void setAppointmentId(Pack<Integer> appointmentId)
    {
        this.appointmentId = appointmentId;
    }
        
    public Integer getAppointmentId()
    {
        return this.appointmentId == null ? null : this.appointmentId.getValue();
    }

    public void setCount(Integer count)
    {
        if (null == this.count)
        {
            this.count = new EqualPack<Integer>();
        }
        this.count.setValue(count);
    }

    public void setCount(Pack<Integer> count)
    {
        this.count = count;
    }
        
    public Integer getCount()
    {
        return this.count == null ? null : this.count.getValue();
    }

    public void setAmount(BigDecimal amount)
    {
        if (null == this.amount)
        {
            this.amount = new EqualPack<BigDecimal>();
        }
        this.amount.setValue(amount);
    }

    public void setAmount(Pack<BigDecimal> amount)
    {
        this.amount = amount;
    }
        
    public BigDecimal getAmount()
    {
        return this.amount == null ? null : this.amount.getValue();
    }

    public void setOrderTime(Date orderTime)
    {
        if (null == this.orderTime)
        {
            this.orderTime = new EqualPack<Date>();
        }
        this.orderTime.setValue(orderTime);
    }

    public void setOrderTime(Pack<Date> orderTime)
    {
        this.orderTime = orderTime;
    }
        
    public Date getOrderTime()
    {
        return this.orderTime == null ? null : this.orderTime.getValue();
    }

    public void setStatus(Integer status)
    {
        if (null == this.status)
        {
            this.status = new EqualPack<Integer>();
        }
        this.status.setValue(status);
    }

    public void setStatus(Pack<Integer> status)
    {
        this.status = status;
    }
        
    public Integer getStatus()
    {
        return this.status == null ? null : this.status.getValue();
    }

    public void setIsDelete(Integer isDelete)
    {
        if (null == this.isDelete)
        {
            this.isDelete = new EqualPack<Integer>();
        }
        this.isDelete.setValue(isDelete);
    }

    public void setIsDelete(Pack<Integer> isDelete)
    {
        this.isDelete = isDelete;
    }
        
    public Integer getIsDelete()
    {
        return this.isDelete == null ? null : this.isDelete.getValue();
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

    public void setUpdateDate(Date updateDate)
    {
        if (null == this.updateDate)
        {
            this.updateDate = new EqualPack<Date>();
        }
        this.updateDate.setValue(updateDate);
    }

    public void setUpdateDate(Pack<Date> updateDate)
    {
        this.updateDate = updateDate;
    }
        
    public Date getUpdateDate()
    {
        return this.updateDate == null ? null : this.updateDate.getValue();
    }

    public void setUpdateBy(Integer updateBy)
    {
        if (null == this.updateBy)
        {
            this.updateBy = new EqualPack<Integer>();
        }
        this.updateBy.setValue(updateBy);
    }

    public void setUpdateBy(Pack<Integer> updateBy)
    {
        this.updateBy = updateBy;
    }
        
    public Integer getUpdateBy()
    {
        return this.updateBy == null ? null : this.updateBy.getValue();
    }

}