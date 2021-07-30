package br.com.fiap.sociallearn.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import br.com.fiap.sociallearn.R
import br.com.fiap.sociallearn.databinding.ActivityLoginBinding
import br.com.fiap.sociallearn.databinding.ActivityMainBindingImpl
import br.com.fiap.sociallearn.ui.cursos.JavaCourseActivity
import br.com.fiap.sociallearn.ui.login.LoginActivity
import br.com.fiap.sociallearn.viewmodel.home.HomeContract
import br.com.fiap.sociallearn.viewmodel.home.HomeViewModel
import br.com.fiap.sociallearn.viewmodel.login.LoginViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class HomeActivity : AppCompatActivity(), HomeContract {
    private lateinit var binding: ActivityMainBindingImpl
    private val viewModel: HomeViewModel by viewModel { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        viewModel.onCreate()
        setContentView(R.layout.activity_main)
    }

    override fun goToLoginActivity() {
        TODO("Not yet implemented")
    }

    override fun goToCourseInformation() {
        startActivity(Intent(this, JavaCourseActivity::class.java))
    }
    override fun showGenericErrorMessage() {
        TODO("Not yet implemented")
    }
}
