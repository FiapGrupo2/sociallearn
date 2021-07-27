package br.com.fiap.sociallearn.view.cadastro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.findFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import br.com.example.sociallearn.R
import br.com.fiap.sociallearn.extensions.hideKeyboard
import br.com.fiap.sociallearn.model.Gender
import br.com.fiap.sociallearn.model.Profile
import br.com.fiap.sociallearn.model.RequestState
import br.com.fiap.sociallearn.model.User
import br.com.fiap.sociallearn.view.base.auth.BaseAuthFragment
import br.com.fiap.sociallearn.viewmodel.SignUpViewModel

class CadastroTeachFragment : BaseAuthFragment() {
    private var name: String? = null
    private var email: String? = null
    private var pass: String? = null
    private var genero: String? = null

    private lateinit var btCreateAccount: Button
    private var checkBoxDone = true
    private lateinit var listProfife :ArrayList<Profile>

    private val signUpViewModel: SignUpViewModel by viewModels()

    override val layout: Int
        get() = R.layout.fragment_cadastro_teach

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
        registerObserver()
    }
    private fun setUpView(view: View) {
        btCreateAccount = view.findViewById(R.id.btCreateAccount)

        btCreateAccount = view.findViewById(R.id.btCreateAccount)
        btCreateAccount.setOnClickListener {
            hideKeyboard()
            if(checkBoxDone) {
                listProfife = ArrayList<Profile>()
                listProfife.add(Profile(0,"user",true));

                val newUser = User(0,
                    name.toString(),
                    email.toString(),
                    pass.toString(),
                    true,
                    Gender.FEMALE,
                    listProfife
                )
                signUpViewModel.signUp(newUser)
            } else {
                showMessage("Você precisa aceitar os termos de uso.")
            }
        }

    }

    private fun registerObserver() {
        this.signUpViewModel.signUpState.observe(viewLifecycleOwner, Observer {
            when (it) {
                is RequestState.Success<*> -> {
                    hideLoading()
                    NavHostFragment.findNavController(this)
                        .navigate(R.id.main_nav)
                }
                is RequestState.Error -> {
                    hideLoading()
                    showMessage(it.throwable.message)
                }
                is RequestState.Loading -> showLoading("Realizando a autenticação")
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cadastro_teach, container, false)
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