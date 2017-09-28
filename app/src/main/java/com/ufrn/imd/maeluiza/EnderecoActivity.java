package com.ufrn.imd.maeluiza;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EnderecoActivity extends AppCompatActivity {

    private RecyclerView rvEndereco;
    private RecyclerView.Adapter mAdapter;
    private List<String> enderecos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endereco);

        rvEndereco = (RecyclerView) findViewById(R.id.rvEndereco);

        rvEndereco.setHasFixedSize(true);
        rvEndereco.setLayoutManager( new LinearLayoutManager(this) );
        mAdapter = new EnderecoAdapter(enderecos);
        rvEndereco.setAdapter(mAdapter);

        enderecos.add("CRAS\n" +
                "Rua Guanabara, 816\n" +
                "Natal - RN, 59014-106");
        enderecos.add("Arena do Morro");
        enderecos.add("Escola Estadual Monsenhor Alfred");
        enderecos.add("Igreja Batista");
        enderecos.add("Igreja Católica");

        mAdapter.notifyDataSetChanged();

    }
}
