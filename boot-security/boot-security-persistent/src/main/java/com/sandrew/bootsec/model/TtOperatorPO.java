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

@TableName("tt_operator")
public class TtOperatorPO extends PO
{

    public TtOperatorPO()
    {
    }


                                                                                
    public TtOperatorPO(Integer operatorId)
    {
        if (null == this.operatorId)
        {
            this.operatorId = new EqualPack<Integer>();
        }
        this.operatorId.setValue(operatorId);
    }

    @ColumnName(value = "operator_id", isPK = true, autoIncrement = true)
    private Pack<Integer> operatorId;

    @ColumnName(value = "card_type", isPK = false, autoIncrement = false)
    private Pack<String> cardType;

    @ColumnName(value = "card_no", isPK = false, autoIncrement = false)
    private Pack<String> cardNo;

    @ColumnName(value = "operator_name", isPK = false, autoIncrement = false)
    private Pack<String> operatorName;

    @ColumnName(value = "operator_no", isPK = false, autoIncrement = false)
    private Pack<String> operatorNo;

    @ColumnName(value = "is_sign", isPK = false, autoIncrement = false)
    private Pack<Integer> isSign;

    @ColumnName(value = "reg_time", isPK = false, autoIncrement = false)
    private Pack<Date> regTime;

    @ColumnName(value = "ito_account", isPK = false, autoIncrement = false)
    private Pack<String> itoAccount;

    @ColumnName(value = "ito_token", isPK = false, autoIncrement = false)
    private Pack<String> itoToken;

    @ColumnName(value = "is_real_auth", isPK = false, autoIncrement = false)
    private Pack<Integer> isRealAuth;

    @ColumnName(value = "real_auth_time", isPK = false, autoIncrement = false)
    private Pack<Date> realAuthTime;

    @ColumnName(value = "is_bind_mobile", isPK = false, autoIncrement = false)
    private Pack<Integer> isBindMobile;

    @ColumnName(value = "is_ensure_agreement", isPK = false, autoIncrement = false)
    private Pack<Integer> isEnsureAgreement;

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

    public void setCardType(String cardType)
    {
        if (null == this.cardType)
        {
            this.cardType = new EqualPack<String>();
        }
        this.cardType.setValue(cardType);
    }

    public void setCardType(Pack<String> cardType)
    {
        this.cardType = cardType;
    }
        
    public String getCardType()
    {
        return this.cardType == null ? null : this.cardType.getValue();
    }

    public void setCardNo(String cardNo)
    {
        if (null == this.cardNo)
        {
            this.cardNo = new EqualPack<String>();
        }
        this.cardNo.setValue(cardNo);
    }

    public void setCardNo(Pack<String> cardNo)
    {
        this.cardNo = cardNo;
    }
        
    public String getCardNo()
    {
        return this.cardNo == null ? null : this.cardNo.getValue();
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

    public void setOperatorNo(String operatorNo)
    {
        if (null == this.operatorNo)
        {
            this.operatorNo = new EqualPack<String>();
        }
        this.operatorNo.setValue(operatorNo);
    }

    public void setOperatorNo(Pack<String> operatorNo)
    {
        this.operatorNo = operatorNo;
    }
        
    public String getOperatorNo()
    {
        return this.operatorNo == null ? null : this.operatorNo.getValue();
    }

    public void setIsSign(Integer isSign)
    {
        if (null == this.isSign)
        {
            this.isSign = new EqualPack<Integer>();
        }
        this.isSign.setValue(isSign);
    }

    public void setIsSign(Pack<Integer> isSign)
    {
        this.isSign = isSign;
    }
        
    public Integer getIsSign()
    {
        return this.isSign == null ? null : this.isSign.getValue();
    }

    public void setRegTime(Date regTime)
    {
        if (null == this.regTime)
        {
            this.regTime = new EqualPack<Date>();
        }
        this.regTime.setValue(regTime);
    }

    public void setRegTime(Pack<Date> regTime)
    {
        this.regTime = regTime;
    }
        
    public Date getRegTime()
    {
        return this.regTime == null ? null : this.regTime.getValue();
    }

    public void setItoAccount(String itoAccount)
    {
        if (null == this.itoAccount)
        {
            this.itoAccount = new EqualPack<String>();
        }
        this.itoAccount.setValue(itoAccount);
    }

    public void setItoAccount(Pack<String> itoAccount)
    {
        this.itoAccount = itoAccount;
    }
        
    public String getItoAccount()
    {
        return this.itoAccount == null ? null : this.itoAccount.getValue();
    }

    public void setItoToken(String itoToken)
    {
        if (null == this.itoToken)
        {
            this.itoToken = new EqualPack<String>();
        }
        this.itoToken.setValue(itoToken);
    }

    public void setItoToken(Pack<String> itoToken)
    {
        this.itoToken = itoToken;
    }
        
    public String getItoToken()
    {
        return this.itoToken == null ? null : this.itoToken.getValue();
    }

    public void setIsRealAuth(Integer isRealAuth)
    {
        if (null == this.isRealAuth)
        {
            this.isRealAuth = new EqualPack<Integer>();
        }
        this.isRealAuth.setValue(isRealAuth);
    }

    public void setIsRealAuth(Pack<Integer> isRealAuth)
    {
        this.isRealAuth = isRealAuth;
    }
        
    public Integer getIsRealAuth()
    {
        return this.isRealAuth == null ? null : this.isRealAuth.getValue();
    }

    public void setRealAuthTime(Date realAuthTime)
    {
        if (null == this.realAuthTime)
        {
            this.realAuthTime = new EqualPack<Date>();
        }
        this.realAuthTime.setValue(realAuthTime);
    }

    public void setRealAuthTime(Pack<Date> realAuthTime)
    {
        this.realAuthTime = realAuthTime;
    }
        
    public Date getRealAuthTime()
    {
        return this.realAuthTime == null ? null : this.realAuthTime.getValue();
    }

    public void setIsBindMobile(Integer isBindMobile)
    {
        if (null == this.isBindMobile)
        {
            this.isBindMobile = new EqualPack<Integer>();
        }
        this.isBindMobile.setValue(isBindMobile);
    }

    public void setIsBindMobile(Pack<Integer> isBindMobile)
    {
        this.isBindMobile = isBindMobile;
    }
        
    public Integer getIsBindMobile()
    {
        return this.isBindMobile == null ? null : this.isBindMobile.getValue();
    }

    public void setIsEnsureAgreement(Integer isEnsureAgreement)
    {
        if (null == this.isEnsureAgreement)
        {
            this.isEnsureAgreement = new EqualPack<Integer>();
        }
        this.isEnsureAgreement.setValue(isEnsureAgreement);
    }

    public void setIsEnsureAgreement(Pack<Integer> isEnsureAgreement)
    {
        this.isEnsureAgreement = isEnsureAgreement;
    }
        
    public Integer getIsEnsureAgreement()
    {
        return this.isEnsureAgreement == null ? null : this.isEnsureAgreement.getValue();
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