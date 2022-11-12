package org.techtown.howhair;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;

public class DesignerUploadActivity1 extends AppCompatActivity {
    ImageView imageView;
    ImageView imageView2;
    private static final int REQUEST_TAKE_ALBUM=102;//앨범업로드
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_designer_upload1);

        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();
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
