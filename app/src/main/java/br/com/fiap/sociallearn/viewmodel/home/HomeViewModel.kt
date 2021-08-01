package br.com.fiap.sociallearn.viewmodel.home

import androidx.lifecycle.ViewModel
import br.com.fiap.sociallearn.domain.useCases.logout.MakeLogoutContract

class HomeViewModel(
    private val contract: HomeContract,
    private val makeLogout: MakeLogoutContract
) : ViewModel() {

    fun onSearchPressed() {

    }

    fun onLogoutPressed() {
        makeLogout.execute {
            contract.goToLoginActivity()
        }
    }

    fun goToJavaActivity() {
        contract.goToJavaActivity()
    }

    fun goToAngularActivity() {
        contract.goToAngularActivity()
    }

    fun goToNodeActivity() {
        contract.goToNodeActivity()
    }

    fun goToBootActivity() {
        contract.goToBootActivity()
    }

    fun goToFrontActivity() {
        contract.goToFrontActivity()
    }

    fun goToJSActivity() {
        contract.goToJSActivity()
    }

    fun goToJRActivity() {
        contract.goToJRActivity()
    }

    fun goToSalesActivity() {
        contract.goToSalesActivity()
    }

    fun goToSecurityActivity() {
        contract.goToSecurityActivity()
    }

    fun goToSQActivity() {
        contract.goToSQLActivity()
    }

    fun goToPSQLActivity() {
        contract.goToPSQLActivity()
    }

    fun goToCActivity() {
        contract.goToCActivity()
    }
}