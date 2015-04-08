package com.evo.citicargasmobile.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.evo.citicargasmobile.Entity.Transportador;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel on 23/03/2015.
 */
public class TransportadorRepository {

    private TransportadorSqlHelper dbHelper;
    private SQLiteDatabase database;

    public TransportadorRepository(Context context){
        dbHelper = new TransportadorSqlHelper(context);
        database = dbHelper.getWritableDatabase();
    }

    public int getTransportadoresCount() {
        String countQuery = "SELECT  * FROM " + dbHelper.TABLE_NAME;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

    public long inserir(Transportador transportador){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("nome", transportador.nome);
        cv.put("rntrc", transportador.rntrc);
        cv.put("cpfCnpj", transportador.cpfCnpj);
        cv.put("tipoTransportador",transportador.tipoTransportador);
        cv.put("dataValidade",transportador.dataValidade);
        cv.put("dataRecadastramento",transportador.dataRecadastramento);
        cv.put("dataEmissao",transportador.dataEmissao);
        cv.put("situacaoRntrc",transportador.situacaoRntrc);
        cv.put("uf",transportador.uf);
        cv.put("contatoCelular",transportador.contatoCelular);
        cv.put("contatoEmail",transportador.contatoEmail);
        cv.put("contatoFixo",transportador.contatoFixo);
        cv.put("contatoFax",transportador.contatoFax);
        cv.put("enderecoComercial",transportador.enderecoComercial);
        cv.put("enderecoCorrespondencia",transportador.enderecoCorrespondencia);

        long id = db.insert(dbHelper.TABLE_NAME,null, cv);
        return id;
    }

    public List<Transportador> consultarTransportadores(String nome, String rntrc, String cpfCnpj) {
        String filterQuery = "SELECT  _id, nome, rntrc, cpfCnpj, tipoTransportador, uf, situacaoRntrc FROM " + dbHelper.TABLE_NAME +" WHERE 1=1 ";

        if(nome != null && !nome.isEmpty()){
            filterQuery += " and nome LIKE '%"+nome+"%'";
        }

        if(rntrc != null && !rntrc.isEmpty()){
            filterQuery += " and rntrc= '"+rntrc+"'";
        }

        if(cpfCnpj != null && !cpfCnpj.isEmpty()){
            filterQuery += " and cpfCnpj= '"+cpfCnpj+"'";
        }

        filterQuery += " ORDER BY nome";

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(filterQuery, null);
        List<Transportador> result = new ArrayList<Transportador>();

        while(cursor.moveToNext()){
            result.add(new Transportador(
                    cursor.getLong(cursor.getColumnIndex("_id")),
                    cursor.getString(cursor.getColumnIndex("nome")),
                    cursor.getString(cursor.getColumnIndex("rntrc")),
                    cursor.getString(cursor.getColumnIndex("cpfCnpj")),
                    cursor.getString(cursor.getColumnIndex("tipoTransportador")),
                    cursor.getString(cursor.getColumnIndex("uf")),
                    cursor.getString(cursor.getColumnIndex("situacaoRntrc"))
            ));
        }

        cursor.close();
        dbHelper.close();

        // return count
        return result;
    }

    public Transportador detalharTransportador(String cpfCnpj){
        String filterQuery = "SELECT  * FROM " + dbHelper.TABLE_NAME +" WHERE cpfCnpj='"+cpfCnpj+"'";
        Transportador result = new Transportador();

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(filterQuery, null);

        while(cursor.moveToNext()){
            result.id = cursor.getLong(cursor.getColumnIndex("_id"));
            result.nome = cursor.getString(cursor.getColumnIndex("nome"));
            result.rntrc = cursor.getString(cursor.getColumnIndex("rntrc"));
            result.cpfCnpj = cursor.getString(cursor.getColumnIndex("cpfCnpj"));
            result.tipoTransportador = cursor.getString(cursor.getColumnIndex("tipoTransportador"));
            result.dataValidade = cursor.getString(cursor.getColumnIndex("dataValidade"));
            result.dataRecadastramento = cursor.getString(cursor.getColumnIndex("dataRecadastramento"));
            result.dataEmissao = cursor.getString(cursor.getColumnIndex("dataEmissao"));
            result.situacaoRntrc = cursor.getString(cursor.getColumnIndex("situacaoRntrc"));
            result.uf = cursor.getString(cursor.getColumnIndex("uf"));
            result.contatoCelular = cursor.getString(cursor.getColumnIndex("contatoCelular"));
            result.contatoEmail = cursor.getString(cursor.getColumnIndex("contatoEmail"));
            result.contatoFixo = cursor.getString(cursor.getColumnIndex("contatoFixo"));
            result.contatoFax = cursor.getString(cursor.getColumnIndex("contatoFax"));
            result.enderecoComercial = cursor.getString(cursor.getColumnIndex("enderecoComercial"));
            result.enderecoCorrespondencia = cursor.getString(cursor.getColumnIndex("enderecoCorrespondencia"));
        }

        cursor.close();
        dbHelper.close();

        return result;
    }
}
