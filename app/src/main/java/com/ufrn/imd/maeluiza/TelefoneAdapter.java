package com.ufrn.imd.maeluiza;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ademir on 11/09/17.
 */

class TelefoneAdapter extends RecyclerView.Adapter<TelefoneAdapter.ViewHolder> {

    private List<String> telefones;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvTelefone;

        public ViewHolder(View v) {
            super(v);
            tvTelefone = (TextView) v.findViewById(R.id.tvTelefone);
        }

    }

    public TelefoneAdapter(List<String> telefones) {
        this.telefones = telefones;
    }

    @Override
    public TelefoneAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.telefone_row, parent, false);

        return new TelefoneAdapter.ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(TelefoneAdapter.ViewHolder holder, int position) {
        holder.tvTelefone.setText(telefones.get(position));
    }

    @Override
    public int getItemCount() {
        return telefones.size();
    }

}
