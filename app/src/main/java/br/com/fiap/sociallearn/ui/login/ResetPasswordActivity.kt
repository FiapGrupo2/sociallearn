package br.com.fiap.sociallearn.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import br.com.fiap.sociallearn.R
import br.com.fiap.sociallearn.databinding.ActivityLoginBinding
import br.com.fiap.sociallearn.databinding.ActivityResetPasswordBinding
import br.com.fiap.sociallearn.viewmodel.login.LoginViewModel
import br.com.fiap.sociallearn.viewmodel.login.ResetPasswordContract
import br.com.fiap.sociallearn.viewmodel.login.ResetPasswordViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class ResetPasswordActivity : AppCompatActivity(), ResetPasswordContract {
    private lateinit var binding: ActivityResetPasswordBinding
    private val viewModel: ResetPasswordViewModel by viewModel { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_reset_password)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

    override fun goToLoginActivity() {
        startActivity(Intent(this, LoginActivity::class.java))
    }

    override fun showGenericErrorMessage() {
        TODO("Not yet implemented")
    }
}