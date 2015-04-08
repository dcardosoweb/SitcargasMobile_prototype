package com.evo.citicargasmobile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.evo.citicargasmobile.DAO.TransportadorRepository;
import com.evo.citicargasmobile.Entity.Transportador;


public class DetalharTransportadorFragment extends Fragment {

    Transportador  transportador;
    TextView mTextNome;
    TextView mTextRntrc;
    TextView mTextCpfCnpj;
    TextView mTextSituacao;
    TextView mTextTipo;
    TextView mLabelCpfCnpj;
    TextView mTexEmissao;
    TextView mTextRecadastramento;
    TextView mTextVencimento;

    TextView mTextCelular;
    TextView mTextEmail;
    TextView mTextFixo;
    TextView mTexFax;
    TextView mTextComercial;
    TextView mTextCorrespondencia;
    final String VALOR_NAO_INFORMADO="Não informado";


    TransportadorRepository repository;


    public DetalharTransportadorFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public static DetalharTransportadorFragment novaInstancia(
            String cpfCnpj) {

        Bundle params = new Bundle();
        params.putString("CPF_CNPJ", cpfCnpj);
        DetalharTransportadorFragment dtf = new DetalharTransportadorFragment();
        dtf.setArguments(params);
        return dtf;
    }

    @Override
    public void onActivityCreated(Bundle savedInstance){
        super.onCreate(savedInstance);
        repository = new TransportadorRepository(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Bundle params = getArguments();
        repository = new TransportadorRepository(getActivity());
        transportador = repository.detalharTransportador(params.getString("CPF_CNPJ"));

        View layout = inflater.inflate(R.layout.fragment_detalhar_transportador, container, false);
        mTextNome = (TextView) layout.findViewById(R.id.txtNome);
        mTextCpfCnpj = (TextView) layout.findViewById(R.id.txtCpfCnpj);
        mTextRntrc = (TextView) layout.findViewById(R.id.txtRntrc);
        mTextTipo = (TextView) layout.findViewById(R.id.txtTipo);
        mTextSituacao = (TextView) layout.findViewById(R.id.txtSituacao);
        mLabelCpfCnpj = (TextView) layout.findViewById(R.id.txtCpfCnpjLabel);
        mTexEmissao= (TextView) layout.findViewById(R.id.txtEmissao);
        mTextRecadastramento = (TextView) layout.findViewById(R.id.txtRecadastramento);
        mTextVencimento = (TextView) layout.findViewById(R.id.txtVencimento);

        mTextCelular= (TextView) layout.findViewById(R.id.txtCelular);
        mTextEmail = (TextView) layout.findViewById(R.id.txtEmail);
        mTextFixo = (TextView) layout.findViewById(R.id.txtFixo);
        mTexFax= (TextView) layout.findViewById(R.id.txtFax);
        mTextCorrespondencia = (TextView) layout.findViewById(R.id.txtCorrespondencia);
        mTextComercial = (TextView) layout.findViewById(R.id.txtComercial);

        if(transportador != null){
            mTextNome.setText(transportador.nome);
            mTextCpfCnpj.setText(transportador.cpfCnpj);
            mTextRntrc.setText(transportador.rntrc);
            mTextTipo.setText(transportador.tipoTransportador);
            mTextSituacao.setText(transportador.situacaoRntrc);

            mTexEmissao.setText(transportador.dataEmissao);
            mTextRecadastramento.setText(transportador.dataRecadastramento);
            mTextVencimento.setText(transportador.dataValidade);

            if(transportador.tipoTransportador != null && transportador.tipoTransportador.toString().equalsIgnoreCase("TAC"))
                mLabelCpfCnpj.setText("CPF:");
            else
                mLabelCpfCnpj.setText("CNPJ:");

            if(transportador.contatoCelular != null && !transportador.contatoCelular.isEmpty())
                mTextCelular.setText(transportador.contatoCelular);
            else
                mTextCelular.setText(VALOR_NAO_INFORMADO);

            if(transportador.contatoEmail != null && !transportador.contatoEmail.isEmpty())
                mTextEmail.setText(transportador.contatoEmail);
            else
                mTextEmail.setText(VALOR_NAO_INFORMADO);

            if(transportador.contatoFixo != null && !transportador.contatoFixo.isEmpty())
                mTextFixo.setText(transportador.contatoFixo);
            else
                mTextFixo.setText(VALOR_NAO_INFORMADO);

            if(transportador.contatoFax != null && !transportador.contatoFax.isEmpty())
                mTexFax.setText(transportador.contatoFax);
            else
                mTexFax.setText(VALOR_NAO_INFORMADO);

            if(transportador.enderecoComercial != null && !transportador.enderecoComercial.isEmpty())
                mTextComercial.setText(transportador.enderecoComercial);
            else
                mTextComercial.setText(VALOR_NAO_INFORMADO);

            if(transportador.enderecoCorrespondencia != null && !transportador.enderecoCorrespondencia.isEmpty())
                mTextCorrespondencia.setText(transportador.enderecoCorrespondencia);
            else
                mTextCorrespondencia.setText(VALOR_NAO_INFORMADO);
        }

        return layout;
    }


}
