package br.com.fiap.sociallearn.view.cadastro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.example.sociallearn.R
import android.view.Window
import android.view.WindowManager
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var btnNext: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fullScreen()
        setContentView(R.layout.activity_main)

        //btnNext = findViewById(R.id.btnNext)
        //btnNext.setOnClickListener {
         //   val intent = Intent(this, CadastroPerfil::class.java)
          //  startActivity(intent)
       // }
    }

    private fun fullScreen() {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        supportActionBar?.hide()
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
    }
}
