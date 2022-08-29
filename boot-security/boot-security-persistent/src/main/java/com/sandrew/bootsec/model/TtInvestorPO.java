/** 自动生成的PO,不要手动修改 */
package com.sandrew.bootsec.model;

import com.sandrew.bury.annotations.ColumnName;
import com.sandrew.bury.annotations.TableName;
import com.sandrew.bury.bean.EqualPack;
import com.sandrew.bury.bean.PO;
import com.sandrew.bury.bean.Pack;

import java.util.Date;

@TableName("tt_investor")
public class TtInvestorPO extends PO {

  public TtInvestorPO() {}

  public TtInvestorPO(Integer investorId) {
    if (null == this.investorId) {
      this.investorId = new EqualPack<Integer>();
    }
    this.investorId.setValue(investorId);
  }

  @ColumnName(value = "investor_id", isPK = true, autoIncrement = true)
  private Pack<Integer> investorId;

  @ColumnName(value = "biz_id", isPK = false, autoIncrement = false)
  private Pack<String> bizId;

  @ColumnName(value = "name", isPK = false, autoIncrement = false)
  private Pack<String> name;

  @ColumnName(value = "mobile", isPK = false, autoIncrement = false)
  private Pack<String> mobile;

  @ColumnName(value = "card_type", isPK = false, autoIncrement = false)
  private Pack<Integer> cardType;

  @ColumnName(value = "card_no", isPK = false, autoIncrement = false)
  private Pack<String> cardNo;

  @ColumnName(value = "investor_no", isPK = false, autoIncrement = false)
  private Pack<String> investorNo;

  @ColumnName(value = "register_time", isPK = false, autoIncrement = false)
  private Pack<Date> registerTime;

  @ColumnName(value = "ito_account", isPK = false, autoIncrement = false)
  private Pack<String> itoAccount;

  @ColumnName(value = "ito_token", isPK = false, autoIncrement = false)
  private Pack<String> itoToken;

  @ColumnName(value = "status", isPK = false, autoIncrement = false)
  private Pack<Integer> status;

  @ColumnName(value = "is_delete", isPK = false, autoIncrement = false)
  private Pack<Integer> isDelete;

  @ColumnName(value = "create_by", isPK = false, autoIncrement = false)
  private Pack<Integer> createBy;

  @ColumnName(value = "create_date", isPK = false, autoIncrement = false)
  private Pack<Date> createDate;

  @ColumnName(value = "update_by", isPK = false, autoIncrement = false)
  private Pack<Integer> updateBy;

  @ColumnName(value = "update_date", isPK = false, autoIncrement = false)
  private Pack<Date> updateDate;

  public void setInvestorId(Integer investorId) {
    if (null == this.investorId) {
      this.investorId = new EqualPack<Integer>();
    }
    this.investorId.setValue(investorId);
  }

  public void setInvestorId(Pack<Integer> investorId) {
    this.investorId = investorId;
  }

  public Integer getInvestorId() {
    return this.investorId == null ? null : this.investorId.getValue();
  }

  public void setBizId(String bizId) {
    if (null == this.bizId) {
      this.bizId = new EqualPack<String>();
    }
    this.bizId.setValue(bizId);
  }

  public void setBizId(Pack<String> bizId) {
    this.bizId = bizId;
  }

  public String getBizId() {
    return this.bizId == null ? null : this.bizId.getValue();
  }

  public void setName(String name) {
    if (null == this.name) {
      this.name = new EqualPack<String>();
    }
    this.name.setValue(name);
  }

  public void setName(Pack<String> name) {
    this.name = name;
  }

  public String getName() {
    return this.name == null ? null : this.name.getValue();
  }

  public void setMobile(String mobile) {
    if (null == this.mobile) {
      this.mobile = new EqualPack<String>();
    }
    this.mobile.setValue(mobile);
  }

  public void setMobile(Pack<String> mobile) {
    this.mobile = mobile;
  }

  public String getMobile() {
    return this.mobile == null ? null : this.mobile.getValue();
  }

  public void setCardType(Integer cardType) {
    if (null == this.cardType) {
      this.cardType = new EqualPack<Integer>();
    }
    this.cardType.setValue(cardType);
  }

  public void setCardType(Pack<Integer> cardType) {
    this.cardType = cardType;
  }

  public Integer getCardType() {
    return this.cardType == null ? null : this.cardType.getValue();
  }

  public void setCardNo(String cardNo) {
    if (null == this.cardNo) {
      this.cardNo = new EqualPack<String>();
    }
    this.cardNo.setValue(cardNo);
  }

  public void setCardNo(Pack<String> cardNo) {
    this.cardNo = cardNo;
  }

  public String getCardNo() {
    return this.cardNo == null ? null : this.cardNo.getValue();
  }

  public void setInvestorNo(String investorNo) {
    if (null == this.investorNo) {
      this.investorNo = new EqualPack<String>();
    }
    this.investorNo.setValue(investorNo);
  }

  public void setInvestorNo(Pack<String> investorNo) {
    this.investorNo = investorNo;
  }

  public String getInvestorNo() {
    return this.investorNo == null ? null : this.investorNo.getValue();
  }

  public void setRegisterTime(Date registerTime) {
    if (null == this.registerTime) {
      this.registerTime = new EqualPack<Date>();
    }
    this.registerTime.setValue(registerTime);
  }

  public void setRegisterTime(Pack<Date> registerTime) {
    this.registerTime = registerTime;
  }

  public Date getRegisterTime() {
    return this.registerTime == null ? null : this.registerTime.getValue();
  }

  public void setItoAccount(String itoAccount) {
    if (null == this.itoAccount) {
      this.itoAccount = new EqualPack<String>();
    }
    this.itoAccount.setValue(itoAccount);
  }

  public void setItoAccount(Pack<String> itoAccount) {
    this.itoAccount = itoAccount;
  }

  public String getItoAccount() {
    return this.itoAccount == null ? null : this.itoAccount.getValue();
  }

  public void setItoToken(String itoToken) {
    if (null == this.itoToken) {
      this.itoToken = new EqualPack<String>();
    }
    this.itoToken.setValue(itoToken);
  }

  public void setItoToken(Pack<String> itoToken) {
    this.itoToken = itoToken;
  }

  public String getItoToken() {
    return this.itoToken == null ? null : this.itoToken.getValue();
  }

  public void setStatus(Integer status) {
    if (null == this.status) {
      this.status = new EqualPack<Integer>();
    }
    this.status.setValue(status);
  }

  public void setStatus(Pack<Integer> status) {
    this.status = status;
  }

  public Integer getStatus() {
    return this.status == null ? null : this.status.getValue();
  }

  public void setIsDelete(Integer isDelete) {
    if (null == this.isDelete) {
      this.isDelete = new EqualPack<Integer>();
    }
    this.isDelete.setValue(isDelete);
  }

  public void setIsDelete(Pack<Integer> isDelete) {
    this.isDelete = isDelete;
  }

  public Integer getIsDelete() {
    return this.isDelete == null ? null : this.isDelete.getValue();
  }

  public void setCreateBy(Integer createBy) {
    if (null == this.createBy) {
      this.createBy = new EqualPack<Integer>();
    }
    this.createBy.setValue(createBy);
  }

  public void setCreateBy(Pack<Integer> createBy) {
    this.createBy = createBy;
  }

  public Integer getCreateBy() {
    return this.createBy == null ? null : this.createBy.getValue();
  }

  public void setCreateDate(Date createDate) {
    if (null == this.createDate) {
      this.createDate = new EqualPack<Date>();
    }
    this.createDate.setValue(createDate);
  }

  public void setCreateDate(Pack<Date> createDate) {
    this.createDate = createDate;
  }

  public Date getCreateDate() {
    return this.createDate == null ? null : this.createDate.getValue();
  }

  public void setUpdateBy(Integer updateBy) {
    if (null == this.updateBy) {
      this.updateBy = new EqualPack<Integer>();
    }
    this.updateBy.setValue(updateBy);
  }

  public void setUpdateBy(Pack<Integer> updateBy) {
    this.updateBy = updateBy;
  }

  public Integer getUpdateBy() {
    return this.updateBy == null ? null : this.updateBy.getValue();
  }

  public void setUpdateDate(Date updateDate) {
    if (null == this.updateDate) {
      this.updateDate = new EqualPack<Date>();
    }
    this.updateDate.setValue(updateDate);
  }

  public void setUpdateDate(Pack<Date> updateDate) {
    this.updateDate = updateDate;
  }

  public Date getUpdateDate() {
    return this.updateDate == null ? null : this.updateDate.getValue();
  }
}
