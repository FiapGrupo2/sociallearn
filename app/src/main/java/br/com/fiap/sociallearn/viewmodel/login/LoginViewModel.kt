package br.com.example.sociallearn.viewmodel.login

import androidx.lifecycle.ViewModel
import br.com.example.sociallearn.domain.exceptions.GenericException
import br.com.example.sociallearn.domain.useCases.login.CheckUserIsLoggedContract
import br.com.example.sociallearn.domain.useCases.login.MakeLoginContract
import br.com.fiap.sociallearn.domain.useCases.login.ResetPasswordContract

class LoginViewModel(
    private val contract: LoginContract,
    private val checkUserIsLogged: CheckUserIsLoggedContract,
    private val makeLogin: MakeLoginContract,
    private val resetPassword: ResetPasswordContract
) : ViewModel() {

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

    fun onResetPasswordPressed() {
        resetPassword.execute(email, {
            contract.goToMainActivity();
        }, { error ->
            when (error) {
                GenericException.GENERIC_ERROR -> contract.showGenericErrorMessage()
            }
        }
        )
    }
}