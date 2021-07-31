package br.com.fiap.sociallearn.viewmodel.signUp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fiap.sociallearn.R
import br.com.fiap.sociallearn.data.model.UserModel
import br.com.fiap.sociallearn.domain.exceptions.GenericException
import br.com.fiap.sociallearn.domain.useCases.signUp.MakeSignUpContract
import java.util.*

class SignUpViewModel(
    private val contract: SignUpContract,
    private val makeSignUp: MakeSignUpContract
) : ViewModel() {

    var name = MutableLiveData<String>()
    var email = MutableLiveData<String>()
    var password = MutableLiveData<String>()
    var confirmPassword = MutableLiveData<String>()

    fun onNextPressed() {
        var userModel = UserModel(
            name = name.value!!,
            email = email.value!!,
            password = password.value!!,
            Collections.emptyList(),
            Collections.emptyList(),
            active = true
        )

        makeSignUp.execute(userModel, {
            contract.goToKnowledgeToLearnActivity()
        }, { error ->
            when (error) {
                GenericException.GENERIC_ERROR -> contract.showMessage(R.string.ERROR_GENERIC)
            }
        })
    }

}