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

@TableName("tt_appointment")
public class TtAppointmentPO extends PO
{

    public TtAppointmentPO()
    {
    }


                                                                                            
    public TtAppointmentPO(Integer appointmentId)
    {
        if (null == this.appointmentId)
        {
            this.appointmentId = new EqualPack<Integer>();
        }
        this.appointmentId.setValue(appointmentId);
    }

    @ColumnName(value = "appointment_id", isPK = true, autoIncrement = true)
    private Pack<Integer> appointmentId;

    @ColumnName(value = "product_id", isPK = false, autoIncrement = false)
    private Pack<Integer> productId;

    @ColumnName(value = "operator_id", isPK = false, autoIncrement = false)
    private Pack<Integer> operatorId;

    @ColumnName(value = "operator_code", isPK = false, autoIncrement = false)
    private Pack<String> operatorCode;

    @ColumnName(value = "operator_name", isPK = false, autoIncrement = false)
    private Pack<String> operatorName;

    @ColumnName(value = "operator_mobile", isPK = false, autoIncrement = false)
    private Pack<String> operatorMobile;

    @ColumnName(value = "product_type", isPK = false, autoIncrement = false)
    private Pack<String> productType;

    @ColumnName(value = "investor_id", isPK = false, autoIncrement = false)
    private Pack<String> investorId;

    @ColumnName(value = "investor_name", isPK = false, autoIncrement = false)
    private Pack<String> investorName;

    @ColumnName(value = "branch_code", isPK = false, autoIncrement = false)
    private Pack<String> branchCode;

    @ColumnName(value = "branch_name", isPK = false, autoIncrement = false)
    private Pack<String> branchName;

    @ColumnName(value = "appointment_time", isPK = false, autoIncrement = false)
    private Pack<Date> appointmentTime;

    @ColumnName(value = "count", isPK = false, autoIncrement = false)
    private Pack<Integer> count;

    @ColumnName(value = "amount", isPK = false, autoIncrement = false)
    private Pack<BigDecimal> amount;

    @ColumnName(value = "temp_id", isPK = false, autoIncrement = false)
    private Pack<Integer> tempId;

    @ColumnName(value = "mot_task_id", isPK = false, autoIncrement = false)
    private Pack<String> motTaskId;

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

    public void setOperatorCode(String operatorCode)
    {
        if (null == this.operatorCode)
        {
            this.operatorCode = new EqualPack<String>();
        }
        this.operatorCode.setValue(operatorCode);
    }

    public void setOperatorCode(Pack<String> operatorCode)
    {
        this.operatorCode = operatorCode;
    }
        
    public String getOperatorCode()
    {
        return this.operatorCode == null ? null : this.operatorCode.getValue();
    }

    public void setOperatorName(String operatorName)
    {
        if (null == this.operatorName)
        {
            this.operatorName = new EqualPack<String>();
        }
        this.operatorName.setValue(operatorName);
    }

    public void setOperatorName(Pack<String> operatorName)
    {
        this.operatorName = operatorName;
    }
        
    public String getOperatorName()
    {
        return this.operatorName == null ? null : this.operatorName.getValue();
    }

    public void setOperatorMobile(String operatorMobile)
    {
        if (null == this.operatorMobile)
        {
            this.operatorMobile = new EqualPack<String>();
        }
        this.operatorMobile.setValue(operatorMobile);
    }

    public void setOperatorMobile(Pack<String> operatorMobile)
    {
        this.operatorMobile = operatorMobile;
    }
        
    public String getOperatorMobile()
    {
        return this.operatorMobile == null ? null : this.operatorMobile.getValue();
    }

    public void setProductType(String productType)
    {
        if (null == this.productType)
        {
            this.productType = new EqualPack<String>();
        }
        this.productType.setValue(productType);
    }

    public void setProductType(Pack<String> productType)
    {
        this.productType = productType;
    }
        
    public String getProductType()
    {
        return this.productType == null ? null : this.productType.getValue();
    }

    public void setInvestorId(String investorId)
    {
        if (null == this.investorId)
        {
            this.investorId = new EqualPack<String>();
        }
        this.investorId.setValue(investorId);
    }

    public void setInvestorId(Pack<String> investorId)
    {
        this.investorId = investorId;
    }
        
    public String getInvestorId()
    {
        return this.investorId == null ? null : this.investorId.getValue();
    }

    public void setInvestorName(String investorName)
    {
        if (null == this.investorName)
        {
            this.investorName = new EqualPack<String>();
        }
        this.investorName.setValue(investorName);
    }

    public void setInvestorName(Pack<String> investorName)
    {
        this.investorName = investorName;
    }
        
    public String getInvestorName()
    {
        return this.investorName == null ? null : this.investorName.getValue();
    }

    public void setBranchCode(String branchCode)
    {
        if (null == this.branchCode)
        {
            this.branchCode = new EqualPack<String>();
        }
        this.branchCode.setValue(branchCode);
    }

    public void setBranchCode(Pack<String> branchCode)
    {
        this.branchCode = branchCode;
    }
        
    public String getBranchCode()
    {
        return this.branchCode == null ? null : this.branchCode.getValue();
    }

    public void setBranchName(String branchName)
    {
        if (null == this.branchName)
        {
            this.branchName = new EqualPack<String>();
        }
        this.branchName.setValue(branchName);
    }

    public void setBranchName(Pack<String> branchName)
    {
        this.branchName = branchName;
    }
        
    public String getBranchName()
    {
        return this.branchName == null ? null : this.branchName.getValue();
    }

    public void setAppointmentTime(Date appointmentTime)
    {
        if (null == this.appointmentTime)
        {
            this.appointmentTime = new EqualPack<Date>();
        }
        this.appointmentTime.setValue(appointmentTime);
    }

    public void setAppointmentTime(Pack<Date> appointmentTime)
    {
        this.appointmentTime = appointmentTime;
    }
        
    public Date getAppointmentTime()
    {
        return this.appointmentTime == null ? null : this.appointmentTime.getValue();
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

    public void setTempId(Integer tempId)
    {
        if (null == this.tempId)
        {
            this.tempId = new EqualPack<Integer>();
        }
        this.tempId.setValue(tempId);
    }

    public void setTempId(Pack<Integer> tempId)
    {
        this.tempId = tempId;
    }
        
    public Integer getTempId()
    {
        return this.tempId == null ? null : this.tempId.getValue();
    }

    public void setMotTaskId(String motTaskId)
    {
        if (null == this.motTaskId)
        {
            this.motTaskId = new EqualPack<String>();
        }
        this.motTaskId.setValue(motTaskId);
    }

    public void setMotTaskId(Pack<String> motTaskId)
    {
        this.motTaskId = motTaskId;
    }
        
    public String getMotTaskId()
    {
        return this.motTaskId == null ? null : this.motTaskId.getValue();
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