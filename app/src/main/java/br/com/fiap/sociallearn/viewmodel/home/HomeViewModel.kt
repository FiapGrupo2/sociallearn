package br.com.fiap.sociallearn.viewmodel.home

import androidx.lifecycle.ViewModel
import br.com.fiap.sociallearn.domain.useCases.logout.MakeLogoutContract
import br.com.fiap.sociallearn.viewmodel.search.content.SearchContentContract

class HomeViewModel(
    private val contract: HomeContract,
    private val searchContent: SearchContentContract,
    private val makeLogout: MakeLogoutContract
) : ViewModel() {

    fun onLogoutPressed() {
        makeLogout.execute {
            contract.goToLoginActivity()
        }
    }
}