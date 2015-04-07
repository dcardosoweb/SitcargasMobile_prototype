package com.evo.citicargasmobile;




import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.widget.ListView;

import com.evo.citicargasmobile.Adapter.VeiculoAdapter;
import com.evo.citicargasmobile.DAO.VeiculoRepository;
import com.evo.citicargasmobile.Entity.Transportador;
import com.evo.citicargasmobile.Entity.Veiculo;

import java.util.List;

public class VeiculoListFragment extends ListFragment {

    ListView mListView;
    List<Veiculo> mVeiculos;
    VeiculoRepository mRepositorio;
    Transportador transportadorFilter;
    VeiculoAdapter tAdapter;

    public VeiculoListFragment() {
        // Required empty public constructor
    }

    public static VeiculoListFragment novaInstancia(
            long idTransportador) {

        Bundle params = new Bundle();
        params.putLong("ID_TRANSPORTADOR", idTransportador);
        VeiculoListFragment vlf = new VeiculoListFragment();
        vlf.setArguments(params);
        return vlf;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mListView = getListView();
        buscar();
    }

    public void buscar() {
        Bundle params = getArguments();
        mRepositorio = new VeiculoRepository(getActivity());
        mVeiculos = mRepositorio.consultarVeiculosTransportador(params.getLong("ID_TRANSPORTADOR"));
        tAdapter = new VeiculoAdapter(getActivity(),mVeiculos);
        setListAdapter(tAdapter);
    }
}
