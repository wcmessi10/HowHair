package org.techtown.howhair;

import android.app.Activity;
import android.content.Intent;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class toolbarClass extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}
