package com.sandrew.mvc.model;

import java.util.Date;


public class TrFuncPromPO {

	private Integer id;

	private Integer roleFuncId;

	private Integer promissionId;

	private Integer createBy;

	private Date createDate;

	private Integer updateBy;

	private Date updateDate;


	public void setId(Integer id){
		this.id=id;
	}

	public Integer getId(){
		return id;
	}

	public void setRoleFuncId(Integer roleFuncId){
		this.roleFuncId=roleFuncId;
	}

	public Integer getRoleFuncId(){
		return roleFuncId;
	}

	public void setPromissionId(Integer promissionId){
		this.promissionId=promissionId;
	}

	public Integer getPromissionId(){
		return promissionId;
	}

	public void setCreateBy(Integer createBy){
		this.createBy=createBy;
	}

	public Integer getCreateBy(){
		return createBy;
	}

	public void setCreateDate(Date createDate){
		this.createDate=createDate;
	}

	public Date getCreateDate(){
		return createDate;
	}

	public void setUpdateBy(Integer updateBy){
		this.updateBy=updateBy;
	}

	public Integer getUpdateBy(){
		return updateBy;
	}

	public void setUpdateDate(Date updateDate){
		this.updateDate=updateDate;
	}

	public Date getUpdateDate(){
		return updateDate;
	}

}
