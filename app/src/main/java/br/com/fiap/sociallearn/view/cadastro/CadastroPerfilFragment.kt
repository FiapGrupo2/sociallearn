package br.com.fiap.sociallearn.view.cadastro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import br.com.example.sociallearn.R
import br.com.fiap.sociallearn.view.base.auth.BaseAuthFragment

class CadastroPerfilFragment : BaseAuthFragment() {
    override val layout: Int
        get() = R.layout.fragment_cadastro_perfil

    private var name: String? = null
    private var email: String? = null
    private var pass: String? = null
    private var genero: String? = null
    private lateinit var btNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            name = it.getString("name")
            email = it.getString("email")
            pass = it.getString("pass")
            genero = it.getString("genero")
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpView(view)

    }
    private fun setUpView(view: View) {
        btNext = view.findViewById(R.id.btNextToLearn)
        val bundle = bundleOf("name" to name.toString(),
            "email" to email.toString(),
            "pass" to pass.toString(),
            "genero" to genero.toString() )

        btNext.setOnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_cadastroPerfilFragment_to_cadastroLearnFragment, bundle)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cadastro_perfil, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(name: String, email: String, pass: String, genero: String) =
            CadastroFragment().apply {
                arguments = Bundle().apply {
                    putString("name", name)
                    putString("email", email)
                    putString("pass", pass)
                    putString("genero", genero)
                }
            }
    }
}