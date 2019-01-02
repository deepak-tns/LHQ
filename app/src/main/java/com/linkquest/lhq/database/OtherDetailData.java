package com.linkquest.lhq.database;

public class OtherDetailData {
    private int id;
    private String edtRiggerPic;
    private String edtEngineerPic;
    private String edtCarPic;
    private String edt_RiggerPicwithclimbingTower;
    private String edtRiggerPicduringWah;
    private String iv_RiggerPic;
    private String iv_EngineerPic;
    private String iv_CarPic;
    private String iv_RiggerPicwithclimbingTower;
    private String iv_RiggerPicduringWah;
    private String date;
    private int flag;

    public OtherDetailData() {
    }

    public OtherDetailData(String edtRiggerPic, String edtEngineerPic, String edtCarPic, String edt_RiggerPicwithclimbingTower, String edtRiggerPicduringWah, String iv_RiggerPic, String iv_EngineerPic, String iv_CarPic, String iv_RiggerPicwithclimbingTower, String iv_RiggerPicduringWah, String date, int flag) {

        this.edtRiggerPic = edtRiggerPic;
        this.edtEngineerPic = edtEngineerPic;
        this.edtCarPic = edtCarPic;
        this.edt_RiggerPicwithclimbingTower = edt_RiggerPicwithclimbingTower;
        this.edtRiggerPicduringWah = edtRiggerPicduringWah;
        this.iv_RiggerPic = iv_RiggerPic;
        this.iv_EngineerPic = iv_EngineerPic;
        this.iv_CarPic = iv_CarPic;
        this.iv_RiggerPicwithclimbingTower = iv_RiggerPicwithclimbingTower;
        this.iv_RiggerPicduringWah = iv_RiggerPicduringWah;
        this.date = date;
        this.flag = flag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEdtRiggerPic() {
        return edtRiggerPic;
    }

    public void setEdtRiggerPic(String edtRiggerPic) {
        this.edtRiggerPic = edtRiggerPic;
    }

    public String getEdtEngineerPic() {
        return edtEngineerPic;
    }

    public void setEdtEngineerPic(String edtEngineerPic) {
        this.edtEngineerPic = edtEngineerPic;
    }

    public String getEdtCarPic() {
        return edtCarPic;
    }

    public void setEdtCarPic(String edtCarPic) {
        this.edtCarPic = edtCarPic;
    }

    public String getEdt_RiggerPicwithclimbingTower() {
        return edt_RiggerPicwithclimbingTower;
    }

    public void setEdt_RiggerPicwithclimbingTower(String edt_RiggerPicwithclimbingTower) {
        this.edt_RiggerPicwithclimbingTower = edt_RiggerPicwithclimbingTower;
    }

    public String getEdtRiggerPicduringWah() {
        return edtRiggerPicduringWah;
    }

    public void setEdtRiggerPicduringWah(String edtRiggerPicduringWah) {
        this.edtRiggerPicduringWah = edtRiggerPicduringWah;
    }

    public String getIv_RiggerPic() {
        return iv_RiggerPic;
    }

    public void setIv_RiggerPic(String iv_RiggerPic) {
        this.iv_RiggerPic = iv_RiggerPic;
    }

    public String getIv_EngineerPic() {
        return iv_EngineerPic;
    }

    public void setIv_EngineerPic(String iv_EngineerPic) {
        this.iv_EngineerPic = iv_EngineerPic;
    }

    public String getIv_CarPic() {
        return iv_CarPic;
    }

    public void setIv_CarPic(String iv_CarPic) {
        this.iv_CarPic = iv_CarPic;
    }

    public String getIv_RiggerPicwithclimbingTower() {
        return iv_RiggerPicwithclimbingTower;
    }

    public void setIv_RiggerPicwithclimbingTower(String iv_RiggerPicwithclimbingTower) {
        this.iv_RiggerPicwithclimbingTower = iv_RiggerPicwithclimbingTower;
    }

    public String getIv_RiggerPicduringWah() {
        return iv_RiggerPicduringWah;
    }

    public void setIv_RiggerPicduringWah(String iv_RiggerPicduringWah) {
        this.iv_RiggerPicduringWah = iv_RiggerPicduringWah;
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

    public String toString(){
       return edtRiggerPic+","+
        edtEngineerPic+","+
        edtCarPic+","+
        edt_RiggerPicwithclimbingTower+","+
        edtRiggerPicduringWah+","+
        iv_RiggerPic+","+
        iv_EngineerPic+","+
        iv_CarPic+","+
        iv_RiggerPicwithclimbingTower+","+
        iv_RiggerPicduringWah+","+
        date+","+
        flag;
    }



}
