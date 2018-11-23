package com.linkquest.lhq.fragment;


import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
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

import com.linkquest.lhq.GPSTracker;
import com.linkquest.lhq.GoogleGPSService;
import com.linkquest.lhq.R;
import com.linkquest.lhq.Utils.DrawBitmapAll;
import com.linkquest.lhq.activity.CameraSurfaceViewActivity;
import com.linkquest.lhq.database.DatabaseHandler;
import com.linkquest.lhq.database.SiteDetailForm;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class SiteDetailFragment extends Fragment implements View.OnClickListener {
    private String lat, log;
    int REQUEST_CAMERA = 1;
    private Handler handler;
    private String time;

    private EditText siteid;
    private ImageButton siteid_photo;
    private EditText sitename;
    private ImageButton sitename_photo;
    private EditText towersiteid;
    private ImageButton towersiteid_photo;
    private EditText towercompanyname;
    private ImageButton towercompanyname__photo;
    private EditText siteaddress;
    private ImageButton siteaddress_photo;
    private EditText sectorid;
    private ImageButton sectorid_photo;
    private EditText edt_lat;
    private EditText edt_log;
    private EditText sitetype;
    private ImageButton sitetype_photo;
    private EditText buildingfloor;
    private ImageButton buildingfloor_photo;
    private EditText buildingheight;
    private ImageButton buildingheight_photo;
    private EditText towerheight;
    private ImageButton towerheight_photo;
    private EditText fulltowerphoto;
    private ImageButton fulltowerphoto_photo;
    private EditText nodebtype;
    private ImageButton nodebtype_photo;
    private EditText classical;
    private ImageButton classical_photo;
    private EditText enodebtype;
    private ImageButton enodebtype_photo;
    private EditText anchoroperator;
    private ImageButton anchoroperator_photo;
    private EditText sharingopco1;
    private ImageButton sharingopco1_photo;
    private EditText sharingopco2;
    private ImageButton sharingopco2_photo;
    private EditText sharingopco3;
    private ImageButton sharingopco3_photo;
    private EditText infraprovider;
    private ImageButton infraprovider_photo;
    private EditText type_id_od;
    private ImageButton type_id_od_photo;
    private EditText infrashared;
    private ImageButton infrashared_photo;
    private EditText extra1;
    private ImageButton extra1_photo;
    private EditText extra2;
    private ImageButton extra2_photo;
    private EditText remark1;
    private ImageButton remark1_photo;
    private EditText remark2;
    private ImageButton remark2_photo;

    private ImageView ivsiteid;
    private ImageView ivsitename;
    private ImageView ivtowersiteid;
    private ImageView ivtowercompnyname;
    private ImageView ivsiteaddress;
    private ImageView ivsectorid;
    private ImageView ivsitetype;
    private ImageView ivbuildingfloor;
    private ImageView ivbuildingheight;
    private ImageView ivtowerheight;
    private ImageView ivfulltowerphoto;
    private ImageView ivnodebtype;
    private ImageView ivclassicalrrm;
    private ImageView ivenodebtype;
    private ImageView ivanchoroper;
    private ImageView ivsharingopco1;
    private ImageView ivsharingopco2;
    private ImageView ivsharingopco3;
    private ImageView ivinfraprovider;
    private ImageView ivtypeindoor;
    private ImageView ivinfrashared;
    private ImageView ivextra1;
    private ImageView ivextra2;
    private ImageView ivremark1;
    private ImageView ivremark2;


    private SiteDetailForm siteDetailForm;

    private Button btnsitedetail;

    DatabaseHandler db;


    public SiteDetailFragment() {
        // Required empty public constructor
    }

    public static SiteDetailFragment newInstance(int index) {
        SiteDetailFragment f = new SiteDetailFragment();
        Bundle args = new Bundle();
        args.putInt("index", index);
        f.setArguments(args);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_site_detail, container, false);


   /*     int arg = getArguments().getInt("index");
            Toast.makeText(getActivity(), arg + "", Toast.LENGTH_LONG).show();
*/
        if (!GoogleGPSService.isRunning) {
            getActivity().startService(new Intent(getActivity(), GoogleGPSService.class));
        }
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                time = DateFormat.format("dd-MM-yyyy h:mm:ss:aa", System.currentTimeMillis()).toString();

                handler.postDelayed(this, 1000);
            }

        }, 1000);

        findviewIDS(v);
        db = new DatabaseHandler(getActivity());
        siteDetailForm = new SiteDetailForm();

        return v;
    }

    private void findviewIDS(View v) {
        siteid = v.findViewById(R.id.sitedeatail_edt_site_id);
        siteid_photo = v.findViewById(R.id.sitedeatail_img_site_id);
        sitename = v.findViewById(R.id.sitedeatail_edt_site_name);
        sitename_photo = v.findViewById(R.id.sitedeatail_img_site_name);
        towersiteid = v.findViewById(R.id.sitedeatail_edt_towersiteid);
        towersiteid_photo = v.findViewById(R.id.sitedeatail_img_towersiteid);
        towercompanyname = v.findViewById(R.id.sitedeatail_edt_towercompanyname);
        towercompanyname__photo = v.findViewById(R.id.sitedeatail_img_towercompanyname);
        siteaddress = v.findViewById(R.id.sitedeatail_edt_site_address);
        siteaddress_photo = v.findViewById(R.id.sitedeatail_img_site_address);
        sectorid = v.findViewById(R.id.sitedeatail_edt_sectorid);
        sectorid_photo = v.findViewById(R.id.sitedeatail_img_sectorid);
        edt_lat = v.findViewById(R.id.sitedeatail_edt_lat);
        edt_log = v.findViewById(R.id.sitedeatail_edt_log);
        sitetype = v.findViewById(R.id.sitedeatail_edt_sitetype);
        sitetype_photo = v.findViewById(R.id.sitedeatail_img_sitetype);
        buildingfloor = v.findViewById(R.id.sitedeatail_building_floor);
        buildingfloor_photo = v.findViewById(R.id.sitedeatail_img_buildingfloor);
        buildingheight = v.findViewById(R.id.sitedeatail_edt_buildingheight);
        buildingheight_photo = v.findViewById(R.id.sitedeatail_img_buildingheight);
        towerheight = v.findViewById(R.id.sitedeatail_edt_towerheight);
        towerheight_photo = v.findViewById(R.id.sitedeatail_img_towerheight);
        fulltowerphoto = v.findViewById(R.id.sitedeatail_edt_fulltowerphoto);
        fulltowerphoto_photo = v.findViewById(R.id.sitedeatail_img_fulltowerphoto);
        nodebtype = v.findViewById(R.id.sitedeatail_edt_nodebtype);
        nodebtype_photo = v.findViewById(R.id.sitedeatail_img_nodebtype);
        classical = v.findViewById(R.id.sitedeatail_edt_clasicalRRH);
        classical_photo = v.findViewById(R.id.sitedeatail_img_clasicalRRH);
        enodebtype = v.findViewById(R.id.sitedeatail_edt_enodebtype);
        enodebtype_photo = v.findViewById(R.id.sitedeatail_img_enodebtype);
        anchoroperator = v.findViewById(R.id.sitedeatail_edt_anchoroperator);
        anchoroperator_photo = v.findViewById(R.id.sitedeatail_img_anchoroperator);
        sharingopco1 = v.findViewById(R.id.sitedeatail_edt_sharingopco1);
        sharingopco1_photo = v.findViewById(R.id.sitedeatail_img_sharingopco1);
        sharingopco2 = v.findViewById(R.id.sitedeatail_edt_sharingopco2);
        sharingopco2_photo = v.findViewById(R.id.sitedeatail_img_sharingopco2);
        sharingopco3 = v.findViewById(R.id.sitedeatail_edt_sharingopco3);
        sharingopco3_photo = v.findViewById(R.id.sitedeatail_img_sharingopco3);
        infraprovider = v.findViewById(R.id.sitedeatail_edt_infraprovider);
        infraprovider_photo = v.findViewById(R.id.sitedeatail_img_infraprovider);
        type_id_od = v.findViewById(R.id.sitedeatail_edt_typeindoor);
        type_id_od_photo = v.findViewById(R.id.sitedeatail_img_typeindoor);
        infrashared = v.findViewById(R.id.sitedeatail_edt_infrashared);
        infrashared_photo = v.findViewById(R.id.sitedeatail_img_infrashared);
        extra1 = v.findViewById(R.id.sitedeatail_edt_extra1);
        extra1_photo = v.findViewById(R.id.sitedeatail_img_extra1);
        extra2 = v.findViewById(R.id.sitedeatail_edt_extra2);
        extra2_photo = v.findViewById(R.id.sitedeatail_img_extra2);
        remark1 = v.findViewById(R.id.sitedeatail_edt_remark1);
        remark1_photo = v.findViewById(R.id.sitedeatail_img_remark1);
        remark2 = v.findViewById(R.id.sitedeatail_edt_remark2);
        remark2_photo = v.findViewById(R.id.sitedeatail_img_remark2);
        btnsitedetail = v.findViewById(R.id.btnsitedetail);

         ivsiteid = v.findViewById(R.id.ivsiteid);
         ivsitename = v.findViewById(R.id.ivsitename);
        ivtowersiteid = v.findViewById(R.id.ivtowersiteid);
        ivtowercompnyname = v.findViewById(R.id.ivtowercompnyname);
       ivsiteaddress = v.findViewById(R.id.ivsiteaddress);
         ivsectorid = v.findViewById(R.id.ivsectorid);
        ivsitetype = v.findViewById(R.id.ivsitetype);
        ivbuildingfloor = v.findViewById(R.id.ivbuildingfloor);
      ivbuildingheight = v.findViewById(R.id.ivbuildingheight);
      ivtowerheight = v.findViewById(R.id.ivtowerheight);
         ivfulltowerphoto = v.findViewById(R.id.ivfulltowerphoto);
         ivnodebtype = v.findViewById(R.id.ivnodebtype);
        ivclassicalrrm = v.findViewById(R.id.ivclassicalrrm);
        ivenodebtype = v.findViewById(R.id.ivenodebtype);
         ivanchoroper = v.findViewById(R.id.ivanchoroper);
      ivsharingopco1 = v.findViewById(R.id.ivsharingopco1);
       ivsharingopco2 = v.findViewById(R.id.ivsharingopco2);
         ivsharingopco3 = v.findViewById(R.id.ivsharingopco3);
         ivinfraprovider = v.findViewById(R.id.ivinfraprovider);
         ivtypeindoor = v.findViewById(R.id.ivtypeindoor);
         ivinfrashared = v.findViewById(R.id.ivinfrashared);
        ivextra1 = v.findViewById(R.id.ivextra1);
        ivextra2 = v.findViewById(R.id.ivextra2);
         ivremark1 = v.findViewById(R.id.ivremark1);
        ivremark2 = v.findViewById(R.id.ivremark2);

        siteid_photo.setOnClickListener(this);
        sitename_photo.setOnClickListener(this);
        towersiteid_photo.setOnClickListener(this);
        towercompanyname__photo.setOnClickListener(this);
        siteaddress_photo.setOnClickListener(this);
        sectorid_photo.setOnClickListener(this);
        sitetype_photo.setOnClickListener(this);
        buildingfloor_photo.setOnClickListener(this);
        buildingheight_photo.setOnClickListener(this);
        towerheight_photo.setOnClickListener(this);
        fulltowerphoto_photo.setOnClickListener(this);
        nodebtype_photo.setOnClickListener(this);
        classical_photo.setOnClickListener(this);
        enodebtype_photo.setOnClickListener(this);
        anchoroperator_photo.setOnClickListener(this);
        sharingopco1_photo.setOnClickListener(this);
        sharingopco2_photo.setOnClickListener(this);
        sharingopco3_photo.setOnClickListener(this);
        infraprovider_photo.setOnClickListener(this);
        type_id_od_photo.setOnClickListener(this);
        infrashared_photo.setOnClickListener(this);
        extra1_photo.setOnClickListener(this);
        extra2_photo.setOnClickListener(this);
        remark1_photo.setOnClickListener(this);
        remark2_photo.setOnClickListener(this);
        btnsitedetail.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v == siteid_photo) {
            selectImage("one");
        } else if (v == sitename_photo) {
            selectImage("2");
        }
        if (v == towersiteid_photo) {
            selectImage("3");
        }

        if (v == towercompanyname__photo) {
            selectImage("4");
        }

        if (v == siteaddress_photo) {
            selectImage("5");
        }
        if (v == sectorid_photo) {
            selectImage("6");
        }
        if (v == sitetype_photo) {
            selectImage("7");
        }
        if (v == buildingfloor_photo) {
            selectImage("8");
        }
        if (v == buildingheight_photo) {
            selectImage("9");
        }
        if (v == towerheight_photo) {
            selectImage("10");
        }
        if (v == fulltowerphoto_photo) {
            selectImage("11");
        }
        if (v == nodebtype_photo) {
            selectImage("12");
        }
        if (v == classical_photo) {
            selectImage("13");
        }
        if (v == enodebtype_photo) {
            selectImage("14");
        }
        if (v == anchoroperator_photo) {
            selectImage("15");
        }
        if (v == sharingopco1_photo) {
            selectImage("16");
        }
        if (v == sharingopco2_photo) {
            selectImage("17");
        }
        if (v == sharingopco3_photo) {
            selectImage("18");
        }
        if (v == infraprovider_photo) {
            selectImage("19");
        }
        if (v == type_id_od_photo) {
            selectImage("20");
        }
        if (v == infrashared_photo) {
            selectImage("21");
        }
        if (v == extra1_photo) {
            selectImage("22");
        }
        if (v == extra2_photo) {
            selectImage("23");
        }
        if (v == remark1_photo) {
            selectImage("24");
        }
        if (v == remark2_photo) {
            selectImage("25");
        }

        if (v == btnsitedetail) {

            db.insertSiteDetailData(new SiteDetailForm(siteid.getText().toString(), siteDetailForm.getSiteid_photo(), sitename.getText().toString(), siteDetailForm.getSitename_photo(),
                    towersiteid.getText() + "", siteDetailForm.getTowersiteid_photo(), towercompanyname.getText() + "", siteDetailForm.getTowercompanyname__photo(),
                    siteaddress.getText() + "", siteDetailForm.getSiteaddress_photo(), sectorid.getText() + "", siteDetailForm.getSectorid_photo(),
                    edt_lat.getText() + "", edt_log.getText() + "", sitetype.getText() + "", siteDetailForm.getSitetype_photo(), buildingfloor.getText() + "",
                    siteDetailForm.getBuildingfloor_photo(), buildingheight.getText() + "", siteDetailForm.getBuildingheight_photo(), towerheight.getText() + "",
                    siteDetailForm.getTowerheight_photo(), fulltowerphoto.getText() + "", siteDetailForm.getFulltowerphoto_photo(), nodebtype.getText() + "",
                    siteDetailForm.getNodebtype_photo(), classical.getText() + "", siteDetailForm.getClassical_photo(), enodebtype.getText() + "", siteDetailForm.getEnodebtype_photo(),
                    anchoroperator.getText() + "", siteDetailForm.getAnchoroperator_photo(), sharingopco1.getText() + "", siteDetailForm.getSharingopco1_photo(),
                    sharingopco2.getText() + "", siteDetailForm.getSharingopco2_photo(), sharingopco3.getText() + "", siteDetailForm.getSharingopco3_photo(),
                    infraprovider.getText() + "", siteDetailForm.getInfraprovider_photo(), type_id_od.getText() + "", siteDetailForm.getType_id_od_photo(),
                    infrashared.getText() + "", siteDetailForm.getInfrashared_photo(), extra1.getText() + "", siteDetailForm.getExtra1_photo(),
                    extra2.getText() + "", siteDetailForm.getExtra2_photo(), remark1.getText() + "", siteDetailForm.getRemark1_photo(), remark2.getText() + "",
                    siteDetailForm.getRemark2_photo(), 1));
/*
db.insertSiteDetailData(new SiteDetailForm("1","1","1","1","1","1","1","1","1","1","1","1","1",
               "1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1",
               "1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1",1));
  */
        }


    }

    private void selectImage(String Value) {

        if (Value.equals("one")) {
         /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 1);*/
           // com.derekr.AngleCam
           Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",1);
            startActivityForResult(i, 1);


        }
        if (Value.equals("2")) {
           /* Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 2);*/


            Intent i = new Intent(getContext(), CameraSurfaceViewActivity.class);
            i.putExtra("pos",2);
            startActivityForResult(i, 2);
        }
        if (Value.equals("3")) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 3);
        }
        if (Value.equals("4")) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 4);
        }
        if (Value.equals("5")) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 5);
        }
        if (Value.equals("6")) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 6);
        }
        if (Value.equals("7")) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 7);
        }
        if (Value.equals("8")) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 8);
        }
        if (Value.equals("9")) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 9);
        }
        if (Value.equals("10")) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 10);
        }
        if (Value.equals("11")) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 11);
        }
        if (Value.equals("12")) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 12);
        }
        if (Value.equals("13")) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 13);
        }
        if (Value.equals("14")) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 14);
        }
        if (Value.equals("15")) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 15);
        }
        if (Value.equals("16")) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 16);
        }
        if (Value.equals("17")) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 17);
        }
        if (Value.equals("18")) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 18);
        }
        if (Value.equals("19")) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 19);
        }
        if (Value.equals("20")) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 20);
        }
        if (Value.equals("21")) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 21);
        }
        if (Value.equals("22")) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 22);
        }
        if (Value.equals("23")) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 23);
        }
        if (Value.equals("24")) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 24);
        }
        if (Value.equals("25")) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 25);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode != RESULT_CANCELED) {
            //  Log.v("logtest", data.getStringExtra("path")+","+requestCode);
            if (requestCode == 1) {

                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");

                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(bitmap, "one", angle);

                // onCaptureImageResult(data, "one");
            }
            if (requestCode == 2) {
                String path = data.getStringExtra("path");
                String angle = data.getStringExtra("angle");

                Bitmap bitmap = BitmapFactory.decodeFile(path);
                onCameraSurfaceViewActivity(bitmap, "2", angle);
                //  onCaptureImageResult(data, "2");
            }
            if (requestCode == 3) {
                onCaptureImageResult(data, "3");
            }
            if (requestCode == 4) {
                onCaptureImageResult(data, "4");
            }
            if (requestCode == 5) {
                onCaptureImageResult(data, "5");
            }
            if (requestCode == 6) {
                onCaptureImageResult(data, "6");
            }
            if (requestCode == 7) {
                onCaptureImageResult(data, "7");
            }
            if (requestCode == 8) {
                onCaptureImageResult(data, "8");
            }
            if (requestCode == 9) {
                onCaptureImageResult(data, "9");
            }
            if (requestCode == 10) {
                onCaptureImageResult(data, "10");
            }
            if (requestCode == 11) {
                onCaptureImageResult(data, "11");
            }
            if (requestCode == 12) {
                onCaptureImageResult(data, "12");
            }
            if (requestCode == 13) {
                onCaptureImageResult(data, "13");
            }
            if (requestCode == 14) {
                onCaptureImageResult(data, "14");
            }
            if (requestCode == 15) {
                onCaptureImageResult(data, "15");
            }
            if (requestCode == 16) {
                onCaptureImageResult(data, "16");
            }
            if (requestCode == 17) {
                onCaptureImageResult(data, "17");
            }
            if (requestCode == 18) {
                onCaptureImageResult(data, "18");
            }
            if (requestCode == 19) {
                onCaptureImageResult(data, "19");
            }
            if (requestCode == 20) {
                onCaptureImageResult(data, "20");
            }
            if (requestCode == 21) {
                onCaptureImageResult(data, "21");
            }
            if (requestCode == 22) {
                onCaptureImageResult(data, "22");
            }
            if (requestCode == 23) {
                onCaptureImageResult(data, "23");
            }
            if (requestCode == 24) {
                onCaptureImageResult(data, "24");
            }
            if (requestCode == 25) {
                onCaptureImageResult(data, "25");
            }
        }


    }


    private void onCaptureImageResult(Intent data, String name) {

        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        //.........................................one.....................................
        if (name.equals("one")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                siteDetailForm.setSiteid_photo(imgtxt);
                ivsiteid.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);

            }
        }
        //.........................................one.....................................
        //.........................................2.....................................
        if (name.equals("2")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                siteDetailForm.setSitename_photo(imgtxt);
                ivsitename.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);

            }
        }
        //......................................2................................................................
        //.........................................3.....................................
        if (name.equals("3")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                siteDetailForm.setTowersiteid(imgtxt);
                ivtowersiteid.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);

            }
        }
        //......................................3................................................................
        //.........................................4.....................................
        if (name.equals("4")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                siteDetailForm.setTowercompanyname__photo(imgtxt);
                ivtowercompnyname.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);

            }
        }
        //......................................4................................................................
        //.........................................5....................................
        if (name.equals("5")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                siteDetailForm.setSiteaddress_photo(imgtxt);
                ivsiteaddress.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);
            }
        }
        //......................................5................................................................
        //.........................................6....................................
        if (name.equals("6")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                siteDetailForm.setSectorid_photo(imgtxt);
                ivsectorid.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);
            }
        }
        //......................................6................................................................
        //.........................................7....................................
        if (name.equals("7")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                siteDetailForm.setSitetype_photo(imgtxt);
                ivsitetype.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);
            }
        }
        //......................................7................................................................
        //.........................................8....................................
        if (name.equals("8")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                siteDetailForm.setBuildingfloor_photo(imgtxt);
                ivbuildingfloor.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);
            }
        }
        //......................................8................................................................
        //.........................................9....................................
        if (name.equals("9")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                siteDetailForm.setBuildingheight_photo(imgtxt);
                ivbuildingheight.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);
            }
        }
        //......................................9................................................................
        //.........................................10....................................
        if (name.equals("10")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);
                siteDetailForm.setTowerheight_photo(imgtxt);
                ivtowerheight.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);
            }
        }
        //......................................10................................................................
        //.........................................11....................................
        if (name.equals("11")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                siteDetailForm.setFulltowerphoto(imgtxt);
                ivfulltowerphoto.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);
            }
        }
        //......................................11................................................................
        //.........................................12....................................
        if (name.equals("12")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);
                siteDetailForm.setNodebtype_photo(imgtxt);
                ivnodebtype.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);
            }
        }
        //......................................12...............................................................
        //.........................................13....................................
        if (name.equals("13")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\n Long :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                siteDetailForm.setClassical_photo(imgtxt);
                ivclassicalrrm.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);
            }
        }
        //......................................13................................................................
        //.........................................14....................................
        if (name.equals("14")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\n Long :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                siteDetailForm.setEnodebtype_photo(imgtxt);
                ivenodebtype.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);
            }
        }
        //......................................14................................................................
        //.........................................15....................................
        if (name.equals("15")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\n Long :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                siteDetailForm.setAnchoroperator_photo(imgtxt);
                ivanchoroper.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);
            }
        }
        //......................................15................................................................
        //.........................................16....................................
        if (name.equals("16")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\n Long :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                siteDetailForm.setSharingopco1_photo(imgtxt);
                ivsharingopco1.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);
            }
        }
        //......................................16................................................................
        //.........................................17....................................
        if (name.equals("17")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\n Long :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                siteDetailForm.setSharingopco2_photo(imgtxt);
                ivsharingopco2.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);
            }
        }
        //......................................17................................................................
        //.........................................18....................................
        if (name.equals("18")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\n Long :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                siteDetailForm.setSharingopco3_photo(imgtxt);
                ivsharingopco3.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);
            }
        }
        //......................................18................................................................
        //.........................................19....................................
        if (name.equals("19")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\n Long :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                siteDetailForm.setInfraprovider_photo(imgtxt);
                ivinfraprovider.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);
            }
        }
        //......................................19................................................................
        //.........................................20...................................
        if (name.equals("20")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\n Long :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                siteDetailForm.setType_id_od_photo(imgtxt);
                ivtypeindoor.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);
            }
        }
        //......................................20................................................................
        //.........................................21....................................
        if (name.equals("21")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\n Long :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                siteDetailForm.setInfrashared_photo(imgtxt);
                ivinfrashared.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);
            }
        }
        //......................................21................................................................
        //.........................................22....................................
        if (name.equals("22")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\n Long :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                siteDetailForm.setExtra1_photo(imgtxt);
                ivextra1.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);
            }
        }
        //......................................22................................................................
        //.........................................5....................................
        if (name.equals("23")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\n Long :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                siteDetailForm.setExtra2_photo(imgtxt);
                ivextra2.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);
            }
        }
        //......................................23................................................................
        //.........................................24....................................
        if (name.equals("24")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\n Long :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                siteDetailForm.setRemark1_photo(imgtxt);
                ivremark1.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);
            }
        }
        //......................................24................................................................
        //.........................................25....................................
        if (name.equals("25")) {
            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\n Long :" + log + "\n" + name;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                siteDetailForm.setRemark2_photo(imgtxt);
                ivremark2.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);
            }
        }
        //......................................25................................................................
    }

    private void onCameraSurfaceViewActivity(Bitmap thumbnail, String name, String angle){

        if (name.equals("one")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 80);
                siteDetailForm.setSiteid_photo(imgtxt);
                ivsiteid.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);
            }
        }
        if (name.equals("2")) {

            if (lat == null) {
                Toast.makeText(getActivity(), "please wait gps location not found", Toast.LENGTH_LONG).show();
            } else {
                String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + angle;
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
                String imgtxt = encodeToBase64(setTextwithImage, Bitmap.CompressFormat.JPEG, 100);
                siteDetailForm.setSiteid_photo(imgtxt);
                ivsitename.setImageBitmap(decodeBase64(imgtxt));
                Log.v("img-encode", imgtxt);
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

            Toast.makeText(getActivity(), "Lat : " + lat + "," + "Long : " + log, Toast.LENGTH_LONG).show();
        }


    };


}
