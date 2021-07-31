package br.com.fiap.sociallearn.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.DataBindingUtil
import br.com.fiap.sociallearn.R
import br.com.fiap.sociallearn.databinding.ActivityLoginBinding
import br.com.fiap.sociallearn.databinding.ActivityMainBindingImpl
import br.com.fiap.sociallearn.ui.cursos.*
import br.com.fiap.sociallearn.ui.login.LoginActivity
import br.com.fiap.sociallearn.viewmodel.home.HomeContract
import br.com.fiap.sociallearn.viewmodel.home.HomeViewModel
import br.com.fiap.sociallearn.viewmodel.login.LoginViewModel
import br.com.fiap.sociallearn.viewmodel.logout.LogoutContract
import br.com.fiap.sociallearn.viewmodel.logout.LogoutViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class HomeActivity : AppCompatActivity(), LogoutContract , HomeContract{
    private lateinit var binding: ActivityMainBindingImpl
    private lateinit var btSignOut: AppCompatImageView

    private val viewModelHome: HomeViewModel by viewModel { parametersOf(this) }
    private val viewModel: LogoutViewModel by viewModel { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModelHome
        binding.lifecycleOwner = this
        viewModelHome.onCreate()

        btSignOut = findViewById(R.id.btSignOut)
        btSignOut.setOnClickListener {
            goToLogout()
        }
    }

    override fun goToLogout() {
        viewModel.goToLogout()
    }

    override fun goToLogin() {
        startActivity(Intent(this, LoginActivity::class.java))
    }

    override fun goToLoginActivity() {
        TODO("Not yet implemented")
    }

    override fun goToJavaActivity() {
        startActivity(Intent(this, JavaCourseActivity::class.java))
    }

    override fun goToAngularActivity() {
        startActivity(Intent(this, AngularCursoActivity::class.java))
    }

    override fun goToNodeActivity() {
        startActivity(Intent(this, NodeCourseActivity::class.java))
    }

    override fun goToBootActivity() {
        startActivity(Intent(this, BootCourseActivity::class.java))
    }

    override fun goToFrontActivity() {
        startActivity(Intent(this, FrontCourseActivity::class.java))
    }

    override fun goToJSActivity() {
        startActivity(Intent(this, JavaSCourseActivity::class.java))
    }

    override fun goToJRActivity() {
        startActivity(Intent(this, JavaRubyCourseActivity::class.java))
    }

    override fun goToSalesActivity() {
        startActivity(Intent(this, SalesCourseActivity::class.java))
    }

    override fun goToSecurityActivity() {
        startActivity(Intent(this, SecurityCourseActivity::class.java))
    }

    override fun goToSQActivity() {
        startActivity(Intent(this, SQLCourseActivity::class.java))
    }

    override fun goToPSQLActivity() {
        startActivity(Intent(this, PSQLCourseActivity::class.java))
    }

    override fun goToCActivity() {
        startActivity(Intent(this, CCourseActivity::class.java))
    }

    override fun showGenericErrorMessage() {
        TODO("Not yet implemented")
    }
}
