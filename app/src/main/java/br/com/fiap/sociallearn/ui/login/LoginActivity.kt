package br.com.example.sociallearn.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.example.sociallearn.R
import br.com.example.sociallearn.ui.signUp.SignUpActivity
import br.com.example.sociallearn.viewmodel.login.LoginContract
import br.com.fiap.sociallearn.ui.home.HomeActivity

class LoginActivity : AppCompatActivity(), LoginContract {

//    private val viewModel: LoginViewModel by viewModel { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

//        viewModel.onCreate()
        goToMainActivity()
    }

    override fun goToMainActivity() {
        startActivity(Intent(this, HomeActivity::class.java))
    }

    override fun showGenericErrorMessage() {
        TODO("Not yet implemented")
    }

    override fun goToSignUpActivity() {
        startActivity(Intent(this, SignUpActivity::class.java))
    }
}