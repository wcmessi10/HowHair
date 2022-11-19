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
    BoardDatabase boardDatabase;
    TextView textView;

    @Override
    public void onAttach(@NonNull Context context) {//생명주기에서 프래그먼트가 액티비티에 추가될 때 호출
        super.onAttach(context);
        boardDatabase = (BoardDatabase)context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_designer, container, false);

        textView = (rootView).findViewById(R.id.testtext);
        boardDatabase.findDatabase();
        boardDatabase.findTable();
        boardDatabase.executeQuery(textView);


        return rootView;
    }


}