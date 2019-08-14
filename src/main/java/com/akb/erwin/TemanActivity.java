package com.akb.erwin;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/*
 * Tanggal pengerjaan: 5 Agustus 2019
 * NIM : 10116036
 * Nama : Antonius Erwin
 * Kelas : AKB-1*/

public class TemanActivity extends Fragment implements MainView {

    public TemanActivity(){}
    RelativeLayout view;

    private RecyclerView recyclerView;
    private Button buttonAdd;
    private MainRecyclerAdapter adapter;
    private List<TemanModel> temanList = new ArrayList<>();
    private AppCompatDialog dialog;
    private TemanPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = (RelativeLayout) inflater.inflate(R.layout.activity_teman, container, false);

        getActivity().setTitle("Teman");

        presenter = new TemanPresenterImpl(this);

        recyclerView = view.findViewById(R.id.recycler_view);

        //this disini tadi diganti getActivity() atau getContext() inget
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new MainRecyclerAdapter(temanList);

        adapter.setOnCallbackListener(new MainRecyclerAdapter.OnCallbackListener() {
            @Override
            public void onClick(TemanModel teman) {
                showDialogUpdate(teman);
            }
        });

        recyclerView.setAdapter(adapter);

        //return view;


        buttonAdd = view.findViewById(R.id.btn_main_add);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogInput();
            }
        });

        presenter.load();
        return view;
    }

    @Override
    public void onLoad(List<TemanModel> teman) {
        temanList.clear();
        temanList.addAll(teman);

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onSave() {
        Toast.makeText(getActivity(), "Berhasil disimpan!", Toast.LENGTH_SHORT).show();
        presenter.load();
    }

    @Override
    public void onDelete() {
        Toast.makeText(getActivity(), "Berhasil dihapus!", Toast.LENGTH_SHORT).show();
        presenter.load();
    }

    @Override
    public void onUpdate() {
        Toast.makeText(getActivity(), "Berhasil dihapus!", Toast.LENGTH_SHORT).show();
        presenter.load();
    }

    public void showDialogInput() {

        //this disini tadi diganti getActivity() atau getContext() inget
        dialog = new AppCompatDialog(getActivity());
        dialog.setContentView(R.layout.dialog_input);
        dialog.setTitle("Tambah Data Teman");

        final EditText edtName = dialog.findViewById(R.id.edt_di_nama);
        final EditText edtNim = dialog.findViewById(R.id.edt_di_nim);
        final EditText edtKelas = dialog.findViewById(R.id.edt_di_kelas);
        final EditText edtTelepon = dialog.findViewById(R.id.edt_di_telepon);
        final EditText edtEmail = dialog.findViewById(R.id.edt_di_email);
        final EditText edtSosmed = dialog.findViewById(R.id.edt_di_sosmed);

        Button buttonSave = dialog.findViewById(R.id.btn_di_simpan);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TemanModel teman = new TemanModel();
                teman.setNama(edtName.getText().toString());
                teman.setNim(edtNim.getText().toString());
                teman.setKelas(edtKelas.getText().toString());
                teman.setTelepon(edtTelepon.getText().toString());
                teman.setEmail(edtEmail.getText().toString());
                teman.setSosmed(edtSosmed.getText().toString());
                presenter.save(teman);
                dialog.dismiss();
            }
        });

        Button buttonCancel = dialog.findViewById(R.id.btn_di_cancel);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        if (!dialog.isShowing()) {
            dialog.show();
        }
    }

    public void showDialogUpdate(final TemanModel teman) {

        dialog = new AppCompatDialog(getActivity());
        dialog.setContentView(R.layout.dialog_input);
        dialog.setTitle("Update Data Teman");

        final EditText edtDlName = dialog.findViewById(R.id.edt_di_nama);
        final EditText edtDlNim = dialog.findViewById(R.id.edt_di_nim);
        final EditText edtDlKelas = dialog.findViewById(R.id.edt_di_kelas);
        final EditText edtDlTelepon = dialog.findViewById(R.id.edt_di_telepon);
        final EditText edtDlEmail = dialog.findViewById(R.id.edt_di_email);
        final EditText edtDlSosmed = dialog.findViewById(R.id.edt_di_sosmed);

        edtDlName.setText(teman.getNama());
        edtDlNim.setText(teman.getNim());
        edtDlKelas.setText(teman.getKelas());
        edtDlTelepon.setText(teman.getTelepon());
        edtDlEmail.setText(teman.getEmail());
        edtDlSosmed.setText(teman.getSosmed());

        Button buttonUpdate = dialog.findViewById(R.id.btn_di_simpan);
        buttonUpdate.setText("Update");
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teman.setNama(edtDlName.getText().toString());
                teman.setNim(edtDlNim.getText().toString());
                teman.setKelas(edtDlKelas.getText().toString());
                teman.setTelepon(edtDlTelepon.getText().toString());
                teman.setEmail(edtDlEmail.getText().toString());
                teman.setSosmed(edtDlSosmed.getText().toString());

                presenter.update(teman);
                dialog.dismiss();
            }
        });

        Button buttonDelete = dialog.findViewById(R.id.btn_di_cancel);
        buttonDelete.setText("Delete");
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.delete(teman);
                dialog.dismiss();
            }
        });

        if (!dialog.isShowing()) {
            dialog.show();
        }
    }
}