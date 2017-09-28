package com.ufrn.imd.maeluiza;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ademi on 02/05/2017.
 */

public class EnderecoAdapter extends RecyclerView.Adapter<EnderecoAdapter.ViewHolder> {

    private List<String> enderecos;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvEndereco;

        public ViewHolder(View v) {
            super(v);
            tvEndereco = (TextView) v.findViewById(R.id.tvEndereco);
        }

    }

    public EnderecoAdapter(List<String> enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public EnderecoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.endereco_row, parent, false);

        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvEndereco.setText(enderecos.get(position));
    }

    @Override
    public int getItemCount() {
        return enderecos.size();
    }

}
