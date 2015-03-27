package com.evo.citicargasmobile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.evo.citicargasmobile.Entity.Transportador;


public class DetalharTransportadorFragment extends Fragment {

    Transportador  transportador;
    TextView mTextNome;
    TextView mTextRntrc;
    TextView mTextCpfCnpj;
    TextView mTextSituacao;
    TextView mTextTipo;



    public DetalharTransportadorFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_detalhar_transportador, container, false);

        mTextNome = (TextView) layout.findViewById(R.id.txtNome);
        mTextCpfCnpj = (TextView) layout.findViewById(R.id.txtCpfCnpj);
        mTextRntrc = (TextView) layout.findViewById(R.id.txtRntrc);
        mTextTipo = (TextView) layout.findViewById(R.id.txtTipo);
        mTextSituacao = (TextView) layout.findViewById(R.id.txtSituacao);

        if(transportador != null){
            mTextNome.setText(transportador.nome);
            mTextCpfCnpj.setText(transportador.cpfCnpj);
            mTextRntrc.setText(transportador.rntrc);
        }

        return layout;
    }


}
