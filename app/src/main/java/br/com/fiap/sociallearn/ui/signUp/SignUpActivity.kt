package br.com.fiap.sociallearn.ui.signUp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.fiap.sociallearn.R
import br.com.fiap.sociallearn.ui.home.HomeActivity
import br.com.fiap.sociallearn.ui.register.RegisterUserProfileActivity
import br.com.fiap.sociallearn.viewmodel.signUp.SignUpContract

class SignUpActivity : AppCompatActivity(), SignUpContract {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
    }

    override fun goToRegisterUserProfileActivity() {
        val intent = Intent(this, RegisterUserProfileActivity::class.java)
        startActivity(intent)
    }

    override fun goToMainActivity() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    override fun showGenericErrorMessage() {
        TODO("Not yet implemented")
    }
}