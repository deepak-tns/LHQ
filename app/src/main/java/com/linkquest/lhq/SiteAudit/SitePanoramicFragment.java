package com.linkquest.lhq.SiteAudit;


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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.linkquest.lhq.GoogleGPSService;
import com.linkquest.lhq.LOSAudit.LOSDetailFragment;
import com.linkquest.lhq.LOSAudit.LOSOtherFragment;
import com.linkquest.lhq.LOSAudit.LosPhotoFragment;
import com.linkquest.lhq.R;
import com.linkquest.lhq.activity.CameraSurfaceViewActivity;
import com.linkquest.lhq.database.DatabaseHandler;
import com.linkquest.lhq.database.SitePanoramicBlockingData;
import com.linkquest.lhq.database.SitePanoramicData;
import com.linkquest.lhq.database.SurveyForm;

import java.io.ByteArrayOutputStream;
import java.util.List;

import static android.app.Activity.RESULT_CANCELED;

/**
 * A simple {@link Fragment} subclass.
 */
public class SitePanoramicFragment extends Fragment  implements View.OnClickListener {

    TextView tvBearing0;
    TextView tvBearing30;
    TextView tvBearing60;
    TextView tvBearing90;
    TextView tvBearing120;
    TextView tvBearing150;
    TextView tvBearing180;
    TextView tvBearing210;
    TextView tvBearing240;
    TextView tvBearing270;
    TextView tvBearing300;
    TextView tvBearing330;

   ImageView imgBearing0Image;
   ImageView imgBearing30Image;
   ImageView imgBearing60Image;
   ImageView imgBearing90Image;
   ImageView imgBearing120Image;
   ImageView imgBearing150Image;
   ImageView imgBearing180Image;
   ImageView imgBearing210Image;
   ImageView imgBearing240Image;
   ImageView imgBearing270Image;
   ImageView imgBearing300Image;
   ImageView imgBearing330Image;

   ImageButton btnBearing0Image;
   ImageButton btnBearing30Image;
   ImageButton btnBearing60Image;
   ImageButton btnBearing90Image;
   ImageButton btnBearing120Image;
   ImageButton btnBearing150Image;
   ImageButton btnBearing180Image;
   ImageButton btnBearing210Image;
   ImageButton btnBearing240Image;
   ImageButton btnBearing270Image;
   ImageButton btnBearing300Image;
   ImageButton btnBearing330Image;

   EditText extra1;
   EditText extra2;
   EditText remark1;
   EditText remark2;

   Button btnSave;
   Button btnUpload;
   String lat, log;
   Handler handler;
   String time;

    String imgBearing0 ="";
    String imgBearing30 ="";
    String imgBearing60="";
    String imgBearing90="";
    String imgBearing120="";
    String imgBearing150="";
    String imgBearing180="";
    String imgBearing210="";
    String imgBearing240="";
    String imgBearing270="";
    String imgBearing300="";
    String imgBearing330="";

    CheckBox chkBlockingBearing0;
    CheckBox chkBlockingBearing30;
    CheckBox chkBlockingBearing60;
    CheckBox chkBlockingBearing90;
    CheckBox chkBlockingBearing120;
    CheckBox chkBlockingBearing150;
    CheckBox chkBlockingBearing180;
    CheckBox chkBlockingBearing210;
    CheckBox chkBlockingBearing240;
    CheckBox chkBlockingBearing270;
    CheckBox chkBlockingBearing300;
    CheckBox chkBlockingBearing330;

    String chktext0 ="";
    String chktext30 ="";
    String chktext60="";
    String chktext90="";
    String chktext120="";
    String chktext150="";
    String chktext180="";
    String chktext210="";
    String chktext240="";
    String chktext270="";
    String chktext300="";
    String chktext330 ="";

    TextView tv_sitepanaromic_count;
    TextView tv_sitepanaromic_count_previous;

    DatabaseHandler db;

    public SitePanoramicFragment() {
        // Required empty public constructor
    }

    public static SitePanoramicFragment newInstance(int index) {
        SitePanoramicFragment f = new SitePanoramicFragment();
        Bundle args = new Bundle();
        args.putInt("index", index);
        f.setArguments(args);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_site_panoramic, container, false);
        int arg = getArguments().getInt("index");
       // Toast.makeText(getActivity(), arg + "", Toast.LENGTH_LONG).show();
        db = new DatabaseHandler(getActivity());

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                time = DateFormat.format("dd-MM-yyyy h:mm:ss:aa", System.currentTimeMillis()).toString();
                handler.postDelayed(this, 1000);
            }

        }, 1000);
        findviewbyIDs( v);

        tv_sitepanaromic_count_previous.setText(tv_sitepanaromic_count_previous.getText().toString()+ db.getCountSitePanaromic());
        return v;
    }

    private void findviewbyIDs(View v){

         tvBearing0 = v.findViewById(R.id.tvBearing0);
         tvBearing30 = v.findViewById(R.id.tvBearing30);
         tvBearing60 = v.findViewById(R.id.tvBearing60);
         tvBearing90= v.findViewById(R.id.tvBearing90);
         tvBearing120 = v.findViewById(R.id.tvBearing120);
         tvBearing150= v.findViewById(R.id.tvBearing150);
         tvBearing180= v.findViewById(R.id.tvBearing180);
         tvBearing210= v.findViewById(R.id.tvBearing210);
         tvBearing240= v.findViewById(R.id.tvBearing240);
         tvBearing270= v.findViewById(R.id.tvBearing270);
         tvBearing300= v.findViewById(R.id.tvBearing300);
         tvBearing330= v.findViewById(R.id.tvBearing330);

         imgBearing0Image = v.findViewById(R.id.imgBearing0Image);
         imgBearing30Image = v.findViewById(R.id.imgBearing30Image);
         imgBearing60Image = v.findViewById(R.id.imgBearing60Image);
         imgBearing90Image = v.findViewById(R.id.imgBearing90Image);
         imgBearing120Image = v.findViewById(R.id.imgBearing120Image);
         imgBearing150Image = v.findViewById(R.id.imgBearing150Image);
         imgBearing180Image = v.findViewById(R.id.imgBearing180Image);
         imgBearing210Image = v.findViewById(R.id.imgBearing210Image);
         imgBearing240Image = v.findViewById(R.id.imgBearing240Image);
         imgBearing270Image = v.findViewById(R.id.imgBearing270Image);
         imgBearing300Image = v.findViewById(R.id.imgBearing300Image);
         imgBearing330Image = v.findViewById(R.id.imgBearing330Image);

         btnBearing0Image = v.findViewById(R.id.btnBearing0Image);
         btnBearing30Image = v.findViewById(R.id.btnBearing30Image);
         btnBearing60Image = v.findViewById(R.id.btnBearing60Image);
         btnBearing90Image = v.findViewById(R.id.btnBearing90Image);
         btnBearing120Image = v.findViewById(R.id.btnBearing120Image);
         btnBearing150Image = v.findViewById(R.id.btnBearing150Image);
         btnBearing180Image = v.findViewById(R.id.btnBearing180Image);
         btnBearing210Image = v.findViewById(R.id.btnBearing210Image);
         btnBearing240Image = v.findViewById(R.id.btnBearing240Image);
         btnBearing270Image = v.findViewById(R.id.btnBearing270Image);
         btnBearing300Image = v.findViewById(R.id.btnBearing300Image);
         btnBearing330Image = v.findViewById(R.id.btnBearing330Image);

        chkBlockingBearing0 = v.findViewById(R.id.inputIsBlockingBearing0);
        chkBlockingBearing30 = v.findViewById(R.id.inputIsBlockingBearing30);
        chkBlockingBearing60 = v.findViewById(R.id.inputIsBlockingBearing60);
        chkBlockingBearing90 = v.findViewById(R.id.inputIsBlockingBearing90);
        chkBlockingBearing120 = v.findViewById(R.id.inputIsBlockingBearing120);
        chkBlockingBearing150 = v.findViewById(R.id.inputIsBlockingBearing150);
        chkBlockingBearing180 = v.findViewById(R.id.inputIsBlockingBearing180);
        chkBlockingBearing210 = v.findViewById(R.id.inputIsBlockingBearing210);
        chkBlockingBearing240 = v.findViewById(R.id.inputIsBlockingBearing240);
        chkBlockingBearing270 = v.findViewById(R.id.inputIsBlockingBearing270);
        chkBlockingBearing300 = v.findViewById(R.id.inputIsBlockingBearing300);
        chkBlockingBearing330 = v.findViewById(R.id.inputIsBlockingBearing330);

         extra1  = v.findViewById(R.id.inputBearin_extra1);
         extra2  = v.findViewById(R.id.inputBearin_extra2);
         remark1 = v.findViewById(R.id.inputBearin_remark1);
         remark2 = v.findViewById(R.id.inputBearin_remark2);

        tv_sitepanaromic_count =v.findViewById(R.id.tv_sitepanaromic_count);
        tv_sitepanaromic_count_previous =v.findViewById(R.id.tv_sitepanaromic_count_previous);

        btnSave = v.findViewById(R.id.btnSave);
        btnUpload = v.findViewById(R.id.btnUpload);



        btnBearing0Image.setOnClickListener(this);
        btnBearing30Image.setOnClickListener(this);
        btnBearing60Image.setOnClickListener(this);
        btnBearing90Image.setOnClickListener(this);
        btnBearing120Image.setOnClickListener(this);
        btnBearing150Image.setOnClickListener(this);
        btnBearing180Image.setOnClickListener(this);
        btnBearing210Image.setOnClickListener(this);
        btnBearing240Image.setOnClickListener(this);
        btnBearing270Image.setOnClickListener(this);
        btnBearing300Image.setOnClickListener(this);
        btnBearing330Image.setOnClickListener(this);

        btnSave.setOnClickListener(this);
        btnUpload.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        if(v == btnBearing0Image){
         selectImage("1");
        }
        if(v == btnBearing30Image){
            selectImage("2");
        }
        if(v == btnBearing60Image){
            selectImage("3");
        }
        if(v == btnBearing90Image){
            selectImage("4");
        }
        if(v == btnBearing120Image){
            selectImage("5");
        }
        if(v == btnBearing150Image){
            selectImage("6");
        }
        if(v == btnBearing180Image){
            selectImage("7");
        }
        if(v == btnBearing210Image){
            selectImage("8");
        }
        if(v == btnBearing240Image){
            selectImage("9");
        }
        if(v == btnBearing270Image){
            selectImage("10");
        }
        if(v == btnBearing300Image){
            selectImage("11");
        }
        if(v == btnBearing330Image){
            selectImage("12");
        }

        if(v == btnSave){

            if(chkBlockingBearing0.isChecked())
            {
                chktext0="Blocking0";
            }else{
                 chktext0="UnBlocking0";
            }
            if(chkBlockingBearing30.isChecked())
            {
                chktext30="Blocking30";
            }else{
                chktext30="UnBlocking30";
            }
            if(chkBlockingBearing60.isChecked())
            {
                chktext60="Blocking60";
            }else{
                chktext60="UnBlocking60";
            }
            if(chkBlockingBearing90.isChecked())
            {
                chktext90="Blocking90";
            }else{
                chktext90="UnBlocking90";
            }
            if(chkBlockingBearing120.isChecked())
            {
                chktext120="Blocking120";
            }else{
                chktext120="UnBlocking120";
            }
            if(chkBlockingBearing150.isChecked())
            {
                chktext150="Blocking150";
            }else{
                chktext150="UnBlocking150";
            }
            if(chkBlockingBearing180.isChecked())
            {
                chktext180="Blocking180";
            }else{
                chktext180="UnBlocking180";
            }
            if(chkBlockingBearing210.isChecked())
            {
                chktext210="Blocking210";
            }else{
                chktext210="UnBlocking210";
            }
            if(chkBlockingBearing240.isChecked())
            {
                chktext240="Blocking240";
            }else{
                chktext240="UnBlocking240";
            }
            if(chkBlockingBearing270.isChecked())
            {
                chktext270="Blocking270";
            }else{
                chktext270="UnBlocking270";
            }
            if(chkBlockingBearing300.isChecked())
            {
                chktext300="Blocking300";
            }else{
                chktext300="UnBlocking300";
            }
            if(chkBlockingBearing330.isChecked())
            {
                chktext330="Blocking330";
            }else{
                chktext330="UnBlocking330";
            }

           db.insertSitePanoramicata(new SitePanoramicData(tvBearing0.getText().toString(),tvBearing30.getText().toString(),tvBearing60.getText().toString(),tvBearing90.getText().toString(),tvBearing120.getText().toString(),tvBearing150.getText().toString(),tvBearing180.getText().toString(),tvBearing210.getText().toString(),tvBearing240.getText().toString(),tvBearing270.getText().toString(),tvBearing300.getText().toString(),tvBearing330.getText().toString(),
                   imgBearing0,imgBearing30,imgBearing60,imgBearing90,imgBearing120,imgBearing150,imgBearing180,imgBearing210,imgBearing240,imgBearing270,imgBearing300,imgBearing330,extra1.getText().toString(),extra2.getText().toString(),remark1.getText().toString(),remark2.getText().toString(),1,time ));

            db.insertSitePanoramicBlockingata(new SitePanoramicBlockingData(chktext0,chktext30,chktext60,chktext90,chktext120,chktext150,chktext180,chktext210,chktext240,chktext270,chktext300,chktext330,1));

            int count = db.getCountSitePanaromic();
            tv_sitepanaromic_count.setText(count +"");
        }

        if(v== btnUpload){

            List<SurveyForm> listdata = db.getLastSurveyformData();
            String stSurveyType= listdata.get(0).getSurveytype();
            if (stSurveyType.equalsIgnoreCase("LOS Survey")) {
                getFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag, new LosPhotoFragment()).commit();

            }else {
                getFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag,new OtherFragment()).addToBackStack(null).commit();
            }
        }

    }

    private void selectImage(String Value) {

        if (Value.equals("1")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 1);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",1);
            startActivityForResult(i, 1);
        }
        if (Value.equals("2")) {
        /*    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 2);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",2);
            startActivityForResult(i, 2);
           /*
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_CHOOSER);
            startActivityForResult(Intent.createChooser(intent,"Select Picture"), 2);*/

        }
        if (Value.equals("3")) {
        /*    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 3);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",3);
            startActivityForResult(i, 3);
        }
        if (Value.equals("4")) {
     /*       Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 4);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",4);
            startActivityForResult(i, 4);
        }
        if (Value.equals("5")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 5);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",5);
            startActivityForResult(i, 5);
        }
        if (Value.equals("6")) {
           /* Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 6);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",6);
            startActivityForResult(i, 6);
        }
        if (Value.equals("7")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 7);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",7);
            startActivityForResult(i, 7);
        }
        if (Value.equals("8")) {
         /*   Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 8);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",8);
            startActivityForResult(i, 8);
        }
        if (Value.equals("9")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 9);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",9);
            startActivityForResult(i, 9);
        }
        if (Value.equals("10")) {
           /* Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 10);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",10);
            startActivityForResult(i, 10);
        }
        if (Value.equals("11")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 11);*/
            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",11);
            startActivityForResult(i, 11);
        }
        if (Value.equals("12")) {
          /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);*/
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
              //  onCaptureImageResult(data, "12");
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(path, "12", angle);
            }


        }
    }


/*    private void onCaptureImageResult(Intent data, String name) {

        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        //.........................................one.....................................
        if (name.equals("1")) {
            if (lat == null)
            {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString =time+ "\nLat :" + lat + "\nLong :" + log + "\n"+name;
                // Bitmap setTextwithImage =    ProcessingBitmap(thumbnail,totalString);
                Bitmap setTextwithImage = DrawBitmapAll.drawTextToBitmap(getContext(), thumbnail, totalString);
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                setTextwithImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                String destinationpath = Environment.getExternalStorageDirectory().toString();
                File destination = new File(destinationpath + "/LinkQuest/");
                if (!destination.exists()) {
                    destination.mkdirs();
                }
                File file = null;
                FileOutputStream fo;
                try {
                    // destination.createNewFile();
                    file = new File(destination,  time + ".jpg");
                    fo = new FileOutputStream(file);
                    fo.write(bytes.toByteArray());
                    fo.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                String path = (file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);
                imgBearing0 = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);
                imgBearing0Image.setImageBitmap(decodeBase64(imgBearing0));

                Log.v("img-encode",imgBearing0);

            }
        }
        //.........................................one.....................................
        //.........................................2.....................................
        if (name.equals("2")) {
            if (lat == null)
            {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString =time+ "\nLat :" + lat + "\nLong :" + log + "\n"+name;
                // Bitmap setTextwithImage =    ProcessingBitmap(thumbnail,totalString);
                Bitmap setTextwithImage = DrawBitmapAll.drawTextToBitmap(getContext(), thumbnail, totalString);
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                setTextwithImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                String destinationpath = Environment.getExternalStorageDirectory().toString();
                File destination = new File(destinationpath + "/LinkQuest/");
                if (!destination.exists()) {
                    destination.mkdirs();
                }
                File file = null;
                FileOutputStream fo;
                try {
                    // destination.createNewFile();
                    file = new File(destination,  time + ".jpg");
                    fo = new FileOutputStream(file);
                    fo.write(bytes.toByteArray());
                    fo.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                String path = (file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);
                imgBearing30 = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                imgBearing30Image.setImageBitmap(decodeBase64(imgBearing30));
                Log.v("img-encode",imgBearing30);

            }
        }
        //......................................2................................................................
        //.........................................3.....................................
        if (name.equals("3")) {
            if (lat == null)
            {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString =time+ "\nLat :" + lat + "\nLong :" + log + "\n"+name;
                // Bitmap setTextwithImage =    ProcessingBitmap(thumbnail,totalString);
                Bitmap setTextwithImage = DrawBitmapAll.drawTextToBitmap(getContext(), thumbnail, totalString);
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                setTextwithImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                String destinationpath = Environment.getExternalStorageDirectory().toString();
                File destination = new File(destinationpath + "/LinkQuest/");
                if (!destination.exists()) {
                    destination.mkdirs();
                }
                File file = null;
                FileOutputStream fo;
                try {
                    // destination.createNewFile();
                    file = new File(destination,  time + ".jpg");
                    fo = new FileOutputStream(file);
                    fo.write(bytes.toByteArray());
                    fo.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                String path = (file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);
                imgBearing60 = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                imgBearing60Image.setImageBitmap(decodeBase64(imgBearing60));
                Log.v("img-encode",imgBearing60);

            }
        }
        //......................................3................................................................
        //.........................................4.....................................
        if (name.equals("4")) {
            if (lat == null)
            {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString =time+ "\nLat :" + lat + "\nLong :" + log + "\n"+name;
                // Bitmap setTextwithImage =    ProcessingBitmap(thumbnail,totalString);
                Bitmap setTextwithImage = DrawBitmapAll.drawTextToBitmap(getContext(), thumbnail, totalString);
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                setTextwithImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                String destinationpath = Environment.getExternalStorageDirectory().toString();
                File destination = new File(destinationpath + "/LinkQuest/");
                if (!destination.exists()) {
                    destination.mkdirs();
                }
                File file = null;
                FileOutputStream fo;
                try {
                    // destination.createNewFile();
                    file = new File(destination,  time + ".jpg");
                    fo = new FileOutputStream(file);
                    fo.write(bytes.toByteArray());
                    fo.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                String path = (file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);
                imgBearing90 = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                imgBearing90Image.setImageBitmap(decodeBase64(imgBearing90));
                Log.v("img-encode",imgBearing90);

            }
        }
        //......................................4................................................................
        //.........................................5....................................
        if (name.equals("5")) {
            if (lat == null)
            {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString =time+ "\nLat :" + lat + "\nLong :" + log + "\n"+name;
                // Bitmap setTextwithImage =    ProcessingBitmap(thumbnail,totalString);
                Bitmap setTextwithImage = DrawBitmapAll.drawTextToBitmap(getContext(), thumbnail, totalString);
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                setTextwithImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                String destinationpath = Environment.getExternalStorageDirectory().toString();
                File destination = new File(destinationpath + "/LinkQuest/");
                if (!destination.exists()) {
                    destination.mkdirs();
                }
                File file = null;
                FileOutputStream fo;
                try {
                    // destination.createNewFile();
                    file = new File(destination,  time + ".jpg");
                    fo = new FileOutputStream(file);
                    fo.write(bytes.toByteArray());
                    fo.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                String path = (file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);
                imgBearing120 = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                imgBearing120Image.setImageBitmap(decodeBase64(imgBearing120));
                Log.v("img-encode",imgBearing120);
            }
        }
        //......................................5................................................................
        //.........................................6....................................
        if (name.equals("6")) {
            if (lat == null)
            {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString =time+ "\nLat :" + lat + "\nLong :" + log + "\n"+name;
                // Bitmap setTextwithImage =    ProcessingBitmap(thumbnail,totalString);
                Bitmap setTextwithImage = DrawBitmapAll.drawTextToBitmap(getContext(), thumbnail, totalString);
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                setTextwithImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                String destinationpath = Environment.getExternalStorageDirectory().toString();
                File destination = new File(destinationpath + "/LinkQuest/");
                if (!destination.exists()) {
                    destination.mkdirs();
                }
                File file = null;
                FileOutputStream fo;
                try {
                    // destination.createNewFile();
                    file = new File(destination,  time + ".jpg");
                    fo = new FileOutputStream(file);
                    fo.write(bytes.toByteArray());
                    fo.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                String path = (file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);
                imgBearing150 = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                imgBearing150Image.setImageBitmap(decodeBase64(imgBearing150));
                Log.v("img-encode",imgBearing150);
            }
        }
        //......................................6................................................................
        //.........................................7....................................
        if (name.equals("7")) {
            if (lat == null)
            {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString =time+ "\nLat :" + lat + "\nLong :" + log + "\n"+name;
                // Bitmap setTextwithImage =    ProcessingBitmap(thumbnail,totalString);
                Bitmap setTextwithImage = DrawBitmapAll.drawTextToBitmap(getContext(), thumbnail, totalString);
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                setTextwithImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                String destinationpath = Environment.getExternalStorageDirectory().toString();
                File destination = new File(destinationpath + "/LinkQuest/");
                if (!destination.exists()) {
                    destination.mkdirs();
                }
                File file = null;
                FileOutputStream fo;
                try {
                    // destination.createNewFile();
                    file = new File(destination,  time + ".jpg");
                    fo = new FileOutputStream(file);
                    fo.write(bytes.toByteArray());
                    fo.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                String path = (file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);
                imgBearing180 = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                imgBearing180Image.setImageBitmap(decodeBase64(imgBearing180));
                Log.v("img-encode",imgBearing180);
            }
        }
        //......................................7................................................................
        //.........................................8....................................
        if (name.equals("8")) {
            if (lat == null)
            {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString =time+ "\nLat :" + lat + "\nLong :" + log + "\n"+name;
                // Bitmap setTextwithImage =    ProcessingBitmap(thumbnail,totalString);
                Bitmap setTextwithImage = DrawBitmapAll.drawTextToBitmap(getContext(), thumbnail, totalString);
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                setTextwithImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                String destinationpath = Environment.getExternalStorageDirectory().toString();
                File destination = new File(destinationpath + "/LinkQuest/");
                if (!destination.exists()) {
                    destination.mkdirs();
                }
                File file = null;
                FileOutputStream fo;
                try {
                    // destination.createNewFile();
                    file = new File(destination,  time + ".jpg");
                    fo = new FileOutputStream(file);
                    fo.write(bytes.toByteArray());
                    fo.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                String path = (file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);
                imgBearing210 = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                imgBearing210Image.setImageBitmap(decodeBase64(imgBearing210));
                Log.v("img-encode",imgBearing210);
            }
        }
        //......................................8................................................................
        //.........................................9....................................
        if (name.equals("9")) {
            if (lat == null)
            {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString =time+ "\nLat :" + lat + "\nLong :" + log + "\n"+name;
                // Bitmap setTextwithImage =    ProcessingBitmap(thumbnail,totalString);
                Bitmap setTextwithImage = DrawBitmapAll.drawTextToBitmap(getContext(), thumbnail, totalString);
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                setTextwithImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                String destinationpath = Environment.getExternalStorageDirectory().toString();
                File destination = new File(destinationpath + "/LinkQuest/");
                if (!destination.exists()) {
                    destination.mkdirs();
                }
                File file = null;
                FileOutputStream fo;
                try {
                    // destination.createNewFile();
                    file = new File(destination,  time + ".jpg");
                    fo = new FileOutputStream(file);
                    fo.write(bytes.toByteArray());
                    fo.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                String path = (file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);
                imgBearing240 = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                imgBearing240Image.setImageBitmap(decodeBase64(imgBearing240));
                Log.v("img-encode",imgBearing240);
            }
        }

        //......................................9................................................................
        //.........................................10....................................
        if (name.equals("10")) {
            if (lat == null)
            {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString =time+ "\nLat :" + lat + "\nLong :" + log + "\n"+name;
                // Bitmap setTextwithImage =    ProcessingBitmap(thumbnail,totalString);
                Bitmap setTextwithImage = DrawBitmapAll.drawTextToBitmap(getContext(), thumbnail, totalString);
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                setTextwithImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                String destinationpath = Environment.getExternalStorageDirectory().toString();
                File destination = new File(destinationpath + "/LinkQuest/");
                if (!destination.exists()) {
                    destination.mkdirs();
                }
                File file = null;
                FileOutputStream fo;
                try {
                    // destination.createNewFile();
                    file = new File(destination,  time + ".jpg");
                    fo = new FileOutputStream(file);
                    fo.write(bytes.toByteArray());
                    fo.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                String path = (file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);
                imgBearing270 = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);
                imgBearing270Image.setImageBitmap(decodeBase64(imgBearing270));
                Log.v("img-encode",imgBearing270);
            }
        }
        //......................................10................................................................
        //.........................................11....................................
        if (name.equals("11")) {
            if (lat == null)
            {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString =time+ "\nLat :" + lat + "\nLong :" + log + "\n"+name;
                // Bitmap setTextwithImage =    ProcessingBitmap(thumbnail,totalString);
                Bitmap setTextwithImage = DrawBitmapAll.drawTextToBitmap(getContext(), thumbnail, totalString);
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                setTextwithImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                String destinationpath = Environment.getExternalStorageDirectory().toString();
                File destination = new File(destinationpath + "/LinkQuest/");
                if (!destination.exists()) {
                    destination.mkdirs();
                }
                File file = null;
                FileOutputStream fo;
                try {
                    // destination.createNewFile();
                    file = new File(destination,  time + ".jpg");
                    fo = new FileOutputStream(file);
                    fo.write(bytes.toByteArray());
                    fo.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                String path = (file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);
                imgBearing300 = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                imgBearing300Image.setImageBitmap(decodeBase64(imgBearing300));
                Log.v("img-encode",imgBearing300);
            }
        }
        //......................................11................................................................
        //.........................................12....................................
        if (name.equals("12")) {
            if (lat == null)
            {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString =time+ "\nLat :" + lat + "\nLong :" + log + "\n"+name;
                // Bitmap setTextwithImage =    ProcessingBitmap(thumbnail,totalString);
                Bitmap setTextwithImage = DrawBitmapAll.drawTextToBitmap(getContext(), thumbnail, totalString);
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                setTextwithImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                String destinationpath = Environment.getExternalStorageDirectory().toString();
                File destination = new File(destinationpath + "/LinkQuest/");
                if (!destination.exists()) {
                    destination.mkdirs();
                }
                File file = null;
                FileOutputStream fo;
                try {
                    // destination.createNewFile();
                    file = new File(destination,  time + ".jpg");
                    fo = new FileOutputStream(file);
                    fo.write(bytes.toByteArray());
                    fo.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                String path = (file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);
                imgBearing330 = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);
                imgBearing330Image.setImageBitmap(decodeBase64(imgBearing330));;
                Log.v("img-encode",imgBearing330);
            }
        }
        //......................................12...............................................................

    }*/

    private void onCameraSurfaceViewActivity(String thumbnail, String name, String angle) {

        if (name.equals("1")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
              /*  String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle + "\n"+"Blocking 0" ;
                // Bitmap setTextwithImage =    ProcessingBitmap(thumbnail,totalString);
                Bitmap setTextwithImage = DrawBitmapAll.drawTextToBitmap(getContext(), thumbnail, totalString);
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                setTextwithImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                String destinationpath = Environment.getExternalStorageDirectory().toString();
                File destination = new File(destinationpath + "/LinkQuest/");
                if (!destination.exists()) {
                    destination.mkdirs();
                }
                File file = null;
                FileOutputStream fo;
                try {
                    // destination.createNewFile();
                    file = new File(destination, time + ".jpg");
                    fo = new FileOutputStream(file);
                    fo.write(bytes.toByteArray());
                    fo.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                String path = (file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));*/
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);
               // imgBearing0 = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                imgBearing0Image.setImageBitmap( out);
            //    imgBearing0 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 50);
                 imgBearing0 = thumbnail;
                Log.v("img-encode", imgBearing0);
            }
        }
        if (name.equals("2")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                /*String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle + "\n"+"Blocking 30";
                // Bitmap setTextwithImage =    ProcessingBitmap(thumbnail,totalString);
                Bitmap setTextwithImage = DrawBitmapAll.drawTextToBitmap(getContext(), thumbnail, totalString);
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                setTextwithImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                String destinationpath = Environment.getExternalStorageDirectory().toString();
                File destination = new File(destinationpath + "/LinkQuest/");
                if (!destination.exists()) {
                    destination.mkdirs();
                }
                File file = null;
                FileOutputStream fo;
                try {
                    // destination.createNewFile();
                    file = new File(destination, time + ".jpg");
                    fo = new FileOutputStream(file);
                    fo.write(bytes.toByteArray());
                    fo.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                String path = (file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);
                imgBearing30 = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);
                imgBearing30Image.setImageBitmap(decodeBase64(imgBearing30));*/
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                imgBearing30Image.setImageBitmap(out);
              //  imgBearing30 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                imgBearing30 = thumbnail;
                Log.v("img-encode", imgBearing30);
            }
        }
        if (name.equals("3")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
          /*      String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle + "\n"+"Blocking 60";
                // Bitmap setTextwithImage =    ProcessingBitmap(thumbnail,totalString);
                Bitmap setTextwithImage = DrawBitmapAll.drawTextToBitmap(getContext(), thumbnail, totalString);
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                setTextwithImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                String destinationpath = Environment.getExternalStorageDirectory().toString();
                File destination = new File(destinationpath + "/LinkQuest/");
                if (!destination.exists()) {
                    destination.mkdirs();
                }
                File file = null;
                FileOutputStream fo;
                try {
                    // destination.createNewFile();
                    file = new File(destination, time + ".jpg");
                    fo = new FileOutputStream(file);
                    fo.write(bytes.toByteArray());
                    fo.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                String path = (file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);
                imgBearing60 = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);
                imgBearing60Image.setImageBitmap(decodeBase64(imgBearing60));*/
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                imgBearing60Image.setImageBitmap( out);
              //  imgBearing60 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                imgBearing60 = thumbnail;
                Log.v("img-encode", imgBearing60);
            }
        }
        if (name.equals("4")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
          /*      String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle + "\n"+"Blocking 90";
                // Bitmap setTextwithImage =    ProcessingBitmap(thumbnail,totalString);
                Bitmap setTextwithImage = DrawBitmapAll.drawTextToBitmap(getContext(), thumbnail, totalString);
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                setTextwithImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                String destinationpath = Environment.getExternalStorageDirectory().toString();
                File destination = new File(destinationpath + "/LinkQuest/");
                if (!destination.exists()) {
                    destination.mkdirs();
                }
                File file = null;
                FileOutputStream fo;
                try {
                    // destination.createNewFile();
                    file = new File(destination, time + ".jpg");
                    fo = new FileOutputStream(file);
                    fo.write(bytes.toByteArray());
                    fo.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                String path = (file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);
                imgBearing90 = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);
                imgBearing90Image.setImageBitmap(decodeBase64(imgBearing90));*/
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                imgBearing90Image.setImageBitmap( out);
             //   imgBearing90 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                imgBearing90 = thumbnail;
                Log.v("img-encode", imgBearing90);
            }
        }
        if (name.equals("5")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
             /*   String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 120";
                // Bitmap setTextwithImage =    ProcessingBitmap(thumbnail,totalString);
                Bitmap setTextwithImage = DrawBitmapAll.drawTextToBitmap(getContext(), thumbnail, totalString);
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                setTextwithImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                String destinationpath = Environment.getExternalStorageDirectory().toString();
                File destination = new File(destinationpath + "/LinkQuest/");
                if (!destination.exists()) {
                    destination.mkdirs();
                }
                File file = null;
                FileOutputStream fo;
                try {
                    // destination.createNewFile();
                    file = new File(destination, time + ".jpg");
                    fo = new FileOutputStream(file);
                    fo.write(bytes.toByteArray());
                    fo.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                String path = (file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);
                imgBearing120 = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);
                imgBearing120Image.setImageBitmap(decodeBase64(imgBearing120));*/

                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                imgBearing120Image.setImageBitmap( out);
              //  imgBearing120 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                imgBearing120 = thumbnail;
                Log.v("img-encode", imgBearing120);
            }
        }
        if (name.equals("6")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                /*String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle + "\n"+"Blocking 150";
                // Bitmap setTextwithImage =    ProcessingBitmap(thumbnail,totalString);
                Bitmap setTextwithImage = DrawBitmapAll.drawTextToBitmap(getContext(), thumbnail, totalString);
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                setTextwithImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                String destinationpath = Environment.getExternalStorageDirectory().toString();
                File destination = new File(destinationpath + "/LinkQuest/");
                if (!destination.exists()) {
                    destination.mkdirs();
                }
                File file = null;
                FileOutputStream fo;
                try {
                    // destination.createNewFile();
                    file = new File(destination, time + ".jpg");
                    fo = new FileOutputStream(file);
                    fo.write(bytes.toByteArray());
                    fo.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                String path = (file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);
                imgBearing150 = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);
                imgBearing150Image.setImageBitmap(decodeBase64(imgBearing150));*/
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                imgBearing150Image.setImageBitmap( out);
            //    imgBearing150 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                imgBearing150 = thumbnail;
                Log.v("img-encode", imgBearing150);
            }
        }
        if (name.equals("7")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
              /*  String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle + "\n"+"Blocking 180";
                // Bitmap setTextwithImage =    ProcessingBitmap(thumbnail,totalString);
                Bitmap setTextwithImage = DrawBitmapAll.drawTextToBitmap(getContext(), thumbnail, totalString);
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                setTextwithImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                String destinationpath = Environment.getExternalStorageDirectory().toString();
                File destination = new File(destinationpath + "/LinkQuest/");
                if (!destination.exists()) {
                    destination.mkdirs();
                }
                File file = null;
                FileOutputStream fo;
                try {
                    // destination.createNewFile();
                    file = new File(destination, time + ".jpg");
                    fo = new FileOutputStream(file);
                    fo.write(bytes.toByteArray());
                    fo.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                String path = (file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);
                imgBearing180 = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);
                imgBearing180Image.setImageBitmap(decodeBase64(imgBearing180));*/
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                imgBearing180Image.setImageBitmap( out);
           //     imgBearing180 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                imgBearing180 = thumbnail;
                Log.v("img-encode", imgBearing180);
            }
        }
        if (name.equals("8")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
             /*   String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 210";
                // Bitmap setTextwithImage =    ProcessingBitmap(thumbnail,totalString);
                Bitmap setTextwithImage = DrawBitmapAll.drawTextToBitmap(getContext(), thumbnail, totalString);
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                setTextwithImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                String destinationpath = Environment.getExternalStorageDirectory().toString();
                File destination = new File(destinationpath + "/LinkQuest/");
                if (!destination.exists()) {
                    destination.mkdirs();
                }
                File file = null;
                FileOutputStream fo;
                try {
                    // destination.createNewFile();
                    file = new File(destination, time + ".jpg");
                    fo = new FileOutputStream(file);
                    fo.write(bytes.toByteArray());
                    fo.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                String path = (file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);
                imgBearing210 = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);
                imgBearing210Image.setImageBitmap(decodeBase64(imgBearing210));*/
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                imgBearing210Image.setImageBitmap( out);
             //   imgBearing210 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                imgBearing210 = thumbnail;
                Log.v("img-encode", imgBearing210);
            }
        }
        if (name.equals("9")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
             /*   String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle + "\n"+"Blocking 240";
                // Bitmap setTextwithImage =    ProcessingBitmap(thumbnail,totalString);
                Bitmap setTextwithImage = DrawBitmapAll.drawTextToBitmap(getContext(), thumbnail, totalString);
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                setTextwithImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                String destinationpath = Environment.getExternalStorageDirectory().toString();
                File destination = new File(destinationpath + "/LinkQuest/");
                if (!destination.exists()) {
                    destination.mkdirs();
                }
                File file = null;
                FileOutputStream fo;
                try {
                    // destination.createNewFile();
                    file = new File(destination, time + ".jpg");
                    fo = new FileOutputStream(file);
                    fo.write(bytes.toByteArray());
                    fo.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                String path = (file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);
                imgBearing240 = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);
                imgBearing240Image.setImageBitmap(decodeBase64(imgBearing240));*/
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                imgBearing240Image.setImageBitmap( out);
               // imgBearing240 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                imgBearing240 = thumbnail;
                Log.v("img-encode", imgBearing240);
            }
        }
        if (name.equals("10")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
               /* String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 270";
                // Bitmap setTextwithImage =    ProcessingBitmap(thumbnail,totalString);
                Bitmap setTextwithImage = DrawBitmapAll.drawTextToBitmap(getContext(), thumbnail, totalString);
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                setTextwithImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                String destinationpath = Environment.getExternalStorageDirectory().toString();
                File destination = new File(destinationpath + "/LinkQuest/");
                if (!destination.exists()) {
                    destination.mkdirs();
                }
                File file = null;
                FileOutputStream fo;
                try {
                    // destination.createNewFile();
                    file = new File(destination, time + ".jpg");
                    fo = new FileOutputStream(file);
                    fo.write(bytes.toByteArray());
                    fo.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                String path = (file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);
                imgBearing270 = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);
                imgBearing270Image.setImageBitmap(decodeBase64(imgBearing270));*/
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                imgBearing270Image.setImageBitmap( out);
            //    imgBearing270 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                imgBearing270 = thumbnail;
                Log.v("img-encode", imgBearing270);
            }
        }
        if (name.equals("11")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
             /*   String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 300";
                // Bitmap setTextwithImage =    ProcessingBitmap(thumbnail,totalString);
                Bitmap setTextwithImage = DrawBitmapAll.drawTextToBitmap(getContext(), thumbnail, totalString);
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                setTextwithImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                String destinationpath = Environment.getExternalStorageDirectory().toString();
                File destination = new File(destinationpath + "/LinkQuest/");
                if (!destination.exists()) {
                    destination.mkdirs();
                }
                File file = null;
                FileOutputStream fo;
                try {
                    // destination.createNewFile();
                    file = new File(destination, time + ".jpg");
                    fo = new FileOutputStream(file);
                    fo.write(bytes.toByteArray());
                    fo.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                String path = (file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);
                imgBearing300 = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);
                imgBearing300Image.setImageBitmap(decodeBase64(imgBearing300));*/
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                imgBearing300Image.setImageBitmap( out);
            //    imgBearing300 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                imgBearing300 = thumbnail;
                Log.v("img-encode", imgBearing300);
            }
        }
        if (name.equals("12")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
        /*        String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle+ "\n"+"Blocking 330";
                // Bitmap setTextwithImage =    ProcessingBitmap(thumbnail,totalString);
                Bitmap setTextwithImage = DrawBitmapAll.drawTextToBitmap(getContext(), thumbnail, totalString);
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                setTextwithImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                String destinationpath = Environment.getExternalStorageDirectory().toString();
                File destination = new File(destinationpath + "/LinkQuest/");
                if (!destination.exists()) {
                    destination.mkdirs();
                }
                File file = null;
                FileOutputStream fo;
                try {
                    // destination.createNewFile();
                    file = new File(destination, time + ".jpg");
                    fo = new FileOutputStream(file);
                    fo.write(bytes.toByteArray());
                    fo.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                String path = (file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                // startkmImageEncodeString = encodeToBase64(thumbnail, Bitmap.CompressFormat.JPEG, 50);
                imgBearing330 = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);
                imgBearing330Image.setImageBitmap(decodeBase64(imgBearing330));*/
                Bitmap out = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(thumbnail), 100, 100, false);
                imgBearing330Image.setImageBitmap( out);
            //    imgBearing330 = encodeToBase64(BitmapFactory.decodeFile(thumbnail), Bitmap.CompressFormat.JPEG, 100);
                imgBearing330 = thumbnail;
                Log.v("img-encode", imgBearing330);
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
