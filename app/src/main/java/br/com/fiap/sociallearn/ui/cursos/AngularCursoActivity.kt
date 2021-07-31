package br.com.fiap.sociallearn.ui.cursos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatImageView
import br.com.fiap.sociallearn.R
import br.com.fiap.sociallearn.ui.home.HomeActivity
import br.com.fiap.sociallearn.ui.login.LoginActivity
import br.com.fiap.sociallearn.utils.UtilToast
import br.com.fiap.sociallearn.viewmodel.logout.LogoutContract
import br.com.fiap.sociallearn.viewmodel.logout.LogoutViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class AngularCursoActivity : AppCompatActivity() , LogoutContract {
    private lateinit var btInicio: AppCompatImageView
    private lateinit var btSignOut: AppCompatImageView
    private val viewModel: LogoutViewModel by viewModel { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_angular_course)

        btInicio = findViewById(R.id.btInicio)
        btInicio.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }

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

    override fun showMessage(restId: Int) {
        UtilToast.showMessage(this, restId);
    }
}