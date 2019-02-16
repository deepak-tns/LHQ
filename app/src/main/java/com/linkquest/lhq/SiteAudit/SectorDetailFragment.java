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
import com.linkquest.lhq.database.DatabaseHandler;
import com.linkquest.lhq.database.SectorDetailData;
import com.linkquest.lhq.database.SurveyForm;

import java.io.ByteArrayOutputStream;
import java.util.List;

import static android.app.Activity.RESULT_CANCELED;

/**
 * A simple {@link Fragment} subclass.
 */
public class SectorDetailFragment extends Fragment implements View.OnClickListener {


    private EditText sectordetail_edt_techavailable;
    private ImageButton sectordetail_img_techavailable;
    private EditText sectordetail_edt_bandavailable;
    private ImageButton sectordeatail_img_bandavailable;
    private EditText sectordeatail_edt_APC;
    private ImageButton sectordeatail_img_APC;
    private EditText sectoreatail_edt_preazimuth;
    private ImageButton sectordeatail_img_preazimuth;
    private EditText sectordeatail_edt_postazimuth;
    private ImageButton sectordeatail_img_postazimuth;
    private EditText sectordeatail_edt_premechanical_tilt;
    private ImageButton sectordeatail_img_premechanical_tilt;
    private EditText sectordeatail_edt_postmechanical_tilt;
    private ImageButton sectordeatail_img_postmechanical_tilt;
    private EditText sectordeatail_edt_preelectrical_tilt2g;
    private ImageButton sectordeatail_img_preelectrical_tilt2g;
    private EditText sectordeatail_edt_postelectrical_tilt2g;
    private ImageButton sectordeatail_img_postelectrical_tilt2g;
    private EditText sectordeatail_edt_preelectrical_tilt3g;
    private ImageButton sectordeatail_img_pretelectrical_tilt3g;
    private EditText sectordeatail_edt_postelectrical_tilt3g;
    private ImageButton sectordeatail_img_postelectrical_tilt3g;
    private EditText sectordeatail_edt_preelectrical_tilt4gf1;
    private ImageButton sectordeatail_img_preelectrical_tilt4gf1;
    private EditText sectordeatail_edt_postelectrical_tilt4gf1;
    private ImageButton sectordeatail_img_postelectrical_tilt4gf1;
    private EditText sectordeatail_edt_preelectrical_tilt4gf2;
    private ImageButton sectordeatail_img_preelectrical_tilt4gf2;
    private EditText sectordeatail_edt_postelectrical_tilt4gf2;
    private ImageButton sectordeatail_img_postelectrical_tilt4gf2;
    private EditText sectordeatail_edt_preelectrical_tilt;
    private ImageButton sectordeatail_img_preelectrical_tilt;
    private EditText sectordeatail_edt_postelectrical_tilt;
    private ImageButton sectordeatail_img_postelectrical_tilt;
    private EditText sectordeatail_edt_antennaheight;
    private ImageButton sectordeatail_img_antennaheight;
    private EditText sectordeatail_edt_poleheight;
    private ImageButton sectordeatail_img_poleheight;
    private EditText sectordeatail_edt_buildingheight;
    private ImageButton sectordeatail_img_buildingheight;
    private EditText sectordeatail_edt_towertype;
    private ImageButton sectordeatail_img_towertype;
    private EditText sectordeatail_edt_antennamake;
    private ImageButton sectordeatail_img_antennamake;
    private EditText sectordeatail_edt_antenmodel;
    private ImageButton sectordeatail_img_antennamodel;
    private EditText sectordeatail_edt_clutterpic;
    private ImageButton sectordeatail_img_clutterpic;
    private EditText sectordeatail_edt_txbandwidth;
    private ImageButton sectordeatail_img_txbandwidth;
    private EditText sectordeatail_edt_AST;
    private ImageButton sectordeatail_img_AST;
    private EditText sectordeatail_edt_APST;
    private ImageButton sectordeatail_img_APST;
    private EditText sectordeatail_edt_typ_enodeb;
    private ImageButton sectordeatail_img_typ_enodeb;
    private EditText sectordeatail_edt_mimo;
    private ImageButton sectordeatail_img_mimo;
    private EditText sectordeatail_edt_ret;
    private ImageButton sectordeatail_img_ret;
    private EditText sectordeatail_edt_enodebband;
    private ImageButton sectordeatail_img_enodebband;
    private EditText sectordeatail_edt_MOP;
    private ImageButton sectordeatail_img_MOP;
    private EditText sectordeatail_edt_COP;
    private ImageButton sectordeatail_img_COP;
    private EditText sectordeatail_edt_multiplexer_avail;
    private ImageButton sectordeatail_img_multiplexer_avail;
    private EditText sectordeatail_edt_antennapicleg;
    private ImageButton sectordeatail_img_antennapicleg;
    private EditText sectordeatail_edt_CRP;
    private ImageButton sectordeatail_img_CRP;
    private EditText sectordeatail_edt_powerdeboosting;
    private ImageButton sectordeatail_img_powerdeboosting;
    private EditText sectordeatail_edt_DFS;
    private ImageButton sectordeatail_img_DFS;
    private EditText sectordeatail_edt_rb_percell;
    private ImageButton sectordeatail_img_rb_percell;
    private EditText sectordeatail_edt_m_mimo;
    private ImageButton sectordeatail_img_m_mimo;
    private EditText sectordeatail_edt_FCT;
    private ImageButton sectordeatail_img_FCT;
    private EditText sectordeatail_edt_JCT;
    private ImageButton sectordeatail_img_JCT;
    private EditText sectordeatail_edt_FCL;
    private ImageButton sectordeatail_img_FCL;
    private EditText sectordeatail_edt_jumperlength;
    private ImageButton sectordeatail_img_jumperlength;
    private EditText sectordeatail_edt_prachconfig_index;
    private ImageButton sectordeatail_img_prachconfig_index;
    private EditText sectordeatail_edt_carrieraggregation;
    private ImageButton sectordeatail_img_carrieraggregation;
    private EditText sectordeatail_edt_ACD;
    private ImageButton sectordeatail_img_ACD;
    private EditText sectordeatail_edt_VSWRtest;
    private ImageButton sectordeatail_img_VSWRtest;
    private EditText sectordeatail_edt_URS;
    private ImageButton sectordeatail_img_URS;
    private EditText sectordeatail_edt_extra1;
    private ImageButton sectordeatail_img_extra1;
    private EditText sectordeatail_edt_extra2;
    private ImageButton sectordeatail_img_extra2;
    private EditText sectordeatail_edt_remak1;
    private ImageButton sectordeatail_img_remark1;
    private EditText sectordeatail_edt_remak2;
    private ImageButton sectordeatail_img_remark2;
    private Button btnsectordetail;

    private ImageView iv_sectordetail_techavailable;
    private ImageView iv_sectordetail_bandavailable;
    private ImageView iv_sectordetail_APC;
    private ImageView iv_sectordetail_preazimuth;
    private ImageView iv_sectordetail_postazimuth;
    private ImageView iv_sectordetail_premechanical_tilt;
    private ImageView iv_sectordetail_postmechanical_tilt;
    private ImageView  iv_sectordetail_preelectrical_tilt2g;
    private ImageView iv_sectordetail_postelectrical_tilt2g;
    private ImageView   iv_sectordetail_preelectrical_tilt3g;
    private ImageView iv_sectordetail_postelectrical_tilt3g;
    private ImageView   iv_sectordetail_preelectrical_tilt4gf1;
    private ImageView iv_sectordetail_postelectrical_tilt4gf1;
    private ImageView iv_sectordetail_preelectrical_tilt4gf2;
    private ImageView iv_sectordetail_postelectrical_tilt4gf2;
    private ImageView  iv_sectordetail_preelectrical_tilt;
    private ImageView iv_sectordetail_postelectrical_tilt;
    private ImageView iv_sectordetail_antennaheight;
    private ImageView iv_sectordetail_poleheight;
    private ImageView iv_sectordetail_buildingheight;
    private ImageView iv_sectordetail_towertype;
    private ImageView iv_sectordetail_antenamake;
    private ImageView iv_sectordetail_antenamodel;
    private ImageView iv_sectordetail_cullterpic;
    private ImageView iv_sectordetail_txbandwidth;
    private ImageView iv_sectordetail_AST;
    private ImageView iv_sectordetail_APST;
    private ImageView iv_sectordetail_typeenodeb;
    private ImageView  iv_sectordetail_mimotype;
    private ImageView iv_sectordetail_ret;
    private ImageView iv_sectordetail_enodebband;
    private ImageView iv_sectordetail_MOP;
    private ImageView iv_sectordetail_COP;
    private ImageView iv_sectordetail_multiplexer_avail;
    private ImageView iv_sectordetail_antennapicleg;
    private ImageView iv_sectordetail_CRP;
    private ImageView iv_sectordetail_powerdeboosting;
    private ImageView iv_sectordetail_DFS;
    private ImageView iv_sectordetail_rb_percell;
    private ImageView iv_sectordetail_img_m_mimo;
    private ImageView iv_sectordetail_FCT;
    private ImageView iv_sectordetail_JCT;
    private ImageView iv_sectordetail_FCL;
    private ImageView iv_sectordetail_jumperlength;
    private ImageView iv_sectordetail_prachconfig_index;
    private ImageView  iv_sectordetail_carrieraggregation;
    private ImageView iv_sectordetail_ACD;
    private ImageView  iv_sectordetail_VSWRtest;
    private ImageView iv_sectordetail_URS;
    private ImageView iv_sectordetail_extra1;
    private ImageView iv_sectordetail_extra2;
    private ImageView iv_sectordetail_remark1;
    private ImageView iv_sectordetail_remark2;

    private String sectordetail_techavailable ="";
    private String sectordetail_bandavailable ="";
    private String sectordetail_APC ="";
    private String sectordetail_preazimuth ="";
    private String sectordetail_postazimuth ="";
    private String sectordetail_premechanical_tilt="";
    private String sectordetail_postmechanical_tilt="";
    private String sectordetail_preelectrical_tilt2g="";
    private String sectordetail_postelectrical_tilt2g="";
    private String sectordetail_preelectrical_tilt3g="";
    private String sectordetail_postelectrical_tilt3g="";
    private String sectordetail_preelectrical_tilt4gf1="";
    private String sectordetail_postelectrical_tilt4gf1="";
    private String sectordetail_preelectrical_tilt4gf2="";
    private String sectordetail_postelectrical_tilt4gf2="";
    private String sectordetail_preelectrical_tilt="";
    private String sectordetail_postelectrical_tilt="";
    private String sectordetail_antennaheight="";
    private String sectordetail_poleheight ="";
    private String sectordetail_buildingheight="";
    private String sectordetail_towertype ="";
    private String sectordetail_antenamake="";
    private String sectordetail_antenamodel="";
    private String sectordetail_cullterpic="";
    private String sectordetail_txbandwidth="";
    private String sectordetail_AST="";
    private String sectordetail_APST="";
    private String sectordetail_typeenodeb="";
    private String sectordetail_mimotype="";
    private String sectordetail_ret="";
    private String sectordetail_enodebband="";
    private String sectordetail_MOP="";
    private String sectordetail_COP="";
    private String sectordetail_multiplexer_avail="";
    private String sectordetail_antennapicleg ="";
    private String sectordetail_CRP ="";
    private String sectordetail_powerdeboosting="";
    private String sectordetail_DFS="";
    private String sectordetail_rb_percell="";
    private String sectordetail_img_m_mimo="";
    private String sectordetail_FCT="";
    private String sectordetail_JCT="";
    private String sectordetail_FCL="";
    private String sectordetail_jumperlength="";
    private String sectordetail_prachconfig_index="";
    private String sectordetail_carrieraggregation="";
    private String sectordetail_ACD="";
    private String sectordetail_VSWRtest="";
    private String sectordetail_URS="";
    private String sectordetail_extra1="";
    private String sectordetail_extra2="";
    private String sectordetail_remark1="";
    private String sectordetail_remark2="";
    private String sectordeatailfrgamentname="";
    private Button btnsectordetailsave;
    private TextView tv_sectordetail_count;
    private TextView tv_sectordetail_count_previous;

    private LinearLayout linear_sectordetail_techavailable ;
    private LinearLayout linear_sectordetail_bandavailable ;
    private LinearLayout linear_sectordetail_APC ;
    private LinearLayout linear_sectordetail_preazimuth ;
    private LinearLayout linear_sectordetail_postazimuth ;
    private LinearLayout linear_sectordetail_premechanical_tilt;
    private LinearLayout linear_sectordetail_postmechanical_tilt;
    private LinearLayout linear_sectordetail_preelectrical_tilt2g;
    private LinearLayout linear_sectordetail_postelectrical_tilt2g;
    private LinearLayout linear_sectordetail_preelectrical_tilt3g;
    private LinearLayout linear_sectordetail_postelectrical_tilt3g;
    private LinearLayout linear_sectordetail_preelectrical_tilt4gf1;
    private LinearLayout linear_sectordetail_postelectrical_tilt4gf1;
    private LinearLayout linear_sectordetail_preelectrical_tilt4gf2;
    private LinearLayout linear_sectordetail_postelectrical_tilt4gf2;
    private LinearLayout linear_sectordetail_preelectrical_tilt;
    private LinearLayout linear_sectordetail_postelectrical_tilt;
    private LinearLayout linear_sectordetail_antennaheight;
    private LinearLayout linear_sectordetail_poleheight ;
    private LinearLayout linear_sectordetail_buildingheight;
    private LinearLayout linear_sectordetail_towertype ;
    private LinearLayout linear_sectordetail_antenamake;
    private LinearLayout linear_sectordetail_antenamodel;
    private LinearLayout linear_sectordetail_cullterpic;
    private LinearLayout linear_sectordetail_txbandwidth;
    private LinearLayout linear_sectordetail_AST;
    private LinearLayout linear_sectordetail_APST;
    private LinearLayout linear_sectordetail_typeenodeb;
    private LinearLayout linear_sectordetail_mimotype;
    private LinearLayout linear_sectordetail_ret;
    private LinearLayout linear_sectordetail_enodebband;
    private LinearLayout linear_sectordetail_MOP;
    private LinearLayout linear_sectordetail_COP;
    private LinearLayout linear_sectordetail_multiplexer_avail;
    private LinearLayout linear_sectordetail_antennapicleg ;
    private LinearLayout linear_sectordetail_CRP ;
    private LinearLayout linear_sectordetail_powerdeboosting;
    private LinearLayout linear_sectordetail_DFS;
    private LinearLayout linear_sectordetail_rb_percell;
    private LinearLayout linear_sectordetail_m_mimo;
    private LinearLayout linear_sectordetail_FCT;
    private LinearLayout linear_sectordetail_JCT;
    private LinearLayout linear_sectordetail_FCL;
    private LinearLayout linear_sectordetail_jumperlength;
    private LinearLayout linear_sectordetail_prachconfig_index;
    private LinearLayout linear_sectordetail_carrieraggregation;
    private LinearLayout linear_sectordetail_ACD;
    private LinearLayout linear_sectordetail_VSWRtest;
    private LinearLayout linear_sectordetail_URS;
    private LinearLayout linear_sectordetail_extra1;
    private LinearLayout linear_sectordetail_extra2;
    private LinearLayout linear_sectordetail_remark1;
    private LinearLayout linear_sectordetail_remark2;
    private LinearLayout linear_sdbasebandtype;
    private LinearLayout linear_sdrnc ;
    private LinearLayout linear_sdnoofchannelelement;

    private TextView tv_sectordetail_techavailable ;
    private TextView tv_sectordetail_bandavailable ;
    private TextView tv_sectordetail_APC ;
    private TextView tv_sectordetail_preazimuth ;
    private TextView tv_sectordetail_postazimuth ;
    private TextView tv_sectordetail_premechanical_tilt;
    private TextView tv_sectordetail_postmechanical_tilt;
    private TextView tv_sectordetail_preelectrical_tilt2g;
    private TextView tv_sectordetail_postelectrical_tilt2g;
    private TextView tv_sectordetail_preelectrical_tilt3g;
    private TextView tv_sectordetail_postelectrical_tilt3g;
    private TextView tv_sectordetail_preelectrical_tilt4gf1;
    private TextView tv_sectordetail_postelectrical_tilt4gf1;
    private TextView tv_sectordetail_preelectrical_tilt4gf2;
    private TextView tv_sectordetail_postelectrical_tilt4gf2;
    private TextView tv_sectordetail_preelectrical_tilt;
    private TextView tv_sectordetail_postelectrical_tilt;
    private TextView tv_sectordetail_antennaheight;
    private TextView tv_sectordetail_poleheight ;
    private TextView tv_sectordetail_buildingheight;
    private TextView tv_sectordetail_towertype ;
    private TextView tv_sectordetail_antenamake;
    private TextView tv_sectordetail_antenamodel;
    private TextView tv_sectordetail_cullterpic;
    private TextView tv_sectordetail_txbandwidth;
    private TextView tv_sectordetail_AST;
    private TextView tv_sectordetail_APST;
    private TextView tv_sectordetail_typeenodeb;
    private TextView tv_sectordetail_mimotype;
    private TextView tv_sectordetail_ret;
    private TextView tv_sectordetail_enodebband;
    private TextView tv_sectordetail_MOP;
    private TextView tv_sectordetail_COP;
    private TextView tv_sectordetail_multiplexer_avail;
    private TextView tv_sectordetail_antennapicleg ;
    private TextView tv_sectordetail_CRP ;
    private TextView tv_sectordetail_powerdeboosting;
    private TextView tv_sectordetail_DFS;
    private TextView tv_sectordetail_rb_percell;
    private TextView tv_sectordetail_m_mimo;
    private TextView tv_sectordetail_FCT;
    private TextView tv_sectordetail_JCT;
    private TextView tv_sectordetail_FCL;
    private TextView tv_sectordetail_jumperlength;
    private TextView tv_sectordetail_prachconfig_index;
    private TextView tv_sectordetail_carrieraggregation;
    private TextView tv_sectordetail_ACD;
    private TextView tv_sectordetail_VSWRtest;
    private TextView tv_sectordetail_URS;

    private TextView tv_sdbasebandtype;
    private TextView tv_sdrnc ;
    private TextView tv_sdnoofchannelelement;
    private  TextView tvextra1;
    private  TextView tvextra2;
    private  TextView tvremark1;
    private  TextView tvremark2;



    //insert new row 4/1/19
    private EditText sdbasebandtype_edt;
    private ImageButton sdbasebandtype_img;
    private ImageView sdbasebandtype_iv;
    private String sdbasebandtype_st ="";

    private EditText sdrnc_edt;
    private ImageButton sdrnc_img;
    private ImageView sdrnc_iv;
    private String sdrnc_st ="";

    private EditText sdnoofchannelelement_edt;
    private ImageButton sdnoofchannelelement_img;
    private ImageView sdnoofchannelelement_iv;
    private String sdnoofchannelelement_st="";

    String lat, log;
    Handler handler;
    String time;
    DatabaseHandler db;
    private SharedPreferenceUtils sharedPreferences;
    private String changetempleteName ="";
    private String changetempleteName_Operator="";
    private String activityType="";


    public SectorDetailFragment() {
        // Required empty public constructor
    }

    public static SectorDetailFragment newInstance(int index, String name) {
        SectorDetailFragment f = new SectorDetailFragment();
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
        View v = inflater.inflate(R.layout.fragment_sector_detail, container, false);
        sectordeatailfrgamentname = getArguments().getString("name");


        db = new DatabaseHandler(getActivity());
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                time = DateFormat.format("dd-MM-yyyy h:mm:ss:aa", System.currentTimeMillis()).toString();
                handler.postDelayed(this, 1000);
            }

        }, 1000);

        findids(v);

        tv_sectordetail_count_previous.setText(tv_sectordetail_count_previous.getText().toString()+ db.getCountSectorDetail());

        changeTemplete(v);
        return v;
    }

    private void findids(View v) {

        sectordetail_edt_techavailable = v.findViewById(R.id.sectordetail_edt_techavailable);
        sectordetail_img_techavailable = v.findViewById(R.id.sectordetail_img_techavailable);
        sectordetail_edt_bandavailable = v.findViewById(R.id.sectordetail_edt_bandavailable);
        sectordeatail_img_bandavailable = v.findViewById(R.id.sectordeatail_img_bandavailable);
        sectordeatail_edt_APC = v.findViewById(R.id.sectordeatail_edt_APC);
        sectordeatail_img_APC = v.findViewById(R.id.sectordeatail_img_APC);
        sectoreatail_edt_preazimuth = v.findViewById(R.id.sectoreatail_edt_preazimuth);
        sectordeatail_img_preazimuth = v.findViewById(R.id.sectordeatail_img_preazimuth);
        sectordeatail_edt_postazimuth = v.findViewById(R.id.sectordeatail_edt_postazimuth);
        sectordeatail_img_postazimuth = v.findViewById(R.id.sectordeatail_img_postazimuth);
        sectordeatail_edt_premechanical_tilt = v.findViewById(R.id.sectordeatail_edt_premechanical_tilt);
        sectordeatail_img_premechanical_tilt = v.findViewById(R.id.sectordeatail_img_premechanical_tilt);
        sectordeatail_edt_postmechanical_tilt = v.findViewById(R.id.sectordeatail_edt_postmechanical_tilt);
        sectordeatail_img_postmechanical_tilt = v.findViewById(R.id.sectordeatail_img_postmechanical_tilt);
        sectordeatail_edt_preelectrical_tilt2g = v.findViewById(R.id.sectordeatail_edt_preelectrical_tilt2g);
        sectordeatail_img_preelectrical_tilt2g = v.findViewById(R.id.sectordeatail_img_preelectrical_tilt2g);
        sectordeatail_edt_postelectrical_tilt2g = v.findViewById(R.id.sectordeatail_edt_postelectrical_tilt2g);
        sectordeatail_img_postelectrical_tilt2g = v.findViewById(R.id.sectordeatail_img_postelectrical_tilt2g);
        sectordeatail_edt_preelectrical_tilt3g = v.findViewById(R.id.sectordeatail_edt_preelectrical_tilt3g);
        sectordeatail_img_pretelectrical_tilt3g = v.findViewById(R.id.sectordeatail_img_pretelectrical_tilt3g);
        sectordeatail_edt_postelectrical_tilt3g = v.findViewById(R.id.sectordeatail_edt_postelectrical_tilt3g);
        sectordeatail_img_postelectrical_tilt3g = v.findViewById(R.id.sectordeatail_img_postelectrical_tilt3g);
        sectordeatail_edt_preelectrical_tilt4gf1 = v.findViewById(R.id.sectordeatail_edt_preelectrical_tilt4gf1);
        sectordeatail_img_preelectrical_tilt4gf1 = v.findViewById(R.id.sectordeatail_img_preelectrical_tilt4gf1);
        sectordeatail_edt_postelectrical_tilt4gf1 = v.findViewById(R.id.sectordeatail_edt_postelectrical_tilt4gf1);
        sectordeatail_img_postelectrical_tilt4gf1 = v.findViewById(R.id.sectordeatail_img_postelectrical_tilt4gf1);
        sectordeatail_edt_preelectrical_tilt4gf2 = v.findViewById(R.id.sectordeatail_edt_preelectrical_tilt4gf2);
        sectordeatail_img_preelectrical_tilt4gf2 = v.findViewById(R.id.sectordeatail_img_preelectrical_tilt4gf2);
        sectordeatail_edt_postelectrical_tilt4gf2 = v.findViewById(R.id.sectordeatail_edt_postelectrical_tilt4gf2);
        sectordeatail_img_postelectrical_tilt4gf2 = v.findViewById(R.id.sectordeatail_img_postelectrical_tilt4gf2);
        sectordeatail_edt_preelectrical_tilt = v.findViewById(R.id.sectordeatail_edt_preelectrical_tilt);
        sectordeatail_img_preelectrical_tilt = v.findViewById(R.id.sectordeatail_img_preelectrical_tilt);
        sectordeatail_edt_postelectrical_tilt = v.findViewById(R.id.sectordeatail_edt_postelectrical_tilt);
        sectordeatail_img_postelectrical_tilt = v.findViewById(R.id.sectordeatail_img_postelectrical_tilt);
        sectordeatail_edt_antennaheight = v.findViewById(R.id.sectordeatail_edt_antennaheight);
        sectordeatail_img_antennaheight = v.findViewById(R.id.sectordeatail_img_antennaheight);
        sectordeatail_edt_poleheight = v.findViewById(R.id.sectordeatail_edt_poleheight);
        sectordeatail_img_poleheight = v.findViewById(R.id.sectordeatail_img_poleheight);
        sectordeatail_edt_buildingheight = v.findViewById(R.id.sectordeatail_edt_buildingheight);
        sectordeatail_img_buildingheight = v.findViewById(R.id.sectordeatail_img_buildingheight);
        sectordeatail_edt_towertype = v.findViewById(R.id.sectordeatail_edt_towertype);
        sectordeatail_img_towertype = v.findViewById(R.id.sectordeatail_img_towertype);
        sectordeatail_edt_antennamake = v.findViewById(R.id.sectordeatail_edt_antennamake);
        sectordeatail_img_antennamake = v.findViewById(R.id.sectordeatail_img_antennamake);
        sectordeatail_edt_antenmodel = v.findViewById(R.id.sectordeatail_edt_antenmodel);
        sectordeatail_img_antennamodel = v.findViewById(R.id.sectordeatail_img_antennamodel);
        sectordeatail_edt_clutterpic = v.findViewById(R.id.sectordeatail_edt_clutterpic);
        sectordeatail_img_clutterpic = v.findViewById(R.id.sectordeatail_img_clutterpic);
        sectordeatail_edt_txbandwidth = v.findViewById(R.id.sectordeatail_edt_txbandwidth);
        sectordeatail_img_txbandwidth = v.findViewById(R.id.sectordeatail_img_txbandwidth);
        sectordeatail_edt_AST = v.findViewById(R.id.sectordeatail_edt_AST);
        sectordeatail_img_AST = v.findViewById(R.id.sectordeatail_img_AST);
        sectordeatail_edt_APST = v.findViewById(R.id.sectordeatail_edt_APST);
        sectordeatail_img_APST = v.findViewById(R.id.sectordeatail_img_APST);
        sectordeatail_edt_typ_enodeb = v.findViewById(R.id.sectordeatail_edt_typ_enodeb);
        sectordeatail_img_typ_enodeb = v.findViewById(R.id.sectordeatail_img_typ_enodeb);
        sectordeatail_edt_mimo = v.findViewById(R.id.sectordeatail_edt_mimo);
        sectordeatail_img_mimo = v.findViewById(R.id.sectordeatail_img_mimo);
        sectordeatail_edt_ret = v.findViewById(R.id.sectordeatail_edt_ret);
        sectordeatail_img_ret = v.findViewById(R.id.sectordeatail_img_ret);
        sectordeatail_edt_enodebband = v.findViewById(R.id.sectordeatail_edt_enodebband);
        sectordeatail_img_enodebband = v.findViewById(R.id.sectordeatail_img_enodebband);
        sectordeatail_edt_MOP = v.findViewById(R.id.sectordeatail_edt_MOP);
        sectordeatail_img_MOP = v.findViewById(R.id.sectordeatail_img_MOP);
        sectordeatail_edt_COP = v.findViewById(R.id.sectordeatail_edt_COP);
        sectordeatail_img_COP = v.findViewById(R.id.sectordeatail_img_COP);
        sectordeatail_edt_multiplexer_avail = v.findViewById(R.id.sectordeatail_edt_multiplexer_avail);
        sectordeatail_img_multiplexer_avail = v.findViewById(R.id.sectordeatail_img_multiplexer_avail);
        sectordeatail_edt_antennapicleg = v.findViewById(R.id.sectordeatail_edt_antennapicleg);
        sectordeatail_img_antennapicleg = v.findViewById(R.id.sectordeatail_img_antennapicleg);
        sectordeatail_edt_CRP = v.findViewById(R.id.sectordeatail_edt_CRP);
        sectordeatail_img_CRP = v.findViewById(R.id.sectordeatail_img_CRP);
        sectordeatail_edt_powerdeboosting = v.findViewById(R.id.sectordeatail_edt_powerdeboosting);
        sectordeatail_img_powerdeboosting = v.findViewById(R.id.sectordeatail_img_powerdeboosting);
        sectordeatail_edt_DFS = v.findViewById(R.id.sectordeatail_edt_DFS);
        sectordeatail_img_DFS = v.findViewById(R.id.sectordeatail_img_DFS);
        sectordeatail_edt_rb_percell = v.findViewById(R.id.sectordeatail_edt_rb_percell);
        sectordeatail_img_rb_percell = v.findViewById(R.id.sectordeatail_img_rb_percell);
        sectordeatail_edt_m_mimo = v.findViewById(R.id.sectordeatail_edt_m_mimo);
        sectordeatail_img_m_mimo = v.findViewById(R.id.sectordeatail_img_m_mimo);
        sectordeatail_edt_FCT = v.findViewById(R.id.sectordeatail_edt_FCT);
        sectordeatail_img_FCT = v.findViewById(R.id.sectordeatail_img_FCT);
        sectordeatail_edt_JCT = v.findViewById(R.id.sectordeatail_edt_JCT);
        sectordeatail_img_JCT = v.findViewById(R.id.sectordeatail_img_JCT);
        sectordeatail_edt_FCL = v.findViewById(R.id.sectordeatail_edt_FCL);
        sectordeatail_img_FCL = v.findViewById(R.id.sectordeatail_img_FCL);

        sectordeatail_edt_jumperlength = v.findViewById(R.id.sectordeatail_edt_jumperlength);
        sectordeatail_img_jumperlength = v.findViewById(R.id.sectordeatail_img_jumperlength);
        sectordeatail_edt_prachconfig_index = v.findViewById(R.id.sectordeatail_edt_prachconfig_index);
        sectordeatail_img_prachconfig_index = v.findViewById(R.id.sectordeatail_img_prachconfig_index);
        sectordeatail_edt_carrieraggregation = v.findViewById(R.id.sectordeatail_edt_carrieraggregation);
        sectordeatail_img_carrieraggregation = v.findViewById(R.id.sectordeatail_img_carrieraggregation);

        sectordeatail_edt_ACD = v.findViewById(R.id.sectordeatail_edt_ACD);
        sectordeatail_img_ACD = v.findViewById(R.id.sectordeatail_img_ACD);
        sectordeatail_edt_VSWRtest = v.findViewById(R.id.sectordeatail_edt_VSWRtest);
        sectordeatail_img_VSWRtest = v.findViewById(R.id.sectordeatail_img_VSWRtest);
        sectordeatail_edt_URS = v.findViewById(R.id.sectordeatail_edt_URS);
        sectordeatail_img_URS = v.findViewById(R.id.sectordeatail_img_URS);
        sectordeatail_edt_extra1 = v.findViewById(R.id.sectordeatail_edt_extra1);
        sectordeatail_img_extra1 = v.findViewById(R.id.sectordeatail_img_extra1);
        sectordeatail_edt_extra2 = v.findViewById(R.id.sectordeatail_edt_extra2);
        sectordeatail_img_extra2 = v.findViewById(R.id.sectordeatail_img_extra2);
        sectordeatail_edt_remak1 = v.findViewById(R.id.sectordeatail_edt_remak1);
        sectordeatail_img_remark1 = v.findViewById(R.id.sectordeatail_img_remark1);
        sectordeatail_edt_remak2 = v.findViewById(R.id.sectordeatail_edt_remak2);
        sectordeatail_img_remark2 = v.findViewById(R.id.sectordeatail_img_remark2);
        btnsectordetail = v.findViewById(R.id.btnsectordetail);
        btnsectordetailsave = v.findViewById(R.id.btnsectordetailsave);
        tv_sectordetail_count= v.findViewById(R.id.tv_sectordetail_count);
        tv_sectordetail_count_previous= v.findViewById(R.id.tv_sectordetail_count_previous);


        iv_sectordetail_techavailable   = v.findViewById(R.id.iv_sectordetail_techavailable);
                iv_sectordetail_bandavailable = v.findViewById(R.id.iv_sectordetail_bandavailable);
        iv_sectordetail_APC  = v.findViewById(R.id.iv_sectordetail_APC);
                iv_sectordetail_preazimuth = v.findViewById(R.id.iv_sectordetail_preazimuth);
        iv_sectordetail_postazimuth = v.findViewById(R.id.iv_sectordetail_postazimuth);
                iv_sectordetail_premechanical_tilt = v.findViewById(R.id.iv_sectordetail_premechanical_tilt);
        iv_sectordetail_postmechanical_tilt = v.findViewById(R.id.iv_sectordetail_postmechanical_tilt);
                iv_sectordetail_preelectrical_tilt2g = v.findViewById(R.id.iv_sectordetail_preelectrical_tilt2g);
        iv_sectordetail_postelectrical_tilt2g= v.findViewById(R.id.iv_sectordetail_postelectrical_tilt2g);

                iv_sectordetail_preelectrical_tilt3g = v.findViewById(R.id.iv_sectordetail_preelectrical_tilt3g);
        iv_sectordetail_postelectrical_tilt3g = v.findViewById(R.id.iv_sectordetail_postelectrical_tilt3g);
                iv_sectordetail_preelectrical_tilt4gf1 = v.findViewById(R.id.iv_sectordetail_preelectrical_tilt4gf1);
        iv_sectordetail_postelectrical_tilt4gf1 = v.findViewById(R.id.iv_sectordetail_postelectrical_tilt4gf1);
                iv_sectordetail_preelectrical_tilt4gf2 = v.findViewById(R.id.iv_sectordetail_preelectrical_tilt4gf2);
        iv_sectordetail_postelectrical_tilt4gf2 = v.findViewById(R.id.iv_sectordetail_postelectrical_tilt4gf2);
                iv_sectordetail_preelectrical_tilt= v.findViewById(R.id.iv_sectordetail_preelectrical_tilt);
        iv_sectordetail_postelectrical_tilt = v.findViewById(R.id.iv_sectordetail_postelectrical_tilt);
                iv_sectordetail_antennaheight = v.findViewById(R.id.iv_sectordetail_antennaheight);
        iv_sectordetail_poleheight = v.findViewById(R.id.iv_sectordetail_poleheight);
                iv_sectordetail_buildingheight = v.findViewById(R.id.iv_sectordetail_buildingheight);
        iv_sectordetail_towertype = v.findViewById(R.id.iv_sectordetail_towertype);
                iv_sectordetail_antenamake = v.findViewById(R.id.iv_sectordetail_antennamake);
        iv_sectordetail_antenamodel = v.findViewById(R.id.iv_sectordetail_antenamodel);
                iv_sectordetail_cullterpic = v.findViewById(R.id.iv_sectordetail_cullterpic);
        iv_sectordetail_txbandwidth = v.findViewById(R.id.iv_sectordetail_txbandwidth);
                iv_sectordetail_AST = v.findViewById(R.id.iv_sectordetail_AST);
        iv_sectordetail_APST = v.findViewById(R.id.iv_sectordetail_APST);
                iv_sectordetail_typeenodeb = v.findViewById(R.id.iv_sectordetail_typeenodeb);
        iv_sectordetail_mimotype = v.findViewById(R.id.iv_sectordetail_mimotype);
                iv_sectordetail_ret = v.findViewById(R.id.iv_sectordetail_ret);
        iv_sectordetail_enodebband = v.findViewById(R.id.iv_sectordetail_enodebband);
                iv_sectordetail_MOP = v.findViewById(R.id.iv_sectordetail_MOP);
        iv_sectordetail_COP  = v.findViewById(R.id.iv_sectordetail_COP);
                iv_sectordetail_multiplexer_avail  = v.findViewById(R.id.iv_sectordetail_multiplexer_avail);
        iv_sectordetail_antennapicleg = v.findViewById(R.id.iv_sectordetail_antennapicleg);
                iv_sectordetail_CRP = v.findViewById(R.id.iv_sectordetail_CRP);
        iv_sectordetail_powerdeboosting = v.findViewById(R.id.iv_sectordetail_powerdeboosting);
                iv_sectordetail_DFS  = v.findViewById(R.id.iv_sectordetail_DFS);
        iv_sectordetail_rb_percell = v.findViewById(R.id.iv_sectordetail_rb_percell);
                iv_sectordetail_img_m_mimo = v.findViewById(R.id.iv_sectordetail_img_m_mimo);
        iv_sectordetail_FCT  = v.findViewById(R.id.iv_sectordetail_FCT);
                iv_sectordetail_JCT = v.findViewById(R.id.iv_sectordetail_JCT);
        iv_sectordetail_FCL = v.findViewById(R.id.iv_sectordetail_FCL);
                iv_sectordetail_jumperlength = v.findViewById(R.id.iv_sectordetail_jumperlength);
        iv_sectordetail_prachconfig_index = v.findViewById(R.id.iv_sectordetail_prachconfig_index);
                iv_sectordetail_carrieraggregation = v.findViewById(R.id.iv_sectordetail_carrieraggregation);
        iv_sectordetail_ACD = v.findViewById(R.id.iv_sectordetail_ACD);
                iv_sectordetail_VSWRtest = v.findViewById(R.id.iv_sectordetail_VSWRtest);
        iv_sectordetail_URS = v.findViewById(R.id.iv_sectordetail_URS);
                iv_sectordetail_extra1  = v.findViewById(R.id.iv_sectordetail_extra1);
        iv_sectordetail_extra2  = v.findViewById(R.id.iv_sectordetail_extra2);
                iv_sectordetail_remark1  = v.findViewById(R.id.iv_sectordetail_remark1);
        iv_sectordetail_remark2  = v.findViewById(R.id.iv_sectordetail_remark2);

         sdbasebandtype_edt = v.findViewById(R.id.edt_sd_basebandunittype);
         sdbasebandtype_img = v.findViewById(R.id.ib_sd_basebandunittype);
         sdbasebandtype_iv =v.findViewById(R.id.iv_sd_basebandunittype);
         sdrnc_edt = v.findViewById(R.id.edt_sd_rncname);
         sdrnc_img =v.findViewById(R.id.ib_sd_rncname);
         sdrnc_iv =v.findViewById(R.id.iv_sd_rncname);
         sdnoofchannelelement_edt = v.findViewById(R.id.edt_noofchannelelement);
         sdnoofchannelelement_img = v.findViewById(R.id.ib_sd_noofchannelelement);
         sdnoofchannelelement_iv = v.findViewById(R.id.iv_sd_noofchannelelement);

        sdbasebandtype_img.setOnClickListener(this);
        sdrnc_img.setOnClickListener(this);
        sdnoofchannelelement_img.setOnClickListener(this);

       sectordetail_img_techavailable.setOnClickListener(this);
                sectordeatail_img_bandavailable.setOnClickListener(this);
        sectordeatail_img_APC.setOnClickListener(this);
                sectordeatail_img_preazimuth.setOnClickListener(this);
        sectordeatail_img_postazimuth.setOnClickListener(this);
                sectordeatail_img_premechanical_tilt.setOnClickListener(this);
        sectordeatail_img_postmechanical_tilt.setOnClickListener(this);
                sectordeatail_img_preelectrical_tilt2g.setOnClickListener(this);
        sectordeatail_img_postelectrical_tilt2g.setOnClickListener(this);
                sectordeatail_img_pretelectrical_tilt3g.setOnClickListener(this);
        sectordeatail_img_postelectrical_tilt3g.setOnClickListener(this);
                sectordeatail_img_preelectrical_tilt4gf1.setOnClickListener(this);
        sectordeatail_img_postelectrical_tilt4gf1.setOnClickListener(this);
                sectordeatail_img_preelectrical_tilt4gf2.setOnClickListener(this);
        sectordeatail_img_postelectrical_tilt4gf2.setOnClickListener(this);
                sectordeatail_img_preelectrical_tilt.setOnClickListener(this);
        sectordeatail_img_postelectrical_tilt.setOnClickListener(this);
                sectordeatail_img_antennaheight.setOnClickListener(this);
        sectordeatail_img_poleheight.setOnClickListener(this);
                sectordeatail_img_buildingheight.setOnClickListener(this);
        sectordeatail_img_towertype.setOnClickListener(this);
                sectordeatail_img_antennamake.setOnClickListener(this);
        sectordeatail_img_antennamodel.setOnClickListener(this);
                sectordeatail_img_clutterpic.setOnClickListener(this);
        sectordeatail_img_txbandwidth.setOnClickListener(this);
                sectordeatail_img_AST.setOnClickListener(this);
        sectordeatail_img_APST.setOnClickListener(this);
                sectordeatail_img_typ_enodeb.setOnClickListener(this);
        sectordeatail_img_mimo.setOnClickListener(this);
                sectordeatail_img_ret.setOnClickListener(this);
        sectordeatail_img_enodebband.setOnClickListener(this);
                sectordeatail_img_MOP.setOnClickListener(this);
        sectordeatail_img_COP.setOnClickListener(this);
                sectordeatail_img_multiplexer_avail.setOnClickListener(this);
        sectordeatail_img_antennapicleg.setOnClickListener(this);
                sectordeatail_img_CRP.setOnClickListener(this);
        sectordeatail_img_powerdeboosting.setOnClickListener(this);
                sectordeatail_img_DFS.setOnClickListener(this);
        sectordeatail_img_rb_percell.setOnClickListener(this);
                sectordeatail_img_m_mimo.setOnClickListener(this);
        sectordeatail_img_FCT.setOnClickListener(this);
                sectordeatail_img_JCT.setOnClickListener(this);
        sectordeatail_img_FCL.setOnClickListener(this);
                sectordeatail_img_jumperlength.setOnClickListener(this);
        sectordeatail_img_prachconfig_index.setOnClickListener(this);
                sectordeatail_img_carrieraggregation.setOnClickListener(this);
        sectordeatail_img_ACD.setOnClickListener(this);
                sectordeatail_img_VSWRtest.setOnClickListener(this);
        sectordeatail_img_URS.setOnClickListener(this);
                sectordeatail_img_extra1.setOnClickListener(this);
        sectordeatail_img_extra2.setOnClickListener(this);
                sectordeatail_img_remark1.setOnClickListener(this);
        sectordeatail_img_remark2.setOnClickListener(this);
        btnsectordetail.setOnClickListener(this);
        btnsectordetailsave.setOnClickListener(this);




    }

    private void changeTemplete(View v){
        /* sharedPreferences = SharedPreferenceUtils.getInstance();
        sharedPreferences.setContext(getActivity());
        changetempleteName = sharedPreferences.getString(AppConstants.surveytpeandcustomerandoperator);
        changetempleteName_Operator = sharedPreferences.getString(AppConstants.operators);*/
        List<SurveyForm> siteIDandDate = db.getLastSurveyformData();
        if(siteIDandDate.size() > 0){
            String surveytype_customer_operator = siteIDandDate.get(0).getSurveytype()+siteIDandDate.get(0).getCustomer()+siteIDandDate.get(0).getOperator();
            changetempleteName =surveytype_customer_operator;
            changetempleteName_Operator=siteIDandDate.get(0).getOperator();
            activityType=siteIDandDate.get(0).getTechnologytype();

        }

        //  start change templete code
        linear_sectordetail_techavailable =v.findViewById(R.id.sectordetail_linear_techavailable);
        linear_sectordetail_bandavailable = v.findViewById(R.id.sectordetail_linear_bandavailable);
        linear_sectordetail_APC = v.findViewById(R.id.sectordeatail_linear_APC);
        linear_sectordetail_preazimuth = v.findViewById(R.id.sectoreatail_linear_preazimuth);
        linear_sectordetail_postazimuth = v.findViewById(R.id.sectordeatail_linear_postazimuth);
        linear_sectordetail_premechanical_tilt = v.findViewById(R.id.sectordeatail_linear_premechanical_tilt);
        linear_sectordetail_postmechanical_tilt = v.findViewById(R.id.sectordeatail_linear_postmechanical_tilt);

        linear_sectordetail_preelectrical_tilt2g = v.findViewById(R.id.sectordeatail_linear_preelectrical_tilt2g);
        linear_sectordetail_postelectrical_tilt2g = v.findViewById(R.id.sectordeatail_linear_postelectrical_tilt2g);
        linear_sectordetail_preelectrical_tilt3g = v.findViewById(R.id.sectordeatail_linear_preelectrical_tilt3g);
        linear_sectordetail_postelectrical_tilt3g = v.findViewById(R.id.sectordeatail_linear_postelectrical_tilt3g);
        linear_sectordetail_preelectrical_tilt4gf1 = v.findViewById(R.id.sectordeatail_linear_preelectrical_tilt4gf1);
        linear_sectordetail_postelectrical_tilt4gf1 = v.findViewById(R.id.sectordeatail_linear_postelectrical_tilt4gf1);
        linear_sectordetail_preelectrical_tilt4gf2 = v.findViewById(R.id.sectordeatail_linear_preelectrical_tilt4gf2);
        linear_sectordetail_postelectrical_tilt4gf2 = v.findViewById(R.id.sectordeatail_linear_postelectrical_tilt4gf2);
/*        linear_sectordetail_preelectrical_tilt;
        linear_sectordetail_postelectrical_tilt;
        linear_sectordetail_antennaheight;
        linear_sectordetail_poleheight ;
        linear_sectordetail_buildingheight;
        linear_sectordetail_towertype ;
        linear_sectordetail_antenamake;
        linear_sectordetail_antenamodel;
        linear_sectordetail_cullterpic;
        linear_sectordetail_txbandwidth;
        linear_sectordetail_AST;
        linear_sectordetail_APST;
        linear_sectordetail_typeenodeb;*/
        linear_sectordetail_mimotype = v.findViewById(R.id.sectordeatail_linear_mimo);
        linear_sectordetail_ret = v.findViewById(R.id.sectordeatail_linear_ret);
        linear_sectordetail_enodebband = v.findViewById(R.id.sectordeatail_linear_enodebband);
        linear_sectordetail_MOP = v.findViewById(R.id.sectordeatail_linear_MOP);
        linear_sectordetail_COP = v.findViewById(R.id.sectordeatail_linear_COP);
        linear_sectordetail_multiplexer_avail = v.findViewById(R.id.sectordeatail_linear_multiplexer_avail);
        linear_sectordetail_antennapicleg  = v.findViewById(R.id.sectordeatail_linear_antennapicleg);
        linear_sectordetail_CRP  = v.findViewById(R.id.sectordeatail_linear_COP) ;
        linear_sectordetail_powerdeboosting = v.findViewById(R.id.sectordeatail_linear_CRP);
        linear_sectordetail_DFS = v.findViewById(R.id.sectordeatail_linear_DFS);
        linear_sectordetail_rb_percell = v.findViewById(R.id.sectordeatail_linear_rb_percell);
        linear_sectordetail_m_mimo = v.findViewById(R.id.sectordeatail_linear_m_mimo);
        linear_sectordetail_FCT = v.findViewById(R.id.sectordeatail_linear_FCT);
        linear_sectordetail_JCT = v.findViewById(R.id.sectordeatail_linear_JCT);
        linear_sectordetail_FCL = v.findViewById(R.id.sectordeatail_linear_FCL);
        linear_sectordetail_jumperlength  = v.findViewById(R.id.sectordeatail_linear_jumperlength);
        linear_sectordetail_prachconfig_index  = v.findViewById(R.id.sectordeatail_linear_prachconfig_index);
        linear_sectordetail_carrieraggregation  = v.findViewById(R.id.sectordeatail_linear_carrieraggregation);
        linear_sectordetail_ACD = v.findViewById(R.id.sectordeatail_linear_ACD);
        linear_sectordetail_VSWRtest = v.findViewById(R.id.sectordeatail_linear_VSWRtest);
        linear_sectordetail_URS = v.findViewById(R.id.sectordeatail_linear_URS);
       // linear_sectordetail_extra1;
      //  linear_sectordetail_extra2;
       // linear_sectordetail_remark1;
        linear_sectordetail_remark2 = v.findViewById(R.id.sectordeatail_linear_remak2);
        linear_sdbasebandtype = v.findViewById(R.id.linear_sd_basebandunittype);
      //  linear_sdrnc = v.findViewById(R.id.linear_sd_rncname);
        linear_sdnoofchannelelement = v.findViewById(R.id.linear_noofchannelelement);
        tvextra1 = v.findViewById(R.id.sectordeatail_tv_extra1);
        tvextra2 = v.findViewById(R.id.sectordeatail_tv_extra2);
        tvremark1 = v.findViewById(R.id.sectordeatail_tv_remak1);
        tvremark2 = v.findViewById(R.id.sectordeatail_tv_remak2);

       // tv_sectordetail_techavailable ;
        tv_sectordetail_bandavailable = v.findViewById(R.id.sectordetail_tv_bandavailable) ;
       // tv_sectordetail_APC ;
       // tv_sectordetail_preazimuth ;
      //  tv_sectordetail_postazimuth ;
      //  tv_sectordetail_premechanical_tilt;
      //  tv_sectordetail_postmechanical_tilt;
        tv_sectordetail_preelectrical_tilt2g =  v.findViewById(R.id.sectordeatail_tv_preelectrical_tilt2g) ;
        tv_sectordetail_postelectrical_tilt2g =  v.findViewById(R.id.sectordeatail_tv_postelectrical_tilt2g) ;
        tv_sectordetail_preelectrical_tilt3g =  v.findViewById(R.id.sectordeatail_tv_preelectrical_tilt3g) ;
        tv_sectordetail_postelectrical_tilt3g =  v.findViewById(R.id.sectordeatail_tv_postelectrical_tilt3g) ;
        tv_sectordetail_preelectrical_tilt4gf1 =  v.findViewById(R.id.sectordeatail_tv_preelectrical_tilt4gf1) ;
        tv_sectordetail_postelectrical_tilt4gf1 =  v.findViewById(R.id.sectordeatail_tv_postelectrical_tilt4gf1) ;
        tv_sectordetail_preelectrical_tilt4gf2 =  v.findViewById(R.id.sectordeatail_tv_preelectrical_tilt4gf2) ;
        tv_sectordetail_postelectrical_tilt4gf2 =  v.findViewById(R.id.sectordeatail_tv_postelectrical_tilt4gf2) ;
      //  tv_sectordetail_preelectrical_tilt;
      //  tv_sectordetail_postelectrical_tilt;
     //   tv_sectordetail_antennaheight;
        tv_sectordetail_poleheight   =  v.findViewById(R.id.sectordeatail_tv_poleheight) ;
        tv_sectordetail_buildingheight  =  v.findViewById(R.id.sectordeatail_tv_buildingheight) ;
    //    tv_sectordetail_towertype ;
    //    tv_sectordetail_antenamake;
    //    tv_sectordetail_antenamodel;
     //   tv_sectordetail_cullterpic;
      //  tv_sectordetail_txbandwidth;
        tv_sectordetail_AST  =  v.findViewById(R.id.sectordeatail_tv_AST) ;
       tv_sectordetail_APST =  v.findViewById(R.id.sectordeatail_tv_APST) ;
       tv_sectordetail_typeenodeb =  v.findViewById(R.id.sectordeatail_tv_typ_enodeb) ;
        tv_sectordetail_mimotype  =  v.findViewById(R.id.sectordeatail_tv_mimo);
        tv_sectordetail_ret =  v.findViewById(R.id.sectordeatail_tv_ret) ;
        tv_sectordetail_enodebband=  v.findViewById(R.id.sectordeatail_tv_enodebband) ;
        tv_sectordetail_MOP =   v.findViewById(R.id.sectordeatail_tv_MOP) ;
        tv_sectordetail_COP =   v.findViewById(R.id.sectordeatail_tv_COP) ;
        tv_sectordetail_multiplexer_avail =   v.findViewById(R.id.sectordeatail_tv_multiplexer_avail) ;
        tv_sectordetail_antennapicleg =   v.findViewById(R.id.sectordeatail_tv_antennapicleg) ;
     //   tv_sectordetail_CRP ;
       tv_sectordetail_powerdeboosting=   v.findViewById(R.id.sectordeatail_tv_powerdeboosting) ;
       tv_sectordetail_DFS =v.findViewById(R.id.sectordeatail_tv_DFS) ;
       tv_sectordetail_rb_percell =v.findViewById(R.id.sectordeatail_tv_rb_percell) ;
       tv_sectordetail_m_mimo = v.findViewById(R.id.sectordeatail_tv_m_mimo) ;
    //    tv_sectordetail_FCT;
    //    tv_sectordetail_JCT;
    //    tv_sectordetail_FCL;
    //    tv_sectordetail_jumperlength;
    //      tv_sectordetail_prachconfig_index;
    //    tv_sectordetail_carrieraggregation;
         tv_sectordetail_ACD =v.findViewById(R.id.sectordeatail_tv_ACD) ;
         tv_sectordetail_VSWRtest= v.findViewById(R.id.sectordeatail_tv_VSWRtest) ;
         tv_sectordetail_URS =v.findViewById(R.id.sectordeatail_tv_URS) ;
         tv_sdbasebandtype =v.findViewById(R.id.tv_sd_basebandunittype);
         tv_sdrnc = v.findViewById(R.id.tv_sd_rncname);
         tv_sdnoofchannelelement = v.findViewById(R.id.tv_noofchannelelement);




        //  end change templete code
        if(changetempleteName.equalsIgnoreCase("Site AuditERICSSONAIRTEL")){

            tvextra1.setText("Sector ID");
            tvextra2.setText("PCI/PSC/BCCH");
            tvremark1.setText("No of Antenna");
            tvremark2.setText("Antenna");

            linear_sectordetail_bandavailable.setVisibility(View.GONE);
           linear_sectordetail_preelectrical_tilt2g.setVisibility(View.GONE);
            linear_sectordetail_postelectrical_tilt2g.setVisibility(View.GONE);
            linear_sectordetail_preelectrical_tilt3g.setVisibility(View.GONE);
            linear_sectordetail_postelectrical_tilt3g.setVisibility(View.GONE);

           /* linear_sectordetail_preelectrical_tilt4gf1.setVisibility(View.GONE);
            linear_sectordetail_postelectrical_tilt4gf1.setVisibility(View.GONE);
            linear_sectordetail_preelectrical_tilt4gf2.setVisibility(View.GONE);
            linear_sectordetail_postelectrical_tilt4gf2.setVisibility(View.GONE);*/
            tv_sectordetail_preelectrical_tilt4gf1.setText("Pre Electrical Tilt 2G F1");
            tv_sectordetail_postelectrical_tilt4gf1.setText("Post Electrical Tilt 2G F1");
            tv_sectordetail_preelectrical_tilt4gf2.setText("Pre Electrical Tilt 2G F2");
            tv_sectordetail_postelectrical_tilt4gf2.setText("Post Electrical Tilt 2G F2");



            linear_sectordetail_mimotype.setVisibility(View.GONE);
            linear_sectordetail_ret.setVisibility(View.GONE);
            linear_sectordetail_enodebband.setVisibility(View.GONE);
            linear_sectordetail_MOP.setVisibility(View.GONE);
            linear_sectordetail_COP.setVisibility(View.GONE);
            linear_sectordetail_multiplexer_avail.setVisibility(View.GONE);
            linear_sectordetail_antennapicleg.setVisibility(View.GONE);
            linear_sectordetail_CRP.setVisibility(View.GONE);
            linear_sectordetail_powerdeboosting.setVisibility(View.GONE);
            linear_sectordetail_DFS.setVisibility(View.GONE);
            linear_sectordetail_rb_percell.setVisibility(View.GONE);
            linear_sectordetail_m_mimo.setVisibility(View.GONE);
            linear_sectordetail_FCT.setVisibility(View.GONE);
            linear_sectordetail_JCT.setVisibility(View.GONE);
            linear_sectordetail_FCL.setVisibility(View.GONE);
            linear_sectordetail_jumperlength.setVisibility(View.GONE);
            linear_sectordetail_prachconfig_index.setVisibility(View.GONE);
            linear_sectordetail_carrieraggregation.setVisibility(View.GONE);
            linear_sectordetail_ACD.setVisibility(View.GONE);
            linear_sectordetail_VSWRtest.setVisibility(View.GONE);
            linear_sectordetail_URS.setVisibility(View.GONE);
            linear_sdbasebandtype.setVisibility(View.GONE);
            linear_sdnoofchannelelement.setVisibility(View.GONE);
        }
        if(changetempleteName_Operator.equalsIgnoreCase("VFI")) {
            tv_sectordetail_bandavailable.setText("Multi Layer Supported (8, 16, 24, 32)");
            tv_sectordetail_preelectrical_tilt2g .setText("Pcell carrier Bandwidth");
            tv_sectordetail_postelectrical_tilt2g.setText("Scell carrier Bandwidth");
            tv_sectordetail_preelectrical_tilt3g.setText("DC 3G (Yes/No)");
            tv_sectordetail_postelectrical_tilt3g .setText("Power RS Boost (Pb value)");
            tv_sectordetail_preelectrical_tilt4gf1 .setText("Uplink RSSI all Antenna Port (below-115dbm)");
            tv_sectordetail_postelectrical_tilt4gf1 .setText("Antenna Element (xTxR) (x=32;64;128)");
            tv_sectordetail_preelectrical_tilt4gf2 .setText("Backhaul Bandwidth");
            tv_sectordetail_postelectrical_tilt4gf2.setText("Carrier Aggregation (mention Band & BW of CC)");
            tv_sectordetail_poleheight .setText("Scell Configurations (2CC, 3CC, 4CC dual F+T)");
            tv_sectordetail_buildingheight.setText("UL RSSI interference check");
            tv_sectordetail_enodebband.setText("No of Dedicated TSL for Data");
            tv_sectordetail_MOP .setText("Config. Radio Power 4G");
            tv_sectordetail_COP .setText("Config. Radio Power 3G");
            tv_sectordetail_multiplexer_avail.setText("No of TRX");
            tv_sectordetail_antennapicleg .setText("No of SDCCH");
            tvremark1.setText("Remark");
           // tvremark2.setText("");
            tvextra1.setText("Node B Power cell wise(20W/40W/60W)");
            tvextra2.setText("Node B transmitter output power measurement test.");

           // tv_sdbasebandtype .setText("");
           // tv_sdrnc .setText("");
           // tv_sdnoofchannelelement .setText("");

            linear_sectordetail_remark2.setVisibility(View.GONE);
            linear_sdnoofchannelelement.setVisibility(View.VISIBLE);


        }
        if (changetempleteName.equalsIgnoreCase("Site AuditNSNAIRTEL")&& activityType.equalsIgnoreCase("SCFT")) {

            tv_sectordetail_preelectrical_tilt2g .setText("CGI");
            tv_sectordetail_postelectrical_tilt2g.setText("Antenna Quantity");
            tv_sectordetail_preelectrical_tilt3g.setText("Antenna Gain -dBi");
            tv_sectordetail_postelectrical_tilt3g .setText("TX Power (On Top of BTS Cabinet)");
            tv_sectordetail_preelectrical_tilt4gf1 .setText("BCCH/PSC/PCI");
            tv_sectordetail_postelectrical_tilt4gf1 .setText("Bandwidth(Mhz)");
            tv_sectordetail_preelectrical_tilt4gf2 .setText("Cell ID");

            linear_sectordetail_postelectrical_tilt4gf2.setVisibility(View.GONE);
            linear_sectordetail_MOP.setVisibility(View.GONE);
            linear_sectordetail_antennapicleg.setVisibility(View.GONE);
            linear_sdnoofchannelelement.setVisibility(View.GONE);
            tv_sectordetail_poleheight.setText("Pole/Tower Height");
                    tv_sectordetail_AST.setText("Allocated BW");
                    tv_sectordetail_APST.setText("CPRI Cable/Feeder Solution");
                    tv_sectordetail_typeenodeb.setText("BTS/NodeB/eNodeB Type");
                    tv_sectordetail_ret.setText("TMA Planned");
                    tv_sectordetail_enodebband.setText("TMA Installed");
                    tv_sectordetail_multiplexer_avail.setText("No of TRX");
                    tv_sectordetail_powerdeboosting.setText("Combiners Fitted");
                    tv_sectordetail_DFS.setText("Combined/Uncombined Mode");
                    tv_sectordetail_rb_percell.setText("eNode B Hardware Details");
                    tv_sectordetail_m_mimo.setText("Tower Unit (Model No)");
                    tv_sectordetail_ACD.setText("Number of UL Channel Elements (CE's)");
                    tv_sectordetail_VSWRtest.setText("Number of DL Channel Elements (CE's)");
                    tv_sectordetail_URS.setText("Parented BSC");
                    tv_sdbasebandtype.setText("Base Unit (Model No)");
                    tv_sdrnc.setText("RNC/BSC Name");
     //             tv_sdnoofchannelelement.setText("");

            tvextra1.setText("UE Model");
            tvextra2.setText("UE IMEI No");
            tvremark1.setText("Phone Number");
            tvremark2.setText("SIM Number");

        }
        if (changetempleteName.equalsIgnoreCase("Site AuditNSNAIRTEL")&& activityType.equalsIgnoreCase("CLUSTER")) {

            tv_sectordetail_preelectrical_tilt2g .setText("Planned Azimuth");
            tv_sectordetail_postelectrical_tilt2g.setText("Changed Azimuth");
            tv_sectordetail_preelectrical_tilt3g.setText("Planned Tilt-ET");
            tv_sectordetail_postelectrical_tilt3g .setText("Changed E-Tilt");
            tv_sectordetail_preelectrical_tilt4gf1 .setText("Planned Tilt-MT");
            tv_sectordetail_postelectrical_tilt4gf1 .setText("Changed M-Tilt");
            tv_sectordetail_preelectrical_tilt4gf2 .setText("Planned AGL (mtrs)");
            tv_sectordetail_postelectrical_tilt4gf2 .setText("Changed AGL (mtrs)");

            tv_sectordetail_poleheight.setText("Pole/Tower Height");
            tv_sectordetail_MOP.setText("Planed PCI");
            tv_sectordetail_AST.setText("TAC");
            tv_sectordetail_APST.setText("BCCH/PSC/PCI");
            tv_sectordetail_typeenodeb.setText("2G Cell ID");
            tv_sectordetail_mimotype.setText("3G Cell ID");
            tv_sectordetail_ret.setText("FDD EARFCN DL");
            tv_sectordetail_enodebband.setText("FDD EARFCN UL");

            tv_sectordetail_multiplexer_avail.setText("No of TRX");
            linear_sectordetail_antennapicleg.setVisibility(View.GONE);
            tv_sectordetail_powerdeboosting.setText("FDD dlChannelBandwidth(MHz)");
            tv_sectordetail_DFS.setText("FDD ulChannelBandwidth(MHz)");
            tv_sectordetail_rb_percell.setText("4G Cell Id ");

            tv_sectordetail_URS.setText("Parented BSC");
            tv_sdbasebandtype.setText("Base Unit (Model No)");
            tv_sdrnc.setText("RNC/BSC Name");
            //             tv_sdnoofchannelelement.setText("");

         //   tvextra1.setText("UE Model");


        }

        }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            getFragmentManager().beginTransaction().detach(this).attach(this).commit();
        }
    }

    @Override
    public void onClick(View v) {

        if (v == sectordetail_img_techavailable) {
            selectImage("1");
        }

        if (v == sectordeatail_img_bandavailable) {
            selectImage("2");
        }
        if (v == sectordeatail_img_APC) {
            selectImage("3");
        }
        if (v == sectordeatail_img_preazimuth) {
            selectImage("4");
        }
        if (v == sectordeatail_img_postazimuth) {
            selectImage("5");
        }
        if (v == sectordeatail_img_premechanical_tilt) {
            selectImage("6");
        }
        if (v == sectordeatail_img_postmechanical_tilt) {
            selectImage("7");
        }
        if (v == sectordeatail_img_preelectrical_tilt2g) {
            selectImage("8");
        }
        if (v == sectordeatail_img_postelectrical_tilt2g) {
            selectImage("9");
        }
        if (v == sectordeatail_img_pretelectrical_tilt3g) {
            selectImage("10");
        }
        if (v == sectordeatail_img_postelectrical_tilt3g) {
            selectImage("11");
        }
        if (v == sectordeatail_img_preelectrical_tilt4gf1) {
            selectImage("12");
        }
        if (v == sectordeatail_img_postelectrical_tilt4gf1) {
            selectImage("13");
        }
        if (v == sectordeatail_img_preelectrical_tilt4gf2) {
            selectImage("14");
        }
        if (v == sectordeatail_img_postelectrical_tilt4gf2) {
            selectImage("15");
        }
        if (v == sectordeatail_img_preelectrical_tilt) {
            selectImage("16");
        }
        if (v == sectordeatail_img_postelectrical_tilt) {
            selectImage("17");
        }
        if (v == sectordeatail_img_antennaheight) {
            selectImage("18");
        }
        if (v == sectordeatail_img_poleheight) {
            selectImage("19");
        }
        if (v == sectordeatail_img_buildingheight) {
            selectImage("20");
        }
        if (v == sectordeatail_img_towertype) {
            selectImage("21");
        }
        if (v == sectordeatail_img_antennamake) {
            selectImage("22");
        }
        if (v == sectordeatail_img_antennamodel) {
            selectImage("23");
        }

        if (v == sectordeatail_img_clutterpic) {
            selectImage("24");
        }
        if (v == sectordeatail_img_txbandwidth) {
            selectImage("25");
        }
        if (v == sectordeatail_img_AST) {
            selectImage("26");
        }
        if (v == sectordeatail_img_APST) {
            selectImage("27");
        }
        if (v == sectordeatail_img_typ_enodeb) {
            selectImage("28");
        }
        if (v == sectordeatail_img_mimo) {
            selectImage("29");
        }
        if (v == sectordeatail_img_ret) {
            selectImage("30");
        }
        if (v == sectordeatail_img_enodebband) {
            selectImage("31");
        }
        if (v == sectordeatail_img_MOP) {
            selectImage("32");
        }
        if (v == sectordeatail_img_COP) {
            selectImage("33");
        }
        if (v == sectordeatail_img_multiplexer_avail) {
            selectImage("34");
        }
        if (v == sectordeatail_img_antennapicleg) {
            selectImage("35");
        }
        if (v == sectordeatail_img_CRP) {
            selectImage("36");
        }
        if (v == sectordeatail_img_powerdeboosting) {
            selectImage("37");
        }
        if (v == sectordeatail_img_DFS) {
            selectImage("38");
        }
        if (v == sectordeatail_img_rb_percell) {
            selectImage("39");
        }
        if (v == sectordeatail_img_m_mimo) {
            selectImage("40");
        }
        if (v == sectordeatail_img_FCT) {
            selectImage("41");
        }
        if (v == sectordeatail_img_JCT) {
            selectImage("42");
        }
        if (v == sectordeatail_img_FCL) {
            selectImage("43");
        }
        if (v == sectordeatail_img_jumperlength) {
            selectImage("44");
        }
        if (v == sectordeatail_img_prachconfig_index) {
            selectImage("45");
        }
        if (v == sectordeatail_img_carrieraggregation) {
            selectImage("46");
        }
        if (v == sectordeatail_img_ACD) {
            selectImage("47");
        }
        if (v == sectordeatail_img_VSWRtest) {
            selectImage("48");
        }
        if (v == sectordeatail_img_URS) {
            selectImage("49");
        }
        if (v == sectordeatail_img_extra1) {
            selectImage("50");
        }
        if (v == sectordeatail_img_extra2) {
            selectImage("51");
        }
        if (v == sectordeatail_img_remark1) {
            selectImage("52");
        }
        if (v == sectordeatail_img_remark2) {
            selectImage("53");
        }
        if (v == sdbasebandtype_img) {
            selectImage("54");
        }
        if (v == sdrnc_img) {
            selectImage("55");
        }
        if (v == sdnoofchannelelement_img) {
            selectImage("56");
        }
        if (v == btnsectordetailsave) {


/*
        db.insertSectorDetailData(new  SectorDetailData( sectordetail_edt_techavailable.getText()+"", sectordetail_techavailable, sectordetail_edt_bandavailable.getText()+"",  sectordetail_bandavailable ,  sectordeatail_edt_APC.getText()+"",  sectordetail_APC,  sectoreatail_edt_preazimuth.getText()+"",  sectordetail_preazimuth,  sectordeatail_edt_postazimuth.getText()+"", sectordetail_postazimuth,  sectordeatail_edt_premechanical_tilt.getText()+"", sectordetail_premechanical_tilt,  sectordeatail_edt_postmechanical_tilt.getText()+"",  sectordetail_postmechanical_tilt,sectordeatail_edt_preelectrical_tilt2g.getText()+"", sectordetail_preelectrical_tilt2g,  sectordeatail_edt_postelectrical_tilt2g.getText()+"", sectordetail_postelectrical_tilt2g,  sectordeatail_edt_preelectrical_tilt3g.getText()+"",  sectordetail_postelectrical_tilt3g,  sectordeatail_edt_postelectrical_tilt3g.getText()+"",
                 sectordetail_postelectrical_tilt3g,  sectordeatail_edt_preelectrical_tilt4gf1.getText()+"",  sectordetail_preelectrical_tilt4gf1,  sectordeatail_edt_postelectrical_tilt4gf1.getText()+"", sectordetail_postelectrical_tilt4gf1,  sectordeatail_edt_preelectrical_tilt4gf2.getText()+"", sectordetail_preelectrical_tilt4gf2, sectordeatail_edt_postelectrical_tilt4gf2.getText()+"",sectordetail_postelectrical_tilt4gf2,  sectordeatail_edt_preelectrical_tilt.getText()+"", sectordetail_preelectrical_tilt,  sectordeatail_edt_postelectrical_tilt.getText()+"",sectordetail_postelectrical_tilt,  sectordeatail_edt_antennaheight.getText()+"", sectordetail_antennaheight, sectordeatail_edt_poleheight.getText()+"",  sectordetail_poleheight, sectordeatail_edt_buildingheight.getText()+"",sectordetail_buildingheight,sectordeatail_edt_towertype.getText()+"",sectordetail_towertype, sectordeatail_edt_antennamake.getText()+"",sectordetail_antenamake ,
                sectordeatail_edt_antenmodel.getText()+"",  sectordetail_antenamodel,  sectordeatail_edt_clutterpic.getText()+"", sectordetail_cullterpic, sectordeatail_edt_txbandwidth.getText()+"", sectordetail_txbandwidth,sectordeatail_edt_AST.getText()+"", sectordetail_AST, sectordeatail_edt_APST.getText()+"",  sectordetail_APST, sectordeatail_edt_typ_enodeb.getText()+"", sectordetail_typeenodeb,  sectordeatail_edt_mimo.getText()+"", sectordetail_mimotype,  sectordeatail_edt_ret.getText()+"",sectordetail_ret, sectordeatail_edt_enodebband.getText()+"",sectordetail_enodebband, sectordeatail_edt_MOP.getText()+"",  sectordetail_MOP,  sectordeatail_edt_COP.getText()+"",sectordetail_COP,  sectordeatail_edt_multiplexer_avail.getText()+"",  sectordetail_multiplexer_avail,  sectordeatail_edt_antennapicleg.getText()+"", sectordetail_antennapicleg,  sectordeatail_edt_CRP.getText()+"",sectordetail_CRP,  sectordeatail_edt_powerdeboosting.getText()+"", sectordetail_powerdeboosting,
                 sectordeatail_edt_DFS.getText()+"", sectordetail_DFS, sectordeatail_edt_rb_percell.getText()+"",sectordetail_rb_percell,  sectordeatail_edt_m_mimo.getText()+"", sectordetail_img_m_mimo,  sectordeatail_edt_FCT.getText()+"", sectordetail_FCT,sectordeatail_edt_JCT.getText()+"", sectordetail_JCT,  sectordeatail_edt_FCL.getText()+"", sectordetail_FCL, sectordeatail_edt_jumperlength.getText()+"", sectordetail_jumperlength,  sectordeatail_edt_prachconfig_index.getText()+"",  sectordetail_prachconfig_index, sectordeatail_edt_carrieraggregation.getText()+"",sectordetail_carrieraggregation,  sectordeatail_edt_ACD.getText()+"", sectordetail_ACD, sectordeatail_edt_VSWRtest.getText()+"", sectordetail_VSWRtest, sectordeatail_edt_URS.getText()+"",sectordetail_URS, sectordeatail_edt_extra1.getText()+"",sectordetail_extra1, sectordeatail_edt_extra2.getText()+"",  sectordetail_extra2, sectordeatail_edt_remak1.getText()+"", sectordetail_remark1, sectordeatail_edt_remak2.getText()+"", sectordetail_remark2, sectordeatailfrgamentname, 1,time));
*/
//.................add coloum 4/1/19.......................................
            db.insertSectorDetailData(new  SectorDetailData( sectordetail_edt_techavailable.getText()+"", sectordetail_techavailable, sectordetail_edt_bandavailable.getText()+"",  sectordetail_bandavailable ,  sectordeatail_edt_APC.getText()+"",  sectordetail_APC,  sectoreatail_edt_preazimuth.getText()+"",  sectordetail_preazimuth,  sectordeatail_edt_postazimuth.getText()+"", sectordetail_postazimuth,  sectordeatail_edt_premechanical_tilt.getText()+"", sectordetail_premechanical_tilt,  sectordeatail_edt_postmechanical_tilt.getText()+"",  sectordetail_postmechanical_tilt,sectordeatail_edt_preelectrical_tilt2g.getText()+"", sectordetail_preelectrical_tilt2g,  sectordeatail_edt_postelectrical_tilt2g.getText()+"", sectordetail_postelectrical_tilt2g,  sectordeatail_edt_preelectrical_tilt3g.getText()+"",  sectordetail_postelectrical_tilt3g,  sectordeatail_edt_postelectrical_tilt3g.getText()+"",
                    sectordetail_postelectrical_tilt3g,  sectordeatail_edt_preelectrical_tilt4gf1.getText()+"",  sectordetail_preelectrical_tilt4gf1,  sectordeatail_edt_postelectrical_tilt4gf1.getText()+"", sectordetail_postelectrical_tilt4gf1,  sectordeatail_edt_preelectrical_tilt4gf2.getText()+"", sectordetail_preelectrical_tilt4gf2, sectordeatail_edt_postelectrical_tilt4gf2.getText()+"",sectordetail_postelectrical_tilt4gf2,  sectordeatail_edt_preelectrical_tilt.getText()+"", sectordetail_preelectrical_tilt,  sectordeatail_edt_postelectrical_tilt.getText()+"",sectordetail_postelectrical_tilt,  sectordeatail_edt_antennaheight.getText()+"", sectordetail_antennaheight, sectordeatail_edt_poleheight.getText()+"",  sectordetail_poleheight, sectordeatail_edt_buildingheight.getText()+"",sectordetail_buildingheight,sectordeatail_edt_towertype.getText()+"",sectordetail_towertype, sectordeatail_edt_antennamake.getText()+"",sectordetail_antenamake ,
                    sectordeatail_edt_antenmodel.getText()+"",  sectordetail_antenamodel,  sectordeatail_edt_clutterpic.getText()+"", sectordetail_cullterpic, sectordeatail_edt_txbandwidth.getText()+"", sectordetail_txbandwidth,sectordeatail_edt_AST.getText()+"", sectordetail_AST, sectordeatail_edt_APST.getText()+"",  sectordetail_APST, sectordeatail_edt_typ_enodeb.getText()+"", sectordetail_typeenodeb,  sectordeatail_edt_mimo.getText()+"", sectordetail_mimotype,  sectordeatail_edt_ret.getText()+"",sectordetail_ret, sectordeatail_edt_enodebband.getText()+"",sectordetail_enodebband, sectordeatail_edt_MOP.getText()+"",  sectordetail_MOP,  sectordeatail_edt_COP.getText()+"",sectordetail_COP,  sectordeatail_edt_multiplexer_avail.getText()+"",  sectordetail_multiplexer_avail,  sectordeatail_edt_antennapicleg.getText()+"", sectordetail_antennapicleg,  sectordeatail_edt_CRP.getText()+"",sectordetail_CRP,  sectordeatail_edt_powerdeboosting.getText()+"", sectordetail_powerdeboosting,
                    sectordeatail_edt_DFS.getText()+"", sectordetail_DFS, sectordeatail_edt_rb_percell.getText()+"",sectordetail_rb_percell,  sectordeatail_edt_m_mimo.getText()+"", sectordetail_img_m_mimo,  sectordeatail_edt_FCT.getText()+"", sectordetail_FCT,sectordeatail_edt_JCT.getText()+"", sectordetail_JCT,  sectordeatail_edt_FCL.getText()+"", sectordetail_FCL, sectordeatail_edt_jumperlength.getText()+"", sectordetail_jumperlength,  sectordeatail_edt_prachconfig_index.getText()+"",  sectordetail_prachconfig_index, sectordeatail_edt_carrieraggregation.getText()+"",sectordetail_carrieraggregation,  sectordeatail_edt_ACD.getText()+"", sectordetail_ACD, sectordeatail_edt_VSWRtest.getText()+"", sectordetail_VSWRtest, sectordeatail_edt_URS.getText()+"",sectordetail_URS, sectordeatail_edt_extra1.getText()+"",sectordetail_extra1, sectordeatail_edt_extra2.getText()+"",  sectordetail_extra2, sectordeatail_edt_remak1.getText()+"", sectordetail_remark1, sectordeatail_edt_remak2.getText()+"", sectordetail_remark2, sectordeatailfrgamentname, 1,time,
                    sdbasebandtype_edt.getText()+"",sdbasebandtype_st,sdrnc_edt.getText()+"",sdrnc_st,sdnoofchannelelement_edt.getText()+"",sdnoofchannelelement_st));


            int count = db.getCountSectorDetail();
            tv_sectordetail_count.setText(count+"");
            Toast.makeText(getActivity(),sectordeatailfrgamentname,Toast.LENGTH_LONG).show();
            if(sectordeatailfrgamentname.equalsIgnoreCase( "Sector4"))
            {
                btnsectordetail.setVisibility(View.VISIBLE);
            }
          //  Toast.makeText(getActivity(),sectordeatailfrgamentname,Toast.LENGTH_LONG).show();

          /*  TabLayout tabs = (TabLayout)((MainActivity)getActivity()).findViewById(R.id.tabs);
            tabs.getTabAt(1).select();*/

        }
        if (v == btnsectordetail) {
            getFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag, SitePanoramicFragment.newInstance(1000)).addToBackStack(null).commit();

        }

    }
    private void selectImage(String Value) {

        if (Value.equals("1")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 1);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",1);
            startActivityForResult(i, 1);
        }
        if (Value.equals("2")) {
        /*    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 2);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",2);
            startActivityForResult(i, 2);
           /*
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_CHOOSER);
            startActivityForResult(Intent.createChooser(intent,"Select Picture"), 2);*/

        }
        if (Value.equals("3")) {
        /*    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 3);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",3);
            startActivityForResult(i, 3);
        }
        if (Value.equals("4")) {
     /*       Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 4);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",4);
            startActivityForResult(i, 4);
        }
        if (Value.equals("5")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 5);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",5);
            startActivityForResult(i, 5);
        }
        if (Value.equals("6")) {
           /* Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 6);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",6);
            startActivityForResult(i, 6);
        }
        if (Value.equals("7")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 7);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",7);
            startActivityForResult(i, 7);
        }
        if (Value.equals("8")) {
         /*   Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 8);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",8);
            startActivityForResult(i, 8);
        }
        if (Value.equals("9")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 9);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",9);
            startActivityForResult(i, 9);
        }
        if (Value.equals("10")) {
           /* Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 10);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",10);
            startActivityForResult(i, 10);
        }
        if (Value.equals("11")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 11);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",11);
            startActivityForResult(i, 11);
        }
        if (Value.equals("12")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",12);
            startActivityForResult(i, 12);
        }
        if (Value.equals("13")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",13);
            startActivityForResult(i, 13);
        }
        if (Value.equals("14")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",14);
            startActivityForResult(i, 14);
        }
        if (Value.equals("15")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",15);
            startActivityForResult(i, 15);
        }
        if (Value.equals("16")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",16);
            startActivityForResult(i, 16);
        }
        if (Value.equals("17")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",17);
            startActivityForResult(i, 17);
        }
        if (Value.equals("18")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",18);
            startActivityForResult(i, 18);
        }
        if (Value.equals("19")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",19);
            startActivityForResult(i, 19);
        }
        if (Value.equals("20")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",20);
            startActivityForResult(i, 20);
        }
        if (Value.equals("21")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",21);
            startActivityForResult(i, 21);
        }
        if (Value.equals("22")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",22);
            startActivityForResult(i, 22);
        }
        if (Value.equals("23")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",23);
            startActivityForResult(i, 23);
        }
        if (Value.equals("24")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",24);
            startActivityForResult(i, 24);
        }
        if (Value.equals("25")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",25);
            startActivityForResult(i, 25);
        }
        if (Value.equals("26")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",26);
            startActivityForResult(i, 26);
        }
        if (Value.equals("26")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",26);
            startActivityForResult(i, 26);
        }
        if (Value.equals("27")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",27);
            startActivityForResult(i, 27);
        }
        if (Value.equals("28")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",28);
            startActivityForResult(i, 28);
        }
        if (Value.equals("29")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",29);
            startActivityForResult(i, 29);
        }
        if (Value.equals("30")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",30);
            startActivityForResult(i, 30);
        }
        if (Value.equals("31")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",31);
            startActivityForResult(i, 31);
        }
        if (Value.equals("32")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",32);
            startActivityForResult(i, 32);
        }
        if (Value.equals("33")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",33);
            startActivityForResult(i, 33);
        }
        if (Value.equals("34")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",34);
            startActivityForResult(i, 34);
        }
        if (Value.equals("35")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",35);
            startActivityForResult(i, 35);
        }
        if (Value.equals("36")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",36);
            startActivityForResult(i, 36);
        }
        if (Value.equals("37")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",37);
            startActivityForResult(i, 37);
        }
        if (Value.equals("38")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",38);
            startActivityForResult(i, 38);
        }
        if (Value.equals("39")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",39);
            startActivityForResult(i, 39);
        }
        if (Value.equals("40")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",40);
            startActivityForResult(i, 40);
        }
        if (Value.equals("41")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",41);
            startActivityForResult(i, 41);
        }
        if (Value.equals("42")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",42);
            startActivityForResult(i, 42);
        }
        if (Value.equals("43")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",43);
            startActivityForResult(i, 43);
        }
        if (Value.equals("44")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",44);
            startActivityForResult(i, 44);
        }
        if (Value.equals("45")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",45);
            startActivityForResult(i, 45);
        }
        if (Value.equals("46")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",46);
            startActivityForResult(i, 46);
        }
        if (Value.equals("47")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",47);
            startActivityForResult(i, 47);
        }
        if (Value.equals("48")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",48);
            startActivityForResult(i, 48);
        }
        if (Value.equals("49")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",49);
            startActivityForResult(i, 49);
        }
        if (Value.equals("50")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",50);
            startActivityForResult(i, 50);
        }
        if (Value.equals("51")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",51);
            startActivityForResult(i, 51);
        }
        if (Value.equals("52")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",52);
            startActivityForResult(i, 52);
        }
        if (Value.equals("53")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",53);
            startActivityForResult(i, 53);
        }
        if (Value.equals("54")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",54);
            startActivityForResult(i, 54);
        }
        if (Value.equals("55")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",55);
            startActivityForResult(i, 55);
        }
        if (Value.equals("56")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",56);
            startActivityForResult(i, 56);
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
                //  onCaptureImageResult(data, "12");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "12", angle);
            }
            if (requestCode == 13) {
                //  onCaptureImageResult(data, "12");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "13", angle);
            }
            if (requestCode == 14) {
                //  onCaptureImageResult(data, "12");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "14", angle);
            }
            if (requestCode == 15) {
                //  onCaptureImageResult(data, "12");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "15", angle);
            }
            if (requestCode == 16) {
                //  onCaptureImageResult(data, "12");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "16", angle);
            }
            if (requestCode == 17) {
                //  onCaptureImageResult(data, "12");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "17", angle);
            }
            if (requestCode == 18) {
                //  onCaptureImageResult(data, "12");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "18", angle);
            }
            if (requestCode == 19) {
                //  onCaptureImageResult(data, "12");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "19", angle);
            }
            if (requestCode == 20) {
                //  onCaptureImageResult(data, "12");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "20", angle);
            }
            if (requestCode == 21) {
                //  onCaptureImageResult(data, "12");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "21", angle);
            }
            if (requestCode == 22) {
                //  onCaptureImageResult(data, "12");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "22", angle);
            }
            if (requestCode == 23) {
                //  onCaptureImageResult(data, "12");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "23", angle);
            }
            if (requestCode == 24) {
                //  onCaptureImageResult(data, "12");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "24", angle);
            }
            if (requestCode == 25) {
                //  onCaptureImageResult(data, "12");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "25", angle);
            }
            if (requestCode == 26) {
                //  onCaptureImageResult(data, "12");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "26", angle);
            }
            if (requestCode == 27) {
                //  onCaptureImageResult(data, "12");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "27", angle);
            }
            if (requestCode == 28) {
                //  onCaptureImageResult(data, "12");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "28", angle);
            }
            if (requestCode == 29) {
                //  onCaptureImageResult(data, "12");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "29", angle);
            }
            if (requestCode == 30) {
                //  onCaptureImageResult(data, "12");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "30", angle);
            }
            if (requestCode == 31) {
                //  onCaptureImageResult(data, "12");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "31", angle);
            }
            if (requestCode == 32) {
                //  onCaptureImageResult(data, "12");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "32", angle);
            }
            if (requestCode == 33) {
                //  onCaptureImageResult(data, "12");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "33", angle);
            }
            if (requestCode == 34) {
                //  onCaptureImageResult(data, "12");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "34", angle);
            }
            if (requestCode == 35) {
                //  onCaptureImageResult(data, "12");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "35", angle);
            }
            if (requestCode == 36) {
                //  onCaptureImageResult(data, "12");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "36", angle);
            }
            if (requestCode == 37) {
                //  onCaptureImageResult(data, "12");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "37", angle);
            }
            if (requestCode == 38) {
                //  onCaptureImageResult(data, "12");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "38", angle);
            }
            if (requestCode == 39) {
                //  onCaptureImageResult(data, "12");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "39", angle);
            }
            if (requestCode == 40) {
                //  onCaptureImageResult(data, "12");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "40", angle);
            }
            if (requestCode == 41) {
                //  onCaptureImageResult(data, "12");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "41", angle);
            }
            if (requestCode == 42) {
                //  onCaptureImageResult(data, "12");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "42", angle);
            }
            if (requestCode == 43) {
                //  onCaptureImageResult(data, "12");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "43", angle);
            }
            if (requestCode == 44) {
                //  onCaptureImageResult(data, "12");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "44", angle);
            }
            if (requestCode == 45) {
                //  onCaptureImageResult(data, "12");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "45", angle);
            }
            if (requestCode == 46) {
                //  onCaptureImageResult(data, "12");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "46", angle);
            }
            if (requestCode == 47) {
                //  onCaptureImageResult(data, "12");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "47", angle);
            }
            if (requestCode == 48) {
                //  onCaptureImageResult(data, "12");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "48", angle);
            }
            if (requestCode == 49) {
                //  onCaptureImageResult(data, "12");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "49", angle);
            }
            if (requestCode == 50) {
                //  onCaptureImageResult(data, "12");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "50", angle);
            }
            if (requestCode == 51) {
                //  onCaptureImageResult(data, "12");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "51", angle);
            }
            if (requestCode == 52) {
                //  onCaptureImageResult(data, "12");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "52", angle);
            }
            if (requestCode == 53) {
                //  onCaptureImageResult(data, "12");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "53", angle);
            }
            if (requestCode == 54) {
                //  onCaptureImageResult(data, "12");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "54", angle);
            }
            if (requestCode == 55) {
                //  onCaptureImageResult(data, "12");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "55", angle);
            }
            if (requestCode == 56) {
                //  onCaptureImageResult(data, "12");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "56", angle);
            }
        }
    }

    private void onCameraSurfaceViewActivity(String thumbnail, String name, String angle) {

        if (name.equals("1")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
//                String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle + "\n"+"Blocking 0" ;
//                // Bitmap setTextwithImage =    ProcessingBitmap(thumbnail,totalString);
//                Bitmap setTextwithImage = DrawBitmapAll.drawTextToBitmap(getContext(), thumbnail, totalString);
//                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
//                setTextwithImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
//                String destinationpath = Environment.getExternalStorageDirectory().toString();
//                File destination = new File(destinationpath + "/LinkQuest/");
//                if (!destination.exists()) {
//                    destination.mkdirs();
//                }
//                File file = null;
//                FileOutputStream fo;
//                try {
//                    // destination.createNewFile();
//                    file = new File(destination, time + ".jpg");
//                    fo = new FileOutputStream(file);
//                    fo.write(bytes.toByteArray());
//                    fo.close();
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
//                String path = (file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
//                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);

                sectordetail_techavailable = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                iv_sectordetail_techavailable.setImageBitmap(out);
                Log.v("img-encode", sectordetail_techavailable);
            }
        }
        if (name.equals("2")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
             /*   String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle + "\n"+"Blocking 30";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_bandavailable = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                iv_sectordetail_bandavailable.setImageBitmap(out);
                Log.v("img-encode", sectordetail_bandavailable);
            }
        }
        if (name.equals("3")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
             /*   String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle + "\n"+"Blocking 60";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_APC = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                iv_sectordetail_APC.setImageBitmap(out);
                Log.v("img-encode", sectordetail_APC);
            }
        }
        if (name.equals("4")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
              /*  String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle + "\n"+"Blocking 90";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_preazimuth = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                iv_sectordetail_preazimuth.setImageBitmap(out);
                Log.v("img-encode", sectordetail_preazimuth);
            }
        }
        if (name.equals("5")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
              /*  String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 120";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_postazimuth = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                iv_sectordetail_postazimuth.setImageBitmap(out);
                Log.v("img-encode", sectordetail_postazimuth);
            }
        }
        if (name.equals("6")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
              /*  String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle + "\n"+"Blocking 150";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_premechanical_tilt = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                iv_sectordetail_premechanical_tilt.setImageBitmap(out);
                Log.v("img-encode", sectordetail_premechanical_tilt);
            }
        }
        if (name.equals("7")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
              /*  String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle + "\n"+"Blocking 180";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_postmechanical_tilt = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                iv_sectordetail_postmechanical_tilt.setImageBitmap(out);
                Log.v("img-encode", sectordetail_postmechanical_tilt);
            }
        }
        if (name.equals("8")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
             /*   String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 210";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_preelectrical_tilt2g = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                iv_sectordetail_preelectrical_tilt2g.setImageBitmap(out);
                Log.v("img-encode", sectordetail_preelectrical_tilt2g);
            }
        }
        if (name.equals("9")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
       /*         String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle + "\n"+"Blocking 240";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_postelectrical_tilt2g = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                iv_sectordetail_postelectrical_tilt2g.setImageBitmap(out);
                Log.v("img-encode", sectordetail_postelectrical_tilt2g);
            }
        }
        if (name.equals("10")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
            /*    String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 270";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_preelectrical_tilt3g = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                iv_sectordetail_preelectrical_tilt3g.setImageBitmap(out);
                Log.v("img-encode", sectordetail_preelectrical_tilt3g);
            }
        }
        if (name.equals("11")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
            /*    String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 300";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_postelectrical_tilt3g = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                iv_sectordetail_postelectrical_tilt3g.setImageBitmap(out);
                Log.v("img-encode", sectordetail_postelectrical_tilt3g);
            }
        }
        if (name.equals("12")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
 /*               String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 330";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_preelectrical_tilt4gf1 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                iv_sectordetail_preelectrical_tilt4gf1.setImageBitmap(decodeBase64(sectordetail_preelectrical_tilt4gf1));
                Log.v("img-encode", sectordetail_preelectrical_tilt4gf1);
            }
        }
        if (name.equals("13")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
             /*   String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 330";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_postelectrical_tilt4gf1 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                iv_sectordetail_postelectrical_tilt4gf1.setImageBitmap(out);
                Log.v("img-encode", sectordetail_postelectrical_tilt4gf1);
            }
        }
        if (name.equals("14")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
             /*   String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 330";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_preelectrical_tilt4gf2 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                iv_sectordetail_preelectrical_tilt4gf2.setImageBitmap(out);
                Log.v("img-encode", sectordetail_preelectrical_tilt4gf2);
            }
        }
        if (name.equals("15")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
              /*  String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 330";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_postelectrical_tilt4gf2 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                iv_sectordetail_postelectrical_tilt4gf2.setImageBitmap(out);
                Log.v("img-encode", sectordetail_postelectrical_tilt4gf2);
            }
        }
        if (name.equals("16")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
       /*         String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 330";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_preelectrical_tilt = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                iv_sectordetail_preelectrical_tilt.setImageBitmap(decodeBase64(sectordetail_preelectrical_tilt));
                Log.v("img-encode", sectordetail_preelectrical_tilt);
            }
        }
        if (name.equals("17")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
             /*   String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 330";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_postelectrical_tilt = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                iv_sectordetail_postelectrical_tilt.setImageBitmap(out);
                Log.v("img-encode", sectordetail_postelectrical_tilt);
            }
        }
        if (name.equals("18")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
            /*    String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 330";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_antennaheight = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                iv_sectordetail_antennaheight.setImageBitmap(decodeBase64(sectordetail_antennaheight));
                Log.v("img-encode", sectordetail_antennaheight);
            }
        }
        if (name.equals("19")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
             /*   String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 330";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_poleheight = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                iv_sectordetail_poleheight.setImageBitmap(out);
                Log.v("img-encode", sectordetail_poleheight);
            }
        }
        if (name.equals("20")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
              /*  String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 330";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_buildingheight = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                iv_sectordetail_buildingheight.setImageBitmap(out);
                Log.v("img-encode", sectordetail_buildingheight);
            }
        }
        if (name.equals("21")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
             /*   String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 330";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_towertype = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                iv_sectordetail_towertype.setImageBitmap(out);
                Log.v("img-encode", sectordetail_towertype);
            }
        }
        if (name.equals("22")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
       /*         String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 330";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_antenamake = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                iv_sectordetail_antenamake.setImageBitmap(out);
                Log.v("img-encode", sectordetail_antenamake);
            }
        }
        if (name.equals("23")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
           /*     String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 330";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_antenamodel = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                iv_sectordetail_antenamodel.setImageBitmap(out);
                Log.v("img-encode", sectordetail_antenamodel);
            }
        }
        if (name.equals("24")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
           /*     String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 330";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_cullterpic = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                iv_sectordetail_cullterpic.setImageBitmap(out);
                Log.v("img-encode", sectordetail_cullterpic);
            }
        }
        if (name.equals("25")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
            /*    String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 330";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_txbandwidth = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                iv_sectordetail_txbandwidth.setImageBitmap(decodeBase64(sectordetail_txbandwidth));
                Log.v("img-encode", sectordetail_txbandwidth);
            }
        }
        if (name.equals("26")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
         /*       String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 330";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_AST = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                iv_sectordetail_AST.setImageBitmap(out);
                Log.v("img-encode", sectordetail_AST);
            }
        }
        if (name.equals("27")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
     /*           String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 330";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_APST = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                iv_sectordetail_APST.setImageBitmap(decodeBase64(sectordetail_APST));
                Log.v("img-encode", sectordetail_APST);
            }
        }
        if (name.equals("28")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
          /*      String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 330";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_typeenodeb = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                iv_sectordetail_typeenodeb.setImageBitmap(decodeBase64(sectordetail_typeenodeb));
                Log.v("img-encode", sectordetail_typeenodeb);
            }
        }
        if (name.equals("29")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
            /*    String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 330";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_mimotype = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                iv_sectordetail_mimotype.setImageBitmap(decodeBase64(sectordetail_mimotype));
                Log.v("img-encode", sectordetail_mimotype);
            }
        }
        if (name.equals("30")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
            /*    String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 330";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_ret = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                iv_sectordetail_ret.setImageBitmap(out);
                Log.v("img-encode", sectordetail_ret);
            }
        }
        if (name.equals("31")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
        /*        String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 330";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_enodebband = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                iv_sectordetail_enodebband.setImageBitmap(out);
                Log.v("img-encode", sectordetail_enodebband);
            }
        }
        if (name.equals("32")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
             /*   String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 330";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_MOP = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                iv_sectordetail_MOP.setImageBitmap(out);
                Log.v("img-encode", sectordetail_MOP);
            }
        }
        if (name.equals("33")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
         /*       String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 330";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_COP = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                iv_sectordetail_COP.setImageBitmap(out);
                Log.v("img-encode", sectordetail_COP);
            }
        }
        if (name.equals("34")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
             /*   String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 330";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_multiplexer_avail = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                iv_sectordetail_multiplexer_avail.setImageBitmap(out);
                Log.v("img-encode", sectordetail_multiplexer_avail);
            }
        }
        if (name.equals("35")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
             /*   String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 330";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_antennapicleg = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                iv_sectordetail_antennapicleg.setImageBitmap(out);
                Log.v("img-encode", sectordetail_antennapicleg);
            }
        }
        if (name.equals("36")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
         /*       String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 330";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_CRP = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                iv_sectordetail_CRP.setImageBitmap(out);
                Log.v("img-encode", sectordetail_CRP);
            }
        }
        if (name.equals("37")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
          /*      String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 330";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_powerdeboosting = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                iv_sectordetail_powerdeboosting.setImageBitmap(out);
                Log.v("img-encode", sectordetail_powerdeboosting);
            }
        }
        if (name.equals("38")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
              /*  String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 330";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_DFS = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                iv_sectordetail_DFS.setImageBitmap(out);
                Log.v("img-encode", sectordetail_DFS);
            }
        }
        if (name.equals("39")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
       /*         String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 330";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_rb_percell = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                iv_sectordetail_rb_percell.setImageBitmap(out);
                Log.v("img-encode", sectordetail_rb_percell);
            }
        }
        if (name.equals("40")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
       /*         String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 330";
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
                String path = (file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));*/
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);
                sectordetail_img_m_mimo = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                iv_sectordetail_img_m_mimo.setImageBitmap(out);
                Log.v("img-encode", sectordetail_img_m_mimo);
            }
        }
        if (name.equals("41")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
          /*      String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 330";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_FCT = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                iv_sectordetail_FCT.setImageBitmap(out);
                Log.v("img-encode", sectordetail_FCT);
            }
        }
        if (name.equals("42")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
           /*     String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 330";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_JCT = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                iv_sectordetail_JCT.setImageBitmap(out);
                Log.v("img-encode", sectordetail_JCT);
            }
        }
        if (name.equals("43")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
 /*               String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 330";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_FCL = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                iv_sectordetail_FCL.setImageBitmap(out);
                Log.v("img-encode", sectordetail_FCL);
            }
        }
        if (name.equals("44")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
        /*        String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 330";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_jumperlength = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                iv_sectordetail_jumperlength.setImageBitmap(out);
                Log.v("img-encode", sectordetail_jumperlength);
            }
        }
        if (name.equals("45")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
       /*         String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 330";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_prachconfig_index = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                iv_sectordetail_prachconfig_index.setImageBitmap(out);
                Log.v("img-encode", sectordetail_prachconfig_index);
            }
        }
        if (name.equals("46")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
         /*       String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 330";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_carrieraggregation = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                iv_sectordetail_carrieraggregation.setImageBitmap(decodeBase64(sectordetail_carrieraggregation));
                Log.v("img-encode", sectordetail_carrieraggregation);
            }
        }
        if (name.equals("47")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
       /*         String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 330";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_ACD = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                iv_sectordetail_ACD.setImageBitmap(out);
                Log.v("img-encode", sectordetail_ACD);
            }
        }
        if (name.equals("48")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
          /*      String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 330";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_VSWRtest = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                iv_sectordetail_VSWRtest.setImageBitmap(out);
                Log.v("img-encode", sectordetail_VSWRtest);
            }
        }
        if (name.equals("49")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
           /*     String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 330";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_URS = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                iv_sectordetail_URS.setImageBitmap(out);
                Log.v("img-encode", sectordetail_URS);
            }
        }
        if (name.equals("50")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
           /*     String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 330";
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
                String path = (file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));*/
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);
                sectordetail_extra1 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                iv_sectordetail_extra1.setImageBitmap(out);
                Log.v("img-encode", sectordetail_extra1);
            }
        }
        if (name.equals("51")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
       /*         String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 330";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_extra2 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                iv_sectordetail_extra2.setImageBitmap(out);
                Log.v("img-encode", sectordetail_extra2);
            }
        }
        if (name.equals("52")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
            /*    String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 330";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_remark1 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                iv_sectordetail_remark1.setImageBitmap(out);
                Log.v("img-encode", sectordetail_remark1);
            }
        }
        if (name.equals("53")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
          /*      String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 330";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sectordetail_remark2 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                iv_sectordetail_remark2.setImageBitmap(out);
                Log.v("img-encode", sectordetail_remark2);
            }
        }
        if (name.equals("54")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
          /*      String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 330";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sdbasebandtype_st = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                sdbasebandtype_iv.setImageBitmap(out);
                Log.v("img-encode", sdbasebandtype_st);
            }
        }
        if (name.equals("55")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
          /*      String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 330";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sdrnc_st = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                sdrnc_iv.setImageBitmap(out);
                Log.v("img-encode", sdrnc_st);
            }
        }
        if (name.equals("56")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
          /*      String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 330";
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
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);*/
                sdnoofchannelelement_st = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 50, 50, false);
                sdnoofchannelelement_iv.setImageBitmap(out);
                Log.v("img-encode", sdbasebandtype_st);
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
