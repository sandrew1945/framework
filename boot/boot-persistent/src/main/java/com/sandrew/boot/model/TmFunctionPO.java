package com.sandrew.boot.model;

import java.io.Serializable;
import java.util.Date;

public class TmFunctionPO implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_function.function_id
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    private Integer functionId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_function.function_code
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    private String functionCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_function.function_name
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    private String functionName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_function.father_func
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    private Integer fatherFunc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_function.function_type
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    private Integer functionType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_function.function_status
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    private Integer functionStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_function.access_url
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    private String accessUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_function.function_order
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    private Integer functionOrder;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_function.icon
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    private String icon;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_function.is_delete
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    private Integer isDelete;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_function.create_by
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    private Integer createBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_function.create_date
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    private Date createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_function.update_by
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    private Integer updateBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_function.update_date
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    private Date updateDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tm_function
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_function.function_id
     *
     * @return the value of tm_function.function_id
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    public Integer getFunctionId() {
        return functionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_function.function_id
     *
     * @param functionId the value for tm_function.function_id
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_function.function_code
     *
     * @return the value of tm_function.function_code
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    public String getFunctionCode() {
        return functionCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_function.function_code
     *
     * @param functionCode the value for tm_function.function_code
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    public void setFunctionCode(String functionCode) {
        this.functionCode = functionCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_function.function_name
     *
     * @return the value of tm_function.function_name
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    public String getFunctionName() {
        return functionName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_function.function_name
     *
     * @param functionName the value for tm_function.function_name
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_function.father_func
     *
     * @return the value of tm_function.father_func
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    public Integer getFatherFunc() {
        return fatherFunc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_function.father_func
     *
     * @param fatherFunc the value for tm_function.father_func
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    public void setFatherFunc(Integer fatherFunc) {
        this.fatherFunc = fatherFunc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_function.function_type
     *
     * @return the value of tm_function.function_type
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    public Integer getFunctionType() {
        return functionType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_function.function_type
     *
     * @param functionType the value for tm_function.function_type
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    public void setFunctionType(Integer functionType) {
        this.functionType = functionType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_function.function_status
     *
     * @return the value of tm_function.function_status
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    public Integer getFunctionStatus() {
        return functionStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_function.function_status
     *
     * @param functionStatus the value for tm_function.function_status
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    public void setFunctionStatus(Integer functionStatus) {
        this.functionStatus = functionStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_function.access_url
     *
     * @return the value of tm_function.access_url
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    public String getAccessUrl() {
        return accessUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_function.access_url
     *
     * @param accessUrl the value for tm_function.access_url
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    public void setAccessUrl(String accessUrl) {
        this.accessUrl = accessUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_function.function_order
     *
     * @return the value of tm_function.function_order
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    public Integer getFunctionOrder() {
        return functionOrder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_function.function_order
     *
     * @param functionOrder the value for tm_function.function_order
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    public void setFunctionOrder(Integer functionOrder) {
        this.functionOrder = functionOrder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_function.icon
     *
     * @return the value of tm_function.icon
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    public String getIcon() {
        return icon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_function.icon
     *
     * @param icon the value for tm_function.icon
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_function.is_delete
     *
     * @return the value of tm_function.is_delete
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_function.is_delete
     *
     * @param isDelete the value for tm_function.is_delete
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_function.create_by
     *
     * @return the value of tm_function.create_by
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_function.create_by
     *
     * @param createBy the value for tm_function.create_by
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_function.create_date
     *
     * @return the value of tm_function.create_date
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_function.create_date
     *
     * @param createDate the value for tm_function.create_date
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_function.update_by
     *
     * @return the value of tm_function.update_by
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    public Integer getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_function.update_by
     *
     * @param updateBy the value for tm_function.update_by
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_function.update_date
     *
     * @return the value of tm_function.update_date
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_function.update_date
     *
     * @param updateDate the value for tm_function.update_date
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}