package com.example.campusdiary;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbManager extends SQLiteOpenHelper
{

    private static final String dbname="College.db";

    public DbManager(Context context)
    {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String qry="create table tbl_UserData (user_id integer primary key autoincrement, Full_Name text, DOB numeric, Gender text)";
        db.execSQL(qry);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS tbl_UserData");
        onCreate(db);

    }

    public String addRecord (String p1,String p2,String p3)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put("Full_Name",p1);
        cv.put("DOB",p2);
        cv.put("Gender",p3);
        long res=db.insert("tbl_UserData",null,cv);

        if (res==-1)
            return "Failed";
        else
            return "Successfull";
    }
}
