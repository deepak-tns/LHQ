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
import android.widget.Toast;

import com.linkquest.lhq.GoogleGPSService;
import com.linkquest.lhq.R;
import com.linkquest.lhq.SiteAudit.SectorDetailFragment;
import com.linkquest.lhq.activity.CameraSurfaceViewActivity;
import com.linkquest.lhq.database.DatabaseHandler;

import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;

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
    private EditText  edt_Space_Available_for_3G_Antenna;
    private EditText  edt_Addl_Poles_req_for_3G_Antenna;
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



    private String img_Antenna_Type;
    private String img_2GBand;
    private String img_2GCoverge;
    private String img_2GObstruction;
    private String img_2G_Existing_Antenna_Height;
    private String img_2G_Antenna_Make_and_Model;
    private String img_2G_Existing_Antenna_Direction;
    private String img_2G_Existing_antenna_tilt_Electrical;
    private String img_2G_Existing_antenna_tilt_Mechanical;
    private String img_3GBand;
    private String img_3GCoverge;
    private String img_3GObstruction;
    private String img_3G_Existing_Antenna_Ht;
    private String img_3G_Antenna_Make_and_Model;
    private String img_3G_Existing_Antenna_Direction;
    private String img_3G_Existing_antenna_Electrical_tilt;
    private String img_3G_Existing_antenna_Mechanical_tilt;
    private String  img_Space_Available_for_3G_Antenna;
    private String  img_Addl_Poles_reqd_for_3G_Antenna;
    private String img_3GAntenna_Swap_Required;
    private String img_3GApproximate_Cable_Lenth;
    private String img_3GAntenna_Port_EmptyDamaged;
    private String img_4GBand;
    private String img_4GCoverge;
    private String img_4GObstruction;
    private String img_4G_Existing_Antenna_Ht;
    private String img_4G_Antenna_Make_and_Model;
    private String img_4G_Existing_Antenna_Direction;
    private String img_4G_Existing_antenna_Electrical_tilt;
    private String img_4G_Existing_antenna_Mechanical_tilt;
    private String  img_Space_Available_for_4G_Antenna;
    private String  img_Addl_Poles_reqd_for_4G_Antenna;
    private String img_4GAntenna_Swap_Required;
    private String img_4GApproximate_Cable_Lenth;
    private String img_4GAntenna_Port_EmptyDamaged;
    private String date;
    private int flag;


    String lat, log;
    Handler handler;
    String time;
    Text tvprecount,tvaftercount;
    Button btn_save,btn_next;
    DatabaseHandler db;
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
        
        return v;
    }

    private void findIds(View v) {

        edt_Antenna_Type = v.findViewById(R.id.edt_Antenna_Type);
        edt_2GBand = v.findViewById(R.id.edt_2GBand);
        edt_2GCoverge = v.findViewById(R.id.edt_2GCoverge);
        edt_2GObstruction  = v.findViewById(R.id.edt_2GObstruction);
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
        edt_3GApproximate_Cable_Lenth  = v.findViewById(R.id.edt_3GApproximate_Cable_Lenth);
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

        btn_save =v.findViewById(R.id.btnrfsectordetailsave);
        btn_next =v.findViewById(R.id.btnrfsectordetailnext);
        tvprecount =v.findViewById(R.id.tv_rfsectordetail_count_previous);
        tvaftercount =v.findViewById(R.id.tv_rfsectordetail_count);

        ib_Antenna_Type = v.findViewById(R.id.ib_Antenna_Type);
        ib_2GBand = v.findViewById(R.id.ib_2GBand);
        ib_2GCoverge = v.findViewById(R.id.ib_2GCoverge);
        ib_2GObstruction  = v.findViewById(R.id.ib_2GObstruction);
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
        ib_3GApproximate_Cable_Lenth  = v.findViewById(R.id.ib_3GApproximate_Cable_Lenth);
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
        iv_2GObstruction  = v.findViewById(R.id.iv_2GObstruction);
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
        iv_3GApproximate_Cable_Lenth  = v.findViewById(R.id.iv_3GApproximate_Cable_Lenth);
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





    }

    @Override
    public void onClick(View view) {
       if(view == ib_Antenna_Type){

       }
        if(view == ib_2GBand){

        }
        if(view ==  ib_2GCoverge){

        }
        if(view == ib_2GObstruction){

        }
        if(view == ib_2G_Existing_Antenna_Height){

        }
        if(view ==  ib_2G_Antenna_Make_and_Model){

        }
        if(view == ib_2G_Existing_Antenna_Direction){

        }
        if(view ==  ib_2G_Existing_antenna_tilt_Electrical){

        }
        if(view ==  ib_2G_Existing_antenna_tilt_Mechanical){

        }
        if(view ==  ib_3GBand){

        }
        if(view == ib_3GCoverge){

        }
        if(view == ib_3GObstruction){

        }
        if(view == ib_3G_Existing_Antenna_Ht){

        }
        if(view == ib_3G_Antenna_Make_and_Model){

        }
        if(view ==  ib_3G_Existing_Antenna_Direction){

        }
        if(view == ib_3G_Existing_antenna_Electrical_tilt){

        }
        if(view == ib_3G_Existing_antenna_Mechanical_tilt){

        }
        if(view == ib_Space_Available_for_3G_Antenna){

        }
        if(view ==  ib_3GAntennaedt_Port_EmptyDamaged){

        }
        if(view ==  ib_3GAntenna_Swap_Required){

        }
        if(view == ib_3GApproximate_Cable_Lenth){

        }
        if(view == ib_3GAntenna_Port_EmptyDamaged){

        }
        if(view ==  ib_4GBand){

        }
        if(view == ib_4GCoverge){

        }
        if(view == ib_4GObstruction){

        }
        if(view == ib_4G_Existing_Antenna_Ht){

        }
        if(view == ib_4G_Antenna_Make_and_Model){

        }
        if(view == ib_4G_Existing_Antenna_Direction){

        }
        if(view == ib_4G_Existing_antenna_Electrical_tilt){

        }
        if(view == ib_4G_Existing_antenna_Mechanical_tilt){

        }
        if(view ==  ib_Space_Available_for_4G_Antenna){

        }
        if(view == ib_Addl_Poles_reqd_for_4G_Antenna){

        }
        if(view == ib_4GAntenna_Swap_Required){

        }
        if(view == ib_4GApproximate_Cable_Lenth){

        }
        if(view == ib_4GAntennaedt_Port_EmptyDamaged){

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
                iv_Antenna_Type.setImageBitmap( out);
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
                iv_2GCoverge.setImageBitmap( out);
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
                iv_2GObstruction.setImageBitmap( out);
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
                iv_2G_Existing_Antenna_Height.setImageBitmap( out);
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
                iv_2G_Antenna_Make_and_Model.setImageBitmap( out);
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
                iv_2G_Existing_Antenna_Direction.setImageBitmap( out);
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
                iv_2G_Existing_antenna_tilt_Electrical.setImageBitmap( out);
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
                iv_2G_Existing_antenna_tilt_Mechanical.setImageBitmap( out);
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
                iv_3GBand.setImageBitmap( out);
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
                iv_3GCoverge.setImageBitmap( out);
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
                iv_3GObstruction.setImageBitmap( out);
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
                iv_3G_Existing_Antenna_Ht.setImageBitmap( out);
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
                iv_3G_Antenna_Make_and_Model.setImageBitmap( out);
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
                iv_3G_Existing_Antenna_Direction.setImageBitmap( out);
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
                iv_3G_Existing_antenna_Electrical_tilt.setImageBitmap( out);
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
                iv_3G_Existing_antenna_Mechanical_tilt.setImageBitmap( out);
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
                iv_Space_Available_for_3G_Antenna.setImageBitmap( out);
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
                iv_Addl_Poles_req_for_3G_Antenna.setImageBitmap( out);
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
                iv_3GAntenna_Swap_Required.setImageBitmap( out);
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
                iv_3GApproximate_Cable_Lenth.setImageBitmap( out);
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
                iv_3GAntenna_Port_EmptyDamaged.setImageBitmap( out);
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
                iv_4GBand.setImageBitmap( out);
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
                iv_4GCoverge.setImageBitmap( out);
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
                iv_4GObstruction.setImageBitmap( out);
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
                iv_4G_Existing_Antenna_Ht.setImageBitmap( out);
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
                iv_4G_Antenna_Make_and_Model.setImageBitmap( out);
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
                iv_4G_Existing_Antenna_Direction.setImageBitmap( out);
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
                iv_4G_Existing_antenna_Electrical_tilt.setImageBitmap( out);
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
                iv_4G_Existing_antenna_Mechanical_tilt.setImageBitmap( out);
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
                iv_Space_Available_for_4G_Antenna.setImageBitmap( out);
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
                iv_Addl_Poles_reqd_for_4G_Antenna.setImageBitmap( out);
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
                iv_4GAntenna_Swap_Required.setImageBitmap( out);
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
                iv_4GApproximate_Cable_Lenth.setImageBitmap( out);
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
                iv_4GAntennaedt_Port_EmptyDamaged.setImageBitmap( out);
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
