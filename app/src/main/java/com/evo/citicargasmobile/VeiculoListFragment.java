package com.evo.citicargasmobile;




import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.Gravity;
import android.widget.ListView;
import android.widget.TextView;

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
    final int PADDING = 8;

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
        montarHeader();
        montarFooter();
    }

    public void buscar() {
        Bundle params = getArguments();
        mRepositorio = new VeiculoRepository(getActivity());
        mVeiculos = mRepositorio.consultarVeiculosTransportador(params.getLong("ID_TRANSPORTADOR"));
        tAdapter = new VeiculoAdapter(getActivity(),mVeiculos);
        setListAdapter(tAdapter);
        setEmptyText("Não existem veículos para o transportador");
    }

    private void montarHeader()
    {
        TextView txtHeader = new TextView(getActivity());
        txtHeader.setBackgroundColor(Color.GRAY);
        txtHeader.setTextColor(Color.WHITE);
        txtHeader.setText("Veículos do Transportador");
        txtHeader.setPadding(PADDING, PADDING, 0, PADDING);
        mListView.addHeaderView(txtHeader);
    }

    private void montarFooter(){
        TextView txtFooter = new TextView(getActivity());
        txtFooter.setText(getResources().getQuantityString(
                R.plurals.texto_rodape_veiculo,
                tAdapter.getCount(),
                tAdapter.getCount()));
        txtFooter.setBackgroundColor(Color.LTGRAY);
        txtFooter.setGravity(Gravity.RIGHT);
        txtFooter.setPadding(0, PADDING, PADDING, PADDING);
        mListView.addFooterView(txtFooter);
    }
}
