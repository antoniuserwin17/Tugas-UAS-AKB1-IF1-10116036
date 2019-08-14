package com.akb.erwin;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;


/*
 * Tanggal pengerjaan: 5 Agustus 2019
 * NIM : 10116036
 * Nama : Antonius Erwin
 * Kelas : AKB-1*/

public class KontakActivity extends Fragment {

    public KontakActivity(){}
    RelativeLayout view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.activity_kontak, container, false);

        /*getActivity().setTitle("Kontak");

        return view;*/
    }
}