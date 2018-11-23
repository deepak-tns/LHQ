package com.linkquest.lhq.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;


import com.linkquest.lhq.R;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
     Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView tvtoobar=(TextView)toolbar.findViewById(R.id.tv_toolbar);
        tvtoobar.setTextSize(20);
        tvtoobar.setText("राणा PG");
    }
}
