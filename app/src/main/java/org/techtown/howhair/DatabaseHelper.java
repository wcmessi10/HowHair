package org.techtown.howhair;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static String NAME = "Hairs.db";
    public static int VERSION = 1;

    public DatabaseHelper(Context context){
        super(context,NAME, null, VERSION);
    }

    public DatabaseHelper(QuestionFragment questionFragment) {
        super(questionFragment.getContext(), NAME,null,VERSION);
    }

    public DatabaseHelper(DesignerFragment designerFragment) {
        super(designerFragment.getContext(), NAME, null, VERSION);
    }

    public DatabaseHelper(ReviewFragment reviewFragment) {
        super(reviewFragment.getContext(), NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String query =
                "create table if not exists Hairs " +
                        "(type text not null, " +
                        "pic blob, " +
                        "text text," +
                        "date text);";
        sqLiteDatabase.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
