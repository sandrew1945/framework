package com.sandrew.boot.mapper;

import com.sandrew.boot.model.TrRoleFuncPO;
import com.sandrew.boot.model.TrRoleFuncPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TrRoleFuncPOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_role_func
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    long countByExample(TrRoleFuncPOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_role_func
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    int deleteByExample(TrRoleFuncPOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_role_func
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_role_func
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    int insert(TrRoleFuncPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_role_func
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    int insertSelective(TrRoleFuncPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_role_func
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    List<TrRoleFuncPO> selectByExample(TrRoleFuncPOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_role_func
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    TrRoleFuncPO selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_role_func
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    int updateByExampleSelective(@Param("record") TrRoleFuncPO record, @Param("example") TrRoleFuncPOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_role_func
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    int updateByExample(@Param("record") TrRoleFuncPO record, @Param("example") TrRoleFuncPOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_role_func
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    int updateByPrimaryKeySelective(TrRoleFuncPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_role_func
     *
     * @mbg.generated Mon Oct 29 13:03:11 CST 2018
     */
    int updateByPrimaryKey(TrRoleFuncPO record);
}