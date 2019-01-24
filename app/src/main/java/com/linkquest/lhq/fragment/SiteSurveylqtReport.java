package com.linkquest.lhq.fragment;


import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.linkquest.lhq.CustomClass;
import com.linkquest.lhq.LOSAudit.LOSDetailFragment;
import com.linkquest.lhq.R;
import com.linkquest.lhq.RFSurvey.RFSiteDetailFragment;
import com.linkquest.lhq.SiteAudit.SiteDetailFragment;
import com.linkquest.lhq.Utils.SharedPreferenceUtils;
import com.linkquest.lhq.constants.AppConstants;
import com.linkquest.lhq.database.DatabaseHandler;
import com.linkquest.lhq.database.SurveyForm;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SiteSurveylqtReport extends Fragment {

    private DatabaseHandler databaseHandler;
    private TextView surveytype;
    private TextView customer;
    private TextView operator;
    private TextView circle;
    private TextView technology;
    private TextView technologytype;
    private TextView location;
    private TextView siteid;
    private TextView date;
    private TextView lat;
    private TextView log;

    private String stSurveyType="";

    private SharedPreferenceUtils sharedPreferences;
    public SiteSurveylqtReport() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_site_surveylq_report, container, false);
        databaseHandler = new DatabaseHandler(getActivity());
       List<SurveyForm>  siteIDandDate = databaseHandler.getLastSurveyformData();
       if(siteIDandDate.size() > 0){
          String surveytype_customer_operator = siteIDandDate.get(0).getSurveytype()+siteIDandDate.get(0).getCustomer()+siteIDandDate.get(0).getOperator()
                  +siteIDandDate.get(0).getTechnology()+siteIDandDate.get(0).getTechnologytype()+siteIDandDate.get(0).getSiteid()+siteIDandDate.get(0).getCusterid()+siteIDandDate.get(0).getDate();
           sharedPreferences = SharedPreferenceUtils.getInstance();
           sharedPreferences.setContext(getActivity());
           sharedPreferences.putString(AppConstants.SITEID,siteIDandDate.get(0).getSiteid() );
           sharedPreferences.putString(AppConstants.DATE,siteIDandDate.get(0).getDate() );
           sharedPreferences.putString(AppConstants.surveytpeandcustomerandoperator,surveytype_customer_operator );
           sharedPreferences.putString(AppConstants.operators,siteIDandDate.get(0).getOperator() );

       }


        findsIds(v);
      //  CustomClass.geCustomclass().setNotifyData("Deepak");
        return v;
    }

    private void findsIds(View v){
        surveytype =(TextView)v.findViewById(R.id.tvsqreportsurveytype);
        customer =(TextView)v.findViewById(R.id.tvsqreportcustomer);
        operator =(TextView)v.findViewById(R.id.tvsqreportoperator);
        circle =(TextView)v.findViewById(R.id.tvsqreportcircle);
        technology =(TextView)v.findViewById(R.id.tvsqreporttech);
        technologytype =(TextView)v.findViewById(R.id.tvsqreporttechtype);
        location =(TextView)v.findViewById(R.id.tvsqreportlocation);
        siteid =(TextView)v.findViewById(R.id.tvsqreportsiteid);
        date =(TextView)v.findViewById(R.id.tvsqreportdate);
        lat =(TextView)v.findViewById(R.id.tvsqreportlat);
        log =(TextView)v.findViewById(R.id.tvsqreportlog);
        Button btn_save =(Button) v.findViewById(R.id.btn_sitesurveyreport);

        List<SurveyForm> listdata = databaseHandler.getLastSurveyformData();
        stSurveyType= listdata.get(0).getSurveytype();
        surveytype.setText(stSurveyType);
        customer.setText(listdata.get(0).getCustomer());
        operator.setText(listdata.get(0).getOperator());
        circle.setText(listdata.get(0).getCircle());
        technology.setText(listdata.get(0).getTechnology());
        technologytype.setText(listdata.get(0).getTechnologytype());
        location.setText(listdata.get(0).getLocation());
        siteid.setText(listdata.get(0).getSiteid());
        date.setText(listdata.get(0).getDate());
        lat.setText(listdata.get(0).getLat());
        log.setText(listdata.get(0).getLog());


        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertdiaolog();
            }
        });
    }

    public  void alertdiaolog(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                getActivity());

        // set title
        alertDialogBuilder.setTitle("Confirmation ?");

        // set dialog message
        alertDialogBuilder
                .setMessage("Fill all detail correctly !")
                .setCancelable(false)
                .setPositiveButton("save",
                        new DialogInterface.OnClickListener() {
                            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                            public void onClick(DialogInterface dialog,
                                                int id) {
                                // if this button is clicked, close
                                // current activity
                                // startActivity(new Intent(CardLogin.this, MainActivity.class));

                                if (stSurveyType.equalsIgnoreCase("Site Audit")) {
                                    CustomClass.getCustomclass().setNotifyData("Site Audit");
                                    getFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag, new SiteDetailFragment()).commit();
                                    dialog.cancel();
                                }
                                if (stSurveyType.equalsIgnoreCase("LOS Survey")) {
                                    CustomClass.getCustomclass().setNotifyData("LOS Survey");
                                    getFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag, new LOSDetailFragment()).commit();
                                    dialog.cancel();
                                }
                                if (stSurveyType.equalsIgnoreCase("RF Survey")) {
                                    getFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag, new RFSiteDetailFragment()).commit();
                                    dialog.cancel();
                                }
                            }
                        })
                .setNegativeButton("back",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing

                                getFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag, new SiteSurveylqt()).commit();
                                dialog.cancel();
                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        // show it
        alertDialog.show();
    }


}
