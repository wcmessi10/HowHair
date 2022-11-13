package org.techtown.howhair;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class DesignerUploadActivity2 extends toolbarClass{
    ActionBar abar;//액션바 생성
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    Bitmap imgBitmap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_designer_upload2);

        toolbar = findViewById(R.id.toolbar_designer_upload2);
        setSupportActionBar(toolbar);

        abar = getSupportActionBar();
        abar.setDisplayShowTitleEnabled(false);

        drawerLayout = findViewById(R.id.draw_designer_upload2);
        Button button = findViewById(R.id.menu_button_designer_upload2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
        navigationView = findViewById(R.id.nav_menu_designer_upload2);
        navigationView.setNavigationItemSelectedListener(this);


        Button homeButton = findViewById(R.id.home_button_designer_upload2);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//이전 액티비티 전부 종료
                startActivity(intent);
            }
        });

        Button upload_before = findViewById(R.id.designer_upload2_before);
        upload_before.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),DesignerUploadActivity1.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//위에 액티비티 전부 종료
                startActivity(intent);
            }
        });
    }
}
