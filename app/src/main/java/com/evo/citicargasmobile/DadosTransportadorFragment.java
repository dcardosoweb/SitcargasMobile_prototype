package com.evo.citicargasmobile;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.evo.citicargasmobile.Adapter.AbasPagerAdapter;
import com.evo.citicargasmobile.Entity.Transportador;

public class DadosTransportadorFragment extends Fragment {


    ViewPager mViewPager;
    SlidingTabLayout mSlidingTabLayout;
    Transportador transportador;

    public DadosTransportadorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_dados_transportador, container, false);

        mViewPager = (ViewPager)layout.findViewById(R.id.pager);

        AbasPagerAdapter vAdapter = new AbasPagerAdapter(getActivity(), getActivity().getSupportFragmentManager(),transportador);
        mViewPager.setAdapter(vAdapter);
        mSlidingTabLayout = (SlidingTabLayout)layout.findViewById(R.id.tabs);
        mSlidingTabLayout.setDistributeEvenly(true);
        mSlidingTabLayout.setViewPager(mViewPager);

        return layout;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
