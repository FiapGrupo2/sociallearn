package br.com.fiap.sociallearn.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.fiap.sociallearn.R
import br.com.fiap.sociallearn.ui.login.LoginActivity
import br.com.fiap.sociallearn.viewmodel.home.HomeContract

class HomeActivity : AppCompatActivity(), HomeContract {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun goToLoginActivity() {
        startActivity(Intent(this, LoginActivity::class.java))
    }

    override fun showGenericErrorMessage() {
        TODO("Not yet implemented")
    }
}
