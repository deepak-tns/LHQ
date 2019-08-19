package com.linkquest.lhq.constants;

/**
 * Created by Mayank on 27/04/2016.
 */
public interface AppConstants {
    /*alert type*/
    public static final int ALERT_TYPE_NO_NETWORK = 0x01;
    public static final int ALERT_TYPE_LOGOUT = 0x02;
    public static final int ALERT_TYPE_DELETE_USER = 0x03;


    public static final String FTP_HOST = "tde.lqtindia.com";
    public static final String FTP_USER = "TDEFTP";
    public static final String FTP_PASS = "FTP@9876";

    public static String siteID ="";
    public static String date ="";

    public static final String eventSmsReceived = "android.provider.Telephony.SMS_RECEIVED";
//  public static final String VERIFYLOGINURL = "http://13.126.69.214/lqtweb/webservice.asmx/LoginDetailscheck";
    public static final String VERIFYLOGINURL = "http://13.126.69.214/lq/api/Login/Getlogin";
    public static final String SURVETTYPE = "http://13.126.69.214/lqtapp/api/Login/surveytype";
    public static final String CUSTOMER = "http://13.126.69.214/lqtapp/api/Login/Customer";
    public static final String OPERATOR = "http://13.126.69.214/lqtapp/api/Login/Operator";
    public static final String CIRCLE = "http://13.126.69.214/lqtapp/api/Login/Circle";
    public static final String TECHNOLOGY = "http://13.126.69.214/lqtapp/api/Login/Technology";
    public static final String TECHNOLOGYTYPE = "http://13.126.69.214/lqtapp/api/Login/TechTYPE";
    public static final String LOCATION = "http://13.126.69.214/lqtapp/api/Login/location";

    public static final String SURVEYDETAIL ="http://13.126.69.214/lq/api/Login/SurveyDetail";
    public static final String SITEDETAIL = "http://13.126.69.214/lq/api/Login/SiteDetail";
    public static final String SECTORDETAIL = "http://13.126.69.214/lq/api/Login/SectorDetail";
    public static final String SITEPANAROMIC = "http://13.126.69.214/lq/api/Login/SitePanaromic";
    public static final String OTHERDETAIL = "http://13.126.69.214/lq/api/Login/OtherDetail";

    public static final String  Los_Site_Detail = "http://13.126.69.214/lq/api/Login/Los_Site_Detail";
    public static final String  Transmission_Link = "http://13.126.69.214/lq/api/Login/Transmission_Link";
    public static final String  Transmission_No_Link = "http://13.126.69.214/lq/api/Login/Transmission_No_Link";
    public static final String  Los_Photos =  "http://13.126.69.214/lq/api/Login/Los_Photos";

    public static final String  RF_Sector_Detail =  "http://13.126.69.214/lq/api/Login/RF_Sector_Detail";
    public static final String  RF_Site_Detail =  "http://13.126.69.214/lq/api/Login/RF_Site_Detail";

     String APPNAME = "LHQ" ;
     String EMPID = "EMPID" ;
     String SITEID = "SITEID" ;
     String DATE = "DATE" ;
     String operators = "operators";
     String idall  = "idall";
     String surveytpeandcustomerandoperator = "surveytpeandcustomerandoperator";
}
