package br.com.fiap.sociallearn.view.cadastro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import br.com.example.sociallearn.R
import br.com.fiap.sociallearn.view.base.auth.BaseAuthFragment
import br.com.fiap.sociallearn.viewmodel.CadastroViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private lateinit var etUserName: EditText
private lateinit var etEmail: EditText
private lateinit var etPassword: EditText
private lateinit var etGender: EditText

/**
 * A simple [Fragment] subclass.
 * Use the [CadastroFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CadastroFragment : BaseAuthFragment() {
    private val cadastroViewModel: CadastroViewModel by viewModels()

        override val layout: Int
            get() = R.layout.fragment_cadastro
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var btNext: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpView(view)

    }
    private fun setUpView(view: View) {
        btNext = view.findViewById(R.id.btNextToPerfil)
        etUserName = view.findViewById(R.id.etUserName)
        etEmail = view.findViewById(R.id.etEmail)
        etPassword = view.findViewById(R.id.etPassword)
        etGender = view.findViewById(R.id.etGenero)

        val bundle = bundleOf("name" to etUserName.text.toString(),
            "email" to etEmail.text.toString(),
            "pass" to etPassword.text.toString(),
            "genero" to etGender.text.toString() )

        btNext.setOnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_cadastroFragment_to_cadastroPerfilFragment,
                    bundle)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cadastro, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CadastroFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CadastroFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}