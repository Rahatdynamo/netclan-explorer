package com.example.netclanexplorer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    BottomNavigationView btn_nav;
    Toolbar toolbar;
    Button btn1, btn2, btn3, btn4;
    boolean isButtonClicked1 = false;
    boolean isButtonClicked2 = false;
    boolean isButtonClicked3 = false;
    boolean isButtonClicked4 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.nav_View);
        toolbar = findViewById(R.id.toolbar);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        setSupportActionBar(toolbar);
        btn_nav = findViewById(R.id.btm_nav);
        btn_nav.setSelectedItemId(R.id.nav_btn_explore);
        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        if (getSupportActionBar() != null) {

            toogle.getDrawerArrowDrawable().setColor(Color.WHITE);}

        btn_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.nav_btn_refine) {
                    Intent i = new Intent(getApplicationContext(), Refine_Activity.class);
                    item.setChecked(true);
                    startActivity(i);
                } else {
                    item.setChecked(true);

                }

                return false;
            }
        });


    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else if (btn_nav.getSelectedItemId() != R.id.nav_btn_explore) {
            btn_nav.setSelectedItemId(R.id.nav_btn_explore);
        } else {
            super.onBackPressed();
        }
    }

    public void OnButtonCLick(View view) {
        Button clickButton = (Button) view;
        if (clickButton == findViewById(R.id.btn1)) {
            isButtonClicked1 = !isButtonClicked1;
            changeText(clickButton, isButtonClicked1);
        }
        if (clickButton == findViewById(R.id.btn2)) {
            isButtonClicked2 = !isButtonClicked2;
            changeText(clickButton, isButtonClicked2);
        }
        if (clickButton == findViewById(R.id.btn3)) {
            isButtonClicked3 = !isButtonClicked3;
            changeText(clickButton, isButtonClicked3);
        }
        if (clickButton == findViewById(R.id.btn4)) {
            isButtonClicked4 = !isButtonClicked4;
            changeText(clickButton, isButtonClicked4);
        }
    }

    public void changeText(Button button, boolean isClicked) {
        if (isClicked) {
            button.setText("pending");
        } else {
            button.setText("+ INVITE");
        }

    }
}