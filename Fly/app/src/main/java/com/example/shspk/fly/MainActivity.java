package com.example.shspk.fly;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        mNavigationView =(NavigationView)findViewById(R.id.nav_view);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null)
        {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_list_white_36dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        setupDrawerContent(mNavigationView);
        /*mNavigationView.setCheckedItem(R.id.nav_weather);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
                                                  {
                                                      @Override
                                                      public boolean onNavigationItemSelected(MenuItem item)
                                                      {
                                                          mDrawerLayout.closeDrawers();

                                                          return true;
                                                      }
                                                  }

        );*/
    }

    private void setupDrawerContent(NavigationView navigationView)
    {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener()
                {
                    //private MenuItem mPreMenuItem;
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem)
                    {

                        int id=menuItem.getItemId();

                        if(id==R.id.nav_weather)
                        {

                        }
                        else if(id==R.id.nav_map)
                        {
                            Intent intent=new Intent(MainActivity.this,MapActivity.class);
                            startActivity(intent);
                        }
                        /*if(mPreMenuItem!=null)
                            mPreMenuItem.setCheckable(false);
                        menuItem.setCheckable(true);

                        mPreMenuItem=menuItem;
                       */
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                }
        );

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId()==android.R.id.home)
        {
            mDrawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }




}


