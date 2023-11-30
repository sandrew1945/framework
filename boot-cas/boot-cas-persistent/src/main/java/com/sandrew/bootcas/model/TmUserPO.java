package com.sandrew.bootcas.model;

import java.io.Serializable;
import java.util.Date;

public class TmUserPO implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_user.user_id
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_user.user_code
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    private String userCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_user.user_name
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    private String userName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_user.password
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_user.sex
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    private Integer sex;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_user.phone
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    private String phone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_user.mobile
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    private String mobile;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_user.email
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_user.birthday
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    private Date birthday;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_user.avatar
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    private String avatar;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_user.user_type
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    private Integer userType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_user.user_status
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    private Integer userStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_user.is_delete
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    private Integer isDelete;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_user.create_date
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    private Date createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_user.create_by
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    private Integer createBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_user.update_date
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    private Date updateDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_user.update_by
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    private Integer updateBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tm_user
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_user.user_id
     *
     * @return the value of tm_user.user_id
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_user.user_id
     *
     * @param userId the value for tm_user.user_id
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_user.user_code
     *
     * @return the value of tm_user.user_code
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    public String getUserCode() {
        return userCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_user.user_code
     *
     * @param userCode the value for tm_user.user_code
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_user.user_name
     *
     * @return the value of tm_user.user_name
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_user.user_name
     *
     * @param userName the value for tm_user.user_name
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_user.password
     *
     * @return the value of tm_user.password
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_user.password
     *
     * @param password the value for tm_user.password
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_user.sex
     *
     * @return the value of tm_user.sex
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_user.sex
     *
     * @param sex the value for tm_user.sex
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_user.phone
     *
     * @return the value of tm_user.phone
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_user.phone
     *
     * @param phone the value for tm_user.phone
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_user.mobile
     *
     * @return the value of tm_user.mobile
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_user.mobile
     *
     * @param mobile the value for tm_user.mobile
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_user.email
     *
     * @return the value of tm_user.email
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_user.email
     *
     * @param email the value for tm_user.email
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_user.birthday
     *
     * @return the value of tm_user.birthday
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_user.birthday
     *
     * @param birthday the value for tm_user.birthday
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_user.avatar
     *
     * @return the value of tm_user.avatar
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_user.avatar
     *
     * @param avatar the value for tm_user.avatar
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_user.user_type
     *
     * @return the value of tm_user.user_type
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    public Integer getUserType() {
        return userType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_user.user_type
     *
     * @param userType the value for tm_user.user_type
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_user.user_status
     *
     * @return the value of tm_user.user_status
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    public Integer getUserStatus() {
        return userStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_user.user_status
     *
     * @param userStatus the value for tm_user.user_status
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_user.is_delete
     *
     * @return the value of tm_user.is_delete
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_user.is_delete
     *
     * @param isDelete the value for tm_user.is_delete
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_user.create_date
     *
     * @return the value of tm_user.create_date
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_user.create_date
     *
     * @param createDate the value for tm_user.create_date
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_user.create_by
     *
     * @return the value of tm_user.create_by
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_user.create_by
     *
     * @param createBy the value for tm_user.create_by
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_user.update_date
     *
     * @return the value of tm_user.update_date
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_user.update_date
     *
     * @param updateDate the value for tm_user.update_date
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_user.update_by
     *
     * @return the value of tm_user.update_by
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    public Integer getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_user.update_by
     *
     * @param updateBy the value for tm_user.update_by
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }
}