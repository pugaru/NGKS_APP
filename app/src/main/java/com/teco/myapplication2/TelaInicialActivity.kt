package com.teco.myapplication2

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.teco.myapplication2.R.id.action_buscar
import com.teco.myapplication2.R.id.home
import kotlinx.android.synthetic.main.activity_tela_inicial.*

class TelaInicialActivity :DebugActivity() {

    private val contexto: Context get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        var nome = intent.getStringExtra("nome")
        var numero = intent.getIntExtra("numero",0)


        mensagemInicial.text = nome

        botaoSair.setOnClickListener{
            val returnIntent = Intent()
            returnIntent.putExtra("result","Você saiu")
            setResult(Activity.RESULT_OK,returnIntent)
            finish()
        }

        botao_estoque.setOnClickListener{
            val intent = Intent(contexto, EstoqueActivity::class.java)

            startActivityForResult(intent,1)

        }

        botao_produto.setOnClickListener{
            val intent = Intent(contexto, produtoActivity::class.java)

            startActivityForResult(intent,1)

        }

        botao_caixa.setOnClickListener{
            val intent = Intent(contexto, caixaActivity::class.java)

            startActivityForResult(intent,1)

        }

        supportActionBar?.title = "Tela Incial"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        var id = item?.itemId

        if (id == action_buscar){
            onClickBusca()
        }

        else if (id ==R.id.action_atualizar){
            Toast.makeText(this,"Clicou em atualizar",Toast.LENGTH_SHORT).show()
        }

        else if (id == R.id.action_config){
            val intent = Intent(contexto, configActivity::class.java)

            startActivityForResult(intent,1)
        }

        return super.onOptionsItemSelected(item)
    }

    fun onClickBusca(){
        val ActionBuscar = action_buscar
        val valorBusca = ActionBuscar.toString()
        Toast.makeText(this , "$valorBusca" , Toast.LENGTH_SHORT).show()

        intent.putExtra("nome", valorBusca)

        startActivityForResult(intent,1)
    }
}
