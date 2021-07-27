package br.com.example.sociallearn.viewmodel.login

import androidx.lifecycle.ViewModel
import br.com.example.sociallearn.domain.exceptions.GenericException
import br.com.example.sociallearn.domain.useCases.login.CheckUserIsLoggedContract
import br.com.example.sociallearn.domain.useCases.login.MakeLoginContract

class LoginViewModel(
    private val contract: LoginContract,
    private val checkUserIsLogged: CheckUserIsLoggedContract,
    private val makeLogin: MakeLoginContract
        ): ViewModel() {

    var email: String = ""
    var password: String = ""

    fun onCreate() {
        if (checkUserIsLogged.execute()) {
            contract.goToMainActivity();
        }
    }

    fun onLoginPressed() {
        makeLogin.execute(email, password, {
            contract.goToMainActivity();
        }, { error ->
            when (error) {
                GenericException.GENERIC_ERROR -> contract.showGenericErrorMessage()
            }
        }
        )
    }
}