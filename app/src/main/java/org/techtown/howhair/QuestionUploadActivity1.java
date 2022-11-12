package org.techtown.howhair;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.io.InputStream;

public class QuestionUploadActivity1 extends toolbarClass {
    ActionBar abar;//액션바 생성
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    ImageView imageView;
    ImageView imageView2;
    private static final int REQUEST_TAKE_ALBUM=102;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_upload1);

        toolbar = findViewById(R.id.toolbar_question_upload1);
        setSupportActionBar(toolbar);

        abar = getSupportActionBar();
        abar.setDisplayShowTitleEnabled(false);

        drawerLayout = findViewById(R.id.draw_question_upload1);
        Button button = findViewById(R.id.menu_button_question_upload1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
        navigationView = findViewById(R.id.nav_menu_question_upload1);
        navigationView.setNavigationItemSelectedListener(this);


        Button homeButton = findViewById(R.id.home_button_question_upload1);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//이전 액티비티 전부 종료
                startActivity(intent);
            }
        });

        imageView = findViewById(R.id.imageView4);
        imageView2 = findViewById(R.id.imageView5);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();
            }
        });

        Button upload_before = findViewById(R.id.question_upload1_before);
        upload_before.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),UploadActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//위에 액티비티 전부 종료
                startActivity(intent);
            }
        });
    }
    public void openGallery(){//인텐트 통해서 이미지 가져오기
        Intent intent = new Intent();
        intent.setType("image/*");//MIME타입이 image로 시작하는 데이터를 가져오라는 의미가 됩니다.
        intent.setAction(Intent.ACTION_GET_CONTENT);//앨범을 호출하는 인텐트 액션 ACTION_GET_CONTENT
        startActivityForResult(intent, REQUEST_TAKE_ALBUM);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //onActivityResult로 선택한 사진 결과값을 전달받을 수 있다.
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 102){
            if (resultCode == RESULT_OK){
                Uri fileUri = data.getData();
                ContentResolver resolver = getContentResolver();
                //사진 앱의 ContentProvider에 접근할 수 있도록 ContentResolver를 통해 접근
                //다른 앱의 데이터베이스에 접근할수 있고, CRUD 메소드들을 제공한다.
                try {
                    InputStream inStream = resolver.openInputStream(fileUri);
                    Bitmap imgBitmap = BitmapFactory.decodeStream(inStream);
                    imageView2.setImageBitmap(imgBitmap);

                    inStream.close();
                }catch (Exception e ){
                    e.printStackTrace();
                }

            }
        }
    }
}
