package com.akb.erwin;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/*
 * Tanggal pengerjaan: 5 Agustus 2019
 * NIM : 10116036
 * Nama : Antonius Erwin
 * Kelas : AKB-1*/

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder> {

    private List<TemanModel> temans;
    private OnCallbackListener listener;

    public MainRecyclerAdapter(List<TemanModel> temans) {
        this.temans = temans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_teman, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TemanModel teman = temans.get(position);
        holder.textViewNama.setText(teman.getNama());
        holder.textViewNim.setText(teman.getNim());
        holder.textViewKelas.setText(teman.getKelas());
        holder.textViewTelepon.setText(teman.getTelepon());
        holder.textViewEmail.setText(teman.getEmail());
        holder.textViewSosmed.setText(teman.getSosmed());
    }

    @Override
    public int getItemCount() {
        return temans.size();
    }

    public void setOnCallbackListener(OnCallbackListener listener) {
        this.listener = listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewNama;
        TextView textViewNim;
        TextView textViewKelas;
        TextView textViewTelepon;
        TextView textViewEmail;
        TextView textViewSosmed;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            textViewNama = itemView.findViewById(R.id.nama);
            textViewNim = itemView.findViewById(R.id.nim);
            textViewKelas = itemView.findViewById(R.id.kelas);
            textViewTelepon = itemView.findViewById(R.id.telepon);
            textViewEmail = itemView.findViewById(R.id.email);
            textViewSosmed = itemView.findViewById(R.id.sosmed);
        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.onClick(temans.get(getAdapterPosition()));
            }
        }
    }

    public interface OnCallbackListener {

        void onClick(TemanModel user);
    }
}
