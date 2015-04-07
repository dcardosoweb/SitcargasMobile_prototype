package com.evo.citicargasmobile.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.evo.citicargasmobile.Entity.Veiculo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel on 06/04/2015.
 */
public class VeiculoRepository {

    private TransportadorSqlHelper dbHelper;
    private SQLiteDatabase database;

    public VeiculoRepository(Context context){
        dbHelper = new TransportadorSqlHelper(context);
        database = dbHelper.getWritableDatabase();
    }

    public long inserir(Veiculo veiculo){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("_idTransportador", veiculo.idTrasportador);
        cv.put("placa", veiculo.placa);
        cv.put("renavam", veiculo.renavam);
        cv.put("marca",veiculo.marca);
        cv.put("anoFabricacao",veiculo.anoFabricacao);
        cv.put("propriedade",veiculo.propriedade);

        long id = db.insert(dbHelper.TABLE_NAME_VEICULO,null, cv);
        return id;
    }

    public List<Veiculo> consultarVeiculosTransportador(long idTransportador) {
        String filterQuery = "SELECT  * FROM " + dbHelper.TABLE_NAME_VEICULO +" WHERE _idTransportador= "+idTransportador;
        filterQuery += " ORDER BY placa";

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(filterQuery, null);
        List<Veiculo> result = new ArrayList<Veiculo>();

        while(cursor.moveToNext()){
            result.add(new Veiculo(
                    cursor.getLong(cursor.getColumnIndex("_id")),
                    cursor.getLong(cursor.getColumnIndex("_idTransportador")),
                    cursor.getString(cursor.getColumnIndex("placa")),
                    cursor.getString(cursor.getColumnIndex("renavam")),
                    cursor.getString(cursor.getColumnIndex("marca")),
                    cursor.getString(cursor.getColumnIndex("anoFabricacao")),
                    cursor.getString(cursor.getColumnIndex("propriedade"))
            ));
        }

        cursor.close();
        dbHelper.close();

        // return count
        return result;
    }
}
