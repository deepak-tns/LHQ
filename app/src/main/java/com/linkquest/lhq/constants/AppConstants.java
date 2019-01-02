package com.linkquest.lhq.constants;

/**
 * Created by Mayank on 27/04/2016.
 */
public interface AppConstants {


    /*alert type*/
    public static final int ALERT_TYPE_NO_NETWORK = 0x01;
    public static final int ALERT_TYPE_LOGOUT = 0x02;
    public static final int ALERT_TYPE_DELETE_USER = 0x03;

    public static final String eventSmsReceived = "android.provider.Telephony.SMS_RECEIVED";

   // public static final String VERIFYLOGINURL = "http://13.126.69.214/lqtweb/webservice.asmx/LoginDetailscheck";
    public static final String VERIFYLOGINURL = "http://13.126.69.214/lqtapp/api/Login/Getlogin";
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

}
