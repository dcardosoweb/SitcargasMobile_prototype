package com.evo.citicargasmobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.view.ActionMode;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.evo.citicargasmobile.Adapter.TransportadorAdapter;
import com.evo.citicargasmobile.DAO.TransportadorRepository;
import com.evo.citicargasmobile.Entity.Transportador;

import java.util.ArrayList;
import java.util.List;


public class TransportadorListFragment extends ListFragment   {

    ListView mListView;
    List<Transportador> mTransportadores;
    ArrayAdapter<Transportador> mAdapter;
    ActionMode mActionMode;
    TransportadorRepository mRepositorio;
    Transportador transportadorFilter;
    TransportadorAdapter tAdapter;

    public TransportadorListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mListView = getListView();
        mRepositorio = new TransportadorRepository(getActivity());
        buscar();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Transportador transportadorSelecionado = (Transportador) l.getItemAtPosition(position);
        DetalharTransportadorFragment result = new DetalharTransportadorFragment();
        result.transportador = transportadorSelecionado;
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, result)
                .commit();
    }

    public void buscar() {
        mTransportadores = mRepositorio.consultarTransportadores(transportadorFilter.nome, transportadorFilter.cpfCnpj, transportadorFilter.rntrc);
        tAdapter = new TransportadorAdapter(getActivity(),mTransportadores);
        setListAdapter(tAdapter);
    }


}
