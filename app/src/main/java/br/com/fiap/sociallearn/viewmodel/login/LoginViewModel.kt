package br.com.fiap.sociallearn.viewmodel.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fiap.sociallearn.domain.exceptions.GenericException
import br.com.fiap.sociallearn.domain.useCases.login.CheckUserIsLoggedContract
import br.com.fiap.sociallearn.domain.useCases.login.MakeLoginContract

class LoginViewModel(
    private val contract: LoginContract,
    private val checkUserIsLogged: CheckUserIsLoggedContract,
    private val makeLogin: MakeLoginContract,
) : ViewModel() {

    var email = MutableLiveData<String>()
    var password = MutableLiveData<String>()

    fun onCreate() {
        if (checkUserIsLogged.execute()) {
            contract.goToMainActivity();
        }
    }

    fun onLoginPressed() {
        makeLogin.execute(email.value!!, password.value!!, {
            contract.goToMainActivity()
        }, { error ->
            when (error) {
                GenericException.GENERIC_ERROR -> contract.showGenericErrorMessage()
            }
        }
        )
    }

    fun onResetPasswordPressed() {
        contract.goToResetPasswordActivity()
    }

    fun onSignUpPressed() {
        contract.goToSignUpActivity()
    }
}