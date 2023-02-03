package com.example.mini_project_mcwc;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME="history.db";
    public static final String TABLE_NAME="history_table";
    public static final String OPERATION = "operation"; //Col1
    public static final String RESULT = "result"; //Col2

    public DataBaseHelper(@Nullable Context context)
    {
        super(context, DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL("create table "+TABLE_NAME+" (OPERATION TEXT,RESULT TEXT) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
    public boolean insertData(String operation,String ans)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(OPERATION,operation);
        contentValues.put(RESULT,ans);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public Cursor getAllData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }
}
