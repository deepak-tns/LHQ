package com.linkquest.lhq;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import java.text.SimpleDateFormat;


public class GPSTracker extends Service implements com.google.android.gms.location.LocationListener, GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {

    //  private final Context mContext;
    private static final String TAG = "gpstracker";
    public static boolean isRunning = false;

    double latitude;
    double longitude;
    Intent intent;
    public static final String BROADCAST_ACTION = "ACTION_ONE";
    private int INTERVAL = 5000;
    int flag = 0;
    SharedPreferences preference;
    LocationRequest mLocationRequest;
    GoogleApiClient mGoogleApiClient;
    private static final float MIN_ACCURACY = 25.0f;
    LocationManager lm;

    /*
    public GPSTracker(Context mContext) {
      //  this.mContext = mContext;
        isRunning = true;
        BUS.register(this);
        timer = new Timer();
        getLocation();
    }
    */


    @Override
    public void onCreate() {
        super.onCreate();

        intent = new Intent(BROADCAST_ACTION);

    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        isRunning = true;
        // BUS.register(this);
        // location.
        getLocation();
        Log.v("Service ", "ON start command is start");
        return START_STICKY;

    }

    protected void createLocationRequest() {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(INTERVAL * 1000);
        mLocationRequest.setFastestInterval(INTERVAL * 1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        lm = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        // lm.addGpsStatusListener(this);
    }

    private void getLocation() {
        createLocationRequest();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();
        mGoogleApiClient.connect();
        Log.d(TAG, "Location update resumed .....................");
        //  return loc;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onLocationChanged(Location location) {
        SimpleDateFormat time_formatter = new SimpleDateFormat("HH:mm:ss");
        String getTime = time_formatter.format(location.getTime());

        double getspeed = 3.6 * location.getSpeed();
        Log.v("LatLong", latitude + "," + longitude);
        String lats = String.format("%.6f", latitude);
        String longi = String.format("%.6f", longitude);
        intent.putExtra("LAT", lats);
        intent.putExtra("LOG", longi);
        sendBroadcast(intent);
    }


    protected void stopLocationUpdates() {
        LocationServices.FusedLocationApi.removeLocationUpdates(
                mGoogleApiClient, this);
        Log.d(TAG, "Location update stopped .......................");
    }

    @Override
    public void onConnected(Bundle bundle) {
        Log.d(TAG, "onConnected - isConnected ...............: " + mGoogleApiClient.isConnected());
        startLocationUpdates();
    }

    protected void startLocationUpdates() {
        PendingResult<Status> pendingResult = LocationServices.FusedLocationApi.requestLocationUpdates(
                mGoogleApiClient, mLocationRequest, this);
        Log.d(TAG, "Location update started ..............: ");
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.d(TAG, "onConnectionSuspended ..............: ");
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.d(TAG, "onConnectionFailed ..............: ");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopLocationUpdates();
        mGoogleApiClient.disconnect();
        isRunning = false;
        //BUS.unregister(this);
    }


    @Override
    public void onTaskRemoved(Intent rootIntent) {
        Intent restartServiceTask = new Intent(getApplicationContext(), this.getClass());
        restartServiceTask.setPackage(getPackageName());
        PendingIntent restartPendingIntent = PendingIntent.getService(getApplicationContext(), 1, restartServiceTask, PendingIntent.FLAG_ONE_SHOT);
        AlarmManager myAlarmService = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
        myAlarmService.set(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime() + 2000, restartPendingIntent);
        super.onTaskRemoved(rootIntent);
    }

}
