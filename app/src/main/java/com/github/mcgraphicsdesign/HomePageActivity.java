package com.github.mcgraphicsdesign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class HomePageActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;


    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);
        assert actionBar != null;
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_id);

        navigationView.setNavigationItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.photography_id:
                    item.setChecked(true);
                    Intent navigateToPhotographyActivity = new Intent(this,PhotographyActivity.class);
                    startActivity(navigateToPhotographyActivity);
                    drawerLayout.closeDrawers();

                case R.id.graphics_id:
                    item.setChecked(true);
                    Intent navigateToGraphicsActivity = new Intent(this,GraphicsDesignActivity.class);
                    startActivity(navigateToGraphicsActivity);
                    drawerLayout.closeDrawers();

                case R.id.software_dev_id:
                    item.setChecked(true);
                    Intent navigateToSoftwareDevActivity = new Intent(this,SoftwareDevActivity.class);
                    startActivity(navigateToSoftwareDevActivity
                    );
                    drawerLayout.closeDrawers();
            }
            return false;
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}