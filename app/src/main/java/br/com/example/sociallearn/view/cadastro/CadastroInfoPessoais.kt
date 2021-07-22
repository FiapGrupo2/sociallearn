package br.com.example.sociallearn.view.cadastro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.example.sociallearn.R
import android.content.Intent
import android.widget.Button

class CadastroInfoPessoais : AppCompatActivity() {
    lateinit var btnNext: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_info_pessoais)

        btnNext = findViewById(R.id.btnNext)
        btnNext.setOnClickListener {
            val intent = Intent(this, CadastroPerfil::class.java)
            startActivity(intent)
        }
    }
}