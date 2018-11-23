package com.linkquest.lhq.activity;

import android.content.Context;
import android.content.Intent;
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

import com.linkquest.lhq.R;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CameraSurfaceViewActivity extends AppCompatActivity implements SurfaceHolder.Callback, SensorEventListener  {
    //  activity_camera_surface_view

    Camera camera;
    SurfaceView surfaceView;
    SurfaceHolder surfaceHolder;

    Camera.PictureCallback rawCallback;
    Camera.ShutterCallback shutterCallback;
    Camera.PictureCallback jpegCallback;
    Button edt_result_save;
    EditText edt_text;
    String getPicturePath ="";
    String current_date;
    private Calendar cal;

    private SensorManager sensorManager;
    private Sensor compass;
    private ImageView image;
    private TextView compassAngle;
    private float currentDegree = 0f;
    Bitmap bitmap;
    int pos;
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
        TextView back =findViewById(R.id.back);
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
        compasinitial();
    }
    private  void SaveImage(Bitmap finalBitmap) {

        String capturepath = "";
        String destinationpath = Environment.getExternalStorageDirectory().toString();
        SimpleDateFormat time_formatter = new SimpleDateFormat("HH:mm:ss");
        String current_time_str = time_formatter.format(System.currentTimeMillis());

        File destination = new File(destinationpath + "/LHQ/");
        if (!destination.exists()) {
            destination.mkdirs();
        }
        capturepath =destinationpath+"/LHQ/"+ current_date + "_" + current_time_str + ".jpg";
        try {
            FileOutputStream out = new FileOutputStream(capturepath);
            finalBitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.flush();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        getPicturePath =capturepath;
    }
    public void captureImage(View v) throws IOException {
        //take the picture
        camera.takePicture(null, null, jpegCallback);
       /* Intent intent=new Intent();

        // intent.putExtra("text",message);
        intent.putExtra("path",getPicturePath);
        setResult(1,intent);*/
        //finish();//finishing activity
    }

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
       sensorManager.registerListener(this, compass, SensorManager.SENSOR_DELAY_NORMAL);
   }
    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    private void compasinitial(){
        image = (ImageView)findViewById(R.id.imageViewCompass);
        compassAngle = (TextView)findViewById(R.id.angle);
        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        compass = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        if(compass != null){
            sensorManager.registerListener( this, compass, SensorManager.SENSOR_DELAY_NORMAL);
        }

    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        float degree = Math.round(event.values[0]);
        compassAngle.setText("Heading: " + Float.toString(degree) + " degrees");
        // create a rotation animation (reverse turn degree degrees)
        RotateAnimation ra = new RotateAnimation(currentDegree, -degree, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        // how long the animation will take place
        ra.setDuration(210);
        // set the animation after the end of the reservation status
        ra.setFillAfter(true);
        // Start the animation
        image.startAnimation(ra);
        currentDegree = -degree;
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

}