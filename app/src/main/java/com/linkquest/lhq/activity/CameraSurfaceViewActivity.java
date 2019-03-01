package com.linkquest.lhq.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.linkquest.lhq.GoogleGPSService;
import com.linkquest.lhq.R;
import com.linkquest.lhq.Utils.DrawBitmapAll;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CameraSurfaceViewActivity extends AppCompatActivity implements SurfaceHolder.Callback, SensorEventListener  {
   //activity_camera_surface_view
    private Camera camera;
    private SurfaceView surfaceView;
    private SurfaceHolder surfaceHolder;
    private Camera.PictureCallback rawCallback;
    private Camera.ShutterCallback shutterCallback;
    private Camera.PictureCallback jpegCallback;
    private Button edt_result_save;
    private EditText edt_text;
    private String getPicturePath ="";
    private String current_date ;
    private Calendar cal;
    private SensorManager sensorManager;
    private Sensor compass;
    private ImageView image;
    private TextView compassAngle;
    private float currentDegree = 0f;
    private Bitmap bitmap;
    private int pos;
    private Handler handler;
    private String time;
    private String lat ="Not Found",log= "Not Found" ;
    private long lastBackPressTime = 0;
/////////////////////////////////////////03/12/18
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_surface_view);
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
        cal = Calendar.getInstance();
        current_date = dateFormat.format(cal.getTime());
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                time = android.text.format.DateFormat.format("dd-MM-yyyy h:mm:ss:aa", System.currentTimeMillis()).toString();
                handler.postDelayed(this, 1000);
            }

        }, 1000);

        surfaceView = (SurfaceView) findViewById(R.id.surfaceView);
        surfaceHolder = surfaceView.getHolder();
        // Install a SurfaceHolder.Callback so we get notified when the
        // underlying surface is created and destroyed.
        surfaceHolder.addCallback(this);
        // deprecated setting, but required on Android versions prior to 3.0
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        jpegCallback = new Camera.PictureCallback() {
            public void onPictureTaken(byte[] data, Camera camera) {
            /*   String capturepath = "";
                String destinationpath = Environment.getExternalStorageDirectory().toString();
                SimpleDateFormat time_formatter = new SimpleDateFormat("HH:mm:ss");
                String current_time_str = time_formatter.format(System.currentTimeMillis());
                File destination = new File(destinationpath + "/ESP/SurveyFormFixRow/");
                if (!destination.exists()) {
                    destination.mkdirs();
                }
                File file = null;
                FileOutputStream outStream = null;
                try {
                    capturepath = current_date + "_" + current_time_str + ".jpg";

                    file = new File(destination, capturepath);
                    outStream = new FileOutputStream(file);
                    outStream.write(data);
                    outStream.close();
                    Log.d("Log", "onPictureTaken - wrote bytes: " + data.length);
                    Toast.makeText(getApplicationContext(), "Picture Saved", Toast.LENGTH_LONG).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                }
                getPicturePath =destinationpath + "/ESP/SurveyFormFixRow/" + capturepath;
                Log.d("Log", getPicturePath);*/

                if (data != null) {
                    int screenWidth = getResources().getDisplayMetrics().widthPixels;
                    int screenHeight = getResources().getDisplayMetrics().heightPixels;
                    Bitmap bm = BitmapFactory.decodeByteArray(data, 0, (data != null) ? data.length : 0);

                    if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                        // Notice that width and height are reversed
                        Bitmap scaled = Bitmap.createScaledBitmap(bm, screenHeight, screenWidth, true);
                        int w = scaled.getWidth();
                        int h = scaled.getHeight();
                        // Setting post rotate to 90
                        Matrix mtx = new Matrix();
                        mtx.postRotate(90);
                        // Rotating Bitmap
                        bitmap = Bitmap.createBitmap(scaled, 0, 0, w, h, mtx, true);
                    }else{// LANDSCAPE MODE
                        //No need to reverse width and height
                        Bitmap scaled = Bitmap.createScaledBitmap(bm, screenWidth,screenHeight , true);
                        bitmap=scaled;
                    }
                    SaveImage(bitmap);
                    if (getIntent().getIntExtra("pos",0) != 0) {
                       pos = getIntent().getIntExtra("pos",0);
                    }
                   // photoPreview.setImageBitmap(bm);
                }
                       // refreshCamera();
            }
        };
       // edt_text =findViewById(R.id.edt_text);
        edt_result_save=findViewById(R.id.edt_result_save);
        edt_result_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // String message=edt_text.getText().toString();
                Intent intent=new Intent();

               // intent.putExtra("text",message);
                intent.putExtra("path",getPicturePath);
                setResult(1,intent);
                finish();//finishing activity
            }
        });
        final Button back =findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // String message=edt_text.getText().toString();
                Intent intent=new Intent();

                // intent.putExtra("text",message);
                intent.putExtra("path",getPicturePath);
                intent.putExtra("angle",compassAngle.getText().toString());
                setResult(pos,intent);
                finish();//finishing activity
            }
        });
        final Button capture =findViewById(R.id.capture);

        capture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                camera.takePicture(null, null, jpegCallback);
                capture.setClickable(false);
                capture.setFocusable(false);
            }
        });

        compasinitial();
    }
    private  void SaveImage(Bitmap finalBitmap) {

        String capturepath = "";
        String destinationpath = Environment.getExternalStorageDirectory().toString();
        SimpleDateFormat time_formatter = new SimpleDateFormat("HH:mm:ss");
        String current_time_str = time_formatter.format(System.currentTimeMillis());

            String totalString = time + "\nLat :" + lat + "\nLong :" + log + "\n" + compassAngle.getText().toString();
            // Bitmap setTextwithImage =    ProcessingBitmap(thumbnail,totalString);
            Bitmap setTextwithImage = DrawBitmapAll.drawTextToBitmap(this, finalBitmap, totalString);
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
       //     setTextwithImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);

        File destination = new File(destinationpath + "/LHQTEMP/");
        if (!destination.exists()) {
            destination.mkdirs();
        }
        capturepath =destinationpath+"/LHQTEMP/"+time + ".jpg";
        try {
            FileOutputStream out = new FileOutputStream(capturepath);
            setTextwithImage.compress(Bitmap.CompressFormat.JPEG, 30, out);
            out.flush();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        getPicturePath =capturepath;
    }
   /* public void captureImage(View v) throws IOException {
        //take the picture

        *//*if (this.lastBackPressTime < System.currentTimeMillis() - 4000) {
            Toast.makeText(this, "Press back again to close this app", 4000);
            camera.takePicture(null, null, jpegCallback);
            this.lastBackPressTime = System.currentTimeMillis();

        } else {

            }*//*
        camera.takePicture(null, null, jpegCallback);
       *//* Intent intent=new Intent();

        // intent.putExtra("text",message);
        intent.putExtra("path",getPicturePath);
        setResult(1,intent);*//*
        //finish();//finishing activity
    }*/

    public void refreshCamera() {
        if (surfaceHolder.getSurface() == null) {
            // preview surface does not exist
            return;
        }

        // stop preview before making changes
        try {
            camera.stopPreview();
        } catch (Exception e) {
            // ignore: tried to stop a non-existent preview
        }
        // set preview size and make any resize, rotate or
        // reformatting changes here
        // start preview with new settings
        try {
            camera.setPreviewDisplay(surfaceHolder);
            camera.startPreview();
        } catch (Exception e) {

        }
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
        // Now that the size is known, set up the camera parameters and begin
        // the preview.
        refreshCamera();
        camera.setDisplayOrientation(90);
    }

    public void surfaceCreated(SurfaceHolder holder) {
        try {
            // open the camera
            camera = Camera.open();
        } catch (RuntimeException e) {
            // check for exceptions
            System.err.println(e);
            return;
        }
        Camera.Parameters param;
        param = camera.getParameters();

        // modify parameter
        param.setPreviewSize(352, 288);
        param.setJpegQuality(100);
        camera.setParameters(param);
        try {
            // The Surface has been created, now tell the camera where to draw
            // the preview.
            camera.setPreviewDisplay(surfaceHolder);
            camera.startPreview();
        } catch (Exception e) {
            // check for exceptions
            System.err.println(e);
            return;
        }
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
        // stop preview and release camera
        camera.stopPreview();
        camera.release();
        camera = null;
    }

   // ........................................................................................................//
   @Override
   protected void onResume() {
       super.onResume();
      // sensorManager.registerListener(this, compass, SensorManager.SENSOR_DELAY_NORMAL);
       sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION),SensorManager.SENSOR_DELAY_GAME);
       registerReceiver(broadcastReceiver, new IntentFilter(GoogleGPSService.BROADCAST_ACTION));
   }
    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
        unregisterReceiver(broadcastReceiver);
    }

    private void compasinitial(){
        image = (ImageView)findViewById(R.id.imageViewCompass);
        compassAngle = (TextView)findViewById(R.id.angle);
        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
       /* compass = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        if(compass != null){
            sensorManager.registerListener( this, compass, SensorManager.SENSOR_DELAY_NORMAL);
        }*/
        sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);

    }





    @Override
    public void onSensorChanged(SensorEvent event) {
       /* float degree = Math.round(event.values[0]);
        compassAngle.setText("Heading: " + Float.toString(degree) + " degrees");
        // create a rotation animation (reverse turn degree degrees)
        RotateAnimation ra = new RotateAnimation(currentDegree, -degree, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        // how long the animation will take place
        ra.setDuration(210);
        // set the animation after the end of the reservation status
        ra.setFillAfter(true);
        // Start the animation
        image.startAnimation(ra);
        currentDegree = -degree;*/

       // commemnt by deepak 12/03/18
       float degree=Math.round(event.values[0]);
        compassAngle.setText("Rotation: "+Float.toString(degree)+" degrees");
        RotateAnimation ra=new RotateAnimation(currentDegree,-degree,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        ra.setDuration(120);
        ra.setFillAfter(true);
        image.startAnimation(ra);
        currentDegree=-degree;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // mContact = (Contact)getIntent().getExtras().getSerializable(EXTRA_CONTACT);
            lat = intent.getStringExtra("LAT");
            log = intent.getStringExtra("LOG");
            //    Toast.makeText(getActivity(), "Lat : " + lat + "," + "Long : " + log, Toast.LENGTH_LONG).show();
        }
    };

}