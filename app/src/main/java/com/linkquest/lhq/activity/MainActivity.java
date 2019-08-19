package com.linkquest.lhq.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.linkquest.lhq.CustomClass;
import com.linkquest.lhq.LOSAudit.LOSDetailFragment;
import com.linkquest.lhq.LOSAudit.LOSOtherFragment;
import com.linkquest.lhq.LOSAudit.LosPhotoFragment;
import com.linkquest.lhq.LOSAudit.TabTransmissionLinkFragment;
import com.linkquest.lhq.LOSAudit.TabTransmissionNoLinkFragment;
import com.linkquest.lhq.LOSAudit.TransmissionLinkFragment;
import com.linkquest.lhq.LOSAudit.TransmissionNoLinkFragment;
import com.linkquest.lhq.R;
import com.linkquest.lhq.RFSurvey.RFSectorDetailFragment;
import com.linkquest.lhq.RFSurvey.RFSiteDetailFragment;
import com.linkquest.lhq.RFSurvey.RFTabFragment;
import com.linkquest.lhq.SiteAudit.OtherFragment;
import com.linkquest.lhq.SiteAudit.SiteDetailFragment;
import com.linkquest.lhq.SiteAudit.SitePanoramicFragment;
import com.linkquest.lhq.database.TransmissionLinkData;
import com.linkquest.lhq.fragment.HomeFragment;
import com.linkquest.lhq.fragment.SiteSurveylqt;
import com.linkquest.lhq.SiteAudit.TabFragment;
import com.linkquest.lhq.fragment.SiteSurveylqtReport;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CustomClass.interfaceCustom {
    private DrawerLayout mDrawerLayout;
    private LinearLayout mDrawerPane;
    private ActionBarDrawerToggle mDrawerToggle;
    Toolbar toolbar;
    private TextView tvsiteinfo;
    private TextView tv_sitedetail;
    private TextView tv_siteinforeport;
    private TextView tv_sitepanoramic;
    private TextView tv_sectordetail;
    private TextView tv_otherdetail;
    private TextView tv_los_sitedetail;
    private TextView tv_tranmissionlink;
    private TextView tv_tranmission_nolink;
    private TextView tv_los_sitepanoramic;
    private TextView tv_los_photos;
    private TextView tv_losotherdetail;
    private TextView tv_rf_sitedetail;
    private TextView tv_rf_sectorDetail;
    private LinearLayout linear_surveyaudit;
    private LinearLayout linear_losaudit;
    private LinearLayout linear_RFSurvey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.frameLayout_home_frag, new HomeFragment()).commit();
        }
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        navigationdrawer();
        findIds();
        CustomClass.setInterfaceCustom(this);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Click action
                Toast.makeText(getApplicationContext(),"Welcome",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void findIds(){
        tvsiteinfo=(TextView)findViewById(R.id.tv_siteinfo);
        tv_sitedetail=(TextView)findViewById(R.id.tv_sitedetail);
        tv_sitepanoramic=(TextView)findViewById(R.id.tv_sitepanoramic);
        tv_sectordetail=(TextView)findViewById(R.id.tv_sectordetail);
        tv_otherdetail=(TextView)findViewById(R.id.tv_otherdetail);
        tv_siteinforeport=(TextView)findViewById(R.id.tv_siteinforeport);

        tv_los_sitedetail=(TextView)findViewById(R.id.tv_los_sitedetail);
        tv_tranmissionlink=(TextView)findViewById(R.id.tv_transmissionlink);
        tv_tranmission_nolink=(TextView)findViewById(R.id.tv_transmission_nolink);
        tv_los_sitepanoramic=(TextView)findViewById(R.id.tv_los_sitepanoramic);
        tv_los_photos=(TextView)findViewById(R.id.tv_losphotos);
        tv_losotherdetail=(TextView)findViewById(R.id.tv_losotherdetail);

        tv_rf_sitedetail=(TextView)findViewById(R.id.tv_rf_sitedetail);
        tv_rf_sectorDetail=(TextView)findViewById(R.id.tv_rf_sectorDetail);

        linear_surveyaudit=(LinearLayout) findViewById(R.id.linear_surveyaudit);
        linear_losaudit=(LinearLayout) findViewById(R.id.linear_los);
        linear_RFSurvey=(LinearLayout) findViewById(R.id.linear_RFSurvey);

        tvsiteinfo.setOnClickListener(this);
        tv_sitedetail.setOnClickListener(this);
        tv_sitepanoramic.setOnClickListener(this);
        tv_sectordetail.setOnClickListener(this);
        tv_otherdetail.setOnClickListener(this);
        tv_siteinforeport.setOnClickListener(this);

        tv_los_sitedetail.setOnClickListener(this);
        tv_tranmissionlink.setOnClickListener(this);
        tv_tranmission_nolink.setOnClickListener(this);
        tv_los_sitepanoramic.setOnClickListener(this);
        tv_los_photos.setOnClickListener(this);
        tv_losotherdetail.setOnClickListener(this);
        tv_rf_sitedetail.setOnClickListener(this);
        tv_rf_sectorDetail.setOnClickListener(this);

        linear_surveyaudit.setOnClickListener(this);
        linear_losaudit.setOnClickListener(this);
        linear_RFSurvey.setOnClickListener(this);
    }

    private void navigationdrawer() {
        mDrawerPane = (LinearLayout) findViewById(R.id.drawerPane);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,
                //nav menu toggle icon
                R.string.app_name, // nav drawer open - description for accessibility
                R.string.app_name // nav drawer close - description for accessibility
        );

    }

    @Override
    public void onClick(View v) {
        if(v == tvsiteinfo){
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag, new SiteSurveylqt()).addToBackStack(null).commit();
            mDrawerLayout.closeDrawer(mDrawerPane);
        }

        if(v == tv_siteinforeport){

          //  getSupportFragmentManager().beginTransaction().add(R.id.frameLayout_home_frag,SiteSurveyFragment.newInstance(1)).commit();
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag, new SiteSurveylqtReport()).addToBackStack(null).commit();
            mDrawerLayout.closeDrawer(mDrawerPane);
          // startActivity(new Intent (this,RegisterActivity.class));

        }  if(v == tv_sitedetail){

          //  getSupportFragmentManager().beginTransaction().add(R.id.frameLayout_home_frag,SiteSurveyFragment.newInstance(1)).commit();
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag, SiteDetailFragment.newInstance(1000)).addToBackStack(null).commit();
            mDrawerLayout.closeDrawer(mDrawerPane);
          // startActivity(new Intent (this,RegisterActivity.class));

        }

        if(v == tv_sitepanoramic){

            //  getSupportFragmentManager().beginTransaction().add(R.id.frameLayout_home_frag,SiteSurveyFragment.newInstance(1)).commit();
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag, SitePanoramicFragment.newInstance(2000)).addToBackStack(null).commit();
            mDrawerLayout.closeDrawer(mDrawerPane);
            // startActivity(new Intent (this,RegisterActivity.class));

        }

        if(v == tv_sectordetail){

            //  getSupportFragmentManager().beginTransaction().add(R.id.frameLayout_home_frag,SiteSurveyFragment.newInstance(1)).commit();
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag,new TabFragment()).addToBackStack(null).commit();
            mDrawerLayout.closeDrawer(mDrawerPane);
            // startActivity(new Intent (this,RegisterActivity.class));

        }

        if(v == tv_otherdetail){

            //  getSupportFragmentManager().beginTransaction().add(R.id.frameLayout_home_frag,SiteSurveyFragment.newInstance(1)).commit();
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag,OtherFragment.newInstance(1000)).addToBackStack(null).commit();
            mDrawerLayout.closeDrawer(mDrawerPane);
            // startActivity(new Intent (this,RegisterActivity.class));

        }
        if(v == tv_los_sitedetail){

            //  getSupportFragmentManager().beginTransaction().add(R.id.frameLayout_home_frag,SiteSurveyFragment.newInstance(1)).commit();
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag,LOSDetailFragment.newInstance(1000,"LosSiteDetail")).addToBackStack(null).commit();
            mDrawerLayout.closeDrawer(mDrawerPane);
            // startActivity(new Intent (this,RegisterActivity.class));

        }
        if(v == tv_tranmissionlink){

            //  getSupportFragmentManager().beginTransaction().add(R.id.frameLayout_home_frag,SiteSurveyFragment.newInstance(1)).commit();
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag,new TabTransmissionLinkFragment()).addToBackStack(null).commit();
            mDrawerLayout.closeDrawer(mDrawerPane);
            // startActivity(new Intent (this,RegisterActivity.class));

        }
        if(v == tv_tranmission_nolink){

            //  getSupportFragmentManager().beginTransaction().add(R.id.frameLayout_home_frag,SiteSurveyFragment.newInstance(1)).commit();
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag,new TabTransmissionNoLinkFragment()).addToBackStack(null).commit();
            mDrawerLayout.closeDrawer(mDrawerPane);
            // startActivity(new Intent (this,RegisterActivity.class));

        }
        if(v == tv_los_sitepanoramic){

            //  getSupportFragmentManager().beginTransaction().add(R.id.frameLayout_home_frag,SiteSurveyFragment.newInstance(1)).commit();
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag,SitePanoramicFragment.newInstance(1000)).addToBackStack(null).commit();
            mDrawerLayout.closeDrawer(mDrawerPane);
            // startActivity(new Intent (this,RegisterActivity.class));

        }
        if(v == tv_los_photos){

            //  getSupportFragmentManager().beginTransaction().add(R.id.frameLayout_home_frag,SiteSurveyFragment.newInstance(1)).commit();
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag,new LosPhotoFragment()).addToBackStack(null).commit();
            mDrawerLayout.closeDrawer(mDrawerPane);
            // startActivity(new Intent (this,RegisterActivity.class));

        }

        if(v == tv_losotherdetail){

            //  getSupportFragmentManager().beginTransaction().add(R.id.frameLayout_home_frag,SiteSurveyFragment.newInstance(1)).commit();
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag,LOSOtherFragment.newInstance(1000)).addToBackStack(null).commit();
            mDrawerLayout.closeDrawer(mDrawerPane);
            // startActivity(new Intent (this,RegisterActivity.class));

        }
        if(v == tv_rf_sitedetail){

            //  getSupportFragmentManager().beginTransaction().add(R.id.frameLayout_home_frag,SiteSurveyFragment.newInstance(1)).commit();
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag,new RFSiteDetailFragment()).addToBackStack(null).commit();
            mDrawerLayout.closeDrawer(mDrawerPane);
            // startActivity(new Intent (this,RegisterActivity.class));

        }
        if(v == tv_rf_sectorDetail){

            //  getSupportFragmentManager().beginTransaction().add(R.id.frameLayout_home_frag,SiteSurveyFragment.newInstance(1)).commit();
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag,new RFTabFragment()).addToBackStack(null).commit();
            mDrawerLayout.closeDrawer(mDrawerPane);
            // startActivity(new Intent (this,RegisterActivity.class));
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);

    }

    @Override
    public void setData(String data) {
        if(data.equals("LOS Survey")){
            linear_surveyaudit.setVisibility(View.GONE);
            linear_losaudit.setVisibility(View.VISIBLE);
            linear_RFSurvey.setVisibility(View.GONE);
        }

        if(data.equals("Site Audit")){
            linear_surveyaudit.setVisibility(View.VISIBLE);
            linear_losaudit.setVisibility(View.GONE);
            linear_RFSurvey.setVisibility(View.GONE);
        }
        if(data.equals("RF Survey")){
            linear_surveyaudit.setVisibility(View.GONE);
            linear_losaudit.setVisibility(View.GONE);
            linear_RFSurvey.setVisibility(View.VISIBLE);
        }
    }

   /*
   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    */
}
