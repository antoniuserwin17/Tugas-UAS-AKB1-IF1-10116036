package com.akb.erwin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
/*
 * Tanggal pengerjaan: 5 Agustus 2019
 * NIM : 10116036
 * Nama : Antonius Erwin
 * Kelas : AKB-1*/

public class RegisterActivity extends AppCompatActivity {

    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_register);
    b2 = (Button)findViewById(R.id.btn_login);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(pindah);
            }
        });
    }
}
