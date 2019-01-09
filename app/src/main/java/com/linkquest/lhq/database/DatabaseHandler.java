package com.linkquest.lhq.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class DatabaseHandler extends SQLiteOpenHelper {

    private static final String TAG = DatabaseHandler.class.getSimpleName();
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    public static final String DATABASE_NAME = "lqt";
    private static final String TABLE_SURVEYFORM = "surveyform";
    private static final String TABLE_SITEDETAIL = "sitedetail";
    private static final String TABLE_SITEPANOROMIC = "sitepanoramic";
    private static final String TABLE_SITEPANOROMICBLOCKING = "sitepanoramicBlocking";
    private static final String TABLE_SECTORDETAIL = "sectordetail";
    private static final String TABLE_OTHERDETAIL = "otherdetail";


    // SurveyForm Table Columns names for add post data student
    private static final String KEY_INCRI_ID = "id";
    private static final String KEY_SURVEYTYPE = "SurveyType";
    private static final String KEY_CUSTOMER = "Customer";
    private static final String KEY_OPERATER = "Operater";
    private static final String KEY_CIRCLE = "Circle";
    private static final String KEY_TECHNOLOGY = "Technology";
    private static final String KEY_TECHNOLOGYTYPE = "TechnologyType";
    private static final String KEY_LOCATION = "Location";
    private static final String KEY_SITEID = "SiteId";
    private static final String KEY_DATE = "date";
    private static final String KEY_LAT = "lat";
    private static final String KEY_LOG = "log";
    private static final String KEY_FLAG = "flag";
    private static final String KEY_CLUSTERID = "CusterId";

    // SiteDetail Table Columns names for add post data
    private static final String keyincriid = "id";
    private static final String keysiteid = "siteid";
    private static final String keysiteid_photo = "siteidphoto";
    private static final String keysitename = "sitename";
    private static final String keysitename_photo = "sitenamephoto";
    private static final String keytowersiteid = "towersiteid";
    private static final String keytowersiteid_photo = "towersiteidphoto";
    private static final String keytowercompanyname = "towercompanyname";
    private static final String keytowercompanyname__photo = "towercompanyname__photo";
    private static final String keysiteaddress = "siteaddress";
    private static final String keysiteaddress_photo = "siteaddress_photo";
    private static final String keysectorid = "sectorid";
    private static final String keysectorid_photo = "sectorid_photo";
    private static final String keylat = "lat";
    private static final String keylog = "log";
    private static final String keysitetype = "sitetype";
    private static final String keysitetype_photo = "sitetype_photo";
    private static final String keybuildingfloor = "buildingfloor";
    private static final String keybuildingfloor_photo = "buildingfloor_photo";
    private static final String keybuildingheight = "buildingheight";
    private static final String keybuildingheight_photo = "buildingheight_photo";
    private static final String keytowerheight = "towerheight";
    private static final String keytowerheight_photo = "towerheight_photo";
    private static final String keyfulltowerphoto = "fulltowerphoto";
    private static final String keyfulltowerphoto_photo = "fulltowerphoto_photo";
    private static final String keynodebtype = "nodebtype";
    private static final String keynodebtype_photo = "nodebtype_photo";
    private static final String keyclassical = "classical";
    private static final String keyclassical_photo = "classical_photo";
    private static final String keyenodebtype = "enodebtype";
    private static final String keyenodebtype_photo = "enodebtype_photo";
    private static final String keyanchoroperator = "anchoroperator";
    private static final String keyanchoroperator_photo = "anchoroperator_photo";
    private static final String keysharingopco1 = "sharingopco1";
    private static final String keysharingopco1_photo = "sharingopco1_photo";
    private static final String keysharingopco2 = "sharingopco2";
    private static final String keysharingopco2_photo = "sharingopco2_photo";
    private static final String keysharingopco3 = "sharingopco3";
    private static final String keysharingopco3_photo = "sharingopco3_photo";
    private static final String keyinfraprovider = "infraprovider";
    private static final String keyinfraprovider_photo = "infraprovider_photo";
    private static final String keytype_id_od = "type_id_od";
    private static final String keytype_id_od_photo = "type_id_od_photo";
    private static final String keyinfrashared = "infrashared";
    private static final String keyinfrashared_photo = "infrashared_photo";
    private static final String keyextra1 = "extra1";
    private static final String keyextra1_photo = "extra1_photo";
    private static final String keyextra2 = "extra2";
    private static final String keyextra2_photo = "extra2_photo";
    private static final String keyremark1 = "remark1";
    private static final String keyremark1_photo = "remark1_photo";
    private static final String keyremark2 = "remark2";
    private static final String keyremark2_photo = "remark2_photo";
    private static final String keyflag = "flag";
    private static final String keydate = "date";

    // SitePanoramic Table Columns names for add post data
    private static final String SPTVID = "id";
    private static final String SPTVBEARING0 = "Degree0";
    private static final String SPTVBEARING30 = "Degree30";
    private static final String SPTVBEARING60 = "Degree60";
    private static final String SPTVBEARING90 = "Degree90";
    private static final String SPTVBEARING120 = "Degree120";
    private static final String SPTVBEARING150 = "Degree150";
    private static final String SPTVBEARING180 = "Degree180";
    private static final String SPTVBEARING210 = "Degree210";
    private static final String SPTVBEARING240 = "Degree240";
    private static final String SPTVBEARING270 = "Degree270";
    private static final String SPTVBEARING300 = "Degree300";
    private static final String SPTVBEARING330 = "Degree330";
    private static final String SPIMGBEARING0 = "Degreeimg0";
    private static final String SPIMGBEARING30 = "Degreeimg30";
    private static final String SPIMGBEARING60 = "Degreeimg60";
    private static final String SPIMGBEARING90 = "Degreeimg90";
    private static final String SPIMGBEARING120 = "Degreeimg120";
    private static final String SPIMGBEARING150 = "Degreeimg150";
    private static final String SPIMGBEARING180 = "Degreeimg180";
    private static final String SPIMGBEARING210 = "Degreeimg210";
    private static final String SPIMGBEARING240 = "Degreeimg240";
    private static final String SPIMGBEARING270 = "Degreeimg270";
    private static final String SPIMGBEARING300 = "Degreeimg300";
    private static final String SPIMGBEARING330 = "Degreeimg330";
    private static final String SPEXTRA1 = "extra1";
    private static final String SPEXTRA2 = "extra2";
    private static final String SPREMARK1 = "remark1";
    private static final String SPREMARK2 = "remark2";
    private static final String SPFLAG = "Flag";
    private static final String SPDATE = "Date";

    // SitePanoramicBlocking Table Columns names for add post data
    private static final String SPBLOCKINGID = "id";
    private static final String SPBLOCKING0 = "Blocking0";
    private static final String SPBLOCKING30 = "Blocking30";
    private static final String SPBLOCKING60 = "Blocking60";
    private static final String SPBLOCKING90 = "Blocking90";
    private static final String SPBLOCKING120 = "Blocking120";
    private static final String SPBLOCKING150 = "Blocking150";
    private static final String SPBLOCKING180 = "Blocking180";
    private static final String SPBLOCKING210 = "Blocking210";
    private static final String SPBLOCKING240 = "Blocking240";
    private static final String SPBLOCKING270 = "Blocking270";
    private static final String SPBLOCKING300 = "Blocking300";
    private static final String SPBLOCKING330 = "Blocking330";
    private static final String SPBLOCKINGFLAG = "Flag";

    // SectorDetail Table Columns names for add post data
    private static final String sectordetail_id = "id";
    private static final String sectordetail_edt_techavailable = "edt_techavailable";
    private static final String sectordetail_img_techavailable = "img_techavailable";
    private static final String sectordetail_edt_bandavailable = "edt_bandavailable";
    private static final String sectordeatail_img_bandavailable = "img_bandavailable ";
    private static final String sectordeatail_edt_APC = "edt_APC";
    private static final String sectordeatail_img_APC = "img_APC";
    private static final String sectoreatail_edt_preazimuth = "edt_preazimuth";
    private static final String sectordeatail_img_preazimuth = "img_preazimuth ";
    private static final String sectordeatail_edt_postazimuth = "edt_postazimuth";
    private static final String sectordeatail_img_postazimuth = "img_postazimuth";
    private static final String sectordeatail_edt_premechanical_tilt = "edt_premechanical_tilt";
    private static final String sectordeatail_img_premechanical_tilt = "img_premechanical_tilt";
    private static final String sectordeatail_edt_postmechanical_tilt = "edt_postmechanical_tilt";
    private static final String sectordeatail_img_postmechanical_tilt = "img_postmechanical_tilt";
    private static final String sectordeatail_edt_preelectrical_tilt2g = "edt_preelectrical_tilt2g";
    private static final String sectordeatail_img_preelectrical_tilt2g = "img_preelectrical_tilt2g";
    private static final String sectordeatail_edt_postelectrical_tilt2g = "postelectrical_tilt2g";
    private static final String sectordeatail_img_postelectrical_tilt2g = "img_postelectrical_tilt2g";
    private static final String sectordeatail_edt_preelectrical_tilt3g = "edt_preelectrical_tilt3g";
    private static final String sectordeatail_img_pretelectrical_tilt3g = "img_pretelectrical_tilt3g";
    private static final String sectordeatail_edt_postelectrical_tilt3g = "edt_postelectrical_tilt3g";
    private static final String sectordeatail_img_postelectrical_tilt3g = "img_postelectrical_tilt3g";
    private static final String sectordeatail_edt_preelectrical_tilt4gf1 = "edt_preelectrical_tilt4gf1";
    private static final String sectordeatail_img_preelectrical_tilt4gf1 = "img_preelectrical_tilt4gf1 ";
    private static final String sectordeatail_edt_postelectrical_tilt4gf1 = "edt_postelectrical_tilt4gf1";
    private static final String sectordeatail_img_postelectrical_tilt4gf1 = "img_postelectrical_tilt4gf1";
    private static final String sectordeatail_edt_preelectrical_tilt4gf2 = "edt_preelectrical_tilt4gf2";
    private static final String sectordeatail_img_preelectrical_tilt4gf2 = "img_preelectrical_tilt4gf2";
    private static final String sectordeatail_edt_postelectrical_tilt4gf2 = "edt_postelectrical_tilt4gf2";
    private static final String sectordeatail_img_postelectrical_tilt4gf2 = "img_postelectrical_tilt4gf2";
    private static final String sectordeatail_edt_preelectrical_tilt = "edt_preelectrical_tilt";
    private static final String sectordeatail_img_preelectrical_tilt = "img_preelectrical_tilt";
    private static final String sectordeatail_edt_postelectrical_tilt = "edt_postelectrical_tilt";
    private static final String sectordeatail_img_postelectrical_tilt = "img_postelectrical_tilt";
    private static final String sectordeatail_edt_antennaheight = "edt_antennaheight";
    private static final String sectordeatail_img_antennaheight = "img_antennaheight";
    private static final String sectordeatail_edt_poleheight = "edt_poleheight";
    private static final String sectordeatail_img_poleheight = "img_poleheight";
    private static final String sectordeatail_edt_buildingheight = "edt_buildingheight";
    private static final String sectordeatail_img_buildingheight = "img_buildingheight";
    private static final String sectordeatail_edt_towertype = "edt_towertype";
    private static final String sectordeatail_img_towertype = "img_towertype";
    private static final String sectordeatail_edt_antennamake = "edt_antennamake";
    private static final String sectordeatail_img_antennamake = "img_antennamake";
    private static final String sectordeatail_edt_antenmodel = "edt_antenmodel";
    private static final String sectordeatail_img_antennamodel = "img_antennamodel";
    private static final String sectordeatail_edt_clutterpic = "edt_clutterpic";
    private static final String sectordeatail_img_clutterpic = "img_clutterpic";
    private static final String sectordeatail_edt_txbandwidth = "edt_txbandwidth";
    private static final String sectordeatail_img_txbandwidth = "img_txbandwidth";
    private static final String sectordeatail_edt_AST = "edt_AST";
    private static final String sectordeatail_img_AST = "img_AST";
    private static final String sectordeatail_edt_APST = "edt_APST";
    private static final String sectordeatail_img_APST = "img_APST";
    private static final String sectordeatail_edt_typ_enodeb = "edt_typ_enodeb";
    private static final String sectordeatail_img_typ_enodeb = "img_typ_enodeb";
    private static final String sectordeatail_edt_mimo = "edt_mimo";
    private static final String sectordeatail_img_mimo = "img_mimo";
    private static final String sectordeatail_edt_ret = "edt_ret";
    private static final String sectordeatail_img_ret = "img_ret ";
    private static final String sectordeatail_edt_enodebband = "edt_enodebband";
    private static final String sectordeatail_img_enodebband = "img_enodebband";
    private static final String sectordeatail_edt_MOP = "edt_MOP";
    private static final String sectordeatail_img_MOP = "img_MOP";
    private static final String sectordeatail_edt_COP = "edt_COP";
    private static final String sectordeatail_img_COP = "img_COP";
    private static final String sectordeatail_edt_multiplexer_avail = "edt_multiplexer_avail";
    private static final String sectordeatail_img_multiplexer_avail = "img_multiplexer_avail";
    private static final String sectordeatail_edt_antennapicleg = "edt_antennapicleg";
    private static final String sectordeatail_img_antennapicleg = "img_antennapicleg ";
    private static final String sectordeatail_edt_CRP = "edt_CRP";
    private static final String sectordeatail_img_CRP = "img_CRP";
    private static final String sectordeatail_edt_powerdeboosting = "edt_powerdeboosting";
    private static final String sectordeatail_img_powerdeboosting = "img_powerdeboosting";
    private static final String sectordeatail_edt_DFS = "edt_DFS";
    private static final String sectordeatail_img_DFS = "img_DFS";
    private static final String sectordeatail_edt_rb_percell = "edt_rb_percell";
    private static final String sectordeatail_img_rb_percell = "img_rb_percell";
    private static final String sectordeatail_edt_m_mimo = "edt_m_mimo";
    private static final String sectordeatail_img_m_mimo = "img_m_mimo";
    private static final String sectordeatail_edt_FCT = "edt_FCT";
    private static final String sectordeatail_img_FCT = "img_FCT";
    private static final String sectordeatail_edt_JCT = "edt_JCT ";
    private static final String sectordeatail_img_JCT = "img_JCT ";
    private static final String sectordeatail_edt_FCL = "edt_FCL";
    private static final String sectordeatail_img_FCL = "img_FCL";
    private static final String sectordeatail_edt_jumperlength = "edt_jumperlength";
    private static final String sectordeatail_img_jumperlength = "img_jumperlength";
    private static final String sectordeatail_edt_prachconfig_index = "edt_prachconfig_index";
    private static final String sectordeatail_img_prachconfig_index = "img_prachconfig_index";
    private static final String sectordeatail_edt_carrieraggregation = "edt_carrieraggregation";
    private static final String sectordeatail_img_carrieraggregation = "img_carrieraggregation";
    private static final String sectordeatail_edt_ACD = "edt_ACD";
    private static final String sectordeatail_img_ACD = "img_ACD";
    private static final String sectordeatail_edt_VSWRtest = "edt_VSWRtest";
    private static final String sectordeatail_img_VSWRtest = "img_VSWRtest";
    private static final String sectordeatail_edt_URS = "edt_URS";
    private static final String sectordeatail_img_URS = "img_URS";
    private static final String sectordeatail_edt_extra1 = "edt_extra1";
    private static final String sectordeatail_img_extra1 = "img_extra1";
    private static final String sectordeatail_edt_extra2 = "edt_extra2";
    private static final String sectordeatail_img_extra2 = "img_extra2";
    private static final String sectordeatail_edt_remak1 = "edt_remak1";
    private static final String sectordeatail_img_remark1 = "img_remark1";
    private static final String sectordeatail_edt_remak2 = "edt_remak2";
    private static final String sectordeatail_img_remark2 = "img_remark2";
    private static final String sectordeatailfrgamentname = "sectorname";
    private static final String sectordeatail_flag = "flag";
    private static final String sectordeatail_date = "date";
    private static final String sdbasebandUnitType_edt="basebandUnitType_edt";
    private  static final String sdbasebandUnitType_img="basebandUnitType_img";
    private  static final String sdrNCName_edt = "rNCName_edt";
    private  static final String sdrNCName_img = "rNCName_img";
    private  static final String sdnoofChannelElements_edt = "noofChannelElements_edt";
    private  static final String sdnoofChannelElements_img = "noofChannelElements_img";

    private static final String otherid = "id";
    private  static final String edtRiggerPic ="edtRiggerPic";
    private static final String edtEngineerPic = "edtEngineerPic";
    private static final String edtCarPic = "edtCarPic";
    private static final String edt_RiggerPicwithclimbingTower = "edt_RiggerPicwithclimbingTower";
    private static final String edtRiggerPicduringWah = "edtRiggerPicduringWah";
    private static final String iv_RiggerPic = "iv_RiggerPic";
    private static final String iv_EngineerPic = "iv_EngineerPic";
    private static final String iv_CarPic = "iv_CarPic";
    private static final String iv_RiggerPicwithclimbingTower = "iv_RiggerPicwithclimbingTower";
    private static final String iv_RiggerPicduringWah = "iv_RiggerPicduringWah";
    private static final String otherdate = "date";
    private static final String otherflag = "flag";

    public DatabaseHandler(Context context) {
        super(context, "/mnt/sdcard/lhqdatabase11.db", null, DATABASE_VERSION);
        // super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.v(TAG, "Databaser object created");
    }

    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_SURVEYFORM = "CREATE TABLE " + TABLE_SURVEYFORM + "(" + KEY_INCRI_ID + " integer primary key autoincrement,"
                + KEY_SURVEYTYPE + " TEXT," + KEY_CUSTOMER + " TEXT," + KEY_OPERATER + " TEXT," + KEY_CIRCLE + " TEXT,"
                + KEY_TECHNOLOGY + " TEXT," + KEY_TECHNOLOGYTYPE + " TEXT," + KEY_LOCATION + " TEXT," + KEY_SITEID + " TEXT," + KEY_DATE + " TEXT," + KEY_LAT + " TEXT," + KEY_LOG + " TEXT," + KEY_FLAG + " integer," +KEY_CLUSTERID + " TEXT" + ")";

        String CREATE_TABLE_SITEDETAIL = "CREATE TABLE " + TABLE_SITEDETAIL + "(" + keyincriid + " integer primary key autoincrement,"
                + keysiteid + " TEXT," + keysiteid_photo + " TEXT," + keysitename + " TEXT," + keysitename_photo + " TEXT," + keytowersiteid + " TEXT,"
                + keytowersiteid_photo + " TEXT," + keytowercompanyname + " TEXT," + keytowercompanyname__photo + " TEXT," + keysiteaddress + " TEXT," + keysiteaddress_photo + " TEXT," + keysectorid + " TEXT," + keysectorid_photo + " TEXT," + keylat + " TEXT," + keylog + " TEXT," + keysitetype + " TEXT," + keysitetype_photo + " TEXT,"
                + keybuildingfloor + " TEXT," + keybuildingfloor_photo + " TEXT,"
                + keybuildingheight + " TEXT," + keybuildingheight_photo + " TEXT," + keytowerheight + " TEXT," + keytowerheight_photo + " TEXT," + keyfulltowerphoto + " TEXT," + keyfulltowerphoto_photo + " TEXT," + keynodebtype + " TEXT," + keynodebtype_photo + " TEXT," + keyclassical + " TEXT," + keyclassical_photo + " TEXT," + keyenodebtype + " TEXT," + keyenodebtype_photo + " TEXT," + keyanchoroperator + " TEXT," + keyanchoroperator_photo + " TEXT," + keysharingopco1 + " TEXT," + keysharingopco1_photo + " TEXT," + keysharingopco2 + " TEXT," + keysharingopco2_photo + " TEXT," + keysharingopco3 + " TEXT," + keysharingopco3_photo + " TEXT,"
                + keyinfraprovider + " TEXT," + keyinfraprovider_photo + " TEXT," + keytype_id_od + " TEXT," + keytype_id_od_photo + " TEXT," + keyinfrashared + " TEXT," + keyinfrashared_photo + " TEXT," + keyextra1 + " TEXT," + keyextra1_photo + " TEXT," + keyextra2 + " TEXT," + keyextra2_photo + " TEXT," + keyremark1 + " TEXT," + keyremark1_photo + " TEXT," + keyremark2 + " TEXT," + keyremark2_photo + " TEXT," + keyflag + " integer," +keydate + " TEXT"+ ")";


        String CREATE_TABLE_SITEPANOROMIC = "CREATE TABLE " + TABLE_SITEPANOROMIC + "(" + SPTVID + " integer primary key autoincrement," + SPTVBEARING0 + " TEXT," + SPTVBEARING30 + " TEXT," + SPTVBEARING60 + " TEXT," + SPTVBEARING90 + " TEXT," + SPTVBEARING120 + " TEXT,"
                + SPTVBEARING150 + " TEXT," + SPTVBEARING180 + " TEXT," + SPTVBEARING210 + " TEXT," + SPTVBEARING240 + " TEXT," + SPTVBEARING270 + " TEXT," + SPTVBEARING300 + " TEXT," + SPTVBEARING330 + " TEXT,"
                + SPIMGBEARING0 + " TEXT," + SPIMGBEARING30 + " TEXT," + SPIMGBEARING60 + " TEXT," + SPIMGBEARING90 + " TEXT,"
                + SPIMGBEARING120 + " TEXT," + SPIMGBEARING150 + " TEXT," + SPIMGBEARING180 + " TEXT," + SPIMGBEARING210 + " TEXT,"
                + SPIMGBEARING240 + " TEXT," + SPIMGBEARING270 + " TEXT," + SPIMGBEARING300 + " TEXT," + SPIMGBEARING330 + " TEXT,"
                + SPEXTRA1 + " TEXT," + SPEXTRA2 + " TEXT," + SPREMARK1 + " TEXT," + SPREMARK2 + " TEXT," + SPFLAG + " integer,"  +SPDATE + " TEXT"+ ")";


        String CREATE_TABLE_SITEPANOROMICBLOCKING = "CREATE TABLE " + TABLE_SITEPANOROMICBLOCKING + "(" + SPBLOCKINGID + " integer primary key autoincrement,"
                + SPBLOCKING0 + " TEXT," + SPBLOCKING30 + " TEXT," + SPBLOCKING60 + " TEXT," + SPBLOCKING90 + " TEXT," + SPBLOCKING120 + " TEXT,"
                + SPBLOCKING150 + " TEXT," + SPBLOCKING180 + " TEXT," + SPBLOCKING210 + " TEXT," + SPBLOCKING240 + " TEXT," + SPBLOCKING270 + " TEXT,"
                + SPBLOCKING300 + " TEXT," + SPBLOCKING330 + " TEXT," + SPBLOCKINGFLAG + " integer" + ")";


        String CREATE_TABLE_SECTORDETAIL = "CREATE TABLE " + TABLE_SECTORDETAIL + "(" + sectordetail_id + " integer primary key autoincrement," + sectordetail_edt_techavailable + " TEXT," +
                sectordetail_img_techavailable + " TEXT," + sectordetail_edt_bandavailable + " TEXT," + sectordeatail_img_bandavailable + " TEXT," + sectordeatail_edt_APC
                + " TEXT," + sectordeatail_img_APC + " TEXT," + sectoreatail_edt_preazimuth + " TEXT," + sectordeatail_img_preazimuth + " TEXT," + sectordeatail_edt_postazimuth
                + " TEXT," + sectordeatail_img_postazimuth + " TEXT," + sectordeatail_edt_premechanical_tilt + " TEXT," + sectordeatail_img_premechanical_tilt + " TEXT," + sectordeatail_edt_postmechanical_tilt
                + " TEXT," + sectordeatail_img_postmechanical_tilt + " TEXT," + sectordeatail_edt_preelectrical_tilt2g + " TEXT," + sectordeatail_img_preelectrical_tilt2g
                + " TEXT," + sectordeatail_edt_postelectrical_tilt2g + " TEXT," + sectordeatail_img_postelectrical_tilt2g + " TEXT," + sectordeatail_edt_preelectrical_tilt3g
                + " TEXT," + sectordeatail_img_pretelectrical_tilt3g + " TEXT," + sectordeatail_edt_postelectrical_tilt3g + " TEXT," + sectordeatail_img_postelectrical_tilt3g
                + " TEXT," + sectordeatail_edt_preelectrical_tilt4gf1 + " TEXT," + sectordeatail_img_preelectrical_tilt4gf1 + " TEXT," + sectordeatail_edt_postelectrical_tilt4gf1
                + " TEXT," + sectordeatail_img_postelectrical_tilt4gf1 + " TEXT," + sectordeatail_edt_preelectrical_tilt4gf2 + " TEXT," + sectordeatail_img_preelectrical_tilt4gf2
                + " TEXT," + sectordeatail_edt_postelectrical_tilt4gf2 + " TEXT," + sectordeatail_img_postelectrical_tilt4gf2 + " TEXT," + sectordeatail_edt_preelectrical_tilt
                + " TEXT," + sectordeatail_img_preelectrical_tilt + " TEXT," + sectordeatail_edt_postelectrical_tilt + " TEXT," + sectordeatail_img_postelectrical_tilt + " TEXT," + sectordeatail_edt_antennaheight
                + " TEXT," + sectordeatail_img_antennaheight + " TEXT," + sectordeatail_edt_poleheight + " TEXT," + sectordeatail_img_poleheight + " TEXT," + sectordeatail_edt_buildingheight + " TEXT," + sectordeatail_img_buildingheight
                + " TEXT," + sectordeatail_edt_towertype + " TEXT," + sectordeatail_img_towertype + " TEXT," + sectordeatail_edt_antennamake + " TEXT," + sectordeatail_img_antennamake
                + " TEXT," + sectordeatail_edt_antenmodel + " TEXT," + sectordeatail_img_antennamodel + " TEXT," + sectordeatail_edt_clutterpic + " TEXT," + sectordeatail_img_clutterpic
                + " TEXT," + sectordeatail_edt_txbandwidth + " TEXT," + sectordeatail_img_txbandwidth + " TEXT," + sectordeatail_edt_AST + " TEXT," + sectordeatail_img_AST
                + " TEXT," + sectordeatail_edt_APST + " TEXT," + sectordeatail_img_APST + " TEXT," + sectordeatail_edt_typ_enodeb + " TEXT," + sectordeatail_img_typ_enodeb + " TEXT," + sectordeatail_edt_mimo
                + " TEXT," + sectordeatail_img_mimo + " TEXT," + sectordeatail_edt_ret + " TEXT," + sectordeatail_img_ret + " TEXT," + sectordeatail_edt_enodebband + " TEXT," + sectordeatail_img_enodebband
                + " TEXT," + sectordeatail_edt_MOP + " TEXT," + sectordeatail_img_MOP + " TEXT," + sectordeatail_edt_COP + " TEXT," + sectordeatail_img_COP + " TEXT," + sectordeatail_edt_multiplexer_avail
                + " TEXT," + sectordeatail_img_multiplexer_avail + " TEXT," + sectordeatail_edt_antennapicleg + " TEXT," + sectordeatail_img_antennapicleg + " TEXT," + sectordeatail_edt_CRP
                + " TEXT," + sectordeatail_img_CRP + " TEXT," + sectordeatail_edt_powerdeboosting + " TEXT," + sectordeatail_img_powerdeboosting + " TEXT," + sectordeatail_edt_DFS
                + " TEXT," + sectordeatail_img_DFS + " TEXT," + sectordeatail_edt_rb_percell + " TEXT," + sectordeatail_img_rb_percell + " TEXT," + sectordeatail_edt_m_mimo + " TEXT," + sectordeatail_img_m_mimo
                + " TEXT," + sectordeatail_edt_FCT + " TEXT," + sectordeatail_img_FCT + " TEXT," + sectordeatail_edt_JCT + " TEXT," + sectordeatail_img_JCT + " TEXT," + sectordeatail_edt_FCL
                + " TEXT," + sectordeatail_img_FCL + " TEXT," + sectordeatail_edt_jumperlength + " TEXT," + sectordeatail_img_jumperlength + " TEXT," + sectordeatail_edt_prachconfig_index
                + " TEXT," + sectordeatail_img_prachconfig_index + " TEXT," + sectordeatail_edt_carrieraggregation + " TEXT," + sectordeatail_img_carrieraggregation + " TEXT," + sectordeatail_edt_ACD
                + " TEXT," + sectordeatail_img_ACD + " TEXT," + sectordeatail_edt_VSWRtest + " TEXT," + sectordeatail_img_VSWRtest + " TEXT," + sectordeatail_edt_URS + " TEXT," + sectordeatail_img_URS
                + " TEXT," + sectordeatail_edt_extra1 + " TEXT," + sectordeatail_img_extra1 + " TEXT," + sectordeatail_edt_extra2 + " TEXT," + sectordeatail_img_extra2 + " TEXT," + sectordeatail_edt_remak1
                + " TEXT," + sectordeatail_img_remark1 + " TEXT," + sectordeatail_edt_remak2 + " TEXT,"+ sectordeatail_img_remark2 + " TEXT,"  +  sectordeatailfrgamentname + " TEXT," + sectordeatail_flag + " integer,"  +sectordeatail_date + " TEXT,"+
                sdbasebandUnitType_edt+" TEXT,"+
       sdbasebandUnitType_img + " TEXT,"+ sdrNCName_edt +" TEXT,"+ sdrNCName_img +" TEXT,"+ sdnoofChannelElements_edt + " TEXT," +sdnoofChannelElements_img + " TEXT"+")";


        String CREATE_TABLE_OTHERDETAIL = "CREATE TABLE " + TABLE_OTHERDETAIL + "(" + otherid + " integer primary key autoincrement,"
                + edtRiggerPic + " TEXT," + edtEngineerPic + " TEXT," + edtCarPic + " TEXT," + edt_RiggerPicwithclimbingTower + " TEXT," + edtRiggerPicduringWah + " TEXT,"
                + iv_RiggerPic + " TEXT," + iv_EngineerPic + " TEXT," + iv_CarPic + " TEXT," + iv_RiggerPicwithclimbingTower + " TEXT," + iv_RiggerPicduringWah + " TEXT,"
                + otherdate + " TEXT," +  otherflag + " integer" + ")";

        db.execSQL(CREATE_TABLE_SURVEYFORM);
        db.execSQL(CREATE_TABLE_SITEDETAIL);
        db.execSQL(CREATE_TABLE_SITEPANOROMIC);
        db.execSQL(CREATE_TABLE_SITEPANOROMICBLOCKING);
        db.execSQL(CREATE_TABLE_SECTORDETAIL);
        db.execSQL(CREATE_TABLE_OTHERDETAIL);

        Log.v(TAG, "Database table created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SURVEYFORM);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SITEDETAIL);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SITEPANOROMIC);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SITEPANOROMICBLOCKING);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SECTORDETAIL);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_OTHERDETAIL);

        onCreate(db);
    }

    // code to add the new surveyform
    public void insertSurveyFormData(SurveyForm surveyForm) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_SURVEYTYPE, surveyForm.getSurveytype());
        values.put(KEY_CUSTOMER, surveyForm.getCustomer());
        values.put(KEY_OPERATER, surveyForm.getOperator());
        values.put(KEY_CIRCLE, surveyForm.getCircle());
        values.put(KEY_TECHNOLOGY, surveyForm.getTechnology());
        values.put(KEY_TECHNOLOGYTYPE, surveyForm.getTechnologytype());
        values.put(KEY_LOCATION, surveyForm.getLocation());
        values.put(KEY_SITEID, surveyForm.getSiteid());
        values.put(KEY_DATE, surveyForm.getDate());
        values.put(KEY_LAT, surveyForm.getLat());
        values.put(KEY_LOG, surveyForm.getLog());
        values.put(KEY_FLAG, surveyForm.getFlag());
        values.put(KEY_CLUSTERID, surveyForm.getCusterid());
        // Inserting Row
        db.insert(TABLE_SURVEYFORM, null, values);
        Log.v(TAG, "Databaser insert surveyform table");
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }


    public void deleteSingleRowSurveyformData(String value) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_SURVEYFORM + " WHERE " + KEY_SITEID + "='" + value + "'");
        db.close();
    }

    public void deleteSomeRow_Surveyform() {
        SQLiteDatabase db = this.getWritableDatabase();
        //  db.execSQL("delete from "+ TABLE_SURVEYFORM+" where " +KEY_INCRI_ID+ " not in ( select " +KEY_INCRI_ID+" from "+ TABLE_SURVEYFORM+" order by "+KEY_DATE +" desc limit 100)");
        db.execSQL("DELETE FROM " + TABLE_SURVEYFORM + " ;");

        db.close();
    }

    public List<SurveyForm> getAllSurveyformData() {
        List<SurveyForm> List = new ArrayList<SurveyForm>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_SURVEYFORM;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                SurveyForm data = new SurveyForm();
                data.setId(cursor.getInt(0));
                data.setSurveytype(cursor.getString(1));
                data.setCustomer(cursor.getString(2));
                data.setOperator(cursor.getString(3));
                data.setCircle(cursor.getString(4));
                data.setTechnology(cursor.getString(5));
                data.setTechnologytype(cursor.getString(6));
                data.setLocation(cursor.getString(7));
                data.setSiteid(cursor.getString(8));
                data.setDate(cursor.getString(9));
                data.setLat(cursor.getString(10));
                data.setLog(cursor.getString(11));
                data.setFlag(cursor.getInt(12));
                data.setCusterid(cursor.getString(13));
                // Adding contact to list
                List.add(data);
            } while (cursor.moveToNext());
        }
        // return contact list
        return List;
    }

    public List<SurveyForm> getLastSurveyformData() {
        ArrayList<SurveyForm> list = new ArrayList<SurveyForm>();
        // Select All Query
        // SELECT * FROM members ORDER BY date_of_birth DESC;
        //String selectQuery = "SELECT  * FROM " + TABLE_LATLONG +" ORDER BY "+KEY_LATLONG_INCRIID+" DESC LIMIT 1;";
        String selectQuery = "SELECT  * FROM " + TABLE_SURVEYFORM + " ORDER BY " + KEY_INCRI_ID + " DESC LIMIT 1";
        SQLiteDatabase db = this.getReadableDatabase();
        try {

            Cursor cursor = db.rawQuery(selectQuery, null);
            try {
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        SurveyForm data = new SurveyForm();
                        data.setId(cursor.getInt(0));
                        data.setSurveytype(cursor.getString(1));
                        data.setCustomer(cursor.getString(2));
                        data.setOperator(cursor.getString(3));
                        data.setCircle(cursor.getString(4));
                        data.setTechnology(cursor.getString(5));
                        data.setTechnologytype(cursor.getString(6));
                        data.setLocation(cursor.getString(7));
                        data.setSiteid(cursor.getString(8));
                        data.setDate(cursor.getString(9));
                        data.setLat(cursor.getString(10));
                        data.setLog(cursor.getString(11));
                        data.setFlag(cursor.getInt(12));
                        data.setCusterid(cursor.getString(13));
                        // Adding contact to list
                        list.add(data);
                    } while (cursor.moveToNext());
                }

            } finally {
                try {
                    cursor.close();

                } catch (Exception ignore) {
                }
            }

        } finally {
            try {
                db.close();
            } catch (Exception ignore) {

            }
        }
        return list;
    }

    public List<SiteIDandDate> getSiteIdandDate() {
        ArrayList<SiteIDandDate> list = new ArrayList<SiteIDandDate>();
        // Select All Query
        // SELECT * FROM members ORDER BY date_of_birth DESC;
        //String selectQuery = "SELECT  * FROM " + TABLE_LATLONG +" ORDER BY "+KEY_LATLONG_INCRIID+" DESC LIMIT 1;";

        String selectQuery = "SELECT  * FROM " + TABLE_SURVEYFORM + " ORDER BY " + KEY_INCRI_ID + " DESC LIMIT 1";
        SQLiteDatabase db = this.getReadableDatabase();
        try {

            Cursor cursor = db.rawQuery(selectQuery, null);
            try {
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        SiteIDandDate data = new SiteIDandDate();
                        data.setSiteid(cursor.getString(8));
                        data.setDate(cursor.getString(9));

                        // Adding contact to list
                        list.add(data);
                    } while (cursor.moveToNext());
                }

            } finally {
                try {
                    cursor.close();

                } catch (Exception ignore) {
                }
            }

        } finally {
            try {
                db.close();
            } catch (Exception ignore) {

            }
        }
        return list;
    }

    public int getLastInsertIdTABLE_SURVEYFORM() {
        int index = 0;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT  * FROM " + TABLE_SURVEYFORM, null);
        if (cursor.moveToLast()) {
            index = cursor.getInt(0);//to get id, 0 is the column index
        }
        cursor.close();
        return index;
    }
    public boolean updateSurveyForm(int incriid,  int flag) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues args = new ContentValues();

        args.put(KEY_FLAG, flag);
        //  args.put(KEY_LATLONG_TOTALDIST,dis);


        int i = db.update(TABLE_SURVEYFORM, args, KEY_INCRI_ID + "=" + incriid, null);
        return i > 0;
    }
    public List<SurveyForm> getAllSurveyformORDerBy() {
        ArrayList<SurveyForm> list = new ArrayList<SurveyForm>();
        // Select All Query
        // SELECT * FROM members ORDER BY date_of_birth DESC;
        String selectQuery = "SELECT  * FROM " + TABLE_SURVEYFORM + " ORDER BY " + KEY_INCRI_ID + " ASC;";
        SQLiteDatabase db = this.getReadableDatabase();
        try {

            Cursor cursor = db.rawQuery(selectQuery, null);
            try {
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        SurveyForm data = new SurveyForm();
                        data.setId(cursor.getInt(0));
                        data.setSurveytype(cursor.getString(1));
                        data.setCustomer(cursor.getString(2));
                        data.setOperator(cursor.getString(3));
                        data.setCircle(cursor.getString(4));
                        data.setTechnology(cursor.getString(5));
                        data.setTechnologytype(cursor.getString(6));
                        data.setLocation(cursor.getString(7));
                        data.setSiteid(cursor.getString(8));
                        data.setDate(cursor.getString(9));
                        data.setLat(cursor.getString(10));
                        data.setLog(cursor.getString(11));
                        data.setFlag(cursor.getInt(12));
                        data.setCusterid(cursor.getString(13));
                        //you could add additional columns here..

                        list.add(data);
                    } while (cursor.moveToNext());
                }

            } finally {
                try {
                    cursor.close();

                } catch (Exception ignore) {
                }
            }

        } finally {
            try {
                db.close();
            } catch (Exception ignore) {

            }
        }

        return list;
    }


    // Getting AddBusData Count
    public int getCountSurveyform() {
        String countQuery = "SELECT  * FROM " + TABLE_SURVEYFORM;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();

        // return count
        return count;
    }

    // code to add the new siteDetail
    public void insertSiteDetailData(SiteDetailForm siteDetailForm) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {

            ContentValues values = new ContentValues();
            values.put(keysiteid, siteDetailForm.getSiteid());
            values.put(keysiteid_photo, siteDetailForm.getSiteid_photo());
            values.put(keysitename, siteDetailForm.getSitename());
            values.put(keysitename_photo, siteDetailForm.getSitename_photo());
            values.put(keytowersiteid, siteDetailForm.getTowersiteid());
            values.put(keytowersiteid_photo, siteDetailForm.getTowersiteid_photo());
            values.put(keytowercompanyname, siteDetailForm.getTowercompanyname());
            values.put(keytowercompanyname__photo, siteDetailForm.getTowercompanyname__photo());
            values.put(keysiteaddress, siteDetailForm.getSiteaddress());
            values.put(keysiteaddress_photo, siteDetailForm.getSiteaddress_photo());

            values.put(keysectorid, siteDetailForm.getSectorid());
            values.put(keysectorid_photo, siteDetailForm.getSiteid_photo());
            values.put(keylat, siteDetailForm.getLat());
            values.put(keylog, siteDetailForm.getLog());
            values.put(keysitetype, siteDetailForm.getSitetype());
            values.put(keysitetype_photo, siteDetailForm.getSitetype_photo());
            values.put(keybuildingfloor, siteDetailForm.getBuildingfloor());
            values.put(keybuildingfloor_photo, siteDetailForm.getBuildingfloor_photo());
            values.put(keybuildingheight, siteDetailForm.getBuildingheight());
            values.put(keybuildingheight_photo, siteDetailForm.getBuildingheight_photo());
            values.put(keytowerheight, siteDetailForm.getTowerheight());
            values.put(keytowerheight_photo, siteDetailForm.getTowerheight_photo());
            values.put(keyfulltowerphoto, siteDetailForm.getFulltowerphoto());
            values.put(keyfulltowerphoto_photo, siteDetailForm.getFulltowerphoto_photo());
            values.put(keynodebtype, siteDetailForm.getNodebtype());
            values.put(keynodebtype_photo, siteDetailForm.getNodebtype_photo());
            values.put(keyclassical, siteDetailForm.getClassical());
            values.put(keyclassical_photo, siteDetailForm.getClassical_photo());
            values.put(keyenodebtype, siteDetailForm.getEnodebtype());
            values.put(keyenodebtype_photo, siteDetailForm.getEnodebtype_photo());
            values.put(keyanchoroperator, siteDetailForm.getAnchoroperator());
            values.put(keyanchoroperator_photo, siteDetailForm.getAnchoroperator_photo());
            values.put(keysharingopco1, siteDetailForm.getSharingopco1());
            values.put(keysharingopco1_photo, siteDetailForm.getSharingopco1_photo());
            values.put(keysharingopco2, siteDetailForm.getSharingopco2());
            values.put(keysharingopco2_photo, siteDetailForm.getSharingopco2_photo());
            values.put(keysharingopco3, siteDetailForm.getSharingopco3());
            values.put(keysharingopco3_photo, siteDetailForm.getSharingopco3_photo());
            values.put(keyinfraprovider, siteDetailForm.getInfraprovider());
            values.put(keyinfraprovider_photo, siteDetailForm.getInfraprovider_photo());
            values.put(keytype_id_od, siteDetailForm.getType_id_od());
            values.put(keytype_id_od_photo, siteDetailForm.getType_id_od_photo());
            values.put(keyinfrashared, siteDetailForm.getInfrashared());
            values.put(keyinfrashared_photo, siteDetailForm.getInfrashared_photo());
            values.put(keyextra1, siteDetailForm.getExtra1());
            values.put(keyextra1_photo, siteDetailForm.getExtra1_photo());
            values.put(keyextra2, siteDetailForm.getExtra2());
            values.put(keyextra2_photo, siteDetailForm.getExtra2_photo());
            values.put(keyremark1, siteDetailForm.getRemark1());
            values.put(keyremark1_photo, siteDetailForm.getRemark1_photo());
            values.put(keyremark2, siteDetailForm.getRemark2());
            values.put(keyremark2_photo, siteDetailForm.getRemark2_photo());
            values.put(keyflag, siteDetailForm.getFlag());
            values.put(keydate, siteDetailForm.getDate());
            // Inserting Row
            db.insert(TABLE_SITEDETAIL, null, values);
        } catch (Exception ignor) {
            Log.v(TAG, "Databaser insert sitedetail error");
        }
        Log.v(TAG, "Databaser insert sitedetail table");
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    public List<SiteDetailForm> getLastSiteDetailData() {
        ArrayList<SiteDetailForm> list = new ArrayList<SiteDetailForm>();
        // Select All Query
        // SELECT * FROM members ORDER BY date_of_birth DESC;
        //String selectQuery = "SELECT  * FROM " + TABLE_LATLONG +" ORDER BY "+KEY_LATLONG_INCRIID+" DESC LIMIT 1;";

        String selectQuery = "SELECT  * FROM " + TABLE_SITEDETAIL + " ORDER BY " + keyincriid + " DESC LIMIT 1";

        SQLiteDatabase db = this.getReadableDatabase();
        try {

            Cursor cursor = db.rawQuery(selectQuery, null);
            try {
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        SiteDetailForm siteDetailForm = new SiteDetailForm();
                        siteDetailForm.setId(cursor.getInt(0));
                        siteDetailForm.setSiteid(cursor.getString(1));
                        siteDetailForm.setSiteid_photo(cursor.getString(2));
                        siteDetailForm.setSitename(cursor.getString(3));
                        siteDetailForm.setSitename_photo(cursor.getString(4));
                        siteDetailForm.setTowersiteid(cursor.getString(5));
                        siteDetailForm.setTowersiteid_photo(cursor.getString(6));
                        siteDetailForm.setTowercompanyname(cursor.getString(7));
                        siteDetailForm.setTowercompanyname__photo(cursor.getString(8));
                        siteDetailForm.setSiteaddress(cursor.getString(9));
                        siteDetailForm.setSiteaddress_photo(cursor.getString(10));
                        siteDetailForm.setSectorid(cursor.getString(11));
                        siteDetailForm.setSectorid_photo(cursor.getString(12));
                        siteDetailForm.setLat(cursor.getString(13));
                        siteDetailForm.setLog(cursor.getString(14));
                        siteDetailForm.setSitetype(cursor.getString(15));
                        siteDetailForm.setSitetype_photo(cursor.getString(16));
                        siteDetailForm.setBuildingfloor(cursor.getString(17));
                        siteDetailForm.setBuildingfloor_photo(cursor.getString(18));
                        siteDetailForm.setBuildingheight(cursor.getString(19));
                        siteDetailForm.setBuildingheight_photo(cursor.getString(20));
                        siteDetailForm.setTowerheight(cursor.getString(21));
                        siteDetailForm.setTowerheight_photo(cursor.getString(22));
                        siteDetailForm.setFulltowerphoto(cursor.getString(23));
                        siteDetailForm.setFulltowerphoto_photo(cursor.getString(24));
                        siteDetailForm.setNodebtype(cursor.getString(25));
                        siteDetailForm.setNodebtype_photo(cursor.getString(26));
                        siteDetailForm.setClassical(cursor.getString(27));
                        siteDetailForm.setClassical_photo(cursor.getString(28));
                        siteDetailForm.setEnodebtype(cursor.getString(29));
                        siteDetailForm.setEnodebtype_photo(cursor.getString(30));
                        siteDetailForm.setAnchoroperator(cursor.getString(31));
                        siteDetailForm.setAnchoroperator_photo(cursor.getString(32));
                        siteDetailForm.setSharingopco1(cursor.getString(33));
                        siteDetailForm.setSharingopco1_photo(cursor.getString(34));
                        siteDetailForm.setSharingopco2(cursor.getString(35));
                        siteDetailForm.setSharingopco2_photo(cursor.getString(36));
                        siteDetailForm.setSharingopco3(cursor.getString(37));
                        siteDetailForm.setSharingopco3_photo(cursor.getString(38));
                        siteDetailForm.setInfraprovider(cursor.getString(39));
                        siteDetailForm.setInfraprovider_photo(cursor.getString(40));
                        siteDetailForm.setType_id_od(cursor.getString(41));
                        siteDetailForm.setType_id_od_photo(cursor.getString(42));
                        siteDetailForm.setInfrashared(cursor.getString(43));
                        siteDetailForm.setInfrashared_photo(cursor.getString(44));
                        siteDetailForm.setExtra1(cursor.getString(45));
                        siteDetailForm.setExtra1_photo(cursor.getString(46));
                        siteDetailForm.setExtra2(cursor.getString(47));
                        siteDetailForm.setExtra2_photo(cursor.getString(48));
                        siteDetailForm.setRemark1(cursor.getString(49));
                        siteDetailForm.setRemark1_photo(cursor.getString(50));
                        siteDetailForm.setRemark2(cursor.getString(51));
                        siteDetailForm.setRemark2_photo(cursor.getString(52));
                        siteDetailForm.setFlag(cursor.getInt(53));
                        siteDetailForm.setDate(cursor.getString(54));

                        // Adding contact to list
                        list.add(siteDetailForm);
                        Log.v("datbase",list.toString());
                    } while (cursor.moveToNext());
                }

            } finally {
                try {
                    cursor.close();

                } catch (Exception ignore) {
                    ignore.printStackTrace();
                }
            }

        } finally {
            try {
                db.close();
            } catch (Exception ignore) {

            }
        }
        return list;
    }
    public int getLastInsertIdTABLE_SITEDETAIL() {
        int index = 0;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT  * FROM " + TABLE_SITEDETAIL, null);
        if (cursor.moveToLast()) {
            index = cursor.getInt(0);//to get id, 0 is the column index
        }
        cursor.close();
        return index;
    }
    public boolean updateSITEDETAIL(int incriid,  int flag) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues args = new ContentValues();

        args.put(keyflag, flag);
        //  args.put(KEY_LATLONG_TOTALDIST,dis);
        int i = db.update(TABLE_SITEDETAIL, args, keyincriid + "=" + incriid, null);
        return i > 0;
    }
    public int getCountSiteDetail() {
        String countQuery = "SELECT  * FROM " + TABLE_SITEDETAIL;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        // return count
        return count;
    }

    // code to add the new sitePanoramic
    public void insertSitePanoramicata(SitePanoramicData sitePanoramicData) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put(SPTVBEARING0, sitePanoramicData.getTvBearing0());
            values.put(SPTVBEARING30, sitePanoramicData.getTvBearing30());
            values.put(SPTVBEARING60, sitePanoramicData.getTvBearing60());
            values.put(SPTVBEARING90, sitePanoramicData.getTvBearing90());
            values.put(SPTVBEARING120, sitePanoramicData.getTvBearing120());
            values.put(SPTVBEARING150, sitePanoramicData.getTvBearing150());
            values.put(SPTVBEARING180, sitePanoramicData.getTvBearing180());
            values.put(SPTVBEARING210, sitePanoramicData.getTvBearing210());
            values.put(SPTVBEARING240, sitePanoramicData.getTvBearing240());
            values.put(SPTVBEARING270, sitePanoramicData.getTvBearing270());
            values.put(SPTVBEARING300, sitePanoramicData.getTvBearing300());
            values.put(SPTVBEARING330, sitePanoramicData.getTvBearing330());

            values.put(SPIMGBEARING0, sitePanoramicData.getBtnBearing0Image());
            values.put(SPIMGBEARING30, sitePanoramicData.getBtnBearing30Image());
            values.put(SPIMGBEARING60, sitePanoramicData.getBtnBearing60Image());
            values.put(SPIMGBEARING90, sitePanoramicData.getBtnBearing90Image());
            values.put(SPIMGBEARING120, sitePanoramicData.getBtnBearing120Image());
            values.put(SPIMGBEARING150, sitePanoramicData.getBtnBearing150Image());
            values.put(SPIMGBEARING180, sitePanoramicData.getBtnBearing180Image());
            values.put(SPIMGBEARING210, sitePanoramicData.getBtnBearing210Image());
            values.put(SPIMGBEARING240, sitePanoramicData.getBtnBearing240Image());
            values.put(SPIMGBEARING270, sitePanoramicData.getBtnBearing270Image());
            values.put(SPIMGBEARING300, sitePanoramicData.getBtnBearing300Image());
            values.put(SPIMGBEARING330, sitePanoramicData.getBtnBearing330Image());

            values.put(SPEXTRA1, sitePanoramicData.getInputBearin_extra1());
            values.put(SPEXTRA2, sitePanoramicData.getInputBearin_extra2());
            values.put(SPREMARK1, sitePanoramicData.getInputBearin_remark1());
            values.put(SPREMARK2, sitePanoramicData.getInputBearin_remark2());
            values.put(SPFLAG, sitePanoramicData.getFlag());
            values.put(SPDATE, sitePanoramicData.getDate());
            // Inserting Row
            db.insert(TABLE_SITEPANOROMIC, null, values);
        } catch (Exception ignor) {
            Log.v(TAG, "Databaser insert sitepanoramic error");
        }
        Log.v(TAG, "Databaser insert sitepanoramic table");
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    public List<SitePanoramicData> getLastSitePanaromicData() {
        ArrayList<SitePanoramicData> list = new ArrayList<SitePanoramicData>();
        // Select All Query
        // SELECT * FROM members ORDER BY date_of_birth DESC;
        //String selectQuery = "SELECT  * FROM " + TABLE_LATLONG +" ORDER BY "+KEY_LATLONG_INCRIID+" DESC LIMIT 1;";

        String selectQuery = "SELECT  * FROM " + TABLE_SITEPANOROMIC + " ORDER BY " + SPTVID + " DESC LIMIT 1";

        SQLiteDatabase db = this.getReadableDatabase();
        try {

            Cursor cursor = db.rawQuery(selectQuery, null);
            try {
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        SitePanoramicData sitePanoramicData = new SitePanoramicData();
                        sitePanoramicData.setId(cursor.getInt(0));
                        sitePanoramicData.setTvBearing0(cursor.getString(1));
                        sitePanoramicData.setTvBearing30(cursor.getString(2));
                        sitePanoramicData.setTvBearing60(cursor.getString(3));
                        sitePanoramicData.setTvBearing90(cursor.getString(4));
                        sitePanoramicData.setTvBearing120(cursor.getString(5));
                        sitePanoramicData.setTvBearing150(cursor.getString(6));
                        sitePanoramicData.setTvBearing180(cursor.getString(7));
                        sitePanoramicData.setTvBearing210(cursor.getString(8));
                        sitePanoramicData.setTvBearing240(cursor.getString(9));
                        sitePanoramicData.setTvBearing270(cursor.getString(10));
                        sitePanoramicData.setTvBearing300(cursor.getString(11));
                        sitePanoramicData.setTvBearing330(cursor.getString(12));
                        sitePanoramicData.setBtnBearing0Image(cursor.getString(13));
                        sitePanoramicData.setBtnBearing30Image(cursor.getString(14));
                        sitePanoramicData.setBtnBearing60Image(cursor.getString(15));
                        sitePanoramicData.setBtnBearing90Image(cursor.getString(16));
                        sitePanoramicData.setBtnBearing120Image(cursor.getString(17));
                        sitePanoramicData.setBtnBearing150Image(cursor.getString(18));
                        sitePanoramicData.setBtnBearing180Image(cursor.getString(19));
                        sitePanoramicData.setBtnBearing210Image(cursor.getString(20));
                        sitePanoramicData.setBtnBearing240Image(cursor.getString(21));
                        sitePanoramicData.setBtnBearing270Image(cursor.getString(22));
                        sitePanoramicData.setBtnBearing300Image(cursor.getString(23));
                        sitePanoramicData.setBtnBearing330Image(cursor.getString(24));
                        sitePanoramicData.setInputBearin_extra1(cursor.getString(25));
                        sitePanoramicData.setInputBearin_extra2(cursor.getString(26));
                        sitePanoramicData.setInputBearin_remark1(cursor.getString(27));
                        sitePanoramicData.setInputBearin_remark2(cursor.getString(28));
                        sitePanoramicData.setFlag(cursor.getInt(29));
                        sitePanoramicData.setDate(cursor.getString(30));
                        // Adding contact to list
                        list.add(sitePanoramicData);
                    } while (cursor.moveToNext());
                }

            } finally {
                try {
                    cursor.close();

                } catch (Exception ignore) {
                }
            }

        } finally {
            try {
                db.close();
            } catch (Exception ignore) {

            }
        }
        return list;
    }

    public int getCountSitePanaromic() {
        String countQuery = "SELECT  * FROM " + TABLE_SITEPANOROMIC;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        // return count
        return count;
    }

    // code to add the new sitePanoramicBlocking
    public void insertSitePanoramicBlockingata(SitePanoramicBlockingData sitePanoramicBlockingData) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put(SPBLOCKING0, sitePanoramicBlockingData.getBlocking0());
            values.put(SPBLOCKING30, sitePanoramicBlockingData.getBlocking30());
            values.put(SPBLOCKING60, sitePanoramicBlockingData.getBlocking60());
            values.put(SPBLOCKING90, sitePanoramicBlockingData.getBlocking90());
            values.put(SPBLOCKING120, sitePanoramicBlockingData.getBlocking120());
            values.put(SPBLOCKING150, sitePanoramicBlockingData.getBlocking150());
            values.put(SPBLOCKING180, sitePanoramicBlockingData.getBlocking180());
            values.put(SPBLOCKING210, sitePanoramicBlockingData.getBlocking210());
            values.put(SPBLOCKING240, sitePanoramicBlockingData.getBlocking240());
            values.put(SPBLOCKING270, sitePanoramicBlockingData.getBlocking270());
            values.put(SPBLOCKING300, sitePanoramicBlockingData.getBlocking300());
            values.put(SPBLOCKING330, sitePanoramicBlockingData.getBlocking330());
            values.put(SPBLOCKINGFLAG, sitePanoramicBlockingData.getFlag());
            // Inserting Row
            db.insert(TABLE_SITEPANOROMICBLOCKING, null, values);
        } catch (Exception ignor) {
            Log.v(TAG, "Databaser insert sitepanoramicblocking error");
        }
        Log.v(TAG, "Databaser insert sitepanoramicblocking table");
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    public List<SitePanoramicBlockingData> getLastSitePanaromicBlockingData() {
        ArrayList<SitePanoramicBlockingData> list = new ArrayList<SitePanoramicBlockingData>();
        // Select All Query
        // SELECT * FROM members ORDER BY date_of_birth DESC;
        //String selectQuery = "SELECT  * FROM " + TABLE_LATLONG +" ORDER BY "+KEY_LATLONG_INCRIID+" DESC LIMIT 1;";

        String selectQuery = "SELECT  * FROM " + TABLE_SITEPANOROMICBLOCKING + " ORDER BY " + SPBLOCKINGID + " DESC LIMIT 1";

        SQLiteDatabase db = this.getReadableDatabase();
        try {

            Cursor cursor = db.rawQuery(selectQuery, null);
            try {
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        SitePanoramicBlockingData sitePanoramicBlockingData = new SitePanoramicBlockingData();
                        sitePanoramicBlockingData.setId(cursor.getInt(0));
                        sitePanoramicBlockingData.setBlocking0(cursor.getString(1));
                        ;
                        sitePanoramicBlockingData.setBlocking30(cursor.getString(2));
                        sitePanoramicBlockingData.setBlocking60(cursor.getString(3));
                        sitePanoramicBlockingData.setBlocking90(cursor.getString(4));
                        sitePanoramicBlockingData.setBlocking120(cursor.getString(5));
                        sitePanoramicBlockingData.setBlocking150(cursor.getString(6));
                        sitePanoramicBlockingData.setBlocking180(cursor.getString(7));
                        sitePanoramicBlockingData.setBlocking210(cursor.getString(8));
                        sitePanoramicBlockingData.setBlocking240(cursor.getString(9));
                        sitePanoramicBlockingData.setBlocking270(cursor.getString(10));
                        sitePanoramicBlockingData.setBlocking300(cursor.getString(11));
                        sitePanoramicBlockingData.setBlocking330(cursor.getString(12));
                        sitePanoramicBlockingData.setFlag(cursor.getInt(13));
                        // Adding contact to list
                        list.add(sitePanoramicBlockingData);
                    } while (cursor.moveToNext());
                }

            } finally {
                try {
                    cursor.close();

                } catch (Exception ignore) {
                }
            }

        } finally {
            try {
                db.close();
            } catch (Exception ignore) {

            }
        }
        return list;
    }

    // code to add the new sitePanoramic
    public void insertSectorDetailData(SectorDetailData sectorDetailData) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put(sectordetail_edt_techavailable, sectorDetailData.getSectordetail_edt_techavailable());
            values.put(sectordetail_img_techavailable, sectorDetailData.getSectordetail_img_techavailable());
            values.put(sectordetail_edt_bandavailable, sectorDetailData.getSectordetail_edt_bandavailable());
            values.put(sectordeatail_img_bandavailable, sectorDetailData.getSectordeatail_img_bandavailable());
            values.put(sectordeatail_edt_APC, sectorDetailData.getSectordeatail_edt_APC());
            values.put(sectordeatail_img_APC, sectorDetailData.getSectordeatail_img_APC());
            values.put(sectoreatail_edt_preazimuth, sectorDetailData.getSectoreatail_edt_preazimuth());
            values.put(sectordeatail_img_preazimuth, sectorDetailData.getSectordeatail_img_preazimuth());
            values.put(sectordeatail_edt_postazimuth, sectorDetailData.getSectordeatail_edt_postazimuth());
            values.put(sectordeatail_img_postazimuth, sectorDetailData.getSectordeatail_img_postazimuth());
            values.put(sectordeatail_edt_premechanical_tilt, sectorDetailData.getSectordeatail_edt_premechanical_tilt());
            values.put(sectordeatail_img_premechanical_tilt, sectorDetailData.getSectordeatail_img_premechanical_tilt());
            values.put(sectordeatail_edt_postmechanical_tilt, sectorDetailData.getSectordeatail_edt_postmechanical_tilt());
            values.put(sectordeatail_img_postmechanical_tilt, sectorDetailData.getSectordeatail_img_postmechanical_tilt());
            values.put(sectordeatail_edt_preelectrical_tilt2g, sectorDetailData.getSectordeatail_edt_preelectrical_tilt2g());
            values.put(sectordeatail_img_preelectrical_tilt2g, sectorDetailData.getSectordeatail_img_preelectrical_tilt2g());
            values.put(sectordeatail_edt_postelectrical_tilt2g, sectorDetailData.getSectordeatail_edt_postelectrical_tilt2g());
            values.put(sectordeatail_img_postelectrical_tilt2g, sectorDetailData.getSectordeatail_img_postelectrical_tilt2g());
            values.put(sectordeatail_edt_preelectrical_tilt3g, sectorDetailData.getSectordeatail_edt_preelectrical_tilt3g());
            values.put(sectordeatail_img_pretelectrical_tilt3g, sectorDetailData.getSectordeatail_img_pretelectrical_tilt3g());
            values.put(sectordeatail_edt_postelectrical_tilt3g, sectorDetailData.getSectordeatail_edt_postelectrical_tilt3g());
            values.put(sectordeatail_img_postelectrical_tilt3g, sectorDetailData.getSectordeatail_img_postelectrical_tilt3g());
            values.put(sectordeatail_edt_preelectrical_tilt4gf1, sectorDetailData.getSectordeatail_edt_preelectrical_tilt4gf1());
            values.put(sectordeatail_img_preelectrical_tilt4gf1, sectorDetailData.getSectordeatail_img_preelectrical_tilt4gf1());
            values.put(sectordeatail_edt_postelectrical_tilt4gf1, sectorDetailData.getSectordeatail_edt_postelectrical_tilt4gf1());
            values.put(sectordeatail_img_postelectrical_tilt4gf1, sectorDetailData.getSectordeatail_img_postelectrical_tilt4gf1());
            values.put(sectordeatail_edt_preelectrical_tilt4gf2, sectorDetailData.getSectordeatail_edt_preelectrical_tilt4gf2());
            values.put(sectordeatail_img_preelectrical_tilt4gf2, sectorDetailData.getSectordeatail_img_preelectrical_tilt4gf2());
            values.put(sectordeatail_edt_postelectrical_tilt4gf2, sectorDetailData.getSectordeatail_edt_postelectrical_tilt4gf2());
            values.put(sectordeatail_img_postelectrical_tilt4gf2, sectorDetailData.getSectordeatail_img_postelectrical_tilt4gf2());
            values.put(sectordeatail_edt_preelectrical_tilt, sectorDetailData.getSectordeatail_edt_preelectrical_tilt());
            values.put(sectordeatail_img_preelectrical_tilt, sectorDetailData.getSectordeatail_img_preelectrical_tilt());
            values.put(sectordeatail_edt_postelectrical_tilt, sectorDetailData.getSectordeatail_edt_postelectrical_tilt());
            values.put(sectordeatail_img_postelectrical_tilt, sectorDetailData.getSectordeatail_img_postelectrical_tilt());
            values.put(sectordeatail_edt_antennaheight, sectorDetailData.getSectordeatail_edt_antennaheight());
            values.put(sectordeatail_img_antennaheight, sectorDetailData.getSectordeatail_img_antennaheight());
            values.put(sectordeatail_edt_poleheight, sectorDetailData.getSectordeatail_edt_poleheight());
            values.put(sectordeatail_img_poleheight, sectorDetailData.getSectordeatail_img_poleheight());
            values.put(sectordeatail_edt_buildingheight, sectorDetailData.getSectordeatail_edt_buildingheight());
            values.put(sectordeatail_img_buildingheight, sectorDetailData.getSectordeatail_img_buildingheight());
            values.put(sectordeatail_edt_towertype, sectorDetailData.getSectordeatail_edt_towertype());
            values.put(sectordeatail_img_towertype, sectorDetailData.getSectordeatail_img_towertype());
            values.put(sectordeatail_edt_antennamake, sectorDetailData.getSectordeatail_edt_antennamake());
            values.put(sectordeatail_img_antennamake, sectorDetailData.getSectordeatail_img_antennamake());
            values.put(sectordeatail_edt_antenmodel, sectorDetailData.getSectordeatail_edt_antenmodel());
            values.put(sectordeatail_img_antennamodel, sectorDetailData.getSectordeatail_img_antennamodel());
            values.put(sectordeatail_edt_clutterpic, sectorDetailData.getSectordeatail_edt_clutterpic());
            values.put(sectordeatail_img_clutterpic, sectorDetailData.getSectordeatail_img_clutterpic());
            values.put(sectordeatail_edt_txbandwidth, sectorDetailData.getSectordeatail_edt_txbandwidth());
            values.put(sectordeatail_img_txbandwidth, sectorDetailData.getSectordeatail_img_txbandwidth());
            values.put(sectordeatail_edt_AST, sectorDetailData.getSectordeatail_edt_AST());
            values.put(sectordeatail_img_AST, sectorDetailData.getSectordeatail_img_AST());
            values.put(sectordeatail_edt_APST, sectorDetailData.getSectordeatail_edt_APST());
            values.put(sectordeatail_img_APST, sectorDetailData.getSectordeatail_img_APST());
            values.put(sectordeatail_edt_typ_enodeb, sectorDetailData.getSectordeatail_edt_typ_enodeb());
            values.put(sectordeatail_img_typ_enodeb, sectorDetailData.getSectordeatail_img_typ_enodeb());
            values.put(sectordeatail_edt_mimo, sectorDetailData.getSectordeatail_edt_mimo());
            values.put(sectordeatail_img_mimo, sectorDetailData.getSectordeatail_img_mimo());
            values.put(sectordeatail_edt_ret, sectorDetailData.getSectordeatail_edt_ret());
            values.put(sectordeatail_img_ret, sectorDetailData.getSectordeatail_img_ret());
            values.put(sectordeatail_edt_enodebband, sectorDetailData.getSectordeatail_edt_enodebband());
            values.put(sectordeatail_img_enodebband, sectorDetailData.getSectordeatail_img_enodebband());
            values.put(sectordeatail_edt_MOP, sectorDetailData.getSectordeatail_edt_MOP());
            values.put(sectordeatail_img_MOP, sectorDetailData.getSectordeatail_img_MOP());
            values.put(sectordeatail_edt_COP, sectorDetailData.getSectordeatail_edt_COP());
            values.put(sectordeatail_img_COP, sectorDetailData.getSectordeatail_img_COP());
            values.put(sectordeatail_edt_multiplexer_avail, sectorDetailData.getSectordeatail_edt_multiplexer_avail());
            values.put(sectordeatail_img_multiplexer_avail, sectorDetailData.getSectordeatail_img_multiplexer_avail());
            values.put(sectordeatail_edt_antennapicleg, sectorDetailData.getSectordeatail_edt_antennapicleg());
            values.put(sectordeatail_img_antennapicleg, sectorDetailData.getSectordeatail_img_antennapicleg());
            values.put(sectordeatail_edt_CRP, sectorDetailData.getSectordeatail_edt_CRP());
            values.put(sectordeatail_img_CRP, sectorDetailData.getSectordeatail_img_CRP());
            values.put(sectordeatail_edt_powerdeboosting, sectorDetailData.getSectordeatail_edt_powerdeboosting());
            values.put(sectordeatail_img_powerdeboosting, sectorDetailData.getSectordeatail_img_powerdeboosting());
            values.put(sectordeatail_edt_DFS, sectorDetailData.getSectordeatail_edt_DFS());
            values.put(sectordeatail_img_DFS, sectorDetailData.getSectordeatail_img_DFS());
            values.put(sectordeatail_edt_rb_percell, sectorDetailData.getSectordeatail_edt_rb_percell());
            values.put(sectordeatail_img_rb_percell, sectorDetailData.getSectordeatail_img_rb_percell());
            values.put(sectordeatail_edt_m_mimo, sectorDetailData.getSectordeatail_edt_m_mimo());
            values.put(sectordeatail_img_m_mimo, sectorDetailData.getSectordeatail_img_m_mimo());
            values.put(sectordeatail_edt_FCT, sectorDetailData.getSectordeatail_edt_FCT());
            values.put(sectordeatail_img_FCT, sectorDetailData.getSectordeatail_img_FCT());
            values.put(sectordeatail_edt_JCT, sectorDetailData.getSectordeatail_edt_JCT());
            values.put(sectordeatail_img_JCT, sectorDetailData.getSectordeatail_img_JCT());
            values.put(sectordeatail_edt_FCL, sectorDetailData.getSectordeatail_edt_FCL());
            values.put(sectordeatail_img_FCL, sectorDetailData.getSectordeatail_img_FCL());
            values.put(sectordeatail_edt_jumperlength, sectorDetailData.getSectordeatail_edt_jumperlength());
            values.put(sectordeatail_img_jumperlength, sectorDetailData.getSectordeatail_img_jumperlength());
            values.put(sectordeatail_edt_prachconfig_index, sectorDetailData.getSectordeatail_edt_prachconfig_index());
            values.put(sectordeatail_img_prachconfig_index, sectorDetailData.getSectordeatail_img_prachconfig_index());
            values.put(sectordeatail_edt_carrieraggregation, sectorDetailData.getSectordeatail_edt_carrieraggregation());
            values.put(sectordeatail_img_carrieraggregation, sectorDetailData.getSectordeatail_img_carrieraggregation());
            values.put(sectordeatail_edt_ACD, sectorDetailData.getSectordeatail_edt_ACD());
            values.put(sectordeatail_img_ACD, sectorDetailData.getSectordeatail_img_ACD());
            values.put(sectordeatail_edt_VSWRtest, sectorDetailData.getSectordeatail_edt_VSWRtest());
            values.put(sectordeatail_img_VSWRtest, sectorDetailData.getSectordeatail_img_VSWRtest());
            values.put(sectordeatail_edt_URS, sectorDetailData.getSectordeatail_edt_URS());
            values.put(sectordeatail_img_URS, sectorDetailData.getSectordeatail_img_URS());
            values.put(sectordeatail_edt_extra1, sectorDetailData.getSectordeatail_edt_extra1());
            values.put(sectordeatail_img_extra1, sectorDetailData.getSectordeatail_img_extra1());
            values.put(sectordeatail_edt_extra2, sectorDetailData.getSectordeatail_edt_extra2());
            values.put(sectordeatail_img_extra2, sectorDetailData.getSectordeatail_img_extra2());
            values.put(sectordeatail_edt_remak1, sectorDetailData.getSectordeatail_edt_remak1());
            values.put(sectordeatail_img_remark1, sectorDetailData.getSectordeatail_img_remark1());
            values.put(sectordeatail_edt_remak2, sectorDetailData.getSectordeatail_edt_remak2());
            values.put(sectordeatail_img_remark2, sectorDetailData.getSectordeatail_img_remark2());
            values.put(sectordeatailfrgamentname, sectorDetailData.getSectordeatailfrgamentname());
            values.put(sectordeatail_flag, sectorDetailData.getFlag());
            values.put(sectordeatail_date, sectorDetailData.getDate());
            values.put(sdbasebandUnitType_edt, sectorDetailData.getSdbasebandUnitType_edt());
            values.put(sdbasebandUnitType_img, sectorDetailData.getSdbasebandUnitType_img());
            values.put(sdrNCName_edt, sectorDetailData.getSdrNCName_edt());
            values.put(sdrNCName_img, sectorDetailData.getSdrNCName_img());
            values.put(sdnoofChannelElements_edt, sectorDetailData.getSdnoofChannelElements_edt());
            values.put(sdnoofChannelElements_img, sectorDetailData.getSdnoofChannelElements_img());
            // Inserting Row
            db.insert(TABLE_SECTORDETAIL, null, values);
        } catch (Exception ignor) {
            Log.v(TAG, "Databaser insert sectordetail table error");
        }
        Log.v(TAG, "Databaser insert sectordeatail table");
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }
    public List<SectorDetailData> getLastSectorDetailData() {
        ArrayList<SectorDetailData> list = new ArrayList<SectorDetailData>();
        // Select All Query
        // SELECT * FROM members ORDER BY date_of_birth DESC;
        //String selectQuery = "SELECT  * FROM " + TABLE_LATLONG +" ORDER BY "+KEY_LATLONG_INCRIID+" DESC LIMIT 1;";

        String selectQuery = "SELECT  * FROM " + TABLE_SECTORDETAIL + " ORDER BY " + sectordetail_id + " DESC LIMIT 1";
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            Cursor cursor = db.rawQuery(selectQuery, null);
            try {
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        SectorDetailData sectorDetailData = new SectorDetailData();
                        sectorDetailData.setId(cursor.getInt(0));
                        sectorDetailData.setSectordetail_edt_techavailable(cursor.getString(1));
                        sectorDetailData.setSectordetail_img_techavailable(cursor.getString(2));
                        sectorDetailData.setSectordetail_edt_bandavailable(cursor.getString(3));
                        sectorDetailData.setSectordeatail_img_bandavailable(cursor.getString(4));
                        sectorDetailData.setSectordeatail_edt_APC(cursor.getString(5));
                        sectorDetailData.setSectordeatail_img_APC(cursor.getString(6));
                        sectorDetailData.setSectoreatail_edt_preazimuth(cursor.getString(7));
                        sectorDetailData.setSectordeatail_img_preazimuth(cursor.getString(8));
                        sectorDetailData.setSectordeatail_edt_postazimuth(cursor.getString(9));
                        sectorDetailData.setSectordeatail_img_postazimuth(cursor.getString(10));
                        sectorDetailData.setSectordeatail_edt_premechanical_tilt(cursor.getString(11));
                        sectorDetailData.setSectordeatail_img_premechanical_tilt(cursor.getString(12));
                        sectorDetailData.setSectordeatail_edt_postmechanical_tilt(cursor.getString(13));
                        sectorDetailData.setSectordeatail_img_postmechanical_tilt(cursor.getString(14));
                        sectorDetailData.setSectordeatail_edt_preelectrical_tilt2g(cursor.getString(15));
                        sectorDetailData.setSectordeatail_img_preelectrical_tilt2g(cursor.getString(16));
                        sectorDetailData.setSectordeatail_edt_postelectrical_tilt2g(cursor.getString(17));
                        sectorDetailData.setSectordeatail_img_postelectrical_tilt2g(cursor.getString(18));
                        sectorDetailData.setSectordeatail_edt_preelectrical_tilt3g(cursor.getString(19));
                        sectorDetailData.setSectordeatail_img_pretelectrical_tilt3g(cursor.getString(20));
                        sectorDetailData.setSectordeatail_edt_postelectrical_tilt3g(cursor.getString(21));
                        sectorDetailData.setSectordeatail_img_postelectrical_tilt3g(cursor.getString(22));
                        sectorDetailData.setSectordeatail_edt_preelectrical_tilt4gf1(cursor.getString(23));
                        sectorDetailData.setSectordeatail_img_preelectrical_tilt4gf1(cursor.getString(24));
                        sectorDetailData.setSectordeatail_edt_postelectrical_tilt4gf1(cursor.getString(25));
                        sectorDetailData.setSectordeatail_img_postelectrical_tilt4gf1(cursor.getString(26));
                        sectorDetailData.setSectordeatail_edt_preelectrical_tilt4gf2(cursor.getString(27));
                        sectorDetailData.setSectordeatail_img_preelectrical_tilt4gf2(cursor.getString(28));
                        sectorDetailData.setSectordeatail_edt_postelectrical_tilt4gf2(cursor.getString(29));
                        sectorDetailData.setSectordeatail_img_postelectrical_tilt4gf2(cursor.getString(30));
                        sectorDetailData.setSectordeatail_edt_preelectrical_tilt(cursor.getString(31));
                        sectorDetailData.setSectordeatail_img_preelectrical_tilt(cursor.getString(32));
                        sectorDetailData.setSectordeatail_edt_postelectrical_tilt(cursor.getString(33));
                        sectorDetailData.setSectordeatail_img_postelectrical_tilt(cursor.getString(34));
                        sectorDetailData.setSectordeatail_edt_antennaheight(cursor.getString(35));
                        sectorDetailData.setSectordeatail_img_antennaheight(cursor.getString(36));
                        sectorDetailData.setSectordeatail_edt_poleheight(cursor.getString(37));
                        sectorDetailData.setSectordeatail_img_poleheight(cursor.getString(38));
                        sectorDetailData.setSectordeatail_edt_buildingheight(cursor.getString(39));
                        sectorDetailData.setSectordeatail_img_buildingheight(cursor.getString(40));
                        sectorDetailData.setSectordeatail_edt_towertype(cursor.getString(41));
                        sectorDetailData.setSectordeatail_img_towertype(cursor.getString(42));
                        sectorDetailData.setSectordeatail_edt_antennamake(cursor.getString(43));
                        sectorDetailData.setSectordeatail_img_antennamake(cursor.getString(44));
                        sectorDetailData.setSectordeatail_edt_antenmodel(cursor.getString(45));
                        sectorDetailData.setSectordeatail_img_antennamodel(cursor.getString(46));
                        sectorDetailData.setSectordeatail_edt_clutterpic(cursor.getString(47));
                        sectorDetailData.setSectordeatail_img_clutterpic(cursor.getString(48));
                        sectorDetailData.setSectordeatail_edt_txbandwidth(cursor.getString(49));
                        sectorDetailData.setSectordeatail_img_txbandwidth(cursor.getString(50));
                        sectorDetailData.setSectordeatail_edt_AST(cursor.getString(51));
                        sectorDetailData.setSectordeatail_img_AST(cursor.getString(52));
                        sectorDetailData.setSectordeatail_edt_APST(cursor.getString(53));
                        sectorDetailData.setSectordeatail_img_APST(cursor.getString(54));
                        sectorDetailData.setSectordeatail_edt_typ_enodeb(cursor.getString(55));
                        sectorDetailData.setSectordeatail_img_typ_enodeb(cursor.getString(56));
                        sectorDetailData.setSectordeatail_edt_mimo(cursor.getString(57));
                        sectorDetailData.setSectordeatail_img_mimo(cursor.getString(58));
                        sectorDetailData.setSectordeatail_edt_ret(cursor.getString(59));
                        sectorDetailData.setSectordeatail_img_ret(cursor.getString(60));
                        sectorDetailData.setSectordeatail_edt_enodebband(cursor.getString(61));
                        sectorDetailData.setSectordeatail_img_enodebband(cursor.getString(62));
                        sectorDetailData.setSectordeatail_edt_MOP(cursor.getString(63));
                        sectorDetailData.setSectordeatail_img_MOP(cursor.getString(64));
                        sectorDetailData.setSectordeatail_edt_COP(cursor.getString(65));
                        sectorDetailData.setSectordeatail_img_COP(cursor.getString(66));
                        sectorDetailData.setSectordeatail_edt_multiplexer_avail(cursor.getString(67));
                        sectorDetailData.setSectordeatail_img_multiplexer_avail(cursor.getString(68));
                        sectorDetailData.setSectordeatail_edt_antennapicleg(cursor.getString(69));
                        sectorDetailData.setSectordeatail_img_antennapicleg(cursor.getString(70));
                        sectorDetailData.setSectordeatail_edt_CRP(cursor.getString(71));
                        sectorDetailData.setSectordeatail_img_CRP(cursor.getString(72));
                        sectorDetailData.setSectordeatail_edt_powerdeboosting(cursor.getString(73));
                        sectorDetailData.setSectordeatail_img_powerdeboosting(cursor.getString(74));
                        sectorDetailData.setSectordeatail_edt_DFS(cursor.getString(75));
                        sectorDetailData.setSectordeatail_img_DFS(cursor.getString(76));
                        sectorDetailData.setSectordeatail_edt_rb_percell(cursor.getString(77));
                        sectorDetailData.setSectordeatail_img_rb_percell(cursor.getString(78));
                        sectorDetailData.setSectordeatail_edt_m_mimo(cursor.getString(79));
                        sectorDetailData.setSectordeatail_img_m_mimo(cursor.getString(80));
                        sectorDetailData.setSectordeatail_edt_FCT(cursor.getString(81));
                        sectorDetailData.setSectordeatail_img_FCT(cursor.getString(82));
                        sectorDetailData.setSectordeatail_edt_JCT(cursor.getString(83));
                        sectorDetailData.setSectordeatail_img_JCT(cursor.getString(84));
                        sectorDetailData.setSectordeatail_edt_FCL(cursor.getString(85));
                        sectorDetailData.setSectordeatail_img_FCL(cursor.getString(86));
                        sectorDetailData.setSectordeatail_edt_jumperlength(cursor.getString(87));
                        sectorDetailData.setSectordeatail_img_jumperlength(cursor.getString(88));
                        sectorDetailData.setSectordeatail_edt_prachconfig_index(cursor.getString(89));
                        sectorDetailData.setSectordeatail_img_prachconfig_index(cursor.getString(90));
                        sectorDetailData.setSectordeatail_edt_carrieraggregation(cursor.getString(91));
                        sectorDetailData.setSectordeatail_img_carrieraggregation(cursor.getString(92));
                        sectorDetailData.setSectordeatail_edt_ACD(cursor.getString(93));
                        sectorDetailData.setSectordeatail_img_ACD(cursor.getString(94));
                        sectorDetailData.setSectordeatail_edt_VSWRtest(cursor.getString(95));
                        sectorDetailData.setSectordeatail_img_VSWRtest(cursor.getString(96));
                        sectorDetailData.setSectordeatail_edt_URS(cursor.getString(97));
                        sectorDetailData.setSectordeatail_img_URS(cursor.getString(98));
                        sectorDetailData.setSectordeatail_edt_extra1(cursor.getString(99));
                        sectorDetailData.setSectordeatail_img_extra1(cursor.getString(100));
                        sectorDetailData.setSectordeatail_edt_extra2(cursor.getString(101));
                        sectorDetailData.setSectordeatail_img_extra2(cursor.getString(102));
                        sectorDetailData.setSectordeatail_edt_remak1(cursor.getString(103));
                        sectorDetailData.setSectordeatail_img_remark1(cursor.getString(104));
                        sectorDetailData.setSectordeatail_edt_remak2(cursor.getString(105));
                        sectorDetailData.setSectordeatail_img_remark2(cursor.getString(106));
                        sectorDetailData.setSectordeatailfrgamentname(cursor.getString(107));
                        sectorDetailData.setFlag(cursor.getInt(108));
                        sectorDetailData.setDate(cursor.getString(109));


                        // Adding contact to list
                        list.add(sectorDetailData);
                    } while (cursor.moveToNext());
                }

            } finally {
                try {
                    cursor.close();

                } catch (Exception ignore) {
                }
            }

        } finally {
            try {
                db.close();
            } catch (Exception ignore) {

            }
        }
        return list;
    }

    public List<SectorDetailData> getLastSectordetail(String formno) {
        ArrayList<SectorDetailData> list = new ArrayList<SectorDetailData>();
        // Select All Query
        // SELECT * FROM members ORDER BY date_of_birth DESC;
        //String selectQuery = "SELECT  * FROM " + TABLE_LATLONG +" ORDER BY "+KEY_LATLONG_INCRIID+" DESC LIMIT 1;";
        String selectQuery = "SELECT  * FROM " + TABLE_SECTORDETAIL + " WHERE " + sectordeatailfrgamentname + " = ?" + " ORDER BY " + sectordetail_id + " DESC LIMIT 1";
        SQLiteDatabase db = this.getReadableDatabase();
        try {

            Cursor cursor = db.rawQuery(selectQuery, new String[]{formno});
            try {
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        SectorDetailData sectorDetailData = new SectorDetailData();
                        sectorDetailData.setId(cursor.getInt(0));
                        sectorDetailData.setSectordetail_edt_techavailable(cursor.getString(1));
                        sectorDetailData.setSectordetail_img_techavailable(cursor.getString(2));
                        sectorDetailData.setSectordetail_edt_bandavailable(cursor.getString(3));
                        sectorDetailData.setSectordeatail_img_bandavailable(cursor.getString(4));
                        sectorDetailData.setSectordeatail_edt_APC(cursor.getString(5));
                        sectorDetailData.setSectordeatail_img_APC(cursor.getString(6));
                        sectorDetailData.setSectoreatail_edt_preazimuth(cursor.getString(7));
                        sectorDetailData.setSectordeatail_img_preazimuth(cursor.getString(8));
                        sectorDetailData.setSectordeatail_edt_postazimuth(cursor.getString(9));
                        sectorDetailData.setSectordeatail_img_postazimuth(cursor.getString(10));
                        sectorDetailData.setSectordeatail_edt_premechanical_tilt(cursor.getString(11));
                        sectorDetailData.setSectordeatail_img_premechanical_tilt(cursor.getString(12));
                        sectorDetailData.setSectordeatail_edt_postmechanical_tilt(cursor.getString(13));
                        sectorDetailData.setSectordeatail_img_postmechanical_tilt(cursor.getString(14));
                        sectorDetailData.setSectordeatail_edt_preelectrical_tilt2g(cursor.getString(15));
                        sectorDetailData.setSectordeatail_img_preelectrical_tilt2g(cursor.getString(16));
                        sectorDetailData.setSectordeatail_edt_postelectrical_tilt2g(cursor.getString(17));
                        sectorDetailData.setSectordeatail_img_postelectrical_tilt2g(cursor.getString(18));
                        sectorDetailData.setSectordeatail_edt_preelectrical_tilt3g(cursor.getString(19));
                        sectorDetailData.setSectordeatail_img_pretelectrical_tilt3g(cursor.getString(20));
                        sectorDetailData.setSectordeatail_edt_postelectrical_tilt3g(cursor.getString(21));
                        sectorDetailData.setSectordeatail_img_postelectrical_tilt3g(cursor.getString(22));
                        sectorDetailData.setSectordeatail_edt_preelectrical_tilt4gf1(cursor.getString(23));
                        sectorDetailData.setSectordeatail_img_preelectrical_tilt4gf1(cursor.getString(24));
                        sectorDetailData.setSectordeatail_edt_postelectrical_tilt4gf1(cursor.getString(25));
                        sectorDetailData.setSectordeatail_img_postelectrical_tilt4gf1(cursor.getString(26));
                        sectorDetailData.setSectordeatail_edt_preelectrical_tilt4gf2(cursor.getString(27));
                        sectorDetailData.setSectordeatail_img_preelectrical_tilt4gf2(cursor.getString(28));
                        sectorDetailData.setSectordeatail_edt_postelectrical_tilt4gf2(cursor.getString(29));
                        sectorDetailData.setSectordeatail_img_postelectrical_tilt4gf2(cursor.getString(30));
                        sectorDetailData.setSectordeatail_edt_preelectrical_tilt(cursor.getString(31));
                        sectorDetailData.setSectordeatail_img_preelectrical_tilt(cursor.getString(32));
                        sectorDetailData.setSectordeatail_edt_postelectrical_tilt(cursor.getString(33));
                        sectorDetailData.setSectordeatail_img_postelectrical_tilt(cursor.getString(34));
                        sectorDetailData.setSectordeatail_edt_antennaheight(cursor.getString(35));
                        sectorDetailData.setSectordeatail_img_antennaheight(cursor.getString(36));
                        sectorDetailData.setSectordeatail_edt_poleheight(cursor.getString(37));
                        sectorDetailData.setSectordeatail_img_poleheight(cursor.getString(38));
                        sectorDetailData.setSectordeatail_edt_buildingheight(cursor.getString(39));
                        sectorDetailData.setSectordeatail_img_buildingheight(cursor.getString(40));
                        sectorDetailData.setSectordeatail_edt_towertype(cursor.getString(41));
                        sectorDetailData.setSectordeatail_img_towertype(cursor.getString(42));
                        sectorDetailData.setSectordeatail_edt_antennamake(cursor.getString(43));
                        sectorDetailData.setSectordeatail_img_antennamake(cursor.getString(44));
                        sectorDetailData.setSectordeatail_edt_antenmodel(cursor.getString(45));
                        sectorDetailData.setSectordeatail_img_antennamodel(cursor.getString(46));
                        sectorDetailData.setSectordeatail_edt_clutterpic(cursor.getString(47));
                        sectorDetailData.setSectordeatail_img_clutterpic(cursor.getString(48));
                        sectorDetailData.setSectordeatail_edt_txbandwidth(cursor.getString(49));
                        sectorDetailData.setSectordeatail_img_txbandwidth(cursor.getString(50));
                        sectorDetailData.setSectordeatail_edt_AST(cursor.getString(51));
                        sectorDetailData.setSectordeatail_img_AST(cursor.getString(52));
                        sectorDetailData.setSectordeatail_edt_APST(cursor.getString(53));
                        sectorDetailData.setSectordeatail_img_APST(cursor.getString(54));
                        sectorDetailData.setSectordeatail_edt_typ_enodeb(cursor.getString(55));
                        sectorDetailData.setSectordeatail_img_typ_enodeb(cursor.getString(56));
                        sectorDetailData.setSectordeatail_edt_mimo(cursor.getString(57));
                        sectorDetailData.setSectordeatail_img_mimo(cursor.getString(58));
                        sectorDetailData.setSectordeatail_edt_ret(cursor.getString(59));
                        sectorDetailData.setSectordeatail_img_ret(cursor.getString(60));
                        sectorDetailData.setSectordeatail_edt_enodebband(cursor.getString(61));
                        sectorDetailData.setSectordeatail_img_enodebband(cursor.getString(62));
                        sectorDetailData.setSectordeatail_edt_MOP(cursor.getString(63));
                        sectorDetailData.setSectordeatail_img_MOP(cursor.getString(64));
                        sectorDetailData.setSectordeatail_edt_COP(cursor.getString(65));
                        sectorDetailData.setSectordeatail_img_COP(cursor.getString(66));
                        sectorDetailData.setSectordeatail_edt_multiplexer_avail(cursor.getString(67));
                        sectorDetailData.setSectordeatail_img_multiplexer_avail(cursor.getString(68));
                        sectorDetailData.setSectordeatail_edt_antennapicleg(cursor.getString(69));
                        sectorDetailData.setSectordeatail_img_antennapicleg(cursor.getString(70));
                        sectorDetailData.setSectordeatail_edt_CRP(cursor.getString(71));
                        sectorDetailData.setSectordeatail_img_CRP(cursor.getString(72));
                        sectorDetailData.setSectordeatail_edt_powerdeboosting(cursor.getString(73));
                        sectorDetailData.setSectordeatail_img_powerdeboosting(cursor.getString(74));
                        sectorDetailData.setSectordeatail_edt_DFS(cursor.getString(75));
                        sectorDetailData.setSectordeatail_img_DFS(cursor.getString(76));
                        sectorDetailData.setSectordeatail_edt_rb_percell(cursor.getString(77));
                        sectorDetailData.setSectordeatail_img_rb_percell(cursor.getString(78));
                        sectorDetailData.setSectordeatail_edt_m_mimo(cursor.getString(79));
                        sectorDetailData.setSectordeatail_img_m_mimo(cursor.getString(80));
                        sectorDetailData.setSectordeatail_edt_FCT(cursor.getString(81));
                        sectorDetailData.setSectordeatail_img_FCT(cursor.getString(82));
                        sectorDetailData.setSectordeatail_edt_JCT(cursor.getString(83));
                        sectorDetailData.setSectordeatail_img_JCT(cursor.getString(84));
                        sectorDetailData.setSectordeatail_edt_FCL(cursor.getString(85));
                        sectorDetailData.setSectordeatail_img_FCL(cursor.getString(86));
                        sectorDetailData.setSectordeatail_edt_jumperlength(cursor.getString(87));
                        sectorDetailData.setSectordeatail_img_jumperlength(cursor.getString(88));
                        sectorDetailData.setSectordeatail_edt_prachconfig_index(cursor.getString(89));
                        sectorDetailData.setSectordeatail_img_prachconfig_index(cursor.getString(90));
                        sectorDetailData.setSectordeatail_edt_carrieraggregation(cursor.getString(91));
                        sectorDetailData.setSectordeatail_img_carrieraggregation(cursor.getString(92));
                        sectorDetailData.setSectordeatail_edt_ACD(cursor.getString(93));
                        sectorDetailData.setSectordeatail_img_ACD(cursor.getString(94));
                        sectorDetailData.setSectordeatail_edt_VSWRtest(cursor.getString(95));
                        sectorDetailData.setSectordeatail_img_VSWRtest(cursor.getString(96));
                        sectorDetailData.setSectordeatail_edt_URS(cursor.getString(97));
                        sectorDetailData.setSectordeatail_img_URS(cursor.getString(98));
                        sectorDetailData.setSectordeatail_edt_extra1(cursor.getString(99));
                        sectorDetailData.setSectordeatail_img_extra1(cursor.getString(100));
                        sectorDetailData.setSectordeatail_edt_extra2(cursor.getString(101));
                        sectorDetailData.setSectordeatail_img_extra2(cursor.getString(102));
                        sectorDetailData.setSectordeatail_edt_remak1(cursor.getString(103));
                        sectorDetailData.setSectordeatail_img_remark1(cursor.getString(104));
                        sectorDetailData.setSectordeatail_edt_remak2(cursor.getString(105));
                        sectorDetailData.setSectordeatail_img_remark2(cursor.getString(106));
                        sectorDetailData.setSectordeatailfrgamentname(cursor.getString(107));
                        sectorDetailData.setFlag(cursor.getInt(108));
                        sectorDetailData.setDate(cursor.getString(109));
                        sectorDetailData.setSdbasebandUnitType_edt(cursor.getString(110));
                        sectorDetailData.setSdbasebandUnitType_img(cursor.getString(111));
                        sectorDetailData.setSdrNCName_edt(cursor.getString(112));
                        sectorDetailData.setSdrNCName_img(cursor.getString(113));
                        sectorDetailData.setSdnoofChannelElements_edt(cursor.getString(114));
                        sectorDetailData.setSdnoofChannelElements_img(cursor.getString(115));


                        // Adding contact to list
                        list.add(sectorDetailData);
                    } while (cursor.moveToNext());
                }

            } finally {
                try {
                    cursor.close();

                }
                catch (Exception ignore) {
                }
            }

        } finally {
            try {
                db.close();
            } catch (Exception ignore) {

            }
        }
        return list;
    }


    public int getCountSectorDetail() {
        String countQuery = "SELECT  * FROM " + TABLE_SECTORDETAIL;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        // return count
        return count;
    }

    // code to add the new OtherDetail
    public void insertOtherData(OtherDetailData otherDetailData) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put(edtRiggerPic, otherDetailData.getEdtRiggerPic());
            values.put(edtEngineerPic, otherDetailData.getEdtEngineerPic());
            values.put(edtCarPic, otherDetailData.getEdtCarPic());
            values.put(edt_RiggerPicwithclimbingTower, otherDetailData.getEdt_RiggerPicwithclimbingTower());
            values.put(edtRiggerPicduringWah, otherDetailData.getEdtRiggerPicduringWah());
            values.put(iv_RiggerPic, otherDetailData.getIv_RiggerPic());
            values.put(iv_EngineerPic, otherDetailData.getIv_EngineerPic());
            values.put(iv_CarPic, otherDetailData.getIv_CarPic());
            values.put(iv_RiggerPicwithclimbingTower, otherDetailData.getIv_RiggerPicwithclimbingTower());
            values.put(iv_RiggerPicduringWah, otherDetailData.getIv_RiggerPicduringWah());
            values.put(otherdate, otherDetailData.getDate());
            values.put(otherflag, otherDetailData.getFlag());

            // Inserting Row
            db.insert(TABLE_OTHERDETAIL, null, values);
        } catch (Exception ignor) {
            Log.v(TAG, "Databaser insert otherdetail error");
        }
        Log.v(TAG, "Databaser insert otherdetail table");
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    public List<OtherDetailData> getLastOtherdetaiData() {
        ArrayList<OtherDetailData> list = new ArrayList<OtherDetailData>();
        // Select All Query
        // SELECT * FROM members ORDER BY date_of_birth DESC;
        //String selectQuery = "SELECT  * FROM " + TABLE_LATLONG +" ORDER BY "+KEY_LATLONG_INCRIID+" DESC LIMIT 1;";

        String selectQuery = "SELECT  * FROM " + TABLE_OTHERDETAIL + " ORDER BY " + otherid + " DESC LIMIT 1";

        SQLiteDatabase db = this.getReadableDatabase();
        try {

            Cursor cursor = db.rawQuery(selectQuery, null);
            try {
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        OtherDetailData otherDetailData = new OtherDetailData();
                        otherDetailData.setId(cursor.getInt(0));
                        otherDetailData.setEdtRiggerPic(cursor.getString(1));
                        otherDetailData.setEdtEngineerPic(cursor.getString(2));
                        otherDetailData.setEdtCarPic(cursor.getString(3));
                        otherDetailData.setEdt_RiggerPicwithclimbingTower(cursor.getString(4));
                        otherDetailData.setEdtRiggerPicduringWah(cursor.getString(5));
                        otherDetailData.setIv_RiggerPic(cursor.getString(6));
                        otherDetailData.setIv_EngineerPic(cursor.getString(7));
                        otherDetailData.setIv_CarPic(cursor.getString(8));
                        otherDetailData.setIv_RiggerPicwithclimbingTower(cursor.getString(9));
                        otherDetailData.setIv_RiggerPicduringWah(cursor.getString(10));
                        otherDetailData.setDate(cursor.getString(11));
                        otherDetailData.setFlag(cursor.getInt(12));


                        // Adding contact to list
                        list.add(otherDetailData);
                    } while (cursor.moveToNext());
                }

            } finally {
                try {
                    cursor.close();

                } catch (Exception ignore) {
                }
            }

        } finally {
            try {
                db.close();
            } catch (Exception ignore) {

            }
        }
        return list;
    }

    public int getCountOtherDetail() {
        String countQuery = "SELECT  * FROM " + TABLE_OTHERDETAIL;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        // return count
        return count;
    }

    public  ArrayList<HashMap<String, String>> printTable1Data(String table_name){
        ArrayList<HashMap<String, String>> prodArrayList = new ArrayList<HashMap<String, String>>();
        SQLiteDatabase db = getReadableDatabase();
        String row_values = "";
        Cursor cur = db.rawQuery("SELECT * FROM " + table_name + " ORDER BY " + keyincriid + " DESC LIMIT 1", null);
        if(cur.getCount() != 0){
            cur.moveToFirst();
            do{
                for(int i = 0 ; i < cur.getColumnCount(); i++){
                    String column_value = cur.getString(i);
                    String column_name = cur.getColumnName(i);
                    HashMap<String,String> map = new HashMap<String,String>();
                    if(i%2 == 0){
                        map.put("column_name",column_name);
                        map.put("column_value",column_value);
                    }
                    prodArrayList.add(map);
                }
                Log.d("LOG_TAG_HERE", row_values);

            }while (cur.moveToNext());
        }

        return prodArrayList;
    }


}