package com.linkquest.lhq.SiteAudit;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.InputType;
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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.linkquest.lhq.GoogleGPSService;
import com.linkquest.lhq.R;
import com.linkquest.lhq.Utils.SharedPreferenceUtils;
import com.linkquest.lhq.activity.CameraSurfaceViewActivity;
import com.linkquest.lhq.constants.AppConstants;
import com.linkquest.lhq.database.DatabaseHandler;
import com.linkquest.lhq.database.SiteDetailForm;
import com.linkquest.lhq.database.SurveyForm;

import java.io.ByteArrayOutputStream;
import java.util.List;

import static android.app.Activity.RESULT_CANCELED;

/**
 * A simple {@link Fragment} subclass.
 */
public class SiteDetailFragment extends Fragment implements View.OnClickListener {
    private String lat, log;
    int REQUEST_CAMERA = 1;
    private Handler handler;
    private String time;
    private EditText siteid;
    private ImageButton siteid_photo;
    private EditText sitename;
    private ImageButton sitename_photo;
    private EditText towersiteid;
    private ImageButton towersiteid_photo;
    private EditText towercompanyname;
    private ImageButton towercompanyname__photo;
    private EditText siteaddress;
    private ImageButton siteaddress_photo;
    private EditText sectorid;
    private ImageButton sectorid_photo;
    private EditText edt_lat;
    private EditText edt_log;
    private EditText sitetype;
    private ImageButton sitetype_photo;
    private EditText buildingfloor;
    private ImageButton buildingfloor_photo;
    private EditText buildingheight;
    private ImageButton buildingheight_photo;
    private EditText towerheight;
    private ImageButton towerheight_photo;
    private EditText fulltowerphoto;
    private ImageButton fulltowerphoto_photo;
    private EditText nodebtype;
    private ImageButton nodebtype_photo;
    private EditText classical;
    private ImageButton classical_photo;
    private EditText enodebtype;
    private ImageButton enodebtype_photo;
    private EditText anchoroperator;
    private ImageButton anchoroperator_photo;
    private EditText sharingopco1;
    private ImageButton sharingopco1_photo;
    private EditText sharingopco2;
    private ImageButton sharingopco2_photo;
    private EditText sharingopco3;
    private ImageButton sharingopco3_photo;
    private EditText infraprovider;
    private ImageButton infraprovider_photo;
    private EditText type_id_od;
    private ImageButton type_id_od_photo;
    private EditText infrashared;
    private ImageButton infrashared_photo;
    private EditText extra1;
    private ImageButton extra1_photo;
    private EditText extra2;
    private ImageButton extra2_photo;
    private EditText remark1;
    private ImageButton remark1_photo;
    private EditText remark2;
    private ImageButton remark2_photo;


    private ImageView ivsiteid;
    private ImageView ivsitename;
    private ImageView ivtowersiteid;
    private ImageView ivtowercompnyname;
    private ImageView ivsiteaddress;
    private ImageView ivsectorid;
    private ImageView ivsitetype;
    private ImageView ivbuildingfloor;
    private ImageView ivbuildingheight;
    private ImageView ivtowerheight;
    private ImageView ivfulltowerphoto;
    private ImageView ivnodebtype;
    private ImageView ivclassicalrrm;
    private ImageView ivenodebtype;
    private ImageView ivanchoroper;
    private ImageView ivsharingopco1;
    private ImageView ivsharingopco2;
    private ImageView ivsharingopco3;
    private ImageView ivinfraprovider;
    private ImageView ivtypeindoor;
    private ImageView ivinfrashared;
    private ImageView ivextra1;
    private ImageView ivextra2;
    private ImageView ivremark1;
    private ImageView ivremark2;

    private LinearLayout linear_sitename;
    private LinearLayout linear_towersiteid;
    private LinearLayout linear_towercompanyname;
    private LinearLayout linear_siteaddress;
    private LinearLayout linear_sectorid;
    private LinearLayout linear_edt_lat_long;
    private LinearLayout linear_sitetype;
    private LinearLayout linear_buildingfloor;
    private LinearLayout linear_buildingheight;
    private LinearLayout linear_towerheight;
    private LinearLayout linear_fulltowerphoto;
    private LinearLayout linear_nodebtype;
    private LinearLayout linear_classical;
    private LinearLayout linear_enodebtype;
    private LinearLayout linear_anchoroperator;
    private LinearLayout linear_sharingopco1;
    private LinearLayout linear_sharingopco2;
    private LinearLayout linear_sharingopco3;
    private LinearLayout linear_infraprovider;
    private LinearLayout linear_type_id_od;
    private LinearLayout linear_infrashared;
    private LinearLayout linear_extra1;
    private LinearLayout linear_extra2;
    private LinearLayout linear_remark1;
    private LinearLayout linear_remark2;
    private SiteDetailForm siteDetailForm;

    private Button btnsitedetail;
    private Button btnsitedetailsave;
    private TextView tv_sitedetail_count;
    private TextView tv_sitedetail_count_previous;
    DatabaseHandler db;
    private SharedPreferenceUtils sharedPreferences;
    private String changetempleteName = "";
    private String changetempleteName_Operator = "";
    private String activityType = "";


    private TextView tvsectorid;
    private TextView tvtype_id_od;
    private TextView tv_siteid;
    private TextView tv_sitename;
    private TextView tv_towersiteid;
    private TextView tv_towercompanyname;
    private TextView tv_siteaddress;
    private TextView tv_sitetype;
    private TextView tv_buildingfloor;
    private TextView tv_buildingheight;
    private TextView tv_towerheight;
    private TextView tv_fulltowerphoto;
    private TextView tv_nodebtype;
    private TextView tv_classical;
    private TextView tv_enodebtype;
    private TextView tv_anchoroperator;
    private TextView tv_sharingopco1;
    private TextView tv_sharingopco2;
    private TextView tv_sharingopco3;
    private TextView tv_infraprovider;
    private TextView tv_infrashared;
    ;
    private TextView tv_extra1;
    private TextView tv_extra2;
    private TextView tv_remark1;
    private TextView tv_remark2;

    public SiteDetailFragment() {
        // Required empty public constructor
    }

    public static SiteDetailFragment newInstance(int index) {
        SiteDetailFragment f = new SiteDetailFragment();
        Bundle args = new Bundle();
        args.putInt("index", index);
        f.setArguments(args);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_site_detail, container, false);


   /*     int arg = getArguments().getInt("index");
            Toast.makeText(getActivity(), arg + "", Toast.LENGTH_LONG).show();
*/
        if (!GoogleGPSService.isRunning) {
            getActivity().startService(new Intent(getActivity(), GoogleGPSService.class));
        }
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                time = DateFormat.format("dd-MM-yyyy h:mm:ss:aa", System.currentTimeMillis()).toString();

                handler.postDelayed(this, 1000);
            }

        }, 1000);

        findviewIDS(v);
        db = new DatabaseHandler(getActivity());


        siteDetailForm = new SiteDetailForm();
        tv_sitedetail_count_previous.setText(tv_sitedetail_count_previous.getText().toString() + db.getCountSiteDetail());


        changeTemplete(v);
        return v;
    }

    private void findviewIDS(View v) {

        //  start change templete code
        linear_sitename = v.findViewById(R.id.linear_sitedeatail_edt_site_name);
        linear_towersiteid = v.findViewById(R.id.linear_sitedeatail_edt_towersiteid);
        linear_towercompanyname = v.findViewById(R.id.linear_sitedeatail_edt_towercompanyname);
        linear_siteaddress = v.findViewById(R.id.linear_sitedeatail_edt_site_address);
        linear_sectorid = v.findViewById(R.id.linear_sitedeatail_edt_sectorid);
        linear_edt_lat_long = v.findViewById(R.id.linear_sitedeatail_edt_lat_long);
        linear_sitetype = v.findViewById(R.id.linear_sitedeatail_edt_sitetype);
        linear_buildingfloor = v.findViewById(R.id.linear_sitedeatail_edt_building_floor);
        linear_buildingheight = v.findViewById(R.id.linear_sitedeatail_edt_buildingheight);
        linear_towerheight = v.findViewById(R.id.linear_sitedeatail_edt_towerheight);
        linear_fulltowerphoto = v.findViewById(R.id.linear_sitedeatail_edt_fulltowerphoto);
        linear_nodebtype = v.findViewById(R.id.linear_sitedeatail_edt_nodebtype);
        linear_classical = v.findViewById(R.id.linear_sitedeatail_edt_clasicalRRH);
        linear_enodebtype = v.findViewById(R.id.linear_sitedeatail_edt_enodebtype);
        linear_anchoroperator = v.findViewById(R.id.linear_sitedeatail_edt_anchoroperator);
        linear_sharingopco1 = v.findViewById(R.id.linear_sitedeatail_edt_sharingopco1);
        linear_sharingopco2 = v.findViewById(R.id.linear_sitedeatail_edt_sharingopco2);
        linear_sharingopco3 = v.findViewById(R.id.linear_sitedeatail_edt_sharingopco3);
        linear_infraprovider = v.findViewById(R.id.linear_sitedeatail_edt_infraprovider);
        linear_type_id_od = v.findViewById(R.id.linear_sitedeatail_edt_typeindoor);
        linear_infrashared = v.findViewById(R.id.linear_sitedeatail_edt_infrashared);
        linear_extra1 = v.findViewById(R.id.linear_sitedeatail_edt_extra1);
        linear_extra2 = v.findViewById(R.id.linear_sitedeatail_edt_extra2);
        linear_remark1 = v.findViewById(R.id.linear_sitedeatail_edt_remark1);
        linear_remark2 = v.findViewById(R.id.linear_sitedeatail_edt_remark2);


        tv_siteid = v.findViewById(R.id.sitedeatail_tv_site_id);
        tv_sitename = v.findViewById(R.id.sitedeatail_tv_site_name);
        tv_towersiteid = v.findViewById(R.id.sitedeatail_tv_towersiteid);
        tv_towercompanyname = v.findViewById(R.id.sitedeatail_tv_towercompanyname);
        tv_siteaddress = v.findViewById(R.id.sitedeatail_tv_site_address);
        //  tv_sectorid=v.findViewById(R.id.sitedeatail_tv_sectorid);
        tv_sitetype = v.findViewById(R.id.sitedeatail_tv_sitetype);
        tv_buildingfloor = v.findViewById(R.id.sitedeatail_tv_building_floor);
        tv_buildingheight = v.findViewById(R.id.sitedeatail_tv_buildingheight);
        tv_towerheight = v.findViewById(R.id.sitedeatail_tv_towerheight);
        tv_fulltowerphoto = v.findViewById(R.id.sitedeatail_tv_fulltowerphoto);
        tv_nodebtype = v.findViewById(R.id.sitedeatail_tv_nodebtype);
        tv_classical = v.findViewById(R.id.sitedeatail_tv_clasicalRRH);
        tv_enodebtype = v.findViewById(R.id.sitedeatail_tv_enodebtype);
        tv_anchoroperator = v.findViewById(R.id.sitedeatail_tv_anchoroperator);
        tv_sharingopco1 = v.findViewById(R.id.sitedeatail_tv_sharingopco1);
        tv_sharingopco2 = v.findViewById(R.id.sitedeatail_tv_sharingopco2);
        tv_sharingopco3 = v.findViewById(R.id.sitedeatail_tv_sharingopco3);
        tv_infraprovider = v.findViewById(R.id.sitedeatail_tv_infraprovider);
//    tv_type_id_od =v.findViewById(R.id.tv_sitedeatail_tv_typeindoor);
        tv_infrashared = v.findViewById(R.id.sitedeatail_tv_infrashared);
        tv_extra1 = v.findViewById(R.id.sitedeatail_tv_extra1);
        tv_extra2 = v.findViewById(R.id.sitedeatail_tv_extra2);
        tv_remark1 = v.findViewById(R.id.sitedeatail_tv_remark1);
        tv_remark2 = v.findViewById(R.id.sitedeatail_tv_remark2);
        tvsectorid = v.findViewById(R.id.sitedeatail_tv_sectorid);
        tvtype_id_od = v.findViewById(R.id.sitedeatail_tv_typeindoor);


        //  end change templete code


        siteid = v.findViewById(R.id.sitedeatail_edt_site_id);
        siteid_photo = v.findViewById(R.id.sitedeatail_img_site_id);
        sitename = v.findViewById(R.id.sitedeatail_edt_site_name);
        sitename_photo = v.findViewById(R.id.sitedeatail_img_site_name);
        towersiteid = v.findViewById(R.id.sitedeatail_edt_towersiteid);
        towersiteid_photo = v.findViewById(R.id.sitedeatail_img_towersiteid);
        towercompanyname = v.findViewById(R.id.sitedeatail_edt_towercompanyname);
        towercompanyname__photo = v.findViewById(R.id.sitedeatail_img_towercompanyname);
        siteaddress = v.findViewById(R.id.sitedeatail_edt_site_address);
        siteaddress_photo = v.findViewById(R.id.sitedeatail_img_site_address);
        sectorid = v.findViewById(R.id.sitedeatail_edt_sectorid);
        sectorid_photo = v.findViewById(R.id.sitedeatail_img_sectorid);
        edt_lat = v.findViewById(R.id.sitedeatail_edt_lat);
        edt_lat.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        edt_log = v.findViewById(R.id.sitedeatail_edt_log);
        edt_log.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        sitetype = v.findViewById(R.id.sitedeatail_edt_sitetype);
        sitetype_photo = v.findViewById(R.id.sitedeatail_img_sitetype);
        buildingfloor = v.findViewById(R.id.sitedeatail_building_floor);
        buildingfloor_photo = v.findViewById(R.id.sitedeatail_img_buildingfloor);
        buildingheight = v.findViewById(R.id.sitedeatail_edt_buildingheight);
        buildingheight_photo = v.findViewById(R.id.sitedeatail_img_buildingheight);
        towerheight = v.findViewById(R.id.sitedeatail_edt_towerheight);
        towerheight_photo = v.findViewById(R.id.sitedeatail_img_towerheight);
        fulltowerphoto = v.findViewById(R.id.sitedeatail_edt_fulltowerphoto);
        fulltowerphoto_photo = v.findViewById(R.id.sitedeatail_img_fulltowerphoto);
        nodebtype = v.findViewById(R.id.sitedeatail_edt_nodebtype);
        nodebtype_photo = v.findViewById(R.id.sitedeatail_img_nodebtype);
        classical = v.findViewById(R.id.sitedeatail_edt_clasicalRRH);
        classical_photo = v.findViewById(R.id.sitedeatail_img_clasicalRRH);
        enodebtype = v.findViewById(R.id.sitedeatail_edt_enodebtype);
        enodebtype_photo = v.findViewById(R.id.sitedeatail_img_enodebtype);
        anchoroperator = v.findViewById(R.id.sitedeatail_edt_anchoroperator);
        anchoroperator_photo = v.findViewById(R.id.sitedeatail_img_anchoroperator);
        sharingopco1 = v.findViewById(R.id.sitedeatail_edt_sharingopco1);
        sharingopco1_photo = v.findViewById(R.id.sitedeatail_img_sharingopco1);
        sharingopco2 = v.findViewById(R.id.sitedeatail_edt_sharingopco2);
        sharingopco2_photo = v.findViewById(R.id.sitedeatail_img_sharingopco2);
        sharingopco3 = v.findViewById(R.id.sitedeatail_edt_sharingopco3);
        sharingopco3_photo = v.findViewById(R.id.sitedeatail_img_sharingopco3);
        infraprovider = v.findViewById(R.id.sitedeatail_edt_infraprovider);
        infraprovider_photo = v.findViewById(R.id.sitedeatail_img_infraprovider);
        type_id_od = v.findViewById(R.id.sitedeatail_edt_typeindoor);
        type_id_od_photo = v.findViewById(R.id.sitedeatail_img_typeindoor);
        infrashared = v.findViewById(R.id.sitedeatail_edt_infrashared);
        infrashared_photo = v.findViewById(R.id.sitedeatail_img_infrashared);
        extra1 = v.findViewById(R.id.sitedeatail_edt_extra1);
        extra1_photo = v.findViewById(R.id.sitedeatail_img_extra1);
        extra2 = v.findViewById(R.id.sitedeatail_edt_extra2);
        extra2_photo = v.findViewById(R.id.sitedeatail_img_extra2);
        remark1 = v.findViewById(R.id.sitedeatail_edt_remark1);
        remark1_photo = v.findViewById(R.id.sitedeatail_img_remark1);
        remark2 = v.findViewById(R.id.sitedeatail_edt_remark2);
        remark2_photo = v.findViewById(R.id.sitedeatail_img_remark2);
        btnsitedetail = v.findViewById(R.id.btnsitedetail);
        btnsitedetailsave = v.findViewById(R.id.btnsitedetailsave);

        ivsiteid = v.findViewById(R.id.ivsiteid);
        ivsitename = v.findViewById(R.id.ivsitename);
        ivtowersiteid = v.findViewById(R.id.ivtowersiteid);
        ivtowercompnyname = v.findViewById(R.id.ivtowercompnyname);
        ivsiteaddress = v.findViewById(R.id.ivsiteaddress);
        ivsectorid = v.findViewById(R.id.ivsectorid);
        ivsitetype = v.findViewById(R.id.ivsitetype);
        ivbuildingfloor = v.findViewById(R.id.ivbuildingfloor);
        ivbuildingheight = v.findViewById(R.id.ivbuildingheight);
        ivtowerheight = v.findViewById(R.id.ivtowerheight);
        ivfulltowerphoto = v.findViewById(R.id.ivfulltowerphoto);
        ivnodebtype = v.findViewById(R.id.ivnodebtype);
        ivclassicalrrm = v.findViewById(R.id.ivclassicalrrm);
        ivenodebtype = v.findViewById(R.id.ivenodebtype);
        ivanchoroper = v.findViewById(R.id.ivanchoroper);
        ivsharingopco1 = v.findViewById(R.id.ivsharingopco1);
        ivsharingopco2 = v.findViewById(R.id.ivsharingopco2);
        ivsharingopco3 = v.findViewById(R.id.ivsharingopco3);
        ivinfraprovider = v.findViewById(R.id.ivinfraprovider);
        ivtypeindoor = v.findViewById(R.id.ivtypeindoor);
        ivinfrashared = v.findViewById(R.id.ivinfrashared);
        ivextra1 = v.findViewById(R.id.ivextra1);
        ivextra2 = v.findViewById(R.id.ivextra2);
        ivremark1 = v.findViewById(R.id.ivremark1);
        ivremark2 = v.findViewById(R.id.ivremark2);

        tv_sitedetail_count = v.findViewById(R.id.tv_sitedetail_count);
        tv_sitedetail_count_previous = v.findViewById(R.id.tv_sitedetail_count_previous);

        siteid_photo.setOnClickListener(this);
        sitename_photo.setOnClickListener(this);
        towersiteid_photo.setOnClickListener(this);
        towercompanyname__photo.setOnClickListener(this);
        siteaddress_photo.setOnClickListener(this);
        sectorid_photo.setOnClickListener(this);
        sitetype_photo.setOnClickListener(this);
        buildingfloor_photo.setOnClickListener(this);
        buildingheight_photo.setOnClickListener(this);
        towerheight_photo.setOnClickListener(this);
        fulltowerphoto_photo.setOnClickListener(this);
        nodebtype_photo.setOnClickListener(this);
        classical_photo.setOnClickListener(this);
        enodebtype_photo.setOnClickListener(this);
        anchoroperator_photo.setOnClickListener(this);
        sharingopco1_photo.setOnClickListener(this);
        sharingopco2_photo.setOnClickListener(this);
        sharingopco3_photo.setOnClickListener(this);
        infraprovider_photo.setOnClickListener(this);
        type_id_od_photo.setOnClickListener(this);
        infrashared_photo.setOnClickListener(this);
        extra1_photo.setOnClickListener(this);
        extra2_photo.setOnClickListener(this);
        remark1_photo.setOnClickListener(this);
        remark2_photo.setOnClickListener(this);
        btnsitedetail.setOnClickListener(this);
        btnsitedetailsave.setOnClickListener(this);

    }

    private void changeTemplete(View v) {

        sharedPreferences = SharedPreferenceUtils.getInstance();
        sharedPreferences.setContext(getActivity());
        // changetempleteName = sharedPreferences.getString(AppConstants.surveytpeandcustomerandoperator);
        //  changetempleteName_Operator = sharedPreferences.getString(AppConstants.operators);
        Toast.makeText(getActivity(), sharedPreferences.getString(AppConstants.surveytpeandcustomerandoperator), Toast.LENGTH_LONG).show();
        List<SurveyForm> siteIDandDate = db.getLastSurveyformData();
        if (siteIDandDate.size() > 0) {
            String surveytype_customer_operator = siteIDandDate.get(0).getSurveytype() + siteIDandDate.get(0).getCustomer() + siteIDandDate.get(0).getOperator();
            changetempleteName = surveytype_customer_operator;
            changetempleteName_Operator = siteIDandDate.get(0).getOperator();
            activityType = siteIDandDate.get(0).getTechnologytype();

        }

        //  start change templete code
     /*   linear_sitename =v.findViewById(R.id.linear_sitedeatail_edt_site_name);
        linear_towersiteid =v.findViewById(R.id.linear_sitedeatail_edt_towersiteid);
        linear_towercompanyname=v.findViewById(R.id.linear_sitedeatail_edt_towercompanyname);
        linear_siteaddress=v.findViewById(R.id.linear_sitedeatail_edt_site_address);
        linear_sectorid=v.findViewById(R.id.linear_sitedeatail_edt_sectorid);
        linear_edt_lat_long=v.findViewById(R.id.linear_sitedeatail_edt_lat_long);
        linear_sitetype =v.findViewById(R.id.linear_sitedeatail_edt_sitetype);
        linear_buildingfloor =v.findViewById(R.id.linear_sitedeatail_edt_building_floor);
        linear_buildingheight =v.findViewById(R.id.linear_sitedeatail_edt_buildingheight);
        linear_towerheight =v.findViewById(R.id.linear_sitedeatail_edt_towerheight);
        linear_fulltowerphoto =v.findViewById(R.id.linear_sitedeatail_edt_fulltowerphoto);
        linear_nodebtype =v.findViewById(R.id.linear_sitedeatail_edt_nodebtype);
        linear_classical =v.findViewById(R.id.linear_sitedeatail_edt_clasicalRRH);
        linear_enodebtype =v.findViewById(R.id.linear_sitedeatail_edt_enodebtype);
        linear_anchoroperator=v.findViewById(R.id.linear_sitedeatail_edt_anchoroperator);
        linear_sharingopco1 =v.findViewById(R.id.linear_sitedeatail_edt_sharingopco1);
        linear_sharingopco2 =v.findViewById(R.id.linear_sitedeatail_edt_sharingopco2);
        linear_sharingopco3 =v.findViewById(R.id.linear_sitedeatail_edt_sharingopco3);
        linear_infraprovider =v.findViewById(R.id.linear_sitedeatail_edt_infraprovider);
        linear_type_id_od =v.findViewById(R.id.linear_sitedeatail_edt_typeindoor);
        linear_infrashared =v.findViewById(R.id.linear_sitedeatail_edt_infrashared);
        linear_extra1 =v.findViewById(R.id.linear_sitedeatail_edt_extra1);
        linear_extra2 =v.findViewById(R.id.linear_sitedeatail_edt_extra2);
        linear_remark1 =v.findViewById(R.id.linear_sitedeatail_edt_remark1);
        linear_remark2 =v.findViewById(R.id.linear_sitedeatail_edt_remark2);
*/

      /*  tvextra1 = v.findViewById(R.id.sitedeatail_tv_extra1);
        tvextra2 = v.findViewById(R.id.sitedeatail_tv_extra2);
        tvremark1 = v.findViewById(R.id.sitedeatail_tv_remark1);*/
        //  end change templete code
        if (changetempleteName.equalsIgnoreCase("Site AuditERICSSONAIRTEL")) {
            tvsectorid.setText("No of Sectors");
            tvtype_id_od.setText("Zone");
            tv_extra1.setText("DT Name");
            tv_extra2.setText("RNO Name");
            tv_remark1.setText("GPS");

            linear_towersiteid.setVisibility(View.GONE);
            linear_sitetype.setVisibility(View.GONE);
            linear_buildingfloor.setVisibility(View.GONE);
            linear_buildingheight.setVisibility(View.GONE);
            linear_towerheight.setVisibility(View.GONE);
            linear_classical.setVisibility(View.GONE);
            linear_nodebtype.setVisibility(View.GONE);
            linear_anchoroperator.setVisibility(View.GONE);
            linear_sharingopco1.setVisibility(View.GONE);
            linear_sharingopco2.setVisibility(View.GONE);
            linear_sharingopco3.setVisibility(View.GONE);
        }
        if (changetempleteName_Operator.equalsIgnoreCase("VFI")) {
            tvsectorid.setText("No of Sectors");
            tvtype_id_od.setText("Zone");
            tv_extra1.setText("DT Name");
            tv_extra2.setText("RNO Name");

            linear_towersiteid.setVisibility(View.GONE);
            //  linear_sitetype.setVisibility(View.GONE);
            // linear_buildingfloor.setVisibility(View.GONE);
            linear_buildingheight.setVisibility(View.GONE);
            linear_towerheight.setVisibility(View.GONE);
            linear_classical.setVisibility(View.GONE);
            linear_nodebtype.setVisibility(View.GONE);
            linear_anchoroperator.setVisibility(View.GONE);
            linear_sharingopco1.setVisibility(View.GONE);
            linear_sharingopco2.setVisibility(View.GONE);
            linear_sharingopco3.setVisibility(View.GONE);
            linear_type_id_od.setVisibility(View.GONE);
            linear_infraprovider.setVisibility(View.GONE);
            linear_infrashared.setVisibility(View.GONE);
        }

        if (changetempleteName.equalsIgnoreCase("Site AuditNSNAIRTEL") && activityType.equalsIgnoreCase("SCFT")) {
            tvsectorid.setText("No of Sectors");
            tvtype_id_od.setText("Zone");
            //   tv_siteid.setText("Zone");
            //   tv_sitename.setText("Zone");
            //   tv_towersiteid.setText("Zone");
            //   tv_towercompanyname.setText("Zone");
            //   tv_siteaddress.setText("Zone");
            tv_sitetype.setText("IBS/Macro");
            tv_buildingfloor.setText("Airtel 2G Site ID");
            tv_buildingheight.setText("Airtel 3G Site ID");
            tv_towerheight.setText("Airtel 4G Site ID");
            tv_fulltowerphoto.setText("FDD/TDD Site ID");
            tv_nodebtype.setText("EARFCN");
            //      tv_classical.setText("Zone");
            //      tv_enodebtype.setText("Zone");
            //      tv_anchoroperator.setText("Zone");
            //      tv_sharingopco1.setText("Zone");
            //      tv_sharingopco2.setText("Zone");
            //      tv_sharingopco3.setText("Zone");
            tv_infraprovider.setText("FDD Site ID");
            //      tv_infrashared.setText("Zone");
            tv_extra1.setText("DTE Name");
            tv_extra2.setText("Team Lead Name");
            tv_remark1.setText("Team Lead Number");
            tv_remark2.setText("Remarks");

        }
        if (changetempleteName.equalsIgnoreCase("Site AuditNSNAIRTEL") && activityType.equalsIgnoreCase("CLUSTER")) {
            tvsectorid.setText("No of Sectors");
            //   tvtype_id_od.setText("Zone");
            //   tv_siteid.setText("Zone");
            //   tv_sitename.setText("Zone");
            //   tv_towersiteid.setText("Zone");
            //   tv_towercompanyname.setText("Zone");
            //   tv_siteaddress.setText("Zone");
            //   tv_sitetype.setText("IBS/Macro");
            tv_buildingfloor.setText("Cluster Sites Planned");
            tv_buildingheight.setText("Cluster Sites On-Air");

            tv_nodebtype.setText("EARFCN");
                 tv_classical.setText("FDD/TDD Site ID");
            //      tv_enodebtype.setText("Zone");
                 tv_anchoroperator.setText("DT Tool Used");
                 tv_sharingopco1.setText("Post Processing Tool Used");
                 tv_sharingopco2.setText("UE used for Testing");
            //      tv_sharingopco3.setText("Zone");
            tvtype_id_od.setText("Zone");
            //      tv_infrashared.setText("Zone");
            tv_extra1.setText("DTE Name");
            tv_extra2.setText("Team Lead Name");


        }

    }

    @Override
    public void onClick(View v) {

        if (v == siteid_photo) {
            selectImage("one");
        }
         if (v == sitename_photo) {
            selectImage("2");
        }

        if (v == towersiteid_photo) {
            selectImage("3");
        }

        if (v == towercompanyname__photo) {
            selectImage("4");
        }

        if (v == siteaddress_photo) {
            selectImage("5");
        }
        if (v == sectorid_photo) {
            selectImage("6");
        }
        if (v == sitetype_photo) {
            selectImage("7");
        }
        if (v == buildingfloor_photo) {
            selectImage("8");
        }
        if (v == buildingheight_photo) {
            selectImage("9");
        }
        if (v == towerheight_photo) {
            selectImage("10");
        }
        if (v == fulltowerphoto_photo) {
            selectImage("11");
        }
        if (v == nodebtype_photo) {
            selectImage("12");
        }
        if (v == classical_photo) {
            selectImage("13");
        }
        if (v == enodebtype_photo) {
            selectImage("14");
        }
        if (v == anchoroperator_photo) {
            selectImage("15");
        }
        if (v == sharingopco1_photo) {
            selectImage("16");
        }
        if (v == sharingopco2_photo) {
            selectImage("17");
        }
        if (v == sharingopco3_photo) {
            selectImage("18");
        }
        if (v == infraprovider_photo) {
            selectImage("19");
        }
        if (v == type_id_od_photo) {
            selectImage("20");
        }
        if (v == infrashared_photo) {
            selectImage("21");
        }
        if (v == extra1_photo) {
            selectImage("22");
        }
        if (v == extra2_photo) {
            selectImage("23");
        }
        if (v == remark1_photo) {
            selectImage("24");
        }
        if (v == remark2_photo) {
            selectImage("25");
        }

        if (v == btnsitedetailsave) {

            if (edt_lat.getText().toString().equalsIgnoreCase("")) {
                edt_lat.setError("Please Enter Valid Value");

                btnsitedetail.setVisibility(View.GONE);

                return;
            }
            if (edt_log.getText().toString().equalsIgnoreCase("")) {
                edt_log.setError("Please Enter Valid Value");
                btnsitedetail.setVisibility(View.GONE);
                return;
            } else {
                btnsitedetail.setVisibility(View.VISIBLE);
                if (db.getCountSiteDetail() > 2) {
                    db.deleteSomeRow_SiteDetail();

                }

                db.insertSiteDetailData(new SiteDetailForm(siteid.getText().toString(), siteDetailForm.getSiteid_photo() + "", sitename.getText().toString(), siteDetailForm.getSitename_photo() + "",
                        towersiteid.getText() + "", siteDetailForm.getTowersiteid_photo() + "", towercompanyname.getText() + "", siteDetailForm.getTowercompanyname__photo() + "",
                        siteaddress.getText() + "", siteDetailForm.getSiteaddress_photo() + "", sectorid.getText() + "", siteDetailForm.getSectorid_photo() + "",
                        edt_lat.getText() + "", edt_log.getText() + "", sitetype.getText() + "", siteDetailForm.getSitetype_photo() + "", buildingfloor.getText() + "",
                        siteDetailForm.getBuildingfloor_photo() + "", buildingheight.getText() + "", siteDetailForm.getBuildingheight_photo() + "", towerheight.getText() + "",
                        siteDetailForm.getTowerheight_photo() + "", fulltowerphoto.getText() + "", siteDetailForm.getFulltowerphoto_photo() + "", nodebtype.getText() + "",
                        siteDetailForm.getNodebtype_photo() + "", classical.getText() + "", siteDetailForm.getClassical_photo() + "", enodebtype.getText() + "", siteDetailForm.getEnodebtype_photo() + "",
                        anchoroperator.getText() + "", siteDetailForm.getAnchoroperator_photo() + "", sharingopco1.getText() + "", siteDetailForm.getSharingopco1_photo() + "",
                        sharingopco2.getText() + "", siteDetailForm.getSharingopco2_photo() + "", sharingopco3.getText() + "", siteDetailForm.getSharingopco3_photo() + "",
                        infraprovider.getText() + "", siteDetailForm.getInfraprovider_photo() + "", type_id_od.getText() + "", siteDetailForm.getType_id_od_photo() + "",
                        infrashared.getText() + "", siteDetailForm.getInfrashared_photo() + "", extra1.getText() + "", siteDetailForm.getExtra1_photo() + "",
                        extra2.getText() + "", siteDetailForm.getExtra2_photo() + "", remark1.getText() + "", siteDetailForm.getRemark1_photo() + "", remark2.getText() + "",
                        siteDetailForm.getRemark2_photo() + "", 1, time));


                int count = db.getCountSiteDetail();
                tv_sitedetail_count.setText(count + "");

            }



            /*
db.insertSiteDetailData(new SiteDetailForm("1","1","1","1","1","1","1","1","1","1","1","1","1",
               "1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1",
               "1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1",1));
  */
        }
        if (v == btnsitedetail) {

            getFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag, new TabFragment()).addToBackStack(null).commit();

        }
    }

    private void selectImage(String Value) {

        if (Value.equals("one")) {
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
        if (Value.equals("6")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 6);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 6);
            startActivityForResult(i, 6);
        }
        if (Value.equals("7")) {
           /* Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 7);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 7);
            startActivityForResult(i, 7);
        }
        if (Value.equals("8")) {
           /* Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 8);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 8);
            startActivityForResult(i, 8);
        }
        if (Value.equals("9")) {
           /* Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 9);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 9);
            startActivityForResult(i, 9);
        }
        if (Value.equals("10")) {
            /*Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 10);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 10);
            startActivityForResult(i, 10);
        }
        if (Value.equals("11")) {
            /*Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 11);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 11);
            startActivityForResult(i, 11);
        }
        if (Value.equals("12")) {
         /*   Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 12);
            startActivityForResult(i, 12);
        }
        if (Value.equals("13")) {
           /* Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 13);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 13);
            startActivityForResult(i, 13);
        }
        if (Value.equals("14")) {
       /*     Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 14);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 14);
            startActivityForResult(i, 14);
        }
        if (Value.equals("15")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 15);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 15);
            startActivityForResult(i, 15);
        }
        if (Value.equals("16")) {
        /*    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 16);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 16);
            startActivityForResult(i, 16);
        }
        if (Value.equals("17")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 17);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 17);
            startActivityForResult(i, 17);
        }
        if (Value.equals("18")) {
           /* Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 18);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 18);
            startActivityForResult(i, 18);
        }
        if (Value.equals("19")) {
       /*     Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 19);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 19);
            startActivityForResult(i, 19);
        }
        if (Value.equals("20")) {
         /*   Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 20);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 20);
            startActivityForResult(i, 20);
        }
        if (Value.equals("21")) {
         /*   Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 21);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 21);
            startActivityForResult(i, 21);
        }
        if (Value.equals("22")) {
         /*   Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 22);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 22);
            startActivityForResult(i, 22);
        }
        if (Value.equals("23")) {
           /* Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 23);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 23);
            startActivityForResult(i, 23);
        }
        if (Value.equals("24")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 24);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 24);
            startActivityForResult(i, 24);
        }
        if (Value.equals("25")) {
        /*    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 25);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 25);
            startActivityForResult(i, 25);
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
                onCameraSurfaceViewActivity(path, "one", angle);

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
            if (requestCode == 6) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "6", angle);
                // onCaptureImageResult(data, "6");
            }
            if (requestCode == 7) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "7", angle);
                // onCaptureImageResult(data, "7");
            }
            if (requestCode == 8) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "8", angle);
                // onCaptureImageResult(data, "8");
            }
            if (requestCode == 9) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "9", angle);
                //  onCaptureImageResult(data, "9");
            }
            if (requestCode == 10) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "10", angle);
                // onCaptureImageResult(data, "10");
            }
            if (requestCode == 11) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "11", angle);
                //   onCaptureImageResult(data, "11");
            }
            if (requestCode == 12) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "12", angle);
                //    onCaptureImageResult(data, "12");
            }
            if (requestCode == 13) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "13", angle);
                //     onCaptureImageResult(data, "13");
            }
            if (requestCode == 14) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "14", angle);
                //    onCaptureImageResult(data, "14");
            }
            if (requestCode == 15) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "15", angle);
                //    onCaptureImageResult(data, "15");
            }
            if (requestCode == 16) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "16", angle);
                //    onCaptureImageResult(data, "16");
            }
            if (requestCode == 17) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "17", angle);
                //    onCaptureImageResult(data, "17");
            }
            if (requestCode == 18) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "18", angle);
                //    onCaptureImageResult(data, "18");
            }
            if (requestCode == 19) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "19", angle);
                //    onCaptureImageResult(data, "19");
            }
            if (requestCode == 20) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "20", angle);
                //     onCaptureImageResult(data, "20");
            }
            if (requestCode == 21) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "21", angle);
                //    onCaptureImageResult(data, "21");
            }
            if (requestCode == 22) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "22", angle);
                // onCaptureImageResult(data, "22");
            }
            if (requestCode == 23) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "23", angle);
                //     onCaptureImageResult(data, "23");
            }
            if (requestCode == 24) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "24", angle);
                //     onCaptureImageResult(data, "24");
            }
            if (requestCode == 25) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "25", angle);
                //     onCaptureImageResult(data, "25");
            }
        }


    }


  /*  private void onCaptureImageResult(Intent data, String name) {

        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        //.........................................one.....................................
        if (name.equals("one")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                siteDetailForm.setSiteid_photo(imgtxt);
                ivsiteid.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);

            }
        }
        //.........................................one.....................................
        //.........................................2.....................................
        if (name.equals("2")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                siteDetailForm.setSitename_photo(imgtxt);
                ivsitename.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);

            }
        }
        //......................................2................................................................
        //.........................................3.....................................
        if (name.equals("3")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                siteDetailForm.setTowersiteid(imgtxt);
                ivtowersiteid.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);

            }
        }
        //......................................3................................................................
        //.........................................4.....................................
        if (name.equals("4")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                siteDetailForm.setTowercompanyname__photo(imgtxt);
                ivtowercompnyname.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);

            }
        }
        //......................................4................................................................
        //.........................................5....................................
        if (name.equals("5")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                siteDetailForm.setSiteaddress_photo(imgtxt);
                ivsiteaddress.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);
            }
        }
        //......................................5................................................................
        //.........................................6....................................
        if (name.equals("6")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                siteDetailForm.setSectorid_photo(imgtxt);
                ivsectorid.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);
            }
        }
        //......................................6................................................................
        //.........................................7....................................
        if (name.equals("7")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                siteDetailForm.setSitetype_photo(imgtxt);
                ivsitetype.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);
            }
        }
        //......................................7................................................................
        //.........................................8....................................
        if (name.equals("8")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                siteDetailForm.setBuildingfloor_photo(imgtxt);
                ivbuildingfloor.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);
            }
        }
        //......................................8................................................................
        //.........................................9....................................
        if (name.equals("9")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                siteDetailForm.setBuildingheight_photo(imgtxt);
                ivbuildingheight.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);
            }
        }
        //......................................9................................................................
        //.........................................10....................................
        if (name.equals("10")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);
                siteDetailForm.setTowerheight_photo(imgtxt);
                ivtowerheight.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);
            }
        }
        //......................................10................................................................
        //.........................................11....................................
        if (name.equals("11")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                siteDetailForm.setFulltowerphoto(imgtxt);
                ivfulltowerphoto.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);
            }
        }
        //......................................11................................................................
        //.........................................12....................................
        if (name.equals("12")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);
                siteDetailForm.setNodebtype_photo(imgtxt);
                ivnodebtype.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);
            }
        }
        //......................................12...............................................................
        //.........................................13....................................
        if (name.equals("13")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\n Long :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                siteDetailForm.setClassical_photo(imgtxt);
                ivclassicalrrm.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);
            }
        }
        //......................................13................................................................
        //.........................................14....................................
        if (name.equals("14")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\n Long :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                siteDetailForm.setEnodebtype_photo(imgtxt);
                ivenodebtype.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);
            }
        }
        //......................................14................................................................
        //.........................................15....................................
        if (name.equals("15")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\n Long :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                siteDetailForm.setAnchoroperator_photo(imgtxt);
                ivanchoroper.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);
            }
        }
        //......................................15................................................................
        //.........................................16....................................
        if (name.equals("16")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\n Long :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                siteDetailForm.setSharingopco1_photo(imgtxt);
                ivsharingopco1.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);
            }
        }
        //......................................16................................................................
        //.........................................17....................................
        if (name.equals("17")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\n Long :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                siteDetailForm.setSharingopco2_photo(imgtxt);
                ivsharingopco2.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);
            }
        }
        //......................................17................................................................
        //.........................................18....................................
        if (name.equals("18")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\n Long :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                siteDetailForm.setSharingopco3_photo(imgtxt);
                ivsharingopco3.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);
            }
        }
        //......................................18................................................................
        //.........................................19....................................
        if (name.equals("19")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\n Long :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                siteDetailForm.setInfraprovider_photo(imgtxt);
                ivinfraprovider.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);
            }
        }
        //......................................19................................................................
        //.........................................20...................................
        if (name.equals("20")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\n Long :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                siteDetailForm.setType_id_od_photo(imgtxt);
                ivtypeindoor.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);
            }
        }
        //......................................20................................................................
        //.........................................21....................................
        if (name.equals("21")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\n Long :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                siteDetailForm.setInfrashared_photo(imgtxt);
                ivinfrashared.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);
            }
        }
        //......................................21................................................................
        //.........................................22....................................
        if (name.equals("22")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\n Long :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                siteDetailForm.setExtra1_photo(imgtxt);
                ivextra1.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);
            }
        }
        //......................................22................................................................
        //.........................................5....................................
        if (name.equals("23")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\n Long :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                siteDetailForm.setExtra2_photo(imgtxt);
                ivextra2.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);
            }
        }
        //......................................23................................................................
        //.........................................24....................................
        if (name.equals("24")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\n Long :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                siteDetailForm.setRemark1_photo(imgtxt);
                ivremark1.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);
            }
        }
        //......................................24................................................................
        //.........................................25....................................
        if (name.equals("25")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\n Long :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                siteDetailForm.setRemark2_photo(imgtxt);
                ivremark2.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);
            }
        }
        //......................................25................................................................
    }*/

    private void onCameraSurfaceViewActivity(String thumbnail, String name, String angle) {

        if (name.equals("one")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
             /*   String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);*/
                String imgtxt = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                siteDetailForm.setSiteid_photo(imgtxt);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                ivsiteid.setImageBitmap(out);
                Log.v("img-encode", imgtxt);
            }
        }
        if (name.equals("2")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
             /*   String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);*/
                String imgtxt = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                siteDetailForm.setSitename_photo(imgtxt);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                ivsitename.setImageBitmap(out);
                Log.v("img-encode", imgtxt);
            }
        }
        if (name.equals("3")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
            /*    String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);*/
                String imgtxt = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                siteDetailForm.setTowersiteid_photo(imgtxt);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                ivtowersiteid.setImageBitmap(out);
                Log.v("img-encode", imgtxt);
            }
        }
        if (name.equals("4")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
             /*   String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);*/
                String imgtxt = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                siteDetailForm.setTowercompanyname__photo(imgtxt);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                ivtowercompnyname.setImageBitmap(out);
                Log.v("img-encode", imgtxt);
            }
        }
        if (name.equals("5")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
             /*   String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);*/
                String imgtxt = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                siteDetailForm.setSiteaddress_photo(imgtxt);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                ivsiteaddress.setImageBitmap(out);
                Log.v("img-encode", imgtxt);
            }
        }
        if (name.equals("6")) {

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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);*/
                String imgtxt = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                siteDetailForm.setSectorid_photo(imgtxt);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                ivsectorid.setImageBitmap(out);
                Log.v("img-encode", imgtxt);
            }
        }
        if (name.equals("7")) {

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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);*/
                String imgtxt = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                siteDetailForm.setSitetype_photo(imgtxt);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                ivsitetype.setImageBitmap(out);
                Log.v("img-encode", imgtxt);
            }
        }
        if (name.equals("8")) {

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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);*/
                String imgtxt = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                siteDetailForm.setBuildingfloor_photo(imgtxt);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                ivbuildingfloor.setImageBitmap(out);
                Log.v("img-encode", imgtxt);
            }
        }
        if (name.equals("9")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
             /*   String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);*/
                String imgtxt = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                siteDetailForm.setBuildingheight_photo(imgtxt);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                ivbuildingheight.setImageBitmap(out);
                Log.v("img-encode", imgtxt);
            }
        }
        if (name.equals("10")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
        /*        String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);*/
                String imgtxt = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                siteDetailForm.setTowerheight_photo(imgtxt);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                ivtowerheight.setImageBitmap(out);
                Log.v("img-encode", imgtxt);
            }
        }
        if (name.equals("11")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
             /*   String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);*/
                String imgtxt = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                siteDetailForm.setFulltowerphoto_photo(imgtxt);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                ivfulltowerphoto.setImageBitmap(out);
                Log.v("img-encode", imgtxt);
            }
        }
        if (name.equals("12")) {

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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);*/
                String imgtxt = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                siteDetailForm.setNodebtype_photo(imgtxt);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                ivnodebtype.setImageBitmap(out);
                Log.v("img-encode", imgtxt);
            }
        }
        if (name.equals("13")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
           /*     String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);*/
                String imgtxt = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                siteDetailForm.setClassical_photo(imgtxt);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                ivclassicalrrm.setImageBitmap(out);
                Log.v("img-encode", imgtxt);
            }
        }
        if (name.equals("14")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
             /*   String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);*/
                String imgtxt = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                siteDetailForm.setEnodebtype_photo(imgtxt);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                ivenodebtype.setImageBitmap(out);
                Log.v("img-encode", imgtxt);
            }
        }
        if (name.equals("15")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
             /*   String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);*/
                String imgtxt = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                siteDetailForm.setAnchoroperator_photo(imgtxt);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                ivanchoroper.setImageBitmap(out);
                Log.v("img-encode", imgtxt);
            }
        }
        if (name.equals("16")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
             /*   String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);*/
                String imgtxt = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                siteDetailForm.setSharingopco1_photo(imgtxt);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                ivsharingopco1.setImageBitmap(out);
                Log.v("img-encode", imgtxt);
            }
        }
        if (name.equals("17")) {

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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);*/
                String imgtxt = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                siteDetailForm.setSharingopco2_photo(imgtxt);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                ivsharingopco2.setImageBitmap(out);
                Log.v("img-encode", imgtxt);
            }
        }
        if (name.equals("18")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
            /*    String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);*/
                String imgtxt = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                siteDetailForm.setSharingopco3_photo(imgtxt);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                ivsharingopco3.setImageBitmap(out);
                Log.v("img-encode", imgtxt);
            }
        }
        if (name.equals("19")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
           /*     String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);*/
                String imgtxt = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                siteDetailForm.setInfraprovider_photo(imgtxt);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                ivinfraprovider.setImageBitmap(out);
                Log.v("img-encode", imgtxt);
            }
        }
        if (name.equals("20")) {

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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);*/
                String imgtxt = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                siteDetailForm.setType_id_od_photo(imgtxt);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                ivtypeindoor.setImageBitmap(out);
                Log.v("img-encode", imgtxt);
            }
        }
        if (name.equals("21")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
             /*   String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);*/
                String imgtxt = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                siteDetailForm.setInfrashared_photo(imgtxt);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                ivinfrashared.setImageBitmap(out);
                Log.v("img-encode", imgtxt);
            }
        }
        if (name.equals("22")) {

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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);*/
                String imgtxt = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                siteDetailForm.setExtra1_photo(imgtxt);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                ivextra1.setImageBitmap(out);
                Log.v("img-encode", imgtxt);
            }
        }
        if (name.equals("23")) {

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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);*/
                String imgtxt = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                siteDetailForm.setExtra2_photo(imgtxt);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                ivextra2.setImageBitmap(out);
                Log.v("img-encode", imgtxt);
            }
        }
        if (name.equals("24")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
             /*   String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);*/
                String imgtxt = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                siteDetailForm.setRemark1_photo(imgtxt);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                ivremark1.setImageBitmap(out);
                Log.v("img-encode", imgtxt);
            }
        }
        if (name.equals("25")) {

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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);*/
                String imgtxt = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                siteDetailForm.setRemark2_photo(imgtxt);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                ivremark2.setImageBitmap(out);
                Log.v("img-encode", imgtxt);
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


}
