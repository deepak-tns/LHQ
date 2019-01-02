package com.linkquest.lhq.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.linkquest.lhq.R;
import com.linkquest.lhq.database.DatabaseHandler;
import com.linkquest.lhq.database.SiteDetailForm;
import com.linkquest.lhq.database.SurveyForm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class SiteAuditAllDataHistory extends AppCompatActivity {
 DatabaseHandler db;

 ArrayList<String> listsitedetail = new ArrayList<>();
 ArrayList<String> listsitedetail2 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site_audit_all_data_history);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        db= new DatabaseHandler(this);

     /*  ArrayList<HashMap<String, String>> Table1 = db.printTable1Data("sitedetail");
        for(HashMap<String,String> hashMap: Table1){
            listsitedetail.add(hashMap.get("column_value"));
            listsitedetail2.add(hashMap.get("column_name"));

        }*/
        List<SurveyForm> surveyformData = db.getLastSurveyformData();
        if(surveyformData.size()>0){
            Log.v("history_sitesurvey",surveyformData.toString());
        }
        ListView lv =(ListView)findViewById(R.id.listview_activitysiteauditdatahistory);
        MyAdapter adapter = new MyAdapter(this,R.layout.adapter_site_audit_all_data_history,surveyformData);
        lv.setAdapter(adapter);


    }

    public class MyAdapter extends ArrayAdapter {
        Context context;
        List<SurveyForm> getListArray;
        public MyAdapter(Context context, int textViewResourceId, List objects) {
            super(context, textViewResourceId, objects);
            this.context = context;
            this.getListArray = objects;

        }
        @Override
        public int getCount() {
            return super.getCount();
        }

        @Override
        public View getView(int position, View v, ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (v == null) {
                v = layoutInflater.inflate(R.layout.adapter_site_audit_all_data_history, parent, false);
            }
           TextView surveytype =(TextView)v.findViewById(R.id.tvsqreportsurveytype2);
            TextView customer =(TextView)v.findViewById(R.id.tvsqreportcustomer2);
            TextView operator =(TextView)v.findViewById(R.id.tvsqreportoperator2);
            TextView  circle =(TextView)v.findViewById(R.id.tvsqreportcircle2);
            TextView  technology =(TextView)v.findViewById(R.id.tvsqreporttech2);
            TextView technologytype =(TextView)v.findViewById(R.id.tvsqreporttechtype2);
            TextView  location =(TextView)v.findViewById(R.id.tvsqreportlocation2);
            TextView siteid =(TextView)v.findViewById(R.id.tvsqreportsiteid2);
            TextView  date =(TextView)v.findViewById(R.id.tvsqreportdate2);
            TextView lat =(TextView)v.findViewById(R.id.tvsqreportlat2);
            TextView log =(TextView)v.findViewById(R.id.tvsqreportlog2);


           SurveyForm listdata = getListArray.get(position);

            surveytype.setText(listdata.getSurveytype());
            customer.setText(listdata.getCustomer());
            operator.setText(listdata.getOperator());
            circle.setText(listdata.getCircle());
            technology.setText(listdata.getTechnology());
            technologytype.setText(listdata.getTechnologytype());
            location.setText(listdata.getLocation());
            siteid.setText(listdata.getSiteid());
            date.setText(listdata.getDate());
            lat.setText(listdata.getLat());
            log.setText(listdata.getLog());

          //  Object obj2 = getListArray2.get(position);
           /* tvname.setText(((SiteDetailForm) obj).getSectorid());
            tvimg.setText(((SiteDetailForm) obj).getSectorid_photo());

            tvname.setText(((SiteDetailForm) obj).getSitename());
            tvimg.setText(((SiteDetailForm) obj).getSitename_photo());
            tvname.setText(((SiteDetailForm) obj).getTowersiteid());
            tvimg.setText(((SiteDetailForm) obj).getTowersiteid_photo());
            tvname.setText(((SiteDetailForm) obj).getTowercompanyname());
            tvimg.setText(((SiteDetailForm) obj).getTowercompanyname__photo());
            tvname.setText(((SiteDetailForm) obj).getSiteaddress());
            tvimg.setText(((SiteDetailForm) obj).getSiteaddress_photo());
            tvname.setText(((SiteDetailForm) obj).getSectorid());
            tvimg.setText(((SiteDetailForm) obj).getSectorid_photo());
            tvname.setText(((SiteDetailForm) obj).getLat());
            tvimg.setText(((SiteDetailForm) obj).getLog());
            tvname.setText(((SiteDetailForm) obj).getSitetype());
            tvimg.setText(((SiteDetailForm) obj).getSitetype_photo());
            tvname.setText(((SiteDetailForm) obj).getBuildingfloor());
            tvimg.setText(((SiteDetailForm) obj).getBuildingfloor_photo());
            tvname.setText(((SiteDetailForm) obj).getBuildingheight());
            tvimg.setText(((SiteDetailForm) obj).getBuildingheight_photo());
            tvname.setText(((SiteDetailForm) obj).getTowerheight());
            tvimg.setText(((SiteDetailForm) obj).getTowerheight_photo());
            tvname.setText(((SiteDetailForm) obj).getFulltowerphoto());
            tvimg.setText(((SiteDetailForm) obj).getFulltowerphoto_photo());
            tvname.setText(((SiteDetailForm) obj).getNodebtype());
            tvimg.setText(((SiteDetailForm) obj).getNodebtype_photo());
            tvname.setText(((SiteDetailForm) obj).getClassical());
            tvimg.setText(((SiteDetailForm) obj).getClassical_photo());
            tvname.setText(((SiteDetailForm) obj).getEnodebtype());
            tvimg.setText(((SiteDetailForm) obj).getEnodebtype_photo());
            tvname.setText(((SiteDetailForm) obj).getAnchoroperator());
            tvimg.setText(((SiteDetailForm) obj).getAnchoroperator_photo());
            tvname.setText(((SiteDetailForm) obj).getSharingopco1());
            tvimg.setText(((SiteDetailForm) obj).getSharingopco1_photo());
            tvname.setText(((SiteDetailForm) obj).getSharingopco2());
            tvimg.setText(((SiteDetailForm) obj).getSharingopco2_photo());
            tvname.setText(((SiteDetailForm) obj).getSharingopco3());
            tvimg.setText(((SiteDetailForm) obj).getSharingopco3_photo());
            tvname.setText(((SiteDetailForm) obj).getInfraprovider());
            tvimg.setText(((SiteDetailForm) obj).getInfraprovider_photo());
            tvname.setText(((SiteDetailForm) obj).getType_id_od());
            tvimg.setText(((SiteDetailForm) obj).getType_id_od_photo());
            tvname.setText(((SiteDetailForm) obj).getInfrashared());
            tvimg.setText(((SiteDetailForm) obj).getInfrashared_photo());
            tvname.setText(((SiteDetailForm) obj).getExtra1());
            tvimg.setText(((SiteDetailForm) obj).getExtra1_photo());
            tvname.setText(((SiteDetailForm) obj).getExtra2());
            tvimg.setText(((SiteDetailForm) obj).getExtra2_photo());
            tvname.setText(((SiteDetailForm) obj).getRemark1());
            tvimg.setText(((SiteDetailForm) obj).getRemark1_photo());
            tvname.setText(((SiteDetailForm) obj).getRemark2());
            tvimg.setText(((SiteDetailForm) obj).getRemark2_photo());
            tvname.setText(((SiteDetailForm) obj).getFlag()+"");
            tvname.setText(((SiteDetailForm) obj).getDate());*/
            return v;
        }
    }


}
