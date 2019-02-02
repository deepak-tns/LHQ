package com.linkquest.lhq.LOSAudit;


import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.linkquest.lhq.BitmapEncodedDecoded;
import com.linkquest.lhq.GoogleGPSService;
import com.linkquest.lhq.HTTPPostRequestMethod;
import com.linkquest.lhq.R;
import com.linkquest.lhq.Utils.AppSingleton;
import com.linkquest.lhq.Utils.SharedPreferenceUtils;
import com.linkquest.lhq.activity.CameraSurfaceViewActivity;
import com.linkquest.lhq.constants.AppConstants;
import com.linkquest.lhq.database.DatabaseHandler;
import com.linkquest.lhq.database.LOSSiteDetailData;
import com.linkquest.lhq.database.LosPhotoData;
import com.linkquest.lhq.database.OtherDetailData;
import com.linkquest.lhq.database.SectorDetailData;
import com.linkquest.lhq.database.SiteDetailForm;
import com.linkquest.lhq.database.SitePanoramicBlockingData;
import com.linkquest.lhq.database.SitePanoramicData;
import com.linkquest.lhq.database.SurveyForm;
import com.linkquest.lhq.database.TransmissionLinkData;
import com.linkquest.lhq.database.TransmissionNoLinkData;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.util.List;

import static android.app.Activity.RESULT_CANCELED;

/**
 * A simple {@link Fragment} subclass.
 */
public class LOSOtherFragment extends Fragment implements View.OnClickListener {

    private EditText edtRiggerPic;
    private EditText edtEngineerPic;
    private EditText edtCarPic;
    private EditText edt_RiggerPicwithclimbingTower;
    private EditText edtRiggerPicduringWah;

    private ImageButton ib_RiggerPic;
    private ImageButton ib_EngineerPic;
    private ImageButton ib_CarPic;
    private ImageButton ib_RiggerPicwithclimbingTower;
    private ImageButton ib_RiggerPicduringWah;

    private ImageView iv_RiggerPic;
    private ImageView iv_EngineerPic;
    private ImageView iv_CarPic;
    private ImageView iv_RiggerPicwithclimbingTower;
    private ImageView iv_RiggerPicduringWah;
    private DatabaseHandler db;
    private String lat, log, time;

    private String pic_RiggerPic = "";
    private String pic_EngineerPic = "";
    private String pic_CarPic = "";
    private String pic_RiggerPicwithclimbingTower = "";
    private String pic_RiggerPicduringWah = "";

    private Button btnothersave;
    private Button btnUpload;
    private TextView tv_otherdetail_count;
    private TextView tv_otherdetail_count_previous;
    private TextView tv_show_status;

    private final String LINK1 = "Link1";
    private final String LINK2 = "Link2";
    private final String LINK3 = "Link3";
    private final String LINK4 = "Link4";
    private final String LINK5 = "Link5";
    private final String LINK6 = "Link6";

    private final String NOLINK1 = "NOLink1";
    private final String NOLINK2 = "NOLink2";
    private final String NOLINK3 = "NOLink3";
    private final String NOLINK4 = "NOLink4";
    private final String NOLINK5 = "NOLink5";
    private final String NOLINK6 = "NOLink6";
    private SharedPreferenceUtils sharedPreferences;

    public LOSOtherFragment() {
        // Required empty public constructor
    }

    public static LOSOtherFragment newInstance(int index) {
        LOSOtherFragment f = new LOSOtherFragment();
        Bundle args = new Bundle();
        args.putInt("index", index);
        f.setArguments(args);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_other, container, false);
        db = new DatabaseHandler(getActivity());
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                time = DateFormat.format("dd-MM-yyyy h:mm:ss:aa", System.currentTimeMillis()).toString();
                handler.postDelayed(this, 1000);
            }

        }, 1000);

        findIDS(v);
        tv_otherdetail_count_previous.setText(tv_otherdetail_count_previous.getText().toString() + db.getCountOtherDetail());


        sharedPreferences = SharedPreferenceUtils.getInstance();
        sharedPreferences.setContext(getActivity());
        // String empId = sharedPreferences.getString(AppConstraint.EMPID);
        Toast.makeText(getActivity(), sharedPreferences.getString(AppConstants.DATE) + sharedPreferences.getString(AppConstants.EMPID) +
                sharedPreferences.getString(AppConstants.SITEID), Toast.LENGTH_LONG).show();
        return v;
    }

    private void findIDS(View v) {

        tv_show_status = v.findViewById(R.id.tv_show_status);

        edtRiggerPic = v.findViewById(R.id.other_riggerpic);
        edtEngineerPic = v.findViewById(R.id.other_engineerpic);
        edtCarPic = v.findViewById(R.id.other_carpic);
        edt_RiggerPicwithclimbingTower = v.findViewById(R.id.otherriggerpic_with_tower);
        edtRiggerPicduringWah = v.findViewById(R.id.other_riggerpicwithwah);

        ib_RiggerPic = v.findViewById(R.id.ibother_riggerpic);
        ib_EngineerPic = v.findViewById(R.id.ibother_engineerpic);
        ib_CarPic = v.findViewById(R.id.ib_other_carpic);
        ib_RiggerPicwithclimbingTower = v.findViewById(R.id.ib_otherriggerpic_with_tower);
        ib_RiggerPicduringWah = v.findViewById(R.id.ib_otherriggerpicwithwah);

        iv_RiggerPic = v.findViewById(R.id.ivother_riggerpic);
        iv_EngineerPic = v.findViewById(R.id.ivother_engineerpic);
        iv_CarPic = v.findViewById(R.id.iv_other_carpic);
        iv_RiggerPicwithclimbingTower = v.findViewById(R.id.iv_otherriggerpic_with_tower);
        iv_RiggerPicduringWah = v.findViewById(R.id.iv_otherriggerpicwithwah);

        btnothersave = v.findViewById(R.id.btnothersave);
        btnUpload = v.findViewById(R.id.btnUpload);
        tv_otherdetail_count = v.findViewById(R.id.tv_otherdetail_count);
        tv_otherdetail_count_previous = v.findViewById(R.id.tv_otherdetail_count_previous);

        ib_RiggerPic.setOnClickListener(this);
        ib_EngineerPic.setOnClickListener(this);
        ib_CarPic.setOnClickListener(this);
        ib_RiggerPicwithclimbingTower.setOnClickListener(this);
        ib_RiggerPicduringWah.setOnClickListener(this);
        btnothersave.setOnClickListener(this);
        btnUpload.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == ib_RiggerPic) {
            selectImage("1");
        }
        if (v == ib_EngineerPic) {
            selectImage("2");
        }
        if (v == ib_CarPic) {
            selectImage("3");
        }
        if (v == ib_RiggerPicwithclimbingTower) {
            selectImage("4");
        }
        if (v == ib_RiggerPicduringWah) {
            selectImage("5");
        }
        if (v == btnothersave) {

            db.insertOtherData(new OtherDetailData(edtRiggerPic.getText().toString(), edtEngineerPic.getText().toString(), edtCarPic.getText().toString(),
                    edt_RiggerPicwithclimbingTower.getText().toString(), edtRiggerPicduringWah.getText().toString(), pic_RiggerPic, pic_EngineerPic, pic_CarPic,
                    pic_RiggerPicwithclimbingTower, pic_RiggerPicduringWah, time, 1));

            //   db.insertOtherData(new OtherDetailData(1+"",2+"",3+"",4+"",5+"",1+"img",2+"img",3+"img", 4+"img",5+"img",time,1));
            int count = db.getCountOtherDetail();
            tv_otherdetail_count.setText(count + "");
        }
        if (v == btnUpload) {
            toSendDataSurveyDetail();
            toSendDataLOSSiteDetail();
            toSendDataTransmissionLink1(LINK1);
            toSendDataTransmissionLink2(LINK2);
            toSendDataTransmissionLink3(LINK3);
            toSendDataTransmissionLink4(LINK4);
            toSendDataTransmissionLink5(LINK5);
            toSendDataTransmissionLink6(LINK6);

            toSendDataTransmissionNoLink1(NOLINK1);
            toSendDataTransmissionNoLink2(NOLINK2);
            toSendDataTransmissionNoLink3(NOLINK3);
            toSendDataTransmissionNoLink4(NOLINK4);
            toSendDataTransmissionNoLink5(NOLINK5);
            toSendDataTransmissionNoLink6(NOLINK6);
            toSendDataSitePanaromic();
            toSendDataLosPhotos();
            toSendDataOtherDetail();
            // startActivity(new Intent(getActivity(),SiteAuditAllDataHistory.class));
        }
    }


    //...........................siteDetail.......................
    private JSONObject jsondataLOSDetail() {
        JSONObject jsonObject = new JSONObject();
        List<LOSSiteDetailData> losSiteDetailData = db.getLastLOSSitedetaiData();
        if (losSiteDetailData.size() > 0) {
            Log.v("LosOtherFragLosDetail", losSiteDetailData.toString());
            try {
                // jsonObject.put("siteid", siteDetailData.get(0).getSiteid());
                jsonObject.put("SiteID_TXT", losSiteDetailData.get(0).getSiteID_TXT());
                jsonObject.put("SiteName_TXT", losSiteDetailData.get(0).getSiteName_TXT());
                jsonObject.put("Sharing_TXT", losSiteDetailData.get(0).getSharing_TXT());
                jsonObject.put("SiteType_TXT", losSiteDetailData.get(0).getSiteType_TXT());
                jsonObject.put("SurveyDate_TXT", losSiteDetailData.get(0).getSurveyDate_TXT());
                jsonObject.put("TNPEngineer_TXT", losSiteDetailData.get(0).getTNPEngineer_TXT());
                jsonObject.put("TNPEngineerTel_TXT", losSiteDetailData.get(0).getTNPEngineerTel_TXT());
                jsonObject.put("Customerrepresentative_TXT", losSiteDetailData.get(0).getCustomerrepresentative_TXT());
                jsonObject.put("Nearenddetails_TXT", losSiteDetailData.get(0).getNearenddetails_TXT());
                jsonObject.put("Lat", losSiteDetailData.get(0).getLat());
                jsonObject.put("Long", losSiteDetailData.get(0).getLong());
                jsonObject.put("CandidateName_TXT", losSiteDetailData.get(0).getCandidateName_TXT());
                jsonObject.put("Address_TXT", losSiteDetailData.get(0).getAddress_TXT());
                jsonObject.put("Bldght_TXT", losSiteDetailData.get(0).getBldght_TXT());
                jsonObject.put("Totalht_TXT", losSiteDetailData.get(0).getTotalht_TXT());
                jsonObject.put("AMSL_TXT", losSiteDetailData.get(0).getAMSL_TXT());
                jsonObject.put("Buildingsideviewphoto_TXT", losSiteDetailData.get(0).getBuildingsideviewphoto_TXT());
                jsonObject.put("AntennaTowerlocationphoto_TXT", losSiteDetailData.get(0).getAntennaTowerlocationphoto_TXT());
                jsonObject.put("Possibleobstacle_TXT", losSiteDetailData.get(0).getPossibleobstacle_TXT());
                jsonObject.put("HeightofObstruction_TXT", losSiteDetailData.get(0).getHeightofObstruction_TXT());
                jsonObject.put("PanaromicPhoto_TXT", losSiteDetailData.get(0).getPanaromicPhoto_TXT());
                jsonObject.put("ExisitngNoofMWAntennatypewithsizeandPhotograph_TXT", losSiteDetailData.get(0).getExisitngNoofMWAntennatypewithsizeandPhotograph_TXT());
                jsonObject.put("ExisitngMWAntennaheightandPolemountPhotograph_TXT", losSiteDetailData.get(0).getExisitngMWAntennaheightandPolemountPhotograph_TXT());

                jsonObject.put("SiteID_PIC", losSiteDetailData.get(0).getSiteID_PIC());
                jsonObject.put("SiteName_PIC", losSiteDetailData.get(0).getSiteName_PIC());
                jsonObject.put("Sharing_PIC", losSiteDetailData.get(0).getSharing_PIC());
                jsonObject.put("SiteType_PIC", losSiteDetailData.get(0).getSiteType_PIC());
                jsonObject.put("SurveyDate_PIC", losSiteDetailData.get(0).getSurveyDate_PIC());
                jsonObject.put("TNPEngineer_PIC", losSiteDetailData.get(0).getTNPEngineer_PIC());
                jsonObject.put("TNPEngineerTel_PIC", losSiteDetailData.get(0).getTNPEngineerTel_PIC());
                jsonObject.put("Customerrepresentative_PIC", losSiteDetailData.get(0).getCustomerrepresentative_PIC());
                jsonObject.put("Nearenddetails_PIC", losSiteDetailData.get(0).getNearenddetails_PIC());
                jsonObject.put("CandidateName_PIC", losSiteDetailData.get(0).getCandidateName_PIC());
                jsonObject.put("Address_PIC", losSiteDetailData.get(0).getAddress_PIC());
                jsonObject.put("Bldght_PIC", losSiteDetailData.get(0).getBldght_PIC());
                jsonObject.put("Totalht_PIC", losSiteDetailData.get(0).getTotalht_PIC());
                jsonObject.put("AMSL_PIC", losSiteDetailData.get(0).getAMSL_PIC());
                jsonObject.put("Buildingsideviewphoto_PIC", losSiteDetailData.get(0).getBuildingsideviewphoto_PIC());
                jsonObject.put("AntennaTowerlocationphoto_PIC", losSiteDetailData.get(0).getAntennaTowerlocationphoto_PIC());
                jsonObject.put("Possibleobstacle_PIC", losSiteDetailData.get(0).getPossibleobstacle_PIC());
                jsonObject.put("HeightofObstruction_PIC", losSiteDetailData.get(0).getHeightofObstruction_PIC());
                jsonObject.put("PanaromicPhoto_PIC", losSiteDetailData.get(0).getPanaromicPhoto_PIC());
                jsonObject.put("ExisitngNoofMWAntennatypewithsizeandPhotograph_PIC", losSiteDetailData.get(0).getExisitngNoofMWAntennatypewithsizeandPhotograph_TXT());
                jsonObject.put("ExisitngMWAntennaheightandPolemountPhotograph_PIC", losSiteDetailData.get(0).getExisitngMWAntennaheightandPolemountPhotograph_TXT());
                // add  2/02/2019................................................
                jsonObject.put("edt_Commentaddnew", losSiteDetailData.get(0).getEdt_Commentsaddnew());
                jsonObject.put("edt_MWAntennaht", losSiteDetailData.get(0).getEdt_MWAntennaht());
                jsonObject.put("edt_towerexistingnew", losSiteDetailData.get(0).getEdt_towerexistingnew());
                jsonObject.put("edt_Towertype", losSiteDetailData.get(0).getEdt_Towertype());
                jsonObject.put("edt_remarks", losSiteDetailData.get(0).getEdt_remarks());
                jsonObject.put("img_Commentaddnew", losSiteDetailData.get(0).getImg_Commentsaddnew());
                jsonObject.put("img_MWAntennaht", losSiteDetailData.get(0).getImg_MWAntennaht());
                jsonObject.put("img_towerexistingnew", losSiteDetailData.get(0).getImg_towerexistingnew());
                jsonObject.put("img_Towertype", losSiteDetailData.get(0).getImg_Towertype());
                jsonObject.put("img_remarks", losSiteDetailData.get(0).getImg_remarks());

                jsonObject.put("flag", losSiteDetailData.get(0).getFlag());


                jsonObject.put("date", sharedPreferences.getString(AppConstants.DATE));
                jsonObject.put("empid", sharedPreferences.getString(AppConstants.EMPID));
                jsonObject.put("siteid", sharedPreferences.getString(AppConstants.SITEID));
                jsonObject.put("idall", sharedPreferences.getString(AppConstants.surveytpeandcustomerandoperator));
            } catch (Exception e) {

            }
        }
        return jsonObject;
    }

    private void toSendDataLOSSiteDetail() {
        //  +"?Loginid="+empId+"&password="+empPassword+"&imeno="+"1234567890"
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        pDialog.show();
        Log.v("jsonlossitedetail", jsondataLOSDetail().toString());
        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.Los_Site_Detail, jsondataLOSDetail(),
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponseLOSSiteDetail(response);
                        Log.v(" response sitedetail", response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v(" res errorsitedetail", error.toString());
                pDialog.hide();
            }

        });
        jsonObjReq.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });

        AppSingleton.getInstance(getActivity()).addToRequestQueue(jsonObjReq, null);
    }

    private void parseSettingResponseLOSSiteDetail(JSONArray response) {
        try {
            JSONArray jsonArray = new JSONArray(response.toString());
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String status = jsonObject.getString("Status");

            tv_show_status.append("Site Detail :" + status + "\n");
            Toast.makeText(getActivity(), status + " Site Detail", Toast.LENGTH_LONG).show();
            // String password = jsonObject.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//..........................siteDetail

    //...........................surveyDetail.......................
    private JSONObject jsondataSurveyDetail() {
        JSONObject jsonObject = new JSONObject();
        List<SurveyForm> surveyformData = db.getLastSurveyformData();
        if (surveyformData.size() > 0) {
            Log.v("OtherFragSurveyform", surveyformData.toString());

            try {
                jsonObject.put("surveytype", surveyformData.get(0).getSurveytype());
                jsonObject.put("customer", surveyformData.get(0).getCustomer());
                jsonObject.put("operators", surveyformData.get(0).getOperator());
                jsonObject.put("circle", surveyformData.get(0).getCircle());
                jsonObject.put("technology", surveyformData.get(0).getTechnology());
                jsonObject.put("technologytype", surveyformData.get(0).getTechnologytype());
                jsonObject.put("location", surveyformData.get(0).getLocation());
                jsonObject.put("siteid", surveyformData.get(0).getSiteid());
                // jsonObject.put("date", surveyformData.get(0).getDate());
                jsonObject.put("lat", surveyformData.get(0).getLat());
                jsonObject.put("log", surveyformData.get(0).getLog());
                jsonObject.put("flag", surveyformData.get(0).getFlag());
                jsonObject.put("clusterid", surveyformData.get(0).getCusterid());

                jsonObject.put("date", sharedPreferences.getString(AppConstants.DATE));
                jsonObject.put("empid", sharedPreferences.getString(AppConstants.EMPID));
                jsonObject.put("idall", sharedPreferences.getString(AppConstants.surveytpeandcustomerandoperator));

            } catch (Exception e) {

            }
        }
        Log.v("json_surveydetail", jsonObject.toString());
        return jsonObject;
    }

    private void toSendDataSurveyDetail() {
        //  +"?Loginid="+empId+"&password="+empPassword+"&imeno="+"1234567890"
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        pDialog.show();

        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.SURVEYDETAIL, jsondataSurveyDetail(),
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponseSurveyDetail(response.toString());
                        Log.v(" response_surveydetail", response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("res errorsurveydetail", error.toString());
                pDialog.hide();
            }

        });
        jsonObjReq.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });

        AppSingleton.getInstance(getActivity()).addToRequestQueue(jsonObjReq, null);
    }

    private void parseSettingResponseSurveyDetail(String s) {
        try {
            JSONArray jsonArray = new JSONArray(s);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String status = jsonObject.getString("Status");
            Toast.makeText(getActivity(), status + "Survey Detail", Toast.LENGTH_LONG).show();
            tv_show_status.append("Survey Detail :" + status + "\n");
            // String password = jsonObject.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //..........................SurveyDetail
//..........................TransmissionLink 1
    private JSONObject jsondataTransmissionLinkDetail1(String secname) {
        JSONObject jsonObject = new JSONObject();
        List<TransmissionLinkData> transmissionLinkData = db.getLastTransmissionLink(secname);
        if (transmissionLinkData.size() > 0) {
            Log.v("OtherFragTransLinkl", transmissionLinkData.toString());
            try {
                jsonObject.put("edt_Sitename", transmissionLinkData.get(0).getEdt_Sitename());
                jsonObject.put("edt_Latitude", transmissionLinkData.get(0).getEdt_Latitude());
                jsonObject.put("edt_Longitude", transmissionLinkData.get(0).getEdt_Longitude());
                jsonObject.put("edt_Azimuthfromnearend", transmissionLinkData.get(0).getEdt_Azimuthfromnearend());
                jsonObject.put("edt_Distance", transmissionLinkData.get(0).getEdt_Distance());
                jsonObject.put("edt_AntennaHeightatFarend", transmissionLinkData.get(0).getEdt_AntennaHeightatFarend());
                jsonObject.put("edt_PoleFixtureRequirementatFarend", transmissionLinkData.get(0).getEdt_PoleFixtureRequirementatFarend());
                jsonObject.put("edt_IFLengthatFarend", transmissionLinkData.get(0).getEdt_IFLengthatFarend());
                jsonObject.put("edt_BuildingHeightatFarend", transmissionLinkData.get(0).getEdt_BuildingHeightatFarend());
                jsonObject.put("edt_TotalhtForGBTRTTRTPATFarEnd", transmissionLinkData.get(0).getEdt_TotalhtForGBTRTTRTPATFarEnd());
                jsonObject.put("edt_AMSLatFarEnd", transmissionLinkData.get(0).getEdt_AMSLatFarEnd());
                jsonObject.put("img_SiteID", transmissionLinkData.get(0).getImg_SiteID());
                jsonObject.put("img_Sitename", transmissionLinkData.get(0).getImg_Sitename());
                jsonObject.put("img_Azimuthfromnearend", transmissionLinkData.get(0).getImg_Azimuthfromnearend());
                jsonObject.put("img_Distance", transmissionLinkData.get(0).getImg_Distance());
                jsonObject.put("img_AntennaHeightatFarend", transmissionLinkData.get(0).getImg_AntennaHeightatFarend());
                jsonObject.put("img_PoleFixtureRequirementatFarend", transmissionLinkData.get(0).getImg_PoleFixtureRequirementatFarend());
                jsonObject.put("img_IFLengthatFarend", transmissionLinkData.get(0).getImg_IFLengthatFarend());
                jsonObject.put("img_BuildingHeightatFarend", transmissionLinkData.get(0).getImg_BuildingHeightatFarend());
                jsonObject.put("img_TotalhtForGBTRTTRTPATFarEnd", transmissionLinkData.get(0).getImg_TotalhtForGBTRTTRTPATFarEnd());
                jsonObject.put("img_AMSLatFarEnd", transmissionLinkData.get(0).getImg_AMSLatFarEnd());
                jsonObject.put("transmissionLink_name", transmissionLinkData.get(0).getTransmissionLink_name());
            // add  02/02/2019.......................................
                jsonObject.put("edt_Commentadd", transmissionLinkData.get(0).getEdt_Commentadd());
                jsonObject.put("edt_Towertype", transmissionLinkData.get(0).getEdt_Towertype());
                jsonObject.put("edt_towerexistingnew", transmissionLinkData.get(0).getEdt_towerexistingnew());
                jsonObject.put("edt_Azimuthfromfarend", transmissionLinkData.get(0).getEdt_Azimuthfromfarend());
                jsonObject.put("edt_losstatus", transmissionLinkData.get(0).getEdt_losstatus());
                jsonObject.put("edt_remarks", transmissionLinkData.get(0).getEdt_remarks());
                jsonObject.put("img_Commentadd", transmissionLinkData.get(0).getImg_Commentadd());
                jsonObject.put("img_Towertype", transmissionLinkData.get(0).getImg_Towertype());
                jsonObject.put("img_towerexistingnew", transmissionLinkData.get(0).getImg_towerexistingnew());
                jsonObject.put("img_Azimuthfromfarend", transmissionLinkData.get(0).getImg_Azimuthfromfarend());
                jsonObject.put("img_losstatus", transmissionLinkData.get(0).getImg_losstatus());
                jsonObject.put("img_remarks", transmissionLinkData.get(0).getImg_remarks());

                jsonObject.put("flag", transmissionLinkData.get(0).getFlag());
                jsonObject.put("siteid",sharedPreferences.getString(AppConstants.SITEID));
                jsonObject.put("date",  sharedPreferences.getString(AppConstants.DATE));
                jsonObject.put("empid", sharedPreferences.getString(AppConstants.EMPID));
                jsonObject.put("idall", sharedPreferences.getString(AppConstants.surveytpeandcustomerandoperator));



            } catch (Exception e) {
                Log.e("Exception", e.toString());
            }
        }
        return jsonObject;
    }

    private void toSendDataTransmissionLink1(String secname) {
        //  +"?Loginid="+empId+"&password="+empPassword+"&imeno="+"1234567890"
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        pDialog.show();
        Log.v("jsonobjecttranlink1", jsondataTransmissionLinkDetail1(secname).toString());
        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.Transmission_Link, jsondataTransmissionLinkDetail1(secname),
                new Response.Listener<JSONArray>() {


                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponseTransmissionLink1(response.toString());
                        Log.v("res transmisiionLink1", response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("res transmissionlink1", error.toString());
                pDialog.hide();
            }

        });
        jsonObjReq.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });

        AppSingleton.getInstance(getActivity()).addToRequestQueue(jsonObjReq, null);
    }

    private void parseSettingResponseTransmissionLink1(String s) {
        try {
            JSONArray jsonArray = new JSONArray(s);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String status = jsonObject.getString("Status");
            Toast.makeText(getActivity(), status + "Link1", Toast.LENGTH_LONG).show();
            tv_show_status.append("Link1 :" + status + "\n");
            // String password = jsonObject.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //..........................TransmissionLink 2
    private JSONObject jsondataTransmissionLinkDetail2(String secname) {
        JSONObject jsonObject = new JSONObject();
        List<TransmissionLinkData> transmissionLinkData = db.getLastTransmissionLink(secname);
        if (transmissionLinkData.size() > 0) {
            Log.v("OtherFragTransLink2", transmissionLinkData.toString());
            try {
                jsonObject.put("edt_Sitename", transmissionLinkData.get(0).getEdt_Sitename());
                jsonObject.put("edt_Latitude", transmissionLinkData.get(0).getEdt_Latitude());
                jsonObject.put("edt_Longitude", transmissionLinkData.get(0).getEdt_Longitude());
                jsonObject.put("edt_Azimuthfromnearend", transmissionLinkData.get(0).getEdt_Azimuthfromnearend());
                jsonObject.put("edt_Distance", transmissionLinkData.get(0).getEdt_Distance());
                jsonObject.put("edt_AntennaHeightatFarend", transmissionLinkData.get(0).getEdt_AntennaHeightatFarend());
                jsonObject.put("edt_PoleFixtureRequirementatFarend", transmissionLinkData.get(0).getEdt_PoleFixtureRequirementatFarend());
                jsonObject.put("edt_IFLengthatFarend", transmissionLinkData.get(0).getEdt_IFLengthatFarend());
                jsonObject.put("edt_BuildingHeightatFarend", transmissionLinkData.get(0).getEdt_BuildingHeightatFarend());
                jsonObject.put("edt_TotalhtForGBTRTTRTPATFarEnd", transmissionLinkData.get(0).getEdt_TotalhtForGBTRTTRTPATFarEnd());
                jsonObject.put("edt_AMSLatFarEnd", transmissionLinkData.get(0).getEdt_AMSLatFarEnd());

                jsonObject.put("img_SiteID", transmissionLinkData.get(0).getImg_SiteID());
                jsonObject.put("img_Sitename", transmissionLinkData.get(0).getImg_Sitename());
                jsonObject.put("img_Azimuthfromnearend", transmissionLinkData.get(0).getImg_Azimuthfromnearend());
                jsonObject.put("img_Distance", transmissionLinkData.get(0).getImg_Distance());
                jsonObject.put("img_AntennaHeightatFarend", transmissionLinkData.get(0).getImg_AntennaHeightatFarend());
                jsonObject.put("img_PoleFixtureRequirementatFarend", transmissionLinkData.get(0).getImg_PoleFixtureRequirementatFarend());
                jsonObject.put("img_IFLengthatFarend", transmissionLinkData.get(0).getImg_IFLengthatFarend());
                jsonObject.put("img_BuildingHeightatFarend", transmissionLinkData.get(0).getImg_BuildingHeightatFarend());
                jsonObject.put("img_TotalhtForGBTRTTRTPATFarEnd", transmissionLinkData.get(0).getImg_TotalhtForGBTRTTRTPATFarEnd());
                jsonObject.put("img_AMSLatFarEnd", transmissionLinkData.get(0).getImg_AMSLatFarEnd());
                jsonObject.put("transmissionLink_name", transmissionLinkData.get(0).getTransmissionLink_name());
            //    jsonObject.put("date", transmissionLinkData.get(0).getDate());
                jsonObject.put("flag", transmissionLinkData.get(0).getFlag());

                jsonObject.put("siteid", sharedPreferences.getString(AppConstants.SITEID));
                jsonObject.put("date", sharedPreferences.getString(AppConstants.DATE));
                jsonObject.put("empid", sharedPreferences.getString(AppConstants.EMPID));
                jsonObject.put("idall", sharedPreferences.getString(AppConstants.surveytpeandcustomerandoperator));



            } catch (Exception e) {
                Log.e("Exception", e.toString());
            }
        }
        return jsonObject;
    }

    private void toSendDataTransmissionLink2(String secname) {
        //  +"?Loginid="+empId+"&password="+empPassword+"&imeno="+"1234567890"
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        pDialog.show();
        Log.v("jsonobjecttranslink2", jsondataTransmissionLinkDetail2(secname).toString());
        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.Transmission_Link, jsondataTransmissionLinkDetail2(secname),
                new Response.Listener<JSONArray>() {


                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponseTransmissionLink2(response.toString());
                        Log.v("res transmisiionLink2", response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("res transmissionlink2", error.toString());
                pDialog.hide();
            }

        });
        jsonObjReq.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });

        AppSingleton.getInstance(getActivity()).addToRequestQueue(jsonObjReq, null);
    }

    private void parseSettingResponseTransmissionLink2(String s) {
        try {
            JSONArray jsonArray = new JSONArray(s);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String status = jsonObject.getString("Status");
            Toast.makeText(getActivity(), status + "Link2", Toast.LENGTH_LONG).show();
            tv_show_status.append("Link2 :" + status + "\n");
            // String password = jsonObject.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //..........................TransmissionLink 3
    private JSONObject jsondataTransmissionLinkDetail3(String secname) {
        JSONObject jsonObject = new JSONObject();
        List<TransmissionLinkData> transmissionLinkData = db.getLastTransmissionLink(secname);
        if (transmissionLinkData.size() > 0) {
            Log.v("OtherFragTransLink3", transmissionLinkData.toString());
            try {
                jsonObject.put("edt_Sitename", transmissionLinkData.get(0).getEdt_Sitename());
                jsonObject.put("edt_Latitude", transmissionLinkData.get(0).getEdt_Latitude());
                jsonObject.put("edt_Longitude", transmissionLinkData.get(0).getEdt_Longitude());
                jsonObject.put("edt_Azimuthfromnearend", transmissionLinkData.get(0).getEdt_Azimuthfromnearend());
                jsonObject.put("edt_Distance", transmissionLinkData.get(0).getEdt_Distance());
                jsonObject.put("edt_AntennaHeightatFarend", transmissionLinkData.get(0).getEdt_AntennaHeightatFarend());
                jsonObject.put("edt_PoleFixtureRequirementatFarend", transmissionLinkData.get(0).getEdt_PoleFixtureRequirementatFarend());
                jsonObject.put("edt_IFLengthatFarend", transmissionLinkData.get(0).getEdt_IFLengthatFarend());
                jsonObject.put("edt_BuildingHeightatFarend", transmissionLinkData.get(0).getEdt_BuildingHeightatFarend());
                jsonObject.put("edt_TotalhtForGBTRTTRTPATFarEnd", transmissionLinkData.get(0).getEdt_TotalhtForGBTRTTRTPATFarEnd());
                jsonObject.put("edt_AMSLatFarEnd", transmissionLinkData.get(0).getEdt_AMSLatFarEnd());

                jsonObject.put("img_SiteID", transmissionLinkData.get(0).getImg_SiteID());
                jsonObject.put("img_Sitename", transmissionLinkData.get(0).getImg_Sitename());
                jsonObject.put("img_Azimuthfromnearend", transmissionLinkData.get(0).getImg_Azimuthfromnearend());
                jsonObject.put("img_Distance", transmissionLinkData.get(0).getImg_Distance());
                jsonObject.put("img_AntennaHeightatFarend", transmissionLinkData.get(0).getImg_AntennaHeightatFarend());
                jsonObject.put("img_PoleFixtureRequirementatFarend", transmissionLinkData.get(0).getImg_PoleFixtureRequirementatFarend());
                jsonObject.put("img_IFLengthatFarend", transmissionLinkData.get(0).getImg_IFLengthatFarend());
                jsonObject.put("img_BuildingHeightatFarend", transmissionLinkData.get(0).getImg_BuildingHeightatFarend());
                jsonObject.put("img_TotalhtForGBTRTTRTPATFarEnd", transmissionLinkData.get(0).getImg_TotalhtForGBTRTTRTPATFarEnd());
                jsonObject.put("img_AMSLatFarEnd", transmissionLinkData.get(0).getImg_AMSLatFarEnd());
                jsonObject.put("transmissionLink_name", transmissionLinkData.get(0).getTransmissionLink_name());
            //    jsonObject.put("date", transmissionLinkData.get(0).getDate());
                jsonObject.put("flag", transmissionLinkData.get(0).getFlag());

                jsonObject.put("siteid", sharedPreferences.getString(AppConstants.SITEID));
                jsonObject.put("date", sharedPreferences.getString(AppConstants.DATE));
                jsonObject.put("empid", sharedPreferences.getString(AppConstants.EMPID));
                jsonObject.put("idall", sharedPreferences.getString(AppConstants.surveytpeandcustomerandoperator));



            } catch (Exception e) {
                Log.e("Exception", e.toString());
            }
        }
        return jsonObject;
    }

    private void toSendDataTransmissionLink3(String secname) {
        //  +"?Loginid="+empId+"&password="+empPassword+"&imeno="+"1234567890"
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        pDialog.show();
        Log.v("jsonobjecttranslink3", jsondataTransmissionLinkDetail3(secname).toString());
        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.Transmission_Link, jsondataTransmissionLinkDetail3(secname),
                new Response.Listener<JSONArray>() {


                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponseTransmissionLink3(response.toString());
                        Log.v("res transmisiionLink3", response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("res transmissionlink3", error.toString());
                pDialog.hide();
            }

        });
        jsonObjReq.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });

        AppSingleton.getInstance(getActivity()).addToRequestQueue(jsonObjReq, null);
    }

    private void parseSettingResponseTransmissionLink3(String s) {
        try {
            JSONArray jsonArray = new JSONArray(s);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String status = jsonObject.getString("Status");
            Toast.makeText(getActivity(), status + "Link3", Toast.LENGTH_LONG).show();
            tv_show_status.append("Link3 :" + status + "\n");
            // String password = jsonObject.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //..........................TransmissionLink 4
    private JSONObject jsondataTransmissionLinkDetail4(String secname) {
        JSONObject jsonObject = new JSONObject();
        List<TransmissionLinkData> transmissionLinkData = db.getLastTransmissionLink(secname);
        if (transmissionLinkData.size() > 0) {
            Log.v("OtherFragTransLink4", transmissionLinkData.toString());
            try {
                jsonObject.put("edt_Sitename", transmissionLinkData.get(0).getEdt_Sitename());
                jsonObject.put("edt_Latitude", transmissionLinkData.get(0).getEdt_Latitude());
                jsonObject.put("edt_Longitude", transmissionLinkData.get(0).getEdt_Longitude());
                jsonObject.put("edt_Azimuthfromnearend", transmissionLinkData.get(0).getEdt_Azimuthfromnearend());
                jsonObject.put("edt_Distance", transmissionLinkData.get(0).getEdt_Distance());
                jsonObject.put("edt_AntennaHeightatFarend", transmissionLinkData.get(0).getEdt_AntennaHeightatFarend());
                jsonObject.put("edt_PoleFixtureRequirementatFarend", transmissionLinkData.get(0).getEdt_PoleFixtureRequirementatFarend());
                jsonObject.put("edt_IFLengthatFarend", transmissionLinkData.get(0).getEdt_IFLengthatFarend());
                jsonObject.put("edt_BuildingHeightatFarend", transmissionLinkData.get(0).getEdt_BuildingHeightatFarend());
                jsonObject.put("edt_TotalhtForGBTRTTRTPATFarEnd", transmissionLinkData.get(0).getEdt_TotalhtForGBTRTTRTPATFarEnd());
                jsonObject.put("edt_AMSLatFarEnd", transmissionLinkData.get(0).getEdt_AMSLatFarEnd());

                jsonObject.put("img_SiteID", transmissionLinkData.get(0).getImg_SiteID());
                jsonObject.put("img_Sitename", transmissionLinkData.get(0).getImg_Sitename());
                jsonObject.put("img_Azimuthfromnearend", transmissionLinkData.get(0).getImg_Azimuthfromnearend());
                jsonObject.put("img_Distance", transmissionLinkData.get(0).getImg_Distance());
                jsonObject.put("img_AntennaHeightatFarend", transmissionLinkData.get(0).getImg_AntennaHeightatFarend());
                jsonObject.put("img_PoleFixtureRequirementatFarend", transmissionLinkData.get(0).getImg_PoleFixtureRequirementatFarend());
                jsonObject.put("img_IFLengthatFarend", transmissionLinkData.get(0).getImg_IFLengthatFarend());
                jsonObject.put("img_BuildingHeightatFarend", transmissionLinkData.get(0).getImg_BuildingHeightatFarend());
                jsonObject.put("img_TotalhtForGBTRTTRTPATFarEnd", transmissionLinkData.get(0).getImg_TotalhtForGBTRTTRTPATFarEnd());
                jsonObject.put("img_AMSLatFarEnd", transmissionLinkData.get(0).getImg_AMSLatFarEnd());
                jsonObject.put("transmissionLink_name", transmissionLinkData.get(0).getTransmissionLink_name());
             //   jsonObject.put("date", transmissionLinkData.get(0).getDate());
                jsonObject.put("flag", transmissionLinkData.get(0).getFlag());

                jsonObject.put("siteid", sharedPreferences.getString(AppConstants.SITEID));
                jsonObject.put("date", sharedPreferences.getString(AppConstants.DATE));
                jsonObject.put("empid", sharedPreferences.getString(AppConstants.EMPID));
                jsonObject.put("idall", sharedPreferences.getString(AppConstants.surveytpeandcustomerandoperator));



            } catch (Exception e) {
                Log.e("Exception", e.toString());
            }
        }
        return jsonObject;
    }

    private void toSendDataTransmissionLink4(String secname) {
        //  +"?Loginid="+empId+"&password="+empPassword+"&imeno="+"1234567890"
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        pDialog.show();
        Log.v("jsonobjecttranslink4", jsondataTransmissionLinkDetail4(secname).toString());
        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.Transmission_Link, jsondataTransmissionLinkDetail4(secname),
                new Response.Listener<JSONArray>() {


                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponseTransmissionLink4(response.toString());
                        Log.v("res transmisiionLink4", response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("res transmissionlink4", error.toString());
                pDialog.hide();
            }

        });
        jsonObjReq.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });

        AppSingleton.getInstance(getActivity()).addToRequestQueue(jsonObjReq, null);
    }

    private void parseSettingResponseTransmissionLink4(String s) {
        try {
            JSONArray jsonArray = new JSONArray(s);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String status = jsonObject.getString("Status");
            Toast.makeText(getActivity(), status + "Link4", Toast.LENGTH_LONG).show();
            tv_show_status.append("Link4 :" + status + "\n");
            // String password = jsonObject.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //..........................TransmissionLink 5
    private JSONObject jsondataTransmissionLinkDetail5(String secname) {
        JSONObject jsonObject = new JSONObject();
        List<TransmissionLinkData> transmissionLinkData = db.getLastTransmissionLink(secname);
        if (transmissionLinkData.size() > 0) {
            Log.v("OtherFragTransLink5", transmissionLinkData.toString());
            try {
                jsonObject.put("edt_Sitename", transmissionLinkData.get(0).getEdt_Sitename());
                jsonObject.put("edt_Latitude", transmissionLinkData.get(0).getEdt_Latitude());
                jsonObject.put("edt_Longitude", transmissionLinkData.get(0).getEdt_Longitude());
                jsonObject.put("edt_Azimuthfromnearend", transmissionLinkData.get(0).getEdt_Azimuthfromnearend());
                jsonObject.put("edt_Distance", transmissionLinkData.get(0).getEdt_Distance());
                jsonObject.put("edt_AntennaHeightatFarend", transmissionLinkData.get(0).getEdt_AntennaHeightatFarend());
                jsonObject.put("edt_PoleFixtureRequirementatFarend", transmissionLinkData.get(0).getEdt_PoleFixtureRequirementatFarend());
                jsonObject.put("edt_IFLengthatFarend", transmissionLinkData.get(0).getEdt_IFLengthatFarend());
                jsonObject.put("edt_BuildingHeightatFarend", transmissionLinkData.get(0).getEdt_BuildingHeightatFarend());
                jsonObject.put("edt_TotalhtForGBTRTTRTPATFarEnd", transmissionLinkData.get(0).getEdt_TotalhtForGBTRTTRTPATFarEnd());
                jsonObject.put("edt_AMSLatFarEnd", transmissionLinkData.get(0).getEdt_AMSLatFarEnd());

                jsonObject.put("img_SiteID", transmissionLinkData.get(0).getImg_SiteID());
                jsonObject.put("img_Sitename", transmissionLinkData.get(0).getImg_Sitename());
                jsonObject.put("img_Azimuthfromnearend", transmissionLinkData.get(0).getImg_Azimuthfromnearend());
                jsonObject.put("img_Distance", transmissionLinkData.get(0).getImg_Distance());
                jsonObject.put("img_AntennaHeightatFarend", transmissionLinkData.get(0).getImg_AntennaHeightatFarend());
                jsonObject.put("img_PoleFixtureRequirementatFarend", transmissionLinkData.get(0).getImg_PoleFixtureRequirementatFarend());
                jsonObject.put("img_IFLengthatFarend", transmissionLinkData.get(0).getImg_IFLengthatFarend());
                jsonObject.put("img_BuildingHeightatFarend", transmissionLinkData.get(0).getImg_BuildingHeightatFarend());
                jsonObject.put("img_TotalhtForGBTRTTRTPATFarEnd", transmissionLinkData.get(0).getImg_TotalhtForGBTRTTRTPATFarEnd());
                jsonObject.put("img_AMSLatFarEnd", transmissionLinkData.get(0).getImg_AMSLatFarEnd());
                jsonObject.put("transmissionLink_name", transmissionLinkData.get(0).getTransmissionLink_name());
              //  jsonObject.put("date", transmissionLinkData.get(0).getDate());
                jsonObject.put("flag", transmissionLinkData.get(0).getFlag());

                jsonObject.put("siteid", sharedPreferences.getString(AppConstants.SITEID));
                jsonObject.put("date", sharedPreferences.getString(AppConstants.DATE));
                jsonObject.put("empid", sharedPreferences.getString(AppConstants.EMPID));
                jsonObject.put("idall", sharedPreferences.getString(AppConstants.surveytpeandcustomerandoperator));



            } catch (Exception e) {
                Log.e("Exception", e.toString());
            }
        }
        return jsonObject;
    }

    private void toSendDataTransmissionLink5(String secname) {
        //  +"?Loginid="+empId+"&password="+empPassword+"&imeno="+"1234567890"
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        pDialog.show();
        Log.v("jsonobjecttranslink5", jsondataTransmissionLinkDetail5(secname).toString());
        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.Transmission_Link, jsondataTransmissionLinkDetail5(secname),
                new Response.Listener<JSONArray>() {


                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponseTransmissionLink5(response.toString());
                        Log.v("res transmisiionLink5", response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("res transmissionlink5", error.toString());
                pDialog.hide();
            }

        });
        jsonObjReq.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });

        AppSingleton.getInstance(getActivity()).addToRequestQueue(jsonObjReq, null);
    }

    private void parseSettingResponseTransmissionLink5(String s) {
        try {
            JSONArray jsonArray = new JSONArray(s);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String status = jsonObject.getString("Status");
            Toast.makeText(getActivity(), status + "Link5", Toast.LENGTH_LONG).show();
            tv_show_status.append("Link5 :" + status + "\n");
            // String password = jsonObject.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //..........................TransmissionLink 6
    private JSONObject jsondataTransmissionLinkDetail6(String secname) {
        JSONObject jsonObject = new JSONObject();
        List<TransmissionLinkData> transmissionLinkData = db.getLastTransmissionLink(secname);
        if (transmissionLinkData.size() > 0) {
            Log.v("OtherFragTransLink6", transmissionLinkData.toString());
            try {
                jsonObject.put("edt_Sitename", transmissionLinkData.get(0).getEdt_Sitename());
                jsonObject.put("edt_Latitude", transmissionLinkData.get(0).getEdt_Latitude());
                jsonObject.put("edt_Longitude", transmissionLinkData.get(0).getEdt_Longitude());
                jsonObject.put("edt_Azimuthfromnearend", transmissionLinkData.get(0).getEdt_Azimuthfromnearend());
                jsonObject.put("edt_Distance", transmissionLinkData.get(0).getEdt_Distance());
                jsonObject.put("edt_AntennaHeightatFarend", transmissionLinkData.get(0).getEdt_AntennaHeightatFarend());
                jsonObject.put("edt_PoleFixtureRequirementatFarend", transmissionLinkData.get(0).getEdt_PoleFixtureRequirementatFarend());
                jsonObject.put("edt_IFLengthatFarend", transmissionLinkData.get(0).getEdt_IFLengthatFarend());
                jsonObject.put("edt_BuildingHeightatFarend", transmissionLinkData.get(0).getEdt_BuildingHeightatFarend());
                jsonObject.put("edt_TotalhtForGBTRTTRTPATFarEnd", transmissionLinkData.get(0).getEdt_TotalhtForGBTRTTRTPATFarEnd());
                jsonObject.put("edt_AMSLatFarEnd", transmissionLinkData.get(0).getEdt_AMSLatFarEnd());

                jsonObject.put("img_SiteID", transmissionLinkData.get(0).getImg_SiteID());
                jsonObject.put("img_Sitename", transmissionLinkData.get(0).getImg_Sitename());
                jsonObject.put("img_Azimuthfromnearend", transmissionLinkData.get(0).getImg_Azimuthfromnearend());
                jsonObject.put("img_Distance", transmissionLinkData.get(0).getImg_Distance());
                jsonObject.put("img_AntennaHeightatFarend", transmissionLinkData.get(0).getImg_AntennaHeightatFarend());
                jsonObject.put("img_PoleFixtureRequirementatFarend", transmissionLinkData.get(0).getImg_PoleFixtureRequirementatFarend());
                jsonObject.put("img_IFLengthatFarend", transmissionLinkData.get(0).getImg_IFLengthatFarend());
                jsonObject.put("img_BuildingHeightatFarend", transmissionLinkData.get(0).getImg_BuildingHeightatFarend());
                jsonObject.put("img_TotalhtForGBTRTTRTPATFarEnd", transmissionLinkData.get(0).getImg_TotalhtForGBTRTTRTPATFarEnd());
                jsonObject.put("img_AMSLatFarEnd", transmissionLinkData.get(0).getImg_AMSLatFarEnd());
                jsonObject.put("transmissionLink_name", transmissionLinkData.get(0).getTransmissionLink_name());
               // jsonObject.put("date", transmissionLinkData.get(0).getDate());
                jsonObject.put("flag", transmissionLinkData.get(0).getFlag());

                jsonObject.put("siteid", sharedPreferences.getString(AppConstants.SITEID));
                jsonObject.put("date", sharedPreferences.getString(AppConstants.DATE));
                jsonObject.put("empid", sharedPreferences.getString(AppConstants.EMPID));
                jsonObject.put("idall", sharedPreferences.getString(AppConstants.surveytpeandcustomerandoperator));



            } catch (Exception e) {
                Log.e("Exception", e.toString());
            }
        }
        return jsonObject;
    }

    private void toSendDataTransmissionLink6(String secname) {
        //  +"?Loginid="+empId+"&password="+empPassword+"&imeno="+"1234567890"
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        pDialog.show();
        Log.v("jsonobjecttranslink6", jsondataTransmissionLinkDetail6(secname).toString());
        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.Transmission_Link, jsondataTransmissionLinkDetail6(secname),
                new Response.Listener<JSONArray>() {


                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponseTransmissionLink6(response.toString());
                        Log.v("res transmisiionLink6", response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("res transmissionlink6", error.toString());
                pDialog.hide();
            }

        });
        jsonObjReq.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });

        AppSingleton.getInstance(getActivity()).addToRequestQueue(jsonObjReq, null);
    }

    private void parseSettingResponseTransmissionLink6(String s) {
        try {
            JSONArray jsonArray = new JSONArray(s);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String status = jsonObject.getString("Status");
            Toast.makeText(getActivity(), status + "Link6", Toast.LENGTH_LONG).show();
            tv_show_status.append("Link6 :" + status + "\n");
            // String password = jsonObject.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //..........................TransmissionNoLink  1
    private JSONObject jsondataTransmissionNoLinkDetail1(String secname) {
        JSONObject jsonObject = new JSONObject();
        List<TransmissionNoLinkData> transmissionNoLinkData = db.getLastTransmissionNOLink (secname);
        if (transmissionNoLinkData.size() > 0) {
            Log.v("OtherFragTransNoLink 1", transmissionNoLinkData.toString());
            try {
                jsonObject.put("edt_Sitename",  transmissionNoLinkData.get(0).getEdt_Sitename());
                jsonObject.put("edt_ObstructionDetails",  transmissionNoLinkData.get(0).getEdt_ObstructionDetails());
                jsonObject.put("edt_Azimuth",  transmissionNoLinkData.get(0).getEdt_Azimuth());
                jsonObject.put("edt_Distance",  transmissionNoLinkData.get(0).getEdt_Distance());
                jsonObject.put("edt_AntennaHeight",  transmissionNoLinkData.get(0).getEdt_AntennaHeight());
                jsonObject.put("edt_Altitude",  transmissionNoLinkData.get(0).getEdt_Altitude());
                jsonObject.put("img_SiteID",  transmissionNoLinkData.get(0).getImg_SiteID());
                jsonObject.put("img_Sitename",  transmissionNoLinkData.get(0).getImg_Sitename());
                jsonObject.put("img_ObstructionDetails",  transmissionNoLinkData.get(0).getImg_ObstructionDetails());
                jsonObject.put("img_Azimuth",  transmissionNoLinkData.get(0).getImg_Azimuth());
                jsonObject.put("img_Distance",  transmissionNoLinkData.get(0).getImg_Distance());
                jsonObject.put("img_AntennaHeight",  transmissionNoLinkData.get(0).getImg_AntennaHeight());
                jsonObject.put("img_Altitude",  transmissionNoLinkData.get(0).getImg_Altitude());

                jsonObject.put("transmissionNoLink_name", transmissionNoLinkData.get(0).getTransmissionNoLink_name());
             //   jsonObject.put("date", transmissionNoLinkData.get(0).getDate());
                jsonObject.put("flag", transmissionNoLinkData.get(0).getFlag());

                jsonObject.put("siteid", sharedPreferences.getString(AppConstants.SITEID));
                jsonObject.put("date", sharedPreferences.getString(AppConstants.DATE));
                jsonObject.put("empid", sharedPreferences.getString(AppConstants.EMPID));
                jsonObject.put("idall", sharedPreferences.getString(AppConstants.surveytpeandcustomerandoperator));


            } catch (Exception e) {
                Log.e("Exception", e.toString());
            }
        }
        return jsonObject;
    }

    private void toSendDataTransmissionNoLink1(String secname) {
        //  +"?Loginid="+empId+"&password="+empPassword+"&imeno="+"1234567890"
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        pDialog.show();
        Log.v("jsonobjectTransNoLink 1", jsondataTransmissionNoLinkDetail1(secname).toString());
        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.Transmission_No_Link, jsondataTransmissionNoLinkDetail1(secname),
                new Response.Listener<JSONArray>() {


                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponseTransmissionNoLink1(response.toString());
                        Log.v("res transmisiionLink1", response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("res TransNoLink 1", error.toString());
                pDialog.hide();
            }

        });
        jsonObjReq.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });

        AppSingleton.getInstance(getActivity()).addToRequestQueue(jsonObjReq, null);
    }

    private void parseSettingResponseTransmissionNoLink1(String s) {
        try {
            JSONArray jsonArray = new JSONArray(s);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String status = jsonObject.getString("Status");
            Toast.makeText(getActivity(), status + "NoLink1", Toast.LENGTH_LONG).show();
            tv_show_status.append("NoLink1 :" + status + "\n");
            // String password = jsonObject.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //..........................TransmissionNoLink  2
    private JSONObject jsondataTransmissionNoLinkDetail2(String secname) {
        JSONObject jsonObject = new JSONObject();
        List<TransmissionNoLinkData> transmissionNoLinkData = db.getLastTransmissionNOLink (secname);
        if (transmissionNoLinkData.size() > 0) {
            Log.v("OtherFragTransNoLink 2", transmissionNoLinkData.toString());
            try {
                jsonObject.put("edt_Sitename",  transmissionNoLinkData.get(0).getEdt_Sitename());
                jsonObject.put("edt_ObstructionDetails",  transmissionNoLinkData.get(0).getEdt_ObstructionDetails());
                jsonObject.put("edt_Azimuth",  transmissionNoLinkData.get(0).getEdt_Azimuth());
                jsonObject.put("edt_Distance",  transmissionNoLinkData.get(0).getEdt_Distance());
                jsonObject.put("edt_AntennaHeight",  transmissionNoLinkData.get(0).getEdt_AntennaHeight());
                jsonObject.put("edt_Altitude",  transmissionNoLinkData.get(0).getEdt_Altitude());
                jsonObject.put("img_SiteID",  transmissionNoLinkData.get(0).getImg_SiteID());
                jsonObject.put("img_Sitename",  transmissionNoLinkData.get(0).getImg_Sitename());
                jsonObject.put("img_ObstructionDetails",  transmissionNoLinkData.get(0).getImg_ObstructionDetails());
                jsonObject.put("img_Azimuth",  transmissionNoLinkData.get(0).getImg_Azimuth());
                jsonObject.put("img_Distance",  transmissionNoLinkData.get(0).getImg_Distance());
                jsonObject.put("img_AntennaHeight",  transmissionNoLinkData.get(0).getImg_AntennaHeight());
                jsonObject.put("img_Altitude",  transmissionNoLinkData.get(0).getImg_Altitude());

                jsonObject.put("transmissionNoLink_name", transmissionNoLinkData.get(0).getTransmissionNoLink_name());
              //  jsonObject.put("date", transmissionNoLinkData.get(0).getDate());
                jsonObject.put("flag", transmissionNoLinkData.get(0).getFlag());

                jsonObject.put("siteid", sharedPreferences.getString(AppConstants.SITEID));
                jsonObject.put("date", sharedPreferences.getString(AppConstants.DATE));
                jsonObject.put("empid", sharedPreferences.getString(AppConstants.EMPID));
                jsonObject.put("idall", sharedPreferences.getString(AppConstants.surveytpeandcustomerandoperator));




            } catch (Exception e) {
                Log.e("Exception", e.toString());
            }
        }
        return jsonObject;
    }

    private void toSendDataTransmissionNoLink2(String secname) {
        //  +"?Loginid="+empId+"&password="+empPassword+"&imeno="+"1234567890"
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        pDialog.show();
        Log.v("jsonobjectTransNoLink 2", jsondataTransmissionNoLinkDetail2(secname).toString());
        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.Transmission_No_Link, jsondataTransmissionNoLinkDetail2(secname),
                new Response.Listener<JSONArray>() {


                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponseTransmissionNoLink2(response.toString());
                        Log.v("res transmisiionNoLink2", response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("res TransNoLink 2", error.toString());
                pDialog.hide();
            }

        });
        jsonObjReq.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });

        AppSingleton.getInstance(getActivity()).addToRequestQueue(jsonObjReq, null);
    }

    private void parseSettingResponseTransmissionNoLink2(String s) {
        try {
            JSONArray jsonArray = new JSONArray(s);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String status = jsonObject.getString("Status");
            Toast.makeText(getActivity(), status + "NoLink2", Toast.LENGTH_LONG).show();
            tv_show_status.append("NoLink2 :" + status + "\n");
            // String password = jsonObject.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //..........................TransmissionNoLink  3
    private JSONObject jsondataTransmissionNoLinkDetail3(String secname) {
        JSONObject jsonObject = new JSONObject();
        List<TransmissionNoLinkData> transmissionNoLinkData = db.getLastTransmissionNOLink (secname);
        if (transmissionNoLinkData.size() > 0) {
            Log.v("OtherFragTransNoLink 3", transmissionNoLinkData.toString());
            try {
                jsonObject.put("edt_Sitename",  transmissionNoLinkData.get(0).getEdt_Sitename());
                jsonObject.put("edt_ObstructionDetails",  transmissionNoLinkData.get(0).getEdt_ObstructionDetails());
                jsonObject.put("edt_Azimuth",  transmissionNoLinkData.get(0).getEdt_Azimuth());
                jsonObject.put("edt_Distance",  transmissionNoLinkData.get(0).getEdt_Distance());
                jsonObject.put("edt_AntennaHeight",  transmissionNoLinkData.get(0).getEdt_AntennaHeight());
                jsonObject.put("edt_Altitude",  transmissionNoLinkData.get(0).getEdt_Altitude());
                jsonObject.put("img_SiteID",  transmissionNoLinkData.get(0).getImg_SiteID());
                jsonObject.put("img_Sitename",  transmissionNoLinkData.get(0).getImg_Sitename());
                jsonObject.put("img_ObstructionDetails",  transmissionNoLinkData.get(0).getImg_ObstructionDetails());
                jsonObject.put("img_Azimuth",  transmissionNoLinkData.get(0).getImg_Azimuth());
                jsonObject.put("img_Distance",  transmissionNoLinkData.get(0).getImg_Distance());
                jsonObject.put("img_AntennaHeight",  transmissionNoLinkData.get(0).getImg_AntennaHeight());
                jsonObject.put("img_Altitude",  transmissionNoLinkData.get(0).getImg_Altitude());

                jsonObject.put("transmissionNoLink_name", transmissionNoLinkData.get(0).getTransmissionNoLink_name());
            //    jsonObject.put("date", transmissionNoLinkData.get(0).getDate());
                jsonObject.put("flag", transmissionNoLinkData.get(0).getFlag());

                jsonObject.put("siteid", sharedPreferences.getString(AppConstants.SITEID));
                jsonObject.put("date", sharedPreferences.getString(AppConstants.DATE));
                jsonObject.put("empid", sharedPreferences.getString(AppConstants.EMPID));
                jsonObject.put("idall", sharedPreferences.getString(AppConstants.surveytpeandcustomerandoperator));



            } catch (Exception e) {
                Log.e("Exception", e.toString());
            }
        }
        return jsonObject;
    }

    private void toSendDataTransmissionNoLink3(String secname) {
        //  +"?Loginid="+empId+"&password="+empPassword+"&imeno="+"1234567890"
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        pDialog.show();
        Log.v("jsonobjectTransNoLink3", jsondataTransmissionNoLinkDetail3(secname).toString());
        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.Transmission_No_Link, jsondataTransmissionNoLinkDetail3(secname),
                new Response.Listener<JSONArray>() {


                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponseTransmissionNoLink3(response.toString());
                        Log.v("res transmisiionNoLink3", response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("res TransNoLink 3", error.toString());
                pDialog.hide();
            }

        });
        jsonObjReq.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });

        AppSingleton.getInstance(getActivity()).addToRequestQueue(jsonObjReq, null);
    }

    private void parseSettingResponseTransmissionNoLink3(String s) {
        try {
            JSONArray jsonArray = new JSONArray(s);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String status = jsonObject.getString("Status");
            Toast.makeText(getActivity(), status + "NoLink3", Toast.LENGTH_LONG).show();
            tv_show_status.append("NoLink3 :" + status + "\n");
            // String password = jsonObject.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //..........................TransmissionNoLink  4
    private JSONObject jsondataTransmissionNoLinkDetail4(String secname) {
        JSONObject jsonObject = new JSONObject();
        List<TransmissionNoLinkData> transmissionNoLinkData = db.getLastTransmissionNOLink (secname);
        if (transmissionNoLinkData.size() > 0) {
            Log.v("OtherFragTransNoLink4", transmissionNoLinkData.toString());
            try {
                jsonObject.put("edt_Sitename",  transmissionNoLinkData.get(0).getEdt_Sitename());
                jsonObject.put("edt_ObstructionDetails",  transmissionNoLinkData.get(0).getEdt_ObstructionDetails());
                jsonObject.put("edt_Azimuth",  transmissionNoLinkData.get(0).getEdt_Azimuth());
                jsonObject.put("edt_Distance",  transmissionNoLinkData.get(0).getEdt_Distance());
                jsonObject.put("edt_AntennaHeight",  transmissionNoLinkData.get(0).getEdt_AntennaHeight());
                jsonObject.put("edt_Altitude",  transmissionNoLinkData.get(0).getEdt_Altitude());
                jsonObject.put("img_SiteID",  transmissionNoLinkData.get(0).getImg_SiteID());
                jsonObject.put("img_Sitename",  transmissionNoLinkData.get(0).getImg_Sitename());
                jsonObject.put("img_ObstructionDetails",  transmissionNoLinkData.get(0).getImg_ObstructionDetails());
                jsonObject.put("img_Azimuth",  transmissionNoLinkData.get(0).getImg_Azimuth());
                jsonObject.put("img_Distance",  transmissionNoLinkData.get(0).getImg_Distance());
                jsonObject.put("img_AntennaHeight",  transmissionNoLinkData.get(0).getImg_AntennaHeight());
                jsonObject.put("img_Altitude",  transmissionNoLinkData.get(0).getImg_Altitude());

                jsonObject.put("transmissionNoLink_name", transmissionNoLinkData.get(0).getTransmissionNoLink_name());
            //    jsonObject.put("date", transmissionNoLinkData.get(0).getDate());
                jsonObject.put("flag", transmissionNoLinkData.get(0).getFlag());

                jsonObject.put("siteid", sharedPreferences.getString(AppConstants.SITEID));
                jsonObject.put("date", sharedPreferences.getString(AppConstants.DATE));
                jsonObject.put("empid", sharedPreferences.getString(AppConstants.EMPID));
                jsonObject.put("idall", sharedPreferences.getString(AppConstants.surveytpeandcustomerandoperator));



            } catch (Exception e) {
                Log.e("Exception", e.toString());
            }
        }
        return jsonObject;
    }

    private void toSendDataTransmissionNoLink4(String secname) {
        //  +"?Loginid="+empId+"&password="+empPassword+"&imeno="+"1234567890"
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        pDialog.show();
        Log.v("jsonobjectTransNoLink 4", jsondataTransmissionNoLinkDetail4(secname).toString());
        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.Transmission_No_Link, jsondataTransmissionNoLinkDetail4(secname),
                new Response.Listener<JSONArray>() {


                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponseTransmissionNoLink4(response.toString());
                        Log.v("res transmisiionNoLink4", response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("res TransNoLink 4", error.toString());
                pDialog.hide();
            }

        });
        jsonObjReq.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });

        AppSingleton.getInstance(getActivity()).addToRequestQueue(jsonObjReq, null);
    }

    private void parseSettingResponseTransmissionNoLink4(String s) {
        try {
            JSONArray jsonArray = new JSONArray(s);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String status = jsonObject.getString("Status");
            Toast.makeText(getActivity(), status + "NoLink4", Toast.LENGTH_LONG).show();
            tv_show_status.append("NoLink4 :" + status + "\n");
            // String password = jsonObject.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //..........................TransmissionNoLink  5
    private JSONObject jsondataTransmissionNoLinkDetail5(String secname) {
        JSONObject jsonObject = new JSONObject();
        List<TransmissionNoLinkData> transmissionNoLinkData = db.getLastTransmissionNOLink (secname);
        if (transmissionNoLinkData.size() > 0) {
            Log.v("OtherFragTransNoLink 5", transmissionNoLinkData.toString());
            try {
                jsonObject.put("edt_Sitename",  transmissionNoLinkData.get(0).getEdt_Sitename());
                jsonObject.put("edt_ObstructionDetails",  transmissionNoLinkData.get(0).getEdt_ObstructionDetails());
                jsonObject.put("edt_Azimuth",  transmissionNoLinkData.get(0).getEdt_Azimuth());
                jsonObject.put("edt_Distance",  transmissionNoLinkData.get(0).getEdt_Distance());
                jsonObject.put("edt_AntennaHeight",  transmissionNoLinkData.get(0).getEdt_AntennaHeight());
                jsonObject.put("edt_Altitude",  transmissionNoLinkData.get(0).getEdt_Altitude());
                jsonObject.put("img_SiteID",  transmissionNoLinkData.get(0).getImg_SiteID());
                jsonObject.put("img_Sitename",  transmissionNoLinkData.get(0).getImg_Sitename());
                jsonObject.put("img_ObstructionDetails",  transmissionNoLinkData.get(0).getImg_ObstructionDetails());
                jsonObject.put("img_Azimuth",  transmissionNoLinkData.get(0).getImg_Azimuth());
                jsonObject.put("img_Distance",  transmissionNoLinkData.get(0).getImg_Distance());
                jsonObject.put("img_AntennaHeight",  transmissionNoLinkData.get(0).getImg_AntennaHeight());
                jsonObject.put("img_Altitude",  transmissionNoLinkData.get(0).getImg_Altitude());

                jsonObject.put("transmissionNoLink_name", transmissionNoLinkData.get(0).getTransmissionNoLink_name());
            //    jsonObject.put("date", transmissionNoLinkData.get(0).getDate());
                jsonObject.put("flag", transmissionNoLinkData.get(0).getFlag());

                jsonObject.put("siteid", sharedPreferences.getString(AppConstants.SITEID));
                jsonObject.put("date", sharedPreferences.getString(AppConstants.DATE));
                jsonObject.put("empid", sharedPreferences.getString(AppConstants.EMPID));
                jsonObject.put("idall", sharedPreferences.getString(AppConstants.surveytpeandcustomerandoperator));




            } catch (Exception e) {
                Log.e("Exception", e.toString());
            }
        }
        return jsonObject;
    }

    private void toSendDataTransmissionNoLink5(String secname) {
        //  +"?Loginid="+empId+"&password="+empPassword+"&imeno="+"1234567890"
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        pDialog.show();
        Log.v("jsonobjectTransNoLink 5", jsondataTransmissionNoLinkDetail5(secname).toString());
        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.Transmission_No_Link, jsondataTransmissionNoLinkDetail1(secname),
                new Response.Listener<JSONArray>() {


                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponseTransmissionNoLink5(response.toString());
                        Log.v("res transmisiionNoLink5", response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("res TransNoLink 5", error.toString());
                pDialog.hide();
            }

        });
        jsonObjReq.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });

        AppSingleton.getInstance(getActivity()).addToRequestQueue(jsonObjReq, null);
    }

    private void parseSettingResponseTransmissionNoLink5(String s) {
        try {
            JSONArray jsonArray = new JSONArray(s);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String status = jsonObject.getString("Status");
            Toast.makeText(getActivity(), status + "NoLink5", Toast.LENGTH_LONG).show();
            tv_show_status.append("NoLink5 :" + status + "\n");
            // String password = jsonObject.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //..........................TransmissionNoLink  6
    private JSONObject jsondataTransmissionNoLinkDetail6(String secname) {
        JSONObject jsonObject = new JSONObject();
        List<TransmissionNoLinkData> transmissionNoLinkData = db.getLastTransmissionNOLink (secname);
        if (transmissionNoLinkData.size() > 0) {
            Log.v("OtherFragTransNoLink 6", transmissionNoLinkData.toString());
            try {
                jsonObject.put("edt_Sitename",  transmissionNoLinkData.get(0).getEdt_Sitename());
                jsonObject.put("edt_ObstructionDetails",  transmissionNoLinkData.get(0).getEdt_ObstructionDetails());
                jsonObject.put("edt_Azimuth",  transmissionNoLinkData.get(0).getEdt_Azimuth());
                jsonObject.put("edt_Distance",  transmissionNoLinkData.get(0).getEdt_Distance());
                jsonObject.put("edt_AntennaHeight",  transmissionNoLinkData.get(0).getEdt_AntennaHeight());
                jsonObject.put("edt_Altitude",  transmissionNoLinkData.get(0).getEdt_Altitude());
                jsonObject.put("img_SiteID",  transmissionNoLinkData.get(0).getImg_SiteID());
                jsonObject.put("img_Sitename",  transmissionNoLinkData.get(0).getImg_Sitename());
                jsonObject.put("img_ObstructionDetails",  transmissionNoLinkData.get(0).getImg_ObstructionDetails());
                jsonObject.put("img_Azimuth",  transmissionNoLinkData.get(0).getImg_Azimuth());
                jsonObject.put("img_Distance",  transmissionNoLinkData.get(0).getImg_Distance());
                jsonObject.put("img_AntennaHeight",  transmissionNoLinkData.get(0).getImg_AntennaHeight());
                jsonObject.put("img_Altitude",  transmissionNoLinkData.get(0).getImg_Altitude());

                jsonObject.put("transmissionNoLink_name", transmissionNoLinkData.get(0).getTransmissionNoLink_name());
            //    jsonObject.put("date", transmissionNoLinkData.get(0).getDate());
                jsonObject.put("flag", transmissionNoLinkData.get(0).getFlag());

                jsonObject.put("siteid", sharedPreferences.getString(AppConstants.SITEID));
                jsonObject.put("date", sharedPreferences.getString(AppConstants.DATE));
                jsonObject.put("empid", sharedPreferences.getString(AppConstants.EMPID));
                jsonObject.put("idall", sharedPreferences.getString(AppConstants.surveytpeandcustomerandoperator));



            } catch (Exception e) {
                Log.e("Exception", e.toString());
            }
        }
        return jsonObject;
    }

    private void toSendDataTransmissionNoLink6(String secname) {
        //  +"?Loginid="+empId+"&password="+empPassword+"&imeno="+"1234567890"
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        pDialog.show();
        Log.v("jsonobjectTransNoLink6", jsondataTransmissionNoLinkDetail6(secname).toString());
        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.Transmission_No_Link, jsondataTransmissionNoLinkDetail6(secname),
                new Response.Listener<JSONArray>() {


                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponseTransmissionNoLink6(response.toString());
                        Log.v("res transmisiionNoLink6", response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("resTransmissionNoLink6", error.toString());
                pDialog.hide();
            }

        });
        jsonObjReq.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });

        AppSingleton.getInstance(getActivity()).addToRequestQueue(jsonObjReq, null);
    }

    private void parseSettingResponseTransmissionNoLink6(String s) {
        try {
            JSONArray jsonArray = new JSONArray(s);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String status = jsonObject.getString("Status");
            Toast.makeText(getActivity(), status + "NoLink6", Toast.LENGTH_LONG).show();
            tv_show_status.append("NoLink6 :" + status + "\n");
            // String password = jsonObject.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    //......................................Start SitePanaromic........................
    private JSONObject jsondataSitePanaromic() {
        JSONObject jsonObject = new JSONObject();
        List<SitePanoramicData> sitePanoramicData = db.getLastSitePanaromicData();
        List<SitePanoramicBlockingData> sitePanoramicBlockingData = db.getLastSitePanaromicBlockingData();
        try {
            jsonObject.put("tvBearing0", sitePanoramicData.get(0).getTvBearing0());
            jsonObject.put("tvBearing30", sitePanoramicData.get(0).getTvBearing30());
            jsonObject.put("tvBearing60", sitePanoramicData.get(0).getTvBearing60());
            jsonObject.put("tvBearing90", sitePanoramicData.get(0).getTvBearing90());
            jsonObject.put("tvBearing120", sitePanoramicData.get(0).getTvBearing120());
            jsonObject.put("tvBearing150", sitePanoramicData.get(0).getTvBearing150());
            jsonObject.put("tvBearing180", sitePanoramicData.get(0).getTvBearing180());
            jsonObject.put("tvBearing210", sitePanoramicData.get(0).getTvBearing210());
            jsonObject.put("tvBearing240", sitePanoramicData.get(0).getTvBearing240());
            jsonObject.put("tvBearing270", sitePanoramicData.get(0).getTvBearing270());
            jsonObject.put("tvBearing300", sitePanoramicData.get(0).getTvBearing300());
            jsonObject.put("tvBearing330", sitePanoramicData.get(0).getTvBearing330());

            if(!sitePanoramicData.get(0).getBtnBearing0Image().equals("")){
                jsonObject.put("btnBearing0Image", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePanoramicData.get(0).getBtnBearing0Image()), Bitmap.CompressFormat.JPEG, 100));
            }
            else{
                jsonObject.put("btnBearing0Image",sitePanoramicData.get(0).getBtnBearing0Image() );
            }

         //   jsonObject.put("btnBearing30Image", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePanoramicData.get(0).getBtnBearing30Image()), Bitmap.CompressFormat.JPEG, 100));
            if(!sitePanoramicData.get(0).getBtnBearing30Image().equals("")){
                jsonObject.put("btnBearing30Image", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePanoramicData.get(0).getBtnBearing30Image()), Bitmap.CompressFormat.JPEG, 100));
            }
            else{
                jsonObject.put("btnBearing30Image",sitePanoramicData.get(0).getBtnBearing30Image() );
            }
           // jsonObject.put("btnBearing60Image", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePanoramicData.get(0).getBtnBearing60Image()), Bitmap.CompressFormat.JPEG, 100));
            if(!sitePanoramicData.get(0).getBtnBearing60Image().equals("")){
                jsonObject.put("btnBearing60Image", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePanoramicData.get(0).getBtnBearing60Image()), Bitmap.CompressFormat.JPEG, 100));
            }
            else{
                jsonObject.put("btnBearing60Image",sitePanoramicData.get(0).getBtnBearing60Image() );
            }
           // jsonObject.put("btnBearing90Image", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePanoramicData.get(0).getBtnBearing90Image()), Bitmap.CompressFormat.JPEG, 100));
            if(!sitePanoramicData.get(0).getBtnBearing90Image().equals("")){
                jsonObject.put("btnBearing90Image", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePanoramicData.get(0).getBtnBearing90Image()), Bitmap.CompressFormat.JPEG, 100));
            }
            else{
                jsonObject.put("btnBearing90Image",sitePanoramicData.get(0).getBtnBearing90Image() );
            }
        //    jsonObject.put("btnBearing120Image", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePanoramicData.get(0).getBtnBearing120Image()), Bitmap.CompressFormat.JPEG, 100));
            if(!sitePanoramicData.get(0).getBtnBearing120Image().equals("")){
                jsonObject.put("btnBearing120Image", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePanoramicData.get(0).getBtnBearing120Image()), Bitmap.CompressFormat.JPEG, 100));
            }
            else{
                jsonObject.put("btnBearing120Image",sitePanoramicData.get(0).getBtnBearing120Image() );
            }
           // jsonObject.put("btnBearing150Image", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePanoramicData.get(0).getBtnBearing150Image()), Bitmap.CompressFormat.JPEG, 100));
            if(!sitePanoramicData.get(0).getBtnBearing150Image().equals("")){
                jsonObject.put("btnBearing150Image", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePanoramicData.get(0).getBtnBearing150Image()), Bitmap.CompressFormat.JPEG, 100));
            }
            else{
                jsonObject.put("btnBearing150Image",sitePanoramicData.get(0).getBtnBearing150Image() );
            }
       //     jsonObject.put("btnBearing180Image", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePanoramicData.get(0).getBtnBearing180Image()), Bitmap.CompressFormat.JPEG, 100));
            if(!sitePanoramicData.get(0).getBtnBearing180Image().equals("")){
                jsonObject.put("btnBearing180Image", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePanoramicData.get(0).getBtnBearing180Image()), Bitmap.CompressFormat.JPEG, 100));
            }
            else{
                jsonObject.put("btnBearing180Image",sitePanoramicData.get(0).getBtnBearing180Image() );
            }
         //   jsonObject.put("btnBearing210Image", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePanoramicData.get(0).getBtnBearing210Image()), Bitmap.CompressFormat.JPEG, 100));
            if(!sitePanoramicData.get(0).getBtnBearing210Image().equals("")){
                jsonObject.put("btnBearing210Image", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePanoramicData.get(0).getBtnBearing210Image()), Bitmap.CompressFormat.JPEG, 100));
            }
            else{
                jsonObject.put("btnBearing210Image",sitePanoramicData.get(0).getBtnBearing210Image() );
            }
          //  jsonObject.put("btnBearing240Image", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePanoramicData.get(0).getBtnBearing240Image()), Bitmap.CompressFormat.JPEG, 100));
            if(!sitePanoramicData.get(0).getBtnBearing240Image().equals("")){
                jsonObject.put("btnBearing240Image", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePanoramicData.get(0).getBtnBearing240Image()), Bitmap.CompressFormat.JPEG, 100));
            }
            else{
                jsonObject.put("btnBearing240Image",sitePanoramicData.get(0).getBtnBearing240Image() );
            }
      //      jsonObject.put("btnBearing270Image", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePanoramicData.get(0).getBtnBearing270Image()), Bitmap.CompressFormat.JPEG, 100));
            if(!sitePanoramicData.get(0).getBtnBearing270Image().equals("")){
                jsonObject.put("btnBearing270Image", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePanoramicData.get(0).getBtnBearing270Image()), Bitmap.CompressFormat.JPEG, 100));
            }
            else{
                jsonObject.put("btnBearing270Image",sitePanoramicData.get(0).getBtnBearing270Image() );
            }
       //     jsonObject.put("btnBearing300Image", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePanoramicData.get(0).getBtnBearing300Image()), Bitmap.CompressFormat.JPEG, 100));
            if(!sitePanoramicData.get(0).getBtnBearing300Image().equals("")){
                jsonObject.put("btnBearing300Image", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePanoramicData.get(0).getBtnBearing300Image()), Bitmap.CompressFormat.JPEG, 100));
            }
            else{
                jsonObject.put("btnBearing300Image",sitePanoramicData.get(0).getBtnBearing300Image() );
            }
      //      jsonObject.put("btnBearing330Image", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePanoramicData.get(0).getBtnBearing330Image()), Bitmap.CompressFormat.JPEG, 100));
            if(!sitePanoramicData.get(0).getBtnBearing330Image().equals("")){
                jsonObject.put("btnBearing330Image", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePanoramicData.get(0).getBtnBearing330Image()), Bitmap.CompressFormat.JPEG, 100));
            }
            else{
                jsonObject.put("btnBearing330Image",sitePanoramicData.get(0).getBtnBearing330Image() );
            }
            jsonObject.put("inputBearin_extra1", sitePanoramicData.get(0).getInputBearin_extra1());
            jsonObject.put("inputBearin_extra2", sitePanoramicData.get(0).getInputBearin_extra2());
            jsonObject.put("inputBearin_remark1", sitePanoramicData.get(0).getInputBearin_remark1());
            jsonObject.put("inputBearin_remark2", sitePanoramicData.get(0).getInputBearin_remark2());
            jsonObject.put("flag", sitePanoramicData.get(0).getFlag());
            //  jsonObject.put("date", sitePanoramicData.get(0).getDate());

            jsonObject.put("date", sharedPreferences.getString(AppConstants.DATE));
            jsonObject.put("empid", sharedPreferences.getString(AppConstants.EMPID));
            jsonObject.put("siteid", sharedPreferences.getString(AppConstants.SITEID));
            jsonObject.put("idall", sharedPreferences.getString(AppConstants.surveytpeandcustomerandoperator));
            //..................sitepanoramicBlocking................
            jsonObject.put("blocking0", sitePanoramicBlockingData.get(0).getBlocking0());
            jsonObject.put("blocking30", sitePanoramicBlockingData.get(0).getBlocking30());
            jsonObject.put("blocking60", sitePanoramicBlockingData.get(0).getBlocking60());
            jsonObject.put("blocking90", sitePanoramicBlockingData.get(0).getBlocking90());
            jsonObject.put("blocking120", sitePanoramicBlockingData.get(0).getBlocking120());
            jsonObject.put("blocking150", sitePanoramicBlockingData.get(0).getBlocking150());
            jsonObject.put("blocking180", sitePanoramicBlockingData.get(0).getBlocking180());
            jsonObject.put("blocking210", sitePanoramicBlockingData.get(0).getBlocking210());
            jsonObject.put("blocking240", sitePanoramicBlockingData.get(0).getBlocking240());
            jsonObject.put("blocking270", sitePanoramicBlockingData.get(0).getBlocking270());
            jsonObject.put("blocking300", sitePanoramicBlockingData.get(0).getBlocking300());
            jsonObject.put("blocking330", sitePanoramicBlockingData.get(0).getBlocking330());
            // jsonObject.put("flag", sitePanoramicBlockingData.get(0).getFlag());
        } catch (Exception e) {


        }
        return jsonObject;
    }

    private void toSendDataSitePanaromic() {
        //  +"?Loginid="+empId+"&password="+empPassword+"&imeno="+"1234567890"
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        pDialog.show();
        Log.v("jsonsitepanaromic", jsondataSitePanaromic().toString());
        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.SITEPANAROMIC, jsondataSitePanaromic(),
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponseSitePanaromic(response.toString());
                        Log.v(" response_sitepanaromic", response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("res errorsitepanaramic", error.toString());
                pDialog.hide();
            }

        });
        jsonObjReq.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });

        AppSingleton.getInstance(getActivity()).addToRequestQueue(jsonObjReq, null);
    }

    private void parseSettingResponseSitePanaromic(String s) {
        try {
            JSONArray jsonArray = new JSONArray(s);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String status = jsonObject.getString("Status");
            Toast.makeText(getActivity(), status + " Site Panaromic", Toast.LENGTH_LONG).show();
            tv_show_status.append("Site Panaromic :" + status + "\n");
            // String password = jsonObject.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //......................................Start OtherDetail........................
    private JSONObject jsondataLosPhotos() {
        JSONObject jsonObject = new JSONObject();
        List<LosPhotoData> losPhotoData = db.getLastLosPhotos();
        try {
            jsonObject.put("NearEndFarEndphoto1", losPhotoData.get(0).getNearEndFarEndphoto1());
            jsonObject.put("FarEndtoNearEndphoto1", losPhotoData.get(0).getFarEndtoNearEndphoto1());
            jsonObject.put("TowerPhoto1", losPhotoData.get(0).getTowerPhoto1());
            jsonObject.put("NearEndtoFarEndphoto2", losPhotoData.get(0).getNearEndtoFarEndphoto2());
            jsonObject.put("FarEndNearEndphoto2", losPhotoData.get(0).getFarEndNearEndphoto2());
            jsonObject.put("TowerPhoto2", losPhotoData.get(0).getTowerPhoto2());
            jsonObject.put("NearEndFarEndphoto3", losPhotoData.get(0).getNearEndFarEndphoto3());
            jsonObject.put("FarEndtoNearEndphoto3", losPhotoData.get(0).getFarEndtoNearEndphoto3());
            jsonObject.put("TowerPhoto3", losPhotoData.get(0).getTowerPhoto3());
            jsonObject.put("NearEndtoFarEndphoto4", losPhotoData.get(0).getNearEndtoFarEndphoto4());
            jsonObject.put("FarEndtoNearEndphoto4", losPhotoData.get(0).getFarEndtoNearEndphoto4());
            jsonObject.put("TowerPhoto4", losPhotoData.get(0).getTowerPhoto4());
            // jsonObject.put("date", losPhotoData.get(0).getDate());
            jsonObject.put("flag", losPhotoData.get(0).getFlag());
            jsonObject.put("date", sharedPreferences.getString(AppConstants.DATE));
            jsonObject.put("empid", sharedPreferences.getString(AppConstants.EMPID));
            jsonObject.put("siteid", sharedPreferences.getString(AppConstants.SITEID));
            jsonObject.put("idall", sharedPreferences.getString(AppConstants.surveytpeandcustomerandoperator));


        } catch (Exception e) {


        }
        return jsonObject;
    }

    private void toSendDataLosPhotos() {
        //  +"?Loginid="+empId+"&password="+empPassword+"&imeno="+"1234567890"
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        pDialog.show();
        Log.v("jsonlosphotos", jsondataLosPhotos().toString());
        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.Los_Photos, jsondataLosPhotos(),
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponselosPhotos(response.toString());
                        Log.v(" res_losphotodetail", response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("reserror_losphotodetail", error.toString());
                pDialog.hide();
            }

        });
        jsonObjReq.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });

        AppSingleton.getInstance(getActivity()).addToRequestQueue(jsonObjReq, null);
    }

    private void parseSettingResponselosPhotos(String s) {
        try {
            JSONArray jsonArray = new JSONArray(s);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String status = jsonObject.getString("Status");
            Toast.makeText(getActivity(), status + "los Detail", Toast.LENGTH_LONG).show();
            tv_show_status.append("los Detail :" + status + "\n");
            // String password = jsonObject.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//..................................

    //......................................Start OtherDetail........................
    private JSONObject jsondataOtherDetail() {
        JSONObject jsonObject = new JSONObject();
        List<OtherDetailData> otherDetailData = db.getLastOtherdetaiData();
        try {
            jsonObject.put("edtRiggerPic", otherDetailData.get(0).getEdtRiggerPic());
            jsonObject.put("edtEngineerPic", otherDetailData.get(0).getEdtEngineerPic());
            jsonObject.put("edtCarPic", otherDetailData.get(0).getEdtCarPic());
            jsonObject.put("edt_RiggerPicwithclimbingTower", otherDetailData.get(0).getEdt_RiggerPicwithclimbingTower());
            jsonObject.put("edtRiggerPicduringWah", otherDetailData.get(0).getEdtRiggerPicduringWah());
            jsonObject.put("iv_RiggerPic", otherDetailData.get(0).getIv_RiggerPic());
            jsonObject.put("iv_EngineerPic", otherDetailData.get(0).getIv_EngineerPic());
            jsonObject.put("iv_CarPic", otherDetailData.get(0).getIv_CarPic());
            jsonObject.put("iv_RiggerPicwithclimbingTower", otherDetailData.get(0).getIv_RiggerPicwithclimbingTower());
            jsonObject.put("iv_RiggerPicduringWah", otherDetailData.get(0).getIv_RiggerPicduringWah());
            // jsonObject.put("date", otherDetailData.get(0).getDate());
            jsonObject.put("flag", otherDetailData.get(0).getFlag());
            jsonObject.put("date", sharedPreferences.getString(AppConstants.DATE));
            jsonObject.put("empid", sharedPreferences.getString(AppConstants.EMPID));
            jsonObject.put("siteid", sharedPreferences.getString(AppConstants.SITEID));
            jsonObject.put("idall", sharedPreferences.getString(AppConstants.surveytpeandcustomerandoperator));


        } catch (Exception e) {


        }
        return jsonObject;
    }

    private void toSendDataOtherDetail() {
        //  +"?Loginid="+empId+"&password="+empPassword+"&imeno="+"1234567890"
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        pDialog.show();
        Log.v("jsonotherdetail", jsondataOtherDetail().toString());
        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.OTHERDETAIL, jsondataOtherDetail(),
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponseOtherDetail(response.toString());
                        Log.v(" response_otherdetail", response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("res error_otherdetail", error.toString());
                pDialog.hide();
            }

        });
        jsonObjReq.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });

        AppSingleton.getInstance(getActivity()).addToRequestQueue(jsonObjReq, null);
    }

    private void parseSettingResponseOtherDetail(String s) {
        try {
            JSONArray jsonArray = new JSONArray(s);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String status = jsonObject.getString("Status");
            Toast.makeText(getActivity(), status + "Other Detail", Toast.LENGTH_LONG).show();
            tv_show_status.append("Other Detail :" + status + "\n");
            // String password = jsonObject.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//.................................................................................

    private JSONObject jsonDataAll() {

        List<SurveyForm> surveyformData = db.getLastSurveyformData();
        if (surveyformData.size() > 0) {
            Log.v("OtherFragSurveyform", surveyformData.toString());
        }
        List<SiteDetailForm> siteDetailData = db.getLastSiteDetailData();
        if (siteDetailData.size() > 0) {
            Log.v("OtherFragSiteDetail", siteDetailData.toString());
        }
        List<SectorDetailData> sectorDetailData = db.getLastSectorDetailData();
        if (sectorDetailData.size() > 0) {
            Log.v("OtherFragSectorDetail", sectorDetailData.toString());
        }

        List<SitePanoramicData> sitePanoramicData = db.getLastSitePanaromicData();
        List<SitePanoramicBlockingData> sitePanoramicBlockingData = db.getLastSitePanaromicBlockingData();
        List<OtherDetailData> otherDetailData = db.getLastOtherdetaiData();
        if (otherDetailData.size() > 0) {
            Log.v("OtherFragotherDetail", otherDetailData.toString());
        }

        JSONObject jsonObject = new JSONObject();
        try {
// survey aduit detail.....................................................................//
            jsonObject.put("", surveyformData.get(0).getSurveytype());
            jsonObject.put("", surveyformData.get(0).getCustomer());
            jsonObject.put("", surveyformData.get(0).getOperator());
            jsonObject.put("", surveyformData.get(0).getCircle());
            jsonObject.put("", surveyformData.get(0).getTechnology());
            jsonObject.put("", surveyformData.get(0).getTechnologytype());
            jsonObject.put("", surveyformData.get(0).getLocation());
            jsonObject.put("", surveyformData.get(0).getSiteid());
            jsonObject.put("", surveyformData.get(0).getDate());
            jsonObject.put("", surveyformData.get(0).getLat());
            jsonObject.put("", surveyformData.get(0).getLog());
            jsonObject.put("", surveyformData.get(0).getFlag());
// site Detail detail.....................................................................//
            jsonObject.put("", siteDetailData.get(0).getSiteid());
            jsonObject.put("", siteDetailData.get(0).getSiteid_photo());
            jsonObject.put("", siteDetailData.get(0).getSitename());
            jsonObject.put("", siteDetailData.get(0).getSitename_photo());
            jsonObject.put("", siteDetailData.get(0).getTowersiteid());
            jsonObject.put("", siteDetailData.get(0).getTowersiteid_photo());
            jsonObject.put("", siteDetailData.get(0).getTowercompanyname());
            jsonObject.put("", siteDetailData.get(0).getTowercompanyname__photo());
            jsonObject.put("", siteDetailData.get(0).getSiteaddress());
            jsonObject.put("", siteDetailData.get(0).getSiteaddress_photo());
            jsonObject.put("", siteDetailData.get(0).getSectorid());
            jsonObject.put("", siteDetailData.get(0).getSectorid_photo());
            jsonObject.put("", siteDetailData.get(0).getLat());
            jsonObject.put("", siteDetailData.get(0).getLog());
            jsonObject.put("", siteDetailData.get(0).getSitetype());
            jsonObject.put("", siteDetailData.get(0).getSitetype_photo());
            jsonObject.put("", siteDetailData.get(0).getBuildingfloor());
            jsonObject.put("", siteDetailData.get(0).getBuildingfloor_photo());
            jsonObject.put("", siteDetailData.get(0).getBuildingheight());
            jsonObject.put("", siteDetailData.get(0).getBuildingheight_photo());
            jsonObject.put("", siteDetailData.get(0).getTowerheight());
            jsonObject.put("", siteDetailData.get(0).getTowerheight_photo());
            jsonObject.put("", siteDetailData.get(0).getFulltowerphoto());
            jsonObject.put("", siteDetailData.get(0).getFulltowerphoto_photo());
            jsonObject.put("", siteDetailData.get(0).getNodebtype());
            jsonObject.put("", siteDetailData.get(0).getNodebtype_photo());
            jsonObject.put("", siteDetailData.get(0).getClassical());
            jsonObject.put("", siteDetailData.get(0).getClassical_photo());
            jsonObject.put("", siteDetailData.get(0).getEnodebtype());
            jsonObject.put("", siteDetailData.get(0).getEnodebtype_photo());
            jsonObject.put("", siteDetailData.get(0).getAnchoroperator());
            jsonObject.put("", siteDetailData.get(0).getAnchoroperator_photo());
            jsonObject.put("", siteDetailData.get(0).getSharingopco1());
            jsonObject.put("", siteDetailData.get(0).getSharingopco1_photo());
            jsonObject.put("", siteDetailData.get(0).getSharingopco2());
            jsonObject.put("", siteDetailData.get(0).getSharingopco2_photo());
            jsonObject.put("", siteDetailData.get(0).getSharingopco3());
            jsonObject.put("", siteDetailData.get(0).getSharingopco3_photo());
            jsonObject.put("", siteDetailData.get(0).getInfraprovider());
            jsonObject.put("", siteDetailData.get(0).getInfraprovider_photo());
            jsonObject.put("", siteDetailData.get(0).getType_id_od());
            jsonObject.put("", siteDetailData.get(0).getType_id_od_photo());
            jsonObject.put("", siteDetailData.get(0).getInfrashared());
            jsonObject.put("", siteDetailData.get(0).getInfrashared_photo());
            jsonObject.put("", siteDetailData.get(0).getExtra1());
            jsonObject.put("", siteDetailData.get(0).getExtra1_photo());
            jsonObject.put("", siteDetailData.get(0).getExtra2());
            jsonObject.put("", siteDetailData.get(0).getExtra2_photo());
            jsonObject.put("", siteDetailData.get(0).getRemark1());
            jsonObject.put("", siteDetailData.get(0).getRemark1_photo());
            jsonObject.put("", siteDetailData.get(0).getRemark2());
            jsonObject.put("", siteDetailData.get(0).getRemark2_photo());
            jsonObject.put("", siteDetailData.get(0).getFlag());
            jsonObject.put("", siteDetailData.get(0).getDate());
// sector Detail detail.....................................................................//
            jsonObject.put("sectordetail_edt_techavailable", sectorDetailData.get(0).getSectordetail_edt_techavailable());
            jsonObject.put("sectordetail_img_techavailable", sectorDetailData.get(0).getSectordetail_img_techavailable());
            jsonObject.put("sectordetail_edt_bandavailable", sectorDetailData.get(0).getSectordetail_edt_bandavailable());
            jsonObject.put("sectordeatail_img_bandavailable", sectorDetailData.get(0).getSectordeatail_img_bandavailable());
            jsonObject.put("sectordeatail_edt_APC", sectorDetailData.get(0).getSectordeatail_edt_APC());
            jsonObject.put("sectordeatail_img_APC", sectorDetailData.get(0).getSectordeatail_img_APC());
            jsonObject.put("sectoreatail_edt_preazimuth", sectorDetailData.get(0).getSectoreatail_edt_preazimuth());
            jsonObject.put("sectordeatail_img_preazimuth", sectorDetailData.get(0).getSectordeatail_img_preazimuth());
            jsonObject.put("sectordeatail_edt_postazimuth", sectorDetailData.get(0).getSectordeatail_edt_postazimuth());
            jsonObject.put("sectordeatail_img_postazimuth", sectorDetailData.get(0).getSectordeatail_img_postazimuth());
            jsonObject.put("sectordeatail_edt_premechanical_tilt", sectorDetailData.get(0).getSectordeatail_edt_premechanical_tilt());
            jsonObject.put("sectordeatail_img_premechanical_tilt", sectorDetailData.get(0).getSectordeatail_img_premechanical_tilt());
            jsonObject.put("sectordeatail_edt_postmechanical_tilt", sectorDetailData.get(0).getSectordeatail_edt_postmechanical_tilt());
            jsonObject.put("sectordeatail_img_postmechanical_tilt", sectorDetailData.get(0).getSectordeatail_img_postmechanical_tilt());
            jsonObject.put("sectordeatail_edt_preelectrical_tilt2g", sectorDetailData.get(0).getSectordeatail_edt_preelectrical_tilt2g());
            jsonObject.put("sectordeatail_img_preelectrical_tilt2g", sectorDetailData.get(0).getSectordeatail_img_preelectrical_tilt2g());
            jsonObject.put("sectordeatail_edt_postelectrical_tilt2g", sectorDetailData.get(0).getSectordeatail_edt_postelectrical_tilt2g());
            jsonObject.put("sectordeatail_img_postelectrical_tilt2g", sectorDetailData.get(0).getSectordeatail_img_postelectrical_tilt2g());
            jsonObject.put("sectordeatail_edt_preelectrical_tilt3g", sectorDetailData.get(0).getSectordeatail_edt_preelectrical_tilt3g());
            jsonObject.put("sectordeatail_img_pretelectrical_tilt3g", sectorDetailData.get(0).getSectordeatail_img_pretelectrical_tilt3g());
            jsonObject.put("sectordeatail_edt_postelectrical_tilt3g", sectorDetailData.get(0).getSectordeatail_edt_postelectrical_tilt3g());
            jsonObject.put("sectordeatail_img_postelectrical_tilt3g", sectorDetailData.get(0).getSectordeatail_img_postelectrical_tilt3g());
            jsonObject.put("sectordeatail_edt_preelectrical_tilt4gf1", sectorDetailData.get(0).getSectordeatail_edt_preelectrical_tilt4gf1());
            jsonObject.put("sectordeatail_img_preelectrical_tilt4gf1", sectorDetailData.get(0).getSectordeatail_img_preelectrical_tilt4gf1());
            jsonObject.put("sectordeatail_edt_postelectrical_tilt4gf1", sectorDetailData.get(0).getSectordeatail_edt_postelectrical_tilt4gf1());
            jsonObject.put("sectordeatail_img_postelectrical_tilt4gf1", sectorDetailData.get(0).getSectordeatail_img_postelectrical_tilt4gf1());
            jsonObject.put("sectordeatail_edt_preelectrical_tilt4gf2", sectorDetailData.get(0).getSectordeatail_edt_preelectrical_tilt4gf2());
            jsonObject.put("sectordeatail_img_preelectrical_tilt4gf2", sectorDetailData.get(0).getSectordeatail_img_preelectrical_tilt4gf2());
            jsonObject.put("sectordeatail_edt_postelectrical_tilt4gf2", sectorDetailData.get(0).getSectordeatail_edt_postelectrical_tilt4gf2());
            jsonObject.put("sectordeatail_img_postelectrical_tilt4gf2", sectorDetailData.get(0).getSectordeatail_img_postelectrical_tilt4gf2());
            jsonObject.put("sectordeatail_edt_preelectrical_tilt", sectorDetailData.get(0).getSectordeatail_edt_preelectrical_tilt());
            jsonObject.put("sectordeatail_img_preelectrical_tilt", sectorDetailData.get(0).getSectordeatail_img_preelectrical_tilt());
            jsonObject.put("sectordeatail_edt_postelectrical_tilt", sectorDetailData.get(0).getSectordeatail_edt_postelectrical_tilt());
            jsonObject.put("sectordeatail_img_postelectrical_tilt", sectorDetailData.get(0).getSectordeatail_img_postelectrical_tilt());
            jsonObject.put("sectordeatail_edt_antennaheight", sectorDetailData.get(0).getSectordeatail_edt_antennaheight());
            jsonObject.put("sectordeatail_img_antennaheight", sectorDetailData.get(0).getSectordeatail_img_antennaheight());
            jsonObject.put("sectordeatail_edt_poleheight", sectorDetailData.get(0).getSectordeatail_edt_poleheight());
            jsonObject.put("sectordeatail_img_poleheight", sectorDetailData.get(0).getSectordeatail_img_poleheight());
            jsonObject.put("sectordeatail_edt_buildingheight", sectorDetailData.get(0).getSectordeatail_edt_buildingheight());
            jsonObject.put("sectordeatail_img_buildingheight", sectorDetailData.get(0).getSectordeatail_img_buildingheight());
            jsonObject.put("sectordeatail_edt_towertype", sectorDetailData.get(0).getSectordeatail_edt_towertype());
            jsonObject.put("sectordeatail_img_towertype", sectorDetailData.get(0).getSectordeatail_img_towertype());
            jsonObject.put("sectordeatail_edt_antennamake", sectorDetailData.get(0).getSectordeatail_edt_antennamake());
            jsonObject.put("sectordeatail_img_antennamake", sectorDetailData.get(0).getSectordeatail_img_antennamake());
            jsonObject.put("sectordeatail_edt_antenmodel", sectorDetailData.get(0).getSectordeatail_edt_antenmodel());
            jsonObject.put("sectordeatail_img_antennamodel", sectorDetailData.get(0).getSectordeatail_img_antennamodel());
            jsonObject.put("sectordeatail_edt_clutterpic", sectorDetailData.get(0).getSectordeatail_edt_clutterpic());
            jsonObject.put("sectordeatail_img_clutterpic", sectorDetailData.get(0).getSectordeatail_img_clutterpic());
            jsonObject.put("sectordeatail_edt_txbandwidth", sectorDetailData.get(0).getSectordeatail_edt_txbandwidth());
            jsonObject.put("sectordeatail_img_txbandwidth", sectorDetailData.get(0).getSectordeatail_img_txbandwidth());
            jsonObject.put("sectordeatail_edt_AST", sectorDetailData.get(0).getSectordeatail_edt_AST());
            jsonObject.put("sectordeatail_img_AST", sectorDetailData.get(0).getSectordeatail_img_AST());
            jsonObject.put("sectordeatail_edt_APST", sectorDetailData.get(0).getSectordeatail_edt_APST());
            jsonObject.put("sectordeatail_img_APST", sectorDetailData.get(0).getSectordeatail_img_APST());
            jsonObject.put("sectordeatail_edt_typ_enodeb", sectorDetailData.get(0).getSectordeatail_edt_typ_enodeb());
            jsonObject.put("sectordeatail_img_typ_enodeb", sectorDetailData.get(0).getSectordeatail_img_typ_enodeb());
            jsonObject.put("sectordeatail_edt_mimo", sectorDetailData.get(0).getSectordeatail_edt_mimo());
            jsonObject.put("sectordeatail_img_mimo", sectorDetailData.get(0).getSectordeatail_img_mimo());
            jsonObject.put("sectordeatail_edt_ret", sectorDetailData.get(0).getSectordeatail_edt_ret());
            jsonObject.put("sectordeatail_img_ret", sectorDetailData.get(0).getSectordeatail_img_ret());
            jsonObject.put("sectordeatail_edt_enodebband", sectorDetailData.get(0).getSectordeatail_edt_enodebband());
            jsonObject.put("sectordeatail_img_enodebband", sectorDetailData.get(0).getSectordeatail_img_enodebband());
            jsonObject.put("sectordeatail_edt_MOP", sectorDetailData.get(0).getSectordeatail_edt_MOP());
            jsonObject.put("sectordeatail_img_MOP", sectorDetailData.get(0).getSectordeatail_img_MOP());
            jsonObject.put("sectordeatail_edt_COP", sectorDetailData.get(0).getSectordeatail_edt_COP());
            jsonObject.put("sectordeatail_img_COP", sectorDetailData.get(0).getSectordeatail_img_COP());
            jsonObject.put("sectordeatail_edt_multiplexer_avail", sectorDetailData.get(0).getSectordeatail_edt_multiplexer_avail());
            jsonObject.put("sectordeatail_img_multiplexer_avail", sectorDetailData.get(0).getSectordeatail_img_multiplexer_avail());
            jsonObject.put("sectordeatail_edt_antennapicleg", sectorDetailData.get(0).getSectordeatail_edt_antennapicleg());
            jsonObject.put("sectordeatail_img_antennapicleg", sectorDetailData.get(0).getSectordeatail_img_antennapicleg());
            jsonObject.put("sectordeatail_edt_CRP", sectorDetailData.get(0).getSectordeatail_edt_CRP());
            jsonObject.put("sectordeatail_img_CRP", sectorDetailData.get(0).getSectordeatail_img_CRP());
            jsonObject.put("sectordeatail_edt_powerdeboosting", sectorDetailData.get(0).getSectordeatail_edt_powerdeboosting());
            jsonObject.put("sectordeatail_img_powerdeboosting", sectorDetailData.get(0).getSectordeatail_img_powerdeboosting());
            jsonObject.put("sectordeatail_edt_DFS", sectorDetailData.get(0).getSectordeatail_edt_DFS());
            jsonObject.put("sectordeatail_img_DFS", sectorDetailData.get(0).getSectordeatail_img_DFS());
            jsonObject.put("sectordeatail_edt_rb_percell", sectorDetailData.get(0).getSectordeatail_edt_rb_percell());
            jsonObject.put("sectordeatail_img_rb_percell", sectorDetailData.get(0).getSectordeatail_img_rb_percell());
            jsonObject.put("sectordeatail_edt_m_mimo", sectorDetailData.get(0).getSectordeatail_edt_m_mimo());
            jsonObject.put("sectordeatail_img_m_mimo", sectorDetailData.get(0).getSectordeatail_img_m_mimo());
            jsonObject.put("sectordeatail_edt_FCT", sectorDetailData.get(0).getSectordeatail_edt_FCT());
            jsonObject.put("sectordeatail_img_FCT", sectorDetailData.get(0).getSectordeatail_img_FCT());
            jsonObject.put("sectordeatail_edt_JCT", sectorDetailData.get(0).getSectordeatail_edt_JCT());
            jsonObject.put("sectordeatail_img_JCT", sectorDetailData.get(0).getSectordeatail_img_JCT());
            jsonObject.put("sectordeatail_edt_FCL", sectorDetailData.get(0).getSectordeatail_edt_FCL());
            jsonObject.put("sectordeatail_img_FCL", sectorDetailData.get(0).getSectordeatail_img_FCL());
            jsonObject.put("sectordeatail_edt_jumperlength", sectorDetailData.get(0).getSectordeatail_edt_jumperlength());
            jsonObject.put("sectordeatail_img_jumperlength", sectorDetailData.get(0).getSectordeatail_img_jumperlength());
            jsonObject.put("sectordeatail_edt_prachconfig_index", sectorDetailData.get(0).getSectordeatail_edt_prachconfig_index());
            jsonObject.put("sectordeatail_img_prachconfig_index", sectorDetailData.get(0).getSectordeatail_img_prachconfig_index());
            jsonObject.put("sectordeatail_edt_carrieraggregation", sectorDetailData.get(0).getSectordeatail_edt_carrieraggregation());
            jsonObject.put("sectordeatail_img_carrieraggregation", sectorDetailData.get(0).getSectordeatail_img_carrieraggregation());
            jsonObject.put("sectordeatail_edt_ACD", sectorDetailData.get(0).getSectordeatail_edt_ACD());
            jsonObject.put("sectordeatail_img_ACD", sectorDetailData.get(0).getSectordeatail_img_ACD());
            jsonObject.put("sectordeatail_edt_VSWRtest", sectorDetailData.get(0).getSectordeatail_edt_VSWRtest());
            jsonObject.put("sectordeatail_img_VSWRtest", sectorDetailData.get(0).getSectordeatail_img_VSWRtest());
            jsonObject.put("sectordeatail_edt_URS", sectorDetailData.get(0).getSectordeatail_edt_URS());
            jsonObject.put("sectordeatail_img_URS", sectorDetailData.get(0).getSectordeatail_img_URS());
            jsonObject.put("sectordeatail_edt_extra1", sectorDetailData.get(0).getSectordeatail_edt_extra1());
            jsonObject.put("sectordeatail_img_extra1", sectorDetailData.get(0).getSectordeatail_img_extra1());
            jsonObject.put("sectordeatail_edt_extra2", sectorDetailData.get(0).getSectordeatail_edt_extra2());
            jsonObject.put("sectordeatail_img_extra2", sectorDetailData.get(0).getSectordeatail_img_extra2());
            jsonObject.put("sectordeatail_edt_remark1", sectorDetailData.get(0).getSectordeatail_edt_remak1());
            jsonObject.put("sectordeatail_img_remark1", sectorDetailData.get(0).getSectordeatail_img_remark1());
            jsonObject.put("sectordeatail_edt_remark2", sectorDetailData.get(0).getSectordeatail_edt_remak2());
            jsonObject.put("sectordeatail_img_remark2", sectorDetailData.get(0).getSectordeatail_img_remark2());
            jsonObject.put("sectordeatailfrgamentname", sectorDetailData.get(0).getSectordeatailfrgamentname());
            jsonObject.put("flag", sectorDetailData.get(0).getFlag());
            jsonObject.put("date", sectorDetailData.get(0).getDate());

// site panoramic....................................................................................
            jsonObject.put("tvBearing0", sitePanoramicData.get(0).getTvBearing0());
            jsonObject.put("tvBearing30", sitePanoramicData.get(0).getTvBearing30());
            jsonObject.put("tvBearing60", sitePanoramicData.get(0).getTvBearing60());
            jsonObject.put("tvBearing90", sitePanoramicData.get(0).getTvBearing90());
            jsonObject.put("tvBearing120", sitePanoramicData.get(0).getTvBearing120());
            jsonObject.put("tvBearing150", sitePanoramicData.get(0).getTvBearing150());
            jsonObject.put("tvBearing180", sitePanoramicData.get(0).getTvBearing180());
            jsonObject.put("tvBearing210", sitePanoramicData.get(0).getTvBearing210());
            jsonObject.put("tvBearing240", sitePanoramicData.get(0).getTvBearing240());
            jsonObject.put("tvBearing270", sitePanoramicData.get(0).getTvBearing270());
            jsonObject.put("tvBearing300", sitePanoramicData.get(0).getTvBearing300());
            jsonObject.put("tvBearing330", sitePanoramicData.get(0).getTvBearing330());
            jsonObject.put("inputBearin_extra1", sitePanoramicData.get(0).getInputBearin_extra1());
            jsonObject.put("inputBearin_extra2", sitePanoramicData.get(0).getInputBearin_extra2());
            jsonObject.put("inputBearin_remark1", sitePanoramicData.get(0).getInputBearin_remark1());
            jsonObject.put("inputBearin_remark2", sitePanoramicData.get(0).getInputBearin_remark2());
            jsonObject.put("flag", sitePanoramicData.get(0).getFlag());
            jsonObject.put("date", sitePanoramicData.get(0).getDate());
            //..................sitepanoramicBlocking................
            jsonObject.put("blocking0", sitePanoramicBlockingData.get(0).getBlocking0());
            jsonObject.put("blocking30", sitePanoramicBlockingData.get(0).getBlocking30());
            jsonObject.put("blocking60", sitePanoramicBlockingData.get(0).getBlocking60());
            jsonObject.put("blocking90", sitePanoramicBlockingData.get(0).getBlocking90());
            jsonObject.put("blocking120", sitePanoramicBlockingData.get(0).getBlocking120());
            jsonObject.put("blocking150", sitePanoramicBlockingData.get(0).getBlocking150());
            jsonObject.put("blocking180", sitePanoramicBlockingData.get(0).getBlocking180());
            jsonObject.put("blocking210", sitePanoramicBlockingData.get(0).getBlocking210());
            jsonObject.put("blocking240", sitePanoramicBlockingData.get(0).getBlocking240());
            jsonObject.put("blocking270", sitePanoramicBlockingData.get(0).getBlocking270());
            jsonObject.put("blocking300", sitePanoramicBlockingData.get(0).getBlocking300());
            jsonObject.put("blocking330", sitePanoramicBlockingData.get(0).getBlocking330());
            jsonObject.put("flag", sitePanoramicBlockingData.get(0).getFlag());
//  //..................sitepanoramicBlocking................
            jsonObject.put("", otherDetailData.get(0).getEdtRiggerPic());
            jsonObject.put("", otherDetailData.get(0).getEdtEngineerPic());
            jsonObject.put("", otherDetailData.get(0).getEdtCarPic());
            jsonObject.put("", otherDetailData.get(0).getEdt_RiggerPicwithclimbingTower());
            jsonObject.put("", otherDetailData.get(0).getEdtRiggerPicduringWah());
            jsonObject.put("", otherDetailData.get(0).getIv_RiggerPic());
            jsonObject.put("", otherDetailData.get(0).getIv_EngineerPic());
            jsonObject.put("", otherDetailData.get(0).getIv_CarPic());
            jsonObject.put("", otherDetailData.get(0).getEdt_RiggerPicwithclimbingTower());
            jsonObject.put("", otherDetailData.get(0).getEdtRiggerPicduringWah());
            jsonObject.put("", otherDetailData.get(0).getDate());
            jsonObject.put("", otherDetailData.get(0).getFlag());

        } catch (Exception e) {

        }
        return jsonObject;
    }

    private void toSendDataAll() {
        //  +"?Loginid="+empId+"&password="+empPassword+"&imeno="+"1234567890"
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        pDialog.show();

        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.VERIFYLOGINURL, jsonDataAll(),
                new Response.Listener<JSONArray>() {


                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponse(response);
                        Log.v("login response", response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("login response error", error.toString());
                pDialog.hide();
            }

        });
        jsonObjReq.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });

        AppSingleton.getInstance(getActivity()).addToRequestQueue(jsonObjReq, null);
    }

    private void parseSettingResponse(JSONArray response) {
        try {
            JSONArray jsonArray = new JSONArray(response.toString());
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String status = jsonObject.getString("Status");

            // String password = jsonObject.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void selectImage(String Value) {
        if (Value.equals("1")) {
         /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 1);*/
            // com.derekr.AngleCam
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 1);
            startActivityForResult(i, 1);
        }
        if (Value.equals("2")) {
           /* Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 2);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 2);
            startActivityForResult(i, 2);
        }
        if (Value.equals("3")) {
           /* Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 3);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 3);
            startActivityForResult(i, 3);
        }
        if (Value.equals("4")) {
         /*   Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 4);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 4);
            startActivityForResult(i, 4);
        }
        if (Value.equals("5")) {
            /*Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 5);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 5);
            startActivityForResult(i, 5);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_CANCELED) {
            //  Log.v("logtest", data.getStringExtra("path")+","+requestCode);
            if (requestCode == 1) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "1", angle);
                // onCaptureImageResult(data, "one");
            }
            if (requestCode == 2) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "2", angle);
                //  onCaptureImageResult(data, "2");
            }
            if (requestCode == 3) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "3", angle);
                // onCaptureImageResult(data, "3");
            }
            if (requestCode == 4) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "4", angle);
                //  onCaptureImageResult(data, "4");
            }
            if (requestCode == 5) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "5", angle);
                //onCaptureImageResult(data, "5");
            }
        }
    }

    private void onCameraSurfaceViewActivity(String thumbnail, String name, String angle) {

        if (name.equals("1")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
               /* String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle;
                // Bitmap setTextwithImage =    ProcessingBitmap(thumbnail,totalString);
                Bitmap setTextwithImage = DrawBitmapAll.drawTextToBitmap(getContext(), thumbnail, totalString);
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                setTextwithImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                String destinationpath = Environment.getExternalStorageDirectory().toString();
                File destination = new File(destinationpath + "/LinkQuest/");
                if (!destination.exists()) {
                    destination.mkdirs();
                }
                File file = null;
                FileOutputStream fo;
                try {
                    // destination.createNewFile();
                    file = new File(destination, time + ".jpg");
                    fo = new FileOutputStream(file);
                    fo.write(bytes.toByteArray());
                    fo.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                String path = (file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                String path2 = destinationpath + "/LinkQuest/"+ time+".jpg";
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);
               // pic_RiggerPic = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
               // iv_RiggerPic.setImageBitmap(decodeBase64(pic_RiggerPic));*/

                iv_RiggerPic.setImageBitmap(BitmapFactory.decodeFile(thumbnail));
                pic_RiggerPic = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                //  pic_RiggerPic= thumbnail;
                Log.v("img-encode", pic_RiggerPic);
                // Log.v("img-encode", path2);
            }
        }
        if (name.equals("2")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
       /*         String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle;
                // Bitmap setTextwithImage =    ProcessingBitmap(thumbnail,totalString);
                Bitmap setTextwithImage = DrawBitmapAll.drawTextToBitmap(getContext(), thumbnail, totalString);
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                setTextwithImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                String destinationpath = Environment.getExternalStorageDirectory().toString();
                File destination = new File(destinationpath + "/LinkQuest/");
                if (!destination.exists()) {
                    destination.mkdirs();
                }
                File file = null;
                FileOutputStream fo;
                try {
                    // destination.createNewFile();
                    file = new File(destination, time + ".jpg");
                    fo = new FileOutputStream(file);
                    fo.write(bytes.toByteArray());
                    fo.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                String path = (file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);
              //  pic_EngineerPic = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);
              //  iv_EngineerPic.setImageBitmap(decodeBase64(pic_EngineerPic));

                String path2 = destinationpath + "/LinkQuest/"+ time+".jpg";
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);
                // pic_RiggerPic = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                // iv_RiggerPic.setImageBitmap(decodeBase64(pic_RiggerPic));*/

                iv_EngineerPic.setImageBitmap(BitmapFactory.decodeFile(thumbnail));
                pic_EngineerPic = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                //  pic_EngineerPic= pic_EngineerPic;
                Log.v("img-encode", pic_EngineerPic);

            }
        }
        if (name.equals("3")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
              /*  String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle;
                // Bitmap setTextwithImage =    ProcessingBitmap(thumbnail,totalString);
                Bitmap setTextwithImage = DrawBitmapAll.drawTextToBitmap(getContext(), thumbnail, totalString);
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                setTextwithImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                String destinationpath = Environment.getExternalStorageDirectory().toString();
                File destination = new File(destinationpath + "/LinkQuest/");
                if (!destination.exists()) {
                    destination.mkdirs();
                }
                File file = null;
                FileOutputStream fo;
                try {
                    // destination.createNewFile();
                    file = new File(destination, time + ".jpg");
                    fo = new FileOutputStream(file);
                    fo.write(bytes.toByteArray());
                    fo.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                String path = (file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);
               // pic_CarPic = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);
               // iv_CarPic.setImageBitmap(decodeBase64(pic_CarPic));
                String path2 = destinationpath + "/LinkQuest/"+ time+".jpg";
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);
                // pic_RiggerPic = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                // iv_RiggerPic.setImageBitmap(decodeBase64(pic_RiggerPic));*/

                iv_CarPic.setImageBitmap(BitmapFactory.decodeFile(thumbnail));
                pic_CarPic = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                //  pic_CarPic= path2;
                Log.v("img-encode", thumbnail);

            }
        }
        if (name.equals("4")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
       /*         String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle;
                // Bitmap setTextwithImage =    ProcessingBitmap(thumbnail,totalString);
                Bitmap setTextwithImage = DrawBitmapAll.drawTextToBitmap(getContext(), thumbnail, totalString);
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                setTextwithImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                String destinationpath = Environment.getExternalStorageDirectory().toString();
                File destination = new File(destinationpath + "/LinkQuest/");
                if (!destination.exists()) {
                    destination.mkdirs();
                }
                File file = null;
                FileOutputStream fo;
                try {
                    // destination.createNewFile();
                    file = new File(destination, time + ".jpg");
                    fo = new FileOutputStream(file);
                    fo.write(bytes.toByteArray());
                    fo.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                String path = (file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);
               // pic_RiggerPicwithclimbingTower = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);
               // iv_RiggerPicwithclimbingTower.setImageBitmap(decodeBase64(pic_RiggerPicwithclimbingTower));
                String path2 = destinationpath + "/LinkQuest/"+ time+".jpg";
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);
                // pic_RiggerPic = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                // iv_RiggerPic.setImageBitmap(decodeBase64(pic_RiggerPic));*/

                iv_RiggerPicwithclimbingTower.setImageBitmap(BitmapFactory.decodeFile(thumbnail));
                pic_RiggerPicwithclimbingTower = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                // pic_RiggerPicwithclimbingTower= thumbnail;
                Log.v("img-encode", thumbnail);
            }
        }
        if (name.equals("5")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
          /*      String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle;
                // Bitmap setTextwithImage =    ProcessingBitmap(thumbnail,totalString);
                Bitmap setTextwithImage = DrawBitmapAll.drawTextToBitmap(getContext(), thumbnail, totalString);
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                setTextwithImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                String destinationpath = Environment.getExternalStorageDirectory().toString();
                File destination = new File(destinationpath + "/LinkQuest/");
                if (!destination.exists()) {
                    destination.mkdirs();
                }
                File file = null;
                FileOutputStream fo;
                try {
                    // destination.createNewFile();
                    file = new File(destination, time + ".jpg");
                    fo = new FileOutputStream(file);
                    fo.write(bytes.toByteArray());
                    fo.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                String path = (file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);
               // pic_RiggerPicduringWah = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);
               // iv_RiggerPicduringWah.setImageBitmap(decodeBase64(pic_RiggerPicduringWah));
                String path2 = destinationpath + "/LinkQuest/"+ time+".jpg";
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);
                // pic_RiggerPic = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                // iv_RiggerPic.setImageBitmap(decodeBase64(pic_RiggerPic));*/

                iv_RiggerPicduringWah.setImageBitmap(BitmapFactory.decodeFile(thumbnail));
                pic_RiggerPicduringWah = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                //   pic_RiggerPicduringWah= thumbnail;
                Log.v("img-encode", thumbnail);
            }
        }
    }

    public static String encodeToBase64(Bitmap image, Bitmap.CompressFormat compressFormat, int quality) {
        ByteArrayOutputStream byteArrayOS = new ByteArrayOutputStream();
        image.compress(compressFormat, quality, byteArrayOS);
        return Base64.encodeToString(byteArrayOS.toByteArray(), Base64.DEFAULT);
    }

    public static Bitmap decodeBase64(String input) {
        byte[] decodedBytes = Base64.decode(input, 0);
        return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);
    }

    @Override
    public void onResume() {
        super.onResume();
        //  GPSTracker.BUS.register(this);
        getActivity().registerReceiver(broadcastReceiver, new IntentFilter(GoogleGPSService.BROADCAST_ACTION));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        try {
            getActivity().unregisterReceiver(broadcastReceiver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // mContact = (Contact)getIntent().getExtras().getSerializable(EXTRA_CONTACT);
            lat = intent.getStringExtra("LAT");
            log = intent.getStringExtra("LOG");

            //    Toast.makeText(getActivity(), "Lat : " + lat + "," + "Long : " + log, Toast.LENGTH_LONG).show();
        }


    };


    private class getDataAsnycTask extends AsyncTask<String, Void, String> {
        // ProgressDialog pd = AllPermissionGrant.createProgressDialog(LoginActivity.this);
        ProgressDialog pd = new ProgressDialog(getActivity(), R.style.AppCompatAlertDialogStyle);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd.setIndeterminate(false);
            pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            pd.setMessage("get credentials");
            pd.setCancelable(false);
            pd.show();

            //  pd.setContentView(R.layout.custom_progressdialog_layout);
            // custom_progress_dialog =(ProgressBar)findViewById(R.id.custom_progress_dialog) ;
            //   custom_progress_dialog.getIndeterminateDrawable().setColorFilter(Color.parseColor("#C60000"), android.graphics.PorterDuff.Mode.SRC_IN);

        }

        @Override
        protected String doInBackground(String... params) {

            String s = HTTPPostRequestMethod.postMethodforESP(params[0], jsondataSurveyDetail());
            return s;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            parseSettingResponseSurveyDetail(s);
            pd.dismiss();
            // startActivity(new Intent(getApplicationContext(),HomeActivity.class));
        }

    }

}
