package br.com.example.sociallearn.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.example.sociallearn.R
import br.com.example.sociallearn.ui.search.SearchContentActivity
import br.com.example.sociallearn.ui.signUp.SignUpActivity
import br.com.example.sociallearn.viewmodel.login.LoginContract
import br.com.example.sociallearn.viewmodel.login.LoginViewModel
import org.koin.android.viewmodel.compat.ViewModelCompat.viewModel
import org.koin.core.parameter.parametersOf

class LoginActivity : AppCompatActivity(), LoginContract {

//    private val viewModel: LoginViewModel by viewModel { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

//        viewModel.onCreate()
        goToMainActivity()
    }

    override fun goToMainActivity() {
        startActivity(Intent(this, SearchContentActivity::class.java))
    }

    override fun showGenericErrorMessage() {
        TODO("Not yet implemented")
    }

    override fun goToSignUpActivity() {
        startActivity(Intent(this, SignUpActivity::class.java))
    }
}