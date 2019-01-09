package com.linkquest.lhq.fragment;


import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.linkquest.lhq.CustomClass;
import com.linkquest.lhq.GPSTracker;
import com.linkquest.lhq.GoogleGPSService;
import com.linkquest.lhq.constants.AppConstants;
import com.linkquest.lhq.R;
import com.linkquest.lhq.Utils.AppSingleton;
import com.linkquest.lhq.database.DatabaseHandler;
import com.linkquest.lhq.database.SurveyForm;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SiteSurveylqt extends Fragment   {
    private final String TAG = SiteSurveylqt.class.getSimpleName() ;

    private String SELECT = "-SELECT-";
    private Spinner spinner_siteaudit, spinner_customer, spi_operator, spi_circle, spi_tech, spi_techtype, spi_location;
    private EditText edt_other, edtsiteid, edt_clusterid;
    private LinearLayout li_other;
    private Button button;
    String selectitem;
    List<String> listsiteaudit = new ArrayList<String>();
    List<String> listcustomer = new ArrayList<String>();
    List<String> listoperater = new ArrayList<String>();
    List<String> listcircle = new ArrayList<String>();
    List<String> listtechnology = new ArrayList<String>();
    List<String> listtechnogytype = new ArrayList<String>();
    List<String> listlocation = new ArrayList<String>();
    private ArrayAdapter adapter_listsiteaudit;
    Handler handler;
    private String time;
    private String getcustomLocation;
    private DatabaseHandler databaseHandler;
    private String lat;
    private String log;
    private TextView lat_log;

    public SiteSurveylqt() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // String h = DateFormat.format("MMddyyyyhmmssaa", System.currentTimeMillis()).toString();
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_site_surveylqt, container, false);
        final TextView tvdate = (TextView) v.findViewById(R.id.surveyformdate);
        databaseHandler = new DatabaseHandler(getActivity());
        if (!GoogleGPSService.isRunning) {
            getActivity().startService(new Intent(getActivity(), GoogleGPSService.class));
        }

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                time = DateFormat.format("dd-MM-yyyy h:mm:ss:aa", System.currentTimeMillis()).toString();
                tvdate.setText(time);
                handler.postDelayed(this, 1000);
            }

        }, 1000);

        addListenerOnButton(v);
        addListenerOnSpinnerItemSelection(v);

        spinner_siteaudit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

              //  selectitem = parent.getItemAtPosition(position).toString();
                //adapter_listsiteaudit.notifyDataSetChanged();
               // todatasppinercustomer(selectitem);

                listcustomer.clear();
                listcustomer.add(SELECT);
                listcustomer.add("ERICSSON");
                listcustomer.add("NSN");
                listcustomer.add("SAMSUNG");
                listcustomer.add("HUAWEI");
                listcustomer.add("ZTE");

                final ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listcustomer);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner_customer.setAdapter(dataAdapter);
                dataAdapter.notifyDataSetChanged();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner_customer.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectitem = parent.getItemAtPosition(position).toString();
              //  todatasppineroperator(selectitem);
                listoperater.clear();
                listoperater.add("AIRTEL");
                listoperater.add("VODAFONE");
                listoperater.add("IDEA");
                listoperater.add("VFI");
                listoperater.add("JIO");

                final ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listoperater);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spi_operator.setAdapter(dataAdapter);
                dataAdapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spi_operator.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectitem = parent.getItemAtPosition(position).toString();
                //  todatasppinerCircle(selectitem);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spi_circle.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectitem = parent.getItemAtPosition(position).toString();
               // todatasppinerTechnology(selectitem);
                todatasppinerLocation(selectitem);

                listtechnology.clear();
                listtechnology.add("2G");
                listtechnology.add("2G SRAN");
                listtechnology.add("3G");
                listtechnology.add("4G FDD");
                listtechnology.add("4G TDD");
                listtechnology.add("VoLTE");
                listtechnology.add("VoLTE FDD");
                listtechnology.add("VoLTE TDD");
                listtechnology.add("4G & VoLTE");
                listtechnology.add("Air Scale");

                final ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listtechnology);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spi_tech.setAdapter(dataAdapter);
                dataAdapter.notifyDataSetChanged();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spi_tech.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectitem = parent.getItemAtPosition(position).toString();
             //   todatasppinerTechnologyType(selectitem);
                listtechnogytype.clear();
                listtechnogytype.add("SCFT");
                listtechnogytype.add("CLUSTER");

                final ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listtechnogytype);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spi_techtype.setAdapter(dataAdapter);
                dataAdapter.notifyDataSetChanged();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spi_location.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectitem = parent.getItemAtPosition(position).toString();

                if (selectitem.equalsIgnoreCase("Other")) {
                    li_other.setVisibility(View.VISIBLE);
                } else {
                    li_other.setVisibility(View.GONE);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return v;

    }

    public void addListenerOnSpinnerItemSelection(View v) {
        //  todatasppinersiteadudit();
        listsiteaudit.add(SELECT);
        listsiteaudit.add("Site Audit");
        listsiteaudit.add("RF Survey");
        listsiteaudit.add("LOS Survey");
        listsiteaudit.add("RFI Survey");
        listsiteaudit.add("EMF Survey");
        adapter_listsiteaudit = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listsiteaudit) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        adapter_listsiteaudit.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_siteaudit.setAdapter(adapter_listsiteaudit);
        // spinner_siteaudit.setOnItemSelectedListener(new MyOnItemSelectedListener());

        listcircle.clear();
        listcircle.add("Andaman and Nicobar");
        listcircle.add("Andaman and Nicobar Islands");
        listcircle.add("Andhra Pradesh");
        listcircle.add("Arunachal Pradesh");
        listcircle.add("Assam");
        listcircle.add("Bihar");
        listcircle.add("Chandigarh");
        listcircle.add("Chhattisgarh");
        listcircle.add("Dadra and Nagar Haveli");
        listcircle.add("Daman and Diu");
        listcircle.add("Delhi");
        listcircle.add("Goa");
        listcircle.add("Gujarat");
        listcircle.add("Haryana");
        listcircle.add("Himachal Pradesh");
        listcircle.add("Jammu and Kashmir");
        listcircle.add("Jharkhand");
        listcircle.add("Karnataka");
        listcircle.add("Kashmir");
        listcircle.add("Kerala");
        listcircle.add("Laccadives");
        listcircle.add("Madhya Pradesh");
        listcircle.add("Maharashtra");
        listcircle.add("Manipur");
        listcircle.add("Meghalaya");
        listcircle.add("Mizoram");
        listcircle.add("Nagaland");
        listcircle.add("National Capital Territory of Delhi");
        listcircle.add("Odisha");
        listcircle.add("Orissa");
        listcircle.add("Puducherry");
        listcircle.add("Punjab");
        listcircle.add("Rajasthan");
        listcircle.add("Sikkim");
        listcircle.add("State of Andhra Pradesh");
        listcircle.add("State of Assam");
        listcircle.add("State of Chhattisgarh");
        listcircle.add("State of Gujarat");
        listcircle.add("State of Himachal Pradesh");
        listcircle.add("State of Jharkhand");
        listcircle.add("State of Punjab");
        listcircle.add("State of Rajasthan");
        listcircle.add("State of Tripura");
        listcircle.add("Tamil Nadu");
        listcircle.add("Telangana");
        listcircle.add("Tripura");
        listcircle.add("Union Territory of Puducherry");
        listcircle.add("Uttar Pradesh");
        listcircle.add("Uttarakhand");
        listcircle.add("MPCG");
        listcircle.add("Kolkata");
        listcircle.add("ROB");
        listcircle.add("ROM");
        listcircle.add("Mumbai");
        listcircle.add("UPE");
        listcircle.add("UPW");
        listcircle.add("NESA");


        final ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listcircle);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spi_circle.setAdapter(dataAdapter);
        dataAdapter.notifyDataSetChanged();

    }

    public void addListenerOnButton(View v) {

        spinner_siteaudit = (Spinner) v.findViewById(R.id.spinner_siteaudit);
        spinner_customer = (Spinner) v.findViewById(R.id.spinner_customer);
        spi_operator = (Spinner) v.findViewById(R.id.spi_operator);
        spi_circle = (Spinner) v.findViewById(R.id.spi_circle);
        spi_tech = (Spinner) v.findViewById(R.id.spi_technology);
        spi_techtype = (Spinner) v.findViewById(R.id.spi_technology_type);
        spi_location = (Spinner) v.findViewById(R.id.spi_location);
        edt_other = (EditText) v.findViewById(R.id.edt_other);
        edtsiteid = (EditText) v.findViewById(R.id.edt_siteid);
        edt_clusterid = (EditText) v.findViewById(R.id.edt_clusterid);
        button = (Button) v.findViewById(R.id.button);
        li_other = (LinearLayout) v.findViewById(R.id.li_otherlocation);
        lat_log = (TextView) v.findViewById(R.id.lat_log);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (spinner_siteaudit.getSelectedItem().toString().trim().equalsIgnoreCase(SELECT)) {
                    View selectedView = spinner_siteaudit.getSelectedView();
                    TextView selectedTextView = (TextView) selectedView;
                    selectedTextView.setError("Please Select");
                    return;
                } else if (spinner_customer.getSelectedItem().toString().trim().equalsIgnoreCase(SELECT)) {
                    View selectedView = spinner_customer.getSelectedView();
                    TextView selectedTextView = (TextView) selectedView;
                    selectedTextView.setError("Please Select");
                    return;
                } else if (spi_operator.getSelectedItem().toString().trim().equalsIgnoreCase(SELECT)) {
                    View selectedView = spi_operator.getSelectedView();
                    TextView selectedTextView = (TextView) selectedView;
                    selectedTextView.setError("Please Select");
                    return;
                } else if (spi_circle.getSelectedItem().toString().trim().equalsIgnoreCase(SELECT)) {
                    View selectedView = spi_circle.getSelectedView();
                    TextView selectedTextView = (TextView) selectedView;
                    selectedTextView.setError("Please Select");
                    return;
                } else if (spi_tech.getSelectedItem().toString().trim().equalsIgnoreCase(SELECT)) {
                    View selectedView = spi_tech.getSelectedView();
                    TextView selectedTextView = (TextView) selectedView;
                    selectedTextView.setError("Please Select");
                    return;
                } else if (spi_techtype.getSelectedItem().toString().trim().equalsIgnoreCase(SELECT)) {
                    View selectedView = spi_techtype.getSelectedView();
                    TextView selectedTextView = (TextView) selectedView;
                    selectedTextView.setError("Please Select");
                    return;
                } else if (!spi_location.getSelectedItem().toString().trim().equalsIgnoreCase("")) {
                    getcustomLocation = spi_location.getSelectedItem().toString();

                } else if (spi_location.getSelectedItem().toString().trim().equalsIgnoreCase("other")) {
                    if (edt_other.getText().toString().equals("")) {
                        edt_other.setError("Please Enter other location");
                    } else {

                        String s = edtsiteid.getText().toString().trim();
                        getcustomLocation = edt_other.getText().toString();
                    }

                }
                if (edtsiteid.getText().toString().trim().equalsIgnoreCase("")) {
                    edtsiteid.setError("Please Enter SiteId");
                    return;
                } else {
                    Toast.makeText(getActivity(), "Result : " +
                                    "\nSpinner 1 : " + String.valueOf(spinner_siteaudit.getSelectedItem()) +
                                    "\nSpinner 2 : " + String.valueOf(spinner_customer.getSelectedItem()),
                            Toast.LENGTH_SHORT).show();
                    databaseHandler.insertSurveyFormData(new SurveyForm(spinner_siteaudit.getSelectedItem().toString(), spinner_customer.getSelectedItem().toString(), spi_operator.getSelectedItem().toString(), spi_circle.getSelectedItem().toString(), spi_tech.getSelectedItem().toString(), spi_techtype.getSelectedItem().toString(), getcustomLocation, edtsiteid.getText().toString(), time, lat, log, 1,edt_clusterid.getText().toString()));

                    SiteSurveylqtReport ldf = new SiteSurveylqtReport();
                    Bundle args = new Bundle();
                    args.putString("YourKey", "YourValue");
                    ldf.setArguments(args);
     //Inflate the fragment
                    getFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag, ldf).addToBackStack(null).commit();
                }
            }

        });

    }

    class MyOnItemSelectedListener implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

            Toast.makeText(parent.getContext(), "Selected Country : " + parent.getItemAtPosition(pos).toString(), Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }

    }

    //.....................start...........Sppiner Site Aduit.........................//
    private void todatasppinersiteadudit() {
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.show();
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.SURVETTYPE, JSonobjParametersiteaudit(),
                new Response.Listener<JSONArray>() {


                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponse(response);
                        Log.v(TAG, response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v(TAG, error.toString());
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
        queue.add(queue.add(jsonObjReq));
        //AppSingleton.getInstance(getActivity()).addToRequestQueue(jsonObjReq, null);
    }

    private JSONObject JSonobjParametersiteaudit() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("surveytyp", "surveytyp");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }

    private void parseSettingResponse(JSONArray response) {
        listsiteaudit.clear();
        listsiteaudit.add("SELECT");
        try {
            JSONArray jsonArray = new JSONArray(response.toString());

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String surveyType = jsonObject.getString("SurveyType");
                Log.v(TAG, surveyType);
                listsiteaudit.add(surveyType);
            }
            adapter_listsiteaudit.notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     //......................end...........Sppiner Site Aduit.........................//

    //.....................start...........Sppiner Customer.........................//
    private void todatasppinercustomer(String type) {
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.show();
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.CUSTOMER, JSonobjParametercustomer(type),
                new Response.Listener<JSONArray>() {


                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponsecustomer(response);
                        Log.v(TAG, response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v(TAG, error.toString());
                pDialog.hide();
            }

        });
        queue.add(jsonObjReq);
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

        // AppSingleton.getInstance(getActivity()).addToRequestQueue(jsonObjReq, null);
    }

    private JSONObject JSonobjParametercustomer(String type) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("surveytyp", type);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    private void parseSettingResponsecustomer(JSONArray response) {
        listcustomer.clear();
        //  listcustomer.add("SELECT");
        try {
            JSONArray jsonArray = new JSONArray(response.toString());

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String surveyType = jsonObject.getString("CustomerName");
                Log.v(TAG, surveyType);
                listcustomer.add(surveyType);
            }
            final ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listcustomer);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_customer.setAdapter(dataAdapter);
            dataAdapter.notifyDataSetChanged();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //.....................end...........Sppiner Customer.........................//

    //.....................start...........Sppiner operator.........................//
    private void todatasppineroperator(String type) {
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.show();
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.OPERATOR, JSonobjParameteroperator(type),
                new Response.Listener<JSONArray>() {


                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponseoperator(response);
                        Log.v(TAG, response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v(TAG, error.toString());
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
        queue.add(jsonObjReq);
        //  AppSingleton.getInstance(getActivity()).addToRequestQueue(jsonObjReq, null);
    }

    private JSONObject JSonobjParameteroperator(String type) {
        JSONObject jsonObject = new JSONObject();
        try {

            jsonObject.put("customers", type);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }

    private void parseSettingResponseoperator(JSONArray response) {
        listoperater.clear();
        //  listcustomer.add("SELECT");
        try {
            JSONArray jsonArray = new JSONArray(response.toString());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String surveyType = jsonObject.getString("OperatorName");
                Log.v(TAG, surveyType);
                listoperater.add(surveyType);
            }
            final ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listoperater);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spi_operator.setAdapter(dataAdapter);
            dataAdapter.notifyDataSetChanged();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//.....................end...........Sppiner Operator.........................//

    //.....................start...........Sppiner Circle.........................//
    private void todatasppinerCircle(String type) {
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.show();
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.CIRCLE, JSonobjParameterCircle(type),
                new Response.Listener<JSONArray>() {


                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponseCircle(response);
                        Log.v(TAG + "circle", response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v(TAG, error.toString());
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
        queue.add(jsonObjReq);
        // AppSingleton.getInstance(getActivity()).addToRequestQueue(jsonObjReq, null);
    }

    private JSONObject JSonobjParameterCircle(String type) {
        JSONObject jsonObject = new JSONObject();
        try {

            jsonObject.put("Operators", type);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    private void parseSettingResponseCircle(JSONArray response) {
        listcircle.clear();
        //  listcustomer.add("SELECT");
        try {
            JSONArray jsonArray = new JSONArray(response.toString());

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String surveyType = jsonObject.getString("CircleName");
                Log.v(TAG, surveyType);
                listcircle.add(surveyType);
            }
            final ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listcircle);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spi_circle.setAdapter(dataAdapter);
            dataAdapter.notifyDataSetChanged();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//.....................end...........Sppiner Circle.........................//

    //.....................start...........Sppiner Technology.........................//
    private void todatasppinerTechnology(String type) {
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.show();
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.TECHNOLOGY, JSonobjParametertechnology(type),
                new Response.Listener<JSONArray>() {


                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponsetechnology(response);
                        Log.v(TAG, response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v(TAG, error.toString());
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
        queue.add(jsonObjReq);
        // AppSingleton.getInstance(getActivity()).addToRequestQueue(jsonObjReq, null);
    }

    private JSONObject JSonobjParametertechnology(String type) {
        JSONObject jsonObject = new JSONObject();
        try {

            jsonObject.put("Circles", type);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }

    private void parseSettingResponsetechnology(JSONArray response) {
        listtechnology.clear();
        //  listcustomer.add("SELECT");
        try {
            JSONArray jsonArray = new JSONArray(response.toString());

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String surveyType = jsonObject.getString("Technology");
                Log.v(TAG, surveyType);
                listtechnology.add(surveyType);

            }
            final ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listtechnology);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spi_tech.setAdapter(dataAdapter);
            dataAdapter.notifyDataSetChanged();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//.....................end...........Sppiner Technology.........................//

    //.....................start...........Sppiner TechnologyType.........................//
    private void todatasppinerTechnologyType(String type) {
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.show();
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.TECHNOLOGYTYPE, JSonobjParametertechnologyType(type),
                new Response.Listener<JSONArray>() {


                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponsetechnologyType(response);
                        Log.v(TAG, response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v(TAG, error.toString());
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
        queue.add(jsonObjReq);
        //  AppSingleton.getInstance(getActivity()).addToRequestQueue(jsonObjReq, null);
    }

    private JSONObject JSonobjParametertechnologyType(String type) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("TechTYPEs", type);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    private void parseSettingResponsetechnologyType(JSONArray response) {
        listtechnogytype.clear();
        //  listcustomer.add("SELECT");
        try {
            JSONArray jsonArray = new JSONArray(response.toString());

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String surveyType = jsonObject.getString("TechType");
                Log.v(TAG, surveyType);
                listtechnogytype.add(surveyType);

            }
            final ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listtechnogytype);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spi_techtype.setAdapter(dataAdapter);
            dataAdapter.notifyDataSetChanged();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//.....................end...........Sppiner TechnologyType.........................//

    //.....................start...........Sppiner Location.........................//
    private void todatasppinerLocation(String type) {
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.show();
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.LOCATION, JSonobjParameterLocation(type),
                new Response.Listener<JSONArray>() {


                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponseLocation(response);
                        Log.v("techtype", response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v(TAG, error.toString());
                listlocation.clear();
                listlocation.add(SELECT);
                listlocation.add("Other");
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
        queue.add(jsonObjReq);
        // AppSingleton.getInstance(getActivity()).addToRequestQueue(jsonObjReq, null);
    }

    private JSONObject JSonobjParameterLocation(String type) {
        JSONObject jsonObject = new JSONObject();
        try {

            jsonObject.put("Circles", type);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }

    private void parseSettingResponseLocation(JSONArray response) {
        listlocation.clear();
        //  listcustomer.add("SELECT");
        try {
            JSONArray jsonArray = new JSONArray(response.toString());

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String surveyType = jsonObject.getString("cityName");
                Log.v(TAG, surveyType);
                listlocation.add(surveyType);

            }
            final ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listlocation);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spi_location.setAdapter(dataAdapter);
            dataAdapter.notifyDataSetChanged();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//.....................end...........Sppiner Location.........................//

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
            lat_log.setText(lat + "," + log);
            //  Toast.makeText(getActivity(), "Lat : "+lat+","+ "Long : "+ log, Toast.LENGTH_LONG).show();


        }


    };


}