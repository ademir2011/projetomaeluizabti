package com.ufrn.imd.maeluiza;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ademi on 02/05/2017.
 */

public class MediaAdapter extends RecyclerView.Adapter<MediaAdapter.ViewHolder>  {

    private List<Media> medias;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvTituloMediaRow;
        public TextView tvDescricaoMediaRow;
        public ImageView ivMediaMediaRow;

        public ViewHolder(View v) {
            super(v);
            tvTituloMediaRow = (TextView) v.findViewById(R.id.tvTituloMediaRow);
            tvDescricaoMediaRow = (TextView) v.findViewById(R.id.tvDescricaoMediaRow);
            ivMediaMediaRow = (ImageView) v.findViewById(R.id.ivMediaMediaRow);
        }

    }

    public MediaAdapter(List<Media> medias) {
        this.medias = medias;
    }

    @Override
    public MediaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.media_row, parent, false);

        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvTituloMediaRow.setText(medias.get(position).getTitulo());
        holder.tvDescricaoMediaRow.setText(medias.get(position).getDescricao());
        holder.ivMediaMediaRow.setImageResource(R.drawable.imagemteste);
    }

    @Override
    public int getItemCount() {
        return medias.size();
    }

}
