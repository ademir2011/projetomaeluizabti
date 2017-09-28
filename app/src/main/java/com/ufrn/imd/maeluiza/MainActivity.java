package com.ufrn.imd.maeluiza;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMedia;
    private RecyclerView.Adapter mAdapter;
    private List<Media> medias = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.mediaToolbar);
        setSupportActionBar(myToolbar);

        SecondaryDrawerItem item11 = new SecondaryDrawerItem().withIdentifier(11).withName("Rotas de Fuga");
        SecondaryDrawerItem item12 = new SecondaryDrawerItem().withIdentifier(12).withName("Pontos de Encontro");
        SecondaryDrawerItem item13 = new SecondaryDrawerItem().withIdentifier(13).withName("Mapa das áreas de riscos");
        SecondaryDrawerItem item14 = new SecondaryDrawerItem().withIdentifier(14).withName("Mapa do Bairro");
        SecondaryDrawerItem item15 = new SecondaryDrawerItem().withIdentifier(15).withName("Pontos Oficiais de Coleta de Lixo");
        SecondaryDrawerItem item16 = new SecondaryDrawerItem().withIdentifier(16).withName("Pontos Informais de Descarte de Lixo");

        SecondaryDrawerItem item21 = new SecondaryDrawerItem().withIdentifier(21).withName("Abrigos públicos");
        SecondaryDrawerItem item22 = new SecondaryDrawerItem().withIdentifier(22).withName("Posto de saúde");
        SecondaryDrawerItem item23 = new SecondaryDrawerItem().withIdentifier(23).withName("Posto de Polícia");
        SecondaryDrawerItem item24 = new SecondaryDrawerItem().withIdentifier(24).withName("Outros locais");

        SecondaryDrawerItem item31 = new SecondaryDrawerItem().withIdentifier(31).withName("Procedimentos de Emergência");
        SecondaryDrawerItem item32 = new SecondaryDrawerItem().withIdentifier(32).withName("Condutas enviadas pela comunidade");
        SecondaryDrawerItem item33 = new SecondaryDrawerItem().withIdentifier(33).withName("Enviar prática de conduta");
        SecondaryDrawerItem item35 = new SecondaryDrawerItem().withIdentifier(34).withName("Áreas de riscos e desastres");
        SecondaryDrawerItem item36 = new SecondaryDrawerItem().withIdentifier(35).withName("Áreas de desastres após triagem");
        SecondaryDrawerItem item37 = new SecondaryDrawerItem().withIdentifier(36).withName("Pedido de Socorro");

        PrimaryDrawerItem item4 = new PrimaryDrawerItem().withIdentifier(4).withName("Sobre");

        //create the drawer and remember the `Drawer` result object
        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(myToolbar)
                .addDrawerItems(
                        item11, item12, item13, item14, item15, item16,
                        new DividerDrawerItem(),
                        item21, item22, item23, item24,
                        new DividerDrawerItem(),
                        item31, item32, item33, item35, item36, item37,
                        new DividerDrawerItem(),
                        item4
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        Log.e("teste",""+position);
                        return true;
                    }
                })
                .build();

        rvMedia = (RecyclerView) findViewById(R.id.rvMedia);

        rvMedia.setHasFixedSize(true);
        rvMedia.setLayoutManager( new LinearLayoutManager(this) );
        mAdapter = new MediaAdapter(medias);
        rvMedia.setAdapter(mAdapter);

        medias.add( new Media("Titulo teste 1", "Descricao teste 1", "imagem") );
        medias.add( new Media("Titulo teste 2", "Descricao teste 2", "imagem") );
        medias.add( new Media("Titulo teste 3", "Descricao teste 3", "imagem") );
        medias.add( new Media("Titulo teste 4", "Descricao teste 4", "imagem") );

        mAdapter.notifyDataSetChanged();

    }

    public void telefonesUteisClick(View view) {
        startActivity( new Intent(this, TelefoneActivity.class) );
    }

    public void  pontosDeEncontroClick(View view) {
        startActivity( new Intent(this, MapsActivity.class) );
    }

    public void  rotasDeFugaClick(View view) {
        startActivity( new Intent(this, MapsActivity.class) );
    }

}


