package com.evo.citicargasmobile.Adapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.evo.citicargasmobile.DetalharTransportadorFragment;
import com.evo.citicargasmobile.Entity.Transportador;
import com.evo.citicargasmobile.R;
import com.evo.citicargasmobile.VeiculoListFragment;

import java.util.List;
import java.util.Locale;

/**
 * Created by Daniel on 06/04/2015.
 */
public class AbasPagerAdapter extends FragmentStatePagerAdapter {

    String[] titulosAbas;
    Transportador transportador;

    public AbasPagerAdapter(Context ctx, FragmentManager fm, Transportador transportadorParam) {
        super(fm);
        titulosAbas = ctx.getResources().getStringArray(R.array.secoes);
        transportador = transportadorParam;
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            DetalharTransportadorFragment fragment = DetalharTransportadorFragment.novaInstancia(transportador.cpfCnpj);
            return fragment;
        } else if (position == 1){
            VeiculoListFragment fragment = VeiculoListFragment.novaInstancia(transportador.id);
            return fragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();
        return titulosAbas[position].toUpperCase(l);
    }
}