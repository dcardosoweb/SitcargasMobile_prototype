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
                salvarCargaTransportador();
                /*long id = salvar(
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
                Toast.makeText(this.getActivity(), "Transportador cadastrado ID -"+ String.valueOf(id),Toast.LENGTH_SHORT).show();*/
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


    private void salvarCargaTransportador(){
        repository.inserir(inserirETC1());
        repository.inserir(inserirCTC1());
        repository.inserir(inserirTAC1());
        repository.inserir(inserirETC2());
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

    private Transportador inserirETC1()
    {
        return new Transportador(
                "DIOGO DE OLIVEIRA PARREIRA FRANCA - ME",
                "002943781",
                "00645399000168",
                "ETC",
                "31/05/2015",
                "04/03/2010",
                "14/02/2005",
                "ATIVO",
                "SP",
                null,
                null,
                "(64)4005-8800",
                null,
                "RODOVIA BR 060 KM 383,SETOR ALVORADA, Rio Verde",
                null
        );
    }

    private Transportador inserirETC2()
    {
        return new Transportador(
                "C&A TEIXEIRINHA DE PADRA E PAPEL LTDA",
                "002943781",
                "00645399000168",
                "ETC",
                "31/03/2015",
                "04/03/2010",
                "14/02/2005",
                "VENCIDO",
                "SP",
                null,
                null,
                "(11)4005-8800",
                null,
                "RODOVIA BR 060 KM 383,SETOR ALVORADA, Rio Verde",
                null
        );
    }

    private Transportador inserirCTC1()
    {
        return new Transportador(
                "COOPERATIVA DE TRANSPORTES DE CARGAS",
                "000244343",
                "81800849000141",
                "ETC",
                "28/05/2015",
                "04/03/2010",
                "15/09/2004",
                "ATIVO",
                "AM",
                "(49)93444-7000",
                null,
                "(49)4005-8800",
                null,
                "RUA MARECHAL DEODORO,Centro, Concórdia",
                null
        );
    }

    private Transportador inserirTAC1()
    {
        return new Transportador(
                "DANIEL CARDOSO GONÇALVES",
                "000244589",
                "12044922711",
                "TAC",
                "28/05/2015",
                "04/03/2010",
                "15/09/2004",
                "ATIVO",
                "AM",
                "(21)98449-1601",
                "dcardoso.web@gmail.com",
                null,
                null,
                "AV.Vicente de Carvalho, 1086, Vila Kosmos",
                "AV.Vicente de Carvalho, 1086, Vila Kosmos"
        );
    }
}
