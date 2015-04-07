package com.evo.citicargasmobile;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.evo.citicargasmobile.DAO.TransportadorRepository;
import com.evo.citicargasmobile.DAO.VeiculoRepository;
import com.evo.citicargasmobile.Entity.Transportador;
import com.evo.citicargasmobile.Entity.Veiculo;


public class InserirVeiculoFragment extends Fragment implements View.OnClickListener {

    EditText txtIdTransportador;
    EditText txtPlaca;
    EditText txtRenavam;
    EditText txtMarca;
    EditText txtAnoFabricacao;
    EditText txtPropriedade;

    VeiculoRepository repository;

    public InserirVeiculoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstance){
        super.onCreate(savedInstance);
        repository = new VeiculoRepository(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout =  inflater.inflate(R.layout.fragment_inserir_veiculo, container, false);

        txtIdTransportador= (EditText) layout.findViewById(R.id.edtIdTransportador);
        txtPlaca= (EditText) layout.findViewById(R.id.edtPlaca);
        txtRenavam= (EditText) layout.findViewById(R.id.edtRenavam);
        txtMarca= (EditText) layout.findViewById(R.id.edtNMarca);
        txtAnoFabricacao= (EditText) layout.findViewById(R.id.edtAnoFabricacao);
        txtPropriedade= (EditText) layout.findViewById(R.id.edtPropriedade);


        Button btnInserir = (Button) layout.findViewById(R.id.btnInserir);
        Button btnLimpar = (Button) layout.findViewById(R.id.btnLimpar);
        btnInserir.setOnClickListener(this);
        btnLimpar.setOnClickListener(this);

        return layout;
    }

    private long salvar(
            long idTrasportador, String placa, String renavam, String marca, String anoFabricacao, String propriedade){
        Veiculo dto = new Veiculo(idTrasportador, placa, renavam, marca, anoFabricacao, propriedade);
        return repository.inserir(dto);
    }

    private void limparCampos(){
        txtIdTransportador.setText(null);
        txtPlaca.setText(null);
        txtRenavam.setText(null);
        txtMarca.setText(null);
        txtAnoFabricacao.setText(null);
        txtPropriedade.setText(null);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLimpar:
                limparCampos();
                break;
            case R.id.btnInserir:
                long id = salvar(
                        Long.parseLong(txtIdTransportador.getText().toString()),
                        txtPlaca.getText().toString(),
                        txtRenavam.getText().toString(),
                        txtMarca.getText().toString(),
                        txtAnoFabricacao.getText().toString(),
                        txtPropriedade.getText().toString()
                );
                Toast.makeText(this.getActivity(), "Veiculo cadastrado ID -" + String.valueOf(id), Toast.LENGTH_LONG).show();
                limparCampos();
                break;
        }
    }
}
