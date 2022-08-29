/**
 *   自动生成的PO,不要手动修改
 *
 */
package com.sandrew.bootsec.bean;

import com.sandrew.bury.annotations.ColumnName;
import com.sandrew.bury.annotations.TableName;
import com.sandrew.bury.bean.PO;

import java.util.Date;

@TableName("ti_appointment_temp")
public class AppointmentTempDTO extends PO
{
    @ColumnName(value = "temp_id", isPK = true, autoIncrement = true)
    private Integer tempId;

    @ColumnName(value = "cpdm", isPK = false, autoIncrement = false)
    private String cpdm;

    @ColumnName(value = "xsr", isPK = false, autoIncrement = false)
    private Integer xsr;

    @ColumnName(value = "xsrxm", isPK = false, autoIncrement = false)
    private String xsrxm;

    @ColumnName(value = "org_id", isPK = false, autoIncrement = false)
    private Integer orgId;

    @ColumnName(value = "org_name", isPK = false, autoIncrement = false)
    private String orgName;

    @ColumnName(value = "khid", isPK = false, autoIncrement = false)
    private String khid;

    @ColumnName(value = "xm", isPK = false, autoIncrement = false)
    private String xm;

    @ColumnName(value = "khorgid", isPK = false, autoIncrement = false)
    private String khorgid;

    @ColumnName(value = "khorgmc", isPK = false, autoIncrement = false)
    private String khorgmc;

    @ColumnName(value = "kh_mobile", isPK = false, autoIncrement = false)
    private String khMobile;

    @ColumnName(value = "kh_card_no", isPK = false, autoIncrement = false)
    private String khCardNo;

    @ColumnName(value = "data_biz_date", isPK = false, autoIncrement = false)
    private String dataBizDate;

    @ColumnName(value = "status", isPK = false, autoIncrement = false)
    private Integer status;

    @ColumnName(value = "create_date", isPK = false, autoIncrement = false)
    private Date createDate;

    public String getKhCardNo() {
        return khCardNo;
    }

    public void setKhCardNo(String khCardNo) {
        this.khCardNo = khCardNo;
    }

    public Integer getTempId() {
        return tempId;
    }

    public void setTempId(Integer tempId) {
        this.tempId = tempId;
    }

    public String getCpdm() {
        return cpdm;
    }

    public void setCpdm(String cpdm) {
        this.cpdm = cpdm;
    }

    public Integer getXsr() {
        return xsr;
    }

    public void setXsr(Integer xsr) {
        this.xsr = xsr;
    }

    public String getXsrxm() {
        return xsrxm;
    }

    public void setXsrxm(String xsrxm) {
        this.xsrxm = xsrxm;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getKhid() {
        return khid;
    }

    public void setKhid(String khid) {
        this.khid = khid;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getKhorgid()
    {
        return khorgid;
    }

    public void setKhorgid(String khorgid)
    {
        this.khorgid = khorgid;
    }

    public String getKhorgmc() {
        return khorgmc;
    }

    public void setKhorgmc(String khorgmc) {
        this.khorgmc = khorgmc;
    }

    public String getKhMobile()
    {
        return khMobile;
    }

    public void setKhMobile(String khMobile)
    {
        this.khMobile = khMobile;
    }

    public String getDataBizDate() {
        return dataBizDate;
    }

    public void setDataBizDate(String dataBizDate) {
        this.dataBizDate = dataBizDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}