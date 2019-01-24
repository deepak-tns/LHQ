package com.linkquest.lhq.database;



public class TransmissionNoLinkData {

    private  int id;
    private  String edt_SiteID;
    private  String edt_Sitename;
    private  String edt_ObstructionDetails;
    private  String edt_Azimuth;
    private  String edt_Distance;
    private  String edt_AntennaHeight;
    private  String edt_Altitude;
    private  String img_SiteID;
    private  String img_Sitename;
    private  String img_ObstructionDetails;
    private  String img_Azimuth;
    private  String img_Distance;
    private  String img_AntennaHeight;
    private  String img_Altitude;
    private  String transmissionNoLink_name;
    private  String date;
    private  int flag;

    public TransmissionNoLinkData() {
    }

    public TransmissionNoLinkData(String edt_SiteID, String edt_Sitename, String edt_ObstructionDetails, String edt_Azimuth, String edt_Distance, String edt_AntennaHeight, String edt_Altitude, String img_SiteID, String img_Sitename, String img_ObstructionDetails, String img_Azimuth, String img_Distance, String img_AntennaHeight, String img_Altitude,String transmissionNoLink_name, String date, int flag) {
        this.edt_SiteID = edt_SiteID;
        this.edt_Sitename = edt_Sitename;
        this.edt_ObstructionDetails = edt_ObstructionDetails;
        this.edt_Azimuth = edt_Azimuth;
        this.edt_Distance = edt_Distance;
        this.edt_AntennaHeight = edt_AntennaHeight;
        this.edt_Altitude = edt_Altitude;
        this.img_SiteID = img_SiteID;
        this.img_Sitename = img_Sitename;
        this.img_ObstructionDetails = img_ObstructionDetails;
        this.img_Azimuth = img_Azimuth;
        this.img_Distance = img_Distance;
        this.img_AntennaHeight = img_AntennaHeight;
        this.img_Altitude = img_Altitude;
        this.transmissionNoLink_name = transmissionNoLink_name;
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

    public String getEdt_ObstructionDetails() {
        return edt_ObstructionDetails;
    }

    public void setEdt_ObstructionDetails(String edt_ObstructionDetails) {
        this.edt_ObstructionDetails = edt_ObstructionDetails;
    }

    public String getEdt_Azimuth() {
        return edt_Azimuth;
    }

    public void setEdt_Azimuth(String edt_Azimuth) {
        this.edt_Azimuth = edt_Azimuth;
    }

    public String getEdt_Distance() {
        return edt_Distance;
    }

    public void setEdt_Distance(String edt_Distance) {
        this.edt_Distance = edt_Distance;
    }

    public String getEdt_AntennaHeight() {
        return edt_AntennaHeight;
    }

    public void setEdt_AntennaHeight(String edt_AntennaHeight) {
        this.edt_AntennaHeight = edt_AntennaHeight;
    }

    public String getEdt_Altitude() {
        return edt_Altitude;
    }

    public void setEdt_Altitude(String edt_Altitude) {
        this.edt_Altitude = edt_Altitude;
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

    public String getImg_ObstructionDetails() {
        return img_ObstructionDetails;
    }

    public void setImg_ObstructionDetails(String img_ObstructionDetails) {
        this.img_ObstructionDetails = img_ObstructionDetails;
    }

    public String getImg_Azimuth() {
        return img_Azimuth;
    }

    public void setImg_Azimuth(String img_Azimuth) {
        this.img_Azimuth = img_Azimuth;
    }

    public String getImg_Distance() {
        return img_Distance;
    }

    public void setImg_Distance(String img_Distance) {
        this.img_Distance = img_Distance;
    }

    public String getImg_AntennaHeight() {
        return img_AntennaHeight;
    }

    public void setImg_AntennaHeight(String img_AntennaHeight) {
        this.img_AntennaHeight = img_AntennaHeight;
    }

    public String getImg_Altitude() {
        return img_Altitude;
    }

    public void setImg_Altitude(String img_Altitude) {
        this.img_Altitude = img_Altitude;
    }

    public String getTransmissionNoLink_name() {
        return transmissionNoLink_name;
    }

    public void setTransmissionNoLink_name(String transmissionNoLink_name) {
        this.transmissionNoLink_name = transmissionNoLink_name;
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
