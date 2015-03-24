package com.evo.citicargasmobile.DAO;

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

    private CitiCargasSqlHelper dbHelper;
    private SQLiteDatabase database;

    public TransportadorRepository(Context context){
        dbHelper = new CitiCargasSqlHelper(context);
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

    public List<Transportador> consultarTransportadores(String nome, String rntrc, String cpfCnpj) {
        String filterQuery = "SELECT  * FROM " + dbHelper.TABLE_NAME +" WHERE 1=1 ";

        if(nome != null && nome.trim() != ""){
            filterQuery += " and nome LIKE '%"+nome+"%'";
        }

        if(rntrc != null && rntrc.trim() != ""){
            filterQuery += " and rntrc= '"+rntrc+"'";
        }

        if(cpfCnpj != null && cpfCnpj.trim() != ""){
            filterQuery += " and cpfCnpj= '"+cpfCnpj+"'";
        }

        filterQuery += " ORDER BY nome";

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(filterQuery, null);
        List<Transportador> result = new ArrayList<Transportador>();

        while(cursor.moveToNext()){
            result.add(new Transportador(
                    cursor.getString(cursor.getColumnIndex("cpfCnpj")),
                    cursor.getString(cursor.getColumnIndex("rntrc")),
                    cursor.getString(cursor.getColumnIndex("nome")),
                    cursor.getLong(cursor.getColumnIndex("_id"))
            ));
        }

        cursor.close();
        dbHelper.close();

        // return count
        return result;
    }
}
