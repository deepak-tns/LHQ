package com.linkquest.lhq.RFSurvey;

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
import android.widget.TextView;
import android.widget.Toast;
import com.linkquest.lhq.GoogleGPSService;
import com.linkquest.lhq.R;
import com.linkquest.lhq.activity.CameraSurfaceViewActivity;
import com.linkquest.lhq.database.DatabaseHandler;


import java.io.ByteArrayOutputStream;

import static android.app.Activity.RESULT_CANCELED;

/**
 * A simple {@link Fragment} subclass.
 */
public class RFSiteDetailFragment extends Fragment implements View.OnClickListener{

    private EditText edt_SiteID;
    private EditText edt_SiteName;
    private EditText edt_SurveyDate;
    private EditText edt_City;
    private EditText edt_IMID;
    private EditText edt_Cluttertype;
    private EditText edt_SiteType;
    private EditText edt_Zone;
    private EditText edt_SiteCandidate;
    private EditText edt_BldgHeight;
    private EditText edt_BldgStructure;
    private EditText edt_AGL;
    private EditText edt_SiteContact;
    private EditText edt_AMSL;
    private EditText edt_SiteAddress;
    private EditText edt_SiteIndoor;
    private EditText edt_SiteOutdoor;
    private EditText edt_ShelterConcrete;
    private EditText edt_shelterFabricated;
    private EditText edt_Numerofotheroperator;
    private EditText edt_IPSite;
    private EditText edt_Others;
    private EditText edt_Sharing;
    private EditText edt_Hostoperator;
    private EditText edt_Anyguestoperators;
    private EditText edt_NoofGSMAntenna;
    private EditText edt_Lat;
    private EditText edt_Long;
   // add 050219.................
   private EditText edt_Commentsadd;
    private EditText edt_SNo;
    private EditText edt_NominalLat;
    private EditText edt_NominalLong;
    private EditText edt_TaLuk;
    private EditText edt_AntennaType;
    private EditText edt_CheckedBy;
    private EditText edt_SuveyedBy;
    private EditText edt_Surveytype;

    private ImageButton ib_SiteID;
    private ImageButton ib_SiteName;
    private ImageButton ib_SurveyDate;
    private ImageButton ib_City;
    private ImageButton ib_IMID;
    private ImageButton ib_Cluttertype;
    private ImageButton ib_SiteType;
    private ImageButton ib_Zone;
    private ImageButton ib_SiteCandidate;
    private ImageButton ib_BldgHeight;
    private ImageButton ib_BldgStructure;
    private ImageButton ib_AGL;
    private ImageButton ib_SiteContact;
    private ImageButton ib_AMSL;
    private ImageButton ib_SiteAddress;
    private ImageButton ib_SiteIndoor;
    private ImageButton ib_SiteOutdoor;
    private ImageButton ib_ShelterConcrete;
    private ImageButton ib_shelterFabricated;
    private ImageButton ib_Numerofotheroperator;
    private ImageButton ib_IPSite;
    private ImageButton ib_Others;
    private ImageButton ib_Sharing;
    private ImageButton ib_Hostoperator;
    private ImageButton ib_Anyguestoperators;
    private ImageButton ib_NoofGSMAntenna;
    private ImageView iv_SiteID;
    private ImageView iv_SiteName;
    private ImageView iv_SurveyDate;
    private ImageView iv_City;
    private ImageView iv_IMID;
    private ImageView iv_Cluttertype;
    private ImageView iv_SiteType;
    private ImageView iv_Zone;
    private ImageView iv_SiteCandidate;
    private ImageView iv_BldgHeight;
    private ImageView iv_BldgStructure;
    private ImageView iv_AGL;
    private ImageView iv_SiteContact;
    private ImageView iv_AMSL;
    private ImageView iv_SiteAddress;
    private ImageView iv_SiteIndoor;
    private ImageView iv_SiteOutdoor;
    private ImageView iv_ShelterConcrete;
    private ImageView iv_shelterFabricated;
    private ImageView iv_Numerofotheroperator;
    private ImageView iv_IPSite;
    private ImageView iv_Others;
    private ImageView iv_Sharing;
    private ImageView iv_Hostoperator;
    private ImageView iv_Anyguestoperators;
    private ImageView iv_NoofGSMAntenna;

    private String img_SiteID ="";
    private String img_SiteName ="";
    private String img_SurveyDate ="";
    private String img_City ="";
    private String img_IMID ="";
    private String img_Cluttertype ="";
    private String img_SiteType ="";
    private String img_Zone ="";
    private String img_SiteCandidate ="";
    private String img_BldgHeight ="";
    private String img_BldgStructure ="";
    private String img_AGL ="";
    private String img_SiteContact ="";
    private String img_AMSL ="";
    private String img_SiteAddress ="";
    private String img_SiteIndoor ="";
    private String img_SiteOutdoor ="";
    private String img_ShelterConcrete ="";
    private String img_shelterFabricated ="";
    private String img_Numerofotheroperator ="";
    private String img_IPSite ="";
    private String img_Others ="";
    private String img_Sharing ="";
    private String img_Hostoperator ="";
    private String img_Anyguestoperators ="";
    private String img_NoofGSMAntenna ="";


    private Button btn_save,btnrfdetail_next;
    private TextView tv_previouscount ,tv_aftercount;
    private String time,lat,log;
    private DatabaseHandler db;




    public RFSiteDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_rfsite_detail, container, false);
        db = new DatabaseHandler(getActivity());
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                time = DateFormat.format("dd-MM-yyyy h:mm:ss:aa", System.currentTimeMillis()).toString();
                handler.postDelayed(this, 1000);
            }

        }, 1000);
        findIds(v);

        int precount = db.getCountRFSiteDetail();
        tv_previouscount.setText(tv_previouscount.getText().toString()+precount+"");
        return v;
    }

    private void findIds(View v){

        edt_SiteID = v.findViewById(R.id.rfdetail_edt_site_id);
        edt_SiteName= v.findViewById(R.id.rfdetail_edt_site_name);
        edt_SurveyDate= v.findViewById(R.id.rfdetail_edt_surveydate);
        edt_City= v.findViewById(R.id.rfdetail_edt_city);
        edt_IMID = v.findViewById(R.id.rfdetail_edt_imid);
        edt_Cluttertype= v.findViewById(R.id.rfdetail_edt_cluttertype);
        edt_SiteType= v.findViewById(R.id.rfdetail_edt_sitetype);
        edt_Zone= v.findViewById(R.id.rfdetail_edt_zone);
        edt_SiteCandidate= v.findViewById(R.id.rfdetail_edt_sitecandidate);
        edt_BldgHeight= v.findViewById(R.id.rfdetail_edt_bldgheight);
        edt_BldgStructure= v.findViewById(R.id.rfdetail_edt_bldgstructure);
        edt_AGL= v.findViewById(R.id.rfdetail_edt_agl);
        edt_SiteContact= v.findViewById(R.id.rfdetail_edt_sitecontact);
        edt_AMSL= v.findViewById(R.id.rfdetail_edt_amsl);
        edt_SiteAddress= v.findViewById(R.id.rfdetail_edt_siteaddress);
        edt_SiteIndoor= v.findViewById(R.id.rfdetail_edt_siteindoor);
        edt_SiteOutdoor= v.findViewById(R.id.rfdetail_edt_siteoutdoor);
        edt_ShelterConcrete= v.findViewById(R.id.rfdetail_edt_ShelterConcrete);
        edt_shelterFabricated= v.findViewById(R.id.rfdetail_edt_shelterFabricated);
        edt_Numerofotheroperator= v.findViewById(R.id.rfdetail_edt_numofotheropertaor);
        edt_IPSite= v.findViewById(R.id.rfdetail__edt_ipsite);
        edt_Others = v.findViewById(R.id.rfdetail__edt_others);
        edt_Sharing= v.findViewById(R.id.rfdetail__edt_sharing);
        edt_Hostoperator= v.findViewById(R.id.rfdetail__edt_hostoperator);
        edt_Anyguestoperators = v.findViewById(R.id.rfdetail__edt_anyguestoperators);
        edt_NoofGSMAntenna= v.findViewById(R.id.rfdetail__edt_NoofGSMAntenna);
        edt_Lat = v.findViewById(R.id.rfdetail__edt_lat);
        edt_Lat.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        edt_Long= v.findViewById(R.id.rfdetail_edt_log);
        edt_Long.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        edt_Commentsadd= v.findViewById(R.id.rfdetail__edt_commentadd);
        edt_SNo= v.findViewById(R.id.rfdetail__edt_sno);
        edt_NominalLat= v.findViewById(R.id.rfdetail__edt_nominallat);
        edt_NominalLong= v.findViewById(R.id.rfdetail_edt_nominallog);
        edt_TaLuk= v.findViewById(R.id.rfdetail__edt_taluk);
        edt_AntennaType= v.findViewById(R.id.rfdetail__edt_antennatype);
        edt_CheckedBy= v.findViewById(R.id.rfdetail__edt_checkedby);
        edt_SuveyedBy= v.findViewById(R.id.rfdetail__edt_surveyedby);
        edt_Surveytype= v.findViewById(R.id.rfdetail__edt_surveytype);

        btn_save = v.findViewById(R.id.btnrfdetailsave);
        btnrfdetail_next = v.findViewById(R.id.btnrfdetail_next);
        tv_previouscount = v.findViewById(R.id.tv_rfdetail_count_previous);
        tv_aftercount = v.findViewById(R.id.tv_rfdetail_count);

        ib_SiteID = v.findViewById(R.id.rfdetail_img_site_id);
        ib_SiteName= v.findViewById(R.id.rfdetail_img_site_name);
        ib_SurveyDate= v.findViewById(R.id.rfdetail_img_surveydate);
        ib_City= v.findViewById(R.id.rfdetail_img_city);
        ib_IMID = v.findViewById(R.id.rfdetail_img_imid);
        ib_Cluttertype= v.findViewById(R.id.rfdetail_img_cluttertype);
        ib_SiteType= v.findViewById(R.id.rfdetail_img_sitetype);
        ib_Zone= v.findViewById(R.id.rfdetail_img_zone);
        ib_SiteCandidate= v.findViewById(R.id.rfdetail_img_sitecandidate);
        ib_BldgHeight= v.findViewById(R.id.rfdetail_img_bldgheight);
        ib_BldgStructure= v.findViewById(R.id.rfdetail_img_bldgstructure);
        ib_AGL= v.findViewById(R.id.rfdetail_img_agl);
        ib_SiteContact= v.findViewById(R.id.rfdetail_img_sitecontact);
        ib_AMSL= v.findViewById(R.id.rfdetail_img_amsl);
        ib_SiteAddress= v.findViewById(R.id.rfdetail_img_siteaddress);
        ib_SiteIndoor= v.findViewById(R.id.rfdetail_img_siteindoor);
        ib_SiteOutdoor= v.findViewById(R.id.rfdetail_img_siteoutdoor);
        ib_ShelterConcrete= v.findViewById(R.id.rfdetail_img_ShelterConcrete);
        ib_shelterFabricated= v.findViewById(R.id.rfdetail_img_shelterFabricated);
        ib_Numerofotheroperator= v.findViewById(R.id.rfdetail_img_numofotheropertaor);
        ib_IPSite= v.findViewById(R.id.rfdetail_img_ipsite);
        ib_Others = v.findViewById(R.id.rfdetail_img_others);
        ib_Sharing= v.findViewById(R.id.rfdetail_img_sharing);
        ib_Hostoperator= v.findViewById(R.id.rfdetail_img_hostoperator);
        ib_Anyguestoperators = v.findViewById(R.id.rfdetail_img_anyguestoperators);
        ib_NoofGSMAntenna= v.findViewById(R.id.rfdetail_img_NoofGSMAntenna);

        iv_SiteID = v.findViewById(R.id.rfdetail_ivsite_id);
        iv_SiteName= v.findViewById(R.id.rfdetail_ivsite_name);
        iv_SurveyDate= v.findViewById(R.id.rfdetail_ivsurveydate);
        iv_City= v.findViewById(R.id.rfdetail_ivcity);
        iv_IMID = v.findViewById(R.id.rfdetail_iv_imid);
        iv_Cluttertype= v.findViewById(R.id.rfdetail_ivcluttertype);
        iv_SiteType= v.findViewById(R.id.rfdetail_ivsitetype);
        iv_Zone= v.findViewById(R.id.rfdetail_iv_zone);
        iv_SiteCandidate= v.findViewById(R.id.rfdetail_iv_sitecandidate);
        iv_BldgHeight= v.findViewById(R.id.rfdetail_iv_bldgheight);
        iv_BldgStructure= v.findViewById(R.id.rfdetail_iv_bldgstructure);
        iv_AGL= v.findViewById(R.id.rfdetail_iv_agl);
        iv_SiteContact= v.findViewById(R.id.rfdetail_iv_sitecontact);
        iv_AMSL= v.findViewById(R.id.rfdetail_iv_amsl);
        iv_SiteAddress= v.findViewById(R.id.rfdetail_iv_siteaddress);
        iv_SiteIndoor= v.findViewById(R.id.rfdetail_iv_siteindoor);
        iv_SiteOutdoor= v.findViewById(R.id.rfdetail_iv_siteoutdoor);
        iv_ShelterConcrete= v.findViewById(R.id.rfdetail_iv_ShelterConcrete);
        iv_shelterFabricated= v.findViewById(R.id.rfdetail_iv_shelterFabricated);
        iv_Numerofotheroperator= v.findViewById(R.id.rfdetail_iv_numofotheropertaor);
        iv_IPSite= v.findViewById(R.id.rfdetail_iv_ipsite);
        iv_Others = v.findViewById(R.id.rfdetail_iv_others);
        iv_Sharing= v.findViewById(R.id.rfdetail_iv_sharing);
        iv_Hostoperator= v.findViewById(R.id.rfdetail_iv_hostoperator);
        iv_Anyguestoperators = v.findViewById(R.id.rfdetail_iv_anyguestoperators);
        iv_NoofGSMAntenna= v.findViewById(R.id.rfdetail_iv_NoofGSMAntenna);

        ib_SiteID .setOnClickListener(this);
        ib_SiteName .setOnClickListener(this);
        ib_SurveyDate .setOnClickListener(this);
        ib_City .setOnClickListener(this);
        ib_IMID .setOnClickListener(this);
        ib_Cluttertype .setOnClickListener(this);
        ib_SiteType .setOnClickListener(this);
        ib_Zone .setOnClickListener(this);
        ib_SiteCandidate .setOnClickListener(this);
        ib_BldgHeight .setOnClickListener(this);
        ib_BldgStructure .setOnClickListener(this);
        ib_AGL .setOnClickListener(this);
        ib_SiteContact .setOnClickListener(this);
        ib_AMSL .setOnClickListener(this);
        ib_SiteAddress .setOnClickListener(this);
        ib_SiteIndoor .setOnClickListener(this);
        ib_SiteOutdoor .setOnClickListener(this);
        ib_ShelterConcrete .setOnClickListener(this);
        ib_shelterFabricated .setOnClickListener(this);
        ib_Numerofotheroperator .setOnClickListener(this);
        ib_IPSite .setOnClickListener(this);
        ib_Others .setOnClickListener(this);
        ib_Sharing .setOnClickListener(this);
        ib_Hostoperator .setOnClickListener(this);
        ib_Anyguestoperators .setOnClickListener(this);
        ib_NoofGSMAntenna .setOnClickListener(this);
        btn_save .setOnClickListener(this);
        btnrfdetail_next .setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        if(view == ib_SiteID){
            selectImage("1");
        }
        if(view == ib_SiteName){
            selectImage("2");
        }
        if(view == ib_SurveyDate){
            selectImage("3");
        }
        if(view == ib_City){
            selectImage("4");
        }
        if(view == ib_IMID){
            selectImage("5");
        }
        if(view == ib_Cluttertype){
            selectImage("6");
        }
        if(view == ib_SiteType){
            selectImage("7");
        }
        if(view == ib_Zone){
            selectImage("8");
        }
        if(view == ib_SiteCandidate){
            selectImage("9");
        }
        if(view == ib_BldgHeight){
            selectImage("10");
        }
        if(view == ib_BldgStructure){
            selectImage("11");
        }
        if(view == ib_AGL){
            selectImage("12");
        }
        if(view == ib_SiteContact){
            selectImage("13");
        }
        if(view == ib_AMSL){
            selectImage("14");
        }
        if(view == ib_SiteAddress){
            selectImage("15");
        }
        if(view == ib_SiteIndoor){
            selectImage("16");
        }
        if(view == ib_SiteOutdoor){
            selectImage("17");
        }
        if(view == ib_ShelterConcrete){
            selectImage("18");
        }
        if(view == ib_shelterFabricated){
            selectImage("19");
        }
        if(view == ib_Numerofotheroperator){
            selectImage("20");
        }
        if(view == ib_IPSite){
            selectImage("21");
        }
        if(view == ib_Others){
            selectImage("22");
        }
        if(view == ib_Sharing){
            selectImage("23");
        }
        if(view == ib_Hostoperator){
            selectImage("24");
        }
        if(view == ib_Anyguestoperators){
            selectImage("25");
        }
        if(view == ib_NoofGSMAntenna){
            selectImage("26");
        }

        if(view == btn_save){
            if (edt_Lat.getText().toString().equalsIgnoreCase("")) {
                edt_Lat.setError("Please Enter Valid Value");
                btnrfdetail_next.setVisibility(View.GONE);
                return;
            }
            if (edt_Long.getText().toString().equalsIgnoreCase("")) {
                edt_Long.setError("Please Enter Valid Value");
                btnrfdetail_next.setVisibility(View.GONE);
                return;
            } else {
                btnrfdetail_next.setVisibility(View.VISIBLE);
                db.insertRFSiteDetail(new RFSiteDetailData(edt_SiteID.getText().toString(), edt_SiteName.getText().toString(), edt_SurveyDate.getText().toString(), edt_City.getText().toString(), edt_IMID.getText().toString(), edt_Cluttertype.getText().toString(), edt_SiteType.getText().toString(), edt_Zone.getText().toString(), edt_SiteCandidate.getText().toString(), edt_BldgHeight.getText().toString(), edt_BldgStructure.getText().toString(), edt_AGL.getText().toString(), edt_SiteContact.getText().toString(), edt_AMSL.getText().toString(), edt_SiteAddress.getText().toString(), edt_SiteIndoor.getText().toString(), edt_SiteOutdoor.getText().toString(), edt_ShelterConcrete.getText().toString(), edt_shelterFabricated.getText().toString(), edt_Numerofotheroperator.getText().toString(), edt_IPSite.getText().toString(), edt_Others.getText().toString(), edt_Sharing.getText().toString(), edt_Hostoperator.getText().toString(), edt_Anyguestoperators.getText().toString(), edt_NoofGSMAntenna.getText().toString(), edt_Lat.getText().toString(), edt_Long.getText().toString(), img_SiteID, img_SiteName, img_SurveyDate, img_City, img_IMID, img_Cluttertype, img_SiteType, img_Zone, img_SiteCandidate, img_BldgHeight, img_BldgStructure, img_AGL, img_SiteContact, img_AMSL, img_SiteAddress, img_SiteIndoor, img_SiteOutdoor, img_ShelterConcrete, img_shelterFabricated, img_Numerofotheroperator, img_IPSite, img_Others, img_Sharing, img_Hostoperator, img_Anyguestoperators, img_NoofGSMAntenna,
                        edt_Commentsadd.getText().toString(),edt_SNo.getText().toString(),edt_NominalLat.getText().toString(),edt_NominalLong.getText().toString(),edt_TaLuk.getText().toString(),edt_AntennaType.getText().toString(),edt_CheckedBy.getText().toString(),edt_SuveyedBy.getText().toString(),edt_Surveytype.getText().toString(), time, 1));


                int aftercount = db.getCountRFSiteDetail();
                tv_aftercount.setText(aftercount + "");

            }
        }
        if(view == btnrfdetail_next) {

                getFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag, new RFTabFragment()).addToBackStack(null).commit();

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
        if (Value.equals("27")) {
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",27);
            startActivityForResult(i, 27);
        }
        if (Value.equals("28")) {
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",28);
            startActivityForResult(i, 28);
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
                img_SiteID = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
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
                img_SiteName = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                Log.v("img-encode", img_SiteName);
            }
        }
        if (name.equals("3")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_SurveyDate.setImageBitmap( out);
                //  imgBearing60 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_SurveyDate = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                Log.v("img-encode", img_SurveyDate);
            }
        }
        if (name.equals("4")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_City.setImageBitmap( out);
                //   imgBearing90 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_City = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                Log.v("img-encode", img_City);
            }
        }
        if (name.equals("5")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_IMID.setImageBitmap( out);
                //  imgBearing120 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_IMID = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                Log.v("img-encode", img_IMID);
            }
        }
        if (name.equals("6")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_Cluttertype.setImageBitmap( out);
                //    imgBearing150 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_Cluttertype = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                Log.v("img-encode", img_Cluttertype);
            }
        }
        if (name.equals("7")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_SiteType.setImageBitmap( out);
                //     imgBearing180 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_SiteType = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                Log.v("img-encode", img_SiteType);
            }
        }
        if (name.equals("8")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_Zone.setImageBitmap( out);
                //   imgBearing210 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_Zone = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                Log.v("img-encode", img_Zone);
            }
        }
        if (name.equals("9")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_SiteCandidate.setImageBitmap( out);
                // imgBearing240 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_SiteCandidate = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                Log.v("img-encode", img_SiteCandidate);
            }
        }
        if (name.equals("10")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_BldgHeight.setImageBitmap( out);
                //    imgBearing270 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_BldgHeight = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                Log.v("img-encode", img_BldgHeight);
            }
        }
        if (name.equals("11")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_BldgStructure.setImageBitmap( out);
                //    imgBearing300 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_BldgStructure = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                Log.v("img-encode", img_BldgStructure);
            }
        }
        if (name.equals("12")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_AGL.setImageBitmap( out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_AGL = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                Log.v("img-encode", img_AGL);
            }
        }
        if (name.equals("13")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_SiteContact.setImageBitmap( out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_SiteContact = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                Log.v("img-encode", img_SiteContact);
            }
        }
        if (name.equals("14")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_AMSL.setImageBitmap( out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_AMSL = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                Log.v("img-encode", img_AMSL);
            }
        }
        if (name.equals("15")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_SiteAddress.setImageBitmap( out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_SiteAddress = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                Log.v("img-encode", img_SiteAddress);
            }
        }
        if (name.equals("16")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_SiteIndoor.setImageBitmap( out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_SiteIndoor = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                Log.v("img-encode", img_SiteIndoor);
            }
        }
        if (name.equals("17")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_SiteOutdoor.setImageBitmap( out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_SiteOutdoor = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                Log.v("img-encode", img_SiteOutdoor);
            }
        }
        if (name.equals("18")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_ShelterConcrete.setImageBitmap( out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_ShelterConcrete = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                Log.v("img-encode", img_ShelterConcrete);
            }
        }
        if (name.equals("19")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_shelterFabricated.setImageBitmap( out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_shelterFabricated = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                Log.v("img-encode", img_shelterFabricated);
            }
        }
        if (name.equals("20")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_Numerofotheroperator.setImageBitmap( out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_Numerofotheroperator = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                Log.v("img-encode", img_Numerofotheroperator);
            }
        }
        if (name.equals("21")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_IPSite.setImageBitmap( out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_IPSite = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                Log.v("img-encode", img_IPSite);
            }
        }
        if (name.equals("22")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_Others.setImageBitmap( out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_Others = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                Log.v("img-encode", img_Others);
            }
        }
        if (name.equals("23")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_Sharing.setImageBitmap( out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_Sharing = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                Log.v("img-encode", img_Sharing);
            }
        }
        if (name.equals("24")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_Hostoperator.setImageBitmap( out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_Hostoperator = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                Log.v("img-encode", img_Hostoperator);
            }
        }
        if (name.equals("25")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_Anyguestoperators.setImageBitmap( out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_Anyguestoperators = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                Log.v("img-encode", img_Anyguestoperators);
            }
        }
        if (name.equals("26")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_NoofGSMAntenna.setImageBitmap( out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_NoofGSMAntenna = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                Log.v("img-encode", img_IPSite);
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
