package com.akb.erwin;

import java.util.ArrayList;
import java.util.List;

/*
 * Tanggal pengerjaan: 5 Agustus 2019
 * NIM : 10116036
 * Nama : Antonius Erwin
 * Kelas : AKB-1*/

public class TemanPresenterImpl implements TemanPresenter {

    private MainView mainView;

    private List<TemanModel> temans = new ArrayList<>();
    private int no = 4;

    public TemanPresenterImpl(MainView mainView){
        this.mainView = mainView;
        setData();
    }

    private void setData() {
        TemanModel teman = new TemanModel();
        teman.setId(1);
        teman.setNama("Christover Moa");
        teman.setNim("10116531");
        teman.setKelas("IF-12");
        teman.setTelepon("085966268954");
        teman.setEmail("Moasukasuka@gmail.com");
        teman.setSosmed("@topertepar");
        temans.add(teman);

        TemanModel teman1 = new TemanModel();
        teman1.setId(2);
        teman1.setNama("Budi Pekerti");
        teman1.setNim("10116542");
        teman1.setKelas("IF-10");
        teman1.setTelepon("085966268972");
        teman1.setEmail("pekertibudi@gmail.com");
        teman1.setSosmed("@budip");
        temans.add(teman1);

        TemanModel teman2 = new TemanModel();
        teman2.setId(3);
        teman2.setNama("Ajun Richard");
        teman2.setNim("10113132");
        teman2.setKelas("FA");
        teman2.setTelepon("081231657422");
        teman2.setEmail("richard@gmail.com");
        teman2.setSosmed("@ajunrichard");
        temans.add(teman2);
    }

     /*   FilmModel film3 = new FilmModel();
        film3.setId(4);
        film3.setNamaFilm("Five Feet Apart");
        film3.setGenreFilm("Drama, Romance");
        film3.setDurasiFilm("116 Minutes");
        film3.setRatingFilm("R 13+");
        films.add(film3);
    }*/


    @Override
    public void save(TemanModel teman) {
        no++;
        teman.setId(no);
        temans.add(teman);

        mainView.onSave();
    }

    @Override
    public void update(TemanModel teman) {
        for (TemanModel model : temans){
            if (model.getId() == teman.getId()){
                model.setNama(teman.getNama());
                model.setNim(teman.getNim());
                model.setKelas(teman.getKelas());
                model.setTelepon(teman.getTelepon());
                model.setEmail(teman.getEmail());
                model.setSosmed(teman.getSosmed());

                break;
            }
        }

        mainView.onUpdate();
    }

    @Override
    public void delete(TemanModel teman) {
        temans.remove(teman);

        mainView.onDelete();
    }

    @Override
    public void load() {
        mainView.onLoad(temans);
    }
}
