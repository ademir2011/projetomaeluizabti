package com.ufrn.imd.maeluiza

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.support.v13.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.KeyEvent
import android.view.View
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem
import kotlinx.android.synthetic.main.activity_main.*
import android.Manifest.permission.WRITE_CALENDAR
import android.widget.Toast
import android.Manifest.permission.CALL_PHONE
import android.os.Build
import android.util.Log


/**
 * Created by ademi on 20/06/2017.
 */
class MainActivityK : AppCompatActivity(){

    var listSecondaryDrawerItem = mutableListOf(
            SecondaryDrawerItem().withIdentifier(11).withName("Rotas de Fuga"),
            SecondaryDrawerItem().withIdentifier(12).withName("Pontos de Encontro"),
            SecondaryDrawerItem().withIdentifier(13).withName("Mapa das áreas de riscos"),
            SecondaryDrawerItem().withIdentifier(14).withName("Mapa do Bairro"),
            SecondaryDrawerItem().withIdentifier(15).withName("Pontos Oficiais de Coleta de Lixo"),
            SecondaryDrawerItem().withIdentifier(16).withName("Pontos Informais de Descarte de Lixo"),


            SecondaryDrawerItem().withIdentifier(21).withName("Abrigos públicos"),
            SecondaryDrawerItem().withIdentifier(22).withName("Posto de saúde"),
            SecondaryDrawerItem().withIdentifier(23).withName("Posto de Polícia"),
            SecondaryDrawerItem().withIdentifier(24).withName("Outros locais"),

            SecondaryDrawerItem().withIdentifier(31).withName("Procedimentos de Emergência"),
            SecondaryDrawerItem().withIdentifier(32).withName("Condutas enviadas pela comunidade"),
            SecondaryDrawerItem().withIdentifier(33).withName("Enviar prática de conduta"),
            SecondaryDrawerItem().withIdentifier(34).withName("Áreas de riscos e desastres"),
            SecondaryDrawerItem().withIdentifier(35).withName("Áreas de desastres após triagem"),
            SecondaryDrawerItem().withIdentifier(36).withName("Pedido de Socorro"),

            SecondaryDrawerItem().withIdentifier(41).withName("Sobre")
    )

    var drawer : Drawer? = null
    var medias = mutableListOf<Media>()
    var mAdapter : MediaAdapter = MediaAdapter(medias)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(mediaToolbar)

        drawer = DrawerBuilder().withActivity(this)
                .withToolbar(mediaToolbar)
                .addDrawerItems(
                        listSecondaryDrawerItem.get(0), listSecondaryDrawerItem.get(1), listSecondaryDrawerItem.get(2), listSecondaryDrawerItem.get(3), listSecondaryDrawerItem.get(4), listSecondaryDrawerItem.get(5),
                        DividerDrawerItem(),
                        listSecondaryDrawerItem.get(6), listSecondaryDrawerItem.get(7), listSecondaryDrawerItem.get(8), listSecondaryDrawerItem.get(9),
                        DividerDrawerItem(),
                        listSecondaryDrawerItem.get(10), listSecondaryDrawerItem.get(11), listSecondaryDrawerItem.get(12), listSecondaryDrawerItem.get(13), listSecondaryDrawerItem.get(14), listSecondaryDrawerItem.get(15),
                        DividerDrawerItem(),
                        listSecondaryDrawerItem.get(16)
                )
                .withOnDrawerItemClickListener { _, position, _ ->
                    redirect(position)
                    true
                }
                .build()

        with(rvMedia){
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivityK) as RecyclerView.LayoutManager?
            adapter = mAdapter
        }

        medias.add( Media("teste","teste","teste") )
        medias.add( Media("teste","teste","teste") )
        medias.add( Media("teste","teste","teste") )

        mAdapter.notifyDataSetChanged()

    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent) = when (event.keyCode) {
        KeyEvent.KEYCODE_POWER -> true
        else -> super.onKeyDown(keyCode, event)
    }

    fun redirect(position : Int){

        when (position) {
            0,1,2,3,4,5,6 -> {
                startActivity( Intent(this, MapsActivity::class.java).putExtra("number",position) )
            }
            7,8,9,10 -> {
                startActivity( Intent(this, EnderecoActivity::class.java).putExtra("number",position) )
            }
        }

    }

    fun telefonesUteisClick(view: View) {
        startActivity( Intent(this, TelefoneActivity::class.java) )
    }

    fun pontosDeEncontroClick(view: View) {
        startActivity( Intent(this, MapsActivity::class.java) )
    }

    fun rotasDeFugaClick(view: View) {
        startActivity( Intent(this, MapsActivity::class.java) )
    }

    fun pedidosDeSocorroClick(view: View) {

        if(isPermissionGranted()){
            call_action();
        }

    }

    fun call_action() {
        val phnum = "777777777"
        val callIntent = Intent(Intent.ACTION_CALL)
        callIntent.data = Uri.parse("tel:" + phnum)
        startActivity(callIntent)
    }

    fun isPermissionGranted(): Boolean {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                Log.v("TAG", "Permission is granted")
                return true
            } else {

                Log.v("TAG", "Permission is revoked")
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE), 1)
                return false
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            Log.v("TAG", "Permission is granted")
            return true
        }
    }


    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {

            1 -> {

                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(applicationContext, "Permission granted", Toast.LENGTH_SHORT).show()
                    call_action()
                } else {
                    Toast.makeText(applicationContext, "Permission denied", Toast.LENGTH_SHORT).show()
                }
                return
            }
        }

    }

}