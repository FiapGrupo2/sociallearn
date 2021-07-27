package br.com.fiap.sociallearn.view.cadastro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.example.sociallearn.R
import android.content.Intent
import android.widget.Button

class CadastroPerfil : AppCompatActivity() {
    lateinit var btnNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_perfil)

        btnNext = findViewById(R.id.btnNextPerfil)
        btnNext.setOnClickListener {
            val intent = Intent(this, CadastroAprenderSobre::class.java)
            startActivity(intent)
        }
    }
}