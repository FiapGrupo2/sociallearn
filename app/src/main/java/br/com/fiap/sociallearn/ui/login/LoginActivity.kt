package br.com.fiap.sociallearn.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import br.com.fiap.sociallearn.R
import br.com.fiap.sociallearn.databinding.ActivityLoginBinding
import br.com.fiap.sociallearn.ui.home.HomeActivity
import br.com.fiap.sociallearn.ui.signUp.SignUpActivity
import br.com.fiap.sociallearn.utils.UtilToast;
import br.com.fiap.sociallearn.viewmodel.login.LoginContract
import br.com.fiap.sociallearn.viewmodel.login.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class LoginActivity : AppCompatActivity(), LoginContract {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModel { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        viewModel.onCreate()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun goToMainActivity() {
        startActivity(Intent(this, HomeActivity::class.java))
    }

    override fun goToSignUpActivity() {
        startActivity(Intent(this, SignUpActivity::class.java))
    }

    override fun goToResetPasswordActivity() {
        startActivity(Intent(this, ResetPasswordActivity::class.java))
    }

    override fun showMessage(resId: Int) {
        if (resId == R.string.ERROR_NULL_LOGIN) {
           binding.tvError.text = "E-mail e senha precisam estar preenchidos!"
        }
        UtilToast.showMessage(this, resId);
    }
}