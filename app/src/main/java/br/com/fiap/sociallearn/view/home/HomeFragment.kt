package br.com.fiap.sociallearn.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import br.com.example.sociallearn.R
import br.com.fiap.sociallearn.model.RequestState
import br.com.fiap.sociallearn.view.base.auth.BaseAuthFragment
import br.com.fiap.sociallearn.viewmodel.HomeViewModel

class HomeFragment : BaseAuthFragment() {
    private val homeViewModel: HomeViewModel by viewModels()

    override val layout: Int
        get() = R.layout.fragment_home

    private lateinit var btSignOut: AppCompatImageView


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpView(view)

        registerObserver()
    }

    private fun setUpView(view: View) {
        btSignOut = view.findViewById(R.id.btSignOut)

        btSignOut.setOnClickListener {
            homeViewModel.logout()
        }
    }

    private fun registerObserver() {
        this.homeViewModel.loggedState.observe(viewLifecycleOwner, Observer {
            when (it) {
                is RequestState.Success -> {
                    hideLoading()
                    NavHostFragment.findNavController(this)
                        .navigate(R.id.logInFragment)
                }
                is RequestState.Error -> {
                    hideLoading()
                    showMessage(it.throwable.message)
                }
                is RequestState.Loading -> showLoading("Calculando o melhor combustível")
            }
        })
    }
}
