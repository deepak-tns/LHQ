package com.linkquest.lhq.database;

public class LosPhotoData {
    private int id;
    private String NearEndFarEndphoto1;
    private String FarEndtoNearEndphoto1;
    private String TowerPhoto1;
    private String NearEndtoFarEndphoto2;
    private String FarEndNearEndphoto2;
    private String TowerPhoto2;
    private String NearEndFarEndphoto3;
    private String FarEndtoNearEndphoto3;
    private String TowerPhoto3;
    private String NearEndtoFarEndphoto4;
    private String FarEndtoNearEndphoto4;
    private String TowerPhoto4;
    private String date;
    private int flag;

    public LosPhotoData() {
    }

    public LosPhotoData(String nearEndFarEndphoto1, String farEndtoNearEndphoto1, String towerPhoto1, String nearEndtoFarEndphoto2, String farEndNearEndphoto2, String towerPhoto2, String nearEndFarEndphoto3, String farEndtoNearEndphoto3, String towerPhoto3, String nearEndtoFarEndphoto4, String farEndtoNearEndphoto4, String towerPhoto4, String date, int flag) {
        NearEndFarEndphoto1 = nearEndFarEndphoto1;
        FarEndtoNearEndphoto1 = farEndtoNearEndphoto1;
        TowerPhoto1 = towerPhoto1;
        NearEndtoFarEndphoto2 = nearEndtoFarEndphoto2;
        FarEndNearEndphoto2 = farEndNearEndphoto2;
        TowerPhoto2 = towerPhoto2;
        NearEndFarEndphoto3 = nearEndFarEndphoto3;
        FarEndtoNearEndphoto3 = farEndtoNearEndphoto3;
        TowerPhoto3 = towerPhoto3;
        NearEndtoFarEndphoto4 = nearEndtoFarEndphoto4;
        FarEndtoNearEndphoto4 = farEndtoNearEndphoto4;
        TowerPhoto4 = towerPhoto4;
        this.date = date;
        this.flag = flag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNearEndFarEndphoto1() {
        return NearEndFarEndphoto1;
    }

    public void setNearEndFarEndphoto1(String nearEndFarEndphoto1) {
        NearEndFarEndphoto1 = nearEndFarEndphoto1;
    }

    public String getFarEndtoNearEndphoto1() {
        return FarEndtoNearEndphoto1;
    }

    public void setFarEndtoNearEndphoto1(String farEndtoNearEndphoto1) {
        FarEndtoNearEndphoto1 = farEndtoNearEndphoto1;
    }

    public String getTowerPhoto1() {
        return TowerPhoto1;
    }

    public void setTowerPhoto1(String towerPhoto1) {
        TowerPhoto1 = towerPhoto1;
    }

    public String getNearEndtoFarEndphoto2() {
        return NearEndtoFarEndphoto2;
    }

    public void setNearEndtoFarEndphoto2(String nearEndtoFarEndphoto2) {
        NearEndtoFarEndphoto2 = nearEndtoFarEndphoto2;
    }

    public String getFarEndNearEndphoto2() {
        return FarEndNearEndphoto2;
    }

    public void setFarEndNearEndphoto2(String farEndNearEndphoto2) {
        FarEndNearEndphoto2 = farEndNearEndphoto2;
    }

    public String getTowerPhoto2() {
        return TowerPhoto2;
    }

    public void setTowerPhoto2(String towerPhoto2) {
        TowerPhoto2 = towerPhoto2;
    }

    public String getNearEndFarEndphoto3() {
        return NearEndFarEndphoto3;
    }

    public void setNearEndFarEndphoto3(String nearEndFarEndphoto3) {
        NearEndFarEndphoto3 = nearEndFarEndphoto3;
    }

    public String getFarEndtoNearEndphoto3() {
        return FarEndtoNearEndphoto3;
    }

    public void setFarEndtoNearEndphoto3(String farEndtoNearEndphoto3) {
        FarEndtoNearEndphoto3 = farEndtoNearEndphoto3;
    }

    public String getTowerPhoto3() {
        return TowerPhoto3;
    }

    public void setTowerPhoto3(String towerPhoto3) {
        TowerPhoto3 = towerPhoto3;
    }

    public String getNearEndtoFarEndphoto4() {
        return NearEndtoFarEndphoto4;
    }

    public void setNearEndtoFarEndphoto4(String nearEndtoFarEndphoto4) {
        NearEndtoFarEndphoto4 = nearEndtoFarEndphoto4;
    }

    public String getFarEndtoNearEndphoto4() {
        return FarEndtoNearEndphoto4;
    }

    public void setFarEndtoNearEndphoto4(String farEndtoNearEndphoto4) {
        FarEndtoNearEndphoto4 = farEndtoNearEndphoto4;
    }

    public String getTowerPhoto4() {
        return TowerPhoto4;
    }

    public void setTowerPhoto4(String towerPhoto4) {
        TowerPhoto4 = towerPhoto4;
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
