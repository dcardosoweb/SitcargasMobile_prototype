package com.evo.citicargasmobile.Adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.evo.citicargasmobile.Entity.Transportador;
import com.evo.citicargasmobile.R;

import java.util.List;

/**
 * Created by Daniel on 23/03/2015.
 */
public class TransportadorAdapter extends BaseAdapter {

    Context ctx;
    List<Transportador> transportadores;

    public TransportadorAdapter(Context ctx, List<Transportador> transportadores) {
        this.ctx = ctx;
        this.transportadores = transportadores;
    }

    @Override
    public int getCount() {
        return transportadores.size();
    }

    @Override
    public Object getItem(int position) {
        return transportadores.get(position);
    }

    @Override
    public long getItemId(int position) {
        return transportadores.get(position).id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Transportador transportador = transportadores.get(position);
        View linha = LayoutInflater.from(ctx).inflate(R.layout.fragment_transportador_item, null);

        TextView txtNome = (TextView) linha.findViewById(R.id.txtxNomeVal);
        TextView txtRntrc = (TextView) linha.findViewById(R.id.txtxRntrcVal);
        TextView txtCpfCnpj = (TextView) linha.findViewById(R.id.txtxCpfCnpjVal);
        TextView txtUf = (TextView) linha.findViewById(R.id.txtxUfVal);
        TextView txtSituacao = (TextView) linha.findViewById(R.id.txtxSituacaoVal);
        TextView txtTipo = (TextView) linha.findViewById(R.id.txtxTipoVal);

        txtNome.setText(transportador.nome);
        txtRntrc.setText(transportador.rntrc);
        txtCpfCnpj.setText(transportador.cpfCnpj);
        txtUf.setText(transportador.uf);
        txtSituacao.setText(transportador.situacaoRntrc);
        txtTipo.setText(transportador.tipoTransportador);

        return linha;
    }
}
