package com.briup.apps.poll.dao;

import com.briup.apps.poll.bean.Options;
import com.briup.apps.poll.bean.OptionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OptionsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_options
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    long countByExample(OptionsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_options
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    int deleteByExample(OptionsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_options
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_options
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    int insert(Options record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_options
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    int insertSelective(Options record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_options
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    List<Options> selectByExampleWithBLOBs(OptionsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_options
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    List<Options> selectByExample(OptionsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_options
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    Options selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_options
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    int updateByExampleSelective(@Param("record") Options record, @Param("example") OptionsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_options
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    int updateByExampleWithBLOBs(@Param("record") Options record, @Param("example") OptionsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_options
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    int updateByExample(@Param("record") Options record, @Param("example") OptionsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_options
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    int updateByPrimaryKeySelective(Options record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_options
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    int updateByPrimaryKeyWithBLOBs(Options record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_options
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    int updateByPrimaryKey(Options record);
}