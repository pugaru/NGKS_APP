package com.teco.myapplication2

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.teco.myapplication2.R.id.action_buscar
import com.teco.myapplication2.R.id.home
import kotlinx.android.synthetic.main.activity_tela_inicial.*


class caixaActivity : DebugActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_caixa)

        supportActionBar?.title = "Caixa"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        var id = item?.itemId

        if (id == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}