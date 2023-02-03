package com.example.mini_project_mcwc;

import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class View extends  AppCompatActivity
{
    DataBaseHelper mydb;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view);
        mydb = new DataBaseHelper(this);
        Cursor res = mydb.getAllData();
        if(res.getCount()==0)
        {
            showmessage("DATA TABLE","Nothing found");
            return;
        }
        StringBuffer buffer = new StringBuffer();
        buffer.append("Operation\t\t\t\t\t\t\t\t\t\t\tResult");
//            buffer.append("(1)\n\n");
        while(res.moveToNext())
        {
            buffer.append(res.getString(0)+"\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+res.getString(1)+"\n");
        }
        showmessage("Data",buffer.toString());
    }
    public void showmessage(String title, String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
