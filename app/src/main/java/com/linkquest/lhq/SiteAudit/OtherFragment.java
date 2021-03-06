package com.linkquest.lhq.SiteAudit;


import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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
import com.linkquest.lhq.database.OtherDetailData;
import com.linkquest.lhq.database.SectorDetailData;
import com.linkquest.lhq.database.SiteDetailForm;
import com.linkquest.lhq.database.SitePanoramicBlockingData;
import com.linkquest.lhq.database.SitePanoramicData;
import com.linkquest.lhq.database.SurveyForm;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPDataTransferListener;

import static android.app.Activity.RESULT_CANCELED;

/**
 * A simple {@link Fragment} subclass.
 */
public class OtherFragment extends Fragment implements View.OnClickListener {

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
    private String lat,log,time;

    private String pic_RiggerPic="";
    private String pic_EngineerPic="";
    private String pic_CarPic="";
    private String pic_RiggerPicwithclimbingTower="";
    private String pic_RiggerPicduringWah="";

    private Button btnothersave;
    private Button btnUpload;
    private TextView tv_otherdetail_count;
    private TextView tv_otherdetail_count_previous;
    private TextView tv_show_status,tv_clearrecord;

    private final String SECTOR1 ="Sector1";
    private final String SECTOR2 ="Sector2";
    private final String SECTOR3 ="Sector3";
    private final String SECTOR4 ="Sector4";
    private SharedPreferenceUtils sharedPreferences;

    public OtherFragment() {
        // Required empty public constructor
    }

    public static OtherFragment newInstance(int index) {
        OtherFragment f = new OtherFragment();
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
        final Handler   handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                time = DateFormat.format("dd-MM-yyyy h:mm:ss:aa", System.currentTimeMillis()).toString();
                handler.postDelayed(this, 1000);
            }

        }, 1000);

        findIDS(v);

        sharedPreferences = SharedPreferenceUtils.getInstance();
        sharedPreferences.setContext(getActivity());
       // String empId = sharedPreferences.getString(AppConstraint.EMPID);
        Toast.makeText(getActivity(), sharedPreferences.getString(AppConstants.DATE)+sharedPreferences.getString(AppConstants.EMPID)+
                sharedPreferences.getString(AppConstants.SITEID),Toast.LENGTH_LONG).show();

        tv_otherdetail_count_previous.setText(tv_otherdetail_count_previous.getText().toString()+db.getCountOtherDetail());
        tv_clearrecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db. deleteSomeRow_OtherDetail();
              /*  FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.detach(SiteDetailFragment.this).attach(SiteDetailFragment.this).commit();*/
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.remove(OtherFragment.this).replace(R.id.frameLayout_home_frag, new OtherFragment());;
                ft.commit();
            }
        });

        if(db.getCountOtherDetail() > 0) {

            pic_RiggerPic = db.getLastOtherdetaiData().get(0).getIv_RiggerPic();
            iv_RiggerPic.setImageBitmap(decodeBase64(pic_RiggerPic));

            pic_EngineerPic = db.getLastOtherdetaiData().get(0).getIv_EngineerPic();
            iv_EngineerPic.setImageBitmap(decodeBase64(pic_EngineerPic));

            pic_CarPic = db.getLastOtherdetaiData().get(0).getIv_CarPic();
            iv_CarPic.setImageBitmap(decodeBase64(pic_CarPic));

            pic_RiggerPicwithclimbingTower = db.getLastOtherdetaiData().get(0).getIv_RiggerPicwithclimbingTower();
            iv_RiggerPicwithclimbingTower.setImageBitmap(decodeBase64(pic_RiggerPicwithclimbingTower));

            pic_RiggerPicduringWah = db.getLastOtherdetaiData().get(0).getIv_RiggerPicduringWah();
            iv_RiggerPicduringWah.setImageBitmap(decodeBase64(pic_RiggerPicduringWah));

            edtRiggerPic.setText(db.getLastOtherdetaiData().get(0).getEdtRiggerPic());

            edtEngineerPic.setText(db.getLastOtherdetaiData().get(0).getEdtEngineerPic());

            edtCarPic.setText(db.getLastOtherdetaiData().get(0).getEdtCarPic());

            edt_RiggerPicwithclimbingTower.setText(db.getLastOtherdetaiData().get(0).getEdt_RiggerPicwithclimbingTower());

            edtRiggerPicduringWah.setText(db.getLastOtherdetaiData().get(0).getEdtRiggerPicduringWah());

        }


            return v;
    }

    private void findIDS(View v){
        tv_clearrecord = v.findViewById(R.id.tv_clearrecord);
        tv_show_status =v.findViewById(R.id.tv_show_status);

         edtRiggerPic = v.findViewById(R.id.other_riggerpic);
         edtEngineerPic = v.findViewById(R.id.other_engineerpic);
         edtCarPic = v.findViewById(R.id.other_carpic);
         edt_RiggerPicwithclimbingTower = v.findViewById(R.id.otherriggerpic_with_tower);
         edtRiggerPicduringWah = v.findViewById(R.id.other_riggerpicwithwah);

        ib_RiggerPic =v.findViewById(R.id.ibother_riggerpic);
        ib_EngineerPic =v.findViewById(R.id.ibother_engineerpic);
        ib_CarPic =v.findViewById(R.id.ib_other_carpic);
        ib_RiggerPicwithclimbingTower =v.findViewById(R.id.ib_otherriggerpic_with_tower);
        ib_RiggerPicduringWah =v.findViewById(R.id.ib_otherriggerpicwithwah);

        iv_RiggerPic =v.findViewById(R.id.ivother_riggerpic);
        iv_EngineerPic =v.findViewById(R.id.ivother_engineerpic);
        iv_CarPic =v.findViewById(R.id.iv_other_carpic);
        iv_RiggerPicwithclimbingTower =v.findViewById(R.id.iv_otherriggerpic_with_tower);
        iv_RiggerPicduringWah =v.findViewById(R.id.iv_otherriggerpicwithwah);

        btnothersave =v.findViewById(R.id.btnothersave);
        btnUpload =v.findViewById(R.id.btnUpload);
        tv_otherdetail_count =v.findViewById(R.id.tv_otherdetail_count);
        tv_otherdetail_count_previous =v.findViewById(R.id.tv_otherdetail_count_previous);

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
        if(v==ib_RiggerPic) {
         selectImage("1");
        }
        if(v==ib_EngineerPic) {
            selectImage("2");
        }
        if(v==ib_CarPic) {
            selectImage("3");
        }
        if(v==ib_RiggerPicwithclimbingTower) {
            selectImage("4");
        }
        if(v==ib_RiggerPicduringWah) {
            selectImage("5");
        }
        if(v==btnothersave) {
         /*   if (db.getCountOtherDetail() > 2) {
                db.deleteSomeRow_OtherDetail();

            }*/

        db.insertOtherData(new OtherDetailData(edtRiggerPic.getText().toString(),edtEngineerPic.getText().toString(),edtCarPic.getText().toString(),
        edt_RiggerPicwithclimbingTower.getText().toString(),edtRiggerPicduringWah.getText().toString(),pic_RiggerPic,pic_EngineerPic,pic_CarPic,
        pic_RiggerPicwithclimbingTower,pic_RiggerPicduringWah,time,1));

        //   db.insertOtherData(new OtherDetailData(1+"",2+"",3+"",4+"",5+"",1+"img",2+"img",3+"img", 4+"img",5+"img",time,1));
      int count =  db.getCountOtherDetail();
      tv_otherdetail_count.setText(count +"");
        }
        if(v==btnUpload) {
            toSendDataSurveyDetail();
            toSendDataSiteDetail();
            toSendDataSectorDetail1(SECTOR1);
            toSendDataSectorDetail2(SECTOR2);
            toSendDataSectorDetail3(SECTOR3);
            toSendDataSectorDetail4(SECTOR4);
         //   toSendDataSitePanaromic();
            toSendDataOtherDetail();

            final List<SitePanoramicData> sitePanoramicData = db.getLastSitePanaromicData();

// add 19/8/2019................................by deepak
            new Thread() {

                public void run() {
                    Looper.prepare();

                    new ftpConnect_Send().uploadFile(new File(sitePanoramicData.get(0).getBtnBearing0Image()));
           /* new ftpConnect_Send().uploadFile(new File(sitePanoramicData.get(0).getBtnBearing30Image()));
            new ftpConnect_Send().uploadFile(new File(sitePanoramicData.get(0).getBtnBearing60Image()));
            new ftpConnect_Send().uploadFile(new File(sitePanoramicData.get(0).getBtnBearing90Image()));
            new ftpConnect_Send().uploadFile(new File(sitePanoramicData.get(0).getBtnBearing120Image()));
            new ftpConnect_Send().uploadFile(new File(sitePanoramicData.get(0).getBtnBearing150Image()));
            new ftpConnect_Send().uploadFile(new File(sitePanoramicData.get(0).getBtnBearing180Image()));
            new ftpConnect_Send().uploadFile(new File(sitePanoramicData.get(0).getBtnBearing210Image()));
            new ftpConnect_Send().uploadFile(new File(sitePanoramicData.get(0).getBtnBearing240Image()));
            new ftpConnect_Send().uploadFile(new File(sitePanoramicData.get(0).getBtnBearing270Image()));
            new ftpConnect_Send().uploadFile(new File(sitePanoramicData.get(0).getBtnBearing300Image()));
            new ftpConnect_Send().uploadFile(new File(sitePanoramicData.get(0).getBtnBearing330Image()));*/

                    Looper.loop();
                }



            }.start();

            // add 19/8/2019................................by deepak

            saveTextFileSiteDetail();
            saveTextFileSurveyDetail();

       // startActivity(new Intent(getActivity(),SiteAuditAllDataHistory.class));
        }
    }


//...........................siteDetail.......................
    private JSONObject jsondataSiteDetail(){
        JSONObject jsonObject = new JSONObject();
        List<SiteDetailForm> siteDetailData = db.getLastSiteDetailData();
        if(siteDetailData.size()>0) {
            Log.v("OtherFragSiteDetail", siteDetailData.toString());
            try {
               // jsonObject.put("siteid", siteDetailData.get(0).getSiteid());
                jsonObject.put("siteid_photo", siteDetailData.get(0).getSiteid_photo());
                jsonObject.put("sitename", siteDetailData.get(0).getSitename());
                jsonObject.put("sitename_photo", siteDetailData.get(0).getSitename_photo());
                jsonObject.put("towersiteid", siteDetailData.get(0).getTowersiteid());
                jsonObject.put("towersiteid_photo", siteDetailData.get(0).getTowersiteid_photo());
                jsonObject.put("towercompanyname", siteDetailData.get(0).getTowercompanyname());
                jsonObject.put("towercompanyname__photo", siteDetailData.get(0).getTowercompanyname__photo());
                jsonObject.put("siteaddress", siteDetailData.get(0).getSiteaddress());
                jsonObject.put("siteaddress_photo", siteDetailData.get(0).getSiteaddress_photo());
                jsonObject.put("sectorid", siteDetailData.get(0).getSectorid());
                jsonObject.put("sectorid_photo", siteDetailData.get(0).getSectorid_photo());
                jsonObject.put("lat", siteDetailData.get(0).getLat());
                jsonObject.put("log", siteDetailData.get(0).getLog());
                jsonObject.put("sitetype", siteDetailData.get(0).getSitetype());
                jsonObject.put("sitetype_photo", siteDetailData.get(0).getSitetype_photo());
                jsonObject.put("buildingfloor", siteDetailData.get(0).getBuildingfloor());
                jsonObject.put("buildingfloor_photo", siteDetailData.get(0).getBuildingfloor_photo());
                jsonObject.put("buildingheight", siteDetailData.get(0).getBuildingheight());
                jsonObject.put("buildingheight_photo", siteDetailData.get(0).getBuildingheight_photo());
                jsonObject.put("towerheight", siteDetailData.get(0).getTowerheight());
                jsonObject.put("towerheight_photo", siteDetailData.get(0).getTowerheight_photo());
                jsonObject.put("fulltowerphoto", siteDetailData.get(0).getFulltowerphoto());
                jsonObject.put("fulltowerphoto_photo", siteDetailData.get(0).getFulltowerphoto_photo());
                jsonObject.put("nodebtype", siteDetailData.get(0).getNodebtype());
                jsonObject.put("nodebtype_photo", siteDetailData.get(0).getNodebtype_photo());
                jsonObject.put("classical", siteDetailData.get(0).getClassical());
                jsonObject.put("classical_photo", siteDetailData.get(0).getClassical_photo());
                jsonObject.put("enodebtype", siteDetailData.get(0).getEnodebtype());
                jsonObject.put("enodebtype_photo", siteDetailData.get(0).getEnodebtype_photo());
                jsonObject.put("anchoroperator", siteDetailData.get(0).getAnchoroperator());
                jsonObject.put("anchoroperator_photo", siteDetailData.get(0).getAnchoroperator_photo());
                jsonObject.put("sharingopco1", siteDetailData.get(0).getSharingopco1());
                jsonObject.put("sharingopco1_photo", siteDetailData.get(0).getSharingopco1_photo());
                jsonObject.put("sharingopco2", siteDetailData.get(0).getSharingopco2());
                jsonObject.put("sharingopco2_photo", siteDetailData.get(0).getSharingopco2_photo());
                jsonObject.put("sharingopco3", siteDetailData.get(0).getSharingopco3());
                jsonObject.put("sharingopco3_photo", siteDetailData.get(0).getSharingopco3_photo());
                jsonObject.put("infraprovider", siteDetailData.get(0).getInfraprovider());
                jsonObject.put("infraprovider_photo", siteDetailData.get(0).getInfraprovider_photo());
                jsonObject.put("type_id_od", siteDetailData.get(0).getType_id_od());
                jsonObject.put("type_id_od_photo", siteDetailData.get(0).getType_id_od_photo());
                jsonObject.put("infrashared", siteDetailData.get(0).getInfrashared());
                jsonObject.put("infrashared_photo", siteDetailData.get(0).getInfrashared_photo());
                jsonObject.put("extra1", siteDetailData.get(0).getExtra1());
                jsonObject.put("extra1_photo", siteDetailData.get(0).getExtra1_photo());
                jsonObject.put("extra2", siteDetailData.get(0).getExtra2());
                jsonObject.put("extra2_photo", siteDetailData.get(0).getExtra2_photo());
                jsonObject.put("remark1", siteDetailData.get(0).getRemark1());
                jsonObject.put("remark1_photo", siteDetailData.get(0).getRemark1_photo());
                jsonObject.put("remark2", siteDetailData.get(0).getRemark2());
                jsonObject.put("remark2_photo", siteDetailData.get(0).getRemark2_photo());
                jsonObject.put("flag", siteDetailData.get(0).getFlag());
              //  jsonObject.put("date", siteDetailData.get(0).getDate());

                jsonObject.put("date", sharedPreferences.getString(AppConstants.DATE));
                jsonObject.put("empid", sharedPreferences.getString(AppConstants.EMPID));
                jsonObject.put("siteid", sharedPreferences.getString(AppConstants.SITEID));
                jsonObject.put("idall",sharedPreferences.getString(AppConstants.surveytpeandcustomerandoperator));
            } catch (Exception e) {

            }
        }
        return jsonObject;
    }
    private void toSendDataSiteDetail() {
        //  +"?Loginid="+empId+"&password="+empPassword+"&imeno="+"1234567890"
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        pDialog.show();

        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.SITEDETAIL,jsondataSiteDetail(),
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponseSiteDetail(response);
                        Log.v(" response sitedetail", response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v(" response errorsitedetail", error.toString());
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
    private void parseSettingResponseSiteDetail(JSONArray response) {
        try {
            JSONArray jsonArray = new JSONArray(response.toString());
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String status = jsonObject.getString("Status");

            tv_show_status.append("Site Detail :" +status+"\n");
            Toast.makeText(getActivity(),status+" Site Detail",Toast.LENGTH_LONG).show();
            // String password = jsonObject.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//..........................siteDetail

    //...........................surveyDetail.......................
    private JSONObject jsondataSurveyDetail(){
        JSONObject jsonObject = new JSONObject();
        List<SurveyForm> surveyformData = db.getLastSurveyformData();
        if(surveyformData.size()>0){
            Log.v("OtherFragSurveyform",surveyformData.toString());

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
                jsonObject.put("idall",sharedPreferences.getString(AppConstants.surveytpeandcustomerandoperator));

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
                AppConstants.SURVEYDETAIL,jsondataSurveyDetail(),
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
                Log.v("response errorsurveydetail", error.toString());
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
Toast.makeText(getActivity(),status +"Survey Detail",Toast.LENGTH_LONG).show();
            tv_show_status.append("Survey Detail :" +status+"\n");
            // String password = jsonObject.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//..........................SurveyDetail
//..........................SectorDetail 1
private JSONObject jsondataSectorDetail1(String secname){
    JSONObject jsonObject = new JSONObject();
    List<SectorDetailData> sectorDetailData = db.getLastSectordetail(secname);
    if(sectorDetailData.size()>0){
        Log.v("OtherFragSectorDetail",sectorDetailData.toString());
        try {
            jsonObject.put("sectordetail_edt_techavailable", sectorDetailData.get(0).getSectordetail_edt_techavailable());
            jsonObject.put("sectordetail_img_techavailable", sectorDetailData.get(0).getSectordetail_img_techavailable());
            jsonObject.put("sectordetail_edt_bandavailable", sectorDetailData.get(0).getSectordetail_edt_bandavailable());
            jsonObject.put("sectordeatail_img_bandavailable", sectorDetailData.get(0).getSectordetail_img_bandavailable());
            jsonObject.put("sectordeatail_edt_APC", sectorDetailData.get(0).getSectordetail_edt_APC());
            jsonObject.put("sectordeatail_img_APC", sectorDetailData.get(0).getSectordetail_img_APC());
            jsonObject.put("sectoreatail_edt_preazimuth", sectorDetailData.get(0).getSectoreatail_edt_preazimuth());
            jsonObject.put("sectordeatail_img_preazimuth", sectorDetailData.get(0).getSectordetail_img_preazimuth());
            jsonObject.put("sectordeatail_edt_postazimuth", sectorDetailData.get(0).getSectordetail_edt_postazimuth());
            jsonObject.put("sectordeatail_img_postazimuth", sectorDetailData.get(0).getSectordetail_img_postazimuth());
            jsonObject.put("sectordeatail_edt_premechanical_tilt", sectorDetailData.get(0).getSectordetail_edt_premechanical_tilt());
            jsonObject.put("sectordeatail_img_premechanical_tilt", sectorDetailData.get(0).getSectordetail_img_premechanical_tilt());
            jsonObject.put("sectordeatail_edt_postmechanical_tilt", sectorDetailData.get(0).getSectordetail_edt_postmechanical_tilt());
            jsonObject.put("sectordeatail_img_postmechanical_tilt", sectorDetailData.get(0).getSectordetail_img_postmechanical_tilt());
            jsonObject.put("sectordeatail_edt_preelectrical_tilt2g", sectorDetailData.get(0).getSectordetail_edt_preelectrical_tilt2g());
            jsonObject.put("sectordeatail_img_preelectrical_tilt2g", sectorDetailData.get(0).getSectordetail_img_preelectrical_tilt2g());
            jsonObject.put("sectordeatail_edt_postelectrical_tilt2g", sectorDetailData.get(0).getSectordetail_edt_postelectrical_tilt2g());
            jsonObject.put("sectordeatail_img_postelectrical_tilt2g", sectorDetailData.get(0).getSectordetail_img_postelectrical_tilt2g());
            jsonObject.put("sectordeatail_edt_preelectrical_tilt3g", sectorDetailData.get(0).getSectordetail_edt_preelectrical_tilt3g());
            jsonObject.put("sectordeatail_img_pretelectrical_tilt3g", sectorDetailData.get(0).getSectordetail_img_pretelectrical_tilt3g());
            jsonObject.put("sectordeatail_edt_postelectrical_tilt3g", sectorDetailData.get(0).getSectordetail_edt_postelectrical_tilt3g());
            jsonObject.put("sectordeatail_img_postelectrical_tilt3g", sectorDetailData.get(0).getSectordetail_img_postelectrical_tilt3g());
            jsonObject.put("sectordeatail_edt_preelectrical_tilt4gf1", sectorDetailData.get(0).getSectordetail_edt_preelectrical_tilt4gf1());
            jsonObject.put("sectordeatail_img_preelectrical_tilt4gf1", sectorDetailData.get(0).getSectordetail_img_preelectrical_tilt4gf1());
            jsonObject.put("sectordeatail_edt_postelectrical_tilt4gf1", sectorDetailData.get(0).getSectordetail_edt_postelectrical_tilt4gf1());
            jsonObject.put("sectordeatail_img_postelectrical_tilt4gf1", sectorDetailData.get(0).getSectordetail_img_postelectrical_tilt4gf1());
            jsonObject.put("sectordeatail_edt_preelectrical_tilt4gf2", sectorDetailData.get(0).getSectordetail_edt_preelectrical_tilt4gf2());
            jsonObject.put("sectordeatail_img_preelectrical_tilt4gf2", sectorDetailData.get(0).getSectordetail_img_preelectrical_tilt4gf2());
            jsonObject.put("sectordeatail_edt_postelectrical_tilt4gf2", sectorDetailData.get(0).getSectordetail_edt_postelectrical_tilt4gf2());
            jsonObject.put("sectordeatail_img_postelectrical_tilt4gf2", sectorDetailData.get(0).getSectordetail_img_postelectrical_tilt4gf2());
            jsonObject.put("sectordeatail_edt_preelectrical_tilt", sectorDetailData.get(0).getSectordetail_edt_preelectrical_tilt());
            jsonObject.put("sectordeatail_img_preelectrical_tilt", sectorDetailData.get(0).getSectordetail_img_preelectrical_tilt());
            jsonObject.put("sectordeatail_edt_postelectrical_tilt", sectorDetailData.get(0).getSectordetail_edt_postelectrical_tilt());
            jsonObject.put("sectordeatail_img_postelectrical_tilt", sectorDetailData.get(0).getSectordetail_img_postelectrical_tilt());
            jsonObject.put("sectordeatail_edt_antennaheight", sectorDetailData.get(0).getSectordetail_edt_antennaheight());
            jsonObject.put("sectordeatail_img_antennaheight", sectorDetailData.get(0).getSectordetail_img_antennaheight());
            jsonObject.put("sectordeatail_edt_poleheight", sectorDetailData.get(0).getSectordetail_edt_poleheight());
            jsonObject.put("sectordeatail_img_poleheight", sectorDetailData.get(0).getSectordetail_img_poleheight());
            jsonObject.put("sectordeatail_edt_buildingheight", sectorDetailData.get(0).getSectordetail_edt_buildingheight());
            jsonObject.put("sectordeatail_img_buildingheight", sectorDetailData.get(0).getSectordetail_img_buildingheight());
            jsonObject.put("sectordeatail_edt_towertype", sectorDetailData.get(0).getSectordetail_edt_towertype());
            jsonObject.put("sectordeatail_img_towertype", sectorDetailData.get(0).getSectordetail_img_towertype());
            jsonObject.put("sectordeatail_edt_antennamake", sectorDetailData.get(0).getSectordetail_edt_antennamake());
            jsonObject.put("sectordeatail_img_antennamake", sectorDetailData.get(0).getSectordetail_img_antennamake());
            jsonObject.put("sectordeatail_edt_antenmodel", sectorDetailData.get(0).getSectordetail_edt_antenmodel());
            jsonObject.put("sectordeatail_img_antennamodel", sectorDetailData.get(0).getSectordetail_img_antennamodel());
            jsonObject.put("sectordeatail_edt_clutterpic", sectorDetailData.get(0).getSectordetail_edt_clutterpic());
            jsonObject.put("sectordeatail_img_clutterpic", sectorDetailData.get(0).getSectordetail_img_clutterpic());
            jsonObject.put("sectordeatail_edt_txbandwidth", sectorDetailData.get(0).getSectordetail_edt_txbandwidth());
            jsonObject.put("sectordeatail_img_txbandwidth", sectorDetailData.get(0).getSectordetail_img_txbandwidth());
            jsonObject.put("sectordeatail_edt_AST", sectorDetailData.get(0).getSectordetail_edt_AST());
            jsonObject.put("sectordeatail_img_AST", sectorDetailData.get(0).getSectordetail_img_AST());
            jsonObject.put("sectordeatail_edt_APST", sectorDetailData.get(0).getSectordetail_edt_APST());
            jsonObject.put("sectordeatail_img_APST", sectorDetailData.get(0).getSectordetail_img_APST());
            jsonObject.put("sectordeatail_edt_typ_enodeb", sectorDetailData.get(0).getSectordetail_edt_typ_enodeb());
            jsonObject.put("sectordeatail_img_typ_enodeb", sectorDetailData.get(0).getSectordetail_img_typ_enodeb());
            jsonObject.put("sectordeatail_edt_mimo", sectorDetailData.get(0).getSectordetail_edt_mimo());
            jsonObject.put("sectordeatail_img_mimo", sectorDetailData.get(0).getSectordetail_img_mimo());
            jsonObject.put("sectordeatail_edt_ret", sectorDetailData.get(0).getSectordetail_edt_ret());
            jsonObject.put("sectordeatail_img_ret", sectorDetailData.get(0).getSectordetail_img_ret());
            jsonObject.put("sectordeatail_edt_enodebband", sectorDetailData.get(0).getSectordetail_edt_enodebband());
            jsonObject.put("sectordeatail_img_enodebband", sectorDetailData.get(0).getSectordetail_img_enodebband());
            jsonObject.put("sectordeatail_edt_MOP", sectorDetailData.get(0).getSectordetail_edt_MOP());
            jsonObject.put("sectordeatail_img_MOP", sectorDetailData.get(0).getSectordetail_img_MOP());
            jsonObject.put("sectordeatail_edt_COP", sectorDetailData.get(0).getSectordetail_edt_COP());
            jsonObject.put("sectordeatail_img_COP", sectorDetailData.get(0).getSectordetail_img_COP());
            jsonObject.put("sectordeatail_edt_multiplexer_avail", sectorDetailData.get(0).getSectordetail_edt_multiplexer_avail());
            jsonObject.put("sectordeatail_img_multiplexer_avail", sectorDetailData.get(0).getSectordetail_img_multiplexer_avail());
            jsonObject.put("sectordeatail_edt_antennapicleg", sectorDetailData.get(0).getSectordetail_edt_antennapicleg());
            jsonObject.put("sectordeatail_img_antennapicleg", sectorDetailData.get(0).getSectordetail_img_antennapicleg());
            jsonObject.put("sectordeatail_edt_CRP", sectorDetailData.get(0).getSectordetail_edt_CRP());
            jsonObject.put("sectordeatail_img_CRP", sectorDetailData.get(0).getSectordetail_img_CRP());
            jsonObject.put("sectordeatail_edt_powerdeboosting", sectorDetailData.get(0).getSectordetail_edt_powerdeboosting());
            jsonObject.put("sectordeatail_img_powerdeboosting", sectorDetailData.get(0).getSectordetail_img_powerdeboosting());
            jsonObject.put("sectordeatail_edt_DFS", sectorDetailData.get(0).getSectordetail_edt_DFS());
            jsonObject.put("sectordeatail_img_DFS", sectorDetailData.get(0).getSectordetail_img_DFS());
            jsonObject.put("sectordeatail_edt_rb_percell", sectorDetailData.get(0).getSectordetail_edt_rb_percell());
            jsonObject.put("sectordeatail_img_rb_percell", sectorDetailData.get(0).getSectordetail_img_rb_percell());
            jsonObject.put("sectordeatail_edt_m_mimo", sectorDetailData.get(0).getSectordetail_edt_m_mimo());
            jsonObject.put("sectordeatail_img_m_mimo", sectorDetailData.get(0).getSectordetail_img_m_mimo());
            jsonObject.put("sectordeatail_edt_FCT", sectorDetailData.get(0).getSectordetail_edt_FCT());
            jsonObject.put("sectordeatail_img_FCT", sectorDetailData.get(0).getSectordetail_img_FCT());
            jsonObject.put("sectordeatail_edt_JCT", sectorDetailData.get(0).getSectordetail_edt_JCT());
            jsonObject.put("sectordeatail_img_JCT", sectorDetailData.get(0).getSectordetail_img_JCT());
            jsonObject.put("sectordeatail_edt_FCL", sectorDetailData.get(0).getSectordetail_edt_FCL());
            jsonObject.put("sectordeatail_img_FCL", sectorDetailData.get(0).getSectordetail_img_FCL());
            jsonObject.put("sectordeatail_edt_jumperlength", sectorDetailData.get(0).getSectordetail_edt_jumperlength());
            jsonObject.put("sectordeatail_img_jumperlength", sectorDetailData.get(0).getSectordetail_img_jumperlength());
            jsonObject.put("sectordeatail_edt_prachconfig_index", sectorDetailData.get(0).getSectordetail_edt_prachconfig_index());
            jsonObject.put("sectordeatail_img_prachconfig_index", sectorDetailData.get(0).getSectordetail_img_prachconfig_index());
            jsonObject.put("sectordeatail_edt_carrieraggregation", sectorDetailData.get(0).getSectordetail_edt_carrieraggregation());
            jsonObject.put("sectordeatail_img_carrieraggregation", sectorDetailData.get(0).getSectordetail_img_carrieraggregation());
            jsonObject.put("sectordeatail_edt_ACD", sectorDetailData.get(0).getSectordetail_edt_ACD());
            jsonObject.put("sectordeatail_img_ACD", sectorDetailData.get(0).getSectordetail_img_ACD());
            jsonObject.put("sectordeatail_edt_VSWRtest", sectorDetailData.get(0).getSectordetail_edt_VSWRtest());
            jsonObject.put("sectordeatail_img_VSWRtest", sectorDetailData.get(0).getSectordetail_img_VSWRtest());
            jsonObject.put("sectordeatail_edt_URS", sectorDetailData.get(0).getSectordetail_edt_URS());
            jsonObject.put("sectordeatail_img_URS", sectorDetailData.get(0).getSectordetail_img_URS());
            jsonObject.put("sectordeatail_edt_extra1", sectorDetailData.get(0).getSectordetail_edt_extra1());
            jsonObject.put("sectordeatail_img_extra1", sectorDetailData.get(0).getSectordetail_img_extra1());
            jsonObject.put("sectordeatail_edt_extra2", sectorDetailData.get(0).getSectordetail_edt_extra2());
            jsonObject.put("sectordeatail_img_extra2", sectorDetailData.get(0).getSectordetail_img_extra2());
            jsonObject.put("sectordeatail_edt_remark1", sectorDetailData.get(0).getSectordetail_edt_remak1());
            jsonObject.put("sectordeatail_img_remark1", sectorDetailData.get(0).getSectordetail_img_remark1());
            jsonObject.put("sectordeatail_edt_remark2", sectorDetailData.get(0).getSectordetail_edt_remak2());
            jsonObject.put("sectordeatail_img_remark2", sectorDetailData.get(0).getSectordetail_img_remark2());
            jsonObject.put("sectordeatailfrgamentname", sectorDetailData.get(0).getSectordetailfrgamentname());
            jsonObject.put("flag", sectorDetailData.get(0).getFlag());
            // jsonObject.put("date", sectorDetailData.get(0).getDate());

            jsonObject.put("siteid", sharedPreferences.getString(AppConstants.SITEID));
            jsonObject.put("date", sharedPreferences.getString(AppConstants.DATE));
            jsonObject.put("empid", sharedPreferences.getString(AppConstants.EMPID));
            jsonObject.put("idall",sharedPreferences.getString(AppConstants.surveytpeandcustomerandoperator));

            jsonObject.put("Baseband_Unit_Type", sectorDetailData.get(0).getSdbasebandUnitType_edt());
            jsonObject.put("RNC_Name", sectorDetailData.get(0).getSdrNCName_edt());
            jsonObject.put("No_of_Channel_Elements", sectorDetailData.get(0).getSdnoofChannelElements_edt());
            jsonObject.put("Baseband_Unit_Type_img", sectorDetailData.get(0).getSdbasebandUnitType_img());
            jsonObject.put("RNC_Name_img", sectorDetailData.get(0).getSdrNCName_img());
            jsonObject.put("No_of_Channel_Elements_img", sectorDetailData.get(0).getSdnoofChannelElements_img());

        }catch (Exception e){
            Log.e("Exception",e.toString());
        }
    }
    return jsonObject;
}
    private void toSendDataSectorDetail1(String secname) {
        //  +"?Loginid="+empId+"&password="+empPassword+"&imeno="+"1234567890"
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        pDialog.show();
        Log.v("jsonobjectsectordetail",jsondataSectorDetail1(secname).toString());
        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.SECTORDETAIL,jsondataSectorDetail1(secname),
                new Response.Listener<JSONArray>() {


                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponseSectorDetail1(response.toString());
                        Log.v("response_sectordetail", response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("response errorsectordetail", error.toString());
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
    private void parseSettingResponseSectorDetail1(String s) {
        try {
            JSONArray jsonArray = new JSONArray(s);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String status = jsonObject.getString("Status");
            Toast.makeText(getActivity(),status + "Sector Detail1",Toast.LENGTH_LONG).show();
            tv_show_status.append("Sector Detail1 :" +status+"\n");

            // String password = jsonObject.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //..........................SectorDetail 2
    private JSONObject jsondataSectorDetail2(String secname){
        JSONObject jsonObject = new JSONObject();
        List<SectorDetailData> sectorDetailData = db.getLastSectordetail(secname);
        if(sectorDetailData.size()>0){
            Log.v("OtherFragSectorDetail2",sectorDetailData.toString());
            try {
                jsonObject.put("sectordetail_edt_techavailable", sectorDetailData.get(0).getSectordetail_edt_techavailable());
                jsonObject.put("sectordetail_img_techavailable", sectorDetailData.get(0).getSectordetail_img_techavailable());
                jsonObject.put("sectordetail_edt_bandavailable", sectorDetailData.get(0).getSectordetail_edt_bandavailable());
                jsonObject.put("sectordeatail_img_bandavailable", sectorDetailData.get(0).getSectordetail_img_bandavailable());
                jsonObject.put("sectordeatail_edt_APC", sectorDetailData.get(0).getSectordetail_edt_APC());
                jsonObject.put("sectordeatail_img_APC", sectorDetailData.get(0).getSectordetail_img_APC());
                jsonObject.put("sectoreatail_edt_preazimuth", sectorDetailData.get(0).getSectoreatail_edt_preazimuth());
                jsonObject.put("sectordeatail_img_preazimuth", sectorDetailData.get(0).getSectordetail_img_preazimuth());
                jsonObject.put("sectordeatail_edt_postazimuth", sectorDetailData.get(0).getSectordetail_edt_postazimuth());
                jsonObject.put("sectordeatail_img_postazimuth", sectorDetailData.get(0).getSectordetail_img_postazimuth());
                jsonObject.put("sectordeatail_edt_premechanical_tilt", sectorDetailData.get(0).getSectordetail_edt_premechanical_tilt());
                jsonObject.put("sectordeatail_img_premechanical_tilt", sectorDetailData.get(0).getSectordetail_img_premechanical_tilt());
                jsonObject.put("sectordeatail_edt_postmechanical_tilt", sectorDetailData.get(0).getSectordetail_edt_postmechanical_tilt());
                jsonObject.put("sectordeatail_img_postmechanical_tilt", sectorDetailData.get(0).getSectordetail_img_postmechanical_tilt());
                jsonObject.put("sectordeatail_edt_preelectrical_tilt2g", sectorDetailData.get(0).getSectordetail_edt_preelectrical_tilt2g());
                jsonObject.put("sectordeatail_img_preelectrical_tilt2g", sectorDetailData.get(0).getSectordetail_img_preelectrical_tilt2g());
                jsonObject.put("sectordeatail_edt_postelectrical_tilt2g", sectorDetailData.get(0).getSectordetail_edt_postelectrical_tilt2g());
                jsonObject.put("sectordeatail_img_postelectrical_tilt2g", sectorDetailData.get(0).getSectordetail_img_postelectrical_tilt2g());
                jsonObject.put("sectordeatail_edt_preelectrical_tilt3g", sectorDetailData.get(0).getSectordetail_edt_preelectrical_tilt3g());
                jsonObject.put("sectordeatail_img_pretelectrical_tilt3g", sectorDetailData.get(0).getSectordetail_img_pretelectrical_tilt3g());
                jsonObject.put("sectordeatail_edt_postelectrical_tilt3g", sectorDetailData.get(0).getSectordetail_edt_postelectrical_tilt3g());
                jsonObject.put("sectordeatail_img_postelectrical_tilt3g", sectorDetailData.get(0).getSectordetail_img_postelectrical_tilt3g());
                jsonObject.put("sectordeatail_edt_preelectrical_tilt4gf1", sectorDetailData.get(0).getSectordetail_edt_preelectrical_tilt4gf1());
                jsonObject.put("sectordeatail_img_preelectrical_tilt4gf1", sectorDetailData.get(0).getSectordetail_img_preelectrical_tilt4gf1());
                jsonObject.put("sectordeatail_edt_postelectrical_tilt4gf1", sectorDetailData.get(0).getSectordetail_edt_postelectrical_tilt4gf1());
                jsonObject.put("sectordeatail_img_postelectrical_tilt4gf1", sectorDetailData.get(0).getSectordetail_img_postelectrical_tilt4gf1());
                jsonObject.put("sectordeatail_edt_preelectrical_tilt4gf2", sectorDetailData.get(0).getSectordetail_edt_preelectrical_tilt4gf2());
                jsonObject.put("sectordeatail_img_preelectrical_tilt4gf2", sectorDetailData.get(0).getSectordetail_img_preelectrical_tilt4gf2());
                jsonObject.put("sectordeatail_edt_postelectrical_tilt4gf2", sectorDetailData.get(0).getSectordetail_edt_postelectrical_tilt4gf2());
                jsonObject.put("sectordeatail_img_postelectrical_tilt4gf2", sectorDetailData.get(0).getSectordetail_img_postelectrical_tilt4gf2());
                jsonObject.put("sectordeatail_edt_preelectrical_tilt", sectorDetailData.get(0).getSectordetail_edt_preelectrical_tilt());
                jsonObject.put("sectordeatail_img_preelectrical_tilt", sectorDetailData.get(0).getSectordetail_img_preelectrical_tilt());
                jsonObject.put("sectordeatail_edt_postelectrical_tilt", sectorDetailData.get(0).getSectordetail_edt_postelectrical_tilt());
                jsonObject.put("sectordeatail_img_postelectrical_tilt", sectorDetailData.get(0).getSectordetail_img_postelectrical_tilt());
                jsonObject.put("sectordeatail_edt_antennaheight", sectorDetailData.get(0).getSectordetail_edt_antennaheight());
                jsonObject.put("sectordeatail_img_antennaheight", sectorDetailData.get(0).getSectordetail_img_antennaheight());
                jsonObject.put("sectordeatail_edt_poleheight", sectorDetailData.get(0).getSectordetail_edt_poleheight());
                jsonObject.put("sectordeatail_img_poleheight", sectorDetailData.get(0).getSectordetail_img_poleheight());
                jsonObject.put("sectordeatail_edt_buildingheight", sectorDetailData.get(0).getSectordetail_edt_buildingheight());
                jsonObject.put("sectordeatail_img_buildingheight", sectorDetailData.get(0).getSectordetail_img_buildingheight());
                jsonObject.put("sectordeatail_edt_towertype", sectorDetailData.get(0).getSectordetail_edt_towertype());
                jsonObject.put("sectordeatail_img_towertype", sectorDetailData.get(0).getSectordetail_img_towertype());
                jsonObject.put("sectordeatail_edt_antennamake", sectorDetailData.get(0).getSectordetail_edt_antennamake());
                jsonObject.put("sectordeatail_img_antennamake", sectorDetailData.get(0).getSectordetail_img_antennamake());
                jsonObject.put("sectordeatail_edt_antenmodel", sectorDetailData.get(0).getSectordetail_edt_antenmodel());
                jsonObject.put("sectordeatail_img_antennamodel", sectorDetailData.get(0).getSectordetail_img_antennamodel());
                jsonObject.put("sectordeatail_edt_clutterpic", sectorDetailData.get(0).getSectordetail_edt_clutterpic());
                jsonObject.put("sectordeatail_img_clutterpic", sectorDetailData.get(0).getSectordetail_img_clutterpic());
                jsonObject.put("sectordeatail_edt_txbandwidth", sectorDetailData.get(0).getSectordetail_edt_txbandwidth());
                jsonObject.put("sectordeatail_img_txbandwidth", sectorDetailData.get(0).getSectordetail_img_txbandwidth());
                jsonObject.put("sectordeatail_edt_AST", sectorDetailData.get(0).getSectordetail_edt_AST());
                jsonObject.put("sectordeatail_img_AST", sectorDetailData.get(0).getSectordetail_img_AST());
                jsonObject.put("sectordeatail_edt_APST", sectorDetailData.get(0).getSectordetail_edt_APST());
                jsonObject.put("sectordeatail_img_APST", sectorDetailData.get(0).getSectordetail_img_APST());
                jsonObject.put("sectordeatail_edt_typ_enodeb", sectorDetailData.get(0).getSectordetail_edt_typ_enodeb());
                jsonObject.put("sectordeatail_img_typ_enodeb", sectorDetailData.get(0).getSectordetail_img_typ_enodeb());
                jsonObject.put("sectordeatail_edt_mimo", sectorDetailData.get(0).getSectordetail_edt_mimo());
                jsonObject.put("sectordeatail_img_mimo", sectorDetailData.get(0).getSectordetail_img_mimo());
                jsonObject.put("sectordeatail_edt_ret", sectorDetailData.get(0).getSectordetail_edt_ret());
                jsonObject.put("sectordeatail_img_ret", sectorDetailData.get(0).getSectordetail_img_ret());
                jsonObject.put("sectordeatail_edt_enodebband", sectorDetailData.get(0).getSectordetail_edt_enodebband());
                jsonObject.put("sectordeatail_img_enodebband", sectorDetailData.get(0).getSectordetail_img_enodebband());
                jsonObject.put("sectordeatail_edt_MOP", sectorDetailData.get(0).getSectordetail_edt_MOP());
                jsonObject.put("sectordeatail_img_MOP", sectorDetailData.get(0).getSectordetail_img_MOP());
                jsonObject.put("sectordeatail_edt_COP", sectorDetailData.get(0).getSectordetail_edt_COP());
                jsonObject.put("sectordeatail_img_COP", sectorDetailData.get(0).getSectordetail_img_COP());
                jsonObject.put("sectordeatail_edt_multiplexer_avail", sectorDetailData.get(0).getSectordetail_edt_multiplexer_avail());
                jsonObject.put("sectordeatail_img_multiplexer_avail", sectorDetailData.get(0).getSectordetail_img_multiplexer_avail());
                jsonObject.put("sectordeatail_edt_antennapicleg", sectorDetailData.get(0).getSectordetail_edt_antennapicleg());
                jsonObject.put("sectordeatail_img_antennapicleg", sectorDetailData.get(0).getSectordetail_img_antennapicleg());
                jsonObject.put("sectordeatail_edt_CRP", sectorDetailData.get(0).getSectordetail_edt_CRP());
                jsonObject.put("sectordeatail_img_CRP", sectorDetailData.get(0).getSectordetail_img_CRP());
                jsonObject.put("sectordeatail_edt_powerdeboosting", sectorDetailData.get(0).getSectordetail_edt_powerdeboosting());
                jsonObject.put("sectordeatail_img_powerdeboosting", sectorDetailData.get(0).getSectordetail_img_powerdeboosting());
                jsonObject.put("sectordeatail_edt_DFS", sectorDetailData.get(0).getSectordetail_edt_DFS());
                jsonObject.put("sectordeatail_img_DFS", sectorDetailData.get(0).getSectordetail_img_DFS());
                jsonObject.put("sectordeatail_edt_rb_percell", sectorDetailData.get(0).getSectordetail_edt_rb_percell());
                jsonObject.put("sectordeatail_img_rb_percell", sectorDetailData.get(0).getSectordetail_img_rb_percell());
                jsonObject.put("sectordeatail_edt_m_mimo", sectorDetailData.get(0).getSectordetail_edt_m_mimo());
                jsonObject.put("sectordeatail_img_m_mimo", sectorDetailData.get(0).getSectordetail_img_m_mimo());
                jsonObject.put("sectordeatail_edt_FCT", sectorDetailData.get(0).getSectordetail_edt_FCT());
                jsonObject.put("sectordeatail_img_FCT", sectorDetailData.get(0).getSectordetail_img_FCT());
                jsonObject.put("sectordeatail_edt_JCT", sectorDetailData.get(0).getSectordetail_edt_JCT());
                jsonObject.put("sectordeatail_img_JCT", sectorDetailData.get(0).getSectordetail_img_JCT());
                jsonObject.put("sectordeatail_edt_FCL", sectorDetailData.get(0).getSectordetail_edt_FCL());
                jsonObject.put("sectordeatail_img_FCL", sectorDetailData.get(0).getSectordetail_img_FCL());
                jsonObject.put("sectordeatail_edt_jumperlength", sectorDetailData.get(0).getSectordetail_edt_jumperlength());
                jsonObject.put("sectordeatail_img_jumperlength", sectorDetailData.get(0).getSectordetail_img_jumperlength());
                jsonObject.put("sectordeatail_edt_prachconfig_index", sectorDetailData.get(0).getSectordetail_edt_prachconfig_index());
                jsonObject.put("sectordeatail_img_prachconfig_index", sectorDetailData.get(0).getSectordetail_img_prachconfig_index());
                jsonObject.put("sectordeatail_edt_carrieraggregation", sectorDetailData.get(0).getSectordetail_edt_carrieraggregation());
                jsonObject.put("sectordeatail_img_carrieraggregation", sectorDetailData.get(0).getSectordetail_img_carrieraggregation());
                jsonObject.put("sectordeatail_edt_ACD", sectorDetailData.get(0).getSectordetail_edt_ACD());
                jsonObject.put("sectordeatail_img_ACD", sectorDetailData.get(0).getSectordetail_img_ACD());
                jsonObject.put("sectordeatail_edt_VSWRtest", sectorDetailData.get(0).getSectordetail_edt_VSWRtest());
                jsonObject.put("sectordeatail_img_VSWRtest", sectorDetailData.get(0).getSectordetail_img_VSWRtest());
                jsonObject.put("sectordeatail_edt_URS", sectorDetailData.get(0).getSectordetail_edt_URS());
                jsonObject.put("sectordeatail_img_URS", sectorDetailData.get(0).getSectordetail_img_URS());
                jsonObject.put("sectordeatail_edt_extra1", sectorDetailData.get(0).getSectordetail_edt_extra1());
                jsonObject.put("sectordeatail_img_extra1", sectorDetailData.get(0).getSectordetail_img_extra1());
                jsonObject.put("sectordeatail_edt_extra2", sectorDetailData.get(0).getSectordetail_edt_extra2());
                jsonObject.put("sectordeatail_img_extra2", sectorDetailData.get(0).getSectordetail_img_extra2());
                jsonObject.put("sectordeatail_edt_remark1", sectorDetailData.get(0).getSectordetail_edt_remak1());
                jsonObject.put("sectordeatail_img_remark1", sectorDetailData.get(0).getSectordetail_img_remark1());
                jsonObject.put("sectordeatail_edt_remark2", sectorDetailData.get(0).getSectordetail_edt_remak2());
                jsonObject.put("sectordeatail_img_remark2", sectorDetailData.get(0).getSectordetail_img_remark2());
                jsonObject.put("sectordeatailfrgamentname", sectorDetailData.get(0).getSectordetailfrgamentname());
                jsonObject.put("flag", sectorDetailData.get(0).getFlag());
                // jsonObject.put("date", sectorDetailData.get(0).getDate());

                jsonObject.put("date", sharedPreferences.getString(AppConstants.DATE));
                jsonObject.put("empid", sharedPreferences.getString(AppConstants.EMPID));
                jsonObject.put("siteid", sharedPreferences.getString(AppConstants.SITEID));
                jsonObject.put("idall",sharedPreferences.getString(AppConstants.surveytpeandcustomerandoperator));

                jsonObject.put("Baseband_Unit_Type", sectorDetailData.get(0).getSdbasebandUnitType_edt());
                jsonObject.put("RNC_Name", sectorDetailData.get(0).getSdrNCName_edt());
                jsonObject.put("No_of_Channel_Elements", sectorDetailData.get(0).getSdnoofChannelElements_edt());
                jsonObject.put("Baseband_Unit_Type_img", sectorDetailData.get(0).getSdbasebandUnitType_img());
                jsonObject.put("RNC_Name_img", sectorDetailData.get(0).getSdrNCName_img());
                jsonObject.put("No_of_Channel_Elements_img", sectorDetailData.get(0).getSdnoofChannelElements_img());
            }catch (Exception e){
                Log.e("Exception",e.toString());
            }
        }
        return jsonObject;
    }
    private void toSendDataSectorDetail2(String secname) {
        //  +"?Loginid="+empId+"&password="+empPassword+"&imeno="+"1234567890"
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        pDialog.show();
        Log.v("jsonobjectsectordetail2",jsondataSectorDetail2(secname).toString());
        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.SECTORDETAIL,jsondataSectorDetail2(secname),
                new Response.Listener<JSONArray>() {


                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponseSectorDetail2(response.toString());
                        Log.v("response_sectordetail2", response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("response errorsectordetail2", error.toString());
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
    private void parseSettingResponseSectorDetail2(String s) {
        try {
            JSONArray jsonArray = new JSONArray(s);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String status = jsonObject.getString("Status");
            Toast.makeText(getActivity(),status + "Sector Detail2",Toast.LENGTH_LONG).show();
            tv_show_status.append("Sector Detail2 :" +status+"\n");
            // String password = jsonObject.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //..........................end SectorDetail 2

    //..........................SectorDetail 3
    private JSONObject jsondataSectorDetail3(String secname){
        JSONObject jsonObject = new JSONObject();
        List<SectorDetailData> sectorDetailData = db.getLastSectordetail(secname);
        if(sectorDetailData.size()>0){
            Log.v("OtherFragSectorDetail3",sectorDetailData.toString());
            try {
                jsonObject.put("sectordetail_edt_techavailable", sectorDetailData.get(0).getSectordetail_edt_techavailable());
                jsonObject.put("sectordetail_img_techavailable", sectorDetailData.get(0).getSectordetail_img_techavailable());
                jsonObject.put("sectordetail_edt_bandavailable", sectorDetailData.get(0).getSectordetail_edt_bandavailable());
                jsonObject.put("sectordeatail_img_bandavailable", sectorDetailData.get(0).getSectordetail_img_bandavailable());
                jsonObject.put("sectordeatail_edt_APC", sectorDetailData.get(0).getSectordetail_edt_APC());
                jsonObject.put("sectordeatail_img_APC", sectorDetailData.get(0).getSectordetail_img_APC());
                jsonObject.put("sectoreatail_edt_preazimuth", sectorDetailData.get(0).getSectoreatail_edt_preazimuth());
                jsonObject.put("sectordeatail_img_preazimuth", sectorDetailData.get(0).getSectordetail_img_preazimuth());
                jsonObject.put("sectordeatail_edt_postazimuth", sectorDetailData.get(0).getSectordetail_edt_postazimuth());
                jsonObject.put("sectordeatail_img_postazimuth", sectorDetailData.get(0).getSectordetail_img_postazimuth());
                jsonObject.put("sectordeatail_edt_premechanical_tilt", sectorDetailData.get(0).getSectordetail_edt_premechanical_tilt());
                jsonObject.put("sectordeatail_img_premechanical_tilt", sectorDetailData.get(0).getSectordetail_img_premechanical_tilt());
                jsonObject.put("sectordeatail_edt_postmechanical_tilt", sectorDetailData.get(0).getSectordetail_edt_postmechanical_tilt());
                jsonObject.put("sectordeatail_img_postmechanical_tilt", sectorDetailData.get(0).getSectordetail_img_postmechanical_tilt());
                jsonObject.put("sectordeatail_edt_preelectrical_tilt2g", sectorDetailData.get(0).getSectordetail_edt_preelectrical_tilt2g());
                jsonObject.put("sectordeatail_img_preelectrical_tilt2g", sectorDetailData.get(0).getSectordetail_img_preelectrical_tilt2g());
                jsonObject.put("sectordeatail_edt_postelectrical_tilt2g", sectorDetailData.get(0).getSectordetail_edt_postelectrical_tilt2g());
                jsonObject.put("sectordeatail_img_postelectrical_tilt2g", sectorDetailData.get(0).getSectordetail_img_postelectrical_tilt2g());
                jsonObject.put("sectordeatail_edt_preelectrical_tilt3g", sectorDetailData.get(0).getSectordetail_edt_preelectrical_tilt3g());
                jsonObject.put("sectordeatail_img_pretelectrical_tilt3g", sectorDetailData.get(0).getSectordetail_img_pretelectrical_tilt3g());
                jsonObject.put("sectordeatail_edt_postelectrical_tilt3g", sectorDetailData.get(0).getSectordetail_edt_postelectrical_tilt3g());
                jsonObject.put("sectordeatail_img_postelectrical_tilt3g", sectorDetailData.get(0).getSectordetail_img_postelectrical_tilt3g());
                jsonObject.put("sectordeatail_edt_preelectrical_tilt4gf1", sectorDetailData.get(0).getSectordetail_edt_preelectrical_tilt4gf1());
                jsonObject.put("sectordeatail_img_preelectrical_tilt4gf1", sectorDetailData.get(0).getSectordetail_img_preelectrical_tilt4gf1());
                jsonObject.put("sectordeatail_edt_postelectrical_tilt4gf1", sectorDetailData.get(0).getSectordetail_edt_postelectrical_tilt4gf1());
                jsonObject.put("sectordeatail_img_postelectrical_tilt4gf1", sectorDetailData.get(0).getSectordetail_img_postelectrical_tilt4gf1());
                jsonObject.put("sectordeatail_edt_preelectrical_tilt4gf2", sectorDetailData.get(0).getSectordetail_edt_preelectrical_tilt4gf2());
                jsonObject.put("sectordeatail_img_preelectrical_tilt4gf2", sectorDetailData.get(0).getSectordetail_img_preelectrical_tilt4gf2());
                jsonObject.put("sectordeatail_edt_postelectrical_tilt4gf2", sectorDetailData.get(0).getSectordetail_edt_postelectrical_tilt4gf2());
                jsonObject.put("sectordeatail_img_postelectrical_tilt4gf2", sectorDetailData.get(0).getSectordetail_img_postelectrical_tilt4gf2());
                jsonObject.put("sectordeatail_edt_preelectrical_tilt", sectorDetailData.get(0).getSectordetail_edt_preelectrical_tilt());
                jsonObject.put("sectordeatail_img_preelectrical_tilt", sectorDetailData.get(0).getSectordetail_img_preelectrical_tilt());
                jsonObject.put("sectordeatail_edt_postelectrical_tilt", sectorDetailData.get(0).getSectordetail_edt_postelectrical_tilt());
                jsonObject.put("sectordeatail_img_postelectrical_tilt", sectorDetailData.get(0).getSectordetail_img_postelectrical_tilt());
                jsonObject.put("sectordeatail_edt_antennaheight", sectorDetailData.get(0).getSectordetail_edt_antennaheight());
                jsonObject.put("sectordeatail_img_antennaheight", sectorDetailData.get(0).getSectordetail_img_antennaheight());
                jsonObject.put("sectordeatail_edt_poleheight", sectorDetailData.get(0).getSectordetail_edt_poleheight());
                jsonObject.put("sectordeatail_img_poleheight", sectorDetailData.get(0).getSectordetail_img_poleheight());
                jsonObject.put("sectordeatail_edt_buildingheight", sectorDetailData.get(0).getSectordetail_edt_buildingheight());
                jsonObject.put("sectordeatail_img_buildingheight", sectorDetailData.get(0).getSectordetail_img_buildingheight());
                jsonObject.put("sectordeatail_edt_towertype", sectorDetailData.get(0).getSectordetail_edt_towertype());
                jsonObject.put("sectordeatail_img_towertype", sectorDetailData.get(0).getSectordetail_img_towertype());
                jsonObject.put("sectordeatail_edt_antennamake", sectorDetailData.get(0).getSectordetail_edt_antennamake());
                jsonObject.put("sectordeatail_img_antennamake", sectorDetailData.get(0).getSectordetail_img_antennamake());
                jsonObject.put("sectordeatail_edt_antenmodel", sectorDetailData.get(0).getSectordetail_edt_antenmodel());
                jsonObject.put("sectordeatail_img_antennamodel", sectorDetailData.get(0).getSectordetail_img_antennamodel());
                jsonObject.put("sectordeatail_edt_clutterpic", sectorDetailData.get(0).getSectordetail_edt_clutterpic());
                jsonObject.put("sectordeatail_img_clutterpic", sectorDetailData.get(0).getSectordetail_img_clutterpic());
                jsonObject.put("sectordeatail_edt_txbandwidth", sectorDetailData.get(0).getSectordetail_edt_txbandwidth());
                jsonObject.put("sectordeatail_img_txbandwidth", sectorDetailData.get(0).getSectordetail_img_txbandwidth());
                jsonObject.put("sectordeatail_edt_AST", sectorDetailData.get(0).getSectordetail_edt_AST());
                jsonObject.put("sectordeatail_img_AST", sectorDetailData.get(0).getSectordetail_img_AST());
                jsonObject.put("sectordeatail_edt_APST", sectorDetailData.get(0).getSectordetail_edt_APST());
                jsonObject.put("sectordeatail_img_APST", sectorDetailData.get(0).getSectordetail_img_APST());
                jsonObject.put("sectordeatail_edt_typ_enodeb", sectorDetailData.get(0).getSectordetail_edt_typ_enodeb());
                jsonObject.put("sectordeatail_img_typ_enodeb", sectorDetailData.get(0).getSectordetail_img_typ_enodeb());
                jsonObject.put("sectordeatail_edt_mimo", sectorDetailData.get(0).getSectordetail_edt_mimo());
                jsonObject.put("sectordeatail_img_mimo", sectorDetailData.get(0).getSectordetail_img_mimo());
                jsonObject.put("sectordeatail_edt_ret", sectorDetailData.get(0).getSectordetail_edt_ret());
                jsonObject.put("sectordeatail_img_ret", sectorDetailData.get(0).getSectordetail_img_ret());
                jsonObject.put("sectordeatail_edt_enodebband", sectorDetailData.get(0).getSectordetail_edt_enodebband());
                jsonObject.put("sectordeatail_img_enodebband", sectorDetailData.get(0).getSectordetail_img_enodebband());
                jsonObject.put("sectordeatail_edt_MOP", sectorDetailData.get(0).getSectordetail_edt_MOP());
                jsonObject.put("sectordeatail_img_MOP", sectorDetailData.get(0).getSectordetail_img_MOP());
                jsonObject.put("sectordeatail_edt_COP", sectorDetailData.get(0).getSectordetail_edt_COP());
                jsonObject.put("sectordeatail_img_COP", sectorDetailData.get(0).getSectordetail_img_COP());
                jsonObject.put("sectordeatail_edt_multiplexer_avail", sectorDetailData.get(0).getSectordetail_edt_multiplexer_avail());
                jsonObject.put("sectordeatail_img_multiplexer_avail", sectorDetailData.get(0).getSectordetail_img_multiplexer_avail());
                jsonObject.put("sectordeatail_edt_antennapicleg", sectorDetailData.get(0).getSectordetail_edt_antennapicleg());
                jsonObject.put("sectordeatail_img_antennapicleg", sectorDetailData.get(0).getSectordetail_img_antennapicleg());
                jsonObject.put("sectordeatail_edt_CRP", sectorDetailData.get(0).getSectordetail_edt_CRP());
                jsonObject.put("sectordeatail_img_CRP", sectorDetailData.get(0).getSectordetail_img_CRP());
                jsonObject.put("sectordeatail_edt_powerdeboosting", sectorDetailData.get(0).getSectordetail_edt_powerdeboosting());
                jsonObject.put("sectordeatail_img_powerdeboosting", sectorDetailData.get(0).getSectordetail_img_powerdeboosting());
                jsonObject.put("sectordeatail_edt_DFS", sectorDetailData.get(0).getSectordetail_edt_DFS());
                jsonObject.put("sectordeatail_img_DFS", sectorDetailData.get(0).getSectordetail_img_DFS());
                jsonObject.put("sectordeatail_edt_rb_percell", sectorDetailData.get(0).getSectordetail_edt_rb_percell());
                jsonObject.put("sectordeatail_img_rb_percell", sectorDetailData.get(0).getSectordetail_img_rb_percell());
                jsonObject.put("sectordeatail_edt_m_mimo", sectorDetailData.get(0).getSectordetail_edt_m_mimo());
                jsonObject.put("sectordeatail_img_m_mimo", sectorDetailData.get(0).getSectordetail_img_m_mimo());
                jsonObject.put("sectordeatail_edt_FCT", sectorDetailData.get(0).getSectordetail_edt_FCT());
                jsonObject.put("sectordeatail_img_FCT", sectorDetailData.get(0).getSectordetail_img_FCT());
                jsonObject.put("sectordeatail_edt_JCT", sectorDetailData.get(0).getSectordetail_edt_JCT());
                jsonObject.put("sectordeatail_img_JCT", sectorDetailData.get(0).getSectordetail_img_JCT());
                jsonObject.put("sectordeatail_edt_FCL", sectorDetailData.get(0).getSectordetail_edt_FCL());
                jsonObject.put("sectordeatail_img_FCL", sectorDetailData.get(0).getSectordetail_img_FCL());
                jsonObject.put("sectordeatail_edt_jumperlength", sectorDetailData.get(0).getSectordetail_edt_jumperlength());
                jsonObject.put("sectordeatail_img_jumperlength", sectorDetailData.get(0).getSectordetail_img_jumperlength());
                jsonObject.put("sectordeatail_edt_prachconfig_index", sectorDetailData.get(0).getSectordetail_edt_prachconfig_index());
                jsonObject.put("sectordeatail_img_prachconfig_index", sectorDetailData.get(0).getSectordetail_img_prachconfig_index());
                jsonObject.put("sectordeatail_edt_carrieraggregation", sectorDetailData.get(0).getSectordetail_edt_carrieraggregation());
                jsonObject.put("sectordeatail_img_carrieraggregation", sectorDetailData.get(0).getSectordetail_img_carrieraggregation());
                jsonObject.put("sectordeatail_edt_ACD", sectorDetailData.get(0).getSectordetail_edt_ACD());
                jsonObject.put("sectordeatail_img_ACD", sectorDetailData.get(0).getSectordetail_img_ACD());
                jsonObject.put("sectordeatail_edt_VSWRtest", sectorDetailData.get(0).getSectordetail_edt_VSWRtest());
                jsonObject.put("sectordeatail_img_VSWRtest", sectorDetailData.get(0).getSectordetail_img_VSWRtest());
                jsonObject.put("sectordeatail_edt_URS", sectorDetailData.get(0).getSectordetail_edt_URS());
                jsonObject.put("sectordeatail_img_URS", sectorDetailData.get(0).getSectordetail_img_URS());
                jsonObject.put("sectordeatail_edt_extra1", sectorDetailData.get(0).getSectordetail_edt_extra1());
                jsonObject.put("sectordeatail_img_extra1", sectorDetailData.get(0).getSectordetail_img_extra1());
                jsonObject.put("sectordeatail_edt_extra2", sectorDetailData.get(0).getSectordetail_edt_extra2());
                jsonObject.put("sectordeatail_img_extra2", sectorDetailData.get(0).getSectordetail_img_extra2());
                jsonObject.put("sectordeatail_edt_remark1", sectorDetailData.get(0).getSectordetail_edt_remak1());
                jsonObject.put("sectordeatail_img_remark1", sectorDetailData.get(0).getSectordetail_img_remark1());
                jsonObject.put("sectordeatail_edt_remark2", sectorDetailData.get(0).getSectordetail_edt_remak2());
                jsonObject.put("sectordeatail_img_remark2", sectorDetailData.get(0).getSectordetail_img_remark2());
                jsonObject.put("sectordeatailfrgamentname", sectorDetailData.get(0).getSectordetailfrgamentname());
                jsonObject.put("flag", sectorDetailData.get(0).getFlag());
                // jsonObject.put("date", sectorDetailData.get(0).getDate());

                jsonObject.put("date", sharedPreferences.getString(AppConstants.DATE));
                jsonObject.put("empid", sharedPreferences.getString(AppConstants.EMPID));
                jsonObject.put("siteid", sharedPreferences.getString(AppConstants.SITEID));
                jsonObject.put("idall",sharedPreferences.getString(AppConstants.surveytpeandcustomerandoperator));

                jsonObject.put("Baseband_Unit_Type", sectorDetailData.get(0).getSdbasebandUnitType_edt());
                jsonObject.put("RNC_Name", sectorDetailData.get(0).getSdrNCName_edt());
                jsonObject.put("No_of_Channel_Elements", sectorDetailData.get(0).getSdnoofChannelElements_edt());
                jsonObject.put("Baseband_Unit_Type_img", sectorDetailData.get(0).getSdbasebandUnitType_img());
                jsonObject.put("RNC_Name_img", sectorDetailData.get(0).getSdrNCName_img());
                jsonObject.put("No_of_Channel_Elements_img", sectorDetailData.get(0).getSdnoofChannelElements_img());
            }catch (Exception e){
                Log.e("Exception",e.toString());
            }
        }
        return jsonObject;
    }
    private void toSendDataSectorDetail3(String secname) {
        //  +"?Loginid="+empId+"&password="+empPassword+"&imeno="+"1234567890"
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        pDialog.show();
        Log.v("jsonobjectsectordetail3",jsondataSectorDetail3(secname).toString());
        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.SECTORDETAIL,jsondataSectorDetail3(secname),
                new Response.Listener<JSONArray>() {


                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponseSectorDetail3(response.toString());
                        Log.v("response_sectordetail3", response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("response errorsectordetail3", error.toString());
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
    private void parseSettingResponseSectorDetail3(String s) {
        try {
            JSONArray jsonArray = new JSONArray(s);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String status = jsonObject.getString("Status");
            Toast.makeText(getActivity(),status + "Sector Detail3",Toast.LENGTH_LONG).show();
            tv_show_status.append("Sector Detail3 :" +status+"\n");
            // String password = jsonObject.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //..........................end SectorDetail 3

    //..........................SectorDetail 4
    private JSONObject jsondataSectorDetail4(String secname){
        JSONObject jsonObject = new JSONObject();
        List<SectorDetailData> sectorDetailData = db.getLastSectordetail(secname);
        if(sectorDetailData.size()>0){
            Log.v("OtherFragSectorDetail4",sectorDetailData.toString());
            try {
                jsonObject.put("sectordetail_edt_techavailable", sectorDetailData.get(0).getSectordetail_edt_techavailable());
                jsonObject.put("sectordetail_img_techavailable", sectorDetailData.get(0).getSectordetail_img_techavailable());
                jsonObject.put("sectordetail_edt_bandavailable", sectorDetailData.get(0).getSectordetail_edt_bandavailable());
                jsonObject.put("sectordeatail_img_bandavailable", sectorDetailData.get(0).getSectordetail_img_bandavailable());
                jsonObject.put("sectordeatail_edt_APC", sectorDetailData.get(0).getSectordetail_edt_APC());
                jsonObject.put("sectordeatail_img_APC", sectorDetailData.get(0).getSectordetail_img_APC());
                jsonObject.put("sectoreatail_edt_preazimuth", sectorDetailData.get(0).getSectoreatail_edt_preazimuth());
                jsonObject.put("sectordeatail_img_preazimuth", sectorDetailData.get(0).getSectordetail_img_preazimuth());
                jsonObject.put("sectordeatail_edt_postazimuth", sectorDetailData.get(0).getSectordetail_edt_postazimuth());
                jsonObject.put("sectordeatail_img_postazimuth", sectorDetailData.get(0).getSectordetail_img_postazimuth());
                jsonObject.put("sectordeatail_edt_premechanical_tilt", sectorDetailData.get(0).getSectordetail_edt_premechanical_tilt());
                jsonObject.put("sectordeatail_img_premechanical_tilt", sectorDetailData.get(0).getSectordetail_img_premechanical_tilt());
                jsonObject.put("sectordeatail_edt_postmechanical_tilt", sectorDetailData.get(0).getSectordetail_edt_postmechanical_tilt());
                jsonObject.put("sectordeatail_img_postmechanical_tilt", sectorDetailData.get(0).getSectordetail_img_postmechanical_tilt());
                jsonObject.put("sectordeatail_edt_preelectrical_tilt2g", sectorDetailData.get(0).getSectordetail_edt_preelectrical_tilt2g());
                jsonObject.put("sectordeatail_img_preelectrical_tilt2g", sectorDetailData.get(0).getSectordetail_img_preelectrical_tilt2g());
                jsonObject.put("sectordeatail_edt_postelectrical_tilt2g", sectorDetailData.get(0).getSectordetail_edt_postelectrical_tilt2g());
                jsonObject.put("sectordeatail_img_postelectrical_tilt2g", sectorDetailData.get(0).getSectordetail_img_postelectrical_tilt2g());
                jsonObject.put("sectordeatail_edt_preelectrical_tilt3g", sectorDetailData.get(0).getSectordetail_edt_preelectrical_tilt3g());
                jsonObject.put("sectordeatail_img_pretelectrical_tilt3g", sectorDetailData.get(0).getSectordetail_img_pretelectrical_tilt3g());
                jsonObject.put("sectordeatail_edt_postelectrical_tilt3g", sectorDetailData.get(0).getSectordetail_edt_postelectrical_tilt3g());
                jsonObject.put("sectordeatail_img_postelectrical_tilt3g", sectorDetailData.get(0).getSectordetail_img_postelectrical_tilt3g());
                jsonObject.put("sectordeatail_edt_preelectrical_tilt4gf1", sectorDetailData.get(0).getSectordetail_edt_preelectrical_tilt4gf1());
                jsonObject.put("sectordeatail_img_preelectrical_tilt4gf1", sectorDetailData.get(0).getSectordetail_img_preelectrical_tilt4gf1());
                jsonObject.put("sectordeatail_edt_postelectrical_tilt4gf1", sectorDetailData.get(0).getSectordetail_edt_postelectrical_tilt4gf1());
                jsonObject.put("sectordeatail_img_postelectrical_tilt4gf1", sectorDetailData.get(0).getSectordetail_img_postelectrical_tilt4gf1());
                jsonObject.put("sectordeatail_edt_preelectrical_tilt4gf2", sectorDetailData.get(0).getSectordetail_edt_preelectrical_tilt4gf2());
                jsonObject.put("sectordeatail_img_preelectrical_tilt4gf2", sectorDetailData.get(0).getSectordetail_img_preelectrical_tilt4gf2());
                jsonObject.put("sectordeatail_edt_postelectrical_tilt4gf2", sectorDetailData.get(0).getSectordetail_edt_postelectrical_tilt4gf2());
                jsonObject.put("sectordeatail_img_postelectrical_tilt4gf2", sectorDetailData.get(0).getSectordetail_img_postelectrical_tilt4gf2());
                jsonObject.put("sectordeatail_edt_preelectrical_tilt", sectorDetailData.get(0).getSectordetail_edt_preelectrical_tilt());
                jsonObject.put("sectordeatail_img_preelectrical_tilt", sectorDetailData.get(0).getSectordetail_img_preelectrical_tilt());
                jsonObject.put("sectordeatail_edt_postelectrical_tilt", sectorDetailData.get(0).getSectordetail_edt_postelectrical_tilt());
                jsonObject.put("sectordeatail_img_postelectrical_tilt", sectorDetailData.get(0).getSectordetail_img_postelectrical_tilt());
                jsonObject.put("sectordeatail_edt_antennaheight", sectorDetailData.get(0).getSectordetail_edt_antennaheight());
                jsonObject.put("sectordeatail_img_antennaheight", sectorDetailData.get(0).getSectordetail_img_antennaheight());
                jsonObject.put("sectordeatail_edt_poleheight", sectorDetailData.get(0).getSectordetail_edt_poleheight());
                jsonObject.put("sectordeatail_img_poleheight", sectorDetailData.get(0).getSectordetail_img_poleheight());
                jsonObject.put("sectordeatail_edt_buildingheight", sectorDetailData.get(0).getSectordetail_edt_buildingheight());
                jsonObject.put("sectordeatail_img_buildingheight", sectorDetailData.get(0).getSectordetail_img_buildingheight());
                jsonObject.put("sectordeatail_edt_towertype", sectorDetailData.get(0).getSectordetail_edt_towertype());
                jsonObject.put("sectordeatail_img_towertype", sectorDetailData.get(0).getSectordetail_img_towertype());
                jsonObject.put("sectordeatail_edt_antennamake", sectorDetailData.get(0).getSectordetail_edt_antennamake());
                jsonObject.put("sectordeatail_img_antennamake", sectorDetailData.get(0).getSectordetail_img_antennamake());
                jsonObject.put("sectordeatail_edt_antenmodel", sectorDetailData.get(0).getSectordetail_edt_antenmodel());
                jsonObject.put("sectordeatail_img_antennamodel", sectorDetailData.get(0).getSectordetail_img_antennamodel());
                jsonObject.put("sectordeatail_edt_clutterpic", sectorDetailData.get(0).getSectordetail_edt_clutterpic());
                jsonObject.put("sectordeatail_img_clutterpic", sectorDetailData.get(0).getSectordetail_img_clutterpic());
                jsonObject.put("sectordeatail_edt_txbandwidth", sectorDetailData.get(0).getSectordetail_edt_txbandwidth());
                jsonObject.put("sectordeatail_img_txbandwidth", sectorDetailData.get(0).getSectordetail_img_txbandwidth());
                jsonObject.put("sectordeatail_edt_AST", sectorDetailData.get(0).getSectordetail_edt_AST());
                jsonObject.put("sectordeatail_img_AST", sectorDetailData.get(0).getSectordetail_img_AST());
                jsonObject.put("sectordeatail_edt_APST", sectorDetailData.get(0).getSectordetail_edt_APST());
                jsonObject.put("sectordeatail_img_APST", sectorDetailData.get(0).getSectordetail_img_APST());
                jsonObject.put("sectordeatail_edt_typ_enodeb", sectorDetailData.get(0).getSectordetail_edt_typ_enodeb());
                jsonObject.put("sectordeatail_img_typ_enodeb", sectorDetailData.get(0).getSectordetail_img_typ_enodeb());
                jsonObject.put("sectordeatail_edt_mimo", sectorDetailData.get(0).getSectordetail_edt_mimo());
                jsonObject.put("sectordeatail_img_mimo", sectorDetailData.get(0).getSectordetail_img_mimo());
                jsonObject.put("sectordeatail_edt_ret", sectorDetailData.get(0).getSectordetail_edt_ret());
                jsonObject.put("sectordeatail_img_ret", sectorDetailData.get(0).getSectordetail_img_ret());
                jsonObject.put("sectordeatail_edt_enodebband", sectorDetailData.get(0).getSectordetail_edt_enodebband());
                jsonObject.put("sectordeatail_img_enodebband", sectorDetailData.get(0).getSectordetail_img_enodebband());
                jsonObject.put("sectordeatail_edt_MOP", sectorDetailData.get(0).getSectordetail_edt_MOP());
                jsonObject.put("sectordeatail_img_MOP", sectorDetailData.get(0).getSectordetail_img_MOP());
                jsonObject.put("sectordeatail_edt_COP", sectorDetailData.get(0).getSectordetail_edt_COP());
                jsonObject.put("sectordeatail_img_COP", sectorDetailData.get(0).getSectordetail_img_COP());
                jsonObject.put("sectordeatail_edt_multiplexer_avail", sectorDetailData.get(0).getSectordetail_edt_multiplexer_avail());
                jsonObject.put("sectordeatail_img_multiplexer_avail", sectorDetailData.get(0).getSectordetail_img_multiplexer_avail());
                jsonObject.put("sectordeatail_edt_antennapicleg", sectorDetailData.get(0).getSectordetail_edt_antennapicleg());
                jsonObject.put("sectordeatail_img_antennapicleg", sectorDetailData.get(0).getSectordetail_img_antennapicleg());
                jsonObject.put("sectordeatail_edt_CRP", sectorDetailData.get(0).getSectordetail_edt_CRP());
                jsonObject.put("sectordeatail_img_CRP", sectorDetailData.get(0).getSectordetail_img_CRP());
                jsonObject.put("sectordeatail_edt_powerdeboosting", sectorDetailData.get(0).getSectordetail_edt_powerdeboosting());
                jsonObject.put("sectordeatail_img_powerdeboosting", sectorDetailData.get(0).getSectordetail_img_powerdeboosting());
                jsonObject.put("sectordeatail_edt_DFS", sectorDetailData.get(0).getSectordetail_edt_DFS());
                jsonObject.put("sectordeatail_img_DFS", sectorDetailData.get(0).getSectordetail_img_DFS());
                jsonObject.put("sectordeatail_edt_rb_percell", sectorDetailData.get(0).getSectordetail_edt_rb_percell());
                jsonObject.put("sectordeatail_img_rb_percell", sectorDetailData.get(0).getSectordetail_img_rb_percell());
                jsonObject.put("sectordeatail_edt_m_mimo", sectorDetailData.get(0).getSectordetail_edt_m_mimo());
                jsonObject.put("sectordeatail_img_m_mimo", sectorDetailData.get(0).getSectordetail_img_m_mimo());
                jsonObject.put("sectordeatail_edt_FCT", sectorDetailData.get(0).getSectordetail_edt_FCT());
                jsonObject.put("sectordeatail_img_FCT", sectorDetailData.get(0).getSectordetail_img_FCT());
                jsonObject.put("sectordeatail_edt_JCT", sectorDetailData.get(0).getSectordetail_edt_JCT());
                jsonObject.put("sectordeatail_img_JCT", sectorDetailData.get(0).getSectordetail_img_JCT());
                jsonObject.put("sectordeatail_edt_FCL", sectorDetailData.get(0).getSectordetail_edt_FCL());
                jsonObject.put("sectordeatail_img_FCL", sectorDetailData.get(0).getSectordetail_img_FCL());
                jsonObject.put("sectordeatail_edt_jumperlength", sectorDetailData.get(0).getSectordetail_edt_jumperlength());
                jsonObject.put("sectordeatail_img_jumperlength", sectorDetailData.get(0).getSectordetail_img_jumperlength());
                jsonObject.put("sectordeatail_edt_prachconfig_index", sectorDetailData.get(0).getSectordetail_edt_prachconfig_index());
                jsonObject.put("sectordeatail_img_prachconfig_index", sectorDetailData.get(0).getSectordetail_img_prachconfig_index());
                jsonObject.put("sectordeatail_edt_carrieraggregation", sectorDetailData.get(0).getSectordetail_edt_carrieraggregation());
                jsonObject.put("sectordeatail_img_carrieraggregation", sectorDetailData.get(0).getSectordetail_img_carrieraggregation());
                jsonObject.put("sectordeatail_edt_ACD", sectorDetailData.get(0).getSectordetail_edt_ACD());
                jsonObject.put("sectordeatail_img_ACD", sectorDetailData.get(0).getSectordetail_img_ACD());
                jsonObject.put("sectordeatail_edt_VSWRtest", sectorDetailData.get(0).getSectordetail_edt_VSWRtest());
                jsonObject.put("sectordeatail_img_VSWRtest", sectorDetailData.get(0).getSectordetail_img_VSWRtest());
                jsonObject.put("sectordeatail_edt_URS", sectorDetailData.get(0).getSectordetail_edt_URS());
                jsonObject.put("sectordeatail_img_URS", sectorDetailData.get(0).getSectordetail_img_URS());
                jsonObject.put("sectordeatail_edt_extra1", sectorDetailData.get(0).getSectordetail_edt_extra1());
                jsonObject.put("sectordeatail_img_extra1", sectorDetailData.get(0).getSectordetail_img_extra1());
                jsonObject.put("sectordeatail_edt_extra2", sectorDetailData.get(0).getSectordetail_edt_extra2());
                jsonObject.put("sectordeatail_img_extra2", sectorDetailData.get(0).getSectordetail_img_extra2());
                jsonObject.put("sectordeatail_edt_remark1", sectorDetailData.get(0).getSectordetail_edt_remak1());
                jsonObject.put("sectordeatail_img_remark1", sectorDetailData.get(0).getSectordetail_img_remark1());
                jsonObject.put("sectordeatail_edt_remark2", sectorDetailData.get(0).getSectordetail_edt_remak2());
                jsonObject.put("sectordeatail_img_remark2", sectorDetailData.get(0).getSectordetail_img_remark2());
                jsonObject.put("sectordeatailfrgamentname", sectorDetailData.get(0).getSectordetailfrgamentname());
                jsonObject.put("flag", sectorDetailData.get(0).getFlag());
                // jsonObject.put("date", sectorDetailData.get(0).getDate());

                jsonObject.put("date", sharedPreferences.getString(AppConstants.DATE));
                jsonObject.put("empid", sharedPreferences.getString(AppConstants.EMPID));
                jsonObject.put("siteid", sharedPreferences.getString(AppConstants.SITEID));
                jsonObject.put("idall",sharedPreferences.getString(AppConstants.surveytpeandcustomerandoperator));

                jsonObject.put("Baseband_Unit_Type", sectorDetailData.get(0).getSdbasebandUnitType_edt());
                jsonObject.put("RNC_Name", sectorDetailData.get(0).getSdrNCName_edt());
                jsonObject.put("No_of_Channel_Elements", sectorDetailData.get(0).getSdnoofChannelElements_edt());
                jsonObject.put("Baseband_Unit_Type_img", sectorDetailData.get(0).getSdbasebandUnitType_img());
                jsonObject.put("RNC_Name_img", sectorDetailData.get(0).getSdrNCName_img());
                jsonObject.put("No_of_Channel_Elements_img", sectorDetailData.get(0).getSdnoofChannelElements_img());

            }catch (Exception e){
                Log.e("Exception",e.toString());
            }
        }
        return jsonObject;
    }
    private void toSendDataSectorDetail4(String secname) {
        //  +"?Loginid="+empId+"&password="+empPassword+"&imeno="+"1234567890"
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        pDialog.show();
        Log.v("jsonobjectsectordetail4",jsondataSectorDetail4(secname).toString());
        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.SECTORDETAIL,jsondataSectorDetail4(secname),
                new Response.Listener<JSONArray>() {


                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponseSectorDetail4(response.toString());
                        Log.v("response_sectordetail4", response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("response errorsectordetail4", error.toString());
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
    private void parseSettingResponseSectorDetail4(String s) {
        try {
            JSONArray jsonArray = new JSONArray(s);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String status = jsonObject.getString("Status");
            Toast.makeText(getActivity(),status + "Sector Detail4",Toast.LENGTH_LONG).show();
            tv_show_status.append("Sector Detail4 :" +status+"\n");
            // String password = jsonObject.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //..........................end SectorDetail 4



    //......................................Start SitePanaromic........................
private JSONObject jsondataSitePanaromic(){
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

           /* jsonObject.put("btnBearing0Image", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePanoramicData.get(0).getBtnBearing0Image()), Bitmap.CompressFormat.JPEG, 100));
            jsonObject.put("btnBearing30Image",BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePanoramicData.get(0).getBtnBearing30Image()), Bitmap.CompressFormat.JPEG, 100) );
            jsonObject.put("btnBearing60Image",BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePanoramicData.get(0).getBtnBearing60Image()), Bitmap.CompressFormat.JPEG, 100) );
            jsonObject.put("btnBearing90Image",BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePanoramicData.get(0).getBtnBearing90Image()), Bitmap.CompressFormat.JPEG, 100));
            jsonObject.put("btnBearing120Image",BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePanoramicData.get(0).getBtnBearing120Image()), Bitmap.CompressFormat.JPEG, 100));
            jsonObject.put("btnBearing150Image",BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePanoramicData.get(0).getBtnBearing150Image()), Bitmap.CompressFormat.JPEG, 100) );
            jsonObject.put("btnBearing180Image",BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePanoramicData.get(0).getBtnBearing180Image()), Bitmap.CompressFormat.JPEG, 100));
            jsonObject.put("btnBearing210Image",BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePanoramicData.get(0).getBtnBearing210Image()), Bitmap.CompressFormat.JPEG, 100) );
            jsonObject.put("btnBearing240Image",BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePanoramicData.get(0).getBtnBearing240Image()), Bitmap.CompressFormat.JPEG, 100));
            jsonObject.put("btnBearing270Image",BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePanoramicData.get(0).getBtnBearing270Image()), Bitmap.CompressFormat.JPEG, 100));
            jsonObject.put("btnBearing300Image",BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePanoramicData.get(0).getBtnBearing300Image()), Bitmap.CompressFormat.JPEG, 100));
            jsonObject.put("btnBearing330Image",BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sitePanoramicData.get(0).getBtnBearing330Image()), Bitmap.CompressFormat.JPEG, 100));
*/
            jsonObject.put("inputBearin_extra1", sitePanoramicData.get(0).getInputBearin_extra1());
            jsonObject.put("inputBearin_extra2", sitePanoramicData.get(0).getInputBearin_extra2());
            jsonObject.put("inputBearin_remark1", sitePanoramicData.get(0).getInputBearin_remark1());
            jsonObject.put("inputBearin_remark2", sitePanoramicData.get(0).getInputBearin_remark2());
            jsonObject.put("flag", sitePanoramicData.get(0).getFlag());
          //  jsonObject.put("date", sitePanoramicData.get(0).getDate());

            jsonObject.put("date", sharedPreferences.getString(AppConstants.DATE));
            jsonObject.put("empid", sharedPreferences.getString(AppConstants.EMPID));
            jsonObject.put("siteid", sharedPreferences.getString(AppConstants.SITEID));
            jsonObject.put("idall",sharedPreferences.getString(AppConstants.surveytpeandcustomerandoperator));
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
    Log.v("jsonsitepanaromic",jsondataSitePanaromic().toString());
    JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
            AppConstants.SITEPANAROMIC,jsondataSitePanaromic(),
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
            tv_show_status.append("Site Panaromic :" +error.toString()+"\n");
            pDialog.hide();
        }

    });
    jsonObjReq.setRetryPolicy(new RetryPolicy() {
        @Override
        public int getCurrentTimeout() {
            return 90000;
        }

        @Override
        public int getCurrentRetryCount() {
            return 90000;
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
            Toast.makeText(getActivity(),status+" Site Panaromic",Toast.LENGTH_LONG).show();
            tv_show_status.append("Site Panaromic :" +status+"\n");
            // String password = jsonObject.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //......................................Start SitePanaromic........................
    private JSONObject jsondataOtherDetail(){
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
            jsonObject.put("empid",sharedPreferences.getString(AppConstants.EMPID));
            jsonObject.put("siteid",sharedPreferences.getString(AppConstants.SITEID));
            jsonObject.put("idall",sharedPreferences.getString(AppConstants.surveytpeandcustomerandoperator));

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
        Log.v("jsonotherdetail",jsondataOtherDetail().toString());
        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.OTHERDETAIL,jsondataOtherDetail(),
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
            Toast.makeText(getActivity(),status+"Other Detail",Toast.LENGTH_LONG).show();
            tv_show_status.append("Other Detail :" +status+"\n");
            // String password = jsonObject.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//.................................................................................



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
    private void onCameraSurfaceViewActivity(String  thumbnail, String name, String angle){

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

                iv_RiggerPic.setImageBitmap( BitmapFactory.decodeFile(thumbnail));
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

                iv_EngineerPic.setImageBitmap( BitmapFactory.decodeFile(thumbnail));
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

                iv_CarPic.setImageBitmap( BitmapFactory.decodeFile(thumbnail));
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

                iv_RiggerPicwithclimbingTower.setImageBitmap( BitmapFactory.decodeFile(thumbnail));
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

                iv_RiggerPicduringWah.setImageBitmap( BitmapFactory.decodeFile(thumbnail));
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

    // add 16/8/2019................................by deepak

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

    private void saveTextFileSiteDetail() {

        List<SiteDetailForm> siteDetailData = db.getLastSiteDetailData();
        try {
            //  String projectno= latLongDataList.get(0).getFormno().replace("/","");
            // Log.v("projectno",projectno);
            String h = DateFormat.format("MM-dd-yyyy-h-mmssaa", System.currentTimeMillis()).toString();
            // this will create a new name everytime and unique
            File root = new File(Environment.getExternalStorageDirectory()+ "/LHQTextData/");
            // if external memory exists and folder with name Notes
            if (!root.exists()) {
                root.mkdirs(); // this will create folder.
            }
            File filepath = new File(root, "SiteDetail"+h + ".txt");  // file path to save
            FileWriter writer = new FileWriter(filepath);
            for(SiteDetailForm data : siteDetailData) {
                writer.append(data.getId() +","+data.getSitename() +","+data.getTowersiteid()+","+data.getTowercompanyname() +","+data.getSiteaddress()
                        +","+data.getSectorid() +","+data.getLat() +","+data.getLog() +","+data.getSitetype() +","+data.getBuildingfloor()
                        +","+data.getBuildingheight() +","+data.getTowerheight() +","+data.getFulltowerphoto() +","+data.getNodebtype()
                        +","+data.getClassical() +","+data.getEnodebtype() +","+data.getAnchoroperator() +","+data.getSharingopco1()
                        +","+data.getSharingopco2() +","+data.getSharingopco3() +","+data.getInfraprovider() +","+data.getType_id_od()
                        +","+data.getInfrashared() +","+data.getExtra1() +","+data.getExtra2() +","+data.getRemark1() +","+data.getRemark2()
                        +","+data.getFlag() +","+sharedPreferences.getString(AppConstants.DATE)+","+ sharedPreferences.getString(AppConstants.EMPID)
                        +","+sharedPreferences.getString(AppConstants.SITEID) +","+sharedPreferences.getString(AppConstants.surveytpeandcustomerandoperator)
                );

                writer.append("\n\r");
            }
            writer.flush();
            writer.close();

            String path  =filepath.getPath();
            String m = "File generated with name " + path ;
            Toast.makeText(getActivity(),m,Toast.LENGTH_LONG).show();

           /* Intent intent =new Intent(getActivity(),SendMailActivity.class);
            intent.putExtra("attachmentpathgpsdata",path);
            startActivity(intent);*/

        } catch (IOException e) {
            Toast.makeText(getActivity(),"error",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
    private void saveTextFileSurveyDetail() {

        List<SurveyForm> surveyDetailData = db.getLastSurveyformData();
        try {
            //  String projectno= latLongDataList.get(0).getFormno().replace("/","");
            // Log.v("projectno",projectno);
            String h = DateFormat.format("MM-dd-yyyy-h-mmssaa", System.currentTimeMillis()).toString();
            // this will create a new name everytime and unique
            File root = new File(Environment.getExternalStorageDirectory()+ "/LHQTextData/");
            // if external memory exists and folder with name Notes
            if (!root.exists()) {
                root.mkdirs(); // this will create folder.
            }
            File filepath = new File(root, "SiteDetail"+h + ".txt");  // file path to save
            FileWriter writer = new FileWriter(filepath);
            for(SurveyForm data : surveyDetailData) {

                writer.append(data.getId() +","+data.getSurveytype() +","+data.getCustomer()+","+data.getOperator() +","+data.getCircle() +","+data.getTechnology()
                        +","+data.getTechnologytype() +","+data.getLat() +","+data.getLog() +","+data.getLocation() +","+data.getSiteid()
                        +","+data.getCusterid()
                        +","+data.getFlag() +","+sharedPreferences.getString(AppConstants.DATE)+","+ sharedPreferences.getString(AppConstants.EMPID)
                        +","+sharedPreferences.getString(AppConstants.SITEID) +","+sharedPreferences.getString(AppConstants.surveytpeandcustomerandoperator)
                );

                writer.append("\n\r");
            }
            writer.flush();
            writer.close();

            String path  =filepath.getPath();
            String m = "File generated with name " + path ;
            Toast.makeText(getActivity(),m,Toast.LENGTH_LONG).show();

           /* Intent intent =new Intent(getActivity(),SendMailActivity.class);
            intent.putExtra("attachmentpathgpsdata",path);
            startActivity(intent);*/

        } catch (IOException e) {
            Toast.makeText(getActivity(),"error",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
    // add 19/8/2019................................by deepak
    public class ftpConnect_Send {
        ProgressDialog pd = new ProgressDialog(getActivity(), R.style.AppCompatAlertDialogStyle);
        public void uploadFile(File fileName) {

            FTPClient client = new FTPClient();
            try {
                pd.show();
                client.connect(AppConstants.FTP_HOST, 21);
                client.login(AppConstants.FTP_USER, AppConstants.FTP_PASS);
                client.setType(FTPClient.TYPE_BINARY);
                // client.changeDirectory("TNSSOFT Folder");

                try {

                    // client.changeDirectory("/upload/"); //I want to upload picture in MyPictures directory/folder. you can use your own.
                } catch (Exception e) {

                    //client.createDirectory("/upload/");
                    // client.changeDirectory("/upload/");
                }
                Log.v("ftpimglog",fileName.getAbsolutePath());
                client.upload(fileName, new MyTransferListener_Send());

            } catch (Exception e) {

                pd.dismiss();

                e.printStackTrace();
                try {
                    client.disconnect(true);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

        }

    }


    /*******
     * Used to file upload and show progress
     **********/


    private class MyTransferListener_Send implements FTPDataTransferListener {

        public void started() {

            // Transfer started
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    //    Toast.makeText(getActivity(), " Upload Started ...", Toast.LENGTH_SHORT).show();
                }
            });

            //System.out.println(" Upload Started ...");
        }

        public void transferred(final int length) {


            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    //   Toast.makeText(getActivity(), " transferred ..." + length, Toast.LENGTH_SHORT).show();
                }
            });


            // Yet other length bytes has been transferred since the last time this
            // method was called

            //System.out.println(" transferred ..." + length);
        }

        public void completed() {

            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    Toast.makeText(getActivity(), " images upload successfully ...", Toast.LENGTH_SHORT).show();
                    Log.v("Capture send  ", "Completed");
                    //  progressDialog.dismiss();
                }
            });

            // Transfer completed


            //System.out.println(" completed ..." );
        }

        public void aborted() {

            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    Toast.makeText(getActivity(), " transfer aborted , please try again...", Toast.LENGTH_SHORT).show();
                    // progressDialog.dismiss();
                }
            });

            // Transfer aborted

            //System.out.println(" aborted ..." );
        }

        public void failed() {

            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getActivity(), " failed...", Toast.LENGTH_SHORT).show();
                    // progressDialog.dismiss();

                }
            });

            // Transfer failed
            System.out.println(" failed ...");
        }

    }


}
