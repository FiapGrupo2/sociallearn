package br.com.fiap.sociallearn.ui.home

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import br.com.fiap.sociallearn.R
import br.com.fiap.sociallearn.databinding.ActivityMainBinding
import br.com.fiap.sociallearn.ui.base.BaseActivity
import br.com.fiap.sociallearn.ui.courses.*
import br.com.fiap.sociallearn.ui.login.LoginActivity
import br.com.fiap.sociallearn.viewmodel.home.HomeContract
import br.com.fiap.sociallearn.viewmodel.home.HomeViewModel
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageClickListener
import com.synnapps.carouselview.ImageListener
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class HomeActivity : BaseActivity(), HomeContract {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: HomeViewModel by viewModel { parametersOf(this) }

    val mImages = arrayOf(
        R.drawable.javacourse,
        R.drawable.angularcouse,
        R.drawable.ccourse2,
        R.drawable.frontcourse,
        R.drawable.javascriptcourse,
        R.drawable.nodejscourse,
        R.drawable.postgrecourse,
        R.drawable.salesforcecourse,
        R.drawable.securitycourse,
        R.drawable.sqlcourse,
        R.drawable.boostrapcourse
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        val carouselView = findViewById<CarouselView>(R.id.carousel)
        carouselView.pageCount = mImages.size

        carouselView.setImageListener(object : ImageListener {
            override fun setImageForPosition(position: Int, imageView: ImageView?) {
                imageView!!.setImageResource(mImages[position])
            }
        })

        carouselView.setImageClickListener(object : ImageClickListener {
            override fun onClick(position: Int) {
                when (position) {
                    0 -> goToJavaActivity()

                    1 -> goToAngularActivity()

                    2 -> goToCActivity()

                    3 -> goToFrontActivity()

                    4 -> goToJSActivity()

                    5 -> goToNodeActivity()

                    6 -> goToPSQLActivity()

                    7 -> goToSalesActivity()

                    8 -> goToSecurityActivity()

                    9 -> goToSQLActivity()

                    10 -> goToBootActivity()
                }
            }
        })

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

    override fun goToSQLActivity() {
        startActivity(Intent(this, SQLCourseActivity::class.java))
    }

    override fun goToPSQLActivity() {
        startActivity(Intent(this, PSQLCourseActivity::class.java))
    }

    override fun goToCActivity() {
        startActivity(Intent(this, CSharpCourseActivity::class.java))
    }
}
