package com.sonderskov.androidtemplate.ui.main;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.sonderskov.androidtemplate.ui.BaseActivity;
import com.sonderskov.androidtemplate.R;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {
    private MainNavigation mNavigation = new MainNavigation() {

        @Override
        public void showFrontPage() {
            final Fragment fragment = FrontPageFragment.newInstance("Hello world!");
            pushFragment(fragment, true);
        }

        @Override
        public void showPlaceHolder(String text) {
            final Fragment fragment = PlaceHolderFragment.newInstance(text);
            pushFragment(fragment);
        }

        @Override
        public void showCameraPage() {
            showPlaceHolder("Camera Page");
        }

        @Override
        public void showGalleryPage() {
            showPlaceHolder("Show Gallery Page");
        }

        @Override
        public void showSlideShowPage() {
            showPlaceHolder("Slide Show Page");
        }

        @Override
        public void showDevicePage() {
            showPlaceHolder("Device Page");
        }

        @Override
        public void showShare() {
            Toast.makeText(MainActivity.this, "Sharing is caring", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void showSend() {
            Toast.makeText(MainActivity.this, "Send More Snacks", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void showSettings() {
            Toast.makeText(MainActivity.this, "Settings are fun!", Toast.LENGTH_SHORT).show();
        }

    };

    public MainNavigation getNavigation() {
        return mNavigation;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mNavigation.showFrontPage();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            mNavigation.showSettings();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            mNavigation.showCameraPage();
        } else if (id == R.id.nav_gallery) {
            mNavigation.showGalleryPage();
        } else if (id == R.id.nav_slideshow) {
            mNavigation.showSlideShowPage();
        } else if (id == R.id.nav_device) {
            mNavigation.showDevicePage();
        } else if (id == R.id.nav_share) {
            mNavigation.showShare();
        } else if (id == R.id.nav_send) {
            mNavigation.showSend();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
