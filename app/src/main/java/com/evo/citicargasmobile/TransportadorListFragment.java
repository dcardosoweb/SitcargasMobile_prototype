package com.evo.citicargasmobile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;

import com.evo.citicargasmobile.Adapter.TransportadorAdapter;
import com.evo.citicargasmobile.DAO.TransportadorRepository;
import com.evo.citicargasmobile.Entity.Transportador;
import java.util.List;


public class TransportadorListFragment extends ListFragment   {

    ListView mListView;
    List<Transportador> mTransportadores;
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
        DadosTransportadorFragment result = new DadosTransportadorFragment();
        result.transportador = transportadorSelecionado;
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment f = fragmentManager.findFragmentByTag("tag");
        fragmentTransaction.replace(R.id.container, result,"tag");
        if(f != null){
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        }
        fragmentTransaction.commit();
    }

    public void buscar() {
        mTransportadores = mRepositorio.consultarTransportadores(transportadorFilter.nome, transportadorFilter.cpfCnpj, transportadorFilter.rntrc);
        tAdapter = new TransportadorAdapter(getActivity(),mTransportadores);
        setListAdapter(tAdapter);
    }



}
