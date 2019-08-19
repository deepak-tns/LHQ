package com.linkquest.lhq.LOSAudit;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.linkquest.lhq.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabTransmissionNoLinkFragment extends Fragment {
    private View view;
    private TabLayout tabLayout;
    private ViewPager viewPager;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /**
         *Inflate tab_layout and setup Views.
         */
         view =  inflater.inflate(R.layout.fragment_tab_nolink_layout,null);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager_no_link);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) view.findViewById(R.id.tabs_no_link);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }
    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());

        for(int i =1;i<=6;i++){
            adapter.addFrag( TransmissionNoLinkFragment.newInstance(i,"NOLink"+i), "NOLink"+i);
        }

    /*    adapter.addFrag(new SiteDetailFragment(), "Sector2");
        adapter.addFrag(new SiteDetailFragment(), "Sector3");
        adapter.addFrag(new SiteDetailFragment(), "Sector4");
    */
        // adapter.addFrag(new FeedBackFragment(), "FeedBack");
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
    }

    @Override
    public void onResume() {
        Log.e("DEBUG", "onResume of TabFragment");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.e("DEBUG", "OnPause of TabFragment");
        super.onPause();
    }




     class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            getFragmentManager().beginTransaction().detach(this).attach(this).commit();
        }
    }

}
