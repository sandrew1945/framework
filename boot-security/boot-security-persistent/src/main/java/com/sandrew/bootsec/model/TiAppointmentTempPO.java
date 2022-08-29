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

@TableName("ti_appointment_temp")
public class TiAppointmentTempPO extends PO
{

    public TiAppointmentTempPO()
    {
    }


                                                                
    public TiAppointmentTempPO(Integer tempId)
    {
        if (null == this.tempId)
        {
            this.tempId = new EqualPack<Integer>();
        }
        this.tempId.setValue(tempId);
    }

    @ColumnName(value = "temp_id", isPK = true, autoIncrement = true)
    private Pack<Integer> tempId;

    @ColumnName(value = "cpdm", isPK = false, autoIncrement = false)
    private Pack<String> cpdm;

    @ColumnName(value = "xsr", isPK = false, autoIncrement = false)
    private Pack<Integer> xsr;

    @ColumnName(value = "xsrxm", isPK = false, autoIncrement = false)
    private Pack<String> xsrxm;

    @ColumnName(value = "org_id", isPK = false, autoIncrement = false)
    private Pack<Integer> orgId;

    @ColumnName(value = "org_name", isPK = false, autoIncrement = false)
    private Pack<String> orgName;

    @ColumnName(value = "khid", isPK = false, autoIncrement = false)
    private Pack<String> khid;

    @ColumnName(value = "xm", isPK = false, autoIncrement = false)
    private Pack<String> xm;

    @ColumnName(value = "khorgid", isPK = false, autoIncrement = false)
    private Pack<String> khorgid;

    @ColumnName(value = "khorgmc", isPK = false, autoIncrement = false)
    private Pack<String> khorgmc;

    @ColumnName(value = "kh_mobile", isPK = false, autoIncrement = false)
    private Pack<String> khMobile;

    @ColumnName(value = "kh_card_no", isPK = false, autoIncrement = false)
    private Pack<String> khCardNo;

    @ColumnName(value = "data_biz_date", isPK = false, autoIncrement = false)
    private Pack<String> dataBizDate;

    @ColumnName(value = "status", isPK = false, autoIncrement = false)
    private Pack<Integer> status;

    @ColumnName(value = "create_date", isPK = false, autoIncrement = false)
    private Pack<Date> createDate;


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

    public void setCpdm(String cpdm)
    {
        if (null == this.cpdm)
        {
            this.cpdm = new EqualPack<String>();
        }
        this.cpdm.setValue(cpdm);
    }

    public void setCpdm(Pack<String> cpdm)
    {
        this.cpdm = cpdm;
    }
        
    public String getCpdm()
    {
        return this.cpdm == null ? null : this.cpdm.getValue();
    }

    public void setXsr(Integer xsr)
    {
        if (null == this.xsr)
        {
            this.xsr = new EqualPack<Integer>();
        }
        this.xsr.setValue(xsr);
    }

    public void setXsr(Pack<Integer> xsr)
    {
        this.xsr = xsr;
    }
        
    public Integer getXsr()
    {
        return this.xsr == null ? null : this.xsr.getValue();
    }

    public void setXsrxm(String xsrxm)
    {
        if (null == this.xsrxm)
        {
            this.xsrxm = new EqualPack<String>();
        }
        this.xsrxm.setValue(xsrxm);
    }

    public void setXsrxm(Pack<String> xsrxm)
    {
        this.xsrxm = xsrxm;
    }
        
    public String getXsrxm()
    {
        return this.xsrxm == null ? null : this.xsrxm.getValue();
    }

    public void setOrgId(Integer orgId)
    {
        if (null == this.orgId)
        {
            this.orgId = new EqualPack<Integer>();
        }
        this.orgId.setValue(orgId);
    }

    public void setOrgId(Pack<Integer> orgId)
    {
        this.orgId = orgId;
    }
        
    public Integer getOrgId()
    {
        return this.orgId == null ? null : this.orgId.getValue();
    }

    public void setOrgName(String orgName)
    {
        if (null == this.orgName)
        {
            this.orgName = new EqualPack<String>();
        }
        this.orgName.setValue(orgName);
    }

    public void setOrgName(Pack<String> orgName)
    {
        this.orgName = orgName;
    }
        
    public String getOrgName()
    {
        return this.orgName == null ? null : this.orgName.getValue();
    }

    public void setKhid(String khid)
    {
        if (null == this.khid)
        {
            this.khid = new EqualPack<String>();
        }
        this.khid.setValue(khid);
    }

    public void setKhid(Pack<String> khid)
    {
        this.khid = khid;
    }
        
    public String getKhid()
    {
        return this.khid == null ? null : this.khid.getValue();
    }

    public void setXm(String xm)
    {
        if (null == this.xm)
        {
            this.xm = new EqualPack<String>();
        }
        this.xm.setValue(xm);
    }

    public void setXm(Pack<String> xm)
    {
        this.xm = xm;
    }
        
    public String getXm()
    {
        return this.xm == null ? null : this.xm.getValue();
    }

    public void setKhorgid(String khorgid)
    {
        if (null == this.khorgid)
        {
            this.khorgid = new EqualPack<String>();
        }
        this.khorgid.setValue(khorgid);
    }

    public void setKhorgid(Pack<String> khorgid)
    {
        this.khorgid = khorgid;
    }
        
    public String getKhorgid()
    {
        return this.khorgid == null ? null : this.khorgid.getValue();
    }

    public void setKhorgmc(String khorgmc)
    {
        if (null == this.khorgmc)
        {
            this.khorgmc = new EqualPack<String>();
        }
        this.khorgmc.setValue(khorgmc);
    }

    public void setKhorgmc(Pack<String> khorgmc)
    {
        this.khorgmc = khorgmc;
    }
        
    public String getKhorgmc()
    {
        return this.khorgmc == null ? null : this.khorgmc.getValue();
    }

    public void setKhMobile(String khMobile)
    {
        if (null == this.khMobile)
        {
            this.khMobile = new EqualPack<String>();
        }
        this.khMobile.setValue(khMobile);
    }

    public void setKhMobile(Pack<String> khMobile)
    {
        this.khMobile = khMobile;
    }
        
    public String getKhMobile()
    {
        return this.khMobile == null ? null : this.khMobile.getValue();
    }

    public void setKhCardNo(String khCardNo)
    {
        if (null == this.khCardNo)
        {
            this.khCardNo = new EqualPack<String>();
        }
        this.khCardNo.setValue(khCardNo);
    }

    public void setKhCardNo(Pack<String> khCardNo)
    {
        this.khCardNo = khCardNo;
    }
        
    public String getKhCardNo()
    {
        return this.khCardNo == null ? null : this.khCardNo.getValue();
    }

    public void setDataBizDate(String dataBizDate)
    {
        if (null == this.dataBizDate)
        {
            this.dataBizDate = new EqualPack<String>();
        }
        this.dataBizDate.setValue(dataBizDate);
    }

    public void setDataBizDate(Pack<String> dataBizDate)
    {
        this.dataBizDate = dataBizDate;
    }
        
    public String getDataBizDate()
    {
        return this.dataBizDate == null ? null : this.dataBizDate.getValue();
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

}