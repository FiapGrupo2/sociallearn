package br.com.fiap.sociallearn.viewmodel.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fiap.sociallearn.R
import br.com.fiap.sociallearn.domain.exceptions.GenericException
import br.com.fiap.sociallearn.domain.useCases.login.MakeResetPasswordContract

class ResetPasswordViewModel(
    private val contract: ResetPasswordContract,
    private val makeResetPassword: MakeResetPasswordContract
) : ViewModel() {

    var email = MutableLiveData<String>()

    fun onSendNewPasswordPressed() {
        makeResetPassword.execute(email.value!!, {
            contract.showMessage(R.string.MSG_SUCCESS)
            contract.goToLoginActivity()
        }, { error ->
            when (error) {
                GenericException.GENERIC_ERROR -> contract.showMessage(R.string.ERROR_GENERIC)
            }
        }
        )
    }
}