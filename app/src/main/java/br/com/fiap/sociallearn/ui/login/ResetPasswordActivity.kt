package br.com.fiap.sociallearn.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import br.com.fiap.sociallearn.R
import br.com.fiap.sociallearn.databinding.ActivityResetPasswordBinding
import br.com.fiap.sociallearn.utils.UtilToast
import br.com.fiap.sociallearn.viewmodel.login.ResetPasswordContract
import br.com.fiap.sociallearn.viewmodel.login.ResetPasswordViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class ResetPasswordActivity : AppCompatActivity(), ResetPasswordContract {
    private lateinit var binding: ActivityResetPasswordBinding
    private val viewModel: ResetPasswordViewModel by viewModel { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_reset_password)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

    override fun goToLoginActivity() {
        startActivity(Intent(this, LoginActivity::class.java))
    }

    override fun showMessage(resId: Int) {
        if (resId == R.string.ERROR_NULL_RESET) {
            binding.tvError.text = "E-mail precisa estar preenchido!"
        }

        UtilToast.showMessage(this, resId);
    }
}