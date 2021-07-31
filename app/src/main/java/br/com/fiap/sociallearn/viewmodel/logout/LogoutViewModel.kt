package br.com.fiap.sociallearn.viewmodel.logout

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fiap.sociallearn.domain.exceptions.GenericException
import br.com.fiap.sociallearn.domain.useCases.login.CheckUserIsLoggedContract
import br.com.fiap.sociallearn.domain.useCases.login.MakeLoginContract
import br.com.fiap.sociallearn.domain.useCases.logout.MakeLogoutContract
import br.com.fiap.sociallearn.viewmodel.login.LoginContract

class LogoutViewModel(
    private val contract: LogoutContract,
    private val makeLogout: MakeLogoutContract,
) : ViewModel() {

    var email = MutableLiveData<String>()
    var password = MutableLiveData<String>()

    fun onCreate() {

    }

    fun goToLogout() {
        makeLogout.execute({
            contract.goToLogin()
        })
    }
}