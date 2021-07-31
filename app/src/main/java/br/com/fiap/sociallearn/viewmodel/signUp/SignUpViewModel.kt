package br.com.fiap.sociallearn.viewmodel.signUp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fiap.sociallearn.R
import br.com.fiap.sociallearn.domain.entities.UserEntity
import br.com.fiap.sociallearn.domain.exceptions.GenericException
import br.com.fiap.sociallearn.domain.useCases.signUp.MakeSignUpContract

class SignUpViewModel(
    private val contract: SignUpContract,
    private val makeSignUp: MakeSignUpContract
) : ViewModel() {

    var name = MutableLiveData<String>()
    var email = MutableLiveData<String>()
    var password = MutableLiveData<String>()
    var confirmPassword = MutableLiveData<String>()

    fun onNextPressed() {
        if (email?.value != null && password?.value != null && password.value != null && confirmPassword.value != null) {
            var userEntity = UserEntity(
                name = name.value!!,
                email = email.value!!,
                password = password.value!!,
                active = true
            )

            makeSignUp.execute(userEntity, {
                contract.goToKnowledgeToLearnActivity()
            }, { error ->
                when (error) {
                    GenericException.GENERIC_ERROR -> contract.showMessage(R.string.ERROR_GENERIC)
                }
            })
        } else {
            contract.showMessage(R.string.MSG_NULL_SIGN)
        }
    }

}