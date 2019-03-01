package com.linkquest.lhq.RFSurvey;

import android.app.ProgressDialog;
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
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.linkquest.lhq.BitmapEncodedDecoded;
import com.linkquest.lhq.GoogleGPSService;
import com.linkquest.lhq.R;
import com.linkquest.lhq.Utils.AppSingleton;
import com.linkquest.lhq.Utils.SharedPreferenceUtils;
import com.linkquest.lhq.activity.CameraSurfaceViewActivity;
import com.linkquest.lhq.constants.AppConstants;
import com.linkquest.lhq.database.DatabaseHandler;
import org.json.JSONArray;
import org.json.JSONObject;


import java.io.ByteArrayOutputStream;
import java.util.List;

import static android.app.Activity.RESULT_CANCELED;

/**
 * A simple {@link Fragment} subclass.
 */
public class RFSectorDetailFragment extends Fragment implements View.OnClickListener {

    private EditText edt_Antenna_Type;
    private EditText edt_2GBand;
    private EditText edt_2GCoverge;
    private EditText edt_2GObstruction;
    private EditText edt_2G_Existing_Antenna_Height;
    private EditText edt_2G_Antenna_Make_and_Model;
    private EditText edt_2G_Existing_Antenna_Direction;
    private EditText edt_2G_Existing_antenna_tilt_Electrical;
    private EditText edt_2G_Existing_antenna_tilt_Mechanical;
    private EditText edt_3GBand;
    private EditText edt_3GCoverge;
    private EditText edt_3GObstruction;
    private EditText edt_3G_Existing_Antenna_Ht;
    private EditText edt_3G_Antenna_Make_and_Model;
    private EditText edt_3G_Existing_Antenna_Direction;
    private EditText edt_3G_Existing_antenna_Electrical_tilt;
    private EditText edt_3G_Existing_antenna_Mechanical_tilt;
    private EditText edt_Space_Available_for_3G_Antenna;
    private EditText edt_Addl_Poles_req_for_3G_Antenna;
    private EditText edt_3GAntenna_Swap_Required;
    private EditText edt_3GApproximate_Cable_Lenth;
    private EditText edt_3GAntenna_Port_EmptyDamaged;
    private EditText edt_4GBand;
    private EditText edt_4GCoverge;
    private EditText edt_4GObstruction;
    private EditText edt_4G_Existing_Antenna_Ht;
    private EditText edt_4G_Antenna_Make_and_Model;
    private EditText edt_4G_Existing_Antenna_Direction;
    private EditText edt_4G_Existing_antenna_Electrical_tilt;
    private EditText edt_4G_Existing_antenna_Mechanical_tilt;
    private EditText edt_Space_Available_for_4G_Antenna;
    private EditText edt_Addl_Poles_reqd_for_4G_Antenna;
    private EditText edt_4GAntenna_Swap_Required;
    private EditText edt_4GApproximate_Cable_Lenth;
    private EditText edt_4GAntennaedt_Port_EmptyDamaged;
    private EditText edt_commentadd;
    private EditText edt_orientation;

    private ImageButton ib_Antenna_Type;
    private ImageButton ib_2GBand;
    private ImageButton ib_2GCoverge;
    private ImageButton ib_2GObstruction;
    private ImageButton ib_2G_Existing_Antenna_Height;
    private ImageButton ib_2G_Antenna_Make_and_Model;
    private ImageButton ib_2G_Existing_Antenna_Direction;
    private ImageButton ib_2G_Existing_antenna_tilt_Electrical;
    private ImageButton ib_2G_Existing_antenna_tilt_Mechanical;
    private ImageButton ib_3GBand;
    private ImageButton ib_3GCoverge;
    private ImageButton ib_3GObstruction;
    private ImageButton ib_3G_Existing_Antenna_Ht;
    private ImageButton ib_3G_Antenna_Make_and_Model;
    private ImageButton ib_3G_Existing_Antenna_Direction;
    private ImageButton ib_3G_Existing_antenna_Electrical_tilt;
    private ImageButton ib_3G_Existing_antenna_Mechanical_tilt;
    private ImageButton ib_Space_Available_for_3G_Antenna;
    private ImageButton ib_3GAntennaedt_Port_EmptyDamaged;
    private ImageButton ib_3GAntenna_Swap_Required;
    private ImageButton ib_3GApproximate_Cable_Lenth;
    private ImageButton ib_3GAntenna_Port_EmptyDamaged;
    private ImageButton ib_4GBand;
    private ImageButton ib_4GCoverge;
    private ImageButton ib_4GObstruction;
    private ImageButton ib_4G_Existing_Antenna_Ht;
    private ImageButton ib_4G_Antenna_Make_and_Model;
    private ImageButton ib_4G_Existing_Antenna_Direction;
    private ImageButton ib_4G_Existing_antenna_Electrical_tilt;
    private ImageButton ib_4G_Existing_antenna_Mechanical_tilt;
    private ImageButton ib_Space_Available_for_4G_Antenna;
    private ImageButton ib_Addl_Poles_reqd_for_4G_Antenna;
    private ImageButton ib_4GAntenna_Swap_Required;
    private ImageButton ib_4GApproximate_Cable_Lenth;
    private ImageButton ib_4GAntennaedt_Port_EmptyDamaged;


    private ImageView iv_Antenna_Type;
    private ImageView iv_2GBand;
    private ImageView iv_2GCoverge;
    private ImageView iv_2GObstruction;
    private ImageView iv_2G_Existing_Antenna_Height;
    private ImageView iv_2G_Antenna_Make_and_Model;
    private ImageView iv_2G_Existing_Antenna_Direction;
    private ImageView iv_2G_Existing_antenna_tilt_Electrical;
    private ImageView iv_2G_Existing_antenna_tilt_Mechanical;
    private ImageView iv_3GBand;
    private ImageView iv_3GCoverge;
    private ImageView iv_3GObstruction;
    private ImageView iv_3G_Existing_Antenna_Ht;
    private ImageView iv_3G_Antenna_Make_and_Model;
    private ImageView iv_3G_Existing_Antenna_Direction;
    private ImageView iv_3G_Existing_antenna_Electrical_tilt;
    private ImageView iv_3G_Existing_antenna_Mechanical_tilt;
    private ImageView iv_Space_Available_for_3G_Antenna;
    private ImageView iv_Addl_Poles_req_for_3G_Antenna;
    private ImageView iv_3GAntenna_Swap_Required;
    private ImageView iv_3GApproximate_Cable_Lenth;
    private ImageView iv_3GAntenna_Port_EmptyDamaged;
    private ImageView iv_4GBand;
    private ImageView iv_4GCoverge;
    private ImageView iv_4GObstruction;
    private ImageView iv_4G_Existing_Antenna_Ht;
    private ImageView iv_4G_Antenna_Make_and_Model;
    private ImageView iv_4G_Existing_Antenna_Direction;
    private ImageView iv_4G_Existing_antenna_Electrical_tilt;
    private ImageView iv_4G_Existing_antenna_Mechanical_tilt;
    private ImageView iv_Space_Available_for_4G_Antenna;
    private ImageView iv_Addl_Poles_reqd_for_4G_Antenna;
    private ImageView iv_4GAntenna_Swap_Required;
    private ImageView iv_4GApproximate_Cable_Lenth;
    private ImageView iv_4GAntennaedt_Port_EmptyDamaged;


    private String img_Antenna_Type = "";
    private String img_2GBand = "";
    private String img_2GCoverge = "";
    private String img_2GObstruction = "";
    private String img_2G_Existing_Antenna_Height = "";
    private String img_2G_Antenna_Make_and_Model = "";
    private String img_2G_Existing_Antenna_Direction = "";
    private String img_2G_Existing_antenna_tilt_Electrical = "";
    private String img_2G_Existing_antenna_tilt_Mechanical = "";
    private String img_3GBand = "";
    private String img_3GCoverge = "";
    private String img_3GObstruction = "";
    private String img_3G_Existing_Antenna_Ht = "";
    private String img_3G_Antenna_Make_and_Model = "";
    private String img_3G_Existing_Antenna_Direction = "";
    private String img_3G_Existing_antenna_Electrical_tilt = "";
    private String img_3G_Existing_antenna_Mechanical_tilt = "";
    private String img_Space_Available_for_3G_Antenna = "";
    private String img_Addl_Poles_reqd_for_3G_Antenna = "";
    private String img_3GAntenna_Swap_Required = "";
    private String img_3GApproximate_Cable_Lenth = "";
    private String img_3GAntenna_Port_EmptyDamaged = "";
    private String img_4GBand = "";
    private String img_4GCoverge = "";
    private String img_4GObstruction = "";
    private String img_4G_Existing_Antenna_Ht = "";
    private String img_4G_Antenna_Make_and_Model = "";
    private String img_4G_Existing_Antenna_Direction = "";
    private String img_4G_Existing_antenna_Electrical_tilt = "";
    private String img_4G_Existing_antenna_Mechanical_tilt = "";
    private String img_Space_Available_for_4G_Antenna = "";
    private String img_Addl_Poles_reqd_for_4G_Antenna = "";
    private String img_4GAntenna_Swap_Required = "";
    private String img_4GApproximate_Cable_Lenth = "";
    private String img_4GAntenna_Port_EmptyDamaged = "";

    private final String SECTOR1 ="Sector1";
    private final String SECTOR2 ="Sector2";
    private final String SECTOR3 ="Sector3";
    private final String SECTOR4 ="Sector4";
    String rf_sectorDetail_name;
    String lat, log;
    Handler handler;
    String time;
    TextView tvprecount, tvaftercount, tv_rfsectordetail_status;
    Button btn_save, btn_next;
    DatabaseHandler db;
    SharedPreferenceUtils sharedPreferences;

    public RFSectorDetailFragment() {
        // Required empty public constructor
    }

    public static RFSectorDetailFragment newInstance(int index, String name) {
        RFSectorDetailFragment f = new RFSectorDetailFragment();
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
        View v = inflater.inflate(R.layout.fragment_rfsector_detail, container, false);
        rf_sectorDetail_name = getArguments().getString("name");
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
        tvprecount.setText(tvprecount.getText().toString() + db.getCountRFSectorDetail());
        sharedPreferences = SharedPreferenceUtils.getInstance();
        sharedPreferences.setContext(getActivity());
        return v;
    }

    private void findIds(View v) {

        edt_Antenna_Type = v.findViewById(R.id.edt_Antenna_Type);
        edt_2GBand = v.findViewById(R.id.edt_2GBand);
        edt_2GCoverge = v.findViewById(R.id.edt_2GCoverge);
        edt_2GObstruction = v.findViewById(R.id.edt_2GObstruction);
        edt_2G_Existing_Antenna_Height = v.findViewById(R.id.edt_2G_Existing_Antenna_Height);
        edt_2G_Antenna_Make_and_Model = v.findViewById(R.id.edt_2G_Antenna_Make_and_Model);
        edt_2G_Existing_Antenna_Direction = v.findViewById(R.id.edt_2G_Existing_Antenna_Direction);
        edt_2G_Existing_antenna_tilt_Electrical = v.findViewById(R.id.edt_2G_Existing_antenna_tilt_Electrical);
        edt_2G_Existing_antenna_tilt_Mechanical = v.findViewById(R.id.edt_2G_Existing_antenna_tilt_Mechanical);
        edt_3GBand = v.findViewById(R.id.edt_3GBand);
        edt_3GCoverge = v.findViewById(R.id.edt_3GCoverge);
        edt_3GObstruction = v.findViewById(R.id.edt_3GObstruction);
        edt_3G_Existing_Antenna_Ht = v.findViewById(R.id.edt_3G_Existing_Antenna_Height);
        edt_3G_Antenna_Make_and_Model = v.findViewById(R.id.edt_3G_Antenna_Make_and_Model);
        edt_3G_Existing_Antenna_Direction = v.findViewById(R.id.edt_3G_Existing_Antenna_Direction);
        edt_3G_Existing_antenna_Electrical_tilt = v.findViewById(R.id.edt_3G_Existing_antenna_Electrical_tilt);
        edt_3G_Existing_antenna_Mechanical_tilt = v.findViewById(R.id.edt_3G_Existing_antenna_Mechanical_tilt);
        edt_Space_Available_for_3G_Antenna = v.findViewById(R.id.edt_Space_Available_for_3G_Antenna);
        edt_Addl_Poles_req_for_3G_Antenna = v.findViewById(R.id.edt_Addl_Poles_req_for_3G_Antenna);
        edt_3GAntenna_Swap_Required = v.findViewById(R.id.edt_3GAntenna_Swap_Required);
        edt_3GApproximate_Cable_Lenth = v.findViewById(R.id.edt_3GApproximate_Cable_Lenth);
        edt_3GAntenna_Port_EmptyDamaged = v.findViewById(R.id.edt_3GAntenna_Port_EmptyDamaged);
        edt_4GBand = v.findViewById(R.id.edt_4GBand);
        edt_4GCoverge = v.findViewById(R.id.edt_4GCoverge);
        edt_4GObstruction = v.findViewById(R.id.edt_4GObstruction);
        edt_4G_Existing_Antenna_Ht = v.findViewById(R.id.edt_4G_Existing_Antenna_Height);
        edt_4G_Antenna_Make_and_Model = v.findViewById(R.id.edt_4G_Antenna_Makeedt_and_Model);
        edt_4G_Existing_Antenna_Direction = v.findViewById(R.id.edt_4G_Existing_Antenna_Direction);
        edt_4G_Existing_antenna_Electrical_tilt = v.findViewById(R.id.edt_4G_Existing_antenna_tilt_Electrical);
        edt_4G_Existing_antenna_Mechanical_tilt = v.findViewById(R.id.edt_4G_Existing_antenna_tilt_Mechanical);
        edt_Space_Available_for_4G_Antenna = v.findViewById(R.id.edt_Space_Available_for_4G_Antenna);
        edt_Addl_Poles_reqd_for_4G_Antenna = v.findViewById(R.id.edt_Addl_Poles_req_for_4G_Antenna);
        edt_4GAntenna_Swap_Required = v.findViewById(R.id.edt_4GAntenna_Swap_Required);
        edt_4GApproximate_Cable_Lenth = v.findViewById(R.id.edt_4GApproximate_Cable_Lenth);
        edt_4GAntennaedt_Port_EmptyDamaged = v.findViewById(R.id.edt_4GAntenna_Port_EmptyDamaged);
        edt_commentadd = v.findViewById(R.id.edt_commentadd);
        edt_orientation = v.findViewById(R.id.edt_orientation);

        btn_save = v.findViewById(R.id.btnrfsectordetailsave);
        btn_next = v.findViewById(R.id.btnrfsectordetailnext);
        tvprecount = v.findViewById(R.id.tv_rfsectordetail_count_previous);
        tvaftercount = v.findViewById(R.id.tv_rfsectordetail_count);
        tv_rfsectordetail_status = v.findViewById(R.id.tv_rfsectordetail_status);

        ib_Antenna_Type = v.findViewById(R.id.ib_Antenna_Type);
        ib_2GBand = v.findViewById(R.id.ib_2GBand);
        ib_2GCoverge = v.findViewById(R.id.ib_2GCoverge);
        ib_2GObstruction = v.findViewById(R.id.ib_2GObstruction);
        ib_2G_Existing_Antenna_Height = v.findViewById(R.id.ib_2G_Existing_Antenna_Height);
        ib_2G_Antenna_Make_and_Model = v.findViewById(R.id.ib_2G_Antenna_Make_and_Model);
        ib_2G_Existing_Antenna_Direction = v.findViewById(R.id.ib_2G_Existing_Antenna_Direction);
        ib_2G_Existing_antenna_tilt_Electrical = v.findViewById(R.id.ib_2G_Existing_antenna_tilt_Electrical);
        ib_2G_Existing_antenna_tilt_Mechanical = v.findViewById(R.id.ib_2G_Existing_antenna_tilt_Mechanical);
        ib_3GBand = v.findViewById(R.id.ib_3GBand);
        ib_3GCoverge = v.findViewById(R.id.ib_3GCoverge);
        ib_3GObstruction = v.findViewById(R.id.ib_3GObstruction);
        ib_3G_Existing_Antenna_Ht = v.findViewById(R.id.ib_3G_Existing_Antenna_Height);
        ib_3G_Antenna_Make_and_Model = v.findViewById(R.id.ib_3G_Antenna_Make_and_Model);
        ib_3G_Existing_Antenna_Direction = v.findViewById(R.id.ib_3G_Existing_Antenna_Direction);
        ib_3G_Existing_antenna_Electrical_tilt = v.findViewById(R.id.ib_3G_Existing_antenna_Electrical_tilt);
        ib_3G_Existing_antenna_Mechanical_tilt = v.findViewById(R.id.ib_3G_Existing_antenna_Mechanical_tilt);
        ib_Space_Available_for_3G_Antenna = v.findViewById(R.id.ib_Space_Available_for_3G_Antenna);
        ib_3GAntennaedt_Port_EmptyDamaged = v.findViewById(R.id.ib_Addl_Poles_req_for_3G_Antenna);
        ib_3GAntenna_Swap_Required = v.findViewById(R.id.ib_3GAntenna_Swap_Required);
        ib_3GApproximate_Cable_Lenth = v.findViewById(R.id.ib_3GApproximate_Cable_Lenth);
        ib_3GAntenna_Port_EmptyDamaged = v.findViewById(R.id.ib_3GAntenna_Port_EmptyDamaged);
        ib_4GBand = v.findViewById(R.id.ib_4GBand);
        ib_4GCoverge = v.findViewById(R.id.ib_4GCoverge);
        ib_4GObstruction = v.findViewById(R.id.ib_4GObstruction);
        ib_4G_Existing_Antenna_Ht = v.findViewById(R.id.ib_4G_Existing_Antenna_Height);
        ib_4G_Antenna_Make_and_Model = v.findViewById(R.id.ib_4G_Antenna_Makeedt_and_Model);
        ib_4G_Existing_Antenna_Direction = v.findViewById(R.id.ib_4G_Existing_Antenna_Direction);
        ib_4G_Existing_antenna_Electrical_tilt = v.findViewById(R.id.ib_4G_Existing_antenna_tilt_Electrical);
        ib_4G_Existing_antenna_Mechanical_tilt = v.findViewById(R.id.ib_4G_Existing_antenna_tilt_Mechanical);
        ib_Space_Available_for_4G_Antenna = v.findViewById(R.id.ib_Space_Available_for_4G_Antenna);
        ib_Addl_Poles_reqd_for_4G_Antenna = v.findViewById(R.id.ib_Addl_Poles_req_for_4G_Antenna);
        ib_4GAntenna_Swap_Required = v.findViewById(R.id.ib_4GAntenna_Swap_Required);
        ib_4GApproximate_Cable_Lenth = v.findViewById(R.id.ib_4GApproximate_Cable_Lenth);
        ib_4GAntennaedt_Port_EmptyDamaged = v.findViewById(R.id.ib_4GAntenna_Port_EmptyDamaged);

        iv_Antenna_Type = v.findViewById(R.id.iv_Antenna_Type);
        iv_2GBand = v.findViewById(R.id.iv_2GBand);
        iv_2GCoverge = v.findViewById(R.id.iv_2GCoverge);
        iv_2GObstruction = v.findViewById(R.id.iv_2GObstruction);
        iv_2G_Existing_Antenna_Height = v.findViewById(R.id.iv_2G_Existing_Antenna_Height);
        iv_2G_Antenna_Make_and_Model = v.findViewById(R.id.iv_2G_Antenna_Make_and_Model);
        iv_2G_Existing_Antenna_Direction = v.findViewById(R.id.iv_2G_Existing_Antenna_Direction);
        iv_2G_Existing_antenna_tilt_Electrical = v.findViewById(R.id.iv_2G_Existing_antenna_tilt_Electrical);
        iv_2G_Existing_antenna_tilt_Mechanical = v.findViewById(R.id.iv_2G_Existing_antenna_tilt_Mechanical);
        iv_3GBand = v.findViewById(R.id.iv_3GBand);
        iv_3GCoverge = v.findViewById(R.id.iv_3GCoverge);
        iv_3GObstruction = v.findViewById(R.id.iv_3GObstruction);
        iv_3G_Existing_Antenna_Ht = v.findViewById(R.id.iv_3G_Existing_Antenna_Height);
        iv_3G_Antenna_Make_and_Model = v.findViewById(R.id.iv_3G_Antenna_Make_and_Model);
        iv_3G_Existing_Antenna_Direction = v.findViewById(R.id.iv_3G_Existing_Antenna_Direction);
        iv_3G_Existing_antenna_Electrical_tilt = v.findViewById(R.id.iv_3G_Existing_antenna_Electrical_tilt);
        iv_3G_Existing_antenna_Mechanical_tilt = v.findViewById(R.id.iv_3G_Existing_antenna_Mechanical_tilt);
        iv_Space_Available_for_3G_Antenna = v.findViewById(R.id.iv_Space_Available_for_3G_Antenna);
        iv_Addl_Poles_req_for_3G_Antenna = v.findViewById(R.id.iv_Addl_Poles_req_for_3G_Antenna);
        iv_3GAntenna_Swap_Required = v.findViewById(R.id.iv_3GAntenna_Swap_Required);
        iv_3GApproximate_Cable_Lenth = v.findViewById(R.id.iv_3GApproximate_Cable_Lenth);
        iv_3GAntenna_Port_EmptyDamaged = v.findViewById(R.id.iv_3GAntenna_Port_EmptyDamaged);
        iv_4GBand = v.findViewById(R.id.iv_4GBand);
        iv_4GCoverge = v.findViewById(R.id.iv_4GCoverge);
        iv_4GObstruction = v.findViewById(R.id.iv_4GObstruction);
        iv_4G_Existing_Antenna_Ht = v.findViewById(R.id.iv_4G_Existing_Antenna_Height);
        iv_4G_Antenna_Make_and_Model = v.findViewById(R.id.iv_4G_Antenna_Makeedt_and_Model);
        iv_4G_Existing_Antenna_Direction = v.findViewById(R.id.iv_4G_Existing_Antenna_Direction);
        iv_4G_Existing_antenna_Electrical_tilt = v.findViewById(R.id.iv_4G_Existing_antenna_tilt_Electrical);
        iv_4G_Existing_antenna_Mechanical_tilt = v.findViewById(R.id.iv_4G_Existing_antenna_tilt_Mechanical);
        iv_Space_Available_for_4G_Antenna = v.findViewById(R.id.iv_Space_Available_for_4G_Antenna);
        iv_Addl_Poles_reqd_for_4G_Antenna = v.findViewById(R.id.iv_Addl_Poles_req_for_4G_Antenna);
        iv_4GAntenna_Swap_Required = v.findViewById(R.id.iv_4GAntenna_Swap_Required);
        iv_4GApproximate_Cable_Lenth = v.findViewById(R.id.iv_4GApproximate_Cable_Lenth);
        iv_4GAntennaedt_Port_EmptyDamaged = v.findViewById(R.id.iv_4GAntenna_Port_EmptyDamaged);

        btn_save.setOnClickListener(this);
        btn_next.setOnClickListener(this);
        ib_Antenna_Type.setOnClickListener(this);
        ib_2GBand.setOnClickListener(this);
        ib_2GCoverge.setOnClickListener(this);
        ib_2GObstruction.setOnClickListener(this);
        ib_2G_Existing_Antenna_Height.setOnClickListener(this);
        ib_2G_Antenna_Make_and_Model.setOnClickListener(this);
        ib_2G_Existing_Antenna_Direction.setOnClickListener(this);
        ib_2G_Existing_antenna_tilt_Electrical.setOnClickListener(this);
        ib_2G_Existing_antenna_tilt_Mechanical.setOnClickListener(this);
        ib_3GBand.setOnClickListener(this);
        ib_3GCoverge.setOnClickListener(this);
        ib_3GObstruction.setOnClickListener(this);
        ib_3G_Existing_Antenna_Ht.setOnClickListener(this);
        ib_3G_Antenna_Make_and_Model.setOnClickListener(this);
        ib_3G_Existing_Antenna_Direction.setOnClickListener(this);
        ib_3G_Existing_antenna_Electrical_tilt.setOnClickListener(this);
        ib_3G_Existing_antenna_Mechanical_tilt.setOnClickListener(this);
        ib_Space_Available_for_3G_Antenna.setOnClickListener(this);
        ib_3GAntennaedt_Port_EmptyDamaged.setOnClickListener(this);
        ib_3GAntenna_Swap_Required.setOnClickListener(this);
        ib_3GApproximate_Cable_Lenth.setOnClickListener(this);
        ib_3GAntenna_Port_EmptyDamaged.setOnClickListener(this);
        ib_4GBand.setOnClickListener(this);
        ib_4GCoverge.setOnClickListener(this);
        ib_4GObstruction.setOnClickListener(this);
        ib_4G_Existing_Antenna_Ht.setOnClickListener(this);
        ib_4G_Antenna_Make_and_Model.setOnClickListener(this);
        ib_4G_Existing_Antenna_Direction.setOnClickListener(this);
        ib_4G_Existing_antenna_Electrical_tilt.setOnClickListener(this);
        ib_4G_Existing_antenna_Mechanical_tilt.setOnClickListener(this);
        ib_Space_Available_for_4G_Antenna.setOnClickListener(this);
        ib_Addl_Poles_reqd_for_4G_Antenna.setOnClickListener(this);
        ib_4GAntenna_Swap_Required.setOnClickListener(this);
        ib_4GApproximate_Cable_Lenth.setOnClickListener(this);
        ib_4GAntennaedt_Port_EmptyDamaged.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view == ib_Antenna_Type) {
            selectImage("1");
        }
        if (view == ib_2GBand) {
            selectImage("2");
        }
        if (view == ib_2GCoverge) {
            selectImage("3");
        }
        if (view == ib_2GObstruction) {
            selectImage("4");
        }
        if (view == ib_2G_Existing_Antenna_Height) {
            selectImage("5");
        }
        if (view == ib_2G_Antenna_Make_and_Model) {
            selectImage("6");
        }
        if (view == ib_2G_Existing_Antenna_Direction) {
            selectImage("7");
        }
        if (view == ib_2G_Existing_antenna_tilt_Electrical) {
            selectImage("8");
        }
        if (view == ib_2G_Existing_antenna_tilt_Mechanical) {
            selectImage("9");
        }
        if (view == ib_3GBand) {
            selectImage("10");
        }
        if (view == ib_3GCoverge) {
            selectImage("11");
        }
        if (view == ib_3GObstruction) {
            selectImage("12");
        }
        if (view == ib_3G_Existing_Antenna_Ht) {
            selectImage("13");
        }
        if (view == ib_3G_Antenna_Make_and_Model) {
            selectImage("14");
        }
        if (view == ib_3G_Existing_Antenna_Direction) {
            selectImage("15");
        }
        if (view == ib_3G_Existing_antenna_Electrical_tilt) {
            selectImage("16");
        }
        if (view == ib_3G_Existing_antenna_Mechanical_tilt) {
            selectImage("17");
        }
        if (view == ib_Space_Available_for_3G_Antenna) {
            selectImage("18");
        }
        if (view == ib_3GAntennaedt_Port_EmptyDamaged) {
            selectImage("19");
        }
        if (view == ib_3GAntenna_Swap_Required) {
            selectImage("20");
        }
        if (view == ib_3GApproximate_Cable_Lenth) {
            selectImage("21");
        }
        if (view == ib_3GAntenna_Port_EmptyDamaged) {
            selectImage("22");
        }
        if (view == ib_4GBand) {
            selectImage("23");
        }
        if (view == ib_4GCoverge) {
            selectImage("24");
        }
        if (view == ib_4GObstruction) {
            selectImage("25");
        }
        if (view == ib_4G_Existing_Antenna_Ht) {
            selectImage("26");
        }
        if (view == ib_4G_Antenna_Make_and_Model) {
            selectImage("27");
        }
        if (view == ib_4G_Existing_Antenna_Direction) {
            selectImage("28");
        }
        if (view == ib_4G_Existing_antenna_Electrical_tilt) {
            selectImage("29");
        }
        if (view == ib_4G_Existing_antenna_Mechanical_tilt) {
            selectImage("30");
        }
        if (view == ib_Space_Available_for_4G_Antenna) {
            selectImage("31");
        }
        if (view == ib_Addl_Poles_reqd_for_4G_Antenna) {
            selectImage("32");
        }
        if (view == ib_4GAntenna_Swap_Required) {
            selectImage("33");
        }
        if (view == ib_4GApproximate_Cable_Lenth) {
            selectImage("34");
        }
        if (view == ib_4GAntennaedt_Port_EmptyDamaged) {
            selectImage("35");
        }
        if (view == btn_save) {
            db.insertRFSectorDetail(new RFSectorAntennaDetailData(edt_Antenna_Type.getText().toString(), edt_2GBand.getText().toString(), edt_2GCoverge.getText().toString(), edt_2GObstruction.getText().toString(), edt_2G_Existing_Antenna_Height.getText().toString(),
                    edt_2G_Antenna_Make_and_Model.getText().toString(), edt_2G_Existing_Antenna_Direction.getText().toString(), edt_2G_Existing_antenna_tilt_Electrical.getText().toString(), edt_2G_Existing_antenna_tilt_Mechanical.getText().toString(),
                    edt_3GBand.getText().toString(), edt_3GCoverge.getText().toString(), edt_3GObstruction.getText().toString(), edt_3G_Existing_Antenna_Ht.getText().toString(), edt_3G_Antenna_Make_and_Model.getText().toString(), edt_3G_Existing_Antenna_Direction.getText().toString(),
                    edt_3G_Existing_antenna_Electrical_tilt.getText().toString(), edt_3G_Existing_antenna_Mechanical_tilt.getText().toString(), edt_Space_Available_for_3G_Antenna.getText().toString(), edt_Addl_Poles_req_for_3G_Antenna.getText().toString(), edt_3GAntenna_Swap_Required.getText().toString(),
                    edt_3GApproximate_Cable_Lenth.getText().toString(), edt_3GAntenna_Port_EmptyDamaged.getText().toString(), edt_4GBand.getText().toString(), edt_4GCoverge.getText().toString(), edt_4GObstruction.getText().toString(), edt_4G_Existing_Antenna_Ht.getText().toString(),
                    edt_4G_Antenna_Make_and_Model.getText().toString(), edt_4G_Existing_Antenna_Direction.getText().toString(), edt_4G_Existing_antenna_Electrical_tilt.getText().toString(), edt_4G_Existing_antenna_Mechanical_tilt.getText().toString(), edt_Space_Available_for_4G_Antenna.getText().toString(),
                    edt_Addl_Poles_reqd_for_4G_Antenna.getText().toString(), edt_4GAntenna_Swap_Required.getText().toString(), edt_4GApproximate_Cable_Lenth.getText().toString(), edt_4GAntennaedt_Port_EmptyDamaged.getText().toString(),
                    img_Antenna_Type, img_2GBand, img_2GCoverge, img_2GObstruction, img_2G_Existing_Antenna_Height, img_2G_Antenna_Make_and_Model, img_2G_Existing_Antenna_Direction, img_2G_Existing_antenna_tilt_Electrical, img_2G_Existing_antenna_tilt_Mechanical, img_3GBand, img_3GCoverge,
                    img_3GObstruction, img_3G_Existing_Antenna_Ht, img_3G_Antenna_Make_and_Model, img_3G_Existing_Antenna_Direction, img_3G_Existing_antenna_Electrical_tilt, img_3G_Existing_antenna_Mechanical_tilt, img_Space_Available_for_3G_Antenna, img_Addl_Poles_reqd_for_3G_Antenna, img_3GAntenna_Swap_Required,
                    img_3GApproximate_Cable_Lenth, img_3GAntenna_Port_EmptyDamaged, img_4GBand, img_4GCoverge, img_4GObstruction, img_4G_Existing_Antenna_Ht, img_4G_Antenna_Make_and_Model, img_4G_Existing_Antenna_Direction, img_4G_Existing_antenna_Electrical_tilt, img_4G_Existing_antenna_Mechanical_tilt,
                    img_Space_Available_for_4G_Antenna, img_Addl_Poles_reqd_for_4G_Antenna, img_4GAntenna_Swap_Required, img_4GApproximate_Cable_Lenth, img_4GAntenna_Port_EmptyDamaged, rf_sectorDetail_name,edt_commentadd.getText().toString(), edt_orientation.getText().toString(),time, 1));

            Toast.makeText(getActivity(), rf_sectorDetail_name, Toast.LENGTH_LONG).show();
            if (rf_sectorDetail_name.equalsIgnoreCase("Sector4")) {
                btn_next.setVisibility(View.VISIBLE);
            }
            tvaftercount.setText(db.getCountRFSectorDetail()+"");
        }
        if (view == btn_next) {
            toSendDataRFSiteDetail();
            toSendDataRFSectorDetail1();
            toSendDataRFSectorDetail2();
            toSendDataRFSectorDetail3();
            toSendDataRFSectorDetail4();

        }
    }

    private JSONObject jsondataRFSiteDetail() {
        JSONObject jsonObject = new JSONObject();
        List<RFSiteDetailData> rfSiteDetailData = db.getLastRFSiteDetail();
        try {

            jsonObject.put("edt_SiteName", rfSiteDetailData.get(0).getEdt_SiteName());
            jsonObject.put("edt_SurveyDate", rfSiteDetailData.get(0).getEdt_SurveyDate());
            jsonObject.put("edt_City", rfSiteDetailData.get(0).getEdt_City());
            jsonObject.put("edt_IMID", rfSiteDetailData.get(0).getEdt_IMID());
            jsonObject.put("edt_Cluttertype", rfSiteDetailData.get(0).getEdt_City());
            jsonObject.put("edt_SiteType", rfSiteDetailData.get(0).getEdt_SiteType());
            jsonObject.put("edt_Zone", rfSiteDetailData.get(0).getEdt_Zone());
            jsonObject.put("edt_SiteCandidate", rfSiteDetailData.get(0).getEdt_SiteCandidate());
            jsonObject.put("edt_BldgHeight", rfSiteDetailData.get(0).getEdt_BldgHeight());
            jsonObject.put("edt_BldgStructure", rfSiteDetailData.get(0).getEdt_BldgStructure());
            jsonObject.put("edt_AGL", rfSiteDetailData.get(0).getEdt_AGL());
            jsonObject.put("edt_SiteContact", rfSiteDetailData.get(0).getEdt_SiteContact());
            jsonObject.put("edt_AMSL", rfSiteDetailData.get(0).getEdt_AMSL());
            jsonObject.put("edt_SiteAddress", rfSiteDetailData.get(0).getEdt_SiteAddress());
            jsonObject.put("edt_SiteIndoor", rfSiteDetailData.get(0).getEdt_SiteIndoor());
            jsonObject.put("edt_SiteOutdoor", rfSiteDetailData.get(0).getEdt_SiteOutdoor());
            jsonObject.put("edt_ShelterConcrete", rfSiteDetailData.get(0).getEdt_ShelterConcrete());
            jsonObject.put("edt_shelterFabricated", rfSiteDetailData.get(0).getEdt_shelterFabricated());
            jsonObject.put("edt_Numerofotheroperator", rfSiteDetailData.get(0).getEdt_Numerofotheroperator());
            jsonObject.put("edt_IPSite", rfSiteDetailData.get(0).getEdt_IPSite());
            jsonObject.put("edt_Others", rfSiteDetailData.get(0).getEdt_Others());
            jsonObject.put("edt_Sharing", rfSiteDetailData.get(0).getEdt_Sharing());
            jsonObject.put("edt_Hostoperator", rfSiteDetailData.get(0).getEdt_Hostoperator());
            jsonObject.put("edt_Anyguestoperators", rfSiteDetailData.get(0).getEdt_Anyguestoperators());
            jsonObject.put("edt_NoofGSMAntenna", rfSiteDetailData.get(0).getEdt_NoofGSMAntenna());
            jsonObject.put("edt_Lat", rfSiteDetailData.get(0).getEdt_Lat());
            jsonObject.put("edt_Long", rfSiteDetailData.get(0).getEdt_Long());
            jsonObject.put("img_SiteID", rfSiteDetailData.get(0).getImg_SiteID());
            jsonObject.put("img_SiteName", rfSiteDetailData.get(0).getImg_SiteName());
            jsonObject.put("img_SurveyDate", rfSiteDetailData.get(0).getImg_SurveyDate());
            jsonObject.put("img_City", rfSiteDetailData.get(0).getImg_City());
            jsonObject.put("img_IMID", rfSiteDetailData.get(0).getImg_IMID());
            jsonObject.put("img_Cluttertype", rfSiteDetailData.get(0).getImg_City());
            jsonObject.put("img_SiteType", rfSiteDetailData.get(0).getImg_SiteType());
            jsonObject.put("img_Zone", rfSiteDetailData.get(0).getImg_Zone());
            jsonObject.put("img_SiteCandidate", rfSiteDetailData.get(0).getImg_SiteCandidate());
            jsonObject.put("img_BldgHeight", rfSiteDetailData.get(0).getImg_BldgHeight());
            jsonObject.put("img_BldgStructure", rfSiteDetailData.get(0).getImg_BldgStructure());
            jsonObject.put("img_AGL", rfSiteDetailData.get(0).getImg_AGL());
            jsonObject.put("img_SiteContact", rfSiteDetailData.get(0).getImg_SiteContact());
            jsonObject.put("img_AMSL", rfSiteDetailData.get(0).getImg_AMSL());
            jsonObject.put("img_SiteAddress", rfSiteDetailData.get(0).getImg_SiteAddress());
            jsonObject.put("img_SiteIndoor", rfSiteDetailData.get(0).getImg_SiteIndoor());
            jsonObject.put("img_SiteOutdoor", rfSiteDetailData.get(0).getImg_SiteOutdoor());
            jsonObject.put("img_ShelterConcrete", rfSiteDetailData.get(0).getImg_ShelterConcrete());
            jsonObject.put("img_shelterFabricated", rfSiteDetailData.get(0).getImg_shelterFabricated());
            jsonObject.put("img_Numerofotheroperator", rfSiteDetailData.get(0).getImg_Numerofotheroperator());
            jsonObject.put("img_IPSite", rfSiteDetailData.get(0).getImg_IPSite());
            jsonObject.put("img_Others", rfSiteDetailData.get(0).getImg_Others());
            jsonObject.put("img_Sharing", rfSiteDetailData.get(0).getImg_Sharing());
            jsonObject.put("img_Hostoperator", rfSiteDetailData.get(0).getImg_Hostoperator());
            jsonObject.put("img_Anyguestoperators", rfSiteDetailData.get(0).getImg_Anyguestoperators());
            jsonObject.put("img_NoofGSMAntenna", rfSiteDetailData.get(0).getImg_NoofGSMAntenna());

            jsonObject.put("edt_Commentsadd", rfSiteDetailData.get(0).getEdt_Commentsadd());
            jsonObject.put("edt_SNo", rfSiteDetailData.get(0).getEdt_SNo());
            jsonObject.put("edt_NominalLat", rfSiteDetailData.get(0).getEdt_NominalLat());
            jsonObject.put("edt_NominalLong", rfSiteDetailData.get(0).getEdt_NominalLong());
            jsonObject.put("edt_TaLuk", rfSiteDetailData.get(0).getEdt_TaLuk());
            jsonObject.put("edt_AntennaType", rfSiteDetailData.get(0).getEdt_AntennaType());
            jsonObject.put("edt_CheckedBy", rfSiteDetailData.get(0).getEdt_CheckedBy());
            jsonObject.put("edt_SurveyedBy", rfSiteDetailData.get(0).getEdt_SurveyedBy());
            jsonObject.put("edt_Surveytype", rfSiteDetailData.get(0).getEdt_Surveytype());

            jsonObject.put("flag", rfSiteDetailData.get(0).getFlag());
            jsonObject.put("date",sharedPreferences.getString(AppConstants.DATE));
            jsonObject.put("empid",sharedPreferences.getString(AppConstants.EMPID));
            jsonObject.put("siteid",sharedPreferences.getString(AppConstants.SITEID));
            jsonObject.put("idall",sharedPreferences.getString(AppConstants.surveytpeandcustomerandoperator));

        } catch (Exception e) {

        }

        return jsonObject;
    }

    private void toSendDataRFSiteDetail() {
        //  +"?Loginid="+empId+"&password="+empPassword+"&imeno="+"1234567890"
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        pDialog.show();
        Log.v("json rfsitedetail", jsondataRFSiteDetail().toString());
        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.RF_Site_Detail, jsondataRFSiteDetail(),
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponseRFSiteDetail(response.toString());
                        Log.v("res rfsitedetail", response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("error rfsitedetail", error.toString());
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

    private void parseSettingResponseRFSiteDetail(String s) {
        try {
            JSONArray jsonArray = new JSONArray(s);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String status = jsonObject.getString("Status");
            Toast.makeText(getActivity(), status + " RF SiteDetail", Toast.LENGTH_LONG).show();
            tv_rfsectordetail_status.append("Site Detail :" + status + "\n");
            // String password = jsonObject.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
            tv_rfsectordetail_status.append("Site Detail :" + e.getMessage() + "\n");
        }
    }
//.....................................................................................

    //.................................RF SectorDetail1.......................
    private JSONObject jsondataRFSectorDetail1(){
        JSONObject jsonObject = new JSONObject();
        List<RFSectorAntennaDetailData> sectorDetailData = db.getLast_RFSECTORDETAIL(SECTOR1);
        if(sectorDetailData.size()>0){
            Log.v("RFSectorDetailData1",sectorDetailData.toString());
            try {
                jsonObject.put("edt_Antenna_Type", sectorDetailData.get(0).getEdt_Antenna_Type());
                jsonObject.put("edt_2GBand", sectorDetailData.get(0).getEdt_2GBand());
                jsonObject.put("edt_2GCoverge", sectorDetailData.get(0).getEdt_2GCoverge());
                jsonObject.put("edt_2GObstruction", sectorDetailData.get(0).getEdt_2GObstruction());
                jsonObject.put("edt_2G_Existing_Antenna_Height", sectorDetailData.get(0).getEdt_2G_Existing_Antenna_Height());
                jsonObject.put("edt_2G_Antenna_Make_and_Model", sectorDetailData.get(0).getEdt_2G_Antenna_Makeedt_and_Model());
                jsonObject.put("edt_2G_Existing_Antenna_Direction", sectorDetailData.get(0).getEdt_2G_Existing_Antenna_Direction());
                jsonObject.put("edt_2G_Existing_antenna_tilt_Electrical", sectorDetailData.get(0).getEdt_2G_Existing_antenna_tilt_Electrical());
                jsonObject.put("edt_2G_Existing_antenna_tilt_Mechanical", sectorDetailData.get(0).getEdt_2G_Existing_antenna_tilt_Mechanical());
                jsonObject.put("edt_3GBand", sectorDetailData.get(0).getEdt_3GBand());
                jsonObject.put("edt_3GCoverge", sectorDetailData.get(0).getEdt_3GCoverge());
                jsonObject.put("edt_3GObstruction", sectorDetailData.get(0).getEdt_3GObstruction());
                jsonObject.put("edt_3G_Existing_Antenna_Ht", sectorDetailData.get(0).getEdt_3G_Existing_Antenna_Ht());
                jsonObject.put("edt_3G_Antenna_Make_and_Model", sectorDetailData.get(0).getEdt_3G_Antenna_Make_and_Model());
                jsonObject.put("edt_3G_Existing_Antenna_Direction", sectorDetailData.get(0).getEdt_3G_Existing_Antenna_Direction());
                jsonObject.put("edt_3G_Existing_antenna_Electrical_tilt", sectorDetailData.get(0).getEdt_3G_Existing_antenna_Electrical_tilt());
                jsonObject.put("edt_3G_Existing_antenna_Mechanical_tilt", sectorDetailData.get(0).getEdt_3G_Existing_antenna_Mechanical_tilt());
                jsonObject.put("edt_Space_Available_for_3G_Antenna", sectorDetailData.get(0).getEdt_Space_Available_for_3G_Antenna());
                jsonObject.put("edt_Addl_Poles_reqd_for_3G_Antenna", sectorDetailData.get(0).getEdt_Addl_Poles_req_for_3G_Antenna());
                jsonObject.put("edt_3GAntenna_Swap_Required", sectorDetailData.get(0).getEdt_3GAntenna_Swap_Required());
                jsonObject.put("edt_3GApproximate_Cable_Lenth", sectorDetailData.get(0).getEdt_3GApproximate_Cable_Lenth());
                jsonObject.put("edt_3GAntenna_Port_EmptyDamaged", sectorDetailData.get(0).getEdt_3GAntenna_Port_EmptyDamaged());
                jsonObject.put("edt_4GBand", sectorDetailData.get(0).getEdt_4GBand());
                jsonObject.put("edt_4GCoverge", sectorDetailData.get(0).getEdt_4GCoverge());
                jsonObject.put("edt_4GObstruction", sectorDetailData.get(0).getEdt_4GObstruction());
                jsonObject.put("edt_4G_Existing_Antenna_Ht", sectorDetailData.get(0).getEdt_4G_Existing_Antenna_Ht());
                jsonObject.put("edt_4G_Antenna_Make_and_Model", sectorDetailData.get(0).getEdt_4G_Antenna_Make_and_Model());
                jsonObject.put("edt_4G_Existing_Antenna_Direction", sectorDetailData.get(0).getEdt_4G_Existing_Antenna_Direction());
                jsonObject.put("edt_4G_Existing_antenna_Electrical_tilt", sectorDetailData.get(0).getEdt_4G_Existing_antenna_Electrical_tilt());
                jsonObject.put("edt_4G_Existing_antenna_Mechanical_tilt", sectorDetailData.get(0).getEdt_4G_Existing_antenna_Mechanical_tilt());
                jsonObject.put("edt_Space_Available_for_4G_Antenna", sectorDetailData.get(0).getEdt_Space_Available_for_4G_Antenna());
                jsonObject.put("edt_Addl_Poles_reqd_for_4G_Antenna", sectorDetailData.get(0).getEdt_Addl_Poles_reqd_for_4G_Antenna());
                jsonObject.put("edt_4GAntenna_Swap_Required", sectorDetailData.get(0).getEdt_4GAntenna_Swap_Required());
                jsonObject.put("edt_4GApproximate_Cable_Lenth", sectorDetailData.get(0).getEdt_3GApproximate_Cable_Lenth());
                jsonObject.put("edt_4GAntennaedt_Port_EmptyDamaged", sectorDetailData.get(0).getEdt_4GAntennaedt_Port_EmptyDamaged());

                //  jsonObject.put("img_Antenna_Type", sectorDetailData.get(0).getImg_Antenna_Type());
                if(!sectorDetailData.get(0).getImg_Antenna_Type().equals("")){
                    jsonObject.put("img_Antenna_Type", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_Antenna_Type()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_Antenna_Type",sectorDetailData.get(0).getImg_Antenna_Type() );
                }
                // jsonObject.put("img_2GBand", sectorDetailData.get(0).getImg_2GBand());
                if(!sectorDetailData.get(0).getImg_2GBand().equals("")){
                    jsonObject.put("img_2GBand", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_2GBand()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_2GBand",sectorDetailData.get(0).getImg_2GBand() );
                }
                // jsonObject.put("img_2GCoverge", sectorDetailData.get(0).getImg_2GCoverge());
                if(!sectorDetailData.get(0).getImg_2GCoverge().equals("")){
                    jsonObject.put("img_2GCoverge", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_2GCoverge()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_2GCoverge",sectorDetailData.get(0).getImg_2GCoverge() );
                }
                //  jsonObject.put("img_2GObstruction", sectorDetailData.get(0).getImg_2GObstruction());
                if(!sectorDetailData.get(0).getImg_2GObstruction().equals("")){
                    jsonObject.put("img_2GObstruction", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_2GObstruction()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_2GObstruction",sectorDetailData.get(0).getImg_2GObstruction() );
                }
                //  jsonObject.put("img_2G_Existing_Antenna_Height", sectorDetailData.get(0).getImg_2G_Existing_Antenna_Height());
                if(!sectorDetailData.get(0).getImg_2G_Existing_Antenna_Height().equals("")){
                    jsonObject.put("img_2G_Existing_Antenna_Height", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_2G_Existing_Antenna_Height()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_2G_Existing_Antenna_Height",sectorDetailData.get(0).getImg_2G_Existing_Antenna_Height() );
                }
                //  jsonObject.put("img_2G_Antenna_Make_and_Model", sectorDetailData.get(0).getImg_2G_Antenna_Make_and_Model());
                if(!sectorDetailData.get(0).getImg_2G_Antenna_Make_and_Model().equals("")){
                    jsonObject.put("img_2G_Antenna_Make_and_Model", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_2G_Antenna_Make_and_Model()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_2G_Antenna_Make_and_Model",sectorDetailData.get(0).getImg_2G_Antenna_Make_and_Model() );
                }
                //  jsonObject.put("img_2G_Existing_Antenna_Direction", sectorDetailData.get(0).getImg_2G_Existing_Antenna_Direction());
                if(!sectorDetailData.get(0).getImg_2G_Existing_Antenna_Direction().equals("")){
                    jsonObject.put("img_2G_Existing_Antenna_Direction", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_2G_Existing_Antenna_Direction()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_2G_Existing_Antenna_Direction",sectorDetailData.get(0).getImg_2G_Existing_Antenna_Direction() );
                }
                //  jsonObject.put("img_2G_Existing_antenna_tilt_Electrical", sectorDetailData.get(0).getImg_2G_Existing_antenna_tilt_Electrical());
                if(!sectorDetailData.get(0).getImg_2G_Existing_antenna_tilt_Electrical().equals("")){
                    jsonObject.put("img_2G_Existing_antenna_tilt_Electrical", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_2G_Existing_antenna_tilt_Electrical()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_2G_Existing_antenna_tilt_Electrical",sectorDetailData.get(0).getImg_2G_Existing_antenna_tilt_Electrical() );
                }
                //   jsonObject.put("img_2G_Existing_antenna_tilt_Mechanical", sectorDetailData.get(0).getImg_2G_Existing_antenna_tilt_Mechanical());
                if(!sectorDetailData.get(0).getImg_2G_Existing_antenna_tilt_Mechanical().equals("")){
                    jsonObject.put("img_2G_Existing_antenna_tilt_Mechanical", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_2G_Existing_antenna_tilt_Mechanical()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_2G_Existing_antenna_tilt_Mechanical",sectorDetailData.get(0).getImg_2G_Existing_antenna_tilt_Mechanical() );
                }
                //   jsonObject.put("img_3GBand", sectorDetailData.get(0).getImg_3GBand());
                if(!sectorDetailData.get(0).getImg_3GBand().equals("")){
                    jsonObject.put("img_3GBand", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3GBand()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_3GBand",sectorDetailData.get(0).getImg_3GBand() );
                }
                //   jsonObject.put("img_3GCoverge", sectorDetailData.get(0).getImg_3GCoverge());
                if(!sectorDetailData.get(0).getImg_3GCoverge().equals("")){
                    jsonObject.put("img_3GCoverge", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3GCoverge()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_3GCoverge",sectorDetailData.get(0).getImg_3GCoverge() );
                }
                //   jsonObject.put("img_3GObstruction", sectorDetailData.get(0).getImg_3GObstruction());
                if(!sectorDetailData.get(0).getImg_3GObstruction().equals("")){
                    jsonObject.put("img_3GObstruction", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3GObstruction()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_3GObstruction",sectorDetailData.get(0).getImg_3GObstruction() );
                }
                //   jsonObject.put("img_3G_Existing_Antenna_Ht", sectorDetailData.get(0).getImg_3G_Existing_Antenna_Ht());
                if(!sectorDetailData.get(0).getImg_3G_Existing_Antenna_Ht().equals("")){
                    jsonObject.put("img_3G_Existing_Antenna_Ht", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3G_Existing_Antenna_Ht()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_3G_Existing_Antenna_Ht",sectorDetailData.get(0).getImg_3G_Existing_Antenna_Ht() );
                }
                //    jsonObject.put("img_3G_Antenna_Make_and_Model", sectorDetailData.get(0).getImg_3G_Antenna_Make_and_Model());
                if(!sectorDetailData.get(0).getImg_3G_Antenna_Make_and_Model().equals("")){
                    jsonObject.put("img_3G_Antenna_Make_and_Model", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3G_Antenna_Make_and_Model()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_3G_Antenna_Make_and_Model",sectorDetailData.get(0).getImg_3G_Antenna_Make_and_Model() );
                }
                //   jsonObject.put("img_3G_Existing_Antenna_Direction", sectorDetailData.get(0).getImg_3G_Existing_Antenna_Direction());
                if(!sectorDetailData.get(0).getImg_3G_Existing_Antenna_Direction().equals("")){
                    jsonObject.put("img_3G_Existing_Antenna_Direction", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3G_Existing_Antenna_Direction()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_3G_Existing_Antenna_Direction",sectorDetailData.get(0).getImg_3G_Existing_Antenna_Direction() );
                }
                //    jsonObject.put("img_3G_Existing_antenna_Electrical_tilt", sectorDetailData.get(0).getImg_3G_Existing_antenna_Electrical_tilt());
                if(!sectorDetailData.get(0).getImg_3G_Existing_antenna_Electrical_tilt().equals("")){
                    jsonObject.put("img_3G_Existing_antenna_Electrical_tilt", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3G_Existing_antenna_Electrical_tilt()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_3G_Existing_antenna_Electrical_tilt",sectorDetailData.get(0).getImg_3G_Existing_antenna_Electrical_tilt() );
                }
                //    jsonObject.put("img_3G_Existing_antenna_Mechanical_tilt", sectorDetailData.get(0).getImg_3G_Existing_antenna_Mechanical_tilt());
                if(!sectorDetailData.get(0).getImg_3G_Existing_antenna_Mechanical_tilt().equals("")){
                    jsonObject.put("img_3G_Existing_antenna_Mechanical_tilt", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3G_Existing_antenna_Mechanical_tilt()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_3G_Existing_antenna_Mechanical_tilt",sectorDetailData.get(0).getImg_3G_Existing_antenna_Mechanical_tilt() );
                }
                //     jsonObject.put("img_Space_Available_for_3G_Antenna", sectorDetailData.get(0).getImg_Space_Available_for_3G_Antenna());
                if(!sectorDetailData.get(0).getImg_Space_Available_for_3G_Antenna().equals("")){
                    jsonObject.put("img_Space_Available_for_3G_Antenna", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_Space_Available_for_3G_Antenna()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_Space_Available_for_3G_Antenna",sectorDetailData.get(0).getImg_Space_Available_for_3G_Antenna() );
                }
                //  jsonObject.put("img_Addl_Poles_req_for_3G_Antenna", sectorDetailData.get(0).getImg_Addl_Poles_reqd_for_3G_Antenna());
                if(!sectorDetailData.get(0).getImg_Addl_Poles_reqd_for_3G_Antenna().equals("")){
                    jsonObject.put("img_Addl_Poles_req_for_3G_Antenna", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_Addl_Poles_reqd_for_3G_Antenna()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_Addl_Poles_req_for_3G_Antenna", sectorDetailData.get(0).getImg_Addl_Poles_reqd_for_3G_Antenna());
                }
                //   jsonObject.put("img_3GAntenna_Swap_Required", sectorDetailData.get(0).getImg_3GAntenna_Swap_Required());
                if(!sectorDetailData.get(0).getImg_3GAntenna_Swap_Required().equals("")){
                    jsonObject.put("img_3GAntenna_Swap_Required", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3GAntenna_Swap_Required()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_3GAntenna_Swap_Required", sectorDetailData.get(0).getImg_3GAntenna_Swap_Required());
                }
                //   jsonObject.put("img_3GApproximate_Cable_Lenth", sectorDetailData.get(0).getImg_3GApproximate_Cable_Lenth());
                if(!sectorDetailData.get(0).getImg_3GApproximate_Cable_Lenth().equals("")){
                    jsonObject.put("img_3GApproximate_Cable_Lenth", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3GApproximate_Cable_Lenth()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_3GApproximate_Cable_Lenth", sectorDetailData.get(0).getImg_3GApproximate_Cable_Lenth());
                }
                //   jsonObject.put("img_3GAntenna_Port_EmptyDamaged", sectorDetailData.get(0).getImg_3GAntenna_Port_EmptyDamaged());
                if(!sectorDetailData.get(0).getImg_3GAntenna_Port_EmptyDamaged().equals("")){
                    jsonObject.put("img_3GAntenna_Port_EmptyDamaged", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3GAntenna_Port_EmptyDamaged()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_3GAntenna_Port_EmptyDamaged", sectorDetailData.get(0).getImg_3GAntenna_Port_EmptyDamaged());
                }
                //    jsonObject.put("img_4GBand", sectorDetailData.get(0).getImg_4GBand());
                if(!sectorDetailData.get(0).getImg_4GBand().equals("")){
                    jsonObject.put("img_4GBand", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_4GBand()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_4GBand", sectorDetailData.get(0).getImg_4GBand());
                }
                //      jsonObject.put("img_4GCoverge", sectorDetailData.get(0).getImg_4GCoverge());
                if(!sectorDetailData.get(0).getImg_4GCoverge().equals("")){
                    jsonObject.put("img_4GCoverge", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_4GCoverge()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_4GCoverge", sectorDetailData.get(0).getImg_4GCoverge());
                }
                //      jsonObject.put("img_4GObstruction", sectorDetailData.get(0).getImg_4GObstruction());
                if(!sectorDetailData.get(0).getImg_4GObstruction().equals("")){
                    jsonObject.put("img_4GObstruction", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_4GObstruction()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_4GObstruction", sectorDetailData.get(0).getImg_4GObstruction());
                }
                //     jsonObject.put("img_4G_Existing_Antenna_Ht", sectorDetailData.get(0).getImg_4G_Existing_Antenna_Ht());
                if(!sectorDetailData.get(0).getImg_4G_Existing_Antenna_Ht().equals("")){
                    jsonObject.put("img_4G_Existing_Antenna_Ht", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_4G_Existing_Antenna_Ht()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_4G_Existing_Antenna_Ht", sectorDetailData.get(0).getImg_4G_Existing_Antenna_Ht());
                }
                //     jsonObject.put("img_4G_Antenna_Make_and_Model", sectorDetailData.get(0).getImg_4G_Antenna_Make_and_Model());
                if(!sectorDetailData.get(0).getImg_4G_Antenna_Make_and_Model().equals("")){
                    jsonObject.put("img_4G_Antenna_Make_and_Model", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_4G_Antenna_Make_and_Model()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_4G_Antenna_Make_and_Model", sectorDetailData.get(0).getImg_4G_Antenna_Make_and_Model());
                }
                //     jsonObject.put("img_4G_Existing_Antenna_Direction", sectorDetailData.get(0).getImg_4G_Existing_Antenna_Direction());
                if(!sectorDetailData.get(0).getImg_4G_Existing_Antenna_Direction().equals("")){
                    jsonObject.put("img_4G_Existing_Antenna_Direction", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_4G_Existing_Antenna_Direction()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_4G_Existing_Antenna_Direction", sectorDetailData.get(0).getImg_4G_Existing_Antenna_Direction());
                }
                //     jsonObject.put("img_4G_Existing_antenna_Electrical_tilt", sectorDetailData.get(0).getImg_4G_Existing_antenna_Electrical_tilt());
                if(!sectorDetailData.get(0).getImg_4G_Existing_antenna_Electrical_tilt().equals("")){
                    jsonObject.put("img_4G_Existing_antenna_Electrical_tilt", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_4G_Existing_antenna_Electrical_tilt()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_4G_Existing_antenna_Electrical_tilt", sectorDetailData.get(0).getImg_4G_Existing_antenna_Electrical_tilt());
                }
                //    jsonObject.put("img_4G_Existing_antenna_Mechanical_tilt", sectorDetailData.get(0).getImg_4G_Existing_antenna_Mechanical_tilt());
                if(!sectorDetailData.get(0).getImg_4G_Existing_antenna_Mechanical_tilt().equals("")){
                    jsonObject.put("img_4G_Existing_antenna_Mechanical_tilt", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_4G_Existing_antenna_Mechanical_tilt()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_4G_Existing_antenna_Mechanical_tilt", sectorDetailData.get(0).getImg_4G_Existing_antenna_Mechanical_tilt());
                }
                //      jsonObject.put("img_Space_Available_for_4G_Antenna", sectorDetailData.get(0).getImg_Space_Available_for_4G_Antenna());
                if(!sectorDetailData.get(0).getImg_Space_Available_for_4G_Antenna().equals("")){
                    jsonObject.put("img_Space_Available_for_4G_Antenna", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_Space_Available_for_4G_Antenna()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_Space_Available_for_4G_Antenna", sectorDetailData.get(0).getImg_Space_Available_for_4G_Antenna());
                }
                //    jsonObject.put("img_Addl_Poles_reqd_for_4G_Antenna", sectorDetailData.get(0).getImg_Addl_Poles_reqd_for_4G_Antenna());
                if(!sectorDetailData.get(0).getImg_Addl_Poles_reqd_for_4G_Antenna().equals("")){
                    jsonObject.put("img_Addl_Poles_reqd_for_4G_Antenna", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_Addl_Poles_reqd_for_4G_Antenna()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_Addl_Poles_reqd_for_4G_Antenna", sectorDetailData.get(0).getImg_Addl_Poles_reqd_for_4G_Antenna());
                }
                //      jsonObject.put("img_4GAntenna_Swap_Required", sectorDetailData.get(0).getImg_4GAntenna_Swap_Required());
                if(!sectorDetailData.get(0).getImg_4GAntenna_Swap_Required().equals("")){
                    jsonObject.put("img_4GAntenna_Swap_Required", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_4GAntenna_Swap_Required()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_4GAntenna_Swap_Required", sectorDetailData.get(0).getImg_4GAntenna_Swap_Required());
                }
                //    jsonObject.put("img_4GApproximate_Cable_Lenth", sectorDetailData.get(0).getImg_3GApproximate_Cable_Lenth());
                if(!sectorDetailData.get(0).getImg_3GApproximate_Cable_Lenth().equals("")){
                    jsonObject.put("img_4GApproximate_Cable_Lenth", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3GApproximate_Cable_Lenth()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_4GApproximate_Cable_Lenth", sectorDetailData.get(0).getImg_3GApproximate_Cable_Lenth());
                }
                //       jsonObject.put("img_4GAntenna_Port_EmptyDamaged", sectorDetailData.get(0).getImg_4GAntenna_Port_EmptyDamaged());
                if(!sectorDetailData.get(0).getImg_4GAntenna_Port_EmptyDamaged().equals("")){
                    jsonObject.put("img_4GAntenna_Port_EmptyDamaged", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_4GAntenna_Port_EmptyDamaged()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_4GAntenna_Port_EmptyDamaged", sectorDetailData.get(0).getImg_4GAntenna_Port_EmptyDamaged());
                }


            /*    jsonObject.put("img_Antenna_Type", sectorDetailData.get(0).getImg_Antenna_Type());
                jsonObject.put("img_2GBand", sectorDetailData.get(0).getImg_2GBand());
                jsonObject.put("img_2GCoverge", sectorDetailData.get(0).getImg_2GCoverge());
                jsonObject.put("img_2GObstruction", sectorDetailData.get(0).getImg_2GObstruction());
                jsonObject.put("img_2G_Existing_Antenna_Height", sectorDetailData.get(0).getImg_2G_Existing_Antenna_Height());
                jsonObject.put("img_2G_Antenna_Make_and_Model", sectorDetailData.get(0).getImg_2G_Antenna_Make_and_Model());
                jsonObject.put("img_2G_Existing_Antenna_Direction", sectorDetailData.get(0).getImg_2G_Existing_Antenna_Direction());
                jsonObject.put("img_2G_Existing_antenna_tilt_Electrical", sectorDetailData.get(0).getImg_2G_Existing_antenna_tilt_Electrical());
                jsonObject.put("img_2G_Existing_antenna_tilt_Mechanical", sectorDetailData.get(0).getImg_2G_Existing_antenna_tilt_Mechanical());
                jsonObject.put("img_3GBand", sectorDetailData.get(0).getImg_3GBand());
                jsonObject.put("img_3GCoverge", sectorDetailData.get(0).getImg_3GCoverge());
                jsonObject.put("img_3GObstruction", sectorDetailData.get(0).getImg_3GObstruction());
                jsonObject.put("img_3G_Existing_Antenna_Ht", sectorDetailData.get(0).getImg_3G_Existing_Antenna_Ht());
                jsonObject.put("img_3G_Antenna_Make_and_Model", sectorDetailData.get(0).getImg_3G_Antenna_Make_and_Model());
                jsonObject.put("img_3G_Existing_Antenna_Direction", sectorDetailData.get(0).getImg_3G_Existing_Antenna_Direction());
                jsonObject.put("img_3G_Existing_antenna_Electrical_tilt", sectorDetailData.get(0).getImg_3G_Existing_antenna_Electrical_tilt());
                jsonObject.put("img_3G_Existing_antenna_Mechanical_tilt", sectorDetailData.get(0).getImg_3G_Existing_antenna_Mechanical_tilt());
                jsonObject.put("img_Space_Available_for_3G_Antenna", sectorDetailData.get(0).getImg_Space_Available_for_3G_Antenna());
                jsonObject.put("img_Addl_Poles_req_for_3G_Antenna", sectorDetailData.get(0).getImg_Addl_Poles_reqd_for_3G_Antenna());
                jsonObject.put("img_3GAntenna_Swap_Required", sectorDetailData.get(0).getImg_3GAntenna_Swap_Required());
                jsonObject.put("img_3GApproximate_Cable_Lenth", sectorDetailData.get(0).getImg_3GApproximate_Cable_Lenth());
                jsonObject.put("img_3GAntenna_Port_EmptyDamaged", sectorDetailData.get(0).getImg_3GAntenna_Port_EmptyDamaged());
                jsonObject.put("img_4GBand", sectorDetailData.get(0).getImg_4GBand());
                jsonObject.put("img_4GCoverge", sectorDetailData.get(0).getImg_4GCoverge());
                jsonObject.put("img_4GObstruction", sectorDetailData.get(0).getImg_4GObstruction());
                jsonObject.put("img_4G_Existing_Antenna_Ht", sectorDetailData.get(0).getImg_4G_Existing_Antenna_Ht());
                jsonObject.put("img_4G_Antenna_Make_and_Model", sectorDetailData.get(0).getImg_4G_Antenna_Make_and_Model());
                jsonObject.put("img_4G_Existing_Antenna_Direction", sectorDetailData.get(0).getImg_4G_Existing_Antenna_Direction());
                jsonObject.put("img_4G_Existing_antenna_Electrical_tilt", sectorDetailData.get(0).getImg_4G_Existing_antenna_Electrical_tilt());
                jsonObject.put("img_4G_Existing_antenna_Mechanical_tilt", sectorDetailData.get(0).getImg_4G_Existing_antenna_Mechanical_tilt());
                jsonObject.put("img_Space_Available_for_4G_Antenna", sectorDetailData.get(0).getImg_Space_Available_for_4G_Antenna());
                jsonObject.put("img_Addl_Poles_reqd_for_4G_Antenna", sectorDetailData.get(0).getImg_Addl_Poles_reqd_for_4G_Antenna());
                jsonObject.put("img_4GAntenna_Swap_Required", sectorDetailData.get(0).getImg_4GAntenna_Swap_Required());
                jsonObject.put("img_4GApproximate_Cable_Lenth", sectorDetailData.get(0).getImg_3GApproximate_Cable_Lenth());
                jsonObject.put("img_4GAntenna_Port_EmptyDamaged", sectorDetailData.get(0).getImg_4GAntenna_Port_EmptyDamaged());*/

                jsonObject.put("rf_sectorDetail_name", sectorDetailData.get(0).getRf_sectorDetail_name());
                jsonObject.put("edt_commentadd", sectorDetailData.get(0).getEdt_commentadd());
                jsonObject.put("edt_orientation", sectorDetailData.get(0).getEdt_orientation());
                jsonObject.put("flag", sectorDetailData.get(0).getFlag());
                // jsonObject.put("date", sectorDetailData.get(0).getDate());

                jsonObject.put("siteid", sharedPreferences.getString(AppConstants.SITEID));
                jsonObject.put("date", sharedPreferences.getString(AppConstants.DATE));
                jsonObject.put("empid", sharedPreferences.getString(AppConstants.EMPID));
                jsonObject.put("idall",sharedPreferences.getString(AppConstants.surveytpeandcustomerandoperator));



            }catch (Exception e){
                Log.e("Exception",e.toString());
            }
        }
        return jsonObject;
    }
    private void toSendDataRFSectorDetail1() {
        //  +"?Loginid="+empId+"&password="+empPassword+"&imeno="+"1234567890"
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        pDialog.show();
        Log.v("json rfsectordetail1", jsondataRFSectorDetail1().toString());
        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.RF_Sector_Detail, jsondataRFSectorDetail1(),
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponseRFSectorDetail1(response.toString());
                        Log.v("res rfsectordetail1", response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("error rfsectordetail1", error.toString());
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

    private void parseSettingResponseRFSectorDetail1(String s) {
        try {
            JSONArray jsonArray = new JSONArray(s);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String status = jsonObject.getString("Status");
            Toast.makeText(getActivity(), status + " RF SectorDetail1", Toast.LENGTH_LONG).show();
            tv_rfsectordetail_status.append("SectorDetail1:" + status + "\n");
            // String password = jsonObject.getString("password");
        } catch (Exception e) {
            tv_rfsectordetail_status.append("SectorDetail1 :" + e.getMessage() + "\n");
            e.printStackTrace();
        }
    }

    //.................................END RF SectorDetail1.......................

//.................................RF SectorDetail2.......................

    private JSONObject jsondataRFSectorDetail2(){
        JSONObject jsonObject = new JSONObject();
        List<RFSectorAntennaDetailData> sectorDetailData = db.getLast_RFSECTORDETAIL(SECTOR2);
        if(sectorDetailData.size()>0){
            Log.v("RFSectorDetailData2",sectorDetailData.toString());
            try {
                jsonObject.put("edt_Antenna_Type", sectorDetailData.get(0).getEdt_Antenna_Type());
                jsonObject.put("edt_2GBand", sectorDetailData.get(0).getEdt_2GBand());
                jsonObject.put("edt_2GCoverge", sectorDetailData.get(0).getEdt_2GCoverge());
                jsonObject.put("edt_2GObstruction", sectorDetailData.get(0).getEdt_2GObstruction());
                jsonObject.put("edt_2G_Existing_Antenna_Height", sectorDetailData.get(0).getEdt_2G_Existing_Antenna_Height());
                jsonObject.put("edt_2G_Antenna_Make_and_Model", sectorDetailData.get(0).getEdt_2G_Antenna_Makeedt_and_Model());
                jsonObject.put("edt_2G_Existing_Antenna_Direction", sectorDetailData.get(0).getEdt_2G_Existing_Antenna_Direction());
                jsonObject.put("edt_2G_Existing_antenna_tilt_Electrical", sectorDetailData.get(0).getEdt_2G_Existing_antenna_tilt_Electrical());
                jsonObject.put("edt_2G_Existing_antenna_tilt_Mechanical", sectorDetailData.get(0).getEdt_2G_Existing_antenna_tilt_Mechanical());
                jsonObject.put("edt_3GBand", sectorDetailData.get(0).getEdt_3GBand());
                jsonObject.put("edt_3GCoverge", sectorDetailData.get(0).getEdt_3GCoverge());
                jsonObject.put("edt_3GObstruction", sectorDetailData.get(0).getEdt_3GObstruction());
                jsonObject.put("edt_3G_Existing_Antenna_Ht", sectorDetailData.get(0).getEdt_3G_Existing_Antenna_Ht());
                jsonObject.put("edt_3G_Antenna_Make_and_Model", sectorDetailData.get(0).getEdt_3G_Antenna_Make_and_Model());
                jsonObject.put("edt_3G_Existing_Antenna_Direction", sectorDetailData.get(0).getEdt_3G_Existing_Antenna_Direction());
                jsonObject.put("edt_3G_Existing_antenna_Electrical_tilt", sectorDetailData.get(0).getEdt_3G_Existing_antenna_Electrical_tilt());
                jsonObject.put("edt_3G_Existing_antenna_Mechanical_tilt", sectorDetailData.get(0).getEdt_3G_Existing_antenna_Mechanical_tilt());
                jsonObject.put("edt_Space_Available_for_3G_Antenna", sectorDetailData.get(0).getEdt_Space_Available_for_3G_Antenna());
                jsonObject.put("edt_Addl_Poles_reqd_for_3G_Antenna", sectorDetailData.get(0).getEdt_Addl_Poles_req_for_3G_Antenna());
                jsonObject.put("edt_3GAntenna_Swap_Required", sectorDetailData.get(0).getEdt_3GAntenna_Swap_Required());
                jsonObject.put("edt_3GApproximate_Cable_Lenth", sectorDetailData.get(0).getEdt_3GApproximate_Cable_Lenth());
                jsonObject.put("edt_3GAntenna_Port_EmptyDamaged", sectorDetailData.get(0).getEdt_3GAntenna_Port_EmptyDamaged());
                jsonObject.put("edt_4GBand", sectorDetailData.get(0).getEdt_4GBand());
                jsonObject.put("edt_4GCoverge", sectorDetailData.get(0).getEdt_4GCoverge());
                jsonObject.put("edt_4GObstruction", sectorDetailData.get(0).getEdt_4GObstruction());
                jsonObject.put("edt_4G_Existing_Antenna_Ht", sectorDetailData.get(0).getEdt_4G_Existing_Antenna_Ht());
                jsonObject.put("edt_4G_Antenna_Make_and_Model", sectorDetailData.get(0).getEdt_4G_Antenna_Make_and_Model());
                jsonObject.put("edt_4G_Existing_Antenna_Direction", sectorDetailData.get(0).getEdt_4G_Existing_Antenna_Direction());
                jsonObject.put("edt_4G_Existing_antenna_Electrical_tilt", sectorDetailData.get(0).getEdt_4G_Existing_antenna_Electrical_tilt());
                jsonObject.put("edt_4G_Existing_antenna_Mechanical_tilt", sectorDetailData.get(0).getEdt_4G_Existing_antenna_Mechanical_tilt());
                jsonObject.put("edt_Space_Available_for_4G_Antenna", sectorDetailData.get(0).getEdt_Space_Available_for_4G_Antenna());
                jsonObject.put("edt_Addl_Poles_reqd_for_4G_Antenna", sectorDetailData.get(0).getEdt_Addl_Poles_reqd_for_4G_Antenna());
                jsonObject.put("edt_4GAntenna_Swap_Required", sectorDetailData.get(0).getEdt_4GAntenna_Swap_Required());
                jsonObject.put("edt_4GApproximate_Cable_Lenth", sectorDetailData.get(0).getEdt_3GApproximate_Cable_Lenth());
                jsonObject.put("edt_4GAntennaedt_Port_EmptyDamaged", sectorDetailData.get(0).getEdt_4GAntennaedt_Port_EmptyDamaged());

                //  jsonObject.put("img_Antenna_Type", sectorDetailData.get(0).getImg_Antenna_Type());
                if(!sectorDetailData.get(0).getImg_Antenna_Type().equals("")){
                    jsonObject.put("img_Antenna_Type", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_Antenna_Type()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_Antenna_Type",sectorDetailData.get(0).getImg_Antenna_Type() );
                }
                // jsonObject.put("img_2GBand", sectorDetailData.get(0).getImg_2GBand());
                if(!sectorDetailData.get(0).getImg_2GBand().equals("")){
                    jsonObject.put("img_2GBand", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_2GBand()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_2GBand",sectorDetailData.get(0).getImg_2GBand() );
                }
                // jsonObject.put("img_2GCoverge", sectorDetailData.get(0).getImg_2GCoverge());
                if(!sectorDetailData.get(0).getImg_2GCoverge().equals("")){
                    jsonObject.put("img_2GCoverge", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_2GCoverge()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_2GCoverge",sectorDetailData.get(0).getImg_2GCoverge() );
                }
                //  jsonObject.put("img_2GObstruction", sectorDetailData.get(0).getImg_2GObstruction());
                if(!sectorDetailData.get(0).getImg_2GObstruction().equals("")){
                    jsonObject.put("img_2GObstruction", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_2GObstruction()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_2GObstruction",sectorDetailData.get(0).getImg_2GObstruction() );
                }
                //  jsonObject.put("img_2G_Existing_Antenna_Height", sectorDetailData.get(0).getImg_2G_Existing_Antenna_Height());
                if(!sectorDetailData.get(0).getImg_2G_Existing_Antenna_Height().equals("")){
                    jsonObject.put("img_2G_Existing_Antenna_Height", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_2G_Existing_Antenna_Height()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_2G_Existing_Antenna_Height",sectorDetailData.get(0).getImg_2G_Existing_Antenna_Height() );
                }
                //  jsonObject.put("img_2G_Antenna_Make_and_Model", sectorDetailData.get(0).getImg_2G_Antenna_Make_and_Model());
                if(!sectorDetailData.get(0).getImg_2G_Antenna_Make_and_Model().equals("")){
                    jsonObject.put("img_2G_Antenna_Make_and_Model", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_2G_Antenna_Make_and_Model()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_2G_Antenna_Make_and_Model",sectorDetailData.get(0).getImg_2G_Antenna_Make_and_Model() );
                }
                //  jsonObject.put("img_2G_Existing_Antenna_Direction", sectorDetailData.get(0).getImg_2G_Existing_Antenna_Direction());
                if(!sectorDetailData.get(0).getImg_2G_Existing_Antenna_Direction().equals("")){
                    jsonObject.put("img_2G_Existing_Antenna_Direction", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_2G_Existing_Antenna_Direction()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_2G_Existing_Antenna_Direction",sectorDetailData.get(0).getImg_2G_Existing_Antenna_Direction() );
                }
                //  jsonObject.put("img_2G_Existing_antenna_tilt_Electrical", sectorDetailData.get(0).getImg_2G_Existing_antenna_tilt_Electrical());
                if(!sectorDetailData.get(0).getImg_2G_Existing_antenna_tilt_Electrical().equals("")){
                    jsonObject.put("img_2G_Existing_antenna_tilt_Electrical", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_2G_Existing_antenna_tilt_Electrical()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_2G_Existing_antenna_tilt_Electrical",sectorDetailData.get(0).getImg_2G_Existing_antenna_tilt_Electrical() );
                }
                //   jsonObject.put("img_2G_Existing_antenna_tilt_Mechanical", sectorDetailData.get(0).getImg_2G_Existing_antenna_tilt_Mechanical());
                if(!sectorDetailData.get(0).getImg_2G_Existing_antenna_tilt_Mechanical().equals("")){
                    jsonObject.put("img_2G_Existing_antenna_tilt_Mechanical", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_2G_Existing_antenna_tilt_Mechanical()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_2G_Existing_antenna_tilt_Mechanical",sectorDetailData.get(0).getImg_2G_Existing_antenna_tilt_Mechanical() );
                }
                //   jsonObject.put("img_3GBand", sectorDetailData.get(0).getImg_3GBand());
                if(!sectorDetailData.get(0).getImg_3GBand().equals("")){
                    jsonObject.put("img_3GBand", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3GBand()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_3GBand",sectorDetailData.get(0).getImg_3GBand() );
                }
                //   jsonObject.put("img_3GCoverge", sectorDetailData.get(0).getImg_3GCoverge());
                if(!sectorDetailData.get(0).getImg_3GCoverge().equals("")){
                    jsonObject.put("img_3GCoverge", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3GCoverge()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_3GCoverge",sectorDetailData.get(0).getImg_3GCoverge() );
                }
                //   jsonObject.put("img_3GObstruction", sectorDetailData.get(0).getImg_3GObstruction());
                if(!sectorDetailData.get(0).getImg_3GObstruction().equals("")){
                    jsonObject.put("img_3GObstruction", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3GObstruction()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_3GObstruction",sectorDetailData.get(0).getImg_3GObstruction() );
                }
                //   jsonObject.put("img_3G_Existing_Antenna_Ht", sectorDetailData.get(0).getImg_3G_Existing_Antenna_Ht());
                if(!sectorDetailData.get(0).getImg_3G_Existing_Antenna_Ht().equals("")){
                    jsonObject.put("img_3G_Existing_Antenna_Ht", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3G_Existing_Antenna_Ht()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_3G_Existing_Antenna_Ht",sectorDetailData.get(0).getImg_3G_Existing_Antenna_Ht() );
                }
                //    jsonObject.put("img_3G_Antenna_Make_and_Model", sectorDetailData.get(0).getImg_3G_Antenna_Make_and_Model());
                if(!sectorDetailData.get(0).getImg_3G_Antenna_Make_and_Model().equals("")){
                    jsonObject.put("img_3G_Antenna_Make_and_Model", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3G_Antenna_Make_and_Model()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_3G_Antenna_Make_and_Model",sectorDetailData.get(0).getImg_3G_Antenna_Make_and_Model() );
                }
                //   jsonObject.put("img_3G_Existing_Antenna_Direction", sectorDetailData.get(0).getImg_3G_Existing_Antenna_Direction());
                if(!sectorDetailData.get(0).getImg_3G_Existing_Antenna_Direction().equals("")){
                    jsonObject.put("img_3G_Existing_Antenna_Direction", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3G_Existing_Antenna_Direction()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_3G_Existing_Antenna_Direction",sectorDetailData.get(0).getImg_3G_Existing_Antenna_Direction() );
                }
                //    jsonObject.put("img_3G_Existing_antenna_Electrical_tilt", sectorDetailData.get(0).getImg_3G_Existing_antenna_Electrical_tilt());
                if(!sectorDetailData.get(0).getImg_3G_Existing_antenna_Electrical_tilt().equals("")){
                    jsonObject.put("img_3G_Existing_antenna_Electrical_tilt", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3G_Existing_antenna_Electrical_tilt()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_3G_Existing_antenna_Electrical_tilt",sectorDetailData.get(0).getImg_3G_Existing_antenna_Electrical_tilt() );
                }
                //    jsonObject.put("img_3G_Existing_antenna_Mechanical_tilt", sectorDetailData.get(0).getImg_3G_Existing_antenna_Mechanical_tilt());
                if(!sectorDetailData.get(0).getImg_3G_Existing_antenna_Mechanical_tilt().equals("")){
                    jsonObject.put("img_3G_Existing_antenna_Mechanical_tilt", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3G_Existing_antenna_Mechanical_tilt()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_3G_Existing_antenna_Mechanical_tilt",sectorDetailData.get(0).getImg_3G_Existing_antenna_Mechanical_tilt() );
                }
                //     jsonObject.put("img_Space_Available_for_3G_Antenna", sectorDetailData.get(0).getImg_Space_Available_for_3G_Antenna());
                if(!sectorDetailData.get(0).getImg_Space_Available_for_3G_Antenna().equals("")){
                    jsonObject.put("img_Space_Available_for_3G_Antenna", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_Space_Available_for_3G_Antenna()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_Space_Available_for_3G_Antenna",sectorDetailData.get(0).getImg_Space_Available_for_3G_Antenna() );
                }
                //  jsonObject.put("img_Addl_Poles_req_for_3G_Antenna", sectorDetailData.get(0).getImg_Addl_Poles_reqd_for_3G_Antenna());
                if(!sectorDetailData.get(0).getImg_Addl_Poles_reqd_for_3G_Antenna().equals("")){
                    jsonObject.put("img_Addl_Poles_req_for_3G_Antenna", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_Addl_Poles_reqd_for_3G_Antenna()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_Addl_Poles_req_for_3G_Antenna", sectorDetailData.get(0).getImg_Addl_Poles_reqd_for_3G_Antenna());
                }
                //   jsonObject.put("img_3GAntenna_Swap_Required", sectorDetailData.get(0).getImg_3GAntenna_Swap_Required());
                if(!sectorDetailData.get(0).getImg_3GAntenna_Swap_Required().equals("")){
                    jsonObject.put("img_3GAntenna_Swap_Required", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3GAntenna_Swap_Required()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_3GAntenna_Swap_Required", sectorDetailData.get(0).getImg_3GAntenna_Swap_Required());
                }
                //   jsonObject.put("img_3GApproximate_Cable_Lenth", sectorDetailData.get(0).getImg_3GApproximate_Cable_Lenth());
                if(!sectorDetailData.get(0).getImg_3GApproximate_Cable_Lenth().equals("")){
                    jsonObject.put("img_3GApproximate_Cable_Lenth", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3GApproximate_Cable_Lenth()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_3GApproximate_Cable_Lenth", sectorDetailData.get(0).getImg_3GApproximate_Cable_Lenth());
                }
                //   jsonObject.put("img_3GAntenna_Port_EmptyDamaged", sectorDetailData.get(0).getImg_3GAntenna_Port_EmptyDamaged());
                if(!sectorDetailData.get(0).getImg_3GAntenna_Port_EmptyDamaged().equals("")){
                    jsonObject.put("img_3GAntenna_Port_EmptyDamaged", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3GAntenna_Port_EmptyDamaged()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_3GAntenna_Port_EmptyDamaged", sectorDetailData.get(0).getImg_3GAntenna_Port_EmptyDamaged());
                }
                //    jsonObject.put("img_4GBand", sectorDetailData.get(0).getImg_4GBand());
                if(!sectorDetailData.get(0).getImg_4GBand().equals("")){
                    jsonObject.put("img_4GBand", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_4GBand()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_4GBand", sectorDetailData.get(0).getImg_4GBand());
                }
                //      jsonObject.put("img_4GCoverge", sectorDetailData.get(0).getImg_4GCoverge());
                if(!sectorDetailData.get(0).getImg_4GCoverge().equals("")){
                    jsonObject.put("img_4GCoverge", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_4GCoverge()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_4GCoverge", sectorDetailData.get(0).getImg_4GCoverge());
                }
                //      jsonObject.put("img_4GObstruction", sectorDetailData.get(0).getImg_4GObstruction());
                if(!sectorDetailData.get(0).getImg_4GObstruction().equals("")){
                    jsonObject.put("img_4GObstruction", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_4GObstruction()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_4GObstruction", sectorDetailData.get(0).getImg_4GObstruction());
                }
                //     jsonObject.put("img_4G_Existing_Antenna_Ht", sectorDetailData.get(0).getImg_4G_Existing_Antenna_Ht());
                if(!sectorDetailData.get(0).getImg_4G_Existing_Antenna_Ht().equals("")){
                    jsonObject.put("img_4G_Existing_Antenna_Ht", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_4G_Existing_Antenna_Ht()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_4G_Existing_Antenna_Ht", sectorDetailData.get(0).getImg_4G_Existing_Antenna_Ht());
                }
                //     jsonObject.put("img_4G_Antenna_Make_and_Model", sectorDetailData.get(0).getImg_4G_Antenna_Make_and_Model());
                if(!sectorDetailData.get(0).getImg_4G_Antenna_Make_and_Model().equals("")){
                    jsonObject.put("img_4G_Antenna_Make_and_Model", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_4G_Antenna_Make_and_Model()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_4G_Antenna_Make_and_Model", sectorDetailData.get(0).getImg_4G_Antenna_Make_and_Model());
                }
                //     jsonObject.put("img_4G_Existing_Antenna_Direction", sectorDetailData.get(0).getImg_4G_Existing_Antenna_Direction());
                if(!sectorDetailData.get(0).getImg_4G_Existing_Antenna_Direction().equals("")){
                    jsonObject.put("img_4G_Existing_Antenna_Direction", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_4G_Existing_Antenna_Direction()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_4G_Existing_Antenna_Direction", sectorDetailData.get(0).getImg_4G_Existing_Antenna_Direction());
                }
                //     jsonObject.put("img_4G_Existing_antenna_Electrical_tilt", sectorDetailData.get(0).getImg_4G_Existing_antenna_Electrical_tilt());
                if(!sectorDetailData.get(0).getImg_4G_Existing_antenna_Electrical_tilt().equals("")){
                    jsonObject.put("img_4G_Existing_antenna_Electrical_tilt", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_4G_Existing_antenna_Electrical_tilt()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_4G_Existing_antenna_Electrical_tilt", sectorDetailData.get(0).getImg_4G_Existing_antenna_Electrical_tilt());
                }
                //    jsonObject.put("img_4G_Existing_antenna_Mechanical_tilt", sectorDetailData.get(0).getImg_4G_Existing_antenna_Mechanical_tilt());
                if(!sectorDetailData.get(0).getImg_4G_Existing_antenna_Mechanical_tilt().equals("")){
                    jsonObject.put("img_4G_Existing_antenna_Mechanical_tilt", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_4G_Existing_antenna_Mechanical_tilt()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_4G_Existing_antenna_Mechanical_tilt", sectorDetailData.get(0).getImg_4G_Existing_antenna_Mechanical_tilt());
                }
                //      jsonObject.put("img_Space_Available_for_4G_Antenna", sectorDetailData.get(0).getImg_Space_Available_for_4G_Antenna());
                if(!sectorDetailData.get(0).getImg_Space_Available_for_4G_Antenna().equals("")){
                    jsonObject.put("img_Space_Available_for_4G_Antenna", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_Space_Available_for_4G_Antenna()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_Space_Available_for_4G_Antenna", sectorDetailData.get(0).getImg_Space_Available_for_4G_Antenna());
                }
                //    jsonObject.put("img_Addl_Poles_reqd_for_4G_Antenna", sectorDetailData.get(0).getImg_Addl_Poles_reqd_for_4G_Antenna());
                if(!sectorDetailData.get(0).getImg_Addl_Poles_reqd_for_4G_Antenna().equals("")){
                    jsonObject.put("img_Addl_Poles_reqd_for_4G_Antenna", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_Addl_Poles_reqd_for_4G_Antenna()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_Addl_Poles_reqd_for_4G_Antenna", sectorDetailData.get(0).getImg_Addl_Poles_reqd_for_4G_Antenna());
                }
                //      jsonObject.put("img_4GAntenna_Swap_Required", sectorDetailData.get(0).getImg_4GAntenna_Swap_Required());
                if(!sectorDetailData.get(0).getImg_4GAntenna_Swap_Required().equals("")){
                    jsonObject.put("img_4GAntenna_Swap_Required", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_4GAntenna_Swap_Required()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_4GAntenna_Swap_Required", sectorDetailData.get(0).getImg_4GAntenna_Swap_Required());
                }
                //    jsonObject.put("img_4GApproximate_Cable_Lenth", sectorDetailData.get(0).getImg_3GApproximate_Cable_Lenth());
                if(!sectorDetailData.get(0).getImg_3GApproximate_Cable_Lenth().equals("")){
                    jsonObject.put("img_4GApproximate_Cable_Lenth", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3GApproximate_Cable_Lenth()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_4GApproximate_Cable_Lenth", sectorDetailData.get(0).getImg_3GApproximate_Cable_Lenth());
                }
                //       jsonObject.put("img_4GAntenna_Port_EmptyDamaged", sectorDetailData.get(0).getImg_4GAntenna_Port_EmptyDamaged());
                if(!sectorDetailData.get(0).getImg_4GAntenna_Port_EmptyDamaged().equals("")){
                    jsonObject.put("img_4GAntenna_Port_EmptyDamaged", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_4GAntenna_Port_EmptyDamaged()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_4GAntenna_Port_EmptyDamaged", sectorDetailData.get(0).getImg_4GAntenna_Port_EmptyDamaged());
                }

                jsonObject.put("rf_sectorDetail_name", sectorDetailData.get(0).getRf_sectorDetail_name());
                jsonObject.put("edt_commentadd", sectorDetailData.get(0).getEdt_commentadd());
                jsonObject.put("edt_orientation", sectorDetailData.get(0).getEdt_orientation());
                jsonObject.put("flag", sectorDetailData.get(0).getFlag());
                // jsonObject.put("date", sectorDetailData.get(0).getDate());

                jsonObject.put("siteid", sharedPreferences.getString(AppConstants.SITEID));
                jsonObject.put("date", sharedPreferences.getString(AppConstants.DATE));
                jsonObject.put("empid", sharedPreferences.getString(AppConstants.EMPID));
                jsonObject.put("idall",sharedPreferences.getString(AppConstants.surveytpeandcustomerandoperator));



            }catch (Exception e){
                Log.e("Exception",e.toString());
            }
        }
        return jsonObject;
    }
    private void toSendDataRFSectorDetail2() {
        //  +"?Loginid="+empId+"&password="+empPassword+"&imeno="+"2234567890"
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        pDialog.show();
        Log.v("json rfsectordetail2", jsondataRFSectorDetail2().toString());
        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.RF_Sector_Detail, jsondataRFSectorDetail2(),
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponseRFSectorDetail2(response.toString());
                        Log.v("res rfsectordetail2", response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("error rfsectordetail2", error.toString());
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

    private void parseSettingResponseRFSectorDetail2(String s) {
        try {
            JSONArray jsonArray = new JSONArray(s);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String status = jsonObject.getString("Status");
            Toast.makeText(getActivity(), status + " RF SectorDetail2", Toast.LENGTH_LONG).show();
            tv_rfsectordetail_status.append("SectorDetail2:" + status + "\n");
            // String password = jsonObject.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
            tv_rfsectordetail_status.append("SectorDetail2:" + e.getMessage() + "\n");
        }
    }

//.................................RF SectorDetail3.......................
    private JSONObject jsondataRFSectorDetail3(){
        JSONObject jsonObject = new JSONObject();
        List<RFSectorAntennaDetailData> sectorDetailData = db.getLast_RFSECTORDETAIL(SECTOR3);
        if(sectorDetailData.size()>0){
            Log.v("RFSectorDetailData3",sectorDetailData.toString());
            try {
                jsonObject.put("edt_Antenna_Type", sectorDetailData.get(0).getEdt_Antenna_Type());
                jsonObject.put("edt_2GBand", sectorDetailData.get(0).getEdt_2GBand());
                jsonObject.put("edt_2GCoverge", sectorDetailData.get(0).getEdt_2GCoverge());
                jsonObject.put("edt_2GObstruction", sectorDetailData.get(0).getEdt_2GObstruction());
                jsonObject.put("edt_2G_Existing_Antenna_Height", sectorDetailData.get(0).getEdt_2G_Existing_Antenna_Height());
                jsonObject.put("edt_2G_Antenna_Make_and_Model", sectorDetailData.get(0).getEdt_2G_Antenna_Makeedt_and_Model());
                jsonObject.put("edt_2G_Existing_Antenna_Direction", sectorDetailData.get(0).getEdt_2G_Existing_Antenna_Direction());
                jsonObject.put("edt_2G_Existing_antenna_tilt_Electrical", sectorDetailData.get(0).getEdt_2G_Existing_antenna_tilt_Electrical());
                jsonObject.put("edt_2G_Existing_antenna_tilt_Mechanical", sectorDetailData.get(0).getEdt_2G_Existing_antenna_tilt_Mechanical());
                jsonObject.put("edt_3GBand", sectorDetailData.get(0).getEdt_3GBand());
                jsonObject.put("edt_3GCoverge", sectorDetailData.get(0).getEdt_3GCoverge());
                jsonObject.put("edt_3GObstruction", sectorDetailData.get(0).getEdt_3GObstruction());
                jsonObject.put("edt_3G_Existing_Antenna_Ht", sectorDetailData.get(0).getEdt_3G_Existing_Antenna_Ht());
                jsonObject.put("edt_3G_Antenna_Make_and_Model", sectorDetailData.get(0).getEdt_3G_Antenna_Make_and_Model());
                jsonObject.put("edt_3G_Existing_Antenna_Direction", sectorDetailData.get(0).getEdt_3G_Existing_Antenna_Direction());
                jsonObject.put("edt_3G_Existing_antenna_Electrical_tilt", sectorDetailData.get(0).getEdt_3G_Existing_antenna_Electrical_tilt());
                jsonObject.put("edt_3G_Existing_antenna_Mechanical_tilt", sectorDetailData.get(0).getEdt_3G_Existing_antenna_Mechanical_tilt());
                jsonObject.put("edt_Space_Available_for_3G_Antenna", sectorDetailData.get(0).getEdt_Space_Available_for_3G_Antenna());
                jsonObject.put("edt_Addl_Poles_reqd_for_3G_Antenna", sectorDetailData.get(0).getEdt_Addl_Poles_req_for_3G_Antenna());
                jsonObject.put("edt_3GAntenna_Swap_Required", sectorDetailData.get(0).getEdt_3GAntenna_Swap_Required());
                jsonObject.put("edt_3GApproximate_Cable_Lenth", sectorDetailData.get(0).getEdt_3GApproximate_Cable_Lenth());
                jsonObject.put("edt_3GAntenna_Port_EmptyDamaged", sectorDetailData.get(0).getEdt_3GAntenna_Port_EmptyDamaged());
                jsonObject.put("edt_4GBand", sectorDetailData.get(0).getEdt_4GBand());
                jsonObject.put("edt_4GCoverge", sectorDetailData.get(0).getEdt_4GCoverge());
                jsonObject.put("edt_4GObstruction", sectorDetailData.get(0).getEdt_4GObstruction());
                jsonObject.put("edt_4G_Existing_Antenna_Ht", sectorDetailData.get(0).getEdt_4G_Existing_Antenna_Ht());
                jsonObject.put("edt_4G_Antenna_Make_and_Model", sectorDetailData.get(0).getEdt_4G_Antenna_Make_and_Model());
                jsonObject.put("edt_4G_Existing_Antenna_Direction", sectorDetailData.get(0).getEdt_4G_Existing_Antenna_Direction());
                jsonObject.put("edt_4G_Existing_antenna_Electrical_tilt", sectorDetailData.get(0).getEdt_4G_Existing_antenna_Electrical_tilt());
                jsonObject.put("edt_4G_Existing_antenna_Mechanical_tilt", sectorDetailData.get(0).getEdt_4G_Existing_antenna_Mechanical_tilt());
                jsonObject.put("edt_Space_Available_for_4G_Antenna", sectorDetailData.get(0).getEdt_Space_Available_for_4G_Antenna());
                jsonObject.put("edt_Addl_Poles_reqd_for_4G_Antenna", sectorDetailData.get(0).getEdt_Addl_Poles_reqd_for_4G_Antenna());
                jsonObject.put("edt_4GAntenna_Swap_Required", sectorDetailData.get(0).getEdt_4GAntenna_Swap_Required());
                jsonObject.put("edt_4GApproximate_Cable_Lenth", sectorDetailData.get(0).getEdt_3GApproximate_Cable_Lenth());
                jsonObject.put("edt_4GAntennaedt_Port_EmptyDamaged", sectorDetailData.get(0).getEdt_4GAntennaedt_Port_EmptyDamaged());

                //  jsonObject.put("img_Antenna_Type", sectorDetailData.get(0).getImg_Antenna_Type());
                if(!sectorDetailData.get(0).getImg_Antenna_Type().equals("")){
                    jsonObject.put("img_Antenna_Type", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_Antenna_Type()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_Antenna_Type",sectorDetailData.get(0).getImg_Antenna_Type() );
                }
                // jsonObject.put("img_2GBand", sectorDetailData.get(0).getImg_2GBand());
                if(!sectorDetailData.get(0).getImg_2GBand().equals("")){
                    jsonObject.put("img_2GBand", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_2GBand()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_2GBand",sectorDetailData.get(0).getImg_2GBand() );
                }
                // jsonObject.put("img_2GCoverge", sectorDetailData.get(0).getImg_2GCoverge());
                if(!sectorDetailData.get(0).getImg_2GCoverge().equals("")){
                    jsonObject.put("img_2GCoverge", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_2GCoverge()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_2GCoverge",sectorDetailData.get(0).getImg_2GCoverge() );
                }
                //  jsonObject.put("img_2GObstruction", sectorDetailData.get(0).getImg_2GObstruction());
                if(!sectorDetailData.get(0).getImg_2GObstruction().equals("")){
                    jsonObject.put("img_2GObstruction", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_2GObstruction()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_2GObstruction",sectorDetailData.get(0).getImg_2GObstruction() );
                }
                //  jsonObject.put("img_2G_Existing_Antenna_Height", sectorDetailData.get(0).getImg_2G_Existing_Antenna_Height());
                if(!sectorDetailData.get(0).getImg_2G_Existing_Antenna_Height().equals("")){
                    jsonObject.put("img_2G_Existing_Antenna_Height", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_2G_Existing_Antenna_Height()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_2G_Existing_Antenna_Height",sectorDetailData.get(0).getImg_2G_Existing_Antenna_Height() );
                }
                //  jsonObject.put("img_2G_Antenna_Make_and_Model", sectorDetailData.get(0).getImg_2G_Antenna_Make_and_Model());
                if(!sectorDetailData.get(0).getImg_2G_Antenna_Make_and_Model().equals("")){
                    jsonObject.put("img_2G_Antenna_Make_and_Model", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_2G_Antenna_Make_and_Model()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_2G_Antenna_Make_and_Model",sectorDetailData.get(0).getImg_2G_Antenna_Make_and_Model() );
                }
                //  jsonObject.put("img_2G_Existing_Antenna_Direction", sectorDetailData.get(0).getImg_2G_Existing_Antenna_Direction());
                if(!sectorDetailData.get(0).getImg_2G_Existing_Antenna_Direction().equals("")){
                    jsonObject.put("img_2G_Existing_Antenna_Direction", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_2G_Existing_Antenna_Direction()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_2G_Existing_Antenna_Direction",sectorDetailData.get(0).getImg_2G_Existing_Antenna_Direction() );
                }
                //  jsonObject.put("img_2G_Existing_antenna_tilt_Electrical", sectorDetailData.get(0).getImg_2G_Existing_antenna_tilt_Electrical());
                if(!sectorDetailData.get(0).getImg_2G_Existing_antenna_tilt_Electrical().equals("")){
                    jsonObject.put("img_2G_Existing_antenna_tilt_Electrical", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_2G_Existing_antenna_tilt_Electrical()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_2G_Existing_antenna_tilt_Electrical",sectorDetailData.get(0).getImg_2G_Existing_antenna_tilt_Electrical() );
                }
                //   jsonObject.put("img_2G_Existing_antenna_tilt_Mechanical", sectorDetailData.get(0).getImg_2G_Existing_antenna_tilt_Mechanical());
                if(!sectorDetailData.get(0).getImg_2G_Existing_antenna_tilt_Mechanical().equals("")){
                    jsonObject.put("img_2G_Existing_antenna_tilt_Mechanical", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_2G_Existing_antenna_tilt_Mechanical()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_2G_Existing_antenna_tilt_Mechanical",sectorDetailData.get(0).getImg_2G_Existing_antenna_tilt_Mechanical() );
                }
                //   jsonObject.put("img_3GBand", sectorDetailData.get(0).getImg_3GBand());
                if(!sectorDetailData.get(0).getImg_3GBand().equals("")){
                    jsonObject.put("img_3GBand", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3GBand()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_3GBand",sectorDetailData.get(0).getImg_3GBand() );
                }
                //   jsonObject.put("img_3GCoverge", sectorDetailData.get(0).getImg_3GCoverge());
                if(!sectorDetailData.get(0).getImg_3GCoverge().equals("")){
                    jsonObject.put("img_3GCoverge", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3GCoverge()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_3GCoverge",sectorDetailData.get(0).getImg_3GCoverge() );
                }
                //   jsonObject.put("img_3GObstruction", sectorDetailData.get(0).getImg_3GObstruction());
                if(!sectorDetailData.get(0).getImg_3GObstruction().equals("")){
                    jsonObject.put("img_3GObstruction", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3GObstruction()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_3GObstruction",sectorDetailData.get(0).getImg_3GObstruction() );
                }
                //   jsonObject.put("img_3G_Existing_Antenna_Ht", sectorDetailData.get(0).getImg_3G_Existing_Antenna_Ht());
                if(!sectorDetailData.get(0).getImg_3G_Existing_Antenna_Ht().equals("")){
                    jsonObject.put("img_3G_Existing_Antenna_Ht", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3G_Existing_Antenna_Ht()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_3G_Existing_Antenna_Ht",sectorDetailData.get(0).getImg_3G_Existing_Antenna_Ht() );
                }
                //    jsonObject.put("img_3G_Antenna_Make_and_Model", sectorDetailData.get(0).getImg_3G_Antenna_Make_and_Model());
                if(!sectorDetailData.get(0).getImg_3G_Antenna_Make_and_Model().equals("")){
                    jsonObject.put("img_3G_Antenna_Make_and_Model", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3G_Antenna_Make_and_Model()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_3G_Antenna_Make_and_Model",sectorDetailData.get(0).getImg_3G_Antenna_Make_and_Model() );
                }
                //   jsonObject.put("img_3G_Existing_Antenna_Direction", sectorDetailData.get(0).getImg_3G_Existing_Antenna_Direction());
                if(!sectorDetailData.get(0).getImg_3G_Existing_Antenna_Direction().equals("")){
                    jsonObject.put("img_3G_Existing_Antenna_Direction", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3G_Existing_Antenna_Direction()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_3G_Existing_Antenna_Direction",sectorDetailData.get(0).getImg_3G_Existing_Antenna_Direction() );
                }
                //    jsonObject.put("img_3G_Existing_antenna_Electrical_tilt", sectorDetailData.get(0).getImg_3G_Existing_antenna_Electrical_tilt());
                if(!sectorDetailData.get(0).getImg_3G_Existing_antenna_Electrical_tilt().equals("")){
                    jsonObject.put("img_3G_Existing_antenna_Electrical_tilt", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3G_Existing_antenna_Electrical_tilt()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_3G_Existing_antenna_Electrical_tilt",sectorDetailData.get(0).getImg_3G_Existing_antenna_Electrical_tilt() );
                }
                //    jsonObject.put("img_3G_Existing_antenna_Mechanical_tilt", sectorDetailData.get(0).getImg_3G_Existing_antenna_Mechanical_tilt());
                if(!sectorDetailData.get(0).getImg_3G_Existing_antenna_Mechanical_tilt().equals("")){
                    jsonObject.put("img_3G_Existing_antenna_Mechanical_tilt", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3G_Existing_antenna_Mechanical_tilt()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_3G_Existing_antenna_Mechanical_tilt",sectorDetailData.get(0).getImg_3G_Existing_antenna_Mechanical_tilt() );
                }
                //     jsonObject.put("img_Space_Available_for_3G_Antenna", sectorDetailData.get(0).getImg_Space_Available_for_3G_Antenna());
                if(!sectorDetailData.get(0).getImg_Space_Available_for_3G_Antenna().equals("")){
                    jsonObject.put("img_Space_Available_for_3G_Antenna", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_Space_Available_for_3G_Antenna()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_Space_Available_for_3G_Antenna",sectorDetailData.get(0).getImg_Space_Available_for_3G_Antenna() );
                }
                //  jsonObject.put("img_Addl_Poles_req_for_3G_Antenna", sectorDetailData.get(0).getImg_Addl_Poles_reqd_for_3G_Antenna());
                if(!sectorDetailData.get(0).getImg_Addl_Poles_reqd_for_3G_Antenna().equals("")){
                    jsonObject.put("img_Addl_Poles_req_for_3G_Antenna", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_Addl_Poles_reqd_for_3G_Antenna()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_Addl_Poles_req_for_3G_Antenna", sectorDetailData.get(0).getImg_Addl_Poles_reqd_for_3G_Antenna());
                }
                //   jsonObject.put("img_3GAntenna_Swap_Required", sectorDetailData.get(0).getImg_3GAntenna_Swap_Required());
                if(!sectorDetailData.get(0).getImg_3GAntenna_Swap_Required().equals("")){
                    jsonObject.put("img_3GAntenna_Swap_Required", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3GAntenna_Swap_Required()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_3GAntenna_Swap_Required", sectorDetailData.get(0).getImg_3GAntenna_Swap_Required());
                }
                //   jsonObject.put("img_3GApproximate_Cable_Lenth", sectorDetailData.get(0).getImg_3GApproximate_Cable_Lenth());
                if(!sectorDetailData.get(0).getImg_3GApproximate_Cable_Lenth().equals("")){
                    jsonObject.put("img_3GApproximate_Cable_Lenth", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3GApproximate_Cable_Lenth()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_3GApproximate_Cable_Lenth", sectorDetailData.get(0).getImg_3GApproximate_Cable_Lenth());
                }
                //   jsonObject.put("img_3GAntenna_Port_EmptyDamaged", sectorDetailData.get(0).getImg_3GAntenna_Port_EmptyDamaged());
                if(!sectorDetailData.get(0).getImg_3GAntenna_Port_EmptyDamaged().equals("")){
                    jsonObject.put("img_3GAntenna_Port_EmptyDamaged", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3GAntenna_Port_EmptyDamaged()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_3GAntenna_Port_EmptyDamaged", sectorDetailData.get(0).getImg_3GAntenna_Port_EmptyDamaged());
                }
                //    jsonObject.put("img_4GBand", sectorDetailData.get(0).getImg_4GBand());
                if(!sectorDetailData.get(0).getImg_4GBand().equals("")){
                    jsonObject.put("img_4GBand", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_4GBand()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_4GBand", sectorDetailData.get(0).getImg_4GBand());
                }
                //      jsonObject.put("img_4GCoverge", sectorDetailData.get(0).getImg_4GCoverge());
                if(!sectorDetailData.get(0).getImg_4GCoverge().equals("")){
                    jsonObject.put("img_4GCoverge", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_4GCoverge()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_4GCoverge", sectorDetailData.get(0).getImg_4GCoverge());
                }
                //      jsonObject.put("img_4GObstruction", sectorDetailData.get(0).getImg_4GObstruction());
                if(!sectorDetailData.get(0).getImg_4GObstruction().equals("")){
                    jsonObject.put("img_4GObstruction", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_4GObstruction()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_4GObstruction", sectorDetailData.get(0).getImg_4GObstruction());
                }
                //     jsonObject.put("img_4G_Existing_Antenna_Ht", sectorDetailData.get(0).getImg_4G_Existing_Antenna_Ht());
                if(!sectorDetailData.get(0).getImg_4G_Existing_Antenna_Ht().equals("")){
                    jsonObject.put("img_4G_Existing_Antenna_Ht", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_4G_Existing_Antenna_Ht()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_4G_Existing_Antenna_Ht", sectorDetailData.get(0).getImg_4G_Existing_Antenna_Ht());
                }
                //     jsonObject.put("img_4G_Antenna_Make_and_Model", sectorDetailData.get(0).getImg_4G_Antenna_Make_and_Model());
                if(!sectorDetailData.get(0).getImg_4G_Antenna_Make_and_Model().equals("")){
                    jsonObject.put("img_4G_Antenna_Make_and_Model", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_4G_Antenna_Make_and_Model()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_4G_Antenna_Make_and_Model", sectorDetailData.get(0).getImg_4G_Antenna_Make_and_Model());
                }
                //     jsonObject.put("img_4G_Existing_Antenna_Direction", sectorDetailData.get(0).getImg_4G_Existing_Antenna_Direction());
                if(!sectorDetailData.get(0).getImg_4G_Existing_Antenna_Direction().equals("")){
                    jsonObject.put("img_4G_Existing_Antenna_Direction", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_4G_Existing_Antenna_Direction()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_4G_Existing_Antenna_Direction", sectorDetailData.get(0).getImg_4G_Existing_Antenna_Direction());
                }
                //     jsonObject.put("img_4G_Existing_antenna_Electrical_tilt", sectorDetailData.get(0).getImg_4G_Existing_antenna_Electrical_tilt());
                if(!sectorDetailData.get(0).getImg_4G_Existing_antenna_Electrical_tilt().equals("")){
                    jsonObject.put("img_4G_Existing_antenna_Electrical_tilt", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_4G_Existing_antenna_Electrical_tilt()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_4G_Existing_antenna_Electrical_tilt", sectorDetailData.get(0).getImg_4G_Existing_antenna_Electrical_tilt());
                }
                //    jsonObject.put("img_4G_Existing_antenna_Mechanical_tilt", sectorDetailData.get(0).getImg_4G_Existing_antenna_Mechanical_tilt());
                if(!sectorDetailData.get(0).getImg_4G_Existing_antenna_Mechanical_tilt().equals("")){
                    jsonObject.put("img_4G_Existing_antenna_Mechanical_tilt", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_4G_Existing_antenna_Mechanical_tilt()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_4G_Existing_antenna_Mechanical_tilt", sectorDetailData.get(0).getImg_4G_Existing_antenna_Mechanical_tilt());
                }
                //      jsonObject.put("img_Space_Available_for_4G_Antenna", sectorDetailData.get(0).getImg_Space_Available_for_4G_Antenna());
                if(!sectorDetailData.get(0).getImg_Space_Available_for_4G_Antenna().equals("")){
                    jsonObject.put("img_Space_Available_for_4G_Antenna", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_Space_Available_for_4G_Antenna()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_Space_Available_for_4G_Antenna", sectorDetailData.get(0).getImg_Space_Available_for_4G_Antenna());
                }
                //    jsonObject.put("img_Addl_Poles_reqd_for_4G_Antenna", sectorDetailData.get(0).getImg_Addl_Poles_reqd_for_4G_Antenna());
                if(!sectorDetailData.get(0).getImg_Addl_Poles_reqd_for_4G_Antenna().equals("")){
                    jsonObject.put("img_Addl_Poles_reqd_for_4G_Antenna", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_Addl_Poles_reqd_for_4G_Antenna()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_Addl_Poles_reqd_for_4G_Antenna", sectorDetailData.get(0).getImg_Addl_Poles_reqd_for_4G_Antenna());
                }
                //      jsonObject.put("img_4GAntenna_Swap_Required", sectorDetailData.get(0).getImg_4GAntenna_Swap_Required());
                if(!sectorDetailData.get(0).getImg_4GAntenna_Swap_Required().equals("")){
                    jsonObject.put("img_4GAntenna_Swap_Required", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_4GAntenna_Swap_Required()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_4GAntenna_Swap_Required", sectorDetailData.get(0).getImg_4GAntenna_Swap_Required());
                }
                //    jsonObject.put("img_4GApproximate_Cable_Lenth", sectorDetailData.get(0).getImg_3GApproximate_Cable_Lenth());
                if(!sectorDetailData.get(0).getImg_3GApproximate_Cable_Lenth().equals("")){
                    jsonObject.put("img_4GApproximate_Cable_Lenth", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3GApproximate_Cable_Lenth()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_4GApproximate_Cable_Lenth", sectorDetailData.get(0).getImg_3GApproximate_Cable_Lenth());
                }
                //       jsonObject.put("img_4GAntenna_Port_EmptyDamaged", sectorDetailData.get(0).getImg_4GAntenna_Port_EmptyDamaged());
                if(!sectorDetailData.get(0).getImg_4GAntenna_Port_EmptyDamaged().equals("")){
                    jsonObject.put("img_4GAntenna_Port_EmptyDamaged", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_4GAntenna_Port_EmptyDamaged()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_4GAntenna_Port_EmptyDamaged", sectorDetailData.get(0).getImg_4GAntenna_Port_EmptyDamaged());
                }

                jsonObject.put("rf_sectorDetail_name", sectorDetailData.get(0).getRf_sectorDetail_name());
                jsonObject.put("edt_commentadd", sectorDetailData.get(0).getEdt_commentadd());
                jsonObject.put("edt_orientation", sectorDetailData.get(0).getEdt_orientation());
                jsonObject.put("flag", sectorDetailData.get(0).getFlag());
                // jsonObject.put("date", sectorDetailData.get(0).getDate());

                jsonObject.put("siteid", sharedPreferences.getString(AppConstants.SITEID));
                jsonObject.put("date", sharedPreferences.getString(AppConstants.DATE));
                jsonObject.put("empid", sharedPreferences.getString(AppConstants.EMPID));
                jsonObject.put("idall",sharedPreferences.getString(AppConstants.surveytpeandcustomerandoperator));



            }catch (Exception e){
                Log.e("Exception",e.toString());
            }
        }
        return jsonObject;
    }
    private void toSendDataRFSectorDetail3() {
        //  +"?Loginid="+empId+"&password="+empPassword+"&imeno="+"2234567890"
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        pDialog.show();
        Log.v("json rfsectordetail3", jsondataRFSectorDetail3().toString());
        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.RF_Sector_Detail, jsondataRFSectorDetail3(),
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponseRFSectorDetail3(response.toString());
                        Log.v("res rfsectordetail3", response.toString());

                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("error rfsectordetail3", error.toString());
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

    private void parseSettingResponseRFSectorDetail3(String s) {
        try {
            JSONArray jsonArray = new JSONArray(s);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String status = jsonObject.getString("Status");
            Toast.makeText(getActivity(), status + " RF SectorDetail3", Toast.LENGTH_LONG).show();
            tv_rfsectordetail_status.append("SectorDetail3:" + status + "\n");
            // String password = jsonObject.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
            tv_rfsectordetail_status.append("SectorDetail3:" + e.getMessage() + "\n");
        }
    }
//.................................RF SectorDetail4.......................

    private JSONObject jsondataRFSectorDetail4(){
        JSONObject jsonObject = new JSONObject();
        List<RFSectorAntennaDetailData> sectorDetailData = db.getLast_RFSECTORDETAIL(SECTOR4);
        if(sectorDetailData.size()>0){
            Log.v("RFSectorDetailData4",sectorDetailData.toString());
            try {
                jsonObject.put("edt_Antenna_Type", sectorDetailData.get(0).getEdt_Antenna_Type());
                jsonObject.put("edt_2GBand", sectorDetailData.get(0).getEdt_2GBand());
                jsonObject.put("edt_2GCoverge", sectorDetailData.get(0).getEdt_2GCoverge());
                jsonObject.put("edt_2GObstruction", sectorDetailData.get(0).getEdt_2GObstruction());
                jsonObject.put("edt_2G_Existing_Antenna_Height", sectorDetailData.get(0).getEdt_2G_Existing_Antenna_Height());
                jsonObject.put("edt_2G_Antenna_Make_and_Model", sectorDetailData.get(0).getEdt_2G_Antenna_Makeedt_and_Model());
                jsonObject.put("edt_2G_Existing_Antenna_Direction", sectorDetailData.get(0).getEdt_2G_Existing_Antenna_Direction());
                jsonObject.put("edt_2G_Existing_antenna_tilt_Electrical", sectorDetailData.get(0).getEdt_2G_Existing_antenna_tilt_Electrical());
                jsonObject.put("edt_2G_Existing_antenna_tilt_Mechanical", sectorDetailData.get(0).getEdt_2G_Existing_antenna_tilt_Mechanical());
                jsonObject.put("edt_3GBand", sectorDetailData.get(0).getEdt_3GBand());
                jsonObject.put("edt_3GCoverge", sectorDetailData.get(0).getEdt_3GCoverge());
                jsonObject.put("edt_3GObstruction", sectorDetailData.get(0).getEdt_3GObstruction());
                jsonObject.put("edt_3G_Existing_Antenna_Ht", sectorDetailData.get(0).getEdt_3G_Existing_Antenna_Ht());
                jsonObject.put("edt_3G_Antenna_Make_and_Model", sectorDetailData.get(0).getEdt_3G_Antenna_Make_and_Model());
                jsonObject.put("edt_3G_Existing_Antenna_Direction", sectorDetailData.get(0).getEdt_3G_Existing_Antenna_Direction());
                jsonObject.put("edt_3G_Existing_antenna_Electrical_tilt", sectorDetailData.get(0).getEdt_3G_Existing_antenna_Electrical_tilt());
                jsonObject.put("edt_3G_Existing_antenna_Mechanical_tilt", sectorDetailData.get(0).getEdt_3G_Existing_antenna_Mechanical_tilt());
                jsonObject.put("edt_Space_Available_for_3G_Antenna", sectorDetailData.get(0).getEdt_Space_Available_for_3G_Antenna());
                jsonObject.put("edt_Addl_Poles_reqd_for_3G_Antenna", sectorDetailData.get(0).getEdt_Addl_Poles_req_for_3G_Antenna());
                jsonObject.put("edt_3GAntenna_Swap_Required", sectorDetailData.get(0).getEdt_3GAntenna_Swap_Required());
                jsonObject.put("edt_3GApproximate_Cable_Lenth", sectorDetailData.get(0).getEdt_3GApproximate_Cable_Lenth());
                jsonObject.put("edt_3GAntenna_Port_EmptyDamaged", sectorDetailData.get(0).getEdt_3GAntenna_Port_EmptyDamaged());
                jsonObject.put("edt_4GBand", sectorDetailData.get(0).getEdt_4GBand());
                jsonObject.put("edt_4GCoverge", sectorDetailData.get(0).getEdt_4GCoverge());
                jsonObject.put("edt_4GObstruction", sectorDetailData.get(0).getEdt_4GObstruction());
                jsonObject.put("edt_4G_Existing_Antenna_Ht", sectorDetailData.get(0).getEdt_4G_Existing_Antenna_Ht());
                jsonObject.put("edt_4G_Antenna_Make_and_Model", sectorDetailData.get(0).getEdt_4G_Antenna_Make_and_Model());
                jsonObject.put("edt_4G_Existing_Antenna_Direction", sectorDetailData.get(0).getEdt_4G_Existing_Antenna_Direction());
                jsonObject.put("edt_4G_Existing_antenna_Electrical_tilt", sectorDetailData.get(0).getEdt_4G_Existing_antenna_Electrical_tilt());
                jsonObject.put("edt_4G_Existing_antenna_Mechanical_tilt", sectorDetailData.get(0).getEdt_4G_Existing_antenna_Mechanical_tilt());
                jsonObject.put("edt_Space_Available_for_4G_Antenna", sectorDetailData.get(0).getEdt_Space_Available_for_4G_Antenna());
                jsonObject.put("edt_Addl_Poles_reqd_for_4G_Antenna", sectorDetailData.get(0).getEdt_Addl_Poles_reqd_for_4G_Antenna());
                jsonObject.put("edt_4GAntenna_Swap_Required", sectorDetailData.get(0).getEdt_4GAntenna_Swap_Required());
                jsonObject.put("edt_4GApproximate_Cable_Lenth", sectorDetailData.get(0).getEdt_3GApproximate_Cable_Lenth());
                jsonObject.put("edt_4GAntennaedt_Port_EmptyDamaged", sectorDetailData.get(0).getEdt_4GAntennaedt_Port_EmptyDamaged());

              //  jsonObject.put("img_Antenna_Type", sectorDetailData.get(0).getImg_Antenna_Type());
                if(!sectorDetailData.get(0).getImg_Antenna_Type().equals("")){
                    jsonObject.put("img_Antenna_Type", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_Antenna_Type()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_Antenna_Type",sectorDetailData.get(0).getImg_Antenna_Type() );
                }
               // jsonObject.put("img_2GBand", sectorDetailData.get(0).getImg_2GBand());
                if(!sectorDetailData.get(0).getImg_2GBand().equals("")){
                    jsonObject.put("img_2GBand", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_2GBand()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_2GBand",sectorDetailData.get(0).getImg_2GBand() );
                }
               // jsonObject.put("img_2GCoverge", sectorDetailData.get(0).getImg_2GCoverge());
                if(!sectorDetailData.get(0).getImg_2GCoverge().equals("")){
                    jsonObject.put("img_2GCoverge", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_2GCoverge()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_2GCoverge",sectorDetailData.get(0).getImg_2GCoverge() );
                }
              //  jsonObject.put("img_2GObstruction", sectorDetailData.get(0).getImg_2GObstruction());
                if(!sectorDetailData.get(0).getImg_2GObstruction().equals("")){
                    jsonObject.put("img_2GObstruction", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_2GObstruction()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_2GObstruction",sectorDetailData.get(0).getImg_2GObstruction() );
                }
              //  jsonObject.put("img_2G_Existing_Antenna_Height", sectorDetailData.get(0).getImg_2G_Existing_Antenna_Height());
                if(!sectorDetailData.get(0).getImg_2G_Existing_Antenna_Height().equals("")){
                    jsonObject.put("img_2G_Existing_Antenna_Height", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_2G_Existing_Antenna_Height()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_2G_Existing_Antenna_Height",sectorDetailData.get(0).getImg_2G_Existing_Antenna_Height() );
                }
              //  jsonObject.put("img_2G_Antenna_Make_and_Model", sectorDetailData.get(0).getImg_2G_Antenna_Make_and_Model());
                if(!sectorDetailData.get(0).getImg_2G_Antenna_Make_and_Model().equals("")){
                    jsonObject.put("img_2G_Antenna_Make_and_Model", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_2G_Antenna_Make_and_Model()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_2G_Antenna_Make_and_Model",sectorDetailData.get(0).getImg_2G_Antenna_Make_and_Model() );
                }
              //  jsonObject.put("img_2G_Existing_Antenna_Direction", sectorDetailData.get(0).getImg_2G_Existing_Antenna_Direction());
                if(!sectorDetailData.get(0).getImg_2G_Existing_Antenna_Direction().equals("")){
                    jsonObject.put("img_2G_Existing_Antenna_Direction", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_2G_Existing_Antenna_Direction()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_2G_Existing_Antenna_Direction",sectorDetailData.get(0).getImg_2G_Existing_Antenna_Direction() );
                }
              //  jsonObject.put("img_2G_Existing_antenna_tilt_Electrical", sectorDetailData.get(0).getImg_2G_Existing_antenna_tilt_Electrical());
                if(!sectorDetailData.get(0).getImg_2G_Existing_antenna_tilt_Electrical().equals("")){
                    jsonObject.put("img_2G_Existing_antenna_tilt_Electrical", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_2G_Existing_antenna_tilt_Electrical()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_2G_Existing_antenna_tilt_Electrical",sectorDetailData.get(0).getImg_2G_Existing_antenna_tilt_Electrical() );
                }
             //   jsonObject.put("img_2G_Existing_antenna_tilt_Mechanical", sectorDetailData.get(0).getImg_2G_Existing_antenna_tilt_Mechanical());
                if(!sectorDetailData.get(0).getImg_2G_Existing_antenna_tilt_Mechanical().equals("")){
                    jsonObject.put("img_2G_Existing_antenna_tilt_Mechanical", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_2G_Existing_antenna_tilt_Mechanical()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_2G_Existing_antenna_tilt_Mechanical",sectorDetailData.get(0).getImg_2G_Existing_antenna_tilt_Mechanical() );
                }
             //   jsonObject.put("img_3GBand", sectorDetailData.get(0).getImg_3GBand());
                if(!sectorDetailData.get(0).getImg_3GBand().equals("")){
                    jsonObject.put("img_3GBand", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3GBand()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_3GBand",sectorDetailData.get(0).getImg_3GBand() );
                }
             //   jsonObject.put("img_3GCoverge", sectorDetailData.get(0).getImg_3GCoverge());
                if(!sectorDetailData.get(0).getImg_3GCoverge().equals("")){
                    jsonObject.put("img_3GCoverge", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3GCoverge()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_3GCoverge",sectorDetailData.get(0).getImg_3GCoverge() );
                }
             //   jsonObject.put("img_3GObstruction", sectorDetailData.get(0).getImg_3GObstruction());
                if(!sectorDetailData.get(0).getImg_3GObstruction().equals("")){
                    jsonObject.put("img_3GObstruction", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3GObstruction()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_3GObstruction",sectorDetailData.get(0).getImg_3GObstruction() );
                }
             //   jsonObject.put("img_3G_Existing_Antenna_Ht", sectorDetailData.get(0).getImg_3G_Existing_Antenna_Ht());
                if(!sectorDetailData.get(0).getImg_3G_Existing_Antenna_Ht().equals("")){
                    jsonObject.put("img_3G_Existing_Antenna_Ht", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3G_Existing_Antenna_Ht()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_3G_Existing_Antenna_Ht",sectorDetailData.get(0).getImg_3G_Existing_Antenna_Ht() );
                }
            //    jsonObject.put("img_3G_Antenna_Make_and_Model", sectorDetailData.get(0).getImg_3G_Antenna_Make_and_Model());
                if(!sectorDetailData.get(0).getImg_3G_Antenna_Make_and_Model().equals("")){
                    jsonObject.put("img_3G_Antenna_Make_and_Model", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3G_Antenna_Make_and_Model()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_3G_Antenna_Make_and_Model",sectorDetailData.get(0).getImg_3G_Antenna_Make_and_Model() );
                }
             //   jsonObject.put("img_3G_Existing_Antenna_Direction", sectorDetailData.get(0).getImg_3G_Existing_Antenna_Direction());
                if(!sectorDetailData.get(0).getImg_3G_Existing_Antenna_Direction().equals("")){
                    jsonObject.put("img_3G_Existing_Antenna_Direction", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3G_Existing_Antenna_Direction()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_3G_Existing_Antenna_Direction",sectorDetailData.get(0).getImg_3G_Existing_Antenna_Direction() );
                }
            //    jsonObject.put("img_3G_Existing_antenna_Electrical_tilt", sectorDetailData.get(0).getImg_3G_Existing_antenna_Electrical_tilt());
                if(!sectorDetailData.get(0).getImg_3G_Existing_antenna_Electrical_tilt().equals("")){
                    jsonObject.put("img_3G_Existing_antenna_Electrical_tilt", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3G_Existing_antenna_Electrical_tilt()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_3G_Existing_antenna_Electrical_tilt",sectorDetailData.get(0).getImg_3G_Existing_antenna_Electrical_tilt() );
                }
            //    jsonObject.put("img_3G_Existing_antenna_Mechanical_tilt", sectorDetailData.get(0).getImg_3G_Existing_antenna_Mechanical_tilt());
                if(!sectorDetailData.get(0).getImg_3G_Existing_antenna_Mechanical_tilt().equals("")){
                    jsonObject.put("img_3G_Existing_antenna_Mechanical_tilt", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3G_Existing_antenna_Mechanical_tilt()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_3G_Existing_antenna_Mechanical_tilt",sectorDetailData.get(0).getImg_3G_Existing_antenna_Mechanical_tilt() );
                }
           //     jsonObject.put("img_Space_Available_for_3G_Antenna", sectorDetailData.get(0).getImg_Space_Available_for_3G_Antenna());
                if(!sectorDetailData.get(0).getImg_Space_Available_for_3G_Antenna().equals("")){
                    jsonObject.put("img_Space_Available_for_3G_Antenna", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_Space_Available_for_3G_Antenna()), Bitmap.CompressFormat.JPEG, 100));
                }
                else{
                    jsonObject.put("img_Space_Available_for_3G_Antenna",sectorDetailData.get(0).getImg_Space_Available_for_3G_Antenna() );
                }
              //  jsonObject.put("img_Addl_Poles_req_for_3G_Antenna", sectorDetailData.get(0).getImg_Addl_Poles_reqd_for_3G_Antenna());
                if(!sectorDetailData.get(0).getImg_Addl_Poles_reqd_for_3G_Antenna().equals("")){
                    jsonObject.put("img_Addl_Poles_req_for_3G_Antenna", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_Addl_Poles_reqd_for_3G_Antenna()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_Addl_Poles_req_for_3G_Antenna", sectorDetailData.get(0).getImg_Addl_Poles_reqd_for_3G_Antenna());
                }
             //   jsonObject.put("img_3GAntenna_Swap_Required", sectorDetailData.get(0).getImg_3GAntenna_Swap_Required());
                if(!sectorDetailData.get(0).getImg_3GAntenna_Swap_Required().equals("")){
                    jsonObject.put("img_3GAntenna_Swap_Required", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3GAntenna_Swap_Required()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_3GAntenna_Swap_Required", sectorDetailData.get(0).getImg_3GAntenna_Swap_Required());
                }
             //   jsonObject.put("img_3GApproximate_Cable_Lenth", sectorDetailData.get(0).getImg_3GApproximate_Cable_Lenth());
                if(!sectorDetailData.get(0).getImg_3GApproximate_Cable_Lenth().equals("")){
                    jsonObject.put("img_3GApproximate_Cable_Lenth", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3GApproximate_Cable_Lenth()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_3GApproximate_Cable_Lenth", sectorDetailData.get(0).getImg_3GApproximate_Cable_Lenth());
                }
             //   jsonObject.put("img_3GAntenna_Port_EmptyDamaged", sectorDetailData.get(0).getImg_3GAntenna_Port_EmptyDamaged());
                if(!sectorDetailData.get(0).getImg_3GAntenna_Port_EmptyDamaged().equals("")){
                    jsonObject.put("img_3GAntenna_Port_EmptyDamaged", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3GAntenna_Port_EmptyDamaged()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_3GAntenna_Port_EmptyDamaged", sectorDetailData.get(0).getImg_3GAntenna_Port_EmptyDamaged());
                }
            //    jsonObject.put("img_4GBand", sectorDetailData.get(0).getImg_4GBand());
                if(!sectorDetailData.get(0).getImg_4GBand().equals("")){
                    jsonObject.put("img_4GBand", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_4GBand()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_4GBand", sectorDetailData.get(0).getImg_4GBand());
                }
          //      jsonObject.put("img_4GCoverge", sectorDetailData.get(0).getImg_4GCoverge());
                if(!sectorDetailData.get(0).getImg_4GCoverge().equals("")){
                    jsonObject.put("img_4GCoverge", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_4GCoverge()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_4GCoverge", sectorDetailData.get(0).getImg_4GCoverge());
                }
          //      jsonObject.put("img_4GObstruction", sectorDetailData.get(0).getImg_4GObstruction());
                if(!sectorDetailData.get(0).getImg_4GObstruction().equals("")){
                    jsonObject.put("img_4GObstruction", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_4GObstruction()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_4GObstruction", sectorDetailData.get(0).getImg_4GObstruction());
                }
           //     jsonObject.put("img_4G_Existing_Antenna_Ht", sectorDetailData.get(0).getImg_4G_Existing_Antenna_Ht());
                if(!sectorDetailData.get(0).getImg_4G_Existing_Antenna_Ht().equals("")){
                    jsonObject.put("img_4G_Existing_Antenna_Ht", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_4G_Existing_Antenna_Ht()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_4G_Existing_Antenna_Ht", sectorDetailData.get(0).getImg_4G_Existing_Antenna_Ht());
                }
           //     jsonObject.put("img_4G_Antenna_Make_and_Model", sectorDetailData.get(0).getImg_4G_Antenna_Make_and_Model());
                if(!sectorDetailData.get(0).getImg_4G_Antenna_Make_and_Model().equals("")){
                    jsonObject.put("img_4G_Antenna_Make_and_Model", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_4G_Antenna_Make_and_Model()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_4G_Antenna_Make_and_Model", sectorDetailData.get(0).getImg_4G_Antenna_Make_and_Model());
                }
           //     jsonObject.put("img_4G_Existing_Antenna_Direction", sectorDetailData.get(0).getImg_4G_Existing_Antenna_Direction());
                if(!sectorDetailData.get(0).getImg_4G_Existing_Antenna_Direction().equals("")){
                    jsonObject.put("img_4G_Existing_Antenna_Direction", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_4G_Existing_Antenna_Direction()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_4G_Existing_Antenna_Direction", sectorDetailData.get(0).getImg_4G_Existing_Antenna_Direction());
                }
           //     jsonObject.put("img_4G_Existing_antenna_Electrical_tilt", sectorDetailData.get(0).getImg_4G_Existing_antenna_Electrical_tilt());
                if(!sectorDetailData.get(0).getImg_4G_Existing_antenna_Electrical_tilt().equals("")){
                    jsonObject.put("img_4G_Existing_antenna_Electrical_tilt", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_4G_Existing_antenna_Electrical_tilt()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_4G_Existing_antenna_Electrical_tilt", sectorDetailData.get(0).getImg_4G_Existing_antenna_Electrical_tilt());
                }
            //    jsonObject.put("img_4G_Existing_antenna_Mechanical_tilt", sectorDetailData.get(0).getImg_4G_Existing_antenna_Mechanical_tilt());
                if(!sectorDetailData.get(0).getImg_4G_Existing_antenna_Mechanical_tilt().equals("")){
                    jsonObject.put("img_4G_Existing_antenna_Mechanical_tilt", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_4G_Existing_antenna_Mechanical_tilt()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_4G_Existing_antenna_Mechanical_tilt", sectorDetailData.get(0).getImg_4G_Existing_antenna_Mechanical_tilt());
                }
          //      jsonObject.put("img_Space_Available_for_4G_Antenna", sectorDetailData.get(0).getImg_Space_Available_for_4G_Antenna());
                if(!sectorDetailData.get(0).getImg_Space_Available_for_4G_Antenna().equals("")){
                    jsonObject.put("img_Space_Available_for_4G_Antenna", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_Space_Available_for_4G_Antenna()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_Space_Available_for_4G_Antenna", sectorDetailData.get(0).getImg_Space_Available_for_4G_Antenna());
                }
            //    jsonObject.put("img_Addl_Poles_reqd_for_4G_Antenna", sectorDetailData.get(0).getImg_Addl_Poles_reqd_for_4G_Antenna());
                if(!sectorDetailData.get(0).getImg_Addl_Poles_reqd_for_4G_Antenna().equals("")){
                    jsonObject.put("img_Addl_Poles_reqd_for_4G_Antenna", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_Addl_Poles_reqd_for_4G_Antenna()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_Addl_Poles_reqd_for_4G_Antenna", sectorDetailData.get(0).getImg_Addl_Poles_reqd_for_4G_Antenna());
                }
          //      jsonObject.put("img_4GAntenna_Swap_Required", sectorDetailData.get(0).getImg_4GAntenna_Swap_Required());
                if(!sectorDetailData.get(0).getImg_4GAntenna_Swap_Required().equals("")){
                    jsonObject.put("img_4GAntenna_Swap_Required", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_4GAntenna_Swap_Required()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_4GAntenna_Swap_Required", sectorDetailData.get(0).getImg_4GAntenna_Swap_Required());
                }
            //    jsonObject.put("img_4GApproximate_Cable_Lenth", sectorDetailData.get(0).getImg_3GApproximate_Cable_Lenth());
                if(!sectorDetailData.get(0).getImg_3GApproximate_Cable_Lenth().equals("")){
                    jsonObject.put("img_4GApproximate_Cable_Lenth", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_3GApproximate_Cable_Lenth()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_4GApproximate_Cable_Lenth", sectorDetailData.get(0).getImg_3GApproximate_Cable_Lenth());
                }
         //       jsonObject.put("img_4GAntenna_Port_EmptyDamaged", sectorDetailData.get(0).getImg_4GAntenna_Port_EmptyDamaged());
                if(!sectorDetailData.get(0).getImg_4GAntenna_Port_EmptyDamaged().equals("")){
                    jsonObject.put("img_4GAntenna_Port_EmptyDamaged", BitmapEncodedDecoded.encodeToBase64(BitmapFactory.decodeFile(sectorDetailData.get(0).getImg_4GAntenna_Port_EmptyDamaged()), Bitmap.CompressFormat.JPEG, 100));
                }
                else {
                    jsonObject.put("img_4GAntenna_Port_EmptyDamaged", sectorDetailData.get(0).getImg_4GAntenna_Port_EmptyDamaged());
                }
                jsonObject.put("rf_sectorDetail_name", sectorDetailData.get(0).getRf_sectorDetail_name());
                jsonObject.put("edt_commentadd", sectorDetailData.get(0).getEdt_commentadd());
                jsonObject.put("edt_orientation", sectorDetailData.get(0).getEdt_orientation());
                jsonObject.put("flag", sectorDetailData.get(0).getFlag());
                // jsonObject.put("date", sectorDetailData.get(0).getDate());

                jsonObject.put("siteid", sharedPreferences.getString(AppConstants.SITEID));
                jsonObject.put("date", sharedPreferences.getString(AppConstants.DATE));
                jsonObject.put("empid", sharedPreferences.getString(AppConstants.EMPID));
                jsonObject.put("idall",sharedPreferences.getString(AppConstants.surveytpeandcustomerandoperator));



            }catch (Exception e){
                Log.e("Exception",e.toString());
            }
        }
        return jsonObject;
    }
    private void toSendDataRFSectorDetail4() {
        //  +"?Loginid="+empId+"&password="+empPassword+"&imeno="+"2234567890"
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        pDialog.show();
        Log.v("json rfsectordetail4", jsondataRFSectorDetail4().toString());
        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                AppConstants.RF_Sector_Detail, jsondataRFSectorDetail4(),
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        parseSettingResponseRFSectorDetail4(response.toString());
                        Log.v("res rfsectordetail4", response.toString());
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("error rfsectordetail4", error.toString());
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

    private void parseSettingResponseRFSectorDetail4(String s) {
        try {
            JSONArray jsonArray = new JSONArray(s);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String status = jsonObject.getString("Status");
            Toast.makeText(getActivity(), status + " RF SectorDetail4", Toast.LENGTH_LONG).show();
            tv_rfsectordetail_status.append("SectorDetail4:" + status + "\n");
            // String password = jsonObject.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
            tv_rfsectordetail_status.append("SectorDetail4:" + e.getMessage() + "\n");
        }
    }

    private void selectImage(String Value) {
        if (Value.equals("1")) {

            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 1);
            startActivityForResult(i, 1);
        }
        if (Value.equals("2")) {

            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 2);
            startActivityForResult(i, 2);

        }
        if (Value.equals("3")) {

            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 3);
            startActivityForResult(i, 3);
        }
        if (Value.equals("4")) {

            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 4);
            startActivityForResult(i, 4);
        }
        if (Value.equals("5")) {

            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 5);
            startActivityForResult(i, 5);
        }
        if (Value.equals("6")) {

            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 6);
            startActivityForResult(i, 6);
        }
        if (Value.equals("7")) {

            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 7);
            startActivityForResult(i, 7);
        }
        if (Value.equals("8")) {

            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 8);
            startActivityForResult(i, 8);
        }
        if (Value.equals("9")) {

            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 9);
            startActivityForResult(i, 9);
        }
        if (Value.equals("10")) {

            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 10);
            startActivityForResult(i, 10);
        }
        if (Value.equals("11")) {
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 11);
            startActivityForResult(i, 11);
        }
        if (Value.equals("12")) {
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 12);
            startActivityForResult(i, 12);
        }
        if (Value.equals("13")) {
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 13);
            startActivityForResult(i, 13);
        }
        if (Value.equals("14")) {
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 14);
            startActivityForResult(i, 14);
        }
        if (Value.equals("15")) {
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 15);
            startActivityForResult(i, 15);
        }
        if (Value.equals("16")) {
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 16);
            startActivityForResult(i, 16);
        }
        if (Value.equals("17")) {
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 17);
            startActivityForResult(i, 17);
        }
        if (Value.equals("18")) {
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 18);
            startActivityForResult(i, 18);
        }
        if (Value.equals("19")) {
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 19);
            startActivityForResult(i, 19);
        }
        if (Value.equals("20")) {
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 20);
            startActivityForResult(i, 20);
        }
        if (Value.equals("21")) {
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 21);
            startActivityForResult(i, 21);
        }
        if (Value.equals("22")) {
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 22);
            startActivityForResult(i, 22);
        }
        if (Value.equals("23")) {
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 23);
            startActivityForResult(i, 23);
        }
        if (Value.equals("24")) {
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 24);
            startActivityForResult(i, 24);
        }
        if (Value.equals("25")) {
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 25);
            startActivityForResult(i, 25);
        }
        if (Value.equals("26")) {
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 26);
            startActivityForResult(i, 26);
        }
        if (Value.equals("27")) {
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 27);
            startActivityForResult(i, 27);
        }
        if (Value.equals("28")) {
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 28);
            startActivityForResult(i, 28);
        }
        if (Value.equals("29")) {
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 29);
            startActivityForResult(i, 29);
        }
        if (Value.equals("30")) {
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 30);
            startActivityForResult(i, 30);
        }
        if (Value.equals("31")) {
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 31);
            startActivityForResult(i, 31);
        }
        if (Value.equals("32")) {
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 32);
            startActivityForResult(i, 32);
        }
        if (Value.equals("33")) {
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 33);
            startActivityForResult(i, 33);
        }
        if (Value.equals("34")) {
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 34);
            startActivityForResult(i, 34);
        }
        if (Value.equals("35")) {
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos", 35);
            startActivityForResult(i, 35);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_CANCELED) {
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
            if (requestCode == 27) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "27", angle);
            }
            if (requestCode == 28) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "28", angle);
            }
            if (requestCode == 29) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "29", angle);
            }
            if (requestCode == 30) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "30", angle);
            }
            if (requestCode == 31) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "31", angle);
            }
            if (requestCode == 32) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "32", angle);
            }
            if (requestCode == 33) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "33", angle);
            }
            if (requestCode == 34) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "34", angle);
            }
            if (requestCode == 35) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "35", angle);
            }
        }
    }

    private void onCameraSurfaceViewActivity(String thumbnail, String name, String angle) {

        if (name.equals("1")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_Antenna_Type.setImageBitmap(out);
                img_Antenna_Type = thumbnail;
                Log.v("img-encode", img_Antenna_Type);
            }
        }
        if (name.equals("2")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_2GBand.setImageBitmap(out);
                //  imgBearing30 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_2GBand = thumbnail;
                Log.v("img-encode", img_2GBand);
            }
        }
        if (name.equals("3")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_2GCoverge.setImageBitmap(out);
                //  imgBearing60 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_2GCoverge = thumbnail;
                Log.v("img-encode", img_2GCoverge);
            }
        }
        if (name.equals("4")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_2GObstruction.setImageBitmap(out);
                //   imgBearing90 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_2GObstruction = thumbnail;
                Log.v("img-encode", img_2GObstruction);
            }
        }
        if (name.equals("5")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_2G_Existing_Antenna_Height.setImageBitmap(out);
                //  imgBearing120 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_2G_Existing_Antenna_Height = thumbnail;
                Log.v("img-encode", img_2G_Existing_Antenna_Height);
            }
        }
        if (name.equals("6")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_2G_Antenna_Make_and_Model.setImageBitmap(out);
                //    imgBearing150 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_2G_Antenna_Make_and_Model = thumbnail;
                Log.v("img-encode", img_2G_Antenna_Make_and_Model);
            }
        }
        if (name.equals("7")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_2G_Existing_Antenna_Direction.setImageBitmap(out);
                //     imgBearing180 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_2G_Existing_Antenna_Direction = thumbnail;
                Log.v("img-encode", img_2G_Existing_Antenna_Direction);
            }
        }
        if (name.equals("8")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_2G_Existing_antenna_tilt_Electrical.setImageBitmap(out);
                //   imgBearing210 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_2G_Existing_antenna_tilt_Electrical = thumbnail;
                Log.v("img-encode", img_2G_Existing_antenna_tilt_Electrical);
            }
        }
        if (name.equals("9")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_2G_Existing_antenna_tilt_Mechanical.setImageBitmap(out);
                // imgBearing240 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_2G_Existing_antenna_tilt_Mechanical = thumbnail;
                Log.v("img-encode", img_2G_Existing_antenna_tilt_Mechanical);
            }
        }
        if (name.equals("10")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_3GBand.setImageBitmap(out);
                //    imgBearing270 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_3GBand = thumbnail;
                Log.v("img-encode", img_3GBand);
            }
        }
        if (name.equals("11")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_3GCoverge.setImageBitmap(out);
                //    imgBearing300 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_3GCoverge = thumbnail;
                Log.v("img-encode", img_3GCoverge);
            }
        }
        if (name.equals("12")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_3GObstruction.setImageBitmap(out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_3GObstruction = thumbnail;
                Log.v("img-encode", img_3GObstruction);
            }
        }
        if (name.equals("13")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_3G_Existing_Antenna_Ht.setImageBitmap(out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_3G_Existing_Antenna_Ht = thumbnail;
                Log.v("img-encode", img_3G_Existing_Antenna_Ht);
            }
        }
        if (name.equals("14")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_3G_Antenna_Make_and_Model.setImageBitmap(out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_3G_Antenna_Make_and_Model = thumbnail;
                Log.v("img-encode", img_3G_Antenna_Make_and_Model);
            }
        }
        if (name.equals("15")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_3G_Existing_Antenna_Direction.setImageBitmap(out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_3G_Existing_Antenna_Direction = thumbnail;
                Log.v("img-encode", img_3G_Existing_Antenna_Direction);
            }
        }
        if (name.equals("16")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_3G_Existing_antenna_Electrical_tilt.setImageBitmap(out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_3G_Existing_antenna_Electrical_tilt = thumbnail;
                Log.v("img-encode", img_3G_Existing_antenna_Electrical_tilt);
            }
        }
        if (name.equals("17")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_3G_Existing_antenna_Mechanical_tilt.setImageBitmap(out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_3G_Existing_antenna_Mechanical_tilt = thumbnail;
                Log.v("img-encode", img_3G_Existing_antenna_Mechanical_tilt);
            }
        }
        if (name.equals("18")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_Space_Available_for_3G_Antenna.setImageBitmap(out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_Space_Available_for_3G_Antenna = thumbnail;
                Log.v("img-encode", img_Space_Available_for_3G_Antenna);
            }
        }
        if (name.equals("19")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_Addl_Poles_req_for_3G_Antenna.setImageBitmap(out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_Addl_Poles_reqd_for_3G_Antenna = thumbnail;
                Log.v("img-encode", img_Addl_Poles_reqd_for_3G_Antenna);
            }
        }
        if (name.equals("20")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_3GAntenna_Swap_Required.setImageBitmap(out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_3GAntenna_Swap_Required = thumbnail;
                Log.v("img-encode", img_3GAntenna_Swap_Required);
            }
        }
        if (name.equals("21")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_3GApproximate_Cable_Lenth.setImageBitmap(out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_3GApproximate_Cable_Lenth = thumbnail;
                Log.v("img-encode", img_3GApproximate_Cable_Lenth);
            }
        }
        if (name.equals("22")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_3GAntenna_Port_EmptyDamaged.setImageBitmap(out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_3GAntenna_Port_EmptyDamaged = thumbnail;
                Log.v("img-encode", img_3GAntenna_Port_EmptyDamaged);
            }
        }

        if (name.equals("23")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_4GBand.setImageBitmap(out);
                //    imgBearing270 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_4GBand = thumbnail;
                Log.v("img-encode", img_4GBand);
            }
        }
        if (name.equals("24")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_4GCoverge.setImageBitmap(out);
                //    imgBearing300 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_4GCoverge = thumbnail;
                Log.v("img-encode", img_4GCoverge);
            }
        }
        if (name.equals("25")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_4GObstruction.setImageBitmap(out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_4GObstruction = thumbnail;
                Log.v("img-encode", img_4GObstruction);
            }
        }
        if (name.equals("26")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_4G_Existing_Antenna_Ht.setImageBitmap(out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_4G_Existing_Antenna_Ht = thumbnail;
                Log.v("img-encode", img_4G_Existing_Antenna_Ht);
            }
        }
        if (name.equals("27")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_4G_Antenna_Make_and_Model.setImageBitmap(out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_4G_Antenna_Make_and_Model = thumbnail;
                Log.v("img-encode", img_4G_Antenna_Make_and_Model);
            }
        }
        if (name.equals("28")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_4G_Existing_Antenna_Direction.setImageBitmap(out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_4G_Existing_Antenna_Direction = thumbnail;
                Log.v("img-encode", img_4G_Existing_Antenna_Direction);
            }
        }
        if (name.equals("29")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_4G_Existing_antenna_Electrical_tilt.setImageBitmap(out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_4G_Existing_antenna_Electrical_tilt = thumbnail;
                Log.v("img-encode", img_4G_Existing_antenna_Electrical_tilt);
            }
        }
        if (name.equals("30")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_4G_Existing_antenna_Mechanical_tilt.setImageBitmap(out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_4G_Existing_antenna_Mechanical_tilt = thumbnail;
                Log.v("img-encode", img_4G_Existing_antenna_Mechanical_tilt);
            }
        }
        if (name.equals("31")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_Space_Available_for_4G_Antenna.setImageBitmap(out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_Space_Available_for_4G_Antenna = thumbnail;
                Log.v("img-encode", img_Space_Available_for_4G_Antenna);
            }
        }
        if (name.equals("32")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_Addl_Poles_reqd_for_4G_Antenna.setImageBitmap(out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_Addl_Poles_reqd_for_4G_Antenna = thumbnail;
                Log.v("img-encode", img_Addl_Poles_reqd_for_4G_Antenna);
            }
        }
        if (name.equals("33")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_4GAntenna_Swap_Required.setImageBitmap(out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_4GAntenna_Swap_Required = thumbnail;
                Log.v("img-encode", img_4GAntenna_Swap_Required);
            }
        }
        if (name.equals("34")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_4GApproximate_Cable_Lenth.setImageBitmap(out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_4GApproximate_Cable_Lenth = thumbnail;
                Log.v("img-encode", img_4GApproximate_Cable_Lenth);
            }
        }
        if (name.equals("35")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_4GAntennaedt_Port_EmptyDamaged.setImageBitmap(out);
                //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_4GAntenna_Port_EmptyDamaged = thumbnail;
                Log.v("img-encode", img_4GAntenna_Port_EmptyDamaged);
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
