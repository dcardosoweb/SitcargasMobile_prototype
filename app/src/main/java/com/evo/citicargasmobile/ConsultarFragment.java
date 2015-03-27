package com.evo.citicargasmobile;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.evo.citicargasmobile.Adapter.TransportadorAdapter;
import com.evo.citicargasmobile.DAO.TransportadorRepository;
import com.evo.citicargasmobile.Entity.Transportador;

import java.util.List;


public class ConsultarFragment extends Fragment implements View.OnClickListener{

    EditText txtNome;
    EditText txtRntrc;
    EditText txtCpfCnpj;
    TransportadorRepository repository;
    List<Transportador> mTransportadores;
    TransportadorAdapter mAdapter;
    ListView listV;

    public ConsultarFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_consultar, container, false);

        txtNome= (EditText) layout.findViewById(R.id.edtNome);
        txtCpfCnpj= (EditText) layout.findViewById(R.id.edtCpfCnpj);
        txtRntrc= (EditText) layout.findViewById(R.id.edtRntrc);
        listV = (ListView) layout.findViewById(R.id.listViewTransportadorResult);

        Button btnConsultar = (Button) layout.findViewById(R.id.btnConsultar);
        Button btnLimpar = (Button) layout.findViewById(R.id.btnLimpar);
        btnConsultar.setOnClickListener(this);
        btnLimpar.setOnClickListener(this);

        return layout;

    }

    @Override
    public void onActivityCreated(Bundle savedInstance){
        super.onCreate(savedInstance);
        repository = new TransportadorRepository(getActivity());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLimpar:
                txtNome.setText(null);
                txtRntrc.setText(null);
                txtCpfCnpj.setText(null);
                break;
            case R.id.btnConsultar:
                Transportador filter = new Transportador(txtCpfCnpj.getText().toString(), txtRntrc.getText().toString(), txtNome.getText().toString());
                TransportadorListFragment result = new TransportadorListFragment();
                result.transportadorFilter = filter;
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, result)
                        .commit();
                break;
        }
    }

    private List<Transportador> buscar(String nome, String cpfCnpj, String rntrc){
        return repository.consultarTransportadores(nome,cpfCnpj,rntrc);
    }
}
