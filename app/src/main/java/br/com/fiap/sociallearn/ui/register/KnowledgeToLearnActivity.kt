package br.com.fiap.sociallearn.ui.register

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import br.com.fiap.sociallearn.R
import br.com.fiap.sociallearn.databinding.ActivityKnowledgeToLearnBinding
import br.com.fiap.sociallearn.viewmodel.register.KnowledgeToLearnContract
import br.com.fiap.sociallearn.viewmodel.register.KnowledgeToLearnViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class KnowledgeToLearnActivity : AppCompatActivity(), KnowledgeToLearnContract {
    private lateinit var binding: ActivityKnowledgeToLearnBinding
    private val viewModel: KnowledgeToLearnViewModel by viewModel { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_knowledge_to_learn)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

    override fun goToKnowledgeToTeachActivity() {
        startActivity(Intent(this, KnowledgeToTeachActivity::class.java))
    }
}