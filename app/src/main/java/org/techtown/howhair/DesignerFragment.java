package org.techtown.howhair;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DesignerFragment extends Fragment {
    SQLiteDatabase database;
    DatabaseHelper helper;
    TextView textView;

    @Override
    public void onAttach(@NonNull Context context) {//생명주기에서 프래그먼트가 액티비티에 추가될 때 호출
        super.onAttach(context);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_designer, container, false);

        String type ="Designer";
        textView = (rootView).findViewById(R.id.designertest);

        helper = new DatabaseHelper(this);
        database = helper.getWritableDatabase();
        findTable();
        executeQuery(textView, type);
        return rootView;
    }
    private void findTable() {

        String query =
                "create table if not exists Hairs " +
                        "(type text not null, pic text, text text,date text);";
        try{
            database.execSQL(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void executeQuery(TextView textView, String type1) {
        Cursor cursor =database.rawQuery("select type, pic, text, date from Hairs where type ='"+type1+"'",null);
        int recordCount = cursor.getCount();//레코드 개수
        textView.append("레코드 개수 : "+recordCount);
        if(recordCount!=0){
            for (int i = 0; i<recordCount; i++){
                cursor.moveToNext();
                String type = cursor.getString(0);
                String pic = cursor.getString(1);
                String text = cursor.getString(2);
                String date = cursor.getString(3);
                textView.append("레코드 : "+type+" "+pic+" "+text+" "+date);
            }
        }

        cursor.close();
    }

}