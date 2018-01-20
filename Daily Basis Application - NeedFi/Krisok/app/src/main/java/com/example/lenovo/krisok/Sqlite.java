package com.example.lenovo.krisok;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DIU on 2/21/2017.
 */


public class Sqlite extends SQLiteOpenHelper {

   private static final String Database_name="mydatabase.db";
    private static final String Table_name="mytable";
    private static final String Coloumn1="Id";
    private static final String Coloumn2="Firstname";
    private static final String Coloumn3="Lastname";
    private static final String Coloumn4="Email";







    public Sqlite(Context context) {
        super(context,Database_name,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
     String query;
     query = "Create table "+Table_name+"(" +Coloumn1+ " INTEGER PRIMARY KEY, " +Coloumn2+ " TEXT, " +Coloumn3+ " TEXT, " +Coloumn4+ " TEXT "+")";
     db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
     db.execSQL(" DROP TABLE IF EXISTS " +Table_name);
     onCreate(db);

    }

 public boolean addtotable(String id, String fname, String lname, String email)
 {
SQLiteDatabase sqLiteDatabase = getWritableDatabase();
  ContentValues contentValues = new ContentValues();
  contentValues.put(Coloumn1,id);
  contentValues.put(Coloumn2,fname);
  contentValues.put(Coloumn3,lname);
  contentValues.put(Coloumn4,email);

  Long checker = sqLiteDatabase .insert(Table_name,null,contentValues);

     if(checker == -1)
     {

         return false;
     }
     else

     {

         return true;
     }

 }
 public Cursor display()
 {
     SQLiteDatabase sqLiteDatabase =getReadableDatabase();
     Cursor res;
     res=sqLiteDatabase.rawQuery("SELECT * FROM "+Table_name,null);
     return res;
 }

public int deletedata(String id)
{
    SQLiteDatabase sqLiteDatabase=getWritableDatabase();
    return sqLiteDatabase.delete(Table_name,"ID=?",new String[]{id});


}
}