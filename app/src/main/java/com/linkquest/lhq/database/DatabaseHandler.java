package com.linkquest.lhq.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import com.linkquest.lhq.RFSurvey.RFSectorAntennaDetailData;
import com.linkquest.lhq.RFSurvey.RFSiteDetailData;

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
    private static final String TABLE_LOSSITEDETAIL = "LosSitedetail";
    private static final String TABLE_LOSSTRANSMISSIONLINK = "LosTransmissionLink";
    private static final String TABLE_LOSSTRANSMISSIONNOLINK = "LosTransmissionNoLink";
    private static final String TABLE_LOSPHOTOS = "LosPhotos";
    private static final String TABLE_RFSITEDETAIL = "RFSiteDetail";
    private static final String TABLE_RFSECTORDETAIL = "RFSectorDetail";

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
    private static final String sdbasebandUnitType_edt = "basebandUnitType_edt";
    private static final String sdbasebandUnitType_img = "basebandUnitType_img";
    private static final String sdrNCName_edt = "rNCName_edt";
    private static final String sdrNCName_img = "rNCName_img";
    private static final String sdnoofChannelElements_edt = "noofChannelElements_edt";
    private static final String sdnoofChannelElements_img = "noofChannelElements_img";

    private static final String otherid = "id";
    private static final String edtRiggerPic = "edtRiggerPic";
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

    //los site detail..........................................................
    private static final String losdetail_id = "id";
    private static final String losdetail_SiteID_TXT = "SiteID_TXT";
    private String losdetail_SiteName_TXT = "SiteName_TXT";
    private String losdetail_Sharing_TXT = "Sharing_TXT";
    private String losdetail_SiteType_TXT = "SiteType_TXT";
    private String losdetail_SurveyDate_TXT = "SurveyDate_TXT";
    private String losdetail_TNPEngineer_TXT = "TNPEngineer_TXT";
    private String losdetail_TNPEngineerTel_TXT = "TNPEngineerTel_TXT";
    private String losdetail_Customerrepresentative_TXT = "Customerrepresentative_TXT";
    private String losdetail_Nearenddetails_TXT = "Nearenddetails_TXT";
    private String losdetail_Lat = "lat";
    private String losdetail_Long = "long";
    private String losdetail_CandidateName_TXT = "CandidateName_TXT";
    private String losdetail_Address_TXT = "Address_TXT";
    private String losdetail_Bldght_TXT = "Bldght_TXT";
    private String losdetail_Totalht_TXT = "Totalht_TXT";
    private String losdetail_AMSL_TXT = "AMSL_TXT";
    private String losdetail_Buildingsideviewphoto_TXT = "Buildingsideviewphoto_TXT";
    private String losdetail_AntennaTowerlocationphoto_TXT = "AntennaTowerlocationphoto_TXT";
    private String losdetail_Possibleobstacle_TXT = "Possibleobstacle_TXT";
    private String losdetail_HeightofObstruction_TXT = "HeightofObstruction_TXT";
    private String losdetail_PanaromicPhoto_TXT = "PanaromicPhoto_TXT";
    private String losdetail_ExisitngNoofMWAntennatypewithsizeandPhotograph_TXT = "ExisitngNoofMWAntennatypewithsizeandPhotograph_TXT";
    private String losdetail_ExisitngMWAntennaheightandPolemountPhotograph_TXT = "ExisitngMWAntennaheightandPolemountPhotograph_TXT";
    private String losdetail_SiteID_PIC = "SiteID_PIC";
    private String losdetail_SiteName_PIC = "SiteName_PIC";
    private String losdetail_Sharing_PIC = "Sharing_PIC";
    private String losdetail_SiteType_PIC = "SiteType_PIC";
    private String losdetail_SurveyDate_PIC = "SurveyDate_PIC";
    private String losdetail_TNPEngineer_PIC = "TNPEngineer_PIC";
    private String losdetail_TNPEngineerTel_PIC = "TNPEngineerTel_PIC";
    private String losdetail_Customerrepresentative_PIC = "Customerrepresentative_PIC";
    private String losdetail_Nearenddetails_PIC = "Nearenddetails_PIC";
    private String losdetail_CandidateName_PIC = "CandidateName_PIC";
    private String losdetail_Address_PIC = "Address_PIC";
    private String losdetail_Bldght_PIC = "Bldght_PIC";
    private String losdetail_Totalht_PIC = "Totalht_PIC";
    private String losdetail_AMSL_PIC = "AMSL_PIC";
    private String losdetail_Buildingsideviewphoto_PIC = "Buildingsideviewphoto_PIC";
    private String losdetail_AntennaTowerlocationphoto_PIC = "AntennaTowerlocationphoto_PIC";
    private String losdetail_Possibleobstacle_PIC = "Possibleobstacle_PIC";
    private String losdetail_HeightofObstruction_PIC = "HeightofObstruction_PIC";
    private String losdetail_PanaromicPhoto_PIC = "PanaromicPhoto_PIC";
    private String losdetail_ExisitngNoofMWAntennatypewithsizeandPhotograph_PIC = "ExisitngNoofMWAntennatypewithsizeandPhotograph_PIC";
    private String losdetail_ExisitngMWAntennaheightandPolemountPhotograph_PIC = "ExisitngMWAntennaheightandPolemountPhotograph_PIC";
    private String losdetail_date = "date";
    private String losdetail_flag = "flag";
    //los Transmission Link ..........................................................
    private  String  tranLink_ID="ID";
    private  String  tranLink_edt_SiteID="edt_SiteID";
    private  String tranLink_edt_Sitename="edt_Sitename";
    private  String tranLink_edt_Latitude="edt_Latitude";
    private  String tranLink_edt_Longitude="edt_Longitude";
    private  String tranLink_edt_Azimuthfromnearend="edt_Azimuthfromnearend";
    private  String tranLink_edt_Distance="edt_Distance";
    private  String tranLink_edt_AntennaHeightatFarend ="edt_AntennaHeightatFarend";
    private  String tranLink_edt_PoleFixtureRequirementatFarend ="edt_PoleFixtureRequirementatFarend";
    private  String tranLink_edt_IFLengthatFarend ="edt_IFLengthatFarend";
    private  String tranLink_edt_BuildingHeightatFarend ="edt_BuildingHeightatFarend";
    private  String tranLink_edt_TotalhtForGBTRTTRTPATFarEnd ="edt_TotalhtForGBTRTTRTPATFarEnd";
    private  String tranLink_edt_AMSLatFarEnd ="edt_AMSLatFarEnd";
    private  String tranLink_img_SiteID ="img_SiteID";
    private  String tranLink_img_Sitename ="img_Sitename";
    private  String tranLink_img_Azimuthfromnearend ="img_Azimuthfromnearend";
    private  String tranLink_img_Distance ="img_Distance";
    private  String tranLink_img_AntennaHeightatFarend = "img_AntennaHeightatFarend";
    private  String tranLink_img_PoleFixtureRequirementatFarend ="img_PoleFixtureRequirementatFarend";
    private  String tranLink_img_IFLengthatFarend ="img_IFLengthatFarend";
    private  String tranLink_img_BuildingHeightatFarend = "img_BuildingHeightatFarend";
    private  String tranLink_img_TotalhtForGBTRTTRTPATFarEnd = "img_TotalhtForGBTRTTRTPATFarEnd";
    private  String tranLink_img_AMSLatFarEnd="img_AMSLatFarEnd";
    private  String tranLink_name="transmissionLink_name";
    private String tranLink_date = "date";
    private String tranLink_flag = "flag";
//LOS Transmission No Link.................................
    private  String transnoLink_id ="id";
    private  String transnoLink_edt_SiteID ="edt_SiteID" ;
    private  String transnoLink_edt_Sitename="edt_Sitename";
    private  String transnoLink_edt_ObstructionDetails="edt_ObstructionDetails";
    private  String transnoLink_edt_Azimuth="edt_Azimuth";
    private  String transnoLink_edt_Distance="edt_Distance";
    private  String transnoLink_edt_AntennaHeight="edt_AntennaHeight";
    private  String transnoLink_edt_Altitude="edt_Altitude";
    private  String transnoLink_img_SiteID="img_SiteID";
    private  String transnoLink_img_Sitename="img_Sitename";
    private  String transnoLink_img_ObstructionDetails="img_ObstructionDetails";
    private  String transnoLink_img_Azimuth="img_Azimuth";
    private  String transnoLink_img_Distance="img_Distance";
    private  String transnoLink_img_AntennaHeight="img_AntennaHeight";
    private  String transnoLink_img_Altitude ="img_Altitude";
    private  String transNoLink_name="transmissionNoLink_name";
    private  String transnoLink_date="date";
    private  String transnoLink_flag="flag";

    //LOS Photos No Link.................................
    private String los_P_id ="id";
    private String los_P_NearEndFarEndphoto1 ="NearEndFarEndphoto1";
    private String los_P_FarEndtoNearEndphoto1 ="FarEndtoNearEndphoto1";
    private String los_P_TowerPhoto1 ="TowerPhoto1";
    private String los_P_NearEndtoFarEndphoto2 ="NearEndtoFarEndphoto2";
    private String los_P_FarEndNearEndphoto2 ="FarEndNearEndphoto2";
    private String los_P_TowerPhoto2 ="TowerPhoto2";
    private String los_P_NearEndFarEndphoto3 ="NearEndFarEndphoto3";
    private String los_P_FarEndtoNearEndphoto3 ="FarEndtoNearEndphoto3";
    private String los_P_TowerPhoto3 ="TowerPhoto3";
    private String los_P_NearEndtoFarEndphoto4 ="NearEndtoFarEndphoto4";
    private String los_P_FarEndtoNearEndphoto4 ="FarEndtoNearEndphoto4";
    private String los_P_TowerPhoto4 ="TowerPhoto4";
    private String los_P_date ="date";
    private String los_P_flag ="flag";
    //RF SiteDetail No Link.................................
    private String rfid="id";
    private String edt_rf_SiteID = "edt_rf_SiteID";
    private String edt_rf_SiteName ="edt_rf_SiteName";
    private String edt_rf_SurveyDate ="edt_rf_SurveyDate";
    private String edt_rf_City ="edt_rf_City";
    private String edt_rf_IMID ="edt_rf_IMID";
    private String edt_rf_Cluttertype ="edt_rf_Cluttertype";
    private String edt_rf_SiteType ="edt_rf_SiteType";
    private String edt_rf_Zone ="edt_rf_Zone";
    private String edt_rf_SiteCandidate ="edt_rf_SiteCandidate";
    private String edt_rf_BldgHeight ="edt_rf_BldgHeight";
    private String edt_rf_BldgStructure ="edt_rf_BldgStructure";
    private String edt_rf_AGL ="edt_rf_AGL";
    private String edt_rf_SiteContact ="edt_rf_SiteContact";
    private String edt_rf_AMSL ="edt_rf_AMSL";
    private String edt_rf_SiteAddress ="edt_rf_SiteAddress";
    private String edt_rf_SiteIndoor ="edt_rf_SiteIndoor";
    private String edt_rf_SiteOutdoor ="edt_rf_SiteOutdoor";
    private String edt_rf_ShelterConcrete ="edt_rf_ShelterConcrete";
    private String edt_rf_shelterFabricated ="edt_rf_shelterFabricated";
    private String edt_rf_Numerofotheroperator ="edt_rf_Numerofotheroperator";
    private String edt_rf_IPSite ="edt_rf_IPSite";
    private String edt_rf_Others ="edt_rf_Others";
    private String edt_rf_Sharing ="edt_rf_Sharing";
    private String edt_rf_Hostoperator ="edt_rf_Hostoperator";
    private String edt_rf_Anyguestoperators ="edt_rf_Anyguestoperators";
    private String edt_rf_NoofGSMAntenna ="edt_rf_NoofGSMAntenna";
    private String edt_rf_Lat ="edt_rf_Lat";
    private String edt_rf_Long ="edt_rf_Long";
    private String img_rf_SiteID ="img_rf_SiteID";
    private String img_rf_SiteName ="img_rf_SiteName";
    private String img_rf_SurveyDate ="img_rf_SurveyDate";
    private String img_rf_City ="img_rf_City";
    private String img_rf_IMID ="img_rf_IMID";
    private String img_rf_Cluttertype ="img_rf_Cluttertype";
    private String img_rf_SiteType ="img_rf_SiteType";
    private String img_rf_Zone ="img_rf_Zone";
    private String img_rf_SiteCandidate ="img_rf_SiteCandidate";
    private String img_rf_BldgHeight ="img_rf_BldgHeight";
    private String img_rf_BldgStructure ="img_rf_BldgStructure";
    private String img_rf_AGL ="img_rf_AGL";
    private String img_rf_SiteContact ="img_rf_SiteContact";
    private String img_rf_AMSL ="img_rf_AMSL";
    private String img_rf_SiteAddress ="img_rf_SiteAddress";
    private String img_rf_SiteIndoor ="img_rf_SiteIndoor";
    private String img_rf_SiteOutdoor ="img_rf_SiteOutdoor";
    private String img_rf_ShelterConcrete ="img_rf_ShelterConcrete";
    private String img_rf_shelterFabricated ="img_rf_shelterFabricated";
    private String img_rf_Numerofotheroperator ="img_rf_Numerofotheroperator";
    private String img_rf_IPSite ="img_rf_IPSite";
    private String img_rf_Others ="img_rf_Others";
    private String img_rf_Sharing ="img_rf_Sharing";
    private String img_rf_Hostoperator ="img_rf_Hostoperator";
    private String img_rf_Anyguestoperators ="img_rf_Anyguestoperators";
    private String img_rf_NoofGSMAntenna ="img_rf_NoofGSMAntenna";
    private String rf_date ="date";
    private String rf_flag ="flag";

    // RF Sector Detail..............................................................
    private String rfs_id ="rfs_id";
    private String rfs_edt_Antenna_Type ="rfs_edt_Antenna_Type";
    private String rfs_edt_2GBand  ="rfs_edt_2GBand";
    private String rfs_edt_2GCoverge  ="rfs_edt_2GCoverge";
    private String rfs_edt_2GObstruction  ="rfs_edt_2GObstruction";
    private String rfs_edt_2G_Existing_Antenna_Height  ="rfs_edt_2G_Existing_Antenna_Height";
    private String rfs_edt_2G_Antenna_Make_and_Model ="rfs_edt_2G_Antenna_Make_and_Model";
    private String rfs_edt_2G_Existing_Antenna_Direction ="rfs_edt_2G_Existing_Antenna_Direction";
    private String rfs_edt_2G_Existing_antenna_tilt_Electrical ="rfs_edt_2G_Existing_antenna_tilt_Electrical";
    private String rfs_edt_2G_Existing_antenna_tilt_Mechanical ="rfs_edt_2G_Existing_antenna_tilt_Mechanical";
    private String rfs_edt_3GBand ="rfs_edt_3GBand";
    private String rfs_edt_3GCoverge ="rfs_edt_3GCoverge";
    private String rfs_edt_3GObstruction  ="rfs_edt_3GObstruction";
    private String rfs_edt_3G_Existing_Antenna_Ht ="rfs_edt_3G_Existing_Antenna_Ht";
    private String rfs_edt_3G_Antenna_Make_and_Model ="rfs_edt_3G_Antenna_Make_and_Model";
    private String rfs_edt_3G_Existing_Antenna_Direction ="rfs_edt_3G_Existing_Antenna_Direction";
    private String rfs_edt_3G_Existing_antenna_Electrical_tilt ="rfs_edt_3G_Existing_antenna_Electrical_tilt";
    private String rfs_edt_3G_Existing_antenna_Mechanical_tilt ="rfs_edt_3G_Existing_antenna_Mechanical_tilt";
    private String rfs_edt_Space_Available_for_3G_Antenna ="rfs_edt_Space_Available_for_3G_Antenna";
    private String rfs_edt_Addl_Poles_req_for_3G_Antenna ="rfs_edt_Addl_Poles_req_for_3G_Antenna";
    private String rfs_edt_3GAntenna_Swap_Required ="rfs_edt_3GAntenna_Swap_Required";
    private String rfs_edt_3GApproximate_Cable_Lenth ="rfs_edt_3GApproximate_Cable_Lenth";
    private String rfs_edt_3GAntenna_Port_EmptyDamaged ="rfs_edt_3GAntenna_Port_EmptyDamaged";
    private String rfs_edt_4GBand ="rfs_edt_4GBand";
    private String rfs_edt_4GCoverge ="rfs_edt_4GCoverge";
    private String rfs_edt_4GObstruction ="rfs_edt_4GObstruction";
    private String rfs_edt_4G_Existing_Antenna_Ht ="rfs_edt_4G_Existing_Antenna_Ht";
    private String rfs_edt_4G_Antenna_Make_and_Model ="rfs_edt_4G_Antenna_Make_and_Model";
    private String rfs_edt_4G_Existing_Antenna_Direction ="rfs_edt_4G_Existing_Antenna_Direction";
    private String rfs_edt_4G_Existing_antenna_Electrical_tilt ="rfs_edt_4G_Existing_antenna_Electrical_tilt";
    private String rfs_edt_4G_Existing_antenna_Mechanical_tilt ="rfs_edt_4G_Existing_antenna_Mechanical_tilt";
    private String rfs_edt_Space_Available_for_4G_Antenna ="rfs_edt_Space_Available_for_4G_Antenna";
    private String rfs_edt_Addl_Poles_reqd_for_4G_Antenna ="rfs_edt_Addl_Poles_reqd_for_4G_Antenna";
    private String rfs_edt_4GAntenna_Swap_Required ="rfs_edt_4GAntenna_Swap_Required";
    private String rfs_edt_4GApproximate_Cable_Lenth ="rfs_edt_4GApproximate_Cable_Lenth";
    private String rfs_edt_4GAntennarfs_edt_Port_EmptyDamaged ="rfs_edt_4GAntennarfs_Port_EmptyDamaged";
    private String rfs_img_Antenna_Type ="rfs_img_Antenna_Type";
    private String rfs_img_2GBand ="rfs_img_2GBand";
    private String rfs_img_2GCoverge ="rfs_img_2GCoverge";
    private String rfs_img_2GObstruction ="rfs_img_2GObstruction";
    private String rfs_img_2G_Existing_Antenna_Height ="rfs_img_2G_Existing_Antenna_Height";
    private String rfs_img_2G_Antenna_Make_and_Model ="rfs_img_2G_Antenna_Make_and_Model";
    private String rfs_img_2G_Existing_Antenna_Direction ="rfs_img_2G_Existing_Antenna_Direction";
    private String rfs_img_2G_Existing_antenna_tilt_Electrical ="rfs_img_2G_Existing_antenna_tilt_Electrical";
    private String rfs_img_2G_Existing_antenna_tilt_Mechanical ="rfs_img_2G_Existing_antenna_tilt_Mechanical";
    private String rfs_img_3GBand ="rfs_img_3GBand";
    private String rfs_img_3GCoverge ="rfs_img_3GCoverge";
    private String rfs_img_3GObstruction ="rfs_img_3GObstruction";
    private String rfs_img_3G_Existing_Antenna_Ht ="rfs_img_3G_Existing_Antenna_Ht";
    private String rfs_img_3G_Antenna_Make_and_Model ="rfs_img_3G_Antenna_Make_and_Model";
    private String rfs_img_3G_Existing_Antenna_Direction ="rfs_img_3G_Existing_Antenna_Direction";
    private String rfs_img_3G_Existing_antenna_Electrical_tilt ="rfs_img_3G_Existing_antenna_Electrical_tilt";
    private String rfs_img_3G_Existing_antenna_Mechanical_tilt ="rfs_img_3G_Existing_antenna_Mechanical_tilt";
    private String rfs_img_Space_Available_for_3G_Antenna ="rfs_img_Space_Available_for_3G_Antenna";
    private String rfs_img_Addl_Poles_reqd_for_3G_Antenna ="rfs_img_Addl_Poles_reqd_for_3G_Antenna";
    private String rfs_img_3GAntenna_Swap_Required ="rfs_img_Addl_Poles_reqd_for_3G_Antenna";
    private String rfs_img_3GApproximate_Cable_Lenth ="rfs_img_3GApproximate_Cable_Lenth";
    private String rfs_img_3GAntenna_Port_EmptyDamaged ="rfs_img_3GAntenna_Port_EmptyDamaged";
    private String rfs_img_4GBand ="rfs_img_4GBand";
    private String rfs_img_4GCoverge ="rfs_img_4GCoverge";
    private String rfs_img_4GObstruction ="rfs_img_4GObstruction";
    private String rfs_img_4G_Existing_Antenna_Ht ="rfs_img_4G_Existing_Antenna_Ht";
    private String rfs_img_4G_Antenna_Make_and_Model ="rfs_img_4G_Antenna_Make_and_Model";
    private String rfs_img_4G_Existing_Antenna_Direction ="rfs_img_4G_Existing_Antenna_Direction";
    private String rfs_img_4G_Existing_antenna_Electrical_tilt ="rfs_img_4G_Existing_antenna_Electrical_tilt";
    private String rfs_img_4G_Existing_antenna_Mechanical_tilt ="rfs_img_4G_Existing_antenna_Mechanical_tilt";
    private String rfs_img_Space_Available_for_4G_Antenna ="rfs_img_Space_Available_for_4G_Antenna";
    private String rfs_img_Addl_Poles_reqd_for_4G_Antenna ="rfs_img_Addl_Poles_reqd_for_4G_Antenna";
    private String rfs_img_4GAntenna_Swap_Required ="rfs_img_4GAntenna_Swap_Required";
    private String rfs_img_4GApproximate_Cable_Lenth ="rfs_img_4GApproximate_Cable_Lenth";
    private String rfs_img_4GAntenna_Port_EmptyDamaged ="rfs_img_4GAntenna_Port_EmptyDamaged";
    private String rf_sectorDetail_name ="rf_sectorDetail_name";
    private String rfs_date ="rfs_date";
    private String rfs_flag ="rfs_flag";


    public DatabaseHandler(Context context) {
        super(context, "/mnt/sdcard/lhqdatabase14.db", null, DATABASE_VERSION);
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
                + KEY_TECHNOLOGY + " TEXT," + KEY_TECHNOLOGYTYPE + " TEXT," + KEY_LOCATION + " TEXT," + KEY_SITEID + " TEXT," + KEY_DATE + " TEXT," + KEY_LAT + " TEXT," + KEY_LOG + " TEXT," + KEY_FLAG + " integer," + KEY_CLUSTERID + " TEXT" + ")";

        String CREATE_TABLE_SITEDETAIL = "CREATE TABLE " + TABLE_SITEDETAIL + "(" + keyincriid + " integer primary key autoincrement,"
                + keysiteid + " TEXT," + keysiteid_photo + " TEXT," + keysitename + " TEXT," + keysitename_photo + " TEXT," + keytowersiteid + " TEXT,"
                + keytowersiteid_photo + " TEXT," + keytowercompanyname + " TEXT," + keytowercompanyname__photo + " TEXT," + keysiteaddress + " TEXT," + keysiteaddress_photo + " TEXT," + keysectorid + " TEXT," + keysectorid_photo + " TEXT," + keylat + " TEXT," + keylog + " TEXT," + keysitetype + " TEXT," + keysitetype_photo + " TEXT,"
                + keybuildingfloor + " TEXT," + keybuildingfloor_photo + " TEXT,"
                + keybuildingheight + " TEXT," + keybuildingheight_photo + " TEXT," + keytowerheight + " TEXT," + keytowerheight_photo + " TEXT," + keyfulltowerphoto + " TEXT," + keyfulltowerphoto_photo + " TEXT," + keynodebtype + " TEXT," + keynodebtype_photo + " TEXT," + keyclassical + " TEXT," + keyclassical_photo + " TEXT," + keyenodebtype + " TEXT," + keyenodebtype_photo + " TEXT," + keyanchoroperator + " TEXT," + keyanchoroperator_photo + " TEXT," + keysharingopco1 + " TEXT," + keysharingopco1_photo + " TEXT," + keysharingopco2 + " TEXT," + keysharingopco2_photo + " TEXT," + keysharingopco3 + " TEXT," + keysharingopco3_photo + " TEXT,"
                + keyinfraprovider + " TEXT," + keyinfraprovider_photo + " TEXT," + keytype_id_od + " TEXT," + keytype_id_od_photo + " TEXT," + keyinfrashared + " TEXT," + keyinfrashared_photo + " TEXT," + keyextra1 + " TEXT," + keyextra1_photo + " TEXT," + keyextra2 + " TEXT," + keyextra2_photo + " TEXT," + keyremark1 + " TEXT," + keyremark1_photo + " TEXT," + keyremark2 + " TEXT," + keyremark2_photo + " TEXT," + keyflag + " integer," + keydate + " TEXT" + ")";


        String CREATE_TABLE_SITEPANOROMIC = "CREATE TABLE " + TABLE_SITEPANOROMIC + "(" + SPTVID + " integer primary key autoincrement," + SPTVBEARING0 + " TEXT," + SPTVBEARING30 + " TEXT," + SPTVBEARING60 + " TEXT," + SPTVBEARING90 + " TEXT," + SPTVBEARING120 + " TEXT,"
                + SPTVBEARING150 + " TEXT," + SPTVBEARING180 + " TEXT," + SPTVBEARING210 + " TEXT," + SPTVBEARING240 + " TEXT," + SPTVBEARING270 + " TEXT," + SPTVBEARING300 + " TEXT," + SPTVBEARING330 + " TEXT,"
                + SPIMGBEARING0 + " TEXT," + SPIMGBEARING30 + " TEXT," + SPIMGBEARING60 + " TEXT," + SPIMGBEARING90 + " TEXT,"
                + SPIMGBEARING120 + " TEXT," + SPIMGBEARING150 + " TEXT," + SPIMGBEARING180 + " TEXT," + SPIMGBEARING210 + " TEXT,"
                + SPIMGBEARING240 + " TEXT," + SPIMGBEARING270 + " TEXT," + SPIMGBEARING300 + " TEXT," + SPIMGBEARING330 + " TEXT,"
                + SPEXTRA1 + " TEXT," + SPEXTRA2 + " TEXT," + SPREMARK1 + " TEXT," + SPREMARK2 + " TEXT," + SPFLAG + " integer," + SPDATE + " TEXT" + ")";


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
                + " TEXT," + sectordeatail_img_remark1 + " TEXT," + sectordeatail_edt_remak2 + " TEXT," + sectordeatail_img_remark2 + " TEXT," + sectordeatailfrgamentname + " TEXT,"
                + sectordeatail_flag + " integer," + sectordeatail_date + " TEXT," + sdbasebandUnitType_edt + " TEXT," +
                sdbasebandUnitType_img + " TEXT," + sdrNCName_edt + " TEXT," + sdrNCName_img + " TEXT," + sdnoofChannelElements_edt + " TEXT," + sdnoofChannelElements_img + " TEXT" + ")";


        String CREATE_TABLE_OTHERDETAIL = "CREATE TABLE " + TABLE_OTHERDETAIL + "(" + otherid + " integer primary key autoincrement,"
                + edtRiggerPic + " TEXT," + edtEngineerPic + " TEXT," + edtCarPic + " TEXT," + edt_RiggerPicwithclimbingTower + " TEXT," + edtRiggerPicduringWah + " TEXT,"
                + iv_RiggerPic + " TEXT," + iv_EngineerPic + " TEXT," + iv_CarPic + " TEXT," + iv_RiggerPicwithclimbingTower + " TEXT," + iv_RiggerPicduringWah + " TEXT,"
                + otherdate + " TEXT," + otherflag + " integer" + ")";

        String CREATE_TABLE_LOSSITEDETAIL = "CREATE TABLE " + TABLE_LOSSITEDETAIL + "(" + losdetail_id + " integer primary key autoincrement,"
                + losdetail_SiteID_TXT + " TEXT," + losdetail_SiteName_TXT + " TEXT," + losdetail_Sharing_TXT + " TEXT," + losdetail_SiteType_TXT + " TEXT," + losdetail_SurveyDate_TXT + " TEXT,"
                + losdetail_TNPEngineer_TXT + " TEXT," + losdetail_TNPEngineerTel_TXT + " TEXT," + losdetail_Customerrepresentative_TXT + " TEXT," + losdetail_Nearenddetails_TXT + " TEXT," + losdetail_Lat + " TEXT,"
                + losdetail_Long + " TEXT," + losdetail_CandidateName_TXT + " TEXT," + losdetail_Address_TXT + " TEXT," + losdetail_Bldght_TXT + " TEXT," + losdetail_Totalht_TXT + " TEXT," + losdetail_AMSL_TXT + " TEXT,"
                + losdetail_Buildingsideviewphoto_TXT + " TEXT," + losdetail_AntennaTowerlocationphoto_TXT + " TEXT," + losdetail_Possibleobstacle_TXT + " TEXT," + losdetail_HeightofObstruction_TXT + " TEXT," + losdetail_PanaromicPhoto_TXT + " TEXT,"
                + losdetail_ExisitngNoofMWAntennatypewithsizeandPhotograph_TXT + " TEXT," + losdetail_ExisitngMWAntennaheightandPolemountPhotograph_TXT + " TEXT," + losdetail_SiteID_PIC + " TEXT," + losdetail_SiteName_PIC + " TEXT," + losdetail_Sharing_PIC + " TEXT," + losdetail_SiteType_PIC + " TEXT," + losdetail_SurveyDate_PIC + " TEXT,"
                + losdetail_TNPEngineer_PIC + " TEXT," + losdetail_TNPEngineerTel_PIC + " TEXT," + losdetail_Customerrepresentative_PIC + " TEXT," + losdetail_Nearenddetails_PIC + " TEXT," +
                losdetail_CandidateName_PIC + " TEXT," + losdetail_Address_PIC + " TEXT," + losdetail_Bldght_PIC + " TEXT," + losdetail_Totalht_PIC + " TEXT," + losdetail_AMSL_PIC + " TEXT,"
                + losdetail_Buildingsideviewphoto_PIC + " TEXT," + losdetail_AntennaTowerlocationphoto_PIC + " TEXT," + losdetail_Possibleobstacle_PIC + " TEXT," + losdetail_HeightofObstruction_PIC + " TEXT," + losdetail_PanaromicPhoto_PIC + " TEXT,"
                + losdetail_ExisitngNoofMWAntennatypewithsizeandPhotograph_PIC + " TEXT," + losdetail_ExisitngMWAntennaheightandPolemountPhotograph_PIC + " TEXT," + losdetail_date + " TEXT," + losdetail_flag + " integer" + ")";

        String CREATE_TABLE_LOSTRANSMISSIONLINK = "CREATE TABLE " + TABLE_LOSSTRANSMISSIONLINK + "(" + tranLink_ID + " integer primary key autoincrement,"
                + tranLink_edt_SiteID + " TEXT," + tranLink_edt_Sitename + " TEXT," + tranLink_edt_Latitude + " TEXT," + tranLink_edt_Longitude + " TEXT," + tranLink_edt_Azimuthfromnearend + " TEXT,"
                + tranLink_edt_Distance + " TEXT," + tranLink_edt_AntennaHeightatFarend + " TEXT," + tranLink_edt_PoleFixtureRequirementatFarend + " TEXT," + tranLink_edt_IFLengthatFarend + " TEXT," + tranLink_edt_BuildingHeightatFarend + " TEXT,"
                + tranLink_edt_TotalhtForGBTRTTRTPATFarEnd + " TEXT," + tranLink_edt_AMSLatFarEnd + " TEXT," + tranLink_img_SiteID + " TEXT," + tranLink_img_Sitename + " TEXT," + tranLink_img_Azimuthfromnearend + " TEXT,"
                + tranLink_img_Distance + " TEXT," + tranLink_img_AntennaHeightatFarend + " TEXT," + tranLink_img_PoleFixtureRequirementatFarend + " TEXT," + tranLink_img_IFLengthatFarend + " TEXT," + tranLink_img_BuildingHeightatFarend + " TEXT,"
                + tranLink_img_TotalhtForGBTRTTRTPATFarEnd + " TEXT,"   + tranLink_img_AMSLatFarEnd + " TEXT,"  + tranLink_name + " TEXT,"
                + tranLink_date + " TEXT," + tranLink_flag + " integer" + ")";

        String CREATE_TABLE_LOSTRANSMISSIONNOLINK = "CREATE TABLE " + TABLE_LOSSTRANSMISSIONNOLINK + "(" + transnoLink_id + " integer primary key autoincrement,"
                + transnoLink_edt_SiteID + " TEXT," + transnoLink_edt_Sitename + " TEXT," + transnoLink_edt_ObstructionDetails + " TEXT," + transnoLink_edt_Azimuth + " TEXT," + transnoLink_edt_Distance + " TEXT,"
                + transnoLink_edt_AntennaHeight + " TEXT," + transnoLink_edt_Altitude+ " TEXT," + transnoLink_img_SiteID + " TEXT," + transnoLink_img_Sitename + " TEXT,"
                + transnoLink_img_ObstructionDetails + " TEXT," + transnoLink_img_Azimuth + " TEXT," + transnoLink_img_Distance + " TEXT," + transnoLink_img_AntennaHeight + " TEXT," + transnoLink_img_Altitude + " TEXT,"
                + transNoLink_name + " TEXT,"   + transnoLink_date + " TEXT," + transnoLink_flag + " integer" + ")";

        String CREATE_TABLE_LOSPHOTOS = "CREATE TABLE " + TABLE_LOSPHOTOS + "(" + los_P_id + " integer primary key autoincrement,"
                + los_P_NearEndFarEndphoto1 + " TEXT," + los_P_FarEndtoNearEndphoto1 + " TEXT," + los_P_TowerPhoto1 + " TEXT," + los_P_NearEndtoFarEndphoto2 + " TEXT," + los_P_FarEndNearEndphoto2 + " TEXT,"
                + los_P_TowerPhoto2 + " TEXT," + los_P_NearEndFarEndphoto3 + " TEXT," + los_P_FarEndtoNearEndphoto3 + " TEXT," + los_P_TowerPhoto3 + " TEXT," + los_P_NearEndtoFarEndphoto4 + " TEXT,"
                + los_P_FarEndtoNearEndphoto4 + " TEXT," + los_P_TowerPhoto4 + " TEXT,"
                + los_P_date + " TEXT," + los_P_flag + " integer" + ")";

        String CREATE_TABLE_RFSITEDETAIL = "CREATE TABLE " + TABLE_RFSITEDETAIL + "(" + rfid + " integer primary key autoincrement,"
                + edt_rf_SiteID + " TEXT," + edt_rf_SiteName + " TEXT," + edt_rf_SurveyDate  + " TEXT," + edt_rf_City + " TEXT," + edt_rf_IMID + " TEXT,"
                + edt_rf_Cluttertype + " TEXT," + edt_rf_SiteType + " TEXT," + edt_rf_Zone + " TEXT," + edt_rf_SiteCandidate + " TEXT," + edt_rf_BldgHeight + " TEXT,"
                + edt_rf_BldgStructure + " TEXT," + edt_rf_AGL + " TEXT," + edt_rf_SiteContact + " TEXT," + edt_rf_AMSL + " TEXT," + edt_rf_SiteAddress + " TEXT," + edt_rf_SiteIndoor + " TEXT,"
                + edt_rf_SiteOutdoor + " TEXT," + edt_rf_ShelterConcrete + " TEXT," + edt_rf_shelterFabricated + " TEXT," + edt_rf_Numerofotheroperator + " TEXT," + edt_rf_IPSite + " TEXT,"
                + edt_rf_Others + " TEXT," + edt_rf_Sharing + " TEXT," + edt_rf_Hostoperator + " TEXT," + edt_rf_Anyguestoperators + " TEXT," + edt_rf_NoofGSMAntenna + " TEXT," + edt_rf_Lat + " TEXT," + edt_rf_Long + " TEXT,"
                + img_rf_SiteID + " TEXT," + img_rf_SiteName + " TEXT," + img_rf_SurveyDate  + " TEXT," + img_rf_City + " TEXT," + img_rf_IMID + " TEXT,"
                + img_rf_Cluttertype + " TEXT," + img_rf_SiteType + " TEXT," + img_rf_Zone + " TEXT," + img_rf_SiteCandidate + " TEXT," + img_rf_BldgHeight + " TEXT,"
                + img_rf_BldgStructure + " TEXT," + img_rf_AGL + " TEXT," + img_rf_SiteContact + " TEXT," + img_rf_AMSL + " TEXT," + img_rf_SiteAddress + " TEXT," + img_rf_SiteIndoor + " TEXT,"
                + img_rf_SiteOutdoor + " TEXT," + img_rf_ShelterConcrete + " TEXT," + img_rf_shelterFabricated + " TEXT," + img_rf_Numerofotheroperator + " TEXT," + img_rf_IPSite + " TEXT,"
                + img_rf_Others + " TEXT," + img_rf_Sharing + " TEXT," + img_rf_Hostoperator + " TEXT," + img_rf_Anyguestoperators + " TEXT," + img_rf_NoofGSMAntenna + " TEXT,"
                + rf_date + " TEXT," + rf_flag + " integer" + ")";





        String CREATE_TABLE_RFSECTORDETAIL = "CREATE TABLE " + TABLE_RFSECTORDETAIL + "(" + rfs_id  + " integer primary key autoincrement," + rfs_edt_Antenna_Type
                + " TEXT," + rfs_edt_2GBand + " TEXT," + rfs_edt_2GCoverge + " TEXT," + rfs_edt_2GObstruction + " TEXT," + rfs_edt_2G_Existing_Antenna_Height
                + " TEXT," + rfs_edt_2G_Antenna_Make_and_Model + " TEXT," + rfs_edt_2G_Existing_Antenna_Direction + " TEXT," + rfs_edt_2G_Existing_antenna_tilt_Electrical + " TEXT," + rfs_edt_2G_Existing_antenna_tilt_Mechanical
                + " TEXT," + rfs_edt_3GBand + " TEXT," + rfs_edt_3GCoverge + " TEXT," + rfs_edt_3GObstruction + " TEXT," + rfs_edt_3G_Existing_Antenna_Ht
                + " TEXT," + rfs_edt_3G_Antenna_Make_and_Model + " TEXT," + rfs_edt_3G_Existing_Antenna_Direction + " TEXT," + rfs_edt_3G_Existing_antenna_Electrical_tilt
                + " TEXT," + rfs_edt_3G_Existing_antenna_Mechanical_tilt + " TEXT," + rfs_edt_Space_Available_for_3G_Antenna + " TEXT," + rfs_edt_Addl_Poles_req_for_3G_Antenna
                + " TEXT," + rfs_edt_3GAntenna_Swap_Required + " TEXT," + rfs_edt_3GApproximate_Cable_Lenth + " TEXT," + rfs_edt_3GAntenna_Port_EmptyDamaged
                + " TEXT," + rfs_edt_4GBand + " TEXT," + rfs_edt_4GCoverge + " TEXT," + rfs_edt_4GObstruction
                + " TEXT," + rfs_edt_4G_Existing_Antenna_Ht + " TEXT," + rfs_edt_4G_Antenna_Make_and_Model + " TEXT," + rfs_edt_4G_Existing_Antenna_Direction
                + " TEXT," + rfs_edt_4G_Existing_antenna_Electrical_tilt + " TEXT," + rfs_edt_4G_Existing_antenna_Mechanical_tilt + " TEXT,"+rfs_edt_Space_Available_for_4G_Antenna+" TEXT," + rfs_edt_Addl_Poles_reqd_for_4G_Antenna
                + " TEXT," + rfs_edt_4GAntenna_Swap_Required + " TEXT," + rfs_edt_4GApproximate_Cable_Lenth + " TEXT," + rfs_edt_4GAntennarfs_edt_Port_EmptyDamaged
                + " TEXT," + rfs_img_Antenna_Type  + " TEXT," + rfs_img_2GBand + " TEXT," + rfs_img_2GCoverge + " TEXT," + rfs_img_2GObstruction + " TEXT," + rfs_img_2G_Existing_Antenna_Height
                + " TEXT," + rfs_img_2G_Antenna_Make_and_Model + " TEXT," + rfs_img_2G_Existing_Antenna_Direction + " TEXT," + rfs_img_2G_Existing_antenna_tilt_Electrical + " TEXT," + rfs_img_2G_Existing_antenna_tilt_Mechanical
                + " TEXT," + rfs_img_3GBand + " TEXT," + rfs_img_3GCoverge + " TEXT," + rfs_img_3GObstruction + " TEXT," + rfs_img_3G_Existing_Antenna_Ht
                + " TEXT," + rfs_img_3G_Antenna_Make_and_Model + " TEXT," + rfs_img_3G_Existing_Antenna_Direction + " TEXT," + rfs_img_3G_Existing_antenna_Electrical_tilt
                + " TEXT," + rfs_img_3G_Existing_antenna_Mechanical_tilt + " TEXT," + rfs_img_Space_Available_for_3G_Antenna + " TEXT," + rfs_img_Addl_Poles_reqd_for_3G_Antenna
                + " TEXT," + rfs_img_3GAntenna_Swap_Required + " TEXT," + rfs_img_3GApproximate_Cable_Lenth + " TEXT," + rfs_img_3GAntenna_Port_EmptyDamaged
                + " TEXT," + rfs_img_4GBand + " TEXT," + rfs_img_4GCoverge + " TEXT," + rfs_img_4GObstruction
                + " TEXT," + rfs_img_4G_Existing_Antenna_Ht + " TEXT," + rfs_img_4G_Antenna_Make_and_Model + " TEXT," + rfs_img_4G_Existing_Antenna_Direction
                + " TEXT," + rfs_img_4G_Existing_antenna_Electrical_tilt + " TEXT," + rfs_img_4G_Existing_antenna_Mechanical_tilt +rfs_img_Space_Available_for_4G_Antenna+" TEXT,"+ " TEXT," + rfs_img_Addl_Poles_reqd_for_4G_Antenna
                + " TEXT," + rfs_img_4GAntenna_Swap_Required + " TEXT," + rfs_img_4GApproximate_Cable_Lenth + " TEXT," + rfs_img_4GAntenna_Port_EmptyDamaged
                + " TEXT,"  + rf_sectorDetail_name  + " TEXT,"  + rfs_date +" TEXT," + rfs_flag + " integer" + ")";



        db.execSQL(CREATE_TABLE_SURVEYFORM);
        db.execSQL(CREATE_TABLE_SITEDETAIL);
        db.execSQL(CREATE_TABLE_SITEPANOROMIC);
        db.execSQL(CREATE_TABLE_SITEPANOROMICBLOCKING);
        db.execSQL(CREATE_TABLE_SECTORDETAIL);
        db.execSQL(CREATE_TABLE_OTHERDETAIL);
        db.execSQL(CREATE_TABLE_LOSSITEDETAIL);
        db.execSQL(CREATE_TABLE_LOSTRANSMISSIONLINK);
        db.execSQL(CREATE_TABLE_LOSTRANSMISSIONNOLINK);
        db.execSQL(CREATE_TABLE_LOSPHOTOS);
        db.execSQL(CREATE_TABLE_RFSITEDETAIL);
        db.execSQL(CREATE_TABLE_RFSECTORDETAIL);

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
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOSSITEDETAIL);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOSSTRANSMISSIONLINK);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOSSTRANSMISSIONNOLINK);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOSPHOTOS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RFSITEDETAIL);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RFSECTORDETAIL);

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

    public boolean updateSurveyForm(int incriid, int flag) {
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
                        Log.v("datbase", list.toString());
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

    public boolean updateSITEDETAIL(int incriid, int flag) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues args = new ContentValues();

        args.put(keyflag, flag);
        //  args.put(KEY_LATLONG_TOTALDIST,dis);
        int i = db.update(TABLE_SITEDETAIL, args, keyincriid + "=" + incriid, null);
        return i > 0;
    }

    public void deleteSomeRow_SiteDetail() {
        SQLiteDatabase db = this.getWritableDatabase();
        //  db.execSQL("delete from "+ TABLE_SURVEYFORM+" where " +KEY_INCRI_ID+ " not in ( select " +KEY_INCRI_ID+" from "+ TABLE_SURVEYFORM+" order by "+KEY_DATE +" desc limit 100)");
        db.execSQL("DELETE FROM " + TABLE_SITEDETAIL + " ;");
        db.close();
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

    public void deleteSomeRow_SitePanoramic() {
        SQLiteDatabase db = this.getWritableDatabase();
        //  db.execSQL("delete from "+ TABLE_SURVEYFORM+" where " +KEY_INCRI_ID+ " not in ( select " +KEY_INCRI_ID+" from "+ TABLE_SURVEYFORM+" order by "+KEY_DATE +" desc limit 100)");
        db.execSQL("DELETE FROM " + TABLE_SITEPANOROMIC + " ;");
        db.close();
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

    public void deleteSomeRow_SectorDetail() {
        SQLiteDatabase db = this.getWritableDatabase();
        //  db.execSQL("delete from "+ TABLE_SURVEYFORM+" where " +KEY_INCRI_ID+ " not in ( select " +KEY_INCRI_ID+" from "+ TABLE_SURVEYFORM+" order by "+KEY_DATE +" desc limit 100)");
        db.execSQL("DELETE FROM " + TABLE_SECTORDETAIL + " ;");
        db.close();
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

    public void deleteSomeRow_OtherDetail() {
        SQLiteDatabase db = this.getWritableDatabase();
        //  db.execSQL("delete from "+ TABLE_SURVEYFORM+" where " +KEY_INCRI_ID+ " not in ( select " +KEY_INCRI_ID+" from "+ TABLE_SURVEYFORM+" order by "+KEY_DATE +" desc limit 100)");
        db.execSQL("DELETE FROM " + TABLE_SITEDETAIL + " ;");
        db.close();
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

    public ArrayList<HashMap<String, String>> printTable1Data(String table_name) {
        ArrayList<HashMap<String, String>> prodArrayList = new ArrayList<HashMap<String, String>>();
        SQLiteDatabase db = getReadableDatabase();
        String row_values = "";
        Cursor cur = db.rawQuery("SELECT * FROM " + table_name + " ORDER BY " + keyincriid + " DESC LIMIT 1", null);
        if (cur.getCount() != 0) {
            cur.moveToFirst();
            do {
                for (int i = 0; i < cur.getColumnCount(); i++) {
                    String column_value = cur.getString(i);
                    String column_name = cur.getColumnName(i);
                    HashMap<String, String> map = new HashMap<String, String>();
                    if (i % 2 == 0) {
                        map.put("column_name", column_name);
                        map.put("column_value", column_value);
                    }
                    prodArrayList.add(map);
                }
                Log.d("LOG_TAG_HERE", row_values);

            } while (cur.moveToNext());
        }

        return prodArrayList;
    }
//...................START LOS SITEDETAIL...................................................

    public void insertLOSSiteDetailData(LOSSiteDetailData losSiteDetailData) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues values = new ContentValues();

            values.put(losdetail_SiteID_TXT, losSiteDetailData.getSiteID_TXT());
            values.put(losdetail_SiteName_TXT, losSiteDetailData.getSiteName_TXT());
            values.put(losdetail_Sharing_TXT, losSiteDetailData.getSharing_TXT());
            values.put(losdetail_SiteType_TXT, losSiteDetailData.getSiteType_TXT());
            values.put(losdetail_SurveyDate_TXT, losSiteDetailData.getSurveyDate_TXT());
            values.put(losdetail_TNPEngineer_TXT, losSiteDetailData.getTNPEngineer_TXT());
            values.put(losdetail_TNPEngineerTel_TXT, losSiteDetailData.getTNPEngineerTel_TXT());
            values.put(losdetail_Customerrepresentative_TXT, losSiteDetailData.getCustomerrepresentative_TXT());
            values.put(losdetail_Nearenddetails_TXT, losSiteDetailData.getNearenddetails_TXT());
            values.put(losdetail_Lat, losSiteDetailData.getLat());
            values.put(losdetail_Long, losSiteDetailData.getLong());
            values.put(losdetail_CandidateName_TXT, losSiteDetailData.getCandidateName_TXT());
            values.put(losdetail_Address_TXT, losSiteDetailData.getAddress_TXT());
            values.put(losdetail_Bldght_TXT, losSiteDetailData.getBldght_TXT());
            values.put(losdetail_Totalht_TXT, losSiteDetailData.getTotalht_TXT());
            values.put(losdetail_AMSL_TXT, losSiteDetailData.getAMSL_TXT());
            values.put(losdetail_Buildingsideviewphoto_TXT, losSiteDetailData.getBuildingsideviewphoto_TXT());
            values.put(losdetail_AntennaTowerlocationphoto_TXT, losSiteDetailData.getAntennaTowerlocationphoto_TXT());
            values.put(losdetail_Possibleobstacle_TXT, losSiteDetailData.getPossibleobstacle_TXT());
            values.put(losdetail_HeightofObstruction_TXT, losSiteDetailData.getHeightofObstruction_TXT());
            values.put(losdetail_PanaromicPhoto_TXT, losSiteDetailData.getPanaromicPhoto_TXT());
            values.put(losdetail_ExisitngNoofMWAntennatypewithsizeandPhotograph_TXT, losSiteDetailData.getExisitngNoofMWAntennatypewithsizeandPhotograph_TXT());
            values.put(losdetail_ExisitngMWAntennaheightandPolemountPhotograph_TXT, losSiteDetailData.getExisitngMWAntennaheightandPolemountPhotograph_TXT());

            values.put(losdetail_SiteID_PIC, losSiteDetailData.getSiteID_PIC());
            values.put(losdetail_SiteName_PIC, losSiteDetailData.getSiteName_PIC());
            values.put(losdetail_Sharing_PIC, losSiteDetailData.getSharing_PIC());
            values.put(losdetail_SiteType_PIC, losSiteDetailData.getSiteType_PIC());
            values.put(losdetail_SurveyDate_PIC, losSiteDetailData.getSurveyDate_PIC());
            values.put(losdetail_TNPEngineer_PIC, losSiteDetailData.getTNPEngineer_PIC());
            values.put(losdetail_TNPEngineerTel_PIC, losSiteDetailData.getTNPEngineerTel_PIC());
            values.put(losdetail_Customerrepresentative_PIC, losSiteDetailData.getCustomerrepresentative_PIC());
            values.put(losdetail_Nearenddetails_PIC, losSiteDetailData.getNearenddetails_PIC());
            values.put(losdetail_CandidateName_PIC, losSiteDetailData.getCandidateName_PIC());
            values.put(losdetail_Address_PIC, losSiteDetailData.getAddress_PIC());
            values.put(losdetail_Bldght_PIC, losSiteDetailData.getBldght_PIC());
            values.put(losdetail_Totalht_PIC, losSiteDetailData.getTotalht_PIC());
            values.put(losdetail_AMSL_PIC, losSiteDetailData.getAMSL_PIC());
            values.put(losdetail_Buildingsideviewphoto_PIC, losSiteDetailData.getBuildingsideviewphoto_PIC());
            values.put(losdetail_AntennaTowerlocationphoto_PIC, losSiteDetailData.getAntennaTowerlocationphoto_PIC());
            values.put(losdetail_Possibleobstacle_PIC, losSiteDetailData.getPossibleobstacle_PIC());
            values.put(losdetail_HeightofObstruction_PIC, losSiteDetailData.getHeightofObstruction_PIC());
            values.put(losdetail_PanaromicPhoto_PIC, losSiteDetailData.getPanaromicPhoto_PIC());
            values.put(losdetail_ExisitngNoofMWAntennatypewithsizeandPhotograph_PIC, losSiteDetailData.getExisitngNoofMWAntennatypewithsizeandPhotograph_PIC());
            values.put(losdetail_ExisitngMWAntennaheightandPolemountPhotograph_PIC, losSiteDetailData.getExisitngMWAntennaheightandPolemountPhotograph_PIC());

            values.put(losdetail_date, losSiteDetailData.getDate());
            values.put(losdetail_flag, losSiteDetailData.getFlag());


            // Inserting Row
            db.insert(TABLE_LOSSITEDETAIL, null, values);
        } catch (Exception ignor) {
            Log.v(TAG, "Databaser insert los_sitedetail error");
        }
        Log.v(TAG, "Databaser insert los_sitedetail table");
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    public List<LOSSiteDetailData> getLastLOSSitedetaiData() {
        ArrayList<LOSSiteDetailData> list = new ArrayList<LOSSiteDetailData>();
        // Select All Query
        // SELECT * FROM members ORDER BY date_of_birth DESC;
        //String selectQuery = "SELECT  * FROM " + TABLE_LATLONG +" ORDER BY "+KEY_LATLONG_INCRIID+" DESC LIMIT 1;";

        String selectQuery = "SELECT  * FROM " + TABLE_LOSSITEDETAIL + " ORDER BY " + losdetail_id + " DESC LIMIT 1";

        SQLiteDatabase db = this.getReadableDatabase();
        try {

            Cursor cursor = db.rawQuery(selectQuery, null);
            try {
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        LOSSiteDetailData losSiteDetailData = new LOSSiteDetailData();
                        losSiteDetailData.setId(cursor.getInt(0));
                        losSiteDetailData.setSiteID_TXT(cursor.getString(1));
                        losSiteDetailData.setSiteName_TXT(cursor.getString(2));
                        losSiteDetailData.setSharing_TXT(cursor.getString(3));
                        losSiteDetailData.setSiteType_TXT(cursor.getString(4));
                        losSiteDetailData.setSurveyDate_TXT(cursor.getString(5));
                        losSiteDetailData.setTNPEngineer_TXT(cursor.getString(6));
                        losSiteDetailData.setTNPEngineerTel_TXT(cursor.getString(7));
                        losSiteDetailData.setCustomerrepresentative_TXT(cursor.getString(8));
                        losSiteDetailData.setNearenddetails_TXT(cursor.getString(9));
                        losSiteDetailData.setLat(cursor.getString(10));
                        losSiteDetailData.setLong(cursor.getString(11));
                        losSiteDetailData.setCandidateName_TXT(cursor.getString(12));
                        losSiteDetailData.setAddress_TXT(cursor.getString(13));
                        losSiteDetailData.setBldght_TXT(cursor.getString(14));
                        losSiteDetailData.setTotalht_TXT(cursor.getString(15));
                        losSiteDetailData.setAMSL_TXT(cursor.getString(16));
                        losSiteDetailData.setBuildingsideviewphoto_TXT(cursor.getString(17));
                        losSiteDetailData.setAntennaTowerlocationphoto_TXT(cursor.getString(18));
                        losSiteDetailData.setPossibleobstacle_TXT(cursor.getString(19));
                        losSiteDetailData.setHeightofObstruction_TXT(cursor.getString(20));
                        losSiteDetailData.setPanaromicPhoto_TXT(cursor.getString(21));
                        losSiteDetailData.setExisitngNoofMWAntennatypewithsizeandPhotograph_TXT(cursor.getString(22));
                        losSiteDetailData.setExisitngMWAntennaheightandPolemountPhotograph_TXT(cursor.getString(23));

                        losSiteDetailData.setSiteID_PIC(cursor.getString(24));
                        losSiteDetailData.setSiteName_PIC(cursor.getString(25));
                        losSiteDetailData.setSharing_PIC(cursor.getString(26));
                        losSiteDetailData.setSiteType_PIC(cursor.getString(27));
                        losSiteDetailData.setSurveyDate_PIC(cursor.getString(28));
                        losSiteDetailData.setTNPEngineer_PIC(cursor.getString(29));
                        losSiteDetailData.setTNPEngineerTel_PIC(cursor.getString(30));
                        losSiteDetailData.setCustomerrepresentative_PIC(cursor.getString(31));
                        losSiteDetailData.setNearenddetails_PIC(cursor.getString(32));
                        losSiteDetailData.setCandidateName_PIC(cursor.getString(33));
                        losSiteDetailData.setAddress_PIC(cursor.getString(34));
                        losSiteDetailData.setBldght_PIC(cursor.getString(35));
                        losSiteDetailData.setTotalht_PIC(cursor.getString(36));
                        losSiteDetailData.setAMSL_PIC(cursor.getString(37));
                        losSiteDetailData.setBuildingsideviewphoto_PIC(cursor.getString(38));
                        losSiteDetailData.setAntennaTowerlocationphoto_PIC(cursor.getString(39));
                        losSiteDetailData.setPossibleobstacle_PIC(cursor.getString(40));
                        losSiteDetailData.setHeightofObstruction_PIC(cursor.getString(41));
                        losSiteDetailData.setPanaromicPhoto_PIC(cursor.getString(42));
                        losSiteDetailData.setExisitngNoofMWAntennatypewithsizeandPhotograph_PIC(cursor.getString(43));
                        losSiteDetailData.setExisitngMWAntennaheightandPolemountPhotograph_PIC(cursor.getString(44));

                        losSiteDetailData.setDate(cursor.getString(45));
                        losSiteDetailData.setFlag(cursor.getInt(46));


                        // Adding contact to list
                        list.add(losSiteDetailData);
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

    public void deleteSomeRow_LosSiteDetail() {
        SQLiteDatabase db = this.getWritableDatabase();
        //  db.execSQL("delete from "+ TABLE_SURVEYFORM+" where " +KEY_INCRI_ID+ " not in ( select " +KEY_INCRI_ID+" from "+ TABLE_SURVEYFORM+" order by "+KEY_DATE +" desc limit 100)");
        db.execSQL("DELETE FROM " + TABLE_LOSSITEDETAIL + " ;");
        db.close();
    }

    public int getCountLosSiteDetail() {
        String countQuery = "SELECT  * FROM " + TABLE_LOSSITEDETAIL;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        // return count
        return count;
    }

//...................END LOS SITEDETAIL...................................................
//...................START LOS TransmissionLink..............................................
public void insertLOSTransmissionLinkData(TransmissionLinkData transmissionLinkData) {
    SQLiteDatabase db = this.getWritableDatabase();
    try {
        ContentValues values = new ContentValues();
        values.put(tranLink_edt_SiteID, transmissionLinkData.getEdt_SiteID());
        values.put(tranLink_edt_Sitename,transmissionLinkData.getEdt_Sitename());
        values.put(tranLink_edt_Latitude,transmissionLinkData.getEdt_Latitude());
        values.put(tranLink_edt_Longitude,transmissionLinkData.getEdt_Longitude());
        values.put(tranLink_edt_Azimuthfromnearend,transmissionLinkData.getEdt_Azimuthfromnearend());
        values.put(tranLink_edt_Distance,transmissionLinkData.getEdt_Distance());
        values.put(tranLink_edt_AntennaHeightatFarend ,transmissionLinkData.getEdt_AntennaHeightatFarend());
        values.put(tranLink_edt_PoleFixtureRequirementatFarend ,transmissionLinkData.getEdt_PoleFixtureRequirementatFarend());
        values.put(tranLink_edt_IFLengthatFarend ,transmissionLinkData.getEdt_IFLengthatFarend());
        values.put(tranLink_edt_BuildingHeightatFarend,transmissionLinkData.getEdt_BuildingHeightatFarend());
        values.put(tranLink_edt_TotalhtForGBTRTTRTPATFarEnd ,transmissionLinkData.getEdt_TotalhtForGBTRTTRTPATFarEnd());
        values.put(tranLink_edt_AMSLatFarEnd ,transmissionLinkData.getEdt_AMSLatFarEnd());
        values.put(tranLink_img_SiteID, transmissionLinkData.getImg_SiteID());
        values.put(tranLink_img_Sitename,transmissionLinkData.getImg_Sitename());
        values.put(tranLink_img_Azimuthfromnearend,transmissionLinkData.getImg_Azimuthfromnearend());
        values.put(tranLink_img_Distance,transmissionLinkData.getImg_Distance());
        values.put(tranLink_img_AntennaHeightatFarend ,transmissionLinkData.getImg_AntennaHeightatFarend());
        values.put(tranLink_img_PoleFixtureRequirementatFarend ,transmissionLinkData.getImg_PoleFixtureRequirementatFarend());
        values.put(tranLink_img_IFLengthatFarend ,transmissionLinkData.getImg_IFLengthatFarend());
        values.put(tranLink_img_BuildingHeightatFarend,transmissionLinkData.getImg_BuildingHeightatFarend());
        values.put(tranLink_img_TotalhtForGBTRTTRTPATFarEnd ,transmissionLinkData.getImg_TotalhtForGBTRTTRTPATFarEnd());
        values.put(tranLink_img_AMSLatFarEnd ,transmissionLinkData.getImg_AMSLatFarEnd());
        values.put(tranLink_name,transmissionLinkData.getTransmissionLink_name());
        values.put(tranLink_date,transmissionLinkData.getDate());
        values.put(tranLink_flag ,transmissionLinkData.getFlag());

        // Inserting Row
        db.insert(TABLE_LOSSTRANSMISSIONLINK, null, values);
    } catch (Exception ignor) {
        Log.v(TAG, "Databaser insert TransmissionLink table error");
    }
    Log.v(TAG, "Databaser insert TransmissionLink table");
    //2nd argument is String containing nullColumnHack
    db.close(); // Closing database connection
}


    public List<TransmissionLinkData> getLastTransmissionLink(String formno) {
        ArrayList<TransmissionLinkData> list = new ArrayList<TransmissionLinkData>();
        // Select All Query
        // SELECT * FROM members ORDER BY date_of_birth DESC;
        //String selectQuery = "SELECT  * FROM " + TABLE_LATLONG +" ORDER BY "+KEY_LATLONG_INCRIID+" DESC LIMIT 1;";
        String selectQuery = "SELECT  * FROM " + TABLE_LOSSTRANSMISSIONLINK + " WHERE " + tranLink_name + " = ?" + " ORDER BY " +tranLink_ID + " DESC LIMIT 1";
        SQLiteDatabase db = this.getReadableDatabase();
        try {

            Cursor cursor = db.rawQuery(selectQuery, new String[]{formno});
            try {
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        TransmissionLinkData transmissionLinkData = new TransmissionLinkData();
                        transmissionLinkData.setId(cursor.getInt(0));
                        transmissionLinkData.setEdt_SiteID(cursor.getString(1));
                        transmissionLinkData.setEdt_Sitename(cursor.getString(2));
                        transmissionLinkData.setEdt_Latitude(cursor.getString(3));
                        transmissionLinkData.setEdt_Longitude(cursor.getString(4));
                        transmissionLinkData.setEdt_Azimuthfromnearend(cursor.getString(5));
                        transmissionLinkData.setEdt_Distance(cursor.getString(6));
                        transmissionLinkData.setEdt_AntennaHeightatFarend(cursor.getString(7));
                        transmissionLinkData.setEdt_PoleFixtureRequirementatFarend(cursor.getString(8));
                        transmissionLinkData.setEdt_IFLengthatFarend(cursor.getString(9));
                        transmissionLinkData.setEdt_BuildingHeightatFarend(cursor.getString(10));
                        transmissionLinkData.setEdt_TotalhtForGBTRTTRTPATFarEnd(cursor.getString(11));
                        transmissionLinkData.setEdt_AMSLatFarEnd(cursor.getString(12));
                        transmissionLinkData.setImg_SiteID(cursor.getString(13));
                        transmissionLinkData.setImg_Sitename(cursor.getString(14));
                        transmissionLinkData.setImg_Azimuthfromnearend(cursor.getString(15));
                        transmissionLinkData.setImg_Distance(cursor.getString(16));
                        transmissionLinkData.setImg_AntennaHeightatFarend(cursor.getString(17));
                        transmissionLinkData.setImg_PoleFixtureRequirementatFarend(cursor.getString(18));
                        transmissionLinkData.setImg_IFLengthatFarend(cursor.getString(19));
                        transmissionLinkData.setImg_BuildingHeightatFarend(cursor.getString(20));
                        transmissionLinkData.setImg_TotalhtForGBTRTTRTPATFarEnd(cursor.getString(21));
                        transmissionLinkData.setImg_AMSLatFarEnd(cursor.getString(22));
                        transmissionLinkData.setTransmissionLink_name(cursor.getString(23));
                        transmissionLinkData.setDate(cursor.getString(24));
                        transmissionLinkData.setFlag(cursor.getInt(25));

                        // Adding contact to list
                        list.add(transmissionLinkData);
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

    public void deleteSomeRow_LOSTransmissionLink() {
        SQLiteDatabase db = this.getWritableDatabase();
        //  db.execSQL("delete from "+ TABLE_SURVEYFORM+" where " +KEY_INCRI_ID+ " not in ( select " +KEY_INCRI_ID+" from "+ TABLE_SURVEYFORM+" order by "+KEY_DATE +" desc limit 100)");
        db.execSQL("DELETE FROM " + TABLE_LOSSTRANSMISSIONLINK + " ;");
        db.close();
    }

    public int getCountLOSTransmissionLink() {
        String countQuery = "SELECT  * FROM " + TABLE_LOSSTRANSMISSIONLINK;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        // return count
        return count;
    }
    //...................START LOS Transmission  NO Link..............................................
    public void insertLOSTransmissionNOLinkData(TransmissionNoLinkData transmissionnoLinkData) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put(transnoLink_edt_SiteID, transmissionnoLinkData.getEdt_SiteID());
            values.put(transnoLink_edt_Sitename,transmissionnoLinkData.getEdt_Sitename());
            values.put(transnoLink_edt_ObstructionDetails,transmissionnoLinkData.getEdt_ObstructionDetails());
            values.put(transnoLink_edt_Azimuth,transmissionnoLinkData.getEdt_Azimuth());
            values.put(transnoLink_edt_Distance,transmissionnoLinkData.getEdt_Distance());
            values.put(transnoLink_edt_AntennaHeight,transmissionnoLinkData.getEdt_AntennaHeight());
            values.put(transnoLink_edt_Altitude ,transmissionnoLinkData.getEdt_Altitude());
            values.put(transnoLink_img_SiteID, transmissionnoLinkData.getImg_SiteID());
            values.put(transnoLink_img_Sitename,transmissionnoLinkData.getImg_Sitename());
            values.put(transnoLink_img_ObstructionDetails,transmissionnoLinkData.getImg_ObstructionDetails());
            values.put(transnoLink_img_Azimuth,transmissionnoLinkData.getImg_Azimuth());
            values.put(transnoLink_img_Distance,transmissionnoLinkData.getImg_Distance());
            values.put(transnoLink_img_AntennaHeight,transmissionnoLinkData.getImg_AntennaHeight());
            values.put(transnoLink_img_Altitude ,transmissionnoLinkData.getImg_Altitude());
            values.put(transNoLink_name ,transmissionnoLinkData.getTransmissionNoLink_name());

            values.put(tranLink_date,transmissionnoLinkData.getDate());
            values.put(tranLink_flag ,transmissionnoLinkData.getFlag());

            // Inserting Row
            db.insert(TABLE_LOSSTRANSMISSIONNOLINK, null, values);
        } catch (Exception ignor) {
            Log.v(TAG, "Databaser insert TransmissionnoLink table error");
        }
        Log.v(TAG, "Databaser insert TransmissionnoLink table");
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }


    public List<TransmissionNoLinkData> getLastTransmissionNOLink(String formno) {
        ArrayList<TransmissionNoLinkData> list = new ArrayList<TransmissionNoLinkData>();
        // Select All Query
        // SELECT * FROM members ORDER BY date_of_birth DESC;
        //String selectQuery = "SELECT  * FROM " + TABLE_LATLONG +" ORDER BY "+KEY_LATLONG_INCRIID+" DESC LIMIT 1;";
        String selectQuery = "SELECT  * FROM " + TABLE_LOSSTRANSMISSIONNOLINK + " WHERE " + transNoLink_name + " = ?" + " ORDER BY " +transnoLink_id + " DESC LIMIT 1";
        SQLiteDatabase db = this.getReadableDatabase();
        try {

            Cursor cursor = db.rawQuery(selectQuery, new String[]{formno});
            try {
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        TransmissionNoLinkData transmissionnoLinkData = new TransmissionNoLinkData();
                        transmissionnoLinkData.setId(cursor.getInt(0));
                        transmissionnoLinkData.setEdt_SiteID(cursor.getString(1));
                        transmissionnoLinkData.setEdt_Sitename(cursor.getString(2));
                        transmissionnoLinkData.setEdt_ObstructionDetails(cursor.getString(3));
                        transmissionnoLinkData.setEdt_Azimuth(cursor.getString(4));
                        transmissionnoLinkData.setEdt_Distance(cursor.getString(5));
                        transmissionnoLinkData.setEdt_AntennaHeight(cursor.getString(6));
                        transmissionnoLinkData.setEdt_Altitude(cursor.getString(7));
                        transmissionnoLinkData.setImg_SiteID(cursor.getString(8));
                        transmissionnoLinkData.setImg_Sitename(cursor.getString(9));
                        transmissionnoLinkData.setImg_ObstructionDetails(cursor.getString(10));
                        transmissionnoLinkData.setImg_Azimuth(cursor.getString(11));
                        transmissionnoLinkData.setImg_Distance(cursor.getString(12));
                        transmissionnoLinkData.setImg_AntennaHeight(cursor.getString(13));
                        transmissionnoLinkData.setImg_Altitude(cursor.getString(14));
                        transmissionnoLinkData.setTransmissionNoLink_name(cursor.getString(15));

                        transmissionnoLinkData.setDate(cursor.getString(16));
                        transmissionnoLinkData.setFlag(cursor.getInt(17));


                        // Adding contact to list
                        list.add(transmissionnoLinkData);
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

    public void deleteSomeRow_LOSTransmissionNOLink() {
        SQLiteDatabase db = this.getWritableDatabase();
        //  db.execSQL("delete from "+ TABLE_SURVEYFORM+" where " +KEY_INCRI_ID+ " not in ( select " +KEY_INCRI_ID+" from "+ TABLE_SURVEYFORM+" order by "+KEY_DATE +" desc limit 100)");
        db.execSQL("DELETE FROM " + TABLE_LOSSTRANSMISSIONNOLINK + " ;");
        db.close();
    }

    public int getCountLOSTransmissionNOLink() {
        String countQuery = "SELECT  * FROM " + TABLE_LOSSTRANSMISSIONNOLINK;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        // return count
        return count;
    }

    // code to add the new LOS Photos
    public void insertLosPhotos(LosPhotoData losPhotoData) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put(los_P_NearEndFarEndphoto1 ,losPhotoData.getNearEndFarEndphoto1());
            values.put(los_P_FarEndtoNearEndphoto1 ,losPhotoData.getFarEndtoNearEndphoto1());
            values.put(los_P_TowerPhoto1 ,losPhotoData.getTowerPhoto1());
            values.put(los_P_NearEndtoFarEndphoto2 ,losPhotoData.getNearEndtoFarEndphoto2());
            values.put(los_P_FarEndNearEndphoto2 ,losPhotoData.getFarEndNearEndphoto2());
            values.put(los_P_TowerPhoto2 ,losPhotoData.getTowerPhoto2());
            values.put(los_P_NearEndFarEndphoto3 ,losPhotoData.getNearEndFarEndphoto3());
            values.put(los_P_FarEndtoNearEndphoto3 ,losPhotoData.getFarEndtoNearEndphoto3());
            values.put(los_P_TowerPhoto3 ,losPhotoData.getTowerPhoto3());
            values.put(los_P_NearEndtoFarEndphoto4 ,losPhotoData.getNearEndtoFarEndphoto4());
            values.put(los_P_FarEndtoNearEndphoto4 ,losPhotoData.getFarEndtoNearEndphoto4());
            values.put(los_P_TowerPhoto4 ,losPhotoData.getTowerPhoto4());
            values.put(los_P_date,losPhotoData.getDate());
            values.put(los_P_flag ,losPhotoData.getFlag());


            // Inserting Row
            db.insert(TABLE_LOSPHOTOS, null, values);
        } catch (Exception ignor) {
            Log.v(TAG, "Databaser insert losphotos error");
        }
        Log.v(TAG, "Databaser insert losphotos table");
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    public List<LosPhotoData> getLastLosPhotos() {
        ArrayList<LosPhotoData> list = new ArrayList<LosPhotoData>();
        // Select All Query
        // SELECT * FROM members ORDER BY date_of_birth DESC;
        //String selectQuery = "SELECT  * FROM " + TABLE_LATLONG +" ORDER BY "+KEY_LATLONG_INCRIID+" DESC LIMIT 1;";

        String selectQuery = "SELECT  * FROM " + TABLE_LOSPHOTOS + " ORDER BY " + los_P_id + " DESC LIMIT 1";

        SQLiteDatabase db = this.getReadableDatabase();
        try {

            Cursor cursor = db.rawQuery(selectQuery, null);
            try {
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        LosPhotoData losPhotoData = new LosPhotoData();
                        losPhotoData.setId(cursor.getInt(0));
                        losPhotoData.setNearEndFarEndphoto1(cursor.getString(1));
                        losPhotoData.setFarEndtoNearEndphoto1(cursor.getString(2));
                        losPhotoData.setTowerPhoto1(cursor.getString(3));
                        losPhotoData.setNearEndtoFarEndphoto2(cursor.getString(4));
                        losPhotoData.setFarEndNearEndphoto2(cursor.getString(5));
                        losPhotoData.setTowerPhoto2(cursor.getString(6));
                        losPhotoData.setNearEndFarEndphoto3(cursor.getString(7));
                        losPhotoData.setFarEndtoNearEndphoto3(cursor.getString(8));
                        losPhotoData.setTowerPhoto3(cursor.getString(9));
                        losPhotoData.setNearEndtoFarEndphoto4(cursor.getString(10));
                        losPhotoData.setFarEndtoNearEndphoto4(cursor.getString(11));
                        losPhotoData.setTowerPhoto4(cursor.getString(12));
                        losPhotoData.setDate(cursor.getString(13));
                        losPhotoData.setFlag(cursor.getInt(14));


                        // Adding contact to list
                        list.add(losPhotoData);
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

    public void deleteSomeRow_LosPhotos() {
        SQLiteDatabase db = this.getWritableDatabase();
        //  db.execSQL("delete from "+ TABLE_SURVEYFORM+" where " +KEY_INCRI_ID+ " not in ( select " +KEY_INCRI_ID+" from "+ TABLE_SURVEYFORM+" order by "+KEY_DATE +" desc limit 100)");
        db.execSQL("DELETE FROM " + TABLE_LOSPHOTOS + " ;");
        db.close();
    }

    public int getCountLosPhotos() {
        String countQuery = "SELECT  * FROM " + TABLE_LOSPHOTOS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        // return count
        return count;
    }

    // code to add the new RF SiteDetail
    public void insertRFSiteDetail(RFSiteDetailData rfSiteDetailData) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues values = new ContentValues();

            values.put(edt_rf_SiteID ,rfSiteDetailData.getEdt_SiteID());
            values.put(edt_rf_SiteName ,rfSiteDetailData.getEdt_SiteName());
            values.put(edt_rf_SurveyDate ,rfSiteDetailData.getEdt_SurveyDate());
            values.put(edt_rf_City ,rfSiteDetailData.getEdt_City());
            values.put(edt_rf_IMID ,rfSiteDetailData.getEdt_IMID());
            values.put(edt_rf_Cluttertype ,rfSiteDetailData.getEdt_Cluttertype());
            values.put(edt_rf_SiteType ,rfSiteDetailData.getEdt_SiteType());
            values.put(edt_rf_Zone ,rfSiteDetailData.getEdt_Zone());
            values.put(edt_rf_SiteCandidate ,rfSiteDetailData.getEdt_SiteCandidate());
            values.put(edt_rf_BldgHeight ,rfSiteDetailData.getEdt_BldgHeight());
            values.put(edt_rf_BldgStructure ,rfSiteDetailData.getEdt_BldgStructure());
            values.put(edt_rf_AGL ,rfSiteDetailData.getEdt_AGL());
            values.put(edt_rf_SiteContact ,rfSiteDetailData.getEdt_SiteContact());
            values.put(edt_rf_AMSL ,rfSiteDetailData.getEdt_AMSL());
            values.put(edt_rf_SiteAddress ,rfSiteDetailData.getEdt_SiteAddress());
            values.put(edt_rf_SiteIndoor ,rfSiteDetailData.getEdt_SiteIndoor());
            values.put(edt_rf_SiteOutdoor ,rfSiteDetailData.getEdt_SiteOutdoor());
            values.put(edt_rf_ShelterConcrete ,rfSiteDetailData.getEdt_ShelterConcrete());
            values.put(edt_rf_shelterFabricated ,rfSiteDetailData.getEdt_shelterFabricated());
            values.put(edt_rf_Numerofotheroperator ,rfSiteDetailData.getEdt_Numerofotheroperator());
            values.put(edt_rf_IPSite ,rfSiteDetailData.getEdt_IPSite());
            values.put(edt_rf_Others ,rfSiteDetailData.getEdt_Others());
            values.put(edt_rf_Sharing ,rfSiteDetailData.getEdt_Sharing());
            values.put(edt_rf_Hostoperator ,rfSiteDetailData.getEdt_Hostoperator());
            values.put(edt_rf_Anyguestoperators ,rfSiteDetailData.getEdt_Anyguestoperators());
            values.put(edt_rf_NoofGSMAntenna ,rfSiteDetailData.getEdt_NoofGSMAntenna());
            values.put(edt_rf_Lat ,rfSiteDetailData.getEdt_Lat());
            values.put(edt_rf_Long ,rfSiteDetailData.getEdt_Long());
            values.put(img_rf_SiteID ,rfSiteDetailData.getImg_SiteID());
            values.put(img_rf_SiteName ,rfSiteDetailData.getImg_SiteName());
            values.put(img_rf_SurveyDate ,rfSiteDetailData.getImg_SurveyDate());
            values.put(img_rf_City ,rfSiteDetailData.getImg_City());
            values.put(img_rf_IMID ,rfSiteDetailData.getImg_IMID());
            values.put(img_rf_Cluttertype ,rfSiteDetailData.getImg_Cluttertype());
            values.put(img_rf_SiteType ,rfSiteDetailData.getImg_SiteType());
            values.put(img_rf_Zone ,rfSiteDetailData.getImg_Zone());
            values.put(img_rf_SiteCandidate ,rfSiteDetailData.getImg_SiteCandidate());
            values.put(img_rf_BldgHeight ,rfSiteDetailData.getImg_BldgHeight());
            values.put(img_rf_BldgStructure ,rfSiteDetailData.getImg_BldgStructure());
            values.put(img_rf_AGL ,rfSiteDetailData.getImg_AGL());
            values.put(img_rf_SiteContact ,rfSiteDetailData.getImg_SiteContact());
            values.put(img_rf_AMSL ,rfSiteDetailData.getImg_AMSL());
            values.put(img_rf_SiteAddress ,rfSiteDetailData.getImg_SiteAddress());
            values.put(img_rf_SiteIndoor ,rfSiteDetailData.getImg_SiteIndoor());
            values.put(img_rf_SiteOutdoor ,rfSiteDetailData.getImg_SiteOutdoor());
            values.put(img_rf_ShelterConcrete ,rfSiteDetailData.getImg_ShelterConcrete());
            values.put(img_rf_shelterFabricated ,rfSiteDetailData.getImg_shelterFabricated());
            values.put(img_rf_Numerofotheroperator ,rfSiteDetailData.getImg_Numerofotheroperator());
            values.put(img_rf_IPSite ,rfSiteDetailData.getImg_IPSite());
            values.put(img_rf_Others ,rfSiteDetailData.getImg_Others());
            values.put(img_rf_Sharing ,rfSiteDetailData.getImg_Sharing());
            values.put(img_rf_Hostoperator ,rfSiteDetailData.getImg_Hostoperator());
            values.put(img_rf_Anyguestoperators ,rfSiteDetailData.getImg_Anyguestoperators());
            values.put(img_rf_NoofGSMAntenna ,rfSiteDetailData.getImg_NoofGSMAntenna());
            values.put(rf_date ,rfSiteDetailData.getDate());
            values.put(rf_flag ,rfSiteDetailData.getFlag());

            // Inserting Row
            db.insert(TABLE_RFSITEDETAIL, null, values);
        } catch (Exception ignor) {
            Log.v(TAG, "Databaser insert RFSiteDetail error");
        }
        Log.v(TAG, "Databaser insert RFSiteDetail table");
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    public List<RFSiteDetailData> getLastRFSiteDetail() {
        ArrayList<RFSiteDetailData> list = new ArrayList<RFSiteDetailData>();
        // Select All Query
        // SELECT * FROM members ORDER BY date_of_birth DESC;
        //String selectQuery = "SELECT  * FROM " + TABLE_LATLONG +" ORDER BY "+KEY_LATLONG_INCRIID+" DESC LIMIT 1;";

        String selectQuery = "SELECT  * FROM " + TABLE_RFSITEDETAIL + " ORDER BY " + rfid + " DESC LIMIT 1";

        SQLiteDatabase db = this.getReadableDatabase();
        try {

            Cursor cursor = db.rawQuery(selectQuery, null);
            try {
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        RFSiteDetailData rfSiteDetailData = new RFSiteDetailData();
                        rfSiteDetailData.setId(cursor.getInt(0));
                        rfSiteDetailData.setEdt_SiteID(cursor.getString(1));
                        rfSiteDetailData.setEdt_SiteName(cursor.getString(2));
                        rfSiteDetailData.setEdt_SurveyDate(cursor.getString(3));
                        rfSiteDetailData.setEdt_City(cursor.getString(4));
                        rfSiteDetailData.setEdt_IMID(cursor.getString(5));
                        rfSiteDetailData.setEdt_Cluttertype(cursor.getString(6));
                        rfSiteDetailData.setEdt_SiteType(cursor.getString(7));
                        rfSiteDetailData.setEdt_Zone(cursor.getString(8));
                        rfSiteDetailData.setEdt_SiteCandidate(cursor.getString(9));
                        rfSiteDetailData.setEdt_BldgHeight(cursor.getString(10));
                        rfSiteDetailData.setEdt_BldgStructure(cursor.getString(11));
                        rfSiteDetailData.setEdt_AGL(cursor.getString(12));
                        rfSiteDetailData.setEdt_SiteContact(cursor.getString(13));
                        rfSiteDetailData.setEdt_AMSL(cursor.getString(14));
                        rfSiteDetailData.setEdt_SiteAddress(cursor.getString(15));
                        rfSiteDetailData.setEdt_SiteIndoor(cursor.getString(16));
                        rfSiteDetailData.setEdt_SiteOutdoor(cursor.getString(17));
                        rfSiteDetailData.setEdt_ShelterConcrete(cursor.getString(18));
                        rfSiteDetailData.setEdt_shelterFabricated(cursor.getString(19));
                        rfSiteDetailData.setEdt_Numerofotheroperator(cursor.getString(20));
                        rfSiteDetailData.setEdt_IPSite(cursor.getString(21));
                        rfSiteDetailData.setEdt_Others(cursor.getString(22));
                        rfSiteDetailData.setEdt_Sharing(cursor.getString(23));
                        rfSiteDetailData.setEdt_Hostoperator(cursor.getString(24));
                        rfSiteDetailData.setEdt_Anyguestoperators(cursor.getString(25));
                        rfSiteDetailData.setEdt_NoofGSMAntenna(cursor.getString(26));
                        rfSiteDetailData.setEdt_Lat(cursor.getString(27));
                        rfSiteDetailData.setEdt_Long(cursor.getString(28));
                        rfSiteDetailData.setImg_SiteID(cursor.getString(29));
                        rfSiteDetailData.setImg_SiteName(cursor.getString(30));
                        rfSiteDetailData.setImg_SurveyDate(cursor.getString(31));
                        rfSiteDetailData.setImg_City(cursor.getString(32));
                        rfSiteDetailData.setImg_IMID(cursor.getString(33));
                        rfSiteDetailData.setImg_Cluttertype(cursor.getString(34));
                        rfSiteDetailData.setImg_SiteType(cursor.getString(35));
                        rfSiteDetailData.setImg_Zone(cursor.getString(36));
                        rfSiteDetailData.setImg_SiteCandidate(cursor.getString(37));
                        rfSiteDetailData.setImg_BldgHeight(cursor.getString(38));
                        rfSiteDetailData.setImg_BldgStructure(cursor.getString(39));
                        rfSiteDetailData.setImg_AGL(cursor.getString(40));
                        rfSiteDetailData.setImg_SiteContact(cursor.getString(41));
                        rfSiteDetailData.setImg_AMSL(cursor.getString(42));
                        rfSiteDetailData.setImg_SiteAddress(cursor.getString(43));
                        rfSiteDetailData.setImg_SiteIndoor(cursor.getString(44));
                        rfSiteDetailData.setImg_SiteOutdoor(cursor.getString(45));
                        rfSiteDetailData.setImg_ShelterConcrete(cursor.getString(46));
                        rfSiteDetailData.setImg_shelterFabricated(cursor.getString(47));
                        rfSiteDetailData.setImg_Numerofotheroperator(cursor.getString(48));
                        rfSiteDetailData.setImg_IPSite(cursor.getString(49));
                        rfSiteDetailData.setImg_Others(cursor.getString(50));
                        rfSiteDetailData.setImg_Sharing(cursor.getString(51));
                        rfSiteDetailData.setImg_Hostoperator(cursor.getString(52));
                        rfSiteDetailData.setImg_Anyguestoperators(cursor.getString(53));
                        rfSiteDetailData.setImg_NoofGSMAntenna(cursor.getString(54));
                        rfSiteDetailData.setDate(cursor.getString(55));
                        rfSiteDetailData.setFlag(cursor.getInt(56));




                        // Adding contact to list
                        list.add(rfSiteDetailData);
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

    public void deleteSomeRow_RFSiteDetail() {
        SQLiteDatabase db = this.getWritableDatabase();
        //  db.execSQL("delete from "+ TABLE_SURVEYFORM+" where " +KEY_INCRI_ID+ " not in ( select " +KEY_INCRI_ID+" from "+ TABLE_SURVEYFORM+" order by "+KEY_DATE +" desc limit 100)");
        db.execSQL("DELETE FROM " + TABLE_RFSITEDETAIL + " ;");
        db.close();
    }

    public int getCountRFSiteDetail() {
        String countQuery = "SELECT  * FROM " + TABLE_RFSITEDETAIL;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        // return count
        return count;
    }

    //...................START RF SectorDetail.............................................
    public void insertRFSectorDetail(RFSectorAntennaDetailData rfSectorAntennaDetailData) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues values = new ContentValues();

            values.put(rfs_edt_Antenna_Type, rfSectorAntennaDetailData.getEdt_Antenna_Type());
            values.put(rfs_edt_2GBand , rfSectorAntennaDetailData.getEdt_2GBand());
            values.put(rfs_edt_2GCoverge, rfSectorAntennaDetailData.getEdt_2GCoverge());
            values.put(rfs_edt_2GObstruction , rfSectorAntennaDetailData.getEdt_2GObstruction());
            values.put(rfs_edt_2G_Existing_Antenna_Height, rfSectorAntennaDetailData.getEdt_2G_Existing_Antenna_Height());
            values.put(rfs_edt_2G_Antenna_Make_and_Model, rfSectorAntennaDetailData.getEdt_2G_Antenna_Makeedt_and_Model());
            values.put(rfs_edt_2G_Existing_Antenna_Direction , rfSectorAntennaDetailData.getEdt_2G_Existing_Antenna_Direction());
            values.put(rfs_edt_2G_Existing_antenna_tilt_Electrical , rfSectorAntennaDetailData.getEdt_2G_Existing_antenna_tilt_Electrical());
            values.put(rfs_edt_2G_Existing_antenna_tilt_Mechanical , rfSectorAntennaDetailData.getEdt_2G_Existing_antenna_tilt_Mechanical());
            values.put(rfs_edt_3GBand , rfSectorAntennaDetailData.getEdt_3GBand());
            values.put(rfs_edt_3GCoverge , rfSectorAntennaDetailData.getEdt_3GCoverge());
            values.put(rfs_edt_3GObstruction  , rfSectorAntennaDetailData.getEdt_3GObstruction());
            values.put(rfs_edt_3G_Existing_Antenna_Ht , rfSectorAntennaDetailData.getEdt_3G_Existing_Antenna_Ht());
            values.put(rfs_edt_3G_Antenna_Make_and_Model , rfSectorAntennaDetailData.getEdt_3G_Antenna_Make_and_Model());
            values.put(rfs_edt_3G_Existing_Antenna_Direction , rfSectorAntennaDetailData.getEdt_3G_Existing_Antenna_Direction());
            values.put(rfs_edt_3G_Existing_antenna_Electrical_tilt , rfSectorAntennaDetailData.getEdt_3G_Existing_antenna_Electrical_tilt());
            values.put(rfs_edt_3G_Existing_antenna_Mechanical_tilt , rfSectorAntennaDetailData.getEdt_3G_Existing_antenna_Mechanical_tilt());
            values.put(rfs_edt_Space_Available_for_3G_Antenna , rfSectorAntennaDetailData.getEdt_Space_Available_for_3G_Antenna());
            values.put(rfs_edt_Addl_Poles_req_for_3G_Antenna , rfSectorAntennaDetailData.getEdt_Addl_Poles_req_for_3G_Antenna());
            values.put(rfs_edt_3GAntenna_Swap_Required , rfSectorAntennaDetailData.getEdt_3GAntenna_Swap_Required());
            values.put(rfs_edt_3GApproximate_Cable_Lenth , rfSectorAntennaDetailData.getEdt_3GApproximate_Cable_Lenth());
            values.put(rfs_edt_3GAntenna_Port_EmptyDamaged , rfSectorAntennaDetailData.getEdt_3GAntenna_Port_EmptyDamaged());
            values.put(rfs_edt_4GBand , rfSectorAntennaDetailData.getEdt_4GBand());
            values.put(rfs_edt_4GCoverge , rfSectorAntennaDetailData.getEdt_4GCoverge());
            values.put(rfs_edt_4GObstruction , rfSectorAntennaDetailData.getEdt_4GObstruction());
            values.put(rfs_edt_4G_Existing_Antenna_Ht , rfSectorAntennaDetailData.getEdt_4G_Existing_Antenna_Ht());
            values.put(rfs_edt_4G_Antenna_Make_and_Model , rfSectorAntennaDetailData.getEdt_4G_Antenna_Make_and_Model());
            values.put(rfs_edt_4G_Existing_Antenna_Direction , rfSectorAntennaDetailData.getEdt_4G_Existing_Antenna_Direction());
            values.put(rfs_edt_4G_Existing_antenna_Electrical_tilt , rfSectorAntennaDetailData.getEdt_4G_Existing_antenna_Electrical_tilt());
            values.put(rfs_edt_4G_Existing_antenna_Mechanical_tilt , rfSectorAntennaDetailData.getEdt_4G_Existing_antenna_Mechanical_tilt());
            values.put(rfs_edt_Space_Available_for_4G_Antenna , rfSectorAntennaDetailData.getEdt_Space_Available_for_4G_Antenna());
            values.put(rfs_edt_Addl_Poles_reqd_for_4G_Antenna , rfSectorAntennaDetailData.getEdt_Addl_Poles_reqd_for_4G_Antenna());
            values.put(rfs_edt_4GAntenna_Swap_Required , rfSectorAntennaDetailData.getEdt_4GAntenna_Swap_Required());
            values.put(rfs_edt_4GApproximate_Cable_Lenth , rfSectorAntennaDetailData.getEdt_4GApproximate_Cable_Lenth());
            values.put(rfs_edt_4GAntennarfs_edt_Port_EmptyDamaged , rfSectorAntennaDetailData.getEdt_4GAntennaedt_Port_EmptyDamaged());

            values.put(rfs_img_Antenna_Type, rfSectorAntennaDetailData.getImg_Antenna_Type());
            values.put(rfs_img_2GBand , rfSectorAntennaDetailData.getImg_2GBand());
            values.put(rfs_img_2GCoverge, rfSectorAntennaDetailData.getImg_2GCoverge());
            values.put(rfs_img_2GObstruction , rfSectorAntennaDetailData.getImg_2GObstruction());
            values.put(rfs_img_2G_Existing_Antenna_Height, rfSectorAntennaDetailData.getImg_2G_Existing_Antenna_Height());
            values.put(rfs_img_2G_Antenna_Make_and_Model, rfSectorAntennaDetailData.getImg_2G_Antenna_Make_and_Model());
            values.put(rfs_img_2G_Existing_Antenna_Direction , rfSectorAntennaDetailData.getImg_2G_Existing_Antenna_Direction());
            values.put(rfs_img_2G_Existing_antenna_tilt_Electrical , rfSectorAntennaDetailData.getImg_2G_Existing_antenna_tilt_Electrical());
            values.put(rfs_img_2G_Existing_antenna_tilt_Mechanical , rfSectorAntennaDetailData.getImg_2G_Existing_antenna_tilt_Mechanical());
            values.put(rfs_img_3GBand , rfSectorAntennaDetailData.getImg_3GBand());
            values.put(rfs_img_3GCoverge , rfSectorAntennaDetailData.getImg_3GCoverge());
            values.put(rfs_img_3GObstruction  , rfSectorAntennaDetailData.getImg_3GObstruction());
            values.put(rfs_img_3G_Existing_Antenna_Ht , rfSectorAntennaDetailData.getImg_3G_Existing_Antenna_Ht());
            values.put(rfs_img_3G_Antenna_Make_and_Model , rfSectorAntennaDetailData.getImg_3G_Antenna_Make_and_Model());
            values.put(rfs_img_3G_Existing_Antenna_Direction , rfSectorAntennaDetailData.getImg_3G_Existing_Antenna_Direction());
            values.put(rfs_img_3G_Existing_antenna_Electrical_tilt , rfSectorAntennaDetailData.getImg_3G_Existing_antenna_Electrical_tilt());
            values.put(rfs_img_3G_Existing_antenna_Mechanical_tilt , rfSectorAntennaDetailData.getImg_3G_Existing_antenna_Mechanical_tilt());
            values.put(rfs_img_Space_Available_for_3G_Antenna , rfSectorAntennaDetailData.getImg_Space_Available_for_3G_Antenna());
            values.put(rfs_img_Addl_Poles_reqd_for_3G_Antenna , rfSectorAntennaDetailData.getImg_Addl_Poles_reqd_for_3G_Antenna());
            values.put(rfs_img_3GAntenna_Swap_Required , rfSectorAntennaDetailData.getImg_3GAntenna_Swap_Required());
            values.put(rfs_img_3GApproximate_Cable_Lenth , rfSectorAntennaDetailData.getImg_3GApproximate_Cable_Lenth());
            values.put(rfs_img_3GAntenna_Port_EmptyDamaged , rfSectorAntennaDetailData.getImg_3GAntenna_Port_EmptyDamaged());
            values.put(rfs_img_4GBand , rfSectorAntennaDetailData.getImg_4GBand());
            values.put(rfs_img_4GCoverge , rfSectorAntennaDetailData.getImg_4GCoverge());
            values.put(rfs_img_4GObstruction , rfSectorAntennaDetailData.getImg_4GObstruction());
            values.put(rfs_img_4G_Existing_Antenna_Ht , rfSectorAntennaDetailData.getImg_4G_Existing_Antenna_Ht());
            values.put(rfs_img_4G_Antenna_Make_and_Model , rfSectorAntennaDetailData.getImg_4G_Antenna_Make_and_Model());
            values.put(rfs_img_4G_Existing_Antenna_Direction , rfSectorAntennaDetailData.getImg_4G_Existing_Antenna_Direction());
            values.put(rfs_img_4G_Existing_antenna_Electrical_tilt , rfSectorAntennaDetailData.getImg_4G_Existing_antenna_Electrical_tilt());
            values.put(rfs_img_4G_Existing_antenna_Mechanical_tilt , rfSectorAntennaDetailData.getImg_4G_Existing_antenna_Mechanical_tilt());
            values.put(rfs_img_Space_Available_for_4G_Antenna , rfSectorAntennaDetailData.getImg_Space_Available_for_4G_Antenna());
            values.put(rfs_img_Addl_Poles_reqd_for_4G_Antenna , rfSectorAntennaDetailData.getImg_Addl_Poles_reqd_for_4G_Antenna());
            values.put(rfs_img_4GAntenna_Swap_Required , rfSectorAntennaDetailData.getImg_4GAntenna_Swap_Required());
            values.put(rfs_img_4GApproximate_Cable_Lenth , rfSectorAntennaDetailData.getImg_4GApproximate_Cable_Lenth());
            values.put(rfs_img_4GAntenna_Port_EmptyDamaged , rfSectorAntennaDetailData.getImg_4GAntenna_Port_EmptyDamaged());

            values.put(rf_sectorDetail_name,rfSectorAntennaDetailData.getRf_sectorDetail_name());
            values.put(rfs_date,rfSectorAntennaDetailData.getDate());
            values.put(rfs_flag ,rfSectorAntennaDetailData.getFlag());

            // Inserting Row
            db.insert(TABLE_RFSECTORDETAIL, null, values);
        } catch (Exception ignor) {
            Log.v(TAG, "Databaser insert TABLE_RFSECTORDETAIL error");
        }
        Log.v(TAG, "Databaser insert TABLE_RFSECTORDETAIL table");
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }


    public List<RFSectorAntennaDetailData> getLast_RFSECTORDETAIL(String formno) {
        ArrayList<RFSectorAntennaDetailData> list = new ArrayList<RFSectorAntennaDetailData>();
        // Select All Query
        // SELECT * FROM members ORDER BY date_of_birth DESC;
        //String selectQuery = "SELECT  * FROM " + TABLE_LATLONG +" ORDER BY "+KEY_LATLONG_INCRIID+" DESC LIMIT 1;";
        String selectQuery = "SELECT  * FROM " + TABLE_RFSECTORDETAIL + " WHERE " + rf_sectorDetail_name + " = ?" + " ORDER BY " +rfs_id + " DESC LIMIT 1";
        SQLiteDatabase db = this.getReadableDatabase();
        try {

            Cursor cursor = db.rawQuery(selectQuery, new String[]{formno});
            try {
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        RFSectorAntennaDetailData rfSectorAntennaDetailData = new RFSectorAntennaDetailData();
                        rfSectorAntennaDetailData.setId(cursor.getInt(0));
                        rfSectorAntennaDetailData.setEdt_Antenna_Type(cursor.getString(1));
                        rfSectorAntennaDetailData.setEdt_2GBand(cursor.getString(2));
                        rfSectorAntennaDetailData.setEdt_2GCoverge(cursor.getString(3));
                        rfSectorAntennaDetailData.setEdt_2GObstruction(cursor.getString(4));
                        rfSectorAntennaDetailData.setEdt_2G_Existing_Antenna_Height(cursor.getString(5));
                        rfSectorAntennaDetailData.setEdt_2G_Antenna_Makeedt_and_Model(cursor.getString(6));
                        rfSectorAntennaDetailData.setEdt_2G_Existing_Antenna_Direction(cursor.getString(7));
                        rfSectorAntennaDetailData.setEdt_2G_Existing_antenna_tilt_Electrical(cursor.getString(8));
                        rfSectorAntennaDetailData.setEdt_2G_Existing_antenna_tilt_Mechanical(cursor.getString(9));
                        rfSectorAntennaDetailData.setEdt_3GBand(cursor.getString(10));
                        rfSectorAntennaDetailData.setEdt_3GCoverge(cursor.getString(12));
                        rfSectorAntennaDetailData.setEdt_3GObstruction(cursor.getString(13));
                        rfSectorAntennaDetailData.setEdt_3G_Existing_Antenna_Ht(cursor.getString(14));
                        rfSectorAntennaDetailData.setEdt_3G_Antenna_Make_and_Model(cursor.getString(15));
                        rfSectorAntennaDetailData.setEdt_3G_Existing_Antenna_Direction(cursor.getString(16));
                        rfSectorAntennaDetailData.setEdt_3G_Existing_antenna_Electrical_tilt(cursor.getString(17));
                        rfSectorAntennaDetailData.setEdt_3G_Existing_antenna_Mechanical_tilt(cursor.getString(18));
                        rfSectorAntennaDetailData.setEdt_Space_Available_for_3G_Antenna(cursor.getString(19));
                        rfSectorAntennaDetailData.setEdt_Addl_Poles_req_for_3G_Antenna(cursor.getString(20));
                        rfSectorAntennaDetailData.setEdt_3GAntenna_Swap_Required(cursor.getString(21));
                        rfSectorAntennaDetailData.setEdt_3GApproximate_Cable_Lenth(cursor.getString(22));
                        rfSectorAntennaDetailData.setEdt_3GAntenna_Port_EmptyDamaged(cursor.getString(23));
                        rfSectorAntennaDetailData.setEdt_4GBand(cursor.getString(24));
                        rfSectorAntennaDetailData.setEdt_4GCoverge(cursor.getString(25));
                        rfSectorAntennaDetailData.setEdt_4GObstruction(cursor.getString(26));
                        rfSectorAntennaDetailData.setEdt_4G_Existing_Antenna_Ht(cursor.getString(27));
                        rfSectorAntennaDetailData.setEdt_4G_Antenna_Make_and_Model(cursor.getString(28));
                        rfSectorAntennaDetailData.setEdt_4G_Existing_Antenna_Direction(cursor.getString(29));
                        rfSectorAntennaDetailData.setEdt_4G_Existing_antenna_Electrical_tilt(cursor.getString(30));
                        rfSectorAntennaDetailData.setEdt_4G_Existing_antenna_Mechanical_tilt(cursor.getString(31));
                        rfSectorAntennaDetailData.setEdt_Space_Available_for_4G_Antenna(cursor.getString(32));
                        rfSectorAntennaDetailData.setEdt_Addl_Poles_reqd_for_4G_Antenna(cursor.getString(33));
                        rfSectorAntennaDetailData.setEdt_4GAntenna_Swap_Required(cursor.getString(34));
                        rfSectorAntennaDetailData.setEdt_4GApproximate_Cable_Lenth(cursor.getString(35));
                        rfSectorAntennaDetailData.setEdt_4GAntennaedt_Port_EmptyDamaged(cursor.getString(36));

                        rfSectorAntennaDetailData.setImg_Antenna_Type(cursor.getString(37));
                        rfSectorAntennaDetailData.setImg_2GBand(cursor.getString(38));
                        rfSectorAntennaDetailData.setImg_2GCoverge(cursor.getString(39));
                        rfSectorAntennaDetailData.setImg_2GObstruction(cursor.getString(40));
                        rfSectorAntennaDetailData.setImg_2G_Existing_Antenna_Height(cursor.getString(41));
                        rfSectorAntennaDetailData.setImg_2G_Antenna_Make_and_Model(cursor.getString(42));
                        rfSectorAntennaDetailData.setImg_2G_Existing_Antenna_Direction(cursor.getString(43));
                        rfSectorAntennaDetailData.setImg_2G_Existing_antenna_tilt_Electrical(cursor.getString(44));
                        rfSectorAntennaDetailData.setImg_2G_Existing_antenna_tilt_Mechanical(cursor.getString(45));
                        rfSectorAntennaDetailData.setImg_3GBand(cursor.getString(46));
                        rfSectorAntennaDetailData.setImg_3GCoverge(cursor.getString(47));
                        rfSectorAntennaDetailData.setImg_3GObstruction(cursor.getString(48));
                        rfSectorAntennaDetailData.setImg_3G_Existing_Antenna_Ht(cursor.getString(49));
                        rfSectorAntennaDetailData.setImg_3G_Antenna_Make_and_Model(cursor.getString(50));
                        rfSectorAntennaDetailData.setImg_3G_Existing_Antenna_Direction(cursor.getString(51));
                        rfSectorAntennaDetailData.setImg_3G_Existing_antenna_Electrical_tilt(cursor.getString(52));
                        rfSectorAntennaDetailData.setImg_3G_Existing_antenna_Mechanical_tilt(cursor.getString(53));
                        rfSectorAntennaDetailData.setImg_Space_Available_for_3G_Antenna(cursor.getString(54));
                        rfSectorAntennaDetailData.setImg_Addl_Poles_reqd_for_3G_Antenna(cursor.getString(55));
                        rfSectorAntennaDetailData.setImg_3GAntenna_Swap_Required(cursor.getString(56));
                        rfSectorAntennaDetailData.setImg_3GApproximate_Cable_Lenth(cursor.getString(57));
                        rfSectorAntennaDetailData.setImg_3GAntenna_Port_EmptyDamaged(cursor.getString(58));
                        rfSectorAntennaDetailData.setImg_4GBand(cursor.getString(59));
                        rfSectorAntennaDetailData.setImg_4GCoverge(cursor.getString(60));
                        rfSectorAntennaDetailData.setImg_4GObstruction(cursor.getString(61));
                        rfSectorAntennaDetailData.setImg_4G_Existing_Antenna_Ht(cursor.getString(62));
                        rfSectorAntennaDetailData.setImg_4G_Antenna_Make_and_Model(cursor.getString(63));
                        rfSectorAntennaDetailData.setImg_4G_Existing_Antenna_Direction(cursor.getString(64));
                        rfSectorAntennaDetailData.setImg_4G_Existing_antenna_Electrical_tilt(cursor.getString(65));
                        rfSectorAntennaDetailData.setImg_4G_Existing_antenna_Mechanical_tilt(cursor.getString(66));
                        rfSectorAntennaDetailData.setImg_Space_Available_for_4G_Antenna(cursor.getString(67));
                        rfSectorAntennaDetailData.setImg_Addl_Poles_reqd_for_4G_Antenna(cursor.getString(68));
                        rfSectorAntennaDetailData.setImg_4GAntenna_Swap_Required(cursor.getString(69));
                        rfSectorAntennaDetailData.setImg_4GApproximate_Cable_Lenth(cursor.getString(70));
                        rfSectorAntennaDetailData.setImg_4GAntenna_Port_EmptyDamaged(cursor.getString(71));

                        rfSectorAntennaDetailData.setRf_sectorDetail_name(cursor.getString(72));
                        rfSectorAntennaDetailData.setDate(cursor.getString(73));
                        rfSectorAntennaDetailData.setFlag(cursor.getInt(74));




                        // Adding contact to list
                        list.add(rfSectorAntennaDetailData);
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

    public void deleteSomeRow_RFSectorDetail() {
        SQLiteDatabase db = this.getWritableDatabase();
        //  db.execSQL("delete from "+ TABLE_SURVEYFORM+" where " +KEY_INCRI_ID+ " not in ( select " +KEY_INCRI_ID+" from "+ TABLE_SURVEYFORM+" order by "+KEY_DATE +" desc limit 100)");
        db.execSQL("DELETE FROM " + TABLE_RFSECTORDETAIL + " ;");
        db.close();
    }

    public int getCountRFSectorDetail() {
        String countQuery = "SELECT  * FROM " + TABLE_RFSECTORDETAIL;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        // return count
        return count;
    }


}