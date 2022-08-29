package com.sandrew.bootcas.mapper;

import com.sandrew.bootcas.model.TtSessionPO;
import com.sandrew.bootcas.model.TtSessionPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TtSessionPOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tt_session
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    long countByExample(TtSessionPOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tt_session
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    int deleteByExample(TtSessionPOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tt_session
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    int deleteByPrimaryKey(String sessionId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tt_session
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    int insert(TtSessionPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tt_session
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    int insertSelective(TtSessionPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tt_session
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    List<TtSessionPO> selectByExampleWithBLOBs(TtSessionPOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tt_session
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    List<TtSessionPO> selectByExample(TtSessionPOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tt_session
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    TtSessionPO selectByPrimaryKey(String sessionId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tt_session
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    int updateByExampleSelective(@Param("record") TtSessionPO record, @Param("example") TtSessionPOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tt_session
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    int updateByExampleWithBLOBs(@Param("record") TtSessionPO record, @Param("example") TtSessionPOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tt_session
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    int updateByExample(@Param("record") TtSessionPO record, @Param("example") TtSessionPOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tt_session
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    int updateByPrimaryKeySelective(TtSessionPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tt_session
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    int updateByPrimaryKeyWithBLOBs(TtSessionPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tt_session
     *
     * @mbg.generated Tue Jul 28 14:06:48 CST 2020
     */
    int updateByPrimaryKey(TtSessionPO record);
}