package com.example.wind.smalldou.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.wind.smalldou.Constants;
import com.example.wind.smalldou.R;
import com.example.wind.smalldou.ui.fragment.TabsFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    @Bind(R.id.drawer_layout)
    DrawerLayout drawer;
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    private long mBackTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setUpDrawer();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);
        initFragment();
    }

    private void initFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.content_main, TabsFragment.newInstance(Constants.TYPE_BILLBOARD),TabsFragment.TAG).commit();
        toolbar.setTitle(getResources().getString(R.string.first_toolbar_name));
    }



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (!drawer.isDrawerOpen(GravityCompat.START)) {
                if ((System.currentTimeMillis() - mBackTime) > 2000) {
                    mBackTime = System.currentTimeMillis();
                    Snackbar.make(drawer,R.string.back_text,Snackbar.LENGTH_SHORT).show();
                } else {
                    finish();
                }
            } else {
                drawer.closeDrawers();
            }
        }
        return true;
    }



    /**
     * 初始化Drawer
     */
    private void setUpDrawer() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public void onBackPressed() {
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        //设置toolbar标题
        String title = (String) item.getTitle();
        toolbar.setTitle(title);
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_movie_hot) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.content_main, TabsFragment.newInstance(Constants.TYPE_BILLBOARD),TabsFragment.TAG).commit();
        } else if (id == R.id.nav_movie) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.content_main, TabsFragment.newInstance(Constants.TYPE_MOVIE),TabsFragment.TAG).commit();


        } else if (id == R.id.nav_setting) {

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
