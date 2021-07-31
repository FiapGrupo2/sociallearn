package br.com.fiap.sociallearn.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import br.com.fiap.sociallearn.R
import br.com.fiap.sociallearn.databinding.ActivityMainBinding
import br.com.fiap.sociallearn.ui.base.BaseActivity
import br.com.fiap.sociallearn.ui.cursos.*
import br.com.fiap.sociallearn.ui.login.LoginActivity
import br.com.fiap.sociallearn.utils.UtilToast
import br.com.fiap.sociallearn.viewmodel.home.HomeContract
import br.com.fiap.sociallearn.viewmodel.home.HomeViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class HomeActivity : BaseActivity(), HomeContract {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: HomeViewModel by viewModel { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

    override fun goToLoginActivity() {
        startActivity(Intent(this, LoginActivity::class.java))
    }

    override fun goToJavaActivity() {
        startActivity(Intent(this, JavaCourseActivity::class.java))
    }

    override fun goToAngularActivity() {
        startActivity(Intent(this, AngularCourseActivity::class.java))
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
        startActivity(Intent(this, CSharpCourseActivity::class.java))
    }

    override fun showMessage(resId: Int) {
        UtilToast.showMessage(this, resId);
    }
}
