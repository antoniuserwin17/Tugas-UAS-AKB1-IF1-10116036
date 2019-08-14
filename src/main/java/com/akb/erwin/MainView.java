package com.akb.erwin;

import java.util.List;

/*
 * Tanggal pengerjaan: 5 Agustus 2019
 * NIM : 10116036
 * Nama : Antonius Erwin
 * Kelas : AKB-1*/

public interface MainView {

    void onLoad(List<TemanModel> teman);

    void onSave();

    void onDelete();

    void onUpdate();
}
