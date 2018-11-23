package com.linkquest.lhq.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.linkquest.lhq.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SectorDetailFragment extends Fragment implements View.OnClickListener {


    private EditText sectordetail_edt_techavailable;
    private ImageButton sectordetail_img_techavailable;
    private EditText sectordetail_edt_bandavailable;
    private ImageButton sectordeatail_img_bandavailable;
    private EditText sectordeatail_edt_APC;
    private ImageButton sectordeatail_img_APC;
    private EditText sectoreatail_edt_preazimuth;
    private ImageButton sectordeatail_img_preazimuth;
    private EditText sectordeatail_edt_postazimuth;
    private ImageButton sectordeatail_img_postazimuth;
    private EditText sectordeatail_edt_premechanical_tilt;
    private ImageButton sectordeatail_img_premechanical_tilt;
    private EditText sectordeatail_edt_postmechanical_tilt;
    private ImageButton sectordeatail_img_postmechanical_tilt;
    private EditText sectordeatail_edt_preelectrical_tilt2g;
    private ImageButton sectordeatail_img_preelectrical_tilt2g;
    private EditText sectordeatail_edt_postelectrical_tilt2g;
    private ImageButton sectordeatail_img_postelectrical_tilt2g;
    private EditText sectordeatail_edt_preelectrical_tilt3g;
    private ImageButton sectordeatail_img_pretelectrical_tilt3g;
    private EditText sectordeatail_edt_postelectrical_tilt3g;
    private ImageButton sectordeatail_img_postelectrical_tilt3g;
    private EditText sectordeatail_edt_preelectrical_tilt4gf1;
    private ImageButton sectordeatail_img_preelectrical_tilt4gf1;
    private EditText sectordeatail_edt_postelectrical_tilt4gf1;
    private ImageButton sectordeatail_img_postelectrical_tilt4gf1;
    private EditText sectordeatail_edt_preelectrical_tilt4gf2;
    private ImageButton sectordeatail_img_preelectrical_tilt4gf2;
    private EditText sectordeatail_edt_postelectrical_tilt4gf2;
    private ImageButton sectordeatail_img_postelectrical_tilt4gf2;
    private EditText sectordeatail_edt_preelectrical_tilt;
    private ImageButton sectordeatail_img_preelectrical_tilt;
    private EditText sectordeatail_edt_postelectrical_tilt;
    private ImageButton sectordeatail_img_postelectrical_tilt;
    private EditText sectordeatail_edt_antennaheight;
    private ImageButton sectordeatail_img_antennaheight;
    private EditText sectordeatail_edt_poleheight;
    private ImageButton sectordeatail_img_poleheight;
    private EditText sectordeatail_edt_buildingheight;
    private ImageButton sectordeatail_img_buildingheight;
    private EditText sectordeatail_edt_towertype;
    private ImageButton sectordeatail_img_towertype;
    private EditText sectordeatail_edt_antennamake;
    private ImageButton sectordeatail_img_antennamake;
    private EditText sectordeatail_edt_antenmodel;
    private ImageButton sectordeatail_img_antennamodel;
    private EditText sectordeatail_edt_clutterpic;
    private ImageButton sectordeatail_img_clutterpic;
    private EditText sectordeatail_edt_txbandwidth;
    private ImageButton sectordeatail_img_txbandwidth;
    private EditText sectordeatail_edt_AST;
    private ImageButton sectordeatail_img_AST;
    private EditText sectordeatail_edt_APST;
    private ImageButton sectordeatail_img_APST;
    private EditText sectordeatail_edt_typ_enodeb;
    private ImageButton sectordeatail_img_typ_enodeb;
    private EditText sectordeatail_edt_mimo;
    private ImageButton sectordeatail_img_mimo;
    private EditText sectordeatail_edt_ret;
    private ImageButton sectordeatail_img_ret;
    private EditText sectordeatail_edt_enodebband;
    private ImageButton sectordeatail_img_enodebband;
    private EditText sectordeatail_edt_MOP;
    private ImageButton sectordeatail_img_MOP;
    private EditText sectordeatail_edt_COP;
    private ImageButton sectordeatail_img_COP;
    private EditText sectordeatail_edt_multiplexer_avail;
    private ImageButton sectordeatail_img_multiplexer_avail;
    private EditText sectordeatail_edt_antennapicleg;
    private ImageButton sectordeatail_img_antennapicleg;
    private EditText sectordeatail_edt_CRP;
    private ImageButton sectordeatail_img_CRP;
    private EditText sectordeatail_edt_powerdeboosting;
    private ImageButton sectordeatail_img_powerdeboosting;
    private EditText sectordeatail_edt_DFS;
    private ImageButton sectordeatail_img_DFS;
    private EditText sectordeatail_edt_rb_percell;
    private ImageButton sectordeatail_img_rb_percell;
    private EditText sectordeatail_edt_m_mimo;
    private ImageButton sectordeatail_img_m_mimo;
    private EditText sectordeatail_edt_FCT;
    private ImageButton sectordeatail_img_FCT;
    private EditText sectordeatail_edt_JCT;
    private ImageButton sectordeatail_img_JCT;
    private EditText sectordeatail_edt_FCL;
    private ImageButton sectordeatail_img_FCL;
    private EditText sectordeatail_edt_jumperlength;
    private ImageButton sectordeatail_img_jumperlength;
    private EditText sectordeatail_edt_prachconfig_index;
    private ImageButton sectordeatail_img_prachconfig_index;
    private EditText sectordeatail_edt_carrieraggregation;
    private ImageButton sectordeatail_img_carrieraggregation;
    private EditText sectordeatail_edt_ACD;
    private ImageButton sectordeatail_img_ACD;
    private EditText sectordeatail_edt_VSWRtest;
    private ImageButton sectordeatail_img_VSWRtest;
    private EditText sectordeatail_edt_URS;
    private ImageButton sectordeatail_img_URS;
    private EditText sectordeatail_edt_extra1;
    private ImageButton sectordeatail_img_extra1;
    private EditText sectordeatail_edt_extra2;
    private ImageButton sectordeatail_img_extra2;
    private EditText sectordeatail_edt_remak1;
    private ImageButton sectordeatail_img_remark1;
    private EditText sectordeatail_edt_remak2;
    private ImageButton sectordeatail_img_remark2;
    private Button btnsectordetail;


    public SectorDetailFragment() {
        // Required empty public constructor
    }

    public static SectorDetailFragment newInstance(int index, String name) {
        SectorDetailFragment f = new SectorDetailFragment();
        Bundle args = new Bundle();
        args.putInt("index", index);
        args.putString("name", name);
        f.setArguments(args);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_sector_detail, container, false);
        String name = getArguments().getString("name");


        findids(v);

        return v;
    }

    private void findids(View v) {

        sectordetail_edt_techavailable = v.findViewById(R.id.sectordetail_edt_techavailable);
        sectordetail_img_techavailable = v.findViewById(R.id.sectordetail_img_techavailable);
        sectordetail_edt_bandavailable = v.findViewById(R.id.sectordetail_edt_bandavailable);
        sectordeatail_img_bandavailable = v.findViewById(R.id.sectordeatail_img_bandavailable);
        sectordeatail_edt_APC = v.findViewById(R.id.sectordeatail_edt_APC);
        sectordeatail_img_APC = v.findViewById(R.id.sectordeatail_img_APC);
        sectoreatail_edt_preazimuth = v.findViewById(R.id.sectoreatail_edt_preazimuth);
        sectordeatail_img_preazimuth = v.findViewById(R.id.sectordeatail_img_preazimuth);
        sectordeatail_edt_postazimuth = v.findViewById(R.id.sectordeatail_edt_postazimuth);
        sectordeatail_img_postazimuth = v.findViewById(R.id.sectordeatail_img_postazimuth);
        sectordeatail_edt_premechanical_tilt = v.findViewById(R.id.sectordeatail_edt_premechanical_tilt);
        sectordeatail_img_premechanical_tilt = v.findViewById(R.id.sectordeatail_img_premechanical_tilt);
        sectordeatail_edt_postmechanical_tilt = v.findViewById(R.id.sectordeatail_edt_postmechanical_tilt);
        sectordeatail_img_postmechanical_tilt = v.findViewById(R.id.sectordeatail_img_postmechanical_tilt);
        sectordeatail_edt_preelectrical_tilt2g = v.findViewById(R.id.sectordeatail_edt_preelectrical_tilt2g);
        sectordeatail_img_preelectrical_tilt2g = v.findViewById(R.id.sectordeatail_img_preelectrical_tilt2g);
        sectordeatail_edt_postelectrical_tilt2g = v.findViewById(R.id.sectordeatail_edt_postelectrical_tilt2g);
        sectordeatail_img_postelectrical_tilt2g = v.findViewById(R.id.sectordeatail_img_postelectrical_tilt2g);
        sectordeatail_edt_preelectrical_tilt3g = v.findViewById(R.id.sectordeatail_edt_preelectrical_tilt3g);
        sectordeatail_img_pretelectrical_tilt3g = v.findViewById(R.id.sectordeatail_img_pretelectrical_tilt3g);
        sectordeatail_edt_postelectrical_tilt3g = v.findViewById(R.id.sectordeatail_edt_postelectrical_tilt3g);
        sectordeatail_img_postelectrical_tilt3g = v.findViewById(R.id.sectordeatail_img_postelectrical_tilt3g);
        sectordeatail_edt_preelectrical_tilt4gf1 = v.findViewById(R.id.sectordeatail_edt_preelectrical_tilt4gf1);
        sectordeatail_img_preelectrical_tilt4gf1 = v.findViewById(R.id.sectordeatail_img_preelectrical_tilt4gf1);
        sectordeatail_edt_postelectrical_tilt4gf1 = v.findViewById(R.id.sectordeatail_edt_postelectrical_tilt4gf1);
        sectordeatail_img_postelectrical_tilt4gf1 = v.findViewById(R.id.sectordeatail_img_postelectrical_tilt4gf1);
        sectordeatail_edt_preelectrical_tilt4gf2 = v.findViewById(R.id.sectordeatail_edt_preelectrical_tilt4gf2);
        sectordeatail_img_preelectrical_tilt4gf2 = v.findViewById(R.id.sectordeatail_img_preelectrical_tilt4gf2);
        sectordeatail_edt_postelectrical_tilt4gf2 = v.findViewById(R.id.sectordeatail_edt_postelectrical_tilt4gf2);
        sectordeatail_img_postelectrical_tilt4gf2 = v.findViewById(R.id.sectordeatail_img_postelectrical_tilt4gf2);
        sectordeatail_edt_preelectrical_tilt = v.findViewById(R.id.sectordeatail_edt_preelectrical_tilt);
        sectordeatail_img_preelectrical_tilt = v.findViewById(R.id.sectordeatail_img_preelectrical_tilt);
        sectordeatail_edt_postelectrical_tilt = v.findViewById(R.id.sectordeatail_edt_postelectrical_tilt);
        sectordeatail_img_postelectrical_tilt = v.findViewById(R.id.sectordeatail_img_postelectrical_tilt);
        sectordeatail_edt_antennaheight = v.findViewById(R.id.sectordeatail_edt_antennaheight);
        sectordeatail_img_antennaheight = v.findViewById(R.id.sectordeatail_img_antennaheight);
        sectordeatail_edt_poleheight = v.findViewById(R.id.sectordeatail_edt_poleheight);
        sectordeatail_img_poleheight = v.findViewById(R.id.sectordeatail_img_poleheight);
        sectordeatail_edt_buildingheight = v.findViewById(R.id.sectordeatail_edt_buildingheight);
        sectordeatail_img_buildingheight = v.findViewById(R.id.sectordeatail_img_buildingheight);
        sectordeatail_edt_towertype = v.findViewById(R.id.sectordeatail_edt_towertype);
        sectordeatail_img_towertype = v.findViewById(R.id.sectordeatail_img_towertype);
        sectordeatail_edt_antennamake = v.findViewById(R.id.sectordeatail_edt_antennamake);
        sectordeatail_img_antennamake = v.findViewById(R.id.sectordeatail_img_antennamake);
        sectordeatail_edt_antenmodel = v.findViewById(R.id.sectordeatail_edt_antenmodel);
        sectordeatail_img_antennamodel = v.findViewById(R.id.sectordeatail_img_antennamodel);
        sectordeatail_edt_clutterpic = v.findViewById(R.id.sectordeatail_edt_clutterpic);
        sectordeatail_img_clutterpic = v.findViewById(R.id.sectordeatail_img_clutterpic);
        sectordeatail_edt_txbandwidth = v.findViewById(R.id.sectordeatail_edt_txbandwidth);
        sectordeatail_img_txbandwidth = v.findViewById(R.id.sectordeatail_img_txbandwidth);
        sectordeatail_edt_AST = v.findViewById(R.id.sectordeatail_edt_AST);
        sectordeatail_img_AST = v.findViewById(R.id.sectordeatail_img_AST);
        sectordeatail_edt_APST = v.findViewById(R.id.sectordeatail_edt_APST);
        sectordeatail_img_APST = v.findViewById(R.id.sectordeatail_img_APST);
        sectordeatail_edt_typ_enodeb = v.findViewById(R.id.sectordeatail_edt_typ_enodeb);
        sectordeatail_img_typ_enodeb = v.findViewById(R.id.sectordeatail_img_typ_enodeb);
        sectordeatail_edt_mimo = v.findViewById(R.id.sectordeatail_edt_mimo);
        sectordeatail_img_mimo = v.findViewById(R.id.sectordeatail_img_mimo);
        sectordeatail_edt_ret = v.findViewById(R.id.sectordeatail_edt_ret);
        sectordeatail_img_ret = v.findViewById(R.id.sectordeatail_img_ret);
        sectordeatail_edt_enodebband = v.findViewById(R.id.sectordeatail_edt_enodebband);
        sectordeatail_img_enodebband = v.findViewById(R.id.sectordeatail_img_enodebband);
        sectordeatail_edt_MOP = v.findViewById(R.id.sectordeatail_edt_MOP);
        sectordeatail_img_MOP = v.findViewById(R.id.sectordeatail_img_MOP);
        sectordeatail_edt_COP = v.findViewById(R.id.sectordeatail_edt_COP);
        sectordeatail_img_COP = v.findViewById(R.id.sectordeatail_img_COP);
        sectordeatail_edt_multiplexer_avail = v.findViewById(R.id.sectordeatail_edt_multiplexer_avail);
        sectordeatail_img_multiplexer_avail = v.findViewById(R.id.sectordeatail_img_multiplexer_avail);
        sectordeatail_edt_antennapicleg = v.findViewById(R.id.sectordeatail_edt_antennapicleg);
        sectordeatail_img_antennapicleg = v.findViewById(R.id.sectordeatail_img_antennapicleg);
        sectordeatail_edt_CRP = v.findViewById(R.id.sectordeatail_edt_CRP);
        sectordeatail_img_CRP = v.findViewById(R.id.sectordeatail_img_CRP);
        sectordeatail_edt_powerdeboosting = v.findViewById(R.id.sectordeatail_edt_powerdeboosting);
        sectordeatail_img_powerdeboosting = v.findViewById(R.id.sectordeatail_img_powerdeboosting);
        sectordeatail_edt_DFS = v.findViewById(R.id.sectordeatail_edt_DFS);
        sectordeatail_img_DFS = v.findViewById(R.id.sectordeatail_img_DFS);
        sectordeatail_edt_rb_percell = v.findViewById(R.id.sectordeatail_edt_rb_percell);
        sectordeatail_img_rb_percell = v.findViewById(R.id.sectordeatail_img_rb_percell);
        sectordeatail_edt_m_mimo = v.findViewById(R.id.sectordeatail_edt_m_mimo);
        sectordeatail_img_m_mimo = v.findViewById(R.id.sectordeatail_img_m_mimo);
        sectordeatail_edt_FCT = v.findViewById(R.id.sectordeatail_edt_FCT);
        sectordeatail_img_FCT = v.findViewById(R.id.sectordeatail_img_FCT);
        sectordeatail_edt_JCT = v.findViewById(R.id.sectordeatail_edt_JCT);
        sectordeatail_img_JCT = v.findViewById(R.id.sectordeatail_img_JCT);
        sectordeatail_edt_FCL = v.findViewById(R.id.sectordeatail_edt_FCL);
        sectordeatail_img_FCL = v.findViewById(R.id.sectordeatail_img_FCL);
        sectordeatail_edt_jumperlength = v.findViewById(R.id.sectordeatail_edt_jumperlength);
        sectordeatail_img_jumperlength = v.findViewById(R.id.sectordeatail_img_jumperlength);
        sectordeatail_edt_prachconfig_index = v.findViewById(R.id.sectordeatail_edt_prachconfig_index);
        sectordeatail_img_prachconfig_index = v.findViewById(R.id.sectordeatail_img_prachconfig_index);
        sectordeatail_edt_carrieraggregation = v.findViewById(R.id.sectordeatail_edt_carrieraggregation);
        sectordeatail_img_carrieraggregation = v.findViewById(R.id.sectordeatail_img_carrieraggregation);

        sectordeatail_edt_ACD = v.findViewById(R.id.sectordeatail_edt_ACD);
        sectordeatail_img_ACD = v.findViewById(R.id.sectordeatail_img_ACD);
        sectordeatail_edt_VSWRtest = v.findViewById(R.id.sectordeatail_edt_VSWRtest);
        sectordeatail_img_VSWRtest = v.findViewById(R.id.sectordeatail_img_VSWRtest);
        sectordeatail_edt_URS = v.findViewById(R.id.sectordeatail_edt_URS);
        sectordeatail_img_URS = v.findViewById(R.id.sectordeatail_img_URS);
        sectordeatail_edt_extra1 = v.findViewById(R.id.sectordeatail_edt_extra1);
        sectordeatail_img_extra1 = v.findViewById(R.id.sectordeatail_img_extra1);
        sectordeatail_edt_extra2 = v.findViewById(R.id.sectordeatail_edt_extra2);
        sectordeatail_img_extra2 = v.findViewById(R.id.sectordeatail_img_extra2);
        sectordeatail_edt_remak1 = v.findViewById(R.id.sectordeatail_edt_remak1);
        sectordeatail_img_remark1 = v.findViewById(R.id.sectordeatail_img_remark1);
        sectordeatail_edt_remak2 = v.findViewById(R.id.sectordeatail_edt_remak2);
        sectordeatail_img_remark2 = v.findViewById(R.id.sectordeatail_img_remark2);
        btnsectordetail = v.findViewById(R.id.btnsectordetail);


       sectordetail_img_techavailable.setOnClickListener(this);
                sectordeatail_img_bandavailable.setOnClickListener(this);
        sectordeatail_img_APC.setOnClickListener(this);
                sectordeatail_img_preazimuth.setOnClickListener(this);
        sectordeatail_img_postazimuth.setOnClickListener(this);
                sectordeatail_img_premechanical_tilt.setOnClickListener(this);
        sectordeatail_img_postmechanical_tilt.setOnClickListener(this);
                sectordeatail_img_preelectrical_tilt2g.setOnClickListener(this);
        sectordeatail_img_postelectrical_tilt2g.setOnClickListener(this);
                sectordeatail_img_pretelectrical_tilt3g.setOnClickListener(this);
        sectordeatail_img_postelectrical_tilt3g.setOnClickListener(this);
                sectordeatail_img_preelectrical_tilt4gf1.setOnClickListener(this);
        sectordeatail_img_postelectrical_tilt4gf1.setOnClickListener(this);
                sectordeatail_img_preelectrical_tilt4gf2.setOnClickListener(this);
        sectordeatail_img_postelectrical_tilt4gf2.setOnClickListener(this);
                sectordeatail_img_preelectrical_tilt.setOnClickListener(this);
        sectordeatail_img_postelectrical_tilt.setOnClickListener(this);
                sectordeatail_img_antennaheight.setOnClickListener(this);
        sectordeatail_img_poleheight.setOnClickListener(this);
                sectordeatail_img_buildingheight.setOnClickListener(this);
        sectordeatail_img_towertype.setOnClickListener(this);
                sectordeatail_img_antennamake.setOnClickListener(this);
        sectordeatail_img_antennamodel.setOnClickListener(this);
                sectordeatail_img_clutterpic.setOnClickListener(this);
        sectordeatail_img_txbandwidth.setOnClickListener(this);
                sectordeatail_img_AST.setOnClickListener(this);
        sectordeatail_img_APST.setOnClickListener(this);
                sectordeatail_img_typ_enodeb.setOnClickListener(this);
        sectordeatail_img_mimo.setOnClickListener(this);
                sectordeatail_img_ret.setOnClickListener(this);
        sectordeatail_img_enodebband.setOnClickListener(this);
                sectordeatail_img_MOP.setOnClickListener(this);
        sectordeatail_img_COP.setOnClickListener(this);
                sectordeatail_img_multiplexer_avail.setOnClickListener(this);
        sectordeatail_img_antennapicleg.setOnClickListener(this);
                sectordeatail_img_CRP.setOnClickListener(this);
        sectordeatail_img_powerdeboosting.setOnClickListener(this);
                sectordeatail_img_DFS.setOnClickListener(this);
        sectordeatail_img_rb_percell.setOnClickListener(this);
                sectordeatail_img_m_mimo.setOnClickListener(this);
        sectordeatail_img_FCT.setOnClickListener(this);
                sectordeatail_img_JCT.setOnClickListener(this);
        sectordeatail_img_FCL.setOnClickListener(this);
                sectordeatail_img_jumperlength.setOnClickListener(this);
        sectordeatail_img_prachconfig_index.setOnClickListener(this);
                sectordeatail_img_carrieraggregation.setOnClickListener(this);
        sectordeatail_img_ACD.setOnClickListener(this);
                sectordeatail_img_VSWRtest.setOnClickListener(this);
        sectordeatail_img_URS.setOnClickListener(this);
                sectordeatail_img_extra1.setOnClickListener(this);
        sectordeatail_img_extra2.setOnClickListener(this);
                sectordeatail_img_remark1.setOnClickListener(this);
        sectordeatail_img_remark2.setOnClickListener(this);




    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            getFragmentManager().beginTransaction().detach(this).attach(this).commit();
        }
    }

    @Override
    public void onClick(View v) {

        if( v ==sectordetail_img_techavailable){

        }

        if( v ==sectordeatail_img_bandavailable){

        }
        if( v ==sectordeatail_img_APC){

        }
        if( v ==sectordeatail_img_preazimuth){

        }
        if( v ==sectordeatail_img_postazimuth){

        }
        if( v ==sectordeatail_img_premechanical_tilt){

        } if( v ==sectordeatail_img_postmechanical_tilt){

        }
        if( v ==sectordeatail_img_preelectrical_tilt2g){

        }
        if( v ==sectordeatail_img_postelectrical_tilt2g){

        }
        if( v ==sectordeatail_img_pretelectrical_tilt3g){

        }
        if( v ==sectordeatail_img_postelectrical_tilt3g){

        }
        if( v ==sectordeatail_img_preelectrical_tilt4gf1){

        }
        if( v ==sectordeatail_img_postelectrical_tilt4gf1){

        }
        if( v ==sectordeatail_img_preelectrical_tilt4gf2){

        }
        if( v ==sectordeatail_img_postelectrical_tilt4gf2){

        }
        if( v ==sectordeatail_img_preelectrical_tilt){

        }
        if( v ==sectordeatail_img_postelectrical_tilt){

        }
        if( v ==sectordeatail_img_antennaheight){

        }
        if( v ==sectordeatail_img_poleheight){

        }
        if( v ==sectordeatail_img_buildingheight){

        }
        if( v ==sectordeatail_img_towertype){

        }
        if( v ==sectordeatail_img_antennamake){

        }
        if( v ==sectordeatail_img_antennamodel){

        }

        if( v ==sectordeatail_img_clutterpic){

        }
        if( v ==sectordeatail_img_txbandwidth){

        }
        if( v ==sectordeatail_img_AST){

        }
        if( v ==sectordeatail_img_APST){

        }
        if( v ==sectordeatail_img_typ_enodeb){

        }
        if( v ==sectordeatail_img_mimo){

        }
        if( v ==sectordeatail_img_ret){

        }
        if( v == sectordeatail_img_ret){

        }
        if( v == sectordeatail_img_enodebband){

        }
        if( v ==sectordeatail_img_MOP){

        }
        if( v ==sectordeatail_img_COP){

        }
        if( v ==sectordeatail_img_multiplexer_avail){

        }
        if( v ==sectordeatail_img_antennapicleg){

        }
        if( v ==sectordeatail_img_CRP){

        } if( v ==sectordeatail_img_powerdeboosting){

        } if( v ==sectordeatail_img_DFS){

        } if( v ==sectordeatail_img_rb_percell){

        } if( v ==sectordeatail_img_m_mimo){

        } if( v ==sectordeatail_img_FCT){

        } if( v ==sectordeatail_img_JCT){

        } if( v ==sectordeatail_img_FCL){

        } if( v ==sectordeatail_img_jumperlength){

        }
        if( v ==sectordeatail_img_prachconfig_index){

        } if( v ==sectordeatail_img_carrieraggregation){

        } if( v ==sectordeatail_img_ACD){

        } if( v ==sectordeatail_img_VSWRtest){

        }
        if( v ==sectordeatail_img_URS){

        }
        if( v ==sectordeatail_img_extra1){
        }
        if( v ==sectordeatail_img_extra2){

        }if( v ==sectordeatail_img_remark1){

        }if( v ==sectordeatail_img_remark2){

        }





    }
}
