package org.techtown.howhair;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class UploadActivity extends toolbarClass {
    ActionBar abar;//액션바 생성
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    FloatingActionButton fab;
    public static final int REQUEST_CODE_UPLOAD = 101;//업로드창
    public static final int REQUEST_CODE_DESIGNERUPLOAD1 = 103;
    public static final int REQUEST_CODE_QUESTIONUPLOAD1 = 104;
    public static final int REQUEST_CODE_REVIEWUPLOAD1 = 105;
    int buttonNumber;
    RadioGroup uploadType;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        toolbar = findViewById(R.id.toolbar_upload);
        setSupportActionBar(toolbar);

        abar = getSupportActionBar();
        abar.setDisplayShowTitleEnabled(false);

        drawerLayout = findViewById(R.id.draw_upload);
        Button button = findViewById(R.id.menu_button_upload);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
        fab = findViewById(R.id.upload_button2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), UploadActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivityForResult(intent,REQUEST_CODE_UPLOAD);
            }
        });

        navigationView = findViewById(R.id.nav_menu_upload);
        navigationView.setNavigationItemSelectedListener(this);


        Button homeButton = findViewById(R.id.home_button_upload);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//이전 액티비티 전부 종료
                startActivity(intent);
            }
        });

        uploadType = findViewById(R.id.uploadType);
        uploadType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.designerCheck) {                // 첫 번째 버튼이 선택 되었을 때
                    buttonNumber = 1;
                } else if (i == R.id.questionCheck) {      // 두 번째 버튼이 선택 되었을 때
                    buttonNumber = 2;
                } else {
                    buttonNumber = 3;
                }
            }
        });

        Button button2 = findViewById(R.id.button);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(buttonNumber == 1) {
                    Intent intent = new Intent(getApplicationContext(), DesignerUploadActivity1.class);
                    startActivity(intent);
                } else if(buttonNumber == 2) {
                    Intent intent = new Intent(getApplicationContext(), QuestionUploadActivity1.class);
                    startActivity(intent);
                }else if(buttonNumber == 3) {
                    Intent intent = new Intent(getApplicationContext(), ReviewUploadActivity1.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Choose the gender", Toast.LENGTH_LONG).show();
                }
                /*
                Intent intent = new Intent(getApplicationContext(),DesignerUploadActivity1.class);
                startActivityForResult(intent,REQUEST_CODE_DESIGNERUPLOAD1);*/
            }


        });
        Button upload_before = findViewById(R.id.upload_before);
        upload_before.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//위에 액티비티 전부 종료
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



}
