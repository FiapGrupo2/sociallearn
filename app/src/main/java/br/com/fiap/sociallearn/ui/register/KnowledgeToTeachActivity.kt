package br.com.fiap.sociallearn.ui.register

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import br.com.fiap.sociallearn.R
import br.com.fiap.sociallearn.databinding.ActivityKnowledgeToTeachBinding
import br.com.fiap.sociallearn.ui.home.HomeActivity
import br.com.fiap.sociallearn.utils.UtilToast
import br.com.fiap.sociallearn.viewmodel.register.KnowledgeToTeachContract
import br.com.fiap.sociallearn.viewmodel.register.KnowledgeToTeachViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class KnowledgeToTeachActivity : AppCompatActivity(), KnowledgeToTeachContract {
    private lateinit var binding: ActivityKnowledgeToTeachBinding
    private val viewModel: KnowledgeToTeachViewModel by viewModel { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_knowledge_to_teach)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

    override fun goToHomeActivity() {
        startActivity(Intent(this, HomeActivity::class.java))
    }

    override fun showMessage(resIdMsg: Int) {
        UtilToast.showMessage(this, resIdMsg)
    }

}