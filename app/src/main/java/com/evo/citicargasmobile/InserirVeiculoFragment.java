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
                salvarCarga();
               /* long id = salvar(
                        Long.parseLong(txtIdTransportador.getText().toString()),
                        txtPlaca.getText().toString(),
                        txtRenavam.getText().toString(),
                        txtMarca.getText().toString(),
                        txtAnoFabricacao.getText().toString(),
                        txtPropriedade.getText().toString()
                );
                Toast.makeText(this.getActivity(), "Veiculo cadastrado ID -" + String.valueOf(id), Toast.LENGTH_SHORT).show();*/
                break;
        }
    }

    private void salvarCarga(){
        repository.inserir(veiculoCTC1());
        repository.inserir(veiculoCTC2());
        repository.inserir(veiculoCTC3());
        repository.inserir(veiculoCTC4());
        repository.inserir(veiculoTAC());
        repository.inserir(veiculoETC1());
        repository.inserir(veiculoETC2());
        repository.inserir(veiculoETC3());
        repository.inserir(veiculoETC4());
        repository.inserir(veiculoETC5());
        repository.inserir(veiculoETC6());

    }

    private Veiculo veiculoCTC1(){
        return new Veiculo(
                2,
                "BCC-0360",
                "678684090",
                "FIAT",
                "2008",
                "Próprio"
        );
    }

    private Veiculo veiculoCTC3(){
        return new Veiculo(
                2,
                "ABC-0360",
                "678684090",
                "FIAT",
                "2008",
                "Próprio"
        );
    }

    private Veiculo veiculoCTC2(){
        return new Veiculo(
                2,
                "DEC-0859",
                "678684090",
                "FIAT",
                "2004",
                "Próprio"
        );
    }

    private Veiculo veiculoCTC4(){
        return new Veiculo(
                2,
                "GTC-0859",
                "678684090",
                "FIAT",
                "2004",
                "Próprio"
        );
    }

    private Veiculo veiculoTAC(){
        return new Veiculo(
                3,
                "KGB-1947",
                "678684090",
                "FIAT",
                "1947",
                "Próprio"
        );
    }

    private Veiculo veiculoETC1(){
        return new Veiculo(
                4,
                "KGB-1948",
                "678884590",
                "HONDA",
                "1948",
                "Próprio"
        );
    }

    private Veiculo veiculoETC2(){
        return new Veiculo(
                4,
                "TER-1234",
                "677726090",
                "HYUNDAI",
                "1947",
                "Leasing"
        );
    }

    private Veiculo veiculoETC3(){
        return new Veiculo(
                4,
                "ABC-4389",
                "338484090",
                "HYUNDAI",
                "1998",
                "Arrendado"
        );
    }

    private Veiculo veiculoETC4(){
        return new Veiculo(
                4,
                "IOP-1947",
                "678684090",
                "FORD",
                "1965",
                "Próprio"
        );
    }

    private Veiculo veiculoETC5(){
        return new Veiculo(
                4,
                "FGT-8745",
                "678684090",
                "HONDA",
                "1987",
                "Próprio"
        );
    }

    private Veiculo veiculoETC6(){
        return new Veiculo(
                4,
                "NJU-1951",
                "678684090",
                "FIAT",
                "2010",
                "Próprio"
        );
    }
}
