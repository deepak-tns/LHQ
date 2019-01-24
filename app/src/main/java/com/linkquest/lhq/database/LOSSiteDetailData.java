package com.linkquest.lhq.database;

public class LOSSiteDetailData {

    private  int    id;
    private  String    SiteID_TXT;
    private  String     SiteName_TXT;
    private  String  Sharing_TXT;
    private  String  SiteType_TXT;
    private  String SurveyDate_TXT;
    private  String  TNPEngineer_TXT;
    private  String TNPEngineerTel_TXT;
    private  String Customerrepresentative_TXT;
    private  String Nearenddetails_TXT;
    private  String Lat;
    private  String Long;
    private  String CandidateName_TXT;
    private  String Address_TXT;
    private  String Bldght_TXT;
    private  String Totalht_TXT;
    private  String AMSL_TXT;
    private  String Buildingsideviewphoto_TXT;
    private  String AntennaTowerlocationphoto_TXT;
    private  String Possibleobstacle_TXT;
    private  String HeightofObstruction_TXT;
    private  String PanaromicPhoto_TXT;
    private  String ExisitngNoofMWAntennatypewithsizeandPhotograph_TXT;
    private  String ExisitngMWAntennaheightandPolemountPhotograph_TXT;

    private  String  SiteID_PIC;
    private  String  SiteName_PIC;
    private  String  Sharing_PIC;
    private  String  SiteType_PIC;
    private  String  SurveyDate_PIC;
    private  String  TNPEngineer_PIC;
    private  String TNPEngineerTel_PIC;
    private  String Customerrepresentative_PIC;
    private  String Nearenddetails_PIC;
    private  String CandidateName_PIC;
    private  String Address_PIC;
    private  String Bldght_PIC;
    private  String Totalht_PIC;
    private  String AMSL_PIC;
    private  String Buildingsideviewphoto_PIC;
    private  String AntennaTowerlocationphoto_PIC;
    private  String Possibleobstacle_PIC;
    private  String HeightofObstruction_PIC;
    private  String PanaromicPhoto_PIC;
    private  String ExisitngNoofMWAntennatypewithsizeandPhotograph_PIC;
    private  String ExisitngMWAntennaheightandPolemountPhotograph_PIC;
    private String date;
    private int flag;


    public LOSSiteDetailData() {
    }

    public LOSSiteDetailData(String siteID_TXT, String siteName_TXT, String sharing_TXT, String siteType_TXT, String surveyDate_TXT, String TNPEngineer_TXT, String TNPEngineerTel_TXT, String customerrepresentative_TXT, String nearenddetails_TXT, String lat, String aLong, String candidateName_TXT, String address_TXT, String bldght_TXT, String totalht_TXT, String AMSL_TXT, String buildingsideviewphoto_TXT, String antennaTowerlocationphoto_TXT, String possibleobstacle_TXT, String heightofObstruction_TXT, String panaromicPhoto_TXT, String exisitngNoofMWAntennatypewithsizeandPhotograph_TXT, String exisitngMWAntennaheightandPolemountPhotograph_TXT, String siteID_PIC, String siteName_PIC, String sharing_PIC, String siteType_PIC, String surveyDate_PIC, String TNPEngineer_PIC, String TNPEngineerTel_PIC, String customerrepresentative_PIC, String nearenddetails_PIC, String candidateName_PIC, String address_PIC, String bldght_PIC, String totalht_PIC, String AMSL_PIC, String buildingsideviewphoto_PIC, String antennaTowerlocationphoto_PIC, String possibleobstacle_PIC, String heightofObstruction_PIC, String panaromicPhoto_PIC, String exisitngNoofMWAntennatypewithsizeandPhotograph_PIC, String exisitngMWAntennaheightandPolemountPhotograph_PIC, String date, int flag) {
        SiteID_TXT = siteID_TXT;
        SiteName_TXT = siteName_TXT;
        Sharing_TXT = sharing_TXT;
        SiteType_TXT = siteType_TXT;
        SurveyDate_TXT = surveyDate_TXT;
        this.TNPEngineer_TXT = TNPEngineer_TXT;
        this.TNPEngineerTel_TXT = TNPEngineerTel_TXT;
        Customerrepresentative_TXT = customerrepresentative_TXT;
        Nearenddetails_TXT = nearenddetails_TXT;
        Lat = lat;
        Long = aLong;
        CandidateName_TXT = candidateName_TXT;
        Address_TXT = address_TXT;
        Bldght_TXT = bldght_TXT;
        Totalht_TXT = totalht_TXT;
        this.AMSL_TXT = AMSL_TXT;
        Buildingsideviewphoto_TXT = buildingsideviewphoto_TXT;
        AntennaTowerlocationphoto_TXT = antennaTowerlocationphoto_TXT;
        Possibleobstacle_TXT = possibleobstacle_TXT;
        HeightofObstruction_TXT = heightofObstruction_TXT;
        PanaromicPhoto_TXT = panaromicPhoto_TXT;
        ExisitngNoofMWAntennatypewithsizeandPhotograph_TXT = exisitngNoofMWAntennatypewithsizeandPhotograph_TXT;
        ExisitngMWAntennaheightandPolemountPhotograph_TXT = exisitngMWAntennaheightandPolemountPhotograph_TXT;
        SiteID_PIC = siteID_PIC;
        SiteName_PIC = siteName_PIC;
        Sharing_PIC = sharing_PIC;
        SiteType_PIC = siteType_PIC;
        SurveyDate_PIC = surveyDate_PIC;
        this.TNPEngineer_PIC = TNPEngineer_PIC;
        this.TNPEngineerTel_PIC = TNPEngineerTel_PIC;
        Customerrepresentative_PIC = customerrepresentative_PIC;
        Nearenddetails_PIC = nearenddetails_PIC;
        CandidateName_PIC = candidateName_PIC;
        Address_PIC = address_PIC;
        Bldght_PIC = bldght_PIC;
        Totalht_PIC = totalht_PIC;
        this.AMSL_PIC = AMSL_PIC;
        Buildingsideviewphoto_PIC = buildingsideviewphoto_PIC;
        AntennaTowerlocationphoto_PIC = antennaTowerlocationphoto_PIC;
        Possibleobstacle_PIC = possibleobstacle_PIC;
        HeightofObstruction_PIC = heightofObstruction_PIC;
        PanaromicPhoto_PIC = panaromicPhoto_PIC;
        ExisitngNoofMWAntennatypewithsizeandPhotograph_PIC = exisitngNoofMWAntennatypewithsizeandPhotograph_PIC;
        ExisitngMWAntennaheightandPolemountPhotograph_PIC = exisitngMWAntennaheightandPolemountPhotograph_PIC;
        this.date = date;
        this.flag = flag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSiteID_TXT() {
        return SiteID_TXT;
    }

    public void setSiteID_TXT(String siteID_TXT) {
        SiteID_TXT = siteID_TXT;
    }

    public String getSiteName_TXT() {
        return SiteName_TXT;
    }

    public void setSiteName_TXT(String siteName_TXT) {
        SiteName_TXT = siteName_TXT;
    }

    public String getSharing_TXT() {
        return Sharing_TXT;
    }

    public void setSharing_TXT(String sharing_TXT) {
        Sharing_TXT = sharing_TXT;
    }

    public String getSiteType_TXT() {
        return SiteType_TXT;
    }

    public void setSiteType_TXT(String siteType_TXT) {
        SiteType_TXT = siteType_TXT;
    }

    public String getSurveyDate_TXT() {
        return SurveyDate_TXT;
    }

    public void setSurveyDate_TXT(String surveyDate_TXT) {
        SurveyDate_TXT = surveyDate_TXT;
    }

    public String getTNPEngineer_TXT() {
        return TNPEngineer_TXT;
    }

    public void setTNPEngineer_TXT(String TNPEngineer_TXT) {
        this.TNPEngineer_TXT = TNPEngineer_TXT;
    }

    public String getTNPEngineerTel_TXT() {
        return TNPEngineerTel_TXT;
    }

    public void setTNPEngineerTel_TXT(String TNPEngineerTel_TXT) {
        this.TNPEngineerTel_TXT = TNPEngineerTel_TXT;
    }

    public String getCustomerrepresentative_TXT() {
        return Customerrepresentative_TXT;
    }

    public void setCustomerrepresentative_TXT(String customerrepresentative_TXT) {
        Customerrepresentative_TXT = customerrepresentative_TXT;
    }

    public String getNearenddetails_TXT() {
        return Nearenddetails_TXT;
    }

    public void setNearenddetails_TXT(String nearenddetails_TXT) {
        Nearenddetails_TXT = nearenddetails_TXT;
    }

    public String getLat() {
        return Lat;
    }

    public void setLat(String lat) {
        Lat = lat;
    }

    public String getLong() {
        return Long;
    }

    public void setLong(String aLong) {
        Long = aLong;
    }

    public String getCandidateName_TXT() {
        return CandidateName_TXT;
    }

    public void setCandidateName_TXT(String candidateName_TXT) {
        CandidateName_TXT = candidateName_TXT;
    }

    public String getAddress_TXT() {
        return Address_TXT;
    }

    public void setAddress_TXT(String address_TXT) {
        Address_TXT = address_TXT;
    }

    public String getBldght_TXT() {
        return Bldght_TXT;
    }

    public void setBldght_TXT(String bldght_TXT) {
        Bldght_TXT = bldght_TXT;
    }

    public String getTotalht_TXT() {
        return Totalht_TXT;
    }

    public void setTotalht_TXT(String totalht_TXT) {
        Totalht_TXT = totalht_TXT;
    }

    public String getAMSL_TXT() {
        return AMSL_TXT;
    }

    public void setAMSL_TXT(String AMSL_TXT) {
        this.AMSL_TXT = AMSL_TXT;
    }

    public String getBuildingsideviewphoto_TXT() {
        return Buildingsideviewphoto_TXT;
    }

    public void setBuildingsideviewphoto_TXT(String buildingsideviewphoto_TXT) {
        Buildingsideviewphoto_TXT = buildingsideviewphoto_TXT;
    }

    public String getAntennaTowerlocationphoto_TXT() {
        return AntennaTowerlocationphoto_TXT;
    }

    public void setAntennaTowerlocationphoto_TXT(String antennaTowerlocationphoto_TXT) {
        AntennaTowerlocationphoto_TXT = antennaTowerlocationphoto_TXT;
    }

    public String getPossibleobstacle_TXT() {
        return Possibleobstacle_TXT;
    }

    public void setPossibleobstacle_TXT(String possibleobstacle_TXT) {
        Possibleobstacle_TXT = possibleobstacle_TXT;
    }

    public String getHeightofObstruction_TXT() {
        return HeightofObstruction_TXT;
    }

    public void setHeightofObstruction_TXT(String heightofObstruction_TXT) {
        HeightofObstruction_TXT = heightofObstruction_TXT;
    }

    public String getPanaromicPhoto_TXT() {
        return PanaromicPhoto_TXT;
    }

    public void setPanaromicPhoto_TXT(String panaromicPhoto_TXT) {
        PanaromicPhoto_TXT = panaromicPhoto_TXT;
    }

    public String getExisitngNoofMWAntennatypewithsizeandPhotograph_TXT() {
        return ExisitngNoofMWAntennatypewithsizeandPhotograph_TXT;
    }

    public void setExisitngNoofMWAntennatypewithsizeandPhotograph_TXT(String exisitngNoofMWAntennatypewithsizeandPhotograph_TXT) {
        ExisitngNoofMWAntennatypewithsizeandPhotograph_TXT = exisitngNoofMWAntennatypewithsizeandPhotograph_TXT;
    }

    public String getExisitngMWAntennaheightandPolemountPhotograph_TXT() {
        return ExisitngMWAntennaheightandPolemountPhotograph_TXT;
    }

    public void setExisitngMWAntennaheightandPolemountPhotograph_TXT(String exisitngMWAntennaheightandPolemountPhotograph_TXT) {
        ExisitngMWAntennaheightandPolemountPhotograph_TXT = exisitngMWAntennaheightandPolemountPhotograph_TXT;
    }

    public String getSiteID_PIC() {
        return SiteID_PIC;
    }

    public void setSiteID_PIC(String siteID_PIC) {
        SiteID_PIC = siteID_PIC;
    }

    public String getSiteName_PIC() {
        return SiteName_PIC;
    }

    public void setSiteName_PIC(String siteName_PIC) {
        SiteName_PIC = siteName_PIC;
    }

    public String getSharing_PIC() {
        return Sharing_PIC;
    }

    public void setSharing_PIC(String sharing_PIC) {
        Sharing_PIC = sharing_PIC;
    }

    public String getSiteType_PIC() {
        return SiteType_PIC;
    }

    public void setSiteType_PIC(String siteType_PIC) {
        SiteType_PIC = siteType_PIC;
    }

    public String getSurveyDate_PIC() {
        return SurveyDate_PIC;
    }

    public void setSurveyDate_PIC(String surveyDate_PIC) {
        SurveyDate_PIC = surveyDate_PIC;
    }

    public String getTNPEngineer_PIC() {
        return TNPEngineer_PIC;
    }

    public void setTNPEngineer_PIC(String TNPEngineer_PIC) {
        this.TNPEngineer_PIC = TNPEngineer_PIC;
    }

    public String getTNPEngineerTel_PIC() {
        return TNPEngineerTel_PIC;
    }

    public void setTNPEngineerTel_PIC(String TNPEngineerTel_PIC) {
        this.TNPEngineerTel_PIC = TNPEngineerTel_PIC;
    }

    public String getCustomerrepresentative_PIC() {
        return Customerrepresentative_PIC;
    }

    public void setCustomerrepresentative_PIC(String customerrepresentative_PIC) {
        Customerrepresentative_PIC = customerrepresentative_PIC;
    }

    public String getNearenddetails_PIC() {
        return Nearenddetails_PIC;
    }

    public void setNearenddetails_PIC(String nearenddetails_PIC) {
        Nearenddetails_PIC = nearenddetails_PIC;
    }

    public String getCandidateName_PIC() {
        return CandidateName_PIC;
    }

    public void setCandidateName_PIC(String candidateName_PIC) {
        CandidateName_PIC = candidateName_PIC;
    }

    public String getAddress_PIC() {
        return Address_PIC;
    }

    public void setAddress_PIC(String address_PIC) {
        Address_PIC = address_PIC;
    }

    public String getBldght_PIC() {
        return Bldght_PIC;
    }

    public void setBldght_PIC(String bldght_PIC) {
        Bldght_PIC = bldght_PIC;
    }

    public String getTotalht_PIC() {
        return Totalht_PIC;
    }

    public void setTotalht_PIC(String totalht_PIC) {
        Totalht_PIC = totalht_PIC;
    }

    public String getAMSL_PIC() {
        return AMSL_PIC;
    }

    public void setAMSL_PIC(String AMSL_PIC) {
        this.AMSL_PIC = AMSL_PIC;
    }

    public String getBuildingsideviewphoto_PIC() {
        return Buildingsideviewphoto_PIC;
    }

    public void setBuildingsideviewphoto_PIC(String buildingsideviewphoto_PIC) {
        Buildingsideviewphoto_PIC = buildingsideviewphoto_PIC;
    }

    public String getAntennaTowerlocationphoto_PIC() {
        return AntennaTowerlocationphoto_PIC;
    }

    public void setAntennaTowerlocationphoto_PIC(String antennaTowerlocationphoto_PIC) {
        AntennaTowerlocationphoto_PIC = antennaTowerlocationphoto_PIC;
    }

    public String getPossibleobstacle_PIC() {
        return Possibleobstacle_PIC;
    }

    public void setPossibleobstacle_PIC(String possibleobstacle_PIC) {
        Possibleobstacle_PIC = possibleobstacle_PIC;
    }

    public String getHeightofObstruction_PIC() {
        return HeightofObstruction_PIC;
    }

    public void setHeightofObstruction_PIC(String heightofObstruction_PIC) {
        HeightofObstruction_PIC = heightofObstruction_PIC;
    }

    public String getPanaromicPhoto_PIC() {
        return PanaromicPhoto_PIC;
    }

    public void setPanaromicPhoto_PIC(String panaromicPhoto_PIC) {
        PanaromicPhoto_PIC = panaromicPhoto_PIC;
    }

    public String getExisitngNoofMWAntennatypewithsizeandPhotograph_PIC() {
        return ExisitngNoofMWAntennatypewithsizeandPhotograph_PIC;
    }

    public void setExisitngNoofMWAntennatypewithsizeandPhotograph_PIC(String exisitngNoofMWAntennatypewithsizeandPhotograph_PIC) {
        ExisitngNoofMWAntennatypewithsizeandPhotograph_PIC = exisitngNoofMWAntennatypewithsizeandPhotograph_PIC;
    }

    public String getExisitngMWAntennaheightandPolemountPhotograph_PIC() {
        return ExisitngMWAntennaheightandPolemountPhotograph_PIC;
    }

    public void setExisitngMWAntennaheightandPolemountPhotograph_PIC(String exisitngMWAntennaheightandPolemountPhotograph_PIC) {
        ExisitngMWAntennaheightandPolemountPhotograph_PIC = exisitngMWAntennaheightandPolemountPhotograph_PIC;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
