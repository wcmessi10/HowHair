package org.techtown.howhair;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends toolbarClass implements BoardDatabase{

    ActionBar abar;//액션바 생성
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    FloatingActionButton fab;
    public static final int REQUEST_CODE_UPLOAD = 101;//업로드창
    private static final int REQUEST_DESIGNER_PAGE=201;
    private static final int REQUEST_QUESTION_PAGE=202;
    private static final int REQUEST_REVIEW_PAGE=203;
    DesignerFragment designerFragment;
    ReviewFragment reviewFragment;
    QuestionFragment questionFragment;
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        abar = getSupportActionBar();
        abar.setDisplayShowTitleEnabled(false);



        drawerLayout = findViewById(R.id.draw_main);
        Button button = findViewById(R.id.menu_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
        navigationView = findViewById(R.id.nav_menu);
        navigationView.setNavigationItemSelectedListener(this);
        fab = findViewById(R.id.upload_button1);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), UploadActivity.class);
                startActivityForResult(intent,REQUEST_CODE_UPLOAD);
            }
        });

        //프레그먼트
        designerFragment = new DesignerFragment();
        questionFragment = new QuestionFragment();
        reviewFragment = new ReviewFragment();

        Intent intent = getIntent();
        int i = intent.getIntExtra("page",2);
        fragmentChanged(i);

        //안드로이드는 임베디드 데이터베이스로 개발된 경량급 관계형 데이터베이스 SQLite를 가짐
        findDatabase();
        findTable();
    }


    //DB 생성


    @Override
    public void findDatabase() {
        database = openOrCreateDatabase("게시글", MODE_PRIVATE, null); //DB가 존재하면 오픈. 존재하지않은면 생성
    }

    @Override
    public void findTable() {

        String query =
                "create table if not exists board " +
                        "(type text not null, pic text, text text,date Date);";
        try{
            database.execSQL(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void executeQuery(TextView textView) {
        Cursor cursor =database.rawQuery("select type, pic, text, date from board",null);
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

    @Override
    public void insertData(String type, String pic, String text) {
        database.beginTransaction();
        String query =
                "insert into board (type, pic, text, date) values " +
                        "("+type +","+ pic + ","+text +",sysdate);";
        try{
            database.execSQL(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public void fragmentChanged(int position) {
        super.fragmentChanged(position);
        switch (position){
            case 1 : getSupportFragmentManager().beginTransaction().replace(R.id.container,designerFragment).commit();
                break;
            case 2 : getSupportFragmentManager().beginTransaction().replace(R.id.container,questionFragment).commit();
                break;
            case 3 : getSupportFragmentManager().beginTransaction().replace(R.id.container,reviewFragment).commit();
                break;
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.designer:
                fragmentChanged(1);
                drawerLayout.closeDrawer(Gravity.LEFT);
                break;


            case R.id.question:
                fragmentChanged(2);
                drawerLayout.closeDrawer(Gravity.LEFT);
                break;

            case R.id.review:
                fragmentChanged(3);
                drawerLayout.closeDrawer(Gravity.LEFT);
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("안내");
        builder.setMessage("종료하겠습니까?");
        builder.setIcon(android.R.drawable.ic_dialog_alert);

        builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finishAffinity();
            }
        });

        builder.setNeutralButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}