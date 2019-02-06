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
import com.linkquest.lhq.SiteAudit.SitePanoramicFragment;
import com.linkquest.lhq.activity.CameraSurfaceViewActivity;
import com.linkquest.lhq.database.DatabaseHandler;
import com.linkquest.lhq.database.TransmissionLinkData;
import com.linkquest.lhq.database.TransmissionNoLinkData;

import java.io.ByteArrayOutputStream;

import static android.app.Activity.RESULT_CANCELED;

/**
 * A simple {@link Fragment} subclass.
 */
public class TransmissionNoLinkFragment extends Fragment implements View.OnClickListener {
    private  EditText edt_SiteID;
    private  EditText edt_Sitename;
    private  EditText edt_ObstructionDetails;
    private  EditText edt_Azimuth;
    private  EditText edt_Distance;
    private  EditText edt_AntennaHeight;
    private  EditText edt_Altitude;

    private ImageButton ib_SiteID;
    private  ImageButton ib_Sitename;
    private  ImageButton ib_ObstructionDetails;
    private  ImageButton ib_Azimuth;
    private  ImageButton ib_Distance;
    private  ImageButton ib_AntennaHeight;
    private  ImageButton ib_Altitude;

    private ImageView iv_SiteID;
    private  ImageView iv_Sitename;
    private  ImageView iv_ObstructionDetails;
    private  ImageView iv_Azimuth;
    private  ImageView iv_Distance;
    private  ImageView iv_AntennaHeight;
    private  ImageView iv_Altitude;


    private  String img_SiteID ="";
    private  String img_Sitename="";
    private  String img_ObstructionDetails="";
    private  String img_Azimuth="";
    private  String img_Distance="";
    private  String img_AntennaHeight="";
    private  String img_Altitude="";
    private  String transmissionNoLink_name="";

    private String lat,log,time;
    private TextView tv_precount;
    private TextView tv_aftercount;
    private Button btn_save,notranslink_btnnext;
    private DatabaseHandler db;


    public TransmissionNoLinkFragment() {
        // Required empty public constructor
    }

    public static TransmissionNoLinkFragment newInstance(int index, String name) {
        TransmissionNoLinkFragment f = new TransmissionNoLinkFragment();
        Bundle args = new Bundle();
        args.putInt("index", index);
        args.putString("name", name);
        f.setArguments(args);
        return f;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_transmission_no_link, container, false);
        transmissionNoLink_name = getArguments().getString("name");
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
        int precount = db.getCountLOSTransmissionNOLink();
        tv_precount.setText(tv_precount.getText().toString()+precount+"");
        return v;
    }
    private void findIds(View v) {

       edt_SiteID = v.findViewById(R.id.transnolink_edt_siteid);
       edt_Sitename = v.findViewById(R.id.transnolink_edt_sitename);
       edt_ObstructionDetails = v.findViewById(R.id.transnolink_edt_obstructiondetail);
       edt_Azimuth= v.findViewById(R.id.transnolink_edt_azimuth);
       edt_Distance = v.findViewById(R.id.transnolink_edt_distance);
       edt_AntennaHeight = v.findViewById(R.id.transnolink_edt_antennaheight);
       edt_Altitude = v.findViewById(R.id.transnolink_edt_altitude);
       btn_save = v.findViewById(R.id.transnolink_btn_save);
       notranslink_btnnext = v.findViewById(R.id.transnolink_btnnext);
        tv_precount = v.findViewById(R.id.transnolink_tv_count_previous);
        tv_aftercount = v.findViewById(R.id.transnolink_tv_aftercount);

       ib_SiteID = v.findViewById(R.id.transnolink_ib_siteid);
        ib_Sitename = v.findViewById(R.id.transnolink_ib_sitename);
        ib_ObstructionDetails= v.findViewById(R.id.transnolink_ib_obstructiondetail);
        ib_Azimuth= v.findViewById(R.id.transnolink_ib_azimuth);
        ib_Distance = v.findViewById(R.id.transnolink_ib_distance);
        ib_AntennaHeight = v.findViewById(R.id.transnolink_ib_antennaheight);
        ib_Altitude= v.findViewById(R.id.transnolink_ib_altitude);

        iv_SiteID= v.findViewById(R.id.transnolink_iv_siteid);
        iv_Sitename= v.findViewById(R.id.transnolink_iv_sitename);
        iv_ObstructionDetails= v.findViewById(R.id.transnolink_iv_obstructiondetail);
        iv_Azimuth= v.findViewById(R.id.transnolink_iv_azimuth);
        iv_Distance= v.findViewById(R.id.transnolink_iv_distance);
         iv_AntennaHeight= v.findViewById(R.id.transnolink_iv_antennaheight);
         iv_Altitude= v.findViewById(R.id.transnolink_iv_altitude);

        ib_SiteID.setOnClickListener(this);
        ib_Sitename.setOnClickListener(this);
        ib_ObstructionDetails.setOnClickListener(this);
        ib_Azimuth.setOnClickListener(this);
        ib_Distance.setOnClickListener(this);
        ib_AntennaHeight.setOnClickListener(this);
        ib_Altitude.setOnClickListener(this);
        btn_save.setOnClickListener(this);
        notranslink_btnnext.setOnClickListener(this);



    }


    @Override
    public void onClick(View view) {

        if(view == ib_SiteID){
            selectImage("1");
        }
        if(view == ib_Sitename){
            selectImage("2");
        }
        if(view == ib_ObstructionDetails){
            selectImage("3");
        }
        if(view == ib_Azimuth){
            selectImage("4");
        }
        if(view == ib_Distance){
            selectImage("5");
        }
        if(view == ib_AntennaHeight){
            selectImage("6");
        }
        if(view == ib_Altitude){
            selectImage("7");
        }

        if(view == btn_save){


           db.insertLOSTransmissionNOLinkData(new TransmissionNoLinkData( edt_SiteID.getText()+"",  edt_Sitename.getText()+"",  edt_ObstructionDetails.getText()+"",  edt_Azimuth.getText()+"",  edt_Distance.getText()+"",  edt_AntennaHeight.getText()+"",  edt_Altitude.getText()+"",  img_SiteID,  img_Sitename,  img_ObstructionDetails,  img_Azimuth,  img_Distance,  img_AntennaHeight,  img_Altitude, transmissionNoLink_name,  time,  1));

                int aftercount = db.getCountLOSTransmissionNOLink();
                tv_aftercount.setText(aftercount+"");

            Toast.makeText(getActivity(),transmissionNoLink_name,Toast.LENGTH_LONG).show();
            if(transmissionNoLink_name.equalsIgnoreCase( "NoLink6"))
            {
                notranslink_btnnext.setVisibility(View.VISIBLE);
            }

        }
        if(view == notranslink_btnnext){
           getFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag,SitePanoramicFragment.newInstance(2000)).commit();


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
                iv_Sitename.setImageBitmap(out);
                //  imgBearing30 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_Sitename = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                Log.v("img-encode", img_Sitename);
            }
        }
        if (name.equals("3")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_ObstructionDetails.setImageBitmap( out);
                //  imgBearing60 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_ObstructionDetails = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                Log.v("img-encode", img_ObstructionDetails);
            }
        }
        if (name.equals("4")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_Azimuth.setImageBitmap( out);
                //   imgBearing90 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_Azimuth = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                Log.v("img-encode", img_Azimuth);
            }
        }
        if (name.equals("5")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_Distance.setImageBitmap( out);
                //  imgBearing120 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_Distance = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                Log.v("img-encode", img_Distance);
            }
        }
        if (name.equals("6")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_AntennaHeight.setImageBitmap( out);
                //    imgBearing150 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_AntennaHeight = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                Log.v("img-encode", img_AntennaHeight);
            }
        }
        if (name.equals("7")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_Altitude.setImageBitmap( out);
                //     imgBearing180 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_Altitude = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                Log.v("img-encode", img_Altitude);
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
