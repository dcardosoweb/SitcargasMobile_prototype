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
    EditText txtTipo;
    EditText txtSituacao;
    EditText txtDataValidade;
    EditText txtDataRecadastramento;
    EditText txtDataEmissao;
    EditText txtUf;
    EditText txtContatoCelular;
    EditText txtContatoEmail;
    EditText txtContatoFixo;
    EditText txtContatoFax;
    EditText txtEnderecoComercial;
    EditText txtEnderecoCorrespondencia;


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
        txtTipo= (EditText) layout.findViewById(R.id.edtTipoTransportador);
        txtSituacao= (EditText) layout.findViewById(R.id.edtSituacao);
        txtDataValidade= (EditText) layout.findViewById(R.id.edtDataValidade);
        txtDataRecadastramento= (EditText) layout.findViewById(R.id.edtDataRecadastramento);
        txtDataEmissao= (EditText) layout.findViewById(R.id.edtDataEmissao);
        txtUf= (EditText) layout.findViewById(R.id.edtUf);
        txtContatoCelular= (EditText) layout.findViewById(R.id.edtContatoCelular);
        txtContatoEmail= (EditText) layout.findViewById(R.id.edtContatoEmail);
        txtContatoFixo= (EditText) layout.findViewById(R.id.edtContatoFixo);
        txtContatoFax= (EditText) layout.findViewById(R.id.edtContatoFax);
        txtEnderecoComercial= (EditText) layout.findViewById(R.id.edtEnderecoComercial);
        txtEnderecoCorrespondencia= (EditText) layout.findViewById(R.id.edtEnderecoCorrespondencia);

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
                limparCampos();
                break;
            case R.id.btnInserir:
                long id = salvar(
                        txtNome.getText().toString(),
                        txtCpfCnpj.getText().toString(),
                        txtRntrc.getText().toString(),
                        txtTipo.getText().toString(),
                        txtSituacao.getText().toString(),
                        txtDataValidade.getText().toString(),
                        txtDataRecadastramento.getText().toString(),
                        txtDataEmissao.getText().toString(),
                        txtUf.getText().toString(),
                        txtContatoCelular.getText().toString(),
                        txtContatoEmail.getText().toString(),
                        txtContatoFixo.getText().toString(),
                        txtContatoFax.getText().toString(),
                        txtEnderecoComercial.getText().toString(),
                        txtEnderecoCorrespondencia.getText().toString()
                );
                Toast.makeText(this.getActivity(), "Transportador cadastrado ID -"+ String.valueOf(id),Toast.LENGTH_LONG).show();
                limparCampos();
                break;
        }
    }

    private long salvar(
            String nome,
            String cpfCnpj,
            String rntrc,String tipoTransportador,String situacaoRntrc, String dataValidade, String dataRecadastramento,
            String dataEmissao, String uf, String contatoCelular,  String contatoEmail, String contatoFixo,
            String contatoFax, String enderecoComercial, String enderecoCorrespondencia){
        Transportador dto = new Transportador(nome,rntrc,cpfCnpj,tipoTransportador,
                dataValidade,dataRecadastramento,dataEmissao,situacaoRntrc,uf, contatoCelular, contatoEmail,
                contatoFixo,contatoFax,enderecoComercial,enderecoCorrespondencia);
        return repository.inserir(dto);
    }



    private void limparCampos(){
        txtNome.setText(null);
        txtRntrc.setText(null);
        txtCpfCnpj.setText(null);
        txtTipo.setText(null);
        txtSituacao.setText(null);
        txtDataValidade.setText(null);
        txtDataRecadastramento.setText(null);
        txtDataEmissao.setText(null);
        txtUf.setText(null);
        txtContatoCelular.setText(null);
        txtContatoEmail.setText(null);
        txtContatoFixo.setText(null);
        txtContatoFax.setText(null);
        txtEnderecoComercial.setText(null);
        txtEnderecoCorrespondencia.setText(null);
    }
}
