package br.com.fiap.sociallearn.view.cadastro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.example.sociallearn.R
import android.content.Intent
import android.widget.Button

class CadastroAprenderSobre : AppCompatActivity() {
    lateinit var btnNext: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_aprender_sobre)

        btnNext = findViewById(R.id.btnNextCompartilhar)
        btnNext.setOnClickListener {
            val intent = Intent(this, CadastroCompartilharSobre::class.java)
            startActivity(intent)
        }
    }
}