package it.gmariotti.android.example.stethotest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by g.mariotti on 16/07/2015.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "stethotest.db";

    private static final int DATABASE_VERSION = 1;

    private static final String TBL_USR = "user";
    private static final String TBL_USR_CLMN_ID = "id";
    private static final String TBL_USR_CLMN_NAME = "name";
    private static final String TBL_USR_CLMN_SURNAME = "surname";
    private static final String TBL_USR_CLMN_CODE = "code";

    private static final String[] TBL_USR_FIELDS = {
            TBL_USR_CLMN_ID,
            TBL_USR_CLMN_NAME,
            TBL_USR_CLMN_SURNAME,
            TBL_USR_CLMN_CODE
    };

    private static final String CREATE_DATABASE = "CREATE TABLE " + TBL_USR + " ( " +
            TBL_USR_CLMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            TBL_USR_CLMN_NAME + " TEXT NOT NULL, " +
            TBL_USR_CLMN_SURNAME + " TEXT NOT NULL, " +
            TBL_USR_CLMN_CODE + " INTEGER NOT NULL DEFAULT 0 " +
            ")";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_DATABASE);
        db.execSQL("INSERT INTO " + TBL_USR + " " + "("+ TBL_USR_CLMN_NAME  +" , " + TBL_USR_CLMN_SURNAME +" , " + TBL_USR_CLMN_CODE  +")" + "  VALUES('PAOLO1','ROSSI1', 233432 )");
        db.execSQL("INSERT INTO " + TBL_USR + " " + "("+ TBL_USR_CLMN_NAME  +" , " + TBL_USR_CLMN_SURNAME +" , " + TBL_USR_CLMN_CODE  +")" + "  VALUES('PAOLO2','ROSSI2', 103213 )");
        db.execSQL("INSERT INTO " + TBL_USR + " " + "("+ TBL_USR_CLMN_NAME  +" , " + TBL_USR_CLMN_SURNAME +" , " + TBL_USR_CLMN_CODE  +")" + "  VALUES('PAOLO3','ROSSI3', 5454331 )");
        db.execSQL("INSERT INTO " + TBL_USR + " " + "("+ TBL_USR_CLMN_NAME  +" , " + TBL_USR_CLMN_SURNAME +" , " + TBL_USR_CLMN_CODE  +")" + "  VALUES('PAOLO4','ROSSI4', 5454444 )");
        db.execSQL("INSERT INTO " + TBL_USR + " " + "("+ TBL_USR_CLMN_NAME  +" , " + TBL_USR_CLMN_SURNAME +" , " + TBL_USR_CLMN_CODE  +")" + "  VALUES('PAOLO5','ROSSI5', 1231232 )");
        db.execSQL("INSERT INTO " + TBL_USR + " " + "("+ TBL_USR_CLMN_NAME  +" , " + TBL_USR_CLMN_SURNAME +" , " + TBL_USR_CLMN_CODE  +")" + "  VALUES('PAOLO6','ROSSI6', 4443343 )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private SQLiteDatabase getDatabase() {
        return getWritableDatabase();
    }

}
