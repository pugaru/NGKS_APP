package com.teco.myapplication2

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.login.*

class MainActivity : DebugActivity() {

    private val contexto: Context get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        var imagem = campo_imagem

        imagem.setImageResource(R.drawable.imagem_login)

        //var textoUsuario = textView2

        textView2.text = "Usuário:"


        botaoLogin.setOnClickListener {
            if (campo_usuario.text.toString().equals("aluno") ||
                    campo_senha.text.toString().equals("impacta")) onCLickLogin()
            else Toast.makeText(this,"Usuário ou senha incorretos ",Toast.LENGTH_SHORT).show()
        }
    }

    fun onCLickLogin(){
        val campoUsuario = campo_usuario
        val campoSenha = campo_senha
        val valorUsuario = campoUsuario.text.toString()
        //val valorSenha = campoSenha.text.toString()
        Toast.makeText(this , "Bem vindo! $valorUsuario  " , Toast.LENGTH_SHORT).show()


        val intent = Intent(contexto, TelaInicialActivity::class.java)

        intent.putExtra("nome", valorUsuario)

        startActivityForResult(intent,1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode ==1){
            val result = data?.getStringExtra("result")
            Toast.makeText(contexto,"$result",Toast.LENGTH_SHORT).show()
        }
    }
}
