package com.akb.erwin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/*
 * Tanggal pengerjaan: 5 Agustus 2019
 * NIM : 10116036
 * Nama : Antonius Erwin
 * Kelas : AKB-1*/

public class LoginActivity extends AppCompatActivity {

    //Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void onClick(View v){
        Intent intent = null;
        switch(v.getId()){
            case R.id.btn_signup:
                intent = new Intent(this,RegisterActivity.class);
                break;
        }
        if (null!=intent) startActivity(intent);
    }
}
