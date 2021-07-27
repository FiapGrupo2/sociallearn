package br.com.fiap.sociallearn.domain.useCases.login

import br.com.example.sociallearn.domain.exceptions.GenericException

interface ResetPasswordContract {
    fun execute(
        email: String,
        onSuccessListener: () -> Unit,
        OnFailureListener: (GenericException) -> Unit
    )
}