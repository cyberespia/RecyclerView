package com.mtw.josealejandrosanchezortega.recyclerview

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    // ESTO ES LO QUE VA A MANTENER LA LISTA DE CONTACTOS
    var contactos : ArrayList<Contacto> = ArrayList()

    // lateinitvar ES PARA INDICAR QUE SE DECLARA PERO NO SE ESTÁ INICIALIZANDO
    private lateinit var mylayoutManager : RecyclerView.LayoutManager
    private lateinit var myContactosAdapter : ContactoListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            // SNACKBAR ES UNA VERSION MEJORADA DEL DIALOGO Toast
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        addContactos()

        mylayoutManager = LinearLayoutManager(this)
        myContactosAdapter = ContactoListAdapter(contactos)
        rvListaContactos.apply {
            setHasFixedSize(true)

            // ES UN OBJETO DE LA CLASE LINEARLAYOUT MANAGER, O GRID O STACKED LAYOUT MANAGER
            layoutManager = mylayoutManager

            adapter = myContactosAdapter

            // AGREGAR UN WIDGET SEPARADOR PARA CADA ELEMENTO DE LA LISTA
            addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.HORIZONTAL))
        }
    }

    private fun addContactos() {
        contactos.add(Contacto("Pedro Hernández", "4641234455"))
        contactos.add(Contacto("Juan Hernández", "4641234456"))
        contactos.add(Contacto("Luis Hernández", "4641234457"))
        contactos.add(Contacto("Felipe Hernández", "4641234458"))
        contactos.add(Contacto("José Hernández", "4641234459"))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
