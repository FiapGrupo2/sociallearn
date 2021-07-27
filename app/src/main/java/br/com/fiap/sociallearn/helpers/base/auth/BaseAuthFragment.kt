//package br.com.fiap.sociallearn.helpers.base.auth
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.core.os.bundleOf
//import androidx.fragment.app.viewModels
//import androidx.lifecycle.Observer
//import androidx.navigation.fragment.findNavController
//import br.com.example.sociallearn.R
//import br.com.fiap.sociallearn.model.RequestState
//import br.com.fiap.sociallearn.helpers.base.BaseFragment
//import br.com.fiap.sociallearn.viewmodel.BaseAuthViewModel
//
//const val NAVIGATION_KEY = "NAV_KEY"
//
//abstract class BaseAuthFragment : BaseFragment() {
//
//    private val baseAuthViewModel: BaseAuthViewModel by viewModels()
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        registerObserver()
//        baseAuthViewModel.isLoggedIn()
//        return super.onCreateView(inflater, container, savedInstanceState)
//    }
//
//    private fun registerObserver() {
//        baseAuthViewModel.loggedState.observe(viewLifecycleOwner, Observer {
//            when (it) {
//                is RequestState.Loading -> showLoading()
//                is RequestState.Success -> {
//                    hideLoading()
//                }
//                is RequestState.Error -> {
//                    hideLoading()
//
//                    findNavController().navigate(
//                        R.id.login_nav, bundleOf(
//                            NAVIGATION_KEY to findNavController().currentDestination?.id
//                        )
//                    )
//                }
//            }
//        })
//    }
//}