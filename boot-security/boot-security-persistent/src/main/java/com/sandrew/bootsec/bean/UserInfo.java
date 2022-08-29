package com.sandrew.bootsec.bean;

import com.sandrew.bury.bean.PO;

public class UserInfo extends PO
{
    private Integer userId;

    private String userCode;

    private String userName;

    private Integer roleId;

    private String roleName;

    private String roleCode;

    private Integer sex;

    private String phone;

    private String mobile;

    private String email;

    private String avatarPath;

    private Integer isLogin;

    private String cardType;

    private String cardNo;

    private String itoAccount;

    private String itoToken;

    private Integer isRealAuth;

    private Integer isBindMobile;

    private Integer IsEnsureAgreement;

    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public String getUserCode()
    {
        return userCode;
    }

    public void setUserCode(String userCode)
    {
        this.userCode = userCode;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public Integer getRoleId()
    {
        return roleId;
    }

    public void setRoleId(Integer roleId)
    {
        this.roleId = roleId;
    }

    public String getRoleName()
    {
        return roleName;
    }

    public void setRoleName(String roleName)
    {
        this.roleName = roleName;
    }

    public String getRoleCode()
    {
        return roleCode;
    }

    public void setRoleCode(String roleCode)
    {
        this.roleCode = roleCode;
    }

    public Integer getSex()
    {
        return sex;
    }

    public void setSex(Integer sex)
    {
        this.sex = sex;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getMobile()
    {
        return mobile;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getAvatarPath()
    {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath)
    {
        this.avatarPath = avatarPath;
    }

    public Integer getIsLogin()
    {
        return isLogin;
    }

    public void setIsLogin(Integer isLogin)
    {
        this.isLogin = isLogin;
    }

    public String getCardType()
    {
        return cardType;
    }

    public void setCardType(String cardType)
    {
        this.cardType = cardType;
    }

    public String getCardNo()
    {
        return cardNo;
    }

    public void setCardNo(String cardNo)
    {
        this.cardNo = cardNo;
    }

    public String getItoAccount()
    {
        return itoAccount;
    }

    public void setItoAccount(String itoAccount)
    {
        this.itoAccount = itoAccount;
    }

    public String getItoToken()
    {
        return itoToken;
    }

    public void setItoToken(String itoToken)
    {
        this.itoToken = itoToken;
    }

    public Integer getIsRealAuth()
    {
        return isRealAuth;
    }

    public void setIsRealAuth(Integer isRealAuth)
    {
        this.isRealAuth = isRealAuth;
    }

    public Integer getIsBindMobile()
    {
        return isBindMobile;
    }

    public void setIsBindMobile(Integer isBindMobile)
    {
        this.isBindMobile = isBindMobile;
    }

    public Integer getIsEnsureAgreement()
    {
        return IsEnsureAgreement;
    }

    public void setIsEnsureAgreement(Integer isEnsureAgreement)
    {
        IsEnsureAgreement = isEnsureAgreement;
    }
}
