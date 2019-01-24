package com.linkquest.lhq.database;

public class TransmissionLinkData {
    private int id;
    private  String edt_SiteID;
    private  String edt_Sitename;
    private  String edt_Latitude;
    private  String edt_Longitude;
    private  String edt_Azimuthfromnearend;
    private  String edt_Distance;
    private  String edt_AntennaHeightatFarend;
    private  String edt_PoleFixtureRequirementatFarend;
    private  String edt_IFLengthatFarend;
    private  String edt_BuildingHeightatFarend;
    private  String edt_TotalhtForGBTRTTRTPATFarEnd;
    private  String edt_AMSLatFarEnd;
    private  String img_SiteID;
    private  String img_Sitename;
    private  String img_Azimuthfromnearend;
    private  String img_Distance;
    private  String img_AntennaHeightatFarend;
    private  String img_PoleFixtureRequirementatFarend;
    private  String img_IFLengthatFarend;
    private  String img_BuildingHeightatFarend;
    private  String img_TotalhtForGBTRTTRTPATFarEnd;
    private  String img_AMSLatFarEnd;
    private  String transmissionLink_name;
    private String date;
    private int flag;

    public TransmissionLinkData() {
    }

    public TransmissionLinkData(String edt_SiteID, String edt_Sitename, String edt_Latitude, String edt_Longitude, String edt_Azimuthfromnearend, String edt_Distance, String edt_AntennaHeightatFarend, String edt_PoleFixtureRequirementatFarend, String edt_IFLengthatFarend, String edt_BuildingHeightatFarend, String edt_TotalhtForGBTRTTRTPATFarEnd, String edt_AMSLatFarEnd, String img_SiteID, String img_Sitename, String img_Azimuthfromnearend, String img_Distance, String img_AntennaHeightatFarend, String img_PoleFixtureRequirementatFarend, String img_IFLengthatFarend, String img_BuildingHeightatFarend, String img_TotalhtForGBTRTTRTPATFarEnd, String img_AMSLatFarEnd,String transmissionLink_name, String date, int flag) {
        this.edt_SiteID = edt_SiteID;
        this.edt_Sitename = edt_Sitename;
        this.edt_Latitude = edt_Latitude;
        this.edt_Longitude = edt_Longitude;
        this.edt_Azimuthfromnearend = edt_Azimuthfromnearend;
        this.edt_Distance = edt_Distance;
        this.edt_AntennaHeightatFarend = edt_AntennaHeightatFarend;
        this.edt_PoleFixtureRequirementatFarend = edt_PoleFixtureRequirementatFarend;
        this.edt_IFLengthatFarend = edt_IFLengthatFarend;
        this.edt_BuildingHeightatFarend = edt_BuildingHeightatFarend;
        this.edt_TotalhtForGBTRTTRTPATFarEnd = edt_TotalhtForGBTRTTRTPATFarEnd;
        this.edt_AMSLatFarEnd = edt_AMSLatFarEnd;
        this.img_SiteID = img_SiteID;
        this.img_Sitename = img_Sitename;
        this.img_Azimuthfromnearend = img_Azimuthfromnearend;
        this.img_Distance = img_Distance;
        this.img_AntennaHeightatFarend = img_AntennaHeightatFarend;
        this.img_PoleFixtureRequirementatFarend = img_PoleFixtureRequirementatFarend;
        this.img_IFLengthatFarend = img_IFLengthatFarend;
        this.img_BuildingHeightatFarend = img_BuildingHeightatFarend;
        this.img_TotalhtForGBTRTTRTPATFarEnd = img_TotalhtForGBTRTTRTPATFarEnd;
        this.img_AMSLatFarEnd = img_AMSLatFarEnd;
        this.transmissionLink_name = transmissionLink_name;
        this.date = date;
        this.flag = flag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEdt_SiteID() {
        return edt_SiteID;
    }

    public void setEdt_SiteID(String edt_SiteID) {
        this.edt_SiteID = edt_SiteID;
    }

    public String getEdt_Sitename() {
        return edt_Sitename;
    }

    public void setEdt_Sitename(String edt_Sitename) {
        this.edt_Sitename = edt_Sitename;
    }

    public String getEdt_Latitude() {
        return edt_Latitude;
    }

    public void setEdt_Latitude(String edt_Latitude) {
        this.edt_Latitude = edt_Latitude;
    }

    public String getEdt_Longitude() {
        return edt_Longitude;
    }

    public void setEdt_Longitude(String edt_Longitude) {
        this.edt_Longitude = edt_Longitude;
    }

    public String getEdt_Azimuthfromnearend() {
        return edt_Azimuthfromnearend;
    }

    public void setEdt_Azimuthfromnearend(String edt_Azimuthfromnearend) {
        this.edt_Azimuthfromnearend = edt_Azimuthfromnearend;
    }

    public String getEdt_Distance() {
        return edt_Distance;
    }

    public void setEdt_Distance(String edt_Distance) {
        this.edt_Distance = edt_Distance;
    }

    public String getEdt_AntennaHeightatFarend() {
        return edt_AntennaHeightatFarend;
    }

    public void setEdt_AntennaHeightatFarend(String edt_AntennaHeightatFarend) {
        this.edt_AntennaHeightatFarend = edt_AntennaHeightatFarend;
    }

    public String getEdt_PoleFixtureRequirementatFarend() {
        return edt_PoleFixtureRequirementatFarend;
    }

    public void setEdt_PoleFixtureRequirementatFarend(String edt_PoleFixtureRequirementatFarend) {
        this.edt_PoleFixtureRequirementatFarend = edt_PoleFixtureRequirementatFarend;
    }

    public String getEdt_IFLengthatFarend() {
        return edt_IFLengthatFarend;
    }

    public void setEdt_IFLengthatFarend(String edt_IFLengthatFarend) {
        this.edt_IFLengthatFarend = edt_IFLengthatFarend;
    }

    public String getEdt_BuildingHeightatFarend() {
        return edt_BuildingHeightatFarend;
    }

    public void setEdt_BuildingHeightatFarend(String edt_BuildingHeightatFarend) {
        this.edt_BuildingHeightatFarend = edt_BuildingHeightatFarend;
    }

    public String getEdt_TotalhtForGBTRTTRTPATFarEnd() {
        return edt_TotalhtForGBTRTTRTPATFarEnd;
    }

    public void setEdt_TotalhtForGBTRTTRTPATFarEnd(String edt_TotalhtForGBTRTTRTPATFarEnd) {
        this.edt_TotalhtForGBTRTTRTPATFarEnd = edt_TotalhtForGBTRTTRTPATFarEnd;
    }

    public String getEdt_AMSLatFarEnd() {
        return edt_AMSLatFarEnd;
    }

    public void setEdt_AMSLatFarEnd(String edt_AMSLatFarEnd) {
        this.edt_AMSLatFarEnd = edt_AMSLatFarEnd;
    }

    public String getImg_SiteID() {
        return img_SiteID;
    }

    public void setImg_SiteID(String img_SiteID) {
        this.img_SiteID = img_SiteID;
    }

    public String getImg_Sitename() {
        return img_Sitename;
    }

    public void setImg_Sitename(String img_Sitename) {
        this.img_Sitename = img_Sitename;
    }

    public String getImg_Azimuthfromnearend() {
        return img_Azimuthfromnearend;
    }

    public void setImg_Azimuthfromnearend(String img_Azimuthfromnearend) {
        this.img_Azimuthfromnearend = img_Azimuthfromnearend;
    }

    public String getImg_Distance() {
        return img_Distance;
    }

    public void setImg_Distance(String img_Distance) {
        this.img_Distance = img_Distance;
    }

    public String getImg_AntennaHeightatFarend() {
        return img_AntennaHeightatFarend;
    }

    public void setImg_AntennaHeightatFarend(String img_AntennaHeightatFarend) {
        this.img_AntennaHeightatFarend = img_AntennaHeightatFarend;
    }

    public String getImg_PoleFixtureRequirementatFarend() {
        return img_PoleFixtureRequirementatFarend;
    }

    public void setImg_PoleFixtureRequirementatFarend(String img_PoleFixtureRequirementatFarend) {
        this.img_PoleFixtureRequirementatFarend = img_PoleFixtureRequirementatFarend;
    }

    public String getImg_IFLengthatFarend() {
        return img_IFLengthatFarend;
    }

    public void setImg_IFLengthatFarend(String img_IFLengthatFarend) {
        this.img_IFLengthatFarend = img_IFLengthatFarend;
    }

    public String getImg_BuildingHeightatFarend() {
        return img_BuildingHeightatFarend;
    }

    public void setImg_BuildingHeightatFarend(String img_BuildingHeightatFarend) {
        this.img_BuildingHeightatFarend = img_BuildingHeightatFarend;
    }

    public String getImg_TotalhtForGBTRTTRTPATFarEnd() {
        return img_TotalhtForGBTRTTRTPATFarEnd;
    }

    public void setImg_TotalhtForGBTRTTRTPATFarEnd(String img_TotalhtForGBTRTTRTPATFarEnd) {
        this.img_TotalhtForGBTRTTRTPATFarEnd = img_TotalhtForGBTRTTRTPATFarEnd;
    }

    public String getImg_AMSLatFarEnd() {
        return img_AMSLatFarEnd;
    }

    public void setImg_AMSLatFarEnd(String img_AMSLatFarEnd) {
        this.img_AMSLatFarEnd = img_AMSLatFarEnd;
    }

    public String getTransmissionLink_name() {
        return transmissionLink_name;
    }

    public void setTransmissionLink_name(String transmissionLink_name) {
        this.transmissionLink_name = transmissionLink_name;
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
