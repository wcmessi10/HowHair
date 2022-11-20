package org.techtown.howhair;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReviewUploadActivity2 extends toolbarClass{
    ActionBar abar;//액션바 생성
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    DatabaseHelper helper;
    SQLiteDatabase database;
    Bitmap imgBitmap;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_upload2);
        toolbar = findViewById(R.id.toolbar_review_upload2);
        setSupportActionBar(toolbar);

        abar = getSupportActionBar();
        abar.setDisplayShowTitleEnabled(false);

        drawerLayout = findViewById(R.id.draw_review_upload2);
        Button button = findViewById(R.id.menu_button_review_upload2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
        navigationView = findViewById(R.id.nav_menu_review_upload2);
        navigationView.setNavigationItemSelectedListener(this);


        Button homeButton = findViewById(R.id.home_button_review_upload2);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//이전 액티비티 전부 종료
                startActivity(intent);
            }
        });

        Button upload_before = findViewById(R.id.review_upload2_before);
        upload_before.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ReviewUploadActivity1.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//위에 액티비티 전부 종료
                startActivity(intent);
            }
        });

        String type = "Review";
        Intent intent = getIntent();
        String pic = intent.getStringExtra("page");
        EditText editText = findViewById(R.id.review_Text);
        Button upload_next = findViewById(R.id.review_upload2_next);
        helper = new DatabaseHelper(this);
        database = helper.getWritableDatabase();
        upload_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                Toast.makeText(getApplicationContext(),type+" "+pic+" "+text,Toast.LENGTH_SHORT).show();
                insertData(type,pic,text);
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        switch (item.getItemId()){

            case R.id.designer:
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("page",1);
                startActivity(intent);

                break;


            case R.id.question:
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("page",2);
                startActivity(intent);
                break;

            case R.id.review:
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("page",3);
                startActivity(intent);
                break;
        }
        return true;
    }

    private void insertData(String type, String pic, String text) {
        Date now= new Date(System.currentTimeMillis());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = format.format(now);
        String query =
                "insert into Hairs (type, pic, text, date) values " +
                        "('"+type+"','"+ pic + "','"+text +"','"+date+"');";
        database.execSQL(query);
    }
}
