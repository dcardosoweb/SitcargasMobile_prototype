package com.evo.citicargasmobile.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Daniel on 05/04/2015.
 */
public class VeiculoSqlHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "dbCitiCargas";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "Veiculo";

    private static final String DATABASE_CREATE =
            "create table "+TABLE_NAME+" ( _id integer primary key, _idTransportador integer, placa text not null, renavam text not null," +
                    " marca text not null, anoFabricacao text, propriedade text," +
                    "FOREIGN KEY(_idTransportador) REFERENCES Transportador(_id));";

    public VeiculoSqlHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(TransportadorSqlHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS Veiculo");
        onCreate(db);
    }
}