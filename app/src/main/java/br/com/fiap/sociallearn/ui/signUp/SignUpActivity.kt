package br.com.fiap.sociallearn.ui.signUp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import br.com.fiap.sociallearn.R
import br.com.fiap.sociallearn.databinding.ActivitySignUpBinding
import br.com.fiap.sociallearn.ui.home.HomeActivity
import br.com.fiap.sociallearn.ui.register.KnowledgeToLearnActivity
import br.com.fiap.sociallearn.utils.UtilToast
import br.com.fiap.sociallearn.viewmodel.signUp.SignUpContract
import br.com.fiap.sociallearn.viewmodel.signUp.SignUpViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class SignUpActivity : AppCompatActivity(), SignUpContract {
    private lateinit var binding: ActivitySignUpBinding
    private val viewModel: SignUpViewModel by viewModel { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

    override fun goToKnowledgeToLearnActivity() {
        startActivity(Intent(this, KnowledgeToLearnActivity::class.java))
    }

    override fun goToMainActivity() {
        startActivity(Intent(this, HomeActivity::class.java))
    }

    override fun showMessage(resId: Int) {
        if (resId == R.string.ERROR_NULL_SIGN) {
            binding.tvError.text = "Todos os campos precisam estar preenchido!"
        }
        if (resId == R.string.ERROR_DIF_PASS) {
            binding.tvError.text = "As senhas digitadas não são iguais"
        }
        if (resId == R.string.ERROR_EMAIL_INVALIDO) {
            binding.tvError.text = "E-mail invalído!"
        }

        UtilToast.showMessage(this, resId);
    }
}