package com.linkquest.lhq.database;

public class SurveyForm {
    private int id;
    private String surveytype;
    private String customer;
    private String operator;
    private String circle;
    private String technology;
    private String technologytype;
    private String location;
    private String siteid;
    private String date;
    private String lat;
    private String log;
    private int flag;

    public SurveyForm() {

    }

    public SurveyForm(String surveytype, String customer, String operator, String circle, String technology, String technologytype, String location, String siteid, String date,String lat,String log, int flag) {
        this.surveytype = surveytype;
        this.customer = customer;
        this.operator = operator;
        this.circle = circle;
        this.technology = technology;
        this.technologytype = technologytype;
        this.location = location;
        this.siteid = siteid;
        this.date = date;
        this.lat = lat;
        this.log = log;
        this.flag = flag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurveytype() {
        return surveytype;
    }

    public void setSurveytype(String surveytype) {
        this.surveytype = surveytype;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getCircle() {
        return circle;
    }

    public void setCircle(String circle) {
        this.circle = circle;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getTechnologytype() {
        return technologytype;
    }

    public void setTechnologytype(String technologytype) {
        this.technologytype = technologytype;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSiteid() {
        return siteid;
    }

    public void setSiteid(String siteid) {
        this.siteid = siteid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
