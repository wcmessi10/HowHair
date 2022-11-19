package org.techtown.howhair;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.sql.Date;

public class toolbarClass extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    SQLiteDatabase database;
    DesignerFragment designerFragment;
    ReviewFragment reviewFragment;
    QuestionFragment questionFragment;

    private static final int REQUEST_DESIGNER_PAGE=201;
    private static final int REQUEST_QUESTION_PAGE=202;
    private static final int REQUEST_REVIEW_PAGE=203;
    /*ActionBar abar;//액션바 생성
    DrawerLayout drawerLayout;

    Toolbar toolbar;
    FloatingActionButton fab;
    public static final int REQUEST_CODE_UPLOAD = 101;//업로드창
    public void setToolbar(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        abar = getSupportActionBar();
        abar.setDisplayShowTitleEnabled(false);



        drawerLayout = findViewById(R.id.draw_menu);
        Button button = findViewById(R.id.menu_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });


    }

    }*/
    public void fragmentChanged(int position){

    }

    /*public void findDatabase(){
        database = openOrCreateDatabase("게시글", MODE_PRIVATE, null); //DB가 존재하면 오픈. 존재하지않은면 생성
    }

    public void findTable(){//테이블이 있으면 오픈, 존재하지 않으면 생성
        String query =
                "create table if not exists board " +
                        "(type text not null, pic text, text text,date Date);";
        try{
            database.execSQL(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void insertData(String type,String pic, String text){
        database.beginTransaction();
        String query =
                "insert into board (type, pic, text, date) values " +
                        "("+type +","+ pic + ","+text +",sysdate,);";
        try{
            database.execSQL(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void executeQuery(){
        Cursor cursor =database.rawQuery("select type, pic, text, date from board",null);
        int recordCount = cursor.getCount();//레코드 개수
        textView.append("레코드 개수 : "+recordCount);
        for (int i = 0; i<recordCount; i++){
            cursor.moveToNext();
            String type = cursor.getString(0);
            String pic = cursor.getString(1);
            String text = cursor.getString(2);
            String date = cursor.getString(3);
            textView.append("레코드 : "+type+" "+pic+" "+text+" "+date);
        }
        cursor.close();
    }*/

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}
