package org.techtown.howhair;

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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.designer:
                Toast.makeText(getApplicationContext(), "디자이너", Toast.LENGTH_SHORT).show();
                return true;


            case R.id.question:
                Toast.makeText(getApplicationContext(), "고민", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.review:
                Toast.makeText(getApplicationContext(), "후기", Toast.LENGTH_SHORT).show();
                return true;
        }
        return false;
    }
}
