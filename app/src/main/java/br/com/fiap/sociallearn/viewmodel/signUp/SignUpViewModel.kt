package br.com.example.sociallearn.viewmodel.signUp

import androidx.lifecycle.ViewModel
import br.com.example.sociallearn.domain.exceptions.GenericException
import br.com.example.sociallearn.domain.useCases.signUp.MakeSignUpContract

class SignUpViewModel(
    private val contract: SignUpContract,
    private val makeSignUp: MakeSignUpContract
) : ViewModel() {

    var email: String = ""
    var password: String = ""

    fun onSignUpPressed() {
        makeSignUp.execute(email, password, {
            contract.goToMainActivity();
        }, { error ->
            when (error) {
                GenericException.GENERIC_ERROR -> contract.showGenericErrorMessage()
            }
        }
        )
    }

}