package br.com.fiap.sociallearn.viewmodel.login

import android.provider.Settings.Global.getString
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fiap.sociallearn.R
import br.com.fiap.sociallearn.domain.exceptions.GenericException
import br.com.fiap.sociallearn.domain.useCases.login.CheckUserIsLoggedContract
import br.com.fiap.sociallearn.domain.useCases.login.MakeLoginContract

class LoginViewModel(
    private val contract: LoginContract,
    private val checkUserIsLogged: CheckUserIsLoggedContract,
    private val makeLogin: MakeLoginContract
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
            contract.showMessage(R.string.MSG_SUCCESS)
            contract.goToMainActivity()
        }, { error ->
            when (error) {
                GenericException.ERROR_INVALID_EMAIL -> contract.showMessage(R.string.ERROR_INVALID_EMAIL)
                GenericException.ERROR_WRONG_PASSWORD -> contract.showMessage(R.string.ERROR_WRONG_PASSWORD)
                GenericException.ERROR_USER_MISMATCH -> contract.showMessage(R.string.ERROR_USER_MISMATCH)
                GenericException.ERROR_EMAIL_ALREADY_IN_USE -> contract.showMessage(R.string.ERROR_EMAIL_ALREADY_IN_USE)
                GenericException.ERROR_USER_DISABLED -> contract.showMessage(R.string.ERROR_USER_DISABLED)
                GenericException.ERROR_OPERATION_NOT_ALLOWED -> contract.showMessage(R.string.ERROR_OPERATION_NOT_ALLOWED)
                GenericException.GENERIC_ERROR -> contract.showMessage(R.string.ERROR_GENERIC)
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