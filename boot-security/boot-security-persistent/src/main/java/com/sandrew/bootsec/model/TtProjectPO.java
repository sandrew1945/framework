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

@TableName("tt_project")
public class TtProjectPO extends PO
{

    public TtProjectPO()
    {
    }


                                                                    
    public TtProjectPO(Integer productId)
    {
        if (null == this.productId)
        {
            this.productId = new EqualPack<Integer>();
        }
        this.productId.setValue(productId);
    }

    @ColumnName(value = "product_id", isPK = true, autoIncrement = true)
    private Pack<Integer> productId;

    @ColumnName(value = "product_code", isPK = false, autoIncrement = false)
    private Pack<String> productCode;

    @ColumnName(value = "product_name", isPK = false, autoIncrement = false)
    private Pack<String> productName;

    @ColumnName(value = "fund_code", isPK = false, autoIncrement = false)
    private Pack<String> fundCode;

    @ColumnName(value = "fund_name", isPK = false, autoIncrement = false)
    private Pack<String> fundName;

    @ColumnName(value = "confirm_time", isPK = false, autoIncrement = false)
    private Pack<Date> confirmTime;

    @ColumnName(value = "manager_name", isPK = false, autoIncrement = false)
    private Pack<String> managerName;

    @ColumnName(value = "trustee", isPK = false, autoIncrement = false)
    private Pack<String> trustee;

    @ColumnName(value = "ver", isPK = false, autoIncrement = false)
    private Pack<String> ver;

    @ColumnName(value = "status", isPK = false, autoIncrement = false)
    private Pack<Integer> status;

    @ColumnName(value = "is_push", isPK = false, autoIncrement = false)
    private Pack<Integer> isPush;

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

    public void setProductCode(String productCode)
    {
        if (null == this.productCode)
        {
            this.productCode = new EqualPack<String>();
        }
        this.productCode.setValue(productCode);
    }

    public void setProductCode(Pack<String> productCode)
    {
        this.productCode = productCode;
    }
        
    public String getProductCode()
    {
        return this.productCode == null ? null : this.productCode.getValue();
    }

    public void setProductName(String productName)
    {
        if (null == this.productName)
        {
            this.productName = new EqualPack<String>();
        }
        this.productName.setValue(productName);
    }

    public void setProductName(Pack<String> productName)
    {
        this.productName = productName;
    }
        
    public String getProductName()
    {
        return this.productName == null ? null : this.productName.getValue();
    }

    public void setFundCode(String fundCode)
    {
        if (null == this.fundCode)
        {
            this.fundCode = new EqualPack<String>();
        }
        this.fundCode.setValue(fundCode);
    }

    public void setFundCode(Pack<String> fundCode)
    {
        this.fundCode = fundCode;
    }
        
    public String getFundCode()
    {
        return this.fundCode == null ? null : this.fundCode.getValue();
    }

    public void setFundName(String fundName)
    {
        if (null == this.fundName)
        {
            this.fundName = new EqualPack<String>();
        }
        this.fundName.setValue(fundName);
    }

    public void setFundName(Pack<String> fundName)
    {
        this.fundName = fundName;
    }
        
    public String getFundName()
    {
        return this.fundName == null ? null : this.fundName.getValue();
    }

    public void setConfirmTime(Date confirmTime)
    {
        if (null == this.confirmTime)
        {
            this.confirmTime = new EqualPack<Date>();
        }
        this.confirmTime.setValue(confirmTime);
    }

    public void setConfirmTime(Pack<Date> confirmTime)
    {
        this.confirmTime = confirmTime;
    }
        
    public Date getConfirmTime()
    {
        return this.confirmTime == null ? null : this.confirmTime.getValue();
    }

    public void setManagerName(String managerName)
    {
        if (null == this.managerName)
        {
            this.managerName = new EqualPack<String>();
        }
        this.managerName.setValue(managerName);
    }

    public void setManagerName(Pack<String> managerName)
    {
        this.managerName = managerName;
    }
        
    public String getManagerName()
    {
        return this.managerName == null ? null : this.managerName.getValue();
    }

    public void setTrustee(String trustee)
    {
        if (null == this.trustee)
        {
            this.trustee = new EqualPack<String>();
        }
        this.trustee.setValue(trustee);
    }

    public void setTrustee(Pack<String> trustee)
    {
        this.trustee = trustee;
    }
        
    public String getTrustee()
    {
        return this.trustee == null ? null : this.trustee.getValue();
    }

    public void setVer(String ver)
    {
        if (null == this.ver)
        {
            this.ver = new EqualPack<String>();
        }
        this.ver.setValue(ver);
    }

    public void setVer(Pack<String> ver)
    {
        this.ver = ver;
    }
        
    public String getVer()
    {
        return this.ver == null ? null : this.ver.getValue();
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

    public void setIsPush(Integer isPush)
    {
        if (null == this.isPush)
        {
            this.isPush = new EqualPack<Integer>();
        }
        this.isPush.setValue(isPush);
    }

    public void setIsPush(Pack<Integer> isPush)
    {
        this.isPush = isPush;
    }
        
    public Integer getIsPush()
    {
        return this.isPush == null ? null : this.isPush.getValue();
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