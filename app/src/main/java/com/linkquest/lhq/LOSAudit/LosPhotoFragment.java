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
import com.linkquest.lhq.database.LosPhotoData;

import java.io.ByteArrayOutputStream;

import static android.app.Activity.RESULT_CANCELED;

/**
 * A simple {@link Fragment} subclass.
 */
public class LosPhotoFragment extends Fragment implements  View.OnClickListener{

    private ImageButton ib_NearEndFarEndphoto1;
    private ImageButton ib_FarEndtoNearEndphoto1;
    private ImageButton ib_TowerPhoto1;
    private ImageButton ib_NearEndtoFarEndphoto2;
    private ImageButton ib_FarEndNearEndphoto2;
    private ImageButton ib_TowerPhoto2;
    private ImageButton ib_NearEndFarEndphoto3;
    private ImageButton ib_FarEndtoNearEndphoto3;
    private ImageButton ib_TowerPhoto3;
    private ImageButton ib_NearEndtoFarEndphoto4;
    private ImageButton ib_FarEndtoNearEndphoto4;
    private ImageButton ib_TowerPhoto4;

    private ImageView iv_NearEndFarEndphoto1;
    private ImageView iv_FarEndtoNearEndphoto1;
    private ImageView iv_TowerPhoto1;
    private ImageView iv_NearEndtoFarEndphoto2;
    private ImageView iv_FarEndNearEndphoto2;
    private ImageView iv_TowerPhoto2;
    private ImageView iv_NearEndFarEndphoto3;
    private ImageView iv_FarEndtoNearEndphoto3;
    private ImageView iv_TowerPhoto3;
    private ImageView iv_NearEndtoFarEndphoto4;
    private ImageView iv_FarEndtoNearEndphoto4;
    private ImageView iv_TowerPhoto4;

    private String img_NearEndFarEndphoto1 = "";
    private String  img_FarEndtoNearEndphoto1 = "";
    private String img_TowerPhoto1 = "";
    private String img_NearEndtoFarEndphoto2 = "";
    private String img_FarEndNearEndphoto2 = "";
    private String img_TowerPhoto2 = "";
    private String img_NearEndFarEndphoto3 = "";
    private String img_FarEndtoNearEndphoto3 = "";
    private String  img_TowerPhoto3 = "";
    private String img_NearEndtoFarEndphoto4 = "";
    private String img_FarEndtoNearEndphoto4 = "";
    private String img_TowerPhoto4 = "";


    private String date;
    private DatabaseHandler db;
    private String lat, log, time;

    private Button btnsave;
    private Button btnUNext;
    private TextView tv_count;
    private TextView tv_count_previous;




    public LosPhotoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_los_photo, container, false);
        db = new DatabaseHandler(getActivity());
        findIds(v);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                time = DateFormat.format("dd-MM-yyyy h:mm:ss:aa", System.currentTimeMillis()).toString();
                handler.postDelayed(this, 1000);
            }

        }, 1000);
        int count = db.getCountLosPhotos();
        tv_count_previous.setText(tv_count_previous.getText().toString()+count+"");
        return v;
    }

    private void findIds(View v){

        ib_NearEndFarEndphoto1 = v.findViewById(R.id.ib_NearEndFarEndphoto1);
        ib_FarEndtoNearEndphoto1= v.findViewById(R.id.ib_FarEndtoNearEndphoto1);
        ib_TowerPhoto1= v.findViewById(R.id.ib_TowerPhoto1);
        ib_NearEndtoFarEndphoto2= v.findViewById(R.id.ib_NearEndtoFarEndphoto2);
        ib_FarEndNearEndphoto2= v.findViewById(R.id.ib_FarEndNearEndphoto2);
        ib_TowerPhoto2= v.findViewById(R.id.ib_TowerPhoto2);
        ib_NearEndFarEndphoto3= v.findViewById(R.id.ib_NearEndFarEndphoto3);
        ib_FarEndtoNearEndphoto3= v.findViewById(R.id.ib_FarEndNearEndphoto3);
        ib_TowerPhoto3= v.findViewById(R.id.ib_TowerPhoto3);
        ib_NearEndtoFarEndphoto4= v.findViewById(R.id.ib_NearEndFarEndphoto4);
        ib_FarEndtoNearEndphoto4= v.findViewById(R.id.ib_FarEndNearEndphoto4);
        ib_TowerPhoto4= v.findViewById(R.id.ib_TowerPhoto4);

        btnsave= v.findViewById(R.id.btnsave);
        btnUNext= v.findViewById(R.id.btnnext);
        tv_count_previous= v.findViewById(R.id.tv_count_previous);
        tv_count = v.findViewById(R.id.tv_count);



        iv_NearEndFarEndphoto1 = v.findViewById(R.id.iv_NearEndFarEndphoto1);
        iv_FarEndtoNearEndphoto1= v.findViewById(R.id.iv_FarEndtoNearEndphoto1);
        iv_TowerPhoto1= v.findViewById(R.id.iv_TowerPhoto1);
        iv_NearEndtoFarEndphoto2= v.findViewById(R.id.iv_NearEndtoFarEndphoto2);
        iv_FarEndNearEndphoto2= v.findViewById(R.id.iv_FarEndNearEndphoto2);
        iv_TowerPhoto2= v.findViewById(R.id.iv_TowerPhoto2);
        iv_NearEndFarEndphoto3= v.findViewById(R.id.iv_NearEndFarEndphoto3);
        iv_FarEndtoNearEndphoto3= v.findViewById(R.id.iv_FarEndNearEndphoto3);
        iv_TowerPhoto3= v.findViewById(R.id.iv_TowerPhoto3);
        iv_NearEndtoFarEndphoto4= v.findViewById(R.id.iv_NearEndFarEndphoto4);
        iv_FarEndtoNearEndphoto4= v.findViewById(R.id.iv_FarEndNearEndphoto4);
        iv_TowerPhoto4= v.findViewById(R.id.iv_TowerPhoto4);

        ib_NearEndFarEndphoto1.setOnClickListener(this);
        ib_FarEndtoNearEndphoto1.setOnClickListener(this);
        ib_TowerPhoto1.setOnClickListener(this);
        ib_NearEndtoFarEndphoto2.setOnClickListener(this);
        ib_FarEndNearEndphoto2.setOnClickListener(this);
        ib_TowerPhoto2.setOnClickListener(this);
        ib_NearEndFarEndphoto3.setOnClickListener(this);
        ib_FarEndtoNearEndphoto3.setOnClickListener(this);
        ib_TowerPhoto3.setOnClickListener(this);
        ib_NearEndtoFarEndphoto4.setOnClickListener(this);
        ib_FarEndtoNearEndphoto4.setOnClickListener(this);
        ib_TowerPhoto4.setOnClickListener(this);
        btnsave.setOnClickListener(this);
        btnUNext.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
       if (view ==ib_NearEndFarEndphoto1){
           selectImage("1");
       }
        if (view ==ib_FarEndtoNearEndphoto1){

            selectImage("2");
        }
        if (view ==ib_TowerPhoto1){
            selectImage("3");

        }
        if (view ==ib_NearEndtoFarEndphoto2){
            selectImage("4");

        }
        if (view ==ib_FarEndNearEndphoto2){

            selectImage("5");
        }
        if (view ==ib_TowerPhoto2){

            selectImage("6");
        }
        if (view ==ib_NearEndFarEndphoto3){

            selectImage("7");
        }
        if (view ==ib_FarEndtoNearEndphoto3){

            selectImage("8");
        }
        if (view ==ib_TowerPhoto3){

            selectImage("9");
        }
        if (view ==ib_NearEndtoFarEndphoto4){
            selectImage("10");

        }
        if (view ==ib_FarEndtoNearEndphoto4){

            selectImage("11");
        }
        if (view ==ib_TowerPhoto4){

            selectImage("12");
        }
        if (view ==btnsave){

           db.insertLosPhotos(new LosPhotoData( img_NearEndFarEndphoto1,  img_FarEndtoNearEndphoto1,  img_TowerPhoto1,  img_NearEndtoFarEndphoto2, img_FarEndNearEndphoto2,img_TowerPhoto2,  img_NearEndFarEndphoto3, img_FarEndtoNearEndphoto3, img_TowerPhoto3, img_NearEndtoFarEndphoto4,  img_NearEndtoFarEndphoto4,  img_TowerPhoto4,  date, 1));
           int count = db.getCountLosPhotos();
           tv_count.setText(count+"");
        }
        if (view ==btnUNext){

            getFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag,new LOSOtherFragment()).addToBackStack(null).commit();
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
                // onCaptureImageResult(data, "7");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "8", angle);
            }
            if (requestCode == 9) {
                // onCaptureImageResult(data, "7");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "9", angle);
            }
            if (requestCode == 10) {
                // onCaptureImageResult(data, "7");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "10", angle);
            }
            if (requestCode == 11) {
                // onCaptureImageResult(data, "7");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "11", angle);
            }
            if (requestCode == 12) {
                // onCaptureImageResult(data, "7");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "12", angle);
            }

        }
    }

    private void onCameraSurfaceViewActivity(String thumbnail, String name, String angle) {

        if (name.equals("1")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_NearEndFarEndphoto1.setImageBitmap( out);
                img_NearEndFarEndphoto1 = thumbnail;
                Log.v("img-encode", img_NearEndFarEndphoto1);
            }
        }
        if (name.equals("2")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_FarEndtoNearEndphoto1.setImageBitmap(out);
                //  imgBearing30 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_FarEndtoNearEndphoto1 = thumbnail;
                Log.v("img-encode", img_FarEndtoNearEndphoto1);
            }
        }
        if (name.equals("3")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_TowerPhoto1.setImageBitmap( out);
                //  imgBearing60 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_TowerPhoto1 = thumbnail;
                Log.v("img-encode", img_TowerPhoto1);
            }
        }
        if (name.equals("4")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_NearEndtoFarEndphoto2.setImageBitmap( out);
                //   imgBearing90 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_NearEndtoFarEndphoto2 = thumbnail;
                Log.v("img-encode", img_NearEndtoFarEndphoto2);
            }
        }
        if (name.equals("5")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_FarEndNearEndphoto2.setImageBitmap( out);
                //  imgBearing120 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_FarEndNearEndphoto2 = thumbnail;
                Log.v("img-encode", img_FarEndNearEndphoto2);
            }
        }
        if (name.equals("6")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_TowerPhoto2.setImageBitmap( out);
                //    imgBearing150 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_TowerPhoto2 = thumbnail;
                Log.v("img-encode", img_TowerPhoto2);
            }
        }
        if (name.equals("7")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_NearEndFarEndphoto3.setImageBitmap( out);
                //     imgBearing180 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_NearEndFarEndphoto3 = thumbnail;
                Log.v("img-encode", img_NearEndFarEndphoto3);
            }
        }
        if (name.equals("6")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_TowerPhoto2.setImageBitmap( out);
                //    imgBearing150 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_TowerPhoto2 = thumbnail;
                Log.v("img-encode", img_TowerPhoto2);
            }
        }
        if (name.equals("7")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_NearEndFarEndphoto3.setImageBitmap( out);
                //     imgBearing180 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_NearEndFarEndphoto3 = thumbnail;
                Log.v("img-encode", img_NearEndFarEndphoto3);
            }
        }
        if (name.equals("8")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_FarEndtoNearEndphoto3.setImageBitmap( out);
                //  imgBearing120 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_FarEndtoNearEndphoto3 = thumbnail;
                Log.v("img-encode", img_FarEndtoNearEndphoto3);
            }
        }
        if (name.equals("9")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_TowerPhoto3.setImageBitmap( out);
                //    imgBearing150 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_TowerPhoto3 = thumbnail;
                Log.v("img-encode", img_TowerPhoto3);
            }
        }
        if (name.equals("10")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_NearEndtoFarEndphoto4.setImageBitmap( out);
                //     imgBearing180 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_NearEndtoFarEndphoto4 = thumbnail;
                Log.v("img-encode", img_NearEndtoFarEndphoto4);
            }
        }
        if (name.equals("11")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_FarEndtoNearEndphoto4.setImageBitmap( out);
                //  imgBearing120 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_FarEndtoNearEndphoto4 = thumbnail;
                Log.v("img-encode", img_FarEndtoNearEndphoto4);
            }
        }
        if (name.equals("12")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                iv_TowerPhoto4.setImageBitmap( out);
                //    imgBearing150 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                img_TowerPhoto4 = thumbnail;
                Log.v("img-encode", img_TowerPhoto4);
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
