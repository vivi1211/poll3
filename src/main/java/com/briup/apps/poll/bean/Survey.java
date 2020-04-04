package com.briup.apps.poll.bean;

public class Survey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poll_survey.id
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poll_survey.status
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    private String status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poll_survey.code
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    private String code;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poll_survey.surveyDate
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    private String surveydate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poll_survey.course_id
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    private Long courseId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poll_survey.clazz_id
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    private Long clazzId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poll_survey.user_id
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    private Long userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poll_survey.questionnaire_id
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    private Long questionnaireId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poll_survey.id
     *
     * @return the value of poll_survey.id
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poll_survey.id
     *
     * @param id the value for poll_survey.id
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poll_survey.status
     *
     * @return the value of poll_survey.status
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poll_survey.status
     *
     * @param status the value for poll_survey.status
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poll_survey.code
     *
     * @return the value of poll_survey.code
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poll_survey.code
     *
     * @param code the value for poll_survey.code
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poll_survey.surveyDate
     *
     * @return the value of poll_survey.surveyDate
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    public String getSurveydate() {
        return surveydate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poll_survey.surveyDate
     *
     * @param surveydate the value for poll_survey.surveyDate
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    public void setSurveydate(String surveydate) {
        this.surveydate = surveydate == null ? null : surveydate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poll_survey.course_id
     *
     * @return the value of poll_survey.course_id
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    public Long getCourseId() {
        return courseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poll_survey.course_id
     *
     * @param courseId the value for poll_survey.course_id
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poll_survey.clazz_id
     *
     * @return the value of poll_survey.clazz_id
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    public Long getClazzId() {
        return clazzId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poll_survey.clazz_id
     *
     * @param clazzId the value for poll_survey.clazz_id
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    public void setClazzId(Long clazzId) {
        this.clazzId = clazzId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poll_survey.user_id
     *
     * @return the value of poll_survey.user_id
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poll_survey.user_id
     *
     * @param userId the value for poll_survey.user_id
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poll_survey.questionnaire_id
     *
     * @return the value of poll_survey.questionnaire_id
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    public Long getQuestionnaireId() {
        return questionnaireId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poll_survey.questionnaire_id
     *
     * @param questionnaireId the value for poll_survey.questionnaire_id
     *
     * @mbg.generated Thu Apr 02 23:41:33 CST 2020
     */
    public void setQuestionnaireId(Long questionnaireId) {
        this.questionnaireId = questionnaireId;
    }
}