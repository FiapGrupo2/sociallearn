package br.com.example.sociallearn.view.cadastro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import br.com.example.sociallearn.R

class CadastroCompartilharSobre : AppCompatActivity() {
    lateinit var btnNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_compartilhar_sobre)
    }
}