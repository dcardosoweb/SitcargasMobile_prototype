package com.evo.citicargasmobile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.evo.citicargasmobile.DAO.TransportadorRepository;
import com.evo.citicargasmobile.Entity.Transportador;



public class InserirFragment extends Fragment implements View.OnClickListener{


    EditText txtNome;
    EditText txtRntrc;
    EditText txtCpfCnpj;
    TransportadorRepository repository;

    public InserirFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout =  inflater.inflate(R.layout.fragment_inserir, container, false);

        txtNome= (EditText) layout.findViewById(R.id.edtNome);
        txtCpfCnpj= (EditText) layout.findViewById(R.id.edtCpfCnpj);
        txtRntrc= (EditText) layout.findViewById(R.id.edtRntrc);

        Button btnInserir = (Button) layout.findViewById(R.id.btnInserir);
        Button btnLimpar = (Button) layout.findViewById(R.id.btnLimpar);
        btnInserir.setOnClickListener(this);
        btnLimpar.setOnClickListener(this);

        return layout;
    }

    @Override
    public void onActivityCreated(Bundle savedInstance){
        super.onCreate(savedInstance);
        repository = new TransportadorRepository(getActivity());
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btnLimpar:
                txtNome.setText(null);
                txtRntrc.setText(null);
                txtCpfCnpj.setText(null);
                break;
            case R.id.btnInserir:
                long id = salvar(txtNome.getText().toString(),txtCpfCnpj.getText().toString(),txtRntrc.getText().toString());
                //Toast.makeText(this.,"Teste",Toast.LENGTH_LONG).show();
                Toast.makeText(this.getActivity(), "Transportador cadastrado ID -"+ String.valueOf(id),Toast.LENGTH_LONG).show();
                break;
        }
    }

    private long salvar(String nome, String cpfCnpj, String rntrc){
        Transportador dto = new Transportador(cpfCnpj,rntrc,nome);
        return repository.inserir(dto);
    }

}
