package com.sandrew.boot.mapper;

import com.sandrew.boot.model.TrRoleFuncFront;
import com.sandrew.boot.model.TrRoleFuncFrontExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TrRoleFuncFrontMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_role_func_front
     *
     * @mbg.generated Sun Feb 02 18:57:45 CST 2020
     */
    long countByExample(TrRoleFuncFrontExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_role_func_front
     *
     * @mbg.generated Sun Feb 02 18:57:45 CST 2020
     */
    int deleteByExample(TrRoleFuncFrontExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_role_func_front
     *
     * @mbg.generated Sun Feb 02 18:57:45 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_role_func_front
     *
     * @mbg.generated Sun Feb 02 18:57:45 CST 2020
     */
    int insert(TrRoleFuncFront record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_role_func_front
     *
     * @mbg.generated Sun Feb 02 18:57:45 CST 2020
     */
    int insertSelective(TrRoleFuncFront record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_role_func_front
     *
     * @mbg.generated Sun Feb 02 18:57:45 CST 2020
     */
    List<TrRoleFuncFront> selectByExample(TrRoleFuncFrontExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_role_func_front
     *
     * @mbg.generated Sun Feb 02 18:57:45 CST 2020
     */
    TrRoleFuncFront selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_role_func_front
     *
     * @mbg.generated Sun Feb 02 18:57:45 CST 2020
     */
    int updateByExampleSelective(@Param("record") TrRoleFuncFront record, @Param("example") TrRoleFuncFrontExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_role_func_front
     *
     * @mbg.generated Sun Feb 02 18:57:45 CST 2020
     */
    int updateByExample(@Param("record") TrRoleFuncFront record, @Param("example") TrRoleFuncFrontExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_role_func_front
     *
     * @mbg.generated Sun Feb 02 18:57:45 CST 2020
     */
    int updateByPrimaryKeySelective(TrRoleFuncFront record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_role_func_front
     *
     * @mbg.generated Sun Feb 02 18:57:45 CST 2020
     */
    int updateByPrimaryKey(TrRoleFuncFront record);
}