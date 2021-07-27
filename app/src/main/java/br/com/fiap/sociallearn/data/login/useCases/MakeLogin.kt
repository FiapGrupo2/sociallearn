package br.com.example.sociallearn.data.login.useCases

import br.com.example.sociallearn.domain.exceptions.GenericException
import br.com.example.sociallearn.domain.useCases.login.MakeLoginContract

class MakeLogin: MakeLoginContract {
    override fun execute(
        email: String,
        password: String,
        onSuccessListener: () -> Unit,
        OnFailureListener: (GenericException) -> Unit
    ) {
        return Unit
    }
}