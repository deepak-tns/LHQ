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

import com.linkquest.lhq.R;
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

    public SiteSurveylqtReport() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_site_surveylq_report, container, false);
        databaseHandler = new DatabaseHandler(getActivity());

        findsIds(v);

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

        surveytype.setText(listdata.get(0).getSurveytype());
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

                                getFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag, new SiteDetailFragment()).commit();
                                dialog.cancel();
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
