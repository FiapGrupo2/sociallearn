package br.com.fiap.sociallearn.ui.cursos

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import br.com.fiap.sociallearn.R
import br.com.fiap.sociallearn.ui.base.BaseActivity
import br.com.fiap.sociallearn.ui.home.HomeActivity
import br.com.fiap.sociallearn.ui.login.LoginActivity
import br.com.fiap.sociallearn.utils.UtilToast
import br.com.fiap.sociallearn.viewmodel.logout.LogoutContract
import br.com.fiap.sociallearn.viewmodel.logout.LogoutViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class FrontCourseActivity : BaseActivity(), LogoutContract {
    private val viewModel: LogoutViewModel by viewModel { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_front_course)
    }

    override fun goToLogout() {
        viewModel.goToLogout()
    }

    override fun goToLogin() {
        startActivity(Intent(this, LoginActivity::class.java))
    }

    override fun showMessage(resId: Int) {
        UtilToast.showMessage(this, resId);
    }
}