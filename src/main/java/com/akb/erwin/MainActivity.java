package com.akb.erwin;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;


/*
* Tanggal pengerjaan: 5 Agustus 2019
* NIM : 10116036
* Nama : Antonius Erwin
* Kelas : AKB-1*/

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    DrawerLayout drawer;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //ini tampilan awal
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction().replace(R.id.frame_container, new ProfileActivity()).commit();
            navigationView.setCheckedItem(R.id.nav_profile);
        }
        //tampilan awal
        /*if (savedInstanceState == null) {
            fragment = new ProfileActivity();
            callFragment(fragment);
        }*/

        //displaySelectedScreen(R.id.nav_profile);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    /* Tanggal Pengerjaan : 15-21 Mei 2019
     * NIM: 10116036
     * NAMA: Antonius Erwin
     * KELAS: IF1
     */
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.


        switch (item.getItemId()){
            case R.id.nav_profile:
                getFragmentManager().beginTransaction().replace(R.id.frame_container, new ProfileActivity()).commit();
                break;
            case R.id.nav_kontak:
                getFragmentManager().beginTransaction().replace(R.id.frame_container, new KontakActivity()).commit();
                break;
            case R.id.nav_daftar:
                getFragmentManager().beginTransaction().replace(R.id.frame_container, new TemanActivity()).commit();
                break;
        }

        //displaySelectedScreen(item.getItemId());
        /*int id = item.getItemId();

        if (id == R.id.nav_profile) {
            fragment = new ProfileActivity();
            callFragment(fragment);
        } else if (id == R.id.nav_kontak) {
            fragment = new KontakActivity();
            callFragment(fragment);
        } else if (id == R.id.nav_daftar) {
            fragment = new TemanActivity();
            callFragment(fragment);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);*/
        //drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Do you want to Sign Out?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user pressed "yes", then he is allowed to exit from application
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user select "No", just cancel this dialog and continue with app
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();


        /*DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }*/
    }

    //ini teh menu di pojok kanan atas yang uda diapus tadi
    /*@Override
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
    }*/



    /*private void displaySelectedScreen(int itemId) {


        //creating fragment object
        Fragment fragment = null;

        //initializing the fragment object which is selected
        switch (itemId) {
            case R.id.nav_profile:
                fragment = new Fragment();
                break;
            case R.id.nav_kontak:
                fragment = new Fragment();
                break;
            case R.id.nav_daftar:
                //tadi fragment = new TemanActivity();
                fragment = new Fragment();
                break;
        }

        //replacing the fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frame_container, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }*/

    /*private void callFragment(Fragment fragment) {
        fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frame_container, fragment)
                .commit();
    }*/
}
