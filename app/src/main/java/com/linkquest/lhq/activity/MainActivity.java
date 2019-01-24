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
import com.linkquest.lhq.LOSAudit.LOSOtherFragment;
import com.linkquest.lhq.R;
import com.linkquest.lhq.SiteAudit.OtherFragment;
import com.linkquest.lhq.SiteAudit.SiteDetailFragment;
import com.linkquest.lhq.SiteAudit.SitePanoramicFragment;
import com.linkquest.lhq.fragment.HomeFragment;
import com.linkquest.lhq.fragment.SiteSurveylqt;
import com.linkquest.lhq.SiteAudit.TabFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CustomClass.interfaceCustom {
    private DrawerLayout mDrawerLayout;
    private LinearLayout mDrawerPane;
    private ActionBarDrawerToggle mDrawerToggle;
    Toolbar toolbar;
    private TextView tvsiteinfo;
    private TextView tv_sitedetail;
    private TextView tv_sitepanoramic;
    private TextView tv_sectordetail;
    private TextView tv_otherdetail;
    private TextView tv_losotherdetail;

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
        tv_losotherdetail=(TextView)findViewById(R.id.tv_losotherdetail);

         tvsiteinfo.setOnClickListener(this);
        tv_sitedetail.setOnClickListener(this);
        tv_sitepanoramic.setOnClickListener(this);
        tv_sectordetail.setOnClickListener(this);
        tv_losotherdetail.setOnClickListener(this);
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

        if(v == tv_sitedetail){

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

        if(v == tv_losotherdetail){

            //  getSupportFragmentManager().beginTransaction().add(R.id.frameLayout_home_frag,SiteSurveyFragment.newInstance(1)).commit();
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_home_frag,LOSOtherFragment.newInstance(1000)).addToBackStack(null).commit();
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
    public void setData(String Data) {
        tv_losotherdetail.setText(Data);
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
