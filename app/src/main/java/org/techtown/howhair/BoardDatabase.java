package org.techtown.howhair;

import android.database.sqlite.SQLiteDatabase;
import android.widget.TextView;

public interface BoardDatabase {


    public void findDatabase();

    public void findTable();

    public void executeQuery(TextView textView);

    public void insertData(String type,String pic, String text);
}
