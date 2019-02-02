package com.linkquest.lhq.LOSAudit;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import com.linkquest.lhq.GoogleGPSService;
import com.linkquest.lhq.R;
import com.linkquest.lhq.activity.CameraSurfaceViewActivity;
import com.linkquest.lhq.database.DatabaseHandler;
import com.linkquest.lhq.database.LOSSiteDetailData;

import java.io.ByteArrayOutputStream;

import static android.app.Activity.RESULT_CANCELED;


/**
 * A simple {@link Fragment} subclass.
 */
public class LOSDetailFragment extends Fragment implements View.OnClickListener {

    private EditText edt_SiteID;
    private  EditText edt_SiteName;
    private  EditText  edt_Sharing;
    private  EditText  edt_SiteType;
    private  EditText edt_SurveyDate;
    private  EditText  edt_TNPEngineer;
    private  EditText edt_TNPEngineerTel;
    private  EditText edt_Customerrepresentative;
    private  EditText edt_Nearenddetails;
    private  EditText edt_Lat;
    private  EditText edt_Long;
    private  EditText edt_CandidateName;
    private  EditText edt_Address;
    private  EditText edt_Bldght;
    private  EditText edt_Totalht;
    private  EditText edt_AMSL;
    private  EditText edt_Buildingsideviewphoto;
    private  EditText edt_AntennaTowerlocationphoto;
    private  EditText edt_Possibleobstacle;
    private  EditText edt_HeightofObstruction;
    private  EditText edt_PanaromicPhoto;
    private  EditText edt_ExisitngNoofMWAntennatypewithsizeandPhotograph;
    private  EditText edt_ExisitngMWAntennaheightandPolemountPhotograph;
   //...............add 2/02/19
    private EditText edt_Commentsaddnew;
    private EditText edt_MWAntennaht;
    private EditText edt_towerexistingnew;
    private EditText edt_Towertype;
    private EditText edt_remarks;


    private ImageView iv_SiteID;
    private  ImageView iv_SiteName;
    private  ImageView  iv_Sharing;
    private  ImageView  iv_SiteType;
    private  ImageView iv_SurveyDate;
    private  ImageView  iv_TNPEngineer;
    private  ImageView iv_TNPEngineerTel;
    private  ImageView iv_Customerrepresentative;
    private  ImageView iv_Nearenddetails;
    private  ImageView iv_Lat;
    private  ImageView iv_Long;
    private  ImageView iv_CandidateName;
    private  ImageView iv_Address;
    private  ImageView iv_Bldght;
    private  ImageView iv_Totalht;
    private  ImageView iv_AMSL;
    private ImageView iv_Buildingsideviewphoto;
    private  ImageView iv_AntennaTowerlocationphoto;
    private  ImageView iv_Possibleobstacle;
    private  ImageView iv_HeightofObstruction;
    private  ImageView iv_PanaromicPhoto;
    private  ImageView iv_ExisitngNoofMWAntennatypewithsizeandPhotograph;
    private  ImageView iv_ExisitngMWAntennaheightandPolemountPhotograph;
    //  add 2/02/2019........................
    private ImageView  iv_Commentsaddnew;
    private ImageView  iv_MWAntennaht;
    private ImageView  iv_towerexistingnew;
    private ImageView  iv_Towertype;
    private ImageView  iv_remarks;


    private ImageButton ib_SiteID;
    private  ImageButton ib_SiteName;
    private  ImageButton  ib_Sharing;
    private  ImageButton  ib_SiteType;
    private  ImageButton ib_SurveyDate;
    private  ImageButton  ib_TNPEngineer;
    private  ImageButton ib_TNPEngineerTel;
    private  ImageButton ib_Customerrepresentative;
    private  ImageButton ib_Nearenddetails;
    private  ImageButton ib_CandidateName;
    private  ImageButton ib_Address;
    private  ImageButton ib_Bldght;
    private  ImageButton ib_Totalht;
    private  ImageButton ib_AMSL;
    private  ImageButton ib_Buildingsideviewphoto;
    private  ImageButton ib_AntennaTowerlocationphoto;
    private  ImageButton ib_Possibleobstacle;
    private  ImageButton ib_HeightofObstruction;
    private  ImageButton ib_PanaromicPhoto;
    private  ImageButton ib_ExisitngNoofMWAntennatypewithsizeandPhotograph;
    private ImageButton ib_ExisitngMWAntennaheightandPolemountPhotograph;
    //  add 2/02/2019........................
    private ImageButton ib_Commentsaddnew;
    private ImageButton ib_MWAntennaht;
    private ImageButton ib_towerexistingnew;
    private ImageButton ib_Towertype;
    private ImageButton ib_remarks;

    private String img_SiteID= "";
    private  String img_SiteName= "";
    private  String  img_Sharing= "";
    private  String  img_SiteType= "";
    private  String img_SurveyDate= "";
    private  String img_TNPEngineer= "";
    private  String img_TNPEngineerTel= "";
    private  String img_Customerrepresentative="";
    private  String img_Nearenddetails= "";
    private  String img_CandidateName="";
    private  String img_Address= "";
    private  String img_Bldght= "";
    private  String img_Totalht= "";
    private  String img_AMSL= "";
    private  String img_Buildingsideviewphoto="";
    private  String img_AntennaTowerlocationphoto= "";
    private  String img_Possimgleobstacle= "";
    private  String img_HeightofObstruction= "";
    private  String img_PanaromicPhoto= "";
    private  String img_ExisitngNoofMWAntennatypewithsizeandPhotograph= "";
    private  String img_ExisitngMWAntennaheightandPolemountPhotograph= "";
    //  add 2/02/2019........................
    private String img_Commentsaddnew ="";
    private String img_MWAntennaht ="";
    private String img_towerexistingnew ="";
    private String img_Towertype ="";
    private String img_remarks ="";

    private  String lat, log;
    private DatabaseHandler db;
    private Button btn_save,btnlosdetail_next;
    private TextView tv_previouscount,tv_aftercount;
    private Handler handler;
    private String time;




    public LOSDetailFragment() {
        // Required empty public constructor
    }


    public static LOSDetailFragment newInstance(int index, String name) {
        LOSDetailFragment f = new LOSDetailFragment();
        Bundle args = new Bundle();
        args.putInt("index", index);
        args.putString("name", name);
        f.setArguments(args);
        return f;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_losdetail, container, false);
          db = new DatabaseHandler(getActivity());
         handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                time = DateFormat.format("dd-MM-yyyy h:mm:ss:aa", System.currentTimeMillis()).toString();
                handler.postDelayed(this, 1000);
            }

        }, 1000);
        findIds(v);

        int precount = db.getCountLosSiteDetail();
        tv_previouscount.setText(tv_previouscount.getText().toString()+precount+"");

        return v;
    }

    private void findIds(View v){
        edt_SiteID = v.findViewById(R.id.losdetail_edt_site_id);
        edt_SiteName =v.findViewById(R.id.losdetail_edt_site_name) ;
        edt_Sharing = v.findViewById(R.id.losdetail_edt_sharing);
        edt_SiteType= v.findViewById(R.id.losdetail_edt_sitetype);
        edt_SurveyDate = v.findViewById(R.id.losdetail_edt_surveydate);
        edt_TNPEngineer =v.findViewById(R.id.losdetail_edt_tnpengineer);
        edt_TNPEngineerTel =v.findViewById(R.id.losdetail_edt_tnpengineertel);
        edt_Customerrepresentative=v.findViewById(R.id.losdetail_edt_Customerrepresentative);
        edt_Nearenddetails = v.findViewById(R.id.losdetail_edt_Nearenddetails);
        edt_Lat =v.findViewById(R.id.losdetail__edt_lat);
        edt_Long = v.findViewById(R.id.losdetail_edt_log);
        edt_CandidateName = v.findViewById(R.id.losdetail_edt_candidatename);
        edt_Address = v.findViewById(R.id.losdetail_edt_address);
        edt_Bldght= v.findViewById(R.id.losdetail_edt_buildingheight);
        edt_Totalht = v.findViewById(R.id.losdetail_edt_totalheight);
        edt_AMSL= v.findViewById(R.id.losdetail_edt_ASML);
        edt_Buildingsideviewphoto= v.findViewById(R.id.losdetail_edt_Buildingsideviewphoto);
        edt_AntennaTowerlocationphoto= v.findViewById(R.id.losdetail_edt_AntennaTowerlocationphoto);
        edt_Possibleobstacle= v.findViewById(R.id.losdetail_edt_Possibleobstacle);
        edt_HeightofObstruction = v.findViewById(R.id.losdetail_edt_HeightofObstruction);
        edt_PanaromicPhoto = v.findViewById(R.id.losdetail_edt_PanaromicPhoto);
        edt_ExisitngNoofMWAntennatypewithsizeandPhotograph = v.findViewById(R.id.losdetail_edt_ExisitngNoofMWAntennatypewithsizeandPhotograph);
        edt_ExisitngMWAntennaheightandPolemountPhotograph = v.findViewById(R.id.losdetail__edt_ExisitngMWAntennaheightandPolemountPhotograph);
        //  add 2/02/2019........................
        edt_Commentsaddnew  = v.findViewById(R.id.losdetail__edt_Commentsaddnew);
        edt_MWAntennaht  = v.findViewById(R.id.losdetail__edt_MWAntennaht);
        edt_towerexistingnew  = v.findViewById(R.id.losdetail__edt_towerexistingnew);
        edt_Towertype  = v.findViewById(R.id.losdetail__edt_Towertype);
        edt_remarks = v.findViewById(R.id.losdetail__edt_remarks);

        btn_save = v.findViewById(R.id.btnlosdetailsave);
        btnlosdetail_next = v.findViewById(R.id.btnlosdetail_next);
        tv_previouscount = v.findViewById(R.id.tv_losdetail_count_previous);
        tv_aftercount = v.findViewById(R.id.tv_losdetail_count);

        ib_SiteID = v.findViewById(R.id.losdetail_img_site_id);
        ib_SiteName =v.findViewById(R.id.losdetail_img_site_name) ;
        ib_Sharing = v.findViewById(R.id.losdetail_img_sharing);
        ib_SiteType= v.findViewById(R.id.losdetail_img_sitetype);
        ib_SurveyDate = v.findViewById(R.id.losdetail_img_surveydate);
        ib_TNPEngineer =v.findViewById(R.id.losdetail_img_tnpengineer);
        ib_TNPEngineerTel =v.findViewById(R.id.losdetail_img_tnpengineertel);
        ib_Customerrepresentative=v.findViewById(R.id.losdetail_img_Customerrepresentative);
        ib_Nearenddetails = v.findViewById(R.id.losdetail_img_Nearenddetails);
        ib_CandidateName = v.findViewById(R.id.losdetail_img_candidatename);
        ib_Address = v.findViewById(R.id.losdetail_img_address);
        ib_Bldght= v.findViewById(R.id.losdetail_img_buildingheight);
        ib_Totalht = v.findViewById(R.id.losdetail_img_totalheight);
        ib_AMSL= v.findViewById(R.id.losdetail_img_ASML);
        ib_Buildingsideviewphoto= v.findViewById(R.id.losdetail_img_Buildingsideviewphoto);
        ib_AntennaTowerlocationphoto= v.findViewById(R.id.losdetail_img_AntennaTowerlocationphoto);
        ib_Possibleobstacle= v.findViewById(R.id.losdetail_img_Possibleobstacle);
        ib_HeightofObstruction = v.findViewById(R.id.losdetail_img_HeightofObstruction);
        ib_PanaromicPhoto = v.findViewById(R.id.losdetail_img_PanaromicPhoto);
        ib_ExisitngNoofMWAntennatypewithsizeandPhotograph = v.findViewById(R.id.losdetail_img_ExisitngNoofMWAntennatypewithsizeandPhotograph);
        ib_ExisitngMWAntennaheightandPolemountPhotograph = v.findViewById(R.id.losdetail_img_ExisitngMWAntennaheightandPolemountPhotograph);
        //  add 2/02/2019........................
        ib_Commentsaddnew  = v.findViewById(R.id.losdetail__ib_Commentsaddnew);
        ib_MWAntennaht  = v.findViewById(R.id.losdetail__ib_MWAntennaht);
        ib_towerexistingnew  = v.findViewById(R.id.losdetail__ib_towerexistingnew);
        ib_Towertype  = v.findViewById(R.id.losdetail__ib_Towertype);
        ib_remarks = v.findViewById(R.id.losdetail__ib_remarks);



        ib_SiteID.setOnClickListener(this);
        ib_SiteName .setOnClickListener(this);
        ib_Sharing .setOnClickListener(this);
        ib_SiteType.setOnClickListener(this);
        ib_SurveyDate .setOnClickListener(this);
        ib_TNPEngineer.setOnClickListener(this);
        ib_TNPEngineerTel .setOnClickListener(this);
        ib_Customerrepresentative.setOnClickListener(this);
        ib_Nearenddetails .setOnClickListener(this);
        ib_CandidateName .setOnClickListener(this);
        ib_Address .setOnClickListener(this);
        ib_Bldght.setOnClickListener(this);
        ib_Totalht.setOnClickListener(this);
        ib_AMSL.setOnClickListener(this);
        ib_Buildingsideviewphoto.setOnClickListener(this);
        ib_AntennaTowerlocationphoto.setOnClickListener(this);
        ib_Possibleobstacle.setOnClickListener(this);
        ib_HeightofObstruction .setOnClickListener(this);
        ib_PanaromicPhoto.setOnClickListener(this);
        ib_ExisitngNoofMWAntennatypewithsizeandPhotograph .setOnClickListener(this);
        ib_ExisitngMWAntennaheightandPolemountPhotograph .setOnClickListener(this);
        //  add 2/02/2019........................
        ib_Commentsaddnew.setOnClickListener(this);
        ib_MWAntennaht.setOnClickListener(this);
        ib_towerexistingnew.setOnClickListener(this);
        ib_Towertype.setOnClickListener(this);
        ib_remarks.setOnClickListener(this);
        btn_save .setOnClickListener(this);
        btnlosdetail_next .setOnClickListener(this);


        iv_SiteID = v.findViewById(R.id.losdetail_ivsite_id);
        iv_SiteName =v.findViewById(R.id.losdetail_ivsite_name) ;
        iv_Sharing = v.findViewById(R.id.losdetail_ivsharing);
        iv_SiteType= v.findViewById(R.id.losdetail_ivsitetype);
        iv_SurveyDate = v.findViewById(R.id.losdetail_ivsurveydate);
        iv_TNPEngineer =v.findViewById(R.id.losdetail_ivtnpengineer);
        iv_TNPEngineerTel =v.findViewById(R.id.losdetail_ivtnpengineertel);
        iv_Customerrepresentative=v.findViewById(R.id.losdetail_ivCustomerrepresentative);
        iv_Nearenddetails = v.findViewById(R.id.losdetail_ivNearenddetails);
        iv_CandidateName = v.findViewById(R.id.losdetail_ivcandidatename);
        iv_Address = v.findViewById(R.id.losdetail_ivaddress);
        iv_Bldght= v.findViewById(R.id.losdetail_ivbuildingheight);
        iv_Totalht = v.findViewById(R.id.losdetail_ivtotalheight);
        iv_AMSL= v.findViewById(R.id.losdetail_ivASML);
        iv_Buildingsideviewphoto= v.findViewById(R.id.losdetail_ivBuildingsideviewphoto);
        iv_AntennaTowerlocationphoto= v.findViewById(R.id.losdetail_ivAntennaTowerlocationphoto);
        iv_Possibleobstacle= v.findViewById(R.id.losdetail_ivPossibleobstacle);
        iv_HeightofObstruction = v.findViewById(R.id.losdetail_ivHeightofObstruction);
        iv_PanaromicPhoto = v.findViewById(R.id.losdetail_ivPanaromicPhoto);
        iv_ExisitngNoofMWAntennatypewithsizeandPhotograph = v.findViewById(R.id.losdetail_ivExisitngNoofMWAntennatypewithsizeandPhotograph);
        iv_ExisitngMWAntennaheightandPolemountPhotograph = v.findViewById(R.id.losdetail_ivExisitngMWAntennaheightandPolemountPhotograph);
        //  add 2/02/2019........................
        iv_Commentsaddnew  = v.findViewById(R.id.losdetail__iv_Commentsaddnew);
        iv_MWAntennaht  = v.findViewById(R.id.losdetail__iv_MWAntennaht);
        iv_towerexistingnew  = v.findViewById(R.id.losdetail__iv_towerexistingnew);
        iv_Towertype  = v.findViewById(R.id.losdetail__iv_Towertype);
        iv_remarks = v.findViewById(R.id.losdetail__iv_remarks);


    }

    @Override
    public void onClick(View view) {

        if(view == ib_SiteID){
            selectImage("1");
        }
        if(view == ib_SiteName){
            selectImage("2");
        }
        if(view == ib_Sharing){
            selectImage("3");
        }
        if(view == ib_SiteType){
            selectImage("4");
        }
        if(view == ib_SurveyDate){
            selectImage("5");
        }
        if(view == ib_TNPEngineer){
            selectImage("6");
        }
        if(view == ib_TNPEngineerTel){
            selectImage("7");
        }
        if(view == ib_Customerrepresentative){
            selectImage("8");
        }
        if(view == ib_Nearenddetails){
            selectImage("9");
        }
        if(view == ib_CandidateName){
            selectImage("10");
        }
        if(view == ib_Address){
            selectImage("11");
        }
        if(view == ib_Bldght){
            selectImage("12");
        }
        if(view == ib_Totalht){
            selectImage("13");
        }
        if(view == ib_AMSL){
            selectImage("14");
        }
        if(view == ib_Buildingsideviewphoto){
            selectImage("15");
        }
        if(view == ib_AntennaTowerlocationphoto){
            selectImage("16");
        }
        if(view == ib_Possibleobstacle){
            selectImage("17");
        }
        if(view == ib_HeightofObstruction){
            selectImage("18");
        }
        if(view == ib_PanaromicPhoto){
            selectImage("19");
        }
        if(view == ib_ExisitngNoofMWAntennatypewithsizeandPhotograph){
            selectImage("20");
        }
        if(view == ib_ExisitngMWAntennaheightandPolemountPhotograph){
            selectImage("21");
        }
        if(view == ib_Commentsaddnew){
            selectImage("22");
        }
        if(view == ib_MWAntennaht){
            selectImage("23");
        }
        if(view == ib_towerexistingnew){
            selectImage("24");
        }
        if(view == ib_Towertype){
            selectImage("25");
        }
        if(view == ib_remarks){
            selectImage("26");
        }




        if(view == btn_save){
            db.insertLOSSiteDetailData( new LOSSiteDetailData(edt_SiteID.getText()+"",edt_SiteName.getText()+"",edt_Sharing.getText()+"",edt_SiteType.getText()+"",edt_SurveyDate.getText()+"",edt_TNPEngineer.getText()+"", edt_TNPEngineerTel.getText()+"",edt_Customerrepresentative.getText()+"",edt_Nearenddetails.getText()+"", edt_Lat.getText()+"",edt_Long.getText()+"",edt_CandidateName.getText()+"",edt_Address.getText()+"",edt_Bldght.getText()+"", edt_Totalht.getText()+"",edt_AMSL.getText()+"",edt_Buildingsideviewphoto.getText()+"",edt_AntennaTowerlocationphoto.getText()+"",edt_Possibleobstacle.getText()+"", edt_HeightofObstruction.getText()+"",edt_PanaromicPhoto.getText()+"", edt_ExisitngNoofMWAntennatypewithsizeandPhotograph.getText()+"", edt_ExisitngMWAntennaheightandPolemountPhotograph.getText()+"",
            img_SiteID, img_SiteName, img_Sharing, img_SiteType, img_SurveyDate, img_TNPEngineer,img_TNPEngineerTel,img_Customerrepresentative,img_Nearenddetails, img_CandidateName,img_Address,img_Bldght,img_Totalht,img_AMSL, img_Buildingsideviewphoto, img_AntennaTowerlocationphoto,img_Possimgleobstacle, img_HeightofObstruction, img_PanaromicPhoto,img_ExisitngNoofMWAntennatypewithsizeandPhotograph,img_ExisitngMWAntennaheightandPolemountPhotograph,
                    edt_Commentsaddnew.getText()+"",edt_MWAntennaht.getText()+"", edt_towerexistingnew.getText()+"" ,edt_Towertype.getText()+"",edt_remarks.getText()+"",img_Commentsaddnew,img_MWAntennaht,img_towerexistingnew,img_Towertype,img_remarks ,   time, 1)) ;


            int aftercount = db.getCountLosSiteDetail();
            tv_aftercount.setText(aftercount+"");
        }
        if(view == btnlosdetail_next) {
            getFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag,new TabTransmissionLinkFragment()).addToBackStack(null).commit();

        }


    }
    private void selectImage(String Value) {

        if (Value.equals("1")) {

            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",1);
            startActivityForResult(i, 1);
        }
        if (Value.equals("2")) {

            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",2);
            startActivityForResult(i, 2);

        }
        if (Value.equals("3")) {

            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",3);
            startActivityForResult(i, 3);
        }
        if (Value.equals("4")) {

            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",4);
            startActivityForResult(i, 4);
        }
        if (Value.equals("5")) {

            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",5);
            startActivityForResult(i, 5);
        }
        if (Value.equals("6")) {

            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",6);
            startActivityForResult(i, 6);
        }
        if (Value.equals("7")) {

            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",7);
            startActivityForResult(i, 7);
        }
        if (Value.equals("8")) {

            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",8);
            startActivityForResult(i, 8);
        }
        if (Value.equals("9")) {

            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",9);
            startActivityForResult(i, 9);
        }
        if (Value.equals("10")) {

            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",10);
            startActivityForResult(i, 10);
        }
        if (Value.equals("11")) {
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",11);
            startActivityForResult(i, 11);
        }
        if (Value.equals("12")) {
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",12);
            startActivityForResult(i, 12);
        }
        if (Value.equals("13")) {
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",13);
            startActivityForResult(i, 13);
        }
        if (Value.equals("14")) {
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",14);
            startActivityForResult(i, 14);
        }
        if (Value.equals("15")) {
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",15);
            startActivityForResult(i, 15);
        }
        if (Value.equals("16")) {
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",16);
            startActivityForResult(i, 16);
        }
        if (Value.equals("17")) {
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",17);
            startActivityForResult(i, 17);
        }
        if (Value.equals("18")) {
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",18);
            startActivityForResult(i, 18);
        }
        if (Value.equals("19")) {
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",19);
            startActivityForResult(i, 19);
        }
        if (Value.equals("20")) {
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",20);
            startActivityForResult(i, 20);
        }
        if (Value.equals("21")) {
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",21);
            startActivityForResult(i, 21);
        }
        if (Value.equals("22")) {
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",22);
            startActivityForResult(i, 22);
        }
        if (Value.equals("23")) {
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",23);
            startActivityForResult(i, 23);
        }
        if (Value.equals("24")) {
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",24);
            startActivityForResult(i, 24);
        }
        if (Value.equals("25")) {
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",25);
            startActivityForResult(i, 25);
        }
        if (Value.equals("26")) {
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",26);
            startActivityForResult(i, 26);
        }

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode != RESULT_CANCELED) {
            //  Log.v("logtest", data.getStringExtra("path")+","+requestCode);
            if (requestCode == 1) {
                // onCaptureImageResult(data, "1");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "1", angle);
            }
            if (requestCode == 2) {
                // onCaptureImageResult(data, "2");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "2", angle);
            }
            if (requestCode == 3) {
                //  onCaptureImageResult(data, "3");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "3", angle);
            }
            if (requestCode == 4) {
                // onCaptureImageResult(data, "4");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "4", angle);
            }
            if (requestCode == 5) {
                //  onCaptureImageResult(data, "5");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "5", angle);
            }
            if (requestCode == 6) {
                //   onCaptureImageResult(data, "6");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "6", angle);
            }
            if (requestCode == 7) {
                // onCaptureImageResult(data, "7");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "7", angle);
            }
            if (requestCode == 8) {
                //  onCaptureImageResult(data, "8");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "8", angle);
            }
            if (requestCode == 9) {
                // onCaptureImageResult(data, "9");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "9", angle);
            }
            if (requestCode == 10) {
                //   onCaptureImageResult(data, "10");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "10", angle);
            }
            if (requestCode == 11) {
                //  onCaptureImageResult(data, "11");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "11", angle);
            }
            if (requestCode == 12) {

                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "12", angle);
            }
            if (requestCode == 13) {

                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "13", angle);
            }
            if (requestCode == 14) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "14", angle);
            }
            if (requestCode == 15) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "15", angle);
            }
            if (requestCode == 16) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "16", angle);
            }
            if (requestCode == 17) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "17", angle);
            }
            if (requestCode == 18) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "18", angle);
            }
            if (requestCode == 19) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "19", angle);
            }
            if (requestCode == 20) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "20", angle);
            }
            if (requestCode == 21) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "21", angle);
            }
            if (requestCode == 22) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "22", angle);
            }
            if (requestCode == 23) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "23", angle);
            }
            if (requestCode == 24) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "24", angle);
            }
            if (requestCode == 25) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "25", angle);
            }
            if (requestCode == 26) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "26", angle);
            }

        }
    }

    private void onCameraSurfaceViewActivity(String thumbnail, String name, String angle) {

        if (name.equals("1")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_SiteID.setImageBitmap( out);
                img_SiteID = thumbnail;
                Log.v("img-encode", img_SiteID);
            }
        }
        if (name.equals("2")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_SiteName.setImageBitmap(out);
                //  imgBearing30 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_SiteName = thumbnail;
                Log.v("img-encode", img_SiteName);
            }
        }
        if (name.equals("3")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_Sharing.setImageBitmap( out);
                //  imgBearing60 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_Sharing = thumbnail;
                Log.v("img-encode", img_Sharing);
            }
        }
        if (name.equals("4")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_SiteType.setImageBitmap( out);
                //   imgBearing90 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_SiteType = thumbnail;
                Log.v("img-encode", img_SiteType);
            }
        }
        if (name.equals("5")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_SurveyDate.setImageBitmap( out);
                //  imgBearing120 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_SurveyDate = thumbnail;
                Log.v("img-encode", img_SurveyDate);
            }
        }
        if (name.equals("6")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_TNPEngineer.setImageBitmap( out);
                //    imgBearing150 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_TNPEngineer = thumbnail;
                Log.v("img-encode", img_TNPEngineer);
            }
        }
        if (name.equals("7")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_TNPEngineerTel.setImageBitmap( out);
                //     imgBearing180 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_TNPEngineerTel = thumbnail;
                Log.v("img-encode", img_TNPEngineerTel);
            }
        }
        if (name.equals("8")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_Customerrepresentative.setImageBitmap( out);
                //   imgBearing210 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_Customerrepresentative = thumbnail;
                Log.v("img-encode", img_Customerrepresentative);
            }
        }
        if (name.equals("9")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_Nearenddetails.setImageBitmap( out);
                // imgBearing240 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_Nearenddetails = thumbnail;
                Log.v("img-encode", img_Nearenddetails);
            }
        }
        if (name.equals("10")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_CandidateName.setImageBitmap( out);
                //    imgBearing270 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_CandidateName = thumbnail;
                Log.v("img-encode", img_CandidateName);
            }
        }
        if (name.equals("11")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_Address.setImageBitmap( out);
                //    imgBearing300 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_Address = thumbnail;
                Log.v("img-encode", img_Address);
            }
        }
        if (name.equals("12")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_Bldght.setImageBitmap( out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_Bldght = thumbnail;
                Log.v("img-encode", img_Bldght);
            }
        }
        if (name.equals("13")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_Totalht.setImageBitmap( out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_Totalht = thumbnail;
                Log.v("img-encode", img_Totalht);
            }
        }
        if (name.equals("14")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_AMSL.setImageBitmap( out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_AMSL = thumbnail;
                Log.v("img-encode", img_AMSL);
            }
        }
        if (name.equals("15")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_Buildingsideviewphoto.setImageBitmap( out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_Buildingsideviewphoto = thumbnail;
                Log.v("img-encode", img_Buildingsideviewphoto);
            }
        }
        if (name.equals("16")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_AntennaTowerlocationphoto.setImageBitmap( out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_AntennaTowerlocationphoto = thumbnail;
                Log.v("img-encode", img_AntennaTowerlocationphoto);
            }
        }
        if (name.equals("17")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_Possibleobstacle.setImageBitmap( out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_Possimgleobstacle = thumbnail;
                Log.v("img-encode", img_Possimgleobstacle);
            }
        }
        if (name.equals("18")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_HeightofObstruction.setImageBitmap( out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_HeightofObstruction = thumbnail;
                Log.v("img-encode", img_HeightofObstruction);
            }
        }
        if (name.equals("19")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_PanaromicPhoto.setImageBitmap( out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_PanaromicPhoto = thumbnail;
                Log.v("img-encode", img_PanaromicPhoto);
            }
        }
        if (name.equals("20")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_ExisitngNoofMWAntennatypewithsizeandPhotograph.setImageBitmap( out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_ExisitngNoofMWAntennatypewithsizeandPhotograph = thumbnail;
                Log.v("img-encode", img_ExisitngNoofMWAntennatypewithsizeandPhotograph);
            }
        }
        if (name.equals("21")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_ExisitngMWAntennaheightandPolemountPhotograph.setImageBitmap( out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_ExisitngMWAntennaheightandPolemountPhotograph = thumbnail;
                Log.v("img-encode", img_ExisitngMWAntennaheightandPolemountPhotograph);
            }
        }
        if (name.equals("22")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_Commentsaddnew.setImageBitmap( out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_Customerrepresentative = thumbnail;
                Log.v("img-encode", img_Commentsaddnew);
            }
        }
        if (name.equals("23")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_MWAntennaht.setImageBitmap( out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_MWAntennaht = thumbnail;
                Log.v("img-encode", img_MWAntennaht);
            }
        }
        if (name.equals("24")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_towerexistingnew.setImageBitmap( out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_towerexistingnew = thumbnail;
                Log.v("img-encode", img_towerexistingnew);
            }
        }
        if (name.equals("25")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_Towertype.setImageBitmap( out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_Towertype = thumbnail;
                Log.v("img-encode", img_Towertype);
            }
        }
        if (name.equals("26")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_remarks.setImageBitmap( out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_remarks = thumbnail;
                Log.v("img-encode", img_remarks);
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

            //   Toast.makeText(getActivity(), "Lat : "+lat+","+ "Long : "+ log, Toast.LENGTH_LONG).show();
        }


    };


}
