package br.com.fiap.sociallearn.data.signUp.useCases

import br.com.fiap.sociallearn.domain.exceptions.GenericException
import br.com.fiap.sociallearn.domain.useCases.signUp.MakeSignUpContract

class MakeSignUp : MakeSignUpContract {
    override fun execute(
        email: String,
        password: String,
        onSuccessListener: () -> Unit,
        OnFailureListener: (GenericException) -> Unit
    ) {
        TODO("Not yet implemented")
    }

}