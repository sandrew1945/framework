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

@TableName("tm_app_version_log")
public class TmAppVersionLogPO extends PO
{

    public TmAppVersionLogPO()
    {
    }


                                    
    public TmAppVersionLogPO(Integer logId)
    {
        if (null == this.logId)
        {
            this.logId = new EqualPack<Integer>();
        }
        this.logId.setValue(logId);
    }

    @ColumnName(value = "log_id", isPK = true, autoIncrement = true)
    private Pack<Integer> logId;

    @ColumnName(value = "app_version", isPK = false, autoIncrement = false)
    private Pack<String> appVersion;

    @ColumnName(value = "aok_url", isPK = false, autoIncrement = false)
    private Pack<String> aokUrl;

    @ColumnName(value = "update_desc", isPK = false, autoIncrement = false)
    private Pack<String> updateDesc;

    @ColumnName(value = "is_force_update", isPK = false, autoIncrement = false)
    private Pack<Integer> isForceUpdate;

    @ColumnName(value = "is_update", isPK = false, autoIncrement = false)
    private Pack<Integer> isUpdate;

    @ColumnName(value = "create_date", isPK = false, autoIncrement = false)
    private Pack<Date> createDate;

    @ColumnName(value = "create_by", isPK = false, autoIncrement = false)
    private Pack<Integer> createBy;

    @ColumnName(value = "apk_size", isPK = false, autoIncrement = false)
    private Pack<Integer> apkSize;

    @ColumnName(value = "apk_md5", isPK = false, autoIncrement = false)
    private Pack<String> apkMd5;


    public void setLogId(Integer logId)
    {
        if (null == this.logId)
        {
            this.logId = new EqualPack<Integer>();
        }
        this.logId.setValue(logId);
    }

    public void setLogId(Pack<Integer> logId)
    {
        this.logId = logId;
    }
        
    public Integer getLogId()
    {
        return this.logId == null ? null : this.logId.getValue();
    }

    public void setAppVersion(String appVersion)
    {
        if (null == this.appVersion)
        {
            this.appVersion = new EqualPack<String>();
        }
        this.appVersion.setValue(appVersion);
    }

    public void setAppVersion(Pack<String> appVersion)
    {
        this.appVersion = appVersion;
    }
        
    public String getAppVersion()
    {
        return this.appVersion == null ? null : this.appVersion.getValue();
    }

    public void setAokUrl(String aokUrl)
    {
        if (null == this.aokUrl)
        {
            this.aokUrl = new EqualPack<String>();
        }
        this.aokUrl.setValue(aokUrl);
    }

    public void setAokUrl(Pack<String> aokUrl)
    {
        this.aokUrl = aokUrl;
    }
        
    public String getAokUrl()
    {
        return this.aokUrl == null ? null : this.aokUrl.getValue();
    }

    public void setUpdateDesc(String updateDesc)
    {
        if (null == this.updateDesc)
        {
            this.updateDesc = new EqualPack<String>();
        }
        this.updateDesc.setValue(updateDesc);
    }

    public void setUpdateDesc(Pack<String> updateDesc)
    {
        this.updateDesc = updateDesc;
    }
        
    public String getUpdateDesc()
    {
        return this.updateDesc == null ? null : this.updateDesc.getValue();
    }

    public void setIsForceUpdate(Integer isForceUpdate)
    {
        if (null == this.isForceUpdate)
        {
            this.isForceUpdate = new EqualPack<Integer>();
        }
        this.isForceUpdate.setValue(isForceUpdate);
    }

    public void setIsForceUpdate(Pack<Integer> isForceUpdate)
    {
        this.isForceUpdate = isForceUpdate;
    }
        
    public Integer getIsForceUpdate()
    {
        return this.isForceUpdate == null ? null : this.isForceUpdate.getValue();
    }

    public void setIsUpdate(Integer isUpdate)
    {
        if (null == this.isUpdate)
        {
            this.isUpdate = new EqualPack<Integer>();
        }
        this.isUpdate.setValue(isUpdate);
    }

    public void setIsUpdate(Pack<Integer> isUpdate)
    {
        this.isUpdate = isUpdate;
    }
        
    public Integer getIsUpdate()
    {
        return this.isUpdate == null ? null : this.isUpdate.getValue();
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

    public void setApkSize(Integer apkSize) {
        if (null == this.apkSize)
        {
            this.apkSize = new EqualPack<Integer>();
        }
        this.apkSize.setValue(apkSize);
    }

    public void setApkSize(Pack<Integer> apkSize) {
        this.apkSize = apkSize;
    }

    public Integer getApkSize() {
        return this.apkSize == null ? null : this.apkSize.getValue();
    }

    public void setApkMd5(String apkMd5) {
        if (null == this.apkMd5)

        {
            this.apkMd5 = new EqualPack<String>();
        }
        this.apkMd5.setValue(apkMd5);
    }

    public void setApkMd5(Pack<String> apkMd5) {
        this.apkMd5 = apkMd5;
    }

    public String getApkMd5() {
        return this.apkMd5 == null ? null : this.apkMd5.getValue();
    }


}