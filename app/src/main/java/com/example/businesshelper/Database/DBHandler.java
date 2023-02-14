package com.example.businesshelper.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DBHandler extends SQLiteOpenHelper {

    Context context;

    private static final int VERSION = 2;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd 'at' HH:mm:ss ");
    String currentDateandTime = sdf.format(new Date());

    private static final String DBNAME = "businessHelper";

    public DBHandler(@Nullable Context context) {
        super(context, DBNAME, null, VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
