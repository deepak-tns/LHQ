package com.linkquest.lhq.database;

public class SiteIDandDate {
    private String siteid;
    private String date;

    public SiteIDandDate() {
    }

    public SiteIDandDate(String siteid, String date) {
        this.siteid = siteid;
        this.date = date;
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
}
