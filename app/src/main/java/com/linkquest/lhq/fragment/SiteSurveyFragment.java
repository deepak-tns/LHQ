package com.linkquest.lhq.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.linkquest.lhq.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class SiteSurveyFragment extends Fragment {


    public SiteSurveyFragment() {
        // Required empty public constructor
    }

    public static SiteSurveyFragment newInstance(int index) {
        SiteSurveyFragment f = new SiteSurveyFragment();
        Bundle args = new Bundle();
        args.putInt("index", index);
        f.setArguments(args);
        return f;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_site_survey, container, false);

        return v;
    }

}
