package com.sandrew.bootcas.mapper;

import com.sandrew.bootcas.model.TrRoleFuncPO;
import com.sandrew.bootcas.model.TrRoleFuncPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TrRoleFuncPOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_role_func
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    long countByExample(TrRoleFuncPOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_role_func
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    int deleteByExample(TrRoleFuncPOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_role_func
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_role_func
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    int insert(TrRoleFuncPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_role_func
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    int insertSelective(TrRoleFuncPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_role_func
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    List<TrRoleFuncPO> selectByExample(TrRoleFuncPOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_role_func
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    TrRoleFuncPO selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_role_func
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    int updateByExampleSelective(@Param("record") TrRoleFuncPO record, @Param("example") TrRoleFuncPOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_role_func
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    int updateByExample(@Param("record") TrRoleFuncPO record, @Param("example") TrRoleFuncPOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_role_func
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    int updateByPrimaryKeySelective(TrRoleFuncPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_role_func
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    int updateByPrimaryKey(TrRoleFuncPO record);
}