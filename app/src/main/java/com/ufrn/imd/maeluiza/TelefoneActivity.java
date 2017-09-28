package com.ufrn.imd.maeluiza;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TelefoneActivity extends AppCompatActivity {

    private RecyclerView rvTelefones;
    private RecyclerView.Adapter mAdapter;
    private List<String> telefones = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telefone);

        rvTelefones = (RecyclerView) findViewById(R.id.rvTelefone);

        rvTelefones.setHasFixedSize(true);
        rvTelefones.setLayoutManager( new LinearLayoutManager(this) );
        mAdapter = new TelefoneAdapter(telefones);
        rvTelefones.setAdapter(mAdapter);

        telefones.add("Policia Militar 24 Hs - 190");
        telefones.add("SAMU 24 Hs - 192");
        telefones.add("Corpo de Bombeiros - 193");
        telefones.add("Defesa Civil - 197");
        telefones.add("Delegacia do Meio Ambiente - 190");
        telefones.add("Delegacia da Mulher - 3232-7402");

        mAdapter.notifyDataSetChanged();

    }
}
