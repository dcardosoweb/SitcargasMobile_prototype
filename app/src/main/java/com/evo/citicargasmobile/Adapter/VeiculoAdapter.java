package com.evo.citicargasmobile.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.evo.citicargasmobile.Entity.Transportador;
import com.evo.citicargasmobile.Entity.Veiculo;
import com.evo.citicargasmobile.R;

import java.util.List;

/**
 * Created by Daniel on 06/04/2015.
 */
public class VeiculoAdapter extends BaseAdapter {


    Context ctx;
    List<Veiculo> veiculos;

    public VeiculoAdapter(Context ctx, List<Veiculo> veiculos) {
        this.ctx = ctx;
        this.veiculos = veiculos;
    }

    @Override
    public int getCount() {
        return veiculos.size();
    }

    @Override
    public Object getItem(int position) {
        return veiculos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return veiculos.get(position).id;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Veiculo veiculo = veiculos.get(position);
        View linha = LayoutInflater.from(ctx).inflate(R.layout.fragment_veiculo_item, null);

        TextView txtPlaca = (TextView) linha.findViewById(R.id.txtxPlacaVal);
        TextView txtRenavam = (TextView) linha.findViewById(R.id.txtxRenavamVal);
        TextView txtMarca = (TextView) linha.findViewById(R.id.txtxMarcaVal);
        TextView txtAnoFabricacao = (TextView) linha.findViewById(R.id.txtxAnoFabricacaoVal);
        TextView txtPropriedade = (TextView) linha.findViewById(R.id.txtxPropriedadeVal);

        txtPlaca.setText(veiculo.placa);
        txtRenavam.setText(veiculo.renavam);
        txtMarca.setText(veiculo.marca);
        txtAnoFabricacao.setText(veiculo.anoFabricacao);
        txtPropriedade.setText(veiculo.propriedade);
        return linha;
    }
}
