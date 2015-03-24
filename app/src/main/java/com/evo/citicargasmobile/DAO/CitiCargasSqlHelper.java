package com.evo.citicargasmobile.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Daniel on 23/03/2015.
 */
public class CitiCargasSqlHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "dbCitiCargas";
    private static final int DATABASE_VERSION = 1;


    public static final String TABLE_NAME = "Transportador";

    private static final String DATABASE_CREATE =
            "create table "+TABLE_NAME+" ( _id integer primary key,nome text not null, rntrc text not null, cpfCnpj text not null);";


    public CitiCargasSqlHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(CitiCargasSqlHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS Transportador");
        onCreate(db);
    }
}
