package com.briup.apps.poll.dao;

import com.briup.apps.poll.bean.Grade;
import com.briup.apps.poll.bean.GradeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GradeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_grade
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    long countByExample(GradeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_grade
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    int deleteByExample(GradeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_grade
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_grade
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    int insert(Grade record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_grade
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    int insertSelective(Grade record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_grade
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    List<Grade> selectByExampleWithBLOBs(GradeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_grade
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    List<Grade> selectByExample(GradeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_grade
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    Grade selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_grade
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    int updateByExampleSelective(@Param("record") Grade record, @Param("example") GradeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_grade
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    int updateByExampleWithBLOBs(@Param("record") Grade record, @Param("example") GradeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_grade
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    int updateByExample(@Param("record") Grade record, @Param("example") GradeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_grade
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    int updateByPrimaryKeySelective(Grade record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_grade
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    int updateByPrimaryKeyWithBLOBs(Grade record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_grade
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    int updateByPrimaryKey(Grade record);
}