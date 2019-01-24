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
import com.linkquest.lhq.SiteAudit.SectorDetailFragment;
import com.linkquest.lhq.SiteAudit.SitePanoramicFragment;
import com.linkquest.lhq.activity.CameraSurfaceViewActivity;
import com.linkquest.lhq.database.DatabaseHandler;
import com.linkquest.lhq.database.LOSSiteDetailData;
import com.linkquest.lhq.database.TransmissionLinkData;

import java.io.ByteArrayOutputStream;

import static android.app.Activity.RESULT_CANCELED;

/**
 * A simple {@link Fragment} subclass.
 */
public class TransmissionLinkFragment extends Fragment implements View.OnClickListener {

    private  EditText edt_SiteID;
    private  EditText edt_Sitename;
    private  EditText edt_Latitude;
    private  EditText edt_Longitude;
    private  EditText edt_Azimuthfromnearend;
    private  EditText edt_Distance;
    private  EditText edt_AntennaHeightatFarend;
    private  EditText edt_PoleFixtureRequirementatFarend;
    private  EditText edt_IFLengthatFarend;
    private  EditText edt_BuildingHeightatFarend;
    private  EditText edt_TotalhtForGBTRTTRTPATFarEnd;
    private  EditText edt_AMSLatFarEnd;

    private  ImageButton ib_SiteID;
    private  ImageButton ib_Sitename;
    private  ImageButton ib_Azimuthfromnearend;
    private  ImageButton ib_Distance;
    private  ImageButton ib_AntennaHeightatFarend;
    private  ImageButton ib_PoleFixtureRequirementatFarend;
    private  ImageButton ib_IFLengthatFarend;
    private  ImageButton ib_BuildingHeightatFarend;
    private  ImageButton ib_TotalhtForGBTRTTRTPATFarEnd;
    private  ImageButton ib_AMSLatFarEnd;

    private  ImageView iv_SiteID;
    private  ImageView iv_Sitename;
    private  ImageView iv_Azimuthfromnearend;
    private  ImageView iv_Distance;
    private  ImageView iv_AntennaHeightatFarend;
    private  ImageView iv_PoleFixtureRequirementatFarend;
    private  ImageView iv_IFLengthatFarend;
    private  ImageView iv_BuildingHeightatFarend;
    private  ImageView iv_TotalhtForGBTRTTRTPATFarEnd;
    private  ImageView iv_AMSLatFarEnd;

    private  String img_SiteID ="";
    private  String img_Sitename ="";
    private  String img_Azimuthfromnearend ="";
    private  String img_Distance ="";
    private  String img_AntennaHeightatFarend ="";
    private  String img_PoleFixtureRequirementatFarend ="";
    private  String img_IFLengthatFarend ="";
    private  String img_BuildingHeightatFarend ="";
    private  String img_TotalhtForGBTRTTRTPATFarEnd ="";
    private  String img_AMSLatFarEnd="";

    private String transName  ="";
    private String lat ,log,time;
    private TextView tv_precount;
    private TextView tv_aftercount;
    private Button btn_save,translink_btnnext;
    private DatabaseHandler db;


    public TransmissionLinkFragment() {
        // Required empty public constructor
    }
    public static TransmissionLinkFragment newInstance(int index, String name) {
        TransmissionLinkFragment f = new TransmissionLinkFragment();
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
        View v = inflater.inflate(R.layout.fragment_transmission_link, container, false);
        transName = getArguments().getString("name");
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
        int precount = db.getCountLOSTransmissionLink();
        tv_precount.setText(tv_precount.getText().toString()+precount+"");
        return v;
    }

    private void findIds(View v){
        edt_SiteID = v.findViewById(R.id.translink_edt_sectorid);
        edt_Sitename = v.findViewById(R.id.translink_edt_sectorname);
        edt_Latitude = v.findViewById(R.id.translink_edt_lat);
        edt_Longitude = v.findViewById(R.id.translink_edt_long);
        edt_Azimuthfromnearend = v.findViewById(R.id.translink_edt_Azimuthfromnearend);
        edt_Distance = v.findViewById(R.id.translink_edt_distance);
        edt_AntennaHeightatFarend = v.findViewById(R.id.translink_edt_AHAF);
        edt_PoleFixtureRequirementatFarend = v.findViewById(R.id.translink_edt_pole_fixture);
        edt_IFLengthatFarend = v.findViewById(R.id.translink_edt_ILAF);
        edt_BuildingHeightatFarend = v.findViewById(R.id.translink_edt_buildingheight);
        edt_TotalhtForGBTRTTRTPATFarEnd = v.findViewById(R.id.translink_edt_totalheight);
        edt_AMSLatFarEnd = v.findViewById(R.id.translink_edt_AMSL);
        tv_precount = v.findViewById(R.id.translink_tv_count_previous);
        tv_aftercount = v.findViewById(R.id.translink_tv_aftercount);
        btn_save = v.findViewById(R.id.translink_btn_save);
        translink_btnnext = v.findViewById(R.id.translink_btnnext);

        ib_SiteID = v.findViewById(R.id.translink_ib_sectorid);
        ib_Sitename = v.findViewById(R.id.translink_ib_sectorname);
        ib_Azimuthfromnearend = v.findViewById(R.id.translink_ib_Azimuthfromnearend);
        ib_Distance = v.findViewById(R.id.translink_ib_distance);
        ib_AntennaHeightatFarend = v.findViewById(R.id.translink_ib_AHAF);
        ib_PoleFixtureRequirementatFarend = v.findViewById(R.id.translink_ib_pole_fixture);
        ib_IFLengthatFarend = v.findViewById(R.id.translink_ib_ILAF);
        ib_BuildingHeightatFarend = v.findViewById(R.id.translink_ib_buildingheight);
        ib_TotalhtForGBTRTTRTPATFarEnd = v.findViewById(R.id.translink_ib_totalheight);
        ib_AMSLatFarEnd = v.findViewById(R.id.translink_ib_AMSL);

        iv_SiteID = v.findViewById(R.id.translink_iv_sectorid);
        iv_Sitename = v.findViewById(R.id.translink_iv_sectorname);
        iv_Azimuthfromnearend = v.findViewById(R.id.translink_iv_Azimuthfromnearend);
        iv_Distance = v.findViewById(R.id.translink_iv_distance);
        iv_AntennaHeightatFarend = v.findViewById(R.id.translink_iv_AHAF);
        iv_PoleFixtureRequirementatFarend = v.findViewById(R.id.translink_iv_pole_fixture);
        iv_IFLengthatFarend = v.findViewById(R.id.translink_iv_ILAF);
        iv_BuildingHeightatFarend = v.findViewById(R.id.translink_iv_buildingheight);
        iv_TotalhtForGBTRTTRTPATFarEnd = v.findViewById(R.id.translink_iv_totalheight);
        iv_AMSLatFarEnd = v.findViewById(R.id.translink_iv_AMSL);

        ib_SiteID.setOnClickListener(this);
        ib_Sitename.setOnClickListener(this);
        ib_Azimuthfromnearend.setOnClickListener(this);
        ib_Distance.setOnClickListener(this);
        ib_AntennaHeightatFarend.setOnClickListener(this);
        ib_PoleFixtureRequirementatFarend.setOnClickListener(this);
        ib_IFLengthatFarend.setOnClickListener(this);
        ib_BuildingHeightatFarend.setOnClickListener(this);
        ib_TotalhtForGBTRTTRTPATFarEnd.setOnClickListener(this);
        ib_AMSLatFarEnd.setOnClickListener(this);
        btn_save.setOnClickListener(this);
        translink_btnnext.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if(view == ib_SiteID){
            selectImage("1");
        }
        if(view == ib_Sitename){
            selectImage("2");
        }
        if(view == ib_Azimuthfromnearend){
            selectImage("3");
        }
        if(view == ib_Distance){
            selectImage("4");
        }
        if(view == ib_AntennaHeightatFarend){
            selectImage("5");
        }
        if(view == ib_PoleFixtureRequirementatFarend){
            selectImage("6");
        }
        if(view == ib_IFLengthatFarend){
            selectImage("7");
        }
        if(view == ib_BuildingHeightatFarend){
            selectImage("8");
        }
        if(view == ib_TotalhtForGBTRTTRTPATFarEnd){
            selectImage("9");
        }
        if(view == ib_AMSLatFarEnd){
            selectImage("10");
        }
        if(view == btn_save){

       db.insertLOSTransmissionLinkData( new TransmissionLinkData(edt_SiteID.getText()+"",edt_Sitename.getText()+"",  edt_Latitude.getText()+"", edt_Longitude.getText()+"",  edt_Azimuthfromnearend.getText()+"",  edt_Distance.getText()+"",  edt_AntennaHeightatFarend.getText()+"", edt_PoleFixtureRequirementatFarend.getText()+"",  edt_IFLengthatFarend.getText().toString(),  edt_BuildingHeightatFarend.getText()+"",  edt_TotalhtForGBTRTTRTPATFarEnd.getText()+"", edt_AMSLatFarEnd.getText()+"",
             img_SiteID,  img_Sitename,  img_Azimuthfromnearend, img_Distance, img_AntennaHeightatFarend, img_PoleFixtureRequirementatFarend, img_IFLengthatFarend, img_BuildingHeightatFarend, img_TotalhtForGBTRTTRTPATFarEnd, img_AMSLatFarEnd, transName,  time,  1));

           int aftercount = db.getCountLOSTransmissionLink();
           tv_aftercount.setText(aftercount+"");

            Toast.makeText(getActivity(),transName,Toast.LENGTH_LONG).show();
            if(transName.equalsIgnoreCase( "Link6"))
            {
                translink_btnnext.setVisibility(View.VISIBLE);
            }

        }
        if(view == translink_btnnext){
            getFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag,new TabTransmissionNoLinkFragment()).addToBackStack(null).commit();


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
        }
    }

    private void onCameraSurfaceViewActivity(String thumbnail, String name, String angle) {

        if (name.equals("1")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_SiteID.setImageBitmap( out);
                img_SiteID = thumbnail;
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
                img_Sitename = thumbnail;
                Log.v("img-encode", img_Sitename);
            }
        }
        if (name.equals("3")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_Azimuthfromnearend.setImageBitmap( out);
                //  imgBearing60 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_Azimuthfromnearend = thumbnail;
                Log.v("img-encode", img_Azimuthfromnearend);
            }
        }
        if (name.equals("4")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_Distance.setImageBitmap( out);
                //   imgBearing90 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_Distance = thumbnail;
                Log.v("img-encode", img_Distance);
            }
        }
        if (name.equals("5")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_AntennaHeightatFarend.setImageBitmap( out);
                //  imgBearing120 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_AntennaHeightatFarend = thumbnail;
                Log.v("img-encode", img_AntennaHeightatFarend);
            }
        }
        if (name.equals("6")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_PoleFixtureRequirementatFarend.setImageBitmap( out);
                //    imgBearing150 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_PoleFixtureRequirementatFarend = thumbnail;
                Log.v("img-encode", img_PoleFixtureRequirementatFarend);
            }
        }
        if (name.equals("7")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_IFLengthatFarend.setImageBitmap( out);
                //     imgBearing180 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_IFLengthatFarend = thumbnail;
                Log.v("img-encode", img_IFLengthatFarend);
            }
        }
        if (name.equals("8")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_BuildingHeightatFarend.setImageBitmap( out);
                //   imgBearing210 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_BuildingHeightatFarend = thumbnail;
                Log.v("img-encode", img_BuildingHeightatFarend);
            }
        }
        if (name.equals("9")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_TotalhtForGBTRTTRTPATFarEnd.setImageBitmap( out);
                // imgBearing240 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_TotalhtForGBTRTTRTPATFarEnd = thumbnail;
                Log.v("img-encode", img_TotalhtForGBTRTTRTPATFarEnd);
            }
        }
        if (name.equals("10")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_AMSLatFarEnd.setImageBitmap( out);
                //    imgBearing270 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_AMSLatFarEnd = thumbnail;
                Log.v("img-encode", img_AMSLatFarEnd);
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
