package br.com.fiap.sociallearn.viewmodel.signUp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fiap.sociallearn.R
import br.com.fiap.sociallearn.data.model.UserModel
import br.com.fiap.sociallearn.domain.entities.UserEntityRequest
import br.com.fiap.sociallearn.domain.exceptions.GenericException
import br.com.fiap.sociallearn.domain.useCases.signUp.MakeSignUpContract
import java.util.*
import java.util.regex.Pattern

class SignUpViewModel(
    private val contract: SignUpContract,
    private val makeSignUp: MakeSignUpContract
) : ViewModel() {

    var name = MutableLiveData<String>()
    var email = MutableLiveData<String>()
    var password = MutableLiveData<String>()
    var confirmPassword = MutableLiveData<String>()
    var mensagem : Int = 0

    val EMAIL_ADDRESS_PATTERN = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )

    fun onNextPressed() {
        if (name?.value != null && email?.value != null && password?.value != null && confirmPassword?.value != null) {
            if (isValidCampos(email.value.toString(),
                    password.value.toString(), confirmPassword.value.toString())) {
                val userEntityRequest = UserEntityRequest(
                    name = name.value!!,
                    email = email.value!!,
                    password = password.value!!,
                    confirmPassword = confirmPassword.value!!,
                    Collections.emptyList(),
                    Collections.emptyList(),
                    active = true
                )

                makeSignUp.execute(userEntityRequest, {
                    contract.goToKnowledgeToLearnActivity()
                }, { error ->
                    when (error) {
                        GenericException.GENERIC_ERROR -> contract.showMessage(R.string.ERROR_GENERIC)
                    }
                })
            } else {
                contract.showMessage(mensagem)
            }
        }else {
            contract.showMessage(R.string.ERROR_NULL_SIGN)
        }
    }

    fun isValidCampos(email: String, password: String, confirmPassword: String): Boolean{
        if (password != confirmPassword) {
            mensagem = R.string.ERROR_DIF_PASS;
            return false;
        }
        if (!EMAIL_ADDRESS_PATTERN.matcher(email).matches()) {
            mensagem = R.string.ERROR_EMAIL_INVALIDO;
            return false
        }
        return true
    }
}