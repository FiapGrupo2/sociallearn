package br.com.fiap.sociallearn.domain.useCases.login

import br.com.fiap.sociallearn.domain.exceptions.GenericException

interface MakeResetPasswordContract {
    fun execute(
        email: String,
        onSuccessListener: () -> Unit,
        onFailureListener: (GenericException) -> Unit
    )
}