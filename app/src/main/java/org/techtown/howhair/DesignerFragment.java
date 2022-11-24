package org.techtown.howhair;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;


public class DesignerFragment extends Fragment {
    SQLiteDatabase database;
    DatabaseHelper helper;

    HairViewAdapter adapter;
    ArrayList<HairView> reviewList;
    RecyclerView recyclerView;

    @Override
    public void onAttach(@NonNull Context context) {//생명주기에서 프래그먼트가 액티비티에 추가될 때 호출
        super.onAttach(context);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_designer, container, false);
        helper = new DatabaseHelper(this);
        database = helper.getWritableDatabase();
        findTable();
        recyclerView = (rootView).findViewById(R.id.recylerView_designer);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity()
                , LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new HairViewAdapter();
        reviewList = executeQuery();
        recyclerView.setAdapter(adapter);

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

    private ArrayList<HairView> executeQuery() {
        ArrayList<HairView> u = new ArrayList<HairView>();
        Cursor cursor =database.rawQuery("select type, pic, text, date from Hairs where type ='Designer'",null);
        int recordCount = cursor.getCount();//레코드 개수
        if(recordCount!=0){
            for (int i = 0; i<recordCount; i++){
                cursor.moveToNext();
                String type = cursor.getString(0);
                byte[] pic = cursor.getBlob(1);
                Bitmap image = stringToBitmap(pic);
                String text = cursor.getString(2);
                String date = cursor.getString(3);
                HairView h = new HairView(type, text,image);
                adapter.addItem(h);
            }
        }

        cursor.close();
        return u;
    }

    private Bitmap stringToBitmap(byte[] strBitmap){
        ByteArrayInputStream stream = new ByteArrayInputStream(strBitmap);
        Bitmap bitmap = BitmapFactory.decodeStream(stream);
        return bitmap;
    }

}