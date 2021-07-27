package br.com.example.sociallearn.data.signUp

import br.com.example.sociallearn.domain.exceptions.GenericException
import br.com.example.sociallearn.domain.useCases.signUp.MakeSignUpContract

class MakeSignUp: MakeSignUpContract {
    override fun execute(
        email: String,
        password: String,
        onSuccessListener: () -> Unit,
        OnFailureListener: (GenericException) -> Unit
    ) {
        TODO("Not yet implemented")
    }

}